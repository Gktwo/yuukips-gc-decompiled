package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import org.eclipse.jetty.security.AbstractUserAuthentication;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/SessionAuthentication.class */
public class SessionAuthentication extends AbstractUserAuthentication implements Serializable, HttpSessionActivationListener, HttpSessionBindingListener {
    private static final Logger LOG = Log.getLogger(SessionAuthentication.class);
    private static final long serialVersionUID = -4643200685888258706L;
    public static final String __J_AUTHENTICATED = "org.eclipse.jetty.security.UserIdentity";
    private final String _name;
    private final Object _credentials;
    private transient HttpSession _session;

    public SessionAuthentication(String method, UserIdentity userIdentity, Object credentials) {
        super(method, userIdentity);
        this._name = userIdentity.getUserPrincipal().getName();
        this._credentials = credentials;
    }

    @Override // org.eclipse.jetty.security.AbstractUserAuthentication, org.eclipse.jetty.server.Authentication.User
    public UserIdentity getUserIdentity() {
        if (this._userIdentity != null) {
            return getUserIdentity();
        }
        throw new IllegalStateException("!UserIdentity");
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        SecurityHandler security = SecurityHandler.getCurrentSecurityHandler();
        if (security != null) {
            LoginService loginService = security.getLoginService();
            if (loginService != null) {
                this._userIdentity = loginService.login(this._name, this._credentials, null);
                LOG.debug("Deserialized and relogged in {}", this);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("!LoginService", new Object[0]);
            }
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("!SecurityHandler", new Object[0]);
        }
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    @Deprecated
    public void logout() {
    }

    @Override // java.lang.Object
    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = this._session == null ? "-" : this._session.getId();
        objArr[3] = this._userIdentity;
        return String.format("%s@%x{%s,%s}", objArr);
    }

    @Override // javax.servlet.http.HttpSessionActivationListener
    public void sessionWillPassivate(HttpSessionEvent se) {
    }

    @Override // javax.servlet.http.HttpSessionActivationListener
    public void sessionDidActivate(HttpSessionEvent se) {
        if (this._session == null) {
            this._session = se.getSession();
        }
    }

    @Override // javax.servlet.http.HttpSessionBindingListener
    @Deprecated
    public void valueBound(HttpSessionBindingEvent event) {
    }

    @Override // javax.servlet.http.HttpSessionBindingListener
    @Deprecated
    public void valueUnbound(HttpSessionBindingEvent event) {
    }
}
