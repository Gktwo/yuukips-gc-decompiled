package org.eclipse.jetty.server;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ServletRequestHttpWrapper.class */
public class ServletRequestHttpWrapper extends ServletRequestWrapper implements HttpServletRequest {
    public ServletRequestHttpWrapper(ServletRequest request) {
        super(request);
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getAuthType() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Cookie[] getCookies() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public long getDateHeader(String name) {
        return 0;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getHeader(String name) {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Enumeration<String> getHeaders(String name) {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Enumeration<String> getHeaderNames() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public int getIntHeader(String name) {
        return 0;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getMethod() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getPathInfo() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getPathTranslated() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getContextPath() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getQueryString() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRemoteUser() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Principal getUserPrincipal() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRequestedSessionId() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getRequestURI() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public StringBuffer getRequestURL() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String getServletPath() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public HttpSession getSession(boolean create) {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public HttpSession getSession() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return false;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Part getPart(String name) throws IOException, ServletException {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public Collection<Part> getParts() throws IOException, ServletException {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public void login(String username, String password) throws ServletException {
    }

    @Override // javax.servlet.http.HttpServletRequest
    public void logout() throws ServletException {
    }

    @Override // javax.servlet.http.HttpServletRequest
    public String changeSessionId() {
        return null;
    }

    @Override // javax.servlet.http.HttpServletRequest
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        return null;
    }
}
