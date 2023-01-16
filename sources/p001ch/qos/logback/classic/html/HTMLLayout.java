package p001ch.qos.logback.classic.html;

import java.util.Map;
import p001ch.qos.logback.classic.PatternLayout;
import p001ch.qos.logback.classic.pattern.MDCConverter;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.helpers.Transform;
import p001ch.qos.logback.core.html.HTMLLayoutBase;
import p001ch.qos.logback.core.html.IThrowableRenderer;
import p001ch.qos.logback.core.pattern.Converter;

/* renamed from: ch.qos.logback.classic.html.HTMLLayout */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/html/HTMLLayout.class */
public class HTMLLayout extends HTMLLayoutBase<ILoggingEvent> {
    static final String DEFAULT_CONVERSION_PATTERN = "%date%thread%level%logger%mdc%msg";
    IThrowableRenderer<ILoggingEvent> throwableRenderer = new DefaultThrowableRenderer();

    public HTMLLayout() {
        this.pattern = DEFAULT_CONVERSION_PATTERN;
        this.cssBuilder = new DefaultCssBuilder();
    }

    @Override // p001ch.qos.logback.core.html.HTMLLayoutBase, p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int errorCount = 0;
        if (this.throwableRenderer == null) {
            addError("ThrowableRender cannot be null.");
            errorCount = 0 + 1;
        }
        if (errorCount == 0) {
            start();
        }
    }

    @Override // p001ch.qos.logback.core.html.HTMLLayoutBase
    protected Map<String, String> getDefaultConverterMap() {
        return PatternLayout.DEFAULT_CONVERTER_MAP;
    }

    public String doLayout(ILoggingEvent event) {
        StringBuilder buf = new StringBuilder();
        startNewTableIfLimitReached(buf);
        boolean odd = true;
        long j = this.counter;
        this.counter = j + 1;
        if ((j & 1) == 0) {
            odd = false;
        }
        String level = event.getLevel().toString().toLowerCase();
        buf.append(CoreConstants.LINE_SEPARATOR);
        buf.append("<tr class=\"");
        buf.append(level);
        if (odd) {
            buf.append(" odd\">");
        } else {
            buf.append(" even\">");
        }
        buf.append(CoreConstants.LINE_SEPARATOR);
        for (Converter<ILoggingEvent> c = this.head; c != null; c = c.getNext()) {
            appendEventToBuffer(buf, c, event);
        }
        buf.append("</tr>");
        buf.append(CoreConstants.LINE_SEPARATOR);
        if (event.getThrowableProxy() != null) {
            this.throwableRenderer.render(buf, event);
        }
        return buf.toString();
    }

    private void appendEventToBuffer(StringBuilder buf, Converter<ILoggingEvent> c, ILoggingEvent event) {
        buf.append("<td class=\"");
        buf.append(computeConverterName(c));
        buf.append("\">");
        buf.append(Transform.escapeTags(c.convert(event)));
        buf.append("</td>");
        buf.append(CoreConstants.LINE_SEPARATOR);
    }

    public IThrowableRenderer getThrowableRenderer() {
        return this.throwableRenderer;
    }

    public void setThrowableRenderer(IThrowableRenderer<ILoggingEvent> throwableRenderer) {
        this.throwableRenderer = throwableRenderer;
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.html.HTMLLayoutBase
    public String computeConverterName(Converter c) {
        if (!(c instanceof MDCConverter)) {
            return computeConverterName(c);
        }
        String key = ((MDCConverter) c).getFirstOption();
        if (key != null) {
            return key;
        }
        return "MDC";
    }
}
