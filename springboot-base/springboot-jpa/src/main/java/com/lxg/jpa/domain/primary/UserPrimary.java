package com.lxg.jpa.domain.primary;

import javax.persistence.*;

/**
 * @author 刘雪岗 on 2017/1/4.
 * 用户实体类
 */
@Table(name = "user")
@Entity
public class UserPrimary {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 年龄
     */
    @Column(nullable = false)
    private Integer age;

    public UserPrimary() {
    }

    public UserPrimary(String name, Integer age) {
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
