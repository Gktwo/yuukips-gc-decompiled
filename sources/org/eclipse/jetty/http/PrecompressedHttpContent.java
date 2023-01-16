package org.eclipse.jetty.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/PrecompressedHttpContent.class */
public class PrecompressedHttpContent implements HttpContent {
    private final HttpContent _content;
    private final HttpContent _precompressedContent;
    private final CompressedContentFormat _format;

    public PrecompressedHttpContent(HttpContent content, HttpContent precompressedContent, CompressedContentFormat format) {
        this._content = content;
        this._precompressedContent = precompressedContent;
        this._format = format;
        if (this._precompressedContent == null || this._format == null) {
            throw new NullPointerException("Missing compressed content and/or format");
        }
    }

    public int hashCode() {
        return this._content.hashCode();
    }

    public boolean equals(Object obj) {
        return this._content.equals(obj);
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public Resource getResource() {
        return this._content.getResource();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getETag() {
        return new HttpField(HttpHeader.ETAG, getETagValue());
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getETagValue() {
        return this._content.getResource().getWeakETag(this._format.getEtagSuffix());
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getLastModified() {
        return this._content.getLastModified();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getLastModifiedValue() {
        return this._content.getLastModifiedValue();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getContentType() {
        return this._content.getContentType();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getContentTypeValue() {
        return this._content.getContentTypeValue();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getContentEncoding() {
        return this._format.getContentEncoding();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getContentEncodingValue() {
        return this._format.getContentEncoding().getValue();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public String getCharacterEncoding() {
        return this._content.getCharacterEncoding();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public MimeTypes.Type getMimeType() {
        return this._content.getMimeType();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public void release() {
        this._content.release();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public ByteBuffer getIndirectBuffer() {
        return this._precompressedContent.getIndirectBuffer();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public ByteBuffer getDirectBuffer() {
        return this._precompressedContent.getDirectBuffer();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public HttpField getContentLength() {
        return this._precompressedContent.getContentLength();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public long getContentLengthValue() {
        return this._precompressedContent.getContentLengthValue();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public InputStream getInputStream() throws IOException {
        return this._precompressedContent.getInputStream();
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return this._precompressedContent.getReadableByteChannel();
    }

    public String toString() {
        return String.format("%s@%x{e=%s,r=%s|%s,lm=%s|%s,ct=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._format, this._content.getResource(), this._precompressedContent.getResource(), Long.valueOf(this._content.getResource().lastModified()), Long.valueOf(this._precompressedContent.getResource().lastModified()), getContentType());
    }

    @Override // org.eclipse.jetty.http.HttpContent
    public Map<CompressedContentFormat, HttpContent> getPrecompressedContents() {
        return null;
    }
}
