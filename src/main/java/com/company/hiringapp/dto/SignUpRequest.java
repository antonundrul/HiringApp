package com.company.hiringapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest {

    @NotBlank(message = "Имя пользователя не может состоять из пробелов или быть пустым!")
    @Pattern(regexp = ".{4,48}", message = "имя пользователя должно быть больше 4 но меньше 48 символов ")
    private String username;
    @NotBlank(message = "Пароль пользователя не может состоять из пробелов или быть пустым!")
    @Pattern(regexp = ".{4,12}", message = "Пароль должен быть больше 4 символов и меньше 12 ")
    private String password;
    @NotBlank(message = "Потверждение пароля пользователя не может состоять из пробелов или быть пустым!")
    @Pattern(regexp = ".{4,12}", message = "Подтверждение пароля должно быть больше 4 символов и меньше 12 ")
    private String passwordConfirm;
    @NotBlank(message = "Имя не может состоять из пробелов или быть пустым!")
    @Pattern(regexp = ".{4,48}", message = "Имя должно быть больше 4 но меньше 48 символов ")
    private String firstName;
    @NotBlank(message = "Фамилия не может состоять из пробелов или быть пустым!")
    @Pattern(regexp = ".{4,48}", message = "Фамилия должно быть больше 4 но меньше 48 символов ")
    private String lastName;
    @NotBlank(message = "Email не может состоять из пробелов или быть пустым!")
    @Pattern(regexp = ".{4,48}", message = "Email должно быть больше 4 но меньше 48 символов ")
    private String email;

    private String avatar;

    public SignUpRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
