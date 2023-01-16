package emu.grasscutter.server.event.internal;

import emu.grasscutter.server.event.types.ServerEvent;
import java.time.OffsetDateTime;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/internal/ServerStopEvent.class */
public final class ServerStopEvent extends ServerEvent {
    private final OffsetDateTime stopTime;

    public ServerStopEvent(ServerEvent.Type type, OffsetDateTime stopTime) {
        super(type);
        this.stopTime = stopTime;
    }

    public OffsetDateTime getStopTime() {
        return this.stopTime;
    }
}
