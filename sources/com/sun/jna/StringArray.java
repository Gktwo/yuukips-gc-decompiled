package com.sun.jna;

import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:com/sun/jna/StringArray.class */
public class StringArray extends Memory implements Function.PostCallRead {
    private String encoding;
    private List<NativeString> natives;
    private Object[] original;

    public StringArray(String[] strings) {
        this(strings, false);
    }

    public StringArray(String[] strings, boolean wide) {
        this((Object[]) strings, wide ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
    }

    public StringArray(String[] strings, String encoding) {
        this((Object[]) strings, encoding);
    }

    public StringArray(WString[] strings) {
        this(strings, "--WIDE-STRING--");
    }

    private StringArray(Object[] strings, String encoding) {
        super((long) ((strings.length + 1) * Native.POINTER_SIZE));
        this.natives = new ArrayList();
        this.original = strings;
        this.encoding = encoding;
        for (int i = 0; i < strings.length; i++) {
            Pointer p = null;
            if (strings[i] != null) {
                NativeString ns = new NativeString(strings[i].toString(), encoding);
                this.natives.add(ns);
                p = ns.getPointer();
            }
            setPointer((long) (Native.POINTER_SIZE * i), p);
        }
        setPointer((long) (Native.POINTER_SIZE * strings.length), null);
    }

    @Override // com.sun.jna.Function.PostCallRead
    public void read() {
        boolean returnWide = this.original instanceof WString[];
        boolean wide = "--WIDE-STRING--".equals(this.encoding);
        for (int si = 0; si < this.original.length; si++) {
            Pointer p = getPointer((long) (si * Native.POINTER_SIZE));
            Object s = null;
            if (p != null) {
                s = wide ? p.getWideString(0) : p.getString(0, this.encoding);
                if (returnWide) {
                    s = new WString((String) s);
                }
            }
            this.original[si] = s;
        }
    }

    @Override // com.sun.jna.Memory, com.sun.jna.Pointer
    public String toString() {
        return ("--WIDE-STRING--".equals(this.encoding) ? "const wchar_t*[]" : "const char*[]") + Arrays.asList(this.original);
    }
}
