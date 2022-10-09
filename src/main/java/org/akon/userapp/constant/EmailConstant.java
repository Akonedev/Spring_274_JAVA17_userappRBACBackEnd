package org.akon.userapp.constant;

public class EmailConstant {

    public static final String SIMPLE_MAIL_TRANSFER_PROTOCOL_GMAIL = "smtps";
    public static final String SIMPLE_MAIL_TRANSFER_PROTOCOL_OUTLOOK = "smtp";
    public static final String USERNAME = "your_email";
    public static final String PASSWORD = "your_password";
    public static final String FROM_EMAIL = "your_email";
    public static final String CC_EMAIL = "";
    public static final String EMAIL_SUBJECT = "Get Arrays, LLC - New Password";
    public static final String GMAIL_SMTP_SERVER = "smtp.gmail.com";
    public static final String OUTLOOK_SMTP_SERVER = "smtp.office365.com";
    public static final String SMTP_HOST = "mail.smtp.host";
    public static final String SMTP_AUTH = "mail.smtp.auth";
    public static final String SMTP_PORT = "mail.smtp.port";
    public static final int DEFAULT_PORT_GMAIL = 465;
    public static final int DEFAULT_PORT_OUTLOOK = 587;
    public static final String SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static final String SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";
    public static final String DEFAULT_MESSAGE_NEW_PASSWORD = "Hello %s," +
            "\n\n Your new account password is: %s" +
            "\n\n The Support Team";

}
