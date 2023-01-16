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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerEnterLevelRspOuterClass.class */
public final class TowerEnterLevelRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018TowerEnterLevelRsp.proto\"h\n\u0012TowerEnterLevelRsp\u0012\u001a\n\u0012tower_buff_id_list\u0018\u0005 \u0003(\r\u0012\u0013\n\u000blevel_index\u0018\u0003 \u0001(\r\u0012\u0010\n\bfloor_id\u0018\u000b \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TowerEnterLevelRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerEnterLevelRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerEnterLevelRsp_descriptor, new String[]{"TowerBuffIdList", "LevelIndex", "FloorId", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerEnterLevelRspOuterClass$TowerEnterLevelRspOrBuilder.class */
    public interface TowerEnterLevelRspOrBuilder extends MessageOrBuilder {
        List<Integer> getTowerBuffIdListList();

        int getTowerBuffIdListCount();

        int getTowerBuffIdList(int i);

        int getLevelIndex();

        int getFloorId();

        int getRetcode();
    }

    private TowerEnterLevelRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerEnterLevelRspOuterClass$TowerEnterLevelRsp.class */
    public static final class TowerEnterLevelRsp extends GeneratedMessageV3 implements TowerEnterLevelRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TOWER_BUFF_ID_LIST_FIELD_NUMBER = 5;
        private Internal.IntList towerBuffIdList_;
        private int towerBuffIdListMemoizedSerializedSize;
        public static final int LEVEL_INDEX_FIELD_NUMBER = 3;
        private int levelIndex_;
        public static final int FLOOR_ID_FIELD_NUMBER = 11;
        private int floorId_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TowerEnterLevelRsp DEFAULT_INSTANCE = new TowerEnterLevelRsp();
        private static final Parser<TowerEnterLevelRsp> PARSER = new AbstractParser<TowerEnterLevelRsp>() { // from class: emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRsp.1
            @Override // com.google.protobuf.Parser
            public TowerEnterLevelRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerEnterLevelRsp(input, extensionRegistry);
            }
        };

        private TowerEnterLevelRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.towerBuffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TowerEnterLevelRsp() {
            this.towerBuffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.towerBuffIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerEnterLevelRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerEnterLevelRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.levelIndex_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.towerBuffIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.towerBuffIdList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.towerBuffIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.towerBuffIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.floorId_ = input.readUInt32();
                                break;
                            case 112:
                                this.retcode_ = input.readInt32();
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
                    this.towerBuffIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerEnterLevelRspOuterClass.internal_static_TowerEnterLevelRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerEnterLevelRspOuterClass.internal_static_TowerEnterLevelRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerEnterLevelRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
        public List<Integer> getTowerBuffIdListList() {
            return this.towerBuffIdList_;
        }

        @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
        public int getTowerBuffIdListCount() {
            return this.towerBuffIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
        public int getTowerBuffIdList(int index) {
            return this.towerBuffIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
        public int getLevelIndex() {
            return this.levelIndex_;
        }

        @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
        public int getFloorId() {
            return this.floorId_;
        }

        @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.levelIndex_ != 0) {
                output.writeUInt32(3, this.levelIndex_);
            }
            if (getTowerBuffIdListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.towerBuffIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.towerBuffIdList_.size(); i++) {
                output.writeUInt32NoTag(this.towerBuffIdList_.getInt(i));
            }
            if (this.floorId_ != 0) {
                output.writeUInt32(11, this.floorId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (this.levelIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.levelIndex_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.towerBuffIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.towerBuffIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTowerBuffIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.towerBuffIdListMemoizedSerializedSize = dataSize;
            if (this.floorId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.floorId_);
            }
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(14, this.retcode_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TowerEnterLevelRsp)) {
                return equals(obj);
            }
            TowerEnterLevelRsp other = (TowerEnterLevelRsp) obj;
            return getTowerBuffIdListList().equals(other.getTowerBuffIdListList()) && getLevelIndex() == other.getLevelIndex() && getFloorId() == other.getFloorId() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTowerBuffIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getTowerBuffIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getLevelIndex())) + 11)) + getFloorId())) + 14)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerEnterLevelRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerEnterLevelRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerEnterLevelRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerEnterLevelRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerEnterLevelRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerEnterLevelRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerEnterLevelRsp parseFrom(InputStream input) throws IOException {
            return (TowerEnterLevelRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerEnterLevelRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerEnterLevelRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerEnterLevelRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerEnterLevelRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerEnterLevelRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerEnterLevelRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerEnterLevelRsp parseFrom(CodedInputStream input) throws IOException {
            return (TowerEnterLevelRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerEnterLevelRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerEnterLevelRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerEnterLevelRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerEnterLevelRspOuterClass$TowerEnterLevelRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerEnterLevelRspOrBuilder {
            private int bitField0_;
            private Internal.IntList towerBuffIdList_ = TowerEnterLevelRsp.emptyIntList();
            private int levelIndex_;
            private int floorId_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerEnterLevelRspOuterClass.internal_static_TowerEnterLevelRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerEnterLevelRspOuterClass.internal_static_TowerEnterLevelRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerEnterLevelRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerEnterLevelRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.towerBuffIdList_ = TowerEnterLevelRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.levelIndex_ = 0;
                this.floorId_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerEnterLevelRspOuterClass.internal_static_TowerEnterLevelRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerEnterLevelRsp getDefaultInstanceForType() {
                return TowerEnterLevelRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerEnterLevelRsp build() {
                TowerEnterLevelRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerEnterLevelRsp buildPartial() {
                TowerEnterLevelRsp result = new TowerEnterLevelRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.towerBuffIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.towerBuffIdList_ = this.towerBuffIdList_;
                result.levelIndex_ = this.levelIndex_;
                result.floorId_ = this.floorId_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof TowerEnterLevelRsp) {
                    return mergeFrom((TowerEnterLevelRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerEnterLevelRsp other) {
                if (other == TowerEnterLevelRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.towerBuffIdList_.isEmpty()) {
                    if (this.towerBuffIdList_.isEmpty()) {
                        this.towerBuffIdList_ = other.towerBuffIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTowerBuffIdListIsMutable();
                        this.towerBuffIdList_.addAll(other.towerBuffIdList_);
                    }
                    onChanged();
                }
                if (other.getLevelIndex() != 0) {
                    setLevelIndex(other.getLevelIndex());
                }
                if (other.getFloorId() != 0) {
                    setFloorId(other.getFloorId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                TowerEnterLevelRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerEnterLevelRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerEnterLevelRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTowerBuffIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.towerBuffIdList_ = TowerEnterLevelRsp.mutableCopy(this.towerBuffIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
            public List<Integer> getTowerBuffIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.towerBuffIdList_) : this.towerBuffIdList_;
            }

            @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
            public int getTowerBuffIdListCount() {
                return this.towerBuffIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
            public int getTowerBuffIdList(int index) {
                return this.towerBuffIdList_.getInt(index);
            }

            public Builder setTowerBuffIdList(int index, int value) {
                ensureTowerBuffIdListIsMutable();
                this.towerBuffIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTowerBuffIdList(int value) {
                ensureTowerBuffIdListIsMutable();
                this.towerBuffIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTowerBuffIdList(Iterable<? extends Integer> values) {
                ensureTowerBuffIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.towerBuffIdList_);
                onChanged();
                return this;
            }

            public Builder clearTowerBuffIdList() {
                this.towerBuffIdList_ = TowerEnterLevelRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
            public int getLevelIndex() {
                return this.levelIndex_;
            }

            public Builder setLevelIndex(int value) {
                this.levelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelIndex() {
                this.levelIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
            public int getFloorId() {
                return this.floorId_;
            }

            public Builder setFloorId(int value) {
                this.floorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFloorId() {
                this.floorId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass.TowerEnterLevelRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TowerEnterLevelRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerEnterLevelRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerEnterLevelRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerEnterLevelRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
