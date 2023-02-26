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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapBonusChallengeInfoOuterClass.class */
public final class TreasureMapBonusChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#TreasureMapBonusChallengeInfo.proto\"á\u0001\n\u001dTreasureMapBonusChallengeInfo\u0012\u0010\n\bisActive\u0018\u0005 \u0001(\b\u0012D\n\u000bfragmentMap\u0018\r \u0003(\u000b2/.TreasureMapBonusChallengeInfo.FragmentMapEntry\u0012\u0012\n\nsolutionId\u0018\u000e \u0001(\r\u0012\u000e\n\u0006isDone\u0018\u0002 \u0001(\b\u0012\u0010\n\bconfigId\u0018\t \u0001(\r\u001a2\n\u0010FragmentMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\b:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TreasureMapBonusChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureMapBonusChallengeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureMapBonusChallengeInfo_descriptor, new String[]{"IsActive", "FragmentMap", "SolutionId", "IsDone", "ConfigId"});

    /* renamed from: internal_static_TreasureMapBonusChallengeInfo_FragmentMapEntry_descriptor */
    private static final Descriptors.Descriptor f864x11aeb179 = internal_static_TreasureMapBonusChallengeInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_TreasureMapBonusChallengeInfo_FragmentMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f865xc354ef7 = new GeneratedMessageV3.FieldAccessorTable(f864x11aeb179, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapBonusChallengeInfoOuterClass$TreasureMapBonusChallengeInfoOrBuilder.class */
    public interface TreasureMapBonusChallengeInfoOrBuilder extends MessageOrBuilder {
        boolean getIsActive();

        int getFragmentMapCount();

        boolean containsFragmentMap(int i);

        @Deprecated
        Map<Integer, Boolean> getFragmentMap();

        Map<Integer, Boolean> getFragmentMapMap();

        boolean getFragmentMapOrDefault(int i, boolean z);

        boolean getFragmentMapOrThrow(int i);

        int getSolutionId();

        boolean getIsDone();

        int getConfigId();
    }

    private TreasureMapBonusChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapBonusChallengeInfoOuterClass$TreasureMapBonusChallengeInfo.class */
    public static final class TreasureMapBonusChallengeInfo extends GeneratedMessageV3 implements TreasureMapBonusChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISACTIVE_FIELD_NUMBER = 5;
        private boolean isActive_;
        public static final int FRAGMENTMAP_FIELD_NUMBER = 13;
        private MapField<Integer, Boolean> fragmentMap_;
        public static final int SOLUTIONID_FIELD_NUMBER = 14;
        private int solutionId_;
        public static final int ISDONE_FIELD_NUMBER = 2;
        private boolean isDone_;
        public static final int CONFIGID_FIELD_NUMBER = 9;
        private int configId_;
        private byte memoizedIsInitialized;
        private static final TreasureMapBonusChallengeInfo DEFAULT_INSTANCE = new TreasureMapBonusChallengeInfo();
        private static final Parser<TreasureMapBonusChallengeInfo> PARSER = new AbstractParser<TreasureMapBonusChallengeInfo>() { // from class: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public TreasureMapBonusChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureMapBonusChallengeInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 13: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetFragmentMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private TreasureMapBonusChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureMapBonusChallengeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureMapBonusChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureMapBonusChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.isDone_ = input.readBool();
                                    break;
                                case 40:
                                    this.isActive_ = input.readBool();
                                    break;
                                case 72:
                                    this.configId_ = input.readUInt32();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.fragmentMap_ = MapField.newMapField(FragmentMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Boolean> fragmentMap__ = (MapEntry) input.readMessage(FragmentMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.fragmentMap_.getMutableMap().put(fragmentMap__.getKey(), fragmentMap__.getValue());
                                    break;
                                case 112:
                                    this.solutionId_ = input.readUInt32();
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
            return TreasureMapBonusChallengeInfoOuterClass.internal_static_TreasureMapBonusChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureMapBonusChallengeInfoOuterClass.internal_static_TreasureMapBonusChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapBonusChallengeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public boolean getIsActive() {
            return this.isActive_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapBonusChallengeInfoOuterClass$TreasureMapBonusChallengeInfo$FragmentMapDefaultEntryHolder.class */
        public static final class FragmentMapDefaultEntryHolder {
            static final MapEntry<Integer, Boolean> defaultEntry = MapEntry.newDefaultInstance(TreasureMapBonusChallengeInfoOuterClass.f864x11aeb179, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.BOOL, false);

            private FragmentMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Boolean> internalGetFragmentMap() {
            if (this.fragmentMap_ == null) {
                return MapField.emptyMapField(FragmentMapDefaultEntryHolder.defaultEntry);
            }
            return this.fragmentMap_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public int getFragmentMapCount() {
            return internalGetFragmentMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public boolean containsFragmentMap(int key) {
            return internalGetFragmentMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        @Deprecated
        public Map<Integer, Boolean> getFragmentMap() {
            return getFragmentMapMap();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public Map<Integer, Boolean> getFragmentMapMap() {
            return internalGetFragmentMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public boolean getFragmentMapOrDefault(int key, boolean defaultValue) {
            Map<Integer, Boolean> map = internalGetFragmentMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).booleanValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public boolean getFragmentMapOrThrow(int key) {
            Map<Integer, Boolean> map = internalGetFragmentMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).booleanValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public int getSolutionId() {
            return this.solutionId_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public boolean getIsDone() {
            return this.isDone_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
        public int getConfigId() {
            return this.configId_;
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
            if (this.isDone_) {
                output.writeBool(2, this.isDone_);
            }
            if (this.isActive_) {
                output.writeBool(5, this.isActive_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(9, this.configId_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetFragmentMap(), FragmentMapDefaultEntryHolder.defaultEntry, 13);
            if (this.solutionId_ != 0) {
                output.writeUInt32(14, this.solutionId_);
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
            if (this.isDone_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isDone_);
            }
            if (this.isActive_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isActive_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.configId_);
            }
            for (Map.Entry<Integer, Boolean> entry : internalGetFragmentMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(13, FragmentMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.solutionId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.solutionId_);
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
            if (!(obj instanceof TreasureMapBonusChallengeInfo)) {
                return equals(obj);
            }
            TreasureMapBonusChallengeInfo other = (TreasureMapBonusChallengeInfo) obj;
            return getIsActive() == other.getIsActive() && internalGetFragmentMap().equals(other.internalGetFragmentMap()) && getSolutionId() == other.getSolutionId() && getIsDone() == other.getIsDone() && getConfigId() == other.getConfigId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashBoolean(getIsActive());
            if (!internalGetFragmentMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 13)) + internalGetFragmentMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + getSolutionId())) + 2)) + Internal.hashBoolean(getIsDone()))) + 9)) + getConfigId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TreasureMapBonusChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(InputStream input) throws IOException {
            return (TreasureMapBonusChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapBonusChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapBonusChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureMapBonusChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureMapBonusChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapBonusChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (TreasureMapBonusChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapBonusChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapBonusChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureMapBonusChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapBonusChallengeInfoOuterClass$TreasureMapBonusChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureMapBonusChallengeInfoOrBuilder {
            private int bitField0_;
            private boolean isActive_;
            private MapField<Integer, Boolean> fragmentMap_;
            private int solutionId_;
            private boolean isDone_;
            private int configId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetFragmentMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 13: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableFragmentMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureMapBonusChallengeInfoOuterClass.internal_static_TreasureMapBonusChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureMapBonusChallengeInfoOuterClass.internal_static_TreasureMapBonusChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapBonusChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureMapBonusChallengeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isActive_ = false;
                internalGetMutableFragmentMap().clear();
                this.solutionId_ = 0;
                this.isDone_ = false;
                this.configId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureMapBonusChallengeInfoOuterClass.internal_static_TreasureMapBonusChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureMapBonusChallengeInfo getDefaultInstanceForType() {
                return TreasureMapBonusChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapBonusChallengeInfo build() {
                TreasureMapBonusChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapBonusChallengeInfo buildPartial() {
                TreasureMapBonusChallengeInfo result = new TreasureMapBonusChallengeInfo(this);
                int i = this.bitField0_;
                result.isActive_ = this.isActive_;
                result.fragmentMap_ = internalGetFragmentMap();
                result.fragmentMap_.makeImmutable();
                result.solutionId_ = this.solutionId_;
                result.isDone_ = this.isDone_;
                result.configId_ = this.configId_;
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
                if (other instanceof TreasureMapBonusChallengeInfo) {
                    return mergeFrom((TreasureMapBonusChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureMapBonusChallengeInfo other) {
                if (other == TreasureMapBonusChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsActive()) {
                    setIsActive(other.getIsActive());
                }
                internalGetMutableFragmentMap().mergeFrom(other.internalGetFragmentMap());
                if (other.getSolutionId() != 0) {
                    setSolutionId(other.getSolutionId());
                }
                if (other.getIsDone()) {
                    setIsDone(other.getIsDone());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
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
                TreasureMapBonusChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureMapBonusChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureMapBonusChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public boolean getIsActive() {
                return this.isActive_;
            }

            public Builder setIsActive(boolean value) {
                this.isActive_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsActive() {
                this.isActive_ = false;
                onChanged();
                return this;
            }

            private MapField<Integer, Boolean> internalGetFragmentMap() {
                if (this.fragmentMap_ == null) {
                    return MapField.emptyMapField(FragmentMapDefaultEntryHolder.defaultEntry);
                }
                return this.fragmentMap_;
            }

            private MapField<Integer, Boolean> internalGetMutableFragmentMap() {
                onChanged();
                if (this.fragmentMap_ == null) {
                    this.fragmentMap_ = MapField.newMapField(FragmentMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.fragmentMap_.isMutable()) {
                    this.fragmentMap_ = this.fragmentMap_.copy();
                }
                return this.fragmentMap_;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public int getFragmentMapCount() {
                return internalGetFragmentMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public boolean containsFragmentMap(int key) {
                return internalGetFragmentMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            @Deprecated
            public Map<Integer, Boolean> getFragmentMap() {
                return getFragmentMapMap();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public Map<Integer, Boolean> getFragmentMapMap() {
                return internalGetFragmentMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public boolean getFragmentMapOrDefault(int key, boolean defaultValue) {
                Map<Integer, Boolean> map = internalGetFragmentMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).booleanValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public boolean getFragmentMapOrThrow(int key) {
                Map<Integer, Boolean> map = internalGetFragmentMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).booleanValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearFragmentMap() {
                internalGetMutableFragmentMap().getMutableMap().clear();
                return this;
            }

            public Builder removeFragmentMap(int key) {
                internalGetMutableFragmentMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Boolean> getMutableFragmentMap() {
                return internalGetMutableFragmentMap().getMutableMap();
            }

            public Builder putFragmentMap(int key, boolean value) {
                internalGetMutableFragmentMap().getMutableMap().put(Integer.valueOf(key), Boolean.valueOf(value));
                return this;
            }

            public Builder putAllFragmentMap(Map<Integer, Boolean> values) {
                internalGetMutableFragmentMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public int getSolutionId() {
                return this.solutionId_;
            }

            public Builder setSolutionId(int value) {
                this.solutionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSolutionId() {
                this.solutionId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public boolean getIsDone() {
                return this.isDone_;
            }

            public Builder setIsDone(boolean value) {
                this.isDone_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDone() {
                this.isDone_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
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

        public static TreasureMapBonusChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureMapBonusChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureMapBonusChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureMapBonusChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
