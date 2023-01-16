package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/BasicAuthenticator.class */
public class BasicAuthenticator extends LoginAuthenticator {
    private Charset _charset;

    public Charset getCharset() {
        return this._charset;
    }

    public void setCharset(Charset charset) {
        this._charset = charset;
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return "BASIC";
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public Authentication validateRequest(ServletRequest req, ServletResponse res, boolean mandatory) throws ServerAuthException {
        int space;
        UserIdentity user;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String credentials = request.getHeader(HttpHeader.AUTHORIZATION.asString());
        try {
            if (!mandatory) {
                return new DeferredAuthentication(this);
            }
            if (credentials != null && (space = credentials.indexOf(32)) > 0 && "basic".equalsIgnoreCase(credentials.substring(0, space))) {
                String credentials2 = credentials.substring(space + 1);
                Charset charset = getCharset();
                if (charset == null) {
                    charset = StandardCharsets.ISO_8859_1;
                }
                String credentials3 = new String(Base64.getDecoder().decode(credentials2), charset);
                int i = credentials3.indexOf(58);
                if (i > 0 && (user = login(credentials3.substring(0, i), credentials3.substring(i + 1), request)) != null) {
                    return new UserAuthentication(getAuthMethod(), user);
                }
            }
            if (DeferredAuthentication.isDeferred(response)) {
                return Authentication.UNAUTHENTICATED;
            }
            String value = "basic realm=\"" + this._loginService.getName() + "\"";
            Charset charset2 = getCharset();
            if (charset2 != null) {
                value = value + ", charset=\"" + charset2.name() + "\"";
            }
            response.setHeader(HttpHeader.WWW_AUTHENTICATE.asString(), value);
            response.sendError(401);
            return Authentication.SEND_CONTINUE;
        } catch (IOException e) {
            throw new ServerAuthException(e);
        }
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest req, ServletResponse res, boolean mandatory, Authentication.User validatedUser) throws ServerAuthException {
        return true;
    }
}
