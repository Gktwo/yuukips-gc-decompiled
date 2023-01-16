package com.mongodb.internal.connection;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/CommandEventSender.class */
interface CommandEventSender {
    void sendStartedEvent();

    void sendFailedEvent(Throwable th);

    void sendSucceededEvent(ResponseBuffers responseBuffers);

    void sendSucceededEventForOneWayCommand();
}
