package p013io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* renamed from: io.netty.handler.codec.serialization.CompactObjectOutputStream */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/CompactObjectOutputStream.class */
class CompactObjectOutputStream extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    /* access modifiers changed from: package-private */
    public CompactObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeStreamHeader() throws IOException {
        writeByte(5);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeClassDescriptor(ObjectStreamClass desc) throws IOException {
        Class<?> clazz = desc.forClass();
        if (clazz.isPrimitive() || clazz.isArray() || clazz.isInterface() || desc.getSerialVersionUID() == 0) {
            write(0);
            writeClassDescriptor(desc);
            return;
        }
        write(1);
        writeUTF(desc.getName());
    }
}
