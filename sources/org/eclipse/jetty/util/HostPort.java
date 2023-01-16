package org.eclipse.jetty.util;

import org.eclipse.jetty.util.annotation.ManagedAttribute;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/HostPort.class */
public class HostPort {
    private final String _host;
    private final int _port;

    public HostPort(String host, int port) {
        this._host = normalizeHost(host);
        this._port = port;
    }

    public HostPort(String authority) throws IllegalArgumentException {
        if (authority == null) {
            throw new IllegalArgumentException("No Authority");
        }
        try {
            if (authority.isEmpty()) {
                this._host = authority;
                this._port = 0;
            } else if (authority.charAt(0) == '[') {
                int close = authority.lastIndexOf(93);
                if (close < 0) {
                    throw new IllegalArgumentException("Bad IPv6 host");
                }
                this._host = authority.substring(0, close + 1);
                if (authority.length() <= close + 1) {
                    this._port = 0;
                } else if (authority.charAt(close + 1) != ':') {
                    throw new IllegalArgumentException("Bad IPv6 port");
                } else {
                    this._port = parsePort(authority.substring(close + 2));
                }
            } else {
                int c = authority.lastIndexOf(58);
                if (c < 0) {
                    this._host = authority;
                    this._port = 0;
                } else if (c != authority.indexOf(58)) {
                    this._host = "[" + authority + "]";
                    this._port = 0;
                } else {
                    this._host = authority.substring(0, c);
                    this._port = parsePort(authority.substring(c + 1));
                }
            }
        } catch (IllegalArgumentException iae) {
            throw iae;
        } catch (Exception ex) {
            throw new IllegalArgumentException("Bad HostPort", ex);
        }
    }

    @ManagedAttribute("host")
    public String getHost() {
        return this._host;
    }

    @ManagedAttribute("port")
    public int getPort() {
        return this._port;
    }

    public int getPort(int defaultPort) {
        return this._port > 0 ? this._port : defaultPort;
    }

    public boolean hasHost() {
        return StringUtil.isNotBlank(this._host);
    }

    public boolean hasPort() {
        return this._port > 0;
    }

    public String toString() {
        if (this._port > 0) {
            return this._host + EmitterKt.COMMENT_PREFIX + this._port;
        }
        return this._host;
    }

    public static String normalizeHost(String host) {
        if (host == null || host.isEmpty() || host.charAt(0) == '[' || host.indexOf(58) < 0) {
            return host;
        }
        return "[" + host + "]";
    }

    public static int parsePort(String rawPort) throws IllegalArgumentException {
        if (StringUtil.isEmpty(rawPort)) {
            throw new IllegalArgumentException("Bad port");
        }
        int port = Integer.parseInt(rawPort);
        if (port > 0 && port <= 65535) {
            return port;
        }
        throw new IllegalArgumentException("Bad port");
    }
}
