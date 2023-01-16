package org.eclipse.jetty.client;

import java.util.Objects;
import org.eclipse.jetty.util.HostPort;
import org.eclipse.jetty.util.URIUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/Origin.class */
public class Origin {
    private final String scheme;
    private final Address address;
    private final Object tag;

    public Origin(String scheme, String host, int port) {
        this(scheme, host, port, null);
    }

    public Origin(String scheme, String host, int port, Object tag) {
        this(scheme, new Address(host, port), tag);
    }

    public Origin(String scheme, Address address) {
        this(scheme, address, (Object) null);
    }

    public Origin(String scheme, Address address, Object tag) {
        this.scheme = (String) Objects.requireNonNull(scheme);
        this.address = address;
        this.tag = tag;
    }

    public String getScheme() {
        return this.scheme;
    }

    public Address getAddress() {
        return this.address;
    }

    public Object getTag() {
        return this.tag;
    }

    public String asString() {
        StringBuilder result = new StringBuilder();
        URIUtil.appendSchemeHostPort(result, this.scheme, this.address.host, this.address.port);
        return result.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Origin that = (Origin) obj;
        return this.scheme.equals(that.scheme) && this.address.equals(that.address) && Objects.equals(this.tag, that.tag);
    }

    public int hashCode() {
        return Objects.hash(this.scheme, this.address, this.tag);
    }

    public String toString() {
        String result = asString();
        if (this.tag != null) {
            result = result + "[tag=" + this.tag + "]";
        }
        return result;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/Origin$Address.class */
    public static class Address {
        private final String host;
        private final int port;

        public Address(String host, int port) {
            this.host = HostPort.normalizeHost((String) Objects.requireNonNull(host));
            this.port = port;
        }

        public String getHost() {
            return this.host;
        }

        public int getPort() {
            return this.port;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Address that = (Address) obj;
            return this.host.equals(that.host) && this.port == that.port;
        }

        public int hashCode() {
            return (31 * this.host.hashCode()) + this.port;
        }

        public String asString() {
            return String.format("%s:%d", this.host, Integer.valueOf(this.port));
        }

        public String toString() {
            return asString();
        }
    }
}
