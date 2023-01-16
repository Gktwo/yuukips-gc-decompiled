package org.eclipse.jetty.security;

import java.io.Serializable;
import java.security.Principal;
import javax.security.auth.Subject;
import javax.servlet.ServletRequest;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.security.Credential;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/AbstractLoginService.class */
public abstract class AbstractLoginService extends ContainerLifeCycle implements LoginService {
    private static final Logger LOG = Log.getLogger(AbstractLoginService.class);
    protected String _name;
    protected IdentityService _identityService = new DefaultIdentityService();
    protected boolean _fullValidate = false;

    protected abstract String[] loadRoleInfo(UserPrincipal userPrincipal);

    protected abstract UserPrincipal loadUserInfo(String str);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/AbstractLoginService$RolePrincipal.class */
    public static class RolePrincipal implements Principal, Serializable {
        private static final long serialVersionUID = 2998397924051854402L;
        private final String _roleName;

        public RolePrincipal(String name) {
            this._roleName = name;
        }

        @Override // java.security.Principal
        public String getName() {
            return this._roleName;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/AbstractLoginService$UserPrincipal.class */
    public static class UserPrincipal implements Principal, Serializable {
        private static final long serialVersionUID = -6226920753748399662L;
        private final String _name;
        private final Credential _credential;

        public UserPrincipal(String name, Credential credential) {
            this._name = name;
            this._credential = credential;
        }

        public boolean authenticate(Object credentials) {
            return this._credential != null && this._credential.check(credentials);
        }

        public boolean authenticate(Credential c) {
            return (this._credential == null || c == null || !this._credential.equals(c)) ? false : true;
        }

        @Override // java.security.Principal
        public String getName() {
            return this._name;
        }

        @Override // java.security.Principal, java.lang.Object
        public String toString() {
            return this._name;
        }
    }

    /* access modifiers changed from: protected */
    public AbstractLoginService() {
        addBean(this._identityService);
    }

    @Override // org.eclipse.jetty.security.LoginService
    public String getName() {
        return this._name;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void setIdentityService(IdentityService identityService) {
        if (isRunning()) {
            throw new IllegalStateException("Running");
        }
        updateBean(this._identityService, identityService);
        this._identityService = identityService;
    }

    public void setName(String name) {
        if (isRunning()) {
            throw new IllegalStateException("Running");
        }
        this._name = name;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x[%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._name);
    }

    @Override // org.eclipse.jetty.security.LoginService
    public UserIdentity login(String username, Object credentials, ServletRequest request) {
        UserPrincipal userPrincipal;
        if (username == null || (userPrincipal = loadUserInfo(username)) == null || !userPrincipal.authenticate(credentials)) {
            return null;
        }
        String[] roles = loadRoleInfo(userPrincipal);
        Subject subject = new Subject();
        subject.getPrincipals().add(userPrincipal);
        subject.getPrivateCredentials().add(userPrincipal._credential);
        if (roles != null) {
            for (String role : roles) {
                subject.getPrincipals().add(new RolePrincipal(role));
            }
        }
        subject.setReadOnly();
        return this._identityService.newUserIdentity(subject, userPrincipal, roles);
    }

    @Override // org.eclipse.jetty.security.LoginService
    public boolean validate(UserIdentity user) {
        if (!isFullValidate()) {
            return true;
        }
        UserPrincipal fresh = loadUserInfo(user.getUserPrincipal().getName());
        if (fresh == null) {
            return false;
        }
        if (user.getUserPrincipal() instanceof UserPrincipal) {
            return fresh.authenticate(((UserPrincipal) user.getUserPrincipal())._credential);
        }
        throw new IllegalStateException("UserPrincipal not KnownUser");
    }

    @Override // org.eclipse.jetty.security.LoginService
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void logout(UserIdentity user) {
    }

    public boolean isFullValidate() {
        return this._fullValidate;
    }

    public void setFullValidate(boolean fullValidate) {
        this._fullValidate = fullValidate;
    }
}
