package p013io.netty.handler.codec;

import p013io.netty.handler.codec.DefaultHeaders;
import p013io.netty.util.HashingStrategy;

/* renamed from: io.netty.handler.codec.DefaultHeadersImpl */
/* loaded from: grasscutter.jar:io/netty/handler/codec/DefaultHeadersImpl.class */
public final class DefaultHeadersImpl<K, V> extends DefaultHeaders<K, V, DefaultHeadersImpl<K, V>> {
    public DefaultHeadersImpl(HashingStrategy<K> nameHashingStrategy, ValueConverter<V> valueConverter, DefaultHeaders.NameValidator<K> nameValidator) {
        super(nameHashingStrategy, valueConverter, nameValidator);
    }
}
