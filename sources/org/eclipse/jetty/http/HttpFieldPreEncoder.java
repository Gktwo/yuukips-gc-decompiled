package org.eclipse.jetty.http;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpFieldPreEncoder.class */
public interface HttpFieldPreEncoder {
    HttpVersion getHttpVersion();

    byte[] getEncodedField(HttpHeader httpHeader, String str, String str2);
}
