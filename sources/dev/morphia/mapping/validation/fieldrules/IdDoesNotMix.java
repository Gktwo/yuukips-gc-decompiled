package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import dev.morphia.sofia.Sofia;
import java.util.Locale;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/IdDoesNotMix.class */
public class IdDoesNotMix extends PropertyConstraint {
    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected void check(Mapper mapper, EntityModel entityModel, PropertyModel propertyModel, Set<ConstraintViolation> ve) {
        if (!propertyModel.hasAnnotation(AbstractC1283Id.class)) {
            return;
        }
        if (propertyModel.hasAnnotation(Reference.class) || propertyModel.hasAnnotation(Embedded.class) || propertyModel.hasAnnotation(Property.class)) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, propertyModel, getClass(), Sofia.invalidAnnotationCombination(propertyModel.getFullName(), AbstractC1283Id.class.getSimpleName(), new Locale[0])));
        }
    }
}
