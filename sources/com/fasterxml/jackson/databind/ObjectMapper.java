package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.StreamWriteFeature;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.p003io.CharacterEscapes;
import com.fasterxml.jackson.core.p003io.SegmentedStringWriter;
import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MutableCoercionConfig;
import com.fasterxml.jackson.databind.cfg.MutableConfigOverride;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeModifier;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ObjectMapper.class */
public class ObjectMapper extends ObjectCodec implements Versioned, Serializable {
    private static final long serialVersionUID = 2;
    protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
    protected static final BaseSettings DEFAULT_BASE = new BaseSettings(null, DEFAULT_ANNOTATION_INTROSPECTOR, null, TypeFactory.defaultInstance(), null, StdDateFormat.instance, null, Locale.getDefault(), null, Base64Variants.getDefaultVariant(), LaissezFaireSubTypeValidator.instance, new DefaultAccessorNamingStrategy.Provider());
    protected final JsonFactory _jsonFactory;
    protected TypeFactory _typeFactory;
    protected InjectableValues _injectableValues;
    protected SubtypeResolver _subtypeResolver;
    protected final ConfigOverrides _configOverrides;
    protected final CoercionConfigs _coercionConfigs;
    protected SimpleMixInResolver _mixIns;
    protected SerializationConfig _serializationConfig;
    protected DefaultSerializerProvider _serializerProvider;
    protected SerializerFactory _serializerFactory;
    protected DeserializationConfig _deserializationConfig;
    protected DefaultDeserializationContext _deserializationContext;
    protected Set<Object> _registeredModuleTypes;
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ObjectMapper$DefaultTyping.class */
    public enum DefaultTyping {
        JAVA_LANG_OBJECT,
        OBJECT_AND_NON_CONCRETE,
        NON_CONCRETE_AND_ARRAYS,
        NON_FINAL,
        EVERYTHING
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ObjectMapper$DefaultTypeResolverBuilder.class */
    public static class DefaultTypeResolverBuilder extends StdTypeResolverBuilder implements Serializable {
        private static final long serialVersionUID = 1;
        protected final DefaultTyping _appliesFor;
        protected final PolymorphicTypeValidator _subtypeValidator;

        @Deprecated
        public DefaultTypeResolverBuilder(DefaultTyping t) {
            this(t, LaissezFaireSubTypeValidator.instance);
        }

        public DefaultTypeResolverBuilder(DefaultTyping t, PolymorphicTypeValidator ptv) {
            this._appliesFor = (DefaultTyping) _requireNonNull(t, "Can not pass `null` DefaultTyping");
            this._subtypeValidator = (PolymorphicTypeValidator) _requireNonNull(ptv, "Can not pass `null` PolymorphicTypeValidator");
        }

        protected DefaultTypeResolverBuilder(DefaultTypeResolverBuilder base, Class<?> defaultImpl) {
            super(base, defaultImpl);
            this._appliesFor = base._appliesFor;
            this._subtypeValidator = base._subtypeValidator;
        }

        private static <T> T _requireNonNull(T value, String msg) {
            if (value != null) {
                return value;
            }
            throw new NullPointerException(msg);
        }

        public static DefaultTypeResolverBuilder construct(DefaultTyping t, PolymorphicTypeValidator ptv) {
            return new DefaultTypeResolverBuilder(t, ptv);
        }

        /* Return type fixed from 'com.fasterxml.jackson.databind.ObjectMapper$DefaultTypeResolverBuilder' to match base method */
        @Override // com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder, com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
        public StdTypeResolverBuilder withDefaultImpl(Class<?> defaultImpl) {
            if (this._defaultImpl == defaultImpl) {
                return this;
            }
            ClassUtil.verifyMustOverride(DefaultTypeResolverBuilder.class, this, "withDefaultImpl");
            return new DefaultTypeResolverBuilder(this, defaultImpl);
        }

        @Override // com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder
        public PolymorphicTypeValidator subTypeValidator(MapperConfig<?> config) {
            return this._subtypeValidator;
        }

        @Override // com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder, com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
        public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
            if (useForType(baseType)) {
                return buildTypeDeserializer(config, baseType, subtypes);
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder, com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
        public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
            if (useForType(baseType)) {
                return buildTypeSerializer(config, baseType, subtypes);
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004e A[LOOP:1: B:10:0x0047->B:12:0x004e, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean useForType(com.fasterxml.jackson.databind.JavaType r4) {
            /*
                r3 = this;
                r0 = r4
                boolean r0 = r0.isPrimitive()
                if (r0 == 0) goto L_0x0009
                r0 = 0
                return r0
            L_0x0009:
                int[] r0 = com.fasterxml.jackson.databind.ObjectMapper.C00433.f234x3ef634e7
                r1 = r3
                com.fasterxml.jackson.databind.ObjectMapper$DefaultTyping r1 = r1._appliesFor
                int r1 = r1.ordinal()
                r0 = r0[r1]
                switch(r0) {
                    case 1: goto L_0x0038;
                    case 2: goto L_0x0047;
                    case 3: goto L_0x0076;
                    case 4: goto L_0x00ad;
                    case 5: goto L_0x00af;
                    default: goto L_0x00af;
                }
            L_0x0038:
                r0 = r4
                boolean r0 = r0.isArrayType()
                if (r0 == 0) goto L_0x0047
                r0 = r4
                com.fasterxml.jackson.databind.JavaType r0 = r0.getContentType()
                r4 = r0
                goto L_0x0038
            L_0x0047:
                r0 = r4
                boolean r0 = r0.isReferenceType()
                if (r0 == 0) goto L_0x0056
                r0 = r4
                com.fasterxml.jackson.databind.JavaType r0 = r0.getReferencedType()
                r4 = r0
                goto L_0x0047
            L_0x0056:
                r0 = r4
                boolean r0 = r0.isJavaLangObject()
                if (r0 != 0) goto L_0x0070
                r0 = r4
                boolean r0 = r0.isConcrete()
                if (r0 != 0) goto L_0x0074
                java.lang.Class<com.fasterxml.jackson.core.TreeNode> r0 = com.fasterxml.jackson.core.TreeNode.class
                r1 = r4
                java.lang.Class r1 = r1.getRawClass()
                boolean r0 = r0.isAssignableFrom(r1)
                if (r0 != 0) goto L_0x0074
            L_0x0070:
                r0 = 1
                goto L_0x0075
            L_0x0074:
                r0 = 0
            L_0x0075:
                return r0
            L_0x0076:
                r0 = r4
                boolean r0 = r0.isArrayType()
                if (r0 == 0) goto L_0x0085
                r0 = r4
                com.fasterxml.jackson.databind.JavaType r0 = r0.getContentType()
                r4 = r0
                goto L_0x0076
            L_0x0085:
                r0 = r4
                boolean r0 = r0.isReferenceType()
                if (r0 == 0) goto L_0x0094
                r0 = r4
                com.fasterxml.jackson.databind.JavaType r0 = r0.getReferencedType()
                r4 = r0
                goto L_0x0085
            L_0x0094:
                r0 = r4
                boolean r0 = r0.isFinal()
                if (r0 != 0) goto L_0x00ab
                java.lang.Class<com.fasterxml.jackson.core.TreeNode> r0 = com.fasterxml.jackson.core.TreeNode.class
                r1 = r4
                java.lang.Class r1 = r1.getRawClass()
                boolean r0 = r0.isAssignableFrom(r1)
                if (r0 != 0) goto L_0x00ab
                r0 = 1
                goto L_0x00ac
            L_0x00ab:
                r0 = 0
            L_0x00ac:
                return r0
            L_0x00ad:
                r0 = 1
                return r0
            L_0x00af:
                r0 = r4
                boolean r0 = r0.isJavaLangObject()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder.useForType(com.fasterxml.jackson.databind.JavaType):boolean");
        }
    }

    public ObjectMapper() {
        this(null, null, null);
    }

    public ObjectMapper(JsonFactory jf) {
        this(jf, null, null);
    }

    /* access modifiers changed from: protected */
    public ObjectMapper(ObjectMapper src) {
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        this._jsonFactory = src._jsonFactory.copy();
        this._jsonFactory.setCodec(this);
        this._subtypeResolver = src._subtypeResolver.copy();
        this._typeFactory = src._typeFactory;
        this._injectableValues = src._injectableValues;
        this._configOverrides = src._configOverrides.copy();
        this._coercionConfigs = src._coercionConfigs.copy();
        this._mixIns = src._mixIns.copy();
        RootNameLookup rootNames = new RootNameLookup();
        this._serializationConfig = new SerializationConfig(src._serializationConfig, this._subtypeResolver, this._mixIns, rootNames, this._configOverrides);
        this._deserializationConfig = new DeserializationConfig(src._deserializationConfig, this._subtypeResolver, this._mixIns, rootNames, this._configOverrides, this._coercionConfigs);
        this._serializerProvider = src._serializerProvider.copy();
        this._deserializationContext = src._deserializationContext.copy();
        this._serializerFactory = src._serializerFactory;
        Set<Object> reg = src._registeredModuleTypes;
        if (reg == null) {
            this._registeredModuleTypes = null;
        } else {
            this._registeredModuleTypes = new LinkedHashSet(reg);
        }
    }

    public ObjectMapper(JsonFactory jf, DefaultSerializerProvider sp, DefaultDeserializationContext dc) {
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (jf == null) {
            this._jsonFactory = new MappingJsonFactory(this);
        } else {
            this._jsonFactory = jf;
            if (jf.getCodec() == null) {
                this._jsonFactory.setCodec(this);
            }
        }
        this._subtypeResolver = new StdSubtypeResolver();
        RootNameLookup rootNames = new RootNameLookup();
        this._typeFactory = TypeFactory.defaultInstance();
        SimpleMixInResolver mixins = new SimpleMixInResolver(null);
        this._mixIns = mixins;
        BaseSettings base = DEFAULT_BASE.withClassIntrospector(defaultClassIntrospector());
        this._configOverrides = new ConfigOverrides();
        this._coercionConfigs = new CoercionConfigs();
        this._serializationConfig = new SerializationConfig(base, this._subtypeResolver, mixins, rootNames, this._configOverrides);
        this._deserializationConfig = new DeserializationConfig(base, this._subtypeResolver, mixins, rootNames, this._configOverrides, this._coercionConfigs);
        boolean needOrder = this._jsonFactory.requiresPropertyOrdering();
        if (needOrder ^ this._serializationConfig.isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)) {
            configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, needOrder);
        }
        this._serializerProvider = sp == null ? new DefaultSerializerProvider.Impl() : sp;
        this._deserializationContext = dc == null ? new DefaultDeserializationContext.Impl(BeanDeserializerFactory.instance) : dc;
        this._serializerFactory = BeanSerializerFactory.instance;
    }

    protected ClassIntrospector defaultClassIntrospector() {
        return new BasicClassIntrospector();
    }

    public ObjectMapper copy() {
        _checkInvalidCopy(ObjectMapper.class);
        return new ObjectMapper(this);
    }

    protected void _checkInvalidCopy(Class<?> exp) {
        if (getClass() != exp) {
            throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
        }
    }

    protected ObjectReader _newReader(DeserializationConfig config) {
        return new ObjectReader(this, config);
    }

    protected ObjectReader _newReader(DeserializationConfig config, JavaType valueType, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues) {
        return new ObjectReader(this, config, valueType, valueToUpdate, schema, injectableValues);
    }

    protected ObjectWriter _newWriter(SerializationConfig config) {
        return new ObjectWriter(this, config);
    }

    protected ObjectWriter _newWriter(SerializationConfig config, FormatSchema schema) {
        return new ObjectWriter(this, config, schema);
    }

    protected ObjectWriter _newWriter(SerializationConfig config, JavaType rootType, PrettyPrinter pp) {
        return new ObjectWriter(this, config, rootType, pp);
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    public ObjectMapper registerModule(Module module) {
        Object typeId;
        _assertNotNull("module", module);
        if (module.getModuleName() == null) {
            throw new IllegalArgumentException("Module without defined name");
        } else if (module.version() == null) {
            throw new IllegalArgumentException("Module without defined version");
        } else {
            for (Module dep : module.getDependencies()) {
                registerModule(dep);
            }
            if (isEnabled(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS) && (typeId = module.getTypeId()) != null) {
                if (this._registeredModuleTypes == null) {
                    this._registeredModuleTypes = new LinkedHashSet();
                }
                if (!this._registeredModuleTypes.add(typeId)) {
                    return this;
                }
            }
            module.setupModule(new Module.SetupContext() { // from class: com.fasterxml.jackson.databind.ObjectMapper.1
                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public Version getMapperVersion() {
                    return ObjectMapper.this.version();
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public <C extends ObjectCodec> C getOwner() {
                    return ObjectMapper.this;
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public TypeFactory getTypeFactory() {
                    return ObjectMapper.this._typeFactory;
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public boolean isEnabled(MapperFeature f) {
                    return ObjectMapper.this.isEnabled(f);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public boolean isEnabled(DeserializationFeature f) {
                    return ObjectMapper.this.isEnabled(f);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public boolean isEnabled(SerializationFeature f) {
                    return ObjectMapper.this.isEnabled(f);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public boolean isEnabled(JsonFactory.Feature f) {
                    return ObjectMapper.this.isEnabled(f);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public boolean isEnabled(JsonParser.Feature f) {
                    return ObjectMapper.this.isEnabled(f);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public boolean isEnabled(JsonGenerator.Feature f) {
                    return ObjectMapper.this.isEnabled(f);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public MutableConfigOverride configOverride(Class<?> type) {
                    return ObjectMapper.this.configOverride(type);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addDeserializers(Deserializers d) {
                    DeserializerFactory df = ObjectMapper.this._deserializationContext._factory.withAdditionalDeserializers(d);
                    ObjectMapper.this._deserializationContext = ObjectMapper.this._deserializationContext.with(df);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addKeyDeserializers(KeyDeserializers d) {
                    DeserializerFactory df = ObjectMapper.this._deserializationContext._factory.withAdditionalKeyDeserializers(d);
                    ObjectMapper.this._deserializationContext = ObjectMapper.this._deserializationContext.with(df);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addBeanDeserializerModifier(BeanDeserializerModifier modifier) {
                    DeserializerFactory df = ObjectMapper.this._deserializationContext._factory.withDeserializerModifier(modifier);
                    ObjectMapper.this._deserializationContext = ObjectMapper.this._deserializationContext.with(df);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addSerializers(Serializers s) {
                    ObjectMapper.this._serializerFactory = ObjectMapper.this._serializerFactory.withAdditionalSerializers(s);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addKeySerializers(Serializers s) {
                    ObjectMapper.this._serializerFactory = ObjectMapper.this._serializerFactory.withAdditionalKeySerializers(s);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addBeanSerializerModifier(BeanSerializerModifier modifier) {
                    ObjectMapper.this._serializerFactory = ObjectMapper.this._serializerFactory.withSerializerModifier(modifier);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addAbstractTypeResolver(AbstractTypeResolver resolver) {
                    DeserializerFactory df = ObjectMapper.this._deserializationContext._factory.withAbstractTypeResolver(resolver);
                    ObjectMapper.this._deserializationContext = ObjectMapper.this._deserializationContext.with(df);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addTypeModifier(TypeModifier modifier) {
                    ObjectMapper.this.setTypeFactory(ObjectMapper.this._typeFactory.withModifier(modifier));
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addValueInstantiators(ValueInstantiators instantiators) {
                    DeserializerFactory df = ObjectMapper.this._deserializationContext._factory.withValueInstantiators(instantiators);
                    ObjectMapper.this._deserializationContext = ObjectMapper.this._deserializationContext.with(df);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void setClassIntrospector(ClassIntrospector ci) {
                    ObjectMapper.this._deserializationConfig = ObjectMapper.this._deserializationConfig.with(ci);
                    ObjectMapper.this._serializationConfig = ObjectMapper.this._serializationConfig.with(ci);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void insertAnnotationIntrospector(AnnotationIntrospector ai) {
                    ObjectMapper.this._deserializationConfig = ObjectMapper.this._deserializationConfig.withInsertedAnnotationIntrospector(ai);
                    ObjectMapper.this._serializationConfig = ObjectMapper.this._serializationConfig.withInsertedAnnotationIntrospector(ai);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void appendAnnotationIntrospector(AnnotationIntrospector ai) {
                    ObjectMapper.this._deserializationConfig = ObjectMapper.this._deserializationConfig.withAppendedAnnotationIntrospector(ai);
                    ObjectMapper.this._serializationConfig = ObjectMapper.this._serializationConfig.withAppendedAnnotationIntrospector(ai);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void registerSubtypes(Class<?>... subtypes) {
                    ObjectMapper.this.registerSubtypes(subtypes);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void registerSubtypes(NamedType... subtypes) {
                    ObjectMapper.this.registerSubtypes(subtypes);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void registerSubtypes(Collection<Class<?>> subtypes) {
                    ObjectMapper.this.registerSubtypes(subtypes);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void setMixInAnnotations(Class<?> target, Class<?> mixinSource) {
                    ObjectMapper.this.addMixIn(target, mixinSource);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void addDeserializationProblemHandler(DeserializationProblemHandler handler) {
                    ObjectMapper.this.addHandler(handler);
                }

                @Override // com.fasterxml.jackson.databind.Module.SetupContext
                public void setNamingStrategy(PropertyNamingStrategy naming) {
                    ObjectMapper.this.setPropertyNamingStrategy(naming);
                }
            });
            return this;
        }
    }

    public ObjectMapper registerModules(Module... modules) {
        for (Module module : modules) {
            registerModule(module);
        }
        return this;
    }

    public ObjectMapper registerModules(Iterable<? extends Module> modules) {
        _assertNotNull("modules", modules);
        for (Module module : modules) {
            registerModule(module);
        }
        return this;
    }

    public Set<Object> getRegisteredModuleIds() {
        return this._registeredModuleTypes == null ? Collections.emptySet() : Collections.unmodifiableSet(this._registeredModuleTypes);
    }

    public static List<Module> findModules() {
        return findModules(null);
    }

    public static List<Module> findModules(ClassLoader classLoader) {
        ArrayList<Module> modules = new ArrayList<>();
        Iterator<Module> it = secureGetServiceLoader(Module.class, classLoader).iterator();
        while (it.hasNext()) {
            modules.add(it.next());
        }
        return modules;
    }

    private static <T> ServiceLoader<T> secureGetServiceLoader(final Class<T> clazz, final ClassLoader classLoader) {
        if (System.getSecurityManager() == null) {
            return classLoader == null ? ServiceLoader.load(clazz) : ServiceLoader.load(clazz, classLoader);
        }
        return (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction<ServiceLoader<T>>() { // from class: com.fasterxml.jackson.databind.ObjectMapper.2
            @Override // java.security.PrivilegedAction
            public ServiceLoader<T> run() {
                return classLoader == null ? ServiceLoader.load(clazz) : ServiceLoader.load(clazz, classLoader);
            }
        });
    }

    public ObjectMapper findAndRegisterModules() {
        return registerModules(findModules());
    }

    public JsonGenerator createGenerator(OutputStream out) throws IOException {
        _assertNotNull("out", out);
        JsonGenerator g = this._jsonFactory.createGenerator(out, JsonEncoding.UTF8);
        this._serializationConfig.initialize(g);
        return g;
    }

    public JsonGenerator createGenerator(OutputStream out, JsonEncoding enc) throws IOException {
        _assertNotNull("out", out);
        JsonGenerator g = this._jsonFactory.createGenerator(out, enc);
        this._serializationConfig.initialize(g);
        return g;
    }

    public JsonGenerator createGenerator(Writer w) throws IOException {
        _assertNotNull("w", w);
        JsonGenerator g = this._jsonFactory.createGenerator(w);
        this._serializationConfig.initialize(g);
        return g;
    }

    public JsonGenerator createGenerator(File outputFile, JsonEncoding enc) throws IOException {
        _assertNotNull("outputFile", outputFile);
        JsonGenerator g = this._jsonFactory.createGenerator(outputFile, enc);
        this._serializationConfig.initialize(g);
        return g;
    }

    public JsonGenerator createGenerator(DataOutput out) throws IOException {
        _assertNotNull("out", out);
        JsonGenerator g = this._jsonFactory.createGenerator(out);
        this._serializationConfig.initialize(g);
        return g;
    }

    public JsonParser createParser(File src) throws IOException {
        _assertNotNull("src", src);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(src));
    }

    public JsonParser createParser(URL src) throws IOException {
        _assertNotNull("src", src);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(src));
    }

    public JsonParser createParser(InputStream in) throws IOException {
        _assertNotNull("in", in);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(in));
    }

    public JsonParser createParser(Reader r) throws IOException {
        _assertNotNull("r", r);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(r));
    }

    public JsonParser createParser(byte[] content) throws IOException {
        _assertNotNull("content", content);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(content));
    }

    public JsonParser createParser(byte[] content, int offset, int len) throws IOException {
        _assertNotNull("content", content);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(content, offset, len));
    }

    public JsonParser createParser(String content) throws IOException {
        _assertNotNull("content", content);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(content));
    }

    public JsonParser createParser(char[] content) throws IOException {
        _assertNotNull("content", content);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(content));
    }

    public JsonParser createParser(char[] content, int offset, int len) throws IOException {
        _assertNotNull("content", content);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(content, offset, len));
    }

    public JsonParser createParser(DataInput content) throws IOException {
        _assertNotNull("content", content);
        return this._deserializationConfig.initialize(this._jsonFactory.createParser(content));
    }

    public JsonParser createNonBlockingByteArrayParser() throws IOException {
        return this._deserializationConfig.initialize(this._jsonFactory.createNonBlockingByteArrayParser());
    }

    public SerializationConfig getSerializationConfig() {
        return this._serializationConfig;
    }

    public DeserializationConfig getDeserializationConfig() {
        return this._deserializationConfig;
    }

    public DeserializationContext getDeserializationContext() {
        return this._deserializationContext;
    }

    public ObjectMapper setSerializerFactory(SerializerFactory f) {
        this._serializerFactory = f;
        return this;
    }

    public SerializerFactory getSerializerFactory() {
        return this._serializerFactory;
    }

    public ObjectMapper setSerializerProvider(DefaultSerializerProvider p) {
        this._serializerProvider = p;
        return this;
    }

    public SerializerProvider getSerializerProvider() {
        return this._serializerProvider;
    }

    public SerializerProvider getSerializerProviderInstance() {
        return _serializerProvider(this._serializationConfig);
    }

    public ObjectMapper setMixIns(Map<Class<?>, Class<?>> sourceMixins) {
        this._mixIns.setLocalDefinitions(sourceMixins);
        return this;
    }

    public ObjectMapper addMixIn(Class<?> target, Class<?> mixinSource) {
        this._mixIns.addLocalDefinition(target, mixinSource);
        return this;
    }

    public ObjectMapper setMixInResolver(ClassIntrospector.MixInResolver resolver) {
        SimpleMixInResolver r = this._mixIns.withOverrides(resolver);
        if (r != this._mixIns) {
            this._mixIns = r;
            this._deserializationConfig = new DeserializationConfig(this._deserializationConfig, r);
            this._serializationConfig = new SerializationConfig(this._serializationConfig, r);
        }
        return this;
    }

    public Class<?> findMixInClassFor(Class<?> cls) {
        return this._mixIns.findMixInClassFor(cls);
    }

    public int mixInCount() {
        return this._mixIns.localSize();
    }

    @Deprecated
    public void setMixInAnnotations(Map<Class<?>, Class<?>> sourceMixins) {
        setMixIns(sourceMixins);
    }

    @Deprecated
    public final void addMixInAnnotations(Class<?> target, Class<?> mixinSource) {
        addMixIn(target, mixinSource);
    }

    public VisibilityChecker<?> getVisibilityChecker() {
        return this._serializationConfig.getDefaultVisibilityChecker();
    }

    public ObjectMapper setVisibility(VisibilityChecker<?> vc) {
        this._configOverrides.setDefaultVisibility(vc);
        return this;
    }

    public ObjectMapper setVisibility(PropertyAccessor forMethod, JsonAutoDetect.Visibility visibility) {
        this._configOverrides.setDefaultVisibility(this._configOverrides.getDefaultVisibility().withVisibility(forMethod, visibility));
        return this;
    }

    public SubtypeResolver getSubtypeResolver() {
        return this._subtypeResolver;
    }

    public ObjectMapper setSubtypeResolver(SubtypeResolver str) {
        this._subtypeResolver = str;
        this._deserializationConfig = this._deserializationConfig.with(str);
        this._serializationConfig = this._serializationConfig.with(str);
        return this;
    }

    public ObjectMapper setAnnotationIntrospector(AnnotationIntrospector ai) {
        this._serializationConfig = this._serializationConfig.with(ai);
        this._deserializationConfig = this._deserializationConfig.with(ai);
        return this;
    }

    public ObjectMapper setAnnotationIntrospectors(AnnotationIntrospector serializerAI, AnnotationIntrospector deserializerAI) {
        this._serializationConfig = this._serializationConfig.with(serializerAI);
        this._deserializationConfig = this._deserializationConfig.with(deserializerAI);
        return this;
    }

    public ObjectMapper setPropertyNamingStrategy(PropertyNamingStrategy s) {
        this._serializationConfig = this._serializationConfig.with(s);
        this._deserializationConfig = this._deserializationConfig.with(s);
        return this;
    }

    public PropertyNamingStrategy getPropertyNamingStrategy() {
        return this._serializationConfig.getPropertyNamingStrategy();
    }

    public ObjectMapper setAccessorNaming(AccessorNamingStrategy.Provider s) {
        this._serializationConfig = this._serializationConfig.with(s);
        this._deserializationConfig = this._deserializationConfig.with(s);
        return this;
    }

    public ObjectMapper setDefaultPrettyPrinter(PrettyPrinter pp) {
        this._serializationConfig = this._serializationConfig.withDefaultPrettyPrinter(pp);
        return this;
    }

    @Deprecated
    public void setVisibilityChecker(VisibilityChecker<?> vc) {
        setVisibility(vc);
    }

    public ObjectMapper setPolymorphicTypeValidator(PolymorphicTypeValidator ptv) {
        this._deserializationConfig = this._deserializationConfig._withBase(this._deserializationConfig.getBaseSettings().with(ptv));
        return this;
    }

    public PolymorphicTypeValidator getPolymorphicTypeValidator() {
        return this._deserializationConfig.getBaseSettings().getPolymorphicTypeValidator();
    }

    public ObjectMapper setSerializationInclusion(JsonInclude.Include incl) {
        setPropertyInclusion(JsonInclude.Value.construct(incl, incl));
        return this;
    }

    @Deprecated
    public ObjectMapper setPropertyInclusion(JsonInclude.Value incl) {
        return setDefaultPropertyInclusion(incl);
    }

    public ObjectMapper setDefaultPropertyInclusion(JsonInclude.Value incl) {
        this._configOverrides.setDefaultInclusion(incl);
        return this;
    }

    public ObjectMapper setDefaultPropertyInclusion(JsonInclude.Include incl) {
        this._configOverrides.setDefaultInclusion(JsonInclude.Value.construct(incl, incl));
        return this;
    }

    public ObjectMapper setDefaultSetterInfo(JsonSetter.Value v) {
        this._configOverrides.setDefaultSetterInfo(v);
        return this;
    }

    public ObjectMapper setDefaultVisibility(JsonAutoDetect.Value vis) {
        this._configOverrides.setDefaultVisibility(VisibilityChecker.Std.construct(vis));
        return this;
    }

    public ObjectMapper setDefaultMergeable(Boolean b) {
        this._configOverrides.setDefaultMergeable(b);
        return this;
    }

    public ObjectMapper setDefaultLeniency(Boolean b) {
        this._configOverrides.setDefaultLeniency(b);
        return this;
    }

    public void registerSubtypes(Class<?>... classes) {
        getSubtypeResolver().registerSubtypes(classes);
    }

    public void registerSubtypes(NamedType... types) {
        getSubtypeResolver().registerSubtypes(types);
    }

    public void registerSubtypes(Collection<Class<?>> subtypes) {
        getSubtypeResolver().registerSubtypes(subtypes);
    }

    public ObjectMapper activateDefaultTyping(PolymorphicTypeValidator ptv) {
        return activateDefaultTyping(ptv, DefaultTyping.OBJECT_AND_NON_CONCRETE);
    }

    public ObjectMapper activateDefaultTyping(PolymorphicTypeValidator ptv, DefaultTyping applicability) {
        return activateDefaultTyping(ptv, applicability, JsonTypeInfo.EnumC0036As.WRAPPER_ARRAY);
    }

    public ObjectMapper activateDefaultTyping(PolymorphicTypeValidator ptv, DefaultTyping applicability, JsonTypeInfo.EnumC0036As includeAs) {
        if (includeAs != JsonTypeInfo.EnumC0036As.EXTERNAL_PROPERTY) {
            return setDefaultTyping(_constructDefaultTypeResolverBuilder(applicability, ptv).init(JsonTypeInfo.EnumC0037Id.CLASS, null).inclusion(includeAs));
        }
        throw new IllegalArgumentException("Cannot use includeAs of " + includeAs);
    }

    public ObjectMapper activateDefaultTypingAsProperty(PolymorphicTypeValidator ptv, DefaultTyping applicability, String propertyName) {
        return setDefaultTyping(_constructDefaultTypeResolverBuilder(applicability, ptv).init(JsonTypeInfo.EnumC0037Id.CLASS, null).inclusion(JsonTypeInfo.EnumC0036As.PROPERTY).typeProperty(propertyName));
    }

    public ObjectMapper deactivateDefaultTyping() {
        return setDefaultTyping(null);
    }

    public ObjectMapper setDefaultTyping(TypeResolverBuilder<?> typer) {
        this._deserializationConfig = this._deserializationConfig.with(typer);
        this._serializationConfig = this._serializationConfig.with(typer);
        return this;
    }

    @Deprecated
    public ObjectMapper enableDefaultTyping() {
        return activateDefaultTyping(getPolymorphicTypeValidator());
    }

    @Deprecated
    public ObjectMapper enableDefaultTyping(DefaultTyping dti) {
        return enableDefaultTyping(dti, JsonTypeInfo.EnumC0036As.WRAPPER_ARRAY);
    }

    @Deprecated
    public ObjectMapper enableDefaultTyping(DefaultTyping applicability, JsonTypeInfo.EnumC0036As includeAs) {
        return activateDefaultTyping(getPolymorphicTypeValidator(), applicability, includeAs);
    }

    @Deprecated
    public ObjectMapper enableDefaultTypingAsProperty(DefaultTyping applicability, String propertyName) {
        return activateDefaultTypingAsProperty(getPolymorphicTypeValidator(), applicability, propertyName);
    }

    @Deprecated
    public ObjectMapper disableDefaultTyping() {
        return setDefaultTyping(null);
    }

    public MutableConfigOverride configOverride(Class<?> type) {
        return this._configOverrides.findOrCreateOverride(type);
    }

    public MutableCoercionConfig coercionConfigDefaults() {
        return this._coercionConfigs.defaultCoercions();
    }

    public MutableCoercionConfig coercionConfigFor(LogicalType logicalType) {
        return this._coercionConfigs.findOrCreateCoercion(logicalType);
    }

    public MutableCoercionConfig coercionConfigFor(Class<?> physicalType) {
        return this._coercionConfigs.findOrCreateCoercion(physicalType);
    }

    public TypeFactory getTypeFactory() {
        return this._typeFactory;
    }

    public ObjectMapper setTypeFactory(TypeFactory f) {
        this._typeFactory = f;
        this._deserializationConfig = this._deserializationConfig.with(f);
        this._serializationConfig = this._serializationConfig.with(f);
        return this;
    }

    public JavaType constructType(Type t) {
        _assertNotNull("t", t);
        return this._typeFactory.constructType(t);
    }

    public JavaType constructType(TypeReference<?> typeRef) {
        _assertNotNull("typeRef", typeRef);
        return this._typeFactory.constructType(typeRef);
    }

    public JsonNodeFactory getNodeFactory() {
        return this._deserializationConfig.getNodeFactory();
    }

    public ObjectMapper setNodeFactory(JsonNodeFactory f) {
        this._deserializationConfig = this._deserializationConfig.with(f);
        return this;
    }

    public ObjectMapper setConstructorDetector(ConstructorDetector cd) {
        this._deserializationConfig = this._deserializationConfig.with(cd);
        return this;
    }

    public ObjectMapper addHandler(DeserializationProblemHandler h) {
        this._deserializationConfig = this._deserializationConfig.withHandler(h);
        return this;
    }

    public ObjectMapper clearProblemHandlers() {
        this._deserializationConfig = this._deserializationConfig.withNoProblemHandlers();
        return this;
    }

    public ObjectMapper setConfig(DeserializationConfig config) {
        _assertNotNull("config", config);
        this._deserializationConfig = config;
        return this;
    }

    @Deprecated
    public void setFilters(FilterProvider filterProvider) {
        this._serializationConfig = this._serializationConfig.withFilters(filterProvider);
    }

    public ObjectMapper setFilterProvider(FilterProvider filterProvider) {
        this._serializationConfig = this._serializationConfig.withFilters(filterProvider);
        return this;
    }

    public ObjectMapper setBase64Variant(Base64Variant v) {
        this._serializationConfig = this._serializationConfig.with(v);
        this._deserializationConfig = this._deserializationConfig.with(v);
        return this;
    }

    public ObjectMapper setConfig(SerializationConfig config) {
        _assertNotNull("config", config);
        this._serializationConfig = config;
        return this;
    }

    public JsonFactory tokenStreamFactory() {
        return this._jsonFactory;
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public JsonFactory getFactory() {
        return this._jsonFactory;
    }

    public ObjectMapper setDateFormat(DateFormat dateFormat) {
        this._deserializationConfig = this._deserializationConfig.with(dateFormat);
        this._serializationConfig = this._serializationConfig.with(dateFormat);
        return this;
    }

    public DateFormat getDateFormat() {
        return this._serializationConfig.getDateFormat();
    }

    public Object setHandlerInstantiator(HandlerInstantiator hi) {
        this._deserializationConfig = this._deserializationConfig.with(hi);
        this._serializationConfig = this._serializationConfig.with(hi);
        return this;
    }

    public ObjectMapper setInjectableValues(InjectableValues injectableValues) {
        this._injectableValues = injectableValues;
        return this;
    }

    public InjectableValues getInjectableValues() {
        return this._injectableValues;
    }

    public ObjectMapper setLocale(Locale l) {
        this._deserializationConfig = this._deserializationConfig.with(l);
        this._serializationConfig = this._serializationConfig.with(l);
        return this;
    }

    public ObjectMapper setTimeZone(TimeZone tz) {
        this._deserializationConfig = this._deserializationConfig.with(tz);
        this._serializationConfig = this._serializationConfig.with(tz);
        return this;
    }

    public ObjectMapper setDefaultAttributes(ContextAttributes attrs) {
        this._deserializationConfig = this._deserializationConfig.with(attrs);
        this._serializationConfig = this._serializationConfig.with(attrs);
        return this;
    }

    public boolean isEnabled(MapperFeature f) {
        return this._serializationConfig.isEnabled(f);
    }

    @Deprecated
    public ObjectMapper configure(MapperFeature f, boolean state) {
        this._serializationConfig = state ? this._serializationConfig.with(f) : this._serializationConfig.without(f);
        this._deserializationConfig = state ? this._deserializationConfig.with(f) : this._deserializationConfig.without(f);
        return this;
    }

    @Deprecated
    public ObjectMapper enable(MapperFeature... f) {
        this._deserializationConfig = this._deserializationConfig.with(f);
        this._serializationConfig = this._serializationConfig.with(f);
        return this;
    }

    @Deprecated
    public ObjectMapper disable(MapperFeature... f) {
        this._deserializationConfig = this._deserializationConfig.without(f);
        this._serializationConfig = this._serializationConfig.without(f);
        return this;
    }

    public boolean isEnabled(SerializationFeature f) {
        return this._serializationConfig.isEnabled(f);
    }

    public ObjectMapper configure(SerializationFeature f, boolean state) {
        this._serializationConfig = state ? this._serializationConfig.with(f) : this._serializationConfig.without(f);
        return this;
    }

    public ObjectMapper enable(SerializationFeature f) {
        this._serializationConfig = this._serializationConfig.with(f);
        return this;
    }

    public ObjectMapper enable(SerializationFeature first, SerializationFeature... f) {
        this._serializationConfig = this._serializationConfig.with(first, f);
        return this;
    }

    public ObjectMapper disable(SerializationFeature f) {
        this._serializationConfig = this._serializationConfig.without(f);
        return this;
    }

    public ObjectMapper disable(SerializationFeature first, SerializationFeature... f) {
        this._serializationConfig = this._serializationConfig.without(first, f);
        return this;
    }

    public boolean isEnabled(DeserializationFeature f) {
        return this._deserializationConfig.isEnabled(f);
    }

    public ObjectMapper configure(DeserializationFeature f, boolean state) {
        this._deserializationConfig = state ? this._deserializationConfig.with(f) : this._deserializationConfig.without(f);
        return this;
    }

    public ObjectMapper enable(DeserializationFeature feature) {
        this._deserializationConfig = this._deserializationConfig.with(feature);
        return this;
    }

    public ObjectMapper enable(DeserializationFeature first, DeserializationFeature... f) {
        this._deserializationConfig = this._deserializationConfig.with(first, f);
        return this;
    }

    public ObjectMapper disable(DeserializationFeature feature) {
        this._deserializationConfig = this._deserializationConfig.without(feature);
        return this;
    }

    public ObjectMapper disable(DeserializationFeature first, DeserializationFeature... f) {
        this._deserializationConfig = this._deserializationConfig.without(first, f);
        return this;
    }

    public boolean isEnabled(JsonParser.Feature f) {
        return this._deserializationConfig.isEnabled(f, this._jsonFactory);
    }

    public ObjectMapper configure(JsonParser.Feature f, boolean state) {
        this._jsonFactory.configure(f, state);
        return this;
    }

    public ObjectMapper enable(JsonParser.Feature... features) {
        for (JsonParser.Feature f : features) {
            this._jsonFactory.enable(f);
        }
        return this;
    }

    public ObjectMapper disable(JsonParser.Feature... features) {
        for (JsonParser.Feature f : features) {
            this._jsonFactory.disable(f);
        }
        return this;
    }

    public boolean isEnabled(JsonGenerator.Feature f) {
        return this._serializationConfig.isEnabled(f, this._jsonFactory);
    }

    public ObjectMapper configure(JsonGenerator.Feature f, boolean state) {
        this._jsonFactory.configure(f, state);
        return this;
    }

    public ObjectMapper enable(JsonGenerator.Feature... features) {
        for (JsonGenerator.Feature f : features) {
            this._jsonFactory.enable(f);
        }
        return this;
    }

    public ObjectMapper disable(JsonGenerator.Feature... features) {
        for (JsonGenerator.Feature f : features) {
            this._jsonFactory.disable(f);
        }
        return this;
    }

    public boolean isEnabled(JsonFactory.Feature f) {
        return this._jsonFactory.isEnabled(f);
    }

    public boolean isEnabled(StreamReadFeature f) {
        return isEnabled(f.mappedFeature());
    }

    public boolean isEnabled(StreamWriteFeature f) {
        return isEnabled(f.mappedFeature());
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public <T> T readValue(JsonParser p, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("p", p);
        return (T) _readValue(getDeserializationConfig(), p, this._typeFactory.constructType(valueType));
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public <T> T readValue(JsonParser p, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("p", p);
        return (T) _readValue(getDeserializationConfig(), p, this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public final <T> T readValue(JsonParser p, ResolvedType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("p", p);
        return (T) _readValue(getDeserializationConfig(), p, (JavaType) valueType);
    }

    public <T> T readValue(JsonParser p, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("p", p);
        return (T) _readValue(getDeserializationConfig(), p, valueType);
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.TreeCodec
    public <T extends TreeNode> T readTree(JsonParser p) throws IOException {
        _assertNotNull("p", p);
        DeserializationConfig cfg = getDeserializationConfig();
        if (p.currentToken() == null && p.nextToken() == null) {
            return null;
        }
        JsonNode n = (JsonNode) _readValue(cfg, p, constructType(JsonNode.class));
        if (n == null) {
            n = getNodeFactory().nullNode();
        }
        return n;
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public <T> MappingIterator<T> readValues(JsonParser p, ResolvedType valueType) throws IOException {
        return readValues(p, (JavaType) valueType);
    }

    public <T> MappingIterator<T> readValues(JsonParser p, JavaType valueType) throws IOException {
        _assertNotNull("p", p);
        DeserializationContext ctxt = createDeserializationContext(p, getDeserializationConfig());
        return new MappingIterator<>(valueType, p, ctxt, _findRootDeserializer(ctxt, valueType), false, null);
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public <T> MappingIterator<T> readValues(JsonParser p, Class<T> valueType) throws IOException {
        return readValues(p, this._typeFactory.constructType(valueType));
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public <T> MappingIterator<T> readValues(JsonParser p, TypeReference<T> valueTypeRef) throws IOException {
        return readValues(p, this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public JsonNode readTree(InputStream in) throws IOException {
        _assertNotNull("in", in);
        return _readTreeAndClose(this._jsonFactory.createParser(in));
    }

    public JsonNode readTree(Reader r) throws IOException {
        _assertNotNull("r", r);
        return _readTreeAndClose(this._jsonFactory.createParser(r));
    }

    public JsonNode readTree(String content) throws JsonProcessingException, JsonMappingException {
        _assertNotNull("content", content);
        try {
            return _readTreeAndClose(this._jsonFactory.createParser(content));
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public JsonNode readTree(byte[] content) throws IOException {
        _assertNotNull("content", content);
        return _readTreeAndClose(this._jsonFactory.createParser(content));
    }

    public JsonNode readTree(byte[] content, int offset, int len) throws IOException {
        _assertNotNull("content", content);
        return _readTreeAndClose(this._jsonFactory.createParser(content, offset, len));
    }

    public JsonNode readTree(File file) throws IOException {
        _assertNotNull(Action.FILE_ATTRIBUTE, file);
        return _readTreeAndClose(this._jsonFactory.createParser(file));
    }

    public JsonNode readTree(URL source) throws IOException {
        _assertNotNull("source", source);
        return _readTreeAndClose(this._jsonFactory.createParser(source));
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec
    public void writeValue(JsonGenerator g, Object value) throws IOException, StreamWriteException, DatabindException {
        _assertNotNull("g", g);
        SerializationConfig config = getSerializationConfig();
        if (config.isEnabled(SerializationFeature.INDENT_OUTPUT) && g.getPrettyPrinter() == null) {
            g.setPrettyPrinter(config.constructDefaultPrettyPrinter());
        }
        if (!config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) || !(value instanceof Closeable)) {
            _serializerProvider(config).serializeValue(g, value);
            if (config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                g.flush();
                return;
            }
            return;
        }
        _writeCloseableValue(g, value, config);
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.TreeCodec
    public void writeTree(JsonGenerator g, TreeNode rootNode) throws IOException {
        _assertNotNull("g", g);
        SerializationConfig config = getSerializationConfig();
        _serializerProvider(config).serializeValue(g, rootNode);
        if (config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            g.flush();
        }
    }

    public void writeTree(JsonGenerator g, JsonNode rootNode) throws IOException {
        _assertNotNull("g", g);
        SerializationConfig config = getSerializationConfig();
        _serializerProvider(config).serializeValue(g, rootNode);
        if (config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
            g.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.TreeCodec
    public ObjectNode createObjectNode() {
        return this._deserializationConfig.getNodeFactory().objectNode();
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.TreeCodec
    public ArrayNode createArrayNode() {
        return this._deserializationConfig.getNodeFactory().arrayNode();
    }

    @Override // com.fasterxml.jackson.core.TreeCodec
    public JsonNode missingNode() {
        return this._deserializationConfig.getNodeFactory().missingNode();
    }

    @Override // com.fasterxml.jackson.core.TreeCodec
    public JsonNode nullNode() {
        return this._deserializationConfig.getNodeFactory().nullNode();
    }

    @Override // com.fasterxml.jackson.core.ObjectCodec, com.fasterxml.jackson.core.TreeCodec
    public JsonParser treeAsTokens(TreeNode n) {
        _assertNotNull("n", n);
        return new TreeTraversingParser((JsonNode) n, this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.fasterxml.jackson.core.TreeNode */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.core.ObjectCodec
    public <T> T treeToValue(TreeNode n, Class<T> valueType) throws IllegalArgumentException, JsonProcessingException {
        T t;
        if (n == 0) {
            return null;
        }
        try {
            if (TreeNode.class.isAssignableFrom(valueType) && valueType.isAssignableFrom(n.getClass())) {
                return n;
            }
            if (n.asToken() != JsonToken.VALUE_EMBEDDED_OBJECT || !(n instanceof POJONode) || ((t = (T) ((POJONode) n).getPojo()) != null && !valueType.isInstance(t))) {
                return (T) readValue(treeAsTokens(n), valueType);
            }
            return t;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.fasterxml.jackson.core.TreeNode */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T treeToValue(TreeNode n, JavaType valueType) throws IllegalArgumentException, JsonProcessingException {
        T t;
        if (n == 0) {
            return null;
        }
        try {
            if (valueType.isTypeOrSubTypeOf(TreeNode.class) && valueType.isTypeOrSuperTypeOf(n.getClass())) {
                return n;
            }
            if (n.asToken() != JsonToken.VALUE_EMBEDDED_OBJECT || !(n instanceof POJONode) || ((t = (T) ((POJONode) n).getPojo()) != null && !valueType.isTypeOrSuperTypeOf(t.getClass()))) {
                return (T) readValue(treeAsTokens(n), valueType);
            }
            return t;
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x0078
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public <T extends com.fasterxml.jackson.databind.JsonNode> T valueToTree(java.lang.Object r6) throws java.lang.IllegalArgumentException {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto L_0x000c
            r0 = r5
            com.fasterxml.jackson.databind.node.JsonNodeFactory r0 = r0.getNodeFactory()
            com.fasterxml.jackson.databind.node.NullNode r0 = r0.nullNode()
            return r0
        L_0x000c:
            r0 = r5
            com.fasterxml.jackson.databind.SerializationConfig r0 = r0.getSerializationConfig()
            com.fasterxml.jackson.databind.SerializationFeature r1 = com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE
            com.fasterxml.jackson.databind.SerializationConfig r0 = r0.without(r1)
            r7 = r0
            r0 = r5
            r1 = r7
            com.fasterxml.jackson.databind.ser.DefaultSerializerProvider r0 = r0._serializerProvider(r1)
            r8 = r0
            r0 = r8
            r1 = r5
            com.fasterxml.jackson.databind.util.TokenBuffer r0 = r0.bufferForValueConversion(r1)
            r9 = r0
            r0 = r5
            com.fasterxml.jackson.databind.DeserializationFeature r1 = com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS
            boolean r0 = r0.isEnabled(r1)
            if (r0 == 0) goto L_0x0036
            r0 = r9
            r1 = 1
            com.fasterxml.jackson.databind.util.TokenBuffer r0 = r0.forceUseOfBigDecimal(r1)
            r9 = r0
        L_0x0036:
            r0 = r8
            r1 = r9
            r2 = r6
            r0.serializeValue(r1, r2)     // Catch: IOException -> 0x00a9
            r0 = r9
            com.fasterxml.jackson.core.JsonParser r0 = r0.asParser()     // Catch: IOException -> 0x00a9
            r10 = r0
            r0 = 0
            r11 = r0
            r0 = r5
            r1 = r10
            com.fasterxml.jackson.core.TreeNode r0 = r0.readTree(r1)     // Catch: IOException -> 0x00a9, Throwable -> 0x0078, all -> 0x0081
            com.fasterxml.jackson.databind.JsonNode r0 = (com.fasterxml.jackson.databind.JsonNode) r0     // Catch: IOException -> 0x00a9, Throwable -> 0x0078, all -> 0x0081
            r12 = r0
            r0 = r10
            if (r0 == 0) goto L_0x0075
            r0 = r11
            if (r0 == 0) goto L_0x0070
            r0 = r10
            r0.close()     // Catch: IOException -> 0x00a9, Throwable -> 0x0064
            goto L_0x0075
        L_0x0064:
            r13 = move-exception
            r0 = r11
            r1 = r13
            r0.addSuppressed(r1)     // Catch: IOException -> 0x00a9
            goto L_0x0075
        L_0x0070:
            r0 = r10
            r0.close()     // Catch: IOException -> 0x00a9
        L_0x0075:
            r0 = r12
            return r0
        L_0x0078:
            r12 = move-exception
            r0 = r12
            r11 = r0
            r0 = r12
            throw r0     // Catch: all -> 0x0081, IOException -> 0x00a9
        L_0x0081:
            r14 = move-exception
            r0 = r10
            if (r0 == 0) goto L_0x00a6
            r0 = r11
            if (r0 == 0) goto L_0x00a1
            r0 = r10
            r0.close()     // Catch: Throwable -> 0x0095, IOException -> 0x00a9
            goto L_0x00a6
        L_0x0095:
            r15 = move-exception
            r0 = r11
            r1 = r15
            r0.addSuppressed(r1)     // Catch: IOException -> 0x00a9
            goto L_0x00a6
        L_0x00a1:
            r0 = r10
            r0.close()     // Catch: IOException -> 0x00a9
        L_0x00a6:
            r0 = r14
            throw r0     // Catch: IOException -> 0x00a9
        L_0x00a9:
            r10 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            java.lang.String r2 = r2.getMessage()
            r3 = r10
            r1.<init>(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper.valueToTree(java.lang.Object):com.fasterxml.jackson.databind.JsonNode");
    }

    public boolean canSerialize(Class<?> type) {
        return _serializerProvider(getSerializationConfig()).hasSerializerFor(type, null);
    }

    public boolean canSerialize(Class<?> type, AtomicReference<Throwable> cause) {
        return _serializerProvider(getSerializationConfig()).hasSerializerFor(type, cause);
    }

    public boolean canDeserialize(JavaType type) {
        return createDeserializationContext(null, getDeserializationConfig()).hasValueDeserializerFor(type, null);
    }

    public boolean canDeserialize(JavaType type, AtomicReference<Throwable> cause) {
        return createDeserializationContext(null, getDeserializationConfig()).hasValueDeserializerFor(type, cause);
    }

    public <T> T readValue(File src, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(File src, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(File src, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), valueType);
    }

    public <T> T readValue(URL src, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(URL src, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(URL src, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), valueType);
    }

    public <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException, JsonMappingException {
        _assertNotNull("content", content);
        return (T) readValue(content, this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonProcessingException, JsonMappingException {
        _assertNotNull("content", content);
        return (T) readValue(content, this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(String content, JavaType valueType) throws JsonProcessingException, JsonMappingException {
        _assertNotNull("content", content);
        try {
            return (T) _readMapAndClose(this._jsonFactory.createParser(content), valueType);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public <T> T readValue(Reader src, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(Reader src, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(Reader src, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), valueType);
    }

    public <T> T readValue(InputStream src, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(InputStream src, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(InputStream src, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), valueType);
    }

    public <T> T readValue(byte[] src, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(byte[] src, int offset, int len, Class<T> valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src, offset, len), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(byte[] src, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(byte[] src, int offset, int len, TypeReference<T> valueTypeRef) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src, offset, len), this._typeFactory.constructType((TypeReference<?>) valueTypeRef));
    }

    public <T> T readValue(byte[] src, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), valueType);
    }

    public <T> T readValue(byte[] src, int offset, int len, JavaType valueType) throws IOException, StreamReadException, DatabindException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src, offset, len), valueType);
    }

    public <T> T readValue(DataInput src, Class<T> valueType) throws IOException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), this._typeFactory.constructType(valueType));
    }

    public <T> T readValue(DataInput src, JavaType valueType) throws IOException {
        _assertNotNull("src", src);
        return (T) _readMapAndClose(this._jsonFactory.createParser(src), valueType);
    }

    public void writeValue(File resultFile, Object value) throws IOException, StreamWriteException, DatabindException {
        _writeValueAndClose(createGenerator(resultFile, JsonEncoding.UTF8), value);
    }

    public void writeValue(OutputStream out, Object value) throws IOException, StreamWriteException, DatabindException {
        _writeValueAndClose(createGenerator(out, JsonEncoding.UTF8), value);
    }

    public void writeValue(DataOutput out, Object value) throws IOException {
        _writeValueAndClose(createGenerator(out), value);
    }

    public void writeValue(Writer w, Object value) throws IOException, StreamWriteException, DatabindException {
        _writeValueAndClose(createGenerator(w), value);
    }

    public String writeValueAsString(Object value) throws JsonProcessingException {
        SegmentedStringWriter sw = new SegmentedStringWriter(this._jsonFactory._getBufferRecycler());
        try {
            _writeValueAndClose(createGenerator(sw), value);
            return sw.getAndClear();
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x004d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public byte[] writeValueAsBytes(java.lang.Object r6) throws com.fasterxml.jackson.core.JsonProcessingException {
        /*
            r5 = this;
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = new com.fasterxml.jackson.core.util.ByteArrayBuilder     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
            r1 = r0
            r2 = r5
            com.fasterxml.jackson.core.JsonFactory r2 = r2._jsonFactory     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
            com.fasterxml.jackson.core.util.BufferRecycler r2 = r2._getBufferRecycler()     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
            r1.<init>(r2)     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r5
            r1 = r5
            r2 = r7
            com.fasterxml.jackson.core.JsonEncoding r3 = com.fasterxml.jackson.core.JsonEncoding.UTF8     // Catch: Throwable -> 0x004d, all -> 0x0055, JsonProcessingException -> 0x0078, IOException -> 0x007b
            com.fasterxml.jackson.core.JsonGenerator r1 = r1.createGenerator(r2, r3)     // Catch: Throwable -> 0x004d, all -> 0x0055, JsonProcessingException -> 0x0078, IOException -> 0x007b
            r2 = r6
            r0._writeValueAndClose(r1, r2)     // Catch: Throwable -> 0x004d, all -> 0x0055, JsonProcessingException -> 0x0078, IOException -> 0x007b
            r0 = r7
            byte[] r0 = r0.toByteArray()     // Catch: Throwable -> 0x004d, all -> 0x0055, JsonProcessingException -> 0x0078, IOException -> 0x007b
            r9 = r0
            r0 = r7
            r0.release()     // Catch: Throwable -> 0x004d, all -> 0x0055, JsonProcessingException -> 0x0078, IOException -> 0x007b
            r0 = r9
            r10 = r0
            r0 = r7
            if (r0 == 0) goto L_0x004a
            r0 = r8
            if (r0 == 0) goto L_0x0046
            r0 = r7
            r0.close()     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b, Throwable -> 0x003b
            goto L_0x004a
        L_0x003b:
            r11 = move-exception
            r0 = r8
            r1 = r11
            r0.addSuppressed(r1)     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
            goto L_0x004a
        L_0x0046:
            r0 = r7
            r0.close()     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
        L_0x004a:
            r0 = r10
            return r0
        L_0x004d:
            r9 = move-exception
            r0 = r9
            r8 = r0
            r0 = r9
            throw r0     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b, all -> 0x0055
        L_0x0055:
            r12 = move-exception
            r0 = r7
            if (r0 == 0) goto L_0x0075
            r0 = r8
            if (r0 == 0) goto L_0x0071
            r0 = r7
            r0.close()     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b, Throwable -> 0x0066
            goto L_0x0075
        L_0x0066:
            r13 = move-exception
            r0 = r8
            r1 = r13
            r0.addSuppressed(r1)     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
            goto L_0x0075
        L_0x0071:
            r0 = r7
            r0.close()     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
        L_0x0075:
            r0 = r12
            throw r0     // Catch: JsonProcessingException -> 0x0078, IOException -> 0x007b
        L_0x0078:
            r7 = move-exception
            r0 = r7
            throw r0
        L_0x007b:
            r7 = move-exception
            r0 = r7
            com.fasterxml.jackson.databind.JsonMappingException r0 = com.fasterxml.jackson.databind.JsonMappingException.fromUnexpectedIOE(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ObjectMapper.writeValueAsBytes(java.lang.Object):byte[]");
    }

    public ObjectWriter writer() {
        return _newWriter(getSerializationConfig());
    }

    public ObjectWriter writer(SerializationFeature feature) {
        return _newWriter(getSerializationConfig().with(feature));
    }

    public ObjectWriter writer(SerializationFeature first, SerializationFeature... other) {
        return _newWriter(getSerializationConfig().with(first, other));
    }

    public ObjectWriter writer(DateFormat df) {
        return _newWriter(getSerializationConfig().with(df));
    }

    public ObjectWriter writerWithView(Class<?> serializationView) {
        return _newWriter(getSerializationConfig().withView(serializationView));
    }

    public ObjectWriter writerFor(Class<?> rootType) {
        return _newWriter(getSerializationConfig(), rootType == null ? null : this._typeFactory.constructType(rootType), null);
    }

    public ObjectWriter writerFor(TypeReference<?> rootType) {
        return _newWriter(getSerializationConfig(), rootType == null ? null : this._typeFactory.constructType(rootType), null);
    }

    public ObjectWriter writerFor(JavaType rootType) {
        return _newWriter(getSerializationConfig(), rootType, null);
    }

    public ObjectWriter writer(PrettyPrinter pp) {
        if (pp == null) {
            pp = ObjectWriter.NULL_PRETTY_PRINTER;
        }
        return _newWriter(getSerializationConfig(), null, pp);
    }

    public ObjectWriter writerWithDefaultPrettyPrinter() {
        SerializationConfig config = getSerializationConfig();
        return _newWriter(config, null, config.getDefaultPrettyPrinter());
    }

    public ObjectWriter writer(FilterProvider filterProvider) {
        return _newWriter(getSerializationConfig().withFilters(filterProvider));
    }

    public ObjectWriter writer(FormatSchema schema) {
        _verifySchemaType(schema);
        return _newWriter(getSerializationConfig(), schema);
    }

    public ObjectWriter writer(Base64Variant defaultBase64) {
        return _newWriter(getSerializationConfig().with(defaultBase64));
    }

    public ObjectWriter writer(CharacterEscapes escapes) {
        return _newWriter(getSerializationConfig()).with(escapes);
    }

    public ObjectWriter writer(ContextAttributes attrs) {
        return _newWriter(getSerializationConfig().with(attrs));
    }

    @Deprecated
    public ObjectWriter writerWithType(Class<?> rootType) {
        return _newWriter(getSerializationConfig(), rootType == null ? null : this._typeFactory.constructType(rootType), null);
    }

    @Deprecated
    public ObjectWriter writerWithType(TypeReference<?> rootType) {
        return _newWriter(getSerializationConfig(), rootType == null ? null : this._typeFactory.constructType(rootType), null);
    }

    @Deprecated
    public ObjectWriter writerWithType(JavaType rootType) {
        return _newWriter(getSerializationConfig(), rootType, null);
    }

    public ObjectReader reader() {
        return _newReader(getDeserializationConfig()).with(this._injectableValues);
    }

    public ObjectReader reader(DeserializationFeature feature) {
        return _newReader(getDeserializationConfig().with(feature));
    }

    public ObjectReader reader(DeserializationFeature first, DeserializationFeature... other) {
        return _newReader(getDeserializationConfig().with(first, other));
    }

    public ObjectReader readerForUpdating(Object valueToUpdate) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType(valueToUpdate.getClass()), valueToUpdate, null, this._injectableValues);
    }

    public ObjectReader readerFor(JavaType type) {
        return _newReader(getDeserializationConfig(), type, null, null, this._injectableValues);
    }

    public ObjectReader readerFor(Class<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType(type), null, null, this._injectableValues);
    }

    public ObjectReader readerFor(TypeReference<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType(type), null, null, this._injectableValues);
    }

    public ObjectReader readerForArrayOf(Class<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructArrayType(type), null, null, this._injectableValues);
    }

    public ObjectReader readerForListOf(Class<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructCollectionType(List.class, type), null, null, this._injectableValues);
    }

    public ObjectReader readerForMapOf(Class<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructMapType(Map.class, String.class, type), null, null, this._injectableValues);
    }

    public ObjectReader reader(JsonNodeFactory f) {
        return _newReader(getDeserializationConfig()).with(f);
    }

    public ObjectReader reader(FormatSchema schema) {
        _verifySchemaType(schema);
        return _newReader(getDeserializationConfig(), null, null, schema, this._injectableValues);
    }

    public ObjectReader reader(InjectableValues injectableValues) {
        return _newReader(getDeserializationConfig(), null, null, null, injectableValues);
    }

    public ObjectReader readerWithView(Class<?> view) {
        return _newReader(getDeserializationConfig().withView(view));
    }

    public ObjectReader reader(Base64Variant defaultBase64) {
        return _newReader(getDeserializationConfig().with(defaultBase64));
    }

    public ObjectReader reader(ContextAttributes attrs) {
        return _newReader(getDeserializationConfig().with(attrs));
    }

    @Deprecated
    public ObjectReader reader(JavaType type) {
        return _newReader(getDeserializationConfig(), type, null, null, this._injectableValues);
    }

    @Deprecated
    public ObjectReader reader(Class<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType(type), null, null, this._injectableValues);
    }

    @Deprecated
    public ObjectReader reader(TypeReference<?> type) {
        return _newReader(getDeserializationConfig(), this._typeFactory.constructType(type), null, null, this._injectableValues);
    }

    public <T> T convertValue(Object fromValue, Class<T> toValueType) throws IllegalArgumentException {
        return (T) _convert(fromValue, this._typeFactory.constructType(toValueType));
    }

    public <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) throws IllegalArgumentException {
        return (T) _convert(fromValue, this._typeFactory.constructType((TypeReference<?>) toValueTypeRef));
    }

    public <T> T convertValue(Object fromValue, JavaType toValueType) throws IllegalArgumentException {
        return (T) _convert(fromValue, toValueType);
    }

    protected Object _convert(Object fromValue, JavaType toValueType) throws IllegalArgumentException {
        Object result;
        DefaultSerializerProvider context = _serializerProvider(getSerializationConfig().without(SerializationFeature.WRAP_ROOT_VALUE));
        TokenBuffer buf = context.bufferForValueConversion(this);
        if (isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            buf = buf.forceUseOfBigDecimal(true);
        }
        try {
            context.serializeValue(buf, fromValue);
            JsonParser p = buf.asParser();
            DeserializationConfig deserConfig = getDeserializationConfig();
            JsonToken t = _initForReading(p, toValueType);
            if (t == JsonToken.VALUE_NULL) {
                DeserializationContext ctxt = createDeserializationContext(p, deserConfig);
                result = _findRootDeserializer(ctxt, toValueType).getNullValue(ctxt);
            } else if (t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) {
                result = null;
            } else {
                DeserializationContext ctxt2 = createDeserializationContext(p, deserConfig);
                result = _findRootDeserializer(ctxt2, toValueType).deserialize(p, ctxt2);
            }
            p.close();
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public <T> T updateValue(T valueToUpdate, Object overrides) throws JsonMappingException {
        T result = valueToUpdate;
        if (!(valueToUpdate == null || overrides == null)) {
            DefaultSerializerProvider context = _serializerProvider(getSerializationConfig().without(SerializationFeature.WRAP_ROOT_VALUE));
            TokenBuffer buf = context.bufferForValueConversion(this);
            if (isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                buf = buf.forceUseOfBigDecimal(true);
            }
            try {
                context.serializeValue(buf, overrides);
                JsonParser p = buf.asParser();
                result = (T) readerForUpdating(valueToUpdate).readValue(p);
                p.close();
            } catch (IOException e) {
                if (e instanceof JsonMappingException) {
                    throw ((JsonMappingException) e);
                }
                throw JsonMappingException.fromUnexpectedIOE(e);
            }
        }
        return result;
    }

    @Deprecated
    public JsonSchema generateJsonSchema(Class<?> t) throws JsonMappingException {
        return _serializerProvider(getSerializationConfig()).generateJsonSchema(t);
    }

    public void acceptJsonFormatVisitor(Class<?> type, JsonFormatVisitorWrapper visitor) throws JsonMappingException {
        acceptJsonFormatVisitor(this._typeFactory.constructType(type), visitor);
    }

    public void acceptJsonFormatVisitor(JavaType type, JsonFormatVisitorWrapper visitor) throws JsonMappingException {
        if (type == null) {
            throw new IllegalArgumentException("type must be provided");
        }
        _serializerProvider(getSerializationConfig()).acceptJsonFormatVisitor(type, visitor);
    }

    protected TypeResolverBuilder<?> _constructDefaultTypeResolverBuilder(DefaultTyping applicability, PolymorphicTypeValidator ptv) {
        return DefaultTypeResolverBuilder.construct(applicability, ptv);
    }

    protected DefaultSerializerProvider _serializerProvider(SerializationConfig config) {
        return this._serializerProvider.createInstance(config, this._serializerFactory);
    }

    protected final void _writeValueAndClose(JsonGenerator g, Object value) throws IOException {
        SerializationConfig cfg = getSerializationConfig();
        if (!cfg.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) || !(value instanceof Closeable)) {
            try {
                _serializerProvider(cfg).serializeValue(g, value);
                g.close();
            } catch (Exception e) {
                ClassUtil.closeOnFailAndThrowAsIOE(g, e);
            }
        } else {
            _writeCloseable(g, value, cfg);
        }
    }

    private final void _writeCloseable(JsonGenerator g, Object value, SerializationConfig cfg) throws IOException {
        Closeable toClose = (Closeable) value;
        try {
            _serializerProvider(cfg).serializeValue(g, value);
            toClose = null;
            toClose.close();
            g.close();
        } catch (Exception e) {
            ClassUtil.closeOnFailAndThrowAsIOE(g, toClose, e);
        }
    }

    private final void _writeCloseableValue(JsonGenerator g, Object value, SerializationConfig cfg) throws IOException {
        Closeable toClose = (Closeable) value;
        try {
            _serializerProvider(cfg).serializeValue(g, value);
            if (cfg.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                g.flush();
            }
            toClose.close();
        } catch (Exception e) {
            ClassUtil.closeOnFailAndThrowAsIOE(null, toClose, e);
        }
    }

    @Deprecated
    protected final void _configAndWriteValue(JsonGenerator g, Object value) throws IOException {
        getSerializationConfig().initialize(g);
        _writeValueAndClose(g, value);
    }

    protected Object _readValue(DeserializationConfig cfg, JsonParser p, JavaType valueType) throws IOException {
        Object result;
        JsonToken t = _initForReading(p, valueType);
        DefaultDeserializationContext ctxt = createDeserializationContext(p, cfg);
        if (t == JsonToken.VALUE_NULL) {
            result = _findRootDeserializer(ctxt, valueType).getNullValue(ctxt);
        } else if (t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) {
            result = null;
        } else {
            result = ctxt.readRootValue(p, valueType, _findRootDeserializer(ctxt, valueType), null);
        }
        p.clearCurrentToken();
        if (cfg.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
            _verifyNoTrailingTokens(p, ctxt, valueType);
        }
        return result;
    }

    protected Object _readMapAndClose(JsonParser p0, JavaType valueType) throws IOException {
        Object result;
        Throwable th = null;
        try {
            DeserializationConfig cfg = getDeserializationConfig();
            DefaultDeserializationContext ctxt = createDeserializationContext(p0, cfg);
            JsonToken t = _initForReading(p0, valueType);
            if (t == JsonToken.VALUE_NULL) {
                result = _findRootDeserializer(ctxt, valueType).getNullValue(ctxt);
            } else if (t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) {
                result = null;
            } else {
                result = ctxt.readRootValue(p0, valueType, _findRootDeserializer(ctxt, valueType), null);
                ctxt.checkUnresolvedObjectId();
            }
            if (cfg.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
                _verifyNoTrailingTokens(p0, ctxt, valueType);
            }
            return result;
        } finally {
            if (p0 != null) {
                if (0 != 0) {
                    try {
                        p0.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    p0.close();
                }
            }
        }
    }

    protected JsonNode _readTreeAndClose(JsonParser p0) throws IOException {
        JsonNode resultNode;
        Throwable th = null;
        try {
            JavaType valueType = constructType(JsonNode.class);
            DeserializationConfig cfg = getDeserializationConfig();
            cfg.initialize(p0);
            JsonToken t = p0.currentToken();
            if (t == null) {
                t = p0.nextToken();
                if (t == null) {
                    JsonNode missingNode = cfg.getNodeFactory().missingNode();
                    if (p0 != null) {
                        if (0 != 0) {
                            try {
                                p0.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            p0.close();
                        }
                    }
                    return missingNode;
                }
            }
            DefaultDeserializationContext ctxt = createDeserializationContext(p0, cfg);
            if (t == JsonToken.VALUE_NULL) {
                resultNode = cfg.getNodeFactory().nullNode();
            } else {
                resultNode = (JsonNode) ctxt.readRootValue(p0, valueType, _findRootDeserializer(ctxt, valueType), null);
            }
            if (cfg.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
                _verifyNoTrailingTokens(p0, ctxt, valueType);
            }
            return resultNode;
        } finally {
            if (p0 != null) {
                if (0 != 0) {
                    try {
                        p0.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                } else {
                    p0.close();
                }
            }
        }
    }

    protected DefaultDeserializationContext createDeserializationContext(JsonParser p, DeserializationConfig cfg) {
        return this._deserializationContext.createInstance(cfg, p, this._injectableValues);
    }

    protected JsonToken _initForReading(JsonParser p, JavaType targetType) throws IOException {
        this._deserializationConfig.initialize(p);
        JsonToken t = p.currentToken();
        if (t == null) {
            t = p.nextToken();
            if (t == null) {
                throw MismatchedInputException.from(p, targetType, "No content to map due to end-of-input");
            }
        }
        return t;
    }

    protected final void _verifyNoTrailingTokens(JsonParser p, DeserializationContext ctxt, JavaType bindType) throws IOException {
        JsonToken t = p.nextToken();
        if (t != null) {
            ctxt.reportTrailingTokens(ClassUtil.rawClass(bindType), p, t);
        }
    }

    protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext ctxt, JavaType valueType) throws DatabindException {
        JsonDeserializer<Object> deser = this._rootDeserializers.get(valueType);
        if (deser != null) {
            return deser;
        }
        JsonDeserializer<Object> deser2 = ctxt.findRootValueDeserializer(valueType);
        if (deser2 == null) {
            return (JsonDeserializer) ctxt.reportBadDefinition(valueType, "Cannot find a deserializer for type " + valueType);
        }
        this._rootDeserializers.put(valueType, deser2);
        return deser2;
    }

    protected void _verifySchemaType(FormatSchema schema) {
        if (schema != null && !this._jsonFactory.canUseSchema(schema)) {
            throw new IllegalArgumentException("Cannot use FormatSchema of type " + schema.getClass().getName() + " for format " + this._jsonFactory.getFormatName());
        }
    }

    protected final void _assertNotNull(String paramName, Object src) {
        if (src == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", paramName));
        }
    }
}
