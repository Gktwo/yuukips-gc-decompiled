package org.eclipse.jetty.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ErrorPageErrorHandler.class */
public class ErrorPageErrorHandler extends ErrorHandler implements ErrorHandler.ErrorPageMapper {
    public static final String GLOBAL_ERROR_PAGE = "org.eclipse.jetty.server.error_page.global";
    private static final Logger LOG = Log.getLogger(ErrorPageErrorHandler.class);
    protected ServletContext _servletContext;
    private final Map<String, String> _errorPages = new HashMap();
    private final List<ErrorCodeRange> _errorPageList = new ArrayList();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ErrorPageErrorHandler$PageLookupTechnique.class */
    private enum PageLookupTechnique {
        THROWABLE,
        STATUS_CODE,
        GLOBAL
    }

    @Override // org.eclipse.jetty.server.handler.ErrorHandler.ErrorPageMapper
    public String getErrorPage(HttpServletRequest request) {
        String errorPage = null;
        PageLookupTechnique pageSource = null;
        Class<?> matchedThrowable = null;
        Throwable th = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        while (errorPage == null && th != null) {
            pageSource = PageLookupTechnique.THROWABLE;
            Class<?> exClass = th.getClass();
            String str = this._errorPages.get(exClass.getName());
            while (true) {
                errorPage = str;
                if (errorPage != null) {
                    break;
                }
                exClass = exClass.getSuperclass();
                if (exClass == null) {
                    break;
                }
                str = this._errorPages.get(exClass.getName());
            }
            if (errorPage != null) {
                matchedThrowable = exClass;
            }
            th = th instanceof ServletException ? ((ServletException) th).getRootCause() : null;
        }
        Integer errorStatusCode = null;
        if (errorPage == null) {
            pageSource = PageLookupTechnique.STATUS_CODE;
            errorStatusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
            if (errorStatusCode != null) {
                errorPage = this._errorPages.get(Integer.toString(errorStatusCode.intValue()));
                if (errorPage == null) {
                    Iterator<ErrorCodeRange> it = this._errorPageList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ErrorCodeRange errCode = it.next();
                        if (errCode.isInRange(errorStatusCode.intValue())) {
                            errorPage = errCode.getUri();
                            break;
                        }
                    }
                }
            }
        }
        if (errorPage == null) {
            pageSource = PageLookupTechnique.GLOBAL;
            errorPage = this._errorPages.get(GLOBAL_ERROR_PAGE);
        }
        if (LOG.isDebugEnabled()) {
            StringBuilder dbg = new StringBuilder();
            dbg.append("getErrorPage(");
            dbg.append(request.getMethod()).append(' ');
            dbg.append(request.getRequestURI());
            dbg.append(") => error_page=").append(errorPage);
            switch (pageSource) {
                case THROWABLE:
                    dbg.append(" (using matched Throwable ");
                    dbg.append(matchedThrowable.getName());
                    dbg.append(" / actually thrown as ");
                    dbg.append(((Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)).getClass().getName());
                    dbg.append(')');
                    LOG.debug(dbg.toString(), th);
                    break;
                case STATUS_CODE:
                    dbg.append(" (from status code ");
                    dbg.append(errorStatusCode);
                    dbg.append(')');
                    LOG.debug(dbg.toString(), new Object[0]);
                    break;
                case GLOBAL:
                    dbg.append(" (from global default)");
                    LOG.debug(dbg.toString(), new Object[0]);
                    break;
            }
        }
        return errorPage;
    }

    public Map<String, String> getErrorPages() {
        return this._errorPages;
    }

    public void setErrorPages(Map<String, String> errorPages) {
        this._errorPages.clear();
        if (errorPages != null) {
            this._errorPages.putAll(errorPages);
        }
    }

    public void addErrorPage(Class<? extends Throwable> exception, String uri) {
        this._errorPages.put(exception.getName(), uri);
    }

    public void addErrorPage(String exceptionClassName, String uri) {
        this._errorPages.put(exceptionClassName, uri);
    }

    public void addErrorPage(int code, String uri) {
        this._errorPages.put(Integer.toString(code), uri);
    }

    public void addErrorPage(int from, int to, String uri) {
        this._errorPageList.add(new ErrorCodeRange(from, to, uri));
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        this._servletContext = ContextHandler.getCurrentContext();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/ErrorPageErrorHandler$ErrorCodeRange.class */
    private static class ErrorCodeRange {
        private int _from;
        private int _to;
        private String _uri;

        ErrorCodeRange(int from, int to, String uri) throws IllegalArgumentException {
            if (from > to) {
                throw new IllegalArgumentException("from>to");
            }
            this._from = from;
            this._to = to;
            this._uri = uri;
        }

        boolean isInRange(int value) {
            return this._from <= value && value <= this._to;
        }

        String getUri() {
            return this._uri;
        }

        public String toString() {
            return "from: " + this._from + ",to: " + this._to + ",uri: " + this._uri;
        }
    }
}
