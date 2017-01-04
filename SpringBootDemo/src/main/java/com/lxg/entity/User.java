package com.lxg.entity;

import java.io.Serializable;

/**
 * Created by 刘雪岗 on 2017/1/3.
 */

/**
 * 用户实体类
 */
public class User implements Serializable {

    /**
     * 用户主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
