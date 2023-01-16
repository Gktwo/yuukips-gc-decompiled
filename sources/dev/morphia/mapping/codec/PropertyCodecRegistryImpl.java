package dev.morphia.mapping.codec;

import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/PropertyCodecRegistryImpl.class */
public class PropertyCodecRegistryImpl implements PropertyCodecRegistry {
    private final List<PropertyCodecProvider> propertyCodecProviders;

    public PropertyCodecRegistryImpl(Codec<?> pojoCodec, CodecRegistry codecRegistry, List<PropertyCodecProvider> propertyCodecProviders) {
        List<PropertyCodecProvider> augmentedProviders = new ArrayList<>();
        augmentedProviders.addAll(propertyCodecProviders);
        augmentedProviders.add(new CollectionPropertyCodecProvider());
        augmentedProviders.add(new MorphiaCollectionPropertyCodecProvider());
        augmentedProviders.add(new EnumPropertyCodecProvider(codecRegistry));
        augmentedProviders.add(new FallbackPropertyCodecProvider(pojoCodec, codecRegistry));
        this.propertyCodecProviders = augmentedProviders;
    }

    @Override // org.bson.codecs.pojo.PropertyCodecRegistry
    public <S> Codec<S> get(TypeWithTypeParameters<S> type) {
        for (PropertyCodecProvider propertyCodecProvider : this.propertyCodecProviders) {
            Codec<S> codec = propertyCodecProvider.get(type, this);
            if (codec != null) {
                return codec;
            }
        }
        return null;
    }

    /* loaded from: grasscutter.jar:dev/morphia/mapping/codec/PropertyCodecRegistryImpl$FallbackPropertyCodecProvider.class */
    private static final class FallbackPropertyCodecProvider implements PropertyCodecProvider {
        private final CodecRegistry codecRegistry;
        private final Codec<?> codec;

        FallbackPropertyCodecProvider(Codec<?> codec, CodecRegistry codecRegistry) {
            this.codec = codec;
            this.codecRegistry = codecRegistry;
        }

        @Override // org.bson.codecs.pojo.PropertyCodecProvider
        public <S> Codec<S> get(TypeWithTypeParameters<S> type, PropertyCodecRegistry propertyCodecRegistry) {
            if (type.getType() == this.codec.getEncoderClass()) {
                return (Codec<S>) this.codec;
            }
            return this.codecRegistry.get(type.getType());
        }
    }
}
