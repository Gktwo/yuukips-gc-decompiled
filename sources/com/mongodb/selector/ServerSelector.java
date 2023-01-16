package com.mongodb.selector;

import com.mongodb.annotations.ThreadSafe;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import java.util.List;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/selector/ServerSelector.class */
public interface ServerSelector {
    List<ServerDescription> select(ClusterDescription clusterDescription);
}
