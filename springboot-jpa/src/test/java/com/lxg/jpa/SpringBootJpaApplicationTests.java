package com.lxg.jpa;

import com.lxg.jpa.dao.primary.UserPrimaryRepository;
import com.lxg.jpa.dao.secondary.UserSecondaryRepository;
import com.lxg.jpa.domain.primary.UserPrimary;
import com.lxg.jpa.domain.secondary.UserSecondary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {

	@Autowired
	private UserSecondaryRepository userRepository;
	@Autowired
	private UserPrimaryRepository userPrimaryRepository;

	@Test
	public void test() throws Exception {

		// 创建10条记录
		userRepository.save(new UserSecondary("AAA", 10));
		userRepository.save(new UserSecondary("BBB", 20));
		userRepository.save(new UserSecondary("CCC", 30));
		userRepository.save(new UserSecondary("DDD", 40));
		userRepository.save(new UserSecondary("EEE", 50));
		userRepository.save(new UserSecondary("FFF", 60));
		userRepository.save(new UserSecondary("GGG", 70));
		userRepository.save(new UserSecondary("HHH", 80));
		userRepository.save(new UserSecondary("III", 90));
		userRepository.save(new UserSecondary("JJJ", 100));
		userPrimaryRepository.save(new UserPrimary("BBB", 20));
		userPrimaryRepository.save(new UserPrimary("CCC", 30));
		userPrimaryRepository.save(new UserPrimary("DDD", 40));
		userPrimaryRepository.save(new UserPrimary("EEE", 50));
		userPrimaryRepository.save(new UserPrimary("FFF", 60));
		userPrimaryRepository.save(new UserPrimary("GGG", 70));
		userPrimaryRepository.save(new UserPrimary("HHH", 80));
		userPrimaryRepository.save(new UserPrimary("III", 90));
		userPrimaryRepository.save(new UserPrimary("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());

	}

}
