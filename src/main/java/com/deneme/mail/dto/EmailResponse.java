package com.deneme.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class EmailResponse {

    private String recipientMail;

    private String subject;

    private String messageBody;

    private String mailStatus;

    private LocalDateTime sendDate;

    public EmailResponse(String recipientMail, String subject, String messageBody,
                         String mailStatus, LocalDateTime sendDate) {
        this.recipientMail = recipientMail;
        this.subject = subject;
        this.messageBody = messageBody;
        this.mailStatus = mailStatus;
        this.sendDate = sendDate;
    }

}

