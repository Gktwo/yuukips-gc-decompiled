package org.eclipse.jetty.http;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/Http1FieldPreEncoder.class */
public class Http1FieldPreEncoder implements HttpFieldPreEncoder {
    @Override // org.eclipse.jetty.http.HttpFieldPreEncoder
    public HttpVersion getHttpVersion() {
        return HttpVersion.HTTP_1_0;
    }

    @Override // org.eclipse.jetty.http.HttpFieldPreEncoder
    public byte[] getEncodedField(HttpHeader header, String headerString, String value) {
        if (header != null) {
            int cbl = header.getBytesColonSpace().length;
            byte[] bytes = Arrays.copyOf(header.getBytesColonSpace(), cbl + value.length() + 2);
            System.arraycopy(value.getBytes(StandardCharsets.ISO_8859_1), 0, bytes, cbl, value.length());
            bytes[bytes.length - 2] = 13;
            bytes[bytes.length - 1] = 10;
            return bytes;
        }
        byte[] n = headerString.getBytes(StandardCharsets.ISO_8859_1);
        byte[] v = value.getBytes(StandardCharsets.ISO_8859_1);
        byte[] bytes2 = Arrays.copyOf(n, n.length + 2 + v.length + 2);
        bytes2[n.length] = 58;
        bytes2[n.length + 1] = 32;
        System.arraycopy(v, 0, bytes2, n.length + 2, v.length);
        bytes2[bytes2.length - 2] = 13;
        bytes2[bytes2.length - 1] = 10;
        return bytes2;
    }
}
