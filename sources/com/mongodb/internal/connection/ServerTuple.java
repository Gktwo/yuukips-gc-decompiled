package com.mongodb.internal.connection;

import com.mongodb.connection.ServerDescription;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerTuple.class */
public class ServerTuple {
    private final Server server;
    private final ServerDescription serverDescription;

    public ServerTuple(Server server, ServerDescription serverDescription) {
        this.server = server;
        this.serverDescription = serverDescription;
    }

    public Server getServer() {
        return this.server;
    }

    public ServerDescription getServerDescription() {
        return this.serverDescription;
    }
}
