package com.lxg.wechat.servlet;

import com.lxg.wechat.support.MyWechat;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * WechatMainServlet
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/18
 * @since 1.8
 **/
@Log4j
@WebServlet(urlPatterns="/wx")
public class WechatMainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public WechatMainServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        MyWechat myWebChat = new MyWechat(request);
        String result = myWebChat.execute();
        try {
            response.getOutputStream().write(null==result?"".getBytes("UTF-8"):result.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
