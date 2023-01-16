package org.eclipse.jetty.security;

import java.security.Principal;
import javax.security.auth.Subject;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/SpnegoUserIdentity.class */
public class SpnegoUserIdentity implements UserIdentity {
    private final Subject _subject;
    private final Principal _principal;
    private final UserIdentity _roleDelegate;

    public SpnegoUserIdentity(Subject subject, Principal principal, UserIdentity roleDelegate) {
        this._subject = subject;
        this._principal = principal;
        this._roleDelegate = roleDelegate;
    }

    @Override // org.eclipse.jetty.server.UserIdentity
    public Subject getSubject() {
        return this._subject;
    }

    @Override // org.eclipse.jetty.server.UserIdentity
    public Principal getUserPrincipal() {
        return this._principal;
    }

    @Override // org.eclipse.jetty.server.UserIdentity
    public boolean isUserInRole(String role, UserIdentity.Scope scope) {
        return this._roleDelegate != null && this._roleDelegate.isUserInRole(role, scope);
    }

    public boolean isEstablished() {
        return this._roleDelegate != null;
    }
}
