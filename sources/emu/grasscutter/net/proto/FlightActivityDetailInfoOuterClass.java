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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FlightDailyRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightActivityDetailInfoOuterClass.class */
public final class FlightActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eFlightActivityDetailInfo.proto\u001a\u0017FlightDailyRecord.proto\"\u0001\n\u0018FlightActivityDetailInfo\u0012-\n\u0011daily_record_list\u0018\f \u0003(\u000b2\u0012.FlightDailyRecord\u0012\u0019\n\u0011preview_reward_id\u0018\u0001 \u0001(\r\u0012\u001d\n\u0015min_open_player_level\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FlightDailyRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FlightActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FlightActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FlightActivityDetailInfo_descriptor, new String[]{"DailyRecordList", "PreviewRewardId", "MinOpenPlayerLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightActivityDetailInfoOuterClass$FlightActivityDetailInfoOrBuilder.class */
    public interface FlightActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<FlightDailyRecordOuterClass.FlightDailyRecord> getDailyRecordListList();

        FlightDailyRecordOuterClass.FlightDailyRecord getDailyRecordList(int i);

        int getDailyRecordListCount();

        List<? extends FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> getDailyRecordListOrBuilderList();

        FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder getDailyRecordListOrBuilder(int i);

        int getPreviewRewardId();

        int getMinOpenPlayerLevel();
    }

    private FlightActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightActivityDetailInfoOuterClass$FlightActivityDetailInfo.class */
    public static final class FlightActivityDetailInfo extends GeneratedMessageV3 implements FlightActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAILY_RECORD_LIST_FIELD_NUMBER = 12;
        private List<FlightDailyRecordOuterClass.FlightDailyRecord> dailyRecordList_;
        public static final int PREVIEW_REWARD_ID_FIELD_NUMBER = 1;
        private int previewRewardId_;
        public static final int MIN_OPEN_PLAYER_LEVEL_FIELD_NUMBER = 4;
        private int minOpenPlayerLevel_;
        private byte memoizedIsInitialized;
        private static final FlightActivityDetailInfo DEFAULT_INSTANCE = new FlightActivityDetailInfo();
        private static final Parser<FlightActivityDetailInfo> PARSER = new AbstractParser<FlightActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public FlightActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FlightActivityDetailInfo(input, extensionRegistry);
            }
        };

        private FlightActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FlightActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.dailyRecordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FlightActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FlightActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.previewRewardId_ = input.readUInt32();
                                break;
                            case 32:
                                this.minOpenPlayerLevel_ = input.readUInt32();
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dailyRecordList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.dailyRecordList_.add((FlightDailyRecordOuterClass.FlightDailyRecord) input.readMessage(FlightDailyRecordOuterClass.FlightDailyRecord.parser(), extensionRegistry));
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
                    this.dailyRecordList_ = Collections.unmodifiableList(this.dailyRecordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FlightActivityDetailInfoOuterClass.internal_static_FlightActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FlightActivityDetailInfoOuterClass.internal_static_FlightActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FlightActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public List<FlightDailyRecordOuterClass.FlightDailyRecord> getDailyRecordListList() {
            return this.dailyRecordList_;
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public List<? extends FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> getDailyRecordListOrBuilderList() {
            return this.dailyRecordList_;
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public int getDailyRecordListCount() {
            return this.dailyRecordList_.size();
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public FlightDailyRecordOuterClass.FlightDailyRecord getDailyRecordList(int index) {
            return this.dailyRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder getDailyRecordListOrBuilder(int index) {
            return this.dailyRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public int getPreviewRewardId() {
            return this.previewRewardId_;
        }

        @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
        public int getMinOpenPlayerLevel() {
            return this.minOpenPlayerLevel_;
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
            if (this.previewRewardId_ != 0) {
                output.writeUInt32(1, this.previewRewardId_);
            }
            if (this.minOpenPlayerLevel_ != 0) {
                output.writeUInt32(4, this.minOpenPlayerLevel_);
            }
            for (int i = 0; i < this.dailyRecordList_.size(); i++) {
                output.writeMessage(12, this.dailyRecordList_.get(i));
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
            if (this.previewRewardId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.previewRewardId_);
            }
            if (this.minOpenPlayerLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.minOpenPlayerLevel_);
            }
            for (int i = 0; i < this.dailyRecordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.dailyRecordList_.get(i));
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
            if (!(obj instanceof FlightActivityDetailInfo)) {
                return equals(obj);
            }
            FlightActivityDetailInfo other = (FlightActivityDetailInfo) obj;
            return getDailyRecordListList().equals(other.getDailyRecordListList()) && getPreviewRewardId() == other.getPreviewRewardId() && getMinOpenPlayerLevel() == other.getMinOpenPlayerLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDailyRecordListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getDailyRecordListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getPreviewRewardId())) + 4)) + getMinOpenPlayerLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FlightActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (FlightActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FlightActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FlightActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FlightActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FlightActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FlightActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (FlightActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FlightActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FlightActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightActivityDetailInfoOuterClass$FlightActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FlightActivityDetailInfoOrBuilder {
            private int bitField0_;
            private List<FlightDailyRecordOuterClass.FlightDailyRecord> dailyRecordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FlightDailyRecordOuterClass.FlightDailyRecord, FlightDailyRecordOuterClass.FlightDailyRecord.Builder, FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> dailyRecordListBuilder_;
            private int previewRewardId_;
            private int minOpenPlayerLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FlightActivityDetailInfoOuterClass.internal_static_FlightActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FlightActivityDetailInfoOuterClass.internal_static_FlightActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FlightActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FlightActivityDetailInfo.alwaysUseFieldBuilders) {
                    getDailyRecordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.dailyRecordListBuilder_ == null) {
                    this.dailyRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dailyRecordListBuilder_.clear();
                }
                this.previewRewardId_ = 0;
                this.minOpenPlayerLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FlightActivityDetailInfoOuterClass.internal_static_FlightActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FlightActivityDetailInfo getDefaultInstanceForType() {
                return FlightActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FlightActivityDetailInfo build() {
                FlightActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FlightActivityDetailInfo buildPartial() {
                FlightActivityDetailInfo result = new FlightActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.dailyRecordListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dailyRecordList_ = Collections.unmodifiableList(this.dailyRecordList_);
                        this.bitField0_ &= -2;
                    }
                    result.dailyRecordList_ = this.dailyRecordList_;
                } else {
                    result.dailyRecordList_ = this.dailyRecordListBuilder_.build();
                }
                result.previewRewardId_ = this.previewRewardId_;
                result.minOpenPlayerLevel_ = this.minOpenPlayerLevel_;
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
                if (other instanceof FlightActivityDetailInfo) {
                    return mergeFrom((FlightActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FlightActivityDetailInfo other) {
                if (other == FlightActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.dailyRecordListBuilder_ == null) {
                    if (!other.dailyRecordList_.isEmpty()) {
                        if (this.dailyRecordList_.isEmpty()) {
                            this.dailyRecordList_ = other.dailyRecordList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDailyRecordListIsMutable();
                            this.dailyRecordList_.addAll(other.dailyRecordList_);
                        }
                        onChanged();
                    }
                } else if (!other.dailyRecordList_.isEmpty()) {
                    if (this.dailyRecordListBuilder_.isEmpty()) {
                        this.dailyRecordListBuilder_.dispose();
                        this.dailyRecordListBuilder_ = null;
                        this.dailyRecordList_ = other.dailyRecordList_;
                        this.bitField0_ &= -2;
                        this.dailyRecordListBuilder_ = FlightActivityDetailInfo.alwaysUseFieldBuilders ? getDailyRecordListFieldBuilder() : null;
                    } else {
                        this.dailyRecordListBuilder_.addAllMessages(other.dailyRecordList_);
                    }
                }
                if (other.getPreviewRewardId() != 0) {
                    setPreviewRewardId(other.getPreviewRewardId());
                }
                if (other.getMinOpenPlayerLevel() != 0) {
                    setMinOpenPlayerLevel(other.getMinOpenPlayerLevel());
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
                FlightActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FlightActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FlightActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDailyRecordListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dailyRecordList_ = new ArrayList(this.dailyRecordList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public List<FlightDailyRecordOuterClass.FlightDailyRecord> getDailyRecordListList() {
                if (this.dailyRecordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dailyRecordList_);
                }
                return this.dailyRecordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public int getDailyRecordListCount() {
                if (this.dailyRecordListBuilder_ == null) {
                    return this.dailyRecordList_.size();
                }
                return this.dailyRecordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public FlightDailyRecordOuterClass.FlightDailyRecord getDailyRecordList(int index) {
                if (this.dailyRecordListBuilder_ == null) {
                    return this.dailyRecordList_.get(index);
                }
                return this.dailyRecordListBuilder_.getMessage(index);
            }

            public Builder setDailyRecordList(int index, FlightDailyRecordOuterClass.FlightDailyRecord value) {
                if (this.dailyRecordListBuilder_ != null) {
                    this.dailyRecordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDailyRecordList(int index, FlightDailyRecordOuterClass.FlightDailyRecord.Builder builderForValue) {
                if (this.dailyRecordListBuilder_ == null) {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyRecordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDailyRecordList(FlightDailyRecordOuterClass.FlightDailyRecord value) {
                if (this.dailyRecordListBuilder_ != null) {
                    this.dailyRecordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyRecordList(int index, FlightDailyRecordOuterClass.FlightDailyRecord value) {
                if (this.dailyRecordListBuilder_ != null) {
                    this.dailyRecordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyRecordList(FlightDailyRecordOuterClass.FlightDailyRecord.Builder builderForValue) {
                if (this.dailyRecordListBuilder_ == null) {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dailyRecordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDailyRecordList(int index, FlightDailyRecordOuterClass.FlightDailyRecord.Builder builderForValue) {
                if (this.dailyRecordListBuilder_ == null) {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyRecordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDailyRecordList(Iterable<? extends FlightDailyRecordOuterClass.FlightDailyRecord> values) {
                if (this.dailyRecordListBuilder_ == null) {
                    ensureDailyRecordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dailyRecordList_);
                    onChanged();
                } else {
                    this.dailyRecordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDailyRecordList() {
                if (this.dailyRecordListBuilder_ == null) {
                    this.dailyRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dailyRecordListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDailyRecordList(int index) {
                if (this.dailyRecordListBuilder_ == null) {
                    ensureDailyRecordListIsMutable();
                    this.dailyRecordList_.remove(index);
                    onChanged();
                } else {
                    this.dailyRecordListBuilder_.remove(index);
                }
                return this;
            }

            public FlightDailyRecordOuterClass.FlightDailyRecord.Builder getDailyRecordListBuilder(int index) {
                return getDailyRecordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder getDailyRecordListOrBuilder(int index) {
                if (this.dailyRecordListBuilder_ == null) {
                    return this.dailyRecordList_.get(index);
                }
                return this.dailyRecordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public List<? extends FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> getDailyRecordListOrBuilderList() {
                if (this.dailyRecordListBuilder_ != null) {
                    return this.dailyRecordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dailyRecordList_);
            }

            public FlightDailyRecordOuterClass.FlightDailyRecord.Builder addDailyRecordListBuilder() {
                return getDailyRecordListFieldBuilder().addBuilder(FlightDailyRecordOuterClass.FlightDailyRecord.getDefaultInstance());
            }

            public FlightDailyRecordOuterClass.FlightDailyRecord.Builder addDailyRecordListBuilder(int index) {
                return getDailyRecordListFieldBuilder().addBuilder(index, FlightDailyRecordOuterClass.FlightDailyRecord.getDefaultInstance());
            }

            public List<FlightDailyRecordOuterClass.FlightDailyRecord.Builder> getDailyRecordListBuilderList() {
                return getDailyRecordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FlightDailyRecordOuterClass.FlightDailyRecord, FlightDailyRecordOuterClass.FlightDailyRecord.Builder, FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> getDailyRecordListFieldBuilder() {
                if (this.dailyRecordListBuilder_ == null) {
                    this.dailyRecordListBuilder_ = new RepeatedFieldBuilderV3<>(this.dailyRecordList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dailyRecordList_ = null;
                }
                return this.dailyRecordListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public int getPreviewRewardId() {
                return this.previewRewardId_;
            }

            public Builder setPreviewRewardId(int value) {
                this.previewRewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPreviewRewardId() {
                this.previewRewardId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder
            public int getMinOpenPlayerLevel() {
                return this.minOpenPlayerLevel_;
            }

            public Builder setMinOpenPlayerLevel(int value) {
                this.minOpenPlayerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinOpenPlayerLevel() {
                this.minOpenPlayerLevel_ = 0;
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

        public static FlightActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FlightActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FlightActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FlightActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FlightDailyRecordOuterClass.getDescriptor();
    }
}
