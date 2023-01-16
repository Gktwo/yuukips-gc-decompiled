package com.mongodb.internal.connection;

import com.mongodb.ServerAddress;
import com.mongodb.UnixServerAddress;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerAddressHelper.class */
public final class ServerAddressHelper {
    public static ServerAddress createServerAddress(String host) {
        return createServerAddress(host, ServerAddress.defaultPort());
    }

    public static ServerAddress createServerAddress(String host, int port) {
        if (host == null || !host.endsWith(".sock")) {
            return new ServerAddress(host, port);
        }
        return new UnixServerAddress(host);
    }

    private ServerAddressHelper() {
    }
}
