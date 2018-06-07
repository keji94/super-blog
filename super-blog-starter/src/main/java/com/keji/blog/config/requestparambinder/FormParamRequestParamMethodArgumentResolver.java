package com.keji.blog.config.requestparambinder;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import com.keji.blog.annotion.ParamName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

/**
 * Copyright (c) 2018 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * Method processor supports {@link ParamName} parameters renaming
 *
 * @author qinjiao
 * @since 2018/6/1
 */
public class FormParamRequestParamMethodArgumentResolver extends ServletModelAttributeMethodProcessor {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    /**
     * Rename cache
     */
    private final Map<Class<?>, Map<String, String>> replaceMap = new ConcurrentHashMap<Class<?>, Map<String, String>>();


    public FormParamRequestParamMethodArgumentResolver(boolean annotationNotRequired) {
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
