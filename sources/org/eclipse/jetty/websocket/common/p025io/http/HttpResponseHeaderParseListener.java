package org.eclipse.jetty.websocket.common.p025io.http;

import java.nio.ByteBuffer;

/* renamed from: org.eclipse.jetty.websocket.common.io.http.HttpResponseHeaderParseListener */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/http/HttpResponseHeaderParseListener.class */
public interface HttpResponseHeaderParseListener {
    void addHeader(String str, String str2);

    void setRemainingBuffer(ByteBuffer byteBuffer);

    void setStatusCode(int i);

    void setStatusReason(String str);
}
