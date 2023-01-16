package emu.grasscutter.server.event.types;

import emu.grasscutter.server.event.Event;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/types/ServerEvent.class */
public abstract class ServerEvent extends Event {
    protected final Type type;

    /* loaded from: grasscutter.jar:emu/grasscutter/server/event/types/ServerEvent$Type.class */
    public enum Type {
        DISPATCH,
        GAME
    }

    public ServerEvent(Type type) {
        this.type = type;
    }

    public Type getServerType() {
        return this.type;
    }
}
