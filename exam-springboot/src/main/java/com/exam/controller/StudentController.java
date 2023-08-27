package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import com.exam.service.StudentService;
import com.exam.util.Res;
import org.springframework.web.bind.annotation.*;

/**
 * @author weidie
 */
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{page}/{size}")
    public Res<IPage<Student>> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Student> studentPage = new Page<>(page, size);
        IPage<Student> res = studentService.findAll(studentPage);
        return Res.buildApiResult(200, "分页查询所有学生", res);
    }

    @GetMapping("/student/{studentId}")
    public Res<Student> findById(@PathVariable("studentId") Integer studentId) {
        Student res = studentService.findById(studentId);
        if (res != null) {
            return Res.buildApiResult(200, "ok", res);
        } else {
            return Res.buildApiResult(404, "查询的用户不存在", null);
        }
    }

    @DeleteMapping("/student/{studentId}")
    public Res<Integer> deleteById(@PathVariable("studentId") Integer studentId) {
        return Res.buildApiResult(200, "删除成功", studentService.deleteById(studentId));
    }

    @PutMapping("/studentPWD")
    public Res<String> updatePwd(@RequestBody Student student) {
        studentService.updatePwd(student);
        return Res.buildApiResult(200, "密码更新成功", null);
    }

    @PutMapping("/student")
    public Res<Integer> update(@RequestBody Student student) {
        int res = studentService.update(student);
        if (res != 0) {
            return Res.buildApiResult(200, "更新成功", res);
        }
        return Res.buildApiResult(400, "更新失败", res);
    }

    @PostMapping("/student")
    public Res<Integer> add(@RequestBody Student student) {
        int res = studentService.add(student);
        if (res == 1) {
            return Res.buildApiResult(200, "添加成功", null);
        } else {
            return Res.buildApiResult(400, "添加失败", null);
        }
    }
}
