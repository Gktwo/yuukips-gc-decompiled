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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorDataOuterClass.class */
public final class SkyCrystalDetectorDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSkyCrystalDetectorData.proto\u001a\fVector.proto\"v\n\u0016SkyCrystalDetectorData\u0012\u0015\n\ris_hint_valid\u0018\u0001 \u0001(\b\u0012\u0010\n\bgroup_id\u0018\u0005 \u0001(\r\u0012 \n\u000fhint_center_pos\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0011\n\tconfig_id\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SkyCrystalDetectorData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SkyCrystalDetectorData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SkyCrystalDetectorData_descriptor, new String[]{"IsHintValid", "GroupId", "HintCenterPos", "ConfigId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorDataOuterClass$SkyCrystalDetectorDataOrBuilder.class */
    public interface SkyCrystalDetectorDataOrBuilder extends MessageOrBuilder {
        boolean getIsHintValid();

        int getGroupId();

        boolean hasHintCenterPos();

        VectorOuterClass.Vector getHintCenterPos();

        VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder();

        int getConfigId();
    }

    private SkyCrystalDetectorDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorDataOuterClass$SkyCrystalDetectorData.class */
    public static final class SkyCrystalDetectorData extends GeneratedMessageV3 implements SkyCrystalDetectorDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_HINT_VALID_FIELD_NUMBER = 1;
        private boolean isHintValid_;
        public static final int GROUP_ID_FIELD_NUMBER = 5;
        private int groupId_;
        public static final int HINT_CENTER_POS_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector hintCenterPos_;
        public static final int CONFIG_ID_FIELD_NUMBER = 7;
        private int configId_;
        private byte memoizedIsInitialized;
        private static final SkyCrystalDetectorData DEFAULT_INSTANCE = new SkyCrystalDetectorData();
        private static final Parser<SkyCrystalDetectorData> PARSER = new AbstractParser<SkyCrystalDetectorData>() { // from class: emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorData.1
            @Override // com.google.protobuf.Parser
            public SkyCrystalDetectorData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SkyCrystalDetectorData(input, extensionRegistry);
            }
        };

        private SkyCrystalDetectorData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SkyCrystalDetectorData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SkyCrystalDetectorData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SkyCrystalDetectorData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isHintValid_ = input.readBool();
                                break;
                            case 40:
                                this.groupId_ = input.readUInt32();
                                break;
                            case 56:
                                this.configId_ = input.readUInt32();
                                break;
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder = this.hintCenterPos_ != null ? this.hintCenterPos_.toBuilder() : null;
                                this.hintCenterPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.hintCenterPos_);
                                    this.hintCenterPos_ = subBuilder.buildPartial();
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
            return SkyCrystalDetectorDataOuterClass.internal_static_SkyCrystalDetectorData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SkyCrystalDetectorDataOuterClass.internal_static_SkyCrystalDetectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(SkyCrystalDetectorData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
        public boolean getIsHintValid() {
            return this.isHintValid_;
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
        public boolean hasHintCenterPos() {
            return this.hintCenterPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
        public VectorOuterClass.Vector getHintCenterPos() {
            return this.hintCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hintCenterPos_;
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder() {
            return getHintCenterPos();
        }

        @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
        public int getConfigId() {
            return this.configId_;
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
            if (this.isHintValid_) {
                output.writeBool(1, this.isHintValid_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(5, this.groupId_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(7, this.configId_);
            }
            if (this.hintCenterPos_ != null) {
                output.writeMessage(12, getHintCenterPos());
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
            if (this.isHintValid_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isHintValid_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.groupId_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.configId_);
            }
            if (this.hintCenterPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getHintCenterPos());
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
            if (!(obj instanceof SkyCrystalDetectorData)) {
                return equals(obj);
            }
            SkyCrystalDetectorData other = (SkyCrystalDetectorData) obj;
            if (getIsHintValid() == other.getIsHintValid() && getGroupId() == other.getGroupId() && hasHintCenterPos() == other.hasHintCenterPos()) {
                return (!hasHintCenterPos() || getHintCenterPos().equals(other.getHintCenterPos())) && getConfigId() == other.getConfigId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsHintValid()))) + 5)) + getGroupId();
            if (hasHintCenterPos()) {
                hash = (53 * ((37 * hash) + 12)) + getHintCenterPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getConfigId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SkyCrystalDetectorData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SkyCrystalDetectorData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkyCrystalDetectorData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SkyCrystalDetectorData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkyCrystalDetectorData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SkyCrystalDetectorData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SkyCrystalDetectorData parseFrom(InputStream input) throws IOException {
            return (SkyCrystalDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SkyCrystalDetectorData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkyCrystalDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SkyCrystalDetectorData parseDelimitedFrom(InputStream input) throws IOException {
            return (SkyCrystalDetectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SkyCrystalDetectorData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkyCrystalDetectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SkyCrystalDetectorData parseFrom(CodedInputStream input) throws IOException {
            return (SkyCrystalDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SkyCrystalDetectorData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SkyCrystalDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SkyCrystalDetectorData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SkyCrystalDetectorDataOuterClass$SkyCrystalDetectorData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SkyCrystalDetectorDataOrBuilder {
            private boolean isHintValid_;
            private int groupId_;
            private VectorOuterClass.Vector hintCenterPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> hintCenterPosBuilder_;
            private int configId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SkyCrystalDetectorDataOuterClass.internal_static_SkyCrystalDetectorData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SkyCrystalDetectorDataOuterClass.internal_static_SkyCrystalDetectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(SkyCrystalDetectorData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SkyCrystalDetectorData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isHintValid_ = false;
                this.groupId_ = 0;
                if (this.hintCenterPosBuilder_ == null) {
                    this.hintCenterPos_ = null;
                } else {
                    this.hintCenterPos_ = null;
                    this.hintCenterPosBuilder_ = null;
                }
                this.configId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SkyCrystalDetectorDataOuterClass.internal_static_SkyCrystalDetectorData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SkyCrystalDetectorData getDefaultInstanceForType() {
                return SkyCrystalDetectorData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SkyCrystalDetectorData build() {
                SkyCrystalDetectorData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SkyCrystalDetectorData buildPartial() {
                SkyCrystalDetectorData result = new SkyCrystalDetectorData(this);
                result.isHintValid_ = this.isHintValid_;
                result.groupId_ = this.groupId_;
                if (this.hintCenterPosBuilder_ == null) {
                    result.hintCenterPos_ = this.hintCenterPos_;
                } else {
                    result.hintCenterPos_ = this.hintCenterPosBuilder_.build();
                }
                result.configId_ = this.configId_;
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
                if (other instanceof SkyCrystalDetectorData) {
                    return mergeFrom((SkyCrystalDetectorData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SkyCrystalDetectorData other) {
                if (other == SkyCrystalDetectorData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsHintValid()) {
                    setIsHintValid(other.getIsHintValid());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.hasHintCenterPos()) {
                    mergeHintCenterPos(other.getHintCenterPos());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
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
                SkyCrystalDetectorData parsedMessage = null;
                try {
                    try {
                        parsedMessage = SkyCrystalDetectorData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SkyCrystalDetectorData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
            public boolean getIsHintValid() {
                return this.isHintValid_;
            }

            public Builder setIsHintValid(boolean value) {
                this.isHintValid_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHintValid() {
                this.isHintValid_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            public Builder setGroupId(int value) {
                this.groupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
            public boolean hasHintCenterPos() {
                return (this.hintCenterPosBuilder_ == null && this.hintCenterPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
            public VectorOuterClass.Vector getHintCenterPos() {
                if (this.hintCenterPosBuilder_ == null) {
                    return this.hintCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hintCenterPos_;
                }
                return this.hintCenterPosBuilder_.getMessage();
            }

            public Builder setHintCenterPos(VectorOuterClass.Vector value) {
                if (this.hintCenterPosBuilder_ != null) {
                    this.hintCenterPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.hintCenterPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setHintCenterPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.hintCenterPosBuilder_ == null) {
                    this.hintCenterPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hintCenterPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeHintCenterPos(VectorOuterClass.Vector value) {
                if (this.hintCenterPosBuilder_ == null) {
                    if (this.hintCenterPos_ != null) {
                        this.hintCenterPos_ = VectorOuterClass.Vector.newBuilder(this.hintCenterPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.hintCenterPos_ = value;
                    }
                    onChanged();
                } else {
                    this.hintCenterPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearHintCenterPos() {
                if (this.hintCenterPosBuilder_ == null) {
                    this.hintCenterPos_ = null;
                    onChanged();
                } else {
                    this.hintCenterPos_ = null;
                    this.hintCenterPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getHintCenterPosBuilder() {
                onChanged();
                return getHintCenterPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder() {
                if (this.hintCenterPosBuilder_ != null) {
                    return this.hintCenterPosBuilder_.getMessageOrBuilder();
                }
                return this.hintCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hintCenterPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getHintCenterPosFieldBuilder() {
                if (this.hintCenterPosBuilder_ == null) {
                    this.hintCenterPosBuilder_ = new SingleFieldBuilderV3<>(getHintCenterPos(), getParentForChildren(), isClean());
                    this.hintCenterPos_ = null;
                }
                return this.hintCenterPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SkyCrystalDetectorDataOuterClass.SkyCrystalDetectorDataOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
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

        public static SkyCrystalDetectorData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SkyCrystalDetectorData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SkyCrystalDetectorData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SkyCrystalDetectorData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
