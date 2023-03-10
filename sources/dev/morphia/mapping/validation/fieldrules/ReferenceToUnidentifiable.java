package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.Key;
import dev.morphia.annotations.Reference;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.NotMappableException;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import dev.morphia.sofia.Sofia;
import java.util.Locale;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/ReferenceToUnidentifiable.class */
public class ReferenceToUnidentifiable extends PropertyConstraint {
    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected void check(Mapper mapper, EntityModel entityModel, PropertyModel propertyModel, Set<ConstraintViolation> ve) {
        if (propertyModel.hasAnnotation(Reference.class)) {
            Class realType = propertyModel.getNormalizedType();
            if (realType.equals(Key.class)) {
                ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, propertyModel, getClass(), Sofia.keyNotAllowedAsProperty(new Locale[0])));
                return;
            }
            try {
                mapper.getEntityModel(realType);
            } catch (NotMappableException e) {
                ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, propertyModel, getClass(), Sofia.referredTypeMissingId(propertyModel.getFullName(), propertyModel.getType().getName(), new Locale[0])));
            }
        }
    }
}
