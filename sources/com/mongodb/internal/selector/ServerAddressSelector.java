package com.mongodb.internal.selector;

import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.ClusterDescriptionHelper;
import com.mongodb.selector.ServerSelector;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/selector/ServerAddressSelector.class */
public class ServerAddressSelector implements ServerSelector {
    private final ServerAddress serverAddress;

    public ServerAddressSelector(ServerAddress serverAddress) {
        this.serverAddress = (ServerAddress) Assertions.notNull("serverAddress", serverAddress);
    }

    public ServerAddress getServerAddress() {
        return this.serverAddress;
    }

    @Override // com.mongodb.selector.ServerSelector
    public List<ServerDescription> select(ClusterDescription clusterDescription) {
        ServerDescription serverDescription = ClusterDescriptionHelper.getByServerAddress(clusterDescription, this.serverAddress);
        if (serverDescription != null) {
            return Collections.singletonList(serverDescription);
        }
        return Collections.emptyList();
    }

    public String toString() {
        return "ServerAddressSelector{serverAddress=" + this.serverAddress + '}';
    }
}
