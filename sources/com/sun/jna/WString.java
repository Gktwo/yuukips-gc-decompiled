package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/WString.class */
public final class WString implements CharSequence, Comparable {
    private String string;

    public WString(String s) {
        if (s == null) {
            throw new NullPointerException("String initializer must be non-null");
        }
        this.string = s;
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public String toString() {
        return this.string;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        return (o instanceof WString) && toString().equals(o.toString());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }
}
