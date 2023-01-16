package org.eclipse.jetty.client;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpVersion;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpContentResponse.class */
public class HttpContentResponse implements ContentResponse {
    private final Response response;
    private final byte[] content;
    private final String mediaType;
    private final String encoding;

    public HttpContentResponse(Response response, byte[] content, String mediaType, String encoding) {
        this.response = response;
        this.content = content;
        this.mediaType = mediaType;
        this.encoding = encoding;
    }

    @Override // org.eclipse.jetty.client.api.Response
    public Request getRequest() {
        return this.response.getRequest();
    }

    @Override // org.eclipse.jetty.client.api.Response
    public <T extends Response.ResponseListener> List<T> getListeners(Class<T> listenerClass) {
        return this.response.getListeners(listenerClass);
    }

    @Override // org.eclipse.jetty.client.api.Response
    public HttpVersion getVersion() {
        return this.response.getVersion();
    }

    @Override // org.eclipse.jetty.client.api.Response
    public int getStatus() {
        return this.response.getStatus();
    }

    @Override // org.eclipse.jetty.client.api.Response
    public String getReason() {
        return this.response.getReason();
    }

    @Override // org.eclipse.jetty.client.api.Response
    public HttpFields getHeaders() {
        return this.response.getHeaders();
    }

    @Override // org.eclipse.jetty.client.api.Response
    public boolean abort(Throwable cause) {
        return this.response.abort(cause);
    }

    @Override // org.eclipse.jetty.client.api.ContentResponse
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // org.eclipse.jetty.client.api.ContentResponse
    public String getEncoding() {
        return this.encoding;
    }

    @Override // org.eclipse.jetty.client.api.ContentResponse
    public byte[] getContent() {
        return this.content;
    }

    @Override // org.eclipse.jetty.client.api.ContentResponse
    public String getContentAsString() {
        String encoding = this.encoding;
        if (encoding == null) {
            return new String(getContent(), StandardCharsets.UTF_8);
        }
        try {
            return new String(getContent(), encoding);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(encoding);
        }
    }

    public String toString() {
        return String.format("%s[%s %d %s - %d bytes]", HttpContentResponse.class.getSimpleName(), getVersion(), Integer.valueOf(getStatus()), getReason(), Integer.valueOf(getContent().length));
    }
}
