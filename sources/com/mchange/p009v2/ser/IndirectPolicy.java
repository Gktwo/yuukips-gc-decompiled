package com.mchange.p009v2.ser;

/* renamed from: com.mchange.v2.ser.IndirectPolicy */
/* loaded from: grasscutter.jar:com/mchange/v2/ser/IndirectPolicy.class */
public final class IndirectPolicy {
    public static final IndirectPolicy DEFINITELY_INDIRECT = new IndirectPolicy("DEFINITELY_INDIRECT");
    public static final IndirectPolicy INDIRECT_ON_EXCEPTION = new IndirectPolicy("INDIRECT_ON_EXCEPTION");
    public static final IndirectPolicy DEFINITELY_DIRECT = new IndirectPolicy("DEFINITELY_DIRECT");
    String name;

    private IndirectPolicy(String str) {
        this.name = str;
    }

    public String toString() {
        return "[IndirectPolicy: " + this.name + ']';
    }
}
