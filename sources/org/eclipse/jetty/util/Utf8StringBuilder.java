package org.eclipse.jetty.util;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Utf8StringBuilder.class */
public class Utf8StringBuilder extends Utf8Appendable {
    final StringBuilder _buffer = (StringBuilder) this._appendable;

    public Utf8StringBuilder() {
        super(new StringBuilder());
    }

    public Utf8StringBuilder(int capacity) {
        super(new StringBuilder(capacity));
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public int length() {
        return this._buffer.length();
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public void reset() {
        reset();
        this._buffer.setLength(0);
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public String getPartialString() {
        return this._buffer.toString();
    }

    public StringBuilder getStringBuilder() {
        checkState();
        return this._buffer;
    }

    public String toString() {
        checkState();
        return this._buffer.toString();
    }
}
