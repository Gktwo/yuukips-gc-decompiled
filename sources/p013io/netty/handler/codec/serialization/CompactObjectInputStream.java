package p013io.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* renamed from: io.netty.handler.codec.serialization.CompactObjectInputStream */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/CompactObjectInputStream.class */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    /* access modifiers changed from: package-private */
    public CompactObjectInputStream(InputStream in, ClassResolver classResolver) throws IOException {
        super(in);
        this.classResolver = classResolver;
    }

    @Override // java.io.ObjectInputStream
    protected void readStreamHeader() throws IOException {
        int version = readByte() & 255;
        if (version != 5) {
            throw new StreamCorruptedException("Unsupported version: " + version);
        }
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        int type = read();
        if (type < 0) {
            throw new EOFException();
        }
        switch (type) {
            case 0:
                return readClassDescriptor();
            case 1:
                return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
            default:
                throw new StreamCorruptedException("Unexpected class descriptor type: " + type);
        }
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        Class<?> clazz;
        try {
            clazz = this.classResolver.resolve(desc.getName());
        } catch (ClassNotFoundException e) {
            clazz = resolveClass(desc);
        }
        return clazz;
    }
}
