package com.example.msg_board.service;

import com.example.msg_board.model.Message;
import com.example.msg_board.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // 查詢所有留言
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // 新增留言
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    // 刪除留言
    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }

}