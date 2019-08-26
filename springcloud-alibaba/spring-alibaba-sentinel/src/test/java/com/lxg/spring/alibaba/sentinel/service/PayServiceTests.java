package com.lxg.spring.alibaba.sentinel.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * PayServiceTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/23
 * @since 1.8
 **/
public class PayServiceTests {

    @Autowired
    private PayService payService;

    @Test
    public void testSentinel(){
        for (int i = 0; i < 10; i++) {
            payService.call();
        }
    }
}
