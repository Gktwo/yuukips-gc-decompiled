package p013io.netty.buffer;

import java.util.Arrays;

/* renamed from: io.netty.buffer.LongPriorityQueue */
/* loaded from: grasscutter.jar:io/netty/buffer/LongPriorityQueue.class */
final class LongPriorityQueue {
    public static final int NO_VALUE = -1;
    private long[] array = new long[9];
    private int size;

    public void offer(long handle) {
        if (handle == -1) {
            throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
        }
        this.size++;
        if (this.size == this.array.length) {
            this.array = Arrays.copyOf(this.array, 1 + ((this.array.length - 1) * 2));
        }
        this.array[this.size] = handle;
        lift(this.size);
    }

    public void remove(long value) {
        for (int i = 1; i <= this.size; i++) {
            if (this.array[i] == value) {
                long[] jArr = this.array;
                long[] jArr2 = this.array;
                int i2 = this.size;
                this.size = i2 - 1;
                jArr[i] = jArr2[i2];
                lift(i);
                sink(i);
                return;
            }
        }
    }

    public long peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[1];
    }

    public long poll() {
        if (this.size == 0) {
            return -1;
        }
        long val = this.array[1];
        this.array[1] = this.array[this.size];
        this.array[this.size] = 0;
        this.size--;
        sink(1);
        return val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void lift(int index) {
        while (index > 1) {
            int parentIndex = index >> 1;
            if (subord(parentIndex, index)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                return;
            }
        }
    }

    private void sink(int index) {
        while (true) {
            int i = index << 1;
            int child = i;
            if (i <= this.size) {
                if (child < this.size && subord(child, child + 1)) {
                    child++;
                }
                if (subord(index, child)) {
                    swap(index, child);
                    index = child;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private boolean subord(int a, int b) {
        return this.array[a] > this.array[b];
    }

    private void swap(int a, int b) {
        long value = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = value;
    }
}
