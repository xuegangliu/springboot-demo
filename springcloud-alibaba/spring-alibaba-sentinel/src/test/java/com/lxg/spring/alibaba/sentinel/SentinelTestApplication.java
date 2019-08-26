package com.lxg.spring.alibaba.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.lxg.spring.alibaba.sentinel.service.PayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class SentinelTestApplication {
    @Autowired
    private PayService payService;

    @Before
    public void setUp(){
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

    @Test
    public void testSentinel(){
        for (int i = 0; i < 10; i++) {
            payService.call();
        }
    }

    static int executedNumber = 0;

    @Test
    public void test01()
    {
        String resourceName = "test01";
        initFlowRules(resourceName);    //上面定义的规则
        for (int i = 0; i < 10; i++)
        {
            Entry entry = null;
            try
            {
                entry = SphU.entry(resourceName);
                //我的代码块
                doSomething();
            }
            catch (BlockException e1)
            {
                e1.printStackTrace();   //直接将异常打出来
            }
            finally
            {
                if (entry != null)
                {
                    entry.exit();
                }
            }
        }
    }

    public static void doSomething()
    {
        executedNumber++;
        System.out.println("-------CurrentExecutedNumber-------" + executedNumber);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    static void initFlowRules(String resource)
    {
        List rules = new ArrayList();
        FlowRule rule = new FlowRule();
        rule.setResource(resource); //资源名
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); //限流阈值类型，此处为qps类型
        rule.setCount(5);   //限流阈值，表示每秒钟通过5次请求
        rules.add(rule);    //将定义好的rule放在List中
        FlowRuleManager.loadRules(rules);
    }
}
