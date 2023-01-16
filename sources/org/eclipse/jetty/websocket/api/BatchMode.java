package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/BatchMode.class */
public enum BatchMode {
    AUTO,
    ON,
    OFF;

    public static BatchMode max(BatchMode one, BatchMode two) {
        return one.ordinal() < two.ordinal() ? two : one;
    }
}
