package dev.morphia.mapping.codec.pojo;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.annotations.Entity;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.NotMappableException;
import dev.morphia.mapping.conventions.MorphiaConvention;
import dev.morphia.sofia.Sofia;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/EntityModelBuilder.class */
public class EntityModelBuilder {
    private final Datastore datastore;
    private final List<PropertyModelBuilder> propertyModels;
    private final Class<?> type;
    private final Map<Class<? extends Annotation>, Annotation> annotationsMap;
    private final Set<Class<?>> classes;
    private final Set<Class<?>> interfaces;
    private final Set<Annotation> annotations;
    private boolean discriminatorEnabled;
    private String discriminator;
    private String discriminatorKey;
    private String idPropertyName;
    private String versionPropertyName;
    private final List<EntityModel> interfaceModels;
    private EntityModel superclass;
    private final Map<String, Map<String, Type>> parameterization;

    public EntityModelBuilder(Datastore datastore, Class<?> type) {
        this.propertyModels = new ArrayList();
        this.annotationsMap = new HashMap();
        this.classes = new LinkedHashSet();
        this.interfaces = new LinkedHashSet();
        this.annotations = new LinkedHashSet();
        this.datastore = datastore;
        this.type = type;
        buildHierarchy(this.type);
        this.parameterization = findParameterization(type);
        propagateTypes();
        if (type.getSuperclass() != null) {
            try {
                this.superclass = datastore.getMapper().getEntityModel(type.getSuperclass());
            } catch (NotMappableException e) {
            }
        }
        this.interfaceModels = (List) this.interfaces.stream().map(i -> {
            try {
                return datastore.getMapper().getEntityModel(i);
            } catch (NotMappableException e2) {
                return null;
            }
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).collect(Collectors.toList());
    }

    public <T, A extends Annotation> EntityModelBuilder(Datastore datastore, A annotation, Class<T> clazz) {
        this(datastore, clazz);
        LinkedHashSet<Annotation> temp = new LinkedHashSet<>();
        temp.add(annotation);
        temp.addAll(this.annotations);
        this.annotations.clear();
        this.annotations.addAll(temp);
    }

    public PropertyModelBuilder addProperty() {
        PropertyModelBuilder builder = PropertyModel.builder(this.datastore);
        this.propertyModels.add(builder);
        return builder;
    }

    public Set<Class<?>> classHierarchy() {
        return this.classes;
    }

    private Map<String, Map<String, Type>> findParameterization(Class<?> type) {
        if (type.getSuperclass() == null) {
            return new LinkedHashMap();
        }
        Map<String, Map<String, Type>> parentMap = findParameterization(type.getSuperclass());
        parentMap.put(type.getSuperclass().getName(), mapArguments(type.getSuperclass(), type.getGenericSuperclass()));
        return parentMap;
    }

    @Nullable
    public <A extends Annotation> A getAnnotation(Class<A> type) {
        return (A) this.annotationsMap.get(type);
    }

    private Set<Class<?>> findParentClasses(Class<?> type) {
        Set<Class<?>> classes = new LinkedHashSet<>();
        while (type != null && !type.isEnum() && !type.equals(Object.class)) {
            classes.add(type);
            this.annotations.addAll(Set.of((Object[]) type.getAnnotations()));
            type = type.getSuperclass();
        }
        return classes;
    }

    public Set<Annotation> annotations() {
        return this.annotations;
    }

    public EntityModel build() {
        this.annotations.forEach(a -> {
            this.annotationsMap.putIfAbsent(a.annotationType(), a);
        });
        for (MorphiaConvention convention : this.datastore.getMapper().getOptions().getConventions()) {
            convention.apply(this.datastore, this);
        }
        if (this.discriminatorEnabled) {
            Objects.requireNonNull(this.discriminatorKey, Sofia.notNull("discriminatorKey", new Locale[0]));
            Objects.requireNonNull(this.discriminator, Sofia.notNull("discriminator", new Locale[0]));
        }
        return new EntityModel(this);
    }

    public EntityModelBuilder discriminator(String discriminator) {
        this.discriminator = discriminator;
        return this;
    }

    public String discriminator() {
        return this.discriminator;
    }

    public EntityModelBuilder discriminatorKey(String key) {
        this.discriminatorKey = key;
        return this;
    }

    public String discriminatorKey() {
        return this.discriminatorKey;
    }

    public EntityModelBuilder enableDiscriminator(boolean enabled) {
        this.discriminatorEnabled = enabled;
        return this;
    }

    @Nullable
    public String idPropertyName() {
        return this.idPropertyName;
    }

    public EntityModelBuilder idPropertyName(String name) {
        this.idPropertyName = name;
        return this;
    }

    @Nullable
    public EntityModel superclass() {
        return this.superclass;
    }

    public Class<?> getType() {
        return this.type;
    }

    public boolean hasAnnotation(Class<? extends Annotation> type) {
        for (Annotation annotation : this.annotations) {
            if (type.equals(annotation.annotationType())) {
                return true;
            }
        }
        return false;
    }

    public PropertyModelBuilder propertyModelByName(String name) throws NoSuchElementException {
        return this.propertyModels.stream().filter(f -> {
            return f.name().equals(name);
        }).findFirst().orElseThrow(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: RETURN  
              (wrap: dev.morphia.mapping.codec.pojo.PropertyModelBuilder : 0x0023: INVOKE  (r0v6 dev.morphia.mapping.codec.pojo.PropertyModelBuilder A[REMOVE]) = 
              (wrap: java.util.Optional<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> : 0x0014: INVOKE  (r0v4 java.util.Optional<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> A[REMOVE]) = 
              (wrap: java.util.stream.Stream<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> : 0x000f: INVOKE  (r0v3 java.util.stream.Stream<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> A[REMOVE]) = 
              (wrap: java.util.stream.Stream<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> : 0x0004: INVOKE  (r0v2 java.util.stream.Stream<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> A[REMOVE]) = 
              (wrap: java.util.List<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> : 0x0001: IGET  (r0v1 java.util.List<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> A[REMOVE]) = 
              (r4v0 'this' dev.morphia.mapping.codec.pojo.EntityModelBuilder A[D('this' dev.morphia.mapping.codec.pojo.EntityModelBuilder), IMMUTABLE_TYPE, THIS])
             dev.morphia.mapping.codec.pojo.EntityModelBuilder.propertyModels java.util.List)
             type: INTERFACE call: java.util.List.stream():java.util.stream.Stream)
              (wrap: java.util.function.Predicate<? super dev.morphia.mapping.codec.pojo.PropertyModelBuilder> : 0x000a: INVOKE_CUSTOM (r1v1 java.util.function.Predicate<? super dev.morphia.mapping.codec.pojo.PropertyModelBuilder> A[REMOVE]) = (r5v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Predicate.test(java.lang.Object):boolean
             call insn: ?: INVOKE  (r1 I:java.lang.String), (v1 dev.morphia.mapping.codec.pojo.PropertyModelBuilder) type: STATIC call: dev.morphia.mapping.codec.pojo.EntityModelBuilder.lambda$propertyModelByName$2(java.lang.String, dev.morphia.mapping.codec.pojo.PropertyModelBuilder):boolean)
             type: INTERFACE call: java.util.stream.Stream.filter(java.util.function.Predicate):java.util.stream.Stream)
             type: INTERFACE call: java.util.stream.Stream.findFirst():java.util.Optional)
              (wrap: java.util.function.Supplier<? extends X extends java.lang.Throwable> : 0x001b: INVOKE_CUSTOM (r1v3 java.util.function.Supplier<? extends X extends java.lang.Throwable> A[REMOVE]) = 
              (r4v0 'this' dev.morphia.mapping.codec.pojo.EntityModelBuilder A[D('this' dev.morphia.mapping.codec.pojo.EntityModelBuilder), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:dev.morphia.mapping.codec.pojo.EntityModelBuilder), (r2 I:java.lang.String) type: DIRECT call: dev.morphia.mapping.codec.pojo.EntityModelBuilder.lambda$propertyModelByName$4(java.lang.String):java.util.NoSuchElementException)
             type: VIRTUAL call: java.util.Optional.orElseThrow(java.util.function.Supplier):java.lang.Object)
             in method: dev.morphia.mapping.codec.pojo.EntityModelBuilder.propertyModelByName(java.lang.String):dev.morphia.mapping.codec.pojo.PropertyModelBuilder, file: grasscutter.jar:dev/morphia/mapping/codec/pojo/EntityModelBuilder.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r4
            java.util.List<dev.morphia.mapping.codec.pojo.PropertyModelBuilder> r0 = r0.propertyModels
            java.util.stream.Stream r0 = r0.stream()
            r1 = r5
            dev.morphia.mapping.codec.pojo.PropertyModelBuilder r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$propertyModelByName$2(r1, v1);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            java.util.Optional r0 = r0.findFirst()
            r1 = r4
            r2 = r5
            dev.morphia.mapping.codec.pojo.PropertyModelBuilder r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return r1.lambda$propertyModelByName$4(r2);
            }
            java.lang.Object r0 = r0.orElseThrow(r1)
            dev.morphia.mapping.codec.pojo.PropertyModelBuilder r0 = (dev.morphia.mapping.codec.pojo.PropertyModelBuilder) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.pojo.EntityModelBuilder.propertyModelByName(java.lang.String):dev.morphia.mapping.codec.pojo.PropertyModelBuilder");
    }

    public List<PropertyModelBuilder> propertyModels() {
        return this.propertyModels;
    }

    @Nullable
    public String versionPropertyName() {
        return this.versionPropertyName;
    }

    public EntityModelBuilder versionPropertyName(String name) {
        this.versionPropertyName = name;
        return this;
    }

    public List<EntityModel> interfaces() {
        return this.interfaceModels;
    }

    public boolean isDiscriminatorEnabled() {
        return this.discriminatorEnabled;
    }

    private Map<String, Type> mapArguments(@Nullable Class<?> type, Type typeSignature) {
        Map<String, Type> map = new HashMap<>();
        if (type != null && (typeSignature instanceof ParameterizedType)) {
            TypeVariable<?>[] typeParameters = type.getTypeParameters();
            if (typeParameters.length != 0) {
                Type[] arguments = ((ParameterizedType) typeSignature).getActualTypeArguments();
                for (int i = 0; i < typeParameters.length; i++) {
                    map.put(typeParameters[i].getName(), arguments[i]);
                }
            }
        }
        return map;
    }

    /* access modifiers changed from: protected */
    public Map<Class<? extends Annotation>, Annotation> annotationsMap() {
        return this.annotationsMap;
    }

    /* access modifiers changed from: protected */
    public String getCollectionName() {
        Entity entityAn = (Entity) getAnnotation(Entity.class);
        if (entityAn == null || entityAn.value().equals(Mapper.IGNORED_FIELDNAME)) {
            return this.datastore.getMapper().getOptions().getCollectionNaming().apply(this.type.getSimpleName());
        }
        return entityAn.value();
    }

    /* access modifiers changed from: protected */
    public Datastore getDatastore() {
        return this.datastore;
    }

    private void buildHierarchy(Class<?> type) {
        this.annotations.addAll(Set.of((Object[]) type.getAnnotations()));
        this.interfaces.addAll(findInterfaces(type));
        this.classes.addAll(findParentClasses(type.getSuperclass()));
        this.classes.forEach(c -> {
            this.interfaces.addAll(findInterfaces(c));
        });
    }

    private List<? extends Class<?>> findInterfaces(Class<?> type) {
        List<Class<?>> list = new ArrayList<>();
        List<Class<?>> interfaces = Arrays.asList(type.getInterfaces());
        this.annotations.addAll(Set.of((Object[]) type.getAnnotations()));
        list.addAll(interfaces);
        list.addAll((Collection) interfaces.stream().flatMap(i -> {
            return findInterfaces(i).stream();
        }).collect(Collectors.toList()));
        return list;
    }

    private void propagateTypes() {
        List<Map<String, Type>> parameters = new ArrayList<>(this.parameterization.values());
        for (int index = 0; index < parameters.size(); index++) {
            Map<String, Type> current = parameters.get(index);
            if (index + 1 < parameters.size()) {
                for (Map.Entry<String, Type> entry : current.entrySet()) {
                    int peek = index + 1;
                    while (entry.getValue() instanceof TypeVariable) {
                        peek++;
                        entry.setValue(parameters.get(peek).get(((TypeVariable) entry.getValue()).getName()));
                    }
                }
            }
        }
    }

    public TypeData<?> getTypeData(Class<?> type, TypeData<?> suggested, Type genericType) {
        Map<String, Type> map;
        if ((genericType instanceof TypeVariable) && (map = this.parameterization.get(type.getName())) != null) {
            Type mapped = map.get(((TypeVariable) genericType).getName());
            if (mapped instanceof Class) {
                suggested = TypeData.newInstance(genericType, (Class) mapped);
            }
        }
        return suggested;
    }
}
