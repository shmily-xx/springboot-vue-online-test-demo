package com.exam.controller;

import com.exam.entity.PaperManage;
import com.exam.service.FillQuestionService;
import com.exam.service.JudgeQuestionService;
import com.exam.service.MultiQuestionService;
import com.exam.service.PaperService;
import com.exam.util.Res;
import com.exam.vo.Item;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weidie
 */
@RestController
public class ItemController {

    private final MultiQuestionService multiQuestionService;

    private final FillQuestionService fillQuestionService;

    private final JudgeQuestionService judgeQuestionService;

    private final PaperService paperService;

    public ItemController(MultiQuestionService multiQuestionService, FillQuestionService fillQuestionService, JudgeQuestionService judgeQuestionService, PaperService paperService) {
        this.multiQuestionService = multiQuestionService;
        this.fillQuestionService = fillQuestionService;
        this.judgeQuestionService = judgeQuestionService;
        this.paperService = paperService;
    }

    @PostMapping("/item")
    public Res<Integer> item(@RequestBody Item item) {
        // 选择题
        Integer changeNumber = item.getChangeNumber();
        // 填空题
        Integer fillNumber = item.getFillNumber();
        // 判断题
        Integer judgeNumber = item.getJudgeNumber();
        //出卷id
        Integer paperId = item.getPaperId();

        // 选择题数据库获取
        List<Integer> changeNumbers = multiQuestionService.findBySubject(item.getSubject(), changeNumber);
        if (changeNumbers == null) {
            return Res.buildApiResult(400, "选择题数据库获取失败", null);
        }
        for (Integer number : changeNumbers) {
            PaperManage paperManage = new PaperManage(paperId, 1, number);
            int index = paperService.add(paperManage);
            if (index == 0) {
                return Res.buildApiResult(400, "选择题组卷保存失败", null);
            }
        }

        // 填空题
        List<Integer> fills = fillQuestionService.findBySubject(item.getSubject(), fillNumber);
        if (fills == null) {
            return Res.buildApiResult(400, "填空题数据库获取失败", null);
        }
        for (Integer fillNum : fills) {
            PaperManage paperManage = new PaperManage(paperId, 2, fillNum);
            int index = paperService.add(paperManage);
            if (index == 0) {
                return Res.buildApiResult(400, "填空题题组卷保存失败", null);
            }
        }
        // 判断题
        List<Integer> judges = judgeQuestionService.findBySubject(item.getSubject(), judgeNumber);
        if (judges == null) {
            return Res.buildApiResult(400, "判断题数据库获取失败", null);
        }
        for (Integer judge : judges) {
            PaperManage paperManage = new PaperManage(paperId, 3, judge);
            int index = paperService.add(paperManage);
            if (index == 0) {
                return Res.buildApiResult(400, "判断题题组卷保存失败", null);
            }
        }
        return Res.buildApiResult(200, "试卷组卷成功", null);
    }
}
