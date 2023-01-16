package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.TextFormatParseInfoTree;
import com.google.protobuf.UnknownFieldSet;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.lang.Character;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;
import org.luaj.vm2.LuaDouble;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:com/google/protobuf/TextFormat.class */
public final class TextFormat {
    private static final Logger logger = Logger.getLogger(TextFormat.class.getName());
    private static final Parser PARSER = Parser.newBuilder().build();

    private TextFormat() {
    }

    @Deprecated
    public static void print(MessageOrBuilder message, Appendable output) throws IOException {
        printer().print(message, output);
    }

    @Deprecated
    public static void print(UnknownFieldSet fields, Appendable output) throws IOException {
        printer().print(fields, output);
    }

    @Deprecated
    public static void printUnicode(MessageOrBuilder message, Appendable output) throws IOException {
        printer().escapingNonAscii(false).print(message, output);
    }

    @Deprecated
    public static void printUnicode(UnknownFieldSet fields, Appendable output) throws IOException {
        printer().escapingNonAscii(false).print(fields, output);
    }

    public static String shortDebugString(MessageOrBuilder message) {
        return printer().shortDebugString(message);
    }

    @Deprecated
    public static String shortDebugString(Descriptors.FieldDescriptor field, Object value) {
        return printer().shortDebugString(field, value);
    }

    @Deprecated
    public static String shortDebugString(UnknownFieldSet fields) {
        return printer().shortDebugString(fields);
    }

    @Deprecated
    public static String printToString(MessageOrBuilder message) {
        return printer().printToString(message);
    }

    @Deprecated
    public static String printToString(UnknownFieldSet fields) {
        return printer().printToString(fields);
    }

    @Deprecated
    public static String printToUnicodeString(MessageOrBuilder message) {
        return printer().escapingNonAscii(false).printToString(message);
    }

    @Deprecated
    public static String printToUnicodeString(UnknownFieldSet fields) {
        return printer().escapingNonAscii(false).printToString(fields);
    }

    @Deprecated
    public static void printField(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
        printer().printField(field, value, output);
    }

    @Deprecated
    public static String printFieldToString(Descriptors.FieldDescriptor field, Object value) {
        return printer().printFieldToString(field, value);
    }

    @Deprecated
    public static void printUnicodeFieldValue(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
        printer().escapingNonAscii(false).printFieldValue(field, value, output);
    }

    @Deprecated
    public static void printFieldValue(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
        printer().printFieldValue(field, value, output);
    }

    public static void printUnknownFieldValue(int tag, Object value, Appendable output) throws IOException {
        printUnknownFieldValue(tag, value, multiLineOutput(output));
    }

    private static void printUnknownFieldValue(int tag, Object value, TextGenerator generator) throws IOException {
        switch (WireFormat.getTagWireType(tag)) {
            case 0:
                generator.print(unsignedToString(((Long) value).longValue()));
                return;
            case 1:
                generator.print(String.format(null, "0x%016x", (Long) value));
                return;
            case 2:
                try {
                    UnknownFieldSet message = UnknownFieldSet.parseFrom((ByteString) value);
                    generator.print("{");
                    generator.eol();
                    generator.indent();
                    Printer.printUnknownFields(message, generator);
                    generator.outdent();
                    generator.print("}");
                    return;
                } catch (InvalidProtocolBufferException e) {
                    generator.print("\"");
                    generator.print(escapeBytes((ByteString) value));
                    generator.print("\"");
                    return;
                }
            case 3:
                Printer.printUnknownFields((UnknownFieldSet) value, generator);
                return;
            case 4:
            default:
                throw new IllegalArgumentException("Bad tag: " + tag);
            case 5:
                generator.print(String.format(null, "0x%08x", (Integer) value));
                return;
        }
    }

    public static Printer printer() {
        return Printer.DEFAULT;
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Printer.class */
    public static final class Printer {
        private static final Printer DEFAULT = new Printer(true, TypeRegistry.getEmptyTypeRegistry());
        private final boolean escapeNonAscii;
        private final TypeRegistry typeRegistry;

        private Printer(boolean escapeNonAscii, TypeRegistry typeRegistry) {
            this.escapeNonAscii = escapeNonAscii;
            this.typeRegistry = typeRegistry;
        }

        public Printer escapingNonAscii(boolean escapeNonAscii) {
            return new Printer(escapeNonAscii, this.typeRegistry);
        }

        public Printer usingTypeRegistry(TypeRegistry typeRegistry) {
            if (this.typeRegistry == TypeRegistry.getEmptyTypeRegistry()) {
                return new Printer(this.escapeNonAscii, typeRegistry);
            }
            throw new IllegalArgumentException("Only one typeRegistry is allowed.");
        }

        public void print(MessageOrBuilder message, Appendable output) throws IOException {
            print(message, TextFormat.multiLineOutput(output));
        }

        public void print(UnknownFieldSet fields, Appendable output) throws IOException {
            printUnknownFields(fields, TextFormat.multiLineOutput(output));
        }

        private void print(MessageOrBuilder message, TextGenerator generator) throws IOException {
            if (!message.getDescriptorForType().getFullName().equals("google.protobuf.Any") || !printAny(message, generator)) {
                printMessage(message, generator);
            }
        }

        private boolean printAny(MessageOrBuilder message, TextGenerator generator) throws IOException {
            Descriptors.Descriptor messageType = message.getDescriptorForType();
            Descriptors.FieldDescriptor typeUrlField = messageType.findFieldByNumber(1);
            Descriptors.FieldDescriptor valueField = messageType.findFieldByNumber(2);
            if (typeUrlField == null || typeUrlField.getType() != Descriptors.FieldDescriptor.Type.STRING || valueField == null || valueField.getType() != Descriptors.FieldDescriptor.Type.BYTES) {
                return false;
            }
            String typeUrl = (String) message.getField(typeUrlField);
            if (typeUrl.isEmpty()) {
                return false;
            }
            Object value = message.getField(valueField);
            try {
                Descriptors.Descriptor contentType = this.typeRegistry.getDescriptorForTypeUrl(typeUrl);
                if (contentType == null) {
                    return false;
                }
                Message.Builder contentBuilder = DynamicMessage.getDefaultInstance(contentType).newBuilderForType();
                contentBuilder.mergeFrom((ByteString) value);
                generator.print("[");
                generator.print(typeUrl);
                generator.print("] {");
                generator.eol();
                generator.indent();
                print(contentBuilder, generator);
                generator.outdent();
                generator.print("}");
                generator.eol();
                return true;
            } catch (InvalidProtocolBufferException e) {
                return false;
            }
        }

        public String printFieldToString(Descriptors.FieldDescriptor field, Object value) {
            try {
                StringBuilder text = new StringBuilder();
                printField(field, value, text);
                return text.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public void printField(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
            printField(field, value, TextFormat.multiLineOutput(output));
        }

        private void printField(Descriptors.FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            if (field.isMapField()) {
                List<MapEntryAdapter> adapters = new ArrayList<>();
                for (Object entry : (List) value) {
                    adapters.add(new MapEntryAdapter(entry, field));
                }
                Collections.sort(adapters);
                for (MapEntryAdapter adapter : adapters) {
                    printSingleField(field, adapter.getEntry(), generator);
                }
            } else if (field.isRepeated()) {
                for (Object element : (List) value) {
                    printSingleField(field, element, generator);
                }
            } else {
                printSingleField(field, value, generator);
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Printer$MapEntryAdapter.class */
        public static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
            private Object entry;
            private MapEntry mapEntry;
            private final Descriptors.FieldDescriptor.JavaType fieldType;

            public MapEntryAdapter(Object entry, Descriptors.FieldDescriptor fieldDescriptor) {
                if (entry instanceof MapEntry) {
                    this.mapEntry = (MapEntry) entry;
                } else {
                    this.entry = entry;
                }
                this.fieldType = extractFieldType(fieldDescriptor);
            }

            private static Descriptors.FieldDescriptor.JavaType extractFieldType(Descriptors.FieldDescriptor fieldDescriptor) {
                return fieldDescriptor.getMessageType().getFields().get(0).getJavaType();
            }

            public Object getKey() {
                if (this.mapEntry != null) {
                    return this.mapEntry.getKey();
                }
                return null;
            }

            public Object getEntry() {
                if (this.mapEntry != null) {
                    return this.mapEntry;
                }
                return this.entry;
            }

            public int compareTo(MapEntryAdapter b) {
                if (getKey() == null || b.getKey() == null) {
                    TextFormat.logger.info("Invalid key for map field.");
                    return -1;
                }
                switch (this.fieldType) {
                    case BOOLEAN:
                        return Boolean.compare(((Boolean) getKey()).booleanValue(), ((Boolean) b.getKey()).booleanValue());
                    case LONG:
                        return Long.compare(((Long) getKey()).longValue(), ((Long) b.getKey()).longValue());
                    case INT:
                        return Integer.compare(((Integer) getKey()).intValue(), ((Integer) b.getKey()).intValue());
                    case STRING:
                        String aString = (String) getKey();
                        String bString = (String) b.getKey();
                        if (aString == null && bString == null) {
                            return 0;
                        }
                        if (aString == null && bString != null) {
                            return -1;
                        }
                        if (aString == null || bString != null) {
                            return aString.compareTo(bString);
                        }
                        return 1;
                    default:
                        return 0;
                }
            }
        }

        public void printFieldValue(Descriptors.FieldDescriptor field, Object value, Appendable output) throws IOException {
            printFieldValue(field, value, TextFormat.multiLineOutput(output));
        }

        private void printFieldValue(Descriptors.FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            String str;
            switch (field.getType()) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    generator.print(((Integer) value).toString());
                    return;
                case INT64:
                case SINT64:
                case SFIXED64:
                    generator.print(((Long) value).toString());
                    return;
                case BOOL:
                    generator.print(((Boolean) value).toString());
                    return;
                case FLOAT:
                    generator.print(((Float) value).toString());
                    return;
                case DOUBLE:
                    generator.print(((Double) value).toString());
                    return;
                case UINT32:
                case FIXED32:
                    generator.print(TextFormat.unsignedToString(((Integer) value).intValue()));
                    return;
                case UINT64:
                case FIXED64:
                    generator.print(TextFormat.unsignedToString(((Long) value).longValue()));
                    return;
                case STRING:
                    generator.print("\"");
                    if (this.escapeNonAscii) {
                        str = TextFormatEscaper.escapeText((String) value);
                    } else {
                        str = TextFormat.escapeDoubleQuotesAndBackslashes((String) value).replace("\n", "\\n");
                    }
                    generator.print(str);
                    generator.print("\"");
                    return;
                case BYTES:
                    generator.print("\"");
                    if (value instanceof ByteString) {
                        generator.print(TextFormat.escapeBytes((ByteString) value));
                    } else {
                        generator.print(TextFormat.escapeBytes((byte[]) value));
                    }
                    generator.print("\"");
                    return;
                case ENUM:
                    generator.print(((Descriptors.EnumValueDescriptor) value).getName());
                    return;
                case MESSAGE:
                case GROUP:
                    print((Message) value, generator);
                    return;
                default:
                    return;
            }
        }

        public String printToString(MessageOrBuilder message) {
            try {
                StringBuilder text = new StringBuilder();
                print(message, text);
                return text.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String printToString(UnknownFieldSet fields) {
            try {
                StringBuilder text = new StringBuilder();
                print(fields, text);
                return text.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String shortDebugString(MessageOrBuilder message) {
            try {
                StringBuilder text = new StringBuilder();
                print(message, TextFormat.singleLineOutput(text));
                return text.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String shortDebugString(Descriptors.FieldDescriptor field, Object value) {
            try {
                StringBuilder text = new StringBuilder();
                printField(field, value, TextFormat.singleLineOutput(text));
                return text.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String shortDebugString(UnknownFieldSet fields) {
            try {
                StringBuilder text = new StringBuilder();
                printUnknownFields(fields, TextFormat.singleLineOutput(text));
                return text.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private static void printUnknownFieldValue(int tag, Object value, TextGenerator generator) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    generator.print(TextFormat.unsignedToString(((Long) value).longValue()));
                    return;
                case 1:
                    generator.print(String.format(null, "0x%016x", (Long) value));
                    return;
                case 2:
                    try {
                        UnknownFieldSet message = UnknownFieldSet.parseFrom((ByteString) value);
                        generator.print("{");
                        generator.eol();
                        generator.indent();
                        printUnknownFields(message, generator);
                        generator.outdent();
                        generator.print("}");
                        return;
                    } catch (InvalidProtocolBufferException e) {
                        generator.print("\"");
                        generator.print(TextFormat.escapeBytes((ByteString) value));
                        generator.print("\"");
                        return;
                    }
                case 3:
                    printUnknownFields((UnknownFieldSet) value, generator);
                    return;
                case 4:
                default:
                    throw new IllegalArgumentException("Bad tag: " + tag);
                case 5:
                    generator.print(String.format(null, "0x%08x", (Integer) value));
                    return;
            }
        }

        private void printMessage(MessageOrBuilder message, TextGenerator generator) throws IOException {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> field : message.getAllFields().entrySet()) {
                printField(field.getKey(), field.getValue(), generator);
            }
            printUnknownFields(message.getUnknownFields(), generator);
        }

        private void printSingleField(Descriptors.FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
            if (field.isExtension()) {
                generator.print("[");
                if (!field.getContainingType().getOptions().getMessageSetWireFormat() || field.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || !field.isOptional() || field.getExtensionScope() != field.getMessageType()) {
                    generator.print(field.getFullName());
                } else {
                    generator.print(field.getMessageType().getFullName());
                }
                generator.print("]");
            } else if (field.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
                generator.print(field.getMessageType().getName());
            } else {
                generator.print(field.getName());
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                generator.print(" {");
                generator.eol();
                generator.indent();
            } else {
                generator.print(": ");
            }
            printFieldValue(field, value, generator);
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                generator.outdent();
                generator.print("}");
            }
            generator.eol();
        }

        /* access modifiers changed from: private */
        public static void printUnknownFields(UnknownFieldSet unknownFields, TextGenerator generator) throws IOException {
            for (Map.Entry<Integer, UnknownFieldSet.Field> entry : unknownFields.asMap().entrySet()) {
                int number = entry.getKey().intValue();
                UnknownFieldSet.Field field = entry.getValue();
                printUnknownField(number, 0, field.getVarintList(), generator);
                printUnknownField(number, 5, field.getFixed32List(), generator);
                printUnknownField(number, 1, field.getFixed64List(), generator);
                printUnknownField(number, 2, field.getLengthDelimitedList(), generator);
                for (UnknownFieldSet value : field.getGroupList()) {
                    generator.print(entry.getKey().toString());
                    generator.print(" {");
                    generator.eol();
                    generator.indent();
                    printUnknownFields(value, generator);
                    generator.outdent();
                    generator.print("}");
                    generator.eol();
                }
            }
        }

        private static void printUnknownField(int number, int wireType, List<?> values, TextGenerator generator) throws IOException {
            for (Object value : values) {
                generator.print(String.valueOf(number));
                generator.print(": ");
                printUnknownFieldValue(wireType, value, generator);
                generator.eol();
            }
        }
    }

    public static String unsignedToString(int value) {
        if (value >= 0) {
            return Integer.toString(value);
        }
        return Long.toString(((long) value) & 4294967295L);
    }

    public static String unsignedToString(long value) {
        if (value >= 0) {
            return Long.toString(value);
        }
        return BigInteger.valueOf(value & LongCompanionObject.MAX_VALUE).setBit(63).toString();
    }

    /* access modifiers changed from: private */
    public static TextGenerator multiLineOutput(Appendable output) {
        return new TextGenerator(output, false);
    }

    /* access modifiers changed from: private */
    public static TextGenerator singleLineOutput(Appendable output) {
        return new TextGenerator(output, true);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$TextGenerator.class */
    public static final class TextGenerator {
        private final Appendable output;
        private final StringBuilder indent;
        private final boolean singleLineMode;
        private boolean atStartOfLine;

        private TextGenerator(Appendable output, boolean singleLineMode) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = output;
            this.singleLineMode = singleLineMode;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.setLength(length - 2);
        }

        public void print(CharSequence text) throws IOException {
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.singleLineMode ? " " : this.indent);
            }
            this.output.append(text);
        }

        public void eol() throws IOException {
            if (!this.singleLineMode) {
                this.output.append("\n");
            }
            this.atStartOfLine = true;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Tokenizer.class */
    public static final class Tokenizer {
        private final CharSequence text;
        private final Matcher matcher;
        private String currentToken;
        private int pos;
        private int line;
        private int column;
        private int previousLine;
        private int previousColumn;
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);

        private Tokenizer(CharSequence text) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = text;
            this.matcher = WHITESPACE.matcher(text);
            skipWhitespace();
            nextToken();
        }

        int getPreviousLine() {
            return this.previousLine;
        }

        int getPreviousColumn() {
            return this.previousColumn;
        }

        int getLine() {
            return this.line;
        }

        int getColumn() {
            return this.column;
        }

        public boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                this.matcher.region(this.pos + 1, this.matcher.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            }
        }

        public boolean tryConsume(String token) {
            if (!this.currentToken.equals(token)) {
                return false;
            }
            nextToken();
            return true;
        }

        public void consume(String token) throws ParseException {
            if (!tryConsume(token)) {
                throw parseException("Expected \"" + token + "\".");
            }
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char c = this.currentToken.charAt(0);
            return ('0' <= c && c <= '9') || c == '-' || c == '+';
        }

        public boolean lookingAt(String text) {
            return this.currentToken.equals(text);
        }

        public String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char c = this.currentToken.charAt(i);
                if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && !(('0' <= c && c <= '9') || c == '_' || c == '.'))) {
                    throw parseException("Expected identifier. Found '" + this.currentToken + "'");
                }
            }
            String result = this.currentToken;
            nextToken();
            return result;
        }

        public boolean tryConsumeIdentifier() {
            try {
                consumeIdentifier();
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public int consumeInt32() throws ParseException {
            try {
                int result = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public int consumeUInt32() throws ParseException {
            try {
                int result = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeInt64() throws ParseException {
            try {
                long result = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public boolean tryConsumeInt64() {
            try {
                consumeInt64();
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public long consumeUInt64() throws ParseException {
            try {
                long result = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public boolean tryConsumeUInt64() {
            try {
                consumeUInt64();
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else if (this.currentToken.equalsIgnoreCase(LuaDouble.JSTR_NAN)) {
                nextToken();
                return Double.NaN;
            } else {
                try {
                    double result = Double.parseDouble(this.currentToken);
                    nextToken();
                    return result;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public boolean tryConsumeDouble() {
            try {
                consumeDouble();
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            } else if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            } else {
                try {
                    float result = Float.parseFloat(this.currentToken);
                    nextToken();
                    return result;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public boolean tryConsumeFloat() {
            try {
                consumeFloat();
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals(C3P0Substitutions.DEBUG) || this.currentToken.equals("True") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            } else if (this.currentToken.equals("false") || this.currentToken.equals("False") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            } else {
                throw parseException("Expected \"true\" or \"false\". Found \"" + this.currentToken + "\".");
            }
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public boolean tryConsumeString() {
            try {
                consumeString();
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        public ByteString consumeByteString() throws ParseException {
            List<ByteString> list = new ArrayList<>();
            consumeByteString(list);
            while (true) {
                if (!this.currentToken.startsWith("'") && !this.currentToken.startsWith("\"")) {
                    return ByteString.copyFrom(list);
                }
                consumeByteString(list);
            }
        }

        private void consumeByteString(List<ByteString> list) throws ParseException {
            char quote = this.currentToken.length() > 0 ? this.currentToken.charAt(0) : 0;
            if (quote != '\"' && quote != '\'') {
                throw parseException("Expected string.");
            } else if (this.currentToken.length() < 2 || this.currentToken.charAt(this.currentToken.length() - 1) != quote) {
                throw parseException("String missing ending quote.");
            } else {
                try {
                    ByteString result = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
                    nextToken();
                    list.add(result);
                } catch (InvalidEscapeSequenceException e) {
                    throw parseException(e.getMessage());
                }
            }
        }

        public ParseException parseException(String description) {
            return new ParseException(this.line + 1, this.column + 1, description);
        }

        public ParseException parseExceptionPreviousToken(String description) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, description);
        }

        private ParseException integerParseException(NumberFormatException e) {
            return parseException("Couldn't parse integer: " + e.getMessage());
        }

        private ParseException floatParseException(NumberFormatException e) {
            return parseException("Couldn't parse number: " + e.getMessage());
        }

        public UnknownFieldParseException unknownFieldParseExceptionPreviousToken(String unknownField, String description) {
            return new UnknownFieldParseException(this.previousLine + 1, this.previousColumn + 1, unknownField, description);
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$ParseException.class */
    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int line;
        private final int column;

        public ParseException(String message) {
            this(-1, -1, message);
        }

        public ParseException(int line, int column, String message) {
            super(Integer.toString(line) + EmitterKt.COMMENT_PREFIX + column + ": " + message);
            this.line = line;
            this.column = column;
        }

        public int getLine() {
            return this.line;
        }

        public int getColumn() {
            return this.column;
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$UnknownFieldParseException.class */
    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(String message) {
            this(-1, -1, "", message);
        }

        public UnknownFieldParseException(int line, int column, String unknownField, String message) {
            super(line, column, message);
            this.unknownField = unknownField;
        }

        public String getUnknownField() {
            return this.unknownField;
        }
    }

    public static Parser getParser() {
        return PARSER;
    }

    public static void merge(Readable input, Message.Builder builder) throws IOException {
        PARSER.merge(input, builder);
    }

    public static void merge(CharSequence input, Message.Builder builder) throws ParseException {
        PARSER.merge(input, builder);
    }

    public static <T extends Message> T parse(CharSequence input, Class<T> protoClass) throws ParseException {
        Message.Builder builder = ((Message) Internal.getDefaultInstance(protoClass)).newBuilderForType();
        merge(input, builder);
        return (T) builder.build();
    }

    public static void merge(Readable input, ExtensionRegistry extensionRegistry, Message.Builder builder) throws IOException {
        PARSER.merge(input, extensionRegistry, builder);
    }

    public static void merge(CharSequence input, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
        PARSER.merge(input, extensionRegistry, builder);
    }

    public static <T extends Message> T parse(CharSequence input, ExtensionRegistry extensionRegistry, Class<T> protoClass) throws ParseException {
        Message.Builder builder = ((Message) Internal.getDefaultInstance(protoClass)).newBuilderForType();
        merge(input, extensionRegistry, builder);
        return (T) builder.build();
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Parser.class */
    public static class Parser {
        private final TypeRegistry typeRegistry;
        private final boolean allowUnknownFields;
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final SingularOverwritePolicy singularOverwritePolicy;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private static final int BUFFER_SIZE = 4096;

        /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Parser$SingularOverwritePolicy.class */
        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        private Parser(TypeRegistry typeRegistry, boolean allowUnknownFields, boolean allowUnknownEnumValues, boolean allowUnknownExtensions, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder parseInfoTreeBuilder) {
            this.typeRegistry = typeRegistry;
            this.allowUnknownFields = allowUnknownFields;
            this.allowUnknownEnumValues = allowUnknownEnumValues;
            this.allowUnknownExtensions = allowUnknownExtensions;
            this.singularOverwritePolicy = singularOverwritePolicy;
            this.parseInfoTreeBuilder = parseInfoTreeBuilder;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Parser$Builder.class */
        public static class Builder {
            private boolean allowUnknownFields = false;
            private boolean allowUnknownEnumValues = false;
            private boolean allowUnknownExtensions = false;
            private SingularOverwritePolicy singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
            private TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();

            public Builder setTypeRegistry(TypeRegistry typeRegistry) {
                this.typeRegistry = typeRegistry;
                return this;
            }

            public Builder setAllowUnknownFields(boolean allowUnknownFields) {
                this.allowUnknownFields = allowUnknownFields;
                return this;
            }

            public Builder setAllowUnknownExtensions(boolean allowUnknownExtensions) {
                this.allowUnknownExtensions = allowUnknownExtensions;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy p) {
                this.singularOverwritePolicy = p;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder parseInfoTreeBuilder) {
                this.parseInfoTreeBuilder = parseInfoTreeBuilder;
                return this;
            }

            public Parser build() {
                return new Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder);
            }
        }

        public void merge(Readable input, Message.Builder builder) throws IOException {
            merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(CharSequence input, Message.Builder builder) throws ParseException {
            merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(Readable input, ExtensionRegistry extensionRegistry, Message.Builder builder) throws IOException {
            merge(toStringBuilder(input), extensionRegistry, builder);
        }

        private static StringBuilder toStringBuilder(Readable input) throws IOException {
            StringBuilder text = new StringBuilder();
            CharBuffer buffer = CharBuffer.allocate(4096);
            while (true) {
                int n = input.read(buffer);
                if (n == -1) {
                    return text;
                }
                buffer.flip();
                text.append((CharSequence) buffer, 0, n);
            }
        }

        /* access modifiers changed from: package-private */
        /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Parser$UnknownField.class */
        public static final class UnknownField {
            final String message;
            final Type type;

            /* access modifiers changed from: package-private */
            /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$Parser$UnknownField$Type.class */
            public enum Type {
                FIELD,
                EXTENSION
            }

            UnknownField(String message, Type type) {
                this.message = message;
                this.type = type;
            }
        }

        private void checkUnknownFields(List<UnknownField> unknownFields) throws ParseException {
            if (!unknownFields.isEmpty()) {
                StringBuilder msg = new StringBuilder("Input contains unknown fields and/or extensions:");
                for (UnknownField field : unknownFields) {
                    msg.append('\n').append(field.message);
                }
                if (this.allowUnknownFields) {
                    TextFormat.logger.warning(msg.toString());
                    return;
                }
                int firstErrorIndex = 0;
                if (this.allowUnknownExtensions) {
                    boolean allUnknownExtensions = true;
                    Iterator<UnknownField> it = unknownFields.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().type == UnknownField.Type.FIELD) {
                            allUnknownExtensions = false;
                            break;
                        } else {
                            firstErrorIndex++;
                        }
                    }
                    if (allUnknownExtensions) {
                        TextFormat.logger.warning(msg.toString());
                        return;
                    }
                }
                String[] lineColumn = unknownFields.get(firstErrorIndex).message.split(EmitterKt.COMMENT_PREFIX);
                throw new ParseException(Integer.parseInt(lineColumn[0]), Integer.parseInt(lineColumn[1]), msg.toString());
            }
        }

        public void merge(CharSequence input, ExtensionRegistry extensionRegistry, Message.Builder builder) throws ParseException {
            Tokenizer tokenizer = new Tokenizer(input);
            MessageReflection.BuilderAdapter target = new MessageReflection.BuilderAdapter(builder);
            List<UnknownField> unknownFields = new ArrayList<>();
            while (!tokenizer.atEnd()) {
                mergeField(tokenizer, extensionRegistry, target, unknownFields);
            }
            checkUnknownFields(unknownFields);
        }

        private void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget target, List<UnknownField> unknownFields) throws ParseException {
            mergeField(tokenizer, extensionRegistry, target, this.parseInfoTreeBuilder, unknownFields);
        }

        private void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget target, TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields) throws ParseException {
            Descriptors.FieldDescriptor field = null;
            int startLine = tokenizer.getLine();
            int startColumn = tokenizer.getColumn();
            Descriptors.Descriptor type = target.getDescriptorForType();
            ExtensionRegistry.ExtensionInfo extension = null;
            if (!"google.protobuf.Any".equals(type.getFullName()) || !tokenizer.tryConsume("[")) {
                if (tokenizer.tryConsume("[")) {
                    StringBuilder name = new StringBuilder(tokenizer.consumeIdentifier());
                    while (tokenizer.tryConsume(Mapper.IGNORED_FIELDNAME)) {
                        name.append('.');
                        name.append(tokenizer.consumeIdentifier());
                    }
                    extension = target.findExtensionByName(extensionRegistry, name.toString());
                    if (extension == null) {
                        unknownFields.add(new UnknownField((tokenizer.getPreviousLine() + 1) + EmitterKt.COMMENT_PREFIX + (tokenizer.getPreviousColumn() + 1) + ":\t" + type.getFullName() + ".[" + ((Object) name) + "]", UnknownField.Type.EXTENSION));
                    } else if (extension.descriptor.getContainingType() != type) {
                        throw tokenizer.parseExceptionPreviousToken("Extension \"" + ((Object) name) + "\" does not extend message type \"" + type.getFullName() + "\".");
                    } else {
                        field = extension.descriptor;
                    }
                    tokenizer.consume("]");
                } else {
                    String name2 = tokenizer.consumeIdentifier();
                    field = type.findFieldByName(name2);
                    if (field == null) {
                        field = type.findFieldByName(name2.toLowerCase(Locale.US));
                        if (!(field == null || field.getType() == Descriptors.FieldDescriptor.Type.GROUP)) {
                            field = null;
                        }
                    }
                    if (field != null && field.getType() == Descriptors.FieldDescriptor.Type.GROUP && !field.getMessageType().getName().equals(name2)) {
                        field = null;
                    }
                    if (field == null) {
                        unknownFields.add(new UnknownField((tokenizer.getPreviousLine() + 1) + EmitterKt.COMMENT_PREFIX + (tokenizer.getPreviousColumn() + 1) + ":\t" + type.getFullName() + Mapper.IGNORED_FIELDNAME + name2, UnknownField.Type.FIELD));
                    }
                }
                if (field != null) {
                    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        tokenizer.tryConsume(EmitterKt.COMMENT_PREFIX);
                        if (parseTreeBuilder != null) {
                            consumeFieldValues(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder.getBuilderForSubMessageField(field), unknownFields);
                        } else {
                            consumeFieldValues(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder, unknownFields);
                        }
                    } else {
                        tokenizer.consume(EmitterKt.COMMENT_PREFIX);
                        consumeFieldValues(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder, unknownFields);
                    }
                    if (parseTreeBuilder != null) {
                        parseTreeBuilder.setLocation(field, TextFormatParseLocation.create(startLine, startColumn));
                    }
                    if (!tokenizer.tryConsume(";")) {
                        tokenizer.tryConsume(",");
                    }
                } else if (!tokenizer.tryConsume(EmitterKt.COMMENT_PREFIX) || tokenizer.lookingAt("{") || tokenizer.lookingAt("<")) {
                    skipFieldMessage(tokenizer);
                } else {
                    skipFieldValue(tokenizer);
                }
            } else {
                mergeAnyFieldValue(tokenizer, extensionRegistry, target, parseTreeBuilder, unknownFields, type);
            }
        }

        private void consumeFieldValues(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget target, Descriptors.FieldDescriptor field, ExtensionRegistry.ExtensionInfo extension, TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields) throws ParseException {
            if (!field.isRepeated() || !tokenizer.tryConsume("[")) {
                consumeFieldValue(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder, unknownFields);
            } else if (!tokenizer.tryConsume("]")) {
                while (true) {
                    consumeFieldValue(tokenizer, extensionRegistry, target, field, extension, parseTreeBuilder, unknownFields);
                    if (!tokenizer.tryConsume("]")) {
                        tokenizer.consume(",");
                    } else {
                        return;
                    }
                }
            }
        }

        private void consumeFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget target, Descriptors.FieldDescriptor field, ExtensionRegistry.ExtensionInfo extension, TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields) throws ParseException {
            String endToken;
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && !field.isRepeated()) {
                if (target.hasField(field)) {
                    throw tokenizer.parseExceptionPreviousToken("Non-repeated field \"" + field.getFullName() + "\" cannot be overwritten.");
                } else if (field.getContainingOneof() != null && target.hasOneof(field.getContainingOneof())) {
                    Descriptors.OneofDescriptor oneof = field.getContainingOneof();
                    throw tokenizer.parseExceptionPreviousToken("Field \"" + field.getFullName() + "\" is specified along with field \"" + target.getOneofFieldDescriptor(oneof).getFullName() + "\", another member of oneof \"" + oneof.getName() + "\".");
                }
            }
            Object value = null;
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (tokenizer.tryConsume("<")) {
                    endToken = ">";
                } else {
                    tokenizer.consume("{");
                    endToken = "}";
                }
                if (!field.getMessageType().getFullName().equals("google.protobuf.Any") || !tokenizer.tryConsume("[")) {
                    MessageReflection.MergeTarget subField = target.newMergeTargetForField(field, extension == null ? null : extension.defaultInstance);
                    while (!tokenizer.tryConsume(endToken)) {
                        if (tokenizer.atEnd()) {
                            throw tokenizer.parseException("Expected \"" + endToken + "\".");
                        }
                        mergeField(tokenizer, extensionRegistry, subField, parseTreeBuilder, unknownFields);
                    }
                    value = subField.finish();
                } else {
                    MessageReflection.MergeTarget anyField = target.newMergeTargetForField(field, DynamicMessage.getDefaultInstance(field.getMessageType()));
                    mergeAnyFieldValue(tokenizer, extensionRegistry, anyField, parseTreeBuilder, unknownFields, field.getMessageType());
                    value = anyField.finish();
                    tokenizer.consume(endToken);
                }
            } else {
                switch (field.getType()) {
                    case INT32:
                    case SINT32:
                    case SFIXED32:
                        value = Integer.valueOf(tokenizer.consumeInt32());
                        break;
                    case INT64:
                    case SINT64:
                    case SFIXED64:
                        value = Long.valueOf(tokenizer.consumeInt64());
                        break;
                    case BOOL:
                        value = Boolean.valueOf(tokenizer.consumeBoolean());
                        break;
                    case FLOAT:
                        value = Float.valueOf(tokenizer.consumeFloat());
                        break;
                    case DOUBLE:
                        value = Double.valueOf(tokenizer.consumeDouble());
                        break;
                    case UINT32:
                    case FIXED32:
                        value = Integer.valueOf(tokenizer.consumeUInt32());
                        break;
                    case UINT64:
                    case FIXED64:
                        value = Long.valueOf(tokenizer.consumeUInt64());
                        break;
                    case STRING:
                        value = tokenizer.consumeString();
                        break;
                    case BYTES:
                        value = tokenizer.consumeByteString();
                        break;
                    case ENUM:
                        Descriptors.EnumDescriptor enumType = field.getEnumType();
                        if (tokenizer.lookingAtInteger()) {
                            int number = tokenizer.consumeInt32();
                            value = enumType.findValueByNumber(number);
                            if (value == null) {
                                String unknownValueMsg = "Enum type \"" + enumType.getFullName() + "\" has no value with number " + number + '.';
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(unknownValueMsg);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + number + '.');
                            }
                        } else {
                            String id = tokenizer.consumeIdentifier();
                            value = enumType.findValueByName(id);
                            if (value == null) {
                                String unknownValueMsg2 = "Enum type \"" + enumType.getFullName() + "\" has no value named \"" + id + "\".";
                                if (this.allowUnknownEnumValues) {
                                    TextFormat.logger.warning(unknownValueMsg2);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken(unknownValueMsg2);
                            }
                        }
                        break;
                    case MESSAGE:
                    case GROUP:
                        throw new RuntimeException("Can't get here.");
                }
            }
            if (field.isRepeated()) {
                target.addRepeatedField(field, value);
            } else {
                target.setField(field, value);
            }
        }

        private void mergeAnyFieldValue(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, MessageReflection.MergeTarget target, TextFormatParseInfoTree.Builder parseTreeBuilder, List<UnknownField> unknownFields, Descriptors.Descriptor anyDescriptor) throws ParseException {
            String anyEndToken;
            StringBuilder typeUrlBuilder = new StringBuilder();
            while (true) {
                typeUrlBuilder.append(tokenizer.consumeIdentifier());
                if (tokenizer.tryConsume("]")) {
                    tokenizer.tryConsume(EmitterKt.COMMENT_PREFIX);
                    if (tokenizer.tryConsume("<")) {
                        anyEndToken = ">";
                    } else {
                        tokenizer.consume("{");
                        anyEndToken = "}";
                    }
                    String typeUrl = typeUrlBuilder.toString();
                    try {
                        Descriptors.Descriptor contentType = this.typeRegistry.getDescriptorForTypeUrl(typeUrl);
                        if (contentType == null) {
                            throw tokenizer.parseException("Unable to parse Any of type: " + typeUrl + ". Please make sure that the TypeRegistry contains the descriptors for the given types.");
                        }
                        Message.Builder contentBuilder = DynamicMessage.getDefaultInstance(contentType).newBuilderForType();
                        MessageReflection.BuilderAdapter contentTarget = new MessageReflection.BuilderAdapter(contentBuilder);
                        while (!tokenizer.tryConsume(anyEndToken)) {
                            mergeField(tokenizer, extensionRegistry, contentTarget, parseTreeBuilder, unknownFields);
                        }
                        target.setField(anyDescriptor.findFieldByName("type_url"), typeUrlBuilder.toString());
                        target.setField(anyDescriptor.findFieldByName("value"), contentBuilder.build().toByteString());
                        return;
                    } catch (InvalidProtocolBufferException e) {
                        throw tokenizer.parseException("Invalid valid type URL. Found: " + typeUrl);
                    }
                } else if (tokenizer.tryConsume("/")) {
                    typeUrlBuilder.append("/");
                } else if (tokenizer.tryConsume(Mapper.IGNORED_FIELDNAME)) {
                    typeUrlBuilder.append(Mapper.IGNORED_FIELDNAME);
                } else {
                    throw tokenizer.parseExceptionPreviousToken("Expected a valid type URL.");
                }
            }
        }

        private static void skipField(Tokenizer tokenizer) throws ParseException {
            if (tokenizer.tryConsume("[")) {
                do {
                    tokenizer.consumeIdentifier();
                } while (tokenizer.tryConsume(Mapper.IGNORED_FIELDNAME));
                tokenizer.consume("]");
            } else {
                tokenizer.consumeIdentifier();
            }
            if (!tokenizer.tryConsume(EmitterKt.COMMENT_PREFIX) || tokenizer.lookingAt("<") || tokenizer.lookingAt("{")) {
                skipFieldMessage(tokenizer);
            } else {
                skipFieldValue(tokenizer);
            }
            if (!tokenizer.tryConsume(";")) {
                tokenizer.tryConsume(",");
            }
        }

        private static void skipFieldMessage(Tokenizer tokenizer) throws ParseException {
            String delimiter;
            if (tokenizer.tryConsume("<")) {
                delimiter = ">";
            } else {
                tokenizer.consume("{");
                delimiter = "}";
            }
            while (!tokenizer.lookingAt(">") && !tokenizer.lookingAt("}")) {
                skipField(tokenizer);
            }
            tokenizer.consume(delimiter);
        }

        private static void skipFieldValue(Tokenizer tokenizer) throws ParseException {
            if (tokenizer.tryConsumeString()) {
                do {
                } while (tokenizer.tryConsumeString());
            } else if (!tokenizer.tryConsumeIdentifier() && !tokenizer.tryConsumeInt64() && !tokenizer.tryConsumeUInt64() && !tokenizer.tryConsumeDouble() && !tokenizer.tryConsumeFloat()) {
                throw tokenizer.parseException("Invalid field value: " + tokenizer.currentToken);
            }
        }
    }

    public static String escapeBytes(ByteString input) {
        return TextFormatEscaper.escapeBytes(input);
    }

    public static String escapeBytes(byte[] input) {
        return TextFormatEscaper.escapeBytes(input);
    }

    public static ByteString unescapeBytes(CharSequence charString) throws InvalidEscapeSequenceException {
        ByteString input = ByteString.copyFromUtf8(charString.toString());
        byte[] result = new byte[input.size()];
        int pos = 0;
        int i = 0;
        while (i < input.size()) {
            byte c = input.byteAt(i);
            if (c != 92) {
                pos++;
                result[pos] = c;
            } else if (i + 1 < input.size()) {
                i++;
                byte c2 = input.byteAt(i);
                if (isOctal(c2)) {
                    int code = digitValue(c2);
                    if (i + 1 < input.size() && isOctal(input.byteAt(i + 1))) {
                        i++;
                        code = (code * 8) + digitValue(input.byteAt(i));
                    }
                    if (i + 1 < input.size() && isOctal(input.byteAt(i + 1))) {
                        i++;
                        code = (code * 8) + digitValue(input.byteAt(i));
                    }
                    pos++;
                    result[pos] = (byte) code;
                } else {
                    switch (c2) {
                        case 34:
                            pos++;
                            result[pos] = 34;
                            continue;
                        case 39:
                            pos++;
                            result[pos] = 39;
                            continue;
                        case 85:
                            int i2 = i + 1;
                            if (i2 + 7 >= input.size()) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                            }
                            int codepoint = 0;
                            for (int offset = i2; offset < i2 + 8; offset++) {
                                byte b = input.byteAt(offset);
                                if (!isHex(b)) {
                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
                                }
                                codepoint = (codepoint << 4) | digitValue(b);
                            }
                            if (!Character.isValidCodePoint(codepoint)) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + input.substring(i2, i2 + 8).toStringUtf8() + "' is not a valid code point value");
                            }
                            Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(codepoint);
                            if (unicodeBlock.equals(Character.UnicodeBlock.LOW_SURROGATES) || unicodeBlock.equals(Character.UnicodeBlock.HIGH_SURROGATES) || unicodeBlock.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES)) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + input.substring(i2, i2 + 8).toStringUtf8() + "' refers to a surrogate code unit");
                            }
                            byte[] chUtf8 = new String(new int[]{codepoint}, 0, 1).getBytes(StandardCharsets.UTF_8);
                            System.arraycopy(chUtf8, 0, result, pos, chUtf8.length);
                            pos += chUtf8.length;
                            i = i2 + 7;
                            continue;
                        case 92:
                            pos++;
                            result[pos] = 92;
                            continue;
                        case 97:
                            pos++;
                            result[pos] = 7;
                            continue;
                        case 98:
                            pos++;
                            result[pos] = 8;
                            continue;
                        case 102:
                            pos++;
                            result[pos] = 12;
                            continue;
                        case 110:
                            pos++;
                            result[pos] = 10;
                            continue;
                        case 114:
                            pos++;
                            result[pos] = 13;
                            continue;
                        case 116:
                            pos++;
                            result[pos] = 9;
                            continue;
                        case 117:
                            int i3 = i + 1;
                            if (i3 + 3 >= input.size() || !isHex(input.byteAt(i3)) || !isHex(input.byteAt(i3 + 1)) || !isHex(input.byteAt(i3 + 2)) || !isHex(input.byteAt(i3 + 3))) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
                            }
                            char ch = (char) ((digitValue(input.byteAt(i3)) << 12) | (digitValue(input.byteAt(i3 + 1)) << 8) | (digitValue(input.byteAt(i3 + 2)) << 4) | digitValue(input.byteAt(i3 + 3)));
                            if (Character.isSurrogate(ch)) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
                            }
                            byte[] chUtf82 = Character.toString(ch).getBytes(StandardCharsets.UTF_8);
                            System.arraycopy(chUtf82, 0, result, pos, chUtf82.length);
                            pos += chUtf82.length;
                            i = i3 + 3;
                            continue;
                        case 118:
                            pos++;
                            result[pos] = 11;
                            continue;
                        case 120:
                            if (i + 1 >= input.size() || !isHex(input.byteAt(i + 1))) {
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                            i++;
                            int code2 = digitValue(input.byteAt(i));
                            if (i + 1 < input.size() && isHex(input.byteAt(i + 1))) {
                                i++;
                                code2 = (code2 * 16) + digitValue(input.byteAt(i));
                            }
                            pos++;
                            result[pos] = (byte) code2;
                            continue;
                        default:
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) c2) + '\'');
                    }
                }
            } else {
                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
            }
            i++;
        }
        if (result.length == pos) {
            return ByteString.wrap(result);
        }
        return ByteString.copyFrom(result, 0, pos);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormat$InvalidEscapeSequenceException.class */
    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String description) {
            super(description);
        }
    }

    static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    public static String escapeDoubleQuotesAndBackslashes(String input) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(input);
    }

    static String unescapeText(String input) throws InvalidEscapeSequenceException {
        return unescapeBytes(input).toStringUtf8();
    }

    private static boolean isOctal(byte c) {
        return 48 <= c && c <= 55;
    }

    private static boolean isHex(byte c) {
        return (48 <= c && c <= 57) || (97 <= c && c <= 102) || (65 <= c && c <= 70);
    }

    private static int digitValue(byte c) {
        if (48 <= c && c <= 57) {
            return c - 48;
        }
        if (97 > c || c > 122) {
            return (c - 65) + 10;
        }
        return (c - 97) + 10;
    }

    /* access modifiers changed from: package-private */
    public static int parseInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, true, false);
    }

    /* access modifiers changed from: package-private */
    public static int parseUInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, false, false);
    }

    /* access modifiers changed from: package-private */
    public static long parseInt64(String text) throws NumberFormatException {
        return parseInteger(text, true, true);
    }

    /* access modifiers changed from: package-private */
    public static long parseUInt64(String text) throws NumberFormatException {
        return parseInteger(text, false, true);
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARN: Type inference failed for: r0v50, types: [long] */
    private static long parseInteger(String text, boolean isSigned, boolean isLong) throws NumberFormatException {
        char c;
        int pos = 0;
        boolean negative = false;
        if (text.startsWith("-", 0)) {
            if (!isSigned) {
                throw new NumberFormatException("Number must be positive: " + text);
            }
            pos = 0 + 1;
            negative = true;
        }
        int radix = 10;
        if (text.startsWith("0x", pos)) {
            pos += 2;
            radix = 16;
        } else if (text.startsWith("0", pos)) {
            radix = 8;
        }
        String numberText = text.substring(pos);
        if (numberText.length() < 16) {
            c = Long.parseLong(numberText, radix);
            if (negative) {
                c = -c;
            }
            if (!isLong) {
                if (isSigned) {
                    if (c > 2147483647L || c < -2147483648L) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
                    }
                } else if (c >= 4294967296L || c < 0) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
                }
            }
        } else {
            BigInteger bigValue = new BigInteger(numberText, radix);
            if (negative) {
                bigValue = bigValue.negate();
            }
            if (!isLong) {
                if (isSigned) {
                    if (bigValue.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
                    }
                } else if (bigValue.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
                }
            } else if (isSigned) {
                if (bigValue.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + text);
                }
            } else if (bigValue.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + text);
            }
            c = bigValue.longValue();
        }
        return c;
    }
}
