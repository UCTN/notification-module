package com.deneme.mail.entity.enums;

public enum MailStatus {

    SENDING("Sending"),
    SENT("Sent"),
    FAILED("Failed");

    private final String status;

    MailStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
