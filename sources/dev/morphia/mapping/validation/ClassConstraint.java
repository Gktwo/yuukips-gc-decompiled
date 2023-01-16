package dev.morphia.mapping.validation;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/ClassConstraint.class */
public interface ClassConstraint {
    void check(Mapper mapper, EntityModel entityModel, Set<ConstraintViolation> set);
}
