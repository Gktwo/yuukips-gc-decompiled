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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureCustomSuiteDataOuterClass.class */
public final class HomeFurnitureCustomSuiteDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"HomeFurnitureCustomSuiteData.proto\u001a\fVector.proto\"k\n\u001cHomeFurnitureCustomSuiteData\u0012\f\n\u0004guid\u0018\n \u0001(\r\u0012\"\n\u001aincludedFurnitureIndexList\u0018\u0005 \u0003(\u0005\u0012\u0019\n\bspawnPos\u0018\u0006 \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeFurnitureCustomSuiteData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeFurnitureCustomSuiteData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeFurnitureCustomSuiteData_descriptor, new String[]{"Guid", "IncludedFurnitureIndexList", "SpawnPos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureCustomSuiteDataOuterClass$HomeFurnitureCustomSuiteDataOrBuilder.class */
    public interface HomeFurnitureCustomSuiteDataOrBuilder extends MessageOrBuilder {
        int getGuid();

        List<Integer> getIncludedFurnitureIndexListList();

        int getIncludedFurnitureIndexListCount();

        int getIncludedFurnitureIndexList(int i);

        boolean hasSpawnPos();

        VectorOuterClass.Vector getSpawnPos();

        VectorOuterClass.VectorOrBuilder getSpawnPosOrBuilder();
    }

    private HomeFurnitureCustomSuiteDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureCustomSuiteDataOuterClass$HomeFurnitureCustomSuiteData.class */
    public static final class HomeFurnitureCustomSuiteData extends GeneratedMessageV3 implements HomeFurnitureCustomSuiteDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUID_FIELD_NUMBER = 10;
        private int guid_;
        public static final int INCLUDEDFURNITUREINDEXLIST_FIELD_NUMBER = 5;
        private Internal.IntList includedFurnitureIndexList_;
        private int includedFurnitureIndexListMemoizedSerializedSize;
        public static final int SPAWNPOS_FIELD_NUMBER = 6;
        private VectorOuterClass.Vector spawnPos_;
        private byte memoizedIsInitialized;
        private static final HomeFurnitureCustomSuiteData DEFAULT_INSTANCE = new HomeFurnitureCustomSuiteData();
        private static final Parser<HomeFurnitureCustomSuiteData> PARSER = new AbstractParser<HomeFurnitureCustomSuiteData>() { // from class: emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.1
            @Override // com.google.protobuf.Parser
            public HomeFurnitureCustomSuiteData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeFurnitureCustomSuiteData(input, extensionRegistry);
            }
        };

        private HomeFurnitureCustomSuiteData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.includedFurnitureIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeFurnitureCustomSuiteData() {
            this.includedFurnitureIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.includedFurnitureIndexList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeFurnitureCustomSuiteData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeFurnitureCustomSuiteData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.includedFurnitureIndexList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.includedFurnitureIndexList_.addInt(input.readInt32());
                                break;
                            case 42:
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
                            case 50:
                                VectorOuterClass.Vector.Builder subBuilder = this.spawnPos_ != null ? this.spawnPos_.toBuilder() : null;
                                this.spawnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.spawnPos_);
                                    this.spawnPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 80:
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.includedFurnitureIndexList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeFurnitureCustomSuiteDataOuterClass.internal_static_HomeFurnitureCustomSuiteData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeFurnitureCustomSuiteDataOuterClass.internal_static_HomeFurnitureCustomSuiteData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureCustomSuiteData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
        public int getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
        public List<Integer> getIncludedFurnitureIndexListList() {
            return this.includedFurnitureIndexList_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
        public int getIncludedFurnitureIndexListCount() {
            return this.includedFurnitureIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
        public int getIncludedFurnitureIndexList(int index) {
            return this.includedFurnitureIndexList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
        public boolean hasSpawnPos() {
            return this.spawnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
        public VectorOuterClass.Vector getSpawnPos() {
            return this.spawnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.spawnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
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
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.includedFurnitureIndexListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.includedFurnitureIndexList_.size(); i++) {
                output.writeInt32NoTag(this.includedFurnitureIndexList_.getInt(i));
            }
            if (this.spawnPos_ != null) {
                output.writeMessage(6, getSpawnPos());
            }
            if (this.guid_ != 0) {
                output.writeUInt32(10, this.guid_);
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
                size2 += CodedOutputStream.computeMessageSize(6, getSpawnPos());
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.guid_);
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
            if (!(obj instanceof HomeFurnitureCustomSuiteData)) {
                return equals(obj);
            }
            HomeFurnitureCustomSuiteData other = (HomeFurnitureCustomSuiteData) obj;
            if (getGuid() == other.getGuid() && getIncludedFurnitureIndexListList().equals(other.getIncludedFurnitureIndexListList()) && hasSpawnPos() == other.hasSpawnPos()) {
                return (!hasSpawnPos() || getSpawnPos().equals(other.getSpawnPos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getGuid();
            if (getIncludedFurnitureIndexListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getIncludedFurnitureIndexListList().hashCode();
            }
            if (hasSpawnPos()) {
                hash = (53 * ((37 * hash) + 6)) + getSpawnPos().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeFurnitureCustomSuiteData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(InputStream input) throws IOException {
            return (HomeFurnitureCustomSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureCustomSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureCustomSuiteData parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeFurnitureCustomSuiteData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeFurnitureCustomSuiteData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureCustomSuiteData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(CodedInputStream input) throws IOException {
            return (HomeFurnitureCustomSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeFurnitureCustomSuiteData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeFurnitureCustomSuiteData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeFurnitureCustomSuiteData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeFurnitureCustomSuiteDataOuterClass$HomeFurnitureCustomSuiteData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeFurnitureCustomSuiteDataOrBuilder {
            private int bitField0_;
            private int guid_;
            private Internal.IntList includedFurnitureIndexList_ = HomeFurnitureCustomSuiteData.emptyIntList();
            private VectorOuterClass.Vector spawnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> spawnPosBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeFurnitureCustomSuiteDataOuterClass.internal_static_HomeFurnitureCustomSuiteData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeFurnitureCustomSuiteDataOuterClass.internal_static_HomeFurnitureCustomSuiteData_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeFurnitureCustomSuiteData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeFurnitureCustomSuiteData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guid_ = 0;
                this.includedFurnitureIndexList_ = HomeFurnitureCustomSuiteData.emptyIntList();
                this.bitField0_ &= -2;
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
                return HomeFurnitureCustomSuiteDataOuterClass.internal_static_HomeFurnitureCustomSuiteData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeFurnitureCustomSuiteData getDefaultInstanceForType() {
                return HomeFurnitureCustomSuiteData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureCustomSuiteData build() {
                HomeFurnitureCustomSuiteData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeFurnitureCustomSuiteData buildPartial() {
                HomeFurnitureCustomSuiteData result = new HomeFurnitureCustomSuiteData(this);
                int i = this.bitField0_;
                result.guid_ = this.guid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.includedFurnitureIndexList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.includedFurnitureIndexList_ = this.includedFurnitureIndexList_;
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
                if (other instanceof HomeFurnitureCustomSuiteData) {
                    return mergeFrom((HomeFurnitureCustomSuiteData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeFurnitureCustomSuiteData other) {
                if (other == HomeFurnitureCustomSuiteData.getDefaultInstance()) {
                    return this;
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
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
                HomeFurnitureCustomSuiteData parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeFurnitureCustomSuiteData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeFurnitureCustomSuiteData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
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

            private void ensureIncludedFurnitureIndexListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.includedFurnitureIndexList_ = HomeFurnitureCustomSuiteData.mutableCopy(this.includedFurnitureIndexList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
            public List<Integer> getIncludedFurnitureIndexListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.includedFurnitureIndexList_) : this.includedFurnitureIndexList_;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
            public int getIncludedFurnitureIndexListCount() {
                return this.includedFurnitureIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
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
                this.includedFurnitureIndexList_ = HomeFurnitureCustomSuiteData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
            public boolean hasSpawnPos() {
                return (this.spawnPosBuilder_ == null && this.spawnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder
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

        public static HomeFurnitureCustomSuiteData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeFurnitureCustomSuiteData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeFurnitureCustomSuiteData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeFurnitureCustomSuiteData getDefaultInstanceForType() {
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
