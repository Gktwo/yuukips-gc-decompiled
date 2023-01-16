package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMapEntry.class */
public class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {
    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int size) {
        return new ImmutableMapEntry[size];
    }

    /* access modifiers changed from: package-private */
    public ImmutableMapEntry(K key, V value) {
        super(key, value);
        CollectPreconditions.checkEntryNotNull(key, value);
    }

    ImmutableMapEntry(ImmutableMapEntry<K, V> contents) {
        super(contents.getKey(), contents.getValue());
    }

    /* access modifiers changed from: package-private */
    public ImmutableMapEntry<K, V> getNextInKeyBucket() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public ImmutableMapEntry<K, V> getNextInValueBucket() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isReusable() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMapEntry$NonTerminalImmutableMapEntry.class */
    public static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInKeyBucket;

        /* access modifiers changed from: package-private */
        public NonTerminalImmutableMapEntry(K key, V value, ImmutableMapEntry<K, V> nextInKeyBucket) {
            super(key, value);
            this.nextInKeyBucket = nextInKeyBucket;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        final ImmutableMapEntry<K, V> getNextInKeyBucket() {
            return this.nextInKeyBucket;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        final boolean isReusable() {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMapEntry$NonTerminalImmutableBiMapEntry.class */
    public static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {
        private final transient ImmutableMapEntry<K, V> nextInValueBucket;

        /* access modifiers changed from: package-private */
        public NonTerminalImmutableBiMapEntry(K key, V value, ImmutableMapEntry<K, V> nextInKeyBucket, ImmutableMapEntry<K, V> nextInValueBucket) {
            super(key, value, nextInKeyBucket);
            this.nextInValueBucket = nextInValueBucket;
        }

        @Override // com.google.common.collect.ImmutableMapEntry
        ImmutableMapEntry<K, V> getNextInValueBucket() {
            return this.nextInValueBucket;
        }
    }
}
