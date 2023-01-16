package com.mongodb.event;

import java.util.EventListener;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionPoolListener.class */
public interface ConnectionPoolListener extends EventListener {
    @Deprecated
    default void connectionPoolOpened(ConnectionPoolOpenedEvent event) {
    }

    default void connectionPoolCreated(ConnectionPoolCreatedEvent event) {
    }

    default void connectionPoolCleared(ConnectionPoolClearedEvent event) {
    }

    default void connectionPoolClosed(ConnectionPoolClosedEvent event) {
    }

    default void connectionCheckOutStarted(ConnectionCheckOutStartedEvent event) {
    }

    default void connectionCheckedOut(ConnectionCheckedOutEvent event) {
    }

    default void connectionCheckOutFailed(ConnectionCheckOutFailedEvent event) {
    }

    default void connectionCheckedIn(ConnectionCheckedInEvent event) {
    }

    @Deprecated
    default void connectionAdded(ConnectionAddedEvent event) {
    }

    default void connectionCreated(ConnectionCreatedEvent event) {
    }

    default void connectionReady(ConnectionReadyEvent event) {
    }

    @Deprecated
    default void connectionRemoved(ConnectionRemovedEvent event) {
    }

    default void connectionClosed(ConnectionClosedEvent event) {
    }
}
