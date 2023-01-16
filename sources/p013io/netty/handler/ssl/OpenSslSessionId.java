package p013io.netty.handler.ssl;

import java.util.Arrays;
import p013io.netty.util.internal.EmptyArrays;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.OpenSslSessionId */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslSessionId.class */
public final class OpenSslSessionId {

    /* renamed from: id */
    private final byte[] f1018id;
    private final int hashCode;
    static final OpenSslSessionId NULL_ID = new OpenSslSessionId(EmptyArrays.EMPTY_BYTES);

    /* access modifiers changed from: package-private */
    public OpenSslSessionId(byte[] id) {
        this.f1018id = id;
        this.hashCode = Arrays.hashCode(id);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OpenSslSessionId)) {
            return false;
        }
        return Arrays.equals(this.f1018id, ((OpenSslSessionId) o).f1018id);
    }

    public String toString() {
        return "OpenSslSessionId{id=" + Arrays.toString(this.f1018id) + '}';
    }

    public int hashCode() {
        return this.hashCode;
    }

    /* access modifiers changed from: package-private */
    public byte[] cloneBytes() {
        return (byte[]) this.f1018id.clone();
    }
}
