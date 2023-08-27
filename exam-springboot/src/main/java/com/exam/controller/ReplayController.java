package com.exam.controller;

import com.exam.entity.Replay;
import com.exam.service.ReplayService;
import com.exam.util.Res;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author weidie
 */
@RestController
public class ReplayController {

    private final ReplayService replayService;

    public ReplayController(ReplayService replayService) {
        this.replayService = replayService;
    }

    @PostMapping("/replay")
    public Res<Integer> add(@RequestBody Replay replay) {
        int data = replayService.add(replay);
        if (data != 0) {
            return Res.buildApiResult(200, "添加成功！", data);
        } else {
            return Res.buildApiResult(400, "添加失败！", null);
        }
    }

    @GetMapping("/replay/{messageId}")
    public Res<List<Replay>> findAllById(@PathVariable("messageId") Integer messageId) {
        List<Replay> res = replayService.findAllById(messageId);
        return Res.buildApiResult(200, "根据messageId查询", res);
    }
}
