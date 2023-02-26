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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEntityInfoOuterClass.class */
public final class TeamEntityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014TeamEntityInfo.proto\u001a\u001aAbilitySyncStateInfo.proto\"o\n\u000eTeamEntityInfo\u0012.\n\u000fteamAbilityInfo\u0018\b \u0001(\u000b2\u0015.AbilitySyncStateInfo\u0012\u0014\n\fteamEntityId\u0018\u0002 \u0001(\r\u0012\u0017\n\u000fauthorityPeerId\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilitySyncStateInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TeamEntityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TeamEntityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TeamEntityInfo_descriptor, new String[]{"TeamAbilityInfo", "TeamEntityId", "AuthorityPeerId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEntityInfoOuterClass$TeamEntityInfoOrBuilder.class */
    public interface TeamEntityInfoOrBuilder extends MessageOrBuilder {
        boolean hasTeamAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getTeamAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getTeamAbilityInfoOrBuilder();

        int getTeamEntityId();

        int getAuthorityPeerId();
    }

    private TeamEntityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEntityInfoOuterClass$TeamEntityInfo.class */
    public static final class TeamEntityInfo extends GeneratedMessageV3 implements TeamEntityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAMABILITYINFO_FIELD_NUMBER = 8;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo teamAbilityInfo_;
        public static final int TEAMENTITYID_FIELD_NUMBER = 2;
        private int teamEntityId_;
        public static final int AUTHORITYPEERID_FIELD_NUMBER = 12;
        private int authorityPeerId_;
        private byte memoizedIsInitialized;
        private static final TeamEntityInfo DEFAULT_INSTANCE = new TeamEntityInfo();
        private static final Parser<TeamEntityInfo> PARSER = new AbstractParser<TeamEntityInfo>() { // from class: emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfo.1
            @Override // com.google.protobuf.Parser
            public TeamEntityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TeamEntityInfo(input, extensionRegistry);
            }
        };

        private TeamEntityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TeamEntityInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TeamEntityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TeamEntityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 16:
                                    this.teamEntityId_ = input.readUInt32();
                                    break;
                                case 66:
                                    AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder = this.teamAbilityInfo_ != null ? this.teamAbilityInfo_.toBuilder() : null;
                                    this.teamAbilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.teamAbilityInfo_);
                                        this.teamAbilityInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 96:
                                    this.authorityPeerId_ = input.readUInt32();
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
            return TeamEntityInfoOuterClass.internal_static_TeamEntityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TeamEntityInfoOuterClass.internal_static_TeamEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TeamEntityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
        public boolean hasTeamAbilityInfo() {
            return this.teamAbilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getTeamAbilityInfo() {
            return this.teamAbilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.teamAbilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getTeamAbilityInfoOrBuilder() {
            return getTeamAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
        public int getTeamEntityId() {
            return this.teamEntityId_;
        }

        @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
        public int getAuthorityPeerId() {
            return this.authorityPeerId_;
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
            if (this.teamEntityId_ != 0) {
                output.writeUInt32(2, this.teamEntityId_);
            }
            if (this.teamAbilityInfo_ != null) {
                output.writeMessage(8, getTeamAbilityInfo());
            }
            if (this.authorityPeerId_ != 0) {
                output.writeUInt32(12, this.authorityPeerId_);
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
            if (this.teamEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.teamEntityId_);
            }
            if (this.teamAbilityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getTeamAbilityInfo());
            }
            if (this.authorityPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.authorityPeerId_);
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
            if (!(obj instanceof TeamEntityInfo)) {
                return equals(obj);
            }
            TeamEntityInfo other = (TeamEntityInfo) obj;
            if (hasTeamAbilityInfo() != other.hasTeamAbilityInfo()) {
                return false;
            }
            return (!hasTeamAbilityInfo() || getTeamAbilityInfo().equals(other.getTeamAbilityInfo())) && getTeamEntityId() == other.getTeamEntityId() && getAuthorityPeerId() == other.getAuthorityPeerId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasTeamAbilityInfo()) {
                hash = (53 * ((37 * hash) + 8)) + getTeamAbilityInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getTeamEntityId())) + 12)) + getAuthorityPeerId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TeamEntityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamEntityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamEntityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamEntityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamEntityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamEntityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamEntityInfo parseFrom(InputStream input) throws IOException {
            return (TeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TeamEntityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TeamEntityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TeamEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TeamEntityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TeamEntityInfo parseFrom(CodedInputStream input) throws IOException {
            return (TeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TeamEntityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TeamEntityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamEntityInfoOuterClass$TeamEntityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TeamEntityInfoOrBuilder {
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo teamAbilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> teamAbilityInfoBuilder_;
            private int teamEntityId_;
            private int authorityPeerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TeamEntityInfoOuterClass.internal_static_TeamEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TeamEntityInfoOuterClass.internal_static_TeamEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TeamEntityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TeamEntityInfo.alwaysUseFieldBuilders) {
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
                this.teamEntityId_ = 0;
                this.authorityPeerId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TeamEntityInfoOuterClass.internal_static_TeamEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TeamEntityInfo getDefaultInstanceForType() {
                return TeamEntityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TeamEntityInfo build() {
                TeamEntityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TeamEntityInfo buildPartial() {
                TeamEntityInfo result = new TeamEntityInfo(this);
                if (this.teamAbilityInfoBuilder_ == null) {
                    result.teamAbilityInfo_ = this.teamAbilityInfo_;
                } else {
                    result.teamAbilityInfo_ = this.teamAbilityInfoBuilder_.build();
                }
                result.teamEntityId_ = this.teamEntityId_;
                result.authorityPeerId_ = this.authorityPeerId_;
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
                if (other instanceof TeamEntityInfo) {
                    return mergeFrom((TeamEntityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TeamEntityInfo other) {
                if (other == TeamEntityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTeamAbilityInfo()) {
                    mergeTeamAbilityInfo(other.getTeamAbilityInfo());
                }
                if (other.getTeamEntityId() != 0) {
                    setTeamEntityId(other.getTeamEntityId());
                }
                if (other.getAuthorityPeerId() != 0) {
                    setAuthorityPeerId(other.getAuthorityPeerId());
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
                TeamEntityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TeamEntityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TeamEntityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
            public boolean hasTeamAbilityInfo() {
                return (this.teamAbilityInfoBuilder_ == null && this.teamAbilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TeamEntityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TeamEntityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TeamEntityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TeamEntityInfo getDefaultInstanceForType() {
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
