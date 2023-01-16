package org.eclipse.jetty.security;

import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/UserAuthentication.class */
public class UserAuthentication extends AbstractUserAuthentication {
    public UserAuthentication(String method, UserIdentity userIdentity) {
        super(method, userIdentity);
    }

    @Override // java.lang.Object
    public String toString() {
        return "{User," + getAuthMethod() + "," + this._userIdentity + "}";
    }

    @Override // org.eclipse.jetty.server.Authentication.User
    @Deprecated
    public void logout() {
    }
}
