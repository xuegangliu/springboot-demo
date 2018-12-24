package com.lxg.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by 刘雪岗 on 2017/1/5.
 */
public interface  StudentRepository extends MongoRepository<Student, Long> {

    Student findByStudentname(String username);
}
