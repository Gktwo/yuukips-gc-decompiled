package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.p003io.NumberInput;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/StdDeserializer.class */
public abstract class StdDeserializer<T> extends JsonDeserializer<T> implements Serializable, ValueInstantiator.Gettable {
    private static final long serialVersionUID = 1;
    protected static final int F_MASK_INT_COERCIONS = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.getMask() | DeserializationFeature.USE_LONG_FOR_INTS.getMask();
    @Deprecated
    protected static final int F_MASK_ACCEPT_ARRAYS = DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.getMask() | DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.getMask();
    protected final Class<?> _valueClass;
    protected final JavaType _valueType;

    /* access modifiers changed from: protected */
    public StdDeserializer(Class<?> vc) {
        this._valueClass = vc;
        this._valueType = null;
    }

    /* access modifiers changed from: protected */
    public StdDeserializer(JavaType valueType) {
        this._valueClass = valueType == null ? Object.class : valueType.getRawClass();
        this._valueType = valueType;
    }

    /* access modifiers changed from: protected */
    public StdDeserializer(StdDeserializer<?> src) {
        this._valueClass = src._valueClass;
        this._valueType = src._valueType;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Class<?> handledType() {
        return this._valueClass;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public JavaType getValueType() {
        return this._valueType;
    }

    public JavaType getValueType(DeserializationContext ctxt) {
        if (this._valueType != null) {
            return this._valueType;
        }
        return ctxt.constructType(this._valueClass);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable
    public ValueInstantiator getValueInstantiator() {
        return null;
    }

    protected boolean isDefaultDeserializer(JsonDeserializer<?> deserializer) {
        return ClassUtil.isJacksonStdImpl(deserializer);
    }

    protected boolean isDefaultKeyDeserializer(KeyDeserializer keyDeser) {
        return ClassUtil.isJacksonStdImpl(keyDeser);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }

    protected T _deserializeFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        CoercionAction act = _findCoercionFromEmptyArray(ctxt);
        boolean unwrap = ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (unwrap || act != CoercionAction.Fail) {
            if (p.nextToken() == JsonToken.END_ARRAY) {
                switch (act) {
                    case AsEmpty:
                        return (T) getEmptyValue(ctxt);
                    case AsNull:
                    case TryConvert:
                        return getNullValue(ctxt);
                }
            } else if (unwrap) {
                T parsed = _deserializeWrappedValue(p, ctxt);
                if (p.nextToken() != JsonToken.END_ARRAY) {
                    handleMissingEndArrayForSingle(p, ctxt);
                }
                return parsed;
            }
        }
        return (T) ctxt.handleUnexpectedToken(getValueType(ctxt), JsonToken.START_ARRAY, p, (String) null, new Object[0]);
    }

    @Deprecated
    protected T _deserializeFromEmpty(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.hasToken(JsonToken.START_ARRAY) || !ctxt.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            return (T) ctxt.handleUnexpectedToken(getValueType(ctxt), p);
        }
        if (p.nextToken() == JsonToken.END_ARRAY) {
            return null;
        }
        return (T) ctxt.handleUnexpectedToken(getValueType(ctxt), p);
    }

    protected T _deserializeFromString(JsonParser p, DeserializationContext ctxt) throws IOException {
        ValueInstantiator inst = getValueInstantiator();
        Class<?> rawTargetType = handledType();
        String value = p.getValueAsString();
        if (inst != null && inst.canCreateFromString()) {
            return (T) inst.createFromString(ctxt, value);
        }
        if (value.isEmpty()) {
            return (T) _deserializeFromEmptyString(p, ctxt, ctxt.findCoercionAction(logicalType(), rawTargetType, CoercionInputShape.EmptyString), rawTargetType, "empty String (\"\")");
        }
        if (_isBlank(value)) {
            return (T) _deserializeFromEmptyString(p, ctxt, ctxt.findCoercionFromBlankString(logicalType(), rawTargetType, CoercionAction.Fail), rawTargetType, "blank String (all whitespace)");
        }
        if (inst != null) {
            value = value.trim();
            if (inst.canCreateFromInt() && ctxt.findCoercionAction(LogicalType.Integer, Integer.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
                return (T) inst.createFromInt(ctxt, _parseIntPrimitive(ctxt, value));
            }
            if (inst.canCreateFromLong() && ctxt.findCoercionAction(LogicalType.Integer, Long.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
                return (T) inst.createFromLong(ctxt, _parseLongPrimitive(ctxt, value));
            }
            if (inst.canCreateFromBoolean() && ctxt.findCoercionAction(LogicalType.Boolean, Boolean.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
                String str = value.trim();
                if (C3P0Substitutions.DEBUG.equals(str)) {
                    return (T) inst.createFromBoolean(ctxt, true);
                }
                if ("false".equals(str)) {
                    return (T) inst.createFromBoolean(ctxt, false);
                }
            }
        }
        return (T) ctxt.handleMissingInstantiator(rawTargetType, inst, ctxt.getParser(), "no String-argument constructor/factory method to deserialize from String value ('%s')", value);
    }

    protected Object _deserializeFromEmptyString(JsonParser p, DeserializationContext ctxt, CoercionAction act, Class<?> rawTargetType, String desc) throws IOException {
        switch (act) {
            case AsEmpty:
                return getEmptyValue(ctxt);
            case AsNull:
            case TryConvert:
            default:
                return null;
            case Fail:
                _checkCoercionFail(ctxt, act, rawTargetType, "", "empty String (\"\")");
                return null;
        }
    }

    protected T _deserializeWrappedValue(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.START_ARRAY)) {
            return (T) ctxt.handleUnexpectedToken(getValueType(ctxt), p.currentToken(), p, String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", ClassUtil.nameOf(this._valueClass), JsonToken.START_ARRAY, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"), new Object[0]);
        }
        return deserialize(p, ctxt);
    }

    @Deprecated
    protected final boolean _parseBooleanPrimitive(DeserializationContext ctxt, JsonParser p, Class<?> targetType) throws IOException {
        return _parseBooleanPrimitive(p, ctxt);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean _parseBooleanPrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseBooleanPrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):boolean");
    }

    protected boolean _isTrue(String text) {
        char c = text.charAt(0);
        if (c == 't') {
            return C3P0Substitutions.DEBUG.equals(text);
        }
        if (c == 'T') {
            return "TRUE".equals(text) || "True".equals(text);
        }
        return false;
    }

    protected boolean _isFalse(String text) {
        char c = text.charAt(0);
        if (c == 'f') {
            return "false".equals(text);
        }
        if (c == 'F') {
            return "FALSE".equals(text) || "False".equals(text);
        }
        return false;
    }

    protected final Boolean _parseBoolean(JsonParser p, DeserializationContext ctxt, Class<?> targetType) throws IOException {
        String text;
        switch (p.currentTokenId()) {
            case 1:
                text = ctxt.extractScalarFromObject(p, this, targetType);
                break;
            case 2:
            case 4:
            case 5:
            case 8:
            default:
                return (Boolean) ctxt.handleUnexpectedToken(targetType, p);
            case 3:
                return (Boolean) _deserializeFromArray(p, ctxt);
            case 6:
                text = p.getText();
                break;
            case 7:
                return _coerceBooleanFromInt(p, ctxt, targetType);
            case 9:
                return true;
            case 10:
                return false;
            case 11:
                return null;
        }
        CoercionAction act = _checkFromStringCoercion(ctxt, text, LogicalType.Boolean, targetType);
        if (act == CoercionAction.AsNull) {
            return null;
        }
        if (act == CoercionAction.AsEmpty) {
            return false;
        }
        String text2 = text.trim();
        int len = text2.length();
        if (len == 4) {
            if (_isTrue(text2)) {
                return true;
            }
        } else if (len == 5 && _isFalse(text2)) {
            return false;
        }
        if (_checkTextualNull(ctxt, text2)) {
            return null;
        }
        return (Boolean) ctxt.handleWeirdStringValue(targetType, text2, "only \"true\" or \"false\" recognized", new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final byte _parseBytePrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 312
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseBytePrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):byte");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final short _parseShortPrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseShortPrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):short");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int _parseIntPrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseIntPrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):int");
    }

    protected final int _parseIntPrimitive(DeserializationContext ctxt, String text) throws IOException {
        try {
            if (text.length() <= 9) {
                return NumberInput.parseInt(text);
            }
            long l = NumberInput.parseLong(text);
            if (_intOverflow(l)) {
                return _nonNullNumber((Number) ctxt.handleWeirdStringValue(Integer.TYPE, text, "Overflow: numeric value (%s) out of range of int (%d -%d)", text, Integer.MIN_VALUE, Integer.MAX_VALUE)).intValue();
            }
            return (int) l;
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(Integer.TYPE, text, "not a valid `int` value", new Object[0])).intValue();
        }
    }

    protected final Integer _parseInteger(JsonParser p, DeserializationContext ctxt, Class<?> targetType) throws IOException {
        String text;
        switch (p.currentTokenId()) {
            case 1:
                text = ctxt.extractScalarFromObject(p, this, targetType);
                break;
            case 2:
            case 4:
            case 5:
            case 9:
            case 10:
            default:
                return (Integer) ctxt.handleUnexpectedToken(getValueType(ctxt), p);
            case 3:
                return (Integer) _deserializeFromArray(p, ctxt);
            case 6:
                text = p.getText();
                break;
            case 7:
                return Integer.valueOf(p.getIntValue());
            case 8:
                CoercionAction act = _checkFloatToIntCoercion(p, ctxt, targetType);
                if (act == CoercionAction.AsNull) {
                    return (Integer) getNullValue(ctxt);
                }
                if (act == CoercionAction.AsEmpty) {
                    return (Integer) getEmptyValue(ctxt);
                }
                return Integer.valueOf(p.getValueAsInt());
            case 11:
                return (Integer) getNullValue(ctxt);
        }
        CoercionAction act2 = _checkFromStringCoercion(ctxt, text);
        if (act2 == CoercionAction.AsNull) {
            return (Integer) getNullValue(ctxt);
        }
        if (act2 == CoercionAction.AsEmpty) {
            return (Integer) getEmptyValue(ctxt);
        }
        String text2 = text.trim();
        if (_checkTextualNull(ctxt, text2)) {
            return (Integer) getNullValue(ctxt);
        }
        return _parseInteger(ctxt, text2);
    }

    protected final Integer _parseInteger(DeserializationContext ctxt, String text) throws IOException {
        try {
            if (text.length() <= 9) {
                return Integer.valueOf(NumberInput.parseInt(text));
            }
            long l = NumberInput.parseLong(text);
            if (_intOverflow(l)) {
                return (Integer) ctxt.handleWeirdStringValue(Integer.class, text, "Overflow: numeric value (%s) out of range of `java.lang.Integer` (%d -%d)", text, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
            return Integer.valueOf((int) l);
        } catch (IllegalArgumentException e) {
            return (Integer) ctxt.handleWeirdStringValue(Integer.class, text, "not a valid `java.lang.Integer` value", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final long _parseLongPrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseLongPrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):long");
    }

    protected final long _parseLongPrimitive(DeserializationContext ctxt, String text) throws IOException {
        try {
            return NumberInput.parseLong(text);
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(Long.TYPE, text, "not a valid `long` value", new Object[0])).longValue();
        }
    }

    protected final Long _parseLong(JsonParser p, DeserializationContext ctxt, Class<?> targetType) throws IOException {
        String text;
        switch (p.currentTokenId()) {
            case 1:
                text = ctxt.extractScalarFromObject(p, this, targetType);
                break;
            case 2:
            case 4:
            case 5:
            case 9:
            case 10:
            default:
                return (Long) ctxt.handleUnexpectedToken(getValueType(ctxt), p);
            case 3:
                return (Long) _deserializeFromArray(p, ctxt);
            case 6:
                text = p.getText();
                break;
            case 7:
                return Long.valueOf(p.getLongValue());
            case 8:
                CoercionAction act = _checkFloatToIntCoercion(p, ctxt, targetType);
                if (act == CoercionAction.AsNull) {
                    return (Long) getNullValue(ctxt);
                }
                if (act == CoercionAction.AsEmpty) {
                    return (Long) getEmptyValue(ctxt);
                }
                return Long.valueOf(p.getValueAsLong());
            case 11:
                return (Long) getNullValue(ctxt);
        }
        CoercionAction act2 = _checkFromStringCoercion(ctxt, text);
        if (act2 == CoercionAction.AsNull) {
            return (Long) getNullValue(ctxt);
        }
        if (act2 == CoercionAction.AsEmpty) {
            return (Long) getEmptyValue(ctxt);
        }
        String text2 = text.trim();
        if (_checkTextualNull(ctxt, text2)) {
            return (Long) getNullValue(ctxt);
        }
        return _parseLong(ctxt, text2);
    }

    protected final Long _parseLong(DeserializationContext ctxt, String text) throws IOException {
        try {
            return Long.valueOf(NumberInput.parseLong(text));
        } catch (IllegalArgumentException e) {
            return (Long) ctxt.handleWeirdStringValue(Long.class, text, "not a valid `java.lang.Long` value", new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final float _parseFloatPrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r7
            int r0 = r0.currentTokenId()
            switch(r0) {
                case 1: goto L_0x0054;
                case 2: goto L_0x0081;
                case 3: goto L_0x0061;
                case 4: goto L_0x0081;
                case 5: goto L_0x0081;
                case 6: goto L_0x0040;
                case 7: goto L_0x0048;
                case 8: goto L_0x0048;
                case 9: goto L_0x0081;
                case 10: goto L_0x0081;
                case 11: goto L_0x004d;
                default: goto L_0x0081;
            }
        L_0x0040:
            r0 = r7
            java.lang.String r0 = r0.getText()
            r9 = r0
            goto L_0x0090
        L_0x0048:
            r0 = r7
            float r0 = r0.getFloatValue()
            return r0
        L_0x004d:
            r0 = r6
            r1 = r8
            r0._verifyNullForPrimitive(r1)
            r0 = 0
            return r0
        L_0x0054:
            r0 = r8
            r1 = r7
            r2 = r6
            java.lang.Class r3 = java.lang.Float.TYPE
            java.lang.String r0 = r0.extractScalarFromObject(r1, r2, r3)
            r9 = r0
            goto L_0x0090
        L_0x0061:
            r0 = r8
            com.fasterxml.jackson.databind.DeserializationFeature r1 = com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r0.isEnabled(r1)
            if (r0 == 0) goto L_0x0081
            r0 = r7
            com.fasterxml.jackson.core.JsonToken r0 = r0.nextToken()
            r0 = r6
            r1 = r7
            r2 = r8
            float r0 = r0._parseFloatPrimitive(r1, r2)
            r10 = r0
            r0 = r6
            r1 = r7
            r2 = r8
            r0._verifyEndArrayForSingle(r1, r2)
            r0 = r10
            return r0
        L_0x0081:
            r0 = r8
            java.lang.Class r1 = java.lang.Float.TYPE
            r2 = r7
            java.lang.Object r0 = r0.handleUnexpectedToken(r1, r2)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            return r0
        L_0x0090:
            r0 = r6
            r1 = r9
            java.lang.Float r0 = r0._checkFloatSpecialValue(r1)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L_0x00a2
            r0 = r10
            float r0 = r0.floatValue()
            return r0
        L_0x00a2:
            r0 = r6
            r1 = r8
            r2 = r9
            com.fasterxml.jackson.databind.type.LogicalType r3 = com.fasterxml.jackson.databind.type.LogicalType.Integer
            java.lang.Class r4 = java.lang.Float.TYPE
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = r0._checkFromStringCoercion(r1, r2, r3, r4)
            r10 = r0
            r0 = r10
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull
            if (r0 != r1) goto L_0x00bf
            r0 = r6
            r1 = r8
            r0._verifyNullForPrimitive(r1)
            r0 = 0
            return r0
        L_0x00bf:
            r0 = r10
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsEmpty
            if (r0 != r1) goto L_0x00c9
            r0 = 0
            return r0
        L_0x00c9:
            r0 = r9
            java.lang.String r0 = r0.trim()
            r9 = r0
            r0 = r6
            r1 = r9
            boolean r0 = r0._hasTextualNull(r1)
            if (r0 == 0) goto L_0x00de
            r0 = r6
            r1 = r8
            r2 = r9
            r0._verifyNullForPrimitiveCoercion(r1, r2)
            r0 = 0
            return r0
        L_0x00de:
            r0 = r6
            r1 = r8
            r2 = r9
            float r0 = r0._parseFloatPrimitive(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseFloatPrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):float");
    }

    protected final float _parseFloatPrimitive(DeserializationContext ctxt, String text) throws IOException {
        try {
            return Float.parseFloat(text);
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(Float.TYPE, text, "not a valid `float` value", new Object[0])).floatValue();
        }
    }

    protected Float _checkFloatSpecialValue(String text) {
        if (text.isEmpty()) {
            return null;
        }
        switch (text.charAt(0)) {
            case '-':
                if (_isNegInf(text)) {
                    return Float.valueOf(Float.NEGATIVE_INFINITY);
                }
                return null;
            case 'I':
                if (_isPosInf(text)) {
                    return Float.valueOf(Float.POSITIVE_INFINITY);
                }
                return null;
            case 'N':
                if (_isNaN(text)) {
                    return Float.valueOf(Float.NaN);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final double _parseDoublePrimitive(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r7
            int r0 = r0.currentTokenId()
            switch(r0) {
                case 1: goto L_0x0054;
                case 2: goto L_0x0081;
                case 3: goto L_0x0061;
                case 4: goto L_0x0081;
                case 5: goto L_0x0081;
                case 6: goto L_0x0040;
                case 7: goto L_0x0048;
                case 8: goto L_0x0048;
                case 9: goto L_0x0081;
                case 10: goto L_0x0081;
                case 11: goto L_0x004d;
                default: goto L_0x0081;
            }
        L_0x0040:
            r0 = r7
            java.lang.String r0 = r0.getText()
            r9 = r0
            goto L_0x0090
        L_0x0048:
            r0 = r7
            double r0 = r0.getDoubleValue()
            return r0
        L_0x004d:
            r0 = r6
            r1 = r8
            r0._verifyNullForPrimitive(r1)
            r0 = 0
            return r0
        L_0x0054:
            r0 = r8
            r1 = r7
            r2 = r6
            java.lang.Class r3 = java.lang.Double.TYPE
            java.lang.String r0 = r0.extractScalarFromObject(r1, r2, r3)
            r9 = r0
            goto L_0x0090
        L_0x0061:
            r0 = r8
            com.fasterxml.jackson.databind.DeserializationFeature r1 = com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r0.isEnabled(r1)
            if (r0 == 0) goto L_0x0081
            r0 = r7
            com.fasterxml.jackson.core.JsonToken r0 = r0.nextToken()
            r0 = r6
            r1 = r7
            r2 = r8
            double r0 = r0._parseDoublePrimitive(r1, r2)
            r10 = r0
            r0 = r6
            r1 = r7
            r2 = r8
            r0._verifyEndArrayForSingle(r1, r2)
            r0 = r10
            return r0
        L_0x0081:
            r0 = r8
            java.lang.Class r1 = java.lang.Double.TYPE
            r2 = r7
            java.lang.Object r0 = r0.handleUnexpectedToken(r1, r2)
            java.lang.Number r0 = (java.lang.Number) r0
            double r0 = r0.doubleValue()
            return r0
        L_0x0090:
            r0 = r6
            r1 = r9
            java.lang.Double r0 = r0._checkDoubleSpecialValue(r1)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L_0x00a2
            r0 = r10
            double r0 = r0.doubleValue()
            return r0
        L_0x00a2:
            r0 = r6
            r1 = r8
            r2 = r9
            com.fasterxml.jackson.databind.type.LogicalType r3 = com.fasterxml.jackson.databind.type.LogicalType.Integer
            java.lang.Class r4 = java.lang.Double.TYPE
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = r0._checkFromStringCoercion(r1, r2, r3, r4)
            r10 = r0
            r0 = r10
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull
            if (r0 != r1) goto L_0x00bf
            r0 = r6
            r1 = r8
            r0._verifyNullForPrimitive(r1)
            r0 = 0
            return r0
        L_0x00bf:
            r0 = r10
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsEmpty
            if (r0 != r1) goto L_0x00c9
            r0 = 0
            return r0
        L_0x00c9:
            r0 = r9
            java.lang.String r0 = r0.trim()
            r9 = r0
            r0 = r6
            r1 = r9
            boolean r0 = r0._hasTextualNull(r1)
            if (r0 == 0) goto L_0x00de
            r0 = r6
            r1 = r8
            r2 = r9
            r0._verifyNullForPrimitiveCoercion(r1, r2)
            r0 = 0
            return r0
        L_0x00de:
            r0 = r6
            r1 = r8
            r2 = r9
            double r0 = r0._parseDoublePrimitive(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseDoublePrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):double");
    }

    protected final double _parseDoublePrimitive(DeserializationContext ctxt, String text) throws IOException {
        try {
            return _parseDouble(text);
        } catch (IllegalArgumentException e) {
            return _nonNullNumber((Number) ctxt.handleWeirdStringValue(Double.TYPE, text, "not a valid `double` value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    protected static final double _parseDouble(String numStr) throws NumberFormatException {
        if (NumberInput.NASTY_SMALL_DOUBLE.equals(numStr)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(numStr);
    }

    protected Double _checkDoubleSpecialValue(String text) {
        if (text.isEmpty()) {
            return null;
        }
        switch (text.charAt(0)) {
            case '-':
                if (_isNegInf(text)) {
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                }
                return null;
            case 'I':
                if (_isPosInf(text)) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
                return null;
            case 'N':
                if (_isNaN(text)) {
                    return Double.valueOf(Double.NaN);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    protected Date _parseDate(JsonParser p, DeserializationContext ctxt) throws IOException {
        char c;
        String text;
        switch (p.currentTokenId()) {
            case 1:
                text = ctxt.extractScalarFromObject(p, this, this._valueClass);
                break;
            case 2:
            case 4:
            case 5:
            case 8:
            case 9:
            case 10:
            default:
                return (Date) ctxt.handleUnexpectedToken(this._valueClass, p);
            case 3:
                return _parseDateFromArray(p, ctxt);
            case 6:
                text = p.getText();
                break;
            case 7:
                try {
                    c = p.getLongValue();
                } catch (StreamReadException e) {
                    c = ((Number) ctxt.handleWeirdNumberValue(this._valueClass, p.getNumberValue(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0])).longValue();
                }
                return new Date(c);
            case 11:
                return (Date) getNullValue(ctxt);
        }
        return _parseDate(text.trim(), ctxt);
    }

    protected Date _parseDateFromArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        CoercionAction act = _findCoercionFromEmptyArray(ctxt);
        boolean unwrap = ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (unwrap || act != CoercionAction.Fail) {
            if (p.nextToken() == JsonToken.END_ARRAY) {
                switch (act) {
                    case AsEmpty:
                        return (Date) getEmptyValue(ctxt);
                    case AsNull:
                    case TryConvert:
                        return (Date) getNullValue(ctxt);
                }
            } else if (unwrap) {
                Date parsed = _parseDate(p, ctxt);
                _verifyEndArrayForSingle(p, ctxt);
                return parsed;
            }
        }
        return (Date) ctxt.handleUnexpectedToken(this._valueClass, JsonToken.START_ARRAY, p, (String) null, new Object[0]);
    }

    protected Date _parseDate(String value, DeserializationContext ctxt) throws IOException {
        try {
            if (value.isEmpty()) {
                switch (_checkFromStringCoercion(ctxt, value)) {
                    case AsEmpty:
                        return new Date(0);
                    case AsNull:
                    case TryConvert:
                    default:
                        return null;
                }
            } else if (_hasTextualNull(value)) {
                return null;
            } else {
                return ctxt.parseDate(value);
            }
        } catch (IllegalArgumentException iae) {
            return (Date) ctxt.handleWeirdStringValue(this._valueClass, value, "not a valid representation (error: %s)", ClassUtil.exceptionMessage(iae));
        }
    }

    protected final String _parseString(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_STRING)) {
            return p.getText();
        }
        if (p.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
            Object ob = p.getEmbeddedObject();
            if (ob instanceof byte[]) {
                return ctxt.getBase64Variant().encode((byte[]) ob, false);
            }
            if (ob == null) {
                return null;
            }
            return ob.toString();
        } else if (p.hasToken(JsonToken.START_OBJECT)) {
            return ctxt.extractScalarFromObject(p, this, this._valueClass);
        } else {
            String value = p.getValueAsString();
            if (value != null) {
                return value;
            }
            return (String) ctxt.handleUnexpectedToken(String.class, p);
        }
    }

    protected boolean _hasTextualNull(String value) {
        return "null".equals(value);
    }

    protected final boolean _isNegInf(String text) {
        return "-Infinity".equals(text) || "-INF".equals(text);
    }

    protected final boolean _isPosInf(String text) {
        return "Infinity".equals(text) || "INF".equals(text);
    }

    protected final boolean _isNaN(String text) {
        return "NaN".equals(text);
    }

    protected static final boolean _isBlank(String text) {
        int len = text.length();
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) > ' ') {
                return false;
            }
        }
        return true;
    }

    protected CoercionAction _checkFromStringCoercion(DeserializationContext ctxt, String value) throws IOException {
        return _checkFromStringCoercion(ctxt, value, logicalType(), handledType());
    }

    protected CoercionAction _checkFromStringCoercion(DeserializationContext ctxt, String value, LogicalType logicalType, Class<?> rawTargetType) throws IOException {
        if (value.isEmpty()) {
            return _checkCoercionFail(ctxt, ctxt.findCoercionAction(logicalType, rawTargetType, CoercionInputShape.EmptyString), rawTargetType, value, "empty String (\"\")");
        }
        if (_isBlank(value)) {
            return _checkCoercionFail(ctxt, ctxt.findCoercionFromBlankString(logicalType, rawTargetType, CoercionAction.Fail), rawTargetType, value, "blank String (all whitespace)");
        }
        if (ctxt.isEnabled(StreamReadCapability.UNTYPED_SCALARS)) {
            return CoercionAction.TryConvert;
        }
        CoercionAction act = ctxt.findCoercionAction(logicalType, rawTargetType, CoercionInputShape.String);
        if (act == CoercionAction.Fail) {
            ctxt.reportInputMismatch(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", value, _coercedTypeDesc());
        }
        return act;
    }

    protected CoercionAction _checkFloatToIntCoercion(JsonParser p, DeserializationContext ctxt, Class<?> rawTargetType) throws IOException {
        CoercionAction act = ctxt.findCoercionAction(LogicalType.Integer, rawTargetType, CoercionInputShape.Float);
        if (act == CoercionAction.Fail) {
            return _checkCoercionFail(ctxt, act, rawTargetType, p.getNumberValue(), "Floating-point value (" + p.getText() + ")");
        }
        return act;
    }

    protected Boolean _coerceBooleanFromInt(JsonParser p, DeserializationContext ctxt, Class<?> rawTargetType) throws IOException {
        CoercionAction act = ctxt.findCoercionAction(LogicalType.Boolean, rawTargetType, CoercionInputShape.Integer);
        switch (act) {
            case AsEmpty:
                return Boolean.FALSE;
            case AsNull:
                return null;
            case TryConvert:
            default:
                if (p.getNumberType() == JsonParser.NumberType.INT) {
                    return Boolean.valueOf(p.getIntValue() != 0);
                }
                return Boolean.valueOf(!"0".equals(p.getText()));
            case Fail:
                _checkCoercionFail(ctxt, act, rawTargetType, p.getNumberValue(), "Integer value (" + p.getText() + ")");
                return Boolean.FALSE;
        }
    }

    protected CoercionAction _checkCoercionFail(DeserializationContext ctxt, CoercionAction act, Class<?> targetType, Object inputValue, String inputDesc) throws IOException {
        if (act == CoercionAction.Fail) {
            ctxt.reportBadCoercion(this, targetType, inputValue, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", inputDesc, _coercedTypeDesc());
        }
        return act;
    }

    protected boolean _checkTextualNull(DeserializationContext ctxt, String text) throws JsonMappingException {
        if (!_hasTextualNull(text)) {
            return false;
        }
        if (ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            return true;
        }
        _reportFailedNullCoerce(ctxt, true, MapperFeature.ALLOW_COERCION_OF_SCALARS, "String \"null\"");
        return true;
    }

    protected Object _coerceIntegral(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
            return p.getBigIntegerValue();
        }
        if (ctxt.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS)) {
            return Long.valueOf(p.getLongValue());
        }
        return p.getNumberValue();
    }

    protected final void _verifyNullForPrimitive(DeserializationContext ctxt) throws JsonMappingException {
        if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            ctxt.reportInputMismatch(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
        }
    }

    protected final void _verifyNullForPrimitiveCoercion(DeserializationContext ctxt, String str) throws JsonMappingException {
        boolean enable;
        Enum<?> feat;
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
            enable = true;
        } else if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            feat = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            enable = false;
        } else {
            return;
        }
        _reportFailedNullCoerce(ctxt, enable, feat, str.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", str));
    }

    protected void _reportFailedNullCoerce(DeserializationContext ctxt, boolean state, Enum<?> feature, String inputDesc) throws JsonMappingException {
        ctxt.reportInputMismatch(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", inputDesc, _coercedTypeDesc(), state ? "enable" : "disable", feature.getDeclaringClass().getSimpleName(), feature.name());
    }

    protected String _coercedTypeDesc() {
        String typeDesc;
        boolean structured;
        JavaType t = getValueType();
        if (t == null || t.isPrimitive()) {
            Class<?> cls = handledType();
            structured = cls.isArray() || Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
            typeDesc = ClassUtil.getClassDescription(cls);
        } else {
            structured = t.isContainerType() || t.isReferenceType();
            typeDesc = ClassUtil.getTypeDescription(t);
        }
        if (structured) {
            return "element of " + typeDesc;
        }
        return typeDesc + " value";
    }

    @Deprecated
    protected boolean _parseBooleanFromInt(JsonParser p, DeserializationContext ctxt) throws IOException {
        _verifyNumberForScalarCoercion(ctxt, p);
        return !"0".equals(p.getText());
    }

    @Deprecated
    protected void _verifyStringForScalarCoercion(DeserializationContext ctxt, String str) throws JsonMappingException {
        MapperFeature feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!ctxt.isEnabled(feat)) {
            ctxt.reportInputMismatch(this, "Cannot coerce String \"%s\" to %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), feat.getDeclaringClass().getSimpleName(), feat.name());
        }
    }

    @Deprecated
    protected Object _coerceEmptyString(DeserializationContext ctxt, boolean isPrimitive) throws JsonMappingException {
        boolean enable;
        Enum<?> feat;
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
            enable = true;
        } else if (!isPrimitive || !ctxt.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            return getNullValue(ctxt);
        } else {
            feat = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            enable = false;
        }
        _reportFailedNullCoerce(ctxt, enable, feat, "empty String (\"\")");
        return null;
    }

    @Deprecated
    protected void _failDoubleToIntCoercion(JsonParser p, DeserializationContext ctxt, String type) throws IOException {
        ctxt.reportInputMismatch(handledType(), "Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", p.getValueAsString(), type);
    }

    @Deprecated
    protected final void _verifyNullForScalarCoercion(DeserializationContext ctxt, String str) throws JsonMappingException {
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            _reportFailedNullCoerce(ctxt, true, MapperFeature.ALLOW_COERCION_OF_SCALARS, str.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", str));
        }
    }

    @Deprecated
    protected void _verifyNumberForScalarCoercion(DeserializationContext ctxt, JsonParser p) throws IOException {
        MapperFeature feat = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!ctxt.isEnabled(feat)) {
            ctxt.reportInputMismatch(this, "Cannot coerce Number (%s) to %s (enable `%s.%s` to allow)", p.getText(), _coercedTypeDesc(), feat.getDeclaringClass().getSimpleName(), feat.name());
        }
    }

    @Deprecated
    protected Object _coerceNullToken(DeserializationContext ctxt, boolean isPrimitive) throws JsonMappingException {
        if (isPrimitive) {
            _verifyNullForPrimitive(ctxt);
        }
        return getNullValue(ctxt);
    }

    @Deprecated
    protected Object _coerceTextualNull(DeserializationContext ctxt, boolean isPrimitive) throws JsonMappingException {
        if (!ctxt.isEnabled(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            _reportFailedNullCoerce(ctxt, true, MapperFeature.ALLOW_COERCION_OF_SCALARS, "String \"null\"");
        }
        return getNullValue(ctxt);
    }

    @Deprecated
    protected boolean _isEmptyOrTextualNull(String value) {
        return value.isEmpty() || "null".equals(value);
    }

    protected JsonDeserializer<Object> findDeserializer(DeserializationContext ctxt, JavaType type, BeanProperty property) throws JsonMappingException {
        return ctxt.findContextualValueDeserializer(type, property);
    }

    protected final boolean _isIntNumber(String text) {
        int i;
        int len = text.length();
        if (len <= 0) {
            return false;
        }
        char c = text.charAt(0);
        if (c != '-' && c != '+') {
            i = 0;
        } else if (len == 1) {
            return false;
        } else {
            i = 1;
        }
        while (i < len) {
            int ch = text.charAt(i);
            if (ch > 57 || ch < 48) {
                return false;
            }
            i++;
        }
        return true;
    }

    protected JsonDeserializer<?> findConvertingContentDeserializer(DeserializationContext ctxt, BeanProperty prop, JsonDeserializer<?> existingDeserializer) throws JsonMappingException {
        AnnotatedMember member;
        Object convDef;
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (!_neitherNull(intr, prop) || (member = prop.getMember()) == null || (convDef = intr.findDeserializationContentConverter(member)) == null) {
            return existingDeserializer;
        }
        Converter<Object, Object> conv = ctxt.converterInstance(prop.getMember(), convDef);
        JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
        if (existingDeserializer == null) {
            existingDeserializer = ctxt.findContextualValueDeserializer(delegateType, prop);
        }
        return new StdDelegatingDeserializer(conv, delegateType, existingDeserializer);
    }

    protected JsonFormat.Value findFormatOverrides(DeserializationContext ctxt, BeanProperty prop, Class<?> typeForDefaults) {
        if (prop != null) {
            return prop.findPropertyFormat(ctxt.getConfig(), typeForDefaults);
        }
        return ctxt.getDefaultPropertyFormat(typeForDefaults);
    }

    protected Boolean findFormatFeature(DeserializationContext ctxt, BeanProperty prop, Class<?> typeForDefaults, JsonFormat.Feature feat) {
        JsonFormat.Value format = findFormatOverrides(ctxt, prop, typeForDefaults);
        if (format != null) {
            return format.getFeature(feat);
        }
        return null;
    }

    protected final NullValueProvider findValueNullProvider(DeserializationContext ctxt, SettableBeanProperty prop, PropertyMetadata propMetadata) throws JsonMappingException {
        if (prop != null) {
            return _findNullProvider(ctxt, prop, propMetadata.getValueNulls(), prop.getValueDeserializer());
        }
        return null;
    }

    protected NullValueProvider findContentNullProvider(DeserializationContext ctxt, BeanProperty prop, JsonDeserializer<?> valueDeser) throws JsonMappingException {
        Nulls nulls = findContentNullStyle(ctxt, prop);
        if (nulls == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        }
        if (nulls != Nulls.FAIL) {
            NullValueProvider prov = _findNullProvider(ctxt, prop, nulls, valueDeser);
            if (prov != null) {
                return prov;
            }
            return valueDeser;
        } else if (prop != null) {
            return NullsFailProvider.constructForProperty(prop, prop.getType().getContentType());
        } else {
            JavaType type = ctxt.constructType(valueDeser.handledType());
            if (type.isContainerType()) {
                type = type.getContentType();
            }
            return NullsFailProvider.constructForRootValue(type);
        }
    }

    protected Nulls findContentNullStyle(DeserializationContext ctxt, BeanProperty prop) throws JsonMappingException {
        if (prop != null) {
            return prop.getMetadata().getContentNulls();
        }
        return ctxt.getConfig().getDefaultSetterInfo().getContentNulls();
    }

    protected final NullValueProvider _findNullProvider(DeserializationContext ctxt, BeanProperty prop, Nulls nulls, JsonDeserializer<?> valueDeser) throws JsonMappingException {
        if (nulls == Nulls.FAIL) {
            if (prop != null) {
                return NullsFailProvider.constructForProperty(prop);
            }
            return NullsFailProvider.constructForRootValue(ctxt.constructType(valueDeser == null ? Object.class : valueDeser.handledType()));
        } else if (nulls == Nulls.AS_EMPTY) {
            if (valueDeser == null) {
                return null;
            }
            if (valueDeser instanceof BeanDeserializerBase) {
                BeanDeserializerBase bd = (BeanDeserializerBase) valueDeser;
                if (!bd.getValueInstantiator().canCreateUsingDefault()) {
                    JavaType type = prop == null ? bd.getValueType() : prop.getType();
                    return (NullValueProvider) ctxt.reportBadDefinition(type, String.format("Cannot create empty instance of %s, no default Creator", type));
                }
            }
            AccessPattern access = valueDeser.getEmptyAccessPattern();
            if (access == AccessPattern.ALWAYS_NULL) {
                return NullsConstantProvider.nuller();
            }
            if (access == AccessPattern.CONSTANT) {
                return NullsConstantProvider.forValue(valueDeser.getEmptyValue(ctxt));
            }
            return new NullsAsEmptyProvider(valueDeser);
        } else if (nulls == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        } else {
            return null;
        }
    }

    protected CoercionAction _findCoercionFromEmptyString(DeserializationContext ctxt) {
        return ctxt.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
    }

    protected CoercionAction _findCoercionFromEmptyArray(DeserializationContext ctxt) {
        return ctxt.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyArray);
    }

    protected CoercionAction _findCoercionFromBlankString(DeserializationContext ctxt) {
        return ctxt.findCoercionFromBlankString(logicalType(), handledType(), CoercionAction.Fail);
    }

    /* access modifiers changed from: protected */
    public void handleUnknownProperty(JsonParser p, DeserializationContext ctxt, Object instanceOrClass, String propName) throws IOException {
        if (instanceOrClass == null) {
            instanceOrClass = handledType();
        }
        if (!ctxt.handleUnknownProperty(p, this, instanceOrClass, propName)) {
            p.skipChildren();
        }
    }

    protected void handleMissingEndArrayForSingle(JsonParser p, DeserializationContext ctxt) throws IOException {
        ctxt.reportWrongTokenException(this, JsonToken.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
    }

    protected void _verifyEndArrayForSingle(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.nextToken() != JsonToken.END_ARRAY) {
            handleMissingEndArrayForSingle(p, ctxt);
        }
    }

    protected static final boolean _neitherNull(Object a, Object b) {
        return (a == null || b == null) ? false : true;
    }

    protected final boolean _byteOverflow(int value) {
        return value < -128 || value > 255;
    }

    protected final boolean _shortOverflow(int value) {
        return value < -32768 || value > 32767;
    }

    protected final boolean _intOverflow(long value) {
        return value < -2147483648L || value > 2147483647L;
    }

    protected Number _nonNullNumber(Number n) {
        if (n == null) {
            n = 0;
        }
        return n;
    }
}
