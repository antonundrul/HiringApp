package com.company.hiringapp.repository;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.Chat;
import com.company.hiringapp.entity.Message;
import com.company.hiringapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findById(Long id);

    Page<Message> findByChat(Chat chat, Pageable pageable);
    Page<Message> findBySender(User sender, Pageable pageable);
    Page<Message> findByMessage(String message, Pageable pageable);

    List<Message> findByChat(Chat chat);

    List<Message> findBySender(User sender);

    List<Message> findByMessage(String message);
}
