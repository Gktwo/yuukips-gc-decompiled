package org.eclipse.jetty.client.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/StringContentProvider.class */
public class StringContentProvider extends BytesContentProvider {
    public StringContentProvider(String content) {
        this(content, StandardCharsets.UTF_8);
    }

    public StringContentProvider(String content, String encoding) {
        this(content, Charset.forName(encoding));
    }

    public StringContentProvider(String content, Charset charset) {
        this("text/plain;charset=" + charset.name(), content, charset);
    }

    public StringContentProvider(String contentType, String content, Charset charset) {
        super(contentType, content.getBytes(charset));
    }
}
