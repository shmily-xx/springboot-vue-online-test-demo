package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author weidie
 */
@Data
public class Student {

    @TableId(value = "teacherId",type = IdType.AUTO)//在自增主键的变量加上即可
    private Integer studentId;

    /**
     * 名字
     */
    @NotNull
    @ApiModelProperty("名字")
    private String studentName;

    @NotNull
    @ApiModelProperty("年级")
    private String grade;

    @NotNull
    @ApiModelProperty("专业")
    private String major;

    @NotNull
    @ApiModelProperty("班级")
    private String clazz;

    @NotNull
    @ApiModelProperty("学院")
    private String institute;

    @NotNull
    @ApiModelProperty("电话号码")
    private String tel;

    @NotNull
    @ApiModelProperty("email")
    private String email;

    @NotNull
    @ApiModelProperty("密码")
    private String pwd;

    @NotNull
    @ApiModelProperty("身份证号")
    private String cardId;

    @NotNull
    @ApiModelProperty("性别")
    private String sex;

    @NotNull
    @ApiModelProperty("身份")
    private String role;
}