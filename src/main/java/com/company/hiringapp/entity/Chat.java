package com.company.hiringapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chats")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Chat extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "first_user_id")
    private User firstUser;
    @ManyToOne
    @JoinColumn(name = "second_user_id")
    private User secondUser;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Message> messages;

}
