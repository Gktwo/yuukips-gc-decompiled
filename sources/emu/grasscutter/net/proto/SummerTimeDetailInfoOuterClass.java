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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.SummerTimeSprintBoatInfoOuterClass;
import emu.grasscutter.net.proto.SummerTimeStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDetailInfoOuterClass.class */
public final class SummerTimeDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSummerTimeDetailInfo.proto\u001a\u001eSummerTimeSprintBoatInfo.proto\u001a\u0019SummerTimeStageInfo.proto\"\u0002\n\u0014SummerTimeDetailInfo\u00126\n\tstage_map\u0018\t \u0003(\u000b2#.SummerTimeDetailInfo.StageMapEntry\u00123\n\u0010sprint_boat_info\u0018\u0001 \u0001(\u000b2\u0019.SummerTimeSprintBoatInfo\u0012\u0019\n\u0011is_content_closed\u0018\r \u0001(\b\u0012\u001a\n\u0012content_close_time\u0018\f \u0001(\r\u001aE\n\rStageMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012#\n\u0005value\u0018\u0002 \u0001(\u000b2\u0014.SummerTimeStageInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SummerTimeSprintBoatInfoOuterClass.getDescriptor(), SummerTimeStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SummerTimeDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeDetailInfo_descriptor, new String[]{"StageMap", "SprintBoatInfo", "IsContentClosed", "ContentCloseTime"});
    private static final Descriptors.Descriptor internal_static_SummerTimeDetailInfo_StageMapEntry_descriptor = internal_static_SummerTimeDetailInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SummerTimeDetailInfo_StageMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f881xb44198d = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeDetailInfo_StageMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDetailInfoOuterClass$SummerTimeDetailInfoOrBuilder.class */
    public interface SummerTimeDetailInfoOrBuilder extends MessageOrBuilder {
        int getStageMapCount();

        boolean containsStageMap(int i);

        @Deprecated
        Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMap();

        Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMapMap();

        SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrDefault(int i, SummerTimeStageInfoOuterClass.SummerTimeStageInfo summerTimeStageInfo);

        SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrThrow(int i);

        boolean hasSprintBoatInfo();

        SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo getSprintBoatInfo();

        SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder getSprintBoatInfoOrBuilder();

        boolean getIsContentClosed();

        int getContentCloseTime();
    }

    private SummerTimeDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDetailInfoOuterClass$SummerTimeDetailInfo.class */
    public static final class SummerTimeDetailInfo extends GeneratedMessageV3 implements SummerTimeDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_MAP_FIELD_NUMBER = 9;
        private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> stageMap_;
        public static final int SPRINT_BOAT_INFO_FIELD_NUMBER = 1;
        private SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo sprintBoatInfo_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 13;
        private boolean isContentClosed_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 12;
        private int contentCloseTime_;
        private byte memoizedIsInitialized;
        private static final SummerTimeDetailInfo DEFAULT_INSTANCE = new SummerTimeDetailInfo();
        private static final Parser<SummerTimeDetailInfo> PARSER = new AbstractParser<SummerTimeDetailInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeDetailInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 9: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetStageMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SummerTimeDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder subBuilder = this.sprintBoatInfo_ != null ? this.sprintBoatInfo_.toBuilder() : null;
                                    this.sprintBoatInfo_ = (SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo) input.readMessage(SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.sprintBoatInfo_);
                                        this.sprintBoatInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageMap_ = MapField.newMapField(StageMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> stageMap__ = (MapEntry) input.readMessage(StageMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.stageMap_.getMutableMap().put(stageMap__.getKey(), stageMap__.getValue());
                                    break;
                                case 96:
                                    this.contentCloseTime_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isContentClosed_ = input.readBool();
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
                        }
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
            return SummerTimeDetailInfoOuterClass.internal_static_SummerTimeDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeDetailInfoOuterClass.internal_static_SummerTimeDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeDetailInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDetailInfoOuterClass$SummerTimeDetailInfo$StageMapDefaultEntryHolder.class */
        public static final class StageMapDefaultEntryHolder {
            static final MapEntry<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> defaultEntry = MapEntry.newDefaultInstance(SummerTimeDetailInfoOuterClass.internal_static_SummerTimeDetailInfo_StageMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, SummerTimeStageInfoOuterClass.SummerTimeStageInfo.getDefaultInstance());

            private StageMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> internalGetStageMap() {
            if (this.stageMap_ == null) {
                return MapField.emptyMapField(StageMapDefaultEntryHolder.defaultEntry);
            }
            return this.stageMap_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public int getStageMapCount() {
            return internalGetStageMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public boolean containsStageMap(int key) {
            return internalGetStageMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        @Deprecated
        public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMap() {
            return getStageMapMap();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMapMap() {
            return internalGetStageMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrDefault(int key, SummerTimeStageInfoOuterClass.SummerTimeStageInfo defaultValue) {
            Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrThrow(int key) {
            Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public boolean hasSprintBoatInfo() {
            return this.sprintBoatInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo getSprintBoatInfo() {
            return this.sprintBoatInfo_ == null ? SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.getDefaultInstance() : this.sprintBoatInfo_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder getSprintBoatInfoOrBuilder() {
            return getSprintBoatInfo();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
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
            if (this.sprintBoatInfo_ != null) {
                output.writeMessage(1, getSprintBoatInfo());
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetStageMap(), StageMapDefaultEntryHolder.defaultEntry, 9);
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(12, this.contentCloseTime_);
            }
            if (this.isContentClosed_) {
                output.writeBool(13, this.isContentClosed_);
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
            if (this.sprintBoatInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getSprintBoatInfo());
            }
            for (Map.Entry<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> entry : internalGetStageMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(9, StageMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.contentCloseTime_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isContentClosed_);
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
            if (!(obj instanceof SummerTimeDetailInfo)) {
                return equals(obj);
            }
            SummerTimeDetailInfo other = (SummerTimeDetailInfo) obj;
            if (internalGetStageMap().equals(other.internalGetStageMap()) && hasSprintBoatInfo() == other.hasSprintBoatInfo()) {
                return (!hasSprintBoatInfo() || getSprintBoatInfo().equals(other.getSprintBoatInfo())) && getIsContentClosed() == other.getIsContentClosed() && getContentCloseTime() == other.getContentCloseTime() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetStageMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetStageMap().hashCode();
            }
            if (hasSprintBoatInfo()) {
                hash = (53 * ((37 * hash) + 1)) + getSprintBoatInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 13)) + Internal.hashBoolean(getIsContentClosed()))) + 12)) + getContentCloseTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SummerTimeDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeDetailInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeDetailInfoOuterClass$SummerTimeDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeDetailInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> stageMap_;
            private SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo sprintBoatInfo_;
            private SingleFieldBuilderV3<SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo, SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder, SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder> sprintBoatInfoBuilder_;
            private boolean isContentClosed_;
            private int contentCloseTime_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetStageMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 9: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableStageMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeDetailInfoOuterClass.internal_static_SummerTimeDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeDetailInfoOuterClass.internal_static_SummerTimeDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableStageMap().clear();
                if (this.sprintBoatInfoBuilder_ == null) {
                    this.sprintBoatInfo_ = null;
                } else {
                    this.sprintBoatInfo_ = null;
                    this.sprintBoatInfoBuilder_ = null;
                }
                this.isContentClosed_ = false;
                this.contentCloseTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeDetailInfoOuterClass.internal_static_SummerTimeDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeDetailInfo getDefaultInstanceForType() {
                return SummerTimeDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeDetailInfo build() {
                SummerTimeDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeDetailInfo buildPartial() {
                SummerTimeDetailInfo result = new SummerTimeDetailInfo(this);
                int i = this.bitField0_;
                result.stageMap_ = internalGetStageMap();
                result.stageMap_.makeImmutable();
                if (this.sprintBoatInfoBuilder_ == null) {
                    result.sprintBoatInfo_ = this.sprintBoatInfo_;
                } else {
                    result.sprintBoatInfo_ = this.sprintBoatInfoBuilder_.build();
                }
                result.isContentClosed_ = this.isContentClosed_;
                result.contentCloseTime_ = this.contentCloseTime_;
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
                if (other instanceof SummerTimeDetailInfo) {
                    return mergeFrom((SummerTimeDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeDetailInfo other) {
                if (other == SummerTimeDetailInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableStageMap().mergeFrom(other.internalGetStageMap());
                if (other.hasSprintBoatInfo()) {
                    mergeSprintBoatInfo(other.getSprintBoatInfo());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
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
                SummerTimeDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> internalGetStageMap() {
                if (this.stageMap_ == null) {
                    return MapField.emptyMapField(StageMapDefaultEntryHolder.defaultEntry);
                }
                return this.stageMap_;
            }

            private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> internalGetMutableStageMap() {
                onChanged();
                if (this.stageMap_ == null) {
                    this.stageMap_ = MapField.newMapField(StageMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.stageMap_.isMutable()) {
                    this.stageMap_ = this.stageMap_.copy();
                }
                return this.stageMap_;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public int getStageMapCount() {
                return internalGetStageMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public boolean containsStageMap(int key) {
                return internalGetStageMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            @Deprecated
            public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMap() {
                return getStageMapMap();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMapMap() {
                return internalGetStageMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrDefault(int key, SummerTimeStageInfoOuterClass.SummerTimeStageInfo defaultValue) {
                Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrThrow(int key) {
                Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearStageMap() {
                internalGetMutableStageMap().getMutableMap().clear();
                return this;
            }

            public Builder removeStageMap(int key) {
                internalGetMutableStageMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getMutableStageMap() {
                return internalGetMutableStageMap().getMutableMap();
            }

            public Builder putStageMap(int key, SummerTimeStageInfoOuterClass.SummerTimeStageInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableStageMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllStageMap(Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> values) {
                internalGetMutableStageMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public boolean hasSprintBoatInfo() {
                return (this.sprintBoatInfoBuilder_ == null && this.sprintBoatInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo getSprintBoatInfo() {
                if (this.sprintBoatInfoBuilder_ == null) {
                    return this.sprintBoatInfo_ == null ? SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.getDefaultInstance() : this.sprintBoatInfo_;
                }
                return this.sprintBoatInfoBuilder_.getMessage();
            }

            public Builder setSprintBoatInfo(SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo value) {
                if (this.sprintBoatInfoBuilder_ != null) {
                    this.sprintBoatInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.sprintBoatInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSprintBoatInfo(SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder builderForValue) {
                if (this.sprintBoatInfoBuilder_ == null) {
                    this.sprintBoatInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sprintBoatInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSprintBoatInfo(SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo value) {
                if (this.sprintBoatInfoBuilder_ == null) {
                    if (this.sprintBoatInfo_ != null) {
                        this.sprintBoatInfo_ = SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.newBuilder(this.sprintBoatInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.sprintBoatInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.sprintBoatInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSprintBoatInfo() {
                if (this.sprintBoatInfoBuilder_ == null) {
                    this.sprintBoatInfo_ = null;
                    onChanged();
                } else {
                    this.sprintBoatInfo_ = null;
                    this.sprintBoatInfoBuilder_ = null;
                }
                return this;
            }

            public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder getSprintBoatInfoBuilder() {
                onChanged();
                return getSprintBoatInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder getSprintBoatInfoOrBuilder() {
                if (this.sprintBoatInfoBuilder_ != null) {
                    return this.sprintBoatInfoBuilder_.getMessageOrBuilder();
                }
                return this.sprintBoatInfo_ == null ? SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.getDefaultInstance() : this.sprintBoatInfo_;
            }

            private SingleFieldBuilderV3<SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo, SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder, SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder> getSprintBoatInfoFieldBuilder() {
                if (this.sprintBoatInfoBuilder_ == null) {
                    this.sprintBoatInfoBuilder_ = new SingleFieldBuilderV3<>(getSprintBoatInfo(), getParentForChildren(), isClean());
                    this.sprintBoatInfo_ = null;
                }
                return this.sprintBoatInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
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

        public static SummerTimeDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SummerTimeSprintBoatInfoOuterClass.getDescriptor();
        SummerTimeStageInfoOuterClass.getDescriptor();
    }
}
