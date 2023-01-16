package com.mongodb.client.internal;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientSessionClock.class */
public final class ClientSessionClock {
    public static final ClientSessionClock INSTANCE = new ClientSessionClock(0);
    private long currentTime;

    private ClientSessionClock(long millis) {
        this.currentTime = millis;
    }

    public long now() {
        if (this.currentTime == 0) {
            return System.currentTimeMillis();
        }
        return this.currentTime;
    }

    public void setTime(long millis) {
        this.currentTime = millis;
    }
}
