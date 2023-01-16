package emu.grasscutter.utils;

import emu.grasscutter.server.event.Event;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/EventConsumer.class */
public interface EventConsumer<T extends Event> {
    void consume(T t);
}
