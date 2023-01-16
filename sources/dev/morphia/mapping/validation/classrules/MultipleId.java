package dev.morphia.mapping.validation.classrules;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.validation.ClassConstraint;
import dev.morphia.mapping.validation.ConstraintViolation;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/classrules/MultipleId.class */
public class MultipleId implements ClassConstraint {
    @Override // dev.morphia.mapping.validation.ClassConstraint
    public void check(Mapper mapper, EntityModel entityModel, Set<ConstraintViolation> ve) {
        List<PropertyModel> properties = entityModel.getProperties(AbstractC1283Id.class);
        if (properties.size() > 1) {
            ve.add(new ConstraintViolation(ConstraintViolation.Level.FATAL, entityModel, getClass(), Sofia.multipleIdPropertiesFound(new FieldEnumString(properties), new Locale[0])));
        }
    }
}
