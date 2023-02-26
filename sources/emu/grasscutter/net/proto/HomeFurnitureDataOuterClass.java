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
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureDataOuterClass.class */
public final class HomeFurnitureDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017HomeFurnitureData.proto\u001a\fVector.proto\"\u0001\n\u0011HomeFurnitureData\u0012\u000f\n\u0007version\u0018\u0005 \u0001(\r\u0012\u001c\n\u0014parentFurnitureIndex\u0018\t \u0001(\u0005\u0012\u0019\n\bspawnRot\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0019\n\bspawnPos\u0018\u0002 \u0001(\u000b2\u0007.Vector\u0012\f\n\u0004guid\u0018\u000e \u0001(\r\u0012\u0013\n\u000bfurnitureId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeFurnitureData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeFurnitureData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeFurnitureData_descriptor, new String[]{"Version", "ParentFurnitureIndex", "SpawnRot", "SpawnPos", "Guid", "FurnitureId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureDataOuterClass$HomeFurnitureDataOrBuilder.class */
    public interface HomeFurnitureDataOrBuilder extends MessageOrBuilder {
        int getVersion();

        int getParentFurnitureIndex();

        boolean hasSpawnRot();

        VectorOuterClass.Vector getSpawnRot();

        VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder();

        boolean hasSpawnPos();

        VectorOuterClass.Vector getSpawnPos();

        VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder();

        int getGuid();

        int getFurnitureId();
    }

    private HomeFurnitureDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureDataOuterClass$HomeFurnitureData.class */
    public static final class HomeFurnitureData extends GeneratedMessageV3 implements HomeFurnitureDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VERSION_FIELD_NUMBER = 5;
        private int version_;
        public static final int PARENTFURNITUREINDEX_FIELD_NUMBER = 9;
        private int parentFurnitureIndex_;
        public static final int SPAWNROT_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector spawnRot_;
        public static final int SPAWNPOS_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector spawnPos_;
        public static final int GUID_FIELD_NUMBER = 14;
        private int guid_;
        public static final int FURNITUREID_FIELD_NUMBER = 11;
        private int furnitureId_;
        private byte memoizedIsInitialized;
        private static final HomeFurnitureData DEFAULT_INSTANCE = new HomeFurnitureData();
        private static final Parser<HomeFurnitureData> PARSER = new AbstractParser<HomeFurnitureData>() { // from class: emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureData.1
            @Override // com.google.protobuf.Parser
            public HomeFurnitureData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeFurnitureData(input, extensionRegistry);
            }
        };

        private HomeFurnitureData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeFurnitureData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeFurnitureData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeFurnitureData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                VectorOuterClass.Vector.Builder subBuilder = this.spawnPos_ != null ? this.spawnPos_.toBuilder() : null;
                                this.spawnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.spawnPos_);
                                    this.spawnPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 40:
                                this.version_ = input.readUInt32();
                                break;
                            case 72:
                                this.parentFurnitureIndex_ = input.readInt32();
                                break;
                            case 88:
                                this.furnitureId_ = input.readUInt32();
                                break;
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.spawnRot_ != null ? this.spawnRot_.toBuilder() : null;
                                this.spawnRot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.spawnRot_);
                                    this.spawnRot_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 112:
                                this.guid_ = input.readUInt32();
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
            return HomeFurnitureDataOuterClass.internal_static_HomeFurnitureData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeFurnitureDataOuterClass.internal_static_HomeFurnitureData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public int getParentFurnitureIndex() {
            return this.parentFurnitureIndex_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public boolean hasSpawnRot() {
            return this.spawnRot_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public VectorOuterClass.Vector getSpawnRot() {
            return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder() {
            return getSpawnRot();
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public boolean hasSpawnPos() {
            return this.spawnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public VectorOuterClass.Vector getSpawnPos() {
            return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder() {
            return getSpawnPos();
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public int getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
        public int getFurnitureId() {
            return this.furnitureId_;
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
            if (this.spawnPos_ != null) {
                output.writeMessage(2, getSpawnPos());
            }
            if (this.version_ != 0) {
                output.writeUInt32(5, this.version_);
            }
            if (this.parentFurnitureIndex_ != 0) {
                output.writeInt32(9, this.parentFurnitureIndex_);
            }
            if (this.furnitureId_ != 0) {
                output.writeUInt32(11, this.furnitureId_);
            }
            if (this.spawnRot_ != null) {
                output.writeMessage(12, getSpawnRot());
            }
            if (this.guid_ != 0) {
                output.writeUInt32(14, this.guid_);
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
            if (this.spawnPos_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getSpawnPos());
            }
            if (this.version_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.version_);
            }
            if (this.parentFurnitureIndex_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.parentFurnitureIndex_);
            }
            if (this.furnitureId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.furnitureId_);
            }
            if (this.spawnRot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getSpawnRot());
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.guid_);
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
            if (!(obj instanceof HomeFurnitureData)) {
                return equals(obj);
            }
            HomeFurnitureData other = (HomeFurnitureData) obj;
            if (getVersion() != other.getVersion() || getParentFurnitureIndex() != other.getParentFurnitureIndex() || hasSpawnRot() != other.hasSpawnRot()) {
                return false;
            }
            if ((!hasSpawnRot() || getSpawnRot().equals(other.getSpawnRot())) && hasSpawnPos() == other.hasSpawnPos()) {
                return (!hasSpawnPos() || getSpawnPos().equals(other.getSpawnPos())) && getGuid() == other.getGuid() && getFurnitureId() == other.getFurnitureId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getVersion())) + 9)) + getParentFurnitureIndex();
            if (hasSpawnRot()) {
                hash = (53 * ((37 * hash) + 12)) + getSpawnRot().hashCode();
            }
            if (hasSpawnPos()) {
                hash = (53 * ((37 * hash) + 2)) + getSpawnPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + getGuid())) + 11)) + getFurnitureId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeFurnitureData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureData parseFrom(InputStream input) throws IOException {
            return (HomeFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeFurnitureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeFurnitureData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureData parseFrom(CodedInputStream input) throws IOException {
            return (HomeFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeFurnitureData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureDataOuterClass$HomeFurnitureData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeFurnitureDataOrBuilder {
            private int version_;
            private int parentFurnitureIndex_;
            private VectorOuterClass.Vector spawnRot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnRotBuilder_;
            private VectorOuterClass.Vector spawnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnPosBuilder_;
            private int guid_;
            private int furnitureId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeFurnitureDataOuterClass.internal_static_HomeFurnitureData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeFurnitureDataOuterClass.internal_static_HomeFurnitureData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeFurnitureData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.version_ = 0;
                this.parentFurnitureIndex_ = 0;
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRot_ = null;
                } else {
                    this.spawnRot_ = null;
                    this.spawnRotBuilder_ = null;
                }
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = null;
                } else {
                    this.spawnPos_ = null;
                    this.spawnPosBuilder_ = null;
                }
                this.guid_ = 0;
                this.furnitureId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeFurnitureDataOuterClass.internal_static_HomeFurnitureData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeFurnitureData getDefaultInstanceForType() {
                return HomeFurnitureData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureData build() {
                HomeFurnitureData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureData buildPartial() {
                HomeFurnitureData result = new HomeFurnitureData(this);
                result.version_ = this.version_;
                result.parentFurnitureIndex_ = this.parentFurnitureIndex_;
                if (this.spawnRotBuilder_ == null) {
                    result.spawnRot_ = this.spawnRot_;
                } else {
                    result.spawnRot_ = this.spawnRotBuilder_.build();
                }
                if (this.spawnPosBuilder_ == null) {
                    result.spawnPos_ = this.spawnPos_;
                } else {
                    result.spawnPos_ = this.spawnPosBuilder_.build();
                }
                result.guid_ = this.guid_;
                result.furnitureId_ = this.furnitureId_;
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
                if (other instanceof HomeFurnitureData) {
                    return mergeFrom((HomeFurnitureData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeFurnitureData other) {
                if (other == HomeFurnitureData.getDefaultInstance()) {
                    return this;
                }
                if (other.getVersion() != 0) {
                    setVersion(other.getVersion());
                }
                if (other.getParentFurnitureIndex() != 0) {
                    setParentFurnitureIndex(other.getParentFurnitureIndex());
                }
                if (other.hasSpawnRot()) {
                    mergeSpawnRot(other.getSpawnRot());
                }
                if (other.hasSpawnPos()) {
                    mergeSpawnPos(other.getSpawnPos());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getFurnitureId() != 0) {
                    setFurnitureId(other.getFurnitureId());
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
                HomeFurnitureData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeFurnitureData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeFurnitureData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public int getVersion() {
                return this.version_;
            }

            public Builder setVersion(int value) {
                this.version_ = value;
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.version_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public int getParentFurnitureIndex() {
                return this.parentFurnitureIndex_;
            }

            public Builder setParentFurnitureIndex(int value) {
                this.parentFurnitureIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentFurnitureIndex() {
                this.parentFurnitureIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public boolean hasSpawnRot() {
                return (this.spawnRotBuilder_ == null && this.spawnRot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public VectorOuterClass.Vector getSpawnRot() {
                if (this.spawnRotBuilder_ == null) {
                    return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
                }
                return this.spawnRotBuilder_.getMessage();
            }

            public Builder setSpawnRot(VectorOuterClass.Vector value) {
                if (this.spawnRotBuilder_ != null) {
                    this.spawnRotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.spawnRot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSpawnRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.spawnRotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSpawnRot(VectorOuterClass.Vector value) {
                if (this.spawnRotBuilder_ == null) {
                    if (this.spawnRot_ != null) {
                        this.spawnRot_ = VectorOuterClass.Vector.newBuilder(this.spawnRot_).mergeFrom(value).buildPartial();
                    } else {
                        this.spawnRot_ = value;
                    }
                    onChanged();
                } else {
                    this.spawnRotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSpawnRot() {
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRot_ = null;
                    onChanged();
                } else {
                    this.spawnRot_ = null;
                    this.spawnRotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSpawnRotBuilder() {
                onChanged();
                return getSpawnRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getSpawnRotOrBuilder() {
                if (this.spawnRotBuilder_ != null) {
                    return this.spawnRotBuilder_.getMessageOrBuilder();
                }
                return this.spawnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnRot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSpawnRotFieldBuilder() {
                if (this.spawnRotBuilder_ == null) {
                    this.spawnRotBuilder_ = new SingleFieldBuilderV3<>(getSpawnRot(), getParentForChildren(), isClean());
                    this.spawnRot_ = null;
                }
                return this.spawnRotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public boolean hasSpawnPos() {
                return (this.spawnPosBuilder_ == null && this.spawnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public VectorOuterClass.Vector getSpawnPos() {
                if (this.spawnPosBuilder_ == null) {
                    return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
                }
                return this.spawnPosBuilder_.getMessage();
            }

            public Builder setSpawnPos(VectorOuterClass.Vector value) {
                if (this.spawnPosBuilder_ != null) {
                    this.spawnPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.spawnPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSpawnPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.spawnPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSpawnPos(VectorOuterClass.Vector value) {
                if (this.spawnPosBuilder_ == null) {
                    if (this.spawnPos_ != null) {
                        this.spawnPos_ = VectorOuterClass.Vector.newBuilder(this.spawnPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.spawnPos_ = value;
                    }
                    onChanged();
                } else {
                    this.spawnPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSpawnPos() {
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = null;
                    onChanged();
                } else {
                    this.spawnPos_ = null;
                    this.spawnPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getSpawnPosBuilder() {
                onChanged();
                return getSpawnPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder() {
                if (this.spawnPosBuilder_ != null) {
                    return this.spawnPosBuilder_.getMessageOrBuilder();
                }
                return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSpawnPosFieldBuilder() {
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPosBuilder_ = new SingleFieldBuilderV3<>(getSpawnPos(), getParentForChildren(), isClean());
                    this.spawnPos_ = null;
                }
                return this.spawnPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public int getGuid() {
                return this.guid_;
            }

            public Builder setGuid(int value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder
            public int getFurnitureId() {
                return this.furnitureId_;
            }

            public Builder setFurnitureId(int value) {
                this.furnitureId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFurnitureId() {
                this.furnitureId_ = 0;
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

        public static HomeFurnitureData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeFurnitureData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeFurnitureData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeFurnitureData getDefaultInstanceForType() {
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
