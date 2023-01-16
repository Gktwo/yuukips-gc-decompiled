package p013io.netty.resolver;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.resolver.HostsFileEntriesProvider;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.resolver.DefaultHostsFileEntriesResolver */
/* loaded from: grasscutter.jar:io/netty/resolver/DefaultHostsFileEntriesResolver.class */
public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHostsFileEntriesResolver.class);
    private static final long DEFAULT_REFRESH_INTERVAL = SystemPropertyUtil.getLong("io.netty.hostsFileRefreshInterval", 0);
    private final long refreshInterval;
    private final AtomicLong lastRefresh;
    private final HostsFileEntriesProvider.Parser hostsFileParser;
    private volatile Map<String, List<InetAddress>> inet4Entries;
    private volatile Map<String, List<InetAddress>> inet6Entries;

    static {
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.hostsFileRefreshInterval: {}", Long.valueOf(DEFAULT_REFRESH_INTERVAL));
        }
    }

    public DefaultHostsFileEntriesResolver() {
        this(HostsFileEntriesProvider.parser(), DEFAULT_REFRESH_INTERVAL);
    }

    DefaultHostsFileEntriesResolver(HostsFileEntriesProvider.Parser hostsFileParser, long refreshInterval) {
        this.lastRefresh = new AtomicLong(System.nanoTime());
        this.hostsFileParser = hostsFileParser;
        this.refreshInterval = ObjectUtil.checkPositiveOrZero(refreshInterval, "refreshInterval");
        HostsFileEntriesProvider entries = parseEntries(hostsFileParser);
        this.inet4Entries = entries.ipv4Entries();
        this.inet6Entries = entries.ipv6Entries();
    }

    @Override // p013io.netty.resolver.HostsFileEntriesResolver
    public InetAddress address(String inetHost, ResolvedAddressTypes resolvedAddressTypes) {
        return firstAddress(addresses(inetHost, resolvedAddressTypes));
    }

    public List<InetAddress> addresses(String inetHost, ResolvedAddressTypes resolvedAddressTypes) {
        String normalized = normalize(inetHost);
        ensureHostsFileEntriesAreFresh();
        switch (resolvedAddressTypes) {
            case IPV4_ONLY:
                return this.inet4Entries.get(normalized);
            case IPV6_ONLY:
                return this.inet6Entries.get(normalized);
            case IPV4_PREFERRED:
                List<InetAddress> allInet4Addresses = this.inet4Entries.get(normalized);
                return allInet4Addresses != null ? allAddresses(allInet4Addresses, this.inet6Entries.get(normalized)) : this.inet6Entries.get(normalized);
            case IPV6_PREFERRED:
                List<InetAddress> allInet6Addresses = this.inet6Entries.get(normalized);
                return allInet6Addresses != null ? allAddresses(allInet6Addresses, this.inet4Entries.get(normalized)) : this.inet4Entries.get(normalized);
            default:
                throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
    }

    private void ensureHostsFileEntriesAreFresh() {
        long interval = this.refreshInterval;
        if (interval != 0) {
            long last = this.lastRefresh.get();
            long currentTime = System.nanoTime();
            if (currentTime - last > interval && this.lastRefresh.compareAndSet(last, currentTime)) {
                HostsFileEntriesProvider entries = parseEntries(this.hostsFileParser);
                this.inet4Entries = entries.ipv4Entries();
                this.inet6Entries = entries.ipv6Entries();
            }
        }
    }

    String normalize(String inetHost) {
        return inetHost.toLowerCase(Locale.ENGLISH);
    }

    private static List<InetAddress> allAddresses(List<InetAddress> a, List<InetAddress> b) {
        List<InetAddress> result = new ArrayList<>(a.size() + (b == null ? 0 : b.size()));
        result.addAll(a);
        if (b != null) {
            result.addAll(b);
        }
        return result;
    }

    private static InetAddress firstAddress(List<InetAddress> addresses) {
        if (addresses == null || addresses.isEmpty()) {
            return null;
        }
        return addresses.get(0);
    }

    private static HostsFileEntriesProvider parseEntries(HostsFileEntriesProvider.Parser parser) {
        if (PlatformDependent.isWindows()) {
            return parser.parseSilently(Charset.defaultCharset(), CharsetUtil.UTF_16, CharsetUtil.UTF_8);
        }
        return parser.parseSilently();
    }
}
