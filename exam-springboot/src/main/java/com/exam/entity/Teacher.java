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
public class Teacher {

    @TableId(value = "teacherId",type = IdType.AUTO)//在自增主键的变量加上即可
    private Integer teacherId;

    @NotNull
    @ApiModelProperty("名字")
    private String teacherName;

    @NotNull
    @ApiModelProperty("所属学院")
    private String institute;

    @NotNull
    @ApiModelProperty("性别")
    private String sex;

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
    @ApiModelProperty("职级")
    private String type;

    @NotNull
    @ApiModelProperty("身份")
    private String role;
}