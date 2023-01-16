package com.mongodb.internal.connection;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/NoOpCommandEventSender.class */
class NoOpCommandEventSender implements CommandEventSender {
    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendStartedEvent() {
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendFailedEvent(Throwable t) {
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendSucceededEvent(ResponseBuffers responseBuffers) {
    }

    @Override // com.mongodb.internal.connection.CommandEventSender
    public void sendSucceededEventForOneWayCommand() {
    }
}
