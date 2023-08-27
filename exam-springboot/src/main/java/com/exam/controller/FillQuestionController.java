package com.exam.controller;

import com.exam.entity.FillQuestion;
import com.exam.service.FillQuestionService;
import com.exam.util.Res;
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
    public Res<Integer> add(@RequestBody FillQuestion fillQuestion) {
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0) {
            return Res.buildApiResult(200,"添加成功",res);
        }
        return Res.buildApiResult(400,"添加失败",res);
    }

    @GetMapping("/fillQuestionId")
    public Res<FillQuestion> findOnlyQuestionId() {
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return Res.buildApiResult(200,"查询成功",res);
}
}
