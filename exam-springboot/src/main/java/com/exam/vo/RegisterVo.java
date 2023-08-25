package com.exam.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author weidie
 */
@Data
public class RegisterVo {

    private String studentName;

    /**
     * 年级
     */
    private String grade;

    /**
     * 专业
     */
    private String major;

    /**
     * 班级
     */

    private String clazz;

    /**
     * 学院
     */
    @NotNull
    private String institute;

    /**
     * 电话
     */
    @NotNull
    private String tel;

    @NotNull
    private String email;

    @NotNull
    private String pwd;

    /**
     * 身份证
     */
    @NotNull
    private String cardId;

    @NotNull
    private String sex;

    @NotNull
    private String role;

    private String teacherName;

    @NotNull
    private String userName;

    /**
     * 职称
     */
    private String type;

}
