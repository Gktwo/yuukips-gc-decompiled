package p001ch.qos.logback.core.joran.spi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ch.qos.logback.core.joran.spi.ElementPath */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/ElementPath.class */
public class ElementPath {
    ArrayList<String> partList = new ArrayList<>();

    public ElementPath() {
    }

    public ElementPath(List<String> list) {
        this.partList.addAll(list);
    }

    public ElementPath(String pathStr) {
        String[] partArray;
        if (!(pathStr == null || (partArray = pathStr.split("/")) == null)) {
            for (String part : partArray) {
                if (part.length() > 0) {
                    this.partList.add(part);
                }
            }
        }
    }

    public ElementPath duplicate() {
        ElementPath p = new ElementPath();
        p.partList.addAll(this.partList);
        return p;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof ElementPath)) {
            return false;
        }
        ElementPath r = (ElementPath) o;
        if (r.size() != size()) {
            return false;
        }
        int len = size();
        for (int i = 0; i < len; i++) {
            if (!equalityCheck(get(i), r.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean equalityCheck(String x, String y) {
        return x.equalsIgnoreCase(y);
    }

    public List<String> getCopyOfPartList() {
        return new ArrayList(this.partList);
    }

    public void push(String s) {
        this.partList.add(s);
    }

    public String get(int i) {
        return this.partList.get(i);
    }

    public void pop() {
        if (!this.partList.isEmpty()) {
            this.partList.remove(this.partList.size() - 1);
        }
    }

    public String peekLast() {
        if (this.partList.isEmpty()) {
            return null;
        }
        return this.partList.get(this.partList.size() - 1);
    }

    public int size() {
        return this.partList.size();
    }

    /* access modifiers changed from: protected */
    public String toStableString() {
        StringBuilder result = new StringBuilder();
        Iterator<String> it = this.partList.iterator();
        while (it.hasNext()) {
            result.append("[").append(it.next()).append("]");
        }
        return result.toString();
    }

    public String toString() {
        return toStableString();
    }
}
