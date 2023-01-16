package com.mongodb.internal.connection;

import com.mongodb.event.ServerDescriptionChangedEvent;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerDescriptionChangedListener.class */
public interface ServerDescriptionChangedListener {
    void serverDescriptionChanged(ServerDescriptionChangedEvent serverDescriptionChangedEvent);
}
