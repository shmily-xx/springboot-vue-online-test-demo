package com.exam.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author weidie
 */
@Data
public class Teacher {
    private Integer teacherId;
    @NotNull
    private String teacherName;

    @NotNull
    private String institute;

    @NotNull
    private String sex;

    @NotNull
    private String tel;

    @NotNull
    private String email;

    @NotNull
    private String pwd;

    @NotNull
    private String cardId;

    @NotNull
    private String type;

    @NotNull
    private String role;
}