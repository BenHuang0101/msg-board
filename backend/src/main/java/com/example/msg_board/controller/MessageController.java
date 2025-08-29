package com.example.msg_board.controller;

import com.example.msg_board.model.Message;
import com.example.msg_board.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*") // 前後端分離：允許跨域請求
public class MessageController {

    @Autowired
    private MessageService messageService;

    // 查詢所有留言
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // 新增一則留言
    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    // 刪除留言
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessageById(id);
    }

}