package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Teacher;
import com.exam.service.TeacherService;
import com.exam.serviceimpl.TeacherServiceImpl;
import com.exam.util.ApiResultHandler;
import com.exam.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author weidie
 */
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers/{page}/{size}")
    public ApiResult<IPage<Teacher>> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Teacher> teacherPage = new Page<>(page, size);
        IPage<Teacher> teacherIpage = teacherService.findAll(teacherPage);

        return ApiResultHandler.buildApiResult(200, "查询所有教师", teacherIpage);
    }

    @GetMapping("/teacher/{teacherId}")
    public ApiResult<Teacher> findById(@PathVariable("teacherId") Integer teacherId) {
        return ApiResultHandler.success(teacherService.findById(teacherId));
    }

    @DeleteMapping("/teacher/{teacherId}")
    public ApiResult<Integer> deleteById(@PathVariable("teacherId") Integer teacherId) {
        return ApiResultHandler.success(teacherService.deleteById(teacherId));
    }

    @PutMapping("/teacher")
    public ApiResult<Integer> update(@RequestBody Teacher teacher) {
        return ApiResultHandler.success(teacherService.update(teacher));
    }

    @PostMapping("/teacher")
    public ApiResult<Integer> add(@RequestBody Teacher teacher) {
        return ApiResultHandler.success(teacherService.add(teacher));
    }
}
