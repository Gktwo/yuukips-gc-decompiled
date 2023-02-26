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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DetectorDataOuterClass.class */
public final class DetectorDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012DetectorData.proto\u001a\fVector.proto\"¦\u0001\n\fDetectorData\u0012\u0013\n\u000bisHintValid\u0018\u0002 \u0001(\b\u0012\u0010\n\bconfigId\u0018\t \u0001(\r\u0012\u001e\n\rhintCenterPos\u0018\u0003 \u0001(\u000b2\u0007.Vector\u0012\u0012\n\nmaterialId\u0018\n \u0001(\r\u0012\u0016\n\u000eisAllCollected\u0018\r \u0001(\b\u0012\u000f\n\u0007groupId\u0018\u000e \u0001(\r\u0012\u0012\n\nhintRadius\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DetectorData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DetectorData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DetectorData_descriptor, new String[]{"IsHintValid", "ConfigId", "HintCenterPos", "MaterialId", "IsAllCollected", "GroupId", "HintRadius"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DetectorDataOuterClass$DetectorDataOrBuilder.class */
    public interface DetectorDataOrBuilder extends MessageOrBuilder {
        boolean getIsHintValid();

        int getConfigId();

        boolean hasHintCenterPos();

        VectorOuterClass.Vector getHintCenterPos();

        VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder();

        int getMaterialId();

        boolean getIsAllCollected();

        int getGroupId();

        int getHintRadius();
    }

    private DetectorDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DetectorDataOuterClass$DetectorData.class */
    public static final class DetectorData extends GeneratedMessageV3 implements DetectorDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISHINTVALID_FIELD_NUMBER = 2;
        private boolean isHintValid_;
        public static final int CONFIGID_FIELD_NUMBER = 9;
        private int configId_;
        public static final int HINTCENTERPOS_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector hintCenterPos_;
        public static final int MATERIALID_FIELD_NUMBER = 10;
        private int materialId_;
        public static final int ISALLCOLLECTED_FIELD_NUMBER = 13;
        private boolean isAllCollected_;
        public static final int GROUPID_FIELD_NUMBER = 14;
        private int groupId_;
        public static final int HINTRADIUS_FIELD_NUMBER = 5;
        private int hintRadius_;
        private byte memoizedIsInitialized;
        private static final DetectorData DEFAULT_INSTANCE = new DetectorData();
        private static final Parser<DetectorData> PARSER = new AbstractParser<DetectorData>() { // from class: emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorData.1
            @Override // com.google.protobuf.Parser
            public DetectorData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DetectorData(input, extensionRegistry);
            }
        };

        private DetectorData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DetectorData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DetectorData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DetectorData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isHintValid_ = input.readBool();
                                break;
                            case 26:
                                VectorOuterClass.Vector.Builder subBuilder = this.hintCenterPos_ != null ? this.hintCenterPos_.toBuilder() : null;
                                this.hintCenterPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.hintCenterPos_);
                                    this.hintCenterPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 40:
                                this.hintRadius_ = input.readUInt32();
                                break;
                            case 72:
                                this.configId_ = input.readUInt32();
                                break;
                            case 80:
                                this.materialId_ = input.readUInt32();
                                break;
                            case 104:
                                this.isAllCollected_ = input.readBool();
                                break;
                            case 112:
                                this.groupId_ = input.readUInt32();
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
            return DetectorDataOuterClass.internal_static_DetectorData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DetectorDataOuterClass.internal_static_DetectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(DetectorData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public boolean getIsHintValid() {
            return this.isHintValid_;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public boolean hasHintCenterPos() {
            return this.hintCenterPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public VectorOuterClass.Vector getHintCenterPos() {
            return this.hintCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hintCenterPos_;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder() {
            return getHintCenterPos();
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public int getMaterialId() {
            return this.materialId_;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public boolean getIsAllCollected() {
            return this.isAllCollected_;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
        public int getHintRadius() {
            return this.hintRadius_;
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
                output.writeBool(2, this.isHintValid_);
            }
            if (this.hintCenterPos_ != null) {
                output.writeMessage(3, getHintCenterPos());
            }
            if (this.hintRadius_ != 0) {
                output.writeUInt32(5, this.hintRadius_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(9, this.configId_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(10, this.materialId_);
            }
            if (this.isAllCollected_) {
                output.writeBool(13, this.isAllCollected_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(14, this.groupId_);
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
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isHintValid_);
            }
            if (this.hintCenterPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getHintCenterPos());
            }
            if (this.hintRadius_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.hintRadius_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.configId_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.materialId_);
            }
            if (this.isAllCollected_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isAllCollected_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.groupId_);
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
            if (!(obj instanceof DetectorData)) {
                return equals(obj);
            }
            DetectorData other = (DetectorData) obj;
            if (getIsHintValid() == other.getIsHintValid() && getConfigId() == other.getConfigId() && hasHintCenterPos() == other.hasHintCenterPos()) {
                return (!hasHintCenterPos() || getHintCenterPos().equals(other.getHintCenterPos())) && getMaterialId() == other.getMaterialId() && getIsAllCollected() == other.getIsAllCollected() && getGroupId() == other.getGroupId() && getHintRadius() == other.getHintRadius() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsHintValid()))) + 9)) + getConfigId();
            if (hasHintCenterPos()) {
                hash = (53 * ((37 * hash) + 3)) + getHintCenterPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + getMaterialId())) + 13)) + Internal.hashBoolean(getIsAllCollected()))) + 14)) + getGroupId())) + 5)) + getHintRadius())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DetectorData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DetectorData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DetectorData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DetectorData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DetectorData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DetectorData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DetectorData parseFrom(InputStream input) throws IOException {
            return (DetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DetectorData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DetectorData parseDelimitedFrom(InputStream input) throws IOException {
            return (DetectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DetectorData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DetectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DetectorData parseFrom(CodedInputStream input) throws IOException {
            return (DetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DetectorData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DetectorData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DetectorDataOuterClass$DetectorData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DetectorDataOrBuilder {
            private boolean isHintValid_;
            private int configId_;
            private VectorOuterClass.Vector hintCenterPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> hintCenterPosBuilder_;
            private int materialId_;
            private boolean isAllCollected_;
            private int groupId_;
            private int hintRadius_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DetectorDataOuterClass.internal_static_DetectorData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DetectorDataOuterClass.internal_static_DetectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(DetectorData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DetectorData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isHintValid_ = false;
                this.configId_ = 0;
                if (this.hintCenterPosBuilder_ == null) {
                    this.hintCenterPos_ = null;
                } else {
                    this.hintCenterPos_ = null;
                    this.hintCenterPosBuilder_ = null;
                }
                this.materialId_ = 0;
                this.isAllCollected_ = false;
                this.groupId_ = 0;
                this.hintRadius_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DetectorDataOuterClass.internal_static_DetectorData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DetectorData getDefaultInstanceForType() {
                return DetectorData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DetectorData build() {
                DetectorData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DetectorData buildPartial() {
                DetectorData result = new DetectorData(this);
                result.isHintValid_ = this.isHintValid_;
                result.configId_ = this.configId_;
                if (this.hintCenterPosBuilder_ == null) {
                    result.hintCenterPos_ = this.hintCenterPos_;
                } else {
                    result.hintCenterPos_ = this.hintCenterPosBuilder_.build();
                }
                result.materialId_ = this.materialId_;
                result.isAllCollected_ = this.isAllCollected_;
                result.groupId_ = this.groupId_;
                result.hintRadius_ = this.hintRadius_;
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
                if (other instanceof DetectorData) {
                    return mergeFrom((DetectorData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DetectorData other) {
                if (other == DetectorData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsHintValid()) {
                    setIsHintValid(other.getIsHintValid());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (other.hasHintCenterPos()) {
                    mergeHintCenterPos(other.getHintCenterPos());
                }
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
                }
                if (other.getIsAllCollected()) {
                    setIsAllCollected(other.getIsAllCollected());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.getHintRadius() != 0) {
                    setHintRadius(other.getHintRadius());
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
                DetectorData parsedMessage = null;
                try {
                    try {
                        parsedMessage = DetectorData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DetectorData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
            public boolean hasHintCenterPos() {
                return (this.hintCenterPosBuilder_ == null && this.hintCenterPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
            public boolean getIsAllCollected() {
                return this.isAllCollected_;
            }

            public Builder setIsAllCollected(boolean value) {
                this.isAllCollected_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAllCollected() {
                this.isAllCollected_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.DetectorDataOuterClass.DetectorDataOrBuilder
            public int getHintRadius() {
                return this.hintRadius_;
            }

            public Builder setHintRadius(int value) {
                this.hintRadius_ = value;
                onChanged();
                return this;
            }

            public Builder clearHintRadius() {
                this.hintRadius_ = 0;
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

        public static DetectorData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DetectorData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DetectorData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DetectorData getDefaultInstanceForType() {
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
