package org.eclipse.jetty.security;

import javax.servlet.ServletRequest;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/LoginService.class */
public interface LoginService {
    String getName();

    UserIdentity login(String str, Object obj, ServletRequest servletRequest);

    boolean validate(UserIdentity userIdentity);

    IdentityService getIdentityService();

    void setIdentityService(IdentityService identityService);

    void logout(UserIdentity userIdentity);
}
