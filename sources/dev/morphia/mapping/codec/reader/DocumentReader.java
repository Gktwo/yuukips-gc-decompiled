package dev.morphia.mapping.codec.reader;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.BsonTypeMap;
import dev.morphia.mapping.codec.Conversions;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.bson.BsonBinary;
import org.bson.BsonDbPointer;
import org.bson.BsonJavaScript;
import org.bson.BsonJavaScriptWithScope;
import org.bson.BsonReader;
import org.bson.BsonReaderMark;
import org.bson.BsonRegularExpression;
import org.bson.BsonSerializationException;
import org.bson.BsonTimestamp;
import org.bson.BsonType;
import org.bson.Document;
import org.bson.types.Binary;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/reader/DocumentReader.class */
public class DocumentReader implements BsonReader {
    private static final BsonTypeMap TYPE_MAP = new BsonTypeMap();
    private final ReaderState start;
    private ReaderState current;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r0
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Dependency scan failed at insn: 0x0029: INVOKE_CUSTOM r-4
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r3, method: dev.morphia.mapping.codec.reader.DocumentReader.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, []}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, []}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0029: INVOKE_CUSTOM r1, method: dev.morphia.mapping.codec.reader.DocumentReader.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/mapping/codec/reader/ReaderState;)Ljava/lang/String;}, <<>>]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/mapping/codec/reader/ReaderState;)Ljava/lang/String;}, <<>>]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // java.lang.Object
    public java.lang.String toString() {
        /*
            r6 = this;
            java.util.StringJoiner r0 = new java.util.StringJoiner
            r1 = r0
            java.lang.String r2 = ", "
            java.lang.Class<dev.morphia.mapping.codec.reader.DocumentReader> r3 = dev.morphia.mapping.codec.reader.DocumentReader.class
            java.lang.String r3 = r3.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, []}
            java.lang.String r4 = "]"
            r1.<init>(r2, r3, r4)
            r7 = r0
            r0 = r6
            dev.morphia.mapping.codec.reader.ReaderState r0 = r0.start
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0046
            r0 = r8
            r1 = r6
            dev.morphia.mapping.codec.reader.ReaderState r1 = r1.current
            if (r0 != r1) goto L_0x0035
            r0 = r7
            r1 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/mapping/codec/reader/ReaderState;)Ljava/lang/String;}, <<>>]}
            java.util.StringJoiner r0 = r0.add(r1)
            goto L_0x003e
            r0 = r7
            r1 = r8
            java.lang.String r1 = r1.toString()
            java.util.StringJoiner r0 = r0.add(r1)
            r0 = r8
            dev.morphia.mapping.codec.reader.ReaderState r0 = r0.nextState()
            r8 = r0
            goto L_0x001b
            r0 = r7
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.reader.DocumentReader.toString():java.lang.String");
    }

    public DocumentReader(Document document) {
        this.current = new DocumentState(this, document);
        this.start = this.current;
    }

    public ReaderState currentState() {
        return this.current;
    }

    @Override // org.bson.BsonReader
    public BsonType getCurrentBsonType() {
        return stage().getCurrentBsonType();
    }

    @Override // org.bson.BsonReader
    public String getCurrentName() {
        return stage().name();
    }

    @Override // org.bson.BsonReader
    public BsonBinary readBinaryData() {
        Object value = stage().value();
        if (value instanceof UUID) {
            return new BsonBinary((UUID) value);
        }
        if (value instanceof Binary) {
            return new BsonBinary(((Binary) value).getType(), ((Binary) value).getData());
        }
        return (BsonBinary) value;
    }

    @Override // org.bson.BsonReader
    public byte peekBinarySubType() {
        BsonReaderMark mark = getMark();
        try {
            Object binary = stage().value();
            if (binary instanceof UUID) {
                byte version = (byte) ((UUID) binary).version();
                mark.reset();
                return version;
            } else if (binary instanceof Binary) {
                byte type = ((Binary) binary).getType();
                mark.reset();
                return type;
            } else {
                byte type2 = ((BsonBinary) binary).getType();
                mark.reset();
                return type2;
            }
        } catch (Throwable th) {
            mark.reset();
            throw th;
        }
    }

    @Override // org.bson.BsonReader
    public int peekBinarySize() {
        BsonReaderMark mark = getMark();
        try {
            Object value = stage().value();
            if (value instanceof UUID) {
                return 16;
            }
            if (value instanceof Binary) {
                int length = ((Binary) value).getData().length;
                mark.reset();
                return length;
            }
            int length2 = ((BsonBinary) value).getData().length;
            mark.reset();
            return length2;
        } finally {
            mark.reset();
        }
    }

    @Override // org.bson.BsonReader
    public BsonBinary readBinaryData(String name) {
        verifyName(name);
        return readBinaryData();
    }

    @Override // org.bson.BsonReader
    public boolean readBoolean() {
        return ((Boolean) stage().value()).booleanValue();
    }

    @Override // org.bson.BsonReader
    public boolean readBoolean(String name) {
        verifyName(name);
        return readBoolean();
    }

    @Override // org.bson.BsonReader
    public BsonType readBsonType() {
        return stage().getCurrentBsonType();
    }

    @Override // org.bson.BsonReader
    public long readDateTime() {
        Long value = (Long) Conversions.convert(stage().value(), Long.TYPE);
        if (value != null) {
            return value.longValue();
        }
        throw new IllegalStateException(Sofia.valueCannotBeNull(new Locale[0]));
    }

    @Override // org.bson.BsonReader
    public long readDateTime(String name) {
        verifyName(name);
        return readDateTime();
    }

    @Override // org.bson.BsonReader
    public double readDouble() {
        return ((Double) stage().value()).doubleValue();
    }

    @Override // org.bson.BsonReader
    public double readDouble(String name) {
        verifyName(name);
        return readDouble();
    }

    @Override // org.bson.BsonReader
    public void readEndArray() {
        stage().endArray();
    }

    @Override // org.bson.BsonReader
    public void readEndDocument() {
        stage().endDocument();
    }

    @Override // org.bson.BsonReader
    public int readInt32() {
        return ((Integer) stage().value()).intValue();
    }

    @Override // org.bson.BsonReader
    public int readInt32(String name) {
        verifyName(name);
        return readInt32();
    }

    @Override // org.bson.BsonReader
    public long readInt64() {
        return ((Long) stage().value()).longValue();
    }

    @Override // org.bson.BsonReader
    public long readInt64(String name) {
        verifyName(name);
        return readInt64();
    }

    @Override // org.bson.BsonReader
    public Decimal128 readDecimal128() {
        return (Decimal128) stage().value();
    }

    @Override // org.bson.BsonReader
    public Decimal128 readDecimal128(String name) {
        verifyName(name);
        return readDecimal128();
    }

    @Override // org.bson.BsonReader
    public String readJavaScript() {
        return ((BsonJavaScript) stage().value()).getCode();
    }

    @Override // org.bson.BsonReader
    public String readJavaScript(String name) {
        verifyName(name);
        return readJavaScript();
    }

    @Override // org.bson.BsonReader
    public String readJavaScriptWithScope() {
        return ((BsonJavaScriptWithScope) stage().value()).getCode();
    }

    @Override // org.bson.BsonReader
    public String readJavaScriptWithScope(String name) {
        verifyName(name);
        return readJavaScriptWithScope();
    }

    @Override // org.bson.BsonReader
    public void readMaxKey() {
    }

    @Override // org.bson.BsonReader
    public void readMaxKey(String name) {
        verifyName(name);
        readMaxKey();
    }

    @Override // org.bson.BsonReader
    public void readMinKey() {
    }

    @Override // org.bson.BsonReader
    public void readMinKey(String name) {
        verifyName(name);
        readMinKey();
    }

    @Override // org.bson.BsonReader
    public String readName() {
        return stage().name();
    }

    @Override // org.bson.BsonReader
    public void readName(String name) {
        verifyName(name);
    }

    @Override // org.bson.BsonReader
    public void readNull() {
        stage().advance();
    }

    @Override // org.bson.BsonReader
    public void readNull(String name) {
        verifyName(name);
        readNull();
    }

    @Override // org.bson.BsonReader
    public ObjectId readObjectId() {
        return (ObjectId) stage().value();
    }

    @Override // org.bson.BsonReader
    public ObjectId readObjectId(String name) {
        verifyName(name);
        return readObjectId();
    }

    @Override // org.bson.BsonReader
    public BsonRegularExpression readRegularExpression() {
        return (BsonRegularExpression) stage().value();
    }

    @Override // org.bson.BsonReader
    public BsonRegularExpression readRegularExpression(String name) {
        verifyName(name);
        return readRegularExpression();
    }

    @Override // org.bson.BsonReader
    public BsonDbPointer readDBPointer() {
        return (BsonDbPointer) stage().value();
    }

    @Override // org.bson.BsonReader
    public BsonDbPointer readDBPointer(String name) {
        verifyName(name);
        return readDBPointer();
    }

    @Override // org.bson.BsonReader
    public void readStartArray() {
        stage().startArray();
    }

    @Override // org.bson.BsonReader
    public void readStartDocument() {
        stage().startDocument();
    }

    @Override // org.bson.BsonReader
    public String readString() {
        return (String) stage().value();
    }

    @Override // org.bson.BsonReader
    public String readString(String name) {
        verifyName(name);
        return readString();
    }

    @Override // org.bson.BsonReader
    public String readSymbol() {
        return (String) stage().value();
    }

    @Override // org.bson.BsonReader
    public String readSymbol(String name) {
        verifyName(name);
        return readSymbol();
    }

    @Override // org.bson.BsonReader
    public BsonTimestamp readTimestamp() {
        return (BsonTimestamp) stage().value();
    }

    @Override // org.bson.BsonReader
    public BsonTimestamp readTimestamp(String name) {
        verifyName(name);
        return readTimestamp();
    }

    @Override // org.bson.BsonReader
    public void readUndefined() {
    }

    @Override // org.bson.BsonReader
    public void readUndefined(String name) {
        verifyName(name);
        readUndefined();
    }

    @Override // org.bson.BsonReader
    public void skipName() {
        stage().skipName();
    }

    @Override // org.bson.BsonReader
    public void skipValue() {
        stage().skipValue();
    }

    @Override // org.bson.BsonReader
    public BsonReaderMark getMark() {
        return new Mark(this, stage());
    }

    @Override // org.bson.BsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected void verifyName(String expectedName) {
        String actualName = readName();
        if (!actualName.equals(expectedName)) {
            throw new BsonSerializationException(String.format("Expected element name to be '%s', not '%s'.", expectedName, actualName));
        }
    }

    /* access modifiers changed from: package-private */
    public BsonType getBsonType(@Nullable Object o) {
        BsonType bsonType = o == null ? BsonType.NULL : TYPE_MAP.get(o.getClass());
        if (bsonType == null) {
            if (o instanceof List) {
                bsonType = BsonType.ARRAY;
            } else {
                bsonType = BsonType.UNDEFINED;
            }
        }
        return bsonType;
    }

    /* access modifiers changed from: package-private */
    public void reset(ReaderState bookmark) {
        this.current = bookmark;
    }

    ReaderState stage() {
        return this.current;
    }

    /* access modifiers changed from: package-private */
    public void state(@Nullable ReaderState next) {
        this.current = next;
    }
}
