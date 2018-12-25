package com.lxg.service;

import com.lxg.sample.entity.User;
import com.lxg.sample.mapper.UserRowMapper;
import com.lxg.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 刘雪岗 on 2017/1/4.
 * jdbcTemplate 实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询所有用户
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new UserRowMapper());
        return list;
    }

    // 按用户名查询列表
    @Override
    public List<User> findByName(String name) {
        String sql = "select * from user where name = ?";
        return jdbcTemplate.query(sql,new Object[]{name},new UserRowMapper());
    }

    // 添加用户
    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    // 按用户名删除用户
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    // 按主键删除用户
    @Override
    public void deleteById(Integer id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
    }

    // 获取用户数量
    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    // 删除所有用户
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }

    // 更新用户
    @Override
    public void updateUser(User user) {
        String sql = "update user set name= ?,age= ? where id = ?";
        jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getId());
    }
}
