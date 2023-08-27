package com.exam.controller;

import com.exam.entity.*;
import com.exam.service.FillQuestionService;
import com.exam.service.JudgeQuestionService;
import com.exam.service.MultiQuestionService;
import com.exam.service.PaperService;
import com.exam.serviceimpl.FillQuestionServiceImpl;
import com.exam.serviceimpl.JudgeQuestionServiceImpl;
import com.exam.serviceimpl.MultiQuestionServiceImpl;
import com.exam.serviceimpl.PaperServiceImpl;
import com.exam.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weidie
 */
@RestController
public class PaperController {

    private final PaperService paperService;

    private final JudgeQuestionService judgeQuestionService;

    private final MultiQuestionService multiQuestionService;

    private final FillQuestionService fillQuestionService;

    public PaperController(PaperService paperService, JudgeQuestionService judgeQuestionService, MultiQuestionService multiQuestionService, FillQuestionService fillQuestionService) {
        this.paperService = paperService;
        this.judgeQuestionService = judgeQuestionService;
        this.multiQuestionService = multiQuestionService;
        this.fillQuestionService = fillQuestionService;
    }

    @GetMapping("/papers")
    public Res<List<PaperManage>> findAll() {
        return Res.buildApiResult(200, "ok", paperService.findAll());
    }

    @GetMapping("/paper/{paperId}")
    public Map<Integer, List<?>> findById(@PathVariable("paperId") Integer paperId) {
        List<MultiQuestion> multiQuestionRes = multiQuestionService.findByIdAndType(paperId);   //选择题题库 1
        List<FillQuestion> fillQuestionsRes = fillQuestionService.findByIdAndType(paperId);     //填空题题库 2
        List<JudgeQuestion> judgeQuestionRes = judgeQuestionService.findByIdAndType(paperId);   //判断题题库 3
        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1, multiQuestionRes);
        map.put(2, fillQuestionsRes);
        map.put(3, judgeQuestionRes);
        return map;
    }

    @PostMapping("/paperManage")
    public Res<Integer> add(@RequestBody PaperManage paperManage) {
        int res = paperService.add(paperManage);
        if (res != 0) {
            return Res.buildApiResult(200, "添加成功", res);
        }
        return Res.buildApiResult(400, "添加失败", res);
    }
}
