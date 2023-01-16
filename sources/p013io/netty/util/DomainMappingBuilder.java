package p013io.netty.util;

@Deprecated
/* renamed from: io.netty.util.DomainMappingBuilder */
/* loaded from: grasscutter.jar:io/netty/util/DomainMappingBuilder.class */
public final class DomainMappingBuilder<V> {
    private final DomainNameMappingBuilder<V> builder;

    public DomainMappingBuilder(V defaultValue) {
        this.builder = new DomainNameMappingBuilder<>(defaultValue);
    }

    public DomainMappingBuilder(int initialCapacity, V defaultValue) {
        this.builder = new DomainNameMappingBuilder<>(initialCapacity, defaultValue);
    }

    public DomainMappingBuilder<V> add(String hostname, V output) {
        this.builder.add(hostname, output);
        return this;
    }

    public DomainNameMapping<V> build() {
        return this.builder.build();
    }
}
