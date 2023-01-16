package org.eclipse.jetty.util.ajax;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.IntStream;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON.class */
public class JSON {
    static final Logger LOG = Log.getLogger(JSON.class);
    public static final JSON DEFAULT = new JSON();
    private final Map<String, Convertor> _convertors = new ConcurrentHashMap();
    private int _stringBufferSize = 1024;
    private Function<List<?>, Object> _arrayConverter = this::defaultArrayConverter;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$Convertible.class */
    public interface Convertible {
        void toJSON(Output output);

        void fromJSON(Map map);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$Convertor.class */
    public interface Convertor {
        void toJSON(Object obj, Output output);

        Object fromJSON(Map map);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$Generator.class */
    public interface Generator {
        void addJSON(Appendable appendable);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$Output.class */
    public interface Output {
        void addClass(Class cls);

        void add(Object obj);

        void add(String str, Object obj);

        void add(String str, double d);

        void add(String str, long j);

        void add(String str, boolean z);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$Source.class */
    public interface Source {
        boolean hasNext();

        char next();

        char peek();

        char[] scratchBuffer();
    }

    public static void reset() {
        DEFAULT._convertors.clear();
        DEFAULT._stringBufferSize = 1024;
    }

    public int getStringBufferSize() {
        return this._stringBufferSize;
    }

    public void setStringBufferSize(int stringBufferSize) {
        this._stringBufferSize = stringBufferSize;
    }

    public static void registerConvertor(Class forClass, Convertor convertor) {
        DEFAULT.addConvertor(forClass, convertor);
    }

    public static JSON getDefault() {
        return DEFAULT;
    }

    @Deprecated
    public static void setDefault(JSON json) {
    }

    public static String toString(Object object) {
        StringBuilder buffer = new StringBuilder(DEFAULT.getStringBufferSize());
        DEFAULT.append(buffer, object);
        return buffer.toString();
    }

    public static String toString(Map object) {
        StringBuilder buffer = new StringBuilder(DEFAULT.getStringBufferSize());
        DEFAULT.appendMap(buffer, object);
        return buffer.toString();
    }

    public static String toString(Object[] array) {
        StringBuilder buffer = new StringBuilder(DEFAULT.getStringBufferSize());
        DEFAULT.appendArray(buffer, array);
        return buffer.toString();
    }

    public static Object parse(String s) {
        return DEFAULT.parse((Source) new StringSource(s), false);
    }

    public static Object parse(String s, boolean stripOuterComment) {
        return DEFAULT.parse(new StringSource(s), stripOuterComment);
    }

    public static Object parse(Reader in) throws IOException {
        return DEFAULT.parse((Source) new ReaderSource(in), false);
    }

    public static Object parse(Reader in, boolean stripOuterComment) throws IOException {
        return DEFAULT.parse(new ReaderSource(in), stripOuterComment);
    }

    @Deprecated
    public static Object parse(InputStream in) throws IOException {
        return DEFAULT.parse((Source) new StringSource(C5747IO.toString(in)), false);
    }

    @Deprecated
    public static Object parse(InputStream in, boolean stripOuterComment) throws IOException {
        return DEFAULT.parse(new StringSource(C5747IO.toString(in)), stripOuterComment);
    }

    /* access modifiers changed from: private */
    public void quotedEscape(Appendable buffer, String input) {
        try {
            buffer.append('\"');
            if (input != null && !input.isEmpty()) {
                escapeString(buffer, input);
            }
            buffer.append('\"');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escapeString(Appendable buffer, String input) throws IOException {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < ' ' || c > '~') {
                if (c == '\b') {
                    buffer.append("\\b");
                } else if (c == '\f') {
                    buffer.append("\\f");
                } else if (c == '\n') {
                    buffer.append("\\n");
                } else if (c == '\r') {
                    buffer.append("\\r");
                } else if (c == '\t') {
                    buffer.append("\\t");
                } else if (c < ' ' || c == 127) {
                    buffer.append(String.format("\\u%04x", Short.valueOf((short) c)));
                } else {
                    escapeUnicode(buffer, c);
                }
            } else if (c == '\"' || c == '\\') {
                buffer.append('\\').append(c);
            } else {
                buffer.append(c);
            }
        }
    }

    protected void escapeUnicode(Appendable buffer, char c) throws IOException {
        buffer.append(c);
    }

    public String toJSON(Object object) {
        StringBuilder buffer = new StringBuilder(getStringBufferSize());
        append(buffer, object);
        return buffer.toString();
    }

    public Object fromJSON(String json) {
        return parse(new StringSource(json));
    }

    @Deprecated
    public void append(StringBuffer buffer, Object object) {
        append((Appendable) buffer, object);
    }

    public void append(Appendable buffer, Object object) {
        try {
            if (object == null) {
                buffer.append("null");
            } else if (object instanceof Map) {
                appendMap(buffer, (Map) object);
            } else if (object instanceof String) {
                appendString(buffer, (String) object);
            } else if (object instanceof Number) {
                appendNumber(buffer, (Number) object);
            } else if (object instanceof Boolean) {
                appendBoolean(buffer, (Boolean) object);
            } else if (object.getClass().isArray()) {
                appendArray(buffer, object);
            } else if (object instanceof Character) {
                appendString(buffer, object.toString());
            } else if (object instanceof Convertible) {
                appendJSON(buffer, (Convertible) object);
            } else if (object instanceof Generator) {
                appendJSON(buffer, (Generator) object);
            } else {
                Convertor convertor = getConvertor(object.getClass());
                if (convertor != null) {
                    appendJSON(buffer, convertor, object);
                } else if (object instanceof Collection) {
                    appendArray(buffer, (Collection) object);
                } else {
                    appendString(buffer, object.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendNull(StringBuffer buffer) {
        appendNull((Appendable) buffer);
    }

    public void appendNull(Appendable buffer) {
        try {
            buffer.append("null");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendJSON(StringBuffer buffer, Convertor convertor, Object object) {
        appendJSON((Appendable) buffer, convertor, object);
    }

    public void appendJSON(Appendable buffer, final Convertor convertor, final Object object) {
        appendJSON(buffer, new Convertible() { // from class: org.eclipse.jetty.util.ajax.JSON.1
            @Override // org.eclipse.jetty.util.ajax.JSON.Convertible
            public void fromJSON(Map object2) {
            }

            @Override // org.eclipse.jetty.util.ajax.JSON.Convertible
            public void toJSON(Output out) {
                convertor.toJSON(object, out);
            }
        });
    }

    @Deprecated
    public void appendJSON(StringBuffer buffer, Convertible converter) {
        appendJSON((Appendable) buffer, converter);
    }

    public void appendJSON(Appendable buffer, Convertible converter) {
        ConvertableOutput out = new ConvertableOutput(buffer);
        converter.toJSON(out);
        out.complete();
    }

    @Deprecated
    public void appendJSON(StringBuffer buffer, Generator generator) {
        generator.addJSON(buffer);
    }

    public void appendJSON(Appendable buffer, Generator generator) {
        generator.addJSON(buffer);
    }

    @Deprecated
    public void appendMap(StringBuffer buffer, Map<?, ?> map) {
        appendMap((Appendable) buffer, map);
    }

    public void appendMap(Appendable buffer, Map<?, ?> map) {
        try {
            if (map == null) {
                appendNull(buffer);
                return;
            }
            buffer.append('{');
            Iterator<?> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<?, ?> entry = iter.next();
                quotedEscape(buffer, entry.getKey().toString());
                buffer.append(':');
                append(buffer, entry.getValue());
                if (iter.hasNext()) {
                    buffer.append(',');
                }
            }
            buffer.append('}');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendArray(StringBuffer buffer, Collection collection) {
        appendArray((Appendable) buffer, collection);
    }

    public void appendArray(Appendable buffer, Collection collection) {
        try {
            if (collection == null) {
                appendNull(buffer);
                return;
            }
            buffer.append('[');
            boolean first = true;
            for (Object obj : collection) {
                if (!first) {
                    buffer.append(',');
                }
                first = false;
                append(buffer, obj);
            }
            buffer.append(']');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendArray(StringBuffer buffer, Object array) {
        appendArray((Appendable) buffer, array);
    }

    public void appendArray(Appendable buffer, Object array) {
        try {
            if (array == null) {
                appendNull(buffer);
                return;
            }
            buffer.append('[');
            int length = Array.getLength(array);
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    buffer.append(',');
                }
                append(buffer, Array.get(array, i));
            }
            buffer.append(']');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendBoolean(StringBuffer buffer, Boolean b) {
        appendBoolean((Appendable) buffer, b);
    }

    public void appendBoolean(Appendable buffer, Boolean b) {
        try {
            if (b == null) {
                appendNull(buffer);
            } else {
                buffer.append(b.booleanValue() ? C3P0Substitutions.DEBUG : "false");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendNumber(StringBuffer buffer, Number number) {
        appendNumber((Appendable) buffer, number);
    }

    public void appendNumber(Appendable buffer, Number number) {
        try {
            if (number == null) {
                appendNull(buffer);
            } else {
                buffer.append(String.valueOf(number));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void appendString(StringBuffer buffer, String string) {
        appendString((Appendable) buffer, string);
    }

    public void appendString(Appendable buffer, String string) {
        if (string == null) {
            appendNull(buffer);
        } else {
            quotedEscape(buffer, string);
        }
    }

    protected String toString(char[] buffer, int offset, int length) {
        return new String(buffer, offset, length);
    }

    protected Map<String, Object> newMap() {
        return new HashMap();
    }

    @Deprecated
    protected Object[] newArray(int size) {
        return new Object[size];
    }

    protected JSON contextForArray() {
        return this;
    }

    protected JSON contextFor(String field) {
        return this;
    }

    protected Object convertTo(Class type, Map map) {
        if (type == null || !Convertible.class.isAssignableFrom(type)) {
            Convertor convertor = getConvertor(type);
            if (convertor != null) {
                return convertor.fromJSON(map);
            }
            return map;
        }
        try {
            Convertible conv = (Convertible) type.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            conv.fromJSON(map);
            return conv;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addConvertor(Class forClass, Convertor convertor) {
        this._convertors.put(forClass.getName(), convertor);
    }

    protected Convertor getConvertor(Class forClass) {
        Class cls = forClass;
        Convertor convertor = this._convertors.get(cls.getName());
        if (convertor == null && this != DEFAULT) {
            convertor = DEFAULT.getConvertor(cls);
        }
        while (convertor == null && cls != Object.class) {
            Class[] ifs = cls.getInterfaces();
            int i = 0;
            while (convertor == null && i < ifs.length) {
                i++;
                convertor = this._convertors.get(ifs[i].getName());
            }
            if (convertor == null) {
                cls = cls.getSuperclass();
                convertor = this._convertors.get(cls.getName());
            }
        }
        return convertor;
    }

    public void addConvertorFor(String name, Convertor convertor) {
        this._convertors.put(name, convertor);
    }

    public Convertor removeConvertorFor(String name) {
        return this._convertors.remove(name);
    }

    public Function<List<?>, Object> getArrayConverter() {
        return this._arrayConverter;
    }

    public void setArrayConverter(Function<List<?>, Object> arrayConverter) {
        this._arrayConverter = (Function) Objects.requireNonNull(arrayConverter);
    }

    public Convertor getConvertorFor(String name) {
        Convertor convertor = this._convertors.get(name);
        if (convertor == null && this != DEFAULT) {
            convertor = DEFAULT.getConvertorFor(name);
        }
        return convertor;
    }

    public Object parse(Source source, boolean stripOuterComment) {
        int commentState = 0;
        if (!stripOuterComment) {
            return parse(source);
        }
        int stripState = 1;
        Object o = null;
        while (source.hasNext()) {
            char c = source.peek();
            if (commentState == 1) {
                switch (c) {
                    case '*':
                        commentState = 2;
                        if (stripState == 1) {
                            commentState = 0;
                            stripState = 2;
                            break;
                        }
                        break;
                    case '/':
                        commentState = -1;
                        break;
                }
            } else if (commentState > 1) {
                switch (c) {
                    case '*':
                        commentState = 3;
                        break;
                    case '/':
                        if (commentState != 3) {
                            commentState = 2;
                            break;
                        } else {
                            commentState = 0;
                            if (stripState == 2) {
                                return o;
                            }
                        }
                        break;
                    default:
                        commentState = 2;
                        break;
                }
            } else if (commentState < 0) {
                switch (c) {
                    case '\n':
                    case '\r':
                        commentState = 0;
                        break;
                }
            } else if (!Character.isWhitespace(c)) {
                if (c == '/') {
                    commentState = 1;
                } else if (c == '*') {
                    commentState = 3;
                } else if (o == null) {
                    o = parse(source);
                }
            }
            source.next();
        }
        return o;
    }

    public Object parse(Source source) {
        int commentState = 0;
        while (source.hasNext()) {
            char c = source.peek();
            if (commentState == 1) {
                switch (c) {
                    case '*':
                        commentState = 2;
                        continue;
                    case '/':
                        commentState = -1;
                        continue;
                }
            } else if (commentState > 1) {
                switch (c) {
                    case '*':
                        commentState = 3;
                        continue;
                    case '/':
                        if (commentState != 3) {
                            commentState = 2;
                            break;
                        } else {
                            commentState = 0;
                            continue;
                        }
                    default:
                        commentState = 2;
                        continue;
                }
            } else if (commentState < 0) {
                switch (c) {
                    case '\n':
                    case '\r':
                        commentState = 0;
                        continue;
                }
            } else {
                switch (c) {
                    case '\"':
                        return parseString(source);
                    case '-':
                        return parseNumber(source);
                    case '/':
                        commentState = 1;
                        continue;
                    case 'N':
                        complete("NaN", source);
                        return null;
                    case '[':
                        return parseArray(source);
                    case 'f':
                        complete("false", source);
                        return Boolean.FALSE;
                    case 'n':
                        complete("null", source);
                        return null;
                    case 't':
                        complete(C3P0Substitutions.DEBUG, source);
                        return Boolean.TRUE;
                    case 'u':
                        complete("undefined", source);
                        return null;
                    case '{':
                        return parseObject(source);
                    default:
                        if (Character.isDigit(c)) {
                            return parseNumber(source);
                        }
                        if (!Character.isWhitespace(c)) {
                            return handleUnknown(source, c);
                        }
                        continue;
                }
            }
            source.next();
        }
        return null;
    }

    protected Object handleUnknown(Source source, char c) {
        throw new IllegalStateException("unknown char '" + c + "'(" + ((int) c) + ") in " + source);
    }

    protected Object parseObject(Source source) {
        if (source.next() != '{') {
            throw new IllegalStateException();
        }
        Map<String, Object> map = newMap();
        char next = seekTo("\"}", source);
        while (true) {
            if (!source.hasNext()) {
                break;
            } else if (next == '}') {
                source.next();
                break;
            } else {
                String name = parseString(source);
                seekTo(':', source);
                source.next();
                map.put(name, contextFor(name).parse(source));
                seekTo(",}", source);
                if (source.next() == '}') {
                    break;
                }
                next = seekTo("\"}", source);
            }
        }
        String xclassname = (String) map.get("x-class");
        if (xclassname != null) {
            Convertor c = getConvertorFor(xclassname);
            if (c != null) {
                return c.fromJSON(map);
            }
            LOG.warn("No Convertor for x-class '{}'", xclassname);
        }
        String classname = (String) map.get("class");
        if (classname != null) {
            try {
                return convertTo(Loader.loadClass(classname), map);
            } catch (ClassNotFoundException e) {
                LOG.warn("No Class for '{}'", classname);
            }
        }
        return map;
    }

    private Object defaultArrayConverter(List<?> list) {
        Object[] objects = newArray(list.size());
        IntStream.range(0, list.size()).forEach(i -> {
            objects[i] = list.get(i);
        });
        return objects;
    }

    protected Object parseArray(Source source) {
        if (source.next() != '[') {
            throw new IllegalStateException();
        }
        int size = 0;
        List<Object> list = null;
        Object item = null;
        boolean comma = true;
        while (source.hasNext()) {
            char c = source.peek();
            switch (c) {
                case ',':
                    if (!comma) {
                        comma = true;
                        source.next();
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                case ']':
                    source.next();
                    switch (size) {
                        case 0:
                            list = Collections.emptyList();
                            break;
                        case 1:
                            list = Collections.singletonList(item);
                            break;
                    }
                    return getArrayConverter().apply(list);
                default:
                    if (!Character.isWhitespace(c)) {
                        comma = false;
                        size++;
                        if (size != 0) {
                            if (list != null) {
                                list.add(contextForArray().parse(source));
                                item = null;
                                break;
                            } else {
                                list = new ArrayList<>();
                                list.add(item);
                                list.add(contextForArray().parse(source));
                                item = null;
                                break;
                            }
                        } else {
                            item = contextForArray().parse(source);
                            break;
                        }
                    } else {
                        source.next();
                        break;
                    }
            }
        }
        throw new IllegalStateException("unexpected end of array");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0197, code lost:
        if (r8 != null) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a3, code lost:
        return toString(r0, 0, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String parseString(org.eclipse.jetty.util.ajax.JSON.Source r6) {
        /*
        // Method dump skipped, instructions count: 747
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.parseString(org.eclipse.jetty.util.ajax.JSON$Source):java.lang.String");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0007 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0007 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Number parseNumber(org.eclipse.jetty.util.ajax.JSON.Source r6) {
        /*
            r5 = this;
            r0 = 0
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r10 = r0
        L_0x0007:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x017d
            r0 = r6
            char r0 = r0.peek()
            r11 = r0
            r0 = r11
            switch(r0) {
                case 43: goto L_0x012b;
                case 44: goto L_0x0177;
                case 45: goto L_0x012b;
                case 46: goto L_0x0147;
                case 47: goto L_0x0177;
                case 48: goto L_0x0114;
                case 49: goto L_0x0114;
                case 50: goto L_0x0114;
                case 51: goto L_0x0114;
                case 52: goto L_0x0114;
                case 53: goto L_0x0114;
                case 54: goto L_0x0114;
                case 55: goto L_0x0114;
                case 56: goto L_0x0114;
                case 57: goto L_0x0114;
                case 58: goto L_0x0177;
                case 59: goto L_0x0177;
                case 60: goto L_0x0177;
                case 61: goto L_0x0177;
                case 62: goto L_0x0177;
                case 63: goto L_0x0177;
                case 64: goto L_0x0177;
                case 65: goto L_0x0177;
                case 66: goto L_0x0177;
                case 67: goto L_0x0177;
                case 68: goto L_0x0177;
                case 69: goto L_0x0147;
                case 70: goto L_0x0177;
                case 71: goto L_0x0177;
                case 72: goto L_0x0177;
                case 73: goto L_0x0177;
                case 74: goto L_0x0177;
                case 75: goto L_0x0177;
                case 76: goto L_0x0177;
                case 77: goto L_0x0177;
                case 78: goto L_0x0177;
                case 79: goto L_0x0177;
                case 80: goto L_0x0177;
                case 81: goto L_0x0177;
                case 82: goto L_0x0177;
                case 83: goto L_0x0177;
                case 84: goto L_0x0177;
                case 85: goto L_0x0177;
                case 86: goto L_0x0177;
                case 87: goto L_0x0177;
                case 88: goto L_0x0177;
                case 89: goto L_0x0177;
                case 90: goto L_0x0177;
                case 91: goto L_0x0177;
                case 92: goto L_0x0177;
                case 93: goto L_0x0177;
                case 94: goto L_0x0177;
                case 95: goto L_0x0177;
                case 96: goto L_0x0177;
                case 97: goto L_0x0177;
                case 98: goto L_0x0177;
                case 99: goto L_0x0177;
                case 100: goto L_0x0177;
                case 101: goto L_0x0147;
                default: goto L_0x0177;
            }
        L_0x0114:
            r0 = r8
            r1 = 10
            long r0 = r0 * r1
            r1 = r11
            r2 = 48
            int r1 = r1 - r2
            long r1 = (long) r1
            long r0 = r0 + r1
            r8 = r0
            r0 = r6
            char r0 = r0.next()
            goto L_0x017a
        L_0x012b:
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x013b
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "bad number"
            r1.<init>(r2)
            throw r0
        L_0x013b:
            r0 = 1
            r7 = r0
            r0 = r6
            char r0 = r0.next()
            goto L_0x017a
        L_0x0147:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r2 = 16
            r1.<init>(r2)
            r10 = r0
            r0 = r7
            if (r0 == 0) goto L_0x015e
            r0 = r10
            r1 = 45
            java.lang.StringBuilder r0 = r0.append(r1)
        L_0x015e:
            r0 = r10
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r11
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            char r0 = r0.next()
            goto L_0x017d
        L_0x0177:
            goto L_0x017d
        L_0x017a:
            goto L_0x0007
        L_0x017d:
            r0 = r10
            if (r0 != 0) goto L_0x0193
            r0 = r7
            if (r0 == 0) goto L_0x018e
            r0 = -1
            r1 = r8
            long r0 = r0 * r1
            goto L_0x018f
        L_0x018e:
            r0 = r8
        L_0x018f:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        L_0x0193:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x02b8
            r0 = r6
            char r0 = r0.peek()
            r11 = r0
            r0 = r11
            switch(r0) {
                case 43: goto L_0x02a0;
                case 44: goto L_0x02b2;
                case 45: goto L_0x02a0;
                case 46: goto L_0x02a0;
                case 47: goto L_0x02b2;
                case 48: goto L_0x02a0;
                case 49: goto L_0x02a0;
                case 50: goto L_0x02a0;
                case 51: goto L_0x02a0;
                case 52: goto L_0x02a0;
                case 53: goto L_0x02a0;
                case 54: goto L_0x02a0;
                case 55: goto L_0x02a0;
                case 56: goto L_0x02a0;
                case 57: goto L_0x02a0;
                case 58: goto L_0x02b2;
                case 59: goto L_0x02b2;
                case 60: goto L_0x02b2;
                case 61: goto L_0x02b2;
                case 62: goto L_0x02b2;
                case 63: goto L_0x02b2;
                case 64: goto L_0x02b2;
                case 65: goto L_0x02b2;
                case 66: goto L_0x02b2;
                case 67: goto L_0x02b2;
                case 68: goto L_0x02b2;
                case 69: goto L_0x02a0;
                case 70: goto L_0x02b2;
                case 71: goto L_0x02b2;
                case 72: goto L_0x02b2;
                case 73: goto L_0x02b2;
                case 74: goto L_0x02b2;
                case 75: goto L_0x02b2;
                case 76: goto L_0x02b2;
                case 77: goto L_0x02b2;
                case 78: goto L_0x02b2;
                case 79: goto L_0x02b2;
                case 80: goto L_0x02b2;
                case 81: goto L_0x02b2;
                case 82: goto L_0x02b2;
                case 83: goto L_0x02b2;
                case 84: goto L_0x02b2;
                case 85: goto L_0x02b2;
                case 86: goto L_0x02b2;
                case 87: goto L_0x02b2;
                case 88: goto L_0x02b2;
                case 89: goto L_0x02b2;
                case 90: goto L_0x02b2;
                case 91: goto L_0x02b2;
                case 92: goto L_0x02b2;
                case 93: goto L_0x02b2;
                case 94: goto L_0x02b2;
                case 95: goto L_0x02b2;
                case 96: goto L_0x02b2;
                case 97: goto L_0x02b2;
                case 98: goto L_0x02b2;
                case 99: goto L_0x02b2;
                case 100: goto L_0x02b2;
                case 101: goto L_0x02a0;
                default: goto L_0x02b2;
            }
        L_0x02a0:
            r0 = r10
            r1 = r11
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            char r0 = r0.next()
            goto L_0x02b5
        L_0x02b2:
            goto L_0x02b8
        L_0x02b5:
            goto L_0x0193
        L_0x02b8:
            r0 = r10
            java.lang.String r0 = r0.toString()
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ajax.JSON.parseNumber(org.eclipse.jetty.util.ajax.JSON$Source):java.lang.Number");
    }

    protected void seekTo(char seek, Source source) {
        while (source.hasNext()) {
            char c = source.peek();
            if (c != seek) {
                if (!Character.isWhitespace(c)) {
                    throw new IllegalStateException("Unexpected '" + c + " while seeking '" + seek + "'");
                }
                source.next();
            } else {
                return;
            }
        }
        throw new IllegalStateException("Expected '" + seek + "'");
    }

    protected char seekTo(String seek, Source source) {
        while (source.hasNext()) {
            char c = source.peek();
            if (seek.indexOf(c) >= 0) {
                return c;
            }
            if (!Character.isWhitespace(c)) {
                throw new IllegalStateException("Unexpected '" + c + "' while seeking one of '" + seek + "'");
            }
            source.next();
        }
        throw new IllegalStateException("Expected one of '" + seek + "'");
    }

    protected static void complete(String seek, Source source) {
        int i = 0;
        while (source.hasNext() && i < seek.length()) {
            char c = source.next();
            i++;
            if (c != seek.charAt(i)) {
                throw new IllegalStateException("Unexpected '" + c + " while seeking  \"" + seek + "\"");
            }
        }
        if (i < seek.length()) {
            throw new IllegalStateException("Expected \"" + seek + "\"");
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$ConvertableOutput.class */
    public final class ConvertableOutput implements Output {
        private final Appendable _buffer;

        /* renamed from: c */
        char f3166c;

        private ConvertableOutput(Appendable buffer) {
            this.f3166c = '{';
            this._buffer = buffer;
        }

        public void complete() {
            try {
                if (this.f3166c == '{') {
                    this._buffer.append("{}");
                } else if (this.f3166c != 0) {
                    this._buffer.append("}");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(Object obj) {
            if (this.f3166c == 0) {
                throw new IllegalStateException();
            }
            JSON.this.append(this._buffer, obj);
            this.f3166c = 0;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void addClass(Class type) {
            try {
                if (this.f3166c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f3166c);
                this._buffer.append("\"class\":");
                JSON.this.append(this._buffer, type.getName());
                this.f3166c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String name, Object value) {
            try {
                if (this.f3166c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f3166c);
                JSON.this.quotedEscape(this._buffer, name);
                this._buffer.append(':');
                JSON.this.append(this._buffer, value);
                this.f3166c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String name, double value) {
            try {
                if (this.f3166c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f3166c);
                JSON.this.quotedEscape(this._buffer, name);
                this._buffer.append(':');
                JSON.this.appendNumber(this._buffer, Double.valueOf(value));
                this.f3166c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String name, long value) {
            try {
                if (this.f3166c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f3166c);
                JSON.this.quotedEscape(this._buffer, name);
                this._buffer.append(':');
                JSON.this.appendNumber(this._buffer, Long.valueOf(value));
                this.f3166c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Output
        public void add(String name, boolean value) {
            try {
                if (this.f3166c == 0) {
                    throw new IllegalStateException();
                }
                this._buffer.append(this.f3166c);
                JSON.this.quotedEscape(this._buffer, name);
                this._buffer.append(':');
                JSON.this.appendBoolean(this._buffer, value ? Boolean.TRUE : Boolean.FALSE);
                this.f3166c = ',';
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$StringSource.class */
    public static class StringSource implements Source {
        private final String string;
        private int index;
        private char[] scratch;

        public StringSource(String s) {
            this.string = s;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public boolean hasNext() {
            if (this.index < this.string.length()) {
                return true;
            }
            this.scratch = null;
            return false;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char next() {
            String str = this.string;
            int i = this.index;
            this.index = i + 1;
            return str.charAt(i);
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char peek() {
            return this.string.charAt(this.index);
        }

        public String toString() {
            return this.string.substring(0, this.index) + "|||" + this.string.substring(this.index);
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char[] scratchBuffer() {
            if (this.scratch == null) {
                this.scratch = new char[this.string.length()];
            }
            return this.scratch;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$ReaderSource.class */
    public static class ReaderSource implements Source {
        private Reader _reader;
        private int _next = -1;
        private char[] scratch;

        public ReaderSource(Reader r) {
            this._reader = r;
        }

        public void setReader(Reader reader) {
            this._reader = reader;
            this._next = -1;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public boolean hasNext() {
            getNext();
            if (this._next >= 0) {
                return true;
            }
            this.scratch = null;
            return false;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char next() {
            getNext();
            char c = (char) this._next;
            this._next = -1;
            return c;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char peek() {
            getNext();
            return (char) this._next;
        }

        private void getNext() {
            if (this._next < 0) {
                try {
                    this._next = this._reader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Source
        public char[] scratchBuffer() {
            if (this.scratch == null) {
                this.scratch = new char[1024];
            }
            return this.scratch;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ajax/JSON$Literal.class */
    public static class Literal implements Generator {
        private final String _json;

        public Literal(String json) {
            if (JSON.LOG.isDebugEnabled()) {
                JSON.parse(json);
            }
            this._json = json;
        }

        public String toString() {
            return this._json;
        }

        @Override // org.eclipse.jetty.util.ajax.JSON.Generator
        public void addJSON(Appendable buffer) {
            try {
                buffer.append(this._json);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
