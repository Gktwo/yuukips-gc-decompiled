package com.mongodb;

import com.mongodb.annotations.ThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.lang.NonNull;
import java.util.concurrent.TimeUnit;
import javax.security.auth.Subject;
import javax.security.auth.kerberos.KerberosTicket;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/KerberosSubjectProvider.class */
public class KerberosSubjectProvider implements SubjectProvider {
    private static final Logger LOGGER = Loggers.getLogger("authenticator");
    private static final String TGT_PREFIX = "krbtgt/";
    private final String loginContextName;
    private Subject subject;

    public KerberosSubjectProvider() {
        this("com.sun.security.jgss.krb5.initiate");
    }

    public KerberosSubjectProvider(@NonNull String loginContextName) {
        this.loginContextName = (String) Assertions.notNull("loginContextName", loginContextName);
    }

    @Override // com.mongodb.SubjectProvider
    @NonNull
    public synchronized Subject getSubject() throws LoginException {
        if (this.subject == null || needNewSubject(this.subject)) {
            LOGGER.info("Creating new LoginContext and logging in the principal");
            LoginContext loginContext = new LoginContext(this.loginContextName);
            loginContext.login();
            this.subject = loginContext.getSubject();
            LOGGER.info("Login successful");
        }
        return this.subject;
    }

    private static boolean needNewSubject(@NonNull Subject subject) {
        for (KerberosTicket cur : subject.getPrivateCredentials(KerberosTicket.class)) {
            if (cur.getServer().getName().startsWith(TGT_PREFIX)) {
                if (System.currentTimeMillis() <= cur.getEndTime().getTime() - TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES)) {
                    return false;
                }
                LOGGER.info("The TGT is close to expiring. Time to reacquire.");
                return true;
            }
        }
        return false;
    }
}
