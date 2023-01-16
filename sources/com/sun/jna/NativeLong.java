package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/NativeLong.class */
public class NativeLong extends IntegerType {
    private static final long serialVersionUID = 1;
    public static final int SIZE = Native.LONG_SIZE;

    public NativeLong() {
        this(0);
    }

    public NativeLong(long value) {
        this(value, false);
    }

    public NativeLong(long value, boolean unsigned) {
        super(SIZE, value, unsigned);
    }
}
