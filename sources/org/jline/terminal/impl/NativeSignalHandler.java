package org.jline.terminal.impl;

import org.jline.terminal.Terminal;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/NativeSignalHandler.class */
public final class NativeSignalHandler implements Terminal.SignalHandler {
    public static final NativeSignalHandler SIG_DFL = new NativeSignalHandler();
    public static final NativeSignalHandler SIG_IGN = new NativeSignalHandler();

    private NativeSignalHandler() {
    }

    @Override // org.jline.terminal.Terminal.SignalHandler
    public void handle(Terminal.Signal signal) {
        throw new UnsupportedOperationException();
    }
}
