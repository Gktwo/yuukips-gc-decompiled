package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ClassConstraint;
import dev.morphia.mapping.validation.ConstraintViolation;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/PropertyConstraint.class */
public abstract class PropertyConstraint implements ClassConstraint {
    protected abstract void check(Mapper mapper, EntityModel entityModel, PropertyModel propertyModel, Set<ConstraintViolation> set);

    @Override // dev.morphia.mapping.validation.ClassConstraint
    public final void check(Mapper mapper, EntityModel entityModel, Set<ConstraintViolation> ve) {
        for (PropertyModel model : entityModel.getProperties()) {
            check(mapper, entityModel, model, ve);
        }
    }
}
