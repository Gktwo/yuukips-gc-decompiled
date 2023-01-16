package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Dispatcher.class */
public class Dispatcher implements RequestDispatcher {
    private static final Logger LOG = Log.getLogger(Dispatcher.class);
    public static final String __INCLUDE_PREFIX = "javax.servlet.include.";
    public static final String __FORWARD_PREFIX = "javax.servlet.forward.";
    private final ContextHandler _contextHandler;
    private final HttpURI _uri;
    private final String _pathInContext;
    private final String _named;

    public Dispatcher(ContextHandler contextHandler, HttpURI uri, String pathInContext) {
        this._contextHandler = contextHandler;
        this._uri = uri;
        this._pathInContext = pathInContext;
        this._named = null;
    }

    public Dispatcher(ContextHandler contextHandler, String name) throws IllegalStateException {
        this._contextHandler = contextHandler;
        this._uri = null;
        this._pathInContext = null;
        this._named = name;
    }

    @Override // javax.servlet.RequestDispatcher
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        forward(request, response, DispatcherType.FORWARD);
    }

    public void error(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        forward(request, response, DispatcherType.ERROR);
    }

    @Override // javax.servlet.RequestDispatcher
    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        Request baseRequest = (Request) Objects.requireNonNull(Request.getBaseRequest(request));
        if (!(request instanceof HttpServletRequest)) {
            request = new ServletRequestHttpWrapper(request);
        }
        if (!(response instanceof HttpServletResponse)) {
            response = new ServletResponseHttpWrapper(response);
        }
        DispatcherType old_type = baseRequest.getDispatcherType();
        Attributes old_attr = baseRequest.getAttributes();
        MultiMap<String> old_query_params = baseRequest.getQueryParameters();
        try {
            baseRequest.setDispatcherType(DispatcherType.INCLUDE);
            baseRequest.getResponse().include();
            if (this._named != null) {
                this._contextHandler.handle(this._named, baseRequest, (HttpServletRequest) request, (HttpServletResponse) response);
            } else {
                Objects.requireNonNull(this._uri);
                checkUriViolations(this._uri, baseRequest);
                IncludeAttributes attr = new IncludeAttributes(old_attr);
                attr._requestURI = this._uri.getPath();
                attr._contextPath = this._contextHandler.getRequestContextPath();
                attr._servletPath = null;
                attr._pathInfo = this._pathInContext;
                attr._query = this._uri.getQuery();
                if (attr._query != null) {
                    baseRequest.mergeQueryParameters(baseRequest.getQueryString(), attr._query, false);
                }
                baseRequest.setAttributes(attr);
                this._contextHandler.handle(this._pathInContext, baseRequest, (HttpServletRequest) request, (HttpServletResponse) response);
            }
        } finally {
            baseRequest.setAttributes(old_attr);
            baseRequest.getResponse().included();
            baseRequest.setQueryParameters(old_query_params);
            baseRequest.resetParameters();
            baseRequest.setDispatcherType(old_type);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:21:0x019a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void forward(javax.servlet.ServletRequest r7, javax.servlet.ServletResponse r8, javax.servlet.DispatcherType r9) throws javax.servlet.ServletException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 642
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.Dispatcher.forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.DispatcherType):void");
    }

    private static void checkUriViolations(HttpURI uri, Request baseRequest) {
        HttpCompliance compliance;
        if (uri.hasViolations()) {
            HttpChannel channel = baseRequest.getHttpChannel();
            Connection connection = channel == null ? null : channel.getConnection();
            if (connection instanceof HttpConnection) {
                compliance = ((HttpConnection) connection).getHttpCompliance();
            } else {
                compliance = channel != null ? (HttpCompliance) channel.getConnector().getBean(HttpCompliance.class) : null;
            }
            String illegalState = HttpCompliance.checkUriCompliance(compliance, uri);
            if (illegalState != null) {
                throw new IllegalStateException(illegalState);
            }
        }
    }

    public String toString() {
        return String.format("Dispatcher@0x%x{%s,%s}", Integer.valueOf(hashCode()), this._named, this._uri);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Dispatcher$ForwardAttributes.class */
    public class ForwardAttributes extends Attributes.Wrapper {
        private String _requestURI;
        private String _contextPath;
        private String _servletPath;
        private String _pathInfo;
        private String _query;

        ForwardAttributes(Attributes attributes) {
            super(attributes);
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Object getAttribute(String key) {
            if (Dispatcher.this._named == null) {
                char c = 65535;
                switch (key.hashCode()) {
                    case -1446311223:
                        if (key.equals(RequestDispatcher.FORWARD_SERVLET_PATH)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -671636078:
                        if (key.equals(RequestDispatcher.FORWARD_REQUEST_URI)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 467614111:
                        if (key.equals(RequestDispatcher.FORWARD_CONTEXT_PATH)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 809018334:
                        if (key.equals(RequestDispatcher.FORWARD_PATH_INFO)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 946106450:
                        if (key.equals(RequestDispatcher.FORWARD_QUERY_STRING)) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return this._pathInfo;
                    case 1:
                        return this._requestURI;
                    case 2:
                        return this._servletPath;
                    case 3:
                        return this._contextPath;
                    case 4:
                        return this._query;
                }
            }
            if (key.startsWith(Dispatcher.__INCLUDE_PREFIX)) {
                return null;
            }
            return this._attributes.getAttribute(key);
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Set<String> getAttributeNameSet() {
            HashSet<String> set = new HashSet<>();
            Stream<String> filter = getAttributeNameSet().stream().filter(name -> {
                return !name.startsWith(Dispatcher.__INCLUDE_PREFIX);
            }).filter(name -> {
                return !name.startsWith(Dispatcher.__FORWARD_PREFIX);
            });
            Objects.requireNonNull(set);
            filter.forEach((v1) -> {
                r1.add(v1);
            });
            if (Dispatcher.this._named == null) {
                if (this._pathInfo != null) {
                    set.add(RequestDispatcher.FORWARD_PATH_INFO);
                }
                if (this._requestURI != null) {
                    set.add(RequestDispatcher.FORWARD_REQUEST_URI);
                }
                if (this._servletPath != null) {
                    set.add(RequestDispatcher.FORWARD_SERVLET_PATH);
                }
                if (this._contextPath != null) {
                    set.add(RequestDispatcher.FORWARD_CONTEXT_PATH);
                }
                if (this._query != null) {
                    set.add(RequestDispatcher.FORWARD_QUERY_STRING);
                }
            }
            return set;
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public void setAttribute(String key, Object value) {
            if (Dispatcher.this._named == null && key.startsWith("javax.servlet.")) {
                char c = 65535;
                switch (key.hashCode()) {
                    case -1446311223:
                        if (key.equals(RequestDispatcher.FORWARD_SERVLET_PATH)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -671636078:
                        if (key.equals(RequestDispatcher.FORWARD_REQUEST_URI)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 467614111:
                        if (key.equals(RequestDispatcher.FORWARD_CONTEXT_PATH)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 809018334:
                        if (key.equals(RequestDispatcher.FORWARD_PATH_INFO)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 946106450:
                        if (key.equals(RequestDispatcher.FORWARD_QUERY_STRING)) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this._pathInfo = (String) value;
                        return;
                    case 1:
                        this._requestURI = (String) value;
                        return;
                    case 2:
                        this._servletPath = (String) value;
                        return;
                    case 3:
                        this._contextPath = (String) value;
                        return;
                    case 4:
                        this._query = (String) value;
                        return;
                    default:
                        if (value == null) {
                            this._attributes.removeAttribute(key);
                            return;
                        } else {
                            this._attributes.setAttribute(key, value);
                            return;
                        }
                }
            } else if (value == null) {
                this._attributes.removeAttribute(key);
            } else {
                this._attributes.setAttribute(key, value);
            }
        }

        public String toString() {
            return "FORWARD+" + this._attributes.toString();
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public void clearAttributes() {
            throw new IllegalStateException();
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public void removeAttribute(String name) {
            setAttribute(name, null);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/Dispatcher$IncludeAttributes.class */
    private class IncludeAttributes extends Attributes.Wrapper {
        private String _requestURI;
        private String _contextPath;
        private String _servletPath;
        private String _pathInfo;
        private String _query;

        IncludeAttributes(Attributes attributes) {
            super(attributes);
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Object getAttribute(String key) {
            if (Dispatcher.this._named == null) {
                char c = 65535;
                switch (key.hashCode()) {
                    case -1601904484:
                        if (key.equals(RequestDispatcher.INCLUDE_CONTEXT_PATH)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1431131403:
                        if (key.equals(RequestDispatcher.INCLUDE_REQUEST_URI)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1123412145:
                        if (key.equals(RequestDispatcher.INCLUDE_QUERY_STRING)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 330016257:
                        if (key.equals(RequestDispatcher.INCLUDE_PATH_INFO)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 779137478:
                        if (key.equals(RequestDispatcher.INCLUDE_SERVLET_PATH)) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return this._pathInfo;
                    case 1:
                        return this._servletPath;
                    case 2:
                        return this._contextPath;
                    case 3:
                        return this._query;
                    case 4:
                        return this._requestURI;
                }
            } else if (key.startsWith(Dispatcher.__INCLUDE_PREFIX)) {
                return null;
            }
            return this._attributes.getAttribute(key);
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Set<String> getAttributeNameSet() {
            HashSet<String> set = new HashSet<>();
            Stream<String> filter = getAttributeNameSet().stream().filter(name -> {
                return !name.startsWith(Dispatcher.__INCLUDE_PREFIX);
            });
            Objects.requireNonNull(set);
            filter.forEach((v1) -> {
                r1.add(v1);
            });
            if (Dispatcher.this._named == null) {
                if (this._pathInfo != null) {
                    set.add(RequestDispatcher.INCLUDE_PATH_INFO);
                }
                if (this._requestURI != null) {
                    set.add(RequestDispatcher.INCLUDE_REQUEST_URI);
                }
                if (this._servletPath != null) {
                    set.add(RequestDispatcher.INCLUDE_SERVLET_PATH);
                }
                if (this._contextPath != null) {
                    set.add(RequestDispatcher.INCLUDE_CONTEXT_PATH);
                }
                if (this._query != null) {
                    set.add(RequestDispatcher.INCLUDE_QUERY_STRING);
                }
            }
            return set;
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public void setAttribute(String key, Object value) {
            if (Dispatcher.this._named == null && key.startsWith("javax.servlet.")) {
                char c = 65535;
                switch (key.hashCode()) {
                    case -1601904484:
                        if (key.equals(RequestDispatcher.INCLUDE_CONTEXT_PATH)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1431131403:
                        if (key.equals(RequestDispatcher.INCLUDE_REQUEST_URI)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1123412145:
                        if (key.equals(RequestDispatcher.INCLUDE_QUERY_STRING)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 330016257:
                        if (key.equals(RequestDispatcher.INCLUDE_PATH_INFO)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 779137478:
                        if (key.equals(RequestDispatcher.INCLUDE_SERVLET_PATH)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this._pathInfo = (String) value;
                        return;
                    case 1:
                        this._requestURI = (String) value;
                        return;
                    case 2:
                        this._servletPath = (String) value;
                        return;
                    case 3:
                        this._contextPath = (String) value;
                        return;
                    case 4:
                        this._query = (String) value;
                        return;
                    default:
                        if (value == null) {
                            this._attributes.removeAttribute(key);
                            return;
                        } else {
                            this._attributes.setAttribute(key, value);
                            return;
                        }
                }
            } else if (value == null) {
                this._attributes.removeAttribute(key);
            } else {
                this._attributes.setAttribute(key, value);
            }
        }

        public String toString() {
            return "INCLUDE+" + this._attributes.toString();
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public void clearAttributes() {
            throw new IllegalStateException();
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public void removeAttribute(String name) {
            setAttribute(name, null);
        }
    }
}
