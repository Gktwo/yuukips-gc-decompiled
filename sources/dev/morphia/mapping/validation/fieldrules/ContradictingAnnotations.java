package dev.morphia.mapping.validation.fieldrules;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import dev.morphia.sofia.Sofia;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/ContradictingAnnotations.class */
public class ContradictingAnnotations extends PropertyConstraint {

    /* renamed from: a1 */
    private final Class<? extends Annotation> f481a1;

    /* renamed from: a2 */
    private final Class<? extends Annotation> f482a2;

    public ContradictingAnnotations(Class<? extends Annotation> a1, Class<? extends Annotation> a2) {
        this.f481a1 = a1;
        this.f482a2 = a2;
    }

    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected final void check(Mapper mapper, EntityModel entityModel, PropertyModel propertyModel, Set<ConstraintViolation> ve) {
        if (propertyModel.hasAnnotation(this.f481a1) && propertyModel.hasAnnotation(this.f482a2)) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, propertyModel, getClass(), Sofia.contradictingAnnotations(this.f481a1.getSimpleName(), this.f482a2.getSimpleName(), new Locale[0])));
        }
    }
}
