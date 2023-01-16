package p013io.netty.util;

import java.util.LinkedHashMap;
import java.util.Map;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.util.DomainWildcardMappingBuilder */
/* loaded from: grasscutter.jar:io/netty/util/DomainWildcardMappingBuilder.class */
public class DomainWildcardMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    public DomainWildcardMappingBuilder(V defaultValue) {
        this(4, defaultValue);
    }

    public DomainWildcardMappingBuilder(int initialCapacity, V defaultValue) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(defaultValue, "defaultValue");
        this.map = new LinkedHashMap(initialCapacity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Map<java.lang.String, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public DomainWildcardMappingBuilder<V> add(String hostname, V output) {
        this.map.put(normalizeHostName(hostname), ObjectUtil.checkNotNull(output, "output"));
        return this;
    }

    private String normalizeHostName(String hostname) {
        ObjectUtil.checkNotNull(hostname, "hostname");
        if (hostname.isEmpty() || hostname.charAt(0) == '.') {
            throw new IllegalArgumentException("Hostname '" + hostname + "' not valid");
        }
        String hostname2 = ImmutableDomainWildcardMapping.normalize((String) ObjectUtil.checkNotNull(hostname, "hostname"));
        if (hostname2.charAt(0) != '*') {
            return hostname2;
        }
        if (hostname2.length() >= 3 && hostname2.charAt(1) == '.') {
            return hostname2.substring(1);
        }
        throw new IllegalArgumentException("Wildcard Hostname '" + hostname2 + "'not valid");
    }

    public Mapping<String, V> build() {
        return new ImmutableDomainWildcardMapping(this.defaultValue, this.map);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.DomainWildcardMappingBuilder$ImmutableDomainWildcardMapping */
    /* loaded from: grasscutter.jar:io/netty/util/DomainWildcardMappingBuilder$ImmutableDomainWildcardMapping.class */
    public static final class ImmutableDomainWildcardMapping<V> implements Mapping<String, V> {
        private static final String REPR_HEADER = "ImmutableDomainWildcardMapping(default: ";
        private static final String REPR_MAP_OPENING = ", map: ";
        private static final String REPR_MAP_CLOSING = ")";
        private final V defaultValue;
        private final Map<String, V> map;

        ImmutableDomainWildcardMapping(V defaultValue, Map<String, V> map) {
            this.defaultValue = defaultValue;
            this.map = new LinkedHashMap(map);
        }

        public V map(String hostname) {
            V value;
            if (hostname != null) {
                String hostname2 = normalize(hostname);
                V value2 = this.map.get(hostname2);
                if (value2 != null) {
                    return value2;
                }
                int idx = hostname2.indexOf(46);
                if (!(idx == -1 || (value = this.map.get(hostname2.substring(idx))) == null)) {
                    return value;
                }
            }
            return this.defaultValue;
        }

        static String normalize(String hostname) {
            return DomainNameMapping.normalizeHostname(hostname);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(REPR_HEADER).append(this.defaultValue).append(REPR_MAP_OPENING).append('{');
            for (Map.Entry<String, V> entry : this.map.entrySet()) {
                String hostname = entry.getKey();
                if (hostname.charAt(0) == '.') {
                    hostname = '*' + hostname;
                }
                sb.append(hostname).append('=').append(entry.getValue()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            return sb.append('}').append(REPR_MAP_CLOSING).toString();
        }
    }
}
