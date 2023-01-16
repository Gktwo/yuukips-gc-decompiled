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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryHomeSeekFurnitureInfoOuterClass.class */
public final class SceneGalleryHomeSeekFurnitureInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'SceneGalleryHomeSeekFurnitureInfo.proto\"\u0002\n!SceneGalleryHomeSeekFurnitureInfo\u0012\u001b\n\u0013Unk3300_DAEEBIEAOMN\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013Unk3300_ENKOGPIEHFD\u0018\u000e \u0001(\r\u0012P\n\u0010player_score_map\u0018\n \u0003(\u000b26.SceneGalleryHomeSeekFurnitureInfo.PlayerScoreMapEntry\u0012\u001b\n\u0013Unk3300_LGEAPLJCJFH\u0018\f \u0001(\r\u001a5\n\u0013PlayerScoreMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SceneGalleryHomeSeekFurnitureInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_SceneGalleryHomeSeekFurnitureInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f866xbfa46bf8 = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneGalleryHomeSeekFurnitureInfo_descriptor, new String[]{"Unk3300DAEEBIEAOMN", "Unk3300ENKOGPIEHFD", "PlayerScoreMap", "Unk3300LGEAPLJCJFH"});

    /* renamed from: internal_static_SceneGalleryHomeSeekFurnitureInfo_PlayerScoreMapEntry_descriptor */
    private static final Descriptors.Descriptor f867xc96a9392 = internal_static_SceneGalleryHomeSeekFurnitureInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SceneGalleryHomeSeekFurnitureInfo_PlayerScoreMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f868xbd9e0810 = new GeneratedMessageV3.FieldAccessorTable(f867xc96a9392, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryHomeSeekFurnitureInfoOuterClass$SceneGalleryHomeSeekFurnitureInfoOrBuilder.class */
    public interface SceneGalleryHomeSeekFurnitureInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300DAEEBIEAOMN();

        int getUnk3300ENKOGPIEHFD();

        int getPlayerScoreMapCount();

        boolean containsPlayerScoreMap(int i);

        @Deprecated
        Map<Integer, Integer> getPlayerScoreMap();

        Map<Integer, Integer> getPlayerScoreMapMap();

        int getPlayerScoreMapOrDefault(int i, int i2);

        int getPlayerScoreMapOrThrow(int i);

        int getUnk3300LGEAPLJCJFH();
    }

    private SceneGalleryHomeSeekFurnitureInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryHomeSeekFurnitureInfoOuterClass$SceneGalleryHomeSeekFurnitureInfo.class */
    public static final class SceneGalleryHomeSeekFurnitureInfo extends GeneratedMessageV3 implements SceneGalleryHomeSeekFurnitureInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_DAEEBIEAOMN_FIELD_NUMBER = 3;
        private int unk3300DAEEBIEAOMN_;
        public static final int UNK3300_ENKOGPIEHFD_FIELD_NUMBER = 14;
        private int unk3300ENKOGPIEHFD_;
        public static final int PLAYER_SCORE_MAP_FIELD_NUMBER = 10;
        private MapField<Integer, Integer> playerScoreMap_;
        public static final int UNK3300_LGEAPLJCJFH_FIELD_NUMBER = 12;
        private int unk3300LGEAPLJCJFH_;
        private byte memoizedIsInitialized;
        private static final SceneGalleryHomeSeekFurnitureInfo DEFAULT_INSTANCE = new SceneGalleryHomeSeekFurnitureInfo();
        private static final Parser<SceneGalleryHomeSeekFurnitureInfo> PARSER = new AbstractParser<SceneGalleryHomeSeekFurnitureInfo>() { // from class: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.1
            @Override // com.google.protobuf.Parser
            public SceneGalleryHomeSeekFurnitureInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneGalleryHomeSeekFurnitureInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 10: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPlayerScoreMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SceneGalleryHomeSeekFurnitureInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneGalleryHomeSeekFurnitureInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneGalleryHomeSeekFurnitureInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneGalleryHomeSeekFurnitureInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.unk3300DAEEBIEAOMN_ = input.readUInt32();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.playerScoreMap_ = MapField.newMapField(PlayerScoreMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> playerScoreMap__ = (MapEntry) input.readMessage(PlayerScoreMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.playerScoreMap_.getMutableMap().put(playerScoreMap__.getKey(), playerScoreMap__.getValue());
                                break;
                            case 96:
                                this.unk3300LGEAPLJCJFH_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300ENKOGPIEHFD_ = input.readUInt32();
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
            return SceneGalleryHomeSeekFurnitureInfoOuterClass.internal_static_SceneGalleryHomeSeekFurnitureInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneGalleryHomeSeekFurnitureInfoOuterClass.f866xbfa46bf8.ensureFieldAccessorsInitialized(SceneGalleryHomeSeekFurnitureInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public int getUnk3300DAEEBIEAOMN() {
            return this.unk3300DAEEBIEAOMN_;
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public int getUnk3300ENKOGPIEHFD() {
            return this.unk3300ENKOGPIEHFD_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryHomeSeekFurnitureInfoOuterClass$SceneGalleryHomeSeekFurnitureInfo$PlayerScoreMapDefaultEntryHolder.class */
        public static final class PlayerScoreMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneGalleryHomeSeekFurnitureInfoOuterClass.f867xc96a9392, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private PlayerScoreMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetPlayerScoreMap() {
            if (this.playerScoreMap_ == null) {
                return MapField.emptyMapField(PlayerScoreMapDefaultEntryHolder.defaultEntry);
            }
            return this.playerScoreMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public int getPlayerScoreMapCount() {
            return internalGetPlayerScoreMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public boolean containsPlayerScoreMap(int key) {
            return internalGetPlayerScoreMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getPlayerScoreMap() {
            return getPlayerScoreMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public Map<Integer, Integer> getPlayerScoreMapMap() {
            return internalGetPlayerScoreMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public int getPlayerScoreMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetPlayerScoreMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public int getPlayerScoreMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetPlayerScoreMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
        public int getUnk3300LGEAPLJCJFH() {
            return this.unk3300LGEAPLJCJFH_;
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
            if (this.unk3300DAEEBIEAOMN_ != 0) {
                output.writeUInt32(3, this.unk3300DAEEBIEAOMN_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPlayerScoreMap(), PlayerScoreMapDefaultEntryHolder.defaultEntry, 10);
            if (this.unk3300LGEAPLJCJFH_ != 0) {
                output.writeUInt32(12, this.unk3300LGEAPLJCJFH_);
            }
            if (this.unk3300ENKOGPIEHFD_ != 0) {
                output.writeUInt32(14, this.unk3300ENKOGPIEHFD_);
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
            if (this.unk3300DAEEBIEAOMN_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.unk3300DAEEBIEAOMN_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetPlayerScoreMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(10, PlayerScoreMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.unk3300LGEAPLJCJFH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300LGEAPLJCJFH_);
            }
            if (this.unk3300ENKOGPIEHFD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300ENKOGPIEHFD_);
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
            if (!(obj instanceof SceneGalleryHomeSeekFurnitureInfo)) {
                return equals(obj);
            }
            SceneGalleryHomeSeekFurnitureInfo other = (SceneGalleryHomeSeekFurnitureInfo) obj;
            return getUnk3300DAEEBIEAOMN() == other.getUnk3300DAEEBIEAOMN() && getUnk3300ENKOGPIEHFD() == other.getUnk3300ENKOGPIEHFD() && internalGetPlayerScoreMap().equals(other.internalGetPlayerScoreMap()) && getUnk3300LGEAPLJCJFH() == other.getUnk3300LGEAPLJCJFH() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getUnk3300DAEEBIEAOMN())) + 14)) + getUnk3300ENKOGPIEHFD();
            if (!internalGetPlayerScoreMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 10)) + internalGetPlayerScoreMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getUnk3300LGEAPLJCJFH())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(InputStream input) throws IOException {
            return (SceneGalleryHomeSeekFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGalleryHomeSeekFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneGalleryHomeSeekFurnitureInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGalleryHomeSeekFurnitureInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneGalleryHomeSeekFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneGalleryHomeSeekFurnitureInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGalleryHomeSeekFurnitureInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneGalleryHomeSeekFurnitureInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryHomeSeekFurnitureInfoOuterClass$SceneGalleryHomeSeekFurnitureInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneGalleryHomeSeekFurnitureInfoOrBuilder {
            private int bitField0_;
            private int unk3300DAEEBIEAOMN_;
            private int unk3300ENKOGPIEHFD_;
            private MapField<Integer, Integer> playerScoreMap_;
            private int unk3300LGEAPLJCJFH_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPlayerScoreMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 10: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePlayerScoreMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneGalleryHomeSeekFurnitureInfoOuterClass.internal_static_SceneGalleryHomeSeekFurnitureInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneGalleryHomeSeekFurnitureInfoOuterClass.f866xbfa46bf8.ensureFieldAccessorsInitialized(SceneGalleryHomeSeekFurnitureInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneGalleryHomeSeekFurnitureInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300DAEEBIEAOMN_ = 0;
                this.unk3300ENKOGPIEHFD_ = 0;
                internalGetMutablePlayerScoreMap().clear();
                this.unk3300LGEAPLJCJFH_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneGalleryHomeSeekFurnitureInfoOuterClass.internal_static_SceneGalleryHomeSeekFurnitureInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneGalleryHomeSeekFurnitureInfo getDefaultInstanceForType() {
                return SceneGalleryHomeSeekFurnitureInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneGalleryHomeSeekFurnitureInfo build() {
                SceneGalleryHomeSeekFurnitureInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneGalleryHomeSeekFurnitureInfo buildPartial() {
                SceneGalleryHomeSeekFurnitureInfo result = new SceneGalleryHomeSeekFurnitureInfo(this);
                int i = this.bitField0_;
                result.unk3300DAEEBIEAOMN_ = this.unk3300DAEEBIEAOMN_;
                result.unk3300ENKOGPIEHFD_ = this.unk3300ENKOGPIEHFD_;
                result.playerScoreMap_ = internalGetPlayerScoreMap();
                result.playerScoreMap_.makeImmutable();
                result.unk3300LGEAPLJCJFH_ = this.unk3300LGEAPLJCJFH_;
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
                if (other instanceof SceneGalleryHomeSeekFurnitureInfo) {
                    return mergeFrom((SceneGalleryHomeSeekFurnitureInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneGalleryHomeSeekFurnitureInfo other) {
                if (other == SceneGalleryHomeSeekFurnitureInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300DAEEBIEAOMN() != 0) {
                    setUnk3300DAEEBIEAOMN(other.getUnk3300DAEEBIEAOMN());
                }
                if (other.getUnk3300ENKOGPIEHFD() != 0) {
                    setUnk3300ENKOGPIEHFD(other.getUnk3300ENKOGPIEHFD());
                }
                internalGetMutablePlayerScoreMap().mergeFrom(other.internalGetPlayerScoreMap());
                if (other.getUnk3300LGEAPLJCJFH() != 0) {
                    setUnk3300LGEAPLJCJFH(other.getUnk3300LGEAPLJCJFH());
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
                SceneGalleryHomeSeekFurnitureInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneGalleryHomeSeekFurnitureInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneGalleryHomeSeekFurnitureInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public int getUnk3300DAEEBIEAOMN() {
                return this.unk3300DAEEBIEAOMN_;
            }

            public Builder setUnk3300DAEEBIEAOMN(int value) {
                this.unk3300DAEEBIEAOMN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DAEEBIEAOMN() {
                this.unk3300DAEEBIEAOMN_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public int getUnk3300ENKOGPIEHFD() {
                return this.unk3300ENKOGPIEHFD_;
            }

            public Builder setUnk3300ENKOGPIEHFD(int value) {
                this.unk3300ENKOGPIEHFD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ENKOGPIEHFD() {
                this.unk3300ENKOGPIEHFD_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetPlayerScoreMap() {
                if (this.playerScoreMap_ == null) {
                    return MapField.emptyMapField(PlayerScoreMapDefaultEntryHolder.defaultEntry);
                }
                return this.playerScoreMap_;
            }

            private MapField<Integer, Integer> internalGetMutablePlayerScoreMap() {
                onChanged();
                if (this.playerScoreMap_ == null) {
                    this.playerScoreMap_ = MapField.newMapField(PlayerScoreMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.playerScoreMap_.isMutable()) {
                    this.playerScoreMap_ = this.playerScoreMap_.copy();
                }
                return this.playerScoreMap_;
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public int getPlayerScoreMapCount() {
                return internalGetPlayerScoreMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public boolean containsPlayerScoreMap(int key) {
                return internalGetPlayerScoreMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getPlayerScoreMap() {
                return getPlayerScoreMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public Map<Integer, Integer> getPlayerScoreMapMap() {
                return internalGetPlayerScoreMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public int getPlayerScoreMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetPlayerScoreMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public int getPlayerScoreMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetPlayerScoreMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPlayerScoreMap() {
                internalGetMutablePlayerScoreMap().getMutableMap().clear();
                return this;
            }

            public Builder removePlayerScoreMap(int key) {
                internalGetMutablePlayerScoreMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutablePlayerScoreMap() {
                return internalGetMutablePlayerScoreMap().getMutableMap();
            }

            public Builder putPlayerScoreMap(int key, int value) {
                internalGetMutablePlayerScoreMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllPlayerScoreMap(Map<Integer, Integer> values) {
                internalGetMutablePlayerScoreMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryHomeSeekFurnitureInfoOuterClass.SceneGalleryHomeSeekFurnitureInfoOrBuilder
            public int getUnk3300LGEAPLJCJFH() {
                return this.unk3300LGEAPLJCJFH_;
            }

            public Builder setUnk3300LGEAPLJCJFH(int value) {
                this.unk3300LGEAPLJCJFH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LGEAPLJCJFH() {
                this.unk3300LGEAPLJCJFH_ = 0;
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

        public static SceneGalleryHomeSeekFurnitureInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneGalleryHomeSeekFurnitureInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneGalleryHomeSeekFurnitureInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneGalleryHomeSeekFurnitureInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
