package dev.morphia.mapping.codec;

import dev.morphia.mapping.codec.pojo.TypeData;
import java.util.List;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaPropertyCodecProvider.class */
public abstract class MorphiaPropertyCodecProvider implements PropertyCodecProvider {
    protected TypeWithTypeParameters<?> getType(List<? extends TypeWithTypeParameters<?>> typeParameters, int position) {
        if (typeParameters.size() > position) {
            return (TypeWithTypeParameters) typeParameters.get(position);
        }
        return TypeData.builder(Object.class).build();
    }
}
