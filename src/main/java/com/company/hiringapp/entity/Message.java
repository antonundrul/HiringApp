package com.company.hiringapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Message extends AbstractEntity {
    @Column(name = "message")
    private String message;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id")
    private Chat chat;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @Column(name = "send_date_time")
    private LocalDateTime sendDateTime;
    @Column(name = "seen")
    private boolean isSeen;
}
