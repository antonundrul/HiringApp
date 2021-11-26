package com.company.hiringapp.controller;

import com.company.hiringapp.dto.ChatDTO;
import com.company.hiringapp.dto.MessageDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.mapper.ChatMapper;
import com.company.hiringapp.dto.mapper.MessageMapper;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.service.ChatService;
import com.company.hiringapp.service.MessageService;
import com.company.hiringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static com.company.hiringapp.controller.ControllerHelper.*;

@Controller
public class ChatController {
    private ChatService chatService;
    private ChatMapper chatMapper;
    private MessageService messageService;
    private MessageMapper messageMapper;
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public ChatController(ChatService chatService,
                          ChatMapper chatMapper,
                          MessageService messageService,
                          MessageMapper messageMapper,
                          UserService userService,
                          UserMapper userMapper){
        this.chatService=chatService;
        this.chatMapper=chatMapper;
        this.messageService=messageService;
        this.messageMapper=messageMapper;
        this.userService = userService;
        this.userMapper=userMapper;
    }


    @GetMapping("/chats")
    public ModelAndView getChats(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("chat/chats");
        UserDTO userDTO = userService.findByUsername(principal.getName());

        HashMap<UserDTO,ChatDTO> chats = chatService.getChats(userDTO);
        modelAndView.addObject("chats",chats);

        return modelAndView;
    }

    @GetMapping("/chats/chatWith/{toUser}")
    public ModelAndView getMessages(@PathVariable(name = "toUser") Long toUserId,
                                Principal principal){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("chat/chatWith");
        UserDTO userDTO = userService.findByUsername(principal.getName());
        UserDTO toUserDTO = userService.findById(toUserId);

        HashMap<UserDTO,ChatDTO> chats = chatService.getChats(userDTO);
        modelAndView.addObject("chats",chats);
        modelAndView.addObject("toUser",toUserDTO);
        modelAndView.addObject("messageForm",new MessageDTO());
        ChatDTO chatDTO = chatService.findByUsers(userDTO.getId(),toUserId);
        if(chatDTO.getId()!=null) {
            modelAndView.addObject("messages", messageService.findByChat(chatDTO));
        }
        return modelAndView;
    }

    @PostMapping("/chats/chatWith/{toUser}")
    public String sendMessage(@PathVariable(name = "toUser") Long toUserId,
                                Model model,
                                @Validated @ModelAttribute("messageForm") MessageDTO messageDTO,
                                BindingResult bindingResult,
                                Principal principal){

        UserDTO userDTO = userService.findByUsername(principal.getName());
        ChatDTO chat = chatService.findByUsers(toUserId,userDTO.getId());
        if(chat.getId()==null) {
            ChatDTO newChat = new ChatDTO(userDTO, userService.findById(toUserId));
            chatService.save(newChat);

            newChat = chatService.findByUsers(userDTO.getId(),toUserId);
            messageDTO.setChat(newChat);
        }
        else {
            messageDTO.setChat(chat);
        }
        messageDTO.setSender(userDTO);
        messageDTO.setSendDateTime(LocalDateTime.now());
        messageService.save(messageDTO);


        return redirectTo("chats/chatWith/"+toUserId);
    }

    @GetMapping("/chats/delete/{id}")
    public String delete(@PathVariable Long id, Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());
        ChatDTO chatDTO = chatService.findByUsers(userDTO.getId(), id);

        List<MessageDTO> messages = messageService.findByChat(chatDTO);
                for(MessageDTO message:messages){
                    messageService.delete(message.getId());
                }
        chatService.delete(chatDTO.getId());
        return redirectTo("chats");
    }
}
