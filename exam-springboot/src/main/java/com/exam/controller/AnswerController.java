package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.service.AnswerService;
import com.exam.util.Res;
import com.exam.vo.AnswerVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author weidie
 */
@RestController
public class AnswerController {

    private final AnswerService answerService;
    public AnswerController(AnswerService adminService) {
        this.answerService = adminService;
    }

    @GetMapping("/answers/{page}/{size}")
    public Res<IPage<AnswerVO>> findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
       Page<AnswerVO> answervoPage = new Page<>(page,size);
       IPage<AnswerVO> answervoIpage = answerService.findAll(answervoPage);
       return Res.buildApiResult(200,"ok",answervoIpage);

    }
}
