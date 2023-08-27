package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ExamManage;
import com.exam.service.ExamManageService;
import com.exam.util.Res;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weidie
 */
@RestController
public class ExamManageController {

    private final ExamManageService examManageService;

    public ExamManageController(ExamManageService examManageService) {
        this.examManageService = examManageService;
    }

    @GetMapping("/exams")
    public Res<List<ExamManage>> findAll() {
        return Res.buildApiResult(200, "ok！", examManageService.findAll());
    }

    @GetMapping("/exams/{page}/{size}")
    public Res<IPage<ExamManage>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<ExamManage> examManage = new Page<>(page, size);
        IPage<ExamManage> all = examManageService.findAll(examManage);
        return Res.buildApiResult(200, "ok！", all);
    }

    @GetMapping("/exam/{examCode}")
    public Res<ExamManage> findById(@PathVariable("examCode") Integer examCode) {
        ExamManage res = examManageService.findById(examCode);
        if (res == null) {
            return Res.buildApiResult(10000, "考试编号不存在", null);
        }
        return Res.buildApiResult(200, "ok！", res);
    }

    @DeleteMapping("/exam/{examCode}")
    public Res<Integer> deleteById(@PathVariable("examCode") Integer examCode) {
        int res = examManageService.delete(examCode);
        return Res.buildApiResult(200, "删除成功", res);
    }

    @PutMapping("/exam")
    public Res<Integer> update(@RequestBody ExamManage exammanage) {
        int res = examManageService.update(exammanage);
        return Res.buildApiResult(200, "更新成功", res);
    }

    @PostMapping("/exam")
    public Res<Integer> add(@RequestBody ExamManage exammanage) {
        int res = examManageService.add(exammanage);
        if (res == 1) {
            return Res.buildApiResult(200, "添加成功", res);
        } else {
            return Res.buildApiResult(400, "添加失败", res);
        }
    }

    @GetMapping("/examManagePaperId")
    public Res<ExamManage> findOnlyPaperId() {
        ExamManage res = examManageService.findOnlyPaperId();
        if (res != null) {
            return Res.buildApiResult(200, "ok!", res);
        }
        return Res.buildApiResult(400, "error", null);
    }
}
