package dev.morphia.mapping.validation.classrules;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.validation.ClassConstraint;
import dev.morphia.mapping.validation.ConstraintViolation;
import dev.morphia.sofia.Sofia;
import java.util.Locale;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/classrules/EntityOrEmbed.class */
public class EntityOrEmbed implements ClassConstraint {
    @Override // dev.morphia.mapping.validation.ClassConstraint
    public void check(Mapper mapper, EntityModel entityModel, Set<ConstraintViolation> ve) {
        if (entityModel.getEntityAnnotation() == null && entityModel.getEmbeddedAnnotation() == null) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, getClass(), Sofia.entityOrEmbedded(entityModel.getType().getName(), new Locale[0])));
        }
    }
}
