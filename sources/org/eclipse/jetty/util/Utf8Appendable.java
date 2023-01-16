package org.eclipse.jetty.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Utf8Appendable.class */
public abstract class Utf8Appendable {
    public static final char REPLACEMENT = 65533;
    private static final int UTF8_ACCEPT = 0;
    private static final int UTF8_REJECT = 12;
    protected final Appendable _appendable;
    protected int _state = 0;
    private int _codep;
    protected static final Logger LOG = Log.getLogger(Utf8Appendable.class);
    public static final byte[] REPLACEMENT_UTF8 = {-17, -65, -67};
    private static final byte[] BYTE_TABLE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 3, 11, 6, 6, 6, 5, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    private static final byte[] TRANS_TABLE = {0, 12, 24, 36, 60, 96, 84, 12, 12, 12, 48, 72, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 0, 12, 12, 12, 12, 12, 0, 12, 0, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 24, 12, 12, 12, 12, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 36, 12, 36, 12, 12, 12, 36, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public abstract int length();

    public abstract String getPartialString();

    public Utf8Appendable(Appendable appendable) {
        this._appendable = appendable;
    }

    /* access modifiers changed from: protected */
    public void reset() {
        this._state = 0;
    }

    private void checkCharAppend() throws IOException {
        if (this._state != 0) {
            this._appendable.append((char) 65533);
            int state = this._state;
            this._state = 0;
            throw new NotUtf8Exception("char appended in state " + state);
        }
    }

    public void append(char c) {
        try {
            checkCharAppend();
            this._appendable.append(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void append(String s) {
        try {
            checkCharAppend();
            this._appendable.append(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void append(String s, int offset, int length) {
        try {
            checkCharAppend();
            this._appendable.append(s, offset, offset + length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void append(byte b) {
        try {
            appendByte(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void append(ByteBuffer buf) {
        while (buf.remaining() > 0) {
            try {
                appendByte(buf.get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void append(byte[] b) {
        append(b, 0, b.length);
    }

    public void append(byte[] b, int offset, int length) {
        try {
            int end = offset + length;
            for (int i = offset; i < end; i++) {
                appendByte(b[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean append(byte[] b, int offset, int length, int maxChars) {
        try {
            int end = offset + length;
            for (int i = offset; i < end; i++) {
                if (length() > maxChars) {
                    return false;
                }
                appendByte(b[i]);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void appendByte(byte b) throws IOException {
        if (b <= 0 || this._state != 0) {
            int i = b & 255;
            byte b2 = BYTE_TABLE[i];
            this._codep = this._state == 0 ? (255 >> b2) & i : (i & 63) | (this._codep << 6);
            byte b3 = TRANS_TABLE[this._state + b2];
            switch (b3) {
                case 0:
                    this._state = b3;
                    if (this._codep < 55296) {
                        this._appendable.append((char) this._codep);
                        return;
                    }
                    for (char c : Character.toChars(this._codep)) {
                        this._appendable.append(c);
                    }
                    return;
                case 12:
                    String reason = "byte " + TypeUtil.toHexString(b) + " in state " + (this._state / 12);
                    this._codep = 0;
                    this._state = 0;
                    this._appendable.append((char) 65533);
                    throw new NotUtf8Exception(reason);
                default:
                    this._state = b3;
                    return;
            }
        } else {
            this._appendable.append((char) (b & 255));
        }
    }

    public boolean isUtf8SequenceComplete() {
        return this._state == 0;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Utf8Appendable$NotUtf8Exception.class */
    public static class NotUtf8Exception extends IllegalArgumentException {
        public NotUtf8Exception(String reason) {
            super("Not valid UTF8! " + reason);
        }
    }

    protected void checkState() {
        if (!isUtf8SequenceComplete()) {
            this._codep = 0;
            this._state = 0;
            try {
                this._appendable.append((char) 65533);
                throw new NotUtf8Exception("incomplete UTF8 sequence");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String takePartialString() {
        String partial = getPartialString();
        int save = this._state;
        reset();
        this._state = save;
        return partial;
    }

    public String toReplacedString() {
        if (!isUtf8SequenceComplete()) {
            this._codep = 0;
            this._state = 0;
            try {
                this._appendable.append((char) 65533);
                Throwable th = new NotUtf8Exception("incomplete UTF8 sequence");
                LOG.warn(th.toString(), new Object[0]);
                LOG.debug(th);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this._appendable.toString();
    }
}
