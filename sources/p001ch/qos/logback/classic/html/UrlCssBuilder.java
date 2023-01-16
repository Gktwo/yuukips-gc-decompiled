package p001ch.qos.logback.classic.html;

import p001ch.qos.logback.core.html.CssBuilder;

/* renamed from: ch.qos.logback.classic.html.UrlCssBuilder */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/html/UrlCssBuilder.class */
public class UrlCssBuilder implements CssBuilder {
    String url = "http://logback.qos.ch/css/classic.css";

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override // p001ch.qos.logback.core.html.CssBuilder
    public void addCss(StringBuilder sbuf) {
        sbuf.append("<link REL=StyleSheet HREF=\"");
        sbuf.append(this.url);
        sbuf.append("\" TITLE=\"Basic\" />");
    }
}
