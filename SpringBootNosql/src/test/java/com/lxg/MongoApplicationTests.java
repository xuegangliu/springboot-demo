package com.lxg;

import com.lxg.domain.Student;
import com.lxg.domain.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 刘雪岗 on 2017/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootNosqlApplication.class)
public class MongoApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void setUp() {
        studentRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {

        // 创建三个Student，并验证Student总数
        studentRepository.save(new Student(1L, "didi", 30));
        studentRepository.save(new Student(2L, "mama", 40));
        studentRepository.save(new Student(3L, "kaka", 50));
        Assert.assertEquals(3, studentRepository.findAll().size());

        // 删除一个Student，再验证Student总数
        Student u = studentRepository.findOne(1L);
        studentRepository.delete(u);
        Assert.assertEquals(2, studentRepository.findAll().size());

        // 删除一个Student，再验证Student总数
        u = studentRepository.findByStudentname("mama");
        studentRepository.delete(u);
        Assert.assertEquals(1, studentRepository.findAll().size());

    }
}
