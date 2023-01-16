package org.eclipse.jetty.p023io;

/* renamed from: org.eclipse.jetty.io.NegotiatingClientConnectionFactory */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/NegotiatingClientConnectionFactory.class */
public abstract class NegotiatingClientConnectionFactory implements ClientConnectionFactory {
    private final ClientConnectionFactory connectionFactory;

    protected NegotiatingClientConnectionFactory(ClientConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ClientConnectionFactory getClientConnectionFactory() {
        return this.connectionFactory;
    }
}
