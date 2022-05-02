package com.company.hiringapp.service;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.dto.PageWrapper;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.Chat;

import java.util.HashMap;
import java.util.List;

public interface ChatService {

//    boolean isPresent(UserDTO firstUser, UserDTO secondUser);

    ChatDTO save(ChatDTO dto);

    PageWrapper<ChatDTO> findAll(int page, int size);

    ChatDTO findById(Long id);

    PageWrapper<ChatDTO> findAllForUser(UserDTO userDto,int page, int size);
    List<ChatDTO> findAllForUser(UserDTO userDto);
    List<UserDTO> getInterlocutors(List<ChatDTO> chats, UserDTO user);

    HashMap<UserDTO,ChatDTO> getChats(UserDTO userDto);

    ChatDTO findByUsers(Long firstUserId, Long secondUserId);
    int countUnseenMessages(Long chatId, UserDTO receiver);
    void delete(Long id);
}
