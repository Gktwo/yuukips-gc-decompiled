package org.eclipse.jetty.security.authentication;

import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.UserIdentity;

@FunctionalInterface
/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/AuthorizationService.class */
public interface AuthorizationService {
    UserIdentity getUserIdentity(HttpServletRequest httpServletRequest, String str);

    static AuthorizationService from(LoginService loginService, Object credentials) {
        return request, name -> {
            return loginService.login(name, credentials, request);
        };
    }
}
