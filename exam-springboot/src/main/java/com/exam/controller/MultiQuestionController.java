package com.exam.controller;

import com.exam.entity.MultiQuestion;
import com.exam.service.MultiQuestionService;
import com.exam.util.Res;
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
    public Res<MultiQuestion> findOnlyQuestion() {
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return Res.buildApiResult(200,"查询成功",res);
    }

    @PostMapping("/MultiQuestion")
    public Res<Integer> add(@RequestBody MultiQuestion multiQuestion) {
        int res = multiQuestionService.add(multiQuestion);
        if (res != 0) {

            return Res.buildApiResult(200,"添加成功",res);
        }
        return Res.buildApiResult(400,"添加失败",res);
    }
}
