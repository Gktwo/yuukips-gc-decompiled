package p013io.netty.buffer;

/* renamed from: io.netty.buffer.LongLongHashMap */
/* loaded from: grasscutter.jar:io/netty/buffer/LongLongHashMap.class */
final class LongLongHashMap {
    private static final int MASK_TEMPLATE = -2;
    private int maxProbe;
    private long zeroVal;
    private final long emptyVal;
    private long[] array = new long[32];
    private int mask = 32 - 1;

    /* access modifiers changed from: package-private */
    public LongLongHashMap(long emptyVal) {
        this.emptyVal = emptyVal;
        this.zeroVal = emptyVal;
        computeMaskAndProbe();
    }

    public long put(long key, long value) {
        int index;
        int i;
        long existing;
        if (key == 0) {
            long prev = this.zeroVal;
            this.zeroVal = value;
            return prev;
        }
        loop0: while (true) {
            index = index(key);
            i = 0;
            while (i < this.maxProbe) {
                existing = this.array[index];
                if (existing == key || existing == 0) {
                    break loop0;
                }
                index = (index + 2) & this.mask;
                i++;
            }
            expand();
        }
        long prev2 = existing == 0 ? this.emptyVal : this.array[index + 1];
        this.array[index] = key;
        this.array[index + 1] = value;
        while (true) {
            if (i >= this.maxProbe) {
                break;
            }
            index = (index + 2) & this.mask;
            if (this.array[index] == key) {
                this.array[index] = 0;
                prev2 = this.array[index + 1];
                break;
            }
            i++;
        }
        return prev2;
    }

    public void remove(long key) {
        if (key == 0) {
            this.zeroVal = this.emptyVal;
            return;
        }
        int index = index(key);
        for (int i = 0; i < this.maxProbe; i++) {
            if (this.array[index] == key) {
                this.array[index] = 0;
                return;
            } else {
                index = (index + 2) & this.mask;
            }
        }
    }

    public long get(long key) {
        if (key == 0) {
            return this.zeroVal;
        }
        int index = index(key);
        for (int i = 0; i < this.maxProbe; i++) {
            if (this.array[index] == key) {
                return this.array[index + 1];
            }
            index = (index + 2) & this.mask;
        }
        return this.emptyVal;
    }

    private int index(long key) {
        long key2 = (key ^ (key >>> 33)) * -49064778989728563L;
        long key3 = (key2 ^ (key2 >>> 33)) * -4265267296055464877L;
        return ((int) (key3 ^ (key3 >>> 33))) & this.mask;
    }

    private void expand() {
        long[] prev = this.array;
        this.array = new long[prev.length * 2];
        computeMaskAndProbe();
        for (int i = 0; i < prev.length; i += 2) {
            long key = prev[i];
            if (key != 0) {
                put(key, prev[i + 1]);
            }
        }
    }

    private void computeMaskAndProbe() {
        int length = this.array.length;
        this.mask = (length - 1) & -2;
        this.maxProbe = (int) Math.log((double) length);
    }
}
