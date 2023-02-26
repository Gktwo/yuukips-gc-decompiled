package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureSuiteDataOuterClass.class */
public final class HomeFurnitureSuiteDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cHomeFurnitureSuiteData.proto\u001a\fVector.proto\"\u0001\n\u0016HomeFurnitureSuiteData\u0012\"\n\u001aincludedFurnitureIndexList\u0018\u0007 \u0003(\u0005\u0012\f\n\u0004guid\u0018\f \u0001(\r\u0012\u000f\n\u0007suiteId\u0018\u000f \u0001(\r\u0012\u0015\n\risAllowSummon\u0018\u000e \u0001(\b\u0012\u0019\n\bspawnPos\u0018\n \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeFurnitureSuiteData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeFurnitureSuiteData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeFurnitureSuiteData_descriptor, new String[]{"IncludedFurnitureIndexList", "Guid", "SuiteId", "IsAllowSummon", "SpawnPos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureSuiteDataOuterClass$HomeFurnitureSuiteDataOrBuilder.class */
    public interface HomeFurnitureSuiteDataOrBuilder extends MessageOrBuilder {
        List<Integer> getIncludedFurnitureIndexListList();

        int getIncludedFurnitureIndexListCount();

        int getIncludedFurnitureIndexList(int i);

        int getGuid();

        int getSuiteId();

        boolean getIsAllowSummon();

        boolean hasSpawnPos();

        VectorOuterClass.Vector getSpawnPos();

        VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder();
    }

    private HomeFurnitureSuiteDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureSuiteDataOuterClass$HomeFurnitureSuiteData.class */
    public static final class HomeFurnitureSuiteData extends GeneratedMessageV3 implements HomeFurnitureSuiteDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INCLUDEDFURNITUREINDEXLIST_FIELD_NUMBER = 7;
        private Internal.IntList includedFurnitureIndexList_;
        private int includedFurnitureIndexListMemoizedSerializedSize;
        public static final int GUID_FIELD_NUMBER = 12;
        private int guid_;
        public static final int SUITEID_FIELD_NUMBER = 15;
        private int suiteId_;
        public static final int ISALLOWSUMMON_FIELD_NUMBER = 14;
        private boolean isAllowSummon_;
        public static final int SPAWNPOS_FIELD_NUMBER = 10;
        private VectorOuterClass.Vector spawnPos_;
        private byte memoizedIsInitialized;
        private static final HomeFurnitureSuiteData DEFAULT_INSTANCE = new HomeFurnitureSuiteData();
        private static final Parser<HomeFurnitureSuiteData> PARSER = new AbstractParser<HomeFurnitureSuiteData>() { // from class: emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.1
            @Override // com.google.protobuf.Parser
            public HomeFurnitureSuiteData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeFurnitureSuiteData(input, extensionRegistry);
            }
        };

        private HomeFurnitureSuiteData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.includedFurnitureIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeFurnitureSuiteData() {
            this.includedFurnitureIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.includedFurnitureIndexList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeFurnitureSuiteData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeFurnitureSuiteData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.includedFurnitureIndexList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.includedFurnitureIndexList_.addInt(input.readInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.includedFurnitureIndexList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.includedFurnitureIndexList_.addInt(input.readInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 82:
                                VectorOuterClass.Vector.Builder subBuilder = this.spawnPos_ != null ? this.spawnPos_.toBuilder() : null;
                                this.spawnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.spawnPos_);
                                    this.spawnPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 96:
                                this.guid_ = input.readUInt32();
                                break;
                            case 112:
                                this.isAllowSummon_ = input.readBool();
                                break;
                            case 120:
                                this.suiteId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.includedFurnitureIndexList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeFurnitureSuiteDataOuterClass.internal_static_HomeFurnitureSuiteData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeFurnitureSuiteDataOuterClass.internal_static_HomeFurnitureSuiteData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureSuiteData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public List<Integer> getIncludedFurnitureIndexListList() {
            return this.includedFurnitureIndexList_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public int getIncludedFurnitureIndexListCount() {
            return this.includedFurnitureIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public int getIncludedFurnitureIndexList(int index) {
            return this.includedFurnitureIndexList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public int getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public int getSuiteId() {
            return this.suiteId_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public boolean getIsAllowSummon() {
            return this.isAllowSummon_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public boolean hasSpawnPos() {
            return this.spawnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public VectorOuterClass.Vector getSpawnPos() {
            return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
        public VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder() {
            return getSpawnPos();
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
            getSerializedSize();
            if (getIncludedFurnitureIndexListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.includedFurnitureIndexListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.includedFurnitureIndexList_.size(); i++) {
                output.writeInt32NoTag(this.includedFurnitureIndexList_.getInt(i));
            }
            if (this.spawnPos_ != null) {
                output.writeMessage(10, getSpawnPos());
            }
            if (this.guid_ != 0) {
                output.writeUInt32(12, this.guid_);
            }
            if (this.isAllowSummon_) {
                output.writeBool(14, this.isAllowSummon_);
            }
            if (this.suiteId_ != 0) {
                output.writeUInt32(15, this.suiteId_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.includedFurnitureIndexList_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.includedFurnitureIndexList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getIncludedFurnitureIndexListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.includedFurnitureIndexListMemoizedSerializedSize = dataSize;
            if (this.spawnPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getSpawnPos());
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.guid_);
            }
            if (this.isAllowSummon_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isAllowSummon_);
            }
            if (this.suiteId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.suiteId_);
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
            if (!(obj instanceof HomeFurnitureSuiteData)) {
                return equals(obj);
            }
            HomeFurnitureSuiteData other = (HomeFurnitureSuiteData) obj;
            if (getIncludedFurnitureIndexListList().equals(other.getIncludedFurnitureIndexListList()) && getGuid() == other.getGuid() && getSuiteId() == other.getSuiteId() && getIsAllowSummon() == other.getIsAllowSummon() && hasSpawnPos() == other.hasSpawnPos()) {
                return (!hasSpawnPos() || getSpawnPos().equals(other.getSpawnPos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getIncludedFurnitureIndexListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getIncludedFurnitureIndexListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + getGuid())) + 15)) + getSuiteId())) + 14)) + Internal.hashBoolean(getIsAllowSummon());
            if (hasSpawnPos()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getSpawnPos().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static HomeFurnitureSuiteData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureSuiteData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureSuiteData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureSuiteData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureSuiteData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureSuiteData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureSuiteData parseFrom(InputStream input) throws IOException {
            return (HomeFurnitureSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureSuiteData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureSuiteData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeFurnitureSuiteData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeFurnitureSuiteData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureSuiteData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureSuiteData parseFrom(CodedInputStream input) throws IOException {
            return (HomeFurnitureSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureSuiteData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeFurnitureSuiteData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureSuiteDataOuterClass$HomeFurnitureSuiteData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeFurnitureSuiteDataOrBuilder {
            private int bitField0_;
            private Internal.IntList includedFurnitureIndexList_ = HomeFurnitureSuiteData.emptyIntList();
            private int guid_;
            private int suiteId_;
            private boolean isAllowSummon_;
            private VectorOuterClass.Vector spawnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnPosBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeFurnitureSuiteDataOuterClass.internal_static_HomeFurnitureSuiteData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeFurnitureSuiteDataOuterClass.internal_static_HomeFurnitureSuiteData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureSuiteData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeFurnitureSuiteData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.includedFurnitureIndexList_ = HomeFurnitureSuiteData.emptyIntList();
                this.bitField0_ &= -2;
                this.guid_ = 0;
                this.suiteId_ = 0;
                this.isAllowSummon_ = false;
                if (this.spawnPosBuilder_ == null) {
                    this.spawnPos_ = null;
                } else {
                    this.spawnPos_ = null;
                    this.spawnPosBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeFurnitureSuiteDataOuterClass.internal_static_HomeFurnitureSuiteData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeFurnitureSuiteData getDefaultInstanceForType() {
                return HomeFurnitureSuiteData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureSuiteData build() {
                HomeFurnitureSuiteData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureSuiteData buildPartial() {
                HomeFurnitureSuiteData result = new HomeFurnitureSuiteData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.includedFurnitureIndexList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.includedFurnitureIndexList_ = this.includedFurnitureIndexList_;
                result.guid_ = this.guid_;
                result.suiteId_ = this.suiteId_;
                result.isAllowSummon_ = this.isAllowSummon_;
                if (this.spawnPosBuilder_ == null) {
                    result.spawnPos_ = this.spawnPos_;
                } else {
                    result.spawnPos_ = this.spawnPosBuilder_.build();
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
                if (other instanceof HomeFurnitureSuiteData) {
                    return mergeFrom((HomeFurnitureSuiteData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeFurnitureSuiteData other) {
                if (other == HomeFurnitureSuiteData.getDefaultInstance()) {
                    return this;
                }
                if (!other.includedFurnitureIndexList_.isEmpty()) {
                    if (this.includedFurnitureIndexList_.isEmpty()) {
                        this.includedFurnitureIndexList_ = other.includedFurnitureIndexList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureIncludedFurnitureIndexListIsMutable();
                        this.includedFurnitureIndexList_.addAll(other.includedFurnitureIndexList_);
                    }
                    onChanged();
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getSuiteId() != 0) {
                    setSuiteId(other.getSuiteId());
                }
                if (other.getIsAllowSummon()) {
                    setIsAllowSummon(other.getIsAllowSummon());
                }
                if (other.hasSpawnPos()) {
                    mergeSpawnPos(other.getSpawnPos());
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
                HomeFurnitureSuiteData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeFurnitureSuiteData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeFurnitureSuiteData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureIncludedFurnitureIndexListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.includedFurnitureIndexList_ = HomeFurnitureSuiteData.mutableCopy(this.includedFurnitureIndexList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
            public List<Integer> getIncludedFurnitureIndexListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.includedFurnitureIndexList_) : this.includedFurnitureIndexList_;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
            public int getIncludedFurnitureIndexListCount() {
                return this.includedFurnitureIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
            public int getIncludedFurnitureIndexList(int index) {
                return this.includedFurnitureIndexList_.getInt(index);
            }

            public Builder setIncludedFurnitureIndexList(int index, int value) {
                ensureIncludedFurnitureIndexListIsMutable();
                this.includedFurnitureIndexList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addIncludedFurnitureIndexList(int value) {
                ensureIncludedFurnitureIndexListIsMutable();
                this.includedFurnitureIndexList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllIncludedFurnitureIndexList(Iterable<? extends Integer> values) {
                ensureIncludedFurnitureIndexListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.includedFurnitureIndexList_);
                onChanged();
                return this;
            }

            public Builder clearIncludedFurnitureIndexList() {
                this.includedFurnitureIndexList_ = HomeFurnitureSuiteData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
            public int getSuiteId() {
                return this.suiteId_;
            }

            public Builder setSuiteId(int value) {
                this.suiteId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSuiteId() {
                this.suiteId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
            public boolean getIsAllowSummon() {
                return this.isAllowSummon_;
            }

            public Builder setIsAllowSummon(boolean value) {
                this.isAllowSummon_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAllowSummon() {
                this.isAllowSummon_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
            public boolean hasSpawnPos() {
                return (this.spawnPosBuilder_ == null && this.spawnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static HomeFurnitureSuiteData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeFurnitureSuiteData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeFurnitureSuiteData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeFurnitureSuiteData getDefaultInstanceForType() {
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
