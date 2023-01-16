package org.eclipse.jetty.security;

import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.Server;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/Authenticator.class */
public interface Authenticator {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/Authenticator$AuthConfiguration.class */
    public interface AuthConfiguration {
        String getAuthMethod();

        String getRealmName();

        String getInitParameter(String str);

        Set<String> getInitParameterNames();

        LoginService getLoginService();

        IdentityService getIdentityService();

        boolean isSessionRenewedOnAuthentication();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/Authenticator$Factory.class */
    public interface Factory {
        Authenticator getAuthenticator(Server server, ServletContext servletContext, AuthConfiguration authConfiguration, IdentityService identityService, LoginService loginService);
    }

    void setConfiguration(AuthConfiguration authConfiguration);

    String getAuthMethod();

    void prepareRequest(ServletRequest servletRequest);

    Authentication validateRequest(ServletRequest servletRequest, ServletResponse servletResponse, boolean z) throws ServerAuthException;

    boolean secureResponse(ServletRequest servletRequest, ServletResponse servletResponse, boolean z, Authentication.User user) throws ServerAuthException;
}
