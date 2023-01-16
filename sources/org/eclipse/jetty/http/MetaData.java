package org.eclipse.jetty.http;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Supplier;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/MetaData.class */
public class MetaData implements Iterable<HttpField> {
    private HttpVersion _httpVersion;
    private final HttpFields _fields;
    private long _contentLength;
    private Supplier<HttpFields> _trailers;

    public MetaData(HttpVersion version, HttpFields fields) {
        this(version, fields, Long.MIN_VALUE);
    }

    public MetaData(HttpVersion version, HttpFields fields, long contentLength) {
        this._httpVersion = version;
        this._fields = fields;
        this._contentLength = contentLength;
    }

    protected void recycle() {
        this._httpVersion = null;
        if (this._fields != null) {
            this._fields.clear();
        }
        this._contentLength = Long.MIN_VALUE;
    }

    public boolean isRequest() {
        return false;
    }

    public boolean isResponse() {
        return false;
    }

    @Deprecated
    public HttpVersion getVersion() {
        return getHttpVersion();
    }

    public HttpVersion getHttpVersion() {
        return this._httpVersion;
    }

    public void setHttpVersion(HttpVersion httpVersion) {
        this._httpVersion = httpVersion;
    }

    public HttpFields getFields() {
        return this._fields;
    }

    public Supplier<HttpFields> getTrailerSupplier() {
        return this._trailers;
    }

    public void setTrailerSupplier(Supplier<HttpFields> trailers) {
        this._trailers = trailers;
    }

    public long getContentLength() {
        if (this._contentLength == Long.MIN_VALUE && this._fields != null) {
            HttpField field = this._fields.getField(HttpHeader.CONTENT_LENGTH);
            this._contentLength = field == null ? -1 : field.getLongValue();
        }
        return this._contentLength;
    }

    public void setContentLength(long contentLength) {
        this._contentLength = contentLength;
    }

    @Override // java.lang.Iterable
    public Iterator<HttpField> iterator() {
        HttpFields fields = getFields();
        return fields == null ? Collections.emptyIterator() : fields.iterator();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder out = new StringBuilder();
        Iterator<HttpField> it = iterator();
        while (it.hasNext()) {
            out.append(it.next()).append(System.lineSeparator());
        }
        return out.toString();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MetaData$Request.class */
    public static class Request extends MetaData {
        private String _method;
        private HttpURI _uri;

        public Request(HttpFields fields) {
            this(null, null, null, fields);
        }

        public Request(String method, HttpURI uri, HttpVersion version, HttpFields fields) {
            this(method, uri, version, fields, Long.MIN_VALUE);
        }

        public Request(String method, HttpURI uri, HttpVersion version, HttpFields fields, long contentLength) {
            super(version, fields, contentLength);
            this._method = method;
            this._uri = uri;
        }

        public Request(String method, HttpScheme scheme, HostPortHttpField hostPort, String uri, HttpVersion version, HttpFields fields) {
            this(method, new HttpURI(scheme == null ? null : scheme.asString(), hostPort == null ? null : hostPort.getHost(), hostPort == null ? -1 : hostPort.getPort(), uri), version, fields);
        }

        public Request(String method, HttpScheme scheme, HostPortHttpField hostPort, String uri, HttpVersion version, HttpFields fields, long contentLength) {
            this(method, new HttpURI(scheme == null ? null : scheme.asString(), hostPort == null ? null : hostPort.getHost(), hostPort == null ? -1 : hostPort.getPort(), uri), version, fields, contentLength);
        }

        public Request(String method, String scheme, HostPortHttpField hostPort, String uri, HttpVersion version, HttpFields fields, long contentLength) {
            this(method, new HttpURI(scheme, hostPort == null ? null : hostPort.getHost(), hostPort == null ? -1 : hostPort.getPort(), uri), version, fields, contentLength);
        }

        public Request(Request request) {
            this(request.getMethod(), new HttpURI(request.getURI()), request.getHttpVersion(), new HttpFields(request.getFields()), request.getContentLength());
        }

        @Override // org.eclipse.jetty.http.MetaData
        public void recycle() {
            recycle();
            this._method = null;
            if (this._uri != null) {
                this._uri.clear();
            }
        }

        @Override // org.eclipse.jetty.http.MetaData
        public boolean isRequest() {
            return true;
        }

        public String getMethod() {
            return this._method;
        }

        public void setMethod(String method) {
            this._method = method;
        }

        public HttpURI getURI() {
            return this._uri;
        }

        public String getURIString() {
            if (this._uri == null) {
                return null;
            }
            return this._uri.toString();
        }

        public void setURI(HttpURI uri) {
            this._uri = uri;
        }

        @Override // org.eclipse.jetty.http.MetaData, java.lang.Object
        public String toString() {
            HttpFields fields = getFields();
            Object[] objArr = new Object[5];
            objArr[0] = getMethod();
            objArr[1] = getURI();
            objArr[2] = getHttpVersion();
            objArr[3] = Integer.valueOf(fields == null ? -1 : fields.size());
            objArr[4] = Long.valueOf(getContentLength());
            return String.format("%s{u=%s,%s,h=%d,cl=%d}", objArr);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MetaData$Response.class */
    public static class Response extends MetaData {
        private int _status;
        private String _reason;

        public Response() {
            this(null, 0, null);
        }

        public Response(HttpVersion version, int status, HttpFields fields) {
            this(version, status, fields, Long.MIN_VALUE);
        }

        public Response(HttpVersion version, int status, HttpFields fields, long contentLength) {
            super(version, fields, contentLength);
            this._status = status;
        }

        public Response(HttpVersion version, int status, String reason, HttpFields fields, long contentLength) {
            super(version, fields, contentLength);
            this._reason = reason;
            this._status = status;
        }

        @Override // org.eclipse.jetty.http.MetaData
        public boolean isResponse() {
            return true;
        }

        public int getStatus() {
            return this._status;
        }

        public String getReason() {
            return this._reason;
        }

        public void setStatus(int status) {
            this._status = status;
        }

        public void setReason(String reason) {
            this._reason = reason;
        }

        @Override // org.eclipse.jetty.http.MetaData, java.lang.Object
        public String toString() {
            HttpFields fields = getFields();
            Object[] objArr = new Object[4];
            objArr[0] = getHttpVersion();
            objArr[1] = Integer.valueOf(getStatus());
            objArr[2] = Integer.valueOf(fields == null ? -1 : fields.size());
            objArr[3] = Long.valueOf(getContentLength());
            return String.format("%s{s=%d,h=%d,cl=%d}", objArr);
        }
    }
}
