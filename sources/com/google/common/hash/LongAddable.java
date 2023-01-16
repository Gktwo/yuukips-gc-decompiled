package com.google.common.hash;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/common/hash/LongAddable.class */
public interface LongAddable {
    void increment();

    void add(long j);

    long sum();
}
