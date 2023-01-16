package dev.morphia.mapping.codec.pojo;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.EntityInterceptor;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.EntityListeners;
import dev.morphia.annotations.PostLoad;
import dev.morphia.annotations.PostPersist;
import dev.morphia.annotations.PreLoad;
import dev.morphia.annotations.PrePersist;
import dev.morphia.mapping.InstanceCreatorFactory;
import dev.morphia.mapping.InstanceCreatorFactoryImpl;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import dev.morphia.sofia.Sofia;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/EntityModel.class */
public class EntityModel {
    private static final List<Class<? extends Annotation>> LIFECYCLE_ANNOTATIONS = Arrays.asList(PrePersist.class, PreLoad.class, PostPersist.class, PostLoad.class);
    private final Map<Class<? extends Annotation>, Annotation> annotations;
    private final Map<String, PropertyModel> propertyModelsByName;
    private final Map<String, PropertyModel> propertyModelsByMappedName;
    private final Datastore datastore;
    private final InstanceCreatorFactory creatorFactory;
    private final boolean discriminatorEnabled;
    private final String discriminatorKey;
    private final String discriminator;
    private final Class<?> type;
    private final String collectionName;
    private final List<EntityModel> subtypes = new ArrayList();
    private final EntityModel superClass;
    private final PropertyModel idProperty;
    private final PropertyModel versionProperty;
    private Map<Class<? extends Annotation>, List<ClassMethodPair>> lifecycleMethods;

    /* access modifiers changed from: package-private */
    public EntityModel(EntityModelBuilder builder) {
        this.type = builder.getType();
        if (Modifier.isStatic(this.type.getModifiers()) || !this.type.isMemberClass()) {
            this.superClass = builder.superclass();
            this.discriminatorEnabled = builder.isDiscriminatorEnabled();
            this.discriminatorKey = builder.discriminatorKey();
            this.discriminator = builder.discriminator();
            this.annotations = builder.annotationsMap();
            this.propertyModelsByName = new LinkedHashMap();
            this.propertyModelsByMappedName = new LinkedHashMap();
            builder.propertyModels().forEach(modelBuilder -> {
                PropertyModel model = modelBuilder.owner(this).build();
                this.propertyModelsByMappedName.put(model.getMappedName(), model);
                for (String name : modelBuilder.alternateNames()) {
                    if (this.propertyModelsByMappedName.put(name, model) != null) {
                        throw new MappingException(Sofia.duplicatedMappedName(this.type.getCanonicalName(), name, new Locale[0]));
                    }
                }
                this.propertyModelsByName.putIfAbsent(model.getName(), model);
            });
            this.datastore = builder.getDatastore();
            this.collectionName = builder.getCollectionName();
            this.creatorFactory = new InstanceCreatorFactoryImpl(this);
            if (this.superClass != null) {
                this.superClass.addSubtype(this);
            }
            this.idProperty = getProperty(builder.idPropertyName());
            this.versionProperty = getProperty(builder.versionPropertyName());
            builder.interfaces().forEach(i -> {
                i.addSubtype(this);
            });
            return;
        }
        throw new MappingException(Sofia.noInnerClasses(this.type.getName(), new Locale[0]));
    }

    public void callLifecycleMethods(Class<? extends Annotation> event, Object entity, Document document, Mapper mapper) {
        List<ClassMethodPair> methodPairs = getLifecycleMethods().get(event);
        if (methodPairs != null) {
            for (ClassMethodPair cm : methodPairs) {
                cm.invoke(document, entity);
            }
        }
        callGlobalInterceptors(event, entity, document, mapper);
    }

    @Nullable
    public <A extends Annotation> A getAnnotation(Class<A> clazz) {
        return (A) this.annotations.get(clazz);
    }

    public Map<Class<? extends Annotation>, Annotation> getAnnotations() {
        return this.annotations;
    }

    public String getCollectionName() {
        if (this.collectionName != null) {
            return this.collectionName;
        }
        throw new MappingException(Sofia.noMappedCollection(getType().getName(), new Locale[0]));
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public String getDiscriminatorKey() {
        return this.discriminatorKey;
    }

    @Nullable
    public Embedded getEmbeddedAnnotation() {
        return (Embedded) getAnnotation(Embedded.class);
    }

    @Nullable
    public Entity getEntityAnnotation() {
        return (Entity) getAnnotation(Entity.class);
    }

    @Nullable
    public PropertyModel getIdProperty() {
        return this.idProperty;
    }

    public List<PropertyModel> getProperties(Class<? extends Annotation> type) {
        return (List) this.propertyModelsByName.values().stream().filter(model -> {
            return model.hasAnnotation(type);
        }).collect(Collectors.toList());
    }

    public List<PropertyModel> getProperties() {
        return new ArrayList(this.propertyModelsByName.values());
    }

    @Nullable
    public PropertyModel getProperty(@Nullable String name) {
        if (name != null) {
            return this.propertyModelsByMappedName.getOrDefault(name, this.propertyModelsByName.get(name));
        }
        return null;
    }

    public MorphiaInstanceCreator getInstanceCreator() {
        return this.creatorFactory.create();
    }

    public InstanceCreatorFactory getInstanceCreatorFactory() {
        return this.creatorFactory;
    }

    public Map<Class<? extends Annotation>, List<ClassMethodPair>> getLifecycleMethods() {
        if (this.lifecycleMethods == null) {
            this.lifecycleMethods = new HashMap();
            EntityListeners entityLisAnn = (EntityListeners) getAnnotation(EntityListeners.class);
            if (!(entityLisAnn == null || entityLisAnn.value().length == 0)) {
                for (Class<?> aClass : entityLisAnn.value()) {
                    mapEvent(aClass, true);
                }
            }
            mapEvent(getType(), false);
        }
        return this.lifecycleMethods;
    }

    public String getName() {
        return this.type.getSimpleName();
    }

    public List<EntityModel> getSubtypes() {
        return this.subtypes;
    }

    @Nullable
    public EntityModel getSuperClass() {
        return this.superClass;
    }

    public Class<?> getType() {
        return this.type;
    }

    @Nullable
    public PropertyModel getVersionProperty() {
        return this.versionProperty;
    }

    public boolean hasLifecycle(Class<? extends Annotation> type) {
        return getLifecycleMethods().containsKey(type);
    }

    public int hashCode() {
        return Objects.hash(getAnnotations(), this.propertyModelsByName, this.propertyModelsByMappedName, this.datastore, this.creatorFactory, Boolean.valueOf(this.discriminatorEnabled), getDiscriminatorKey(), getDiscriminator(), getType(), getCollectionName(), getLifecycleMethods());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityModel)) {
            return false;
        }
        EntityModel that = (EntityModel) o;
        return this.discriminatorEnabled == that.discriminatorEnabled && Objects.equals(getAnnotations(), that.getAnnotations()) && Objects.equals(this.propertyModelsByName, that.propertyModelsByName) && Objects.equals(this.propertyModelsByMappedName, that.propertyModelsByMappedName) && Objects.equals(this.datastore, that.datastore) && Objects.equals(this.creatorFactory, that.creatorFactory) && Objects.equals(getDiscriminatorKey(), that.getDiscriminatorKey()) && Objects.equals(getDiscriminator(), that.getDiscriminator()) && Objects.equals(getType(), that.getType()) && Objects.equals(getCollectionName(), that.getCollectionName()) && Objects.equals(getLifecycleMethods(), that.getLifecycleMethods());
    }

    public String toString() {
        return String.format("%s<%s> { %s } ", EntityModel.class.getSimpleName(), this.type.getSimpleName(), (String) this.propertyModelsByName.values().stream().map((v0) -> {
            return v0.toString();
        }).collect(Collectors.joining(", ")));
    }

    public boolean isAbstract() {
        return Modifier.isAbstract(getType().getModifiers());
    }

    public boolean isInterface() {
        return getType().isInterface();
    }

    public boolean useDiscriminator() {
        return this.discriminatorEnabled;
    }

    private void addSubtype(EntityModel entityModel) {
        this.subtypes.add(entityModel);
        if (this.superClass != null) {
            this.superClass.addSubtype(entityModel);
        }
    }

    private void callGlobalInterceptors(Class<? extends Annotation> event, Object entity, Document document, Mapper mapper) {
        for (EntityInterceptor ei : mapper.getInterceptors()) {
            Sofia.logCallingInterceptorMethod(event.getSimpleName(), ei, new Locale[0]);
            if (event.equals(PreLoad.class)) {
                ei.preLoad(entity, document, mapper);
            } else if (event.equals(PostLoad.class)) {
                ei.postLoad(entity, document, mapper);
            } else if (event.equals(PrePersist.class)) {
                ei.prePersist(entity, document, mapper);
            } else if (event.equals(PostPersist.class)) {
                ei.postPersist(entity, document, mapper);
            }
        }
    }

    private List<Method> getDeclaredAndInheritedMethods(Class<?> type) {
        List<Method> methods = new ArrayList<>();
        if (type == Object.class) {
            return methods;
        }
        Class<?> parent = type.getSuperclass();
        if (parent != null) {
            methods.addAll(getDeclaredAndInheritedMethods(parent));
        }
        Method[] declaredMethods = type.getDeclaredMethods();
        for (Method m : declaredMethods) {
            if (!Modifier.isStatic(m.getModifiers())) {
                methods.add(m);
            }
        }
        return methods;
    }

    private void mapEvent(Class<?> type, boolean entityListener) {
        for (Method method : getDeclaredAndInheritedMethods(type)) {
            for (Class<? extends Annotation> annotationClass : LIFECYCLE_ANNOTATIONS) {
                if (method.isAnnotationPresent(annotationClass)) {
                    this.lifecycleMethods.computeIfAbsent(annotationClass, c -> {
                        return new ArrayList();
                    }).add(new ClassMethodPair(this.datastore, method, entityListener ? type : null, annotationClass));
                }
            }
        }
    }
}
