package p001ch.qos.logback.classic.spi;

import java.io.Serializable;
import p001ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.spi.LoggerRemoteView */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/LoggerRemoteView.class */
public class LoggerRemoteView implements Serializable {
    private static final long serialVersionUID = 5028223666108713696L;
    final LoggerContextVO loggerContextView;
    final String name;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LoggerRemoteView.class.desiredAssertionStatus();
    }

    public LoggerRemoteView(String name, LoggerContext lc) {
        this.name = name;
        if ($assertionsDisabled || lc.getLoggerContextRemoteView() != null) {
            this.loggerContextView = lc.getLoggerContextRemoteView();
            return;
        }
        throw new AssertionError();
    }

    public LoggerContextVO getLoggerContextView() {
        return this.loggerContextView;
    }

    public String getName() {
        return this.name;
    }
}
