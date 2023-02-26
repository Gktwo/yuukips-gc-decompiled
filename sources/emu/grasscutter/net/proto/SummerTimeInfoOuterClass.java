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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeInfoOuterClass.class */
public final class SummerTimeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014SummerTimeInfo.proto\u001a\u001eSummerTimeSprintBoatInfo.proto\u001a\u0019SummerTimeStageInfo.proto\"ë\u0001\n\u000eSummerTimeInfo\u00121\n\u000esprintBoatInfo\u0018\u000b \u0001(\u000b2\u0019.SummerTimeSprintBoatInfo\u0012\u0018\n\u0010contentCloseTime\u0018\u0006 \u0001(\r\u0012/\n\bstageMap\u0018\u0002 \u0003(\u000b2\u001d.SummerTimeInfo.StageMapEntry\u0012\u0014\n\fleftMonsters\u0018\t \u0001(\b\u001aE\n\rStageMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012#\n\u0005value\u0018\u0002 \u0001(\u000b2\u0014.SummerTimeStageInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SummerTimeSprintBoatInfoOuterClass.getDescriptor(), SummerTimeStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SummerTimeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeInfo_descriptor, new String[]{"SprintBoatInfo", "ContentCloseTime", "StageMap", "LeftMonsters"});
    private static final Descriptors.Descriptor internal_static_SummerTimeInfo_StageMapEntry_descriptor = internal_static_SummerTimeInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeInfo_StageMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeInfo_StageMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeInfoOuterClass$SummerTimeInfoOrBuilder.class */
    public interface SummerTimeInfoOrBuilder extends MessageOrBuilder {
        boolean hasSprintBoatInfo();

        SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo getSprintBoatInfo();

        SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder getSprintBoatInfoOrBuilder();

        int getContentCloseTime();

        int getStageMapCount();

        boolean containsStageMap(int i);

        @Deprecated
        Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMap();

        Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMapMap();

        SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrDefault(int i, SummerTimeStageInfoOuterClass.SummerTimeStageInfo summerTimeStageInfo);

        SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrThrow(int i);

        boolean getLeftMonsters();
    }

    private SummerTimeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeInfoOuterClass$SummerTimeInfo.class */
    public static final class SummerTimeInfo extends GeneratedMessageV3 implements SummerTimeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SPRINTBOATINFO_FIELD_NUMBER = 11;
        private SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo sprintBoatInfo_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 6;
        private int contentCloseTime_;
        public static final int STAGEMAP_FIELD_NUMBER = 2;
        private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> stageMap_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 9;
        private boolean leftMonsters_;
        private byte memoizedIsInitialized;
        private static final SummerTimeInfo DEFAULT_INSTANCE = new SummerTimeInfo();
        private static final Parser<SummerTimeInfo> PARSER = new AbstractParser<SummerTimeInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 2: goto L_0x0014;
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
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SummerTimeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageMap_ = MapField.newMapField(StageMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> stageMap__ = (MapEntry) input.readMessage(StageMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.stageMap_.getMutableMap().put(stageMap__.getKey(), stageMap__.getValue());
                                    break;
                                case 48:
                                    this.contentCloseTime_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.leftMonsters_ = input.readBool();
                                    break;
                                case 90:
                                    SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder subBuilder = this.sprintBoatInfo_ != null ? this.sprintBoatInfo_.toBuilder() : null;
                                    this.sprintBoatInfo_ = (SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo) input.readMessage(SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.sprintBoatInfo_);
                                        this.sprintBoatInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return SummerTimeInfoOuterClass.internal_static_SummerTimeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeInfoOuterClass.internal_static_SummerTimeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public boolean hasSprintBoatInfo() {
            return this.sprintBoatInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo getSprintBoatInfo() {
            return this.sprintBoatInfo_ == null ? SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.getDefaultInstance() : this.sprintBoatInfo_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder getSprintBoatInfoOrBuilder() {
            return getSprintBoatInfo();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeInfoOuterClass$SummerTimeInfo$StageMapDefaultEntryHolder.class */
        public static final class StageMapDefaultEntryHolder {
            static final MapEntry<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> defaultEntry = MapEntry.newDefaultInstance(SummerTimeInfoOuterClass.internal_static_SummerTimeInfo_StageMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, SummerTimeStageInfoOuterClass.SummerTimeStageInfo.getDefaultInstance());

            private StageMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> internalGetStageMap() {
            if (this.stageMap_ == null) {
                return MapField.emptyMapField(StageMapDefaultEntryHolder.defaultEntry);
            }
            return this.stageMap_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public int getStageMapCount() {
            return internalGetStageMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public boolean containsStageMap(int key) {
            return internalGetStageMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        @Deprecated
        public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMap() {
            return getStageMapMap();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMapMap() {
            return internalGetStageMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrDefault(int key, SummerTimeStageInfoOuterClass.SummerTimeStageInfo defaultValue) {
            Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrThrow(int key) {
            Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetStageMap(), StageMapDefaultEntryHolder.defaultEntry, 2);
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(6, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                output.writeBool(9, this.leftMonsters_);
            }
            if (this.sprintBoatInfo_ != null) {
                output.writeMessage(11, getSprintBoatInfo());
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
            for (Map.Entry<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> entry : internalGetStageMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(2, StageMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.leftMonsters_);
            }
            if (this.sprintBoatInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getSprintBoatInfo());
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
            if (!(obj instanceof SummerTimeInfo)) {
                return equals(obj);
            }
            SummerTimeInfo other = (SummerTimeInfo) obj;
            if (hasSprintBoatInfo() != other.hasSprintBoatInfo()) {
                return false;
            }
            return (!hasSprintBoatInfo() || getSprintBoatInfo().equals(other.getSprintBoatInfo())) && getContentCloseTime() == other.getContentCloseTime() && internalGetStageMap().equals(other.internalGetStageMap()) && getLeftMonsters() == other.getLeftMonsters() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasSprintBoatInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getSprintBoatInfo().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getContentCloseTime();
            if (!internalGetStageMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 2)) + internalGetStageMap().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 9)) + Internal.hashBoolean(getLeftMonsters()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static SummerTimeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeInfoOuterClass$SummerTimeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeInfoOrBuilder {
            private int bitField0_;
            private SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo sprintBoatInfo_;
            private SingleFieldBuilderV3<SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo, SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfo.Builder, SummerTimeSprintBoatInfoOuterClass.SummerTimeSprintBoatInfoOrBuilder> sprintBoatInfoBuilder_;
            private int contentCloseTime_;
            private MapField<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> stageMap_;
            private boolean leftMonsters_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x0014;
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 2: goto L_0x0014;
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
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeInfoOuterClass.internal_static_SummerTimeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeInfoOuterClass.internal_static_SummerTimeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.sprintBoatInfoBuilder_ == null) {
                    this.sprintBoatInfo_ = null;
                } else {
                    this.sprintBoatInfo_ = null;
                    this.sprintBoatInfoBuilder_ = null;
                }
                this.contentCloseTime_ = 0;
                internalGetMutableStageMap().clear();
                this.leftMonsters_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeInfoOuterClass.internal_static_SummerTimeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeInfo getDefaultInstanceForType() {
                return SummerTimeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeInfo build() {
                SummerTimeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeInfo buildPartial() {
                SummerTimeInfo result = new SummerTimeInfo(this);
                int i = this.bitField0_;
                if (this.sprintBoatInfoBuilder_ == null) {
                    result.sprintBoatInfo_ = this.sprintBoatInfo_;
                } else {
                    result.sprintBoatInfo_ = this.sprintBoatInfoBuilder_.build();
                }
                result.contentCloseTime_ = this.contentCloseTime_;
                result.stageMap_ = internalGetStageMap();
                result.stageMap_.makeImmutable();
                result.leftMonsters_ = this.leftMonsters_;
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
                if (other instanceof SummerTimeInfo) {
                    return mergeFrom((SummerTimeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeInfo other) {
                if (other == SummerTimeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasSprintBoatInfo()) {
                    mergeSprintBoatInfo(other.getSprintBoatInfo());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                internalGetMutableStageMap().mergeFrom(other.internalGetStageMap());
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
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
                SummerTimeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            public boolean hasSprintBoatInfo() {
                return (this.sprintBoatInfoBuilder_ == null && this.sprintBoatInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            public int getStageMapCount() {
                return internalGetStageMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            public boolean containsStageMap(int key) {
                return internalGetStageMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            @Deprecated
            public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMap() {
                return getStageMapMap();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            public Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> getStageMapMap() {
                return internalGetStageMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            public SummerTimeStageInfoOuterClass.SummerTimeStageInfo getStageMapOrDefault(int key, SummerTimeStageInfoOuterClass.SummerTimeStageInfo defaultValue) {
                Map<Integer, SummerTimeStageInfoOuterClass.SummerTimeStageInfo> map = internalGetStageMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
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

        public static SummerTimeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeInfo getDefaultInstanceForType() {
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
