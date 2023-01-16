package com.mongodb;

import com.mongodb.annotations.Immutable;
import com.mongodb.lang.Nullable;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import p013io.javalin.http.sse.EmitterKt;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/ServerAddress.class */
public class ServerAddress implements Serializable {
    private static final long serialVersionUID = 4027873363095395504L;
    private final String host;
    private final int port;

    public ServerAddress() {
        this(defaultHost(), defaultPort());
    }

    public ServerAddress(@Nullable String host) {
        this(host, defaultPort());
    }

    public ServerAddress(InetAddress inetAddress) {
        this(inetAddress.getHostName(), defaultPort());
    }

    public ServerAddress(InetAddress inetAddress, int port) {
        this(inetAddress.getHostName(), port);
    }

    public ServerAddress(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress.getAddress(), inetSocketAddress.getPort());
    }

    public ServerAddress(@Nullable String host, int port) {
        String hostToUse = host;
        String hostToUse2 = (hostToUse == null ? defaultHost() : hostToUse).trim();
        hostToUse2 = hostToUse2.length() == 0 ? defaultHost() : hostToUse2;
        int portToUse = port;
        if (hostToUse2.startsWith("[")) {
            int idx = host.indexOf("]");
            if (idx == -1) {
                throw new IllegalArgumentException("an IPV6 address must be encosed with '[' and ']' according to RFC 2732.");
            }
            int portIdx = host.indexOf("]:");
            if (portIdx != -1) {
                if (port != defaultPort()) {
                    throw new IllegalArgumentException("can't specify port in construct and via host");
                }
                portToUse = Integer.parseInt(host.substring(portIdx + 2));
            }
            hostToUse2 = host.substring(1, idx);
        } else {
            int idx2 = hostToUse2.indexOf(EmitterKt.COMMENT_PREFIX);
            if (idx2 == hostToUse2.lastIndexOf(EmitterKt.COMMENT_PREFIX) && idx2 > 0) {
                if (port != defaultPort()) {
                    throw new IllegalArgumentException("can't specify port in construct and via host");
                }
                try {
                    portToUse = Integer.parseInt(hostToUse2.substring(idx2 + 1));
                    hostToUse2 = hostToUse2.substring(0, idx2).trim();
                } catch (NumberFormatException e) {
                    throw new MongoException("host and port should be specified in host:port format");
                }
            }
        }
        this.host = hostToUse2.toLowerCase();
        this.port = portToUse;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerAddress that = (ServerAddress) o;
        if (this.port == that.port && this.host.equals(that.host)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * this.host.hashCode()) + this.port;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public InetSocketAddress getSocketAddress() {
        try {
            return new InetSocketAddress(InetAddress.getByName(this.host), this.port);
        } catch (UnknownHostException e) {
            throw new MongoSocketException(e.getMessage(), this, e);
        }
    }

    public List<InetSocketAddress> getSocketAddresses() {
        try {
            InetAddress[] inetAddresses = InetAddress.getAllByName(this.host);
            List<InetSocketAddress> inetSocketAddressList = new ArrayList<>();
            for (InetAddress inetAddress : inetAddresses) {
                inetSocketAddressList.add(new InetSocketAddress(inetAddress, this.port));
            }
            return inetSocketAddressList;
        } catch (UnknownHostException e) {
            throw new MongoSocketException(e.getMessage(), this, e);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return this.host + EmitterKt.COMMENT_PREFIX + this.port;
    }

    public static String defaultHost() {
        return "127.0.0.1";
    }

    public static int defaultPort() {
        return 27017;
    }
}
