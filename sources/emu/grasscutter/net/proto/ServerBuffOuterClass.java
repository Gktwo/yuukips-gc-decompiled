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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffOuterClass.class */
public final class ServerBuffOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010ServerBuff.proto\"\u0001\n\nServerBuff\u0012\u0017\n\u000fserver_buff_uid\u0018\u0001 \u0001(\r\u0012\u0016\n\u000eserver_buff_id\u0018\u0002 \u0001(\r\u0012\u0018\n\u0010server_buff_type\u0018\u0003 \u0001(\r\u0012\u001d\n\u0015instanced_modifier_id\u0018\u0004 \u0001(\r\u0012\u0019\n\u0011is_modifier_added\u0018\u0005 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ServerBuff_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ServerBuff_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ServerBuff_descriptor, new String[]{"ServerBuffUid", "ServerBuffId", "ServerBuffType", "InstancedModifierId", "IsModifierAdded"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffOuterClass$ServerBuffOrBuilder.class */
    public interface ServerBuffOrBuilder extends MessageOrBuilder {
        int getServerBuffUid();

        int getServerBuffId();

        int getServerBuffType();

        int getInstancedModifierId();

        boolean getIsModifierAdded();
    }

    private ServerBuffOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffOuterClass$ServerBuff.class */
    public static final class ServerBuff extends GeneratedMessageV3 implements ServerBuffOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SERVER_BUFF_UID_FIELD_NUMBER = 1;
        private int serverBuffUid_;
        public static final int SERVER_BUFF_ID_FIELD_NUMBER = 2;
        private int serverBuffId_;
        public static final int SERVER_BUFF_TYPE_FIELD_NUMBER = 3;
        private int serverBuffType_;
        public static final int INSTANCED_MODIFIER_ID_FIELD_NUMBER = 4;
        private int instancedModifierId_;
        public static final int IS_MODIFIER_ADDED_FIELD_NUMBER = 5;
        private boolean isModifierAdded_;
        private byte memoizedIsInitialized;
        private static final ServerBuff DEFAULT_INSTANCE = new ServerBuff();
        private static final Parser<ServerBuff> PARSER = new AbstractParser<ServerBuff>() { // from class: emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuff.1
            @Override // com.google.protobuf.Parser
            public ServerBuff parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ServerBuff(input, extensionRegistry);
            }
        };

        private ServerBuff(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ServerBuff() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ServerBuff();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ServerBuff(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.serverBuffUid_ = input.readUInt32();
                                break;
                            case 16:
                                this.serverBuffId_ = input.readUInt32();
                                break;
                            case 24:
                                this.serverBuffType_ = input.readUInt32();
                                break;
                            case 32:
                                this.instancedModifierId_ = input.readUInt32();
                                break;
                            case 40:
                                this.isModifierAdded_ = input.readBool();
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
            return ServerBuffOuterClass.internal_static_ServerBuff_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServerBuffOuterClass.internal_static_ServerBuff_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerBuff.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
        public int getServerBuffUid() {
            return this.serverBuffUid_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
        public int getServerBuffId() {
            return this.serverBuffId_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
        public int getServerBuffType() {
            return this.serverBuffType_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
        public int getInstancedModifierId() {
            return this.instancedModifierId_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
        public boolean getIsModifierAdded() {
            return this.isModifierAdded_;
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
            if (this.serverBuffUid_ != 0) {
                output.writeUInt32(1, this.serverBuffUid_);
            }
            if (this.serverBuffId_ != 0) {
                output.writeUInt32(2, this.serverBuffId_);
            }
            if (this.serverBuffType_ != 0) {
                output.writeUInt32(3, this.serverBuffType_);
            }
            if (this.instancedModifierId_ != 0) {
                output.writeUInt32(4, this.instancedModifierId_);
            }
            if (this.isModifierAdded_) {
                output.writeBool(5, this.isModifierAdded_);
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
            if (this.serverBuffUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.serverBuffUid_);
            }
            if (this.serverBuffId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.serverBuffId_);
            }
            if (this.serverBuffType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.serverBuffType_);
            }
            if (this.instancedModifierId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.instancedModifierId_);
            }
            if (this.isModifierAdded_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isModifierAdded_);
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
            if (!(obj instanceof ServerBuff)) {
                return equals(obj);
            }
            ServerBuff other = (ServerBuff) obj;
            return getServerBuffUid() == other.getServerBuffUid() && getServerBuffId() == other.getServerBuffId() && getServerBuffType() == other.getServerBuffType() && getInstancedModifierId() == other.getInstancedModifierId() && getIsModifierAdded() == other.getIsModifierAdded() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getServerBuffUid())) + 2)) + getServerBuffId())) + 3)) + getServerBuffType())) + 4)) + getInstancedModifierId())) + 5)) + Internal.hashBoolean(getIsModifierAdded()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ServerBuff parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerBuff parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerBuff parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerBuff parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerBuff parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerBuff parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerBuff parseFrom(InputStream input) throws IOException {
            return (ServerBuff) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerBuff parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerBuff) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerBuff parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerBuff) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ServerBuff parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerBuff) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerBuff parseFrom(CodedInputStream input) throws IOException {
            return (ServerBuff) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerBuff parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerBuff) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServerBuff prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffOuterClass$ServerBuff$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServerBuffOrBuilder {
            private int serverBuffUid_;
            private int serverBuffId_;
            private int serverBuffType_;
            private int instancedModifierId_;
            private boolean isModifierAdded_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ServerBuffOuterClass.internal_static_ServerBuff_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ServerBuffOuterClass.internal_static_ServerBuff_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerBuff.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ServerBuff.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.serverBuffUid_ = 0;
                this.serverBuffId_ = 0;
                this.serverBuffType_ = 0;
                this.instancedModifierId_ = 0;
                this.isModifierAdded_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServerBuffOuterClass.internal_static_ServerBuff_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServerBuff getDefaultInstanceForType() {
                return ServerBuff.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerBuff build() {
                ServerBuff result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerBuff buildPartial() {
                ServerBuff result = new ServerBuff(this);
                result.serverBuffUid_ = this.serverBuffUid_;
                result.serverBuffId_ = this.serverBuffId_;
                result.serverBuffType_ = this.serverBuffType_;
                result.instancedModifierId_ = this.instancedModifierId_;
                result.isModifierAdded_ = this.isModifierAdded_;
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
                if (other instanceof ServerBuff) {
                    return mergeFrom((ServerBuff) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServerBuff other) {
                if (other == ServerBuff.getDefaultInstance()) {
                    return this;
                }
                if (other.getServerBuffUid() != 0) {
                    setServerBuffUid(other.getServerBuffUid());
                }
                if (other.getServerBuffId() != 0) {
                    setServerBuffId(other.getServerBuffId());
                }
                if (other.getServerBuffType() != 0) {
                    setServerBuffType(other.getServerBuffType());
                }
                if (other.getInstancedModifierId() != 0) {
                    setInstancedModifierId(other.getInstancedModifierId());
                }
                if (other.getIsModifierAdded()) {
                    setIsModifierAdded(other.getIsModifierAdded());
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
                ServerBuff parsedMessage = null;
                try {
                    try {
                        parsedMessage = ServerBuff.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ServerBuff) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
            public int getServerBuffUid() {
                return this.serverBuffUid_;
            }

            public Builder setServerBuffUid(int value) {
                this.serverBuffUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerBuffUid() {
                this.serverBuffUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
            public int getServerBuffId() {
                return this.serverBuffId_;
            }

            public Builder setServerBuffId(int value) {
                this.serverBuffId_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerBuffId() {
                this.serverBuffId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
            public int getServerBuffType() {
                return this.serverBuffType_;
            }

            public Builder setServerBuffType(int value) {
                this.serverBuffType_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerBuffType() {
                this.serverBuffType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
            public int getInstancedModifierId() {
                return this.instancedModifierId_;
            }

            public Builder setInstancedModifierId(int value) {
                this.instancedModifierId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstancedModifierId() {
                this.instancedModifierId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffOuterClass.ServerBuffOrBuilder
            public boolean getIsModifierAdded() {
                return this.isModifierAdded_;
            }

            public Builder setIsModifierAdded(boolean value) {
                this.isModifierAdded_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsModifierAdded() {
                this.isModifierAdded_ = false;
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

        public static ServerBuff getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServerBuff> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ServerBuff> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServerBuff getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
