package com.mongodb.event;

import java.util.EventListener;

/* loaded from: grasscutter.jar:com/mongodb/event/ServerMonitorListener.class */
public interface ServerMonitorListener extends EventListener {
    default void serverHearbeatStarted(ServerHeartbeatStartedEvent event) {
    }

    default void serverHeartbeatSucceeded(ServerHeartbeatSucceededEvent event) {
    }

    default void serverHeartbeatFailed(ServerHeartbeatFailedEvent event) {
    }
}
