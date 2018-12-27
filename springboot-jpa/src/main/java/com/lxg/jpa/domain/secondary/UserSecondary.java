package com.lxg.jpa.domain.secondary;

import javax.persistence.*;

/**
 * Created by 刘雪岗 on 2017/1/4.
 */

/**
 * 用户实体类
 */
@Table(name = "user")
@Entity  // jpa实体注解  需要有空构造器
public class UserSecondary {

    /**
     * 主键id
     */
    @Id // jpa 用户id主键注解
//    @GeneratedValue //jpa 用户主键id自增注解
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    public UserSecondary() {
    }

    public UserSecondary(String name, Integer age) {
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
