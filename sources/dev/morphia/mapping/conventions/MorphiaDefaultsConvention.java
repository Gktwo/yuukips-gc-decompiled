package dev.morphia.mapping.conventions;

import dev.morphia.Datastore;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MapperOptions;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;

/* loaded from: grasscutter.jar:dev/morphia/mapping/conventions/MorphiaDefaultsConvention.class */
public class MorphiaDefaultsConvention implements MorphiaConvention {
    @Override // dev.morphia.mapping.conventions.MorphiaConvention
    public void apply(Datastore datastore, EntityModelBuilder modelBuilder) {
        MapperOptions options = datastore.getMapper().getOptions();
        Entity entity = (Entity) modelBuilder.getAnnotation(Entity.class);
        Embedded embedded = (Embedded) modelBuilder.getAnnotation(Embedded.class);
        if (entity != null) {
            modelBuilder.enableDiscriminator(entity.useDiscriminator());
            modelBuilder.discriminatorKey(applyDefaults(entity.discriminatorKey(), options.getDiscriminatorKey()));
        } else {
            modelBuilder.enableDiscriminator(embedded == null || embedded.useDiscriminator());
            modelBuilder.discriminatorKey(applyDefaults(embedded != null ? embedded.discriminatorKey() : Mapper.IGNORED_FIELDNAME, options.getDiscriminatorKey()));
        }
        options.getDiscriminator().apply(modelBuilder);
    }

    String applyDefaults(String configured, String defaultValue) {
        if (!configured.equals(Mapper.IGNORED_FIELDNAME)) {
            return configured;
        }
        return defaultValue;
    }
}
