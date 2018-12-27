package com.lxg.sample;

import com.lxg.sample.entity.User;
import com.lxg.sample.mapper.UserRowMapper;
import com.lxg.sample.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	UserService userService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
//	@Autowired
//	@Qualifier("primaryJdbcTemplate")
//	protected JdbcTemplate jdbcTemplate1;
//	@Autowired
//	@Qualifier("secondaryJdbcTemplate")
//	protected JdbcTemplate jdbcTemplate2;

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

	@Test
	public void tesetUpdate(){
		User user = userService.findByName("MM").get(0);
		System.out.print("更新前User={"+user.getId()+","+user.getName()+","+user.getAge()+"}\n");
		user.setName("NN");
		user.setAge(22);
		userService.updateUser(user);
		System.out.print("更新前User={"+user.getId()+","+user.getName()+","+user.getAge()+"}\n");
	}

    @Test
    public void testFindAll1() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new UserRowMapper());
        System.out.println(list.size());
    }




//	@Test
//	public void testMoreDataSource() throws Exception {
//		jdbcTemplate1.update("DELETE  FROM  USER ");
//		jdbcTemplate2.update("DELETE  FROM  USER ");
//
//		// 往第一个数据源中插入两条数据
//		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
//		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);
//
//		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
//		jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
//
//		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
//		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));
//
//		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
//		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));
//	}

}
