package p013io.netty.handler.codec.serialization;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.serialization.ObjectEncoderOutputStream */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ObjectEncoderOutputStream.class */
public class ObjectEncoderOutputStream extends OutputStream implements ObjectOutput {
    private final DataOutputStream out;
    private final int estimatedLength;

    public ObjectEncoderOutputStream(OutputStream out) {
        this(out, 512);
    }

    public ObjectEncoderOutputStream(OutputStream out, int estimatedLength) {
        ObjectUtil.checkNotNull(out, "out");
        ObjectUtil.checkPositiveOrZero(estimatedLength, "estimatedLength");
        if (out instanceof DataOutputStream) {
            this.out = (DataOutputStream) out;
        } else {
            this.out = new DataOutputStream(out);
        }
        this.estimatedLength = estimatedLength;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0028
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.io.ObjectOutput
    public void writeObject(java.lang.Object r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r6
            int r0 = r0.estimatedLength
            io.netty.buffer.ByteBuf r0 = p013io.netty.buffer.Unpooled.buffer(r0)
            r8 = r0
            io.netty.handler.codec.serialization.CompactObjectOutputStream r0 = new io.netty.handler.codec.serialization.CompactObjectOutputStream     // Catch: all -> 0x004e
            r1 = r0
            io.netty.buffer.ByteBufOutputStream r2 = new io.netty.buffer.ByteBufOutputStream     // Catch: all -> 0x004e
            r3 = r2
            r4 = r8
            r3.<init>(r4)     // Catch: all -> 0x004e
            r1.<init>(r2)     // Catch: all -> 0x004e
            r9 = r0
            r0 = r9
            r1 = r7
            r0.writeObject(r1)     // Catch: all -> 0x004e, all -> 0x0028
            r0 = r9
            r0.flush()     // Catch: all -> 0x004e, all -> 0x0028
            r0 = r9
            r0.close()     // Catch: all -> 0x004e
            goto L_0x0031
        L_0x0028:
            r10 = move-exception
            r0 = r9
            r0.close()     // Catch: all -> 0x004e
            r0 = r10
            throw r0     // Catch: all -> 0x004e
        L_0x0031:
            r0 = r8
            int r0 = r0.readableBytes()     // Catch: all -> 0x004e
            r10 = r0
            r0 = r6
            r1 = r10
            r0.writeInt(r1)     // Catch: all -> 0x004e
            r0 = r8
            r1 = 0
            r2 = r6
            r3 = r10
            io.netty.buffer.ByteBuf r0 = r0.getBytes(r1, r2, r3)     // Catch: all -> 0x004e
            r0 = r8
            boolean r0 = r0.release()
            goto L_0x0058
        L_0x004e:
            r11 = move-exception
            r0 = r8
            boolean r0 = r0.release()
            r0 = r11
            throw r0
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.serialization.ObjectEncoderOutputStream.writeObject(java.lang.Object):void");
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(int b) throws IOException {
        this.out.write(b);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectOutput
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable, java.io.ObjectOutput
    public void flush() throws IOException {
        this.out.flush();
    }

    public final int size() {
        return this.out.size();
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] b) throws IOException {
        this.out.write(b);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean v) throws IOException {
        this.out.writeBoolean(v);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int v) throws IOException {
        this.out.writeByte(v);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String s) throws IOException {
        this.out.writeBytes(s);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int v) throws IOException {
        this.out.writeChar(v);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String s) throws IOException {
        this.out.writeChars(s);
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double v) throws IOException {
        this.out.writeDouble(v);
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float v) throws IOException {
        this.out.writeFloat(v);
    }

    @Override // java.io.DataOutput
    public final void writeInt(int v) throws IOException {
        this.out.writeInt(v);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long v) throws IOException {
        this.out.writeLong(v);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int v) throws IOException {
        this.out.writeShort(v);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        this.out.writeUTF(str);
    }
}
