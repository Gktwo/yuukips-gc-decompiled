package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/Buffer.class */
public interface Buffer {
    int cursor();

    int atChar(int i);

    int length();

    int currChar();

    int prevChar();

    int nextChar();

    boolean cursor(int i);

    int move(int i);

    /* renamed from: up */
    boolean mo27up();

    boolean down();

    boolean moveXY(int i, int i2);

    boolean clear();

    boolean currChar(int i);

    void write(int i);

    void write(int i, boolean z);

    void write(CharSequence charSequence);

    void write(CharSequence charSequence, boolean z);

    boolean backspace();

    int backspace(int i);

    boolean delete();

    int delete(int i);

    String substring(int i);

    String substring(int i, int i2);

    String upToCursor();

    String toString();

    Buffer copy();

    void copyFrom(Buffer buffer);
}
