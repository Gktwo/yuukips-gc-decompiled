package p013io.netty.util;

import java.net.IDN;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

@Deprecated
/* renamed from: io.netty.util.DomainNameMapping */
/* loaded from: grasscutter.jar:io/netty/util/DomainNameMapping.class */
public class DomainNameMapping<V> implements Mapping<String, V> {
    final V defaultValue;
    private final Map<String, V> map;
    private final Map<String, V> unmodifiableMap;

    @Deprecated
    public DomainNameMapping(V defaultValue) {
        this(4, defaultValue);
    }

    @Deprecated
    public DomainNameMapping(int initialCapacity, V defaultValue) {
        this(new LinkedHashMap(initialCapacity), defaultValue);
    }

    /* access modifiers changed from: package-private */
    public DomainNameMapping(Map<String, V> map, V defaultValue) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(defaultValue, "defaultValue");
        this.map = map;
        this.unmodifiableMap = map != null ? Collections.unmodifiableMap(map) : null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Map<java.lang.String, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public DomainNameMapping<V> add(String hostname, V output) {
        this.map.put(normalizeHostname((String) ObjectUtil.checkNotNull(hostname, "hostname")), ObjectUtil.checkNotNull(output, "output"));
        return this;
    }

    static boolean matches(String template, String hostName) {
        if (template.startsWith("*.")) {
            return template.regionMatches(2, hostName, 0, hostName.length()) || StringUtil.commonSuffixOfLength(hostName, template, template.length() - 1);
        }
        return template.equals(hostName);
    }

    /* access modifiers changed from: package-private */
    public static String normalizeHostname(String hostname) {
        if (needsNormalization(hostname)) {
            hostname = IDN.toASCII(hostname, 1);
        }
        return hostname.toLowerCase(Locale.US);
    }

    private static boolean needsNormalization(String hostname) {
        int length = hostname.length();
        for (int i = 0; i < length; i++) {
            if (hostname.charAt(i) > 127) {
                return true;
            }
        }
        return false;
    }

    public V map(String hostname) {
        if (hostname != null) {
            String hostname2 = normalizeHostname(hostname);
            for (Map.Entry<String, V> entry : this.map.entrySet()) {
                if (matches(entry.getKey(), hostname2)) {
                    return entry.getValue();
                }
            }
        }
        return this.defaultValue;
    }

    public Map<String, V> asMap() {
        return this.unmodifiableMap;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(default: " + this.defaultValue + ", map: " + this.map + ')';
    }
}
