package p001ch.qos.logback.core.subst;

/* renamed from: ch.qos.logback.core.subst.Node */
/* loaded from: grasscutter.jar:ch/qos/logback/core/subst/Node.class */
public class Node {
    Type type;
    Object payload;
    Object defaultPart;
    Node next;

    /* access modifiers changed from: package-private */
    /* renamed from: ch.qos.logback.core.subst.Node$Type */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/subst/Node$Type.class */
    public enum Type {
        LITERAL,
        VARIABLE
    }

    public Node(Type type, Object payload) {
        this.type = type;
        this.payload = payload;
    }

    public Node(Type type, Object payload, Object defaultPart) {
        this.type = type;
        this.payload = payload;
        this.defaultPart = defaultPart;
    }

    /* access modifiers changed from: package-private */
    public void append(Node newNode) {
        if (newNode != null) {
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public String toString() {
        switch (this.type) {
            case LITERAL:
                return "Node{type=" + this.type + ", payload='" + this.payload + "'}";
            case VARIABLE:
                StringBuilder payloadBuf = new StringBuilder();
                StringBuilder defaultPartBuf2 = new StringBuilder();
                if (this.defaultPart != null) {
                    recursive((Node) this.defaultPart, defaultPartBuf2);
                }
                recursive((Node) this.payload, payloadBuf);
                String r = "Node{type=" + this.type + ", payload='" + payloadBuf.toString() + "'";
                if (this.defaultPart != null) {
                    r = r + ", defaultPart=" + defaultPartBuf2.toString();
                }
                return r + '}';
            default:
                return null;
        }
    }

    public void dump() {
        System.out.print(toString());
        System.out.print(" -> ");
        if (this.next != null) {
            this.next.dump();
        } else {
            System.out.print(" null");
        }
    }

    void recursive(Node n, StringBuilder sb) {
        for (Node c = n; c != null; c = c.next) {
            sb.append(c.toString()).append(" --> ");
        }
        sb.append("null ");
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        if (this.type != node.type) {
            return false;
        }
        if (this.payload != null) {
            if (!this.payload.equals(node.payload)) {
                return false;
            }
        } else if (node.payload != null) {
            return false;
        }
        if (this.defaultPart != null) {
            if (!this.defaultPart.equals(node.defaultPart)) {
                return false;
            }
        } else if (node.defaultPart != null) {
            return false;
        }
        if (this.next != null) {
            if (!this.next.equals(node.next)) {
                return false;
            }
            return true;
        } else if (node.next != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * (this.type != null ? this.type.hashCode() : 0)) + (this.payload != null ? this.payload.hashCode() : 0))) + (this.defaultPart != null ? this.defaultPart.hashCode() : 0))) + (this.next != null ? this.next.hashCode() : 0);
    }
}
