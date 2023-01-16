package org.eclipse.jetty.p023io.ssl;

import java.util.EventListener;
import java.util.EventObject;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;

/* renamed from: org.eclipse.jetty.io.ssl.SslHandshakeListener */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslHandshakeListener.class */
public interface SslHandshakeListener extends EventListener {
    default void handshakeSucceeded(Event event) throws SSLException {
    }

    default void handshakeFailed(Event event, Throwable failure) {
    }

    /* renamed from: org.eclipse.jetty.io.ssl.SslHandshakeListener$Event */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslHandshakeListener$Event.class */
    public static class Event extends EventObject {
        public Event(Object source) {
            super(source);
        }

        public SSLEngine getSSLEngine() {
            return (SSLEngine) getSource();
        }
    }
}
