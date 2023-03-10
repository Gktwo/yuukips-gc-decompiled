package org.eclipse.jetty.security.authentication;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.session.Session;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/LoginAuthenticator.class */
public abstract class LoginAuthenticator implements Authenticator {
    private static final Logger LOG = Log.getLogger(LoginAuthenticator.class);
    protected LoginService _loginService;
    protected IdentityService _identityService;
    private boolean _renewSession;

    @Override // org.eclipse.jetty.security.Authenticator
    public void prepareRequest(ServletRequest request) {
    }

    public UserIdentity login(String username, Object password, ServletRequest servletRequest) {
        UserIdentity user = this._loginService.login(username, password, servletRequest);
        if (user == null) {
            return null;
        }
        Request request = Request.getBaseRequest(servletRequest);
        renewSession(request, request == null ? null : request.getResponse());
        return user;
    }

    public void logout(ServletRequest request) {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null) {
            session.removeAttribute(Session.SESSION_CREATED_SECURE);
        }
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public void setConfiguration(Authenticator.AuthConfiguration configuration) {
        this._loginService = configuration.getLoginService();
        if (this._loginService == null) {
            throw new IllegalStateException("No LoginService for " + this + " in " + configuration);
        }
        this._identityService = configuration.getIdentityService();
        if (this._identityService == null) {
            throw new IllegalStateException("No IdentityService for " + this + " in " + configuration);
        }
        this._renewSession = configuration.isSessionRenewedOnAuthentication();
    }

    public LoginService getLoginService() {
        return this._loginService;
    }

    protected HttpSession renewSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(false);
        if (this._renewSession && httpSession != null) {
            synchronized (httpSession) {
                if (httpSession.getAttribute(Session.SESSION_CREATED_SECURE) != Boolean.TRUE) {
                    if (httpSession instanceof Session) {
                        Session s = (Session) httpSession;
                        String oldId = s.getId();
                        s.renewId(request);
                        s.setAttribute(Session.SESSION_CREATED_SECURE, Boolean.TRUE);
                        if (s.isIdChanged() && (response instanceof Response)) {
                            ((Response) response).replaceCookie(s.getSessionHandler().getSessionCookie(s, request.getContextPath(), request.isSecure()));
                        }
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("renew {}->{}", oldId, s.getId());
                        }
                    } else {
                        LOG.warn("Unable to renew session " + httpSession, new Object[0]);
                    }
                    return httpSession;
                }
            }
        }
        return httpSession;
    }
}
