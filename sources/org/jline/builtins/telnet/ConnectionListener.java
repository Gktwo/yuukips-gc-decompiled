package org.jline.builtins.telnet;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/ConnectionListener.class */
public interface ConnectionListener {
    default void connectionIdle(ConnectionEvent ce) {
    }

    default void connectionTimedOut(ConnectionEvent ce) {
    }

    default void connectionLogoutRequest(ConnectionEvent ce) {
    }

    default void connectionSentBreak(ConnectionEvent ce) {
    }

    default void connectionTerminalGeometryChanged(ConnectionEvent ce) {
    }
}
