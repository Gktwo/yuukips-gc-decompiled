package org.eclipse.jetty.util;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Utf8StringBuffer.class */
public class Utf8StringBuffer extends Utf8Appendable {
    final StringBuffer _buffer = (StringBuffer) this._appendable;

    public Utf8StringBuffer() {
        super(new StringBuffer());
    }

    public Utf8StringBuffer(int capacity) {
        super(new StringBuffer(capacity));
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

    public StringBuffer getStringBuffer() {
        checkState();
        return this._buffer;
    }

    public String toString() {
        checkState();
        return this._buffer.toString();
    }
}
