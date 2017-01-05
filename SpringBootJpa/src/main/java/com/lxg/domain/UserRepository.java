package com.lxg.domain;

import com.lxg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

/**
 * jpa 实现(方法命名规则)通过解析方法名创建查询
 */
public interface UserRepository extends JpaRepository<User,Integer>{

    /**
     * 按用户名查询用户
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 按id删除用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 按用户名和用户年龄查询用户
     * @param name
     * @param age
     * @return
     */
    User findByNameAndAge(String name,Integer age);

    /**
     * 按用户名查询
     * @param name
     * @return
     */
    @Query("from User u where u.name=:name")    // jpa hql实现
    User findUser(@Param("name") String name);

    @Modifying
    @Query("update User u set u.name=?1,u.age=?2 where u.id=?3")
    void updateUser(String name,Integer age,Integer id);

}
