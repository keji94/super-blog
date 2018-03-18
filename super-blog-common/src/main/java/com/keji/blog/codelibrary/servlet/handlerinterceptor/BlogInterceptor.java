package com.keji.blog.codelibrary.servlet.handlerinterceptor;

import com.keji.blog.constants.BlogConstants;
import com.keji.blog.enums.ViewTipEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * spring的拦截器和Filter类似，不过比Filter更加精细，比如在request被响应之前、request被响应之后、视图渲染之前以及request全部结束之后
 *                 在拦截器和Filter同时存在的情况下，先走Filter，再走拦截器
 * @author keji
 * @version $Id: BlogInterceptor.java, v 0.1 2018/3/18 下午2:57 keji Exp $
 */
public class BlogInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession(true);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if(session.getAttribute(BlogConstants.USER_NAME_STRING) == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }else{
            session.setAttribute(BlogConstants.USER_ID_STRING, session.getAttribute(BlogConstants.USER_ID_STRING));
            // 只有返回true才会继续向下执行，返回false取消当前请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
