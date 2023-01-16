package org.bson.codecs.pojo;

import com.mongodb.DBCollection;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/ConventionDefaultsImpl.class */
final class ConventionDefaultsImpl implements Convention {
    @Override // org.bson.codecs.pojo.Convention
    public void apply(ClassModelBuilder<?> classModelBuilder) {
        if (classModelBuilder.getDiscriminatorKey() == null) {
            classModelBuilder.discriminatorKey("_t");
        }
        if (classModelBuilder.getDiscriminator() == null && classModelBuilder.getType() != null) {
            classModelBuilder.discriminator(classModelBuilder.getType().getName());
        }
        for (PropertyModelBuilder<?> propertyModel : classModelBuilder.getPropertyModelBuilders()) {
            if (classModelBuilder.getIdPropertyName() == null) {
                String propertyName = propertyModel.getName();
                if (propertyName.equals(DBCollection.ID_FIELD_NAME) || propertyName.equals("id")) {
                    classModelBuilder.idPropertyName(propertyName);
                }
            }
        }
    }
}
