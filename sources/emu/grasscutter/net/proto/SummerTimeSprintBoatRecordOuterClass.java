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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeSprintBoatRecordOuterClass.class */
public final class SummerTimeSprintBoatRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n SummerTimeSprintBoatRecord.proto\"\u0001\n\u001aSummerTimeSprintBoatRecord\u0012\u0012\n\nstart_time\u0018\f \u0001(\r\u0012\u0010\n\bgroup_id\u0018\u0005 \u0001(\r\u0012\u0017\n\u000fwatcher_id_list\u0018\u0002 \u0003(\r\u0012\u0012\n\nbest_score\u0018\r \u0001(\r\u0012\u0012\n\nis_touched\u0018\u0006 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SummerTimeSprintBoatRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeSprintBoatRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeSprintBoatRecord_descriptor, new String[]{"StartTime", "GroupId", "WatcherIdList", "BestScore", "IsTouched"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeSprintBoatRecordOuterClass$SummerTimeSprintBoatRecordOrBuilder.class */
    public interface SummerTimeSprintBoatRecordOrBuilder extends MessageOrBuilder {
        int getStartTime();

        int getGroupId();

        List<Integer> getWatcherIdListList();

        int getWatcherIdListCount();

        int getWatcherIdList(int i);

        int getBestScore();

        boolean getIsTouched();
    }

    private SummerTimeSprintBoatRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeSprintBoatRecordOuterClass$SummerTimeSprintBoatRecord.class */
    public static final class SummerTimeSprintBoatRecord extends GeneratedMessageV3 implements SummerTimeSprintBoatRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int START_TIME_FIELD_NUMBER = 12;
        private int startTime_;
        public static final int GROUP_ID_FIELD_NUMBER = 5;
        private int groupId_;
        public static final int WATCHER_ID_LIST_FIELD_NUMBER = 2;
        private Internal.IntList watcherIdList_;
        private int watcherIdListMemoizedSerializedSize;
        public static final int BEST_SCORE_FIELD_NUMBER = 13;
        private int bestScore_;
        public static final int IS_TOUCHED_FIELD_NUMBER = 6;
        private boolean isTouched_;
        private byte memoizedIsInitialized;
        private static final SummerTimeSprintBoatRecord DEFAULT_INSTANCE = new SummerTimeSprintBoatRecord();
        private static final Parser<SummerTimeSprintBoatRecord> PARSER = new AbstractParser<SummerTimeSprintBoatRecord>() { // from class: emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecord.1
            @Override // com.google.protobuf.Parser
            public SummerTimeSprintBoatRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeSprintBoatRecord(input, extensionRegistry);
            }
        };

        private SummerTimeSprintBoatRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.watcherIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeSprintBoatRecord() {
            this.watcherIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.watcherIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeSprintBoatRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SummerTimeSprintBoatRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.watcherIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.watcherIdList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.watcherIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.watcherIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                this.groupId_ = input.readUInt32();
                                break;
                            case 48:
                                this.isTouched_ = input.readBool();
                                break;
                            case 96:
                                this.startTime_ = input.readUInt32();
                                break;
                            case 104:
                                this.bestScore_ = input.readUInt32();
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
                    this.watcherIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SummerTimeSprintBoatRecordOuterClass.internal_static_SummerTimeSprintBoatRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeSprintBoatRecordOuterClass.internal_static_SummerTimeSprintBoatRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeSprintBoatRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public List<Integer> getWatcherIdListList() {
            return this.watcherIdList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public int getWatcherIdListCount() {
            return this.watcherIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public int getWatcherIdList(int index) {
            return this.watcherIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public int getBestScore() {
            return this.bestScore_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
        public boolean getIsTouched() {
            return this.isTouched_;
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
            if (getWatcherIdListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.watcherIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.watcherIdList_.size(); i++) {
                output.writeUInt32NoTag(this.watcherIdList_.getInt(i));
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(5, this.groupId_);
            }
            if (this.isTouched_) {
                output.writeBool(6, this.isTouched_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(12, this.startTime_);
            }
            if (this.bestScore_ != 0) {
                output.writeUInt32(13, this.bestScore_);
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
            for (int i = 0; i < this.watcherIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.watcherIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getWatcherIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.watcherIdListMemoizedSerializedSize = dataSize;
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.groupId_);
            }
            if (this.isTouched_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isTouched_);
            }
            if (this.startTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.startTime_);
            }
            if (this.bestScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.bestScore_);
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
            if (!(obj instanceof SummerTimeSprintBoatRecord)) {
                return equals(obj);
            }
            SummerTimeSprintBoatRecord other = (SummerTimeSprintBoatRecord) obj;
            return getStartTime() == other.getStartTime() && getGroupId() == other.getGroupId() && getWatcherIdListList().equals(other.getWatcherIdListList()) && getBestScore() == other.getBestScore() && getIsTouched() == other.getIsTouched() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getStartTime())) + 5)) + getGroupId();
            if (getWatcherIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getWatcherIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 13)) + getBestScore())) + 6)) + Internal.hashBoolean(getIsTouched()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SummerTimeSprintBoatRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeSprintBoatRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeSprintBoatRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeSprintBoatRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeSprintBoatRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeSprintBoatRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeSprintBoatRecord parseFrom(InputStream input) throws IOException {
            return (SummerTimeSprintBoatRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeSprintBoatRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeSprintBoatRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeSprintBoatRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeSprintBoatRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeSprintBoatRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeSprintBoatRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeSprintBoatRecord parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeSprintBoatRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeSprintBoatRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeSprintBoatRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeSprintBoatRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeSprintBoatRecordOuterClass$SummerTimeSprintBoatRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeSprintBoatRecordOrBuilder {
            private int bitField0_;
            private int startTime_;
            private int groupId_;
            private Internal.IntList watcherIdList_ = SummerTimeSprintBoatRecord.emptyIntList();
            private int bestScore_;
            private boolean isTouched_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeSprintBoatRecordOuterClass.internal_static_SummerTimeSprintBoatRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeSprintBoatRecordOuterClass.internal_static_SummerTimeSprintBoatRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeSprintBoatRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeSprintBoatRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.startTime_ = 0;
                this.groupId_ = 0;
                this.watcherIdList_ = SummerTimeSprintBoatRecord.emptyIntList();
                this.bitField0_ &= -2;
                this.bestScore_ = 0;
                this.isTouched_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeSprintBoatRecordOuterClass.internal_static_SummerTimeSprintBoatRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeSprintBoatRecord getDefaultInstanceForType() {
                return SummerTimeSprintBoatRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeSprintBoatRecord build() {
                SummerTimeSprintBoatRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeSprintBoatRecord buildPartial() {
                SummerTimeSprintBoatRecord result = new SummerTimeSprintBoatRecord(this);
                int i = this.bitField0_;
                result.startTime_ = this.startTime_;
                result.groupId_ = this.groupId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.watcherIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.watcherIdList_ = this.watcherIdList_;
                result.bestScore_ = this.bestScore_;
                result.isTouched_ = this.isTouched_;
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
                if (other instanceof SummerTimeSprintBoatRecord) {
                    return mergeFrom((SummerTimeSprintBoatRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeSprintBoatRecord other) {
                if (other == SummerTimeSprintBoatRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (!other.watcherIdList_.isEmpty()) {
                    if (this.watcherIdList_.isEmpty()) {
                        this.watcherIdList_ = other.watcherIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureWatcherIdListIsMutable();
                        this.watcherIdList_.addAll(other.watcherIdList_);
                    }
                    onChanged();
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
                }
                if (other.getIsTouched()) {
                    setIsTouched(other.getIsTouched());
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
                SummerTimeSprintBoatRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeSprintBoatRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeSprintBoatRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
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

            private void ensureWatcherIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.watcherIdList_ = SummerTimeSprintBoatRecord.mutableCopy(this.watcherIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
            public List<Integer> getWatcherIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.watcherIdList_) : this.watcherIdList_;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
            public int getWatcherIdListCount() {
                return this.watcherIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
            public int getWatcherIdList(int index) {
                return this.watcherIdList_.getInt(index);
            }

            public Builder setWatcherIdList(int index, int value) {
                ensureWatcherIdListIsMutable();
                this.watcherIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addWatcherIdList(int value) {
                ensureWatcherIdListIsMutable();
                this.watcherIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllWatcherIdList(Iterable<? extends Integer> values) {
                ensureWatcherIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.watcherIdList_);
                onChanged();
                return this;
            }

            public Builder clearWatcherIdList() {
                this.watcherIdList_ = SummerTimeSprintBoatRecord.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeSprintBoatRecordOuterClass.SummerTimeSprintBoatRecordOrBuilder
            public boolean getIsTouched() {
                return this.isTouched_;
            }

            public Builder setIsTouched(boolean value) {
                this.isTouched_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTouched() {
                this.isTouched_ = false;
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

        public static SummerTimeSprintBoatRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeSprintBoatRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeSprintBoatRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeSprintBoatRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
