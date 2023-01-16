package org.quartz.jobs.p027ee.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* renamed from: org.quartz.jobs.ee.mail.SendMailJob */
/* loaded from: grasscutter.jar:org/quartz/jobs/ee/mail/SendMailJob.class */
public class SendMailJob implements Job {
    private final Logger log = LoggerFactory.getLogger(getClass());
    public static final String PROP_SMTP_HOST = "smtp_host";
    public static final String PROP_RECIPIENT = "recipient";
    public static final String PROP_CC_RECIPIENT = "cc_recipient";
    public static final String PROP_SENDER = "sender";
    public static final String PROP_REPLY_TO = "reply_to";
    public static final String PROP_SUBJECT = "subject";
    public static final String PROP_MESSAGE = "message";
    public static final String PROP_CONTENT_TYPE = "content_type";
    public static final String PROP_USERNAME = "username";
    public static final String PROP_PASSWORD = "password";

    @Override // org.quartz.Job
    public void execute(JobExecutionContext context) throws JobExecutionException {
        MailInfo mailInfo = populateMailInfo(context.getMergedJobDataMap(), createMailInfo());
        getLog().info("Sending message " + mailInfo);
        try {
            Transport.send(prepareMimeMessage(mailInfo));
        } catch (MessagingException e) {
            throw new JobExecutionException("Unable to send mail: " + mailInfo, e, false);
        }
    }

    protected Logger getLog() {
        return this.log;
    }

    protected MimeMessage prepareMimeMessage(MailInfo mailInfo) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(getMailSession(mailInfo));
        mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailInfo.getTo()));
        if (mailInfo.getCc() != null) {
            mimeMessage.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailInfo.getCc()));
        }
        mimeMessage.setFrom(new InternetAddress(mailInfo.getFrom()));
        if (mailInfo.getReplyTo() != null) {
            mimeMessage.setReplyTo(new InternetAddress[]{new InternetAddress(mailInfo.getReplyTo())});
        }
        mimeMessage.setSubject(mailInfo.getSubject());
        mimeMessage.setSentDate(new Date());
        setMimeMessageContent(mimeMessage, mailInfo);
        return mimeMessage;
    }

    protected void setMimeMessageContent(MimeMessage mimeMessage, MailInfo mailInfo) throws MessagingException {
        if (mailInfo.getContentType() == null) {
            mimeMessage.setText(mailInfo.getMessage());
        } else {
            mimeMessage.setContent(mailInfo.getMessage(), mailInfo.getContentType());
        }
    }

    protected Session getMailSession(final MailInfo mailInfo) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", mailInfo.getSmtpHost());
        Properties extraSettings = mailInfo.getSmtpProperties();
        if (extraSettings != null) {
            properties.putAll(extraSettings);
        }
        Authenticator authenticator = null;
        if (!(mailInfo.getUsername() == null || mailInfo.getPassword() == null)) {
            this.log.info("using username '{}' and password 'xxx'", mailInfo.getUsername());
            authenticator = new Authenticator() { // from class: org.quartz.jobs.ee.mail.SendMailJob.1
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailInfo.getUsername(), mailInfo.getPassword());
                }
            };
        }
        this.log.debug("Sending mail with properties: {}", properties);
        return Session.getDefaultInstance(properties, authenticator);
    }

    protected MailInfo createMailInfo() {
        return new MailInfo();
    }

    protected MailInfo populateMailInfo(JobDataMap data, MailInfo mailInfo) {
        mailInfo.setSmtpHost(getRequiredParm(data, PROP_SMTP_HOST, "PROP_SMTP_HOST"));
        mailInfo.setTo(getRequiredParm(data, PROP_RECIPIENT, "PROP_RECIPIENT"));
        mailInfo.setFrom(getRequiredParm(data, PROP_SENDER, "PROP_SENDER"));
        mailInfo.setSubject(getRequiredParm(data, PROP_SUBJECT, "PROP_SUBJECT"));
        mailInfo.setMessage(getRequiredParm(data, PROP_MESSAGE, "PROP_MESSAGE"));
        mailInfo.setReplyTo(getOptionalParm(data, PROP_REPLY_TO));
        mailInfo.setCc(getOptionalParm(data, PROP_CC_RECIPIENT));
        mailInfo.setContentType(getOptionalParm(data, PROP_CONTENT_TYPE));
        mailInfo.setUsername(getOptionalParm(data, PROP_USERNAME));
        mailInfo.setPassword(getOptionalParm(data, "password"));
        Properties smtpProperties = new Properties();
        for (String key : data.keySet()) {
            if (key.startsWith("mail.smtp.")) {
                smtpProperties.put(key, data.getString(key));
            }
        }
        if (mailInfo.getSmtpProperties() == null) {
            mailInfo.setSmtpProperties(smtpProperties);
        } else {
            mailInfo.getSmtpProperties().putAll(smtpProperties);
        }
        return mailInfo;
    }

    protected String getRequiredParm(JobDataMap data, String property, String constantName) {
        String value = getOptionalParm(data, property);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(constantName + " not specified.");
    }

    protected String getOptionalParm(JobDataMap data, String property) {
        String value = data.getString(property);
        if (value == null || value.trim().length() != 0) {
            return value;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: org.quartz.jobs.ee.mail.SendMailJob$MailInfo */
    /* loaded from: grasscutter.jar:org/quartz/jobs/ee/mail/SendMailJob$MailInfo.class */
    public static class MailInfo {
        private String smtpHost;

        /* renamed from: to */
        private String f3374to;
        private String from;
        private String subject;
        private String message;
        private String replyTo;

        /* renamed from: cc */
        private String f3375cc;
        private String contentType;
        private String username;
        private String password;
        private Properties smtpProperties;

        protected MailInfo() {
        }

        public String toString() {
            return "'" + getSubject() + "' to: " + getTo();
        }

        public String getCc() {
            return this.f3375cc;
        }

        public void setCc(String cc) {
            this.f3375cc = cc;
        }

        public String getContentType() {
            return this.contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getReplyTo() {
            return this.replyTo;
        }

        public void setReplyTo(String replyTo) {
            this.replyTo = replyTo;
        }

        public String getSmtpHost() {
            return this.smtpHost;
        }

        public void setSmtpHost(String smtpHost) {
            this.smtpHost = smtpHost;
        }

        public String getSubject() {
            return this.subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTo() {
            return this.f3374to;
        }

        public void setTo(String to) {
            this.f3374to = to;
        }

        public Properties getSmtpProperties() {
            return this.smtpProperties;
        }

        public void setSmtpProperties(Properties smtpProperties) {
            this.smtpProperties = smtpProperties;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
