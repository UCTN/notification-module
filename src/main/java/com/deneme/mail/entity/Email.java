package com.deneme.mail.entity;

import com.deneme.mail.entity.enums.MailStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipient_mail", nullable = false)
    private String recipientMail;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "message_body", length = 300)
    private String messageBody;

    @Column(name = "attachment")
    private String attachment;

    @Enumerated(EnumType.STRING)
    @Column(name = "mail_status", nullable = false)
    private MailStatus mailStatus;

    @Column(name = "sent_date")
    private LocalDateTime sentDate;

    public Email() {
    }

    public Email(Long id, String recipientMail, String subject, String messageBody,
                 String attachment, MailStatus mailStatus, LocalDateTime sentDate) {
        this.id = id;
        this.recipientMail = recipientMail;
        this.subject = subject;
        this.messageBody = messageBody;
        this.attachment = attachment;
        this.mailStatus = mailStatus;
        this.sentDate = sentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipientMail() {
        return recipientMail;
    }

    public void setRecipientMail(String recipientMail) {
        this.recipientMail = recipientMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public MailStatus getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(MailStatus mailStatus) {
        this.mailStatus = mailStatus;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }
}


