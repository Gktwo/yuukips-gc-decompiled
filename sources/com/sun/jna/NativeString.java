package com.sun.jna;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/sun/jna/NativeString.class */
public class NativeString implements CharSequence, Comparable {
    static final String WIDE_STRING = "--WIDE-STRING--";
    private Pointer pointer;
    private String encoding;

    /* loaded from: grasscutter.jar:com/sun/jna/NativeString$StringMemory.class */
    private class StringMemory extends Memory {
        public StringMemory(long size) {
            super(size);
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return NativeString.this.toString();
        }
    }

    public NativeString(String string) {
        this(string, Native.getDefaultStringEncoding());
    }

    public NativeString(String string, boolean wide) {
        this(string, wide ? WIDE_STRING : Native.getDefaultStringEncoding());
    }

    public NativeString(WString string) {
        this(string.toString(), WIDE_STRING);
    }

    public NativeString(String string, String encoding) {
        if (string == null) {
            throw new NullPointerException("String must not be null");
        }
        this.encoding = encoding;
        if (WIDE_STRING.equals(this.encoding)) {
            this.pointer = new StringMemory((long) ((string.length() + 1) * Native.WCHAR_SIZE));
            this.pointer.setWideString(0, string);
            return;
        }
        byte[] data = Native.getBytes(string, encoding);
        this.pointer = new StringMemory((long) (data.length + 1));
        this.pointer.write(0L, data, 0, data.length);
        this.pointer.setByte((long) data.length, (byte) 0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return (other instanceof CharSequence) && compareTo(other) == 0;
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public String toString() {
        return WIDE_STRING.equals(this.encoding) ? this.pointer.getWideString(0) : this.pointer.getString(0, this.encoding);
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        if (other == null) {
            return 1;
        }
        return toString().compareTo(other.toString());
    }
}
