package p001ch.qos.logback.classic.layout;

import p001ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.LayoutBase;
import p001ch.qos.logback.core.util.CachingDateFormatter;

/* renamed from: ch.qos.logback.classic.layout.TTLLLayout */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/layout/TTLLLayout.class */
public class TTLLLayout extends LayoutBase<ILoggingEvent> {
    CachingDateFormatter cachingDateFormatter = new CachingDateFormatter("HH:mm:ss.SSS");
    ThrowableProxyConverter tpc = new ThrowableProxyConverter();

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.tpc.start();
        start();
    }

    public String doLayout(ILoggingEvent event) {
        if (!isStarted()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.cachingDateFormatter.format(event.getTimeStamp()));
        sb.append(" [");
        sb.append(event.getThreadName());
        sb.append("] ");
        sb.append(event.getLevel().toString());
        sb.append(" ");
        sb.append(event.getLoggerName());
        sb.append(" - ");
        sb.append(event.getFormattedMessage());
        sb.append(CoreConstants.LINE_SEPARATOR);
        if (event.getThrowableProxy() != null) {
            sb.append(this.tpc.convert(event));
        }
        return sb.toString();
    }
}
