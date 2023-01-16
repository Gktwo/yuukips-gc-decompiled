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
import emu.grasscutter.net.proto.PlatformInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformStartRouteNotifyOuterClass.class */
public final class PlatformStartRouteNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001ePlatformStartRouteNotify.proto\u001a\u0012PlatformInfo.proto\"b\n\u0018PlatformStartRouteNotify\u0012\u0011\n\tentity_id\u0018\f \u0001(\r\u0012\u0012\n\nscene_time\u0018\u0007 \u0001(\r\u0012\u001f\n\bplatform\u0018\u0002 \u0001(\u000b2\r.PlatformInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlatformInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlatformStartRouteNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlatformStartRouteNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlatformStartRouteNotify_descriptor, new String[]{"EntityId", "SceneTime", "Platform"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformStartRouteNotifyOuterClass$PlatformStartRouteNotifyOrBuilder.class */
    public interface PlatformStartRouteNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getSceneTime();

        boolean hasPlatform();

        PlatformInfoOuterClass.PlatformInfo getPlatform();

        PlatformInfoOuterClass.PlatformInfoOrBuilder getPlatformOrBuilder();
    }

    private PlatformStartRouteNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformStartRouteNotifyOuterClass$PlatformStartRouteNotify.class */
    public static final class PlatformStartRouteNotify extends GeneratedMessageV3 implements PlatformStartRouteNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 12;
        private int entityId_;
        public static final int SCENE_TIME_FIELD_NUMBER = 7;
        private int sceneTime_;
        public static final int PLATFORM_FIELD_NUMBER = 2;
        private PlatformInfoOuterClass.PlatformInfo platform_;
        private byte memoizedIsInitialized;
        private static final PlatformStartRouteNotify DEFAULT_INSTANCE = new PlatformStartRouteNotify();
        private static final Parser<PlatformStartRouteNotify> PARSER = new AbstractParser<PlatformStartRouteNotify>() { // from class: emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotify.1
            @Override // com.google.protobuf.Parser
            public PlatformStartRouteNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlatformStartRouteNotify(input, extensionRegistry);
            }
        };

        private PlatformStartRouteNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlatformStartRouteNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlatformStartRouteNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PlatformStartRouteNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    PlatformInfoOuterClass.PlatformInfo.Builder subBuilder = this.platform_ != null ? this.platform_.toBuilder() : null;
                                    this.platform_ = (PlatformInfoOuterClass.PlatformInfo) input.readMessage(PlatformInfoOuterClass.PlatformInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.platform_);
                                        this.platform_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 56:
                                    this.sceneTime_ = input.readUInt32();
                                    break;
                                case 96:
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
            return PlatformStartRouteNotifyOuterClass.internal_static_PlatformStartRouteNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlatformStartRouteNotifyOuterClass.internal_static_PlatformStartRouteNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformStartRouteNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
        public int getSceneTime() {
            return this.sceneTime_;
        }

        @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
        public boolean hasPlatform() {
            return this.platform_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
        public PlatformInfoOuterClass.PlatformInfo getPlatform() {
            return this.platform_ == null ? PlatformInfoOuterClass.PlatformInfo.getDefaultInstance() : this.platform_;
        }

        @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
        public PlatformInfoOuterClass.PlatformInfoOrBuilder getPlatformOrBuilder() {
            return getPlatform();
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
            if (this.platform_ != null) {
                output.writeMessage(2, getPlatform());
            }
            if (this.sceneTime_ != 0) {
                output.writeUInt32(7, this.sceneTime_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(12, this.entityId_);
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
            if (this.platform_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getPlatform());
            }
            if (this.sceneTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.sceneTime_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.entityId_);
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
            if (!(obj instanceof PlatformStartRouteNotify)) {
                return equals(obj);
            }
            PlatformStartRouteNotify other = (PlatformStartRouteNotify) obj;
            if (getEntityId() == other.getEntityId() && getSceneTime() == other.getSceneTime() && hasPlatform() == other.hasPlatform()) {
                return (!hasPlatform() || getPlatform().equals(other.getPlatform())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getEntityId())) + 7)) + getSceneTime();
            if (hasPlatform()) {
                hash = (53 * ((37 * hash) + 2)) + getPlatform().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PlatformStartRouteNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlatformStartRouteNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlatformStartRouteNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlatformStartRouteNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlatformStartRouteNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlatformStartRouteNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlatformStartRouteNotify parseFrom(InputStream input) throws IOException {
            return (PlatformStartRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlatformStartRouteNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlatformStartRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlatformStartRouteNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (PlatformStartRouteNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlatformStartRouteNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlatformStartRouteNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlatformStartRouteNotify parseFrom(CodedInputStream input) throws IOException {
            return (PlatformStartRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlatformStartRouteNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlatformStartRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlatformStartRouteNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformStartRouteNotifyOuterClass$PlatformStartRouteNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlatformStartRouteNotifyOrBuilder {
            private int entityId_;
            private int sceneTime_;
            private PlatformInfoOuterClass.PlatformInfo platform_;
            private SingleFieldBuilderV3<PlatformInfoOuterClass.PlatformInfo, PlatformInfoOuterClass.PlatformInfo.Builder, PlatformInfoOuterClass.PlatformInfoOrBuilder> platformBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlatformStartRouteNotifyOuterClass.internal_static_PlatformStartRouteNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlatformStartRouteNotifyOuterClass.internal_static_PlatformStartRouteNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformStartRouteNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlatformStartRouteNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.sceneTime_ = 0;
                if (this.platformBuilder_ == null) {
                    this.platform_ = null;
                } else {
                    this.platform_ = null;
                    this.platformBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlatformStartRouteNotifyOuterClass.internal_static_PlatformStartRouteNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlatformStartRouteNotify getDefaultInstanceForType() {
                return PlatformStartRouteNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlatformStartRouteNotify build() {
                PlatformStartRouteNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlatformStartRouteNotify buildPartial() {
                PlatformStartRouteNotify result = new PlatformStartRouteNotify(this);
                result.entityId_ = this.entityId_;
                result.sceneTime_ = this.sceneTime_;
                if (this.platformBuilder_ == null) {
                    result.platform_ = this.platform_;
                } else {
                    result.platform_ = this.platformBuilder_.build();
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
                if (other instanceof PlatformStartRouteNotify) {
                    return mergeFrom((PlatformStartRouteNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlatformStartRouteNotify other) {
                if (other == PlatformStartRouteNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getSceneTime() != 0) {
                    setSceneTime(other.getSceneTime());
                }
                if (other.hasPlatform()) {
                    mergePlatform(other.getPlatform());
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
                PlatformStartRouteNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlatformStartRouteNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlatformStartRouteNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
            public int getSceneTime() {
                return this.sceneTime_;
            }

            public Builder setSceneTime(int value) {
                this.sceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneTime() {
                this.sceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
            public boolean hasPlatform() {
                return (this.platformBuilder_ == null && this.platform_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
            public PlatformInfoOuterClass.PlatformInfo getPlatform() {
                if (this.platformBuilder_ == null) {
                    return this.platform_ == null ? PlatformInfoOuterClass.PlatformInfo.getDefaultInstance() : this.platform_;
                }
                return this.platformBuilder_.getMessage();
            }

            public Builder setPlatform(PlatformInfoOuterClass.PlatformInfo value) {
                if (this.platformBuilder_ != null) {
                    this.platformBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.platform_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPlatform(PlatformInfoOuterClass.PlatformInfo.Builder builderForValue) {
                if (this.platformBuilder_ == null) {
                    this.platform_ = builderForValue.build();
                    onChanged();
                } else {
                    this.platformBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePlatform(PlatformInfoOuterClass.PlatformInfo value) {
                if (this.platformBuilder_ == null) {
                    if (this.platform_ != null) {
                        this.platform_ = PlatformInfoOuterClass.PlatformInfo.newBuilder(this.platform_).mergeFrom(value).buildPartial();
                    } else {
                        this.platform_ = value;
                    }
                    onChanged();
                } else {
                    this.platformBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPlatform() {
                if (this.platformBuilder_ == null) {
                    this.platform_ = null;
                    onChanged();
                } else {
                    this.platform_ = null;
                    this.platformBuilder_ = null;
                }
                return this;
            }

            public PlatformInfoOuterClass.PlatformInfo.Builder getPlatformBuilder() {
                onChanged();
                return getPlatformFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlatformStartRouteNotifyOuterClass.PlatformStartRouteNotifyOrBuilder
            public PlatformInfoOuterClass.PlatformInfoOrBuilder getPlatformOrBuilder() {
                if (this.platformBuilder_ != null) {
                    return this.platformBuilder_.getMessageOrBuilder();
                }
                return this.platform_ == null ? PlatformInfoOuterClass.PlatformInfo.getDefaultInstance() : this.platform_;
            }

            private SingleFieldBuilderV3<PlatformInfoOuterClass.PlatformInfo, PlatformInfoOuterClass.PlatformInfo.Builder, PlatformInfoOuterClass.PlatformInfoOrBuilder> getPlatformFieldBuilder() {
                if (this.platformBuilder_ == null) {
                    this.platformBuilder_ = new SingleFieldBuilderV3<>(getPlatform(), getParentForChildren(), isClean());
                    this.platform_ = null;
                }
                return this.platformBuilder_;
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

        public static PlatformStartRouteNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlatformStartRouteNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlatformStartRouteNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformStartRouteNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlatformInfoOuterClass.getDescriptor();
    }
}
