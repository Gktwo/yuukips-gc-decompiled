package p001ch.qos.logback.core.html;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.LayoutBase;
import p001ch.qos.logback.core.pattern.Converter;
import p001ch.qos.logback.core.pattern.ConverterUtil;
import p001ch.qos.logback.core.pattern.parser.Parser;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;
import p001ch.qos.logback.core.spi.ScanException;
import p013io.javalin.http.ContentType;

/* renamed from: ch.qos.logback.core.html.HTMLLayoutBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/html/HTMLLayoutBase.class */
public abstract class HTMLLayoutBase<E> extends LayoutBase<E> {
    protected String pattern;
    protected Converter<E> head;
    protected CssBuilder cssBuilder;
    protected String title = "Logback Log Messages";
    protected long counter = 0;

    protected abstract Map<String, String> getDefaultConverterMap();

    public void setPattern(String conversionPattern) {
        this.pattern = conversionPattern;
    }

    public String getPattern() {
        return this.pattern;
    }

    public CssBuilder getCssBuilder() {
        return this.cssBuilder;
    }

    public void setCssBuilder(CssBuilder cssBuilder) {
        this.cssBuilder = cssBuilder;
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int errorCount = 0;
        try {
            Parser<E> p = new Parser<>(this.pattern);
            p.setContext(getContext());
            this.head = p.compile(p.parse(), getEffectiveConverterMap());
            ConverterUtil.startConverters(this.head);
        } catch (ScanException ex) {
            addError("Incorrect pattern found", ex);
            errorCount = 0 + 1;
        }
        if (errorCount == 0) {
            this.started = true;
        }
    }

    public Map<String, String> getEffectiveConverterMap() {
        Map<String, String> contextMap;
        Map<String, String> effectiveMap = new HashMap<>();
        Map<String, String> defaultMap = getDefaultConverterMap();
        if (defaultMap != null) {
            effectiveMap.putAll(defaultMap);
        }
        Context context = getContext();
        if (!(context == null || (contextMap = (Map) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY)) == null)) {
            effectiveMap.putAll(contextMap);
        }
        return effectiveMap;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getContentType() {
        return ContentType.HTML;
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getFileHeader() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
        sbuf.append(" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("<html>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("  <head>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("    <title>");
        sbuf.append(this.title);
        sbuf.append("</title>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        this.cssBuilder.addCss(sbuf);
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("  </head>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("<body>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        return sbuf.toString();
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("<hr/>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("<p>Log session start time ");
        sbuf.append(new Date());
        sbuf.append("</p><p></p>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        sbuf.append("<table cellspacing=\"0\">");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        buildHeaderRowForTable(sbuf);
        return sbuf.toString();
    }

    private void buildHeaderRowForTable(StringBuilder sbuf) {
        Converter c = this.head;
        sbuf.append("<tr class=\"header\">");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        while (c != null) {
            if (computeConverterName(c) == null) {
                c = c.getNext();
            } else {
                sbuf.append("<td class=\"");
                sbuf.append(computeConverterName(c));
                sbuf.append("\">");
                sbuf.append(computeConverterName(c));
                sbuf.append("</td>");
                sbuf.append(CoreConstants.LINE_SEPARATOR);
                c = c.getNext();
            }
        }
        sbuf.append("</tr>");
        sbuf.append(CoreConstants.LINE_SEPARATOR);
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getPresentationFooter() {
        return "</table>";
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getFileFooter() {
        return CoreConstants.LINE_SEPARATOR + "</body></html>";
    }

    protected void startNewTableIfLimitReached(StringBuilder sbuf) {
        if (this.counter >= AbstractComponentTracker.LINGERING_TIMEOUT) {
            this.counter = 0;
            sbuf.append("</table>");
            sbuf.append(CoreConstants.LINE_SEPARATOR);
            sbuf.append("<p></p>");
            sbuf.append("<table cellspacing=\"0\">");
            sbuf.append(CoreConstants.LINE_SEPARATOR);
            buildHeaderRowForTable(sbuf);
        }
    }

    /* access modifiers changed from: protected */
    public String computeConverterName(Converter c) {
        String className = c.getClass().getSimpleName();
        int index = className.indexOf("Converter");
        if (index == -1) {
            return className;
        }
        return className.substring(0, index);
    }
}
