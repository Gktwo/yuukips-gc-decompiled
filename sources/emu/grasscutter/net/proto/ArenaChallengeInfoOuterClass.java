package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.ArenaChallengeMonsterLevelOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeInfoOuterClass.class */
public final class ArenaChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ArenaChallengeInfo.proto\u001a ArenaChallengeMonsterLevel.proto\"ð\u0001\n\u0012ArenaChallengeInfo\u0012C\n\u0010levelOpenTimeMap\u0018\u0002 \u0003(\u000b2).ArenaChallengeInfo.LevelOpenTimeMapEntry\u0012\u0012\n\nworldLevel\u0018\u0006 \u0001(\r\u0012.\n\tlevelList\u0018\u0007 \u0003(\u000b2\u001b.ArenaChallengeMonsterLevel\u0012\u0018\n\u0010isFinishAnyLevel\u0018\u0005 \u0001(\b\u001a7\n\u0015LevelOpenTimeMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ArenaChallengeMonsterLevelOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ArenaChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ArenaChallengeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ArenaChallengeInfo_descriptor, new String[]{"LevelOpenTimeMap", "WorldLevel", "LevelList", "IsFinishAnyLevel"});

    /* renamed from: internal_static_ArenaChallengeInfo_LevelOpenTimeMapEntry_descriptor */
    private static final Descriptors.Descriptor f623x8f0dc023 = internal_static_ArenaChallengeInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ArenaChallengeInfo_LevelOpenTimeMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f624xee1813a1 = new GeneratedMessageV3.FieldAccessorTable(f623x8f0dc023, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeInfoOuterClass$ArenaChallengeInfoOrBuilder.class */
    public interface ArenaChallengeInfoOrBuilder extends MessageOrBuilder {
        int getLevelOpenTimeMapCount();

        boolean containsLevelOpenTimeMap(int i);

        @Deprecated
        Map<Integer, Integer> getLevelOpenTimeMap();

        Map<Integer, Integer> getLevelOpenTimeMapMap();

        int getLevelOpenTimeMapOrDefault(int i, int i2);

        int getLevelOpenTimeMapOrThrow(int i);

        int getWorldLevel();

        List<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel> getLevelListList();

        ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel getLevelList(int i);

        int getLevelListCount();

        List<? extends ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder> getLevelListOrBuilderList();

        ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder getLevelListOrBuilder(int i);

        boolean getIsFinishAnyLevel();
    }

    private ArenaChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeInfoOuterClass$ArenaChallengeInfo.class */
    public static final class ArenaChallengeInfo extends GeneratedMessageV3 implements ArenaChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELOPENTIMEMAP_FIELD_NUMBER = 2;
        private MapField<Integer, Integer> levelOpenTimeMap_;
        public static final int WORLDLEVEL_FIELD_NUMBER = 6;
        private int worldLevel_;
        public static final int LEVELLIST_FIELD_NUMBER = 7;
        private List<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel> levelList_;
        public static final int ISFINISHANYLEVEL_FIELD_NUMBER = 5;
        private boolean isFinishAnyLevel_;
        private byte memoizedIsInitialized;
        private static final ArenaChallengeInfo DEFAULT_INSTANCE = new ArenaChallengeInfo();
        private static final Parser<ArenaChallengeInfo> PARSER = new AbstractParser<ArenaChallengeInfo>() { // from class: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public ArenaChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaChallengeInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                com.google.protobuf.MapField r0 = r0.internalGetLevelOpenTimeMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ArenaChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ArenaChallengeInfo() {
            this.memoizedIsInitialized = -1;
            this.levelList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ArenaChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x00f5 */
        private ArenaChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                        this.levelOpenTimeMap_ = MapField.newMapField(LevelOpenTimeMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    MapEntry<Integer, Integer> levelOpenTimeMap__ = (MapEntry) input.readMessage(LevelOpenTimeMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.levelOpenTimeMap_.getMutableMap().put(levelOpenTimeMap__.getKey(), levelOpenTimeMap__.getValue());
                                    break;
                                case 40:
                                    this.isFinishAnyLevel_ = input.readBool();
                                    break;
                                case 48:
                                    this.worldLevel_ = input.readUInt32();
                                    break;
                                case 58:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.levelList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.levelList_.add((ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel) input.readMessage(ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.parser(), extensionRegistry));
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.levelList_ = Collections.unmodifiableList(this.levelList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ArenaChallengeInfoOuterClass.internal_static_ArenaChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaChallengeInfoOuterClass.internal_static_ArenaChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaChallengeInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeInfoOuterClass$ArenaChallengeInfo$LevelOpenTimeMapDefaultEntryHolder.class */
        public static final class LevelOpenTimeMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ArenaChallengeInfoOuterClass.f623x8f0dc023, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private LevelOpenTimeMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetLevelOpenTimeMap() {
            if (this.levelOpenTimeMap_ == null) {
                return MapField.emptyMapField(LevelOpenTimeMapDefaultEntryHolder.defaultEntry);
            }
            return this.levelOpenTimeMap_;
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public int getLevelOpenTimeMapCount() {
            return internalGetLevelOpenTimeMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public boolean containsLevelOpenTimeMap(int key) {
            return internalGetLevelOpenTimeMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getLevelOpenTimeMap() {
            return getLevelOpenTimeMapMap();
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public Map<Integer, Integer> getLevelOpenTimeMapMap() {
            return internalGetLevelOpenTimeMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public int getLevelOpenTimeMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetLevelOpenTimeMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public int getLevelOpenTimeMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetLevelOpenTimeMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public int getWorldLevel() {
            return this.worldLevel_;
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public List<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel> getLevelListList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public List<? extends ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder> getLevelListOrBuilderList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public int getLevelListCount() {
            return this.levelList_.size();
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel getLevelList(int index) {
            return this.levelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder getLevelListOrBuilder(int index) {
            return this.levelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
        public boolean getIsFinishAnyLevel() {
            return this.isFinishAnyLevel_;
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetLevelOpenTimeMap(), LevelOpenTimeMapDefaultEntryHolder.defaultEntry, 2);
            if (this.isFinishAnyLevel_) {
                output.writeBool(5, this.isFinishAnyLevel_);
            }
            if (this.worldLevel_ != 0) {
                output.writeUInt32(6, this.worldLevel_);
            }
            for (int i = 0; i < this.levelList_.size(); i++) {
                output.writeMessage(7, this.levelList_.get(i));
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
            for (Map.Entry<Integer, Integer> entry : internalGetLevelOpenTimeMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(2, LevelOpenTimeMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.isFinishAnyLevel_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isFinishAnyLevel_);
            }
            if (this.worldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.worldLevel_);
            }
            for (int i = 0; i < this.levelList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.levelList_.get(i));
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
            if (!(obj instanceof ArenaChallengeInfo)) {
                return equals(obj);
            }
            ArenaChallengeInfo other = (ArenaChallengeInfo) obj;
            return internalGetLevelOpenTimeMap().equals(other.internalGetLevelOpenTimeMap()) && getWorldLevel() == other.getWorldLevel() && getLevelListList().equals(other.getLevelListList()) && getIsFinishAnyLevel() == other.getIsFinishAnyLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetLevelOpenTimeMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 2)) + internalGetLevelOpenTimeMap().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getWorldLevel();
            if (getLevelListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getLevelListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 5)) + Internal.hashBoolean(getIsFinishAnyLevel()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ArenaChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ArenaChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ArenaChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ArenaChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaChallengeInfo parseFrom(InputStream input) throws IOException {
            return (ArenaChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ArenaChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ArenaChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ArenaChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ArenaChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (ArenaChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ArenaChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ArenaChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeInfoOuterClass$ArenaChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ArenaChallengeInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> levelOpenTimeMap_;
            private int worldLevel_;
            private List<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel> levelList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder> levelListBuilder_;
            private boolean isFinishAnyLevel_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetLevelOpenTimeMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                    com.google.protobuf.MapField r0 = r0.internalGetMutableLevelOpenTimeMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaChallengeInfoOuterClass.internal_static_ArenaChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaChallengeInfoOuterClass.internal_static_ArenaChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ArenaChallengeInfo.alwaysUseFieldBuilders) {
                    getLevelListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableLevelOpenTimeMap().clear();
                this.worldLevel_ = 0;
                if (this.levelListBuilder_ == null) {
                    this.levelList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.levelListBuilder_.clear();
                }
                this.isFinishAnyLevel_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaChallengeInfoOuterClass.internal_static_ArenaChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ArenaChallengeInfo getDefaultInstanceForType() {
                return ArenaChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ArenaChallengeInfo build() {
                ArenaChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ArenaChallengeInfo buildPartial() {
                ArenaChallengeInfo result = new ArenaChallengeInfo(this);
                int i = this.bitField0_;
                result.levelOpenTimeMap_ = internalGetLevelOpenTimeMap();
                result.levelOpenTimeMap_.makeImmutable();
                result.worldLevel_ = this.worldLevel_;
                if (this.levelListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.levelList_ = Collections.unmodifiableList(this.levelList_);
                        this.bitField0_ &= -3;
                    }
                    result.levelList_ = this.levelList_;
                } else {
                    result.levelList_ = this.levelListBuilder_.build();
                }
                result.isFinishAnyLevel_ = this.isFinishAnyLevel_;
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
                if (other instanceof ArenaChallengeInfo) {
                    return mergeFrom((ArenaChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaChallengeInfo other) {
                if (other == ArenaChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableLevelOpenTimeMap().mergeFrom(other.internalGetLevelOpenTimeMap());
                if (other.getWorldLevel() != 0) {
                    setWorldLevel(other.getWorldLevel());
                }
                if (this.levelListBuilder_ == null) {
                    if (!other.levelList_.isEmpty()) {
                        if (this.levelList_.isEmpty()) {
                            this.levelList_ = other.levelList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureLevelListIsMutable();
                            this.levelList_.addAll(other.levelList_);
                        }
                        onChanged();
                    }
                } else if (!other.levelList_.isEmpty()) {
                    if (this.levelListBuilder_.isEmpty()) {
                        this.levelListBuilder_.dispose();
                        this.levelListBuilder_ = null;
                        this.levelList_ = other.levelList_;
                        this.bitField0_ &= -3;
                        this.levelListBuilder_ = ArenaChallengeInfo.alwaysUseFieldBuilders ? getLevelListFieldBuilder() : null;
                    } else {
                        this.levelListBuilder_.addAllMessages(other.levelList_);
                    }
                }
                if (other.getIsFinishAnyLevel()) {
                    setIsFinishAnyLevel(other.getIsFinishAnyLevel());
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
                ArenaChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ArenaChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ArenaChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetLevelOpenTimeMap() {
                if (this.levelOpenTimeMap_ == null) {
                    return MapField.emptyMapField(LevelOpenTimeMapDefaultEntryHolder.defaultEntry);
                }
                return this.levelOpenTimeMap_;
            }

            private MapField<Integer, Integer> internalGetMutableLevelOpenTimeMap() {
                onChanged();
                if (this.levelOpenTimeMap_ == null) {
                    this.levelOpenTimeMap_ = MapField.newMapField(LevelOpenTimeMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.levelOpenTimeMap_.isMutable()) {
                    this.levelOpenTimeMap_ = this.levelOpenTimeMap_.copy();
                }
                return this.levelOpenTimeMap_;
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public int getLevelOpenTimeMapCount() {
                return internalGetLevelOpenTimeMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public boolean containsLevelOpenTimeMap(int key) {
                return internalGetLevelOpenTimeMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getLevelOpenTimeMap() {
                return getLevelOpenTimeMapMap();
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public Map<Integer, Integer> getLevelOpenTimeMapMap() {
                return internalGetLevelOpenTimeMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public int getLevelOpenTimeMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetLevelOpenTimeMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public int getLevelOpenTimeMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetLevelOpenTimeMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearLevelOpenTimeMap() {
                internalGetMutableLevelOpenTimeMap().getMutableMap().clear();
                return this;
            }

            public Builder removeLevelOpenTimeMap(int key) {
                internalGetMutableLevelOpenTimeMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableLevelOpenTimeMap() {
                return internalGetMutableLevelOpenTimeMap().getMutableMap();
            }

            public Builder putLevelOpenTimeMap(int key, int value) {
                internalGetMutableLevelOpenTimeMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllLevelOpenTimeMap(Map<Integer, Integer> values) {
                internalGetMutableLevelOpenTimeMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public int getWorldLevel() {
                return this.worldLevel_;
            }

            public Builder setWorldLevel(int value) {
                this.worldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWorldLevel() {
                this.worldLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureLevelListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.levelList_ = new ArrayList(this.levelList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public List<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel> getLevelListList() {
                if (this.levelListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelList_);
                }
                return this.levelListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public int getLevelListCount() {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.size();
                }
                return this.levelListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel getLevelList(int index) {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.get(index);
                }
                return this.levelListBuilder_.getMessage(index);
            }

            public Builder setLevelList(int index, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel value) {
                if (this.levelListBuilder_ != null) {
                    this.levelListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelListIsMutable();
                    this.levelList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLevelList(int index, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelList(ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel value) {
                if (this.levelListBuilder_ != null) {
                    this.levelListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelListIsMutable();
                    this.levelList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelList(int index, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel value) {
                if (this.levelListBuilder_ != null) {
                    this.levelListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelListIsMutable();
                    this.levelList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelList(ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelList(int index, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelList(Iterable<? extends ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel> values) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelList_);
                    onChanged();
                } else {
                    this.levelListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLevelList() {
                if (this.levelListBuilder_ == null) {
                    this.levelList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.levelListBuilder_.clear();
                }
                return this;
            }

            public Builder removeLevelList(int index) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.remove(index);
                    onChanged();
                } else {
                    this.levelListBuilder_.remove(index);
                }
                return this;
            }

            public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder getLevelListBuilder(int index) {
                return getLevelListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder getLevelListOrBuilder(int index) {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.get(index);
                }
                return this.levelListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public List<? extends ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder> getLevelListOrBuilderList() {
                if (this.levelListBuilder_ != null) {
                    return this.levelListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelList_);
            }

            public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder addLevelListBuilder() {
                return getLevelListFieldBuilder().addBuilder(ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.getDefaultInstance());
            }

            public ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder addLevelListBuilder(int index) {
                return getLevelListFieldBuilder().addBuilder(index, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.getDefaultInstance());
            }

            public List<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder> getLevelListBuilderList() {
                return getLevelListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.Builder, ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder> getLevelListFieldBuilder() {
                if (this.levelListBuilder_ == null) {
                    this.levelListBuilder_ = new RepeatedFieldBuilderV3<>(this.levelList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.levelList_ = null;
                }
                return this.levelListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder
            public boolean getIsFinishAnyLevel() {
                return this.isFinishAnyLevel_;
            }

            public Builder setIsFinishAnyLevel(boolean value) {
                this.isFinishAnyLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinishAnyLevel() {
                this.isFinishAnyLevel_ = false;
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

        public static ArenaChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ArenaChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ArenaChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ArenaChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ArenaChallengeMonsterLevelOuterClass.getDescriptor();
    }
}
