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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateVehicleRspOuterClass.class */
public final class CreateVehicleRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016CreateVehicleRsp.proto\"H\n\u0010CreateVehicleRsp\u0012\u0011\n\tvehicleId\u0018\n \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005\u0012\u0010\n\bentityId\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CreateVehicleRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CreateVehicleRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CreateVehicleRsp_descriptor, new String[]{"VehicleId", "Retcode", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateVehicleRspOuterClass$CreateVehicleRspOrBuilder.class */
    public interface CreateVehicleRspOrBuilder extends MessageOrBuilder {
        int getVehicleId();

        int getRetcode();

        int getEntityId();
    }

    private CreateVehicleRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateVehicleRspOuterClass$CreateVehicleRsp.class */
    public static final class CreateVehicleRsp extends GeneratedMessageV3 implements CreateVehicleRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VEHICLEID_FIELD_NUMBER = 10;
        private int vehicleId_;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        public static final int ENTITYID_FIELD_NUMBER = 13;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final CreateVehicleRsp DEFAULT_INSTANCE = new CreateVehicleRsp();
        private static final Parser<CreateVehicleRsp> PARSER = new AbstractParser<CreateVehicleRsp>() { // from class: emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRsp.1
            @Override // com.google.protobuf.Parser
            public CreateVehicleRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CreateVehicleRsp(input, extensionRegistry);
            }
        };

        private CreateVehicleRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CreateVehicleRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CreateVehicleRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CreateVehicleRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 80:
                                    this.vehicleId_ = input.readUInt32();
                                    break;
                                case 104:
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
            return CreateVehicleRspOuterClass.internal_static_CreateVehicleRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CreateVehicleRspOuterClass.internal_static_CreateVehicleRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(CreateVehicleRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRspOrBuilder
        public int getVehicleId() {
            return this.vehicleId_;
        }

        @Override // emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(3, this.retcode_);
            }
            if (this.vehicleId_ != 0) {
                output.writeUInt32(10, this.vehicleId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(13, this.entityId_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            if (this.vehicleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.vehicleId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.entityId_);
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
            if (!(obj instanceof CreateVehicleRsp)) {
                return equals(obj);
            }
            CreateVehicleRsp other = (CreateVehicleRsp) obj;
            return getVehicleId() == other.getVehicleId() && getRetcode() == other.getRetcode() && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getVehicleId())) + 3)) + getRetcode())) + 13)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CreateVehicleRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateVehicleRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateVehicleRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateVehicleRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateVehicleRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CreateVehicleRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CreateVehicleRsp parseFrom(InputStream input) throws IOException {
            return (CreateVehicleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreateVehicleRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateVehicleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreateVehicleRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (CreateVehicleRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CreateVehicleRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateVehicleRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CreateVehicleRsp parseFrom(CodedInputStream input) throws IOException {
            return (CreateVehicleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CreateVehicleRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CreateVehicleRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CreateVehicleRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CreateVehicleRspOuterClass$CreateVehicleRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CreateVehicleRspOrBuilder {
            private int vehicleId_;
            private int retcode_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CreateVehicleRspOuterClass.internal_static_CreateVehicleRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CreateVehicleRspOuterClass.internal_static_CreateVehicleRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(CreateVehicleRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CreateVehicleRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.vehicleId_ = 0;
                this.retcode_ = 0;
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CreateVehicleRspOuterClass.internal_static_CreateVehicleRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CreateVehicleRsp getDefaultInstanceForType() {
                return CreateVehicleRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreateVehicleRsp build() {
                CreateVehicleRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CreateVehicleRsp buildPartial() {
                CreateVehicleRsp result = new CreateVehicleRsp(this);
                result.vehicleId_ = this.vehicleId_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof CreateVehicleRsp) {
                    return mergeFrom((CreateVehicleRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CreateVehicleRsp other) {
                if (other == CreateVehicleRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getVehicleId() != 0) {
                    setVehicleId(other.getVehicleId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                CreateVehicleRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = CreateVehicleRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CreateVehicleRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRspOrBuilder
            public int getVehicleId() {
                return this.vehicleId_;
            }

            public Builder setVehicleId(int value) {
                this.vehicleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearVehicleId() {
                this.vehicleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CreateVehicleRspOuterClass.CreateVehicleRspOrBuilder
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

        public static CreateVehicleRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CreateVehicleRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CreateVehicleRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CreateVehicleRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
