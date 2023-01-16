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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarLifeStateChangeNotifyOuterClass.class */
public final class AvatarLifeStateChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!AvatarLifeStateChangeNotify.proto\u001a\u0013PlayerDieType.proto\u001a\u0010ServerBuff.proto\"Ø\u0001\n\u001bAvatarLifeStateChangeNotify\u0012\u0018\n\u0010source_entity_id\u0018\u000b \u0001(\r\u0012%\n\u0010server_buff_list\u0018\u000e \u0003(\u000b2\u000b.ServerBuff\u0012\u0019\n\u0011move_reliable_seq\u0018\f \u0001(\r\u0012\u0012\n\nlife_state\u0018\u0006 \u0001(\r\u0012 \n\bdie_type\u0018\u0005 \u0001(\u000e2\u000e.PlayerDieType\u0012\u0012\n\nattack_tag\u0018\u000f \u0001(\t\u0012\u0013\n\u000bavatar_guid\u0018\u0002 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerDieTypeOuterClass.getDescriptor(), ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarLifeStateChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarLifeStateChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarLifeStateChangeNotify_descriptor, new String[]{"SourceEntityId", "ServerBuffList", "MoveReliableSeq", "LifeState", "DieType", "AttackTag", "AvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarLifeStateChangeNotifyOuterClass$AvatarLifeStateChangeNotifyOrBuilder.class */
    public interface AvatarLifeStateChangeNotifyOrBuilder extends MessageOrBuilder {
        int getSourceEntityId();

        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);

        int getMoveReliableSeq();

        int getLifeState();

        int getDieTypeValue();

        PlayerDieTypeOuterClass.PlayerDieType getDieType();

        String getAttackTag();

        ByteString getAttackTagBytes();

        long getAvatarGuid();
    }

    private AvatarLifeStateChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarLifeStateChangeNotifyOuterClass$AvatarLifeStateChangeNotify.class */
    public static final class AvatarLifeStateChangeNotify extends GeneratedMessageV3 implements AvatarLifeStateChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SOURCE_ENTITY_ID_FIELD_NUMBER = 11;
        private int sourceEntityId_;
        public static final int SERVER_BUFF_LIST_FIELD_NUMBER = 14;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        public static final int MOVE_RELIABLE_SEQ_FIELD_NUMBER = 12;
        private int moveReliableSeq_;
        public static final int LIFE_STATE_FIELD_NUMBER = 6;
        private int lifeState_;
        public static final int DIE_TYPE_FIELD_NUMBER = 5;
        private int dieType_;
        public static final int ATTACK_TAG_FIELD_NUMBER = 15;
        private volatile Object attackTag_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 2;
        private long avatarGuid_;
        private byte memoizedIsInitialized;
        private static final AvatarLifeStateChangeNotify DEFAULT_INSTANCE = new AvatarLifeStateChangeNotify();
        private static final Parser<AvatarLifeStateChangeNotify> PARSER = new AbstractParser<AvatarLifeStateChangeNotify>() { // from class: emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarLifeStateChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarLifeStateChangeNotify(input, extensionRegistry);
            }
        };

        private AvatarLifeStateChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarLifeStateChangeNotify() {
            this.memoizedIsInitialized = -1;
            this.serverBuffList_ = Collections.emptyList();
            this.dieType_ = 0;
            this.attackTag_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarLifeStateChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarLifeStateChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 40:
                                this.dieType_ = input.readEnum();
                                break;
                            case 48:
                                this.lifeState_ = input.readUInt32();
                                break;
                            case 88:
                                this.sourceEntityId_ = input.readUInt32();
                                break;
                            case 96:
                                this.moveReliableSeq_ = input.readUInt32();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
                                break;
                            case 122:
                                this.attackTag_ = input.readStringRequireUtf8();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarLifeStateChangeNotifyOuterClass.internal_static_AvatarLifeStateChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarLifeStateChangeNotifyOuterClass.internal_static_AvatarLifeStateChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarLifeStateChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public int getSourceEntityId() {
            return this.sourceEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public int getMoveReliableSeq() {
            return this.moveReliableSeq_;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public int getLifeState() {
            return this.lifeState_;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public int getDieTypeValue() {
            return this.dieType_;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public PlayerDieTypeOuterClass.PlayerDieType getDieType() {
            PlayerDieTypeOuterClass.PlayerDieType result = PlayerDieTypeOuterClass.PlayerDieType.valueOf(this.dieType_);
            return result == null ? PlayerDieTypeOuterClass.PlayerDieType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public String getAttackTag() {
            Object ref = this.attackTag_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.attackTag_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public ByteString getAttackTagBytes() {
            Object ref = this.attackTag_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.attackTag_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
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
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(2, this.avatarGuid_);
            }
            if (this.dieType_ != PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE.getNumber()) {
                output.writeEnum(5, this.dieType_);
            }
            if (this.lifeState_ != 0) {
                output.writeUInt32(6, this.lifeState_);
            }
            if (this.sourceEntityId_ != 0) {
                output.writeUInt32(11, this.sourceEntityId_);
            }
            if (this.moveReliableSeq_ != 0) {
                output.writeUInt32(12, this.moveReliableSeq_);
            }
            for (int i = 0; i < this.serverBuffList_.size(); i++) {
                output.writeMessage(14, this.serverBuffList_.get(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.attackTag_)) {
                GeneratedMessageV3.writeString(output, 15, this.attackTag_);
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
            if (this.avatarGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(2, this.avatarGuid_);
            }
            if (this.dieType_ != PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.dieType_);
            }
            if (this.lifeState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.lifeState_);
            }
            if (this.sourceEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.sourceEntityId_);
            }
            if (this.moveReliableSeq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.moveReliableSeq_);
            }
            for (int i = 0; i < this.serverBuffList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.serverBuffList_.get(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.attackTag_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.attackTag_);
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
            if (!(obj instanceof AvatarLifeStateChangeNotify)) {
                return equals(obj);
            }
            AvatarLifeStateChangeNotify other = (AvatarLifeStateChangeNotify) obj;
            return getSourceEntityId() == other.getSourceEntityId() && getServerBuffListList().equals(other.getServerBuffListList()) && getMoveReliableSeq() == other.getMoveReliableSeq() && getLifeState() == other.getLifeState() && this.dieType_ == other.dieType_ && getAttackTag().equals(other.getAttackTag()) && getAvatarGuid() == other.getAvatarGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getSourceEntityId();
            if (getServerBuffListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getServerBuffListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + getMoveReliableSeq())) + 6)) + getLifeState())) + 5)) + this.dieType_)) + 15)) + getAttackTag().hashCode())) + 2)) + Internal.hashLong(getAvatarGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarLifeStateChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarLifeStateChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarLifeStateChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarLifeStateChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarLifeStateChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarLifeStateChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarLifeStateChangeNotify parseFrom(InputStream input) throws IOException {
            return (AvatarLifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarLifeStateChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarLifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarLifeStateChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarLifeStateChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarLifeStateChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarLifeStateChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarLifeStateChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarLifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarLifeStateChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarLifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarLifeStateChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarLifeStateChangeNotifyOuterClass$AvatarLifeStateChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarLifeStateChangeNotifyOrBuilder {
            private int bitField0_;
            private int sourceEntityId_;
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;
            private int moveReliableSeq_;
            private int lifeState_;
            private long avatarGuid_;
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();
            private int dieType_ = 0;
            private Object attackTag_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarLifeStateChangeNotifyOuterClass.internal_static_AvatarLifeStateChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarLifeStateChangeNotifyOuterClass.internal_static_AvatarLifeStateChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarLifeStateChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarLifeStateChangeNotify.alwaysUseFieldBuilders) {
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sourceEntityId_ = 0;
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                this.moveReliableSeq_ = 0;
                this.lifeState_ = 0;
                this.dieType_ = 0;
                this.attackTag_ = "";
                this.avatarGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarLifeStateChangeNotifyOuterClass.internal_static_AvatarLifeStateChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarLifeStateChangeNotify getDefaultInstanceForType() {
                return AvatarLifeStateChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarLifeStateChangeNotify build() {
                AvatarLifeStateChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarLifeStateChangeNotify buildPartial() {
                AvatarLifeStateChangeNotify result = new AvatarLifeStateChangeNotify(this);
                int i = this.bitField0_;
                result.sourceEntityId_ = this.sourceEntityId_;
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -2;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
                }
                result.moveReliableSeq_ = this.moveReliableSeq_;
                result.lifeState_ = this.lifeState_;
                result.dieType_ = this.dieType_;
                result.attackTag_ = this.attackTag_;
                result.avatarGuid_ = this.avatarGuid_;
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
                if (other instanceof AvatarLifeStateChangeNotify) {
                    return mergeFrom((AvatarLifeStateChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarLifeStateChangeNotify other) {
                if (other == AvatarLifeStateChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getSourceEntityId() != 0) {
                    setSourceEntityId(other.getSourceEntityId());
                }
                if (this.serverBuffListBuilder_ == null) {
                    if (!other.serverBuffList_.isEmpty()) {
                        if (this.serverBuffList_.isEmpty()) {
                            this.serverBuffList_ = other.serverBuffList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureServerBuffListIsMutable();
                            this.serverBuffList_.addAll(other.serverBuffList_);
                        }
                        onChanged();
                    }
                } else if (!other.serverBuffList_.isEmpty()) {
                    if (this.serverBuffListBuilder_.isEmpty()) {
                        this.serverBuffListBuilder_.dispose();
                        this.serverBuffListBuilder_ = null;
                        this.serverBuffList_ = other.serverBuffList_;
                        this.bitField0_ &= -2;
                        this.serverBuffListBuilder_ = AvatarLifeStateChangeNotify.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
                    }
                }
                if (other.getMoveReliableSeq() != 0) {
                    setMoveReliableSeq(other.getMoveReliableSeq());
                }
                if (other.getLifeState() != 0) {
                    setLifeState(other.getLifeState());
                }
                if (other.dieType_ != 0) {
                    setDieTypeValue(other.getDieTypeValue());
                }
                if (!other.getAttackTag().isEmpty()) {
                    this.attackTag_ = other.attackTag_;
                    onChanged();
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
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
                AvatarLifeStateChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarLifeStateChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarLifeStateChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public int getSourceEntityId() {
                return this.sourceEntityId_;
            }

            public Builder setSourceEntityId(int value) {
                this.sourceEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSourceEntityId() {
                this.sourceEntityId_ = 0;
                onChanged();
                return this;
            }

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessage(index);
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllServerBuffList(Iterable<? extends ServerBuffOuterClass.ServerBuff> values) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.serverBuffList_);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearServerBuffList() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                return this;
            }

            public Builder removeServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.remove(index);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.remove(index);
                }
                return this;
            }

            public ServerBuffOuterClass.ServerBuff.Builder getServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
                if (this.serverBuffListBuilder_ != null) {
                    return this.serverBuffListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.serverBuffList_);
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder() {
                return getServerBuffListFieldBuilder().addBuilder(ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().addBuilder(index, ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public List<ServerBuffOuterClass.ServerBuff.Builder> getServerBuffListBuilderList() {
                return getServerBuffListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListFieldBuilder() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffListBuilder_ = new RepeatedFieldBuilderV3<>(this.serverBuffList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.serverBuffList_ = null;
                }
                return this.serverBuffListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public int getMoveReliableSeq() {
                return this.moveReliableSeq_;
            }

            public Builder setMoveReliableSeq(int value) {
                this.moveReliableSeq_ = value;
                onChanged();
                return this;
            }

            public Builder clearMoveReliableSeq() {
                this.moveReliableSeq_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public int getLifeState() {
                return this.lifeState_;
            }

            public Builder setLifeState(int value) {
                this.lifeState_ = value;
                onChanged();
                return this;
            }

            public Builder clearLifeState() {
                this.lifeState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public int getDieTypeValue() {
                return this.dieType_;
            }

            public Builder setDieTypeValue(int value) {
                this.dieType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public PlayerDieTypeOuterClass.PlayerDieType getDieType() {
                PlayerDieTypeOuterClass.PlayerDieType result = PlayerDieTypeOuterClass.PlayerDieType.valueOf(this.dieType_);
                return result == null ? PlayerDieTypeOuterClass.PlayerDieType.UNRECOGNIZED : result;
            }

            public Builder setDieType(PlayerDieTypeOuterClass.PlayerDieType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dieType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearDieType() {
                this.dieType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public String getAttackTag() {
                Object ref = this.attackTag_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.attackTag_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public ByteString getAttackTagBytes() {
                Object ref = this.attackTag_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.attackTag_ = b;
                return b;
            }

            public Builder setAttackTag(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.attackTag_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackTag() {
                this.attackTag_ = AvatarLifeStateChangeNotify.getDefaultInstance().getAttackTag();
                onChanged();
                return this;
            }

            public Builder setAttackTagBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AvatarLifeStateChangeNotify.checkByteStringIsUtf8(value);
                this.attackTag_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarLifeStateChangeNotifyOuterClass.AvatarLifeStateChangeNotifyOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
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

        public static AvatarLifeStateChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarLifeStateChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarLifeStateChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarLifeStateChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerDieTypeOuterClass.getDescriptor();
        ServerBuffOuterClass.getDescriptor();
    }
}
