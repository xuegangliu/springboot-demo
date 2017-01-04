package com.lxg.service;

/**
 * Created by 刘雪岗 on 2017/1/3.
 */

import com.lxg.entity.User;

import java.util.List;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 按用户名查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 按主键删除用户
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

}
