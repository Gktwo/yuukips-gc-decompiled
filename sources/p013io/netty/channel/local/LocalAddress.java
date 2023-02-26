package p013io.netty.channel.local;

import java.net.SocketAddress;
import p013io.netty.channel.Channel;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.local.LocalAddress */
/* loaded from: grasscutter.jar:io/netty/channel/local/LocalAddress.class */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    private static final long serialVersionUID = 4644331421130916435L;
    public static final LocalAddress ANY = new LocalAddress("ANY");

    /* renamed from: id */
    private final String f949id;
    private final String strVal;

    /* access modifiers changed from: package-private */
    public LocalAddress(Channel channel) {
        StringBuilder buf = new StringBuilder(16);
        buf.append("local:E");
        buf.append(Long.toHexString((((long) channel.hashCode()) & 4294967295L) | 4294967296L));
        buf.setCharAt(7, ':');
        this.f949id = buf.substring(6);
        this.strVal = buf.toString();
    }

    public LocalAddress(String id) {
        this.f949id = ObjectUtil.checkNonEmptyAfterTrim(id, "id").toLowerCase();
        this.strVal = "local:" + this.f949id;
    }

    /* renamed from: id */
    public String m1179id() {
        return this.f949id;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.f949id.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (!(o instanceof LocalAddress)) {
            return false;
        }
        return this.f949id.equals(((LocalAddress) o).f949id);
    }

    public int compareTo(LocalAddress o) {
        return this.f949id.compareTo(o.f949id);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.strVal;
    }
}
