package dev.morphia.mapping.codec;

import java.util.Collection;
import org.bson.codecs.Codec;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/CollectionPropertyCodecProvider.class */
final class CollectionPropertyCodecProvider implements PropertyCodecProvider {
    @Override // org.bson.codecs.pojo.PropertyCodecProvider
    public <T> Codec<T> get(TypeWithTypeParameters<T> type, PropertyCodecRegistry registry) {
        if (!Collection.class.isAssignableFrom(type.getType()) || type.getTypeParameters().size() != 1) {
            return null;
        }
        return new CollectionCodec(type.getType(), registry.get((TypeWithTypeParameters) type.getTypeParameters().get(0)));
    }
}
