package org.eclipse.jetty.security;

import java.io.Serializable;
import java.util.Set;
import javax.servlet.ServletRequest;
import org.eclipse.jetty.security.authentication.LoginAuthenticator;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/AbstractUserAuthentication.class */
public abstract class AbstractUserAuthentication implements Authentication.User, Serializable {
    private static final long serialVersionUID = -6290411814232723403L;
    protected String _method;
    protected transient UserIdentity _userIdentity;

    public AbstractUserAuthentication(String method, UserIdentity userIdentity) {
        this._method = method;
        this._userIdentity = userIdentity;
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public String getAuthMethod() {
        return this._method;
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public UserIdentity getUserIdentity() {
        return this._userIdentity;
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    public boolean isUserInRole(UserIdentity.Scope scope, String role) {
        String roleToTest = null;
        if (!(scope == null || scope.getRoleRefMap() == null)) {
            roleToTest = scope.getRoleRefMap().get(role);
        }
        if (roleToTest == null) {
            roleToTest = role;
        }
        if (!Constraint.ANY_AUTH.equals(roleToTest.trim())) {
            return this._userIdentity.isUserInRole(role, scope);
        }
        if (!declaredRolesContains(Constraint.ANY_AUTH)) {
            return true;
        }
        return this._userIdentity.isUserInRole(role, scope);
    }

    public boolean declaredRolesContains(String roleName) {
        Set<String> declaredRoles;
        SecurityHandler security = SecurityHandler.getCurrentSecurityHandler();
        return security != null && (security instanceof ConstraintAware) && (declaredRoles = ((ConstraintAware) security).getRoles()) != null && declaredRoles.contains(roleName);
    }

    @Override // org.eclipse.jetty.server.Authentication.LogoutAuthentication
    public Authentication logout(ServletRequest request) {
        SecurityHandler security = SecurityHandler.getCurrentSecurityHandler();
        if (security != null) {
            security.logout(this);
            Authenticator authenticator = security.getAuthenticator();
            if (authenticator instanceof LoginAuthenticator) {
                ((LoginAuthenticator) authenticator).logout(request);
                return new LoggedOutAuthentication((LoginAuthenticator) authenticator);
            }
        }
        return Authentication.UNAUTHENTICATED;
    }
}
