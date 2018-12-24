package com.lxg.service;

import com.lxg.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

/**
 * jdbcTemplate 实现
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
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


    // 封装RowMapper
    class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            //rs为返回结果集，以每行为单位封装着
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }
}
