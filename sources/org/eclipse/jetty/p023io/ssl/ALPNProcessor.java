package org.eclipse.jetty.p023io.ssl;

import javax.net.ssl.SSLEngine;
import org.eclipse.jetty.p023io.Connection;

/* renamed from: org.eclipse.jetty.io.ssl.ALPNProcessor */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/ALPNProcessor.class */
public interface ALPNProcessor {

    /* renamed from: org.eclipse.jetty.io.ssl.ALPNProcessor$Client */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/ALPNProcessor$Client.class */
    public interface Client extends ALPNProcessor {
    }

    /* renamed from: org.eclipse.jetty.io.ssl.ALPNProcessor$Server */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/ALPNProcessor$Server.class */
    public interface Server extends ALPNProcessor {
    }

    default void init() {
    }

    default boolean appliesTo(SSLEngine sslEngine) {
        return false;
    }

    default void configure(SSLEngine sslEngine, Connection connection) {
    }
}
