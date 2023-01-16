package dev.morphia.mapping.conventions;

import com.mongodb.DBCollection;
import dev.morphia.Datastore;
import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.AlsoLoad;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Transient;
import dev.morphia.annotations.Version;
import dev.morphia.annotations.experimental.IdField;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MapperOptions;
import dev.morphia.mapping.codec.MorphiaPropertySerialization;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;
import dev.morphia.mapping.codec.pojo.PropertyModelBuilder;
import dev.morphia.mapping.codec.pojo.TypeData;
import java.lang.reflect.Modifier;
import java.util.Iterator;

/* loaded from: grasscutter.jar:dev/morphia/mapping/conventions/ConfigureProperties.class */
public class ConfigureProperties implements MorphiaConvention {
    private static boolean isTransient(PropertyModelBuilder property) {
        return property.hasAnnotation(Transient.class) || property.hasAnnotation(java.beans.Transient.class) || Modifier.isTransient(property.modifiers());
    }

    @Override // dev.morphia.mapping.conventions.MorphiaConvention
    public void apply(Datastore datastore, EntityModelBuilder modelBuilder) {
        IdField idProperty;
        processProperties(modelBuilder, datastore.getMapper().getOptions());
        if (modelBuilder.idPropertyName() == null && (idProperty = (IdField) modelBuilder.getAnnotation(IdField.class)) != null) {
            modelBuilder.idPropertyName(idProperty.value());
            modelBuilder.propertyModelByName(idProperty.value()).mappedName(DBCollection.ID_FIELD_NAME);
        }
    }

    private void buildProperty(MapperOptions options, PropertyModelBuilder builder) {
        builder.serialization(new MorphiaPropertySerialization(options, builder));
        if (isNotConcrete(builder.typeData())) {
            builder.discriminatorEnabled(true);
        }
    }

    void processProperties(EntityModelBuilder modelBuilder, MapperOptions options) {
        Iterator<PropertyModelBuilder> iterator = modelBuilder.propertyModels().iterator();
        while (iterator.hasNext()) {
            PropertyModelBuilder builder = iterator.next();
            if (Modifier.isStatic(builder.modifiers()) || isTransient(builder)) {
                iterator.remove();
            } else {
                Property property = (Property) builder.getAnnotation(Property.class);
                if (property != null && !property.concreteClass().equals(Object.class)) {
                    builder.typeData(builder.typeData().withType(property.concreteClass()));
                }
                AlsoLoad alsoLoad = (AlsoLoad) builder.getAnnotation(AlsoLoad.class);
                if (alsoLoad != null) {
                    for (String name : alsoLoad.value()) {
                        builder.alternateName(name);
                    }
                }
                if (builder.getAnnotation(AbstractC1283Id.class) != null) {
                    modelBuilder.idPropertyName(builder.name());
                }
                if (builder.getAnnotation(Version.class) != null) {
                    modelBuilder.versionPropertyName(builder.name());
                }
                buildProperty(options, builder);
            }
        }
    }

    private boolean isNotConcrete(TypeData<?> typeData) {
        Class<?> type;
        if (!typeData.getTypeParameters().isEmpty()) {
            type = typeData.getTypeParameters().get(typeData.getTypeParameters().size() - 1).getType();
        } else {
            type = typeData.getType();
        }
        return isNotConcrete(type);
    }

    private boolean isNotConcrete(Class<?> type) {
        Class<?> componentType = type;
        if (type.isArray()) {
            componentType = type.getComponentType();
        }
        return componentType.isInterface() || Modifier.isAbstract(componentType.getModifiers());
    }

    String applyDefaults(String configured, String defaultValue) {
        if (!configured.equals(Mapper.IGNORED_FIELDNAME)) {
            return configured;
        }
        return defaultValue;
    }
}
