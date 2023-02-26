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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerGlobalValueChangeNotifyOuterClass.class */
public final class ServerGlobalValueChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#ServerGlobalValueChangeNotify.proto\"Q\n\u001dServerGlobalValueChangeNotify\u0012\r\n\u0005value\u0018\n \u0001(\u0002\u0012\u000f\n\u0007keyHash\u0018\u0006 \u0001(\r\u0012\u0010\n\bentityId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ServerGlobalValueChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ServerGlobalValueChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ServerGlobalValueChangeNotify_descriptor, new String[]{"Value", "KeyHash", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerGlobalValueChangeNotifyOuterClass$ServerGlobalValueChangeNotifyOrBuilder.class */
    public interface ServerGlobalValueChangeNotifyOrBuilder extends MessageOrBuilder {
        float getValue();

        int getKeyHash();

        int getEntityId();
    }

    private ServerGlobalValueChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerGlobalValueChangeNotifyOuterClass$ServerGlobalValueChangeNotify.class */
    public static final class ServerGlobalValueChangeNotify extends GeneratedMessageV3 implements ServerGlobalValueChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VALUE_FIELD_NUMBER = 10;
        private float value_;
        public static final int KEYHASH_FIELD_NUMBER = 6;
        private int keyHash_;
        public static final int ENTITYID_FIELD_NUMBER = 11;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final ServerGlobalValueChangeNotify DEFAULT_INSTANCE = new ServerGlobalValueChangeNotify();
        private static final Parser<ServerGlobalValueChangeNotify> PARSER = new AbstractParser<ServerGlobalValueChangeNotify>() { // from class: emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotify.1
            @Override // com.google.protobuf.Parser
            public ServerGlobalValueChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ServerGlobalValueChangeNotify(input, extensionRegistry);
            }
        };

        private ServerGlobalValueChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ServerGlobalValueChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ServerGlobalValueChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ServerGlobalValueChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.keyHash_ = input.readUInt32();
                                    break;
                                case 85:
                                    this.value_ = input.readFloat();
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
            return ServerGlobalValueChangeNotifyOuterClass.internal_static_ServerGlobalValueChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServerGlobalValueChangeNotifyOuterClass.internal_static_ServerGlobalValueChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerGlobalValueChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotifyOrBuilder
        public float getValue() {
            return this.value_;
        }

        @Override // emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotifyOrBuilder
        public int getKeyHash() {
            return this.keyHash_;
        }

        @Override // emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
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
            if (this.keyHash_ != 0) {
                output.writeUInt32(6, this.keyHash_);
            }
            if (this.value_ != 0.0f) {
                output.writeFloat(10, this.value_);
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
            if (this.keyHash_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.keyHash_);
            }
            if (this.value_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(10, this.value_);
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
            if (!(obj instanceof ServerGlobalValueChangeNotify)) {
                return equals(obj);
            }
            ServerGlobalValueChangeNotify other = (ServerGlobalValueChangeNotify) obj;
            return Float.floatToIntBits(getValue()) == Float.floatToIntBits(other.getValue()) && getKeyHash() == other.getKeyHash() && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Float.floatToIntBits(getValue()))) + 6)) + getKeyHash())) + 11)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ServerGlobalValueChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerGlobalValueChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerGlobalValueChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerGlobalValueChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerGlobalValueChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerGlobalValueChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerGlobalValueChangeNotify parseFrom(InputStream input) throws IOException {
            return (ServerGlobalValueChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerGlobalValueChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerGlobalValueChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerGlobalValueChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerGlobalValueChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ServerGlobalValueChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerGlobalValueChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerGlobalValueChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (ServerGlobalValueChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerGlobalValueChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerGlobalValueChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServerGlobalValueChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerGlobalValueChangeNotifyOuterClass$ServerGlobalValueChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServerGlobalValueChangeNotifyOrBuilder {
            private float value_;
            private int keyHash_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ServerGlobalValueChangeNotifyOuterClass.internal_static_ServerGlobalValueChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ServerGlobalValueChangeNotifyOuterClass.internal_static_ServerGlobalValueChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerGlobalValueChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ServerGlobalValueChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.value_ = 0.0f;
                this.keyHash_ = 0;
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServerGlobalValueChangeNotifyOuterClass.internal_static_ServerGlobalValueChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServerGlobalValueChangeNotify getDefaultInstanceForType() {
                return ServerGlobalValueChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerGlobalValueChangeNotify build() {
                ServerGlobalValueChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerGlobalValueChangeNotify buildPartial() {
                ServerGlobalValueChangeNotify result = new ServerGlobalValueChangeNotify(this);
                result.value_ = this.value_;
                result.keyHash_ = this.keyHash_;
                result.entityId_ = this.entityId_;
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
                if (other instanceof ServerGlobalValueChangeNotify) {
                    return mergeFrom((ServerGlobalValueChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServerGlobalValueChangeNotify other) {
                if (other == ServerGlobalValueChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getValue() != 0.0f) {
                    setValue(other.getValue());
                }
                if (other.getKeyHash() != 0) {
                    setKeyHash(other.getKeyHash());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                ServerGlobalValueChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ServerGlobalValueChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ServerGlobalValueChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotifyOrBuilder
            public float getValue() {
                return this.value_;
            }

            public Builder setValue(float value) {
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.value_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotifyOrBuilder
            public int getKeyHash() {
                return this.keyHash_;
            }

            public Builder setKeyHash(int value) {
                this.keyHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearKeyHash() {
                this.keyHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ServerGlobalValueChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServerGlobalValueChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ServerGlobalValueChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServerGlobalValueChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
