package dev.morphia.mapping.codec;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/EnumPropertyCodecProvider.class */
final class EnumPropertyCodecProvider implements PropertyCodecProvider {
    private final CodecRegistry codecRegistry;

    /* access modifiers changed from: package-private */
    public EnumPropertyCodecProvider(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @Override // org.bson.codecs.pojo.PropertyCodecProvider
    public <T> Codec<T> get(TypeWithTypeParameters<T> type, PropertyCodecRegistry propertyCodecRegistry) {
        Class<T> clazz = type.getType();
        if (!Enum.class.isAssignableFrom(clazz)) {
            return null;
        }
        try {
            return this.codecRegistry.get(clazz);
        } catch (CodecConfigurationException e) {
            return new EnumCodec(clazz);
        }
    }
}
