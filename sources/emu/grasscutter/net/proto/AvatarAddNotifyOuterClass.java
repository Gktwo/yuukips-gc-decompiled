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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AvatarInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarAddNotifyOuterClass.class */
public final class AvatarAddNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015AvatarAddNotify.proto\u001a\u0010AvatarInfo.proto\"B\n\u000fAvatarAddNotify\u0012\u001b\n\u0006avatar\u0018\u0001 \u0001(\u000b2\u000b.AvatarInfo\u0012\u0012\n\nis_in_team\u0018\u000f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AvatarInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarAddNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarAddNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarAddNotify_descriptor, new String[]{"Avatar", "IsInTeam"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarAddNotifyOuterClass$AvatarAddNotifyOrBuilder.class */
    public interface AvatarAddNotifyOrBuilder extends MessageOrBuilder {
        boolean hasAvatar();

        AvatarInfoOuterClass.AvatarInfo getAvatar();

        AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarOrBuilder();

        boolean getIsInTeam();
    }

    private AvatarAddNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarAddNotifyOuterClass$AvatarAddNotify.class */
    public static final class AvatarAddNotify extends GeneratedMessageV3 implements AvatarAddNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATAR_FIELD_NUMBER = 1;
        private AvatarInfoOuterClass.AvatarInfo avatar_;
        public static final int IS_IN_TEAM_FIELD_NUMBER = 15;
        private boolean isInTeam_;
        private byte memoizedIsInitialized;
        private static final AvatarAddNotify DEFAULT_INSTANCE = new AvatarAddNotify();
        private static final Parser<AvatarAddNotify> PARSER = new AbstractParser<AvatarAddNotify>() { // from class: emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarAddNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarAddNotify(input, extensionRegistry);
            }
        };

        private AvatarAddNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarAddNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarAddNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarAddNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    AvatarInfoOuterClass.AvatarInfo.Builder subBuilder = this.avatar_ != null ? this.avatar_.toBuilder() : null;
                                    this.avatar_ = (AvatarInfoOuterClass.AvatarInfo) input.readMessage(AvatarInfoOuterClass.AvatarInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.avatar_);
                                        this.avatar_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 120:
                                    this.isInTeam_ = input.readBool();
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
                        }
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
            return AvatarAddNotifyOuterClass.internal_static_AvatarAddNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarAddNotifyOuterClass.internal_static_AvatarAddNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarAddNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
        public boolean hasAvatar() {
            return this.avatar_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
        public AvatarInfoOuterClass.AvatarInfo getAvatar() {
            return this.avatar_ == null ? AvatarInfoOuterClass.AvatarInfo.getDefaultInstance() : this.avatar_;
        }

        @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
        public AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarOrBuilder() {
            return getAvatar();
        }

        @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
        public boolean getIsInTeam() {
            return this.isInTeam_;
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
            if (this.avatar_ != null) {
                output.writeMessage(1, getAvatar());
            }
            if (this.isInTeam_) {
                output.writeBool(15, this.isInTeam_);
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
            if (this.avatar_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getAvatar());
            }
            if (this.isInTeam_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isInTeam_);
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
            if (!(obj instanceof AvatarAddNotify)) {
                return equals(obj);
            }
            AvatarAddNotify other = (AvatarAddNotify) obj;
            if (hasAvatar() != other.hasAvatar()) {
                return false;
            }
            return (!hasAvatar() || getAvatar().equals(other.getAvatar())) && getIsInTeam() == other.getIsInTeam() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasAvatar()) {
                hash = (53 * ((37 * hash) + 1)) + getAvatar().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + Internal.hashBoolean(getIsInTeam()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarAddNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarAddNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarAddNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarAddNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarAddNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarAddNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarAddNotify parseFrom(InputStream input) throws IOException {
            return (AvatarAddNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarAddNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarAddNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarAddNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarAddNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarAddNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarAddNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarAddNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarAddNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarAddNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarAddNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarAddNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarAddNotifyOuterClass$AvatarAddNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarAddNotifyOrBuilder {
            private AvatarInfoOuterClass.AvatarInfo avatar_;
            private SingleFieldBuilderV3<AvatarInfoOuterClass.AvatarInfo, AvatarInfoOuterClass.AvatarInfo.Builder, AvatarInfoOuterClass.AvatarInfoOrBuilder> avatarBuilder_;
            private boolean isInTeam_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarAddNotifyOuterClass.internal_static_AvatarAddNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarAddNotifyOuterClass.internal_static_AvatarAddNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarAddNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarAddNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarBuilder_ == null) {
                    this.avatar_ = null;
                } else {
                    this.avatar_ = null;
                    this.avatarBuilder_ = null;
                }
                this.isInTeam_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarAddNotifyOuterClass.internal_static_AvatarAddNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarAddNotify getDefaultInstanceForType() {
                return AvatarAddNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarAddNotify build() {
                AvatarAddNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarAddNotify buildPartial() {
                AvatarAddNotify result = new AvatarAddNotify(this);
                if (this.avatarBuilder_ == null) {
                    result.avatar_ = this.avatar_;
                } else {
                    result.avatar_ = this.avatarBuilder_.build();
                }
                result.isInTeam_ = this.isInTeam_;
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
                if (other instanceof AvatarAddNotify) {
                    return mergeFrom((AvatarAddNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarAddNotify other) {
                if (other == AvatarAddNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAvatar()) {
                    mergeAvatar(other.getAvatar());
                }
                if (other.getIsInTeam()) {
                    setIsInTeam(other.getIsInTeam());
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
                AvatarAddNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarAddNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarAddNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
            public boolean hasAvatar() {
                return (this.avatarBuilder_ == null && this.avatar_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
            public AvatarInfoOuterClass.AvatarInfo getAvatar() {
                if (this.avatarBuilder_ == null) {
                    return this.avatar_ == null ? AvatarInfoOuterClass.AvatarInfo.getDefaultInstance() : this.avatar_;
                }
                return this.avatarBuilder_.getMessage();
            }

            public Builder setAvatar(AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarBuilder_ != null) {
                    this.avatarBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.avatar_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAvatar(AvatarInfoOuterClass.AvatarInfo.Builder builderForValue) {
                if (this.avatarBuilder_ == null) {
                    this.avatar_ = builderForValue.build();
                    onChanged();
                } else {
                    this.avatarBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAvatar(AvatarInfoOuterClass.AvatarInfo value) {
                if (this.avatarBuilder_ == null) {
                    if (this.avatar_ != null) {
                        this.avatar_ = AvatarInfoOuterClass.AvatarInfo.newBuilder(this.avatar_).mergeFrom(value).buildPartial();
                    } else {
                        this.avatar_ = value;
                    }
                    onChanged();
                } else {
                    this.avatarBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAvatar() {
                if (this.avatarBuilder_ == null) {
                    this.avatar_ = null;
                    onChanged();
                } else {
                    this.avatar_ = null;
                    this.avatarBuilder_ = null;
                }
                return this;
            }

            public AvatarInfoOuterClass.AvatarInfo.Builder getAvatarBuilder() {
                onChanged();
                return getAvatarFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
            public AvatarInfoOuterClass.AvatarInfoOrBuilder getAvatarOrBuilder() {
                if (this.avatarBuilder_ != null) {
                    return this.avatarBuilder_.getMessageOrBuilder();
                }
                return this.avatar_ == null ? AvatarInfoOuterClass.AvatarInfo.getDefaultInstance() : this.avatar_;
            }

            private SingleFieldBuilderV3<AvatarInfoOuterClass.AvatarInfo, AvatarInfoOuterClass.AvatarInfo.Builder, AvatarInfoOuterClass.AvatarInfoOrBuilder> getAvatarFieldBuilder() {
                if (this.avatarBuilder_ == null) {
                    this.avatarBuilder_ = new SingleFieldBuilderV3<>(getAvatar(), getParentForChildren(), isClean());
                    this.avatar_ = null;
                }
                return this.avatarBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarAddNotifyOuterClass.AvatarAddNotifyOrBuilder
            public boolean getIsInTeam() {
                return this.isInTeam_;
            }

            public Builder setIsInTeam(boolean value) {
                this.isInTeam_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInTeam() {
                this.isInTeam_ = false;
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

        public static AvatarAddNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarAddNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarAddNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarAddNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AvatarInfoOuterClass.getDescriptor();
    }
}
