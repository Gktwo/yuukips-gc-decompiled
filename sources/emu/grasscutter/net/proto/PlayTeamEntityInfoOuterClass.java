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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayTeamEntityInfoOuterClass.class */
public final class PlayTeamEntityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018PlayTeamEntityInfo.proto\u001a\u001aAbilitySyncStateInfo.proto\"\u0001\n\u0012PlayTeamEntityInfo\u0012\u0011\n\tentity_id\u0018\u0001 \u0001(\r\u0012\u0012\n\nplayer_uid\u0018\u0002 \u0001(\r\u0012\u0019\n\u0011authority_peer_id\u0018\u0003 \u0001(\r\u0012\u0018\n\u0010gadget_config_id\u0018\u0005 \u0001(\r\u0012+\n\fability_info\u0018\u0006 \u0001(\u000b2\u0015.AbilitySyncStateInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilitySyncStateInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayTeamEntityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayTeamEntityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayTeamEntityInfo_descriptor, new String[]{"EntityId", "PlayerUid", "AuthorityPeerId", "GadgetConfigId", "AbilityInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayTeamEntityInfoOuterClass$PlayTeamEntityInfoOrBuilder.class */
    public interface PlayTeamEntityInfoOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getPlayerUid();

        int getAuthorityPeerId();

        int getGadgetConfigId();

        boolean hasAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder();
    }

    private PlayTeamEntityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayTeamEntityInfoOuterClass$PlayTeamEntityInfo.class */
    public static final class PlayTeamEntityInfo extends GeneratedMessageV3 implements PlayTeamEntityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 1;
        private int entityId_;
        public static final int PLAYER_UID_FIELD_NUMBER = 2;
        private int playerUid_;
        public static final int AUTHORITY_PEER_ID_FIELD_NUMBER = 3;
        private int authorityPeerId_;
        public static final int GADGET_CONFIG_ID_FIELD_NUMBER = 5;
        private int gadgetConfigId_;
        public static final int ABILITY_INFO_FIELD_NUMBER = 6;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
        private byte memoizedIsInitialized;
        private static final PlayTeamEntityInfo DEFAULT_INSTANCE = new PlayTeamEntityInfo();
        private static final Parser<PlayTeamEntityInfo> PARSER = new AbstractParser<PlayTeamEntityInfo>() { // from class: emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfo.1
            @Override // com.google.protobuf.Parser
            public PlayTeamEntityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayTeamEntityInfo(input, extensionRegistry);
            }
        };

        private PlayTeamEntityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayTeamEntityInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayTeamEntityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlayTeamEntityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.entityId_ = input.readUInt32();
                                break;
                            case 16:
                                this.playerUid_ = input.readUInt32();
                                break;
                            case 24:
                                this.authorityPeerId_ = input.readUInt32();
                                break;
                            case 40:
                                this.gadgetConfigId_ = input.readUInt32();
                                break;
                            case 50:
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder = this.abilityInfo_ != null ? this.abilityInfo_.toBuilder() : null;
                                this.abilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.abilityInfo_);
                                    this.abilityInfo_ = subBuilder.buildPartial();
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
            return PlayTeamEntityInfoOuterClass.internal_static_PlayTeamEntityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayTeamEntityInfoOuterClass.internal_static_PlayTeamEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayTeamEntityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public int getPlayerUid() {
            return this.playerUid_;
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public int getAuthorityPeerId() {
            return this.authorityPeerId_;
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public int getGadgetConfigId() {
            return this.gadgetConfigId_;
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public boolean hasAbilityInfo() {
            return this.abilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo() {
            return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder() {
            return getAbilityInfo();
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
            if (this.entityId_ != 0) {
                output.writeUInt32(1, this.entityId_);
            }
            if (this.playerUid_ != 0) {
                output.writeUInt32(2, this.playerUid_);
            }
            if (this.authorityPeerId_ != 0) {
                output.writeUInt32(3, this.authorityPeerId_);
            }
            if (this.gadgetConfigId_ != 0) {
                output.writeUInt32(5, this.gadgetConfigId_);
            }
            if (this.abilityInfo_ != null) {
                output.writeMessage(6, getAbilityInfo());
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.entityId_);
            }
            if (this.playerUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.playerUid_);
            }
            if (this.authorityPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.authorityPeerId_);
            }
            if (this.gadgetConfigId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.gadgetConfigId_);
            }
            if (this.abilityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getAbilityInfo());
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
            if (!(obj instanceof PlayTeamEntityInfo)) {
                return equals(obj);
            }
            PlayTeamEntityInfo other = (PlayTeamEntityInfo) obj;
            if (getEntityId() == other.getEntityId() && getPlayerUid() == other.getPlayerUid() && getAuthorityPeerId() == other.getAuthorityPeerId() && getGadgetConfigId() == other.getGadgetConfigId() && hasAbilityInfo() == other.hasAbilityInfo()) {
                return (!hasAbilityInfo() || getAbilityInfo().equals(other.getAbilityInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getEntityId())) + 2)) + getPlayerUid())) + 3)) + getAuthorityPeerId())) + 5)) + getGadgetConfigId();
            if (hasAbilityInfo()) {
                hash = (53 * ((37 * hash) + 6)) + getAbilityInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlayTeamEntityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayTeamEntityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayTeamEntityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayTeamEntityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayTeamEntityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayTeamEntityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayTeamEntityInfo parseFrom(InputStream input) throws IOException {
            return (PlayTeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayTeamEntityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayTeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayTeamEntityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayTeamEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayTeamEntityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayTeamEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayTeamEntityInfo parseFrom(CodedInputStream input) throws IOException {
            return (PlayTeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayTeamEntityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayTeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayTeamEntityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayTeamEntityInfoOuterClass$PlayTeamEntityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayTeamEntityInfoOrBuilder {
            private int entityId_;
            private int playerUid_;
            private int authorityPeerId_;
            private int gadgetConfigId_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> abilityInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayTeamEntityInfoOuterClass.internal_static_PlayTeamEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayTeamEntityInfoOuterClass.internal_static_PlayTeamEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayTeamEntityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayTeamEntityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.playerUid_ = 0;
                this.authorityPeerId_ = 0;
                this.gadgetConfigId_ = 0;
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = null;
                } else {
                    this.abilityInfo_ = null;
                    this.abilityInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayTeamEntityInfoOuterClass.internal_static_PlayTeamEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayTeamEntityInfo getDefaultInstanceForType() {
                return PlayTeamEntityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayTeamEntityInfo build() {
                PlayTeamEntityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayTeamEntityInfo buildPartial() {
                PlayTeamEntityInfo result = new PlayTeamEntityInfo(this);
                result.entityId_ = this.entityId_;
                result.playerUid_ = this.playerUid_;
                result.authorityPeerId_ = this.authorityPeerId_;
                result.gadgetConfigId_ = this.gadgetConfigId_;
                if (this.abilityInfoBuilder_ == null) {
                    result.abilityInfo_ = this.abilityInfo_;
                } else {
                    result.abilityInfo_ = this.abilityInfoBuilder_.build();
                }
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
                if (other instanceof PlayTeamEntityInfo) {
                    return mergeFrom((PlayTeamEntityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayTeamEntityInfo other) {
                if (other == PlayTeamEntityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getPlayerUid() != 0) {
                    setPlayerUid(other.getPlayerUid());
                }
                if (other.getAuthorityPeerId() != 0) {
                    setAuthorityPeerId(other.getAuthorityPeerId());
                }
                if (other.getGadgetConfigId() != 0) {
                    setGadgetConfigId(other.getGadgetConfigId());
                }
                if (other.hasAbilityInfo()) {
                    mergeAbilityInfo(other.getAbilityInfo());
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
                PlayTeamEntityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayTeamEntityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayTeamEntityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public int getPlayerUid() {
                return this.playerUid_;
            }

            public Builder setPlayerUid(int value) {
                this.playerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerUid() {
                this.playerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public int getAuthorityPeerId() {
                return this.authorityPeerId_;
            }

            public Builder setAuthorityPeerId(int value) {
                this.authorityPeerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuthorityPeerId() {
                this.authorityPeerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public int getGadgetConfigId() {
                return this.gadgetConfigId_;
            }

            public Builder setGadgetConfigId(int value) {
                this.gadgetConfigId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetConfigId() {
                this.gadgetConfigId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public boolean hasAbilityInfo() {
                return (this.abilityInfoBuilder_ == null && this.abilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo() {
                if (this.abilityInfoBuilder_ == null) {
                    return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
                }
                return this.abilityInfoBuilder_.getMessage();
            }

            public Builder setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.abilityInfoBuilder_ != null) {
                    this.abilityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder builderForValue) {
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.abilityInfoBuilder_ == null) {
                    if (this.abilityInfo_ != null) {
                        this.abilityInfo_ = AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder(this.abilityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityInfo() {
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = null;
                    onChanged();
                } else {
                    this.abilityInfo_ = null;
                    this.abilityInfoBuilder_ = null;
                }
                return this;
            }

            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder getAbilityInfoBuilder() {
                onChanged();
                return getAbilityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayTeamEntityInfoOuterClass.PlayTeamEntityInfoOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder() {
                if (this.abilityInfoBuilder_ != null) {
                    return this.abilityInfoBuilder_.getMessageOrBuilder();
                }
                return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
            }

            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> getAbilityInfoFieldBuilder() {
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfoBuilder_ = new SingleFieldBuilderV3<>(getAbilityInfo(), getParentForChildren(), isClean());
                    this.abilityInfo_ = null;
                }
                return this.abilityInfoBuilder_;
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

        public static PlayTeamEntityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayTeamEntityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayTeamEntityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayTeamEntityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilitySyncStateInfoOuterClass.getDescriptor();
    }
}
