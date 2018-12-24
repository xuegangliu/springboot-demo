package com.lxg.domain.primary;

import java.io.Serializable;

/**
 * Created by 刘雪岗 on 2017/1/12.
 */

/**
 * 用户实体类
 */
public class User implements Serializable {

    /**
     * 用户主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    public User() {
    }

    public User(Long id, String name, Integer age) {
        this.id = id;
        name = name;
        this.age = age;
    }

    public User(String name, Integer age) {
        name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
