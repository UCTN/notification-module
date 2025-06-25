package com.deneme.mail.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmailRequest {

    @NotBlank
    private String mailContentType;

    private String sendPdf;

    @NotBlank
    private String mailAddress;
    private String subject;
    private String messageBody;
    private String title;
    private String body;

    private UserEmailRequest userEmailRequest;


    public EmailRequest(String mailContentType, String sendPdf, String mailAddress,
                        String title, String messageBody, UserEmailRequest userEmailRequest) {
        this.mailContentType = mailContentType;
        this.sendPdf = sendPdf;
        this.mailAddress = mailAddress;
        this.title = title;
        this.messageBody = messageBody;
        this.userEmailRequest = userEmailRequest;
    }
}

