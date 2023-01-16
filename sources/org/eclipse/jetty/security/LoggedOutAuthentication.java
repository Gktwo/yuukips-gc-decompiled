package org.eclipse.jetty.security;

import javax.servlet.ServletRequest;
import org.eclipse.jetty.security.authentication.LoginAuthenticator;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/LoggedOutAuthentication.class */
public class LoggedOutAuthentication implements Authentication.NonAuthenticated {
    private LoginAuthenticator _authenticator;

    public LoggedOutAuthentication(LoginAuthenticator authenticator) {
        this._authenticator = authenticator;
    }

    @Override // org.eclipse.jetty.server.Authentication.LoginAuthentication
    public Authentication login(String username, Object password, ServletRequest request) {
        UserIdentity identity;
        if (username == null || (identity = this._authenticator.login(username, password, request)) == null) {
            return null;
        }
        IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
        UserAuthentication authentication = new UserAuthentication("API", identity);
        if (identityService != null) {
            identityService.associate(identity);
        }
        return authentication;
    }
}
