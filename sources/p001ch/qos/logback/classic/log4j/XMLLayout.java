package p001ch.qos.logback.classic.log4j;

import java.util.Map;
import java.util.Set;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.classic.spi.IThrowableProxy;
import p001ch.qos.logback.classic.spi.StackTraceElementProxy;
import p001ch.qos.logback.core.LayoutBase;
import p001ch.qos.logback.core.helpers.Transform;
import p013io.javalin.http.ContentType;

/* renamed from: ch.qos.logback.classic.log4j.XMLLayout */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/log4j/XMLLayout.class */
public class XMLLayout extends LayoutBase<ILoggingEvent> {
    private final int DEFAULT_SIZE = 256;
    private final int UPPER_LIMIT = 2048;
    private StringBuilder buf = new StringBuilder(256);
    private boolean locationInfo = false;
    private boolean properties = false;

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        start();
    }

    public void setLocationInfo(boolean flag) {
        this.locationInfo = flag;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public void setProperties(boolean flag) {
        this.properties = flag;
    }

    public boolean getProperties() {
        return this.properties;
    }

    public String doLayout(ILoggingEvent event) {
        Map<String, String> propertyMap;
        StackTraceElement[] callerDataArray;
        if (this.buf.capacity() > 2048) {
            this.buf = new StringBuilder(256);
        } else {
            this.buf.setLength(0);
        }
        this.buf.append("<log4j:event logger=\"");
        this.buf.append(Transform.escapeTags(event.getLoggerName()));
        this.buf.append("\"\r\n");
        this.buf.append("             timestamp=\"");
        this.buf.append(event.getTimeStamp());
        this.buf.append("\" level=\"");
        this.buf.append(event.getLevel());
        this.buf.append("\" thread=\"");
        this.buf.append(Transform.escapeTags(event.getThreadName()));
        this.buf.append("\">\r\n");
        this.buf.append("  <log4j:message>");
        this.buf.append(Transform.escapeTags(event.getFormattedMessage()));
        this.buf.append("</log4j:message>\r\n");
        IThrowableProxy tp = event.getThrowableProxy();
        if (tp != null) {
            StackTraceElementProxy[] stepArray = tp.getStackTraceElementProxyArray();
            this.buf.append("  <log4j:throwable><![CDATA[");
            for (StackTraceElementProxy step : stepArray) {
                this.buf.append('\t');
                this.buf.append(step.toString());
                this.buf.append("\r\n");
            }
            this.buf.append("]]></log4j:throwable>\r\n");
        }
        if (this.locationInfo && (callerDataArray = event.getCallerData()) != null && callerDataArray.length > 0) {
            StackTraceElement immediateCallerData = callerDataArray[0];
            this.buf.append("  <log4j:locationInfo class=\"");
            this.buf.append(immediateCallerData.getClassName());
            this.buf.append("\"\r\n");
            this.buf.append("                      method=\"");
            this.buf.append(Transform.escapeTags(immediateCallerData.getMethodName()));
            this.buf.append("\" file=\"");
            this.buf.append(Transform.escapeTags(immediateCallerData.getFileName()));
            this.buf.append("\" line=\"");
            this.buf.append(immediateCallerData.getLineNumber());
            this.buf.append("\"/>\r\n");
        }
        if (!(!getProperties() || (propertyMap = event.getMDCPropertyMap()) == null || propertyMap.size() == 0)) {
            Set<Map.Entry<String, String>> entrySet = propertyMap.entrySet();
            this.buf.append("  <log4j:properties>");
            for (Map.Entry<String, String> entry : entrySet) {
                this.buf.append("\r\n    <log4j:data");
                this.buf.append(" name='" + Transform.escapeTags(entry.getKey()) + "'");
                this.buf.append(" value='" + Transform.escapeTags(entry.getValue()) + "'");
                this.buf.append(" />");
            }
            this.buf.append("\r\n  </log4j:properties>");
        }
        this.buf.append("\r\n</log4j:event>\r\n\r\n");
        return this.buf.toString();
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getContentType() {
        return ContentType.XML;
    }
}
