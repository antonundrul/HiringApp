package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.entity.Chat;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper extends AbstractMapper<Chat, ChatDTO> {
    public ChatMapper() {
        super(Chat.class, ChatDTO.class);
    }
}
