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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonInfoOuterClass.class */
public final class ChannelerSlabLoopDungeonInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"ChannelerSlabLoopDungeonInfo.proto\"¬\u0001\n\u001cChannelerSlabLoopDungeonInfo\u0012\"\n\u001ais_first_pass_reward_taken\u0018\t \u0001(\b\u0012\r\n\u0005score\u0018\u0007 \u0001(\r\u0012\u001e\n\u0016last_condition_id_list\u0018\n \u0003(\r\u0012\u0015\n\rdungeon_index\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\u0004 \u0001(\b\u0012\u0011\n\topen_time\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChannelerSlabLoopDungeonInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChannelerSlabLoopDungeonInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabLoopDungeonInfo_descriptor, new String[]{"IsFirstPassRewardTaken", "Score", "LastConditionIdList", "DungeonIndex", "IsOpen", "OpenTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonInfoOuterClass$ChannelerSlabLoopDungeonInfoOrBuilder.class */
    public interface ChannelerSlabLoopDungeonInfoOrBuilder extends MessageOrBuilder {
        boolean getIsFirstPassRewardTaken();

        int getScore();

        List<Integer> getLastConditionIdListList();

        int getLastConditionIdListCount();

        int getLastConditionIdList(int i);

        int getDungeonIndex();

        boolean getIsOpen();

        int getOpenTime();
    }

    private ChannelerSlabLoopDungeonInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonInfoOuterClass$ChannelerSlabLoopDungeonInfo.class */
    public static final class ChannelerSlabLoopDungeonInfo extends GeneratedMessageV3 implements ChannelerSlabLoopDungeonInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FIRST_PASS_REWARD_TAKEN_FIELD_NUMBER = 9;
        private boolean isFirstPassRewardTaken_;
        public static final int SCORE_FIELD_NUMBER = 7;
        private int score_;
        public static final int LAST_CONDITION_ID_LIST_FIELD_NUMBER = 10;
        private Internal.IntList lastConditionIdList_;
        private int lastConditionIdListMemoizedSerializedSize;
        public static final int DUNGEON_INDEX_FIELD_NUMBER = 1;
        private int dungeonIndex_;
        public static final int IS_OPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        public static final int OPEN_TIME_FIELD_NUMBER = 13;
        private int openTime_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabLoopDungeonInfo DEFAULT_INSTANCE = new ChannelerSlabLoopDungeonInfo();
        private static final Parser<ChannelerSlabLoopDungeonInfo> PARSER = new AbstractParser<ChannelerSlabLoopDungeonInfo>() { // from class: emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabLoopDungeonInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabLoopDungeonInfo(input, extensionRegistry);
            }
        };

        private ChannelerSlabLoopDungeonInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.lastConditionIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabLoopDungeonInfo() {
            this.lastConditionIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.lastConditionIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabLoopDungeonInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannelerSlabLoopDungeonInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.dungeonIndex_ = input.readUInt32();
                                break;
                            case 32:
                                this.isOpen_ = input.readBool();
                                break;
                            case 56:
                                this.score_ = input.readUInt32();
                                break;
                            case 72:
                                this.isFirstPassRewardTaken_ = input.readBool();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.lastConditionIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.lastConditionIdList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.lastConditionIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.lastConditionIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 104:
                                this.openTime_ = input.readUInt32();
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
                    this.lastConditionIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChannelerSlabLoopDungeonInfoOuterClass.internal_static_ChannelerSlabLoopDungeonInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabLoopDungeonInfoOuterClass.internal_static_ChannelerSlabLoopDungeonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabLoopDungeonInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public boolean getIsFirstPassRewardTaken() {
            return this.isFirstPassRewardTaken_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public List<Integer> getLastConditionIdListList() {
            return this.lastConditionIdList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public int getLastConditionIdListCount() {
            return this.lastConditionIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public int getLastConditionIdList(int index) {
            return this.lastConditionIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public int getDungeonIndex() {
            return this.dungeonIndex_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
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
            if (this.dungeonIndex_ != 0) {
                output.writeUInt32(1, this.dungeonIndex_);
            }
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(7, this.score_);
            }
            if (this.isFirstPassRewardTaken_) {
                output.writeBool(9, this.isFirstPassRewardTaken_);
            }
            if (getLastConditionIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.lastConditionIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.lastConditionIdList_.size(); i++) {
                output.writeUInt32NoTag(this.lastConditionIdList_.getInt(i));
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(13, this.openTime_);
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
            if (this.dungeonIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.dungeonIndex_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.score_);
            }
            if (this.isFirstPassRewardTaken_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isFirstPassRewardTaken_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.lastConditionIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.lastConditionIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getLastConditionIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.lastConditionIdListMemoizedSerializedSize = dataSize;
            if (this.openTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.openTime_);
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
            if (!(obj instanceof ChannelerSlabLoopDungeonInfo)) {
                return equals(obj);
            }
            ChannelerSlabLoopDungeonInfo other = (ChannelerSlabLoopDungeonInfo) obj;
            return getIsFirstPassRewardTaken() == other.getIsFirstPassRewardTaken() && getScore() == other.getScore() && getLastConditionIdListList().equals(other.getLastConditionIdListList()) && getDungeonIndex() == other.getDungeonIndex() && getIsOpen() == other.getIsOpen() && getOpenTime() == other.getOpenTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + Internal.hashBoolean(getIsFirstPassRewardTaken()))) + 7)) + getScore();
            if (getLastConditionIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getLastConditionIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getDungeonIndex())) + 4)) + Internal.hashBoolean(getIsOpen()))) + 13)) + getOpenTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabLoopDungeonInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonInfoOuterClass$ChannelerSlabLoopDungeonInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabLoopDungeonInfoOrBuilder {
            private int bitField0_;
            private boolean isFirstPassRewardTaken_;
            private int score_;
            private Internal.IntList lastConditionIdList_ = ChannelerSlabLoopDungeonInfo.emptyIntList();
            private int dungeonIndex_;
            private boolean isOpen_;
            private int openTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabLoopDungeonInfoOuterClass.internal_static_ChannelerSlabLoopDungeonInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabLoopDungeonInfoOuterClass.internal_static_ChannelerSlabLoopDungeonInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabLoopDungeonInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabLoopDungeonInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFirstPassRewardTaken_ = false;
                this.score_ = 0;
                this.lastConditionIdList_ = ChannelerSlabLoopDungeonInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.dungeonIndex_ = 0;
                this.isOpen_ = false;
                this.openTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabLoopDungeonInfoOuterClass.internal_static_ChannelerSlabLoopDungeonInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabLoopDungeonInfo getDefaultInstanceForType() {
                return ChannelerSlabLoopDungeonInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabLoopDungeonInfo build() {
                ChannelerSlabLoopDungeonInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabLoopDungeonInfo buildPartial() {
                ChannelerSlabLoopDungeonInfo result = new ChannelerSlabLoopDungeonInfo(this);
                int i = this.bitField0_;
                result.isFirstPassRewardTaken_ = this.isFirstPassRewardTaken_;
                result.score_ = this.score_;
                if ((this.bitField0_ & 1) != 0) {
                    this.lastConditionIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.lastConditionIdList_ = this.lastConditionIdList_;
                result.dungeonIndex_ = this.dungeonIndex_;
                result.isOpen_ = this.isOpen_;
                result.openTime_ = this.openTime_;
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
                if (other instanceof ChannelerSlabLoopDungeonInfo) {
                    return mergeFrom((ChannelerSlabLoopDungeonInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabLoopDungeonInfo other) {
                if (other == ChannelerSlabLoopDungeonInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFirstPassRewardTaken()) {
                    setIsFirstPassRewardTaken(other.getIsFirstPassRewardTaken());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (!other.lastConditionIdList_.isEmpty()) {
                    if (this.lastConditionIdList_.isEmpty()) {
                        this.lastConditionIdList_ = other.lastConditionIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLastConditionIdListIsMutable();
                        this.lastConditionIdList_.addAll(other.lastConditionIdList_);
                    }
                    onChanged();
                }
                if (other.getDungeonIndex() != 0) {
                    setDungeonIndex(other.getDungeonIndex());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
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
                ChannelerSlabLoopDungeonInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabLoopDungeonInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabLoopDungeonInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public boolean getIsFirstPassRewardTaken() {
                return this.isFirstPassRewardTaken_;
            }

            public Builder setIsFirstPassRewardTaken(boolean value) {
                this.isFirstPassRewardTaken_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFirstPassRewardTaken() {
                this.isFirstPassRewardTaken_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            private void ensureLastConditionIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.lastConditionIdList_ = ChannelerSlabLoopDungeonInfo.mutableCopy(this.lastConditionIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public List<Integer> getLastConditionIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.lastConditionIdList_) : this.lastConditionIdList_;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public int getLastConditionIdListCount() {
                return this.lastConditionIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public int getLastConditionIdList(int index) {
                return this.lastConditionIdList_.getInt(index);
            }

            public Builder setLastConditionIdList(int index, int value) {
                ensureLastConditionIdListIsMutable();
                this.lastConditionIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLastConditionIdList(int value) {
                ensureLastConditionIdListIsMutable();
                this.lastConditionIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLastConditionIdList(Iterable<? extends Integer> values) {
                ensureLastConditionIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lastConditionIdList_);
                onChanged();
                return this;
            }

            public Builder clearLastConditionIdList() {
                this.lastConditionIdList_ = ChannelerSlabLoopDungeonInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public int getDungeonIndex() {
                return this.dungeonIndex_;
            }

            public Builder setDungeonIndex(int value) {
                this.dungeonIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonIndex() {
                this.dungeonIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
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

        public static ChannelerSlabLoopDungeonInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabLoopDungeonInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabLoopDungeonInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabLoopDungeonInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
