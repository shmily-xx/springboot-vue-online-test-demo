package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.JudgeQuestion;
import com.exam.service.JudgeQuestionService;
import com.exam.serviceimpl.JudgeQuestionServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weidie
 */
@RestController
public class JudgeQuestionController {

    private final JudgeQuestionService judgeQuestionService;

    public JudgeQuestionController(JudgeQuestionService judgeQuestionService) {
        this.judgeQuestionService = judgeQuestionService;
    }

    @PostMapping("/judgeQuestion")
    public ApiResult<Integer> add(@RequestBody JudgeQuestion judgeQuestion) {
        int res = judgeQuestionService.add(judgeQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200, "添加成功", res);
        }
        return ApiResultHandler.buildApiResult(400, "添加失败", res);
    }

    @GetMapping("/judgeQuestionId")
    public ApiResult<JudgeQuestion> findOnlyQuestionId() {
        JudgeQuestion res = judgeQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200, "查询成功", res);
    }
}
