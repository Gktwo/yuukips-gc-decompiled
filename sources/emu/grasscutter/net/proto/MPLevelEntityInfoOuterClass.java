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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MPLevelEntityInfoOuterClass.class */
public final class MPLevelEntityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017MPLevelEntityInfo.proto\u001a\u001aAbilitySyncStateInfo.proto\"j\n\u0011MPLevelEntityInfo\u0012*\n\u000babilityInfo\u0018\u0002 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u0012\u0010\n\bentityId\u0018\u000b \u0001(\r\u0012\u0017\n\u000fauthorityPeerId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilitySyncStateInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MPLevelEntityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MPLevelEntityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MPLevelEntityInfo_descriptor, new String[]{"AbilityInfo", "EntityId", "AuthorityPeerId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MPLevelEntityInfoOuterClass$MPLevelEntityInfoOrBuilder.class */
    public interface MPLevelEntityInfoOrBuilder extends MessageOrBuilder {
        boolean hasAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder();

        int getEntityId();

        int getAuthorityPeerId();
    }

    private MPLevelEntityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MPLevelEntityInfoOuterClass$MPLevelEntityInfo.class */
    public static final class MPLevelEntityInfo extends GeneratedMessageV3 implements MPLevelEntityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ABILITYINFO_FIELD_NUMBER = 2;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
        public static final int ENTITYID_FIELD_NUMBER = 11;
        private int entityId_;
        public static final int AUTHORITYPEERID_FIELD_NUMBER = 9;
        private int authorityPeerId_;
        private byte memoizedIsInitialized;
        private static final MPLevelEntityInfo DEFAULT_INSTANCE = new MPLevelEntityInfo();
        private static final Parser<MPLevelEntityInfo> PARSER = new AbstractParser<MPLevelEntityInfo>() { // from class: emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfo.1
            @Override // com.google.protobuf.Parser
            public MPLevelEntityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MPLevelEntityInfo(input, extensionRegistry);
            }
        };

        private MPLevelEntityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MPLevelEntityInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MPLevelEntityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MPLevelEntityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder = this.abilityInfo_ != null ? this.abilityInfo_.toBuilder() : null;
                                    this.abilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.abilityInfo_);
                                        this.abilityInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.authorityPeerId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.entityId_ = input.readUInt32();
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
            return MPLevelEntityInfoOuterClass.internal_static_MPLevelEntityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MPLevelEntityInfoOuterClass.internal_static_MPLevelEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MPLevelEntityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
        public boolean hasAbilityInfo() {
            return this.abilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo() {
            return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder() {
            return getAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
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
            if (this.abilityInfo_ != null) {
                output.writeMessage(2, getAbilityInfo());
            }
            if (this.authorityPeerId_ != 0) {
                output.writeUInt32(9, this.authorityPeerId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(11, this.entityId_);
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
            if (this.abilityInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getAbilityInfo());
            }
            if (this.authorityPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.authorityPeerId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.entityId_);
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
            if (!(obj instanceof MPLevelEntityInfo)) {
                return equals(obj);
            }
            MPLevelEntityInfo other = (MPLevelEntityInfo) obj;
            if (hasAbilityInfo() != other.hasAbilityInfo()) {
                return false;
            }
            return (!hasAbilityInfo() || getAbilityInfo().equals(other.getAbilityInfo())) && getEntityId() == other.getEntityId() && getAuthorityPeerId() == other.getAuthorityPeerId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasAbilityInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getAbilityInfo().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 11)) + getEntityId())) + 9)) + getAuthorityPeerId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MPLevelEntityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MPLevelEntityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MPLevelEntityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MPLevelEntityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MPLevelEntityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MPLevelEntityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MPLevelEntityInfo parseFrom(InputStream input) throws IOException {
            return (MPLevelEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MPLevelEntityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MPLevelEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MPLevelEntityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MPLevelEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MPLevelEntityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MPLevelEntityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MPLevelEntityInfo parseFrom(CodedInputStream input) throws IOException {
            return (MPLevelEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MPLevelEntityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MPLevelEntityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MPLevelEntityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MPLevelEntityInfoOuterClass$MPLevelEntityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MPLevelEntityInfoOrBuilder {
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> abilityInfoBuilder_;
            private int entityId_;
            private int authorityPeerId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MPLevelEntityInfoOuterClass.internal_static_MPLevelEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MPLevelEntityInfoOuterClass.internal_static_MPLevelEntityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MPLevelEntityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MPLevelEntityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = null;
                } else {
                    this.abilityInfo_ = null;
                    this.abilityInfoBuilder_ = null;
                }
                this.entityId_ = 0;
                this.authorityPeerId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MPLevelEntityInfoOuterClass.internal_static_MPLevelEntityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MPLevelEntityInfo getDefaultInstanceForType() {
                return MPLevelEntityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MPLevelEntityInfo build() {
                MPLevelEntityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MPLevelEntityInfo buildPartial() {
                MPLevelEntityInfo result = new MPLevelEntityInfo(this);
                if (this.abilityInfoBuilder_ == null) {
                    result.abilityInfo_ = this.abilityInfo_;
                } else {
                    result.abilityInfo_ = this.abilityInfoBuilder_.build();
                }
                result.entityId_ = this.entityId_;
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
                if (other instanceof MPLevelEntityInfo) {
                    return mergeFrom((MPLevelEntityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MPLevelEntityInfo other) {
                if (other == MPLevelEntityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAbilityInfo()) {
                    mergeAbilityInfo(other.getAbilityInfo());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                MPLevelEntityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MPLevelEntityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MPLevelEntityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
            public boolean hasAbilityInfo() {
                return (this.abilityInfoBuilder_ == null && this.abilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass.MPLevelEntityInfoOrBuilder
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

        public static MPLevelEntityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MPLevelEntityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MPLevelEntityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MPLevelEntityInfo getDefaultInstanceForType() {
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
