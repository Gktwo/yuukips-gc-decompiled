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
import emu.grasscutter.net.proto.AbilityControlBlockOuterClass;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEnterSceneInfoOuterClass.class */
public final class TeamEnterSceneInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018TeamEnterSceneInfo.proto\u001a\u0019AbilityControlBlock.proto\u001a\u001aAbilitySyncStateInfo.proto\"\u0001\n\u0012TeamEnterSceneInfo\u00120\n\u0011team_ability_info\u0018\u0006 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u00123\n\u0015ability_control_block\u0018\u0005 \u0001(\u000b2\u0014.AbilityControlBlock\u0012\u0016\n\u000eteam_entity_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityControlBlockOuterClass.getDescriptor(), AbilitySyncStateInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TeamEnterSceneInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TeamEnterSceneInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TeamEnterSceneInfo_descriptor, new String[]{"TeamAbilityInfo", "AbilityControlBlock", "TeamEntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEnterSceneInfoOuterClass$TeamEnterSceneInfoOrBuilder.class */
    public interface TeamEnterSceneInfoOrBuilder extends MessageOrBuilder {
        boolean hasTeamAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getTeamAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getTeamAbilityInfoOrBuilder();

        boolean hasAbilityControlBlock();

        AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock();

        AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder getAbilityControlBlockOrBuilder();

        int getTeamEntityId();
    }

    private TeamEnterSceneInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEnterSceneInfoOuterClass$TeamEnterSceneInfo.class */
    public static final class TeamEnterSceneInfo extends GeneratedMessageV3 implements TeamEnterSceneInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAM_ABILITY_INFO_FIELD_NUMBER = 6;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo teamAbilityInfo_;
        public static final int ABILITY_CONTROL_BLOCK_FIELD_NUMBER = 5;
        private AbilityControlBlockOuterClass.AbilityControlBlock abilityControlBlock_;
        public static final int TEAM_ENTITY_ID_FIELD_NUMBER = 11;
        private int teamEntityId_;
        private byte memoizedIsInitialized;
        private static final TeamEnterSceneInfo DEFAULT_INSTANCE = new TeamEnterSceneInfo();
        private static final Parser<TeamEnterSceneInfo> PARSER = new AbstractParser<TeamEnterSceneInfo>() { // from class: emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.1
            @Override // com.google.protobuf.Parser
            public TeamEnterSceneInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TeamEnterSceneInfo(input, extensionRegistry);
            }
        };

        private TeamEnterSceneInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TeamEnterSceneInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TeamEnterSceneInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TeamEnterSceneInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                AbilityControlBlockOuterClass.AbilityControlBlock.Builder subBuilder = this.abilityControlBlock_ != null ? this.abilityControlBlock_.toBuilder() : null;
                                this.abilityControlBlock_ = (AbilityControlBlockOuterClass.AbilityControlBlock) input.readMessage(AbilityControlBlockOuterClass.AbilityControlBlock.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.abilityControlBlock_);
                                    this.abilityControlBlock_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 50:
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder2 = this.teamAbilityInfo_ != null ? this.teamAbilityInfo_.toBuilder() : null;
                                this.teamAbilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.teamAbilityInfo_);
                                    this.teamAbilityInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 88:
                                this.teamEntityId_ = input.readUInt32();
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
            return TeamEnterSceneInfoOuterClass.internal_static_TeamEnterSceneInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TeamEnterSceneInfoOuterClass.internal_static_TeamEnterSceneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TeamEnterSceneInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public boolean hasTeamAbilityInfo() {
            return this.teamAbilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getTeamAbilityInfo() {
            return this.teamAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.teamAbilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getTeamAbilityInfoOrBuilder() {
            return getTeamAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public boolean hasAbilityControlBlock() {
            return this.abilityControlBlock_ != null;
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock() {
            return this.abilityControlBlock_ == null ? AbilityControlBlockOuterClass.AbilityControlBlock.getDefaultInstance() : this.abilityControlBlock_;
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder getAbilityControlBlockOrBuilder() {
            return getAbilityControlBlock();
        }

        @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
        public int getTeamEntityId() {
            return this.teamEntityId_;
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
            if (this.abilityControlBlock_ != null) {
                output.writeMessage(5, getAbilityControlBlock());
            }
            if (this.teamAbilityInfo_ != null) {
                output.writeMessage(6, getTeamAbilityInfo());
            }
            if (this.teamEntityId_ != 0) {
                output.writeUInt32(11, this.teamEntityId_);
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
            if (this.abilityControlBlock_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getAbilityControlBlock());
            }
            if (this.teamAbilityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getTeamAbilityInfo());
            }
            if (this.teamEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.teamEntityId_);
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
            if (!(obj instanceof TeamEnterSceneInfo)) {
                return equals(obj);
            }
            TeamEnterSceneInfo other = (TeamEnterSceneInfo) obj;
            if (hasTeamAbilityInfo() != other.hasTeamAbilityInfo()) {
                return false;
            }
            if ((!hasTeamAbilityInfo() || getTeamAbilityInfo().equals(other.getTeamAbilityInfo())) && hasAbilityControlBlock() == other.hasAbilityControlBlock()) {
                return (!hasAbilityControlBlock() || getAbilityControlBlock().equals(other.getAbilityControlBlock())) && getTeamEntityId() == other.getTeamEntityId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasTeamAbilityInfo()) {
                hash = (53 * ((37 * hash) + 6)) + getTeamAbilityInfo().hashCode();
            }
            if (hasAbilityControlBlock()) {
                hash = (53 * ((37 * hash) + 5)) + getAbilityControlBlock().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getTeamEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TeamEnterSceneInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamEnterSceneInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamEnterSceneInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamEnterSceneInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamEnterSceneInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamEnterSceneInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamEnterSceneInfo parseFrom(InputStream input) throws IOException {
            return (TeamEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TeamEnterSceneInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TeamEnterSceneInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TeamEnterSceneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TeamEnterSceneInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamEnterSceneInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TeamEnterSceneInfo parseFrom(CodedInputStream input) throws IOException {
            return (TeamEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TeamEnterSceneInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamEnterSceneInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TeamEnterSceneInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEnterSceneInfoOuterClass$TeamEnterSceneInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TeamEnterSceneInfoOrBuilder {
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo teamAbilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> teamAbilityInfoBuilder_;
            private AbilityControlBlockOuterClass.AbilityControlBlock abilityControlBlock_;
            private SingleFieldBuilderV3<AbilityControlBlockOuterClass.AbilityControlBlock, AbilityControlBlockOuterClass.AbilityControlBlock.Builder, AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder> abilityControlBlockBuilder_;
            private int teamEntityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TeamEnterSceneInfoOuterClass.internal_static_TeamEnterSceneInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TeamEnterSceneInfoOuterClass.internal_static_TeamEnterSceneInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TeamEnterSceneInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TeamEnterSceneInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.teamAbilityInfoBuilder_ == null) {
                    this.teamAbilityInfo_ = null;
                } else {
                    this.teamAbilityInfo_ = null;
                    this.teamAbilityInfoBuilder_ = null;
                }
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlock_ = null;
                } else {
                    this.abilityControlBlock_ = null;
                    this.abilityControlBlockBuilder_ = null;
                }
                this.teamEntityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TeamEnterSceneInfoOuterClass.internal_static_TeamEnterSceneInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TeamEnterSceneInfo getDefaultInstanceForType() {
                return TeamEnterSceneInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TeamEnterSceneInfo build() {
                TeamEnterSceneInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TeamEnterSceneInfo buildPartial() {
                TeamEnterSceneInfo result = new TeamEnterSceneInfo(this);
                if (this.teamAbilityInfoBuilder_ == null) {
                    result.teamAbilityInfo_ = this.teamAbilityInfo_;
                } else {
                    result.teamAbilityInfo_ = this.teamAbilityInfoBuilder_.build();
                }
                if (this.abilityControlBlockBuilder_ == null) {
                    result.abilityControlBlock_ = this.abilityControlBlock_;
                } else {
                    result.abilityControlBlock_ = this.abilityControlBlockBuilder_.build();
                }
                result.teamEntityId_ = this.teamEntityId_;
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
                if (other instanceof TeamEnterSceneInfo) {
                    return mergeFrom((TeamEnterSceneInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TeamEnterSceneInfo other) {
                if (other == TeamEnterSceneInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTeamAbilityInfo()) {
                    mergeTeamAbilityInfo(other.getTeamAbilityInfo());
                }
                if (other.hasAbilityControlBlock()) {
                    mergeAbilityControlBlock(other.getAbilityControlBlock());
                }
                if (other.getTeamEntityId() != 0) {
                    setTeamEntityId(other.getTeamEntityId());
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
                TeamEnterSceneInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TeamEnterSceneInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TeamEnterSceneInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public boolean hasTeamAbilityInfo() {
                return (this.teamAbilityInfoBuilder_ == null && this.teamAbilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getTeamAbilityInfo() {
                if (this.teamAbilityInfoBuilder_ == null) {
                    return this.teamAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.teamAbilityInfo_;
                }
                return this.teamAbilityInfoBuilder_.getMessage();
            }

            public Builder setTeamAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.teamAbilityInfoBuilder_ != null) {
                    this.teamAbilityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.teamAbilityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTeamAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder builderForValue) {
                if (this.teamAbilityInfoBuilder_ == null) {
                    this.teamAbilityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.teamAbilityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTeamAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.teamAbilityInfoBuilder_ == null) {
                    if (this.teamAbilityInfo_ != null) {
                        this.teamAbilityInfo_ = AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder(this.teamAbilityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.teamAbilityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.teamAbilityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTeamAbilityInfo() {
                if (this.teamAbilityInfoBuilder_ == null) {
                    this.teamAbilityInfo_ = null;
                    onChanged();
                } else {
                    this.teamAbilityInfo_ = null;
                    this.teamAbilityInfoBuilder_ = null;
                }
                return this;
            }

            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder getTeamAbilityInfoBuilder() {
                onChanged();
                return getTeamAbilityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getTeamAbilityInfoOrBuilder() {
                if (this.teamAbilityInfoBuilder_ != null) {
                    return this.teamAbilityInfoBuilder_.getMessageOrBuilder();
                }
                return this.teamAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.teamAbilityInfo_;
            }

            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> getTeamAbilityInfoFieldBuilder() {
                if (this.teamAbilityInfoBuilder_ == null) {
                    this.teamAbilityInfoBuilder_ = new SingleFieldBuilderV3<>(getTeamAbilityInfo(), getParentForChildren(), isClean());
                    this.teamAbilityInfo_ = null;
                }
                return this.teamAbilityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public boolean hasAbilityControlBlock() {
                return (this.abilityControlBlockBuilder_ == null && this.abilityControlBlock_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock() {
                if (this.abilityControlBlockBuilder_ == null) {
                    return this.abilityControlBlock_ == null ? AbilityControlBlockOuterClass.AbilityControlBlock.getDefaultInstance() : this.abilityControlBlock_;
                }
                return this.abilityControlBlockBuilder_.getMessage();
            }

            public Builder setAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock value) {
                if (this.abilityControlBlockBuilder_ != null) {
                    this.abilityControlBlockBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityControlBlock_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock.Builder builderForValue) {
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlock_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityControlBlockBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock value) {
                if (this.abilityControlBlockBuilder_ == null) {
                    if (this.abilityControlBlock_ != null) {
                        this.abilityControlBlock_ = AbilityControlBlockOuterClass.AbilityControlBlock.newBuilder(this.abilityControlBlock_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityControlBlock_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityControlBlockBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityControlBlock() {
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlock_ = null;
                    onChanged();
                } else {
                    this.abilityControlBlock_ = null;
                    this.abilityControlBlockBuilder_ = null;
                }
                return this;
            }

            public AbilityControlBlockOuterClass.AbilityControlBlock.Builder getAbilityControlBlockBuilder() {
                onChanged();
                return getAbilityControlBlockFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder getAbilityControlBlockOrBuilder() {
                if (this.abilityControlBlockBuilder_ != null) {
                    return this.abilityControlBlockBuilder_.getMessageOrBuilder();
                }
                return this.abilityControlBlock_ == null ? AbilityControlBlockOuterClass.AbilityControlBlock.getDefaultInstance() : this.abilityControlBlock_;
            }

            private SingleFieldBuilderV3<AbilityControlBlockOuterClass.AbilityControlBlock, AbilityControlBlockOuterClass.AbilityControlBlock.Builder, AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder> getAbilityControlBlockFieldBuilder() {
                if (this.abilityControlBlockBuilder_ == null) {
                    this.abilityControlBlockBuilder_ = new SingleFieldBuilderV3<>(getAbilityControlBlock(), getParentForChildren(), isClean());
                    this.abilityControlBlock_ = null;
                }
                return this.abilityControlBlockBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass.TeamEnterSceneInfoOrBuilder
            public int getTeamEntityId() {
                return this.teamEntityId_;
            }

            public Builder setTeamEntityId(int value) {
                this.teamEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamEntityId() {
                this.teamEntityId_ = 0;
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

        public static TeamEnterSceneInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TeamEnterSceneInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TeamEnterSceneInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TeamEnterSceneInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityControlBlockOuterClass.getDescriptor();
        AbilitySyncStateInfoOuterClass.getDescriptor();
    }
}
