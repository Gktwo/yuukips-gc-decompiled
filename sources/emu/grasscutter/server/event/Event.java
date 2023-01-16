package emu.grasscutter.server.event;

import emu.grasscutter.Grasscutter;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/Event.class */
public abstract class Event {
    private boolean cancelled = false;

    public boolean isCanceled() {
        return this.cancelled;
    }

    public void cancel() {
        if (this instanceof Cancellable) {
            this.cancelled = true;
        }
    }

    public void call() {
        Grasscutter.getPluginManager().invokeEvent(this);
    }
}
