package org.eclipse.jetty.server;

import java.security.Principal;
import java.util.Map;
import javax.security.auth.Subject;
import org.eclipse.jetty.server.handler.ContextHandler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/UserIdentity.class */
public interface UserIdentity {
    public static final UserIdentity UNAUTHENTICATED_IDENTITY = new UnauthenticatedUserIdentity() { // from class: org.eclipse.jetty.server.UserIdentity.1
        @Override // org.eclipse.jetty.server.UserIdentity
        public Subject getSubject() {
            return null;
        }

        @Override // org.eclipse.jetty.server.UserIdentity
        public Principal getUserPrincipal() {
            return null;
        }

        @Override // org.eclipse.jetty.server.UserIdentity
        public boolean isUserInRole(String role, Scope scope) {
            return false;
        }

        public String toString() {
            return "UNAUTHENTICATED";
        }
    };

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/UserIdentity$Scope.class */
    public interface Scope {
        ContextHandler getContextHandler();

        String getContextPath();

        String getName();

        Map<String, String> getRoleRefMap();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/UserIdentity$UnauthenticatedUserIdentity.class */
    public interface UnauthenticatedUserIdentity extends UserIdentity {
    }

    Subject getSubject();

    Principal getUserPrincipal();

    boolean isUserInRole(String str, Scope scope);
}
