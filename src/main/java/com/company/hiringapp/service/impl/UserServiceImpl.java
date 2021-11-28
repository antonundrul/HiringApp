package com.company.hiringapp.service.impl;



import com.company.hiringapp.dto.PageWrapper;
import com.company.hiringapp.dto.SignUpRequest;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.UserDTOwithPhoto;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.entity.User;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.repository.RoleRepository;
import com.company.hiringapp.repository.UserRepository;
import com.company.hiringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) {

        if (!(signUpRequest.getPassword().equals(signUpRequest.getPasswordConfirm()))) {
            throw new ServiceException("Пароль не совпал с подтверждённым паролем!");
        }

        UserDTO userDto = new UserDTO();
        userDto.setUsername(signUpRequest.getUsername());
        userDto.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userDto.setEmail(signUpRequest.getEmail());
        userDto.setFirstName(signUpRequest.getFirstName());
        userDto.setLastName(signUpRequest.getLastName());
        userDto.setEmail(signUpRequest.getEmail());
        this.save(userDto);
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO userDto) {

        userRepository.findByUsername(userDto.getUsername())
                .ifPresent(value -> {
                    throw new ServiceException("Пользователь с таким именем пользователя уже существует!");
                });

        userRepository.findByEmail(userDto.getEmail())
                .ifPresent(value -> {
                    throw new ServiceException("Электронная почта " + value.getEmail() + " занята!");
                });

        User user = userMapper.toEntity(userDto);

        user.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")));
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ServiceException("Пользователь с таким именем пользователя не найден!"));

        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void update(UserDTO userDto) {

        User user = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new ServiceException("Пользователь не найден!"));

        if (!user.getEmail().equals(userDto.getEmail())) {
            userRepository.findByEmail(userDto.getEmail())
                    .ifPresent(value -> {
                        throw new ServiceException("Электронная почта " + value.getEmail() + " занята!");
                    });
        }

        UserDTO dto = userMapper.toDto(user);


        dto.setEmail(userDto.getEmail());
        dto.setFirstName(userDto.getFirstName());
        dto.setLastName(userDto.getLastName());
        dto.setAvatar(userDto.getAvatar());






       /* try {
            dto.setImage(userDto.getImageUpdate().getBytes());
        } catch (Exception ignore) {
        }*/
        if (Objects.nonNull(userDto.getRoles())) {
            dto.setRoles(userDto.getRoles());
        }
        if (Objects.nonNull(userDto.getBlocked())) {
            dto.setBlocked(userDto.getBlocked());
        }
        userRepository.save(userMapper.toEntity(dto));
//        userRepository.save(user1);
    }

    @Override
    public PageWrapper<UserDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<User> users = userRepository.findAll(pageable);

        return new PageWrapper<>(userMapper.toDtoList(users.toList()), users.getTotalPages(), users.getTotalElements());
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO convertUserDTOwithPhoto(UserDTOwithPhoto withPhoto) {
        UserDTO newDto = new UserDTO();
        newDto.setUsername(withPhoto.getUsername());
        newDto.setPassword(withPhoto.getPassword());
        newDto.setLastName(withPhoto.getLastName());
        newDto.setFirstName(withPhoto.getFirstName());
        newDto.setEmail(withPhoto.getEmail());
        newDto.setId(withPhoto.getId());
        newDto.setAvatar(withPhoto.getAvatar().getOriginalFilename());

        return newDto;
    }

    @Override
    public UserDTOwithPhoto convertUserDTO(UserDTO dto) {
        UserDTOwithPhoto withPhoto = new UserDTOwithPhoto();
        File file = new File("C:/Bsuir/7sem/coursework/HiringApp/src/main/webapp/resources/images"+ dto.getAvatar());

        withPhoto.setId(dto.getId());
        withPhoto.setUsername(dto.getUsername());
        withPhoto.setLastName(dto.getLastName());
        withPhoto.setFirstName(dto.getFirstName());
        withPhoto.setPassword(dto.getPassword());
        withPhoto.setEmail(dto.getEmail());
        withPhoto.setAvatarName(dto.getAvatar());

        return withPhoto;
    }
}
