package com.keji.blog.config.requestparambinder;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.keji.blog.annotion.ParamName;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

/**
 *
 * Method processor supports {@link ParamName} parameters renaming
 * 对象参数别名绑定
 *
 * @author keji
 * @version $Id: FieldParamProcessor.java, v 0.1 2018/6/7 上午10:49 keji Exp $
 */
public class FieldParamProcessor extends ServletModelAttributeMethodProcessor {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    /**
     * Rename cache
     */
    private final Map<Class<?>, Map<String, String>> replaceMap = new ConcurrentHashMap<>();


    public FieldParamProcessor(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest nativeWebRequest) {
        Object target = binder.getTarget();
        Class<?> targetClass = target.getClass();
        if (!replaceMap.containsKey(targetClass)) {
            Map<String, String> mapping = analyzeClass(targetClass, nativeWebRequest);
            replaceMap.put(targetClass, mapping);
        }

        Map<String, String> mapping = replaceMap.get(targetClass);
        ParamNameDataBinder paramNameDataBinder = new ParamNameDataBinder(target, binder.getObjectName(), mapping);
        requestMappingHandlerAdapter.getWebBindingInitializer().initBinder(paramNameDataBinder, nativeWebRequest);
        super.bindRequestParameters(paramNameDataBinder, nativeWebRequest);
    }

    private static Map<String, String> analyzeClass(Class<?> targetClass, NativeWebRequest nativeWebRequest) {

        HttpServletRequest request =
                nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        Map<String, String[]> parameterMap = request.getParameterMap();

        Field[] fields = targetClass.getDeclaredFields();
        Map<String, String> renameMap = new HashMap<>(8);
        for (Field field : fields) {
            ParamName paramNameAnnotation = field.getAnnotation(ParamName.class);
            if (paramNameAnnotation != null && !paramNameAnnotation.value().isEmpty()) {

                String paramName = paramNameAnnotation.value();
                for(Map.Entry<String, String[]> entry : parameterMap.entrySet()){

                    if(entry.getKey().toLowerCase().equals(paramName.toLowerCase())){
                        paramName = entry.getKey();
                        break;
                    }
                }

                renameMap.put(paramName, field.getName());
            }
        }
        if (renameMap.isEmpty()){
            return Collections.emptyMap();
        }
        return renameMap;
    }
}

/**
 * ServletRequestDataBinder which supports fields renaming using {@link com.keji.blog.annotion.ParamName}
 *
 * @author keji
 * @version $Id: ParamNameDataBinder.java, v 0.1 2018/6/1 上午10:09 keji Exp $
 */
class ParamNameDataBinder extends ExtendedServletRequestDataBinder {

    private final Map<String, String> renameMapping;

    ParamNameDataBinder(Object target, String objectName, Map<String, String> renameMapping) {
        super(target, objectName);
        this.renameMapping = renameMapping;
    }

    @Override
    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);
        for (Map.Entry<String, String> entry : renameMapping.entrySet()) {
            String from = entry.getKey();
            String to = entry.getValue();
            if (mpvs.contains(from)) {
                mpvs.add(to, mpvs.getPropertyValue(from).getValue());
            }
        }
    }
}
