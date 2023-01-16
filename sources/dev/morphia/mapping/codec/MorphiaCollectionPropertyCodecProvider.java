package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.pojo.TypeData;
import java.util.Collection;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaCollectionPropertyCodecProvider.class */
public class MorphiaCollectionPropertyCodecProvider extends MorphiaPropertyCodecProvider {
    @Override // org.bson.codecs.pojo.PropertyCodecProvider
    @Nullable
    public <T> Codec<T> get(TypeWithTypeParameters<T> type, PropertyCodecRegistry registry) {
        if (!Collection.class.isAssignableFrom(type.getType())) {
            return null;
        }
        TypeWithTypeParameters<?> valueType = getType(type.getTypeParameters(), 0);
        try {
            return new MorphiaCollectionCodec(registry.get(valueType), type.getType());
        } catch (CodecConfigurationException e) {
            if (valueType.getType().equals(Object.class)) {
                try {
                    return registry.get(TypeData.builder(Collection.class).build());
                } catch (CodecConfigurationException e2) {
                    throw e;
                }
            }
            throw e;
        }
    }
}
