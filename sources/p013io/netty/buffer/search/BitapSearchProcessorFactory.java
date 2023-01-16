package p013io.netty.buffer.search;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.search.BitapSearchProcessorFactory */
/* loaded from: grasscutter.jar:io/netty/buffer/search/BitapSearchProcessorFactory.class */
public class BitapSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final long[] bitMasks = new long[256];
    private final long successBit;

    /* renamed from: io.netty.buffer.search.BitapSearchProcessorFactory$Processor */
    /* loaded from: grasscutter.jar:io/netty/buffer/search/BitapSearchProcessorFactory$Processor.class */
    public static class Processor implements SearchProcessor {
        private final long[] bitMasks;
        private final long successBit;
        private long currentMask;

        Processor(long[] bitMasks, long successBit) {
            this.bitMasks = bitMasks;
            this.successBit = successBit;
        }

        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) {
            this.currentMask = ((this.currentMask << 1) | 1) & PlatformDependent.getLong(this.bitMasks, ((long) value) & 255);
            return (this.currentMask & this.successBit) == 0;
        }

        @Override // p013io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentMask = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* access modifiers changed from: package-private */
    public BitapSearchProcessorFactory(byte[] needle) {
        if (needle.length > 64) {
            throw new IllegalArgumentException("Maximum supported search pattern length is 64, got " + needle.length);
        }
        char c = 1;
        for (byte c2 : needle) {
            long[] jArr = this.bitMasks;
            int i = c2 & 255;
            jArr[i] = jArr[i] | c;
            c <<= 1;
        }
        this.successBit = 1 << (needle.length - 1);
    }

    @Override // p013io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.bitMasks, this.successBit);
    }
}
