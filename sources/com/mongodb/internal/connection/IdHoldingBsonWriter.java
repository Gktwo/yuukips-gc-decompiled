package com.mongodb.internal.connection;

import java.util.Objects;
import java.util.function.Supplier;
import org.bson.BsonBinary;
import org.bson.BsonBinaryWriter;
import org.bson.BsonBoolean;
import org.bson.BsonDateTime;
import org.bson.BsonDbPointer;
import org.bson.BsonDecimal128;
import org.bson.BsonDocument;
import org.bson.BsonDouble;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonJavaScript;
import org.bson.BsonJavaScriptWithScope;
import org.bson.BsonMaxKey;
import org.bson.BsonMinKey;
import org.bson.BsonNull;
import org.bson.BsonObjectId;
import org.bson.BsonReader;
import org.bson.BsonRegularExpression;
import org.bson.BsonString;
import org.bson.BsonSymbol;
import org.bson.BsonTimestamp;
import org.bson.BsonUndefined;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.RawBsonDocument;
import org.bson.p022io.BasicOutputBuffer;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class */
public class IdHoldingBsonWriter extends LevelCountingBsonWriter {
    private static final String ID_FIELD_NAME = "_id";
    private LevelCountingBsonWriter idBsonBinaryWriter;
    private BasicOutputBuffer outputBuffer;
    private String currentFieldName;

    /* renamed from: id */
    private BsonValue f455id;

    public IdHoldingBsonWriter(BsonWriter bsonWriter) {
        super(bsonWriter);
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument(String name) {
        setCurrentFieldName(name);
        if (isWritingId()) {
            getIdBsonWriter().writeStartDocument(name);
        }
        writeStartDocument(name);
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartDocument() {
        if (isWritingId()) {
            getIdBsonWriter().writeStartDocument();
        }
        writeStartDocument();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeEndDocument() {
        if (isWritingId()) {
            if (getIdBsonWriter().getCurrentLevel() >= 0) {
                getIdBsonWriter().writeEndDocument();
            }
            if (getIdBsonWriter().getCurrentLevel() == -1) {
                if (this.f455id != null && this.f455id.isJavaScriptWithScope()) {
                    this.f455id = new BsonJavaScriptWithScope(this.f455id.asJavaScriptWithScope().getCode(), new RawBsonDocument(getBytes()));
                } else if (this.f455id == null) {
                    this.f455id = new RawBsonDocument(getBytes());
                }
            }
        }
        if (getCurrentLevel() == 0 && this.f455id == null) {
            this.f455id = new BsonObjectId();
            writeObjectId("_id", this.f455id.asObjectId().getValue());
        }
        writeEndDocument();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartArray() {
        if (isWritingId()) {
            if (getIdBsonWriter().getCurrentLevel() == -1) {
                getIdBsonWriter().writeStartDocument();
                getIdBsonWriter().writeName("_id");
            }
            getIdBsonWriter().writeStartArray();
        }
        writeStartArray();
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeStartArray(String name) {
        setCurrentFieldName(name);
        if (isWritingId()) {
            if (getIdBsonWriter().getCurrentLevel() == -1) {
                getIdBsonWriter().writeStartDocument();
            }
            getIdBsonWriter().writeStartArray(name);
        }
        writeStartArray(name);
    }

    @Override // com.mongodb.internal.connection.LevelCountingBsonWriter, com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeEndArray() {
        if (isWritingId()) {
            getIdBsonWriter().writeEndArray();
            if (getIdBsonWriter().getCurrentLevel() == 0) {
                getIdBsonWriter().writeEndDocument();
                this.f455id = new RawBsonDocument(getBytes()).get((Object) "_id");
            }
        }
        writeEndArray();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBinaryData(String name, BsonBinary binary) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return binary;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'binary' org.bson.BsonBinary A[D('binary' org.bson.BsonBinary), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonBinary) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBinaryData$0(org.bson.BsonBinary):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'binary' org.bson.BsonBinary A[D('binary' org.bson.BsonBinary), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:org.bson.BsonBinary) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBinaryData$1(java.lang.String, org.bson.BsonBinary):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBinaryData(java.lang.String, org.bson.BsonBinary):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeBinaryData$0(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeBinaryData$1(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeBinaryData(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBinaryData(java.lang.String, org.bson.BsonBinary):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBinaryData(BsonBinary binary) {
        addBsonValue(() -> {
            return binary;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'binary' org.bson.BsonBinary A[D('binary' org.bson.BsonBinary), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonBinary) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBinaryData$2(org.bson.BsonBinary):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'binary' org.bson.BsonBinary A[D('binary' org.bson.BsonBinary), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:org.bson.BsonBinary) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBinaryData$3(org.bson.BsonBinary):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBinaryData(org.bson.BsonBinary):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeBinaryData$2(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeBinaryData$3(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeBinaryData(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBinaryData(org.bson.BsonBinary):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBoolean(String name, boolean value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return BsonBoolean.valueOf(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' boolean A[D('value' boolean), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:boolean) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBoolean$4(boolean):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' boolean A[D('value' boolean), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:boolean) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBoolean$5(java.lang.String, boolean):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBoolean(java.lang.String, boolean):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeBoolean$4(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeBoolean$5(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeBoolean(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBoolean(java.lang.String, boolean):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeBoolean(boolean value) {
        addBsonValue(() -> {
            return BsonBoolean.valueOf(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' boolean A[D('value' boolean), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:boolean) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBoolean$6(boolean):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' boolean A[D('value' boolean), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:boolean) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeBoolean$7(boolean):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBoolean(boolean):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeBoolean$6(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeBoolean$7(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeBoolean(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeBoolean(boolean):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDateTime(String name, long value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonDateTime(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r7v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r9v0 'value' long A[D('value' long), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:long) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDateTime$8(long):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r7v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r8v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r9v0 'value' long A[D('value' long), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:long) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDateTime$9(java.lang.String, long):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDateTime(java.lang.String, long):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r7
            r1 = r8
            r0.setCurrentFieldName(r1)
            r0 = r7
            r1 = r9
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDateTime$8(r1);
            }
            r2 = r7
            r3 = r8
            r4 = r9
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDateTime$9(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r7
            r1 = r8
            r2 = r9
            r0.writeDateTime(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDateTime(java.lang.String, long):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDateTime(long value) {
        addBsonValue(() -> {
            return new BsonDateTime(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r7v0 'value' long A[D('value' long), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:long) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDateTime$10(long):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'value' long A[D('value' long), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:long) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDateTime$11(long):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDateTime(long):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDateTime$10(r1);
            }
            r2 = r6
            r3 = r7
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDateTime$11(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r0.writeDateTime(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDateTime(long):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDBPointer(String name, BsonDbPointer value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return value;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' org.bson.BsonDbPointer A[D('value' org.bson.BsonDbPointer), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonDbPointer) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDBPointer$12(org.bson.BsonDbPointer):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' org.bson.BsonDbPointer A[D('value' org.bson.BsonDbPointer), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:org.bson.BsonDbPointer) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDBPointer$13(java.lang.String, org.bson.BsonDbPointer):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDBPointer(java.lang.String, org.bson.BsonDbPointer):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDBPointer$12(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDBPointer$13(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeDBPointer(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDBPointer(java.lang.String, org.bson.BsonDbPointer):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDBPointer(BsonDbPointer value) {
        addBsonValue(() -> {
            return value;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' org.bson.BsonDbPointer A[D('value' org.bson.BsonDbPointer), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonDbPointer) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDBPointer$14(org.bson.BsonDbPointer):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' org.bson.BsonDbPointer A[D('value' org.bson.BsonDbPointer), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:org.bson.BsonDbPointer) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDBPointer$15(org.bson.BsonDbPointer):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDBPointer(org.bson.BsonDbPointer):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDBPointer$14(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDBPointer$15(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeDBPointer(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDBPointer(org.bson.BsonDbPointer):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDouble(String name, double value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonDouble(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r7v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r9v0 'value' double A[D('value' double), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:double) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDouble$16(double):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r7v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r8v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r9v0 'value' double A[D('value' double), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:double) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDouble$17(java.lang.String, double):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDouble(java.lang.String, double):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r7
            r1 = r8
            r0.setCurrentFieldName(r1)
            r0 = r7
            r1 = r9
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDouble$16(r1);
            }
            r2 = r7
            r3 = r8
            r4 = r9
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDouble$17(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r7
            r1 = r8
            r2 = r9
            r0.writeDouble(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDouble(java.lang.String, double):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDouble(double value) {
        addBsonValue(() -> {
            return new BsonDouble(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r7v0 'value' double A[D('value' double), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:double) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDouble$18(double):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'value' double A[D('value' double), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:double) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDouble$19(double):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDouble(double):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDouble$18(r1);
            }
            r2 = r6
            r3 = r7
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDouble$19(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r0.writeDouble(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDouble(double):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt32(String name, int value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonInt32(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' int A[D('value' int), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:int) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt32$20(int):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' int A[D('value' int), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:int) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt32$21(java.lang.String, int):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt32(java.lang.String, int):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeInt32$20(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeInt32$21(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeInt32(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt32(java.lang.String, int):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt32(int value) {
        addBsonValue(() -> {
            return new BsonInt32(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' int A[D('value' int), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:int) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt32$22(int):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' int A[D('value' int), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:int) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt32$23(int):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt32(int):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeInt32$22(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeInt32$23(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeInt32(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt32(int):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt64(String name, long value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonInt64(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r7v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r9v0 'value' long A[D('value' long), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:long) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt64$24(long):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r7v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r8v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r9v0 'value' long A[D('value' long), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:long) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt64$25(java.lang.String, long):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt64(java.lang.String, long):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r7
            r1 = r8
            r0.setCurrentFieldName(r1)
            r0 = r7
            r1 = r9
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeInt64$24(r1);
            }
            r2 = r7
            r3 = r8
            r4 = r9
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeInt64$25(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r7
            r1 = r8
            r2 = r9
            r0.writeInt64(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt64(java.lang.String, long):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeInt64(long value) {
        addBsonValue(() -> {
            return new BsonInt64(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r7v0 'value' long A[D('value' long), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:long) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt64$26(long):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'value' long A[D('value' long), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:long) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeInt64$27(long):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt64(long):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeInt64$26(r1);
            }
            r2 = r6
            r3 = r7
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeInt64$27(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r0.writeInt64(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeInt64(long):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDecimal128(String name, Decimal128 value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonDecimal128(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' org.bson.types.Decimal128 A[D('value' org.bson.types.Decimal128), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.types.Decimal128) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDecimal128$28(org.bson.types.Decimal128):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' org.bson.types.Decimal128 A[D('value' org.bson.types.Decimal128), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:org.bson.types.Decimal128) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDecimal128$29(java.lang.String, org.bson.types.Decimal128):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDecimal128(java.lang.String, org.bson.types.Decimal128):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDecimal128$28(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDecimal128$29(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeDecimal128(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDecimal128(java.lang.String, org.bson.types.Decimal128):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeDecimal128(Decimal128 value) {
        addBsonValue(() -> {
            return new BsonDecimal128(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' org.bson.types.Decimal128 A[D('value' org.bson.types.Decimal128), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.types.Decimal128) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDecimal128$30(org.bson.types.Decimal128):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' org.bson.types.Decimal128 A[D('value' org.bson.types.Decimal128), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:org.bson.types.Decimal128) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeDecimal128$31(org.bson.types.Decimal128):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDecimal128(org.bson.types.Decimal128):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeDecimal128$30(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeDecimal128$31(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeDecimal128(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeDecimal128(org.bson.types.Decimal128):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScript(String name, String code) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonJavaScript(code);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScript$32(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScript$33(java.lang.String, java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScript(java.lang.String, java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeJavaScript$32(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeJavaScript$33(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeJavaScript(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScript(java.lang.String, java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScript(String code) {
        addBsonValue(() -> {
            return new BsonJavaScript(code);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScript$34(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScript$35(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScript(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeJavaScript$34(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeJavaScript$35(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeJavaScript(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScript(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScriptWithScope(String name, String code) {
        addBsonValue(() -> {
            return new BsonJavaScriptWithScope(code, new BsonDocument());
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScriptWithScope$36(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000a: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScriptWithScope$37(java.lang.String, java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScriptWithScope(java.lang.String, java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeJavaScriptWithScope$36(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeJavaScriptWithScope$37(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeJavaScriptWithScope(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScriptWithScope(java.lang.String, java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeJavaScriptWithScope(String code) {
        addBsonValue(() -> {
            return new BsonJavaScriptWithScope(code, new BsonDocument());
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScriptWithScope$38(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'code' java.lang.String A[D('code' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeJavaScriptWithScope$39(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScriptWithScope(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeJavaScriptWithScope$38(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeJavaScriptWithScope$39(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeJavaScriptWithScope(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeJavaScriptWithScope(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMaxKey(String name) {
        setCurrentFieldName(name);
        addBsonValue(BsonMaxKey::new, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = 
             handle type: INVOKE_CONSTRUCTOR
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: CONSTRUCTOR   call: org.bson.BsonMaxKey.<init>():void type: CONSTRUCTOR)
              (wrap: java.lang.Runnable : 0x000d: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeMaxKey$40(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeMaxKey(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            r0.setCurrentFieldName(r1)
            r0 = r5
            void r1 = org.bson.BsonMaxKey::new
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeMaxKey$40(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeMaxKey(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeMaxKey(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMaxKey() {
        Supplier<BsonValue> r1 = BsonMaxKey::new;
        LevelCountingBsonWriter levelCountingBsonWriter = this.idBsonBinaryWriter;
        Objects.requireNonNull(levelCountingBsonWriter);
        addBsonValue(r1, this::writeMaxKey);
        writeMaxKey();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMinKey(String name) {
        setCurrentFieldName(name);
        addBsonValue(BsonMinKey::new, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = 
             handle type: INVOKE_CONSTRUCTOR
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: CONSTRUCTOR   call: org.bson.BsonMinKey.<init>():void type: CONSTRUCTOR)
              (wrap: java.lang.Runnable : 0x000d: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeMinKey$41(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeMinKey(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            r0.setCurrentFieldName(r1)
            r0 = r5
            void r1 = org.bson.BsonMinKey::new
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeMinKey$41(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeMinKey(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeMinKey(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeMinKey() {
        Supplier<BsonValue> r1 = BsonMinKey::new;
        LevelCountingBsonWriter levelCountingBsonWriter = this.idBsonBinaryWriter;
        Objects.requireNonNull(levelCountingBsonWriter);
        addBsonValue(r1, this::writeMinKey);
        writeMinKey();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeName(String name) {
        setCurrentFieldName(name);
        if (getIdBsonWriter().getCurrentLevel() >= 0) {
            getIdBsonWriter().writeName(name);
        }
        writeName(name);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeNull(String name) {
        setCurrentFieldName(name);
        addBsonValue(BsonNull::new, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = 
             handle type: INVOKE_CONSTRUCTOR
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: CONSTRUCTOR   call: org.bson.BsonNull.<init>():void type: CONSTRUCTOR)
              (wrap: java.lang.Runnable : 0x000d: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeNull$42(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeNull(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            r0.setCurrentFieldName(r1)
            r0 = r5
            void r1 = org.bson.BsonNull::new
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeNull$42(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeNull(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeNull(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeNull() {
        Supplier<BsonValue> r1 = BsonNull::new;
        LevelCountingBsonWriter levelCountingBsonWriter = this.idBsonBinaryWriter;
        Objects.requireNonNull(levelCountingBsonWriter);
        addBsonValue(r1, this::writeNull);
        writeNull();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeObjectId(String name, ObjectId objectId) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonObjectId(objectId);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'objectId' org.bson.types.ObjectId A[D('objectId' org.bson.types.ObjectId), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.types.ObjectId) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeObjectId$43(org.bson.types.ObjectId):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'objectId' org.bson.types.ObjectId A[D('objectId' org.bson.types.ObjectId), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:org.bson.types.ObjectId) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeObjectId$44(java.lang.String, org.bson.types.ObjectId):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeObjectId(java.lang.String, org.bson.types.ObjectId):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeObjectId$43(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeObjectId$44(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeObjectId(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeObjectId(java.lang.String, org.bson.types.ObjectId):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeObjectId(ObjectId objectId) {
        addBsonValue(() -> {
            return new BsonObjectId(objectId);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'objectId' org.bson.types.ObjectId A[D('objectId' org.bson.types.ObjectId), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.types.ObjectId) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeObjectId$45(org.bson.types.ObjectId):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'objectId' org.bson.types.ObjectId A[D('objectId' org.bson.types.ObjectId), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:org.bson.types.ObjectId) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeObjectId$46(org.bson.types.ObjectId):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeObjectId(org.bson.types.ObjectId):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeObjectId$45(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeObjectId$46(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeObjectId(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeObjectId(org.bson.types.ObjectId):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeRegularExpression(String name, BsonRegularExpression regularExpression) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return regularExpression;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = 
              (r8v0 'regularExpression' org.bson.BsonRegularExpression A[D('regularExpression' org.bson.BsonRegularExpression), DONT_INLINE])
            
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonRegularExpression) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeRegularExpression$47(org.bson.BsonRegularExpression):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'regularExpression' org.bson.BsonRegularExpression A[D('regularExpression' org.bson.BsonRegularExpression), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter)
              (r3 I:java.lang.String)
              (r4 I:org.bson.BsonRegularExpression)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeRegularExpression$48(java.lang.String, org.bson.BsonRegularExpression):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeRegularExpression(java.lang.String, org.bson.BsonRegularExpression):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeRegularExpression$47(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeRegularExpression$48(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeRegularExpression(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeRegularExpression(java.lang.String, org.bson.BsonRegularExpression):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeRegularExpression(BsonRegularExpression regularExpression) {
        addBsonValue(() -> {
            return regularExpression;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = 
              (r6v0 'regularExpression' org.bson.BsonRegularExpression A[D('regularExpression' org.bson.BsonRegularExpression), DONT_INLINE])
            
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonRegularExpression) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeRegularExpression$49(org.bson.BsonRegularExpression):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'regularExpression' org.bson.BsonRegularExpression A[D('regularExpression' org.bson.BsonRegularExpression), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:org.bson.BsonRegularExpression) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeRegularExpression$50(org.bson.BsonRegularExpression):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeRegularExpression(org.bson.BsonRegularExpression):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeRegularExpression$49(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeRegularExpression$50(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeRegularExpression(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeRegularExpression(org.bson.BsonRegularExpression):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeString(String name, String value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonString(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeString$51(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeString$52(java.lang.String, java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeString(java.lang.String, java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeString$51(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeString$52(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeString(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeString(java.lang.String, java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeString(String value) {
        addBsonValue(() -> {
            return new BsonString(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeString$53(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeString$54(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeString(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeString$53(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeString$54(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeString(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeString(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeSymbol(String name, String value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return new BsonSymbol(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeSymbol$55(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeSymbol$56(java.lang.String, java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeSymbol(java.lang.String, java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeSymbol$55(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeSymbol$56(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeSymbol(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeSymbol(java.lang.String, java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeSymbol(String value) {
        addBsonValue(() -> {
            return new BsonSymbol(value);
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:java.lang.String) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeSymbol$57(java.lang.String):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' java.lang.String A[D('value' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeSymbol$58(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeSymbol(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeSymbol$57(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeSymbol$58(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeSymbol(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeSymbol(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeTimestamp(String name, BsonTimestamp value) {
        setCurrentFieldName(name);
        addBsonValue(() -> {
            return value;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0007: INVOKE_CUSTOM (r1v2 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r8v0 'value' org.bson.BsonTimestamp A[D('value' org.bson.BsonTimestamp), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonTimestamp) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeTimestamp$59(org.bson.BsonTimestamp):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x000f: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
              (r8v0 'value' org.bson.BsonTimestamp A[D('value' org.bson.BsonTimestamp), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String), (r4 I:org.bson.BsonTimestamp) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeTimestamp$60(java.lang.String, org.bson.BsonTimestamp):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeTimestamp(java.lang.String, org.bson.BsonTimestamp):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r6
            r1 = r7
            r0.setCurrentFieldName(r1)
            r0 = r6
            r1 = r8
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeTimestamp$59(r1);
            }
            r2 = r6
            r3 = r7
            r4 = r8
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeTimestamp$60(r3, r4);
            }
            r0.addBsonValue(r1, r2)
            r0 = r6
            r1 = r7
            r2 = r8
            r0.writeTimestamp(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeTimestamp(java.lang.String, org.bson.BsonTimestamp):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeTimestamp(BsonTimestamp value) {
        addBsonValue(() -> {
            return value;
        }, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0002: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = (r6v0 'value' org.bson.BsonTimestamp A[D('value' org.bson.BsonTimestamp), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:org.bson.BsonTimestamp) type: STATIC call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeTimestamp$61(org.bson.BsonTimestamp):org.bson.BsonValue)
              (wrap: java.lang.Runnable : 0x0009: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'value' org.bson.BsonTimestamp A[D('value' org.bson.BsonTimestamp), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:org.bson.BsonTimestamp) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeTimestamp$62(org.bson.BsonTimestamp):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeTimestamp(org.bson.BsonTimestamp):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            void r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return lambda$writeTimestamp$61(r1);
            }
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeTimestamp$62(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeTimestamp(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeTimestamp(org.bson.BsonTimestamp):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeUndefined(String name) {
        setCurrentFieldName(name);
        addBsonValue(BsonUndefined::new, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), IMMUTABLE_TYPE, THIS])
              (wrap: java.util.function.Supplier<org.bson.BsonValue> : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Supplier<org.bson.BsonValue> A[REMOVE]) = 
             handle type: INVOKE_CONSTRUCTOR
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: CONSTRUCTOR   call: org.bson.BsonUndefined.<init>():void type: CONSTRUCTOR)
              (wrap: java.lang.Runnable : 0x000d: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' com.mongodb.internal.connection.IdHoldingBsonWriter A[D('this' com.mongodb.internal.connection.IdHoldingBsonWriter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'name' java.lang.String A[D('name' java.lang.String), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r2 I:com.mongodb.internal.connection.IdHoldingBsonWriter), (r3 I:java.lang.String) type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.lambda$writeUndefined$63(java.lang.String):void)
             type: DIRECT call: com.mongodb.internal.connection.IdHoldingBsonWriter.addBsonValue(java.util.function.Supplier, java.lang.Runnable):void in method: com.mongodb.internal.connection.IdHoldingBsonWriter.writeUndefined(java.lang.String):void, file: grasscutter.jar:com/mongodb/internal/connection/IdHoldingBsonWriter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r5
            r1 = r6
            r0.setCurrentFieldName(r1)
            r0 = r5
            void r1 = org.bson.BsonUndefined::new
            r2 = r5
            r3 = r6
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$writeUndefined$63(r3);
            }
            r0.addBsonValue(r1, r2)
            r0 = r5
            r1 = r6
            r0.writeUndefined(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.IdHoldingBsonWriter.writeUndefined(java.lang.String):void");
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void writeUndefined() {
        Supplier<BsonValue> r1 = BsonUndefined::new;
        LevelCountingBsonWriter levelCountingBsonWriter = this.idBsonBinaryWriter;
        Objects.requireNonNull(levelCountingBsonWriter);
        addBsonValue(r1, this::writeUndefined);
        writeUndefined();
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void pipe(BsonReader reader) {
        pipe(reader);
    }

    @Override // com.mongodb.internal.connection.BsonWriterDecorator, org.bson.BsonWriter
    public void flush() {
        flush();
    }

    public BsonValue getId() {
        return this.f455id;
    }

    private void setCurrentFieldName(String name) {
        this.currentFieldName = name;
    }

    private boolean isWritingId() {
        return getIdBsonWriter().getCurrentLevel() >= 0 || (getCurrentLevel() == 0 && this.currentFieldName != null && this.currentFieldName.equals("_id"));
    }

    private void addBsonValue(Supplier<BsonValue> value, Runnable writeValue) {
        if (!isWritingId()) {
            return;
        }
        if (getIdBsonWriter().getCurrentLevel() >= 0) {
            writeValue.run();
        } else {
            this.f455id = value.get();
        }
    }

    private LevelCountingBsonWriter getIdBsonWriter() {
        if (this.idBsonBinaryWriter == null) {
            this.outputBuffer = new BasicOutputBuffer();
            this.idBsonBinaryWriter = new LevelCountingBsonWriter(new BsonBinaryWriter(this.outputBuffer)) { // from class: com.mongodb.internal.connection.IdHoldingBsonWriter.1
            };
        }
        return this.idBsonBinaryWriter;
    }

    private byte[] getBytes() {
        return this.outputBuffer.getInternalBuffer();
    }
}
