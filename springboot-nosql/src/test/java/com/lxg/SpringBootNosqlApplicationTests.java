package com.lxg;

import com.lxg.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootNosqlApplication.class)
public class SpringBootNosqlApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

		// 保存对象
		User user = new User("aa", 20);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("bb", 30);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("cc", 40);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("aa").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("bb").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("cc").getAge().longValue());

	}

}
