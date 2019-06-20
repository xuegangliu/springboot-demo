package com.lxg.mybatis.mapper.secondary.builder;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * User 动态sql处理
 * @author 刘雪岗 on 2017/1/12.
 */

public class UserSqlBuilder {

    /**
     * If use @Param, you can define only arguments to be used
     * @param name
     * @param age
     * @return
     */
    public String buildGetUsersByName(@Param("name") final String name,@Param("age") final Integer age) {
        return new SQL(){{
            SELECT("*");
            FROM("user");
            if(name == null && age ==null) {
                WHERE("id=-1");
            }
            if(name != null) {
                WHERE("name = #{name}");
            }
            if(age != null) {
                WHERE("age = #{age}");
            }
        }}.toString()+"limit 1,2";
    }
}
