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
import emu.grasscutter.net.proto.SumoStageDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoActivityDetailInfoOuterClass.class */
public final class SumoActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSumoActivityDetailInfo.proto\u001a\u0013SumoStageData.proto\"Î\u0001\n\u0016SumoActivityDetailInfo\u0012\u0015\n\rdifficulty_id\u0018\u000b \u0001(\r\u0012\u0015\n\rlast_stage_id\u0018\f \u0001(\r\u0012A\n\u000esumo_stage_map\u0018\u0001 \u0003(\u000b2).SumoActivityDetailInfo.SumoStageMapEntry\u001aC\n\u0011SumoStageMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001d\n\u0005value\u0018\u0002 \u0001(\u000b2\u000e.SumoStageData:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SumoStageDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SumoActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SumoActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SumoActivityDetailInfo_descriptor, new String[]{"DifficultyId", "LastStageId", "SumoStageMap"});

    /* renamed from: internal_static_SumoActivityDetailInfo_SumoStageMapEntry_descriptor */
    private static final Descriptors.Descriptor f882x24fc4f7c = internal_static_SumoActivityDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SumoActivityDetailInfo_SumoStageMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f883x7bd239fa = new GeneratedMessageV3.FieldAccessorTable(f882x24fc4f7c, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoActivityDetailInfoOuterClass$SumoActivityDetailInfoOrBuilder.class */
    public interface SumoActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getDifficultyId();

        int getLastStageId();

        int getSumoStageMapCount();

        boolean containsSumoStageMap(int i);

        @Deprecated
        Map<Integer, SumoStageDataOuterClass.SumoStageData> getSumoStageMap();

        Map<Integer, SumoStageDataOuterClass.SumoStageData> getSumoStageMapMap();

        SumoStageDataOuterClass.SumoStageData getSumoStageMapOrDefault(int i, SumoStageDataOuterClass.SumoStageData sumoStageData);

        SumoStageDataOuterClass.SumoStageData getSumoStageMapOrThrow(int i);
    }

    private SumoActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoActivityDetailInfoOuterClass$SumoActivityDetailInfo.class */
    public static final class SumoActivityDetailInfo extends GeneratedMessageV3 implements SumoActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DIFFICULTY_ID_FIELD_NUMBER = 11;
        private int difficultyId_;
        public static final int LAST_STAGE_ID_FIELD_NUMBER = 12;
        private int lastStageId_;
        public static final int SUMO_STAGE_MAP_FIELD_NUMBER = 1;
        private MapField<Integer, SumoStageDataOuterClass.SumoStageData> sumoStageMap_;
        private byte memoizedIsInitialized;
        private static final SumoActivityDetailInfo DEFAULT_INSTANCE = new SumoActivityDetailInfo();
        private static final Parser<SumoActivityDetailInfo> PARSER = new AbstractParser<SumoActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public SumoActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SumoActivityDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
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
                    case 1: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSumoStageMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SumoActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SumoActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SumoActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SumoActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.sumoStageMap_ = MapField.newMapField(SumoStageMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, SumoStageDataOuterClass.SumoStageData> sumoStageMap__ = (MapEntry) input.readMessage(SumoStageMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.sumoStageMap_.getMutableMap().put(sumoStageMap__.getKey(), sumoStageMap__.getValue());
                                break;
                            case 88:
                                this.difficultyId_ = input.readUInt32();
                                break;
                            case 96:
                                this.lastStageId_ = input.readUInt32();
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
            return SumoActivityDetailInfoOuterClass.internal_static_SumoActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SumoActivityDetailInfoOuterClass.internal_static_SumoActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public int getDifficultyId() {
            return this.difficultyId_;
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public int getLastStageId() {
            return this.lastStageId_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoActivityDetailInfoOuterClass$SumoActivityDetailInfo$SumoStageMapDefaultEntryHolder.class */
        public static final class SumoStageMapDefaultEntryHolder {
            static final MapEntry<Integer, SumoStageDataOuterClass.SumoStageData> defaultEntry = MapEntry.newDefaultInstance(SumoActivityDetailInfoOuterClass.f882x24fc4f7c, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, SumoStageDataOuterClass.SumoStageData.getDefaultInstance());

            private SumoStageMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, SumoStageDataOuterClass.SumoStageData> internalGetSumoStageMap() {
            if (this.sumoStageMap_ == null) {
                return MapField.emptyMapField(SumoStageMapDefaultEntryHolder.defaultEntry);
            }
            return this.sumoStageMap_;
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public int getSumoStageMapCount() {
            return internalGetSumoStageMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public boolean containsSumoStageMap(int key) {
            return internalGetSumoStageMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, SumoStageDataOuterClass.SumoStageData> getSumoStageMap() {
            return getSumoStageMapMap();
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public Map<Integer, SumoStageDataOuterClass.SumoStageData> getSumoStageMapMap() {
            return internalGetSumoStageMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public SumoStageDataOuterClass.SumoStageData getSumoStageMapOrDefault(int key, SumoStageDataOuterClass.SumoStageData defaultValue) {
            Map<Integer, SumoStageDataOuterClass.SumoStageData> map = internalGetSumoStageMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
        public SumoStageDataOuterClass.SumoStageData getSumoStageMapOrThrow(int key) {
            Map<Integer, SumoStageDataOuterClass.SumoStageData> map = internalGetSumoStageMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSumoStageMap(), SumoStageMapDefaultEntryHolder.defaultEntry, 1);
            if (this.difficultyId_ != 0) {
                output.writeUInt32(11, this.difficultyId_);
            }
            if (this.lastStageId_ != 0) {
                output.writeUInt32(12, this.lastStageId_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (Map.Entry<Integer, SumoStageDataOuterClass.SumoStageData> entry : internalGetSumoStageMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(1, SumoStageMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.difficultyId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.difficultyId_);
            }
            if (this.lastStageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.lastStageId_);
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
            if (!(obj instanceof SumoActivityDetailInfo)) {
                return equals(obj);
            }
            SumoActivityDetailInfo other = (SumoActivityDetailInfo) obj;
            return getDifficultyId() == other.getDifficultyId() && getLastStageId() == other.getLastStageId() && internalGetSumoStageMap().equals(other.internalGetSumoStageMap()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getDifficultyId())) + 12)) + getLastStageId();
            if (!internalGetSumoStageMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 1)) + internalGetSumoStageMap().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SumoActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (SumoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SumoActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SumoActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (SumoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SumoActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoActivityDetailInfoOuterClass$SumoActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SumoActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int difficultyId_;
            private int lastStageId_;
            private MapField<Integer, SumoStageDataOuterClass.SumoStageData> sumoStageMap_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSumoStageMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSumoStageMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SumoActivityDetailInfoOuterClass.internal_static_SumoActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SumoActivityDetailInfoOuterClass.internal_static_SumoActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SumoActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.difficultyId_ = 0;
                this.lastStageId_ = 0;
                internalGetMutableSumoStageMap().clear();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SumoActivityDetailInfoOuterClass.internal_static_SumoActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SumoActivityDetailInfo getDefaultInstanceForType() {
                return SumoActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoActivityDetailInfo build() {
                SumoActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoActivityDetailInfo buildPartial() {
                SumoActivityDetailInfo result = new SumoActivityDetailInfo(this);
                int i = this.bitField0_;
                result.difficultyId_ = this.difficultyId_;
                result.lastStageId_ = this.lastStageId_;
                result.sumoStageMap_ = internalGetSumoStageMap();
                result.sumoStageMap_.makeImmutable();
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
                if (other instanceof SumoActivityDetailInfo) {
                    return mergeFrom((SumoActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SumoActivityDetailInfo other) {
                if (other == SumoActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDifficultyId() != 0) {
                    setDifficultyId(other.getDifficultyId());
                }
                if (other.getLastStageId() != 0) {
                    setLastStageId(other.getLastStageId());
                }
                internalGetMutableSumoStageMap().mergeFrom(other.internalGetSumoStageMap());
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
                SumoActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SumoActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SumoActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public int getDifficultyId() {
                return this.difficultyId_;
            }

            public Builder setDifficultyId(int value) {
                this.difficultyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDifficultyId() {
                this.difficultyId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public int getLastStageId() {
                return this.lastStageId_;
            }

            public Builder setLastStageId(int value) {
                this.lastStageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastStageId() {
                this.lastStageId_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, SumoStageDataOuterClass.SumoStageData> internalGetSumoStageMap() {
                if (this.sumoStageMap_ == null) {
                    return MapField.emptyMapField(SumoStageMapDefaultEntryHolder.defaultEntry);
                }
                return this.sumoStageMap_;
            }

            private MapField<Integer, SumoStageDataOuterClass.SumoStageData> internalGetMutableSumoStageMap() {
                onChanged();
                if (this.sumoStageMap_ == null) {
                    this.sumoStageMap_ = MapField.newMapField(SumoStageMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.sumoStageMap_.isMutable()) {
                    this.sumoStageMap_ = this.sumoStageMap_.copy();
                }
                return this.sumoStageMap_;
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public int getSumoStageMapCount() {
                return internalGetSumoStageMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public boolean containsSumoStageMap(int key) {
                return internalGetSumoStageMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, SumoStageDataOuterClass.SumoStageData> getSumoStageMap() {
                return getSumoStageMapMap();
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public Map<Integer, SumoStageDataOuterClass.SumoStageData> getSumoStageMapMap() {
                return internalGetSumoStageMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public SumoStageDataOuterClass.SumoStageData getSumoStageMapOrDefault(int key, SumoStageDataOuterClass.SumoStageData defaultValue) {
                Map<Integer, SumoStageDataOuterClass.SumoStageData> map = internalGetSumoStageMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder
            public SumoStageDataOuterClass.SumoStageData getSumoStageMapOrThrow(int key) {
                Map<Integer, SumoStageDataOuterClass.SumoStageData> map = internalGetSumoStageMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSumoStageMap() {
                internalGetMutableSumoStageMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSumoStageMap(int key) {
                internalGetMutableSumoStageMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, SumoStageDataOuterClass.SumoStageData> getMutableSumoStageMap() {
                return internalGetMutableSumoStageMap().getMutableMap();
            }

            public Builder putSumoStageMap(int key, SumoStageDataOuterClass.SumoStageData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableSumoStageMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllSumoStageMap(Map<Integer, SumoStageDataOuterClass.SumoStageData> values) {
                internalGetMutableSumoStageMap().getMutableMap().putAll(values);
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

        public static SumoActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SumoActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SumoActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SumoActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SumoStageDataOuterClass.getDescriptor();
    }
}
