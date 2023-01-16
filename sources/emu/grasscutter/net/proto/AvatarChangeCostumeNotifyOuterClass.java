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
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeNotifyOuterClass.class */
public final class AvatarChangeCostumeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fAvatarChangeCostumeNotify.proto\u001a\u0015SceneEntityInfo.proto\"B\n\u0019AvatarChangeCostumeNotify\u0012%\n\u000bentity_info\u0018\u000b \u0001(\u000b2\u0010.SceneEntityInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneEntityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarChangeCostumeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarChangeCostumeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarChangeCostumeNotify_descriptor, new String[]{"EntityInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeNotifyOuterClass$AvatarChangeCostumeNotifyOrBuilder.class */
    public interface AvatarChangeCostumeNotifyOrBuilder extends MessageOrBuilder {
        boolean hasEntityInfo();

        SceneEntityInfoOuterClass.SceneEntityInfo getEntityInfo();

        SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getEntityInfoOrBuilder();
    }

    private AvatarChangeCostumeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeNotifyOuterClass$AvatarChangeCostumeNotify.class */
    public static final class AvatarChangeCostumeNotify extends GeneratedMessageV3 implements AvatarChangeCostumeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_INFO_FIELD_NUMBER = 11;
        private SceneEntityInfoOuterClass.SceneEntityInfo entityInfo_;
        private byte memoizedIsInitialized;
        private static final AvatarChangeCostumeNotify DEFAULT_INSTANCE = new AvatarChangeCostumeNotify();
        private static final Parser<AvatarChangeCostumeNotify> PARSER = new AbstractParser<AvatarChangeCostumeNotify>() { // from class: emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarChangeCostumeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarChangeCostumeNotify(input, extensionRegistry);
            }
        };

        private AvatarChangeCostumeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarChangeCostumeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarChangeCostumeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarChangeCostumeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 90:
                                SceneEntityInfoOuterClass.SceneEntityInfo.Builder subBuilder = this.entityInfo_ != null ? this.entityInfo_.toBuilder() : null;
                                this.entityInfo_ = (SceneEntityInfoOuterClass.SceneEntityInfo) input.readMessage(SceneEntityInfoOuterClass.SceneEntityInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.entityInfo_);
                                    this.entityInfo_ = subBuilder.buildPartial();
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
            return AvatarChangeCostumeNotifyOuterClass.internal_static_AvatarChangeCostumeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarChangeCostumeNotifyOuterClass.internal_static_AvatarChangeCostumeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarChangeCostumeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotifyOrBuilder
        public boolean hasEntityInfo() {
            return this.entityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotifyOrBuilder
        public SceneEntityInfoOuterClass.SceneEntityInfo getEntityInfo() {
            return this.entityInfo_ == null ? SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance() : this.entityInfo_;
        }

        @Override // emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotifyOrBuilder
        public SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getEntityInfoOrBuilder() {
            return getEntityInfo();
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
            if (this.entityInfo_ != null) {
                output.writeMessage(11, getEntityInfo());
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
            if (this.entityInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(11, getEntityInfo());
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
            if (!(obj instanceof AvatarChangeCostumeNotify)) {
                return equals(obj);
            }
            AvatarChangeCostumeNotify other = (AvatarChangeCostumeNotify) obj;
            if (hasEntityInfo() != other.hasEntityInfo()) {
                return false;
            }
            return (!hasEntityInfo() || getEntityInfo().equals(other.getEntityInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasEntityInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getEntityInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarChangeCostumeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarChangeCostumeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarChangeCostumeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarChangeCostumeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarChangeCostumeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarChangeCostumeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarChangeCostumeNotify parseFrom(InputStream input) throws IOException {
            return (AvatarChangeCostumeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarChangeCostumeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarChangeCostumeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarChangeCostumeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarChangeCostumeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarChangeCostumeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarChangeCostumeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarChangeCostumeNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarChangeCostumeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarChangeCostumeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarChangeCostumeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarChangeCostumeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarChangeCostumeNotifyOuterClass$AvatarChangeCostumeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarChangeCostumeNotifyOrBuilder {
            private SceneEntityInfoOuterClass.SceneEntityInfo entityInfo_;
            private SingleFieldBuilderV3<SceneEntityInfoOuterClass.SceneEntityInfo, SceneEntityInfoOuterClass.SceneEntityInfo.Builder, SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> entityInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarChangeCostumeNotifyOuterClass.internal_static_AvatarChangeCostumeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarChangeCostumeNotifyOuterClass.internal_static_AvatarChangeCostumeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarChangeCostumeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarChangeCostumeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.entityInfoBuilder_ == null) {
                    this.entityInfo_ = null;
                } else {
                    this.entityInfo_ = null;
                    this.entityInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarChangeCostumeNotifyOuterClass.internal_static_AvatarChangeCostumeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarChangeCostumeNotify getDefaultInstanceForType() {
                return AvatarChangeCostumeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarChangeCostumeNotify build() {
                AvatarChangeCostumeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarChangeCostumeNotify buildPartial() {
                AvatarChangeCostumeNotify result = new AvatarChangeCostumeNotify(this);
                if (this.entityInfoBuilder_ == null) {
                    result.entityInfo_ = this.entityInfo_;
                } else {
                    result.entityInfo_ = this.entityInfoBuilder_.build();
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
                if (other instanceof AvatarChangeCostumeNotify) {
                    return mergeFrom((AvatarChangeCostumeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarChangeCostumeNotify other) {
                if (other == AvatarChangeCostumeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasEntityInfo()) {
                    mergeEntityInfo(other.getEntityInfo());
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
                AvatarChangeCostumeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarChangeCostumeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarChangeCostumeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotifyOrBuilder
            public boolean hasEntityInfo() {
                return (this.entityInfoBuilder_ == null && this.entityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotifyOrBuilder
            public SceneEntityInfoOuterClass.SceneEntityInfo getEntityInfo() {
                if (this.entityInfoBuilder_ == null) {
                    return this.entityInfo_ == null ? SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance() : this.entityInfo_;
                }
                return this.entityInfoBuilder_.getMessage();
            }

            public Builder setEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.entityInfoBuilder_ != null) {
                    this.entityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo.Builder builderForValue) {
                if (this.entityInfoBuilder_ == null) {
                    this.entityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.entityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo value) {
                if (this.entityInfoBuilder_ == null) {
                    if (this.entityInfo_ != null) {
                        this.entityInfo_ = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder(this.entityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.entityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.entityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEntityInfo() {
                if (this.entityInfoBuilder_ == null) {
                    this.entityInfo_ = null;
                    onChanged();
                } else {
                    this.entityInfo_ = null;
                    this.entityInfoBuilder_ = null;
                }
                return this;
            }

            public SceneEntityInfoOuterClass.SceneEntityInfo.Builder getEntityInfoBuilder() {
                onChanged();
                return getEntityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarChangeCostumeNotifyOuterClass.AvatarChangeCostumeNotifyOrBuilder
            public SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder getEntityInfoOrBuilder() {
                if (this.entityInfoBuilder_ != null) {
                    return this.entityInfoBuilder_.getMessageOrBuilder();
                }
                return this.entityInfo_ == null ? SceneEntityInfoOuterClass.SceneEntityInfo.getDefaultInstance() : this.entityInfo_;
            }

            private SingleFieldBuilderV3<SceneEntityInfoOuterClass.SceneEntityInfo, SceneEntityInfoOuterClass.SceneEntityInfo.Builder, SceneEntityInfoOuterClass.SceneEntityInfoOrBuilder> getEntityInfoFieldBuilder() {
                if (this.entityInfoBuilder_ == null) {
                    this.entityInfoBuilder_ = new SingleFieldBuilderV3<>(getEntityInfo(), getParentForChildren(), isClean());
                    this.entityInfo_ = null;
                }
                return this.entityInfoBuilder_;
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

        public static AvatarChangeCostumeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarChangeCostumeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarChangeCostumeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarChangeCostumeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneEntityInfoOuterClass.getDescriptor();
    }
}
