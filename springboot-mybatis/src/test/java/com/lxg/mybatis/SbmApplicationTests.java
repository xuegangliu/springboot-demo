package com.lxg.mybatis;

import com.lxg.mybatis.domain.primary.User;
import com.lxg.mybatis.mapper.primary.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbmApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testAddUser() throws Exception{
		// 查询所有用户
		List<User> list = userMapper.findAll();
		System.out.println(list.size());

		// 添加用户
		Map<String,Object> map = new HashMap<>();
		User u = new User();
		User u1 = new User();
		User u2 = new User();
		u.setName("u");
		u.setAge(1111);
		u1.setName("u1");
		u1.setAge(1);
		u2.setName("u2");
		u2.setAge(2);
		map.put("name","mapName");
		map.put("age",122);
		userMapper.insertByUser(u); // 按User 对象插入
		int i = userMapper.insertByMap(map);
	}

	@Test
	public void testSQL(){
		List<User> list = userMapper.getUsersByNameToBuilder("u",null);
		System.out.println(list.size());
	}
}
