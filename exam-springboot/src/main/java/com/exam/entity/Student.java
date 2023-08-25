package com.exam.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author weidie
 */
@Data
public class Student {

    private Integer studentId;

    /**
     * 名字
     */
    @NotNull
    private String studentName;

    @NotNull
    private String grade;

    @NotNull
    private String major;

    @NotNull
    private String clazz;

    @NotNull
    private String institute;

    @NotNull
    private String tel;

    @NotNull
    private String email;

    @NotNull
    private String pwd;

    @NotNull
    private String cardId;

    @NotNull
    private String sex;

    @NotNull
    private String role;
}