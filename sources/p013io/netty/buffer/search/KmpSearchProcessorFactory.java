package p013io.netty.buffer.search;

import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.search.KmpSearchProcessorFactory */
/* loaded from: grasscutter.jar:io/netty/buffer/search/KmpSearchProcessorFactory.class */
public class KmpSearchProcessorFactory extends AbstractSearchProcessorFactory {
    private final int[] jumpTable;
    private final byte[] needle;

    /* renamed from: io.netty.buffer.search.KmpSearchProcessorFactory$Processor */
    /* loaded from: grasscutter.jar:io/netty/buffer/search/KmpSearchProcessorFactory$Processor.class */
    public static class Processor implements SearchProcessor {
        private final byte[] needle;
        private final int[] jumpTable;
        private long currentPosition;

        Processor(byte[] needle, int[] jumpTable) {
            this.needle = needle;
            this.jumpTable = jumpTable;
        }

        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) {
            while (this.currentPosition > 0 && PlatformDependent.getByte(this.needle, this.currentPosition) != value) {
                this.currentPosition = (long) PlatformDependent.getInt(this.jumpTable, this.currentPosition);
            }
            if (PlatformDependent.getByte(this.needle, this.currentPosition) == value) {
                this.currentPosition++;
            }
            if (this.currentPosition != ((long) this.needle.length)) {
                return true;
            }
            this.currentPosition = (long) PlatformDependent.getInt(this.jumpTable, this.currentPosition);
            return false;
        }

        @Override // p013io.netty.buffer.search.SearchProcessor
        public void reset() {
            this.currentPosition = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public KmpSearchProcessorFactory(byte[] needle) {
        this.needle = (byte[]) needle.clone();
        this.jumpTable = new int[needle.length + 1];
        int j = 0;
        int i = 1;
        while (i < needle.length) {
            while (j > 0 && needle[j] != needle[i]) {
                j = this.jumpTable[j];
            }
            if (needle[j] == needle[i]) {
                j++;
            }
            this.jumpTable[i + 1] = j;
            i++;
        }
    }

    @Override // p013io.netty.buffer.search.SearchProcessorFactory
    public Processor newSearchProcessor() {
        return new Processor(this.needle, this.jumpTable);
    }
}
