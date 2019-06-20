package com.lxg.jpa.dao.primary;

import com.lxg.jpa.domain.primary.UserPrimary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author 刘雪岗 on 2017/1/4.
 * jpa 实现(方法命名规则)通过解析方法名创建查询
 */
@Repository
public interface UserPrimaryRepository extends JpaRepository<UserPrimary,Integer>{

    /**
     * 按用户名查询用户
     * @param name
     * @return
     */
    UserPrimary findByName(String name);

    /**
     * 按id删除用户
     * @param id
     * @return
     */
    @Override
    Optional<UserPrimary> findById(Integer id);

    /**
     * 按用户名和用户年龄查询用户
     * @param name
     * @param age
     * @return
     */
    UserPrimary findByNameAndAge(String name, Integer age);

    /**
     * 按用户名查询
     * @param name
     * @return
     */
    @Query("from UserPrimary u where u.name=:name")
    UserPrimary findUser(@Param("name") String name);

    /**
     * 更新用户
     * @param name
     * @param age
     * @param id
     */
    @Modifying
    @Query("update UserPrimary u set u.name=?1,u.age=?2 where u.id=?3")
    void updateUser(String name,Integer age,Integer id);

}
