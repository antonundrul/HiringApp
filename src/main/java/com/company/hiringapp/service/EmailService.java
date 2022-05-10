package com.company.hiringapp.service;

import java.nio.file.Path;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
    void sendMessageWithAttachment(String to, String subject,
                                   String text, Path pathToAttachment);
}
