package org.eclipse.jetty.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpContent.class */
public interface HttpContent {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpContent$ContentFactory.class */
    public interface ContentFactory {
        HttpContent getContent(String str, int i) throws IOException;
    }

    HttpField getContentType();

    String getContentTypeValue();

    String getCharacterEncoding();

    MimeTypes.Type getMimeType();

    HttpField getContentEncoding();

    String getContentEncodingValue();

    HttpField getContentLength();

    long getContentLengthValue();

    HttpField getLastModified();

    String getLastModifiedValue();

    HttpField getETag();

    String getETagValue();

    ByteBuffer getIndirectBuffer();

    ByteBuffer getDirectBuffer();

    Resource getResource();

    InputStream getInputStream() throws IOException;

    ReadableByteChannel getReadableByteChannel() throws IOException;

    void release();

    Map<CompressedContentFormat, ? extends HttpContent> getPrecompressedContents();
}
