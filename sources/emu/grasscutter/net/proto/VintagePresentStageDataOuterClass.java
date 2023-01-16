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
import emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentStageDataOuterClass.class */
public final class VintagePresentStageDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dVintagePresentStageData.proto\u001a\u001dVintagePresentLevelData.proto\"þ\u0001\n\u0017VintagePresentStageData\u0012\u000f\n\u0007is_open\u0018\u0004 \u0001(\b\u0012\u0011\n\tis_finish\u0018\n \u0001(\b\u0012H\n\u0011present_level_map\u0018\u000b \u0003(\u000b2-.VintagePresentStageData.PresentLevelMapEntry\u0012\u0011\n\topen_time\u0018\b \u0001(\r\u0012\u0010\n\bstage_id\u0018\u0001 \u0001(\r\u001aP\n\u0014PresentLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012'\n\u0005value\u0018\u0002 \u0001(\u000b2\u0018.VintagePresentLevelData:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VintagePresentLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintagePresentStageData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintagePresentStageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintagePresentStageData_descriptor, new String[]{"IsOpen", "IsFinish", "PresentLevelMap", "OpenTime", "StageId"});

    /* renamed from: internal_static_VintagePresentStageData_PresentLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f934x20c96714 = internal_static_VintagePresentStageData_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_VintagePresentStageData_PresentLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f935x893a3992 = new GeneratedMessageV3.FieldAccessorTable(f934x20c96714, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentStageDataOuterClass$VintagePresentStageDataOrBuilder.class */
    public interface VintagePresentStageDataOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        boolean getIsFinish();

        int getPresentLevelMapCount();

        boolean containsPresentLevelMap(int i);

        @Deprecated
        Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getPresentLevelMap();

        Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getPresentLevelMapMap();

        VintagePresentLevelDataOuterClass.VintagePresentLevelData getPresentLevelMapOrDefault(int i, VintagePresentLevelDataOuterClass.VintagePresentLevelData vintagePresentLevelData);

        VintagePresentLevelDataOuterClass.VintagePresentLevelData getPresentLevelMapOrThrow(int i);

        int getOpenTime();

        int getStageId();
    }

    private VintagePresentStageDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentStageDataOuterClass$VintagePresentStageData.class */
    public static final class VintagePresentStageData extends GeneratedMessageV3 implements VintagePresentStageDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_OPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        public static final int IS_FINISH_FIELD_NUMBER = 10;
        private boolean isFinish_;
        public static final int PRESENT_LEVEL_MAP_FIELD_NUMBER = 11;
        private MapField<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> presentLevelMap_;
        public static final int OPEN_TIME_FIELD_NUMBER = 8;
        private int openTime_;
        public static final int STAGE_ID_FIELD_NUMBER = 1;
        private int stageId_;
        private byte memoizedIsInitialized;
        private static final VintagePresentStageData DEFAULT_INSTANCE = new VintagePresentStageData();
        private static final Parser<VintagePresentStageData> PARSER = new AbstractParser<VintagePresentStageData>() { // from class: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.1
            @Override // com.google.protobuf.Parser
            public VintagePresentStageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintagePresentStageData(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 11: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPresentLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private VintagePresentStageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintagePresentStageData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintagePresentStageData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintagePresentStageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.stageId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 64:
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.presentLevelMap_ = MapField.newMapField(PresentLevelMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> presentLevelMap__ = (MapEntry) input.readMessage(PresentLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.presentLevelMap_.getMutableMap().put(presentLevelMap__.getKey(), presentLevelMap__.getValue());
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VintagePresentStageDataOuterClass.internal_static_VintagePresentStageData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintagePresentStageDataOuterClass.internal_static_VintagePresentStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintagePresentStageData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentStageDataOuterClass$VintagePresentStageData$PresentLevelMapDefaultEntryHolder.class */
        public static final class PresentLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> defaultEntry = MapEntry.newDefaultInstance(VintagePresentStageDataOuterClass.f934x20c96714, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, VintagePresentLevelDataOuterClass.VintagePresentLevelData.getDefaultInstance());

            private PresentLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> internalGetPresentLevelMap() {
            if (this.presentLevelMap_ == null) {
                return MapField.emptyMapField(PresentLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.presentLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public int getPresentLevelMapCount() {
            return internalGetPresentLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public boolean containsPresentLevelMap(int key) {
            return internalGetPresentLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        @Deprecated
        public Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getPresentLevelMap() {
            return getPresentLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getPresentLevelMapMap() {
            return internalGetPresentLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public VintagePresentLevelDataOuterClass.VintagePresentLevelData getPresentLevelMapOrDefault(int key, VintagePresentLevelDataOuterClass.VintagePresentLevelData defaultValue) {
            Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> map = internalGetPresentLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public VintagePresentLevelDataOuterClass.VintagePresentLevelData getPresentLevelMapOrThrow(int key) {
            Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> map = internalGetPresentLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
        public int getStageId() {
            return this.stageId_;
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
            if (this.stageId_ != 0) {
                output.writeUInt32(1, this.stageId_);
            }
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(8, this.openTime_);
            }
            if (this.isFinish_) {
                output.writeBool(10, this.isFinish_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPresentLevelMap(), PresentLevelMapDefaultEntryHolder.defaultEntry, 11);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.stageId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.stageId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.openTime_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isFinish_);
            }
            for (Map.Entry<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> entry : internalGetPresentLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(11, PresentLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof VintagePresentStageData)) {
                return equals(obj);
            }
            VintagePresentStageData other = (VintagePresentStageData) obj;
            return getIsOpen() == other.getIsOpen() && getIsFinish() == other.getIsFinish() && internalGetPresentLevelMap().equals(other.internalGetPresentLevelMap()) && getOpenTime() == other.getOpenTime() && getStageId() == other.getStageId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsOpen()))) + 10)) + Internal.hashBoolean(getIsFinish());
            if (!internalGetPresentLevelMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 11)) + internalGetPresentLevelMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + getOpenTime())) + 1)) + getStageId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VintagePresentStageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintagePresentStageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintagePresentStageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintagePresentStageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintagePresentStageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintagePresentStageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintagePresentStageData parseFrom(InputStream input) throws IOException {
            return (VintagePresentStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintagePresentStageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintagePresentStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintagePresentStageData parseDelimitedFrom(InputStream input) throws IOException {
            return (VintagePresentStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintagePresentStageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintagePresentStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintagePresentStageData parseFrom(CodedInputStream input) throws IOException {
            return (VintagePresentStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintagePresentStageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintagePresentStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintagePresentStageData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentStageDataOuterClass$VintagePresentStageData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintagePresentStageDataOrBuilder {
            private int bitField0_;
            private boolean isOpen_;
            private boolean isFinish_;
            private MapField<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> presentLevelMap_;
            private int openTime_;
            private int stageId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPresentLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 11: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePresentLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageData.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VintagePresentStageDataOuterClass.internal_static_VintagePresentStageData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintagePresentStageDataOuterClass.internal_static_VintagePresentStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintagePresentStageData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintagePresentStageData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.isFinish_ = false;
                internalGetMutablePresentLevelMap().clear();
                this.openTime_ = 0;
                this.stageId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintagePresentStageDataOuterClass.internal_static_VintagePresentStageData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintagePresentStageData getDefaultInstanceForType() {
                return VintagePresentStageData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintagePresentStageData build() {
                VintagePresentStageData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintagePresentStageData buildPartial() {
                VintagePresentStageData result = new VintagePresentStageData(this);
                int i = this.bitField0_;
                result.isOpen_ = this.isOpen_;
                result.isFinish_ = this.isFinish_;
                result.presentLevelMap_ = internalGetPresentLevelMap();
                result.presentLevelMap_.makeImmutable();
                result.openTime_ = this.openTime_;
                result.stageId_ = this.stageId_;
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
                if (other instanceof VintagePresentStageData) {
                    return mergeFrom((VintagePresentStageData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintagePresentStageData other) {
                if (other == VintagePresentStageData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                internalGetMutablePresentLevelMap().mergeFrom(other.internalGetPresentLevelMap());
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
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
                VintagePresentStageData parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintagePresentStageData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintagePresentStageData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
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

            private MapField<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> internalGetPresentLevelMap() {
                if (this.presentLevelMap_ == null) {
                    return MapField.emptyMapField(PresentLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.presentLevelMap_;
            }

            private MapField<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> internalGetMutablePresentLevelMap() {
                onChanged();
                if (this.presentLevelMap_ == null) {
                    this.presentLevelMap_ = MapField.newMapField(PresentLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.presentLevelMap_.isMutable()) {
                    this.presentLevelMap_ = this.presentLevelMap_.copy();
                }
                return this.presentLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
            public int getPresentLevelMapCount() {
                return internalGetPresentLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
            public boolean containsPresentLevelMap(int key) {
                return internalGetPresentLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
            @Deprecated
            public Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getPresentLevelMap() {
                return getPresentLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
            public Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getPresentLevelMapMap() {
                return internalGetPresentLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
            public VintagePresentLevelDataOuterClass.VintagePresentLevelData getPresentLevelMapOrDefault(int key, VintagePresentLevelDataOuterClass.VintagePresentLevelData defaultValue) {
                Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> map = internalGetPresentLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
            public VintagePresentLevelDataOuterClass.VintagePresentLevelData getPresentLevelMapOrThrow(int key) {
                Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> map = internalGetPresentLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPresentLevelMap() {
                internalGetMutablePresentLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removePresentLevelMap(int key) {
                internalGetMutablePresentLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> getMutablePresentLevelMap() {
                return internalGetMutablePresentLevelMap().getMutableMap();
            }

            public Builder putPresentLevelMap(int key, VintagePresentLevelDataOuterClass.VintagePresentLevelData value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutablePresentLevelMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllPresentLevelMap(Map<Integer, VintagePresentLevelDataOuterClass.VintagePresentLevelData> values) {
                internalGetMutablePresentLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.VintagePresentStageDataOuterClass.VintagePresentStageDataOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static VintagePresentStageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintagePresentStageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintagePresentStageData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintagePresentStageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VintagePresentLevelDataOuterClass.getDescriptor();
    }
}
