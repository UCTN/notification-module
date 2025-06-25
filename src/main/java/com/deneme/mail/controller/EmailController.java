package com.deneme.mail.controller;

import com.deneme.mail.dto.EmailRequest;
import com.deneme.mail.dto.EmailResponse;
import com.deneme.mail.service.EmailService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/email")
@Validated
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully");
    }

    @GetMapping("getAllEmails")
    public ResponseEntity<List<EmailResponse>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @GetMapping("get-all-emails-by-mail-status/{mailStatus}")
    public ResponseEntity<List<EmailResponse>> getAllEmailsByMailStatus(@PathVariable String mailStatus) {
        return ResponseEntity.ok(emailService.getAllEmailsByMailStatus(mailStatus));
    }
}
