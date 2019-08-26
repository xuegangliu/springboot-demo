package com.lxg.spring.alibaba.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * PayService
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/23
 * @since 1.8
 **/
@Service
public class PayService {
    private int counter;

    @SentinelResource(value = "PayService.call", blockHandler = "callBlocked")
    public void call() {
        System.out.println("Hello (" + ++counter + ")");
    }

    public void callBlocked(BlockException ex) {
        System.err.println("Blocked (" + ++counter + ") : " + ex.toString());
    }
}
