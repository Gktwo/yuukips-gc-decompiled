package emu.grasscutter.server.event.internal;

import emu.grasscutter.server.event.types.ServerEvent;
import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/internal/ServerLogEvent.class */
public final class ServerLogEvent extends ServerEvent {
    private final ILoggingEvent loggingEvent;
    private final String consoleMessage;

    public ServerLogEvent(ILoggingEvent loggingEvent, String consoleMessage) {
        super(ServerEvent.Type.GAME);
        this.loggingEvent = loggingEvent;
        this.consoleMessage = consoleMessage;
    }

    public ILoggingEvent getLoggingEvent() {
        return this.loggingEvent;
    }

    public String getConsoleMessage() {
        return this.consoleMessage;
    }
}
