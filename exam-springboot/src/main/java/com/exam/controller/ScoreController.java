package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Score;
import com.exam.service.ScoreService;
import com.exam.util.Res;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weidie
 */
@RestController
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/scores")
    public Res<List<Score>> findAll() {
        List<Score> res = scoreService.findAll();
        return Res.buildApiResult(200, "查询所有学生成绩", res);
    }

    //    分页
    @GetMapping("/score/{page}/{size}/{studentId}")
    public Res<IPage<Score>> findById(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("studentId") Integer studentId) {
        Page<Score> scorePage = new Page<>(page, size);
        IPage<Score> res = scoreService.findById(scorePage, studentId);
        return Res.buildApiResult(200, "根据ID查询成绩", res);
    }

    //    不分页
    @GetMapping("/score/{studentId}")
    public Res<List<Score>> findById(@PathVariable("studentId") Integer studentId) {
        List<Score> res = scoreService.findById(studentId);
        if (!res.isEmpty()) {
            return Res.buildApiResult(200, "根据ID查询成绩", res);
        } else {
            return Res.buildApiResult(400, "ID不存在", res);
        }
    }

    @PostMapping("/score")
    public Res<Integer> add(@RequestBody Score score) {
        int res = scoreService.add(score);
        if (res == 0) {
            return Res.buildApiResult(400, "成绩添加失败", res);
        } else {
            return Res.buildApiResult(200, "成绩添加成功", res);
        }
    }

    @GetMapping("/scores/{examCode}")
    public Res<List<Score>> findByExamCode(@PathVariable("examCode") Integer examCode) {
        List<Score> scores = scoreService.findByExamCode(examCode);
        return Res.buildApiResult(200, "查询成功", scores);
    }
}
