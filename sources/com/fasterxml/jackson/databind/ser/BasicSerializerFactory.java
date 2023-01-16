package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/BasicSerializerFactory.class */
public abstract class BasicSerializerFactory extends SerializerFactory implements Serializable {
    protected static final HashMap<String, JsonSerializer<?>> _concrete;
    protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy;
    protected final SerializerFactoryConfig _factoryConfig;

    public abstract SerializerFactory withConfig(SerializerFactoryConfig serializerFactoryConfig);

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public abstract JsonSerializer<Object> createSerializer(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException;

    protected abstract Iterable<Serializers> customSerializers();

    static {
        HashMap<String, Class<? extends JsonSerializer<?>>> concLazy = new HashMap<>();
        HashMap<String, JsonSerializer<?>> concrete = new HashMap<>();
        concrete.put(String.class.getName(), new StringSerializer());
        ToStringSerializer sls = ToStringSerializer.instance;
        concrete.put(StringBuffer.class.getName(), sls);
        concrete.put(StringBuilder.class.getName(), sls);
        concrete.put(Character.class.getName(), sls);
        concrete.put(Character.TYPE.getName(), sls);
        NumberSerializers.addAll(concrete);
        concrete.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        concrete.put(Boolean.class.getName(), new BooleanSerializer(false));
        concrete.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        concrete.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
        concrete.put(Date.class.getName(), DateSerializer.instance);
        for (Map.Entry<Class<?>, Object> en : StdJdkSerializers.all()) {
            Object value = en.getValue();
            if (value instanceof JsonSerializer) {
                concrete.put(en.getKey().getName(), (JsonSerializer) value);
            } else {
                concLazy.put(en.getKey().getName(), (Class) value);
            }
        }
        concLazy.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
        _concrete = concrete;
        _concreteLazy = concLazy;
    }

    /* access modifiers changed from: protected */
    public BasicSerializerFactory(SerializerFactoryConfig config) {
        this._factoryConfig = config == null ? new SerializerFactoryConfig() : config;
    }

    public SerializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public final SerializerFactory withAdditionalSerializers(Serializers additional) {
        return withConfig(this._factoryConfig.withAdditionalSerializers(additional));
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public final SerializerFactory withAdditionalKeySerializers(Serializers additional) {
        return withConfig(this._factoryConfig.withAdditionalKeySerializers(additional));
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public final SerializerFactory withSerializerModifier(BeanSerializerModifier modifier) {
        return withConfig(this._factoryConfig.withSerializerModifier(modifier));
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public JsonSerializer<Object> createKeySerializer(SerializerProvider ctxt, JavaType keyType, JsonSerializer<Object> defaultImpl) throws JsonMappingException {
        SerializationConfig config = ctxt.getConfig();
        BeanDescription beanDesc = config.introspect(keyType);
        JsonSerializer<?> ser = null;
        if (this._factoryConfig.hasKeySerializers()) {
            for (Serializers serializers : this._factoryConfig.keySerializers()) {
                ser = serializers.findSerializer(config, keyType, beanDesc);
                if (ser != null) {
                    break;
                }
            }
        }
        if (ser == null) {
            ser = _findKeySerializer(ctxt, beanDesc.getClassInfo());
            if (ser == null) {
                ser = defaultImpl;
                if (ser == null) {
                    ser = StdKeySerializers.getStdKeySerializer(config, keyType.getRawClass(), false);
                    if (ser == null) {
                        AnnotatedMember acc = beanDesc.findJsonKeyAccessor();
                        if (acc == null) {
                            acc = beanDesc.findJsonValueAccessor();
                        }
                        if (acc != null) {
                            JsonSerializer<?> delegate = createKeySerializer(ctxt, acc.getType(), defaultImpl);
                            if (config.canOverrideAccessModifiers()) {
                                ClassUtil.checkAndFixAccess(acc.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            ser = new JsonValueSerializer(acc, null, delegate);
                        } else {
                            ser = StdKeySerializers.getFallbackKeySerializer(config, keyType.getRawClass());
                        }
                    }
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifyKeySerializer(config, keyType, beanDesc, ser);
            }
        }
        return ser;
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    @Deprecated
    public JsonSerializer<Object> createKeySerializer(SerializationConfig config, JavaType keyType, JsonSerializer<Object> defaultImpl) {
        BeanDescription beanDesc = config.introspect(keyType);
        JsonSerializer<?> ser = null;
        if (this._factoryConfig.hasKeySerializers()) {
            for (Serializers serializers : this._factoryConfig.keySerializers()) {
                ser = serializers.findSerializer(config, keyType, beanDesc);
                if (ser != null) {
                    break;
                }
            }
        }
        if (ser == null) {
            ser = defaultImpl;
            if (ser == null) {
                ser = StdKeySerializers.getStdKeySerializer(config, keyType.getRawClass(), false);
                if (ser == null) {
                    ser = StdKeySerializers.getFallbackKeySerializer(config, keyType.getRawClass());
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifyKeySerializer(config, keyType, beanDesc, ser);
            }
        }
        return ser;
    }

    @Override // com.fasterxml.jackson.databind.ser.SerializerFactory
    public TypeSerializer createTypeSerializer(SerializationConfig config, JavaType baseType) {
        AnnotatedClass ac = config.introspectClassAnnotations(baseType.getRawClass()).getClassInfo();
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findTypeResolver(config, ac, baseType);
        Collection<NamedType> subtypes = null;
        if (b == null) {
            b = config.getDefaultTyper(baseType);
        } else {
            subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, ac);
        }
        if (b == null) {
            return null;
        }
        return b.buildTypeSerializer(config, baseType, subtypes);
    }

    protected final JsonSerializer<?> findSerializerByLookup(JavaType type, SerializationConfig config, BeanDescription beanDesc, boolean staticTyping) {
        Class<? extends JsonSerializer<?>> serClass;
        String clsName = type.getRawClass().getName();
        JsonSerializer<?> ser = _concrete.get(clsName);
        if (ser != null || (serClass = _concreteLazy.get(clsName)) == null) {
            return ser;
        }
        return (JsonSerializer) ClassUtil.createInstance(serClass, false);
    }

    protected final JsonSerializer<?> findSerializerByAnnotations(SerializerProvider prov, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        if (JsonSerializable.class.isAssignableFrom(type.getRawClass())) {
            return SerializableSerializer.instance;
        }
        AnnotatedMember valueAccessor = beanDesc.findJsonValueAccessor();
        if (valueAccessor == null) {
            return null;
        }
        if (prov.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(valueAccessor.getMember(), prov.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        JavaType valueType = valueAccessor.getType();
        JsonSerializer<Object> valueSerializer = findSerializerFromAnnotation(prov, valueAccessor);
        if (valueSerializer == null) {
            valueSerializer = (JsonSerializer) valueType.getValueHandler();
        }
        TypeSerializer typeSerializer = (TypeSerializer) valueType.getTypeHandler();
        if (typeSerializer == null) {
            typeSerializer = createTypeSerializer(prov.getConfig(), valueType);
        }
        return new JsonValueSerializer(valueAccessor, typeSerializer, valueSerializer);
    }

    protected final JsonSerializer<?> findSerializerByPrimaryType(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        if (type.isEnumType()) {
            return buildEnumSerializer(prov.getConfig(), type, beanDesc);
        }
        Class<?> raw = type.getRawClass();
        JsonSerializer<?> ser = findOptionalStdSerializer(prov, type, beanDesc, staticTyping);
        if (ser != null) {
            return ser;
        }
        if (Calendar.class.isAssignableFrom(raw)) {
            return CalendarSerializer.instance;
        }
        if (Date.class.isAssignableFrom(raw)) {
            return DateSerializer.instance;
        }
        if (Map.Entry.class.isAssignableFrom(raw)) {
            JavaType mapEntryType = type.findSuperType(Map.Entry.class);
            return buildMapEntrySerializer(prov, type, beanDesc, staticTyping, mapEntryType.containedTypeOrUnknown(0), mapEntryType.containedTypeOrUnknown(1));
        } else if (ByteBuffer.class.isAssignableFrom(raw)) {
            return new ByteBufferSerializer();
        } else {
            if (InetAddress.class.isAssignableFrom(raw)) {
                return new InetAddressSerializer();
            }
            if (InetSocketAddress.class.isAssignableFrom(raw)) {
                return new InetSocketAddressSerializer();
            }
            if (TimeZone.class.isAssignableFrom(raw)) {
                return new TimeZoneSerializer();
            }
            if (Charset.class.isAssignableFrom(raw)) {
                return ToStringSerializer.instance;
            }
            if (Number.class.isAssignableFrom(raw)) {
                beanDesc.findExpectedFormat(null);
                switch (format.getShape()) {
                    case STRING:
                        return ToStringSerializer.instance;
                    case OBJECT:
                    case ARRAY:
                        return null;
                    default:
                        return NumberSerializer.instance;
                }
            } else if (ClassLoader.class.isAssignableFrom(raw)) {
                return new ToEmptyObjectSerializer(type);
            } else {
                return null;
            }
        }
    }

    protected JsonSerializer<?> findOptionalStdSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findSerializer(prov.getConfig(), type, beanDesc);
    }

    protected final JsonSerializer<?> findSerializerByAddonType(SerializationConfig config, JavaType javaType, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        Class<?> rawType = javaType.getRawClass();
        if (Iterator.class.isAssignableFrom(rawType)) {
            JavaType[] params = config.getTypeFactory().findTypeParameters(javaType, Iterator.class);
            return buildIteratorSerializer(config, javaType, beanDesc, staticTyping, (params == null || params.length != 1) ? TypeFactory.unknownType() : params[0]);
        } else if (Iterable.class.isAssignableFrom(rawType)) {
            JavaType[] params2 = config.getTypeFactory().findTypeParameters(javaType, Iterable.class);
            return buildIterableSerializer(config, javaType, beanDesc, staticTyping, (params2 == null || params2.length != 1) ? TypeFactory.unknownType() : params2[0]);
        } else if (CharSequence.class.isAssignableFrom(rawType)) {
            return ToStringSerializer.instance;
        } else {
            return null;
        }
    }

    protected JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object serDef = prov.getAnnotationIntrospector().findSerializer(a);
        if (serDef == null) {
            return null;
        }
        return findConvertingSerializer(prov, a, prov.serializerInstance(a, serDef));
    }

    protected JsonSerializer<?> findConvertingSerializer(SerializerProvider prov, Annotated a, JsonSerializer<?> ser) throws JsonMappingException {
        Converter<Object, Object> conv = findConverter(prov, a);
        if (conv == null) {
            return ser;
        }
        return new StdDelegatingSerializer(conv, conv.getOutputType(prov.getTypeFactory()), ser);
    }

    protected Converter<Object, Object> findConverter(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object convDef = prov.getAnnotationIntrospector().findSerializationConverter(a);
        if (convDef == null) {
            return null;
        }
        return prov.converterInstance(a, convDef);
    }

    protected JsonSerializer<?> buildContainerSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        SerializationConfig config = prov.getConfig();
        if (!staticTyping && type.useStaticType() && (!type.isContainerType() || !type.getContentType().isJavaLangObject())) {
            staticTyping = true;
        }
        TypeSerializer elementTypeSerializer = createTypeSerializer(config, type.getContentType());
        if (elementTypeSerializer != null) {
            staticTyping = false;
        }
        JsonSerializer<Object> elementValueSerializer = _findContentSerializer(prov, beanDesc.getClassInfo());
        if (type.isMapLikeType()) {
            MapLikeType mlt = (MapLikeType) type;
            JsonSerializer<Object> keySerializer = _findKeySerializer(prov, beanDesc.getClassInfo());
            if (mlt instanceof MapType) {
                return buildMapSerializer(prov, (MapType) mlt, beanDesc, staticTyping, keySerializer, elementTypeSerializer, elementValueSerializer);
            }
            JsonSerializer<?> ser = null;
            MapLikeType mlType = (MapLikeType) type;
            for (Serializers serializers : customSerializers()) {
                ser = serializers.findMapLikeSerializer(config, mlType, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
                if (ser != null) {
                    break;
                }
            }
            if (ser == null) {
                ser = findSerializerByAnnotations(prov, type, beanDesc);
            }
            if (ser != null && this._factoryConfig.hasSerializerModifiers()) {
                for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                    ser = mod.modifyMapLikeSerializer(config, mlType, beanDesc, ser);
                }
            }
            return ser;
        } else if (type.isCollectionLikeType()) {
            CollectionLikeType clt = (CollectionLikeType) type;
            if (clt instanceof CollectionType) {
                return buildCollectionSerializer(prov, (CollectionType) clt, beanDesc, staticTyping, elementTypeSerializer, elementValueSerializer);
            }
            JsonSerializer<?> ser2 = null;
            CollectionLikeType clType = (CollectionLikeType) type;
            for (Serializers serializers2 : customSerializers()) {
                ser2 = serializers2.findCollectionLikeSerializer(config, clType, beanDesc, elementTypeSerializer, elementValueSerializer);
                if (ser2 != null) {
                    break;
                }
            }
            if (ser2 == null) {
                ser2 = findSerializerByAnnotations(prov, type, beanDesc);
            }
            if (ser2 != null && this._factoryConfig.hasSerializerModifiers()) {
                for (BeanSerializerModifier mod2 : this._factoryConfig.serializerModifiers()) {
                    ser2 = mod2.modifyCollectionLikeSerializer(config, clType, beanDesc, ser2);
                }
            }
            return ser2;
        } else if (type.isArrayType()) {
            return buildArraySerializer(prov, (ArrayType) type, beanDesc, staticTyping, elementTypeSerializer, elementValueSerializer);
        } else {
            return null;
        }
    }

    protected JsonSerializer<?> buildCollectionSerializer(SerializerProvider prov, CollectionType type, BeanDescription beanDesc, boolean staticTyping, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) throws JsonMappingException {
        SerializationConfig config = prov.getConfig();
        JsonSerializer<?> ser = null;
        for (Serializers serializers : customSerializers()) {
            ser = serializers.findCollectionSerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
            if (ser != null) {
                break;
            }
        }
        if (ser == null) {
            ser = findSerializerByAnnotations(prov, type, beanDesc);
            if (ser == null) {
                if (beanDesc.findExpectedFormat(null).getShape() == JsonFormat.Shape.OBJECT) {
                    return null;
                }
                Class<?> raw = type.getRawClass();
                if (EnumSet.class.isAssignableFrom(raw)) {
                    JavaType enumType = type.getContentType();
                    if (!enumType.isEnumImplType()) {
                        enumType = null;
                    }
                    ser = buildEnumSetSerializer(enumType);
                } else {
                    Class<?> elementRaw = type.getContentType().getRawClass();
                    if (isIndexedList(raw)) {
                        if (elementRaw != String.class) {
                            ser = buildIndexedListSerializer(type.getContentType(), staticTyping, elementTypeSerializer, elementValueSerializer);
                        } else if (ClassUtil.isJacksonStdImpl(elementValueSerializer)) {
                            ser = IndexedStringListSerializer.instance;
                        }
                    } else if (elementRaw == String.class && ClassUtil.isJacksonStdImpl(elementValueSerializer)) {
                        ser = StringCollectionSerializer.instance;
                    }
                    if (ser == null) {
                        ser = buildCollectionSerializer(type.getContentType(), staticTyping, elementTypeSerializer, elementValueSerializer);
                    }
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifyCollectionSerializer(config, type, beanDesc, ser);
            }
        }
        return ser;
    }

    protected boolean isIndexedList(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    public ContainerSerializer<?> buildIndexedListSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer) {
        return new IndexedListSerializer(elemType, staticTyping, vts, valueSerializer);
    }

    public ContainerSerializer<?> buildCollectionSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer) {
        return new CollectionSerializer(elemType, staticTyping, vts, valueSerializer);
    }

    public JsonSerializer<?> buildEnumSetSerializer(JavaType enumType) {
        return new EnumSetSerializer(enumType);
    }

    protected JsonSerializer<?> buildMapSerializer(SerializerProvider prov, MapType type, BeanDescription beanDesc, boolean staticTyping, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) throws JsonMappingException {
        if (beanDesc.findExpectedFormat(null).getShape() == JsonFormat.Shape.OBJECT) {
            return null;
        }
        JsonSerializer<?> ser = null;
        SerializationConfig config = prov.getConfig();
        for (Serializers serializers : customSerializers()) {
            ser = serializers.findMapSerializer(config, type, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
            if (ser != null) {
                break;
            }
        }
        if (ser == null) {
            ser = findSerializerByAnnotations(prov, type, beanDesc);
            if (ser == null) {
                Object filterId = findFilterId(config, beanDesc);
                JsonIgnoreProperties.Value ignorals = config.getDefaultPropertyIgnorals(Map.class, beanDesc.getClassInfo());
                Set<String> ignored = ignorals == null ? null : ignorals.findIgnoredForSerialization();
                JsonIncludeProperties.Value inclusions = config.getDefaultPropertyInclusions(Map.class, beanDesc.getClassInfo());
                ser = _checkMapContentInclusion(prov, beanDesc, MapSerializer.construct(ignored, inclusions == null ? null : inclusions.getIncluded(), type, staticTyping, elementTypeSerializer, keySerializer, elementValueSerializer, filterId));
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifyMapSerializer(config, type, beanDesc, ser);
            }
        }
        return ser;
    }

    protected MapSerializer _checkMapContentInclusion(SerializerProvider prov, BeanDescription beanDesc, MapSerializer mapSer) throws JsonMappingException {
        Object valueToSuppress;
        JavaType contentType = mapSer.getContentType();
        JsonInclude.Value inclV = _findInclusionWithContent(prov, beanDesc, contentType, Map.class);
        JsonInclude.Include incl = inclV == null ? JsonInclude.Include.USE_DEFAULTS : inclV.getContentInclusion();
        if (incl != JsonInclude.Include.USE_DEFAULTS && incl != JsonInclude.Include.ALWAYS) {
            boolean suppressNulls = true;
            switch (incl) {
                case NON_DEFAULT:
                    valueToSuppress = BeanUtil.getDefaultValue(contentType);
                    if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                        valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
                        break;
                    }
                    break;
                case NON_ABSENT:
                    valueToSuppress = contentType.isReferenceType() ? MapSerializer.MARKER_FOR_EMPTY : null;
                    break;
                case NON_EMPTY:
                    valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
                    break;
                case CUSTOM:
                    valueToSuppress = prov.includeFilterInstance(null, inclV.getContentFilter());
                    if (valueToSuppress != null) {
                        suppressNulls = prov.includeFilterSuppressNulls(valueToSuppress);
                        break;
                    } else {
                        suppressNulls = true;
                        break;
                    }
                case NON_NULL:
                default:
                    valueToSuppress = null;
                    break;
            }
            return mapSer.withContentInclusion(valueToSuppress, suppressNulls);
        } else if (!prov.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
            return mapSer.withContentInclusion(null, true);
        } else {
            return mapSer;
        }
    }

    protected JsonSerializer<?> buildMapEntrySerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType keyType, JavaType valueType) throws JsonMappingException {
        Object valueToSuppress;
        if (JsonFormat.Value.merge(beanDesc.findExpectedFormat(null), prov.getDefaultPropertyFormat(Map.Entry.class)).getShape() == JsonFormat.Shape.OBJECT) {
            return null;
        }
        MapEntrySerializer ser = new MapEntrySerializer(valueType, keyType, valueType, staticTyping, createTypeSerializer(prov.getConfig(), valueType), null);
        JavaType contentType = ser.getContentType();
        JsonInclude.Value inclV = _findInclusionWithContent(prov, beanDesc, contentType, Map.Entry.class);
        JsonInclude.Include incl = inclV == null ? JsonInclude.Include.USE_DEFAULTS : inclV.getContentInclusion();
        if (incl == JsonInclude.Include.USE_DEFAULTS || incl == JsonInclude.Include.ALWAYS) {
            return ser;
        }
        boolean suppressNulls = true;
        switch (incl) {
            case NON_DEFAULT:
                valueToSuppress = BeanUtil.getDefaultValue(contentType);
                if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                    valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
                    break;
                }
                break;
            case NON_ABSENT:
                valueToSuppress = contentType.isReferenceType() ? MapSerializer.MARKER_FOR_EMPTY : null;
                break;
            case NON_EMPTY:
                valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
                break;
            case CUSTOM:
                valueToSuppress = prov.includeFilterInstance(null, inclV.getContentFilter());
                if (valueToSuppress != null) {
                    suppressNulls = prov.includeFilterSuppressNulls(valueToSuppress);
                    break;
                } else {
                    suppressNulls = true;
                    break;
                }
            case NON_NULL:
            default:
                valueToSuppress = null;
                break;
        }
        return ser.withContentInclusion(valueToSuppress, suppressNulls);
    }

    protected JsonInclude.Value _findInclusionWithContent(SerializerProvider prov, BeanDescription beanDesc, JavaType contentType, Class<?> configType) throws JsonMappingException {
        SerializationConfig config = prov.getConfig();
        JsonInclude.Value inclV = config.getDefaultPropertyInclusion(configType, beanDesc.findPropertyInclusion(config.getDefaultPropertyInclusion()));
        JsonInclude.Value valueIncl = config.getDefaultPropertyInclusion(contentType.getRawClass(), null);
        if (valueIncl != null) {
            switch (valueIncl.getValueInclusion()) {
                case CUSTOM:
                    inclV = inclV.withContentFilter(valueIncl.getContentFilter());
                    break;
                case USE_DEFAULTS:
                    break;
                default:
                    inclV = inclV.withContentInclusion(valueIncl.getValueInclusion());
                    break;
            }
        }
        return inclV;
    }

    protected JsonSerializer<?> buildArraySerializer(SerializerProvider prov, ArrayType type, BeanDescription beanDesc, boolean staticTyping, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer) throws JsonMappingException {
        SerializationConfig config = prov.getConfig();
        JsonSerializer<?> ser = null;
        for (Serializers serializers : customSerializers()) {
            ser = serializers.findArraySerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
            if (ser != null) {
                break;
            }
        }
        if (ser == null) {
            Class<?> raw = type.getRawClass();
            if (elementValueSerializer == null || ClassUtil.isJacksonStdImpl(elementValueSerializer)) {
                if (String[].class == raw) {
                    ser = StringArraySerializer.instance;
                } else {
                    ser = StdArraySerializers.findStandardImpl(raw);
                }
            }
            if (ser == null) {
                ser = new ObjectArraySerializer(type.getContentType(), staticTyping, elementTypeSerializer, elementValueSerializer);
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifyArraySerializer(config, type, beanDesc, ser);
            }
        }
        return ser;
    }

    public JsonSerializer<?> findReferenceSerializer(SerializerProvider prov, ReferenceType refType, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        JavaType contentType = refType.getContentType();
        TypeSerializer contentTypeSerializer = (TypeSerializer) contentType.getTypeHandler();
        SerializationConfig config = prov.getConfig();
        if (contentTypeSerializer == null) {
            contentTypeSerializer = createTypeSerializer(config, contentType);
        }
        JsonSerializer<Object> contentSerializer = (JsonSerializer) contentType.getValueHandler();
        for (Serializers serializers : customSerializers()) {
            JsonSerializer<?> ser = serializers.findReferenceSerializer(config, refType, beanDesc, contentTypeSerializer, contentSerializer);
            if (ser != null) {
                return ser;
            }
        }
        if (refType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return buildAtomicReferenceSerializer(prov, refType, beanDesc, staticTyping, contentTypeSerializer, contentSerializer);
        }
        return null;
    }

    protected JsonSerializer<?> buildAtomicReferenceSerializer(SerializerProvider prov, ReferenceType refType, BeanDescription beanDesc, boolean staticTyping, TypeSerializer contentTypeSerializer, JsonSerializer<Object> contentSerializer) throws JsonMappingException {
        boolean suppressNulls;
        Object valueToSuppress;
        JavaType contentType = refType.getReferencedType();
        JsonInclude.Value inclV = _findInclusionWithContent(prov, beanDesc, contentType, AtomicReference.class);
        JsonInclude.Include incl = inclV == null ? JsonInclude.Include.USE_DEFAULTS : inclV.getContentInclusion();
        if (incl != JsonInclude.Include.USE_DEFAULTS && incl != JsonInclude.Include.ALWAYS) {
            suppressNulls = true;
            switch (incl) {
                case NON_DEFAULT:
                    valueToSuppress = BeanUtil.getDefaultValue(contentType);
                    if (valueToSuppress != null && valueToSuppress.getClass().isArray()) {
                        valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress);
                        break;
                    }
                    break;
                case NON_ABSENT:
                    valueToSuppress = contentType.isReferenceType() ? MapSerializer.MARKER_FOR_EMPTY : null;
                    break;
                case NON_EMPTY:
                    valueToSuppress = MapSerializer.MARKER_FOR_EMPTY;
                    break;
                case CUSTOM:
                    valueToSuppress = prov.includeFilterInstance(null, inclV.getContentFilter());
                    if (valueToSuppress != null) {
                        suppressNulls = prov.includeFilterSuppressNulls(valueToSuppress);
                        break;
                    } else {
                        suppressNulls = true;
                        break;
                    }
                case NON_NULL:
                default:
                    valueToSuppress = null;
                    break;
            }
        } else {
            valueToSuppress = null;
            suppressNulls = false;
        }
        return new AtomicReferenceSerializer(refType, staticTyping, contentTypeSerializer, contentSerializer).withContentInclusion(valueToSuppress, suppressNulls);
    }

    protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType valueType) throws JsonMappingException {
        return new IteratorSerializer(valueType, staticTyping, createTypeSerializer(config, valueType));
    }

    protected JsonSerializer<?> buildIterableSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType valueType) throws JsonMappingException {
        return new IterableSerializer(valueType, staticTyping, createTypeSerializer(config, valueType));
    }

    protected JsonSerializer<?> buildEnumSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        JsonFormat.Value format = beanDesc.findExpectedFormat(null);
        if (format.getShape() == JsonFormat.Shape.OBJECT) {
            ((BasicBeanDescription) beanDesc).removeProperty("declaringClass");
            return null;
        }
        JsonSerializer<?> ser = EnumSerializer.construct(type.getRawClass(), config, beanDesc, format);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifyEnumSerializer(config, type, beanDesc, ser);
            }
        }
        return ser;
    }

    protected JsonSerializer<Object> _findKeySerializer(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object serDef = prov.getAnnotationIntrospector().findKeySerializer(a);
        if (serDef != null) {
            return prov.serializerInstance(a, serDef);
        }
        return null;
    }

    protected JsonSerializer<Object> _findContentSerializer(SerializerProvider prov, Annotated a) throws JsonMappingException {
        Object serDef = prov.getAnnotationIntrospector().findContentSerializer(a);
        if (serDef != null) {
            return prov.serializerInstance(a, serDef);
        }
        return null;
    }

    protected Object findFilterId(SerializationConfig config, BeanDescription beanDesc) {
        return config.getAnnotationIntrospector().findFilterId(beanDesc.getClassInfo());
    }

    protected boolean usesStaticTyping(SerializationConfig config, BeanDescription beanDesc, TypeSerializer typeSer) {
        if (typeSer != null) {
            return false;
        }
        JsonSerialize.Typing t = config.getAnnotationIntrospector().findSerializationTyping(beanDesc.getClassInfo());
        if (t == null || t == JsonSerialize.Typing.DEFAULT_TYPING) {
            return config.isEnabled(MapperFeature.USE_STATIC_TYPING);
        }
        return t == JsonSerialize.Typing.STATIC;
    }
}
