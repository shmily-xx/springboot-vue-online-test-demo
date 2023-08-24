package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;

/**
 * @author weidie
 */
public interface StudentService {

    IPage<Student> findAll(Page<Student> page);

    Student findById(Integer studentId);

    int deleteById(Integer studentId);

    int update(Student student);

    void updatePwd(Student student);

    int add(Student student);
}
