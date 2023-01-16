package com.mongodb.internal.connection.tlschannel;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/NeedsTaskException.class */
public class NeedsTaskException extends TlsChannelFlowControlException {
    private static final long serialVersionUID = -936451835836926915L;
    private final Runnable task;

    public NeedsTaskException(Runnable task) {
        this.task = task;
    }

    public Runnable getTask() {
        return this.task;
    }
}
