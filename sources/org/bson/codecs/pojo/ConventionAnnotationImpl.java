package org.bson.codecs.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/ConventionAnnotationImpl.class */
final class ConventionAnnotationImpl implements Convention {
    @Override // org.bson.codecs.pojo.Convention
    public void apply(ClassModelBuilder<?> classModelBuilder) {
        for (Annotation annotation : classModelBuilder.getAnnotations()) {
            processClassAnnotation(classModelBuilder, annotation);
        }
        for (PropertyModelBuilder<?> propertyModelBuilder : classModelBuilder.getPropertyModelBuilders()) {
            processPropertyAnnotations(classModelBuilder, propertyModelBuilder);
        }
        processCreatorAnnotation(classModelBuilder);
        cleanPropertyBuilders(classModelBuilder);
    }

    private void processClassAnnotation(ClassModelBuilder<?> classModelBuilder, Annotation annotation) {
        if (annotation instanceof BsonDiscriminator) {
            BsonDiscriminator discriminator = (BsonDiscriminator) annotation;
            String key = discriminator.key();
            if (!key.equals("")) {
                classModelBuilder.discriminatorKey(key);
            }
            String name = discriminator.value();
            if (!name.equals("")) {
                classModelBuilder.discriminator(name);
            }
            classModelBuilder.enableDiscriminator(true);
        }
    }

    private void processPropertyAnnotations(ClassModelBuilder<?> classModelBuilder, PropertyModelBuilder<?> propertyModelBuilder) {
        for (Annotation annotation : propertyModelBuilder.getReadAnnotations()) {
            if (annotation instanceof BsonProperty) {
                BsonProperty bsonProperty = (BsonProperty) annotation;
                if (!"".equals(bsonProperty.value())) {
                    propertyModelBuilder.readName(bsonProperty.value());
                }
                propertyModelBuilder.discriminatorEnabled(bsonProperty.useDiscriminator());
                if (propertyModelBuilder.getName().equals(classModelBuilder.getIdPropertyName())) {
                    classModelBuilder.idPropertyName(null);
                }
            } else if (annotation instanceof BsonId) {
                classModelBuilder.idPropertyName(propertyModelBuilder.getName());
            } else if (annotation instanceof BsonIgnore) {
                propertyModelBuilder.readName(null);
            } else if (annotation instanceof BsonRepresentation) {
                propertyModelBuilder.bsonRepresentation(((BsonRepresentation) annotation).value());
            }
        }
        for (Annotation annotation2 : propertyModelBuilder.getWriteAnnotations()) {
            if (annotation2 instanceof BsonProperty) {
                BsonProperty bsonProperty2 = (BsonProperty) annotation2;
                if (!"".equals(bsonProperty2.value())) {
                    propertyModelBuilder.writeName(bsonProperty2.value());
                }
            } else if (annotation2 instanceof BsonIgnore) {
                propertyModelBuilder.writeName(null);
            }
        }
    }

    private <T> void processCreatorAnnotation(ClassModelBuilder<T> classModelBuilder) {
        Class<T> clazz = classModelBuilder.getType();
        CreatorExecutable<T> creatorExecutable = null;
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            if (Modifier.isPublic(constructor.getModifiers()) && !constructor.isSynthetic()) {
                for (Annotation annotation : constructor.getDeclaredAnnotations()) {
                    if (annotation.annotationType().equals(BsonCreator.class)) {
                        if (creatorExecutable != null) {
                            throw new CodecConfigurationException("Found multiple constructors annotated with @BsonCreator");
                        }
                        creatorExecutable = new CreatorExecutable<>(clazz, constructor);
                    }
                }
                continue;
            }
        }
        boolean foundStaticBsonCreatorMethod = false;
        for (Class<T> cls = clazz; cls != null && !foundStaticBsonCreatorMethod; cls = cls.getSuperclass()) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (Modifier.isStatic(method.getModifiers()) && !method.isSynthetic() && !method.isBridge()) {
                    for (Annotation annotation2 : method.getDeclaredAnnotations()) {
                        if (annotation2.annotationType().equals(BsonCreator.class)) {
                            if (creatorExecutable != null) {
                                throw new CodecConfigurationException("Found multiple constructors / methods annotated with @BsonCreator");
                            } else if (!cls.isAssignableFrom(method.getReturnType())) {
                                throw new CodecConfigurationException(String.format("Invalid method annotated with @BsonCreator. Returns '%s', expected %s", method.getReturnType(), cls));
                            } else {
                                creatorExecutable = new CreatorExecutable<>(clazz, method);
                                foundStaticBsonCreatorMethod = true;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        if (creatorExecutable != null) {
            List<BsonProperty> properties = creatorExecutable.getProperties();
            List<Class<?>> parameterTypes = creatorExecutable.getParameterTypes();
            List<Type> parameterGenericTypes = creatorExecutable.getParameterGenericTypes();
            if (properties.size() != parameterTypes.size()) {
                throw creatorExecutable.getError(clazz, "All parameters in the @BsonCreator method / constructor must be annotated with a @BsonProperty.");
            }
            for (int i = 0; i < properties.size(); i++) {
                boolean isIdProperty = creatorExecutable.getIdPropertyIndex() != null && creatorExecutable.getIdPropertyIndex().equals(Integer.valueOf(i));
                Class<?> parameterType = parameterTypes.get(i);
                Type genericType = parameterGenericTypes.get(i);
                PropertyModelBuilder<?> propertyModelBuilder = null;
                if (isIdProperty) {
                    propertyModelBuilder = classModelBuilder.getProperty(classModelBuilder.getIdPropertyName());
                } else {
                    BsonProperty bsonProperty = properties.get(i);
                    Iterator<PropertyModelBuilder<?>> it = classModelBuilder.getPropertyModelBuilders().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PropertyModelBuilder<?> builder = it.next();
                        if (bsonProperty.value().equals(builder.getWriteName())) {
                            propertyModelBuilder = builder;
                            break;
                        } else if (bsonProperty.value().equals(builder.getReadName())) {
                            propertyModelBuilder = builder;
                        }
                    }
                    if (propertyModelBuilder == null) {
                        propertyModelBuilder = classModelBuilder.getProperty(bsonProperty.value());
                    }
                    if (propertyModelBuilder == null) {
                        propertyModelBuilder = addCreatorPropertyToClassModelBuilder(classModelBuilder, bsonProperty.value(), parameterType);
                    } else {
                        if (!bsonProperty.value().equals(propertyModelBuilder.getName())) {
                            propertyModelBuilder.writeName(bsonProperty.value());
                        }
                        tryToExpandToGenericType(parameterType, propertyModelBuilder, genericType);
                    }
                }
                if (!propertyModelBuilder.getTypeData().isAssignableFrom(parameterType)) {
                    throw creatorExecutable.getError(clazz, String.format("Invalid Property type for '%s'. Expected %s, found %s.", propertyModelBuilder.getWriteName(), propertyModelBuilder.getTypeData().getType(), parameterType));
                }
            }
            classModelBuilder.instanceCreatorFactory(new InstanceCreatorFactoryImpl(creatorExecutable));
        }
    }

    private static <T> void tryToExpandToGenericType(Class<?> parameterType, PropertyModelBuilder<T> propertyModelBuilder, Type genericType) {
        if (parameterType.isAssignableFrom(propertyModelBuilder.getTypeData().getType())) {
            propertyModelBuilder.typeData(TypeData.newInstance(genericType, parameterType));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: org.bson.codecs.pojo.ClassModelBuilder<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private <T, S> PropertyModelBuilder<S> addCreatorPropertyToClassModelBuilder(ClassModelBuilder<T> classModelBuilder, String name, Class<S> clazz) {
        PropertyModelBuilder propertyModelBuilder = (PropertyModelBuilder<T>) PojoBuilderHelper.createPropertyModelBuilder(new PropertyMetadata(name, classModelBuilder.getType().getSimpleName(), TypeData.builder(clazz).build())).readName(null).writeName(name);
        classModelBuilder.addProperty(propertyModelBuilder);
        return propertyModelBuilder;
    }

    private void cleanPropertyBuilders(ClassModelBuilder<?> classModelBuilder) {
        List<String> propertiesToRemove = new ArrayList<>();
        for (PropertyModelBuilder<?> propertyModelBuilder : classModelBuilder.getPropertyModelBuilders()) {
            if (!propertyModelBuilder.isReadable() && !propertyModelBuilder.isWritable()) {
                propertiesToRemove.add(propertyModelBuilder.getName());
            }
        }
        for (String propertyName : propertiesToRemove) {
            classModelBuilder.removeProperty(propertyName);
        }
    }
}
