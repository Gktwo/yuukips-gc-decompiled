package p001ch.qos.logback.core.pattern.parser;

import p001ch.qos.logback.core.pattern.FormatInfo;

/* renamed from: ch.qos.logback.core.pattern.parser.FormattingNode */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/FormattingNode.class */
public class FormattingNode extends Node {
    FormatInfo formatInfo;

    FormattingNode(int type) {
        super(type);
    }

    /* access modifiers changed from: package-private */
    public FormattingNode(int type, Object value) {
        super(type, value);
    }

    public FormatInfo getFormatInfo() {
        return this.formatInfo;
    }

    public void setFormatInfo(FormatInfo formatInfo) {
        this.formatInfo = formatInfo;
    }

    @Override // p001ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object o) {
        if (!equals(o) || !(o instanceof FormattingNode)) {
            return false;
        }
        FormattingNode r = (FormattingNode) o;
        return this.formatInfo != null ? this.formatInfo.equals(r.formatInfo) : r.formatInfo == null;
    }

    @Override // p001ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        return (31 * hashCode()) + (this.formatInfo != null ? this.formatInfo.hashCode() : 0);
    }
}
