package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestTimeVarNotifyOuterClass.class */
public final class QuestUpdateQuestTimeVarNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#QuestUpdateQuestTimeVarNotify.proto\"­\u0001\n\u001dQuestUpdateQuestTimeVarNotify\u0012\u0015\n\rparentQuestId\u0018\u0005 \u0001(\r\u0012B\n\ntimeVarMap\u0018\b \u0003(\u000b2..QuestUpdateQuestTimeVarNotify.TimeVarMapEntry\u001a1\n\u000fTimeVarMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestUpdateQuestTimeVarNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestUpdateQuestTimeVarNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestUpdateQuestTimeVarNotify_descriptor, new String[]{"ParentQuestId", "TimeVarMap"});

    /* renamed from: internal_static_QuestUpdateQuestTimeVarNotify_TimeVarMapEntry_descriptor */
    private static final Descriptors.Descriptor f816xdc53cc00 = internal_static_QuestUpdateQuestTimeVarNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_QuestUpdateQuestTimeVarNotify_TimeVarMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f817x8536f27e = new GeneratedMessageV3.FieldAccessorTable(f816xdc53cc00, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestTimeVarNotifyOuterClass$QuestUpdateQuestTimeVarNotifyOrBuilder.class */
    public interface QuestUpdateQuestTimeVarNotifyOrBuilder extends MessageOrBuilder {
        int getParentQuestId();

        int getTimeVarMapCount();

        boolean containsTimeVarMap(int i);

        @Deprecated
        Map<Integer, Integer> getTimeVarMap();

        Map<Integer, Integer> getTimeVarMapMap();

        int getTimeVarMapOrDefault(int i, int i2);

        int getTimeVarMapOrThrow(int i);
    }

    private QuestUpdateQuestTimeVarNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestTimeVarNotifyOuterClass$QuestUpdateQuestTimeVarNotify.class */
    public static final class QuestUpdateQuestTimeVarNotify extends GeneratedMessageV3 implements QuestUpdateQuestTimeVarNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENTQUESTID_FIELD_NUMBER = 5;
        private int parentQuestId_;
        public static final int TIMEVARMAP_FIELD_NUMBER = 8;
        private MapField<Integer, Integer> timeVarMap_;
        private byte memoizedIsInitialized;
        private static final QuestUpdateQuestTimeVarNotify DEFAULT_INSTANCE = new QuestUpdateQuestTimeVarNotify();
        private static final Parser<QuestUpdateQuestTimeVarNotify> PARSER = new AbstractParser<QuestUpdateQuestTimeVarNotify>() { // from class: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.1
            @Override // com.google.protobuf.Parser
            public QuestUpdateQuestTimeVarNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestUpdateQuestTimeVarNotify(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.internalGetMapField(int):com.google.protobuf.MapField
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.MapField internalGetMapField(int r5) {
            /*
                r4 = this;
                r0 = r5
                switch(r0) {
                    case 8: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetTimeVarMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private QuestUpdateQuestTimeVarNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestUpdateQuestTimeVarNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestUpdateQuestTimeVarNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestUpdateQuestTimeVarNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                int mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 40:
                                this.parentQuestId_ = input.readUInt32();
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.timeVarMap_ = MapField.newMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> timeVarMap__ = (MapEntry) input.readMessage(TimeVarMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.timeVarMap_.getMutableMap().put(timeVarMap__.getKey(), timeVarMap__.getValue());
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestUpdateQuestTimeVarNotifyOuterClass.internal_static_QuestUpdateQuestTimeVarNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestUpdateQuestTimeVarNotifyOuterClass.internal_static_QuestUpdateQuestTimeVarNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestTimeVarNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestTimeVarNotifyOuterClass$QuestUpdateQuestTimeVarNotify$TimeVarMapDefaultEntryHolder.class */
        public static final class TimeVarMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(QuestUpdateQuestTimeVarNotifyOuterClass.f816xdc53cc00, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private TimeVarMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetTimeVarMap() {
            if (this.timeVarMap_ == null) {
                return MapField.emptyMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
            }
            return this.timeVarMap_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        public int getTimeVarMapCount() {
            return internalGetTimeVarMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        public boolean containsTimeVarMap(int key) {
            return internalGetTimeVarMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        @Deprecated
        public Map<Integer, Integer> getTimeVarMap() {
            return getTimeVarMapMap();
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        public Map<Integer, Integer> getTimeVarMapMap() {
            return internalGetTimeVarMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        public int getTimeVarMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
        public int getTimeVarMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(5, this.parentQuestId_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetTimeVarMap(), TimeVarMapDefaultEntryHolder.defaultEntry, 8);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.parentQuestId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.parentQuestId_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetTimeVarMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(8, TimeVarMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QuestUpdateQuestTimeVarNotify)) {
                return equals(obj);
            }
            QuestUpdateQuestTimeVarNotify other = (QuestUpdateQuestTimeVarNotify) obj;
            return getParentQuestId() == other.getParentQuestId() && internalGetTimeVarMap().equals(other.internalGetTimeVarMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getParentQuestId();
            if (!internalGetTimeVarMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 8)) + internalGetTimeVarMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestTimeVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestTimeVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestTimeVarNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestTimeVarNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestTimeVarNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestTimeVarNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(CodedInputStream input) throws IOException {
            return (QuestUpdateQuestTimeVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestTimeVarNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestTimeVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestUpdateQuestTimeVarNotify prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestTimeVarNotifyOuterClass$QuestUpdateQuestTimeVarNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestUpdateQuestTimeVarNotifyOrBuilder {
            private int bitField0_;
            private int parentQuestId_;
            private MapField<Integer, Integer> timeVarMap_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 8: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetTimeVarMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 8: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableTimeVarMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestUpdateQuestTimeVarNotifyOuterClass.internal_static_QuestUpdateQuestTimeVarNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestUpdateQuestTimeVarNotifyOuterClass.internal_static_QuestUpdateQuestTimeVarNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestTimeVarNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestUpdateQuestTimeVarNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentQuestId_ = 0;
                internalGetMutableTimeVarMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestUpdateQuestTimeVarNotifyOuterClass.internal_static_QuestUpdateQuestTimeVarNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestUpdateQuestTimeVarNotify getDefaultInstanceForType() {
                return QuestUpdateQuestTimeVarNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestTimeVarNotify build() {
                QuestUpdateQuestTimeVarNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestTimeVarNotify buildPartial() {
                QuestUpdateQuestTimeVarNotify result = new QuestUpdateQuestTimeVarNotify(this);
                int i = this.bitField0_;
                result.parentQuestId_ = this.parentQuestId_;
                result.timeVarMap_ = internalGetTimeVarMap();
                result.timeVarMap_.makeImmutable();
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof QuestUpdateQuestTimeVarNotify) {
                    return mergeFrom((QuestUpdateQuestTimeVarNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestUpdateQuestTimeVarNotify other) {
                if (other == QuestUpdateQuestTimeVarNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                internalGetMutableTimeVarMap().mergeFrom(other.internalGetTimeVarMap());
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                QuestUpdateQuestTimeVarNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestUpdateQuestTimeVarNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestUpdateQuestTimeVarNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            public int getParentQuestId() {
                return this.parentQuestId_;
            }

            public Builder setParentQuestId(int value) {
                this.parentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestId() {
                this.parentQuestId_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetTimeVarMap() {
                if (this.timeVarMap_ == null) {
                    return MapField.emptyMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
                }
                return this.timeVarMap_;
            }

            private MapField<Integer, Integer> internalGetMutableTimeVarMap() {
                onChanged();
                if (this.timeVarMap_ == null) {
                    this.timeVarMap_ = MapField.newMapField(TimeVarMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.timeVarMap_.isMutable()) {
                    this.timeVarMap_ = this.timeVarMap_.copy();
                }
                return this.timeVarMap_;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            public int getTimeVarMapCount() {
                return internalGetTimeVarMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            public boolean containsTimeVarMap(int key) {
                return internalGetTimeVarMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            @Deprecated
            public Map<Integer, Integer> getTimeVarMap() {
                return getTimeVarMapMap();
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            public Map<Integer, Integer> getTimeVarMapMap() {
                return internalGetTimeVarMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            public int getTimeVarMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestTimeVarNotifyOuterClass.QuestUpdateQuestTimeVarNotifyOrBuilder
            public int getTimeVarMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetTimeVarMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearTimeVarMap() {
                internalGetMutableTimeVarMap().getMutableMap().clear();
                return this;
            }

            public Builder removeTimeVarMap(int key) {
                internalGetMutableTimeVarMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableTimeVarMap() {
                return internalGetMutableTimeVarMap().getMutableMap();
            }

            public Builder putTimeVarMap(int key, int value) {
                internalGetMutableTimeVarMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllTimeVarMap(Map<Integer, Integer> values) {
                internalGetMutableTimeVarMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static QuestUpdateQuestTimeVarNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestUpdateQuestTimeVarNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestUpdateQuestTimeVarNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestUpdateQuestTimeVarNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
