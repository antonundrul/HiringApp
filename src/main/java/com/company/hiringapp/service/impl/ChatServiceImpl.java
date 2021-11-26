package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.dto.PageWrapper;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.mapper.ChatMapper;
import com.company.hiringapp.entity.Chat;
import com.company.hiringapp.entity.Message;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.ChatRepository;
import com.company.hiringapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class ChatServiceImpl implements ChatService {
    private ChatRepository chatRepository;
    private ChatMapper chatMapper;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository,
                           ChatMapper chatMapper) {
        this.chatRepository = chatRepository;
        this.chatMapper = chatMapper;
    }

    /*@Override
    public boolean isPresent(UserDTO firstUser, UserDTO secondUser) {
        if (chatRepository.findByFirstUser(firstUser))
    }*/

    @Override
    public ChatDTO save(ChatDTO dto) {

        chatRepository.save(chatMapper.toEntity(dto));
        return dto;
    }

    @Override
    public PageWrapper<ChatDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public ChatDTO findById(Long id) {
        Chat chat = chatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return chatMapper.toDto(chat);
    }

    @Override
    public PageWrapper<ChatDTO> findAllForUser(UserDTO userDto, int page, int size) {
        return null;
    }

    @Override
    public List<ChatDTO> findAllForUser(UserDTO userDto) {
        List<Chat> chats = chatRepository.findAll();

        chats.stream()
                .filter(i->i.getFirstUser().equals(userDto)||i.getSecondUser().equals(userDto));


        return chatMapper.toDtoList(chats);
    }

    @Override
    public List<UserDTO> getInterlocutors(List<ChatDTO> chats, UserDTO user) {
        List<UserDTO> interlocutors = new ArrayList<>();

        for(ChatDTO chat: chats){
            if(chat.getFirstUser().equals(user)){
                interlocutors.add(chat.getSecondUser());
            }
            else{
                interlocutors.add(chat.getFirstUser());
            }
        }

        return interlocutors;
    }

    @Override
    public HashMap<UserDTO, ChatDTO> getChats(UserDTO userDto) {

        Chat allChats = chatRepository.findAll().get(0);



        List<ChatDTO> chats = chatMapper.toDtoList(chatRepository.findAll());
        chats.stream()
                .filter(i->i.getFirstUser().equals(userDto)||i.getSecondUser().equals(userDto));


        List<UserDTO> interlocutors = new ArrayList<>();
        for(ChatDTO chat: chats){
            if(chat.getFirstUser().equals(userDto)){
                interlocutors.add(chat.getSecondUser());
            }
            else{
                interlocutors.add(chat.getFirstUser());
            }
        }


        HashMap<UserDTO,ChatDTO> chatMap = new HashMap<>();
        for(int i =0;i<chats.size();i++){
            chatMap.put(interlocutors.get(i),chats.get(i));
        }
        return chatMap;
    }

    @Override
    public ChatDTO findByUsers(Long firstUserId, Long secondUserId) {
        List<Chat> allChats = chatRepository.findAll();
        Chat result = new Chat();

        for(Chat chat:allChats){
            if((chat.getFirstUser().getId()==firstUserId&&chat.getSecondUser().getId()==secondUserId)
                    ||(chat.getFirstUser().getId()==secondUserId&&chat.getSecondUser().getId()==firstUserId)){
                result=chat;
                break;
            }
        }

        return chatMapper.toDto(result);
    }

    @Override
    public void delete(Long id) {
        Chat chat = chatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        chatRepository.delete(chat);
    }
}
