package p013io.netty.channel.unix;

import java.io.File;
import java.net.SocketAddress;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.unix.DomainSocketAddress */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainSocketAddress.class */
public class DomainSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -6934618000832236893L;
    private final String socketPath;

    public DomainSocketAddress(String socketPath) {
        this.socketPath = (String) ObjectUtil.checkNotNull(socketPath, "socketPath");
    }

    public DomainSocketAddress(File file) {
        this(file.getPath());
    }

    public String path() {
        return this.socketPath;
    }

    @Override // java.lang.Object
    public String toString() {
        return path();
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DomainSocketAddress)) {
            return false;
        }
        return ((DomainSocketAddress) o).socketPath.equals(this.socketPath);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.socketPath.hashCode();
    }
}
