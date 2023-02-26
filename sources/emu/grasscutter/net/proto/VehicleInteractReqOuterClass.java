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
import emu.grasscutter.net.proto.VehicleInteractTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractReqOuterClass.class */
public final class VehicleInteractReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018VehicleInteractReq.proto\u001a\u0019VehicleInteractType.proto\"_\n\u0012VehicleInteractReq\u0012\u000b\n\u0003pos\u0018\u000e \u0001(\r\u0012*\n\finteractType\u0018\u000b \u0001(\u000e2\u0014.VehicleInteractType\u0012\u0010\n\bentityId\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VehicleInteractTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VehicleInteractReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VehicleInteractReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VehicleInteractReq_descriptor, new String[]{"Pos", "InteractType", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractReqOuterClass$VehicleInteractReqOrBuilder.class */
    public interface VehicleInteractReqOrBuilder extends MessageOrBuilder {
        int getPos();

        int getInteractTypeValue();

        VehicleInteractTypeOuterClass.VehicleInteractType getInteractType();

        int getEntityId();
    }

    private VehicleInteractReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractReqOuterClass$VehicleInteractReq.class */
    public static final class VehicleInteractReq extends GeneratedMessageV3 implements VehicleInteractReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POS_FIELD_NUMBER = 14;
        private int pos_;
        public static final int INTERACTTYPE_FIELD_NUMBER = 11;
        private int interactType_;
        public static final int ENTITYID_FIELD_NUMBER = 13;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final VehicleInteractReq DEFAULT_INSTANCE = new VehicleInteractReq();
        private static final Parser<VehicleInteractReq> PARSER = new AbstractParser<VehicleInteractReq>() { // from class: emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReq.1
            @Override // com.google.protobuf.Parser
            public VehicleInteractReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VehicleInteractReq(input, extensionRegistry);
            }
        };

        private VehicleInteractReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VehicleInteractReq() {
            this.memoizedIsInitialized = -1;
            this.interactType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VehicleInteractReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VehicleInteractReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 88:
                                this.interactType_ = input.readEnum();
                                break;
                            case 104:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 112:
                                this.pos_ = input.readUInt32();
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
            return VehicleInteractReqOuterClass.internal_static_VehicleInteractReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VehicleInteractReqOuterClass.internal_static_VehicleInteractReq_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleInteractReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
        public int getPos() {
            return this.pos_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
        public int getInteractTypeValue() {
            return this.interactType_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
        public VehicleInteractTypeOuterClass.VehicleInteractType getInteractType() {
            VehicleInteractTypeOuterClass.VehicleInteractType result = VehicleInteractTypeOuterClass.VehicleInteractType.valueOf(this.interactType_);
            return result == null ? VehicleInteractTypeOuterClass.VehicleInteractType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
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
            if (this.interactType_ != VehicleInteractTypeOuterClass.VehicleInteractType.VEHICLE_INTERACT_TYPE_NONE.getNumber()) {
                output.writeEnum(11, this.interactType_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(13, this.entityId_);
            }
            if (this.pos_ != 0) {
                output.writeUInt32(14, this.pos_);
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
            if (this.interactType_ != VehicleInteractTypeOuterClass.VehicleInteractType.VEHICLE_INTERACT_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(11, this.interactType_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.entityId_);
            }
            if (this.pos_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.pos_);
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
            if (!(obj instanceof VehicleInteractReq)) {
                return equals(obj);
            }
            VehicleInteractReq other = (VehicleInteractReq) obj;
            return getPos() == other.getPos() && this.interactType_ == other.interactType_ && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getPos())) + 11)) + this.interactType_)) + 13)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static VehicleInteractReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInteractReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInteractReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInteractReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInteractReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInteractReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInteractReq parseFrom(InputStream input) throws IOException {
            return (VehicleInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleInteractReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleInteractReq parseDelimitedFrom(InputStream input) throws IOException {
            return (VehicleInteractReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VehicleInteractReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInteractReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleInteractReq parseFrom(CodedInputStream input) throws IOException {
            return (VehicleInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleInteractReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInteractReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VehicleInteractReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractReqOuterClass$VehicleInteractReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VehicleInteractReqOrBuilder {
            private int pos_;
            private int interactType_ = 0;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VehicleInteractReqOuterClass.internal_static_VehicleInteractReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VehicleInteractReqOuterClass.internal_static_VehicleInteractReq_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleInteractReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VehicleInteractReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.pos_ = 0;
                this.interactType_ = 0;
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VehicleInteractReqOuterClass.internal_static_VehicleInteractReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VehicleInteractReq getDefaultInstanceForType() {
                return VehicleInteractReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleInteractReq build() {
                VehicleInteractReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleInteractReq buildPartial() {
                VehicleInteractReq result = new VehicleInteractReq(this);
                result.pos_ = this.pos_;
                result.interactType_ = this.interactType_;
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
                if (other instanceof VehicleInteractReq) {
                    return mergeFrom((VehicleInteractReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VehicleInteractReq other) {
                if (other == VehicleInteractReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getPos() != 0) {
                    setPos(other.getPos());
                }
                if (other.interactType_ != 0) {
                    setInteractTypeValue(other.getInteractTypeValue());
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
                VehicleInteractReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = VehicleInteractReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VehicleInteractReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
            public int getPos() {
                return this.pos_;
            }

            public Builder setPos(int value) {
                this.pos_ = value;
                onChanged();
                return this;
            }

            public Builder clearPos() {
                this.pos_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
            public int getInteractTypeValue() {
                return this.interactType_;
            }

            public Builder setInteractTypeValue(int value) {
                this.interactType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
            public VehicleInteractTypeOuterClass.VehicleInteractType getInteractType() {
                VehicleInteractTypeOuterClass.VehicleInteractType result = VehicleInteractTypeOuterClass.VehicleInteractType.valueOf(this.interactType_);
                return result == null ? VehicleInteractTypeOuterClass.VehicleInteractType.UNRECOGNIZED : result;
            }

            public Builder setInteractType(VehicleInteractTypeOuterClass.VehicleInteractType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.interactType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearInteractType() {
                this.interactType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractReqOuterClass.VehicleInteractReqOrBuilder
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

        public static VehicleInteractReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VehicleInteractReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VehicleInteractReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VehicleInteractReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VehicleInteractTypeOuterClass.getDescriptor();
    }
}
