package p013io.netty.channel.socket.nio;

import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;
import p013io.netty.channel.socket.InternetProtocolFamily;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.socket.nio.ProtocolFamilyConverter */
/* loaded from: grasscutter.jar:io/netty/channel/socket/nio/ProtocolFamilyConverter.class */
public final class ProtocolFamilyConverter {
    private ProtocolFamilyConverter() {
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ProtocolFamily convert(InternetProtocolFamily family) {
        switch (family) {
            case IPv4:
                return StandardProtocolFamily.INET;
            case IPv6:
                return StandardProtocolFamily.INET6;
            default:
                throw new IllegalArgumentException();
        }
    }
}
