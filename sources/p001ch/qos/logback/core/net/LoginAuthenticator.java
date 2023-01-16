package p001ch.qos.logback.core.net;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* renamed from: ch.qos.logback.core.net.LoginAuthenticator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/LoginAuthenticator.class */
public class LoginAuthenticator extends Authenticator {
    String username;
    String password;

    /* access modifiers changed from: package-private */
    public LoginAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }
}
