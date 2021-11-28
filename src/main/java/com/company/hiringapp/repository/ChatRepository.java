package com.company.hiringapp.repository;

import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.Chat;
import com.company.hiringapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    Optional<Chat> findById(Long id);

    List<Chat> findByFirstUser(User firstUser);
    List<Chat> findBySecondUser(User seconduserUser);

}
