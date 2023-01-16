package org.eclipse.jetty.p023io;

import java.net.Socket;
import java.nio.ByteBuffer;

/* renamed from: org.eclipse.jetty.io.NetworkTrafficListener */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/NetworkTrafficListener.class */
public interface NetworkTrafficListener {
    default void opened(Socket socket) {
    }

    default void incoming(Socket socket, ByteBuffer bytes) {
    }

    default void outgoing(Socket socket, ByteBuffer bytes) {
    }

    default void closed(Socket socket) {
    }

    @Deprecated
    /* renamed from: org.eclipse.jetty.io.NetworkTrafficListener$Adapter */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/NetworkTrafficListener$Adapter.class */
    public static class Adapter implements NetworkTrafficListener {
        @Override // org.eclipse.jetty.p023io.NetworkTrafficListener
        public void opened(Socket socket) {
        }

        @Override // org.eclipse.jetty.p023io.NetworkTrafficListener
        public void incoming(Socket socket, ByteBuffer bytes) {
        }

        @Override // org.eclipse.jetty.p023io.NetworkTrafficListener
        public void outgoing(Socket socket, ByteBuffer bytes) {
        }

        @Override // org.eclipse.jetty.p023io.NetworkTrafficListener
        public void closed(Socket socket) {
        }
    }
}
