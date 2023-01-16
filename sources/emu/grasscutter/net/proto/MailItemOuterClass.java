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
import emu.grasscutter.net.proto.EquipParamOuterClass;
import emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailItemOuterClass.class */
public final class MailItemOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eMailItem.proto\u001a\u0010EquipParam.proto\u001a\u0018MaterialDeleteInfo.proto\"V\n\bMailItem\u0012 \n\u000bequip_param\u0018\u0001 \u0001(\u000b2\u000b.EquipParam\u0012(\n\u000bdelete_info\u0018\u0002 \u0001(\u000b2\u0013.MaterialDeleteInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EquipParamOuterClass.getDescriptor(), MaterialDeleteInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MailItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MailItem_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MailItem_descriptor, new String[]{"EquipParam", "DeleteInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailItemOuterClass$MailItemOrBuilder.class */
    public interface MailItemOrBuilder extends MessageOrBuilder {
        boolean hasEquipParam();

        EquipParamOuterClass.EquipParam getEquipParam();

        EquipParamOuterClass.EquipParamOrBuilder getEquipParamOrBuilder();

        boolean hasDeleteInfo();

        MaterialDeleteInfoOuterClass.MaterialDeleteInfo getDeleteInfo();

        MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder getDeleteInfoOrBuilder();
    }

    private MailItemOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailItemOuterClass$MailItem.class */
    public static final class MailItem extends GeneratedMessageV3 implements MailItemOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EQUIP_PARAM_FIELD_NUMBER = 1;
        private EquipParamOuterClass.EquipParam equipParam_;
        public static final int DELETE_INFO_FIELD_NUMBER = 2;
        private MaterialDeleteInfoOuterClass.MaterialDeleteInfo deleteInfo_;
        private byte memoizedIsInitialized;
        private static final MailItem DEFAULT_INSTANCE = new MailItem();
        private static final Parser<MailItem> PARSER = new AbstractParser<MailItem>() { // from class: emu.grasscutter.net.proto.MailItemOuterClass.MailItem.1
            @Override // com.google.protobuf.Parser
            public MailItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailItem(input, extensionRegistry);
            }
        };

        private MailItem(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MailItem() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MailItem();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    EquipParamOuterClass.EquipParam.Builder subBuilder = this.equipParam_ != null ? this.equipParam_.toBuilder() : null;
                                    this.equipParam_ = (EquipParamOuterClass.EquipParam) input.readMessage(EquipParamOuterClass.EquipParam.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.equipParam_);
                                        this.equipParam_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 18:
                                    MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder subBuilder2 = this.deleteInfo_ != null ? this.deleteInfo_.toBuilder() : null;
                                    this.deleteInfo_ = (MaterialDeleteInfoOuterClass.MaterialDeleteInfo) input.readMessage(MaterialDeleteInfoOuterClass.MaterialDeleteInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.deleteInfo_);
                                        this.deleteInfo_ = subBuilder2.buildPartial();
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
            return MailItemOuterClass.internal_static_MailItem_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailItemOuterClass.internal_static_MailItem_fieldAccessorTable.ensureFieldAccessorsInitialized(MailItem.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
        public boolean hasEquipParam() {
            return this.equipParam_ != null;
        }

        @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
        public EquipParamOuterClass.EquipParam getEquipParam() {
            return this.equipParam_ == null ? EquipParamOuterClass.EquipParam.getDefaultInstance() : this.equipParam_;
        }

        @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
        public EquipParamOuterClass.EquipParamOrBuilder getEquipParamOrBuilder() {
            return getEquipParam();
        }

        @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
        public boolean hasDeleteInfo() {
            return this.deleteInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
        public MaterialDeleteInfoOuterClass.MaterialDeleteInfo getDeleteInfo() {
            return this.deleteInfo_ == null ? MaterialDeleteInfoOuterClass.MaterialDeleteInfo.getDefaultInstance() : this.deleteInfo_;
        }

        @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
        public MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder getDeleteInfoOrBuilder() {
            return getDeleteInfo();
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
            if (this.equipParam_ != null) {
                output.writeMessage(1, getEquipParam());
            }
            if (this.deleteInfo_ != null) {
                output.writeMessage(2, getDeleteInfo());
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
            if (this.equipParam_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getEquipParam());
            }
            if (this.deleteInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getDeleteInfo());
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
            if (!(obj instanceof MailItem)) {
                return equals(obj);
            }
            MailItem other = (MailItem) obj;
            if (hasEquipParam() != other.hasEquipParam()) {
                return false;
            }
            if ((!hasEquipParam() || getEquipParam().equals(other.getEquipParam())) && hasDeleteInfo() == other.hasDeleteInfo()) {
                return (!hasDeleteInfo() || getDeleteInfo().equals(other.getDeleteInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasEquipParam()) {
                hash = (53 * ((37 * hash) + 1)) + getEquipParam().hashCode();
            }
            if (hasDeleteInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getDeleteInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MailItem parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailItem parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailItem parseFrom(InputStream input) throws IOException {
            return (MailItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailItem parseDelimitedFrom(InputStream input) throws IOException {
            return (MailItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MailItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailItem parseFrom(CodedInputStream input) throws IOException {
            return (MailItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MailItem prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailItemOuterClass$MailItem$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MailItemOrBuilder {
            private EquipParamOuterClass.EquipParam equipParam_;
            private SingleFieldBuilderV3<EquipParamOuterClass.EquipParam, EquipParamOuterClass.EquipParam.Builder, EquipParamOuterClass.EquipParamOrBuilder> equipParamBuilder_;
            private MaterialDeleteInfoOuterClass.MaterialDeleteInfo deleteInfo_;
            private SingleFieldBuilderV3<MaterialDeleteInfoOuterClass.MaterialDeleteInfo, MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder, MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder> deleteInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailItemOuterClass.internal_static_MailItem_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailItemOuterClass.internal_static_MailItem_fieldAccessorTable.ensureFieldAccessorsInitialized(MailItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailItem.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.equipParamBuilder_ == null) {
                    this.equipParam_ = null;
                } else {
                    this.equipParam_ = null;
                    this.equipParamBuilder_ = null;
                }
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfo_ = null;
                } else {
                    this.deleteInfo_ = null;
                    this.deleteInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MailItemOuterClass.internal_static_MailItem_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MailItem getDefaultInstanceForType() {
                return MailItem.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailItem build() {
                MailItem result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailItem buildPartial() {
                MailItem result = new MailItem(this);
                if (this.equipParamBuilder_ == null) {
                    result.equipParam_ = this.equipParam_;
                } else {
                    result.equipParam_ = this.equipParamBuilder_.build();
                }
                if (this.deleteInfoBuilder_ == null) {
                    result.deleteInfo_ = this.deleteInfo_;
                } else {
                    result.deleteInfo_ = this.deleteInfoBuilder_.build();
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
                if (other instanceof MailItem) {
                    return mergeFrom((MailItem) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailItem other) {
                if (other == MailItem.getDefaultInstance()) {
                    return this;
                }
                if (other.hasEquipParam()) {
                    mergeEquipParam(other.getEquipParam());
                }
                if (other.hasDeleteInfo()) {
                    mergeDeleteInfo(other.getDeleteInfo());
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
                MailItem parsedMessage = null;
                try {
                    try {
                        parsedMessage = MailItem.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MailItem) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
            public boolean hasEquipParam() {
                return (this.equipParamBuilder_ == null && this.equipParam_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
            public EquipParamOuterClass.EquipParam getEquipParam() {
                if (this.equipParamBuilder_ == null) {
                    return this.equipParam_ == null ? EquipParamOuterClass.EquipParam.getDefaultInstance() : this.equipParam_;
                }
                return this.equipParamBuilder_.getMessage();
            }

            public Builder setEquipParam(EquipParamOuterClass.EquipParam value) {
                if (this.equipParamBuilder_ != null) {
                    this.equipParamBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.equipParam_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEquipParam(EquipParamOuterClass.EquipParam.Builder builderForValue) {
                if (this.equipParamBuilder_ == null) {
                    this.equipParam_ = builderForValue.build();
                    onChanged();
                } else {
                    this.equipParamBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEquipParam(EquipParamOuterClass.EquipParam value) {
                if (this.equipParamBuilder_ == null) {
                    if (this.equipParam_ != null) {
                        this.equipParam_ = EquipParamOuterClass.EquipParam.newBuilder(this.equipParam_).mergeFrom(value).buildPartial();
                    } else {
                        this.equipParam_ = value;
                    }
                    onChanged();
                } else {
                    this.equipParamBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEquipParam() {
                if (this.equipParamBuilder_ == null) {
                    this.equipParam_ = null;
                    onChanged();
                } else {
                    this.equipParam_ = null;
                    this.equipParamBuilder_ = null;
                }
                return this;
            }

            public EquipParamOuterClass.EquipParam.Builder getEquipParamBuilder() {
                onChanged();
                return getEquipParamFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
            public EquipParamOuterClass.EquipParamOrBuilder getEquipParamOrBuilder() {
                if (this.equipParamBuilder_ != null) {
                    return this.equipParamBuilder_.getMessageOrBuilder();
                }
                return this.equipParam_ == null ? EquipParamOuterClass.EquipParam.getDefaultInstance() : this.equipParam_;
            }

            private SingleFieldBuilderV3<EquipParamOuterClass.EquipParam, EquipParamOuterClass.EquipParam.Builder, EquipParamOuterClass.EquipParamOrBuilder> getEquipParamFieldBuilder() {
                if (this.equipParamBuilder_ == null) {
                    this.equipParamBuilder_ = new SingleFieldBuilderV3<>(getEquipParam(), getParentForChildren(), isClean());
                    this.equipParam_ = null;
                }
                return this.equipParamBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
            public boolean hasDeleteInfo() {
                return (this.deleteInfoBuilder_ == null && this.deleteInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
            public MaterialDeleteInfoOuterClass.MaterialDeleteInfo getDeleteInfo() {
                if (this.deleteInfoBuilder_ == null) {
                    return this.deleteInfo_ == null ? MaterialDeleteInfoOuterClass.MaterialDeleteInfo.getDefaultInstance() : this.deleteInfo_;
                }
                return this.deleteInfoBuilder_.getMessage();
            }

            public Builder setDeleteInfo(MaterialDeleteInfoOuterClass.MaterialDeleteInfo value) {
                if (this.deleteInfoBuilder_ != null) {
                    this.deleteInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.deleteInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDeleteInfo(MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder builderForValue) {
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.deleteInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDeleteInfo(MaterialDeleteInfoOuterClass.MaterialDeleteInfo value) {
                if (this.deleteInfoBuilder_ == null) {
                    if (this.deleteInfo_ != null) {
                        this.deleteInfo_ = MaterialDeleteInfoOuterClass.MaterialDeleteInfo.newBuilder(this.deleteInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.deleteInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.deleteInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDeleteInfo() {
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfo_ = null;
                    onChanged();
                } else {
                    this.deleteInfo_ = null;
                    this.deleteInfoBuilder_ = null;
                }
                return this;
            }

            public MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder getDeleteInfoBuilder() {
                onChanged();
                return getDeleteInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MailItemOuterClass.MailItemOrBuilder
            public MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder getDeleteInfoOrBuilder() {
                if (this.deleteInfoBuilder_ != null) {
                    return this.deleteInfoBuilder_.getMessageOrBuilder();
                }
                return this.deleteInfo_ == null ? MaterialDeleteInfoOuterClass.MaterialDeleteInfo.getDefaultInstance() : this.deleteInfo_;
            }

            private SingleFieldBuilderV3<MaterialDeleteInfoOuterClass.MaterialDeleteInfo, MaterialDeleteInfoOuterClass.MaterialDeleteInfo.Builder, MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder> getDeleteInfoFieldBuilder() {
                if (this.deleteInfoBuilder_ == null) {
                    this.deleteInfoBuilder_ = new SingleFieldBuilderV3<>(getDeleteInfo(), getParentForChildren(), isClean());
                    this.deleteInfo_ = null;
                }
                return this.deleteInfoBuilder_;
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

        public static MailItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MailItem> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MailItem> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MailItem getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EquipParamOuterClass.getDescriptor();
        MaterialDeleteInfoOuterClass.getDescriptor();
    }
}
