package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.VintageCampChallengeLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageCampChallengeStageDataOuterClass.class */
public final class VintageCampChallengeStageDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#VintageCampChallengeStageData.proto\u001a#VintageCampChallengeLevelData.proto\"£\u0002\n\u001dVintageCampChallengeStageData\u0012\u001a\n\u0012max_finished_level\u0018\u0004 \u0001(\r\u0012\u0011\n\tis_finish\u0018\u000e \u0001(\b\u0012H\n\u000ecamp_level_map\u0018\u0006 \u0003(\u000b20.VintageCampChallengeStageData.CampLevelMapEntry\u0012\u000f\n\u0007is_open\u0018\u0002 \u0001(\b\u0012\u0010\n\bstage_id\u0018\r \u0001(\r\u0012\u0011\n\topen_time\u0018\u0007 \u0001(\r\u001aS\n\u0011CampLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012-\n\u0005value\u0018\u0002 \u0001(\u000b2\u001e.VintageCampChallengeLevelData:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VintageCampChallengeLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageCampChallengeStageData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageCampChallengeStageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageCampChallengeStageData_descriptor, new String[]{"MaxFinishedLevel", "IsFinish", "CampLevelMap", "IsOpen", "StageId", "OpenTime"});

    /* renamed from: internal_static_VintageCampChallengeStageData_CampLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f929x1e216a17 = internal_static_VintageCampChallengeStageData_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_VintageCampChallengeStageData_CampLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f930x38ac8995 = new GeneratedMessageV3.FieldAccessorTable(f929x1e216a17, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageCampChallengeStageDataOuterClass$VintageCampChallengeStageDataOrBuilder.class */
    public interface VintageCampChallengeStageDataOrBuilder extends MessageOrBuilder {
        int getMaxFinishedLevel();

        boolean getIsFinish();

        int getCampLevelMapCount();

        boolean containsCampLevelMap(int i);

        @Deprecated
        Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getCampLevelMap();

        Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getCampLevelMapMap();

        VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData getCampLevelMapOrDefault(int i, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData vintageCampChallengeLevelData);

        VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData getCampLevelMapOrThrow(int i);

        boolean getIsOpen();

        int getStageId();

        int getOpenTime();
    }

    private VintageCampChallengeStageDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageCampChallengeStageDataOuterClass$VintageCampChallengeStageData.class */
    public static final class VintageCampChallengeStageData extends GeneratedMessageV3 implements VintageCampChallengeStageDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAX_FINISHED_LEVEL_FIELD_NUMBER = 4;
        private int maxFinishedLevel_;
        public static final int IS_FINISH_FIELD_NUMBER = 14;
        private boolean isFinish_;
        public static final int CAMP_LEVEL_MAP_FIELD_NUMBER = 6;
        private MapField<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> campLevelMap_;
        public static final int IS_OPEN_FIELD_NUMBER = 2;
        private boolean isOpen_;
        public static final int STAGE_ID_FIELD_NUMBER = 13;
        private int stageId_;
        public static final int OPEN_TIME_FIELD_NUMBER = 7;
        private int openTime_;
        private byte memoizedIsInitialized;
        private static final VintageCampChallengeStageData DEFAULT_INSTANCE = new VintageCampChallengeStageData();
        private static final Parser<VintageCampChallengeStageData> PARSER = new AbstractParser<VintageCampChallengeStageData>() { // from class: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.1
            @Override // com.google.protobuf.Parser
            public VintageCampChallengeStageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageCampChallengeStageData(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 6: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetCampLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private VintageCampChallengeStageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintageCampChallengeStageData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageCampChallengeStageData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintageCampChallengeStageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.isOpen_ = input.readBool();
                                break;
                            case 32:
                                this.maxFinishedLevel_ = input.readUInt32();
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.campLevelMap_ = MapField.newMapField(CampLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> campLevelMap__ = (MapEntry) input.readMessage(CampLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.campLevelMap_.getMutableMap().put(campLevelMap__.getKey(), campLevelMap__.getValue());
                                break;
                            case 56:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 104:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 112:
                                this.isFinish_ = input.readBool();
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
            return VintageCampChallengeStageDataOuterClass.internal_static_VintageCampChallengeStageData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageCampChallengeStageDataOuterClass.internal_static_VintageCampChallengeStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageCampChallengeStageData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public int getMaxFinishedLevel() {
            return this.maxFinishedLevel_;
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageCampChallengeStageDataOuterClass$VintageCampChallengeStageData$CampLevelMapDefaultEntryHolder.class */
        public static final class CampLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> defaultEntry = MapEntry.newDefaultInstance(VintageCampChallengeStageDataOuterClass.f929x1e216a17, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData.getDefaultInstance());

            private CampLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> internalGetCampLevelMap() {
            if (this.campLevelMap_ == null) {
                return MapField.emptyMapField(CampLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.campLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public int getCampLevelMapCount() {
            return internalGetCampLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public boolean containsCampLevelMap(int key) {
            return internalGetCampLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        @Deprecated
        public Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getCampLevelMap() {
            return getCampLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getCampLevelMapMap() {
            return internalGetCampLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData getCampLevelMapOrDefault(int key, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData defaultValue) {
            Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> map = internalGetCampLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData getCampLevelMapOrThrow(int key) {
            Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> map = internalGetCampLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
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
            if (this.isOpen_) {
                output.writeBool(2, this.isOpen_);
            }
            if (this.maxFinishedLevel_ != 0) {
                output.writeUInt32(4, this.maxFinishedLevel_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetCampLevelMap(), CampLevelMapDefaultEntryHolder.defaultEntry, 6);
            if (this.openTime_ != 0) {
                output.writeUInt32(7, this.openTime_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(13, this.stageId_);
            }
            if (this.isFinish_) {
                output.writeBool(14, this.isFinish_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isOpen_);
            }
            if (this.maxFinishedLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.maxFinishedLevel_);
            }
            for (Map.Entry<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> entry : internalGetCampLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(6, CampLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.openTime_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.stageId_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isFinish_);
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
            if (!(obj instanceof VintageCampChallengeStageData)) {
                return equals(obj);
            }
            VintageCampChallengeStageData other = (VintageCampChallengeStageData) obj;
            return getMaxFinishedLevel() == other.getMaxFinishedLevel() && getIsFinish() == other.getIsFinish() && internalGetCampLevelMap().equals(other.internalGetCampLevelMap()) && getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getOpenTime() == other.getOpenTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getMaxFinishedLevel())) + 14)) + Internal.hashBoolean(getIsFinish());
            if (!internalGetCampLevelMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 6)) + internalGetCampLevelMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + Internal.hashBoolean(getIsOpen()))) + 13)) + getStageId())) + 7)) + getOpenTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VintageCampChallengeStageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageCampChallengeStageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageCampChallengeStageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageCampChallengeStageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageCampChallengeStageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageCampChallengeStageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageCampChallengeStageData parseFrom(InputStream input) throws IOException {
            return (VintageCampChallengeStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageCampChallengeStageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageCampChallengeStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageCampChallengeStageData parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageCampChallengeStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageCampChallengeStageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageCampChallengeStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageCampChallengeStageData parseFrom(CodedInputStream input) throws IOException {
            return (VintageCampChallengeStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageCampChallengeStageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageCampChallengeStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageCampChallengeStageData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageCampChallengeStageDataOuterClass$VintageCampChallengeStageData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageCampChallengeStageDataOrBuilder {
            private int bitField0_;
            private int maxFinishedLevel_;
            private boolean isFinish_;
            private MapField<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> campLevelMap_;
            private boolean isOpen_;
            private int stageId_;
            private int openTime_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetCampLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableCampLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageData.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageCampChallengeStageDataOuterClass.internal_static_VintageCampChallengeStageData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageCampChallengeStageDataOuterClass.internal_static_VintageCampChallengeStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageCampChallengeStageData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageCampChallengeStageData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.maxFinishedLevel_ = 0;
                this.isFinish_ = false;
                internalGetMutableCampLevelMap().clear();
                this.isOpen_ = false;
                this.stageId_ = 0;
                this.openTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageCampChallengeStageDataOuterClass.internal_static_VintageCampChallengeStageData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageCampChallengeStageData getDefaultInstanceForType() {
                return VintageCampChallengeStageData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageCampChallengeStageData build() {
                VintageCampChallengeStageData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageCampChallengeStageData buildPartial() {
                VintageCampChallengeStageData result = new VintageCampChallengeStageData(this);
                int i = this.bitField0_;
                result.maxFinishedLevel_ = this.maxFinishedLevel_;
                result.isFinish_ = this.isFinish_;
                result.campLevelMap_ = internalGetCampLevelMap();
                result.campLevelMap_.makeImmutable();
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                result.openTime_ = this.openTime_;
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
                if (other instanceof VintageCampChallengeStageData) {
                    return mergeFrom((VintageCampChallengeStageData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageCampChallengeStageData other) {
                if (other == VintageCampChallengeStageData.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaxFinishedLevel() != 0) {
                    setMaxFinishedLevel(other.getMaxFinishedLevel());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                internalGetMutableCampLevelMap().mergeFrom(other.internalGetCampLevelMap());
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
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
                VintageCampChallengeStageData parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageCampChallengeStageData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageCampChallengeStageData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public int getMaxFinishedLevel() {
                return this.maxFinishedLevel_;
            }

            public Builder setMaxFinishedLevel(int value) {
                this.maxFinishedLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxFinishedLevel() {
                this.maxFinishedLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> internalGetCampLevelMap() {
                if (this.campLevelMap_ == null) {
                    return MapField.emptyMapField(CampLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.campLevelMap_;
            }

            private MapField<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> internalGetMutableCampLevelMap() {
                onChanged();
                if (this.campLevelMap_ == null) {
                    this.campLevelMap_ = MapField.newMapField(CampLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.campLevelMap_.isMutable()) {
                    this.campLevelMap_ = this.campLevelMap_.copy();
                }
                return this.campLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public int getCampLevelMapCount() {
                return internalGetCampLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public boolean containsCampLevelMap(int key) {
                return internalGetCampLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            @Deprecated
            public Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getCampLevelMap() {
                return getCampLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getCampLevelMapMap() {
                return internalGetCampLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData getCampLevelMapOrDefault(int key, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData defaultValue) {
                Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> map = internalGetCampLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData getCampLevelMapOrThrow(int key) {
                Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> map = internalGetCampLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearCampLevelMap() {
                internalGetMutableCampLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeCampLevelMap(int key) {
                internalGetMutableCampLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> getMutableCampLevelMap() {
                return internalGetMutableCampLevelMap().getMutableMap();
            }

            public Builder putCampLevelMap(int key, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableCampLevelMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllCampLevelMap(Map<Integer, VintageCampChallengeLevelDataOuterClass.VintageCampChallengeLevelData> values) {
                internalGetMutableCampLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageCampChallengeStageDataOuterClass.VintageCampChallengeStageDataOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
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

        public static VintageCampChallengeStageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageCampChallengeStageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageCampChallengeStageData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageCampChallengeStageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VintageCampChallengeLevelDataOuterClass.getDescriptor();
    }
}
