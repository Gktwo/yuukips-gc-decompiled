package com.mongodb.internal.connection;

import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalConnectionInitializationDescription.class */
public class InternalConnectionInitializationDescription {
    private final ConnectionDescription connectionDescription;
    private final ServerDescription serverDescription;

    public InternalConnectionInitializationDescription(ConnectionDescription connectionDescription, ServerDescription serverDescription) {
        this.connectionDescription = connectionDescription;
        this.serverDescription = serverDescription;
    }

    public ConnectionDescription getConnectionDescription() {
        return this.connectionDescription;
    }

    public ServerDescription getServerDescription() {
        return this.serverDescription;
    }

    public InternalConnectionInitializationDescription withConnectionDescription(ConnectionDescription connectionDescription) {
        return new InternalConnectionInitializationDescription(connectionDescription, this.serverDescription);
    }
}
