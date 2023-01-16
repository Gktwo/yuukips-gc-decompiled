package org.eclipse.jetty.websocket.common.message;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Utf8Appendable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/Utf8CharBuffer.class */
public class Utf8CharBuffer extends Utf8Appendable {
    private final CharBuffer buffer;

    public static Utf8CharBuffer wrap(ByteBuffer buffer) {
        return new Utf8CharBuffer(buffer.asCharBuffer());
    }

    private Utf8CharBuffer(CharBuffer buffer) {
        super(buffer);
        this.buffer = buffer;
    }

    public void append(char[] cbuf, int offset, int size) {
        append(BufferUtil.toDirectBuffer(new String(cbuf, offset, size), StandardCharsets.UTF_8));
    }

    public void append(int c) {
        this.buffer.append((char) c);
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public void reset() {
        clear();
        reset();
    }

    public void clear() {
        this.buffer.position(0);
        this.buffer.limit(this.buffer.capacity());
    }

    public ByteBuffer getByteBuffer() {
        int limit = this.buffer.limit();
        int position = this.buffer.position();
        this.buffer.limit(this.buffer.position());
        this.buffer.position(0);
        ByteBuffer bb = StandardCharsets.UTF_8.encode(this.buffer);
        this.buffer.limit(limit);
        this.buffer.position(position);
        return bb;
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public int length() {
        return this.buffer.capacity();
    }

    public int remaining() {
        return this.buffer.remaining();
    }

    @Override // org.eclipse.jetty.util.Utf8Appendable
    public String getPartialString() {
        return this.buffer.toString();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Utf8CharBuffer@").append(hashCode());
        str.append("[p=").append(this.buffer.position());
        str.append(",l=").append(this.buffer.limit());
        str.append(",c=").append(this.buffer.capacity());
        str.append(",r=").append(this.buffer.remaining());
        str.append("]");
        return str.toString();
    }
}
