package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.mapper.StudentMapper;
import com.exam.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author weidie
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public IPage<Student> findAll(Page<Student> page) {
        return studentMapper.findAll(page);
    }

    @Override
    public Student findById(Integer studentId) {
        return studentMapper.findById(studentId);
    }

    @Override
    public int deleteById(Integer studentId) {
        return studentMapper.deleteById(studentId);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public void updatePwd(Student student) {
        studentMapper.updatePwd(student);
    }

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }
}
