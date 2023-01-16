package org.eclipse.jetty.security.authentication;

import java.security.Principal;
import javax.security.auth.Subject;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/LoginCallback.class */
public interface LoginCallback {
    Subject getSubject();

    String getUserName();

    Object getCredential();

    boolean isSuccess();

    void setSuccess(boolean z);

    Principal getUserPrincipal();

    void setUserPrincipal(Principal principal);

    String[] getRoles();

    void setRoles(String[] strArr);

    void clearPassword();
}
