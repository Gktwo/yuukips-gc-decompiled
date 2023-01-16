package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Handle.class */
public final class Handle {

    /* renamed from: a */
    final int f124a;

    /* renamed from: b */
    final String f125b;

    /* renamed from: c */
    final String f126c;

    /* renamed from: d */
    final String f127d;

    /* renamed from: e */
    final boolean f128e;

    public Handle(int i, String str, String str2, String str3) {
        this(i, str, str2, str3, i == 9);
    }

    public Handle(int i, String str, String str2, String str3, boolean z) {
        this.f124a = i;
        this.f125b = str;
        this.f126c = str2;
        this.f127d = str3;
        this.f128e = z;
    }

    public int getTag() {
        return this.f124a;
    }

    public String getOwner() {
        return this.f125b;
    }

    public String getName() {
        return this.f126c;
    }

    public String getDesc() {
        return this.f127d;
    }

    public boolean isInterface() {
        return this.f128e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle handle = (Handle) obj;
        return this.f124a == handle.f124a && this.f128e == handle.f128e && this.f125b.equals(handle.f125b) && this.f126c.equals(handle.f126c) && this.f127d.equals(handle.f127d);
    }

    public int hashCode() {
        return this.f124a + (this.f128e ? 64 : 0) + (this.f125b.hashCode() * this.f126c.hashCode() * this.f127d.hashCode());
    }

    public String toString() {
        return new StringBuffer().append(this.f125b).append('.').append(this.f126c).append(this.f127d).append(" (").append(this.f124a).append(this.f128e ? " itf" : "").append(')').toString();
    }
}
