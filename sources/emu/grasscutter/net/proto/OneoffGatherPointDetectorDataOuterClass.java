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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OneoffGatherPointDetectorDataOuterClass.class */
public final class OneoffGatherPointDetectorDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#OneoffGatherPointDetectorData.proto\u001a\fVector.proto\"Á\u0001\n\u001dOneoffGatherPointDetectorData\u0012\u0013\n\u000bhint_radius\u0018\u0004 \u0001(\r\u0012\u0011\n\tconfig_id\u0018\u0003 \u0001(\r\u0012\u0015\n\ris_hint_valid\u0018\u000b \u0001(\b\u0012 \n\u000fhint_center_pos\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0018\n\u0010is_all_collected\u0018\n \u0001(\b\u0012\u0010\n\bgroup_id\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bmaterial_id\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_OneoffGatherPointDetectorData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_OneoffGatherPointDetectorData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_OneoffGatherPointDetectorData_descriptor, new String[]{"HintRadius", "ConfigId", "IsHintValid", "HintCenterPos", "IsAllCollected", "GroupId", "MaterialId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OneoffGatherPointDetectorDataOuterClass$OneoffGatherPointDetectorDataOrBuilder.class */
    public interface OneoffGatherPointDetectorDataOrBuilder extends MessageOrBuilder {
        int getHintRadius();

        int getConfigId();

        boolean getIsHintValid();

        boolean hasHintCenterPos();

        VectorOuterClass.Vector getHintCenterPos();

        VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder();

        boolean getIsAllCollected();

        int getGroupId();

        int getMaterialId();
    }

    private OneoffGatherPointDetectorDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OneoffGatherPointDetectorDataOuterClass$OneoffGatherPointDetectorData.class */
    public static final class OneoffGatherPointDetectorData extends GeneratedMessageV3 implements OneoffGatherPointDetectorDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HINT_RADIUS_FIELD_NUMBER = 4;
        private int hintRadius_;
        public static final int CONFIG_ID_FIELD_NUMBER = 3;
        private int configId_;
        public static final int IS_HINT_VALID_FIELD_NUMBER = 11;
        private boolean isHintValid_;
        public static final int HINT_CENTER_POS_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector hintCenterPos_;
        public static final int IS_ALL_COLLECTED_FIELD_NUMBER = 10;
        private boolean isAllCollected_;
        public static final int GROUP_ID_FIELD_NUMBER = 1;
        private int groupId_;
        public static final int MATERIAL_ID_FIELD_NUMBER = 9;
        private int materialId_;
        private byte memoizedIsInitialized;
        private static final OneoffGatherPointDetectorData DEFAULT_INSTANCE = new OneoffGatherPointDetectorData();
        private static final Parser<OneoffGatherPointDetectorData> PARSER = new AbstractParser<OneoffGatherPointDetectorData>() { // from class: emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorData.1
            @Override // com.google.protobuf.Parser
            public OneoffGatherPointDetectorData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OneoffGatherPointDetectorData(input, extensionRegistry);
            }
        };

        private OneoffGatherPointDetectorData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private OneoffGatherPointDetectorData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new OneoffGatherPointDetectorData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OneoffGatherPointDetectorData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.groupId_ = input.readUInt32();
                                break;
                            case 24:
                                this.configId_ = input.readUInt32();
                                break;
                            case 32:
                                this.hintRadius_ = input.readUInt32();
                                break;
                            case 72:
                                this.materialId_ = input.readUInt32();
                                break;
                            case 80:
                                this.isAllCollected_ = input.readBool();
                                break;
                            case 88:
                                this.isHintValid_ = input.readBool();
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
            return OneoffGatherPointDetectorDataOuterClass.internal_static_OneoffGatherPointDetectorData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OneoffGatherPointDetectorDataOuterClass.internal_static_OneoffGatherPointDetectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(OneoffGatherPointDetectorData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public int getHintRadius() {
            return this.hintRadius_;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public boolean getIsHintValid() {
            return this.isHintValid_;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public boolean hasHintCenterPos() {
            return this.hintCenterPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public VectorOuterClass.Vector getHintCenterPos() {
            return this.hintCenterPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.hintCenterPos_;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getHintCenterPosOrBuilder() {
            return getHintCenterPos();
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public boolean getIsAllCollected() {
            return this.isAllCollected_;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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
            if (this.groupId_ != 0) {
                output.writeUInt32(1, this.groupId_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(3, this.configId_);
            }
            if (this.hintRadius_ != 0) {
                output.writeUInt32(4, this.hintRadius_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(9, this.materialId_);
            }
            if (this.isAllCollected_) {
                output.writeBool(10, this.isAllCollected_);
            }
            if (this.isHintValid_) {
                output.writeBool(11, this.isHintValid_);
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
            if (this.groupId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.groupId_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.configId_);
            }
            if (this.hintRadius_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.hintRadius_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.materialId_);
            }
            if (this.isAllCollected_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isAllCollected_);
            }
            if (this.isHintValid_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isHintValid_);
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
            if (!(obj instanceof OneoffGatherPointDetectorData)) {
                return equals(obj);
            }
            OneoffGatherPointDetectorData other = (OneoffGatherPointDetectorData) obj;
            if (getHintRadius() == other.getHintRadius() && getConfigId() == other.getConfigId() && getIsHintValid() == other.getIsHintValid() && hasHintCenterPos() == other.hasHintCenterPos()) {
                return (!hasHintCenterPos() || getHintCenterPos().equals(other.getHintCenterPos())) && getIsAllCollected() == other.getIsAllCollected() && getGroupId() == other.getGroupId() && getMaterialId() == other.getMaterialId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getHintRadius())) + 3)) + getConfigId())) + 11)) + Internal.hashBoolean(getIsHintValid());
            if (hasHintCenterPos()) {
                hash = (53 * ((37 * hash) + 12)) + getHintCenterPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + Internal.hashBoolean(getIsAllCollected()))) + 1)) + getGroupId())) + 9)) + getMaterialId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static OneoffGatherPointDetectorData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OneoffGatherPointDetectorData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OneoffGatherPointDetectorData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OneoffGatherPointDetectorData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OneoffGatherPointDetectorData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OneoffGatherPointDetectorData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OneoffGatherPointDetectorData parseFrom(InputStream input) throws IOException {
            return (OneoffGatherPointDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OneoffGatherPointDetectorData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneoffGatherPointDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static OneoffGatherPointDetectorData parseDelimitedFrom(InputStream input) throws IOException {
            return (OneoffGatherPointDetectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static OneoffGatherPointDetectorData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneoffGatherPointDetectorData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static OneoffGatherPointDetectorData parseFrom(CodedInputStream input) throws IOException {
            return (OneoffGatherPointDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OneoffGatherPointDetectorData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OneoffGatherPointDetectorData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OneoffGatherPointDetectorData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OneoffGatherPointDetectorDataOuterClass$OneoffGatherPointDetectorData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OneoffGatherPointDetectorDataOrBuilder {
            private int hintRadius_;
            private int configId_;
            private boolean isHintValid_;
            private VectorOuterClass.Vector hintCenterPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> hintCenterPosBuilder_;
            private boolean isAllCollected_;
            private int groupId_;
            private int materialId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return OneoffGatherPointDetectorDataOuterClass.internal_static_OneoffGatherPointDetectorData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return OneoffGatherPointDetectorDataOuterClass.internal_static_OneoffGatherPointDetectorData_fieldAccessorTable.ensureFieldAccessorsInitialized(OneoffGatherPointDetectorData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OneoffGatherPointDetectorData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.hintRadius_ = 0;
                this.configId_ = 0;
                this.isHintValid_ = false;
                if (this.hintCenterPosBuilder_ == null) {
                    this.hintCenterPos_ = null;
                } else {
                    this.hintCenterPos_ = null;
                    this.hintCenterPosBuilder_ = null;
                }
                this.isAllCollected_ = false;
                this.groupId_ = 0;
                this.materialId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return OneoffGatherPointDetectorDataOuterClass.internal_static_OneoffGatherPointDetectorData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OneoffGatherPointDetectorData getDefaultInstanceForType() {
                return OneoffGatherPointDetectorData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OneoffGatherPointDetectorData build() {
                OneoffGatherPointDetectorData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OneoffGatherPointDetectorData buildPartial() {
                OneoffGatherPointDetectorData result = new OneoffGatherPointDetectorData(this);
                result.hintRadius_ = this.hintRadius_;
                result.configId_ = this.configId_;
                result.isHintValid_ = this.isHintValid_;
                if (this.hintCenterPosBuilder_ == null) {
                    result.hintCenterPos_ = this.hintCenterPos_;
                } else {
                    result.hintCenterPos_ = this.hintCenterPosBuilder_.build();
                }
                result.isAllCollected_ = this.isAllCollected_;
                result.groupId_ = this.groupId_;
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
                if (other instanceof OneoffGatherPointDetectorData) {
                    return mergeFrom((OneoffGatherPointDetectorData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OneoffGatherPointDetectorData other) {
                if (other == OneoffGatherPointDetectorData.getDefaultInstance()) {
                    return this;
                }
                if (other.getHintRadius() != 0) {
                    setHintRadius(other.getHintRadius());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (other.getIsHintValid()) {
                    setIsHintValid(other.getIsHintValid());
                }
                if (other.hasHintCenterPos()) {
                    mergeHintCenterPos(other.getHintCenterPos());
                }
                if (other.getIsAllCollected()) {
                    setIsAllCollected(other.getIsAllCollected());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
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
                OneoffGatherPointDetectorData parsedMessage = null;
                try {
                    try {
                        parsedMessage = OneoffGatherPointDetectorData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (OneoffGatherPointDetectorData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
            public boolean hasHintCenterPos() {
                return (this.hintCenterPosBuilder_ == null && this.hintCenterPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.OneoffGatherPointDetectorDataOuterClass.OneoffGatherPointDetectorDataOrBuilder
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

        public static OneoffGatherPointDetectorData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OneoffGatherPointDetectorData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OneoffGatherPointDetectorData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OneoffGatherPointDetectorData getDefaultInstanceForType() {
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
