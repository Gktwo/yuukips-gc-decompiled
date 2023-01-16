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
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.ForwardTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtEntityRenderersChangedNotifyOuterClass.class */
public final class EvtEntityRenderersChangedNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%EvtEntityRenderersChangedNotify.proto\u001a\u001fEntityRendererChangedInfo.proto\u001a\u0011ForwardType.proto\"¬\u0001\n\u001fEvtEntityRenderersChangedNotify\u0012\"\n\fforward_type\u0018\u0005 \u0001(\u000e2\f.ForwardType\u0012\u0011\n\tentity_id\u0018\u0001 \u0001(\r\u0012\u0017\n\u000fis_server_cache\u0018\u0003 \u0001(\b\u00129\n\u0015renderer_changed_info\u0018\u000f \u0001(\u000b2\u001a.EntityRendererChangedInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EntityRendererChangedInfoOuterClass.getDescriptor(), ForwardTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtEntityRenderersChangedNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_EvtEntityRenderersChangedNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f706xc5663908 = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtEntityRenderersChangedNotify_descriptor, new String[]{"ForwardType", "EntityId", "IsServerCache", "RendererChangedInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtEntityRenderersChangedNotifyOuterClass$EvtEntityRenderersChangedNotifyOrBuilder.class */
    public interface EvtEntityRenderersChangedNotifyOrBuilder extends MessageOrBuilder {
        int getForwardTypeValue();

        ForwardTypeOuterClass.ForwardType getForwardType();

        int getEntityId();

        boolean getIsServerCache();

        boolean hasRendererChangedInfo();

        EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo();

        EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder();
    }

    private EvtEntityRenderersChangedNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtEntityRenderersChangedNotifyOuterClass$EvtEntityRenderersChangedNotify.class */
    public static final class EvtEntityRenderersChangedNotify extends GeneratedMessageV3 implements EvtEntityRenderersChangedNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FORWARD_TYPE_FIELD_NUMBER = 5;
        private int forwardType_;
        public static final int ENTITY_ID_FIELD_NUMBER = 1;
        private int entityId_;
        public static final int IS_SERVER_CACHE_FIELD_NUMBER = 3;
        private boolean isServerCache_;
        public static final int RENDERER_CHANGED_INFO_FIELD_NUMBER = 15;
        private EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo rendererChangedInfo_;
        private byte memoizedIsInitialized;
        private static final EvtEntityRenderersChangedNotify DEFAULT_INSTANCE = new EvtEntityRenderersChangedNotify();
        private static final Parser<EvtEntityRenderersChangedNotify> PARSER = new AbstractParser<EvtEntityRenderersChangedNotify>() { // from class: emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotify.1
            @Override // com.google.protobuf.Parser
            public EvtEntityRenderersChangedNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtEntityRenderersChangedNotify(input, extensionRegistry);
            }
        };

        private EvtEntityRenderersChangedNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtEntityRenderersChangedNotify() {
            this.memoizedIsInitialized = -1;
            this.forwardType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtEntityRenderersChangedNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtEntityRenderersChangedNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.isServerCache_ = input.readBool();
                                break;
                            case 40:
                                this.forwardType_ = input.readEnum();
                                break;
                            case 122:
                                EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder subBuilder = this.rendererChangedInfo_ != null ? this.rendererChangedInfo_.toBuilder() : null;
                                this.rendererChangedInfo_ = (EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo) input.readMessage(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.rendererChangedInfo_);
                                    this.rendererChangedInfo_ = subBuilder.buildPartial();
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
            return EvtEntityRenderersChangedNotifyOuterClass.internal_static_EvtEntityRenderersChangedNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtEntityRenderersChangedNotifyOuterClass.f706xc5663908.ensureFieldAccessorsInitialized(EvtEntityRenderersChangedNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public int getForwardTypeValue() {
            return this.forwardType_;
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public ForwardTypeOuterClass.ForwardType getForwardType() {
            ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
            return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public boolean getIsServerCache() {
            return this.isServerCache_;
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public boolean hasRendererChangedInfo() {
            return this.rendererChangedInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo() {
            return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
        }

        @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
        public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder() {
            return getRendererChangedInfo();
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
            if (this.isServerCache_) {
                output.writeBool(3, this.isServerCache_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                output.writeEnum(5, this.forwardType_);
            }
            if (this.rendererChangedInfo_ != null) {
                output.writeMessage(15, getRendererChangedInfo());
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
            if (this.isServerCache_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isServerCache_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.forwardType_);
            }
            if (this.rendererChangedInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getRendererChangedInfo());
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
            if (!(obj instanceof EvtEntityRenderersChangedNotify)) {
                return equals(obj);
            }
            EvtEntityRenderersChangedNotify other = (EvtEntityRenderersChangedNotify) obj;
            if (this.forwardType_ == other.forwardType_ && getEntityId() == other.getEntityId() && getIsServerCache() == other.getIsServerCache() && hasRendererChangedInfo() == other.hasRendererChangedInfo()) {
                return (!hasRendererChangedInfo() || getRendererChangedInfo().equals(other.getRendererChangedInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + this.forwardType_)) + 1)) + getEntityId())) + 3)) + Internal.hashBoolean(getIsServerCache());
            if (hasRendererChangedInfo()) {
                hash = (53 * ((37 * hash) + 15)) + getRendererChangedInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtEntityRenderersChangedNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(InputStream input) throws IOException {
            return (EvtEntityRenderersChangedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtEntityRenderersChangedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtEntityRenderersChangedNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtEntityRenderersChangedNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtEntityRenderersChangedNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtEntityRenderersChangedNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(CodedInputStream input) throws IOException {
            return (EvtEntityRenderersChangedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtEntityRenderersChangedNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtEntityRenderersChangedNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtEntityRenderersChangedNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtEntityRenderersChangedNotifyOuterClass$EvtEntityRenderersChangedNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtEntityRenderersChangedNotifyOrBuilder {
            private int forwardType_ = 0;
            private int entityId_;
            private boolean isServerCache_;
            private EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo rendererChangedInfo_;
            private SingleFieldBuilderV3<EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder> rendererChangedInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtEntityRenderersChangedNotifyOuterClass.internal_static_EvtEntityRenderersChangedNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtEntityRenderersChangedNotifyOuterClass.f706xc5663908.ensureFieldAccessorsInitialized(EvtEntityRenderersChangedNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtEntityRenderersChangedNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.forwardType_ = 0;
                this.entityId_ = 0;
                this.isServerCache_ = false;
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = null;
                } else {
                    this.rendererChangedInfo_ = null;
                    this.rendererChangedInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtEntityRenderersChangedNotifyOuterClass.internal_static_EvtEntityRenderersChangedNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtEntityRenderersChangedNotify getDefaultInstanceForType() {
                return EvtEntityRenderersChangedNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtEntityRenderersChangedNotify build() {
                EvtEntityRenderersChangedNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtEntityRenderersChangedNotify buildPartial() {
                EvtEntityRenderersChangedNotify result = new EvtEntityRenderersChangedNotify(this);
                result.forwardType_ = this.forwardType_;
                result.entityId_ = this.entityId_;
                result.isServerCache_ = this.isServerCache_;
                if (this.rendererChangedInfoBuilder_ == null) {
                    result.rendererChangedInfo_ = this.rendererChangedInfo_;
                } else {
                    result.rendererChangedInfo_ = this.rendererChangedInfoBuilder_.build();
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
                if (other instanceof EvtEntityRenderersChangedNotify) {
                    return mergeFrom((EvtEntityRenderersChangedNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtEntityRenderersChangedNotify other) {
                if (other == EvtEntityRenderersChangedNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.forwardType_ != 0) {
                    setForwardTypeValue(other.getForwardTypeValue());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getIsServerCache()) {
                    setIsServerCache(other.getIsServerCache());
                }
                if (other.hasRendererChangedInfo()) {
                    mergeRendererChangedInfo(other.getRendererChangedInfo());
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
                EvtEntityRenderersChangedNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtEntityRenderersChangedNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtEntityRenderersChangedNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
            public int getForwardTypeValue() {
                return this.forwardType_;
            }

            public Builder setForwardTypeValue(int value) {
                this.forwardType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
            public ForwardTypeOuterClass.ForwardType getForwardType() {
                ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
                return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
            }

            public Builder setForwardType(ForwardTypeOuterClass.ForwardType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.forwardType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearForwardType() {
                this.forwardType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
            public boolean getIsServerCache() {
                return this.isServerCache_;
            }

            public Builder setIsServerCache(boolean value) {
                this.isServerCache_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsServerCache() {
                this.isServerCache_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
            public boolean hasRendererChangedInfo() {
                return (this.rendererChangedInfoBuilder_ == null && this.rendererChangedInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
            public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo() {
                if (this.rendererChangedInfoBuilder_ == null) {
                    return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
                }
                return this.rendererChangedInfoBuilder_.getMessage();
            }

            public Builder setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo value) {
                if (this.rendererChangedInfoBuilder_ != null) {
                    this.rendererChangedInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rendererChangedInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder builderForValue) {
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rendererChangedInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo value) {
                if (this.rendererChangedInfoBuilder_ == null) {
                    if (this.rendererChangedInfo_ != null) {
                        this.rendererChangedInfo_ = EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder(this.rendererChangedInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.rendererChangedInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.rendererChangedInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRendererChangedInfo() {
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = null;
                    onChanged();
                } else {
                    this.rendererChangedInfo_ = null;
                    this.rendererChangedInfoBuilder_ = null;
                }
                return this;
            }

            public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder getRendererChangedInfoBuilder() {
                onChanged();
                return getRendererChangedInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotifyOrBuilder
            public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder() {
                if (this.rendererChangedInfoBuilder_ != null) {
                    return this.rendererChangedInfoBuilder_.getMessageOrBuilder();
                }
                return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
            }

            private SingleFieldBuilderV3<EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder> getRendererChangedInfoFieldBuilder() {
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfoBuilder_ = new SingleFieldBuilderV3<>(getRendererChangedInfo(), getParentForChildren(), isClean());
                    this.rendererChangedInfo_ = null;
                }
                return this.rendererChangedInfoBuilder_;
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

        public static EvtEntityRenderersChangedNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtEntityRenderersChangedNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtEntityRenderersChangedNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtEntityRenderersChangedNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EntityRendererChangedInfoOuterClass.getDescriptor();
        ForwardTypeOuterClass.getDescriptor();
    }
}
