package com.mongodb.event;

import java.util.EventListener;

/* loaded from: grasscutter.jar:com/mongodb/event/ServerListener.class */
public interface ServerListener extends EventListener {
    default void serverOpening(ServerOpeningEvent event) {
    }

    default void serverClosed(ServerClosedEvent event) {
    }

    default void serverDescriptionChanged(ServerDescriptionChangedEvent event) {
    }
}
