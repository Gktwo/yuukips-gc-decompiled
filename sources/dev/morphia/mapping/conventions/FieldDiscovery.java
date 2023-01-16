package dev.morphia.mapping.conventions;

import dev.morphia.Datastore;
import dev.morphia.mapping.codec.ArrayFieldAccessor;
import dev.morphia.mapping.codec.FieldAccessor;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;
import dev.morphia.mapping.codec.pojo.TypeData;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.pojo.PropertyAccessor;

/* loaded from: grasscutter.jar:dev/morphia/mapping/conventions/FieldDiscovery.class */
public class FieldDiscovery implements MorphiaConvention {
    @Override // dev.morphia.mapping.conventions.MorphiaConvention
    public void apply(Datastore datastore, EntityModelBuilder builder) {
        List<Class<?>> list = new ArrayList<>(List.of(builder.getType()));
        list.addAll(builder.classHierarchy());
        for (Class<?> type : list) {
            Field[] declaredFields = type.getDeclaredFields();
            for (Field field : declaredFields) {
                TypeData<?> typeData = builder.getTypeData(type, TypeData.newInstance(field), field.getGenericType());
                builder.addProperty().name(field.getName()).typeData(typeData).annotations(List.of((Object[]) field.getDeclaredAnnotations())).accessor(getAccessor(field, typeData)).modifiers(field.getModifiers()).discoverMappedName(datastore.getMapper().getOptions());
            }
        }
    }

    private PropertyAccessor<? super Object> getAccessor(Field field, TypeData<?> typeData) {
        if (!field.getType().isArray() || field.getType().getComponentType().equals(Byte.TYPE)) {
            return new FieldAccessor(field);
        }
        return new ArrayFieldAccessor(typeData, field);
    }
}
