package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.FillQuestion;
import com.exam.service.FillQuestionService;
import com.exam.serviceimpl.FillQuestionServiceImpl;
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
public class FillQuestionController {

    private final FillQuestionService fillQuestionService;

    public FillQuestionController(FillQuestionService fillQuestionService) {
        this.fillQuestionService = fillQuestionService;
    }

    @PostMapping("/fillQuestion")
    public ApiResult<Integer> add(@RequestBody FillQuestion fillQuestion) {
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/fillQuestionId")
    public ApiResult<FillQuestion> findOnlyQuestionId() {
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功",res);
}
}
