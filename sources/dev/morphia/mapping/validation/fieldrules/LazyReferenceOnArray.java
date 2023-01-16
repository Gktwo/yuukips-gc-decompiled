package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.annotations.Reference;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/LazyReferenceOnArray.class */
public class LazyReferenceOnArray extends PropertyConstraint {
    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected void check(Mapper mapper, EntityModel model, PropertyModel propertyModel, Set<ConstraintViolation> ve) {
        Reference ref = (Reference) propertyModel.getAnnotation(Reference.class);
        if (ref != null && ref.lazy() && propertyModel.getType().isArray()) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, model, propertyModel, getClass(), "The lazy attribute cannot be used for an Array. If you need a lazy array please use ArrayList instead."));
        }
    }
}
