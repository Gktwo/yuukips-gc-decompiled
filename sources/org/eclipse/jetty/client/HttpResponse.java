package org.eclipse.jetty.client;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpVersion;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpResponse.class */
public class HttpResponse implements Response {
    private final HttpFields headers = new HttpFields();
    private final Request request;
    private final List<Response.ResponseListener> listeners;
    private HttpVersion version;
    private int status;
    private String reason;
    private HttpFields trailers;

    public HttpResponse(Request request, List<Response.ResponseListener> listeners) {
        this.request = request;
        this.listeners = listeners;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public Request getRequest() {
        return this.request;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public HttpVersion getVersion() {
        return this.version;
    }

    public HttpResponse version(HttpVersion version) {
        this.version = version;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public int getStatus() {
        return this.status;
    }

    public HttpResponse status(int status) {
        this.status = status;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public String getReason() {
        return this.reason;
    }

    public HttpResponse reason(String reason) {
        this.reason = reason;
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public HttpFields getHeaders() {
        return this.headers;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public <T extends Response.ResponseListener> List<T> getListeners(Class<T> type) {
        ArrayList arrayList = new ArrayList();
        for (Response.ResponseListener listener : this.listeners) {
            if (type == null || type.isInstance(listener)) {
                arrayList.add(listener);
            }
        }
        return arrayList;
    }

    public HttpFields getTrailers() {
        return this.trailers;
    }

    public HttpResponse trailer(HttpField trailer) {
        if (this.trailers == null) {
            this.trailers = new HttpFields();
        }
        this.trailers.add(trailer);
        return this;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public boolean abort(Throwable cause) {
        return this.request.abort(cause);
    }

    public String toString() {
        return String.format("%s[%s %d %s]@%x", HttpResponse.class.getSimpleName(), getVersion(), Integer.valueOf(getStatus()), getReason(), Integer.valueOf(hashCode()));
    }
}
