package org.eclipse.jetty.server;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import javax.servlet.AsyncContext;
import org.eclipse.jetty.util.Attributes;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncAttributes.class */
public class AsyncAttributes extends Attributes.Wrapper {
    public static final String __ASYNC_PREFIX = "javax.servlet.async.";
    private String _requestURI;
    private String _contextPath;
    private String _servletPath;
    private String _pathInfo;
    private String _queryString;

    public AsyncAttributes(Attributes attributes, String requestUri, String contextPath, String servletPath, String pathInfo, String queryString) {
        super(attributes);
        this._requestURI = requestUri;
        this._contextPath = contextPath;
        this._servletPath = servletPath;
        this._pathInfo = pathInfo;
        this._queryString = queryString;
    }

    @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
    public Object getAttribute(String key) {
        char c = 65535;
        switch (key.hashCode()) {
            case -976679287:
                if (key.equals(AsyncContext.ASYNC_REQUEST_URI)) {
                    c = 0;
                    break;
                }
                break;
            case -697442667:
                if (key.equals(AsyncContext.ASYNC_PATH_INFO)) {
                    c = 3;
                    break;
                }
                break;
            case -398790776:
                if (key.equals(AsyncContext.ASYNC_CONTEXT_PATH)) {
                    c = 1;
                    break;
                }
                break;
            case 79701563:
                if (key.equals(AsyncContext.ASYNC_QUERY_STRING)) {
                    c = 4;
                    break;
                }
                break;
            case 1982251186:
                if (key.equals(AsyncContext.ASYNC_SERVLET_PATH)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this._requestURI;
            case 1:
                return this._contextPath;
            case 2:
                return this._servletPath;
            case 3:
                return this._pathInfo;
            case 4:
                return this._queryString;
            default:
                return getAttribute(key);
        }
    }

    @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
    public Set<String> getAttributeNameSet() {
        Set<String> set = new HashSet<>();
        Stream<String> filter = getAttributeNameSet().stream().filter(name -> {
            return !name.startsWith(__ASYNC_PREFIX);
        });
        Objects.requireNonNull(set);
        filter.forEach((v1) -> {
            r1.add(v1);
        });
        if (this._requestURI != null) {
            set.add(AsyncContext.ASYNC_REQUEST_URI);
        }
        if (this._contextPath != null) {
            set.add(AsyncContext.ASYNC_CONTEXT_PATH);
        }
        if (this._servletPath != null) {
            set.add(AsyncContext.ASYNC_SERVLET_PATH);
        }
        if (this._pathInfo != null) {
            set.add(AsyncContext.ASYNC_PATH_INFO);
        }
        if (this._queryString != null) {
            set.add(AsyncContext.ASYNC_QUERY_STRING);
        }
        return set;
    }

    @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
    public void setAttribute(String key, Object value) {
        char c = 65535;
        switch (key.hashCode()) {
            case -976679287:
                if (key.equals(AsyncContext.ASYNC_REQUEST_URI)) {
                    c = 0;
                    break;
                }
                break;
            case -697442667:
                if (key.equals(AsyncContext.ASYNC_PATH_INFO)) {
                    c = 3;
                    break;
                }
                break;
            case -398790776:
                if (key.equals(AsyncContext.ASYNC_CONTEXT_PATH)) {
                    c = 1;
                    break;
                }
                break;
            case 79701563:
                if (key.equals(AsyncContext.ASYNC_QUERY_STRING)) {
                    c = 4;
                    break;
                }
                break;
            case 1982251186:
                if (key.equals(AsyncContext.ASYNC_SERVLET_PATH)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this._requestURI = (String) value;
                return;
            case 1:
                this._contextPath = (String) value;
                return;
            case 2:
                this._servletPath = (String) value;
                return;
            case 3:
                this._pathInfo = (String) value;
                return;
            case 4:
                this._queryString = (String) value;
                return;
            default:
                setAttribute(key, value);
                return;
        }
    }

    @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
    public void clearAttributes() {
        this._requestURI = null;
        this._contextPath = null;
        this._servletPath = null;
        this._pathInfo = null;
        this._queryString = null;
        clearAttributes();
    }

    public static void applyAsyncAttributes(Attributes attributes, String requestURI, String contextPath, String servletPath, String pathInfo, String queryString) {
        if (requestURI != null) {
            attributes.setAttribute(AsyncContext.ASYNC_REQUEST_URI, requestURI);
        }
        if (contextPath != null) {
            attributes.setAttribute(AsyncContext.ASYNC_CONTEXT_PATH, contextPath);
        }
        if (servletPath != null) {
            attributes.setAttribute(AsyncContext.ASYNC_SERVLET_PATH, servletPath);
        }
        if (pathInfo != null) {
            attributes.setAttribute(AsyncContext.ASYNC_PATH_INFO, pathInfo);
        }
        if (queryString != null) {
            attributes.setAttribute(AsyncContext.ASYNC_QUERY_STRING, queryString);
        }
    }
}
