package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.exc.InvalidNullException;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers.class */
public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> implements ContextualDeserializer {
    protected final Boolean _unwrapSingle;
    private transient Object _emptyValue;
    protected final NullValueProvider _nuller;

    protected abstract T _concat(T t, T t2);

    protected abstract T handleSingleElementUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    protected abstract PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nullValueProvider, Boolean bool);

    protected abstract T _constructEmpty();

    protected PrimitiveArrayDeserializers(Class<T> cls) {
        super((Class<?>) cls);
        this._unwrapSingle = null;
        this._nuller = null;
    }

    protected PrimitiveArrayDeserializers(PrimitiveArrayDeserializers<?> base, NullValueProvider nuller, Boolean unwrapSingle) {
        super(base._valueClass);
        this._unwrapSingle = unwrapSingle;
        this._nuller = nuller;
    }

    public static JsonDeserializer<?> forType(Class<?> rawType) {
        if (rawType == Integer.TYPE) {
            return IntDeser.instance;
        }
        if (rawType == Long.TYPE) {
            return LongDeser.instance;
        }
        if (rawType == Byte.TYPE) {
            return new ByteDeser();
        }
        if (rawType == Short.TYPE) {
            return new ShortDeser();
        }
        if (rawType == Float.TYPE) {
            return new FloatDeser();
        }
        if (rawType == Double.TYPE) {
            return new DoubleDeser();
        }
        if (rawType == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (rawType == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        Boolean unwrapSingle = findFormatFeature(ctxt, property, this._valueClass, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        NullValueProvider nuller = null;
        Nulls nullStyle = findContentNullStyle(ctxt, property);
        if (nullStyle == Nulls.SKIP) {
            nuller = NullsConstantProvider.skipper();
        } else if (nullStyle == Nulls.FAIL) {
            if (property == null) {
                nuller = NullsFailProvider.constructForRootValue(ctxt.constructType(this._valueClass.getComponentType()));
            } else {
                nuller = NullsFailProvider.constructForProperty(property, property.getType().getContentType());
            }
        }
        if (!Objects.equals(unwrapSingle, this._unwrapSingle) || nuller != this._nuller) {
            return withResolved(nuller, unwrapSingle);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        Object empty = this._emptyValue;
        if (empty == null) {
            Object _constructEmpty = _constructEmpty();
            empty = _constructEmpty;
            this._emptyValue = _constructEmpty;
        }
        return empty;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public T deserialize(JsonParser p, DeserializationContext ctxt, T existing) throws IOException {
        T newValue = deserialize(p, ctxt);
        if (existing == null) {
            return newValue;
        }
        if (Array.getLength(existing) == 0) {
            return newValue;
        }
        return _concat(existing, newValue);
    }

    protected T handleNonArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_STRING)) {
            return _deserializeFromString(p, ctxt);
        }
        if (this._unwrapSingle == Boolean.TRUE || (this._unwrapSingle == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return handleSingleElementUnwrapped(p, ctxt);
        }
        return (T) ctxt.handleUnexpectedToken(this._valueClass, p);
    }

    protected void _failOnNull(DeserializationContext ctxt) throws IOException {
        throw InvalidNullException.from(ctxt, (PropertyName) null, ctxt.constructType(this._valueClass));
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$CharDeser.class */
    public static final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        private static final long serialVersionUID = 1;

        public CharDeser() {
            super(char[].class);
        }

        protected CharDeser(CharDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return this;
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] _constructEmpty() {
            return new char[0];
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public char[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String str;
            if (p.hasToken(JsonToken.VALUE_STRING)) {
                char[] buffer = p.getTextCharacters();
                int offset = p.getTextOffset();
                int len = p.getTextLength();
                char[] result = new char[len];
                System.arraycopy(buffer, offset, result, 0, len);
                return result;
            } else if (p.isExpectedStartArrayToken()) {
                StringBuilder sb = new StringBuilder(64);
                while (true) {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        return sb.toString().toCharArray();
                    }
                    if (t == JsonToken.VALUE_STRING) {
                        str = p.getText();
                    } else if (t != JsonToken.VALUE_NULL) {
                        str = ((CharSequence) ctxt.handleUnexpectedToken(Character.TYPE, p)).toString();
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        str = "��";
                    }
                    if (str.length() != 1) {
                        ctxt.reportInputMismatch(this, "Cannot convert a JSON String of length %d into a char element of char array", Integer.valueOf(str.length()));
                    }
                    sb.append(str.charAt(0));
                }
            } else {
                if (p.hasToken(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                    Object ob = p.getEmbeddedObject();
                    if (ob == null) {
                        return null;
                    }
                    if (ob instanceof char[]) {
                        return (char[]) ob;
                    }
                    if (ob instanceof String) {
                        return ((String) ob).toCharArray();
                    }
                    if (ob instanceof byte[]) {
                        return Base64Variants.getDefaultVariant().encode((byte[]) ob, false).toCharArray();
                    }
                }
                return (char[]) ctxt.handleUnexpectedToken(this._valueClass, p);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return (char[]) ctxt.handleUnexpectedToken(this._valueClass, p);
        }

        /* access modifiers changed from: protected */
        public char[] _concat(char[] oldValue, char[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            char[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$BooleanDeser.class */
    public static final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        private static final long serialVersionUID = 1;

        public BooleanDeser() {
            super(boolean[].class);
        }

        protected BooleanDeser(BooleanDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new BooleanDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] _constructEmpty() {
            return new boolean[0];
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public boolean[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            boolean value;
            if (!p.isExpectedStartArrayToken()) {
                return handleNonArray(p, ctxt);
            }
            ArrayBuilders.BooleanBuilder builder = ctxt.getArrayBuilders().getBooleanBuilder();
            boolean[] chunk = builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        return builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t == JsonToken.VALUE_TRUE) {
                        value = true;
                    } else if (t == JsonToken.VALUE_FALSE) {
                        value = false;
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = _parseBooleanPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = false;
                    }
                    if (ix >= chunk.length) {
                        chunk = builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    ix++;
                    chunk[ix] = value;
                } catch (Exception e) {
                    throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new boolean[]{_parseBooleanPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public boolean[] _concat(boolean[] oldValue, boolean[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            boolean[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$ByteDeser.class */
    public static final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        private static final long serialVersionUID = 1;

        public ByteDeser() {
            super(byte[].class);
        }

        protected ByteDeser(ByteDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new ByteDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] _constructEmpty() {
            return new byte[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers, com.fasterxml.jackson.databind.JsonDeserializer
        public LogicalType logicalType() {
            return LogicalType.Binary;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public byte[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            byte value;
            JsonToken t = p.currentToken();
            if (t == JsonToken.VALUE_STRING) {
                try {
                    return p.getBinaryValue(ctxt.getBase64Variant());
                } catch (StreamReadException e) {
                    String msg = e.getOriginalMessage();
                    if (msg.contains("base64")) {
                        return (byte[]) ctxt.handleWeirdStringValue(byte[].class, p.getText(), msg, new Object[0]);
                    }
                }
            }
            if (t == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object ob = p.getEmbeddedObject();
                if (ob == null) {
                    return null;
                }
                if (ob instanceof byte[]) {
                    return (byte[]) ob;
                }
            }
            if (!p.isExpectedStartArrayToken()) {
                return handleNonArray(p, ctxt);
            }
            ArrayBuilders.ByteBuilder builder = ctxt.getArrayBuilders().getByteBuilder();
            byte[] chunk = builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken t2 = p.nextToken();
                    if (t2 == JsonToken.END_ARRAY) {
                        return builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t2 == JsonToken.VALUE_NUMBER_INT) {
                        value = p.getByteValue();
                    } else if (t2 != JsonToken.VALUE_NULL) {
                        value = _parseBytePrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = 0;
                    }
                    if (ix >= chunk.length) {
                        chunk = builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    ix++;
                    chunk[ix] = value;
                } catch (Exception e2) {
                    throw JsonMappingException.wrapWithPath(e2, chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            byte value;
            JsonToken t = p.currentToken();
            if (t == JsonToken.VALUE_NUMBER_INT) {
                value = p.getByteValue();
            } else if (t != JsonToken.VALUE_NULL) {
                value = ((Number) ctxt.handleUnexpectedToken(this._valueClass.getComponentType(), p)).byteValue();
            } else if (this._nuller != null) {
                this._nuller.getNullValue(ctxt);
                return (byte[]) getEmptyValue(ctxt);
            } else {
                _verifyNullForPrimitive(ctxt);
                return null;
            }
            return new byte[]{value};
        }

        /* access modifiers changed from: protected */
        public byte[] _concat(byte[] oldValue, byte[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            byte[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$ShortDeser.class */
    public static final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        private static final long serialVersionUID = 1;

        public ShortDeser() {
            super(short[].class);
        }

        protected ShortDeser(ShortDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new ShortDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] _constructEmpty() {
            return new short[0];
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public short[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            short value;
            if (!p.isExpectedStartArrayToken()) {
                return handleNonArray(p, ctxt);
            }
            ArrayBuilders.ShortBuilder builder = ctxt.getArrayBuilders().getShortBuilder();
            short[] chunk = builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        return builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t != JsonToken.VALUE_NULL) {
                        value = _parseShortPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = 0;
                    }
                    if (ix >= chunk.length) {
                        chunk = builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    ix++;
                    chunk[ix] = value;
                } catch (Exception e) {
                    throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new short[]{_parseShortPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public short[] _concat(short[] oldValue, short[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            short[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$IntDeser.class */
    public static final class IntDeser extends PrimitiveArrayDeserializers<int[]> {
        private static final long serialVersionUID = 1;
        public static final IntDeser instance = new IntDeser();

        public IntDeser() {
            super(int[].class);
        }

        protected IntDeser(IntDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new IntDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] _constructEmpty() {
            return new int[0];
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public int[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            int value;
            if (!p.isExpectedStartArrayToken()) {
                return handleNonArray(p, ctxt);
            }
            ArrayBuilders.IntBuilder builder = ctxt.getArrayBuilders().getIntBuilder();
            int[] chunk = builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        return builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t == JsonToken.VALUE_NUMBER_INT) {
                        value = p.getIntValue();
                    } else if (t != JsonToken.VALUE_NULL) {
                        value = _parseIntPrimitive(p, ctxt);
                    } else if (this._nuller != null) {
                        this._nuller.getNullValue(ctxt);
                    } else {
                        _verifyNullForPrimitive(ctxt);
                        value = 0;
                    }
                    if (ix >= chunk.length) {
                        chunk = builder.appendCompletedChunk(chunk, ix);
                        ix = 0;
                    }
                    ix++;
                    chunk[ix] = value;
                } catch (Exception e) {
                    throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new int[]{_parseIntPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public int[] _concat(int[] oldValue, int[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            int[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$LongDeser.class */
    public static final class LongDeser extends PrimitiveArrayDeserializers<long[]> {
        private static final long serialVersionUID = 1;
        public static final LongDeser instance = new LongDeser();

        public LongDeser() {
            super(long[].class);
        }

        protected LongDeser(LongDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new LongDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] _constructEmpty() {
            return new long[0];
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [long] */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r0v27, types: [long] */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long[] deserialize(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) throws java.io.IOException {
            /*
                r5 = this;
                r0 = r6
                boolean r0 = r0.isExpectedStartArrayToken()
                if (r0 != 0) goto L_0x0011
                r0 = r5
                r1 = r6
                r2 = r7
                java.lang.Object r0 = r0.handleNonArray(r1, r2)
                long[] r0 = (long[]) r0
                return r0
            L_0x0011:
                r0 = r7
                com.fasterxml.jackson.databind.util.ArrayBuilders r0 = r0.getArrayBuilders()
                com.fasterxml.jackson.databind.util.ArrayBuilders$LongBuilder r0 = r0.getLongBuilder()
                r8 = r0
                r0 = r8
                java.lang.Object r0 = r0.resetAndStart()
                long[] r0 = (long[]) r0
                r9 = r0
                r0 = 0
                r10 = r0
            L_0x0025:
                r0 = r6
                com.fasterxml.jackson.core.JsonToken r0 = r0.nextToken()     // Catch: Exception -> 0x009b
                r1 = r0
                r11 = r1
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.END_ARRAY     // Catch: Exception -> 0x009b
                if (r0 == r1) goto L_0x0098
                r0 = r11
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT     // Catch: Exception -> 0x009b
                if (r0 != r1) goto L_0x0043
                r0 = r6
                long r0 = r0.getLongValue()     // Catch: Exception -> 0x009b
                r12 = r0
                goto L_0x0073
            L_0x0043:
                r0 = r11
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL     // Catch: Exception -> 0x009b
                if (r0 != r1) goto L_0x006b
                r0 = r5
                com.fasterxml.jackson.databind.deser.NullValueProvider r0 = r0._nuller     // Catch: Exception -> 0x009b
                if (r0 == 0) goto L_0x0060
                r0 = r5
                com.fasterxml.jackson.databind.deser.NullValueProvider r0 = r0._nuller     // Catch: Exception -> 0x009b
                r1 = r7
                java.lang.Object r0 = r0.getNullValue(r1)     // Catch: Exception -> 0x009b
                goto L_0x0025
            L_0x0060:
                r0 = r5
                r1 = r7
                r0._verifyNullForPrimitive(r1)     // Catch: Exception -> 0x009b
                r0 = 0
                r12 = r0
                goto L_0x0073
            L_0x006b:
                r0 = r5
                r1 = r6
                r2 = r7
                long r0 = r0._parseLongPrimitive(r1, r2)     // Catch: Exception -> 0x009b
                r12 = r0
            L_0x0073:
                r0 = r10
                r1 = r9
                int r1 = r1.length     // Catch: Exception -> 0x009b
                if (r0 < r1) goto L_0x008b
                r0 = r8
                r1 = r9
                r2 = r10
                java.lang.Object r0 = r0.appendCompletedChunk(r1, r2)     // Catch: Exception -> 0x009b
                long[] r0 = (long[]) r0     // Catch: Exception -> 0x009b
                r9 = r0
                r0 = 0
                r10 = r0
            L_0x008b:
                r0 = r9
                r1 = r10
                int r10 = r10 + 1
                r2 = r12
                r0[r1] = r2     // Catch: Exception -> 0x009b
                goto L_0x0025
            L_0x0098:
                goto L_0x00ac
            L_0x009b:
                r11 = move-exception
                r0 = r11
                r1 = r9
                r2 = r8
                int r2 = r2.bufferedSize()
                r3 = r10
                int r2 = r2 + r3
                com.fasterxml.jackson.databind.JsonMappingException r0 = com.fasterxml.jackson.databind.JsonMappingException.wrapWithPath(r0, r1, r2)
                throw r0
            L_0x00ac:
                r0 = r8
                r1 = r9
                r2 = r10
                java.lang.Object r0 = r0.completeAndClearBuffer(r1, r2)
                long[] r0 = (long[]) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.LongDeser.deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):long[]");
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new long[]{_parseLongPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public long[] _concat(long[] oldValue, long[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            long[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$FloatDeser.class */
    public static final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        private static final long serialVersionUID = 1;

        public FloatDeser() {
            super(float[].class);
        }

        protected FloatDeser(FloatDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new FloatDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] _constructEmpty() {
            return new float[0];
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public float[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (!p.isExpectedStartArrayToken()) {
                return handleNonArray(p, ctxt);
            }
            ArrayBuilders.FloatBuilder builder = ctxt.getArrayBuilders().getFloatBuilder();
            float[] chunk = builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        return builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t != JsonToken.VALUE_NULL || this._nuller == null) {
                        float value = _parseFloatPrimitive(p, ctxt);
                        if (ix >= chunk.length) {
                            chunk = builder.appendCompletedChunk(chunk, ix);
                            ix = 0;
                        }
                        ix++;
                        chunk[ix] = value;
                    } else {
                        this._nuller.getNullValue(ctxt);
                    }
                } catch (Exception e) {
                    throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new float[]{_parseFloatPrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public float[] _concat(float[] oldValue, float[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            float[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$DoubleDeser.class */
    public static final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        private static final long serialVersionUID = 1;

        public DoubleDeser() {
            super(double[].class);
        }

        protected DoubleDeser(DoubleDeser base, NullValueProvider nuller, Boolean unwrapSingle) {
            super(base, nuller, unwrapSingle);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        protected PrimitiveArrayDeserializers<?> withResolved(NullValueProvider nuller, Boolean unwrapSingle) {
            return new DoubleDeser(this, nuller, unwrapSingle);
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] _constructEmpty() {
            return new double[0];
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public double[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (!p.isExpectedStartArrayToken()) {
                return handleNonArray(p, ctxt);
            }
            ArrayBuilders.DoubleBuilder builder = ctxt.getArrayBuilders().getDoubleBuilder();
            double[] chunk = builder.resetAndStart();
            int ix = 0;
            while (true) {
                try {
                    JsonToken t = p.nextToken();
                    if (t == JsonToken.END_ARRAY) {
                        return builder.completeAndClearBuffer(chunk, ix);
                    }
                    if (t != JsonToken.VALUE_NULL || this._nuller == null) {
                        double value = _parseDoublePrimitive(p, ctxt);
                        if (ix >= chunk.length) {
                            chunk = builder.appendCompletedChunk(chunk, ix);
                            ix = 0;
                        }
                        ix++;
                        chunk[ix] = value;
                    } else {
                        this._nuller.getNullValue(ctxt);
                    }
                } catch (Exception e) {
                    throw JsonMappingException.wrapWithPath(e, chunk, builder.bufferedSize() + ix);
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] handleSingleElementUnwrapped(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new double[]{_parseDoublePrimitive(p, ctxt)};
        }

        /* access modifiers changed from: protected */
        public double[] _concat(double[] oldValue, double[] newValue) {
            int len1 = oldValue.length;
            int len2 = newValue.length;
            double[] result = Arrays.copyOf(oldValue, len1 + len2);
            System.arraycopy(newValue, 0, result, len1, len2);
            return result;
        }
    }
}
