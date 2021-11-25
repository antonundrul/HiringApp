package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.MessageDTO;
import com.company.hiringapp.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper extends AbstractMapper<Message, MessageDTO> {

    @Autowired
    public MessageMapper() {
        super(Message.class, MessageDTO.class);
    }
}
