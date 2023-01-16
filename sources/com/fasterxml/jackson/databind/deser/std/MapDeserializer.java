package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JacksonStdImpl
/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/MapDeserializer.class */
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements ContextualDeserializer, ResolvableDeserializer {
    private static final long serialVersionUID = 1;
    protected final KeyDeserializer _keyDeserializer;
    protected boolean _standardStringKey;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected final boolean _hasDefaultCreator;
    protected Set<String> _ignorableProperties;
    protected Set<String> _includableProperties;
    protected IgnorePropertiesUtil.Checker _inclusionChecker;

    public MapDeserializer(JavaType mapType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
        super(mapType, (NullValueProvider) null, (Boolean) null);
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
        this._valueInstantiator = valueInstantiator;
        this._hasDefaultCreator = valueInstantiator.canCreateUsingDefault();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(mapType, keyDeser);
        this._inclusionChecker = null;
    }

    protected MapDeserializer(MapDeserializer src) {
        super(src);
        this._keyDeserializer = src._keyDeserializer;
        this._valueDeserializer = src._valueDeserializer;
        this._valueTypeDeserializer = src._valueTypeDeserializer;
        this._valueInstantiator = src._valueInstantiator;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._hasDefaultCreator = src._hasDefaultCreator;
        this._ignorableProperties = src._ignorableProperties;
        this._includableProperties = src._includableProperties;
        this._inclusionChecker = src._inclusionChecker;
        this._standardStringKey = src._standardStringKey;
    }

    protected MapDeserializer(MapDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, NullValueProvider nuller, Set<String> ignorable) {
        this(src, keyDeser, valueDeser, valueTypeDeser, nuller, ignorable, null);
    }

    protected MapDeserializer(MapDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, NullValueProvider nuller, Set<String> ignorable, Set<String> includable) {
        super(src, nuller, src._unwrapSingle);
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
        this._valueInstantiator = src._valueInstantiator;
        this._propertyBasedCreator = src._propertyBasedCreator;
        this._delegateDeserializer = src._delegateDeserializer;
        this._hasDefaultCreator = src._hasDefaultCreator;
        this._ignorableProperties = ignorable;
        this._includableProperties = includable;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(ignorable, includable);
        this._standardStringKey = _isStdKeyDeser(this._containerType, keyDeser);
    }

    protected MapDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser, NullValueProvider nuller, Set<String> ignorable) {
        return withResolved(keyDeser, valueTypeDeser, valueDeser, nuller, ignorable, this._includableProperties);
    }

    protected MapDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser, NullValueProvider nuller, Set<String> ignorable, Set<String> includable) {
        if (this._keyDeserializer == keyDeser && this._valueDeserializer == valueDeser && this._valueTypeDeserializer == valueTypeDeser && this._nullProvider == nuller && this._ignorableProperties == ignorable && this._includableProperties == includable) {
            return this;
        }
        return new MapDeserializer(this, keyDeser, valueDeser, valueTypeDeser, nuller, ignorable, includable);
    }

    protected final boolean _isStdKeyDeser(JavaType mapType, KeyDeserializer keyDeser) {
        JavaType keyType;
        if (keyDeser == null || (keyType = mapType.getKeyType()) == null) {
            return true;
        }
        Class<?> rawKeyType = keyType.getRawClass();
        return (rawKeyType == String.class || rawKeyType == Object.class) && isDefaultKeyDeserializer(keyDeser);
    }

    @Deprecated
    public void setIgnorableProperties(String[] ignorable) {
        this._ignorableProperties = (ignorable == null || ignorable.length == 0) ? null : ArrayBuilders.arrayToSet(ignorable);
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(this._ignorableProperties, this._includableProperties);
    }

    public void setIgnorableProperties(Set<String> ignorable) {
        this._ignorableProperties = (ignorable == null || ignorable.size() == 0) ? null : ignorable;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(this._ignorableProperties, this._includableProperties);
    }

    public void setIncludableProperties(Set<String> includable) {
        this._includableProperties = includable;
        this._inclusionChecker = IgnorePropertiesUtil.buildCheckerIfNeeded(this._ignorableProperties, this._includableProperties);
    }

    @Override // com.fasterxml.jackson.databind.deser.ResolvableDeserializer
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(ctxt.getConfig());
            if (delegateType == null) {
                ctxt.reportBadDefinition(this._containerType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(ctxt, delegateType, null);
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType delegateType2 = this._valueInstantiator.getArrayDelegateType(ctxt.getConfig());
            if (delegateType2 == null) {
                ctxt.reportBadDefinition(this._containerType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(ctxt, delegateType2, null);
        }
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = PropertyBasedCreator.construct(ctxt, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(ctxt.getConfig()), ctxt.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this._standardStringKey = _isStdKeyDeser(this._containerType, this._keyDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> valueDeser;
        AnnotatedMember member;
        Set<String> includedToAdd;
        KeyDeserializer keyDeser = this._keyDeserializer;
        if (keyDeser == null) {
            keyDeser = ctxt.findKeyDeserializer(this._containerType.getKeyType(), property);
        } else if (keyDeser instanceof ContextualKeyDeserializer) {
            keyDeser = ((ContextualKeyDeserializer) keyDeser).createContextual(ctxt, property);
        }
        JsonDeserializer<?> valueDeser2 = this._valueDeserializer;
        if (property != null) {
            valueDeser2 = findConvertingContentDeserializer(ctxt, property, valueDeser2);
        }
        JavaType vt = this._containerType.getContentType();
        if (valueDeser2 == null) {
            valueDeser = ctxt.findContextualValueDeserializer(vt, property);
        } else {
            valueDeser = ctxt.handleSecondaryContextualization(valueDeser2, property, vt);
        }
        TypeDeserializer vtd = this._valueTypeDeserializer;
        if (vtd != null) {
            vtd = vtd.forProperty(property);
        }
        Set<String> ignored = this._ignorableProperties;
        Set<String> included = this._includableProperties;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (_neitherNull(intr, property) && (member = property.getMember()) != null) {
            DeserializationConfig config = ctxt.getConfig();
            JsonIgnoreProperties.Value ignorals = intr.findPropertyIgnoralByName(config, member);
            if (ignorals != null) {
                Set<String> ignoresToAdd = ignorals.findIgnoredForDeserialization();
                if (!ignoresToAdd.isEmpty()) {
                    ignored = ignored == null ? new HashSet<>() : new HashSet<>(ignored);
                    for (String str : ignoresToAdd) {
                        ignored.add(str);
                    }
                }
            }
            JsonIncludeProperties.Value inclusions = intr.findPropertyInclusionByName(config, member);
            if (!(inclusions == null || (includedToAdd = inclusions.getIncluded()) == null)) {
                Set<String> newIncluded = new HashSet<>();
                if (included == null) {
                    newIncluded = new HashSet<>(includedToAdd);
                } else {
                    for (String str2 : includedToAdd) {
                        if (included.contains(str2)) {
                            newIncluded.add(str2);
                        }
                    }
                }
                included = newIncluded;
            }
        }
        return withResolved(keyDeser, vtd, valueDeser, findContentNullProvider(ctxt, property, valueDeser), ignored, included);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null && this._includableProperties == null;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(p, ctxt);
        }
        if (this._delegateDeserializer != null) {
            return (Map) this._valueInstantiator.createUsingDelegate(ctxt, this._delegateDeserializer.deserialize(p, ctxt));
        }
        if (!this._hasDefaultCreator) {
            return (Map) ctxt.handleMissingInstantiator(getMapClass(), getValueInstantiator(), p, "no default constructor found", new Object[0]);
        }
        switch (p.currentTokenId()) {
            case 1:
            case 2:
            case 5:
                Map<Object, Object> result = (Map) this._valueInstantiator.createUsingDefault(ctxt);
                if (this._standardStringKey) {
                    _readAndBindStringKeyMap(p, ctxt, result);
                    return result;
                }
                _readAndBind(p, ctxt, result);
                return result;
            case 3:
                return _deserializeFromArray(p, ctxt);
            case 4:
            default:
                return (Map) ctxt.handleUnexpectedToken(getValueType(ctxt), p);
            case 6:
                return _deserializeFromString(p, ctxt);
        }
    }

    public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        p.setCurrentValue(result);
        JsonToken t = p.currentToken();
        if (t != JsonToken.START_OBJECT && t != JsonToken.FIELD_NAME) {
            return (Map) ctxt.handleUnexpectedToken(getMapClass(), p);
        }
        if (this._standardStringKey) {
            _readAndUpdateStringKeyMap(p, ctxt, result);
            return result;
        }
        _readAndUpdate(p, ctxt, result);
        return result;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }

    public final Class<?> getMapClass() {
        return this._containerType.getRawClass();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._containerType;
    }

    protected final void _readAndBind(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        String keyStr;
        Object value;
        KeyDeserializer keyDes = this._keyDeserializer;
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        MapReferringAccumulator referringAccumulator = null;
        boolean useObjectId = valueDes.getObjectIdReader() != null;
        if (useObjectId) {
            referringAccumulator = new MapReferringAccumulator(this._containerType.getContentType().getRawClass(), result);
        }
        if (p.isExpectedStartObjectToken()) {
            keyStr = p.nextFieldName();
        } else {
            JsonToken t = p.currentToken();
            if (t != JsonToken.FIELD_NAME) {
                if (t != JsonToken.END_OBJECT) {
                    ctxt.reportWrongTokenException(this, JsonToken.FIELD_NAME, (String) null, new Object[0]);
                } else {
                    return;
                }
            }
            keyStr = p.currentName();
        }
        while (keyStr != null) {
            Object key = keyDes.deserializeKey(keyStr, ctxt);
            JsonToken t2 = p.nextToken();
            if (this._inclusionChecker == null || !this._inclusionChecker.shouldIgnore(keyStr)) {
                try {
                    if (t2 == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            value = this._nullProvider.getNullValue(ctxt);
                        }
                    } else if (typeDeser == null) {
                        value = valueDes.deserialize(p, ctxt);
                    } else {
                        value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                    }
                    if (useObjectId) {
                        referringAccumulator.put(key, value);
                    } else {
                        result.put(key, value);
                    }
                } catch (UnresolvedForwardReference reference) {
                    handleUnresolvedReference(ctxt, referringAccumulator, key, reference);
                } catch (Exception e) {
                    wrapAndThrow(ctxt, e, result, keyStr);
                }
            } else {
                p.skipChildren();
            }
            keyStr = p.nextFieldName();
        }
    }

    protected final void _readAndBindStringKeyMap(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        String key;
        Object value;
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        MapReferringAccumulator referringAccumulator = null;
        boolean useObjectId = valueDes.getObjectIdReader() != null;
        if (useObjectId) {
            referringAccumulator = new MapReferringAccumulator(this._containerType.getContentType().getRawClass(), result);
        }
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else {
            JsonToken t = p.currentToken();
            if (t != JsonToken.END_OBJECT) {
                if (t != JsonToken.FIELD_NAME) {
                    ctxt.reportWrongTokenException(this, JsonToken.FIELD_NAME, (String) null, new Object[0]);
                }
                key = p.currentName();
            } else {
                return;
            }
        }
        while (key != null) {
            JsonToken t2 = p.nextToken();
            if (this._inclusionChecker == null || !this._inclusionChecker.shouldIgnore(key)) {
                try {
                    if (t2 == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            value = this._nullProvider.getNullValue(ctxt);
                        }
                    } else if (typeDeser == null) {
                        value = valueDes.deserialize(p, ctxt);
                    } else {
                        value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                    }
                    if (useObjectId) {
                        referringAccumulator.put(key, value);
                    } else {
                        result.put(key, value);
                    }
                } catch (UnresolvedForwardReference reference) {
                    handleUnresolvedReference(ctxt, referringAccumulator, key, reference);
                } catch (Exception e) {
                    wrapAndThrow(ctxt, e, result, key);
                }
            } else {
                p.skipChildren();
            }
            key = p.nextFieldName();
        }
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser p, DeserializationContext ctxt) throws IOException {
        String key;
        Object value;
        PropertyBasedCreator creator = this._propertyBasedCreator;
        PropertyValueBuffer buffer = creator.startBuilding(p, ctxt, null);
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else if (p.hasToken(JsonToken.FIELD_NAME)) {
            key = p.currentName();
        } else {
            key = null;
        }
        while (key != null) {
            JsonToken t = p.nextToken();
            if (this._inclusionChecker == null || !this._inclusionChecker.shouldIgnore(key)) {
                SettableBeanProperty prop = creator.findCreatorProperty(key);
                if (prop == null) {
                    Object actualKey = this._keyDeserializer.deserializeKey(key, ctxt);
                    try {
                        if (t == JsonToken.VALUE_NULL) {
                            if (!this._skipNullValues) {
                                value = this._nullProvider.getNullValue(ctxt);
                            }
                        } else if (typeDeser == null) {
                            value = valueDes.deserialize(p, ctxt);
                        } else {
                            value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                        }
                        buffer.bufferMapProperty(actualKey, value);
                    } catch (Exception e) {
                        wrapAndThrow(ctxt, e, this._containerType.getRawClass(), key);
                        return null;
                    }
                } else if (buffer.assignParameter(prop, prop.deserialize(p, ctxt))) {
                    p.nextToken();
                    try {
                        Map<Object, Object> result = (Map) creator.build(ctxt, buffer);
                        _readAndBind(p, ctxt, result);
                        return result;
                    } catch (Exception e2) {
                        return (Map) wrapAndThrow(ctxt, e2, this._containerType.getRawClass(), key);
                    }
                }
            } else {
                p.skipChildren();
            }
            key = p.nextFieldName();
        }
        try {
            return (Map) creator.build(ctxt, buffer);
        } catch (Exception e3) {
            wrapAndThrow(ctxt, e3, this._containerType.getRawClass(), key);
            return null;
        }
    }

    protected final void _readAndUpdate(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        String keyStr;
        Object value;
        KeyDeserializer keyDes = this._keyDeserializer;
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (p.isExpectedStartObjectToken()) {
            keyStr = p.nextFieldName();
        } else {
            JsonToken t = p.currentToken();
            if (t != JsonToken.END_OBJECT) {
                if (t != JsonToken.FIELD_NAME) {
                    ctxt.reportWrongTokenException(this, JsonToken.FIELD_NAME, (String) null, new Object[0]);
                }
                keyStr = p.currentName();
            } else {
                return;
            }
        }
        while (keyStr != null) {
            Object key = keyDes.deserializeKey(keyStr, ctxt);
            JsonToken t2 = p.nextToken();
            if (this._inclusionChecker == null || !this._inclusionChecker.shouldIgnore(keyStr)) {
                try {
                    if (t2 != JsonToken.VALUE_NULL) {
                        Object old = result.get(key);
                        if (old != null) {
                            if (typeDeser == null) {
                                value = valueDes.deserialize(p, ctxt, old);
                            } else {
                                value = valueDes.deserializeWithType(p, ctxt, typeDeser, old);
                            }
                        } else if (typeDeser == null) {
                            value = valueDes.deserialize(p, ctxt);
                        } else {
                            value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                        }
                        if (value != old) {
                            result.put(key, value);
                        }
                    } else if (!this._skipNullValues) {
                        result.put(key, this._nullProvider.getNullValue(ctxt));
                    }
                } catch (Exception e) {
                    wrapAndThrow(ctxt, e, result, keyStr);
                }
            } else {
                p.skipChildren();
            }
            keyStr = p.nextFieldName();
        }
    }

    protected final void _readAndUpdateStringKeyMap(JsonParser p, DeserializationContext ctxt, Map<Object, Object> result) throws IOException {
        String key;
        Object value;
        JsonDeserializer<Object> valueDes = this._valueDeserializer;
        TypeDeserializer typeDeser = this._valueTypeDeserializer;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else {
            JsonToken t = p.currentToken();
            if (t != JsonToken.END_OBJECT) {
                if (t != JsonToken.FIELD_NAME) {
                    ctxt.reportWrongTokenException(this, JsonToken.FIELD_NAME, (String) null, new Object[0]);
                }
                key = p.currentName();
            } else {
                return;
            }
        }
        while (key != null) {
            JsonToken t2 = p.nextToken();
            if (this._inclusionChecker == null || !this._inclusionChecker.shouldIgnore(key)) {
                try {
                    if (t2 != JsonToken.VALUE_NULL) {
                        Object old = result.get(key);
                        if (old != null) {
                            if (typeDeser == null) {
                                value = valueDes.deserialize(p, ctxt, old);
                            } else {
                                value = valueDes.deserializeWithType(p, ctxt, typeDeser, old);
                            }
                        } else if (typeDeser == null) {
                            value = valueDes.deserialize(p, ctxt);
                        } else {
                            value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                        }
                        if (value != old) {
                            result.put(key, value);
                        }
                    } else if (!this._skipNullValues) {
                        result.put(key, this._nullProvider.getNullValue(ctxt));
                    }
                } catch (Exception e) {
                    wrapAndThrow(ctxt, e, result, key);
                }
            } else {
                p.skipChildren();
            }
            key = p.nextFieldName();
        }
    }

    private void handleUnresolvedReference(DeserializationContext ctxt, MapReferringAccumulator accumulator, Object key, UnresolvedForwardReference reference) throws JsonMappingException {
        if (accumulator == null) {
            ctxt.reportInputMismatch(this, "Unresolved forward reference but no identity info: " + reference, new Object[0]);
        }
        reference.getRoid().appendReferring(accumulator.handleUnresolvedReference(reference, key));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/MapDeserializer$MapReferringAccumulator.class */
    public static final class MapReferringAccumulator {
        private final Class<?> _valueType;
        private Map<Object, Object> _result;
        private List<MapReferring> _accumulator = new ArrayList();

        public MapReferringAccumulator(Class<?> valueType, Map<Object, Object> result) {
            this._valueType = valueType;
            this._result = result;
        }

        public void put(Object key, Object value) {
            if (this._accumulator.isEmpty()) {
                this._result.put(key, value);
            } else {
                this._accumulator.get(this._accumulator.size() - 1).next.put(key, value);
            }
        }

        public ReadableObjectId.Referring handleUnresolvedReference(UnresolvedForwardReference reference, Object key) {
            MapReferring id = new MapReferring(this, reference, this._valueType, key);
            this._accumulator.add(id);
            return id;
        }

        public void resolveForwardReference(Object id, Object value) throws IOException {
            Iterator<MapReferring> iterator = this._accumulator.iterator();
            Map<Object, Object> previous = this._result;
            while (iterator.hasNext()) {
                MapReferring ref = iterator.next();
                if (ref.hasId(id)) {
                    iterator.remove();
                    previous.put(ref.key, value);
                    previous.putAll(ref.next);
                    return;
                }
                previous = ref.next;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + id + "] that wasn't previously seen as unresolved.");
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/MapDeserializer$MapReferring.class */
    public static class MapReferring extends ReadableObjectId.Referring {
        private final MapReferringAccumulator _parent;
        public final Map<Object, Object> next = new LinkedHashMap();
        public final Object key;

        MapReferring(MapReferringAccumulator parent, UnresolvedForwardReference ref, Class<?> valueType, Object key) {
            super(ref, valueType);
            this._parent = parent;
            this.key = key;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring
        public void handleResolvedForwardReference(Object id, Object value) throws IOException {
            this._parent.resolveForwardReference(id, value);
        }
    }
}
