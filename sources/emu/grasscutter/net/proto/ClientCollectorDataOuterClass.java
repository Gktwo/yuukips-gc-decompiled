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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientCollectorDataOuterClass.class */
public final class ClientCollectorDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ClientCollectorData.proto\"S\n\u0013ClientCollectorData\u0012\u0012\n\nmax_points\u0018\u0002 \u0001(\r\u0012\u0013\n\u000bcurr_points\u0018\u0003 \u0001(\r\u0012\u0013\n\u000bmaterial_id\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ClientCollectorData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ClientCollectorData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ClientCollectorData_descriptor, new String[]{"MaxPoints", "CurrPoints", "MaterialId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientCollectorDataOuterClass$ClientCollectorDataOrBuilder.class */
    public interface ClientCollectorDataOrBuilder extends MessageOrBuilder {
        int getMaxPoints();

        int getCurrPoints();

        int getMaterialId();
    }

    private ClientCollectorDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientCollectorDataOuterClass$ClientCollectorData.class */
    public static final class ClientCollectorData extends GeneratedMessageV3 implements ClientCollectorDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAX_POINTS_FIELD_NUMBER = 2;
        private int maxPoints_;
        public static final int CURR_POINTS_FIELD_NUMBER = 3;
        private int currPoints_;
        public static final int MATERIAL_ID_FIELD_NUMBER = 9;
        private int materialId_;
        private byte memoizedIsInitialized;
        private static final ClientCollectorData DEFAULT_INSTANCE = new ClientCollectorData();
        private static final Parser<ClientCollectorData> PARSER = new AbstractParser<ClientCollectorData>() { // from class: emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorData.1
            @Override // com.google.protobuf.Parser
            public ClientCollectorData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ClientCollectorData(input, extensionRegistry);
            }
        };

        private ClientCollectorData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ClientCollectorData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ClientCollectorData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ClientCollectorData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.maxPoints_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.currPoints_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.materialId_ = input.readUInt32();
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
            return ClientCollectorDataOuterClass.internal_static_ClientCollectorData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ClientCollectorDataOuterClass.internal_static_ClientCollectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientCollectorData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder
        public int getMaxPoints() {
            return this.maxPoints_;
        }

        @Override // emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder
        public int getCurrPoints() {
            return this.currPoints_;
        }

        @Override // emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder
        public int getMaterialId() {
            return this.materialId_;
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
            if (this.maxPoints_ != 0) {
                output.writeUInt32(2, this.maxPoints_);
            }
            if (this.currPoints_ != 0) {
                output.writeUInt32(3, this.currPoints_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(9, this.materialId_);
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
            if (this.maxPoints_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.maxPoints_);
            }
            if (this.currPoints_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.currPoints_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.materialId_);
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
            if (!(obj instanceof ClientCollectorData)) {
                return equals(obj);
            }
            ClientCollectorData other = (ClientCollectorData) obj;
            return getMaxPoints() == other.getMaxPoints() && getCurrPoints() == other.getCurrPoints() && getMaterialId() == other.getMaterialId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getMaxPoints())) + 3)) + getCurrPoints())) + 9)) + getMaterialId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ClientCollectorData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientCollectorData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientCollectorData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientCollectorData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientCollectorData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientCollectorData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientCollectorData parseFrom(InputStream input) throws IOException {
            return (ClientCollectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientCollectorData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientCollectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientCollectorData parseDelimitedFrom(InputStream input) throws IOException {
            return (ClientCollectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ClientCollectorData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientCollectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientCollectorData parseFrom(CodedInputStream input) throws IOException {
            return (ClientCollectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientCollectorData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientCollectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientCollectorData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientCollectorDataOuterClass$ClientCollectorData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientCollectorDataOrBuilder {
            private int maxPoints_;
            private int currPoints_;
            private int materialId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ClientCollectorDataOuterClass.internal_static_ClientCollectorData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ClientCollectorDataOuterClass.internal_static_ClientCollectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientCollectorData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ClientCollectorData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.maxPoints_ = 0;
                this.currPoints_ = 0;
                this.materialId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ClientCollectorDataOuterClass.internal_static_ClientCollectorData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ClientCollectorData getDefaultInstanceForType() {
                return ClientCollectorData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientCollectorData build() {
                ClientCollectorData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientCollectorData buildPartial() {
                ClientCollectorData result = new ClientCollectorData(this);
                result.maxPoints_ = this.maxPoints_;
                result.currPoints_ = this.currPoints_;
                result.materialId_ = this.materialId_;
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
                if (other instanceof ClientCollectorData) {
                    return mergeFrom((ClientCollectorData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ClientCollectorData other) {
                if (other == ClientCollectorData.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaxPoints() != 0) {
                    setMaxPoints(other.getMaxPoints());
                }
                if (other.getCurrPoints() != 0) {
                    setCurrPoints(other.getCurrPoints());
                }
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
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
                ClientCollectorData parsedMessage = null;
                try {
                    try {
                        parsedMessage = ClientCollectorData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ClientCollectorData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder
            public int getMaxPoints() {
                return this.maxPoints_;
            }

            public Builder setMaxPoints(int value) {
                this.maxPoints_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxPoints() {
                this.maxPoints_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder
            public int getCurrPoints() {
                return this.currPoints_;
            }

            public Builder setCurrPoints(int value) {
                this.currPoints_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrPoints() {
                this.currPoints_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ClientCollectorDataOuterClass.ClientCollectorDataOrBuilder
            public int getMaterialId() {
                return this.materialId_;
            }

            public Builder setMaterialId(int value) {
                this.materialId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaterialId() {
                this.materialId_ = 0;
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

        public static ClientCollectorData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientCollectorData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ClientCollectorData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ClientCollectorData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
