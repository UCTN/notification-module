package com.deneme.mail.service;

import com.deneme.mail.dto.EmailRequest;
import com.deneme.mail.dto.EmailResponse;
import com.deneme.mail.dto.UserResponse;
import com.deneme.mail.entity.Email;
import com.deneme.mail.entity.enums.MailStatus;
import com.deneme.mail.repository.EmailRepository;
import com.deneme.mail.service.base.AbstractService;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class EmailService extends AbstractService<Email>{

    private final EmailRepository emailRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    protected EmailRepository getRepository() { return emailRepository;}

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    public void sendEmail(EmailRequest emailRequest) {

        Email email = new Email();
        email.setMailStatus(MailStatus.SENDING);// email içeriğini hazırlar
        email.setRecipientMail(emailRequest.getMailAddress());
        email.setSubject(emailRequest.getSubject());
        email.setMessageBody(emailRequest.getMessageBody());

        try{
            Session session = getMailProperties(); //stmp protokülü için gerekli ayarları yapar
            MimeMessage notification = new MimeMessage(session); // mail içeriğini oluşturur
            notification.setSubject(email.getSubject());
            notification.setFrom(new InternetAddress(username));
            notification.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getRecipientMail()));

            if(emailRequest.getMailContentType().equals("pdf") && emailRequest.getSendPdf() != null && !emailRequest.getSendPdf().isEmpty()){ // eğer mail içeriği pdf ise burada pdfi maile ekliyoruz

                String htmlCreator = htmlCreator(email.getSubject(), email.getMessageBody());
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(htmlCreator, "text/html; charset=utf-8");


                BodyPart messageBodyPart = new MimeBodyPart(); //body part ile mailde önceden belirlediğimiz mesajı ekliyoruz
                messageBodyPart.setText(email.getMessageBody());

                Multipart multipart = new MimeMultipart(); //sonrasında bir pdf bir de text olacağından dolayı multipart kullanıyoruz
                multipart.addBodyPart(messageBodyPart); //texti bodye ekliyoruz
                messageBodyPart = new MimeBodyPart(); //sonra pdfi bodye ekliyoruz
                DataSource source = new FileDataSource(emailRequest.getSendPdf());
                messageBodyPart.setDataHandler(new DataHandler(source));

                if (emailRequest.getPdfFileName() != null && !emailRequest.getPdfFileName().isEmpty()) {
                    messageBodyPart.setFileName(emailRequest.getPdfFileName());
                }
                else{
                    messageBodyPart.setFileName("ek" + LocalDateTime.now() + ".pdf");
                }

                multipart.addBodyPart(messageBodyPart);

                notification.setContent(multipart); // son olarak mail içeriğini multipart olarak ayarlıyoruz
                email.setAttachment(emailRequest.getSendPdf());
            }

            else if (emailRequest.getMailContentType().equals("text/html")) {
                String htmlContent = htmlCreator(email.getSubject(), email.getMessageBody());
                notification.setContent(htmlContent, "text/html; charset=utf-8");
                email.setAttachment(null);
            }

            else{
                String htmlContent = htmlCreator(email.getSubject(), email.getMessageBody());
                notification.setContent(htmlContent, "text/plain; charset=utf-8");
                email.setAttachment(null); //pdf olmadığı için attachmentı null yapıyoruz
            }
            Transport.send(notification);
            email.setMailStatus(MailStatus.SENT);
            email.setSentDate(LocalDateTime.now());
            emailRepository.save(email);

            // Log
            String timestamp = getLocalDateTimeNow();
            String className = getClass().getSimpleName();
            String message = "[" + className +"] ["+ timestamp + "] " + emailRequest.getMailAddress() +" mail adresine bilgilendirme maili gönderildi.";
            System.out.println(message);
            log.debug(message);

        }
        catch (Exception e) {

            email.setMessageBody("Gönderim sırasında bir hata oluştu: "+ e.getMessage());
            email.setAttachment(null);
            email.setSentDate(LocalDateTime.now());
            email.setMailStatus(MailStatus.FAILED);
            emailRepository.save(email);

            log.error("Error while sending email: {}", e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }
    }

    private Session getMailProperties() {
        try {
            Properties properties = new Properties();
            properties.setProperty("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            return Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        }
        catch (Exception e) {
            log.error("Error while getting mail properties: {}", e.getMessage());
            throw new RuntimeException("Failed to get mail properties", e);
        }
    }


    private String getLocalDateTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        return timestamp;
    }

    public List<EmailResponse> getAllEmails() {
        List<Email> emails = emailRepository.findAll();
        return emails.stream()
                .map(email -> new EmailResponse(
                        email.getRecipientMail(),
                        email.getSubject(),
                        email.getMessageBody(),
                        email.getMailStatus().name(),
                        email.getSentDate()))
                .toList();
    }

    public List<EmailResponse> getAllEmailsByMailStatus(String mailStatus) {

        if (mailStatus.contains("i") || mailStatus.contains("I")) {
            mailStatus = mailStatus.replace("i", "I");
        }

        MailStatus status = MailStatus.valueOf(mailStatus.toUpperCase());
        List<Email> emails = emailRepository.findAllByMailStatus(status);
        return emails.stream()
                .map(email -> new EmailResponse(
                        email.getRecipientMail(),
                        email.getSubject(),
                        email.getMessageBody(),
                        email.getMailStatus().name(),
                        email.getSentDate()))
                .toList();
    }

    private String htmlCreator(String title, String messageBody) {
        try {


        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("templates/email_templates.html");
        if (inputStream == null) {
            log.error("Email template not found");
            throw new RuntimeException("Email template not found");
        }

        String template = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        template = template.replace("{{title}}", title);
        template = template.replace("{{messageBody}}", messageBody);

        UserResponse userResponse = userService.findByEmail(username);
        template = template.replace("{{userName}}", userResponse.getName() + " " + userResponse.getSurname());
        template = template.replace("{{userTitle}}", userResponse.getRole());
        template = template.replace("{{userEmail}}", username);

        return template;
        }

        catch (IOException e) {
            log.error("Error while reading email template: {}", e.getMessage());
            throw new RuntimeException("Failed to read email template", e);
        }
    }
}

