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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightDailyRecordOuterClass.class */
public final class FlightDailyRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017FlightDailyRecord.proto\"t\n\u0011FlightDailyRecord\u0012\u000f\n\u0007groupId\u0018\u000e \u0001(\r\u0012\u0011\n\tstartTime\u0018\u000f \u0001(\r\u0012\u0015\n\rwatcherIdList\u0018\u0006 \u0003(\r\u0012\u0011\n\tisTouched\u0018\b \u0001(\b\u0012\u0011\n\tbestScore\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FlightDailyRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FlightDailyRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FlightDailyRecord_descriptor, new String[]{"GroupId", "StartTime", "WatcherIdList", "IsTouched", "BestScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightDailyRecordOuterClass$FlightDailyRecordOrBuilder.class */
    public interface FlightDailyRecordOrBuilder extends MessageOrBuilder {
        int getGroupId();

        int getStartTime();

        List<Integer> getWatcherIdListList();

        int getWatcherIdListCount();

        int getWatcherIdList(int i);

        boolean getIsTouched();

        int getBestScore();
    }

    private FlightDailyRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightDailyRecordOuterClass$FlightDailyRecord.class */
    public static final class FlightDailyRecord extends GeneratedMessageV3 implements FlightDailyRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GROUPID_FIELD_NUMBER = 14;
        private int groupId_;
        public static final int STARTTIME_FIELD_NUMBER = 15;
        private int startTime_;
        public static final int WATCHERIDLIST_FIELD_NUMBER = 6;
        private Internal.IntList watcherIdList_;
        private int watcherIdListMemoizedSerializedSize;
        public static final int ISTOUCHED_FIELD_NUMBER = 8;
        private boolean isTouched_;
        public static final int BESTSCORE_FIELD_NUMBER = 3;
        private int bestScore_;
        private byte memoizedIsInitialized;
        private static final FlightDailyRecord DEFAULT_INSTANCE = new FlightDailyRecord();
        private static final Parser<FlightDailyRecord> PARSER = new AbstractParser<FlightDailyRecord>() { // from class: emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecord.1
            @Override // com.google.protobuf.Parser
            public FlightDailyRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FlightDailyRecord(input, extensionRegistry);
            }
        };

        private FlightDailyRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.watcherIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FlightDailyRecord() {
            this.watcherIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.watcherIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FlightDailyRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FlightDailyRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.bestScore_ = input.readUInt32();
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.watcherIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.watcherIdList_.addInt(input.readUInt32());
                                break;
                            case 50:
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
                            case 64:
                                this.isTouched_ = input.readBool();
                                break;
                            case 112:
                                this.groupId_ = input.readUInt32();
                                break;
                            case 120:
                                this.startTime_ = input.readUInt32();
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
            return FlightDailyRecordOuterClass.internal_static_FlightDailyRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FlightDailyRecordOuterClass.internal_static_FlightDailyRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(FlightDailyRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public List<Integer> getWatcherIdListList() {
            return this.watcherIdList_;
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public int getWatcherIdListCount() {
            return this.watcherIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public int getWatcherIdList(int index) {
            return this.watcherIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public boolean getIsTouched() {
            return this.isTouched_;
        }

        @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
        public int getBestScore() {
            return this.bestScore_;
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
            if (this.bestScore_ != 0) {
                output.writeUInt32(3, this.bestScore_);
            }
            if (getWatcherIdListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.watcherIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.watcherIdList_.size(); i++) {
                output.writeUInt32NoTag(this.watcherIdList_.getInt(i));
            }
            if (this.isTouched_) {
                output.writeBool(8, this.isTouched_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(14, this.groupId_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(15, this.startTime_);
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
            if (this.bestScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.bestScore_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.watcherIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.watcherIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getWatcherIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.watcherIdListMemoizedSerializedSize = dataSize;
            if (this.isTouched_) {
                size3 += CodedOutputStream.computeBoolSize(8, this.isTouched_);
            }
            if (this.groupId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.groupId_);
            }
            if (this.startTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.startTime_);
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
            if (!(obj instanceof FlightDailyRecord)) {
                return equals(obj);
            }
            FlightDailyRecord other = (FlightDailyRecord) obj;
            return getGroupId() == other.getGroupId() && getStartTime() == other.getStartTime() && getWatcherIdListList().equals(other.getWatcherIdListList()) && getIsTouched() == other.getIsTouched() && getBestScore() == other.getBestScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getGroupId())) + 15)) + getStartTime();
            if (getWatcherIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getWatcherIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + Internal.hashBoolean(getIsTouched()))) + 3)) + getBestScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FlightDailyRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightDailyRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightDailyRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightDailyRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightDailyRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightDailyRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightDailyRecord parseFrom(InputStream input) throws IOException {
            return (FlightDailyRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FlightDailyRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightDailyRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FlightDailyRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (FlightDailyRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FlightDailyRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightDailyRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FlightDailyRecord parseFrom(CodedInputStream input) throws IOException {
            return (FlightDailyRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FlightDailyRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightDailyRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FlightDailyRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightDailyRecordOuterClass$FlightDailyRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FlightDailyRecordOrBuilder {
            private int bitField0_;
            private int groupId_;
            private int startTime_;
            private Internal.IntList watcherIdList_ = FlightDailyRecord.emptyIntList();
            private boolean isTouched_;
            private int bestScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FlightDailyRecordOuterClass.internal_static_FlightDailyRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FlightDailyRecordOuterClass.internal_static_FlightDailyRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(FlightDailyRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FlightDailyRecord.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.groupId_ = 0;
                this.startTime_ = 0;
                this.watcherIdList_ = FlightDailyRecord.emptyIntList();
                this.bitField0_ &= -2;
                this.isTouched_ = false;
                this.bestScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FlightDailyRecordOuterClass.internal_static_FlightDailyRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FlightDailyRecord getDefaultInstanceForType() {
                return FlightDailyRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FlightDailyRecord build() {
                FlightDailyRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FlightDailyRecord buildPartial() {
                FlightDailyRecord result = new FlightDailyRecord(this);
                int i = this.bitField0_;
                result.groupId_ = this.groupId_;
                result.startTime_ = this.startTime_;
                if ((this.bitField0_ & 1) != 0) {
                    this.watcherIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.watcherIdList_ = this.watcherIdList_;
                result.isTouched_ = this.isTouched_;
                result.bestScore_ = this.bestScore_;
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
                if (other instanceof FlightDailyRecord) {
                    return mergeFrom((FlightDailyRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FlightDailyRecord other) {
                if (other == FlightDailyRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
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
                if (other.getIsTouched()) {
                    setIsTouched(other.getIsTouched());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
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
                FlightDailyRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = FlightDailyRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FlightDailyRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
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

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
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

            private void ensureWatcherIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.watcherIdList_ = FlightDailyRecord.mutableCopy(this.watcherIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
            public List<Integer> getWatcherIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.watcherIdList_) : this.watcherIdList_;
            }

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
            public int getWatcherIdListCount() {
                return this.watcherIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
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
                this.watcherIdList_ = FlightDailyRecord.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
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

            @Override // emu.grasscutter.net.proto.FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static FlightDailyRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FlightDailyRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FlightDailyRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FlightDailyRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
