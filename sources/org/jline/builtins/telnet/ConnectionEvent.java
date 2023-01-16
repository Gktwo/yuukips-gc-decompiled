package org.jline.builtins.telnet;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/ConnectionEvent.class */
public class ConnectionEvent {
    private final Connection source;
    private final Type type;

    /* loaded from: grasscutter.jar:org/jline/builtins/telnet/ConnectionEvent$Type.class */
    public enum Type {
        CONNECTION_IDLE,
        CONNECTION_TIMEDOUT,
        CONNECTION_LOGOUTREQUEST,
        CONNECTION_BREAK,
        CONNECTION_TERMINAL_GEOMETRY_CHANGED
    }

    public ConnectionEvent(Connection source, Type type) {
        this.type = type;
        this.source = source;
    }

    public Connection getSource() {
        return this.source;
    }

    public Type getType() {
        return this.type;
    }
}
