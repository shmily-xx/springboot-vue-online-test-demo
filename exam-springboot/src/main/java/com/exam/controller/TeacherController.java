package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import com.exam.service.TeacherService;
import com.exam.util.Res;
import org.springframework.web.bind.annotation.*;

/**
 * @author weidie
 */
@RestController
public class TeacherController {

    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers/{page}/{size}")
    public Res<IPage<Teacher>> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Teacher> teacherPage = new Page<>(page, size);
        IPage<Teacher> teacherIpage = teacherService.findAll(teacherPage);

        return Res.buildApiResult(200, "查询所有教师", teacherIpage);
    }

    @GetMapping("/teacher/{teacherId}")
    public Res<Teacher> findById(@PathVariable("teacherId") Integer teacherId) {
        return Res.success(teacherService.findById(teacherId));
    }

    @DeleteMapping("/teacher/{teacherId}")
    public Res<Integer> deleteById(@PathVariable("teacherId") Integer teacherId) {
        return Res.success(teacherService.deleteById(teacherId));
    }

    @PutMapping("/teacher")
    public Res<Integer> update(@RequestBody Teacher teacher) {
        return Res.success(teacherService.update(teacher));
    }

    @PostMapping("/teacher")
    public Res<Integer> add(@RequestBody Teacher teacher) {
        return Res.success(teacherService.add(teacher));
    }
}
