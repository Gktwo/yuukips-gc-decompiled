package dev.morphia.mapping;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;

/* loaded from: grasscutter.jar:dev/morphia/mapping/DiscriminatorFunction.class */
public abstract class DiscriminatorFunction {
    protected abstract String compute(EntityModelBuilder entityModelBuilder);

    public static DiscriminatorFunction className() {
        return new DiscriminatorFunction() { // from class: dev.morphia.mapping.DiscriminatorFunction.1
            @Override // dev.morphia.mapping.DiscriminatorFunction
            public String compute(EntityModelBuilder builder) {
                return builder.getType().getName();
            }
        };
    }

    public static DiscriminatorFunction lowerClassName() {
        return new DiscriminatorFunction() { // from class: dev.morphia.mapping.DiscriminatorFunction.2
            @Override // dev.morphia.mapping.DiscriminatorFunction
            public String compute(EntityModelBuilder builder) {
                return builder.getType().getName().toLowerCase();
            }
        };
    }

    public static DiscriminatorFunction lowerSimpleName() {
        return new DiscriminatorFunction() { // from class: dev.morphia.mapping.DiscriminatorFunction.3
            @Override // dev.morphia.mapping.DiscriminatorFunction
            public String compute(EntityModelBuilder builder) {
                return builder.getType().getSimpleName().toLowerCase();
            }
        };
    }

    public static DiscriminatorFunction simpleName() {
        return new DiscriminatorFunction() { // from class: dev.morphia.mapping.DiscriminatorFunction.4
            @Override // dev.morphia.mapping.DiscriminatorFunction
            public String compute(EntityModelBuilder builder) {
                return builder.getType().getSimpleName();
            }
        };
    }

    public final void apply(EntityModelBuilder builder) {
        String discriminator = Mapper.IGNORED_FIELDNAME;
        Entity entity = (Entity) builder.getAnnotation(Entity.class);
        if (entity != null) {
            discriminator = entity.discriminator();
        } else {
            Embedded embedded = (Embedded) builder.getAnnotation(Embedded.class);
            if (embedded != null) {
                discriminator = embedded.discriminator();
            }
        }
        if (discriminator.equals(Mapper.IGNORED_FIELDNAME)) {
            discriminator = compute(builder);
        }
        builder.discriminator(discriminator);
    }
}
