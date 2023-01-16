package p013io.netty.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p013io.netty.util.internal.ObjectUtil;

@Deprecated
/* renamed from: io.netty.util.DomainNameMappingBuilder */
/* loaded from: grasscutter.jar:io/netty/util/DomainNameMappingBuilder.class */
public final class DomainNameMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    public DomainNameMappingBuilder(V defaultValue) {
        this(4, defaultValue);
    }

    public DomainNameMappingBuilder(int initialCapacity, V defaultValue) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(defaultValue, "defaultValue");
        this.map = new LinkedHashMap(initialCapacity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Map<java.lang.String, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public DomainNameMappingBuilder<V> add(String hostname, V output) {
        this.map.put(ObjectUtil.checkNotNull(hostname, "hostname"), ObjectUtil.checkNotNull(output, "output"));
        return this;
    }

    public DomainNameMapping<V> build() {
        return new ImmutableDomainNameMapping(this.defaultValue, this.map);
    }

    /* renamed from: io.netty.util.DomainNameMappingBuilder$ImmutableDomainNameMapping */
    /* loaded from: grasscutter.jar:io/netty/util/DomainNameMappingBuilder$ImmutableDomainNameMapping.class */
    private static final class ImmutableDomainNameMapping<V> extends DomainNameMapping<V> {
        private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
        private static final String REPR_MAP_OPENING = ", map: {";
        private static final String REPR_MAP_CLOSING = "})";
        private static final int REPR_CONST_PART_LENGTH = (REPR_HEADER.length() + REPR_MAP_OPENING.length()) + REPR_MAP_CLOSING.length();
        private final String[] domainNamePatterns;
        private final V[] values;
        private final Map<String, V> map;

        private ImmutableDomainNameMapping(V defaultValue, Map<String, V> map) {
            super((Map) null, defaultValue);
            Set<Map.Entry<String, V>> mappings = map.entrySet();
            int numberOfMappings = mappings.size();
            this.domainNamePatterns = new String[numberOfMappings];
            this.values = (V[]) new Object[numberOfMappings];
            Map<String, V> mapCopy = new LinkedHashMap<>(map.size());
            int index = 0;
            for (Map.Entry<String, V> mapping : mappings) {
                String hostname = normalizeHostname(mapping.getKey());
                V value = mapping.getValue();
                this.domainNamePatterns[index] = hostname;
                this.values[index] = value;
                mapCopy.put(hostname, value);
                index++;
            }
            this.map = Collections.unmodifiableMap(mapCopy);
        }

        @Override // p013io.netty.util.DomainNameMapping
        @Deprecated
        public DomainNameMapping<V> add(String hostname, V output) {
            throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
        }

        @Override // p013io.netty.util.DomainNameMapping
        public V map(String hostname) {
            if (hostname != null) {
                String hostname2 = normalizeHostname(hostname);
                int length = this.domainNamePatterns.length;
                for (int index = 0; index < length; index++) {
                    if (matches(this.domainNamePatterns[index], hostname2)) {
                        return this.values[index];
                    }
                }
            }
            return (V) this.defaultValue;
        }

        @Override // p013io.netty.util.DomainNameMapping
        public Map<String, V> asMap() {
            return this.map;
        }

        @Override // p013io.netty.util.DomainNameMapping
        public String toString() {
            String defaultValueStr = this.defaultValue.toString();
            int numberOfMappings = this.domainNamePatterns.length;
            if (numberOfMappings == 0) {
                return REPR_HEADER + defaultValueStr + REPR_MAP_OPENING + REPR_MAP_CLOSING;
            }
            String pattern0 = this.domainNamePatterns[0];
            String value0 = this.values[0].toString();
            StringBuilder sb = new StringBuilder(estimateBufferSize(defaultValueStr.length(), numberOfMappings, pattern0.length() + value0.length() + 3)).append(REPR_HEADER).append(defaultValueStr).append(REPR_MAP_OPENING);
            appendMapping(sb, pattern0, value0);
            for (int index = 1; index < numberOfMappings; index++) {
                sb.append(", ");
                appendMapping(sb, index);
            }
            return sb.append(REPR_MAP_CLOSING).toString();
        }

        private static int estimateBufferSize(int defaultValueLength, int numberOfMappings, int estimatedMappingLength) {
            return REPR_CONST_PART_LENGTH + defaultValueLength + ((int) (((double) (estimatedMappingLength * numberOfMappings)) * 1.1d));
        }

        private StringBuilder appendMapping(StringBuilder sb, int mappingIndex) {
            return appendMapping(sb, this.domainNamePatterns[mappingIndex], this.values[mappingIndex].toString());
        }

        private static StringBuilder appendMapping(StringBuilder sb, String domainNamePattern, String value) {
            return sb.append(domainNamePattern).append('=').append(value);
        }
    }
}
