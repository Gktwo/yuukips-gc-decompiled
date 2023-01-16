package kcp.highway.erasure.fec;

import kcp.highway.erasure.IFecEncode;
import kcp.highway.erasure.ReedSolomon;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fec/FecEncode.class */
public class FecEncode implements IFecEncode {
    private int dataShards;
    private int parityShards;
    private int shardSize;
    private long paws;
    private long next;
    private int shardCount;
    private int maxSize;
    private int headerOffset;
    private int payloadOffset;
    private ByteBuf[] shardCache;
    private ByteBuf[] encodeCache;
    private ByteBuf zeros;
    private ReedSolomon codec;

    public FecEncode(int headerOffset, ReedSolomon codec, int mtu) {
        this.dataShards = codec.getDataShardCount();
        this.parityShards = codec.getParityShardCount();
        this.shardSize = this.dataShards + this.parityShards;
        this.paws = (4294967295L / ((long) this.shardSize)) * ((long) this.shardSize);
        this.headerOffset = headerOffset;
        this.payloadOffset = headerOffset + Fec.fecHeaderSize;
        this.codec = codec;
        this.shardCache = new ByteBuf[this.shardSize];
        this.encodeCache = new ByteBuf[this.parityShards];
        this.zeros = ByteBufAllocator.DEFAULT.buffer(mtu);
        this.zeros.writeBytes(new byte[mtu]);
    }

    @Override // kcp.highway.erasure.IFecEncode
    public ByteBuf[] encode(ByteBuf byteBuf) {
        int headerOffset = this.headerOffset;
        int payloadOffset = this.payloadOffset;
        int dataShards = this.dataShards;
        int parityShards = this.parityShards;
        ByteBuf[] shardCache = this.shardCache;
        ByteBuf[] encodeCache = this.encodeCache;
        ByteBuf zeros = this.zeros;
        markData(byteBuf, headerOffset);
        int sz = byteBuf.writerIndex();
        byteBuf.setShort(payloadOffset, (sz - headerOffset) - Fec.fecHeaderSizePlus2);
        shardCache[this.shardCount] = byteBuf.retainedDuplicate();
        this.shardCount++;
        if (sz > this.maxSize) {
            this.maxSize = sz;
        }
        if (this.shardCount != dataShards) {
            return null;
        }
        for (int i = 0; i < parityShards; i++) {
            ByteBuf parityByte = ByteBufAllocator.DEFAULT.buffer(this.maxSize);
            shardCache[i + dataShards] = parityByte;
            encodeCache[i] = parityByte;
            markParity(parityByte, headerOffset);
            parityByte.writerIndex(this.maxSize);
        }
        for (int i2 = 0; i2 < dataShards; i2++) {
            ByteBuf shard = shardCache[i2];
            int left = this.maxSize - shard.writerIndex();
            if (left > 0) {
                shard.writeBytes(zeros, left);
                zeros.readerIndex(0);
            }
        }
        this.codec.encodeParity(shardCache, payloadOffset, this.maxSize - payloadOffset);
        for (int i3 = 0; i3 < dataShards; i3++) {
            shardCache[i3].release();
            shardCache[i3] = null;
        }
        this.shardCount = 0;
        this.maxSize = 0;
        return encodeCache;
    }

    @Override // kcp.highway.erasure.IFecEncode
    public void release() {
        this.dataShards = 0;
        this.parityShards = 0;
        this.shardSize = 0;
        this.paws = 0;
        this.next = 0;
        this.shardCount = 0;
        this.maxSize = 0;
        this.headerOffset = 0;
        this.payloadOffset = 0;
        for (int i = 0; i < this.dataShards; i++) {
            ByteBuf byteBuf = this.shardCache[i];
            if (byteBuf != null) {
                byteBuf.release();
            }
        }
        this.zeros.release();
        this.codec = null;
    }

    public static void main(String[] args) {
        System.out.println((Integer.MAX_VALUE + 1) % Integer.MAX_VALUE);
    }

    private void markData(ByteBuf byteBuf, int offset) {
        byteBuf.setIntLE(offset, (int) this.next);
        byteBuf.setShortLE(offset + 4, Fec.typeData);
        this.next++;
    }

    private void markParity(ByteBuf byteBuf, int offset) {
        byteBuf.setIntLE(offset, (int) this.next);
        byteBuf.setShortLE(offset + 4, Fec.typeParity);
        this.next = (this.next + 1) % this.paws;
    }
}
