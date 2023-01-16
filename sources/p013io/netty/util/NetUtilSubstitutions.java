package p013io.netty.util;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.InjectAccessors;
import com.oracle.svm.core.annotate.TargetClass;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

@TargetClass(NetUtil.class)
/* renamed from: io.netty.util.NetUtilSubstitutions */
/* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions.class */
final class NetUtilSubstitutions {
    @Alias
    @InjectAccessors(NetUtilLocalhost4Accessor.class)
    public static Inet4Address LOCALHOST4;
    @Alias
    @InjectAccessors(NetUtilLocalhost6Accessor.class)
    public static Inet6Address LOCALHOST6;
    @Alias
    @InjectAccessors(NetUtilLocalhostAccessor.class)
    public static InetAddress LOCALHOST;

    private NetUtilSubstitutions() {
    }

    /* renamed from: io.netty.util.NetUtilSubstitutions$NetUtilLocalhost4Accessor */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions$NetUtilLocalhost4Accessor.class */
    private static final class NetUtilLocalhost4Accessor {
        private NetUtilLocalhost4Accessor() {
        }

        static Inet4Address get() {
            return NetUtilLocalhost4LazyHolder.LOCALHOST4;
        }

        static void set(Inet4Address ignored) {
        }
    }

    /* renamed from: io.netty.util.NetUtilSubstitutions$NetUtilLocalhost4LazyHolder */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions$NetUtilLocalhost4LazyHolder.class */
    private static final class NetUtilLocalhost4LazyHolder {
        private static final Inet4Address LOCALHOST4 = NetUtilInitializations.createLocalhost4();

        private NetUtilLocalhost4LazyHolder() {
        }
    }

    /* renamed from: io.netty.util.NetUtilSubstitutions$NetUtilLocalhost6Accessor */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions$NetUtilLocalhost6Accessor.class */
    private static final class NetUtilLocalhost6Accessor {
        private NetUtilLocalhost6Accessor() {
        }

        static Inet6Address get() {
            return NetUtilLocalhost6LazyHolder.LOCALHOST6;
        }

        static void set(Inet6Address ignored) {
        }
    }

    /* renamed from: io.netty.util.NetUtilSubstitutions$NetUtilLocalhost6LazyHolder */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions$NetUtilLocalhost6LazyHolder.class */
    private static final class NetUtilLocalhost6LazyHolder {
        private static final Inet6Address LOCALHOST6 = NetUtilInitializations.createLocalhost6();

        private NetUtilLocalhost6LazyHolder() {
        }
    }

    /* renamed from: io.netty.util.NetUtilSubstitutions$NetUtilLocalhostAccessor */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions$NetUtilLocalhostAccessor.class */
    private static final class NetUtilLocalhostAccessor {
        private NetUtilLocalhostAccessor() {
        }

        static InetAddress get() {
            return NetUtilLocalhostLazyHolder.LOCALHOST;
        }

        static void set(InetAddress ignored) {
        }
    }

    /* renamed from: io.netty.util.NetUtilSubstitutions$NetUtilLocalhostLazyHolder */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtilSubstitutions$NetUtilLocalhostLazyHolder.class */
    private static final class NetUtilLocalhostLazyHolder {
        private static final InetAddress LOCALHOST = NetUtilInitializations.determineLoopback(NetUtilLocalhost4LazyHolder.LOCALHOST4, NetUtilLocalhost6LazyHolder.LOCALHOST6).address();

        private NetUtilLocalhostLazyHolder() {
        }
    }
}
