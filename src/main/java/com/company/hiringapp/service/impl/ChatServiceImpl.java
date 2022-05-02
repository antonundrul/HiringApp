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
import com.company.hiringapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired private ChatRepository chatRepository;
    @Autowired private ChatMapper chatMapper;
    @Autowired private MessageService messageService;

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
        List<ChatDTO> allChats = chatMapper.toDtoList(chatRepository.findAll());
        List<ChatDTO> userChats = new ArrayList<>();

        for(ChatDTO chat : allChats){
            if(chat.getFirstUser().equals(userDto) || chat.getSecondUser().equals(userDto)){
                userChats.add(chat);
            }
        }


        return userChats;
    }

    @Override
    public List<UserDTO> getInterlocutors(List<ChatDTO> chats, UserDTO user) {
        List<UserDTO> interlocutors = new ArrayList<>();

        for(ChatDTO chat: chats){
            if(chat.getFirstUser().equals(user)){
                interlocutors.add(chat.getSecondUser());
            }
            if(chat.getSecondUser().equals(user)){
                interlocutors.add(chat.getFirstUser());
            }
        }

        return interlocutors;
    }

    @Override
    public HashMap<UserDTO, ChatDTO> getChats(UserDTO userDto) {

        List<ChatDTO> allChats = chatMapper.toDtoList(chatRepository.findAll());
        List<ChatDTO> userChats = new ArrayList<>();

        for(ChatDTO chat : allChats){
            if(chat.getFirstUser().equals(userDto) || chat.getSecondUser().equals(userDto)){
                userChats.add(chat);
            }
        }

        List<UserDTO> interlocutors = new ArrayList<>();
        for(ChatDTO chat: userChats){
            if(chat.getFirstUser().equals(userDto)){
                interlocutors.add(chat.getSecondUser());
            }
            else{
                interlocutors.add(chat.getFirstUser());
            }
        }


        HashMap<UserDTO,ChatDTO> chatMap = new HashMap<>();
        for(int i =0;i<userChats.size();i++){
            chatMap.put(interlocutors.get(i),userChats.get(i));
        }
        return chatMap;
    }

    @Override
    public ChatDTO findByUsers(Long firstUserId, Long secondUserId) {
        List<Chat> allChats = chatRepository.findAll();
        Chat result = new Chat();

        for(Chat chat:allChats){
            if((chat.getFirstUser().getId().equals(firstUserId) && chat.getSecondUser().getId().equals(secondUserId))
                    ||(chat.getFirstUser().getId().equals(secondUserId) && chat.getSecondUser().getId().equals(firstUserId))){
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

    @Override
    public List<Integer> countUnseenMessages(List<ChatDTO> chats, UserDTO receiver) {
       List<Integer> amountsOfUnseenMessages = new ArrayList<>();



    }

}
