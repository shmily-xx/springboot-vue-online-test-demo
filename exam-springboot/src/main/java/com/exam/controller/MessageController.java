package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Message;
import com.exam.service.MessageService;
import com.exam.util.Res;
import org.springframework.web.bind.annotation.*;

/**
 * @author weidie
 */
@RestController
public class MessageController {

    private final MessageService messageService;
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages/{page}/{size}")
    public Res<IPage<Message>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Message> messagePage = new Page<>(page,size);
        IPage<Message> all = messageService.findAll(messagePage);
        return Res.buildApiResult(200,"查询所有留言", all);
    }

    @GetMapping("/message/{id}")
    public Res<Message> findById(@PathVariable("id") Integer id) {
        Message res = messageService.findById(id);
        return Res.buildApiResult(200,"根据Id查询",res);
    }

    @DeleteMapping("/message/{id}")
    public int delete(@PathVariable("id") Integer id) {
        return messageService.delete(id);
    }

    @PostMapping("/message")
    public Res<Integer> add(@RequestBody Message message) {
        int res = messageService.add(message);
        if (res == 0) {
            return Res.buildApiResult(400,"添加失败",res);
        } else {
            return Res.buildApiResult(200,"添加成功",res);
        }
    }
}
