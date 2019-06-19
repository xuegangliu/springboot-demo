package com.lxg.wechat.constant;

import org.springframework.beans.factory.annotation.Value;

/**
 * MessageConstant
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/18
 * @since 1.8
 **/
public final class MessageConstant {

    public final static String OK="ok";

    @Value("${test_temp_id}")
    public static String TEST_TMEP_ID;

    @Value("${test_temp_url}")
    public static String TEST_TEMP_URL;

    @Value("${test_temp_send_openid}")
    public static String TEST_TEMP_SEND_OPENID;
}
