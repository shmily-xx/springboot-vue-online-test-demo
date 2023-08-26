package com.exam.controller;

import com.exam.entity.*;
import com.exam.service.LoginService;
import com.exam.service.StudentService;
import com.exam.service.TeacherService;
import com.exam.serviceimpl.LoginServiceImpl;
import com.exam.util.ApiResultHandler;
import com.exam.util.ValidatorUtils;
import com.exam.vo.RegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author weidie
 */
@RestController
public class LoginController {

    private final LoginService loginService;

    private final TeacherService teacherService;

    private final StudentService studentService;
    public LoginController(LoginService loginService, TeacherService teacherService, StudentService studentService) {
        this.loginService = loginService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public ApiResult<?> login(@RequestBody Login login) {

        Integer username = login.getUsername();
        String password = login.getPassword();
        Admin adminRes = loginService.adminLogin(username, password);
        if (adminRes != null) {
            return ApiResultHandler.buildApiResult(200, "ok", adminRes);
        }

        Teacher teacherRes = loginService.teacherLogin(username,password);
        if (teacherRes != null) {
            return ApiResultHandler.buildApiResult(200, "ok", teacherRes);
        }

        Student studentRes = loginService.studentLogin(username,password);
        if (studentRes != null) {
            return ApiResultHandler.buildApiResult(200, "ok", studentRes);
        }

        return ApiResultHandler.buildApiResult(400, "error", null);
    }


    @RequestMapping("/register")
    public ApiResult<?> register(@RequestBody RegisterVo registerVo) {
        if (("1").equals(registerVo.getRole())) {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(registerVo, teacher);
            teacher.setTeacherName(registerVo.getUserName());
            // 老师
            ValidatorUtils.validateEntity(teacher);
            teacherService.add(teacher);
            return ApiResultHandler.buildApiResult(0, "登陆账号：" + teacher.getTeacherId(), teacher);
        } else {
            Student student = new Student();
            BeanUtils.copyProperties(registerVo, student);
            student.setStudentName(registerVo.getUserName());
            // 学生
            ValidatorUtils.validateEntity(student);
            studentService.add(student);
            return ApiResultHandler.buildApiResult(0, "登陆账号：" + student.getStudentId(), student);
        }
    }
}
