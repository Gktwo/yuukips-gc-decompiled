package org.eclipse.jetty.security.authentication;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/FormAuthenticator.class */
public class FormAuthenticator extends LoginAuthenticator {
    private static final Logger LOG = Log.getLogger(FormAuthenticator.class);
    public static final String __FORM_LOGIN_PAGE = "org.eclipse.jetty.security.form_login_page";
    public static final String __FORM_ERROR_PAGE = "org.eclipse.jetty.security.form_error_page";
    public static final String __FORM_DISPATCH = "org.eclipse.jetty.security.dispatch";
    public static final String __J_URI = "org.eclipse.jetty.security.form_URI";
    public static final String __J_POST = "org.eclipse.jetty.security.form_POST";
    public static final String __J_METHOD = "org.eclipse.jetty.security.form_METHOD";
    public static final String __J_SECURITY_CHECK = "/j_security_check";
    public static final String __J_USERNAME = "j_username";
    public static final String __J_PASSWORD = "j_password";
    private String _formErrorPage;
    private String _formErrorPath;
    private String _formLoginPage;
    private String _formLoginPath;
    private boolean _dispatch;
    private boolean _alwaysSaveUri;

    public FormAuthenticator() {
    }

    public FormAuthenticator(String login, String error, boolean dispatch) {
        this();
        if (login != null) {
            setLoginPage(login);
        }
        if (error != null) {
            setErrorPage(error);
        }
        this._dispatch = dispatch;
    }

    public void setAlwaysSaveUri(boolean alwaysSave) {
        this._alwaysSaveUri = alwaysSave;
    }

    public boolean getAlwaysSaveUri() {
        return this._alwaysSaveUri;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator, org.eclipse.jetty.security.Authenticator
    public void setConfiguration(Authenticator.AuthConfiguration configuration) {
        setConfiguration(configuration);
        String login = configuration.getInitParameter(__FORM_LOGIN_PAGE);
        if (login != null) {
            setLoginPage(login);
        }
        String error = configuration.getInitParameter(__FORM_ERROR_PAGE);
        if (error != null) {
            setErrorPage(error);
        }
        String dispatch = configuration.getInitParameter(__FORM_DISPATCH);
        this._dispatch = dispatch == null ? this._dispatch : Boolean.parseBoolean(dispatch);
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public String getAuthMethod() {
        return "FORM";
    }

    private void setLoginPage(String path) {
        if (!path.startsWith("/")) {
            LOG.warn("form-login-page must start with /", new Object[0]);
            path = "/" + path;
        }
        this._formLoginPage = path;
        this._formLoginPath = path;
        if (this._formLoginPath.indexOf(63) > 0) {
            this._formLoginPath = this._formLoginPath.substring(0, this._formLoginPath.indexOf(63));
        }
    }

    private void setErrorPage(String path) {
        if (path == null || path.trim().length() == 0) {
            this._formErrorPath = null;
            this._formErrorPage = null;
            return;
        }
        if (!path.startsWith("/")) {
            LOG.warn("form-error-page must start with /", new Object[0]);
            path = "/" + path;
        }
        this._formErrorPage = path;
        this._formErrorPath = path;
        if (this._formErrorPath.indexOf(63) > 0) {
            this._formErrorPath = this._formErrorPath.substring(0, this._formErrorPath.indexOf(63));
        }
    }

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator
    public UserIdentity login(String username, Object password, ServletRequest request) {
        UserIdentity user = login(username, password, request);
        if (user != null) {
            ((HttpServletRequest) request).getSession(true).setAttribute(SessionAuthentication.__J_AUTHENTICATED, new SessionAuthentication(getAuthMethod(), user, password));
        }
        return user;
    }

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator
    public void logout(ServletRequest request) {
        logout(request);
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session != null) {
            session.removeAttribute(SessionAuthentication.__J_AUTHENTICATED);
        }
    }

    @Override // org.eclipse.jetty.security.authentication.LoginAuthenticator, org.eclipse.jetty.security.Authenticator
    public void prepareRequest(ServletRequest request) {
        String juri;
        String method;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute(SessionAuthentication.__J_AUTHENTICATED) != null && (juri = (String) session.getAttribute(__J_URI)) != null && juri.length() != 0 && (method = (String) session.getAttribute(__J_METHOD)) != null && method.length() != 0) {
            StringBuffer buf = httpRequest.getRequestURL();
            if (httpRequest.getQueryString() != null) {
                buf.append("?").append(httpRequest.getQueryString());
            }
            if (juri.equals(buf.toString())) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Restoring original method {} for {} with method {}", method, juri, httpRequest.getMethod());
                }
                Request.getBaseRequest(request).setMethod(method);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00db, code lost:
        if (r20.length() == 0) goto L_0x00de;
     */
    @Override // org.eclipse.jetty.security.Authenticator
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.eclipse.jetty.server.Authentication validateRequest(javax.servlet.ServletRequest r8, javax.servlet.ServletResponse r9, boolean r10) throws org.eclipse.jetty.security.ServerAuthException {
        /*
        // Method dump skipped, instructions count: 1309
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.security.authentication.FormAuthenticator.validateRequest(javax.servlet.ServletRequest, javax.servlet.ServletResponse, boolean):org.eclipse.jetty.server.Authentication");
    }

    public boolean isJSecurityCheck(String uri) {
        char c;
        int jsc = uri.indexOf(__J_SECURITY_CHECK);
        if (jsc < 0) {
            return false;
        }
        int e = jsc + __J_SECURITY_CHECK.length();
        return e == uri.length() || (c = uri.charAt(e)) == ';' || c == '#' || c == '/' || c == '?';
    }

    public boolean isLoginOrErrorPage(String pathInContext) {
        return pathInContext != null && (pathInContext.equals(this._formErrorPath) || pathInContext.equals(this._formLoginPath));
    }

    @Override // org.eclipse.jetty.security.Authenticator
    public boolean secureResponse(ServletRequest req, ServletResponse res, boolean mandatory, Authentication.User validatedUser) throws ServerAuthException {
        return true;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/FormAuthenticator$FormRequest.class */
    protected static class FormRequest extends HttpServletRequestWrapper {
        public FormRequest(HttpServletRequest request) {
            super(request);
        }

        @Override // javax.servlet.http.HttpServletRequestWrapper, javax.servlet.http.HttpServletRequest
        public long getDateHeader(String name) {
            if (name.toLowerCase(Locale.ENGLISH).startsWith("if-")) {
                return -1;
            }
            return getDateHeader(name);
        }

        @Override // javax.servlet.http.HttpServletRequestWrapper, javax.servlet.http.HttpServletRequest
        public String getHeader(String name) {
            if (name.toLowerCase(Locale.ENGLISH).startsWith("if-")) {
                return null;
            }
            return getHeader(name);
        }

        @Override // javax.servlet.http.HttpServletRequestWrapper, javax.servlet.http.HttpServletRequest
        public Enumeration<String> getHeaderNames() {
            return Collections.enumeration(Collections.list(getHeaderNames()));
        }

        @Override // javax.servlet.http.HttpServletRequestWrapper, javax.servlet.http.HttpServletRequest
        public Enumeration<String> getHeaders(String name) {
            if (name.toLowerCase(Locale.ENGLISH).startsWith("if-")) {
                return Collections.enumeration(Collections.emptyList());
            }
            return getHeaders(name);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/FormAuthenticator$FormResponse.class */
    protected static class FormResponse extends HttpServletResponseWrapper {
        public FormResponse(HttpServletResponse response) {
            super(response);
        }

        @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
        public void addDateHeader(String name, long date) {
            if (notIgnored(name)) {
                addDateHeader(name, date);
            }
        }

        @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
        public void addHeader(String name, String value) {
            if (notIgnored(name)) {
                addHeader(name, value);
            }
        }

        @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
        public void setDateHeader(String name, long date) {
            if (notIgnored(name)) {
                setDateHeader(name, date);
            }
        }

        @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
        public void setHeader(String name, String value) {
            if (notIgnored(name)) {
                setHeader(name, value);
            }
        }

        private boolean notIgnored(String name) {
            return !HttpHeader.CACHE_CONTROL.m42is(name) && !HttpHeader.PRAGMA.m42is(name) && !HttpHeader.ETAG.m42is(name) && !HttpHeader.EXPIRES.m42is(name) && !HttpHeader.LAST_MODIFIED.m42is(name) && !HttpHeader.AGE.m42is(name);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/FormAuthenticator$FormAuthentication.class */
    public static class FormAuthentication extends UserAuthentication implements Authentication.ResponseSent {
        public FormAuthentication(String method, UserIdentity userIdentity) {
            super(method, userIdentity);
        }

        @Override // org.eclipse.jetty.security.UserAuthentication, java.lang.Object
        public String toString() {
            return "Form" + toString();
        }
    }
}
