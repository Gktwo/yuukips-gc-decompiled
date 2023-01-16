package p001ch.qos.logback.core.status;

import java.io.PrintStream;

/* renamed from: ch.qos.logback.core.status.OnErrorConsoleStatusListener */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/OnErrorConsoleStatusListener.class */
public class OnErrorConsoleStatusListener extends OnPrintStreamStatusListenerBase {
    @Override // p001ch.qos.logback.core.status.OnPrintStreamStatusListenerBase
    protected PrintStream getPrintStream() {
        return System.err;
    }
}
