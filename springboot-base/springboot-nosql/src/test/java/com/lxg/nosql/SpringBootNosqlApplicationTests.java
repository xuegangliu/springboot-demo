package com.lxg.nosql;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootNosqlApplicationTests {

	@Autowired
	private CacheManager cacheManager;

	@Test
	public void testRedis(){
//		cacheManager.getCache("my-redis-cache1").clear();
//		Map t = new HashMap<String,Object>();
//		t.put("aaaaaaaaaaaa",111111111111l);
//		t.put("xxxxxxxxxxxxxx","ccccccccccccccc");
//		cacheManager.getCache("my-redis-cache1").put("test1",JSONObject.toJSON(t));
		System.out.println(JSONObject.toJSON(cacheManager.getCache("my-redis-cache1")));
	}


}
