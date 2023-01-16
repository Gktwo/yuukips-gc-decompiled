package com.mongodb.internal.binding;

import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.NoOpSessionContext;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncSingleConnectionReadBinding.class */
public class AsyncSingleConnectionReadBinding extends AbstractReferenceCounted implements AsyncReadBinding {
    private final ReadPreference readPreference;
    private final ServerDescription serverDescription;
    private final AsyncConnection connection;

    public AsyncSingleConnectionReadBinding(ReadPreference readPreference, ServerDescription serverDescription, AsyncConnection connection) {
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
        this.serverDescription = (ServerDescription) Assertions.notNull("serverDescription", serverDescription);
        this.connection = ((AsyncConnection) Assertions.notNull("connection", connection)).retain();
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding, com.mongodb.internal.binding.AsyncWriteBinding
    public SessionContext getSessionContext() {
        return NoOpSessionContext.INSTANCE;
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding
    public void getReadConnectionSource(SingleResultCallback<AsyncConnectionSource> callback) {
        callback.onResult(new AsyncSingleConnectionSource(), null);
    }

    @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public AsyncReadBinding retain() {
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

    /* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncSingleConnectionReadBinding$AsyncSingleConnectionSource.class */
    private class AsyncSingleConnectionSource extends AbstractReferenceCounted implements AsyncConnectionSource {
        AsyncSingleConnectionSource() {
            AsyncSingleConnectionReadBinding.this.retain();
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public ServerDescription getServerDescription() {
            return AsyncSingleConnectionReadBinding.this.serverDescription;
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public SessionContext getSessionContext() {
            return NoOpSessionContext.INSTANCE;
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public void getConnection(SingleResultCallback<AsyncConnection> callback) {
            callback.onResult(AsyncSingleConnectionReadBinding.this.connection.retain(), null);
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public AsyncConnectionSource retain() {
            retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            release();
            if (getCount() == 0) {
                AsyncSingleConnectionReadBinding.this.release();
            }
        }
    }
}
