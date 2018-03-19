package com.keji.blog.controller.admin;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.keji.blog.util.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author keji
 * @version $Id: IndexController.java, v 0.1 2018/3/17 下午1:03 keji Exp $
 */
@Controller
public class AdminIndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Producer producer;

    @RequestMapping("/admin/{page}")
    public String amdinIndex(@PathVariable String page) {
        return "/admin/" + page;
    }

    @RequestMapping("/admin/modules/sys/{page}")
    public String amdinPage(@PathVariable String page) {
        return "/admin/modules/sys/" + page;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/{page}")
    public String index(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/modules/{index}/{page}")
    public String menuIndex(@PathVariable String index, @PathVariable String page) {
        return "/modules/" + index + "/" + page;
    }

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response) {
        try {
            response.setHeader("Cache-Control", "no-store, no-cache");
            response.setContentType("image/jpeg");

            //生成文字验证码
            String text = producer.createText();
            //生成图片验证码
            BufferedImage image = producer.createImage(text);
            //保存到shiro session
            ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            logger.error("验证码写出失败!", e);
        } catch (Exception e) {
            logger.error("系统错误!", e);
        }

    }
}
