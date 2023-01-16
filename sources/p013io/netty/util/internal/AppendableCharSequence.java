package p013io.netty.util.internal;

import java.util.Arrays;

/* renamed from: io.netty.util.internal.AppendableCharSequence */
/* loaded from: grasscutter.jar:io/netty/util/internal/AppendableCharSequence.class */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int length) {
        this.chars = new char[ObjectUtil.checkPositive(length, "length")];
    }

    private AppendableCharSequence(char[] chars) {
        this.chars = ObjectUtil.checkNonEmpty(chars, "chars");
        this.pos = chars.length;
    }

    public void setLength(int length) {
        if (length < 0 || length > this.pos) {
            throw new IllegalArgumentException("length: " + length + " (length: >= 0, <= " + this.pos + ')');
        }
        this.pos = length;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        if (index <= this.pos) {
            return this.chars[index];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int index) {
        return this.chars[index];
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int start, int end) {
        if (start == end) {
            return new AppendableCharSequence(Math.min(16, this.chars.length));
        }
        return new AppendableCharSequence(Arrays.copyOfRange(this.chars, start, end));
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c) {
        if (this.pos == this.chars.length) {
            char[] old = this.chars;
            this.chars = new char[old.length << 1];
            System.arraycopy(old, 0, this.chars, 0, old.length);
        }
        char[] cArr = this.chars;
        int i = this.pos;
        this.pos = i + 1;
        cArr[i] = c;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence csq) {
        return append(csq, 0, csq.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence csq, int start, int end) {
        if (csq.length() < end) {
            throw new IndexOutOfBoundsException("expected: csq.length() >= (" + end + "),but actual is (" + csq.length() + ")");
        }
        int length = end - start;
        if (length > this.chars.length - this.pos) {
            this.chars = expand(this.chars, this.pos + length, this.pos);
        }
        if (csq instanceof AppendableCharSequence) {
            System.arraycopy(((AppendableCharSequence) csq).chars, start, this.chars, this.pos, length);
            this.pos += length;
            return this;
        }
        for (int i = start; i < end; i++) {
            char[] cArr = this.chars;
            int i2 = this.pos;
            this.pos = i2 + 1;
            cArr[i2] = csq.charAt(i);
        }
        return this;
    }

    public void reset() {
        this.pos = 0;
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    public String substring(int start, int end) {
        int length = end - start;
        if (start <= this.pos && length <= this.pos) {
            return new String(this.chars, start, length);
        }
        throw new IndexOutOfBoundsException("expected: start and length <= (" + this.pos + ")");
    }

    public String subStringUnsafe(int start, int end) {
        return new String(this.chars, start, end - start);
    }

    private static char[] expand(char[] array, int neededSpace, int size) {
        int newCapacity = array.length;
        do {
            newCapacity <<= 1;
            if (newCapacity < 0) {
                throw new IllegalStateException();
            }
        } while (neededSpace > newCapacity);
        char[] newArray = new char[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}
