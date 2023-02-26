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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientLoadingCostumeVerificationNotifyOuterClass.class */
public final class ClientLoadingCostumeVerificationNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n,ClientLoadingCostumeVerificationNotify.proto\"]\n&ClientLoadingCostumeVerificationNotify\u0012\u0012\n\nprefabHash\u0018\u000f \u0001(\u0004\u0012\u0011\n\tcostumeId\u0018\b \u0001(\r\u0012\f\n\u0004guid\u0018\r \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* renamed from: internal_static_ClientLoadingCostumeVerificationNotify_descriptor */
    private static final Descriptors.Descriptor f676xe63bdd6c = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_ClientLoadingCostumeVerificationNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f677x3f5cd7ea = new GeneratedMessageV3.FieldAccessorTable(f676xe63bdd6c, new String[]{"PrefabHash", "CostumeId", "Guid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientLoadingCostumeVerificationNotifyOuterClass$ClientLoadingCostumeVerificationNotifyOrBuilder.class */
    public interface ClientLoadingCostumeVerificationNotifyOrBuilder extends MessageOrBuilder {
        long getPrefabHash();

        int getCostumeId();

        long getGuid();
    }

    private ClientLoadingCostumeVerificationNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientLoadingCostumeVerificationNotifyOuterClass$ClientLoadingCostumeVerificationNotify.class */
    public static final class ClientLoadingCostumeVerificationNotify extends GeneratedMessageV3 implements ClientLoadingCostumeVerificationNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PREFABHASH_FIELD_NUMBER = 15;
        private long prefabHash_;
        public static final int COSTUMEID_FIELD_NUMBER = 8;
        private int costumeId_;
        public static final int GUID_FIELD_NUMBER = 13;
        private long guid_;
        private byte memoizedIsInitialized;
        private static final ClientLoadingCostumeVerificationNotify DEFAULT_INSTANCE = new ClientLoadingCostumeVerificationNotify();
        private static final Parser<ClientLoadingCostumeVerificationNotify> PARSER = new AbstractParser<ClientLoadingCostumeVerificationNotify>() { // from class: emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotify.1
            @Override // com.google.protobuf.Parser
            public ClientLoadingCostumeVerificationNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ClientLoadingCostumeVerificationNotify(input, extensionRegistry);
            }
        };

        private ClientLoadingCostumeVerificationNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ClientLoadingCostumeVerificationNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ClientLoadingCostumeVerificationNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ClientLoadingCostumeVerificationNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.costumeId_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.guid_ = input.readUInt64();
                                    break;
                                case 120:
                                    this.prefabHash_ = input.readUInt64();
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
            return ClientLoadingCostumeVerificationNotifyOuterClass.f676xe63bdd6c;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ClientLoadingCostumeVerificationNotifyOuterClass.f677x3f5cd7ea.ensureFieldAccessorsInitialized(ClientLoadingCostumeVerificationNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotifyOrBuilder
        public long getPrefabHash() {
            return this.prefabHash_;
        }

        @Override // emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotifyOrBuilder
        public int getCostumeId() {
            return this.costumeId_;
        }

        @Override // emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotifyOrBuilder
        public long getGuid() {
            return this.guid_;
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
            if (this.costumeId_ != 0) {
                output.writeUInt32(8, this.costumeId_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(13, this.guid_);
            }
            if (this.prefabHash_ != 0) {
                output.writeUInt64(15, this.prefabHash_);
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
            if (this.costumeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.costumeId_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(13, this.guid_);
            }
            if (this.prefabHash_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(15, this.prefabHash_);
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
            if (!(obj instanceof ClientLoadingCostumeVerificationNotify)) {
                return equals(obj);
            }
            ClientLoadingCostumeVerificationNotify other = (ClientLoadingCostumeVerificationNotify) obj;
            return getPrefabHash() == other.getPrefabHash() && getCostumeId() == other.getCostumeId() && getGuid() == other.getGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + Internal.hashLong(getPrefabHash()))) + 8)) + getCostumeId())) + 13)) + Internal.hashLong(getGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(InputStream input) throws IOException {
            return (ClientLoadingCostumeVerificationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientLoadingCostumeVerificationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientLoadingCostumeVerificationNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ClientLoadingCostumeVerificationNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ClientLoadingCostumeVerificationNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientLoadingCostumeVerificationNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(CodedInputStream input) throws IOException {
            return (ClientLoadingCostumeVerificationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientLoadingCostumeVerificationNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientLoadingCostumeVerificationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientLoadingCostumeVerificationNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientLoadingCostumeVerificationNotifyOuterClass$ClientLoadingCostumeVerificationNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientLoadingCostumeVerificationNotifyOrBuilder {
            private long prefabHash_;
            private int costumeId_;
            private long guid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ClientLoadingCostumeVerificationNotifyOuterClass.f676xe63bdd6c;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ClientLoadingCostumeVerificationNotifyOuterClass.f677x3f5cd7ea.ensureFieldAccessorsInitialized(ClientLoadingCostumeVerificationNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ClientLoadingCostumeVerificationNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.prefabHash_ = 0;
                this.costumeId_ = 0;
                this.guid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ClientLoadingCostumeVerificationNotifyOuterClass.f676xe63bdd6c;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ClientLoadingCostumeVerificationNotify getDefaultInstanceForType() {
                return ClientLoadingCostumeVerificationNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientLoadingCostumeVerificationNotify build() {
                ClientLoadingCostumeVerificationNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientLoadingCostumeVerificationNotify buildPartial() {
                ClientLoadingCostumeVerificationNotify result = new ClientLoadingCostumeVerificationNotify(this);
                result.prefabHash_ = this.prefabHash_;
                result.costumeId_ = this.costumeId_;
                result.guid_ = this.guid_;
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
                if (other instanceof ClientLoadingCostumeVerificationNotify) {
                    return mergeFrom((ClientLoadingCostumeVerificationNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ClientLoadingCostumeVerificationNotify other) {
                if (other == ClientLoadingCostumeVerificationNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getPrefabHash() != 0) {
                    setPrefabHash(other.getPrefabHash());
                }
                if (other.getCostumeId() != 0) {
                    setCostumeId(other.getCostumeId());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
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
                ClientLoadingCostumeVerificationNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ClientLoadingCostumeVerificationNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ClientLoadingCostumeVerificationNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotifyOrBuilder
            public long getPrefabHash() {
                return this.prefabHash_;
            }

            public Builder setPrefabHash(long value) {
                this.prefabHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrefabHash() {
                this.prefabHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotifyOrBuilder
            public int getCostumeId() {
                return this.costumeId_;
            }

            public Builder setCostumeId(int value) {
                this.costumeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostumeId() {
                this.costumeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotifyOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
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

        public static ClientLoadingCostumeVerificationNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientLoadingCostumeVerificationNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ClientLoadingCostumeVerificationNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ClientLoadingCostumeVerificationNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
