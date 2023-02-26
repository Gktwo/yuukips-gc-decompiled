package org.eclipse.jetty.security.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.security.IdentityService;
import org.eclipse.jetty.security.LoggedOutAuthentication;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.security.ServerAuthException;
import org.eclipse.jetty.security.UserAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/authentication/DeferredAuthentication.class */
public class DeferredAuthentication implements Authentication.Deferred {
    protected final LoginAuthenticator _authenticator;
    private Object _previousAssociation;
    private static final Logger LOG = Log.getLogger(DeferredAuthentication.class);
    static final HttpServletResponse __deferredResponse = new HttpServletResponse() { // from class: org.eclipse.jetty.security.authentication.DeferredAuthentication.1
        @Override // javax.servlet.http.HttpServletResponse
        public void addCookie(Cookie cookie) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void addDateHeader(String name, long date) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void addHeader(String name, String value) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void addIntHeader(String name, int value) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public boolean containsHeader(String name) {
            return false;
        }

        @Override // javax.servlet.http.HttpServletResponse
        public String encodeRedirectURL(String url) {
            return null;
        }

        @Override // javax.servlet.http.HttpServletResponse
        public String encodeRedirectUrl(String url) {
            return null;
        }

        @Override // javax.servlet.http.HttpServletResponse
        public String encodeURL(String url) {
            return null;
        }

        @Override // javax.servlet.http.HttpServletResponse
        public String encodeUrl(String url) {
            return null;
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void sendError(int sc) throws IOException {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void sendError(int sc, String msg) throws IOException {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void sendRedirect(String location) throws IOException {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void setDateHeader(String name, long date) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void setHeader(String name, String value) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void setIntHeader(String name, int value) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void setStatus(int sc) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public void setStatus(int sc, String sm) {
        }

        @Override // javax.servlet.ServletResponse
        public void flushBuffer() throws IOException {
        }

        @Override // javax.servlet.ServletResponse
        public int getBufferSize() {
            return 1024;
        }

        @Override // javax.servlet.ServletResponse
        public String getCharacterEncoding() {
            return null;
        }

        @Override // javax.servlet.ServletResponse
        public String getContentType() {
            return null;
        }

        @Override // javax.servlet.ServletResponse
        public Locale getLocale() {
            return null;
        }

        @Override // javax.servlet.ServletResponse
        public ServletOutputStream getOutputStream() throws IOException {
            return DeferredAuthentication.__nullOut;
        }

        @Override // javax.servlet.ServletResponse
        public PrintWriter getWriter() throws IOException {
            return C5739IO.getNullPrintWriter();
        }

        @Override // javax.servlet.ServletResponse
        public boolean isCommitted() {
            return true;
        }

        @Override // javax.servlet.ServletResponse
        public void reset() {
        }

        @Override // javax.servlet.ServletResponse
        public void resetBuffer() {
        }

        @Override // javax.servlet.ServletResponse
        public void setBufferSize(int size) {
        }

        @Override // javax.servlet.ServletResponse
        public void setCharacterEncoding(String charset) {
        }

        @Override // javax.servlet.ServletResponse
        public void setContentLength(int len) {
        }

        @Override // javax.servlet.ServletResponse
        public void setContentLengthLong(long len) {
        }

        @Override // javax.servlet.ServletResponse
        public void setContentType(String type) {
        }

        @Override // javax.servlet.ServletResponse
        public void setLocale(Locale loc) {
        }

        @Override // javax.servlet.http.HttpServletResponse
        public Collection<String> getHeaderNames() {
            return Collections.emptyList();
        }

        @Override // javax.servlet.http.HttpServletResponse
        public String getHeader(String arg0) {
            return null;
        }

        @Override // javax.servlet.http.HttpServletResponse
        public Collection<String> getHeaders(String arg0) {
            return Collections.emptyList();
        }

        @Override // javax.servlet.http.HttpServletResponse
        public int getStatus() {
            return 0;
        }
    };
    private static ServletOutputStream __nullOut = new ServletOutputStream() { // from class: org.eclipse.jetty.security.authentication.DeferredAuthentication.2
        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
        }

        @Override // javax.servlet.ServletOutputStream
        public void print(String s) throws IOException {
        }

        @Override // javax.servlet.ServletOutputStream
        public void println(String s) throws IOException {
        }

        @Override // javax.servlet.ServletOutputStream
        public void setWriteListener(WriteListener writeListener) {
        }

        @Override // javax.servlet.ServletOutputStream
        public boolean isReady() {
            return false;
        }
    };

    public DeferredAuthentication(LoginAuthenticator authenticator) {
        if (authenticator == null) {
            throw new NullPointerException("No Authenticator");
        }
        this._authenticator = authenticator;
    }

    @Override // org.eclipse.jetty.server.Authentication.Deferred
    public Authentication authenticate(ServletRequest request) {
        try {
            Authentication authentication = this._authenticator.validateRequest(request, __deferredResponse, true);
            if (authentication != null && (authentication instanceof Authentication.User) && !(authentication instanceof Authentication.ResponseSent)) {
                IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
                if (identityService != null) {
                    this._previousAssociation = identityService.associate(((Authentication.User) authentication).getUserIdentity());
                }
                return authentication;
            }
        } catch (ServerAuthException e) {
            LOG.debug(e);
        }
        return this;
    }

    @Override // org.eclipse.jetty.server.Authentication.Deferred
    public Authentication authenticate(ServletRequest request, ServletResponse response) {
        try {
            IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
            Authentication authentication = this._authenticator.validateRequest(request, response, true);
            if ((authentication instanceof Authentication.User) && identityService != null) {
                this._previousAssociation = identityService.associate(((Authentication.User) authentication).getUserIdentity());
            }
            return authentication;
        } catch (ServerAuthException e) {
            LOG.debug(e);
            return this;
        }
    }

    @Override // org.eclipse.jetty.server.Authentication.LoginAuthentication
    public Authentication login(String username, Object password, ServletRequest request) {
        UserIdentity identity;
        if (username == null || (identity = this._authenticator.login(username, password, request)) == null) {
            return null;
        }
        IdentityService identityService = this._authenticator.getLoginService().getIdentityService();
        UserAuthentication authentication = new UserAuthentication("API", identity);
        if (identityService != null) {
            this._previousAssociation = identityService.associate(identity);
        }
        return authentication;
    }

    @Override // org.eclipse.jetty.server.Authentication.LogoutAuthentication
    public Authentication logout(ServletRequest request) {
        SecurityHandler security = SecurityHandler.getCurrentSecurityHandler();
        if (security != null) {
            security.logout(null);
            if (this._authenticator instanceof LoginAuthenticator) {
                this._authenticator.logout(request);
                return new LoggedOutAuthentication(this._authenticator);
            }
        }
        return Authentication.UNAUTHENTICATED;
    }

    public Object getPreviousAssociation() {
        return this._previousAssociation;
    }

    public static boolean isDeferred(HttpServletResponse response) {
        return response == __deferredResponse;
    }
}
