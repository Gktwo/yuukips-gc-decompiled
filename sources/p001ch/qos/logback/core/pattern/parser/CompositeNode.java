package p001ch.qos.logback.core.pattern.parser;

/* renamed from: ch.qos.logback.core.pattern.parser.CompositeNode */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/CompositeNode.class */
public class CompositeNode extends SimpleKeywordNode {
    Node childNode;

    /* access modifiers changed from: package-private */
    public CompositeNode(String keyword) {
        super(2, keyword);
    }

    public Node getChildNode() {
        return this.childNode;
    }

    public void setChildNode(Node childNode) {
        this.childNode = childNode;
    }

    @Override // p001ch.qos.logback.core.pattern.parser.SimpleKeywordNode, p001ch.qos.logback.core.pattern.parser.FormattingNode, p001ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object o) {
        if (!equals(o) || !(o instanceof CompositeNode)) {
            return false;
        }
        CompositeNode r = (CompositeNode) o;
        return this.childNode != null ? this.childNode.equals(r.childNode) : r.childNode == null;
    }

    @Override // p001ch.qos.logback.core.pattern.parser.SimpleKeywordNode, p001ch.qos.logback.core.pattern.parser.FormattingNode, p001ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        return hashCode();
    }

    @Override // p001ch.qos.logback.core.pattern.parser.SimpleKeywordNode, p001ch.qos.logback.core.pattern.parser.Node
    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (this.childNode != null) {
            buf.append("CompositeNode(" + this.childNode + ")");
        } else {
            buf.append("CompositeNode(no child)");
        }
        buf.append(printNext());
        return buf.toString();
    }
}
