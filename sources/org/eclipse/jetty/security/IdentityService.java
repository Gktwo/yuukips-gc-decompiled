package org.eclipse.jetty.security;

import java.security.Principal;
import javax.security.auth.Subject;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/IdentityService.class */
public interface IdentityService {
    public static final String[] NO_ROLES = new String[0];

    Object associate(UserIdentity userIdentity);

    void disassociate(Object obj);

    Object setRunAs(UserIdentity userIdentity, RunAsToken runAsToken);

    void unsetRunAs(Object obj);

    UserIdentity newUserIdentity(Subject subject, Principal principal, String[] strArr);

    RunAsToken newRunAsToken(String str);

    UserIdentity getSystemUserIdentity();
}
