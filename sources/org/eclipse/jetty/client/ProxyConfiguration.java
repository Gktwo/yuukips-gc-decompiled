package org.eclipse.jetty.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.jetty.client.Origin;
import org.eclipse.jetty.p023io.ClientConnectionFactory;
import org.eclipse.jetty.util.HostPort;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyConfiguration.class */
public class ProxyConfiguration {
    private final List<Proxy> proxies = new ArrayList();

    public List<Proxy> getProxies() {
        return this.proxies;
    }

    public Proxy match(Origin origin) {
        for (Proxy proxy : getProxies()) {
            if (proxy.matches(origin)) {
                return proxy;
            }
        }
        return null;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProxyConfiguration$Proxy.class */
    public static abstract class Proxy {
        private final Set<String> included;
        private final Set<String> excluded;
        private final Origin.Address address;
        private final boolean secure;
        private final SslContextFactory.Client sslContextFactory;

        public abstract ClientConnectionFactory newClientConnectionFactory(ClientConnectionFactory clientConnectionFactory);

        /* access modifiers changed from: protected */
        public Proxy(Origin.Address address, boolean secure) {
            this(address, secure, null);
        }

        /* access modifiers changed from: protected */
        public Proxy(Origin.Address address, SslContextFactory.Client sslContextFactory) {
            this(address, true, (SslContextFactory.Client) Objects.requireNonNull(sslContextFactory));
        }

        private Proxy(Origin.Address address, boolean secure, SslContextFactory.Client sslContextFactory) {
            this.included = new HashSet();
            this.excluded = new HashSet();
            this.address = address;
            this.secure = secure;
            this.sslContextFactory = sslContextFactory;
        }

        public Origin.Address getAddress() {
            return this.address;
        }

        public boolean isSecure() {
            return this.secure;
        }

        public SslContextFactory.Client getSslContextFactory() {
            return this.sslContextFactory;
        }

        public Set<String> getIncludedAddresses() {
            return this.included;
        }

        public Set<String> getExcludedAddresses() {
            return this.excluded;
        }

        public URI getURI() {
            return null;
        }

        public boolean matches(Origin origin) {
            if (getAddress().equals(origin.getAddress())) {
                return false;
            }
            boolean result = this.included.isEmpty();
            Origin.Address address = origin.getAddress();
            Iterator<String> it = this.included.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (matches(address, it.next())) {
                        result = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            Iterator<String> it2 = this.excluded.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (matches(address, it2.next())) {
                        result = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            return result;
        }

        private boolean matches(Origin.Address address, String pattern) {
            HostPort hostPort = new HostPort(pattern);
            String host = hostPort.getHost();
            int port = hostPort.getPort();
            return host.equals(address.getHost()) && (port <= 0 || port == address.getPort());
        }

        public String toString() {
            return this.address.toString();
        }
    }
}
