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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterScenePeerNotifyOuterClass.class */
public final class EnterScenePeerNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aEnterScenePeerNotify.proto\"o\n\u0014EnterScenePeerNotify\u0012\u0019\n\u0011enter_scene_token\u0018\u0007 \u0001(\r\u0012\u0014\n\fhost_peer_id\u0018\f \u0001(\r\u0012\u000f\n\u0007peer_id\u0018\u000e \u0001(\r\u0012\u0015\n\rdest_scene_id\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EnterScenePeerNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EnterScenePeerNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EnterScenePeerNotify_descriptor, new String[]{"EnterSceneToken", "HostPeerId", "PeerId", "DestSceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterScenePeerNotifyOuterClass$EnterScenePeerNotifyOrBuilder.class */
    public interface EnterScenePeerNotifyOrBuilder extends MessageOrBuilder {
        int getEnterSceneToken();

        int getHostPeerId();

        int getPeerId();

        int getDestSceneId();
    }

    private EnterScenePeerNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterScenePeerNotifyOuterClass$EnterScenePeerNotify.class */
    public static final class EnterScenePeerNotify extends GeneratedMessageV3 implements EnterScenePeerNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTER_SCENE_TOKEN_FIELD_NUMBER = 7;
        private int enterSceneToken_;
        public static final int HOST_PEER_ID_FIELD_NUMBER = 12;
        private int hostPeerId_;
        public static final int PEER_ID_FIELD_NUMBER = 14;
        private int peerId_;
        public static final int DEST_SCENE_ID_FIELD_NUMBER = 2;
        private int destSceneId_;
        private byte memoizedIsInitialized;
        private static final EnterScenePeerNotify DEFAULT_INSTANCE = new EnterScenePeerNotify();
        private static final Parser<EnterScenePeerNotify> PARSER = new AbstractParser<EnterScenePeerNotify>() { // from class: emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotify.1
            @Override // com.google.protobuf.Parser
            public EnterScenePeerNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EnterScenePeerNotify(input, extensionRegistry);
            }
        };

        private EnterScenePeerNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EnterScenePeerNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EnterScenePeerNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EnterScenePeerNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.destSceneId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.enterSceneToken_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.hostPeerId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.peerId_ = input.readUInt32();
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
            return EnterScenePeerNotifyOuterClass.internal_static_EnterScenePeerNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EnterScenePeerNotifyOuterClass.internal_static_EnterScenePeerNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterScenePeerNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
        public int getEnterSceneToken() {
            return this.enterSceneToken_;
        }

        @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
        public int getHostPeerId() {
            return this.hostPeerId_;
        }

        @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
        public int getDestSceneId() {
            return this.destSceneId_;
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
            if (this.destSceneId_ != 0) {
                output.writeUInt32(2, this.destSceneId_);
            }
            if (this.enterSceneToken_ != 0) {
                output.writeUInt32(7, this.enterSceneToken_);
            }
            if (this.hostPeerId_ != 0) {
                output.writeUInt32(12, this.hostPeerId_);
            }
            if (this.peerId_ != 0) {
                output.writeUInt32(14, this.peerId_);
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
            if (this.destSceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.destSceneId_);
            }
            if (this.enterSceneToken_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.enterSceneToken_);
            }
            if (this.hostPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.hostPeerId_);
            }
            if (this.peerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.peerId_);
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
            if (!(obj instanceof EnterScenePeerNotify)) {
                return equals(obj);
            }
            EnterScenePeerNotify other = (EnterScenePeerNotify) obj;
            return getEnterSceneToken() == other.getEnterSceneToken() && getHostPeerId() == other.getHostPeerId() && getPeerId() == other.getPeerId() && getDestSceneId() == other.getDestSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getEnterSceneToken())) + 12)) + getHostPeerId())) + 14)) + getPeerId())) + 2)) + getDestSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EnterScenePeerNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterScenePeerNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterScenePeerNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterScenePeerNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterScenePeerNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EnterScenePeerNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EnterScenePeerNotify parseFrom(InputStream input) throws IOException {
            return (EnterScenePeerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EnterScenePeerNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterScenePeerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EnterScenePeerNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EnterScenePeerNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EnterScenePeerNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterScenePeerNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EnterScenePeerNotify parseFrom(CodedInputStream input) throws IOException {
            return (EnterScenePeerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EnterScenePeerNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EnterScenePeerNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnterScenePeerNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterScenePeerNotifyOuterClass$EnterScenePeerNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnterScenePeerNotifyOrBuilder {
            private int enterSceneToken_;
            private int hostPeerId_;
            private int peerId_;
            private int destSceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EnterScenePeerNotifyOuterClass.internal_static_EnterScenePeerNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EnterScenePeerNotifyOuterClass.internal_static_EnterScenePeerNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EnterScenePeerNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EnterScenePeerNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.enterSceneToken_ = 0;
                this.hostPeerId_ = 0;
                this.peerId_ = 0;
                this.destSceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnterScenePeerNotifyOuterClass.internal_static_EnterScenePeerNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnterScenePeerNotify getDefaultInstanceForType() {
                return EnterScenePeerNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnterScenePeerNotify build() {
                EnterScenePeerNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnterScenePeerNotify buildPartial() {
                EnterScenePeerNotify result = new EnterScenePeerNotify(this);
                result.enterSceneToken_ = this.enterSceneToken_;
                result.hostPeerId_ = this.hostPeerId_;
                result.peerId_ = this.peerId_;
                result.destSceneId_ = this.destSceneId_;
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
                if (other instanceof EnterScenePeerNotify) {
                    return mergeFrom((EnterScenePeerNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnterScenePeerNotify other) {
                if (other == EnterScenePeerNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEnterSceneToken() != 0) {
                    setEnterSceneToken(other.getEnterSceneToken());
                }
                if (other.getHostPeerId() != 0) {
                    setHostPeerId(other.getHostPeerId());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (other.getDestSceneId() != 0) {
                    setDestSceneId(other.getDestSceneId());
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
                EnterScenePeerNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EnterScenePeerNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EnterScenePeerNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
            public int getEnterSceneToken() {
                return this.enterSceneToken_;
            }

            public Builder setEnterSceneToken(int value) {
                this.enterSceneToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnterSceneToken() {
                this.enterSceneToken_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
            public int getHostPeerId() {
                return this.hostPeerId_;
            }

            public Builder setHostPeerId(int value) {
                this.hostPeerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearHostPeerId() {
                this.hostPeerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EnterScenePeerNotifyOuterClass.EnterScenePeerNotifyOrBuilder
            public int getDestSceneId() {
                return this.destSceneId_;
            }

            public Builder setDestSceneId(int value) {
                this.destSceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDestSceneId() {
                this.destSceneId_ = 0;
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

        public static EnterScenePeerNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EnterScenePeerNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EnterScenePeerNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnterScenePeerNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}