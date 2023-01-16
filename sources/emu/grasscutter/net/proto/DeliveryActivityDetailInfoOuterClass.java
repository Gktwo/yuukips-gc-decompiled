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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryActivityDetailInfoOuterClass.class */
public final class DeliveryActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n DeliveryActivityDetailInfo.proto\"o\n\u001aDeliveryActivityDetailInfo\u0012\u0011\n\tday_index\u0018\u0001 \u0001(\r\u0012\u0017\n\u000fis_taken_reward\u0018\u000b \u0001(\b\u0012%\n\u001dfinished_delivery_quest_index\u0018\u0004 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DeliveryActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DeliveryActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DeliveryActivityDetailInfo_descriptor, new String[]{"DayIndex", "IsTakenReward", "FinishedDeliveryQuestIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryActivityDetailInfoOuterClass$DeliveryActivityDetailInfoOrBuilder.class */
    public interface DeliveryActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getDayIndex();

        boolean getIsTakenReward();

        List<Integer> getFinishedDeliveryQuestIndexList();

        int getFinishedDeliveryQuestIndexCount();

        int getFinishedDeliveryQuestIndex(int i);
    }

    private DeliveryActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryActivityDetailInfoOuterClass$DeliveryActivityDetailInfo.class */
    public static final class DeliveryActivityDetailInfo extends GeneratedMessageV3 implements DeliveryActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAY_INDEX_FIELD_NUMBER = 1;
        private int dayIndex_;
        public static final int IS_TAKEN_REWARD_FIELD_NUMBER = 11;
        private boolean isTakenReward_;
        public static final int FINISHED_DELIVERY_QUEST_INDEX_FIELD_NUMBER = 4;
        private Internal.IntList finishedDeliveryQuestIndex_;
        private int finishedDeliveryQuestIndexMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DeliveryActivityDetailInfo DEFAULT_INSTANCE = new DeliveryActivityDetailInfo();
        private static final Parser<DeliveryActivityDetailInfo> PARSER = new AbstractParser<DeliveryActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public DeliveryActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DeliveryActivityDetailInfo(input, extensionRegistry);
            }
        };

        private DeliveryActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishedDeliveryQuestIndexMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DeliveryActivityDetailInfo() {
            this.finishedDeliveryQuestIndexMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.finishedDeliveryQuestIndex_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DeliveryActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DeliveryActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishedDeliveryQuestIndex_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.finishedDeliveryQuestIndex_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishedDeliveryQuestIndex_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishedDeliveryQuestIndex_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.isTakenReward_ = input.readBool();
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
                    this.finishedDeliveryQuestIndex_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DeliveryActivityDetailInfoOuterClass.internal_static_DeliveryActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DeliveryActivityDetailInfoOuterClass.internal_static_DeliveryActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DeliveryActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
        public boolean getIsTakenReward() {
            return this.isTakenReward_;
        }

        @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
        public List<Integer> getFinishedDeliveryQuestIndexList() {
            return this.finishedDeliveryQuestIndex_;
        }

        @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
        public int getFinishedDeliveryQuestIndexCount() {
            return this.finishedDeliveryQuestIndex_.size();
        }

        @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
        public int getFinishedDeliveryQuestIndex(int index) {
            return this.finishedDeliveryQuestIndex_.getInt(index);
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
            if (this.dayIndex_ != 0) {
                output.writeUInt32(1, this.dayIndex_);
            }
            if (getFinishedDeliveryQuestIndexList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.finishedDeliveryQuestIndexMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishedDeliveryQuestIndex_.size(); i++) {
                output.writeUInt32NoTag(this.finishedDeliveryQuestIndex_.getInt(i));
            }
            if (this.isTakenReward_) {
                output.writeBool(11, this.isTakenReward_);
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
            if (this.dayIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.dayIndex_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.finishedDeliveryQuestIndex_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishedDeliveryQuestIndex_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFinishedDeliveryQuestIndexList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishedDeliveryQuestIndexMemoizedSerializedSize = dataSize;
            if (this.isTakenReward_) {
                size3 += CodedOutputStream.computeBoolSize(11, this.isTakenReward_);
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
            if (!(obj instanceof DeliveryActivityDetailInfo)) {
                return equals(obj);
            }
            DeliveryActivityDetailInfo other = (DeliveryActivityDetailInfo) obj;
            return getDayIndex() == other.getDayIndex() && getIsTakenReward() == other.getIsTakenReward() && getFinishedDeliveryQuestIndexList().equals(other.getFinishedDeliveryQuestIndexList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getDayIndex())) + 11)) + Internal.hashBoolean(getIsTakenReward());
            if (getFinishedDeliveryQuestIndexCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getFinishedDeliveryQuestIndexList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DeliveryActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DeliveryActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DeliveryActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DeliveryActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DeliveryActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DeliveryActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DeliveryActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (DeliveryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DeliveryActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeliveryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DeliveryActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DeliveryActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DeliveryActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeliveryActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DeliveryActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (DeliveryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DeliveryActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeliveryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DeliveryActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DeliveryActivityDetailInfoOuterClass$DeliveryActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DeliveryActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int dayIndex_;
            private boolean isTakenReward_;
            private Internal.IntList finishedDeliveryQuestIndex_ = DeliveryActivityDetailInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DeliveryActivityDetailInfoOuterClass.internal_static_DeliveryActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DeliveryActivityDetailInfoOuterClass.internal_static_DeliveryActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DeliveryActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DeliveryActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dayIndex_ = 0;
                this.isTakenReward_ = false;
                this.finishedDeliveryQuestIndex_ = DeliveryActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DeliveryActivityDetailInfoOuterClass.internal_static_DeliveryActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DeliveryActivityDetailInfo getDefaultInstanceForType() {
                return DeliveryActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DeliveryActivityDetailInfo build() {
                DeliveryActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DeliveryActivityDetailInfo buildPartial() {
                DeliveryActivityDetailInfo result = new DeliveryActivityDetailInfo(this);
                int i = this.bitField0_;
                result.dayIndex_ = this.dayIndex_;
                result.isTakenReward_ = this.isTakenReward_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishedDeliveryQuestIndex_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishedDeliveryQuestIndex_ = this.finishedDeliveryQuestIndex_;
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
                if (other instanceof DeliveryActivityDetailInfo) {
                    return mergeFrom((DeliveryActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DeliveryActivityDetailInfo other) {
                if (other == DeliveryActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getIsTakenReward()) {
                    setIsTakenReward(other.getIsTakenReward());
                }
                if (!other.finishedDeliveryQuestIndex_.isEmpty()) {
                    if (this.finishedDeliveryQuestIndex_.isEmpty()) {
                        this.finishedDeliveryQuestIndex_ = other.finishedDeliveryQuestIndex_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishedDeliveryQuestIndexIsMutable();
                        this.finishedDeliveryQuestIndex_.addAll(other.finishedDeliveryQuestIndex_);
                    }
                    onChanged();
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
                DeliveryActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DeliveryActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DeliveryActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
            public int getDayIndex() {
                return this.dayIndex_;
            }

            public Builder setDayIndex(int value) {
                this.dayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayIndex() {
                this.dayIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
            public boolean getIsTakenReward() {
                return this.isTakenReward_;
            }

            public Builder setIsTakenReward(boolean value) {
                this.isTakenReward_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTakenReward() {
                this.isTakenReward_ = false;
                onChanged();
                return this;
            }

            private void ensureFinishedDeliveryQuestIndexIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishedDeliveryQuestIndex_ = DeliveryActivityDetailInfo.mutableCopy(this.finishedDeliveryQuestIndex_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
            public List<Integer> getFinishedDeliveryQuestIndexList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishedDeliveryQuestIndex_) : this.finishedDeliveryQuestIndex_;
            }

            @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
            public int getFinishedDeliveryQuestIndexCount() {
                return this.finishedDeliveryQuestIndex_.size();
            }

            @Override // emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder
            public int getFinishedDeliveryQuestIndex(int index) {
                return this.finishedDeliveryQuestIndex_.getInt(index);
            }

            public Builder setFinishedDeliveryQuestIndex(int index, int value) {
                ensureFinishedDeliveryQuestIndexIsMutable();
                this.finishedDeliveryQuestIndex_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishedDeliveryQuestIndex(int value) {
                ensureFinishedDeliveryQuestIndexIsMutable();
                this.finishedDeliveryQuestIndex_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishedDeliveryQuestIndex(Iterable<? extends Integer> values) {
                ensureFinishedDeliveryQuestIndexIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishedDeliveryQuestIndex_);
                onChanged();
                return this;
            }

            public Builder clearFinishedDeliveryQuestIndex() {
                this.finishedDeliveryQuestIndex_ = DeliveryActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
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

        public static DeliveryActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeliveryActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DeliveryActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DeliveryActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
