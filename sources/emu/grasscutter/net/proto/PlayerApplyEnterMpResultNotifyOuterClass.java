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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultNotifyOuterClass.class */
public final class PlayerApplyEnterMpResultNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$PlayerApplyEnterMpResultNotify.proto\"ê\u0004\n\u001ePlayerApplyEnterMpResultNotify\u0012\u0010\n\bisAgreed\u0018\u0007 \u0001(\b\u0012\u0016\n\u000etargetNickname\u0018\u000e \u0001(\t\u00126\n\u0006reason\u0018\n \u0001(\u000e2&.PlayerApplyEnterMpResultNotify.Reason\u0012\u0011\n\ttargetUid\u0018\u0001 \u0001(\r\"Ò\u0003\n\u0006Reason\u0012\u0017\n\u0013REASON_PLAYER_JUDGE\u0010��\u0012\u001d\n\u0019REASON_SCENE_CANNOT_ENTER\u0010\u0001\u0012!\n\u001dREASON_PLAYER_CANNOT_ENTER_MP\u0010\u0002\u0012\u0017\n\u0013REASON_SYSTEM_JUDGE\u0010\u0003\u0012\"\n\u001eREASON_ALLOW_ENTER_PLAYER_FULL\u0010\u0004\u0012&\n\"REASON_WORLD_LEVEL_LOWER_THAN_HOST\u0010\u0005\u0012\u0018\n\u0014REASON_HOST_IN_MATCH\u0010\u0006\u0012\u001e\n\u001aREASON_PLAYER_IN_BLACKLIST\u0010\u0007\u0012&\n\"REASON_PS_PLAYER_NOT_ACCEPT_OTHERS\u0010\b\u0012\u001a\n\u0016REASON_HOST_IS_BLOCKED\u0010\t\u0012(\n$REASON_OTHER_DATA_VERSION_NOT_LATEST\u0010\n\u0012\"\n\u001eREASON_DATA_VERSION_NOT_LATEST\u0010\u000b\u0012%\n!REASON_PLAYER_NOT_IN_PLAYER_WORLD\u0010\f\u0012\u0015\n\u0011REASON_MAX_PLAYER\u0010\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PlayerApplyEnterMpResultNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_PlayerApplyEnterMpResultNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f805x74d4eee9 = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerApplyEnterMpResultNotify_descriptor, new String[]{"IsAgreed", "TargetNickname", "Reason", "TargetUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultNotifyOuterClass$PlayerApplyEnterMpResultNotifyOrBuilder.class */
    public interface PlayerApplyEnterMpResultNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsAgreed();

        String getTargetNickname();

        ByteString getTargetNicknameBytes();

        int getReasonValue();

        PlayerApplyEnterMpResultNotify.Reason getReason();

        int getTargetUid();
    }

    private PlayerApplyEnterMpResultNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultNotifyOuterClass$PlayerApplyEnterMpResultNotify.class */
    public static final class PlayerApplyEnterMpResultNotify extends GeneratedMessageV3 implements PlayerApplyEnterMpResultNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISAGREED_FIELD_NUMBER = 7;
        private boolean isAgreed_;
        public static final int TARGETNICKNAME_FIELD_NUMBER = 14;
        private volatile Object targetNickname_;
        public static final int REASON_FIELD_NUMBER = 10;
        private int reason_;
        public static final int TARGETUID_FIELD_NUMBER = 1;
        private int targetUid_;
        private byte memoizedIsInitialized;
        private static final PlayerApplyEnterMpResultNotify DEFAULT_INSTANCE = new PlayerApplyEnterMpResultNotify();
        private static final Parser<PlayerApplyEnterMpResultNotify> PARSER = new AbstractParser<PlayerApplyEnterMpResultNotify>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.1
            @Override // com.google.protobuf.Parser
            public PlayerApplyEnterMpResultNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerApplyEnterMpResultNotify(input, extensionRegistry);
            }
        };

        private PlayerApplyEnterMpResultNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerApplyEnterMpResultNotify() {
            this.memoizedIsInitialized = -1;
            this.targetNickname_ = "";
            this.reason_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerApplyEnterMpResultNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerApplyEnterMpResultNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.targetUid_ = input.readUInt32();
                                break;
                            case 56:
                                this.isAgreed_ = input.readBool();
                                break;
                            case 80:
                                this.reason_ = input.readEnum();
                                break;
                            case 114:
                                this.targetNickname_ = input.readStringRequireUtf8();
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
            return PlayerApplyEnterMpResultNotifyOuterClass.internal_static_PlayerApplyEnterMpResultNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerApplyEnterMpResultNotifyOuterClass.f805x74d4eee9.ensureFieldAccessorsInitialized(PlayerApplyEnterMpResultNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultNotifyOuterClass$PlayerApplyEnterMpResultNotify$Reason.class */
        public enum Reason implements ProtocolMessageEnum {
            REASON_PLAYER_JUDGE(0),
            REASON_SCENE_CANNOT_ENTER(1),
            REASON_PLAYER_CANNOT_ENTER_MP(2),
            REASON_SYSTEM_JUDGE(3),
            REASON_ALLOW_ENTER_PLAYER_FULL(4),
            REASON_WORLD_LEVEL_LOWER_THAN_HOST(5),
            REASON_HOST_IN_MATCH(6),
            REASON_PLAYER_IN_BLACKLIST(7),
            REASON_PS_PLAYER_NOT_ACCEPT_OTHERS(8),
            REASON_HOST_IS_BLOCKED(9),
            REASON_OTHER_DATA_VERSION_NOT_LATEST(10),
            REASON_DATA_VERSION_NOT_LATEST(11),
            REASON_PLAYER_NOT_IN_PLAYER_WORLD(12),
            REASON_MAX_PLAYER(13),
            UNRECOGNIZED(-1);
            
            public static final int REASON_PLAYER_JUDGE_VALUE = 0;
            public static final int REASON_SCENE_CANNOT_ENTER_VALUE = 1;
            public static final int REASON_PLAYER_CANNOT_ENTER_MP_VALUE = 2;
            public static final int REASON_SYSTEM_JUDGE_VALUE = 3;
            public static final int REASON_ALLOW_ENTER_PLAYER_FULL_VALUE = 4;
            public static final int REASON_WORLD_LEVEL_LOWER_THAN_HOST_VALUE = 5;
            public static final int REASON_HOST_IN_MATCH_VALUE = 6;
            public static final int REASON_PLAYER_IN_BLACKLIST_VALUE = 7;
            public static final int REASON_PS_PLAYER_NOT_ACCEPT_OTHERS_VALUE = 8;
            public static final int REASON_HOST_IS_BLOCKED_VALUE = 9;
            public static final int REASON_OTHER_DATA_VERSION_NOT_LATEST_VALUE = 10;
            public static final int REASON_DATA_VERSION_NOT_LATEST_VALUE = 11;
            public static final int REASON_PLAYER_NOT_IN_PLAYER_WORLD_VALUE = 12;
            public static final int REASON_MAX_PLAYER_VALUE = 13;
            private static final Internal.EnumLiteMap<Reason> internalValueMap = new Internal.EnumLiteMap<Reason>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Reason findValueByNumber(int number) {
                    return Reason.forNumber(number);
                }
            };
            private static final Reason[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static Reason valueOf(int value) {
                return forNumber(value);
            }

            public static Reason forNumber(int value) {
                switch (value) {
                    case 0:
                        return REASON_PLAYER_JUDGE;
                    case 1:
                        return REASON_SCENE_CANNOT_ENTER;
                    case 2:
                        return REASON_PLAYER_CANNOT_ENTER_MP;
                    case 3:
                        return REASON_SYSTEM_JUDGE;
                    case 4:
                        return REASON_ALLOW_ENTER_PLAYER_FULL;
                    case 5:
                        return REASON_WORLD_LEVEL_LOWER_THAN_HOST;
                    case 6:
                        return REASON_HOST_IN_MATCH;
                    case 7:
                        return REASON_PLAYER_IN_BLACKLIST;
                    case 8:
                        return REASON_PS_PLAYER_NOT_ACCEPT_OTHERS;
                    case 9:
                        return REASON_HOST_IS_BLOCKED;
                    case 10:
                        return REASON_OTHER_DATA_VERSION_NOT_LATEST;
                    case 11:
                        return REASON_DATA_VERSION_NOT_LATEST;
                    case 12:
                        return REASON_PLAYER_NOT_IN_PLAYER_WORLD;
                    case 13:
                        return REASON_MAX_PLAYER;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Reason> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return PlayerApplyEnterMpResultNotify.getDescriptor().getEnumTypes().get(0);
            }

            public static Reason valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            Reason(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
        public boolean getIsAgreed() {
            return this.isAgreed_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
        public String getTargetNickname() {
            Object ref = this.targetNickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.targetNickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
        public ByteString getTargetNicknameBytes() {
            Object ref = this.targetNickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.targetNickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
        public Reason getReason() {
            Reason result = Reason.valueOf(this.reason_);
            return result == null ? Reason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
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
            if (this.targetUid_ != 0) {
                output.writeUInt32(1, this.targetUid_);
            }
            if (this.isAgreed_) {
                output.writeBool(7, this.isAgreed_);
            }
            if (this.reason_ != Reason.REASON_PLAYER_JUDGE.getNumber()) {
                output.writeEnum(10, this.reason_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.targetNickname_)) {
                GeneratedMessageV3.writeString(output, 14, this.targetNickname_);
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
            if (this.targetUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.targetUid_);
            }
            if (this.isAgreed_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isAgreed_);
            }
            if (this.reason_ != Reason.REASON_PLAYER_JUDGE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(10, this.reason_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.targetNickname_)) {
                size2 += GeneratedMessageV3.computeStringSize(14, this.targetNickname_);
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
            if (!(obj instanceof PlayerApplyEnterMpResultNotify)) {
                return equals(obj);
            }
            PlayerApplyEnterMpResultNotify other = (PlayerApplyEnterMpResultNotify) obj;
            return getIsAgreed() == other.getIsAgreed() && getTargetNickname().equals(other.getTargetNickname()) && this.reason_ == other.reason_ && getTargetUid() == other.getTargetUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + Internal.hashBoolean(getIsAgreed()))) + 14)) + getTargetNickname().hashCode())) + 10)) + this.reason_)) + 1)) + getTargetUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpResultNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerApplyEnterMpResultNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlayerApplyEnterMpResultNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerApplyEnterMpResultNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerApplyEnterMpResultNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerApplyEnterMpResultNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpResultNotifyOuterClass$PlayerApplyEnterMpResultNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerApplyEnterMpResultNotifyOrBuilder {
            private boolean isAgreed_;
            private Object targetNickname_ = "";
            private int reason_ = 0;
            private int targetUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerApplyEnterMpResultNotifyOuterClass.internal_static_PlayerApplyEnterMpResultNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerApplyEnterMpResultNotifyOuterClass.f805x74d4eee9.ensureFieldAccessorsInitialized(PlayerApplyEnterMpResultNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerApplyEnterMpResultNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAgreed_ = false;
                this.targetNickname_ = "";
                this.reason_ = 0;
                this.targetUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerApplyEnterMpResultNotifyOuterClass.internal_static_PlayerApplyEnterMpResultNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerApplyEnterMpResultNotify getDefaultInstanceForType() {
                return PlayerApplyEnterMpResultNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpResultNotify build() {
                PlayerApplyEnterMpResultNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerApplyEnterMpResultNotify buildPartial() {
                PlayerApplyEnterMpResultNotify result = new PlayerApplyEnterMpResultNotify(this);
                result.isAgreed_ = this.isAgreed_;
                result.targetNickname_ = this.targetNickname_;
                result.reason_ = this.reason_;
                result.targetUid_ = this.targetUid_;
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
                if (other instanceof PlayerApplyEnterMpResultNotify) {
                    return mergeFrom((PlayerApplyEnterMpResultNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerApplyEnterMpResultNotify other) {
                if (other == PlayerApplyEnterMpResultNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAgreed()) {
                    setIsAgreed(other.getIsAgreed());
                }
                if (!other.getTargetNickname().isEmpty()) {
                    this.targetNickname_ = other.targetNickname_;
                    onChanged();
                }
                if (other.reason_ != 0) {
                    setReasonValue(other.getReasonValue());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
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
                PlayerApplyEnterMpResultNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerApplyEnterMpResultNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerApplyEnterMpResultNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
            public boolean getIsAgreed() {
                return this.isAgreed_;
            }

            public Builder setIsAgreed(boolean value) {
                this.isAgreed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAgreed() {
                this.isAgreed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
            public String getTargetNickname() {
                Object ref = this.targetNickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.targetNickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
            public ByteString getTargetNicknameBytes() {
                Object ref = this.targetNickname_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.targetNickname_ = b;
                return b;
            }

            public Builder setTargetNickname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.targetNickname_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetNickname() {
                this.targetNickname_ = PlayerApplyEnterMpResultNotify.getDefaultInstance().getTargetNickname();
                onChanged();
                return this;
            }

            public Builder setTargetNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PlayerApplyEnterMpResultNotify.checkByteStringIsUtf8(value);
                this.targetNickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
            public int getReasonValue() {
                return this.reason_;
            }

            public Builder setReasonValue(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
            public Reason getReason() {
                Reason result = Reason.valueOf(this.reason_);
                return result == null ? Reason.UNRECOGNIZED : result;
            }

            public Builder setReason(Reason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.reason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotifyOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
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

        public static PlayerApplyEnterMpResultNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerApplyEnterMpResultNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerApplyEnterMpResultNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerApplyEnterMpResultNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
