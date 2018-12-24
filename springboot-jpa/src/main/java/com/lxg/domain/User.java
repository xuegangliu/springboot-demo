package com.lxg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

/**
 * 用户实体类
 */
@Entity  // jpa实体注解  需要有空构造器
public class User {

    /**
     * 主键id
     */
    @Id // jpa 用户id主键注解
    @GeneratedValue //jpa 用户主键id自增注解
    private Integer id;

    /**
     * 用户名
     */
    @Column(nullable = false)   // jpa 用户名注解 不为空
    private String name;

    /**
     * 年龄
     */
    @Column(nullable = false)   // jpa 用户年龄注解 不为空
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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
