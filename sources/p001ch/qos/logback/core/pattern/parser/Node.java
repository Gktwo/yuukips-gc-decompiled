package p001ch.qos.logback.core.pattern.parser;

/* renamed from: ch.qos.logback.core.pattern.parser.Node */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/Node.class */
public class Node {
    static final int LITERAL = 0;
    static final int SIMPLE_KEYWORD = 1;
    static final int COMPOSITE_KEYWORD = 2;
    final int type;
    final Object value;
    Node next;

    /* access modifiers changed from: package-private */
    public Node(int type) {
        this(type, null);
    }

    /* access modifiers changed from: package-private */
    public Node(int type, Object value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node r = (Node) o;
        return this.type == r.type && (this.value == null ? r.value == null : this.value.equals(r.value)) && (this.next == null ? r.next == null : this.next.equals(r.next));
    }

    public int hashCode() {
        return (31 * this.type) + (this.value != null ? this.value.hashCode() : 0);
    }

    String printNext() {
        if (this.next != null) {
            return " -> " + this.next;
        }
        return "";
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        switch (this.type) {
            case 0:
                buf.append("LITERAL(" + this.value + ")");
                break;
            default:
                buf.append(toString());
                break;
        }
        buf.append(printNext());
        return buf.toString();
    }
}
