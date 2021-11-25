package com.company.hiringapp.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
//@AllArgsConstructor
public class ChatDTO extends AbstractDTO{
    private UserDTO firstUser;
    private UserDTO secondUser;
    private List<MessageDTO> messages;

    public ChatDTO(UserDTO firstUser, UserDTO secondUser){
        this.firstUser=firstUser;
        this.secondUser=secondUser;
    }
}
