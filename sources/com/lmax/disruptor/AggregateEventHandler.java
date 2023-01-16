package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/AggregateEventHandler.class */
public final class AggregateEventHandler<T> implements EventHandler<T> {
    private final EventHandler<T>[] eventHandlers;

    @SafeVarargs
    public AggregateEventHandler(EventHandler<T>... eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override // com.lmax.disruptor.EventHandler
    public void onEvent(T event, long sequence, boolean endOfBatch) throws Exception {
        for (EventHandler<T> eventHandler : this.eventHandlers) {
            eventHandler.onEvent(event, sequence, endOfBatch);
        }
    }

    @Override // com.lmax.disruptor.EventHandler
    public void onStart() {
        for (EventHandler<T> eventHandler : this.eventHandlers) {
            eventHandler.onStart();
        }
    }

    @Override // com.lmax.disruptor.EventHandler
    public void onShutdown() {
        for (EventHandler<T> eventHandler : this.eventHandlers) {
            eventHandler.onShutdown();
        }
    }
}
