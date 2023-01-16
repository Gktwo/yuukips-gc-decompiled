package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

@JacksonStdImpl
/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/MapEntryDeserializer.class */
public class MapEntryDeserializer extends ContainerDeserializerBase<Map.Entry<Object, Object>> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final KeyDeserializer _keyDeserializer;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final TypeDeserializer _valueTypeDeserializer;

    public MapEntryDeserializer(JavaType type, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
        super(type);
        if (type.containedTypeCount() != 2) {
            throw new IllegalArgumentException("Missing generic type information for " + type);
        }
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
    }

    protected MapEntryDeserializer(MapEntryDeserializer src) {
        super(src);
        this._keyDeserializer = src._keyDeserializer;
        this._valueDeserializer = src._valueDeserializer;
        this._valueTypeDeserializer = src._valueTypeDeserializer;
    }

    protected MapEntryDeserializer(MapEntryDeserializer src, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
        super(src);
        this._keyDeserializer = keyDeser;
        this._valueDeserializer = valueDeser;
        this._valueTypeDeserializer = valueTypeDeser;
    }

    protected MapEntryDeserializer withResolved(KeyDeserializer keyDeser, TypeDeserializer valueTypeDeser, JsonDeserializer<?> valueDeser) {
        if (this._keyDeserializer == keyDeser && this._valueDeserializer == valueDeser && this._valueTypeDeserializer == valueTypeDeser) {
            return this;
        }
        return new MapEntryDeserializer(this, keyDeser, valueDeser, valueTypeDeser);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<?> vd;
        KeyDeserializer kd = this._keyDeserializer;
        if (kd == null) {
            kd = ctxt.findKeyDeserializer(this._containerType.containedType(0), property);
        } else if (kd instanceof ContextualKeyDeserializer) {
            kd = ((ContextualKeyDeserializer) kd).createContextual(ctxt, property);
        }
        JsonDeserializer<?> vd2 = findConvertingContentDeserializer(ctxt, property, this._valueDeserializer);
        JavaType contentType = this._containerType.containedType(1);
        if (vd2 == null) {
            vd = ctxt.findContextualValueDeserializer(contentType, property);
        } else {
            vd = ctxt.handleSecondaryContextualization(vd2, property, contentType);
        }
        TypeDeserializer vtd = this._valueTypeDeserializer;
        if (vtd != null) {
            vtd = vtd.forProperty(property);
        }
        return withResolved(kd, vtd, vd);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JavaType getContentType() {
        return this._containerType.containedType(1);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Map.Entry<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken t = p.currentToken();
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        } else if (!(t == JsonToken.FIELD_NAME || t == JsonToken.END_OBJECT)) {
            if (t == JsonToken.START_ARRAY) {
                return _deserializeFromArray(p, ctxt);
            }
            return (Map.Entry) ctxt.handleUnexpectedToken(getValueType(ctxt), p);
        }
        if (t == JsonToken.FIELD_NAME) {
            KeyDeserializer keyDes = this._keyDeserializer;
            JsonDeserializer<Object> valueDes = this._valueDeserializer;
            TypeDeserializer typeDeser = this._valueTypeDeserializer;
            String keyStr = p.currentName();
            Object key = keyDes.deserializeKey(keyStr, ctxt);
            Object value = null;
            try {
                if (p.nextToken() == JsonToken.VALUE_NULL) {
                    value = valueDes.getNullValue(ctxt);
                } else if (typeDeser == null) {
                    value = valueDes.deserialize(p, ctxt);
                } else {
                    value = valueDes.deserializeWithType(p, ctxt, typeDeser);
                }
            } catch (Exception e) {
                wrapAndThrow(ctxt, e, Map.Entry.class, keyStr);
            }
            JsonToken t2 = p.nextToken();
            if (t2 == JsonToken.END_OBJECT) {
                return new AbstractMap.SimpleEntry(key, value);
            }
            if (t2 == JsonToken.FIELD_NAME) {
                ctxt.reportInputMismatch(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", p.currentName());
                return null;
            }
            ctxt.reportInputMismatch(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + t2, new Object[0]);
            return null;
        } else if (t == JsonToken.END_OBJECT) {
            return (Map.Entry) ctxt.reportInputMismatch(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
        } else {
            return (Map.Entry) ctxt.handleUnexpectedToken(handledType(), p);
        }
    }

    public Map.Entry<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map.Entry<Object, Object> result) throws IOException {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromObject(p, ctxt);
    }
}
