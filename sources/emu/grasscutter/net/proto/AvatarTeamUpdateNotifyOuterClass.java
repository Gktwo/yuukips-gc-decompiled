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
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.AvatarTeamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamUpdateNotifyOuterClass.class */
public final class AvatarTeamUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cAvatarTeamUpdateNotify.proto\u001a\u0010AvatarTeam.proto\"¿\u0001\n\u0016AvatarTeamUpdateNotify\u0012C\n\u000favatar_team_map\u0018\u000f \u0003(\u000b2*.AvatarTeamUpdateNotify.AvatarTeamMapEntry\u0012\u001d\n\u0015temp_avatar_guid_list\u0018\n \u0003(\u0004\u001aA\n\u0012AvatarTeamMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u001a\n\u0005value\u0018\u0002 \u0001(\u000b2\u000b.AvatarTeam:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarTeamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarTeamUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarTeamUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarTeamUpdateNotify_descriptor, new String[]{"AvatarTeamMap", "TempAvatarGuidList"});

    /* renamed from: internal_static_AvatarTeamUpdateNotify_AvatarTeamMapEntry_descriptor */
    private static final Descriptors.Descriptor f653xe3c6ac3a = internal_static_AvatarTeamUpdateNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarTeamUpdateNotify_AvatarTeamMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f654x734af8b8 = new GeneratedMessageV3.FieldAccessorTable(f653xe3c6ac3a, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamUpdateNotifyOuterClass$AvatarTeamUpdateNotifyOrBuilder.class */
    public interface AvatarTeamUpdateNotifyOrBuilder extends MessageOrBuilder {
        int getAvatarTeamMapCount();

        boolean containsAvatarTeamMap(int i);

        @Deprecated
        Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMap();

        Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMapMap();

        AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrDefault(int i, AvatarTeamOuterClass.AvatarTeam avatarTeam);

        AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrThrow(int i);

        List<Long> getTempAvatarGuidListList();

        int getTempAvatarGuidListCount();

        long getTempAvatarGuidList(int i);
    }

    private AvatarTeamUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamUpdateNotifyOuterClass$AvatarTeamUpdateNotify.class */
    public static final class AvatarTeamUpdateNotify extends GeneratedMessageV3 implements AvatarTeamUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_TEAM_MAP_FIELD_NUMBER = 15;
        private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> avatarTeamMap_;
        public static final int TEMP_AVATAR_GUID_LIST_FIELD_NUMBER = 10;
        private Internal.LongList tempAvatarGuidList_;
        private int tempAvatarGuidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final AvatarTeamUpdateNotify DEFAULT_INSTANCE = new AvatarTeamUpdateNotify();
        private static final Parser<AvatarTeamUpdateNotify> PARSER = new AbstractParser<AvatarTeamUpdateNotify>() { // from class: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarTeamUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarTeamUpdateNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 15: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetAvatarTeamMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarTeamUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.tempAvatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarTeamUpdateNotify() {
            this.tempAvatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.tempAvatarGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarTeamUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x0111 */
        private AvatarTeamUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.tempAvatarGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.tempAvatarGuidList_.addLong(input.readUInt64());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.tempAvatarGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.tempAvatarGuidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarTeamMap_ = MapField.newMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, AvatarTeamOuterClass.AvatarTeam> avatarTeamMap__ = (MapEntry) input.readMessage(AvatarTeamMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.avatarTeamMap_.getMutableMap().put(avatarTeamMap__.getKey(), avatarTeamMap__.getValue());
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.tempAvatarGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarTeamUpdateNotifyOuterClass.internal_static_AvatarTeamUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarTeamUpdateNotifyOuterClass.internal_static_AvatarTeamUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarTeamUpdateNotify.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamUpdateNotifyOuterClass$AvatarTeamUpdateNotify$AvatarTeamMapDefaultEntryHolder.class */
        public static final class AvatarTeamMapDefaultEntryHolder {
            static final MapEntry<Integer, AvatarTeamOuterClass.AvatarTeam> defaultEntry = MapEntry.newDefaultInstance(AvatarTeamUpdateNotifyOuterClass.f653xe3c6ac3a, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, AvatarTeamOuterClass.AvatarTeam.getDefaultInstance());

            private AvatarTeamMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> internalGetAvatarTeamMap() {
            if (this.avatarTeamMap_ == null) {
                return MapField.emptyMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
            }
            return this.avatarTeamMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public int getAvatarTeamMapCount() {
            return internalGetAvatarTeamMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public boolean containsAvatarTeamMap(int key) {
            return internalGetAvatarTeamMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        @Deprecated
        public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMap() {
            return getAvatarTeamMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMapMap() {
            return internalGetAvatarTeamMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrDefault(int key, AvatarTeamOuterClass.AvatarTeam defaultValue) {
            Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrThrow(int key) {
            Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public List<Long> getTempAvatarGuidListList() {
            return this.tempAvatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public int getTempAvatarGuidListCount() {
            return this.tempAvatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
        public long getTempAvatarGuidList(int index) {
            return this.tempAvatarGuidList_.getLong(index);
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
            getSerializedSize();
            if (getTempAvatarGuidListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.tempAvatarGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.tempAvatarGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.tempAvatarGuidList_.getLong(i));
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetAvatarTeamMap(), AvatarTeamMapDefaultEntryHolder.defaultEntry, 15);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.tempAvatarGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.tempAvatarGuidList_.getLong(i));
            }
            int size2 = 0 + dataSize;
            if (!getTempAvatarGuidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.tempAvatarGuidListMemoizedSerializedSize = dataSize;
            for (Map.Entry<Integer, AvatarTeamOuterClass.AvatarTeam> entry : internalGetAvatarTeamMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(15, AvatarTeamMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
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
            if (!(obj instanceof AvatarTeamUpdateNotify)) {
                return equals(obj);
            }
            AvatarTeamUpdateNotify other = (AvatarTeamUpdateNotify) obj;
            return internalGetAvatarTeamMap().equals(other.internalGetAvatarTeamMap()) && getTempAvatarGuidListList().equals(other.getTempAvatarGuidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetAvatarTeamMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 15)) + internalGetAvatarTeamMap().hashCode();
            }
            if (getTempAvatarGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getTempAvatarGuidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarTeamUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeamUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeamUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeamUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeamUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeamUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeamUpdateNotify parseFrom(InputStream input) throws IOException {
            return (AvatarTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarTeamUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarTeamUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarTeamUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarTeamUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeamUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarTeamUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarTeamUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeamUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarTeamUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamUpdateNotifyOuterClass$AvatarTeamUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarTeamUpdateNotifyOrBuilder {
            private int bitField0_;
            private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> avatarTeamMap_;
            private Internal.LongList tempAvatarGuidList_ = AvatarTeamUpdateNotify.emptyLongList();

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 15: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetAvatarTeamMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 15: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAvatarTeamMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarTeamUpdateNotifyOuterClass.internal_static_AvatarTeamUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarTeamUpdateNotifyOuterClass.internal_static_AvatarTeamUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarTeamUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarTeamUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableAvatarTeamMap().clear();
                this.tempAvatarGuidList_ = AvatarTeamUpdateNotify.emptyLongList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarTeamUpdateNotifyOuterClass.internal_static_AvatarTeamUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarTeamUpdateNotify getDefaultInstanceForType() {
                return AvatarTeamUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarTeamUpdateNotify build() {
                AvatarTeamUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarTeamUpdateNotify buildPartial() {
                AvatarTeamUpdateNotify result = new AvatarTeamUpdateNotify(this);
                int i = this.bitField0_;
                result.avatarTeamMap_ = internalGetAvatarTeamMap();
                result.avatarTeamMap_.makeImmutable();
                if ((this.bitField0_ & 2) != 0) {
                    this.tempAvatarGuidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.tempAvatarGuidList_ = this.tempAvatarGuidList_;
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
                if (other instanceof AvatarTeamUpdateNotify) {
                    return mergeFrom((AvatarTeamUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarTeamUpdateNotify other) {
                if (other == AvatarTeamUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableAvatarTeamMap().mergeFrom(other.internalGetAvatarTeamMap());
                if (!other.tempAvatarGuidList_.isEmpty()) {
                    if (this.tempAvatarGuidList_.isEmpty()) {
                        this.tempAvatarGuidList_ = other.tempAvatarGuidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTempAvatarGuidListIsMutable();
                        this.tempAvatarGuidList_.addAll(other.tempAvatarGuidList_);
                    }
                    onChanged();
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
                AvatarTeamUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarTeamUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarTeamUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> internalGetAvatarTeamMap() {
                if (this.avatarTeamMap_ == null) {
                    return MapField.emptyMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
                }
                return this.avatarTeamMap_;
            }

            private MapField<Integer, AvatarTeamOuterClass.AvatarTeam> internalGetMutableAvatarTeamMap() {
                onChanged();
                if (this.avatarTeamMap_ == null) {
                    this.avatarTeamMap_ = MapField.newMapField(AvatarTeamMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.avatarTeamMap_.isMutable()) {
                    this.avatarTeamMap_ = this.avatarTeamMap_.copy();
                }
                return this.avatarTeamMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public int getAvatarTeamMapCount() {
                return internalGetAvatarTeamMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public boolean containsAvatarTeamMap(int key) {
                return internalGetAvatarTeamMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            @Deprecated
            public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMap() {
                return getAvatarTeamMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getAvatarTeamMapMap() {
                return internalGetAvatarTeamMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrDefault(int key, AvatarTeamOuterClass.AvatarTeam defaultValue) {
                Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public AvatarTeamOuterClass.AvatarTeam getAvatarTeamMapOrThrow(int key) {
                Map<Integer, AvatarTeamOuterClass.AvatarTeam> map = internalGetAvatarTeamMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAvatarTeamMap() {
                internalGetMutableAvatarTeamMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAvatarTeamMap(int key) {
                internalGetMutableAvatarTeamMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, AvatarTeamOuterClass.AvatarTeam> getMutableAvatarTeamMap() {
                return internalGetMutableAvatarTeamMap().getMutableMap();
            }

            public Builder putAvatarTeamMap(int key, AvatarTeamOuterClass.AvatarTeam value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableAvatarTeamMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllAvatarTeamMap(Map<Integer, AvatarTeamOuterClass.AvatarTeam> values) {
                internalGetMutableAvatarTeamMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensureTempAvatarGuidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.tempAvatarGuidList_ = AvatarTeamUpdateNotify.mutableCopy(this.tempAvatarGuidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public List<Long> getTempAvatarGuidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.tempAvatarGuidList_) : this.tempAvatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public int getTempAvatarGuidListCount() {
                return this.tempAvatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotifyOrBuilder
            public long getTempAvatarGuidList(int index) {
                return this.tempAvatarGuidList_.getLong(index);
            }

            public Builder setTempAvatarGuidList(int index, long value) {
                ensureTempAvatarGuidListIsMutable();
                this.tempAvatarGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addTempAvatarGuidList(long value) {
                ensureTempAvatarGuidListIsMutable();
                this.tempAvatarGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllTempAvatarGuidList(Iterable<? extends Long> values) {
                ensureTempAvatarGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tempAvatarGuidList_);
                onChanged();
                return this;
            }

            public Builder clearTempAvatarGuidList() {
                this.tempAvatarGuidList_ = AvatarTeamUpdateNotify.emptyLongList();
                this.bitField0_ &= -3;
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

        public static AvatarTeamUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarTeamUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarTeamUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarTeamUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarTeamOuterClass.getDescriptor();
    }
}
