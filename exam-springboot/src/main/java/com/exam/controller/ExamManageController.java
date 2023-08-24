package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.ExamManage;
import com.exam.service.ExamManageService;
import com.exam.util.ApiResultHandler;
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
    public ApiResult<List<ExamManage>> findAll() {
        return ApiResultHandler.buildApiResult(200, "ok！", examManageService.findAll());
    }

    @GetMapping("/exams/{page}/{size}")
    public ApiResult<IPage<ExamManage>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<ExamManage> examManage = new Page<>(page, size);
        IPage<ExamManage> all = examManageService.findAll(examManage);
        return ApiResultHandler.buildApiResult(200, "ok！", all);
    }

    @GetMapping("/exam/{examCode}")
    public ApiResult<ExamManage> findById(@PathVariable("examCode") Integer examCode) {
        ExamManage res = examManageService.findById(examCode);
        if (res == null) {
            return ApiResultHandler.buildApiResult(10000, "考试编号不存在", null);
        }
        return ApiResultHandler.buildApiResult(200, "ok！", res);
    }

    @DeleteMapping("/exam/{examCode}")
    public ApiResult<Integer> deleteById(@PathVariable("examCode") Integer examCode) {
        int res = examManageService.delete(examCode);
        return ApiResultHandler.buildApiResult(200, "删除成功", res);
    }

    @PutMapping("/exam")
    public ApiResult<Integer> update(@RequestBody ExamManage exammanage) {
        int res = examManageService.update(exammanage);
        return ApiResultHandler.buildApiResult(200, "更新成功", res);
    }

    @PostMapping("/exam")
    public ApiResult<Integer> add(@RequestBody ExamManage exammanage) {
        int res = examManageService.add(exammanage);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", res);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", res);
        }
    }

    @GetMapping("/examManagePaperId")
    public ApiResult<ExamManage> findOnlyPaperId() {
        ExamManage res = examManageService.findOnlyPaperId();
        if (res != null) {
            return ApiResultHandler.buildApiResult(200, "ok!", res);
        }
        return ApiResultHandler.buildApiResult(400, "error", null);
    }
}
