package p013io.netty.channel;

import java.util.ArrayList;
import java.util.List;
import p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.AdaptiveRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/AdaptiveRecvByteBufAllocator.class */
public class AdaptiveRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    static final int DEFAULT_MINIMUM = 64;
    static final int DEFAULT_INITIAL = 2048;
    static final int DEFAULT_MAXIMUM = 65536;
    private static final int INDEX_INCREMENT = 4;
    private static final int INDEX_DECREMENT = 1;
    private static final int[] SIZE_TABLE;
    @Deprecated
    public static final AdaptiveRecvByteBufAllocator DEFAULT;
    private final int minIndex;
    private final int maxIndex;
    private final int initial;

    static {
        List<Integer> sizeTable = new ArrayList<>();
        for (int i = 16; i < 512; i += 16) {
            sizeTable.add(Integer.valueOf(i));
        }
        for (int i2 = 512; i2 > 0; i2 <<= 1) {
            sizeTable.add(Integer.valueOf(i2));
        }
        SIZE_TABLE = new int[sizeTable.size()];
        for (int i3 = 0; i3 < SIZE_TABLE.length; i3++) {
            SIZE_TABLE[i3] = sizeTable.get(i3).intValue();
        }
        DEFAULT = new AdaptiveRecvByteBufAllocator();
    }

    /* access modifiers changed from: private */
    public static int getSizeTableIndex(int size) {
        int low = 0;
        int high = SIZE_TABLE.length - 1;
        while (high >= low) {
            if (high == low) {
                return high;
            }
            int mid = (low + high) >>> 1;
            int a = SIZE_TABLE[mid];
            if (size > SIZE_TABLE[mid + 1]) {
                low = mid + 1;
            } else if (size < a) {
                high = mid - 1;
            } else if (size == a) {
                return mid;
            } else {
                return mid + 1;
            }
        }
        return low;
    }

    /* renamed from: io.netty.channel.AdaptiveRecvByteBufAllocator$HandleImpl */
    /* loaded from: grasscutter.jar:io/netty/channel/AdaptiveRecvByteBufAllocator$HandleImpl.class */
    private final class HandleImpl extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle {
        private final int minIndex;
        private final int maxIndex;
        private int index;
        private int nextReceiveBufferSize;
        private boolean decreaseNow;

        HandleImpl(int minIndex, int maxIndex, int initial) {
            super();
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
            this.index = AdaptiveRecvByteBufAllocator.getSizeTableIndex(initial);
            this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
        }

        @Override // p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int bytes) {
            if (bytes == attemptedBytesRead()) {
                record(bytes);
            }
            lastBytesRead(bytes);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.nextReceiveBufferSize;
        }

        private void record(int actualReadBytes) {
            if (actualReadBytes <= AdaptiveRecvByteBufAllocator.SIZE_TABLE[Math.max(0, this.index - 1)]) {
                if (this.decreaseNow) {
                    this.index = Math.max(this.index - 1, this.minIndex);
                    this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                    this.decreaseNow = false;
                    return;
                }
                this.decreaseNow = true;
            } else if (actualReadBytes >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = AdaptiveRecvByteBufAllocator.SIZE_TABLE[this.index];
                this.decreaseNow = false;
            }
        }

        @Override // p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            record(totalBytesRead());
        }
    }

    public AdaptiveRecvByteBufAllocator() {
        this(64, 2048, 65536);
    }

    public AdaptiveRecvByteBufAllocator(int minimum, int initial, int maximum) {
        ObjectUtil.checkPositive(minimum, "minimum");
        if (initial < minimum) {
            throw new IllegalArgumentException("initial: " + initial);
        } else if (maximum < initial) {
            throw new IllegalArgumentException("maximum: " + maximum);
        } else {
            int minIndex = getSizeTableIndex(minimum);
            if (SIZE_TABLE[minIndex] < minimum) {
                this.minIndex = minIndex + 1;
            } else {
                this.minIndex = minIndex;
            }
            int maxIndex = getSizeTableIndex(maximum);
            if (SIZE_TABLE[maxIndex] > maximum) {
                this.maxIndex = maxIndex - 1;
            } else {
                this.maxIndex = maxIndex;
            }
            this.initial = initial;
        }
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl(this.minIndex, this.maxIndex, this.initial);
    }

    @Override // p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public AdaptiveRecvByteBufAllocator respectMaybeMoreData(boolean respectMaybeMoreData) {
        respectMaybeMoreData(respectMaybeMoreData);
        return this;
    }
}
