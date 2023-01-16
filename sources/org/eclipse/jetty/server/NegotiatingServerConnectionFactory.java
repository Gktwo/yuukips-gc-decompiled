package org.eclipse.jetty.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.net.ssl.SSLEngine;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.ssl.SslConnection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/NegotiatingServerConnectionFactory.class */
public abstract class NegotiatingServerConnectionFactory extends AbstractConnectionFactory {
    private final List<String> negotiatedProtocols = new ArrayList();
    private String defaultProtocol;

    protected abstract AbstractConnection newServerConnection(Connector connector, EndPoint endPoint, SSLEngine sSLEngine, List<String> list, String str);

    public NegotiatingServerConnectionFactory(String protocol, String... negotiatedProtocols) {
        super(protocol);
        if (negotiatedProtocols != null) {
            for (String p : negotiatedProtocols) {
                String p2 = p.trim();
                if (!p2.isEmpty()) {
                    this.negotiatedProtocols.add(p2);
                }
            }
        }
    }

    public String getDefaultProtocol() {
        return this.defaultProtocol;
    }

    public void setDefaultProtocol(String defaultProtocol) {
        String dft = defaultProtocol == null ? "" : defaultProtocol.trim();
        this.defaultProtocol = dft.isEmpty() ? null : dft;
    }

    public List<String> getNegotiatedProtocols() {
        return this.negotiatedProtocols;
    }

    @Override // org.eclipse.jetty.server.ConnectionFactory
    public Connection newConnection(Connector connector, EndPoint endPoint) {
        List<String> negotiated = this.negotiatedProtocols;
        if (negotiated.isEmpty()) {
            negotiated = (List) connector.getProtocols().stream().filter(p -> {
                ConnectionFactory f = connector.getConnectionFactory(p);
                return !(f instanceof SslConnectionFactory) && !(f instanceof NegotiatingServerConnectionFactory);
            }).collect(Collectors.toList());
        }
        String dft = this.defaultProtocol;
        if (dft == null && !negotiated.isEmpty()) {
            Stream<String> stream = negotiated.stream();
            HttpVersion httpVersion = HttpVersion.HTTP_1_1;
            Objects.requireNonNull(httpVersion);
            dft = stream.filter(this::m38is).findFirst().orElse(negotiated.get(0));
        }
        SSLEngine engine = null;
        EndPoint ep = endPoint;
        while (engine == null && ep != null) {
            if (ep instanceof SslConnection.DecryptedEndPoint) {
                engine = ((SslConnection.DecryptedEndPoint) ep).getSslConnection().getSSLEngine();
            } else {
                ep = null;
            }
        }
        return configure(newServerConnection(connector, endPoint, engine, negotiated, dft), connector, endPoint);
    }

    @Override // org.eclipse.jetty.server.AbstractConnectionFactory, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{%s,%s,%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), getProtocols(), getDefaultProtocol(), getNegotiatedProtocols());
    }
}
