package p001ch.qos.logback.core.status;

import java.io.PrintStream;

/* renamed from: ch.qos.logback.core.status.OnConsoleStatusListener */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/OnConsoleStatusListener.class */
public class OnConsoleStatusListener extends OnPrintStreamStatusListenerBase {
    @Override // p001ch.qos.logback.core.status.OnPrintStreamStatusListenerBase
    protected PrintStream getPrintStream() {
        return System.out;
    }
}
