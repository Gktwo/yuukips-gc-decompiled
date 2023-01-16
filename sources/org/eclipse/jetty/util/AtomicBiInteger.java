package org.eclipse.jetty.util;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/AtomicBiInteger.class */
public class AtomicBiInteger extends AtomicLong {
    public AtomicBiInteger() {
    }

    public AtomicBiInteger(long encoded) {
        super(encoded);
    }

    public AtomicBiInteger(int hi, int lo) {
        super(encode(hi, lo));
    }

    public int getHi() {
        return getHi(get());
    }

    public int getLo() {
        return getLo(get());
    }

    public int getAndSetHi(int hi) {
        long encoded;
        do {
            encoded = get();
        } while (!compareAndSet(encoded, encodeHi(encoded, hi)));
        return getHi(encoded);
    }

    public int getAndSetLo(int lo) {
        long encoded;
        do {
            encoded = get();
        } while (!compareAndSet(encoded, encodeLo(encoded, lo)));
        return getLo(encoded);
    }

    public void set(int hi, int lo) {
        set(encode(hi, lo));
    }

    public boolean compareAndSetHi(int expectHi, int hi) {
        long encoded;
        do {
            encoded = get();
            if (getHi(encoded) != expectHi) {
                return false;
            }
        } while (!compareAndSet(encoded, encodeHi(encoded, hi)));
        return true;
    }

    public boolean compareAndSetLo(int expectLo, int lo) {
        long encoded;
        do {
            encoded = get();
            if (getLo(encoded) != expectLo) {
                return false;
            }
        } while (!compareAndSet(encoded, encodeLo(encoded, lo)));
        return true;
    }

    public boolean compareAndSet(long encoded, int hi, int lo) {
        return compareAndSet(encoded, encode(hi, lo));
    }

    public boolean compareAndSet(int expectHi, int hi, int expectLo, int lo) {
        return compareAndSet(encode(expectHi, expectLo), encode(hi, lo));
    }

    public int addAndGetHi(int delta) {
        long encoded;
        int hi;
        do {
            encoded = get();
            hi = getHi(encoded) + delta;
        } while (!compareAndSet(encoded, encodeHi(encoded, hi)));
        return hi;
    }

    public int addAndGetLo(int delta) {
        long encoded;
        int lo;
        do {
            encoded = get();
            lo = getLo(encoded) + delta;
        } while (!compareAndSet(encoded, encodeLo(encoded, lo)));
        return lo;
    }

    public void add(int deltaHi, int deltaLo) {
        long encoded;
        do {
            encoded = get();
        } while (!compareAndSet(encoded, encode(getHi(encoded) + deltaHi, getLo(encoded) + deltaLo)));
    }

    public static int getHi(long encoded) {
        return (int) ((encoded >> 32) & 4294967295L);
    }

    public static int getLo(long encoded) {
        return (int) (encoded & 4294967295L);
    }

    public static long encode(int hi, int lo) {
        return ((((long) hi) & 4294967295L) << 32) + (((long) lo) & 4294967295L);
    }

    public static long encodeHi(long encoded, int hi) {
        return ((((long) hi) & 4294967295L) << 32) + (encoded & 4294967295L);
    }

    public static long encodeLo(long encoded, int lo) {
        return (((encoded >> 32) & 4294967295L) << 32) + (((long) lo) & 4294967295L);
    }
}
