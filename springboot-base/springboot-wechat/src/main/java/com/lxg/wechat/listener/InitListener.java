package com.lxg.wechat.listener;

import com.lxg.wechat.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.sword.wechat4j.token.server.AccessTokenMemServer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * InitListener
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/19
 * @since 1.8
 **/
@WebListener
@Slf4j
public class InitListener implements ServletContextListener {

    @Value("${custom_muen_url}")
    public String customMenuUrl;

    @Value("${test_muen}")
    public String testMenu;

    @Override
    public void contextInitialized(ServletContextEvent sce){
        log.error("================{}","contextInitialized");
        String accessToken = AccessTokenMemServer.instance().token();
        String url = customMenuUrl + accessToken;
        try {
            CommonUtils.sendPost(url, testMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
