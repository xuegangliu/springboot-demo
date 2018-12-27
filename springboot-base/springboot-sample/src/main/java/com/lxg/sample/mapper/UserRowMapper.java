package com.lxg.sample.mapper;

import com.lxg.sample.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    // 封装RowMapper
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        //rs为返回结果集，以每行为单位封装着
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        return user;
    }
}
