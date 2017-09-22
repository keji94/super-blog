package com.keji.blog.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wb-ny291824
 * @Description  springboot 全局异常处理类 这种方式有个局限，无法根据不同的头部返回不同的数据格式，而且无法针对404、403等多种状态进行处理
 * @Date: Created in 2017/9/19
 * @Modified: By:
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)  {
          ModelAndView mav = new ModelAndView();
          mav.addObject("exception", e);
          mav.addObject("url", req.getRequestURL());
          mav.setViewName("admin/404");
          //TODO 发送邮件
          logger.error("exception occured...url:"+req.getRequestURI(),e);
          return mav;
    }
}
