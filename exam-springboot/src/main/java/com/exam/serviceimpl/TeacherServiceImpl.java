package com.exam.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import com.exam.mapper.TeacherMapper;
import com.exam.service.TeacherService;
import com.exam.vo.RegisterVo;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weidie
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public IPage<Teacher> findAll(Page<Teacher> page) {
        return teacherMapper.selectPage(page, null);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.selectList(null);
    }

    @Override
    public Teacher findById(Integer teacherId) {
        return teacherMapper.selectById(teacherId);
    }

    @Override
    public int deleteById(Integer teacherId) {
        return teacherMapper.deleteById(teacherId);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.updateById(teacher);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

}
