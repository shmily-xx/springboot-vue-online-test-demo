package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.MultiQuestion;
import com.exam.service.MultiQuestionService;
import com.exam.serviceimpl.MultiQuestionServiceImpl;
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
public class MultiQuestionController {

    private final MultiQuestionService multiQuestionService;

    public MultiQuestionController(MultiQuestionService multiQuestionService) {
        this.multiQuestionService = multiQuestionService;
    }

    @GetMapping("/multiQuestionId")
    public ApiResult<MultiQuestion> findOnlyQuestion() {
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功",res);
    }

    @PostMapping("/MultiQuestion")
    public ApiResult<Integer> add(@RequestBody MultiQuestion multiQuestion) {
        int res = multiQuestionService.add(multiQuestion);
        if (res != 0) {

            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }
}
