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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAIStateNotifyOuterClass.class */
public final class ClientAIStateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ClientAIStateNotify.proto\":\n\u0013ClientAIStateNotify\u0012\u0010\n\bentityId\u0018\u0006 \u0001(\r\u0012\u0011\n\tcurTactic\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ClientAIStateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ClientAIStateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ClientAIStateNotify_descriptor, new String[]{"EntityId", "CurTactic"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAIStateNotifyOuterClass$ClientAIStateNotifyOrBuilder.class */
    public interface ClientAIStateNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getCurTactic();
    }

    private ClientAIStateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAIStateNotifyOuterClass$ClientAIStateNotify.class */
    public static final class ClientAIStateNotify extends GeneratedMessageV3 implements ClientAIStateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 6;
        private int entityId_;
        public static final int CURTACTIC_FIELD_NUMBER = 10;
        private int curTactic_;
        private byte memoizedIsInitialized;
        private static final ClientAIStateNotify DEFAULT_INSTANCE = new ClientAIStateNotify();
        private static final Parser<ClientAIStateNotify> PARSER = new AbstractParser<ClientAIStateNotify>() { // from class: emu.grasscutter.net.proto.ClientAIStateNotifyOuterClass.ClientAIStateNotify.1
            @Override // com.google.protobuf.Parser
            public ClientAIStateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ClientAIStateNotify(input, extensionRegistry);
            }
        };

        private ClientAIStateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ClientAIStateNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ClientAIStateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ClientAIStateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 80:
                                this.curTactic_ = input.readUInt32();
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
            return ClientAIStateNotifyOuterClass.internal_static_ClientAIStateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ClientAIStateNotifyOuterClass.internal_static_ClientAIStateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientAIStateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ClientAIStateNotifyOuterClass.ClientAIStateNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.ClientAIStateNotifyOuterClass.ClientAIStateNotifyOrBuilder
        public int getCurTactic() {
            return this.curTactic_;
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
                output.writeUInt32(6, this.entityId_);
            }
            if (this.curTactic_ != 0) {
                output.writeUInt32(10, this.curTactic_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.entityId_);
            }
            if (this.curTactic_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.curTactic_);
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
            if (!(obj instanceof ClientAIStateNotify)) {
                return equals(obj);
            }
            ClientAIStateNotify other = (ClientAIStateNotify) obj;
            return getEntityId() == other.getEntityId() && getCurTactic() == other.getCurTactic() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getEntityId())) + 10)) + getCurTactic())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ClientAIStateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientAIStateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientAIStateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientAIStateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientAIStateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientAIStateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientAIStateNotify parseFrom(InputStream input) throws IOException {
            return (ClientAIStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientAIStateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientAIStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientAIStateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ClientAIStateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ClientAIStateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientAIStateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientAIStateNotify parseFrom(CodedInputStream input) throws IOException {
            return (ClientAIStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientAIStateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientAIStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientAIStateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAIStateNotifyOuterClass$ClientAIStateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientAIStateNotifyOrBuilder {
            private int entityId_;
            private int curTactic_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ClientAIStateNotifyOuterClass.internal_static_ClientAIStateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ClientAIStateNotifyOuterClass.internal_static_ClientAIStateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientAIStateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ClientAIStateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.curTactic_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ClientAIStateNotifyOuterClass.internal_static_ClientAIStateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ClientAIStateNotify getDefaultInstanceForType() {
                return ClientAIStateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientAIStateNotify build() {
                ClientAIStateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientAIStateNotify buildPartial() {
                ClientAIStateNotify result = new ClientAIStateNotify(this);
                result.entityId_ = this.entityId_;
                result.curTactic_ = this.curTactic_;
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
                if (other instanceof ClientAIStateNotify) {
                    return mergeFrom((ClientAIStateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ClientAIStateNotify other) {
                if (other == ClientAIStateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getCurTactic() != 0) {
                    setCurTactic(other.getCurTactic());
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
                ClientAIStateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ClientAIStateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ClientAIStateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientAIStateNotifyOuterClass.ClientAIStateNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.ClientAIStateNotifyOuterClass.ClientAIStateNotifyOrBuilder
            public int getCurTactic() {
                return this.curTactic_;
            }

            public Builder setCurTactic(int value) {
                this.curTactic_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurTactic() {
                this.curTactic_ = 0;
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

        public static ClientAIStateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientAIStateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ClientAIStateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ClientAIStateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
