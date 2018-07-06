package com.keji.blog.assept.methodlog;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import com.keji.blog.annotion.MethodLog;
import com.keji.blog.enums.LogLevelEnum;
import com.keji.blog.enums.LogOccurredTypeEnum;
import com.keji.blog.enums.LogOutputTypeEnum;
import com.keji.blog.util.JsonUtil;
import com.keji.blog.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * methodlog 切面 复制代码待打磨，待优化，待测试
 *
 * @author keji
 * @version $Id: MethodLogAspect.java, v 0.1 2018/7/6 上午10:46 keji Exp $
 */

@Aspect
public class MethodLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodLogAspect.class);

    /**
     * 无须日志记录的参数类型
     */
    private final static List<String> CLASS_NAME_WRITE_LIST = new ArrayList<>();

    /**
     * 短日期格式
     */
    private final static int SHORT_DATE_FORMAT = 10;

    public MethodLogAspect() {
        CLASS_NAME_WRITE_LIST.add("HttpServletRequest");
        CLASS_NAME_WRITE_LIST.add("HttpServletResponse");
        CLASS_NAME_WRITE_LIST.add("MultipartHttpServletRequest");
    }

    /**
     * around拦截
     *
     * @param proceedingJoinPoint 上下文信息
     * @param methodLog           日志注解
     * @return result
     */
    @Around("@annotation(methodLog)")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, MethodLog methodLog) {

        //日志记录的出入参类型 ALL所有日志 IN入参日志 OUT出参日志
        LogOutputTypeEnum outputTypeEnum = methodLog.type();
        //日志记录发生的时机  ANYTIME任何时候 EXCEPTION异常发生时
        LogOccurredTypeEnum occurredType = methodLog.occurrType();
        //日志级别
        LogLevelEnum logLevel = methodLog.level();

        //格式化时间
        DateTime expireDateTime = formatTime(methodLog.expireTime());

        //检查是否输出日志
        if (!expireDateTime.isAfterNow()) {

            return execute(proceedingJoinPoint);
        }

        //get method
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();

        StringBuilder message = new StringBuilder();

        //判断是否需要记录日志
        Boolean isLog;
        Object result;
        try {
            result = execute(proceedingJoinPoint);

            //未发生异常，则判断type是否anytime
            isLog = LogOccurredTypeEnum.NORMAL.equals(occurredType);
        } catch (Exception ex) {

            //发生异常时只记录入参
            message.append(buildHeaderLog(method));
            message.append(buildInLog(method, proceedingJoinPoint.getArgs(), outputTypeEnum));
            LogUtil.info(LOGGER,message.toString());

            throw new RuntimeException(ex);
        }

        if (isLog) {
            //拼接头日志
            message.append(buildHeaderLog(method));
            //拼接入参
            message.append(buildInLog(method, proceedingJoinPoint.getArgs(), outputTypeEnum));
            //拼接出参
            message.append(buildOutLog(result, outputTypeEnum));
            //日志记录
            LogUtil.info(LOGGER,message.toString());
        }

        return result;

    }

    /**
     * 判断是否基本类型
     *
     * @param tClass class
     * @return true or false
     */
    private boolean isPrimitive(Class tClass) {

        return tClass.equals(Integer.class)
               || tClass.equals(Byte.class)
               || tClass.equals(Short.class)
               || tClass.equals(Long.class)
               || tClass.equals(Float.class)
               || tClass.equals(Double.class)
               || tClass.equals(Boolean.class)
               || tClass.equals(String.class)
               || tClass.equals(char.class);

    }

    /**
     * 格式化时间
     *
     * @param expireTime 字符串时间
     * @return joda datetime
     */
    private DateTime formatTime(String expireTime) {
        DateTime expireDateTime = null;

        if (expireTime != null && expireTime.length() > 0) {

            //格式化expireTime
            DateTimeFormatter format;
            try {
                if (expireTime.length() == SHORT_DATE_FORMAT) {
                    format = DateTimeFormat.forPattern("yyyy-MM-dd");
                } else {
                    format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
                }

                expireDateTime = DateTime.parse(expireTime, format);
            } catch (Exception ex) {
                throw new RuntimeException("methodLog expireTime invalid", ex);
            }
        }

        return expireDateTime;
    }

    /**
     * 拼接日志头
     *
     * @param method method对象
     * @return 头日志
     */
    private String buildHeaderLog(Method method) {

        return String.format("%s.%s  ", method.getDeclaringClass().getName(), method.getName());
    }

    /**
     * 组装入参
     *
     * @param method    method
     * @param args      args
     * @param paramType paramType
     * @return 入参日志
     */
    private StringBuilder buildInLog(Method method, Object[] args, LogOutputTypeEnum paramType) {

        StringBuilder message = new StringBuilder();
        if (LogOutputTypeEnum.OUT.equals(paramType)) {
            return message;
        }

        Parameter[] parameters = method.getParameters();

        if (args != null && args.length > 0) {
            message.append("args: \n");

            for (int i = 0; i < args.length; i++) {

                Parameter parameter = parameters[i];
                Object arg = args[i];
                if (arg == null) {
                    message.append(String.format("%s:", parameter.getName()));
                    continue;
                }

                Class<?> classType = arg.getClass();

                String[] nameArr = classType.getName().split("\\.");
                String className = nameArr[nameArr.length - 1];

                if (CLASS_NAME_WRITE_LIST.contains(className)) {
                    continue;
                }

                //一行一个参数
                message.append(String.format("%s:", parameter.getName()));
                message.append(isPrimitive(classType) ? String.valueOf(arg) : JsonUtil.object2Json(arg));
                message.append("\n");

            }
        }

        return message;
    }

    /**
     * 组装出参
     *
     * @param result    result
     * @param paramType paramType
     * @return 出参日志
     */
    private StringBuilder buildOutLog(Object result, LogOutputTypeEnum paramType) {

        StringBuilder message = new StringBuilder();
        if (result == null) {
            return message;
        }

        if (LogOutputTypeEnum.IN.equals(paramType)) {
            return message;
        }

        //拼接出参
        Class<?> resultClassType = result.getClass();
        message.append("result: \n");
        message.append(isPrimitive(resultClassType) ? String.valueOf(result) : JsonUtil.object2Json(result));

        return message;
    }

    /**
     * 执行方法
     *
     * @param proceedingJoinPoint 上下文对象
     * @return 返回值
     */
    private Object execute(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        try {
            //执行方法
            result = proceedingJoinPoint.proceed();

        } catch (Throwable throwable) {

            throw new RuntimeException(throwable);
        }

        return result;
    }
}
