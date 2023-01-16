package p013io.netty.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import p013io.netty.util.ByteProcessor;

@Deprecated
/* renamed from: io.netty.buffer.SlicedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/SlicedByteBuf.class */
public class SlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    private int length;

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        return forEachByteDesc(i, i2, byteProcessor);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        return forEachByte(i, i2, byteProcessor);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer[] nioBuffers(int i, int i2) {
        return nioBuffers(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractDerivedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer nioBuffer(int i, int i2) {
        return nioBuffer(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int nioBufferCount() {
        return nioBufferCount();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return setBytes(i, fileChannel, j, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        return setBytes(i, scatteringByteChannel, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        return setBytes(i, inputStream, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return getBytes(i, fileChannel, j, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return getBytes(i, gatheringByteChannel, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        return getBytes(i, outputStream, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        return setBytes(i, byteBuffer);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return setBytes(i, byteBuf, i2, i3);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        return setBytes(i, bArr, i2, i3);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLongLE(int i, long j) {
        return setLongLE(i, j);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLong(int i, long j) {
        return setLong(i, j);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setIntLE(int i, int i2) {
        return setIntLE(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setInt(int i, int i2) {
        return setInt(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMediumLE(int i, int i2) {
        return setMediumLE(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMedium(int i, int i2) {
        return setMedium(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShortLE(int i, int i2) {
        return setShortLE(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShort(int i, int i2) {
        return setShort(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ CharSequence getCharSequence(int i, int i2, Charset charset) {
        return getCharSequence(i, i2, charset);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setByte(int i, int i2) {
        return setByte(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        return getBytes(i, byteBuffer);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        return getBytes(i, bArr, i2, i3);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return getBytes(i, byteBuf, i2, i3);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf slice(int i, int i2) {
        return slice(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf copy(int i, int i2) {
        return copy(i, i2);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf duplicate() {
        return duplicate();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLongLE(int i) {
        return getLongLE(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLong(int i) {
        return getLong(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getIntLE(int i) {
        return getIntLE(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getInt(int i) {
        return getInt(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMediumLE(int i) {
        return getUnsignedMediumLE(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMedium(int i) {
        return getUnsignedMedium(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShortLE(int i) {
        return getShortLE(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShort(int i) {
        return getShort(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte getByte(int i) {
        return getByte(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long memoryAddress() {
        return memoryAddress();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean hasMemoryAddress() {
        return hasMemoryAddress();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int arrayOffset() {
        return arrayOffset();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte[] array() {
        return array();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean hasArray() {
        return hasArray();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf capacity(int i) {
        return capacity(i);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean isDirect() {
        return isDirect();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    @Deprecated
    public /* bridge */ /* synthetic */ ByteOrder order() {
        return order();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBufAllocator alloc() {
        return alloc();
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf unwrap() {
        return unwrap();
    }

    public SlicedByteBuf(ByteBuf buffer, int index, int length) {
        super(buffer, index, length);
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf
    final void initLength(int length) {
        this.length = length;
    }

    @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf
    final int length() {
        return this.length;
    }

    @Override // p013io.netty.buffer.ByteBuf
    public int capacity() {
        return this.length;
    }
}
