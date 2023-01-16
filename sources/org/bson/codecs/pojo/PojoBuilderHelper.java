package org.bson.codecs.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.bson.assertions.Assertions;
import org.bson.codecs.pojo.PropertyReflectionUtils;
import org.bson.codecs.pojo.TypeParameterMap;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PojoBuilderHelper.class */
public final class PojoBuilderHelper {
    /* access modifiers changed from: package-private */
    public static <T> void configureClassModelBuilder(ClassModelBuilder<T> classModelBuilder, Class<T> clazz) {
        classModelBuilder.type((Class) Assertions.notNull("clazz", clazz));
        ArrayList<Annotation> annotations = new ArrayList<>();
        Set<String> propertyNames = new TreeSet<>();
        Map<String, TypeParameterMap> propertyTypeParameterMap = new HashMap<>();
        Class<T> cls = clazz;
        String declaringClassName = clazz.getSimpleName();
        TypeData<?> parentClassTypeData = null;
        Map<String, PropertyMetadata<?>> propertyNameMap = new HashMap<>();
        while (!cls.isEnum() && cls.getSuperclass() != null) {
            annotations.addAll(Arrays.asList(cls.getDeclaredAnnotations()));
            List<String> genericTypeNames = new ArrayList<>();
            for (TypeVariable<? extends Class<? super T>> classTypeVariable : cls.getTypeParameters()) {
                genericTypeNames.add(classTypeVariable.getName());
            }
            PropertyReflectionUtils.PropertyMethods propertyMethods = PropertyReflectionUtils.getPropertyMethods(cls);
            for (Method method : propertyMethods.getSetterMethods()) {
                String propertyName = PropertyReflectionUtils.toPropertyName(method);
                propertyNames.add(propertyName);
                PropertyMetadata<?> propertyMetadata = getOrCreateMethodPropertyMetadata(propertyName, declaringClassName, propertyNameMap, TypeData.newInstance(method), propertyTypeParameterMap, parentClassTypeData, genericTypeNames, getGenericType(method));
                if (propertyMetadata.getSetter() == null) {
                    propertyMetadata.setSetter(method);
                    for (Annotation annotation : method.getDeclaredAnnotations()) {
                        propertyMetadata.addWriteAnnotation(annotation);
                    }
                }
            }
            for (Method method2 : propertyMethods.getGetterMethods()) {
                String propertyName2 = PropertyReflectionUtils.toPropertyName(method2);
                propertyNames.add(propertyName2);
                PropertyMetadata<?> propertyMetadata2 = propertyNameMap.get(propertyName2);
                if (propertyMetadata2 == null || propertyMetadata2.getGetter() == null) {
                    PropertyMetadata<?> propertyMetadata3 = getOrCreateMethodPropertyMetadata(propertyName2, declaringClassName, propertyNameMap, TypeData.newInstance(method2), propertyTypeParameterMap, parentClassTypeData, genericTypeNames, getGenericType(method2));
                    if (propertyMetadata3.getGetter() == null) {
                        propertyMetadata3.setGetter(method2);
                        for (Annotation annotation2 : method2.getDeclaredAnnotations()) {
                            propertyMetadata3.addReadAnnotation(annotation2);
                        }
                    }
                }
            }
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                propertyNames.add(field.getName());
                PropertyMetadata<?> propertyMetadata4 = getOrCreateFieldPropertyMetadata(field.getName(), declaringClassName, propertyNameMap, TypeData.newInstance(field), propertyTypeParameterMap, parentClassTypeData, genericTypeNames, field.getGenericType());
                if (propertyMetadata4 != null && propertyMetadata4.getField() == null) {
                    propertyMetadata4.field(field);
                    Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                    for (Annotation annotation3 : declaredAnnotations) {
                        propertyMetadata4.addReadAnnotation(annotation3);
                        propertyMetadata4.addWriteAnnotation(annotation3);
                    }
                }
            }
            parentClassTypeData = TypeData.newInstance(cls.getGenericSuperclass(), cls);
            cls = cls.getSuperclass();
        }
        if (cls.isInterface()) {
            annotations.addAll(Arrays.asList(cls.getDeclaredAnnotations()));
        }
        for (String propertyName3 : propertyNames) {
            PropertyMetadata<?> propertyMetadata5 = propertyNameMap.get(propertyName3);
            if (propertyMetadata5.isSerializable() || propertyMetadata5.isDeserializable()) {
                classModelBuilder.addProperty(createPropertyModelBuilder(propertyMetadata5));
            }
        }
        Collections.reverse(annotations);
        classModelBuilder.annotations(annotations);
        classModelBuilder.propertyNameToTypeParameterMap(propertyTypeParameterMap);
        Constructor<?> constructor = null;
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor2 : declaredConstructors) {
            if (constructor2.getParameterTypes().length == 0 && (Modifier.isPublic(constructor2.getModifiers()) || Modifier.isProtected(constructor2.getModifiers()))) {
                constructor = constructor2;
                constructor.setAccessible(true);
            }
        }
        classModelBuilder.instanceCreatorFactory(new InstanceCreatorFactoryImpl<>(new CreatorExecutable(clazz, constructor)));
    }

    private static <T, S> PropertyMetadata<T> getOrCreateMethodPropertyMetadata(String propertyName, String declaringClassName, Map<String, PropertyMetadata<?>> propertyNameMap, TypeData<T> typeData, Map<String, TypeParameterMap> propertyTypeParameterMap, TypeData<S> parentClassTypeData, List<String> genericTypeNames, Type genericType) {
        PropertyMetadata<T> propertyMetadata = getOrCreatePropertyMetadata(propertyName, declaringClassName, propertyNameMap, typeData);
        if (!isAssignableClass(propertyMetadata.getTypeData().getType(), typeData.getType())) {
            propertyMetadata.setError(String.format("Property '%s' in %s, has differing data types: %s and %s.", propertyName, declaringClassName, propertyMetadata.getTypeData(), typeData));
        }
        cachePropertyTypeData(propertyMetadata, propertyTypeParameterMap, parentClassTypeData, genericTypeNames, genericType);
        return propertyMetadata;
    }

    private static boolean isAssignableClass(Class<?> propertyTypeClass, Class<?> typeDataClass) {
        Assertions.notNull("propertyTypeClass", propertyTypeClass);
        Assertions.notNull("typeDataClass", typeDataClass);
        return propertyTypeClass.isAssignableFrom(typeDataClass) || typeDataClass.isAssignableFrom(propertyTypeClass);
    }

    private static <T, S> PropertyMetadata<T> getOrCreateFieldPropertyMetadata(String propertyName, String declaringClassName, Map<String, PropertyMetadata<?>> propertyNameMap, TypeData<T> typeData, Map<String, TypeParameterMap> propertyTypeParameterMap, TypeData<S> parentClassTypeData, List<String> genericTypeNames, Type genericType) {
        PropertyMetadata<T> propertyMetadata = getOrCreatePropertyMetadata(propertyName, declaringClassName, propertyNameMap, typeData);
        if (!propertyMetadata.getTypeData().getType().isAssignableFrom(typeData.getType())) {
            return null;
        }
        cachePropertyTypeData(propertyMetadata, propertyTypeParameterMap, parentClassTypeData, genericTypeNames, genericType);
        return propertyMetadata;
    }

    private static <T> PropertyMetadata<T> getOrCreatePropertyMetadata(String propertyName, String declaringClassName, Map<String, PropertyMetadata<?>> propertyNameMap, TypeData<T> typeData) {
        PropertyMetadata<?> propertyMetadata = propertyNameMap.get(propertyName);
        if (propertyMetadata == null) {
            propertyMetadata = new PropertyMetadata<>(propertyName, declaringClassName, typeData);
            propertyNameMap.put(propertyName, propertyMetadata);
        }
        return propertyMetadata;
    }

    private static <T, S> void cachePropertyTypeData(PropertyMetadata<T> propertyMetadata, Map<String, TypeParameterMap> propertyTypeParameterMap, TypeData<S> parentClassTypeData, List<String> genericTypeNames, Type genericType) {
        TypeParameterMap typeParameterMap = getTypeParameterMap(genericTypeNames, genericType);
        propertyTypeParameterMap.put(propertyMetadata.getName(), typeParameterMap);
        propertyMetadata.typeParameterInfo(typeParameterMap, parentClassTypeData);
    }

    private static Type getGenericType(Method method) {
        return PropertyReflectionUtils.isGetter(method) ? method.getGenericReturnType() : method.getGenericParameterTypes()[0];
    }

    /* access modifiers changed from: package-private */
    public static <T> PropertyModelBuilder<T> createPropertyModelBuilder(PropertyMetadata<T> propertyMetadata) {
        PropertyModelBuilder<T> propertyModelBuilder = PropertyModel.builder().propertyName(propertyMetadata.getName()).readName(propertyMetadata.getName()).writeName(propertyMetadata.getName()).typeData(propertyMetadata.getTypeData()).readAnnotations(propertyMetadata.getReadAnnotations()).writeAnnotations(propertyMetadata.getWriteAnnotations()).propertySerialization(new PropertyModelSerializationImpl()).propertyAccessor(new PropertyAccessorImpl(propertyMetadata)).setError(propertyMetadata.getError());
        if (propertyMetadata.getTypeParameters() != null) {
            propertyModelBuilder.typeData(PojoSpecializationHelper.specializeTypeData(propertyModelBuilder.getTypeData(), propertyMetadata.getTypeParameters(), propertyMetadata.getTypeParameterMap()));
        }
        return propertyModelBuilder;
    }

    private static TypeParameterMap getTypeParameterMap(List<String> genericTypeNames, Type propertyType) {
        int classParamIndex = genericTypeNames.indexOf(propertyType.toString());
        TypeParameterMap.Builder builder = TypeParameterMap.builder();
        if (classParamIndex != -1) {
            builder.addIndex(classParamIndex);
        } else if (propertyType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) propertyType;
            for (int i = 0; i < pt.getActualTypeArguments().length; i++) {
                int classParamIndex2 = genericTypeNames.indexOf(pt.getActualTypeArguments()[i].toString());
                if (classParamIndex2 != -1) {
                    builder.addIndex(i, classParamIndex2);
                } else {
                    builder.addIndex(i, getTypeParameterMap(genericTypeNames, pt.getActualTypeArguments()[i]));
                }
            }
        }
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public static <V> V stateNotNull(String property, V value) {
        if (value != null) {
            return value;
        }
        throw new IllegalStateException(String.format("%s cannot be null", property));
    }

    private PojoBuilderHelper() {
    }
}
