package emu.grasscutter.server.event;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.plugin.Plugin;
import emu.grasscutter.server.event.Event;
import emu.grasscutter.utils.EventConsumer;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/EventHandler.class */
public final class EventHandler<T extends Event> {
    private final Class<T> eventClass;
    private EventConsumer<T> listener;
    private HandlerPriority priority;
    private boolean handleCanceled;

    public EventHandler(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    public Class<T> handles() {
        return this.eventClass;
    }

    public EventConsumer<T> getCallback() {
        return this.listener;
    }

    public HandlerPriority getPriority() {
        return this.priority;
    }

    public boolean ignoresCanceled() {
        return this.handleCanceled;
    }

    public EventHandler<T> listener(EventConsumer<T> listener) {
        this.listener = listener;
        return this;
    }

    public EventHandler<T> priority(HandlerPriority priority) {
        this.priority = priority;
        return this;
    }

    public EventHandler<T> ignore(boolean ignore) {
        this.handleCanceled = ignore;
        return this;
    }

    public void register(Plugin plugin) {
        Grasscutter.getPluginManager().registerListener(plugin, this);
    }
}
