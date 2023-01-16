package org.eclipse.jetty.client.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.util.BufferUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/BufferingResponseListener.class */
public abstract class BufferingResponseListener extends Response.Listener.Adapter {
    private final int maxLength;
    private ByteBuffer buffer;
    private String mediaType;
    private String encoding;

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
    public abstract void onComplete(Result result);

    public BufferingResponseListener() {
        this(2097152);
    }

    public BufferingResponseListener(int maxLength) {
        if (maxLength < 0) {
            throw new IllegalArgumentException("Invalid max length " + maxLength);
        }
        this.maxLength = maxLength;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.HeadersListener
    public void onHeaders(Response response) {
        onHeaders(response);
        Request request = response.getRequest();
        HttpFields headers = response.getHeaders();
        char longField = headers.getLongField(HttpHeader.CONTENT_LENGTH.asString());
        if (HttpMethod.HEAD.m40is(request.getMethod())) {
            longField = 0;
        }
        if (longField > ((long) this.maxLength)) {
            response.abort(new IllegalArgumentException("Buffering capacity " + this.maxLength + " exceeded"));
            return;
        }
        String contentType = headers.get(HttpHeader.CONTENT_TYPE);
        if (contentType != null) {
            String media = contentType;
            int index = contentType.toLowerCase(Locale.ENGLISH).indexOf("charset=");
            if (index > 0) {
                media = contentType.substring(0, index);
                String encoding = contentType.substring(index + "charset=".length());
                int semicolon = encoding.indexOf(59);
                if (semicolon > 0) {
                    encoding = encoding.substring(0, semicolon).trim();
                }
                int lastIndex = encoding.length() - 1;
                if (encoding.charAt(0) == '\"' && encoding.charAt(lastIndex) == '\"') {
                    encoding = encoding.substring(1, lastIndex).trim();
                }
                this.encoding = encoding;
            }
            int semicolon2 = media.indexOf(59);
            if (semicolon2 > 0) {
                media = media.substring(0, semicolon2).trim();
            }
            this.mediaType = media;
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.ContentListener
    public void onContent(Response response, ByteBuffer content) {
        int length = content.remaining();
        if (length > BufferUtil.space(this.buffer)) {
            if ((this.buffer == null ? 0 : this.buffer.remaining()) + length > this.maxLength) {
                response.abort(new IllegalArgumentException("Buffering capacity " + this.maxLength + " exceeded"));
            }
            this.buffer = BufferUtil.ensureCapacity(this.buffer, Math.min(Integer.highestOneBit(this.buffer == null ? length : this.buffer.capacity() + length) << 1, this.maxLength));
        }
        BufferUtil.append(this.buffer, content);
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public byte[] getContent() {
        if (this.buffer == null) {
            return new byte[0];
        }
        return BufferUtil.toArray(this.buffer);
    }

    public String getContentAsString() {
        String encoding = this.encoding;
        if (encoding == null) {
            return getContentAsString(StandardCharsets.UTF_8);
        }
        return getContentAsString(encoding);
    }

    public String getContentAsString(String encoding) {
        if (this.buffer == null) {
            return null;
        }
        return BufferUtil.toString(this.buffer, Charset.forName(encoding));
    }

    public String getContentAsString(Charset encoding) {
        if (this.buffer == null) {
            return null;
        }
        return BufferUtil.toString(this.buffer, encoding);
    }

    public InputStream getContentAsInputStream() {
        if (this.buffer == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        return new ByteArrayInputStream(this.buffer.array(), this.buffer.arrayOffset(), this.buffer.remaining());
    }
}
