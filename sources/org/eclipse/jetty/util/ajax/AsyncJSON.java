package org.eclipse.jetty.util.ajax;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.Utf8StringBuilder;
import org.eclipse.jetty.util.ajax.JSON;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON.class */
public class AsyncJSON {
    private static final Object UNSET = new Object();
    private final FrameStack stack = new FrameStack();
    private final NumberBuilder numberBuilder = new NumberBuilder();
    private final Utf8StringBuilder stringBuilder = new Utf8StringBuilder(32);
    private final Factory factory;
    private List<ByteBuffer> chunks;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$Context.class */
    public interface Context {
        int depth();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$State.class */
    public enum State {
        COMPLETE,
        NULL,
        TRUE,
        FALSE,
        NUMBER,
        STRING,
        ESCAPE,
        UNICODE,
        ARRAY,
        OBJECT,
        OBJECT_FIELD,
        OBJECT_FIELD_NAME,
        OBJECT_FIELD_VALUE
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$Factory.class */
    public static class Factory {
        private Trie<CachedString> cache;
        private Map<String, JSON.Convertor> convertors;
        private Function<List<?>, Object> arrayConverter = list -> {
            return list;
        };
        private boolean detailedParseException;

        public Function<List<?>, Object> getArrayConverter() {
            return this.arrayConverter;
        }

        public void setArrayConverter(Function<List<?>, Object> arrayConverter) {
            this.arrayConverter = (Function) Objects.requireNonNull(arrayConverter);
        }

        public boolean isDetailedParseException() {
            return this.detailedParseException;
        }

        public void setDetailedParseException(boolean detailedParseException) {
            this.detailedParseException = detailedParseException;
        }

        public boolean cache(String value) {
            if (this.cache == null) {
                this.cache = new ArrayTernaryTrie.Growing(false, 64, 64);
            }
            CachedString cached = new CachedString(value);
            if (!cached.isCacheable()) {
                return false;
            }
            this.cache.put(cached.encoded, cached);
            return true;
        }

        protected String cached(ByteBuffer buffer) {
            CachedString result;
            if (this.cache == null || (result = this.cache.getBest(buffer, 0, buffer.remaining())) == null) {
                return null;
            }
            buffer.position(buffer.position() + result.encoded.length());
            return result.value;
        }

        public AsyncJSON newAsyncJSON() {
            return new AsyncJSON(this);
        }

        public void putConvertor(String className, JSON.Convertor convertor) {
            if (this.convertors == null) {
                this.convertors = new ConcurrentHashMap();
            }
            this.convertors.put(className, convertor);
        }

        public JSON.Convertor removeConvertor(String className) {
            if (this.convertors != null) {
                return this.convertors.remove(className);
            }
            return null;
        }

        public JSON.Convertor getConvertor(String className) {
            if (this.convertors == null) {
                return null;
            }
            return this.convertors.get(className);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$Factory$CachedString.class */
        public static class CachedString {
            private final String encoded;
            private final String value;

            private CachedString(String value) {
                this.encoded = JSON.toString(value);
                this.value = value;
            }

            /* access modifiers changed from: private */
            public boolean isCacheable() {
                int i = this.encoded.length();
                do {
                    i--;
                    if (i <= 0) {
                        return true;
                    }
                } while (this.encoded.charAt(i) <= 127);
                return false;
            }
        }
    }

    public AsyncJSON(Factory factory) {
        this.factory = factory;
    }

    boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public boolean parse(byte[] bytes) {
        return parse(bytes, 0, bytes.length);
    }

    public boolean parse(byte[] bytes, int offset, int length) {
        return parse(ByteBuffer.wrap(bytes, offset, length));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d7, code lost:
        if (r6.hasRemaining() == false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00da, code lost:
        r0 = r6.position();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ed, code lost:
        if (isWhitespace(r6.get(r0)) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f0, code lost:
        r6.position(r0 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0103, code lost:
        throw newInvalidJSON(r6, "invalid character after JSON data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean parse(java.nio.ByteBuffer r6) {
        /*
        // Method dump skipped, instructions count: 458
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.AsyncJSON.parse(java.nio.ByteBuffer):boolean");
    }

    public <R> R complete() {
        try {
            if (this.stack.isEmpty()) {
                throw new IllegalStateException("no JSON parsed");
            }
            while (true) {
                State state = this.stack.peek().state;
                switch (state) {
                    case COMPLETE:
                        if (this.stack.peek().value != UNSET) {
                            return (R) end();
                        }
                        throw new IllegalStateException("invalid state " + state);
                    case NUMBER:
                        Number value = this.numberBuilder.value();
                        this.stack.pop();
                        this.stack.peek().value(value);
                    default:
                        throw newInvalidJSON(BufferUtil.EMPTY_BUFFER, "incomplete JSON");
                }
            }
        } catch (Throwable x) {
            reset();
            throw x;
        }
    }

    protected Map<String, Object> newObject(Context context) {
        return new HashMap();
    }

    protected List<Object> newArray(Context context) {
        return new ArrayList();
    }

    private Object end() {
        Object result = this.stack.peek().value;
        reset();
        return result;
    }

    private void reset() {
        this.stack.clear();
        this.chunks = null;
    }

    private boolean parseAny(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte peek = buffer.get(buffer.position());
            switch (peek) {
                case 34:
                    if (!parseString(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                case 45:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    if (!parseNumber(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                case 91:
                    if (!parseArray(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                case 102:
                    if (!parseFalse(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                case 110:
                    if (!parseNull(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                case 116:
                    if (!parseTrue(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                case 123:
                    if (!parseObject(buffer)) {
                        break;
                    } else {
                        return true;
                    }
                default:
                    if (isWhitespace(peek)) {
                        buffer.get();
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "unrecognized JSON value");
                    }
            }
        }
        return false;
    }

    private boolean parseNull(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            switch (buffer.get()) {
                case 108:
                    int index = ((Integer) this.stack.peek().value).intValue();
                    if (index == 2 || index == 3) {
                        parseNullCharacter(buffer, index);
                        if (index != 3) {
                            break;
                        } else {
                            this.stack.pop();
                            this.stack.peek().value(null);
                            return true;
                        }
                    } else {
                        throw newInvalidJSON(buffer, "invalid 'null' literal");
                    }
                case 110:
                    if (this.stack.peek().state != State.NULL) {
                        this.stack.push(State.NULL, 0);
                        parseNullCharacter(buffer, 0);
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid 'null' literal");
                    }
                case 117:
                    parseNullCharacter(buffer, 1);
                    break;
                default:
                    throw newInvalidJSON(buffer, "invalid 'null' literal");
            }
        }
        return false;
    }

    private void parseNullCharacter(ByteBuffer buffer, int index) {
        Frame frame = this.stack.peek();
        int value = ((Integer) frame.value).intValue();
        if (value == index) {
            frame.value = Integer.valueOf(value + 1);
            return;
        }
        throw newInvalidJSON(buffer, "invalid 'null' literal");
    }

    private boolean parseTrue(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            switch (buffer.get()) {
                case 101:
                    parseTrueCharacter(buffer, 3);
                    this.stack.pop();
                    this.stack.peek().value(Boolean.TRUE);
                    return true;
                case 114:
                    parseTrueCharacter(buffer, 1);
                    break;
                case 116:
                    if (this.stack.peek().state != State.TRUE) {
                        this.stack.push(State.TRUE, 0);
                        parseTrueCharacter(buffer, 0);
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid 'true' literal");
                    }
                case 117:
                    parseTrueCharacter(buffer, 2);
                    break;
                default:
                    throw newInvalidJSON(buffer, "invalid 'true' literal");
            }
        }
        return false;
    }

    private void parseTrueCharacter(ByteBuffer buffer, int index) {
        Frame frame = this.stack.peek();
        int value = ((Integer) frame.value).intValue();
        if (value == index) {
            frame.value = Integer.valueOf(value + 1);
            return;
        }
        throw newInvalidJSON(buffer, "invalid 'true' literal");
    }

    private boolean parseFalse(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            switch (buffer.get()) {
                case 97:
                    parseFalseCharacter(buffer, 1);
                    break;
                case 101:
                    parseFalseCharacter(buffer, 4);
                    this.stack.pop();
                    this.stack.peek().value(Boolean.FALSE);
                    return true;
                case 102:
                    if (this.stack.peek().state != State.FALSE) {
                        this.stack.push(State.FALSE, 0);
                        parseFalseCharacter(buffer, 0);
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid 'false' literal");
                    }
                case 108:
                    parseFalseCharacter(buffer, 2);
                    break;
                case 115:
                    parseFalseCharacter(buffer, 3);
                    break;
                default:
                    throw newInvalidJSON(buffer, "invalid 'false' literal");
            }
        }
        return false;
    }

    private void parseFalseCharacter(ByteBuffer buffer, int index) {
        Frame frame = this.stack.peek();
        int value = ((Integer) frame.value).intValue();
        if (value == index) {
            frame.value = Integer.valueOf(value + 1);
            return;
        }
        throw newInvalidJSON(buffer, "invalid 'false' literal");
    }

    private boolean parseNumber(ByteBuffer buffer) {
        if (this.stack.peek().state != State.NUMBER) {
            this.stack.push(State.NUMBER, this.numberBuilder);
        }
        while (buffer.hasRemaining()) {
            byte currentByte = buffer.get();
            switch (currentByte) {
                case 43:
                case 45:
                    if (this.numberBuilder.appendSign(currentByte)) {
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid number");
                    }
                case 44:
                case 47:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                default:
                    buffer.position(buffer.position() - 1);
                    Number value = this.numberBuilder.value();
                    this.stack.pop();
                    this.stack.peek().value(value);
                    return true;
                case 46:
                case 69:
                case 101:
                    if (this.numberBuilder.appendAlpha(currentByte)) {
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid number");
                    }
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    this.numberBuilder.appendDigit(currentByte);
                    break;
            }
        }
        return false;
    }

    private boolean parseString(ByteBuffer buffer) {
        String result;
        Frame frame = this.stack.peek();
        if (!buffer.hasRemaining() || frame.state == State.STRING || (result = this.factory.cached(buffer)) == null) {
            while (buffer.hasRemaining()) {
                byte currentByte = buffer.get();
                switch (currentByte) {
                    case 34:
                        if (this.stack.peek().state != State.STRING) {
                            this.stack.push(State.STRING, this.stringBuilder);
                            break;
                        } else {
                            String string = this.stringBuilder.toString();
                            this.stringBuilder.reset();
                            this.stack.pop();
                            this.stack.peek().value(string);
                            return true;
                        }
                    case 92:
                        buffer.position(buffer.position() - 1);
                        if (parseEscape(buffer)) {
                            break;
                        } else {
                            return false;
                        }
                    default:
                        this.stringBuilder.append(currentByte);
                        break;
                }
            }
            return false;
        }
        frame.value(result);
        return true;
    }

    private boolean parseEscape(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte currentByte = buffer.get();
            switch (currentByte) {
                case 34:
                case 47:
                    return parseEscapeCharacter((char) currentByte);
                case 92:
                    if (this.stack.peek().state == State.ESCAPE) {
                        return parseEscapeCharacter((char) currentByte);
                    }
                    this.stack.push(State.ESCAPE, this.stringBuilder);
                case 98:
                    return parseEscapeCharacter('\b');
                case 102:
                    return parseEscapeCharacter('\f');
                case 110:
                    return parseEscapeCharacter('\n');
                case 114:
                    return parseEscapeCharacter('\r');
                case 116:
                    return parseEscapeCharacter('\t');
                case 117:
                    this.stack.push(State.UNICODE, ByteBuffer.allocate(4));
                    return parseUnicode(buffer);
                default:
                    throw newInvalidJSON(buffer, "invalid escape sequence");
            }
        }
        return false;
    }

    private boolean parseEscapeCharacter(char escape) {
        this.stack.pop();
        this.stringBuilder.append(escape);
        return true;
    }

    private boolean parseUnicode(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte currentByte = buffer.get();
            ByteBuffer hex = (ByteBuffer) this.stack.peek().value;
            hex.put(hexToByte(buffer, currentByte));
            if (!hex.hasRemaining()) {
                int result = (hex.get(0) << 12) + (hex.get(1) << 8) + (hex.get(2) << 4) + hex.get(3);
                this.stack.pop();
                this.stack.pop();
                this.stringBuilder.append((char) result);
                return true;
            }
        }
        return false;
    }

    private byte hexToByte(ByteBuffer buffer, byte currentByte) {
        try {
            return TypeUtil.convertHexDigit(currentByte);
        } catch (Throwable th) {
            throw newInvalidJSON(buffer, "invalid hex digit");
        }
    }

    private boolean parseArray(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte peek = buffer.get(buffer.position());
            switch (peek) {
                case 44:
                    buffer.get();
                    break;
                case 91:
                    buffer.get();
                    this.stack.push(State.ARRAY, newArray(this.stack));
                    break;
                case 93:
                    buffer.get();
                    List<Object> array = (List) this.stack.peek().value;
                    this.stack.pop();
                    this.stack.peek().value(convertArray(array));
                    return true;
                default:
                    if (isWhitespace(peek)) {
                        buffer.get();
                        break;
                    } else if (parseAny(buffer)) {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return false;
    }

    private boolean parseObject(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte currentByte = buffer.get();
            switch (currentByte) {
                case 44:
                    break;
                case 123:
                    if (this.stack.peek().state != State.OBJECT) {
                        this.stack.push(State.OBJECT, newObject(this.stack));
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid object");
                    }
                case 125:
                    Map<String, Object> object = (Map) this.stack.peek().value;
                    this.stack.pop();
                    this.stack.peek().value(convertObject(object));
                    return true;
                default:
                    if (isWhitespace(currentByte)) {
                        continue;
                    } else {
                        buffer.position(buffer.position() - 1);
                        if (parseObjectField(buffer)) {
                            break;
                        } else {
                            return false;
                        }
                    }
            }
        }
        return false;
    }

    private boolean parseObjectField(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte peek = buffer.get(buffer.position());
            switch (peek) {
                case 34:
                    if (this.stack.peek().state != State.OBJECT) {
                        return parseObjectFieldValue(buffer);
                    }
                    this.stack.push(State.OBJECT_FIELD, UNSET);
                    if (parseObjectFieldName(buffer)) {
                        break;
                    } else {
                        return false;
                    }
                default:
                    if (isWhitespace(peek)) {
                        buffer.get();
                        break;
                    } else if (this.stack.peek().state == State.OBJECT_FIELD_VALUE) {
                        return parseObjectFieldValue(buffer);
                    } else {
                        throw newInvalidJSON(buffer, "invalid object field");
                    }
            }
        }
        return false;
    }

    private boolean parseObjectFieldName(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            byte peek = buffer.get(buffer.position());
            switch (peek) {
                case 34:
                    if (this.stack.peek().state == State.OBJECT_FIELD) {
                        this.stack.push(State.OBJECT_FIELD_NAME, UNSET);
                        if (parseString(buffer)) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        throw newInvalidJSON(buffer, "invalid object field");
                    }
                case 58:
                    buffer.get();
                    String fieldName = (String) this.stack.peek().value;
                    this.stack.pop();
                    this.stack.push(fieldName, State.OBJECT_FIELD_VALUE, UNSET);
                    return true;
                default:
                    if (isWhitespace(peek)) {
                        buffer.get();
                        break;
                    } else {
                        throw newInvalidJSON(buffer, "invalid object field");
                    }
            }
        }
        return false;
    }

    private boolean parseObjectFieldValue(ByteBuffer buffer) {
        if (this.stack.peek().value == UNSET && !parseAny(buffer)) {
            return false;
        }
        Frame frame = this.stack.peek();
        Object value = frame.value;
        String name = frame.name;
        this.stack.pop();
        this.stack.pop();
        ((Map) this.stack.peek().value).put(name, value);
        return true;
    }

    private Object convertArray(List<?> array) {
        return this.factory.getArrayConverter().apply(array);
    }

    private Object convertObject(Map<String, Object> object) {
        Object result = convertObject("x-class", object);
        if (result == null) {
            result = convertObject("class", object);
            if (result == null) {
                return object;
            }
        }
        return result;
    }

    private Object convertObject(String fieldName, Map<String, Object> object) {
        String className = (String) object.get(fieldName);
        if (className == null) {
            return null;
        }
        JSON.Convertible convertible = toConvertible(className);
        if (convertible != null) {
            convertible.fromJSON(object);
            return convertible;
        }
        JSON.Convertor convertor = this.factory.getConvertor(className);
        if (convertor != null) {
            return convertor.fromJSON(object);
        }
        return null;
    }

    private JSON.Convertible toConvertible(String className) {
        try {
            Class<?> klass = Loader.loadClass(className);
            if (JSON.Convertible.class.isAssignableFrom(klass)) {
                return (JSON.Convertible) klass.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return null;
        } catch (Throwable x) {
            throw new IllegalArgumentException(x);
        }
    }

    protected RuntimeException newInvalidJSON(ByteBuffer buffer, String message) {
        Utf8StringBuilder builder = new Utf8StringBuilder();
        builder.append(System.lineSeparator());
        int position = buffer.position();
        if (this.factory.isDetailedParseException()) {
            this.chunks.forEach(chunk -> {
                builder.append(buffer);
            });
        } else {
            buffer.position(0);
            builder.append(buffer);
            buffer.position(position);
        }
        builder.append(System.lineSeparator());
        String indent = "";
        if (position > 1) {
            char[] chars = new char[position - 1];
            Arrays.fill(chars, ' ');
            indent = new String(chars);
        }
        builder.append(indent);
        builder.append("^ ");
        builder.append(message);
        return new IllegalArgumentException(builder.toString());
    }

    private static boolean isWhitespace(byte ws) {
        switch (ws) {
            case 9:
            case 10:
            case 13:
            case 32:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$Frame.class */
    public static class Frame {
        private String name;
        private State state;
        private Object value;

        private Frame() {
        }

        /* access modifiers changed from: private */
        public void value(Object value) {
            switch (this.state) {
                case COMPLETE:
                case STRING:
                case OBJECT_FIELD_NAME:
                case OBJECT_FIELD_VALUE:
                    this.value = value;
                    return;
                case NULL:
                case TRUE:
                case FALSE:
                case NUMBER:
                case ESCAPE:
                case UNICODE:
                case OBJECT:
                case OBJECT_FIELD:
                default:
                    throw new IllegalStateException("invalid state " + this.state);
                case ARRAY:
                    ((List) this.value).add(value);
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$NumberBuilder.class */
    public static class NumberBuilder {
        private int integer;
        private long value;
        private StringBuilder builder;

        private NumberBuilder() {
            this.integer = 1;
        }

        /* access modifiers changed from: private */
        public boolean appendSign(byte b) {
            if (this.integer == 0) {
                if (this.builder.length() == 0) {
                    this.builder.append((char) b);
                    return true;
                }
                char c = this.builder.charAt(this.builder.length() - 1);
                if (c != 'E' && c != 'e') {
                    return false;
                }
                this.builder.append((char) b);
                return true;
            } else if (this.value != 0) {
                return false;
            } else {
                if (b != 45) {
                    return true;
                }
                if (this.integer != 1) {
                    return false;
                }
                this.integer = -1;
                return true;
            }
        }

        /* access modifiers changed from: private */
        public void appendDigit(byte b) {
            if (this.integer == 0) {
                this.builder.append((char) b);
            } else {
                this.value = (this.value * 10) + ((long) (b - 48));
            }
        }

        /* access modifiers changed from: private */
        public boolean appendAlpha(byte b) {
            if (this.integer == 0) {
                char c = this.builder.charAt(this.builder.length() - 1);
                if ('0' > c || c > '9' || this.builder.indexOf("" + ((char) b)) >= 0) {
                    return false;
                }
                this.builder.append((char) b);
                return true;
            }
            if (this.builder == null) {
                this.builder = new StringBuilder(16);
            }
            if (this.integer == -1) {
                this.builder.append('-');
            }
            this.integer = 0;
            this.builder.append(this.value);
            this.builder.append((char) b);
            return true;
        }

        /* access modifiers changed from: private */
        public Number value() {
            try {
                if (this.integer == 0) {
                    return Double.valueOf(Double.parseDouble(this.builder.toString()));
                }
                return Long.valueOf(((long) this.integer) * this.value);
            } finally {
                reset();
            }
        }

        private void reset() {
            this.integer = 1;
            this.value = 0;
            if (this.builder != null) {
                this.builder.setLength(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/AsyncJSON$FrameStack.class */
    public static class FrameStack implements Context {
        private final List<Frame> stack;
        private int cursor;

        private FrameStack() {
            this.stack = new ArrayList();
            grow(6);
        }

        private void grow(int grow) {
            for (int i = 0; i < grow; i++) {
                this.stack.add(new Frame());
            }
        }

        /* access modifiers changed from: private */
        public void clear() {
            while (!isEmpty()) {
                pop();
            }
        }

        /* access modifiers changed from: private */
        public boolean isEmpty() {
            return this.cursor == 0;
        }

        @Override // org.eclipse.jetty.util.ajax.AsyncJSON.Context
        public int depth() {
            return this.cursor - 1;
        }

        /* access modifiers changed from: private */
        public Frame peek() {
            if (!isEmpty()) {
                return this.stack.get(depth());
            }
            throw new IllegalStateException("empty stack");
        }

        /* access modifiers changed from: private */
        public void push(State state, Object value) {
            push(null, state, value);
        }

        /* access modifiers changed from: private */
        public void push(String name, State state, Object value) {
            if (this.cursor == this.stack.size()) {
                grow(2);
            }
            this.cursor++;
            Frame frame = this.stack.get(depth());
            frame.name = name;
            frame.state = state;
            frame.value = value;
        }

        /* access modifiers changed from: private */
        public void pop() {
            if (isEmpty()) {
                throw new IllegalStateException("empty stack");
            }
            Frame frame = this.stack.get(depth());
            this.cursor--;
            frame.name = null;
            frame.value = null;
            frame.state = null;
        }
    }
}
