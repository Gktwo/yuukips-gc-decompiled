package dev.morphia.mapping.conventions;

import dev.morphia.Datastore;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;

/* loaded from: grasscutter.jar:dev/morphia/mapping/conventions/MorphiaConvention.class */
public interface MorphiaConvention {
    void apply(Datastore datastore, EntityModelBuilder entityModelBuilder);
}
