package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.annotations.Reference;
import dev.morphia.internal.MorphiaInternals;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/LazyReferenceMissingDependencies.class */
public class LazyReferenceMissingDependencies extends PropertyConstraint {
    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected void check(Mapper mapper, EntityModel entityModel, PropertyModel propertyModel, Set<ConstraintViolation> ve) {
        Reference ref = (Reference) propertyModel.getAnnotation(Reference.class);
        if (ref != null && ref.lazy() && !MorphiaInternals.proxyClassesPresent()) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.SEVERE, entityModel, propertyModel, getClass(), "Lazy references need ByteBuddy on the classpath."));
        }
    }
}
