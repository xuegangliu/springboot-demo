package com.lxg.wechat;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * WeChatPublicTest
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/19
 * @since 1.8
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WeChatPublicTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setupMockMvc() {
     mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test() throws Exception {
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/", "");
//        MvcResult result = mvc.perform(builder).andReturn();
//        log.error(result.toString());
//        System.out.println(result.toString());
    }
}
