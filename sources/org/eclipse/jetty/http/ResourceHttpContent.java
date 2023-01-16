package org.eclipse.jetty.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/ResourceHttpContent.class */
public class ResourceHttpContent implements HttpContent {
    final Resource _resource;
    final String _contentType;
    final int _maxBuffer;
    Map<CompressedContentFormat, HttpContent> _precompressedContents;
    String _etag;

    public ResourceHttpContent(Resource resource, String contentType) {
        this(resource, contentType, -1, null);
    }

    public ResourceHttpContent(Resource resource, String contentType, int maxBuffer) {
        this(resource, contentType, maxBuffer, null);
    }

    public ResourceHttpContent(Resource resource, String contentType, int maxBuffer, Map<CompressedContentFormat, HttpContent> precompressedContents) {
        this._resource = resource;
        this._contentType = contentType;
        this._maxBuffer = maxBuffer;
        if (precompressedContents == null) {
            this._precompressedContents = null;
            return;
        }
        this._precompressedContents = new HashMap(precompressedContents.size());
        for (Map.Entry<CompressedContentFormat, HttpContent> entry : precompressedContents.entrySet()) {
            this._precompressedContents.put(entry.getKey(), new PrecompressedHttpContent(this, entry.getValue(), entry.getKey()));
        }
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getContentTypeValue() {
        return this._contentType;
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getContentType() {
        if (this._contentType == null) {
            return null;
        }
        return new HttpField(HttpHeader.CONTENT_TYPE, this._contentType);
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getContentEncoding() {
        return null;
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getContentEncodingValue() {
        return null;
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getCharacterEncoding() {
        if (this._contentType == null) {
            return null;
        }
        return MimeTypes.getCharsetFromContentType(this._contentType);
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public MimeTypes.Type getMimeType() {
        if (this._contentType == null) {
            return null;
        }
        return MimeTypes.CACHE.get(MimeTypes.getContentTypeWithoutCharset(this._contentType));
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getLastModified() {
        long lm = this._resource.lastModified();
        if (lm >= 0) {
            return new HttpField(HttpHeader.LAST_MODIFIED, DateGenerator.formatDate(lm));
        }
        return null;
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getLastModifiedValue() {
        long lm = this._resource.lastModified();
        if (lm >= 0) {
            return DateGenerator.formatDate(lm);
        }
        return null;
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public ByteBuffer getDirectBuffer() {
        if (this._resource.length() <= 0) {
            return null;
        }
        if (this._maxBuffer > 0 && this._resource.length() > ((long) this._maxBuffer)) {
            return null;
        }
        try {
            return BufferUtil.toBuffer(this._resource, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getETag() {
        return new HttpField(HttpHeader.ETAG, getETagValue());
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getETagValue() {
        return this._resource.getWeakETag();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public ByteBuffer getIndirectBuffer() {
        if (this._resource.length() <= 0) {
            return null;
        }
        if (this._maxBuffer > 0 && this._resource.length() > ((long) this._maxBuffer)) {
            return null;
        }
        try {
            return BufferUtil.toBuffer(this._resource, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getContentLength() {
        long l = this._resource.length();
        if (l == -1) {
            return null;
        }
        return new HttpField.LongValueHttpField(HttpHeader.CONTENT_LENGTH, l);
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public long getContentLengthValue() {
        return this._resource.length();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public InputStream getInputStream() throws IOException {
        return this._resource.getInputStream();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return this._resource.getReadableByteChannel();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public Resource getResource() {
        return this._resource;
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public void release() {
        this._resource.close();
    }

    public String toString() {
        Object[] objArr = new Object[5];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = this._resource;
        objArr[3] = this._contentType;
        objArr[4] = Boolean.valueOf(this._precompressedContents != null);
        return String.format("%s@%x{r=%s,ct=%s,c=%b}", objArr);
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public Map<CompressedContentFormat, HttpContent> getPrecompressedContents() {
        return this._precompressedContents;
    }
}
