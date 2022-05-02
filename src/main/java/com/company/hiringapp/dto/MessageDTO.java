package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class MessageDTO extends AbstractDTO{
    private String message;
    private ChatDTO chat;
    private UserDTO sender;
    private LocalDateTime sendDateTime;
    private boolean isSeen;
}
