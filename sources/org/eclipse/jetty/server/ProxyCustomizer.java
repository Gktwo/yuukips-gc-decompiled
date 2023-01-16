package org.eclipse.jetty.server;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.ProxyConnectionFactory;
import org.eclipse.jetty.util.Attributes;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyCustomizer.class */
public class ProxyCustomizer implements HttpConfiguration.Customizer {
    public static final String REMOTE_ADDRESS_ATTRIBUTE_NAME = "org.eclipse.jetty.proxy.remote.address";
    public static final String REMOTE_PORT_ATTRIBUTE_NAME = "org.eclipse.jetty.proxy.remote.port";
    public static final String LOCAL_ADDRESS_ATTRIBUTE_NAME = "org.eclipse.jetty.proxy.local.address";
    public static final String LOCAL_PORT_ATTRIBUTE_NAME = "org.eclipse.jetty.proxy.local.port";

    @Override // org.eclipse.jetty.server.HttpConfiguration.Customizer
    public void customize(Connector connector, HttpConfiguration channelConfig, Request request) {
        EndPoint endPoint = request.getHttpChannel().getEndPoint();
        if (endPoint instanceof ProxyConnectionFactory.ProxyEndPoint) {
            EndPoint underlyingEndpoint = ((ProxyConnectionFactory.ProxyEndPoint) endPoint).unwrap();
            request.setAttributes(new ProxyAttributes(underlyingEndpoint.getRemoteAddress(), underlyingEndpoint.getLocalAddress(), request.getAttributes()));
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ProxyCustomizer$ProxyAttributes.class */
    private static class ProxyAttributes extends Attributes.Wrapper {
        private final String _remoteAddress;
        private final String _localAddress;
        private final int _remotePort;
        private final int _localPort;

        private ProxyAttributes(InetSocketAddress remoteAddress, InetSocketAddress localAddress, Attributes attributes) {
            super(attributes);
            this._remoteAddress = remoteAddress.getAddress().getHostAddress();
            this._localAddress = localAddress.getAddress().getHostAddress();
            this._remotePort = remoteAddress.getPort();
            this._localPort = localAddress.getPort();
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Object getAttribute(String name) {
            char c = 65535;
            switch (name.hashCode()) {
                case -1784563155:
                    if (name.equals(ProxyCustomizer.REMOTE_ADDRESS_ATTRIBUTE_NAME)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1145130619:
                    if (name.equals(ProxyCustomizer.LOCAL_PORT_ATTRIBUTE_NAME)) {
                        c = 3;
                        break;
                    }
                    break;
                case -416500624:
                    if (name.equals(ProxyCustomizer.LOCAL_ADDRESS_ATTRIBUTE_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case 687656168:
                    if (name.equals(ProxyCustomizer.REMOTE_PORT_ATTRIBUTE_NAME)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return this._remoteAddress;
                case 1:
                    return Integer.valueOf(this._remotePort);
                case 2:
                    return this._localAddress;
                case 3:
                    return Integer.valueOf(this._localPort);
                default:
                    return getAttribute(name);
            }
        }

        @Override // org.eclipse.jetty.util.Attributes.Wrapper, org.eclipse.jetty.util.Attributes
        public Set<String> getAttributeNameSet() {
            Set<String> names = new HashSet<>(this._attributes.getAttributeNameSet());
            names.remove(ProxyCustomizer.REMOTE_ADDRESS_ATTRIBUTE_NAME);
            names.remove(ProxyCustomizer.LOCAL_ADDRESS_ATTRIBUTE_NAME);
            if (this._remoteAddress != null) {
                names.add(ProxyCustomizer.REMOTE_ADDRESS_ATTRIBUTE_NAME);
            }
            if (this._localAddress != null) {
                names.add(ProxyCustomizer.LOCAL_ADDRESS_ATTRIBUTE_NAME);
            }
            names.add(ProxyCustomizer.REMOTE_PORT_ATTRIBUTE_NAME);
            names.add(ProxyCustomizer.LOCAL_PORT_ATTRIBUTE_NAME);
            return names;
        }
    }
}
