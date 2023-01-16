package p001ch.qos.logback.core.pattern.parser;

import java.util.List;

/* renamed from: ch.qos.logback.core.pattern.parser.SimpleKeywordNode */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/SimpleKeywordNode.class */
public class SimpleKeywordNode extends FormattingNode {
    List<String> optionList;

    /* access modifiers changed from: package-private */
    public SimpleKeywordNode(Object value) {
        super(1, value);
    }

    /* access modifiers changed from: protected */
    public SimpleKeywordNode(int type, Object value) {
        super(type, value);
    }

    public List<String> getOptions() {
        return this.optionList;
    }

    public void setOptions(List<String> optionList) {
        this.optionList = optionList;
    }

    @Override // p001ch.qos.logback.core.pattern.parser.FormattingNode, p001ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object o) {
        if (!equals(o) || !(o instanceof SimpleKeywordNode)) {
            return false;
        }
        SimpleKeywordNode r = (SimpleKeywordNode) o;
        return this.optionList != null ? this.optionList.equals(r.optionList) : r.optionList == null;
    }

    @Override // p001ch.qos.logback.core.pattern.parser.FormattingNode, p001ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        return hashCode();
    }

    @Override // p001ch.qos.logback.core.pattern.parser.Node
    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (this.optionList == null) {
            buf.append("KeyWord(" + this.value + "," + this.formatInfo + ")");
        } else {
            buf.append("KeyWord(" + this.value + ", " + this.formatInfo + "," + this.optionList + ")");
        }
        buf.append(printNext());
        return buf.toString();
    }
}
