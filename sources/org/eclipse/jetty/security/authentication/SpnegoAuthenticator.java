package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Constraint;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/SpnegoAuthenticator.class */
public class SpnegoAuthenticator extends LoginAuthenticator {
    private static final Logger LOG = Log.getLogger(SpnegoAuthenticator.class);
    private String _authMethod;

    public SpnegoAuthenticator() {
        this._authMethod = Constraint.__SPNEGO_AUTH;
    }

    public SpnegoAuthenticator(String authMethod) {
        this._authMethod = Constraint.__SPNEGO_AUTH;
        this._authMethod = authMethod;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return this._authMethod;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public Authentication validateRequest(ServletRequest request, ServletResponse response, boolean mandatory) throws ServerAuthException {
        UserIdentity user;
        HttpServletResponse res = (HttpServletResponse) response;
        String header = ((HttpServletRequest) request).getHeader(HttpHeader.AUTHORIZATION.asString());
        String authScheme = getAuthSchemeFromHeader(header);
        if (!mandatory) {
            return new DeferredAuthentication(this);
        }
        if (header != null && isAuthSchemeNegotiate(authScheme) && (user = login(null, header.substring(10), request)) != null) {
            return new UserAuthentication(getAuthMethod(), user);
        }
        try {
            if (DeferredAuthentication.isDeferred(res)) {
                return Authentication.UNAUTHENTICATED;
            }
            LOG.debug("Sending challenge", new Object[0]);
            res.setHeader(HttpHeader.WWW_AUTHENTICATE.asString(), HttpHeader.NEGOTIATE.asString());
            res.sendError(401);
            return Authentication.SEND_CONTINUE;
        } catch (IOException ioe) {
            throw new ServerAuthException(ioe);
        }
    }

    String getAuthSchemeFromHeader(String header) {
        if (header == null || header.isEmpty()) {
            return "";
        }
        String trimmedHeader = header.trim();
        int index = trimmedHeader.indexOf(32);
        if (index > 0) {
            return trimmedHeader.substring(0, index);
        }
        return trimmedHeader;
    }

    boolean isAuthSchemeNegotiate(String authScheme) {
        if (authScheme == null || authScheme.length() != HttpHeader.NEGOTIATE.asString().length()) {
            return false;
        }
        return authScheme.equalsIgnoreCase(HttpHeader.NEGOTIATE.asString());
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest request, ServletResponse response, boolean mandatory, Authentication.User validatedUser) throws ServerAuthException {
        return true;
    }
}
