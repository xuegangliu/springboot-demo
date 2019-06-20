package com.lxg.mybatis.mapper.primary;

import com.lxg.mybatis.domain.primary.User;
import com.lxg.mybatis.mapper.primary.builder.UserSqlBuilder;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 用户接口 mapper注解实现
 * @author 刘雪岗 on 2017/1/12.
 */
@Mapper
public interface UserMapper {

    /**
     * 按用户名查询用户
     * @param name
     * @return
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    /**
     * 按用户id查询用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") Long id);

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> findAll();

    /**
     * 按用户名更新用户年龄
     * @param user
     */
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void updateAgeByName(User user);

    /**
     * 按主键删除用户
     * @param id
     */
    @Delete("DELETE FROM user WHERE id =#{id}")
    void deleteById(@Param("id") Long id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    /**
     * 添加用户   传入参数为map
     * @param map
     * @return
     */
    @Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 动态SQL查询
     * @param name
     * @param age
     * @return
     */
    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetUsersByName")
    List<User> getUsersByNameToBuilder(
            @Param("name") String name, @Param("age") Integer age);
}