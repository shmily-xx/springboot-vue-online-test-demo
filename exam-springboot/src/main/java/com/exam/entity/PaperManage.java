package com.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("paper_manage")
public class PaperManage {
    private Integer paperId;

    private Integer questionType;

    private Integer questionId;


}