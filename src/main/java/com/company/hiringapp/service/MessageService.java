package com.company.hiringapp.service;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.dto.MessageDTO;
import com.company.hiringapp.dto.PageWrapper;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.Message;

import java.util.List;

public interface MessageService {
    MessageDTO save(MessageDTO messageDTO);
    MessageDTO findById(Long id);
    void delete(Long messageId);

    PageWrapper<MessageDTO> findByMessage(String message,int page, int size);
    PageWrapper<MessageDTO> findByChat(ChatDTO chatDTO,int page, int size);
    PageWrapper<MessageDTO> findBySender(UserDTO senderDto,int page, int size);

    List<MessageDTO> findByMessage(String message);
    List<MessageDTO> findByChat(ChatDTO chatDTO);
    List<MessageDTO> findBySender(UserDTO senderDto);


}
