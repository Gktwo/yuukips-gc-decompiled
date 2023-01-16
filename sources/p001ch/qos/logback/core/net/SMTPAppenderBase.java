package p001ch.qos.logback.core.net;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import p001ch.qos.logback.core.AppenderBase;
import p001ch.qos.logback.core.Layout;
import p001ch.qos.logback.core.boolex.EvaluationException;
import p001ch.qos.logback.core.boolex.EventEvaluator;
import p001ch.qos.logback.core.helpers.CyclicBuffer;
import p001ch.qos.logback.core.pattern.PatternLayoutBase;
import p001ch.qos.logback.core.sift.DefaultDiscriminator;
import p001ch.qos.logback.core.sift.Discriminator;
import p001ch.qos.logback.core.spi.CyclicBufferTracker;
import p001ch.qos.logback.core.util.ContentTypeUtil;
import p001ch.qos.logback.core.util.JNDIUtil;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.net.SMTPAppenderBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/SMTPAppenderBase.class */
public abstract class SMTPAppenderBase<E> extends AppenderBase<E> {
    static InternetAddress[] EMPTY_IA_ARRAY = new InternetAddress[0];
    static final long MAX_DELAY_BETWEEN_STATUS_MESSAGES = 1228800000;
    protected Layout<E> subjectLayout;
    protected Layout<E> layout;
    private String from;
    private String smtpHost;
    String username;
    String password;
    String localhost;
    protected Session session;
    protected EventEvaluator<E> eventEvaluator;
    protected CyclicBufferTracker<E> cbTracker;
    long lastTrackerStatusPrint = 0;
    long delayBetweenStatusMessages = 300000;
    private List<PatternLayoutBase<E>> toPatternLayoutList = new ArrayList();
    private String subjectStr = null;
    private int smtpPort = 25;
    private boolean starttls = false;
    private boolean ssl = false;
    private boolean sessionViaJNDI = false;
    private String jndiLocation = "java:comp/env/mail/Session";
    boolean asynchronousSending = true;
    private String charsetEncoding = "UTF-8";
    protected Discriminator<E> discriminator = new DefaultDiscriminator();
    private int errorCount = 0;

    protected abstract Layout<E> makeSubjectLayout(String str);

    protected abstract boolean eventMarksEndOfLife(E e);

    protected abstract void subAppend(CyclicBuffer<E> cyclicBuffer, E e);

    protected abstract void fillBuffer(CyclicBuffer<E> cyclicBuffer, StringBuffer stringBuffer);

    protected abstract PatternLayoutBase<E> makeNewToPatternLayout(String str);

    @Override // p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.cbTracker == null) {
            this.cbTracker = new CyclicBufferTracker<>();
        }
        if (this.sessionViaJNDI) {
            this.session = lookupSessionInJNDI();
        } else {
            this.session = buildSessionFromProperties();
        }
        if (this.session == null) {
            addError("Failed to obtain javax.mail.Session. Cannot start.");
            return;
        }
        this.subjectLayout = makeSubjectLayout(this.subjectStr);
        this.started = true;
    }

    private Session lookupSessionInJNDI() {
        addInfo("Looking up javax.mail.Session at JNDI location [" + this.jndiLocation + "]");
        try {
            return (Session) JNDIUtil.lookupObject(JNDIUtil.getInitialContext(), this.jndiLocation);
        } catch (Exception e) {
            addError("Failed to obtain javax.mail.Session from JNDI location [" + this.jndiLocation + "]");
            return null;
        }
    }

    private Session buildSessionFromProperties() {
        Properties props = new Properties(OptionHelper.getSystemProperties());
        if (this.smtpHost != null) {
            props.put("mail.smtp.host", this.smtpHost);
        }
        props.put("mail.smtp.port", Integer.toString(this.smtpPort));
        if (this.localhost != null) {
            props.put("mail.smtp.localhost", this.localhost);
        }
        Authenticator authenticator = null;
        if (!OptionHelper.isEmpty(this.username)) {
            authenticator = new LoginAuthenticator(this.username, this.password);
            props.put("mail.smtp.auth", C3P0Substitutions.DEBUG);
        }
        if (!isSTARTTLS() || !isSSL()) {
            if (isSTARTTLS()) {
                props.put("mail.smtp.starttls.enable", C3P0Substitutions.DEBUG);
            }
            if (isSSL()) {
                props.put("mail.smtp.socketFactory.port", Integer.toString(this.smtpPort));
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.fallback", C3P0Substitutions.DEBUG);
            }
        } else {
            addError("Both SSL and StartTLS cannot be enabled simultaneously");
        }
        return Session.getInstance(props, authenticator);
    }

    @Override // p001ch.qos.logback.core.AppenderBase
    protected void append(E eventObject) {
        if (checkEntryConditions()) {
            String key = this.discriminator.getDiscriminatingValue(eventObject);
            long now = System.currentTimeMillis();
            CyclicBuffer<E> cb = this.cbTracker.getOrCreate(key, now);
            subAppend(cb, eventObject);
            try {
                if (this.eventEvaluator.evaluate(eventObject)) {
                    CyclicBuffer<E> cbClone = new CyclicBuffer<>(cb);
                    cb.clear();
                    if (this.asynchronousSending) {
                        this.context.getScheduledExecutorService().execute(new SenderRunnable(cbClone, eventObject));
                    } else {
                        sendBuffer(cbClone, eventObject);
                    }
                }
            } catch (EvaluationException ex) {
                this.errorCount++;
                if (this.errorCount < 4) {
                    addError("SMTPAppender's EventEvaluator threw an Exception-", ex);
                }
            }
            if (eventMarksEndOfLife(eventObject)) {
                this.cbTracker.endOfLife(key);
            }
            this.cbTracker.removeStaleComponents(now);
            if (this.lastTrackerStatusPrint + this.delayBetweenStatusMessages < now) {
                addInfo("SMTPAppender [" + this.name + "] is tracking [" + this.cbTracker.getComponentCount() + "] buffers");
                this.lastTrackerStatusPrint = now;
                if (this.delayBetweenStatusMessages < MAX_DELAY_BETWEEN_STATUS_MESSAGES) {
                    this.delayBetweenStatusMessages *= 4;
                }
            }
        }
    }

    public boolean checkEntryConditions() {
        if (!this.started) {
            addError("Attempting to append to a non-started appender: " + getName());
            return false;
        } else if (this.eventEvaluator == null) {
            addError("No EventEvaluator is set for appender [" + this.name + "].");
            return false;
        } else if (this.layout != null) {
            return true;
        } else {
            addError("No layout set for appender named [" + this.name + "]. For more information, please visit http://logback.qos.ch/codes.html#smtp_no_layout");
            return false;
        }
    }

    @Override // p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public synchronized void stop() {
        this.started = false;
    }

    InternetAddress getAddress(String addressStr) {
        try {
            return new InternetAddress(addressStr);
        } catch (AddressException e) {
            addError("Could not parse address [" + addressStr + "].", e);
            return null;
        }
    }

    private List<InternetAddress> parseAddress(E event) {
        int len = this.toPatternLayoutList.size();
        List<InternetAddress> iaList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            try {
                String emailAdrr = this.toPatternLayoutList.get(i).doLayout(event);
                if (emailAdrr != null && emailAdrr.length() != 0) {
                    iaList.addAll(Arrays.asList(InternetAddress.parse(emailAdrr, true)));
                }
            } catch (AddressException e) {
                addError("Could not parse email address for [" + this.toPatternLayoutList.get(i) + "] for event [" + event + "]", e);
                return iaList;
            }
        }
        return iaList;
    }

    public List<PatternLayoutBase<E>> getToList() {
        return this.toPatternLayoutList;
    }

    protected void sendBuffer(CyclicBuffer<E> cb, E lastEventObject) {
        try {
            MimeBodyPart part = new MimeBodyPart();
            StringBuffer sbuf = new StringBuffer();
            String header = this.layout.getFileHeader();
            if (header != null) {
                sbuf.append(header);
            }
            String presentationHeader = this.layout.getPresentationHeader();
            if (presentationHeader != null) {
                sbuf.append(presentationHeader);
            }
            fillBuffer(cb, sbuf);
            String presentationFooter = this.layout.getPresentationFooter();
            if (presentationFooter != null) {
                sbuf.append(presentationFooter);
            }
            String footer = this.layout.getFileFooter();
            if (footer != null) {
                sbuf.append(footer);
            }
            String subjectStr = "Undefined subject";
            if (this.subjectLayout != null) {
                subjectStr = this.subjectLayout.doLayout(lastEventObject);
                int newLinePos = subjectStr != null ? subjectStr.indexOf(10) : -1;
                if (newLinePos > -1) {
                    subjectStr = subjectStr.substring(0, newLinePos);
                }
            }
            MimeMessage mimeMsg = new MimeMessage(this.session);
            if (this.from != null) {
                mimeMsg.setFrom(getAddress(this.from));
            } else {
                mimeMsg.setFrom();
            }
            mimeMsg.setSubject(subjectStr, this.charsetEncoding);
            List<InternetAddress> destinationAddresses = parseAddress(lastEventObject);
            if (destinationAddresses.isEmpty()) {
                addInfo("Empty destination address. Aborting email transmission");
                return;
            }
            InternetAddress[] toAddressArray = (InternetAddress[]) destinationAddresses.toArray(EMPTY_IA_ARRAY);
            mimeMsg.setRecipients(Message.RecipientType.TO, toAddressArray);
            String contentType = this.layout.getContentType();
            if (ContentTypeUtil.isTextual(contentType)) {
                part.setText(sbuf.toString(), this.charsetEncoding, ContentTypeUtil.getSubType(contentType));
            } else {
                part.setContent(sbuf.toString(), this.layout.getContentType());
            }
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(part);
            mimeMsg.setContent(mp);
            mimeMsg.setSentDate(new Date());
            addInfo("About to send out SMTP message \"" + subjectStr + "\" to " + Arrays.toString(toAddressArray));
            Transport.send(mimeMsg);
        } catch (Exception e) {
            addError("Error occurred while sending e-mail notification.", e);
        }
    }

    public String getFrom() {
        return this.from;
    }

    public String getSubject() {
        return this.subjectStr;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubject(String subject) {
        this.subjectStr = subject;
    }

    public void setSMTPHost(String smtpHost) {
        setSmtpHost(smtpHost);
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSMTPHost() {
        return getSmtpHost();
    }

    public String getSmtpHost() {
        return this.smtpHost;
    }

    public void setSMTPPort(int port) {
        setSmtpPort(port);
    }

    public void setSmtpPort(int port) {
        this.smtpPort = port;
    }

    public int getSMTPPort() {
        return getSmtpPort();
    }

    public int getSmtpPort() {
        return this.smtpPort;
    }

    public String getLocalhost() {
        return this.localhost;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    public CyclicBufferTracker<E> getCyclicBufferTracker() {
        return this.cbTracker;
    }

    public void setCyclicBufferTracker(CyclicBufferTracker<E> cbTracker) {
        this.cbTracker = cbTracker;
    }

    public Discriminator<E> getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(Discriminator<E> discriminator) {
        this.discriminator = discriminator;
    }

    public boolean isAsynchronousSending() {
        return this.asynchronousSending;
    }

    public void setAsynchronousSending(boolean asynchronousSending) {
        this.asynchronousSending = asynchronousSending;
    }

    public void addTo(String to) {
        if (to == null || to.length() == 0) {
            throw new IllegalArgumentException("Null or empty <to> property");
        }
        PatternLayoutBase<E> plb = makeNewToPatternLayout(to.trim());
        plb.setContext(this.context);
        plb.start();
        this.toPatternLayoutList.add(plb);
    }

    public List<String> getToAsListOfString() {
        List<String> toList = new ArrayList<>();
        for (PatternLayoutBase<E> plb : this.toPatternLayoutList) {
            toList.add(plb.getPattern());
        }
        return toList;
    }

    public boolean isSTARTTLS() {
        return this.starttls;
    }

    public void setSTARTTLS(boolean startTLS) {
        this.starttls = startTLS;
    }

    public boolean isSSL() {
        return this.ssl;
    }

    public void setSSL(boolean ssl) {
        this.ssl = ssl;
    }

    public void setEvaluator(EventEvaluator<E> eventEvaluator) {
        this.eventEvaluator = eventEvaluator;
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

    public String getCharsetEncoding() {
        return this.charsetEncoding;
    }

    public String getJndiLocation() {
        return this.jndiLocation;
    }

    public void setJndiLocation(String jndiLocation) {
        this.jndiLocation = jndiLocation;
    }

    public boolean isSessionViaJNDI() {
        return this.sessionViaJNDI;
    }

    public void setSessionViaJNDI(boolean sessionViaJNDI) {
        this.sessionViaJNDI = sessionViaJNDI;
    }

    public void setCharsetEncoding(String charsetEncoding) {
        this.charsetEncoding = charsetEncoding;
    }

    public Layout<E> getLayout() {
        return this.layout;
    }

    public void setLayout(Layout<E> layout) {
        this.layout = layout;
    }

    /* renamed from: ch.qos.logback.core.net.SMTPAppenderBase$SenderRunnable */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/net/SMTPAppenderBase$SenderRunnable.class */
    class SenderRunnable implements Runnable {
        final CyclicBuffer<E> cyclicBuffer;

        /* renamed from: e */
        final E f11e;

        SenderRunnable(CyclicBuffer<E> cyclicBuffer, E e) {
            this.cyclicBuffer = cyclicBuffer;
            this.f11e = e;
        }

        @Override // java.lang.Runnable
        public void run() {
            SMTPAppenderBase.this.sendBuffer(this.cyclicBuffer, this.f11e);
        }
    }
}
