package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.annotations.Version;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/VersionMisuse.class */
public class VersionMisuse extends PropertyConstraint {
    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected void check(Mapper mapper, EntityModel entityModel, PropertyModel propertyModel, Set<ConstraintViolation> ve) {
        if (propertyModel.hasAnnotation(Version.class) && !entityModel.isAbstract()) {
            Class<?> type = propertyModel.getType();
            if (!Long.class.equals(type) && !Long.TYPE.equals(type)) {
                ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, propertyModel, getClass(), String.format("@%s can only be used on a Long/long field.", Version.class.getSimpleName())));
            }
        }
    }
}
