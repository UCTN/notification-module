package com.deneme.mail.repository;

import com.deneme.mail.entity.Email;
import com.deneme.mail.entity.enums.MailStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    public List<Email> findAllByMailStatus(MailStatus mailStatus);
}
