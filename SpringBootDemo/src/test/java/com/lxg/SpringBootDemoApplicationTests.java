package com.lxg;

import com.lxg.entity.User;
import com.lxg.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void testdelAll(){
		// 初始化表(清除数据)
		userService.deleteAllUsers();
	}

	/**
	 * 查询所有数据
	 */
	@Test
	public void testFindAll(){
		List<User> list = userService.findAll();
		System.out.print(list.size());
	}

	/**
	 * 添加用户
	 */
	@Test
	public void testCreate() {
		// 插入5个用户
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);
		userService.create("MM", 55);
	}

	/**
	 * 查询总数
	 */
	@Test
	public void getAllUserstest(){
		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userService.getAllUsers().intValue());
	}

	/**
	 * 按名称删除数据
	 */
	@Test
	public void testdelUserByName(){
		// 删除两个用户
		userService.deleteByName("a");
		userService.deleteByName("e");
	}

	/**
	 * 查询数据个数
	 */
	@Test
	public void testGetUserSize(){
		System.out.print("数据user个数="+userService.getAllUsers().intValue()+"\n");
	}

//	@Test
//	public void tesetUpdate(){
//		User user = userService.findByName("MM").get(0);
//		System.out.print("更新前User={"+user.getId()+","+user.getName()+","+user.getAge()+"}\n");
//		user.setName("NN");
//		user.setAge(22);
//		userService.updateUser(user);
//		System.out.print("更新前User={"+user.getId()+","+user.getName()+","+user.getAge()+"}\n");
//	}
}
