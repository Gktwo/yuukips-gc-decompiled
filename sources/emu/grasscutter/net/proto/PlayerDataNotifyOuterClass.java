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
import emu.grasscutter.net.proto.PropValueOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDataNotifyOuterClass.class */
public final class PlayerDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016PlayerDataNotify.proto\u001a\u000fPropValue.proto\"Ù\u0001\n\u0010PlayerDataNotify\u0012\u001c\n\u0014is_first_login_today\u0018\f \u0001(\b\u0012\u0011\n\tnick_name\u0018\t \u0001(\t\u0012\u0013\n\u000bserver_time\u0018\u0001 \u0001(\u0004\u00120\n\bprop_map\u0018\u0004 \u0003(\u000b2\u001e.PlayerDataNotify.PropMapEntry\u0012\u0011\n\tregion_id\u0018\u0002 \u0001(\r\u001a:\n\fPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\u0019\n\u0005value\u0018\u0002 \u0001(\u000b2\n.PropValue:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PropValueOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerDataNotify_descriptor, new String[]{"IsFirstLoginToday", "NickName", "ServerTime", "PropMap", "RegionId"});
    private static final Descriptors.Descriptor internal_static_PlayerDataNotify_PropMapEntry_descriptor = internal_static_PlayerDataNotify_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerDataNotify_PropMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerDataNotify_PropMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDataNotifyOuterClass$PlayerDataNotifyOrBuilder.class */
    public interface PlayerDataNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsFirstLoginToday();

        String getNickName();

        ByteString getNickNameBytes();

        long getServerTime();

        int getPropMapCount();

        boolean containsPropMap(int i);

        @Deprecated
        Map<Integer, PropValueOuterClass.PropValue> getPropMap();

        Map<Integer, PropValueOuterClass.PropValue> getPropMapMap();

        PropValueOuterClass.PropValue getPropMapOrDefault(int i, PropValueOuterClass.PropValue propValue);

        PropValueOuterClass.PropValue getPropMapOrThrow(int i);

        int getRegionId();
    }

    private PlayerDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDataNotifyOuterClass$PlayerDataNotify.class */
    public static final class PlayerDataNotify extends GeneratedMessageV3 implements PlayerDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FIRST_LOGIN_TODAY_FIELD_NUMBER = 12;
        private boolean isFirstLoginToday_;
        public static final int NICK_NAME_FIELD_NUMBER = 9;
        private volatile Object nickName_;
        public static final int SERVER_TIME_FIELD_NUMBER = 1;
        private long serverTime_;
        public static final int PROP_MAP_FIELD_NUMBER = 4;
        private MapField<Integer, PropValueOuterClass.PropValue> propMap_;
        public static final int REGION_ID_FIELD_NUMBER = 2;
        private int regionId_;
        private byte memoizedIsInitialized;
        private static final PlayerDataNotify DEFAULT_INSTANCE = new PlayerDataNotify();
        private static final Parser<PlayerDataNotify> PARSER = new AbstractParser<PlayerDataNotify>() { // from class: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerDataNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 4: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetPropMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private PlayerDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerDataNotify() {
            this.memoizedIsInitialized = -1;
            this.nickName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.serverTime_ = input.readUInt64();
                                break;
                            case 16:
                                this.regionId_ = input.readUInt32();
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.propMap_ = MapField.newMapField(PropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, PropValueOuterClass.PropValue> propMap__ = (MapEntry) input.readMessage(PropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.propMap_.getMutableMap().put(propMap__.getKey(), propMap__.getValue());
                                break;
                            case 74:
                                this.nickName_ = input.readStringRequireUtf8();
                                break;
                            case 96:
                                this.isFirstLoginToday_ = input.readBool();
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
            return PlayerDataNotifyOuterClass.internal_static_PlayerDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerDataNotifyOuterClass.internal_static_PlayerDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public boolean getIsFirstLoginToday() {
            return this.isFirstLoginToday_;
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public String getNickName() {
            Object ref = this.nickName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nickName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public ByteString getNickNameBytes() {
            Object ref = this.nickName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nickName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public long getServerTime() {
            return this.serverTime_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDataNotifyOuterClass$PlayerDataNotify$PropMapDefaultEntryHolder.class */
        public static final class PropMapDefaultEntryHolder {
            static final MapEntry<Integer, PropValueOuterClass.PropValue> defaultEntry = MapEntry.newDefaultInstance(PlayerDataNotifyOuterClass.internal_static_PlayerDataNotify_PropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, PropValueOuterClass.PropValue.getDefaultInstance());

            private PropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, PropValueOuterClass.PropValue> internalGetPropMap() {
            if (this.propMap_ == null) {
                return MapField.emptyMapField(PropMapDefaultEntryHolder.defaultEntry);
            }
            return this.propMap_;
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public int getPropMapCount() {
            return internalGetPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public boolean containsPropMap(int key) {
            return internalGetPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        @Deprecated
        public Map<Integer, PropValueOuterClass.PropValue> getPropMap() {
            return getPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public Map<Integer, PropValueOuterClass.PropValue> getPropMapMap() {
            return internalGetPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public PropValueOuterClass.PropValue getPropMapOrDefault(int key, PropValueOuterClass.PropValue defaultValue) {
            Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public PropValueOuterClass.PropValue getPropMapOrThrow(int key) {
            Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
        public int getRegionId() {
            return this.regionId_;
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
            if (this.serverTime_ != 0) {
                output.writeUInt64(1, this.serverTime_);
            }
            if (this.regionId_ != 0) {
                output.writeUInt32(2, this.regionId_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetPropMap(), PropMapDefaultEntryHolder.defaultEntry, 4);
            if (!GeneratedMessageV3.isStringEmpty(this.nickName_)) {
                GeneratedMessageV3.writeString(output, 9, this.nickName_);
            }
            if (this.isFirstLoginToday_) {
                output.writeBool(12, this.isFirstLoginToday_);
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
            if (this.serverTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(1, this.serverTime_);
            }
            if (this.regionId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.regionId_);
            }
            for (Map.Entry<Integer, PropValueOuterClass.PropValue> entry : internalGetPropMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(4, PropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nickName_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.nickName_);
            }
            if (this.isFirstLoginToday_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isFirstLoginToday_);
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
            if (!(obj instanceof PlayerDataNotify)) {
                return equals(obj);
            }
            PlayerDataNotify other = (PlayerDataNotify) obj;
            return getIsFirstLoginToday() == other.getIsFirstLoginToday() && getNickName().equals(other.getNickName()) && getServerTime() == other.getServerTime() && internalGetPropMap().equals(other.internalGetPropMap()) && getRegionId() == other.getRegionId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + Internal.hashBoolean(getIsFirstLoginToday()))) + 9)) + getNickName().hashCode())) + 1)) + Internal.hashLong(getServerTime());
            if (!internalGetPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 4)) + internalGetPropMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getRegionId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayerDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerDataNotify parseFrom(InputStream input) throws IOException {
            return (PlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDataNotifyOuterClass$PlayerDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerDataNotifyOrBuilder {
            private int bitField0_;
            private boolean isFirstLoginToday_;
            private Object nickName_ = "";
            private long serverTime_;
            private MapField<Integer, PropValueOuterClass.PropValue> propMap_;
            private int regionId_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 4: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetPropMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 4: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutablePropMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerDataNotifyOuterClass.internal_static_PlayerDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerDataNotifyOuterClass.internal_static_PlayerDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFirstLoginToday_ = false;
                this.nickName_ = "";
                this.serverTime_ = 0;
                internalGetMutablePropMap().clear();
                this.regionId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerDataNotifyOuterClass.internal_static_PlayerDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerDataNotify getDefaultInstanceForType() {
                return PlayerDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerDataNotify build() {
                PlayerDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerDataNotify buildPartial() {
                PlayerDataNotify result = new PlayerDataNotify(this);
                int i = this.bitField0_;
                result.isFirstLoginToday_ = this.isFirstLoginToday_;
                result.nickName_ = this.nickName_;
                result.serverTime_ = this.serverTime_;
                result.propMap_ = internalGetPropMap();
                result.propMap_.makeImmutable();
                result.regionId_ = this.regionId_;
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
                if (other instanceof PlayerDataNotify) {
                    return mergeFrom((PlayerDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerDataNotify other) {
                if (other == PlayerDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFirstLoginToday()) {
                    setIsFirstLoginToday(other.getIsFirstLoginToday());
                }
                if (!other.getNickName().isEmpty()) {
                    this.nickName_ = other.nickName_;
                    onChanged();
                }
                if (other.getServerTime() != 0) {
                    setServerTime(other.getServerTime());
                }
                internalGetMutablePropMap().mergeFrom(other.internalGetPropMap());
                if (other.getRegionId() != 0) {
                    setRegionId(other.getRegionId());
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
                PlayerDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public boolean getIsFirstLoginToday() {
                return this.isFirstLoginToday_;
            }

            public Builder setIsFirstLoginToday(boolean value) {
                this.isFirstLoginToday_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFirstLoginToday() {
                this.isFirstLoginToday_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public String getNickName() {
                Object ref = this.nickName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nickName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public ByteString getNickNameBytes() {
                Object ref = this.nickName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nickName_ = b;
                return b;
            }

            public Builder setNickName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nickName_ = value;
                onChanged();
                return this;
            }

            public Builder clearNickName() {
                this.nickName_ = PlayerDataNotify.getDefaultInstance().getNickName();
                onChanged();
                return this;
            }

            public Builder setNickNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerDataNotify.checkByteStringIsUtf8(value);
                this.nickName_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public long getServerTime() {
                return this.serverTime_;
            }

            public Builder setServerTime(long value) {
                this.serverTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerTime() {
                this.serverTime_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, PropValueOuterClass.PropValue> internalGetPropMap() {
                if (this.propMap_ == null) {
                    return MapField.emptyMapField(PropMapDefaultEntryHolder.defaultEntry);
                }
                return this.propMap_;
            }

            private MapField<Integer, PropValueOuterClass.PropValue> internalGetMutablePropMap() {
                onChanged();
                if (this.propMap_ == null) {
                    this.propMap_ = MapField.newMapField(PropMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.propMap_.isMutable()) {
                    this.propMap_ = this.propMap_.copy();
                }
                return this.propMap_;
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public int getPropMapCount() {
                return internalGetPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public boolean containsPropMap(int key) {
                return internalGetPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            @Deprecated
            public Map<Integer, PropValueOuterClass.PropValue> getPropMap() {
                return getPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public Map<Integer, PropValueOuterClass.PropValue> getPropMapMap() {
                return internalGetPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public PropValueOuterClass.PropValue getPropMapOrDefault(int key, PropValueOuterClass.PropValue defaultValue) {
                Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public PropValueOuterClass.PropValue getPropMapOrThrow(int key) {
                Map<Integer, PropValueOuterClass.PropValue> map = internalGetPropMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearPropMap() {
                internalGetMutablePropMap().getMutableMap().clear();
                return this;
            }

            public Builder removePropMap(int key) {
                internalGetMutablePropMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, PropValueOuterClass.PropValue> getMutablePropMap() {
                return internalGetMutablePropMap().getMutableMap();
            }

            public Builder putPropMap(int key, PropValueOuterClass.PropValue value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutablePropMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllPropMap(Map<Integer, PropValueOuterClass.PropValue> values) {
                internalGetMutablePropMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerDataNotifyOuterClass.PlayerDataNotifyOrBuilder
            public int getRegionId() {
                return this.regionId_;
            }

            public Builder setRegionId(int value) {
                this.regionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegionId() {
                this.regionId_ = 0;
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

        public static PlayerDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PropValueOuterClass.getDescriptor();
    }
}
