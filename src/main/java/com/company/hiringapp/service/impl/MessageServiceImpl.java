package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.dto.MessageDTO;
import com.company.hiringapp.dto.PageWrapper;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.mapper.ChatMapper;
import com.company.hiringapp.dto.mapper.MessageMapper;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.entity.Message;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.MessageRepository;
import com.company.hiringapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private MessageMapper messageMapper;
    private ChatMapper chatMapper;
    private UserMapper userMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository,
                              MessageMapper messageMapper,
                              ChatMapper chatMapper,
                              UserMapper userMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.chatMapper = chatMapper;
        this.userMapper = userMapper;
    }

    @Override
    public MessageDTO save(MessageDTO messageDTO) {

        Message message = messageMapper.toEntity(messageDTO);
        messageRepository.save(message);
        return messageDTO;
    }

    @Override
    public MessageDTO findById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return messageMapper.toDto(message);
    }

    @Override
    public void delete(Long messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException(messageId));
        messageRepository.delete(message);
    }

    @Override
    public PageWrapper<MessageDTO> findByMessage(String message, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Message> messages = messageRepository.findByMessage(message, pageable);

        return new PageWrapper<>(messageMapper.toDtoList(messages.toList()), messages.getTotalPages(), messages.getTotalElements());
    }

    @Override
    public PageWrapper<MessageDTO> findByChat(ChatDTO chatDTO, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Message> messages = messageRepository.findByChat(chatMapper.toEntity(chatDTO), pageable);

        return new PageWrapper<>(messageMapper.toDtoList(messages.toList()), messages.getTotalPages(), messages.getTotalElements());
    }

    @Override
    public PageWrapper<MessageDTO> findBySender(UserDTO senderDto, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Message> messages = messageRepository.findBySender(userMapper.toEntity(senderDto), pageable);

        return new PageWrapper<>(messageMapper.toDtoList(messages.toList()), messages.getTotalPages(), messages.getTotalElements());
    }


    @Override
    public List<MessageDTO> findByMessage(String message) {
        return messageMapper.toDtoList(messageRepository.findByMessage(message));
    }

    @Override
    public List<MessageDTO> findByChat(ChatDTO chatDTO) {

        return messageMapper.toDtoList(messageRepository.findByChat(chatMapper.toEntity(chatDTO)));
    }

    @Override
    public List<MessageDTO> findBySender(UserDTO senderDto) {
        return messageMapper.toDtoList(messageRepository.findBySender(userMapper.toEntity(senderDto)));
    }

}
