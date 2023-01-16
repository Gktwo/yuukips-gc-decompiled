package org.bson.codecs.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.codecs.pojo.TypeData;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PojoSpecializationHelper.class */
public final class PojoSpecializationHelper {
    /* access modifiers changed from: package-private */
    public static <V> TypeData<V> specializeTypeData(TypeData<V> typeData, List<TypeData<?>> typeParameters, TypeParameterMap typeParameterMap) {
        if (!typeParameterMap.hasTypeParameters() || typeParameters.isEmpty()) {
            return typeData;
        }
        Map<Integer, Either<Integer, TypeParameterMap>> propertyToClassParamIndexMap = typeParameterMap.getPropertyToClassParamIndexMap();
        Either<Integer, TypeParameterMap> classTypeParamRepresentsWholeField = propertyToClassParamIndexMap.get(-1);
        if (classTypeParamRepresentsWholeField != null) {
            return (TypeData<V>) typeParameters.get(((Integer) classTypeParamRepresentsWholeField.map(i -> {
                return i;
            }, e -> {
                throw new IllegalStateException("Invalid state, the whole class cannot be represented by a subtype.");
            })).intValue());
        }
        return getTypeData(typeData, typeParameters, propertyToClassParamIndexMap);
    }

    private static <V> TypeData<V> getTypeData(TypeData<V> typeData, List<TypeData<?>> specializedTypeParameters, Map<Integer, Either<Integer, TypeParameterMap>> propertyToClassParamIndexMap) {
        List<TypeData<?>> subTypeParameters = new ArrayList<>(typeData.getTypeParameters());
        for (int i = 0; i < typeData.getTypeParameters().size(); i++) {
            subTypeParameters.set(i, getTypeData(subTypeParameters.get(i), specializedTypeParameters, propertyToClassParamIndexMap, i));
        }
        return TypeData.builder(typeData.getType()).addTypeParameters(subTypeParameters).build();
    }

    private static TypeData<?> getTypeData(TypeData<?> typeData, List<TypeData<?>> specializedTypeParameters, Map<Integer, Either<Integer, TypeParameterMap>> propertyToClassParamIndexMap, int index) {
        if (!propertyToClassParamIndexMap.containsKey(Integer.valueOf(index))) {
            return typeData;
        }
        return (TypeData) propertyToClassParamIndexMap.get(Integer.valueOf(index)).map(l -> {
            if (typeData.getTypeParameters().isEmpty()) {
                return (TypeData) specializedTypeParameters.get(l.intValue());
            }
            TypeData.Builder<?> builder = TypeData.builder(typeData.getType());
            List<TypeData<?>> typeParameters = new ArrayList<>(typeData.getTypeParameters());
            typeParameters.set(index, (TypeData) specializedTypeParameters.get(l.intValue()));
            builder.addTypeParameters(typeParameters);
            return builder.build();
        }, r -> {
            return getTypeData(typeData, specializedTypeParameters, r.getPropertyToClassParamIndexMap());
        });
    }

    private PojoSpecializationHelper() {
    }
}
