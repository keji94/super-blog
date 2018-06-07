package com.keji.blog.config.requestparambinder;

import java.util.Map;

import com.keji.blog.annotion.ParamName;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;

/**
 * 普通方法签名上参数别名绑定
 *
 * @author keji
 * @version $Id: MyRequestParamMethodArgumentResolver.java, v 0.1 2018/6/7 上午10:49 keji Exp $
 */
public class MyRequestParamMethodArgumentResolver extends RequestParamMethodArgumentResolver {

    public MyRequestParamMethodArgumentResolver(boolean useDefaultResolution) {
        super(useDefaultResolution);
    }

    /**
     * 自定义参数绑定
     *
     * @param name      参数名称
     * @param parameter 参数上下文信息
     * @param request   request
     * @return 参数值
     */
    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {

        ParamName paramName = parameter.getParameterAnnotation(ParamName.class);

        //参数名 忽略大小写
        String customerParamName;

        //非注解
        if(paramName == null){
            customerParamName = name.toLowerCase();
        }else{
            //注解
            customerParamName = paramName.value().toLowerCase();
        }

        //所有参数键值对
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {

            if (entry.getKey().toLowerCase().equals(customerParamName)) {
                return entry.getValue();
            }
        }

        return null;
    }
}
