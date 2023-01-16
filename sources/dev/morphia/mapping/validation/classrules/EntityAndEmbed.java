package dev.morphia.mapping.validation.classrules;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.validation.ClassConstraint;
import dev.morphia.mapping.validation.ConstraintViolation;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/classrules/EntityAndEmbed.class */
public class EntityAndEmbed implements ClassConstraint {
    @Override // dev.morphia.mapping.validation.ClassConstraint
    public void check(Mapper mapper, EntityModel entityModel, Set<ConstraintViolation> ve) {
        if (entityModel.getEntityAnnotation() != null && entityModel.getEmbeddedAnnotation() != null) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, getClass(), String.format("Cannot have both @%s and @%s annotation at class level.", Entity.class.getSimpleName(), Embedded.class.getSimpleName())));
        }
    }
}
