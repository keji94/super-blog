package com.keji.blog.resolver;

import com.keji.blog.annotion.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author qinjiao
 * @version $Id: CurrentUserMethodArgumentResolver.java, v 0.1 2018-04-16 下午6:52 qinjiao Exp $$
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return null != methodParameter.getParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        String annoVal = null;
        if (methodParameter.getParameterAnnotation(CurrentUser.class) != null) {
            annoVal = methodParameter.getParameterAnnotation(CurrentUser.class).value();
        } else if (methodParameter.getMethodAnnotation(CurrentUser.class) == null) {
            return null;
        }
        if (nativeWebRequest.getAttribute(annoVal, RequestAttributes.SCOPE_SESSION) != null) {
            return nativeWebRequest.getAttribute(annoVal, RequestAttributes.SCOPE_SESSION);
        } else {
            return null;
        }
    }
}
