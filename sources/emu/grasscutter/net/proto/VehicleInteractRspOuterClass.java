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
import emu.grasscutter.net.proto.VehicleInteractTypeOuterClass;
import emu.grasscutter.net.proto.VehicleMemberOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractRspOuterClass.class */
public final class VehicleInteractRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018VehicleInteractRsp.proto\u001a\u0013VehicleMember.proto\u001a\u0019VehicleInteractType.proto\"\u0001\n\u0012VehicleInteractRsp\u0012\u001e\n\u0006member\u0018\u000f \u0001(\u000b2\u000e.VehicleMember\u0012\u0010\n\bentityId\u0018\u0002 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012*\n\finteractType\u0018\b \u0001(\u000e2\u0014.VehicleInteractTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VehicleMemberOuterClass.getDescriptor(), VehicleInteractTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VehicleInteractRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VehicleInteractRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VehicleInteractRsp_descriptor, new String[]{"Member", "EntityId", "Retcode", "InteractType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractRspOuterClass$VehicleInteractRspOrBuilder.class */
    public interface VehicleInteractRspOrBuilder extends MessageOrBuilder {
        boolean hasMember();

        VehicleMemberOuterClass.VehicleMember getMember();

        VehicleMemberOuterClass.VehicleMemberOrBuilder getMemberOrBuilder();

        int getEntityId();

        int getRetcode();

        int getInteractTypeValue();

        VehicleInteractTypeOuterClass.VehicleInteractType getInteractType();
    }

    private VehicleInteractRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractRspOuterClass$VehicleInteractRsp.class */
    public static final class VehicleInteractRsp extends GeneratedMessageV3 implements VehicleInteractRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MEMBER_FIELD_NUMBER = 15;
        private VehicleMemberOuterClass.VehicleMember member_;
        public static final int ENTITYID_FIELD_NUMBER = 2;
        private int entityId_;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int INTERACTTYPE_FIELD_NUMBER = 8;
        private int interactType_;
        private byte memoizedIsInitialized;
        private static final VehicleInteractRsp DEFAULT_INSTANCE = new VehicleInteractRsp();
        private static final Parser<VehicleInteractRsp> PARSER = new AbstractParser<VehicleInteractRsp>() { // from class: emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRsp.1
            @Override // com.google.protobuf.Parser
            public VehicleInteractRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VehicleInteractRsp(input, extensionRegistry);
            }
        };

        private VehicleInteractRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VehicleInteractRsp() {
            this.memoizedIsInitialized = -1;
            this.interactType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VehicleInteractRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VehicleInteractRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 64:
                                this.interactType_ = input.readEnum();
                                break;
                            case 80:
                                this.retcode_ = input.readInt32();
                                break;
                            case 122:
                                VehicleMemberOuterClass.VehicleMember.Builder subBuilder = this.member_ != null ? this.member_.toBuilder() : null;
                                this.member_ = (VehicleMemberOuterClass.VehicleMember) input.readMessage(VehicleMemberOuterClass.VehicleMember.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.member_);
                                    this.member_ = subBuilder.buildPartial();
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
            return VehicleInteractRspOuterClass.internal_static_VehicleInteractRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VehicleInteractRspOuterClass.internal_static_VehicleInteractRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleInteractRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public boolean hasMember() {
            return this.member_ != null;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public VehicleMemberOuterClass.VehicleMember getMember() {
            return this.member_ == null ? VehicleMemberOuterClass.VehicleMember.getDefaultInstance() : this.member_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public VehicleMemberOuterClass.VehicleMemberOrBuilder getMemberOrBuilder() {
            return getMember();
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public int getInteractTypeValue() {
            return this.interactType_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
        public VehicleInteractTypeOuterClass.VehicleInteractType getInteractType() {
            VehicleInteractTypeOuterClass.VehicleInteractType result = VehicleInteractTypeOuterClass.VehicleInteractType.valueOf(this.interactType_);
            return result == null ? VehicleInteractTypeOuterClass.VehicleInteractType.UNRECOGNIZED : result;
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
                output.writeUInt32(2, this.entityId_);
            }
            if (this.interactType_ != VehicleInteractTypeOuterClass.VehicleInteractType.VEHICLE_INTERACT_TYPE_NONE.getNumber()) {
                output.writeEnum(8, this.interactType_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
            }
            if (this.member_ != null) {
                output.writeMessage(15, getMember());
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.entityId_);
            }
            if (this.interactType_ != VehicleInteractTypeOuterClass.VehicleInteractType.VEHICLE_INTERACT_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(8, this.interactType_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
            }
            if (this.member_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getMember());
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
            if (!(obj instanceof VehicleInteractRsp)) {
                return equals(obj);
            }
            VehicleInteractRsp other = (VehicleInteractRsp) obj;
            if (hasMember() != other.hasMember()) {
                return false;
            }
            return (!hasMember() || getMember().equals(other.getMember())) && getEntityId() == other.getEntityId() && getRetcode() == other.getRetcode() && this.interactType_ == other.interactType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasMember()) {
                hash = (53 * ((37 * hash) + 15)) + getMember().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getEntityId())) + 10)) + getRetcode())) + 8)) + this.interactType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VehicleInteractRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInteractRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInteractRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInteractRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInteractRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInteractRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInteractRsp parseFrom(InputStream input) throws IOException {
            return (VehicleInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleInteractRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleInteractRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (VehicleInteractRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VehicleInteractRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInteractRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleInteractRsp parseFrom(CodedInputStream input) throws IOException {
            return (VehicleInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleInteractRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInteractRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VehicleInteractRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractRspOuterClass$VehicleInteractRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VehicleInteractRspOrBuilder {
            private VehicleMemberOuterClass.VehicleMember member_;
            private SingleFieldBuilderV3<VehicleMemberOuterClass.VehicleMember, VehicleMemberOuterClass.VehicleMember.Builder, VehicleMemberOuterClass.VehicleMemberOrBuilder> memberBuilder_;
            private int entityId_;
            private int retcode_;
            private int interactType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return VehicleInteractRspOuterClass.internal_static_VehicleInteractRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VehicleInteractRspOuterClass.internal_static_VehicleInteractRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleInteractRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VehicleInteractRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.memberBuilder_ == null) {
                    this.member_ = null;
                } else {
                    this.member_ = null;
                    this.memberBuilder_ = null;
                }
                this.entityId_ = 0;
                this.retcode_ = 0;
                this.interactType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VehicleInteractRspOuterClass.internal_static_VehicleInteractRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VehicleInteractRsp getDefaultInstanceForType() {
                return VehicleInteractRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleInteractRsp build() {
                VehicleInteractRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleInteractRsp buildPartial() {
                VehicleInteractRsp result = new VehicleInteractRsp(this);
                if (this.memberBuilder_ == null) {
                    result.member_ = this.member_;
                } else {
                    result.member_ = this.memberBuilder_.build();
                }
                result.entityId_ = this.entityId_;
                result.retcode_ = this.retcode_;
                result.interactType_ = this.interactType_;
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
                if (other instanceof VehicleInteractRsp) {
                    return mergeFrom((VehicleInteractRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VehicleInteractRsp other) {
                if (other == VehicleInteractRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasMember()) {
                    mergeMember(other.getMember());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.interactType_ != 0) {
                    setInteractTypeValue(other.getInteractTypeValue());
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
                VehicleInteractRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = VehicleInteractRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VehicleInteractRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
            public boolean hasMember() {
                return (this.memberBuilder_ == null && this.member_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
            public VehicleMemberOuterClass.VehicleMember getMember() {
                if (this.memberBuilder_ == null) {
                    return this.member_ == null ? VehicleMemberOuterClass.VehicleMember.getDefaultInstance() : this.member_;
                }
                return this.memberBuilder_.getMessage();
            }

            public Builder setMember(VehicleMemberOuterClass.VehicleMember value) {
                if (this.memberBuilder_ != null) {
                    this.memberBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.member_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMember(VehicleMemberOuterClass.VehicleMember.Builder builderForValue) {
                if (this.memberBuilder_ == null) {
                    this.member_ = builderForValue.build();
                    onChanged();
                } else {
                    this.memberBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMember(VehicleMemberOuterClass.VehicleMember value) {
                if (this.memberBuilder_ == null) {
                    if (this.member_ != null) {
                        this.member_ = VehicleMemberOuterClass.VehicleMember.newBuilder(this.member_).mergeFrom(value).buildPartial();
                    } else {
                        this.member_ = value;
                    }
                    onChanged();
                } else {
                    this.memberBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMember() {
                if (this.memberBuilder_ == null) {
                    this.member_ = null;
                    onChanged();
                } else {
                    this.member_ = null;
                    this.memberBuilder_ = null;
                }
                return this;
            }

            public VehicleMemberOuterClass.VehicleMember.Builder getMemberBuilder() {
                onChanged();
                return getMemberFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
            public VehicleMemberOuterClass.VehicleMemberOrBuilder getMemberOrBuilder() {
                if (this.memberBuilder_ != null) {
                    return this.memberBuilder_.getMessageOrBuilder();
                }
                return this.member_ == null ? VehicleMemberOuterClass.VehicleMember.getDefaultInstance() : this.member_;
            }

            private SingleFieldBuilderV3<VehicleMemberOuterClass.VehicleMember, VehicleMemberOuterClass.VehicleMember.Builder, VehicleMemberOuterClass.VehicleMemberOrBuilder> getMemberFieldBuilder() {
                if (this.memberBuilder_ == null) {
                    this.memberBuilder_ = new SingleFieldBuilderV3<>(getMember(), getParentForChildren(), isClean());
                    this.member_ = null;
                }
                return this.memberBuilder_;
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
            public int getInteractTypeValue() {
                return this.interactType_;
            }

            public Builder setInteractTypeValue(int value) {
                this.interactType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleInteractRspOuterClass.VehicleInteractRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static VehicleInteractRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VehicleInteractRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VehicleInteractRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VehicleInteractRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VehicleMemberOuterClass.getDescriptor();
        VehicleInteractTypeOuterClass.getDescriptor();
    }
}
