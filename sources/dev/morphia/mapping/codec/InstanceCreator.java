package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.pojo.PropertyModel;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/InstanceCreator.class */
public interface InstanceCreator {
    Object getInstance();

    void set(@Nullable Object obj, PropertyModel propertyModel);
}
