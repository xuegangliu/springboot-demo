package com.lxg.spring.alibaba.sentinel;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * SentinelApplication
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/23
 * @since 1.8
 **/
@SpringBootApplication
public class SentinelApplication {

    private static void initRules() throws Exception {
        FlowRule rule1 = new FlowRule();
        rule1.setResource("PayService.call");
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 每秒调用最大次数为 5 次
        rule1.setCount(5);

        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule1);

        // 将控制规则载入到 Sentinel
        com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager.loadRules(rules);
    }

    public static void main(String[] args) throws Exception {
        // Sentinel 载入规则
        initRules();
        SpringApplication.run(SentinelApplication.class, args);
    }

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

}
