package com.mongodb.connection;

/* loaded from: grasscutter.jar:com/mongodb/connection/ServerType.class */
public enum ServerType {
    STANDALONE {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.STANDALONE;
        }
    },
    REPLICA_SET_PRIMARY {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.REPLICA_SET;
        }
    },
    REPLICA_SET_SECONDARY {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.REPLICA_SET;
        }
    },
    REPLICA_SET_ARBITER {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.REPLICA_SET;
        }
    },
    REPLICA_SET_OTHER {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.REPLICA_SET;
        }
    },
    REPLICA_SET_GHOST {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.REPLICA_SET;
        }
    },
    SHARD_ROUTER {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.SHARDED;
        }
    },
    UNKNOWN {
        @Override // com.mongodb.connection.ServerType
        public ClusterType getClusterType() {
            return ClusterType.UNKNOWN;
        }
    };

    public abstract ClusterType getClusterType();
}
