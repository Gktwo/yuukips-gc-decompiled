package com.mongodb.internal.selector;

import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.ClusterDescriptionHelper;
import com.mongodb.selector.ServerSelector;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/selector/WritableServerSelector.class */
public final class WritableServerSelector implements ServerSelector {
    @Override // com.mongodb.selector.ServerSelector
    public List<ServerDescription> select(ClusterDescription clusterDescription) {
        if (clusterDescription.getConnectionMode() == ClusterConnectionMode.SINGLE) {
            return ClusterDescriptionHelper.getAny(clusterDescription);
        }
        return ClusterDescriptionHelper.getPrimaries(clusterDescription);
    }

    public String toString() {
        return "WritableServerSelector";
    }
}
