package org.eclipse.jetty.server;

import java.util.Set;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/PushBuilderImpl.class */
public class PushBuilderImpl implements PushBuilder {
    private static final Logger LOG = Log.getLogger(PushBuilderImpl.class);
    private static final HttpField JettyPush = new HttpField("x-http2-push", "PushBuilder");
    private final Request _request;
    private final HttpFields _fields;
    private String _method;
    private String _queryString;
    private String _sessionId;
    private boolean _conditional;
    private String _path;
    private String _etag;
    private String _lastModified;

    public PushBuilderImpl(Request request, HttpFields fields, String method, String queryString, String sessionId, boolean conditional) {
        this._request = request;
        this._fields = fields;
        this._method = method;
        this._queryString = queryString;
        this._sessionId = sessionId;
        this._conditional = conditional;
        this._fields.add(JettyPush);
        if (LOG.isDebugEnabled()) {
            LOG.debug("PushBuilder({} {}?{} s={} c={})", this._method, this._request.getRequestURI(), this._queryString, this._sessionId, Boolean.valueOf(this._conditional));
        }
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getMethod() {
        return this._method;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder method(String method) {
        this._method = method;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getQueryString() {
        return this._queryString;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder queryString(String queryString) {
        this._queryString = queryString;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getSessionId() {
        return this._sessionId;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder sessionId(String sessionId) {
        this._sessionId = sessionId;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public boolean isConditional() {
        return this._conditional;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder conditional(boolean conditional) {
        this._conditional = conditional;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public Set<String> getHeaderNames() {
        return this._fields.getFieldNamesCollection();
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getHeader(String name) {
        return this._fields.get(name);
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder setHeader(String name, String value) {
        this._fields.put(name, value);
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder addHeader(String name, String value) {
        this._fields.add(name, value);
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder removeHeader(String name) {
        this._fields.remove(name);
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getPath() {
        return this._path;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder path(String path) {
        this._path = path;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getEtag() {
        return this._etag;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder etag(String etag) {
        this._etag = etag;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public String getLastModified() {
        return this._lastModified;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public PushBuilder lastModified(String lastModified) {
        this._lastModified = lastModified;
        return this;
    }

    @Override // org.eclipse.jetty.server.PushBuilder
    public void push() {
        if (HttpMethod.POST.m40is(this._method) || HttpMethod.PUT.m40is(this._method)) {
            throw new IllegalStateException("Bad Method " + this._method);
        } else if (this._path == null || this._path.length() == 0) {
            throw new IllegalStateException("Bad Path " + this._path);
        } else {
            String path = this._path;
            String query = this._queryString;
            int q = path.indexOf(63);
            if (q >= 0) {
                query = (query == null || query.length() <= 0) ? path.substring(q + 1) : path.substring(q + 1) + '&' + query;
                path = path.substring(0, q);
            }
            if (!path.startsWith("/")) {
                path = URIUtil.addPaths(this._request.getContextPath(), path);
            }
            String param = null;
            if (this._sessionId != null && this._request.isRequestedSessionIdFromURL()) {
                param = "jsessionid=" + this._sessionId;
            }
            if (this._conditional) {
                if (this._etag != null) {
                    this._fields.add(HttpHeader.IF_NONE_MATCH, this._etag);
                } else if (this._lastModified != null) {
                    this._fields.add(HttpHeader.IF_MODIFIED_SINCE, this._lastModified);
                }
            }
            HttpURI uri = HttpURI.createHttpURI(this._request.getScheme(), this._request.getServerName(), this._request.getServerPort(), path, param, query, null);
            MetaData.Request push = new MetaData.Request(this._method, uri, this._request.getHttpVersion(), this._fields);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Push {} {} inm={} ims={}", this._method, uri, this._fields.get(HttpHeader.IF_NONE_MATCH), this._fields.get(HttpHeader.IF_MODIFIED_SINCE));
            }
            this._request.getHttpChannel().getHttpTransport().push(push);
            this._path = null;
            this._etag = null;
            this._lastModified = null;
        }
    }
}
