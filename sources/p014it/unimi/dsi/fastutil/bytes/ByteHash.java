package p014it.unimi.dsi.fastutil.bytes;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteHash.class */
public interface ByteHash {

    /* renamed from: it.unimi.dsi.fastutil.bytes.ByteHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteHash$Strategy.class */
    public interface Strategy {
        int hashCode(byte b);

        boolean equals(byte b, byte b2);
    }
}
