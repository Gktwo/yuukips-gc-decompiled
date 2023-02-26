package org.bson.codecs.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyCodecRegistryImpl.class */
class PropertyCodecRegistryImpl implements PropertyCodecRegistry {
    private final List<PropertyCodecProvider> propertyCodecProviders;
    private final ConcurrentHashMap<TypeWithTypeParameters<?>, Codec<?>> propertyCodecCache;

    /* access modifiers changed from: package-private */
    public PropertyCodecRegistryImpl(PojoCodec<?> pojoCodec, CodecRegistry codecRegistry, List<PropertyCodecProvider> propertyCodecProviders) {
        List<PropertyCodecProvider> augmentedProviders = new ArrayList<>();
        if (propertyCodecProviders != null) {
            augmentedProviders.addAll(propertyCodecProviders);
        }
        augmentedProviders.add(new CollectionPropertyCodecProvider());
        augmentedProviders.add(new MapPropertyCodecProvider());
        augmentedProviders.add(new EnumPropertyCodecProvider(codecRegistry));
        augmentedProviders.add(new FallbackPropertyCodecProvider(pojoCodec, codecRegistry));
        this.propertyCodecProviders = augmentedProviders;
        this.propertyCodecCache = new ConcurrentHashMap<>();
    }

    @Override // org.bson.codecs.pojo.PropertyCodecRegistry
    public <S> Codec<S> get(TypeWithTypeParameters<S> typeWithTypeParameters) {
        if (this.propertyCodecCache.containsKey(typeWithTypeParameters)) {
            return (Codec<S>) this.propertyCodecCache.get(typeWithTypeParameters);
        }
        for (PropertyCodecProvider propertyCodecProvider : this.propertyCodecProviders) {
            Codec<S> codec = propertyCodecProvider.get(typeWithTypeParameters, this);
            if (codec != null) {
                this.propertyCodecCache.put(typeWithTypeParameters, codec);
                return codec;
            }
        }
        return null;
    }
}
