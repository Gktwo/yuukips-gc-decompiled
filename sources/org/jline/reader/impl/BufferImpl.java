package org.jline.reader.impl;

import java.util.Objects;
import org.jline.reader.Buffer;

/* loaded from: grasscutter.jar:org/jline/reader/impl/BufferImpl.class */
public class BufferImpl implements Buffer {
    private int cursor;
    private int cursorCol;
    private int[] buffer;

    /* renamed from: g0 */
    private int f3230g0;

    /* renamed from: g1 */
    private int f3231g1;

    public BufferImpl() {
        this(64);
    }

    public BufferImpl(int size) {
        this.cursor = 0;
        this.cursorCol = -1;
        this.buffer = new int[size];
        this.f3230g0 = 0;
        this.f3231g1 = this.buffer.length;
    }

    private BufferImpl(BufferImpl buffer) {
        this.cursor = 0;
        this.cursorCol = -1;
        this.cursor = buffer.cursor;
        this.cursorCol = buffer.cursorCol;
        this.buffer = (int[]) buffer.buffer.clone();
        this.f3230g0 = buffer.f3230g0;
        this.f3231g1 = buffer.f3231g1;
    }

    @Override // org.jline.reader.Buffer
    public BufferImpl copy() {
        return new BufferImpl(this);
    }

    @Override // org.jline.reader.Buffer
    public int cursor() {
        return this.cursor;
    }

    @Override // org.jline.reader.Buffer
    public int length() {
        return this.buffer.length - (this.f3231g1 - this.f3230g0);
    }

    @Override // org.jline.reader.Buffer
    public boolean currChar(int ch) {
        if (this.cursor == length()) {
            return false;
        }
        this.buffer[adjust(this.cursor)] = ch;
        return true;
    }

    @Override // org.jline.reader.Buffer
    public int currChar() {
        if (this.cursor == length()) {
            return 0;
        }
        return atChar(this.cursor);
    }

    @Override // org.jline.reader.Buffer
    public int prevChar() {
        if (this.cursor <= 0) {
            return 0;
        }
        return atChar(this.cursor - 1);
    }

    @Override // org.jline.reader.Buffer
    public int nextChar() {
        if (this.cursor >= length() - 1) {
            return 0;
        }
        return atChar(this.cursor + 1);
    }

    @Override // org.jline.reader.Buffer
    public int atChar(int i) {
        if (i < 0 || i >= length()) {
            return 0;
        }
        return this.buffer[adjust(i)];
    }

    private int adjust(int i) {
        return i >= this.f3230g0 ? (i + this.f3231g1) - this.f3230g0 : i;
    }

    @Override // org.jline.reader.Buffer
    public void write(int c) {
        write(new int[]{c});
    }

    @Override // org.jline.reader.Buffer
    public void write(int c, boolean overTyping) {
        if (overTyping) {
            delete(1);
        }
        write(new int[]{c});
    }

    @Override // org.jline.reader.Buffer
    public void write(CharSequence str) {
        Objects.requireNonNull(str);
        write(str.codePoints().toArray());
    }

    @Override // org.jline.reader.Buffer
    public void write(CharSequence str, boolean overTyping) {
        Objects.requireNonNull(str);
        int[] ucps = str.codePoints().toArray();
        if (overTyping) {
            delete(ucps.length);
        }
        write(ucps);
    }

    private void write(int[] ucps) {
        moveGapToCursor();
        int len = length() + ucps.length;
        int sz = this.buffer.length;
        if (sz < len) {
            while (sz < len) {
                sz *= 2;
            }
            int[] nb = new int[sz];
            System.arraycopy(this.buffer, 0, nb, 0, this.f3230g0);
            System.arraycopy(this.buffer, this.f3231g1, nb, (this.f3231g1 + sz) - this.buffer.length, this.buffer.length - this.f3231g1);
            this.f3231g1 += sz - this.buffer.length;
            this.buffer = nb;
        }
        System.arraycopy(ucps, 0, this.buffer, this.cursor, ucps.length);
        this.f3230g0 += ucps.length;
        this.cursor += ucps.length;
        this.cursorCol = -1;
    }

    @Override // org.jline.reader.Buffer
    public boolean clear() {
        if (length() == 0) {
            return false;
        }
        this.f3230g0 = 0;
        this.f3231g1 = this.buffer.length;
        this.cursor = 0;
        this.cursorCol = -1;
        return true;
    }

    @Override // org.jline.reader.Buffer
    public String substring(int start) {
        return substring(start, length());
    }

    @Override // org.jline.reader.Buffer
    public String substring(int start, int end) {
        if (start >= end || start < 0 || end > length()) {
            return "";
        }
        if (end <= this.f3230g0) {
            return new String(this.buffer, start, end - start);
        }
        if (start > this.f3230g0) {
            return new String(this.buffer, (this.f3231g1 - this.f3230g0) + start, end - start);
        }
        int[] b = (int[]) this.buffer.clone();
        System.arraycopy(b, this.f3231g1, b, this.f3230g0, b.length - this.f3231g1);
        return new String(b, start, end - start);
    }

    @Override // org.jline.reader.Buffer
    public String upToCursor() {
        return substring(0, this.cursor);
    }

    @Override // org.jline.reader.Buffer
    public boolean cursor(int position) {
        return position == this.cursor || move(position - this.cursor) != 0;
    }

    @Override // org.jline.reader.Buffer
    public int move(int num) {
        int where = num;
        if (this.cursor == 0 && where <= 0) {
            return 0;
        }
        if (this.cursor == length() && where >= 0) {
            return 0;
        }
        if (this.cursor + where < 0) {
            where = -this.cursor;
        } else if (this.cursor + where > length()) {
            where = length() - this.cursor;
        }
        this.cursor += where;
        this.cursorCol = -1;
        return where;
    }

    @Override // org.jline.reader.Buffer
    /* renamed from: up */
    public boolean mo27up() {
        int col = getCursorCol();
        int pnl = this.cursor - 1;
        while (pnl >= 0 && atChar(pnl) != 10) {
            pnl--;
        }
        if (pnl < 0) {
            return false;
        }
        int ppnl = pnl - 1;
        while (ppnl >= 0 && atChar(ppnl) != 10) {
            ppnl--;
        }
        this.cursor = Math.min(ppnl + col + 1, pnl);
        return true;
    }

    @Override // org.jline.reader.Buffer
    public boolean down() {
        int col = getCursorCol();
        int nnl = this.cursor;
        while (nnl < length() && atChar(nnl) != 10) {
            nnl++;
        }
        if (nnl >= length()) {
            return false;
        }
        int nnnl = nnl + 1;
        while (nnnl < length() && atChar(nnnl) != 10) {
            nnnl++;
        }
        this.cursor = Math.min(nnl + col + 1, nnnl);
        return true;
    }

    @Override // org.jline.reader.Buffer
    public boolean moveXY(int dx, int dy) {
        int col = 0;
        while (prevChar() != 10 && move(-1) == -1) {
            col++;
        }
        this.cursorCol = 0;
        while (dy < 0) {
            mo27up();
            dy++;
        }
        while (dy > 0) {
            down();
            dy--;
        }
        int col2 = Math.max(col + dx, 0);
        for (int i = 0; i < col2 && move(1) == 1 && currChar() != 10; i++) {
        }
        this.cursorCol = col2;
        return true;
    }

    private int getCursorCol() {
        if (this.cursorCol < 0) {
            this.cursorCol = 0;
            int pnl = this.cursor - 1;
            while (pnl >= 0 && atChar(pnl) != 10) {
                pnl--;
            }
            this.cursorCol = (this.cursor - pnl) - 1;
        }
        return this.cursorCol;
    }

    @Override // org.jline.reader.Buffer
    public int backspace(int num) {
        int count = Math.max(Math.min(this.cursor, num), 0);
        moveGapToCursor();
        this.cursor -= count;
        this.f3230g0 -= count;
        this.cursorCol = -1;
        return count;
    }

    @Override // org.jline.reader.Buffer
    public boolean backspace() {
        return backspace(1) == 1;
    }

    @Override // org.jline.reader.Buffer
    public int delete(int num) {
        int count = Math.max(Math.min(length() - this.cursor, num), 0);
        moveGapToCursor();
        this.f3231g1 += count;
        this.cursorCol = -1;
        return count;
    }

    @Override // org.jline.reader.Buffer
    public boolean delete() {
        return delete(1) == 1;
    }

    @Override // org.jline.reader.Buffer
    public String toString() {
        return substring(0, length());
    }

    @Override // org.jline.reader.Buffer
    public void copyFrom(Buffer buf) {
        if (!(buf instanceof BufferImpl)) {
            throw new IllegalStateException();
        }
        BufferImpl that = (BufferImpl) buf;
        this.f3230g0 = that.f3230g0;
        this.f3231g1 = that.f3231g1;
        this.buffer = (int[]) that.buffer.clone();
        this.cursor = that.cursor;
        this.cursorCol = that.cursorCol;
    }

    private void moveGapToCursor() {
        if (this.cursor < this.f3230g0) {
            int l = this.f3230g0 - this.cursor;
            System.arraycopy(this.buffer, this.cursor, this.buffer, this.f3231g1 - l, l);
            this.f3230g0 -= l;
            this.f3231g1 -= l;
        } else if (this.cursor > this.f3230g0) {
            int l2 = this.cursor - this.f3230g0;
            System.arraycopy(this.buffer, this.f3231g1, this.buffer, this.f3230g0, l2);
            this.f3230g0 += l2;
            this.f3231g1 += l2;
        }
    }
}
