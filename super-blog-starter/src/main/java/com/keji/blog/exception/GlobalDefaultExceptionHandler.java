package com.keji.blog.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * springboot 全局异常处理类 这种方式有个局限，无法根据不同的头部返回不同的数据格式，而且无法针对404、403等多种状态进行处理
 *
 * @author keji
 * @version $Id: GlobalDefaultExceptionHandler.java, v 0.1 2018/7/6 上午10:31 keji Exp $
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)  {
          ModelAndView mav = new ModelAndView();
          mav.addObject("exception", e);
          mav.addObject("url", req.getRequestURL());
          mav.setViewName("404");
          //TODO 发送邮件
          logger.error("exception occured...url:"+req.getRequestURI(),e);
          return mav;
    }
}
