package org.eclipse.jetty.server;

import java.nio.ByteBuffer;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.util.Callback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpTransport.class */
public interface HttpTransport {
    void send(MetaData.Response response, boolean z, ByteBuffer byteBuffer, boolean z2, Callback callback);

    boolean isPushSupported();

    void push(MetaData.Request request);

    void onCompleted();

    void abort(Throwable th);

    boolean isOptimizedForDirectBuffers();
}
