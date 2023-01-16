package com.mongodb.event;

/* loaded from: grasscutter.jar:com/mongodb/event/CommandListener.class */
public interface CommandListener {
    default void commandStarted(CommandStartedEvent event) {
    }

    default void commandSucceeded(CommandSucceededEvent event) {
    }

    default void commandFailed(CommandFailedEvent event) {
    }
}
