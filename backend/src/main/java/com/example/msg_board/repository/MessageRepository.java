package com.example.msg_board.repository;

import com.example.msg_board.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // 這邊不用自己寫任何方法，JpaRepository 會自動幫你處理 CRUD
}
