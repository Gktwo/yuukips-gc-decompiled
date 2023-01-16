package com.mongodb.internal.binding;

import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.NoOpSessionContext;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/SingleConnectionReadBinding.class */
public class SingleConnectionReadBinding extends AbstractReferenceCounted implements ReadBinding {
    private final ReadPreference readPreference;
    private final ServerDescription serverDescription;
    private final Connection connection;

    public SingleConnectionReadBinding(ReadPreference readPreference, ServerDescription serverDescription, Connection connection) {
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
        this.serverDescription = (ServerDescription) Assertions.notNull("serverDescription", serverDescription);
        this.connection = ((Connection) Assertions.notNull("connection", connection)).retain();
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ConnectionSource getReadConnectionSource() {
        return new SingleConnectionSource();
    }

    @Override // com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.WriteBinding
    public SessionContext getSessionContext() {
        return NoOpSessionContext.INSTANCE;
    }

    @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public ReadBinding retain() {
        retain();
        return this;
    }

    @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
    public void release() {
        release();
        if (getCount() == 0) {
            this.connection.release();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/binding/SingleConnectionReadBinding$SingleConnectionSource.class */
    private class SingleConnectionSource extends AbstractReferenceCounted implements ConnectionSource {
        SingleConnectionSource() {
            SingleConnectionReadBinding.this.retain();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public ServerDescription getServerDescription() {
            return SingleConnectionReadBinding.this.serverDescription;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public SessionContext getSessionContext() {
            return NoOpSessionContext.INSTANCE;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public Connection getConnection() {
            return SingleConnectionReadBinding.this.connection.retain();
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public ConnectionSource retain() {
            retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            release();
            if (getCount() == 0) {
                SingleConnectionReadBinding.this.release();
            }
        }
    }
}
