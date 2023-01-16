package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/ser/BeanSerializerFactory.class */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    private static final long serialVersionUID = 1;
    public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);

    protected BeanSerializerFactory(SerializerFactoryConfig config) {
        super(config);
    }

    @Override // com.fasterxml.jackson.databind.ser.BasicSerializerFactory
    public SerializerFactory withConfig(SerializerFactoryConfig config) {
        if (this._factoryConfig == config) {
            return this;
        }
        if (getClass() == BeanSerializerFactory.class) {
            return new BeanSerializerFactory(config);
        }
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': cannot instantiate subtype with additional serializer definitions");
    }

    @Override // com.fasterxml.jackson.databind.ser.BasicSerializerFactory
    protected Iterable<Serializers> customSerializers() {
        return this._factoryConfig.serializers();
    }

    @Override // com.fasterxml.jackson.databind.ser.BasicSerializerFactory, com.fasterxml.jackson.databind.ser.SerializerFactory
    public JsonSerializer<Object> createSerializer(SerializerProvider prov, JavaType origType) throws JsonMappingException {
        JavaType type;
        boolean staticTyping;
        SerializationConfig config = prov.getConfig();
        BeanDescription beanDesc = config.introspect(origType);
        JsonSerializer<?> ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo());
        if (ser != null) {
            return ser;
        }
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        if (intr == null) {
            type = origType;
        } else {
            try {
                type = intr.refineSerializationType(config, beanDesc.getClassInfo(), origType);
            } catch (JsonMappingException e) {
                return (JsonSerializer) prov.reportBadTypeDefinition(beanDesc, e.getMessage(), new Object[0]);
            }
        }
        if (type == origType) {
            staticTyping = false;
        } else {
            staticTyping = true;
            if (!type.hasRawClass(origType.getRawClass())) {
                beanDesc = config.introspect(type);
            }
        }
        Converter<Object, Object> conv = beanDesc.findSerializationConverter();
        if (conv == null) {
            return _createSerializer2(prov, type, beanDesc, staticTyping);
        }
        JavaType delegateType = conv.getOutputType(prov.getTypeFactory());
        if (!delegateType.hasRawClass(type.getRawClass())) {
            beanDesc = config.introspect(delegateType);
            ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo());
        }
        if (ser == null && !delegateType.isJavaLangObject()) {
            ser = _createSerializer2(prov, delegateType, beanDesc, true);
        }
        return new StdDelegatingSerializer(conv, delegateType, ser);
    }

    protected JsonSerializer<?> _createSerializer2(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        JsonSerializer<?> ser = null;
        SerializationConfig config = prov.getConfig();
        if (type.isContainerType()) {
            if (!staticTyping) {
                staticTyping = usesStaticTyping(config, beanDesc, null);
            }
            ser = buildContainerSerializer(prov, type, beanDesc, staticTyping);
            if (ser != null) {
                return ser;
            }
        } else {
            if (!type.isReferenceType()) {
                for (Serializers serializers : customSerializers()) {
                    ser = serializers.findSerializer(config, type, beanDesc);
                    if (ser != null) {
                        break;
                    }
                }
            } else {
                ser = findReferenceSerializer(prov, (ReferenceType) type, beanDesc, staticTyping);
            }
            if (ser == null) {
                ser = findSerializerByAnnotations(prov, type, beanDesc);
            }
        }
        if (ser == null) {
            ser = findSerializerByLookup(type, config, beanDesc, staticTyping);
            if (ser == null) {
                ser = findSerializerByPrimaryType(prov, type, beanDesc, staticTyping);
                if (ser == null) {
                    ser = findBeanOrAddOnSerializer(prov, type, beanDesc, staticTyping);
                    if (ser == null) {
                        ser = prov.getUnknownTypeSerializer(beanDesc.getBeanClass());
                    }
                }
            }
        }
        if (ser != null && this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                ser = mod.modifySerializer(config, beanDesc, ser);
            }
        }
        return ser;
    }

    @Deprecated
    public JsonSerializer<Object> findBeanSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        return findBeanOrAddOnSerializer(prov, type, beanDesc, prov.isEnabled(MapperFeature.USE_STATIC_TYPING));
    }

    public JsonSerializer<Object> findBeanOrAddOnSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        if (isPotentialBeanType(type.getRawClass()) || ClassUtil.isEnumType(type.getRawClass())) {
            return constructBeanOrAddOnSerializer(prov, type, beanDesc, staticTyping);
        }
        return null;
    }

    public TypeSerializer findPropertyTypeSerializer(JavaType baseType, SerializationConfig config, AnnotatedMember accessor) throws JsonMappingException {
        TypeSerializer typeSer;
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findPropertyTypeResolver(config, accessor, baseType);
        if (b == null) {
            typeSer = createTypeSerializer(config, baseType);
        } else {
            typeSer = b.buildTypeSerializer(config, baseType, config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, accessor, baseType));
        }
        return typeSer;
    }

    public TypeSerializer findPropertyContentTypeSerializer(JavaType containerType, SerializationConfig config, AnnotatedMember accessor) throws JsonMappingException {
        TypeSerializer typeSer;
        JavaType contentType = containerType.getContentType();
        TypeResolverBuilder<?> b = config.getAnnotationIntrospector().findPropertyContentTypeResolver(config, accessor, containerType);
        if (b == null) {
            typeSer = createTypeSerializer(config, contentType);
        } else {
            typeSer = b.buildTypeSerializer(config, contentType, config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, accessor, contentType));
        }
        return typeSer;
    }

    @Deprecated
    protected JsonSerializer<Object> constructBeanSerializer(SerializerProvider prov, BeanDescription beanDesc) throws JsonMappingException {
        return constructBeanOrAddOnSerializer(prov, beanDesc.getType(), beanDesc, prov.isEnabled(MapperFeature.USE_STATIC_TYPING));
    }

    protected JsonSerializer<Object> constructBeanOrAddOnSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException {
        List<BeanPropertyWriter> props;
        if (beanDesc.getBeanClass() == Object.class) {
            return prov.getUnknownTypeSerializer(Object.class);
        }
        JsonSerializer<?> ser = _findUnsupportedTypeSerializer(prov, type, beanDesc);
        if (ser != null) {
            return ser;
        }
        if (_isUnserializableJacksonType(prov, type)) {
            return new ToEmptyObjectSerializer(type);
        }
        SerializationConfig config = prov.getConfig();
        BeanSerializerBuilder builder = constructBeanSerializerBuilder(beanDesc);
        builder.setConfig(config);
        List<BeanPropertyWriter> props2 = findBeanProperties(prov, beanDesc, builder);
        if (props2 == null) {
            props = new ArrayList<>();
        } else {
            props = removeOverlappingTypeIds(prov, beanDesc, builder, props2);
        }
        prov.getAnnotationIntrospector().findAndAddVirtualProperties(config, beanDesc.getClassInfo(), props);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod : this._factoryConfig.serializerModifiers()) {
                props = mod.changeProperties(config, beanDesc, props);
            }
        }
        List<BeanPropertyWriter> props3 = filterBeanProperties(config, beanDesc, filterUnwantedJDKProperties(config, beanDesc, props));
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod2 : this._factoryConfig.serializerModifiers()) {
                props3 = mod2.orderProperties(config, beanDesc, props3);
            }
        }
        builder.setObjectIdWriter(constructObjectIdHandler(prov, beanDesc, props3));
        builder.setProperties(props3);
        builder.setFilterId(findFilterId(config, beanDesc));
        AnnotatedMember anyGetter = beanDesc.findAnyGetter();
        if (anyGetter != null) {
            JavaType anyType = anyGetter.getType();
            JavaType valueType = anyType.getContentType();
            TypeSerializer typeSer = createTypeSerializer(config, valueType);
            JsonSerializer<?> anySer = findSerializerFromAnnotation(prov, anyGetter);
            if (anySer == null) {
                anySer = MapSerializer.construct((Set<String>) null, anyType, config.isEnabled(MapperFeature.USE_STATIC_TYPING), typeSer, (JsonSerializer<Object>) null, (JsonSerializer<Object>) null, (Object) null);
            }
            builder.setAnyGetter(new AnyGetterWriter(new BeanProperty.Std(PropertyName.construct(anyGetter.getName()), valueType, null, anyGetter, PropertyMetadata.STD_OPTIONAL), anyGetter, anySer));
        }
        processViews(config, builder);
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (BeanSerializerModifier mod3 : this._factoryConfig.serializerModifiers()) {
                builder = mod3.updateBuilder(config, beanDesc, builder);
            }
        }
        try {
            JsonSerializer<?> ser2 = builder.build();
            if (ser2 == null) {
                if (type.isRecordType()) {
                    return builder.createDummy();
                }
                ser2 = findSerializerByAddonType(config, type, beanDesc, staticTyping);
                if (ser2 == null && beanDesc.hasKnownClassAnnotations()) {
                    return builder.createDummy();
                }
            }
            return ser2;
        } catch (RuntimeException e) {
            return (JsonSerializer) prov.reportBadTypeDefinition(beanDesc, "Failed to construct BeanSerializer for %s: (%s) %s", beanDesc.getType(), e.getClass().getName(), e.getMessage());
        }
    }

    protected ObjectIdWriter constructObjectIdHandler(SerializerProvider prov, BeanDescription beanDesc, List<BeanPropertyWriter> props) throws JsonMappingException {
        ObjectIdInfo objectIdInfo = beanDesc.getObjectIdInfo();
        if (objectIdInfo == null) {
            return null;
        }
        Class<?> implClass = objectIdInfo.getGeneratorType();
        if (implClass != ObjectIdGenerators.PropertyGenerator.class) {
            return ObjectIdWriter.construct(prov.getTypeFactory().findTypeParameters(prov.constructType(implClass), ObjectIdGenerator.class)[0], objectIdInfo.getPropertyName(), prov.objectIdGeneratorInstance(beanDesc.getClassInfo(), objectIdInfo), objectIdInfo.getAlwaysAsId());
        }
        String propName = objectIdInfo.getPropertyName().getSimpleName();
        int len = props.size();
        for (int i = 0; i != len; i++) {
            BeanPropertyWriter prop = props.get(i);
            if (propName.equals(prop.getName())) {
                if (i > 0) {
                    props.remove(i);
                    props.add(0, prop);
                }
                return ObjectIdWriter.construct(prop.getType(), null, new PropertyBasedObjectIdGenerator(objectIdInfo, prop), objectIdInfo.getAlwaysAsId());
            }
        }
        throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", ClassUtil.getTypeDescription(beanDesc.getType()), ClassUtil.name(propName)));
    }

    protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter writer, Class<?>[] inViews) {
        return FilteredBeanPropertyWriter.constructViewBased(writer, inViews);
    }

    protected PropertyBuilder constructPropertyBuilder(SerializationConfig config, BeanDescription beanDesc) {
        return new PropertyBuilder(config, beanDesc);
    }

    protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beanDesc) {
        return new BeanSerializerBuilder(beanDesc);
    }

    protected boolean isPotentialBeanType(Class<?> type) {
        return ClassUtil.canBeABeanType(type) == null && !ClassUtil.isProxyType(type);
    }

    protected List<BeanPropertyWriter> findBeanProperties(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder) throws JsonMappingException {
        List<BeanPropertyDefinition> properties = beanDesc.findProperties();
        SerializationConfig config = prov.getConfig();
        removeIgnorableTypes(config, beanDesc, properties);
        if (config.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
            removeSetterlessGetters(config, beanDesc, properties);
        }
        if (properties.isEmpty()) {
            return null;
        }
        boolean staticTyping = usesStaticTyping(config, beanDesc, null);
        PropertyBuilder pb = constructPropertyBuilder(config, beanDesc);
        ArrayList<BeanPropertyWriter> result = new ArrayList<>(properties.size());
        for (BeanPropertyDefinition property : properties) {
            AnnotatedMember accessor = property.getAccessor();
            if (!property.isTypeId()) {
                AnnotationIntrospector.ReferenceProperty refType = property.findReferenceType();
                if (refType == null || !refType.isBackReference()) {
                    if (accessor instanceof AnnotatedMethod) {
                        result.add(_constructWriter(prov, property, pb, staticTyping, (AnnotatedMethod) accessor));
                    } else {
                        result.add(_constructWriter(prov, property, pb, staticTyping, (AnnotatedField) accessor));
                    }
                }
            } else if (accessor != null) {
                builder.setTypeId(accessor);
            }
        }
        return result;
    }

    protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> props) {
        JsonIgnoreProperties.Value ignorals = config.getDefaultPropertyIgnorals(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        Set<String> ignored = null;
        if (ignorals != null) {
            ignored = ignorals.findIgnoredForSerialization();
        }
        JsonIncludeProperties.Value inclusions = config.getDefaultPropertyInclusions(beanDesc.getBeanClass(), beanDesc.getClassInfo());
        Set<String> included = null;
        if (inclusions != null) {
            included = inclusions.getIncluded();
        }
        if (included != null || (ignored != null && !ignored.isEmpty())) {
            Iterator<BeanPropertyWriter> it = props.iterator();
            while (it.hasNext()) {
                if (IgnorePropertiesUtil.shouldIgnore(it.next().getName(), ignored, included)) {
                    it.remove();
                }
            }
        }
        return props;
    }

    protected List<BeanPropertyWriter> filterUnwantedJDKProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> props) {
        if (beanDesc.getType().isTypeOrSubTypeOf(CharSequence.class) && props.size() == 1) {
            AnnotatedMember m = props.get(0).getMember();
            if ((m instanceof AnnotatedMethod) && "isEmpty".equals(m.getName()) && m.getDeclaringClass() == CharSequence.class) {
                props.remove(0);
            }
        }
        return props;
    }

    protected void processViews(SerializationConfig config, BeanSerializerBuilder builder) {
        List<BeanPropertyWriter> props = builder.getProperties();
        boolean includeByDefault = config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int propCount = props.size();
        int viewsFound = 0;
        BeanPropertyWriter[] filtered = new BeanPropertyWriter[propCount];
        for (int i = 0; i < propCount; i++) {
            BeanPropertyWriter bpw = props.get(i);
            Class<?>[] views = bpw.getViews();
            if (views != null && views.length != 0) {
                viewsFound++;
                filtered[i] = constructFilteredBeanWriter(bpw, views);
            } else if (includeByDefault) {
                filtered[i] = bpw;
            }
        }
        if (!includeByDefault || viewsFound != 0) {
            builder.setFilteredProperties(filtered);
        }
    }

    protected void removeIgnorableTypes(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties) {
        AnnotationIntrospector intr = config.getAnnotationIntrospector();
        HashMap<Class<?>, Boolean> ignores = new HashMap<>();
        Iterator<BeanPropertyDefinition> it = properties.iterator();
        while (it.hasNext()) {
            BeanPropertyDefinition property = it.next();
            if (property.getAccessor() == null) {
                it.remove();
            } else {
                Class<?> type = property.getRawPrimaryType();
                Boolean result = ignores.get(type);
                if (result == null) {
                    result = config.getConfigOverride(type).getIsIgnoredType();
                    if (result == null) {
                        result = intr.isIgnorableType(config.introspectClassAnnotations(type).getClassInfo());
                        if (result == null) {
                            result = Boolean.FALSE;
                        }
                    }
                    ignores.put(type, result);
                }
                if (result.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    protected void removeSetterlessGetters(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties) {
        Iterator<BeanPropertyDefinition> it = properties.iterator();
        while (it.hasNext()) {
            BeanPropertyDefinition property = it.next();
            if (!property.couldDeserialize() && !property.isExplicitlyIncluded()) {
                it.remove();
            }
        }
    }

    protected List<BeanPropertyWriter> removeOverlappingTypeIds(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder, List<BeanPropertyWriter> props) {
        int end = props.size();
        for (int i = 0; i < end; i++) {
            BeanPropertyWriter bpw = props.get(i);
            TypeSerializer td = bpw.getTypeSerializer();
            if (td != null && td.getTypeInclusion() == JsonTypeInfo.EnumC0036As.EXTERNAL_PROPERTY) {
                PropertyName typePropName = PropertyName.construct(td.getPropertyName());
                Iterator<BeanPropertyWriter> it = props.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BeanPropertyWriter w2 = it.next();
                    if (w2 != bpw && w2.wouldConflictWithName(typePropName)) {
                        bpw.assignTypeSerializer(null);
                        break;
                    }
                }
            }
        }
        return props;
    }

    protected BeanPropertyWriter _constructWriter(SerializerProvider prov, BeanPropertyDefinition propDef, PropertyBuilder pb, boolean staticTyping, AnnotatedMember accessor) throws JsonMappingException {
        PropertyName name = propDef.getFullName();
        JavaType type = accessor.getType();
        BeanProperty.Std property = new BeanProperty.Std(name, type, propDef.getWrapperName(), accessor, propDef.getMetadata());
        JsonSerializer<?> annotatedSerializer = findSerializerFromAnnotation(prov, accessor);
        if (annotatedSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) annotatedSerializer).resolve(prov);
        }
        JsonSerializer<?> annotatedSerializer2 = prov.handlePrimaryContextualization(annotatedSerializer, property);
        TypeSerializer contentTypeSer = null;
        if (type.isContainerType() || type.isReferenceType()) {
            contentTypeSer = findPropertyContentTypeSerializer(type, prov.getConfig(), accessor);
        }
        return pb.buildWriter(prov, propDef, type, annotatedSerializer2, findPropertyTypeSerializer(type, prov.getConfig(), accessor), contentTypeSer, accessor, staticTyping);
    }

    protected JsonSerializer<?> _findUnsupportedTypeSerializer(SerializerProvider ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        String errorMsg = BeanUtil.checkUnsupportedType(type);
        if (errorMsg == null || ctxt.getConfig().findMixInClassFor(type.getRawClass()) != null) {
            return null;
        }
        return new UnsupportedTypeSerializer(type, errorMsg);
    }

    protected boolean _isUnserializableJacksonType(SerializerProvider ctxt, JavaType type) {
        Class<?> raw = type.getRawClass();
        return ObjectMapper.class.isAssignableFrom(raw) || ObjectReader.class.isAssignableFrom(raw) || ObjectWriter.class.isAssignableFrom(raw) || DatabindContext.class.isAssignableFrom(raw) || TokenStreamFactory.class.isAssignableFrom(raw) || JsonParser.class.isAssignableFrom(raw) || JsonGenerator.class.isAssignableFrom(raw);
    }
}
