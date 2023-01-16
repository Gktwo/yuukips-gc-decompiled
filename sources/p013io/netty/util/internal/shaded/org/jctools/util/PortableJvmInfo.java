package p013io.netty.util.internal.shaded.org.jctools.util;

/* renamed from: io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/util/PortableJvmInfo.class */
public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int CPUs = Runtime.getRuntime().availableProcessors();
    public static final int RECOMENDED_OFFER_BATCH = CPUs * 4;
    public static final int RECOMENDED_POLL_BATCH = CPUs * 4;
}
