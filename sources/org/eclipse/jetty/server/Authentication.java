package org.eclipse.jetty.server;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.UserIdentity;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication.class */
public interface Authentication {
    public static final Authentication UNAUTHENTICATED = new Authentication() { // from class: org.eclipse.jetty.server.Authentication.1
        public String toString() {
            return "UNAUTHENTICATED";
        }
    };
    public static final Authentication NOT_CHECKED = new Authentication() { // from class: org.eclipse.jetty.server.Authentication.2
        public String toString() {
            return "NOT CHECKED";
        }
    };
    public static final Authentication SEND_CONTINUE = new Challenge() { // from class: org.eclipse.jetty.server.Authentication.3
        public String toString() {
            return "CHALLENGE";
        }
    };
    public static final Authentication SEND_FAILURE = new Failure() { // from class: org.eclipse.jetty.server.Authentication.4
        public String toString() {
            return "FAILURE";
        }
    };
    public static final Authentication SEND_SUCCESS = new SendSuccess() { // from class: org.eclipse.jetty.server.Authentication.5
        public String toString() {
            return "SEND_SUCCESS";
        }
    };

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$Challenge.class */
    public interface Challenge extends ResponseSent {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$Deferred.class */
    public interface Deferred extends LoginAuthentication, LogoutAuthentication {
        Authentication authenticate(ServletRequest servletRequest);

        Authentication authenticate(ServletRequest servletRequest, ServletResponse servletResponse);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$Failure.class */
    public interface Failure extends ResponseSent {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$LoginAuthentication.class */
    public interface LoginAuthentication extends Authentication {
        Authentication login(String str, Object obj, ServletRequest servletRequest);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$LogoutAuthentication.class */
    public interface LogoutAuthentication extends Authentication {
        Authentication logout(ServletRequest servletRequest);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$NonAuthenticated.class */
    public interface NonAuthenticated extends LoginAuthentication {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$ResponseSent.class */
    public interface ResponseSent extends Authentication {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$SendSuccess.class */
    public interface SendSuccess extends ResponseSent {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$User.class */
    public interface User extends LogoutAuthentication {
        String getAuthMethod();

        UserIdentity getUserIdentity();

        boolean isUserInRole(UserIdentity.Scope scope, String str);

        @Deprecated
        void logout();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$Wrapped.class */
    public interface Wrapped extends Authentication {
        HttpServletRequest getHttpServletRequest();

        HttpServletResponse getHttpServletResponse();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Authentication$Failed.class */
    public static class Failed extends QuietServletException {
        public Failed(String message) {
            super(message);
        }
    }
}
