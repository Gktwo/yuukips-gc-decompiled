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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FindHilichurlDayContentInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FindHilichurlDetailInfoOuterClass.class */
public final class FindHilichurlDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dFindHilichurlDetailInfo.proto\u001a!FindHilichurlDayContentInfo.proto\"ö\u0001\n\u0017FindHilichurlDetailInfo\u0012\u0011\n\tday_index\u0018\b \u0001(\r\u0012\u0019\n\u0011is_content_closed\u0018\f \u0001(\b\u0012\u001d\n\u0015min_open_player_level\u0018\u0002 \u0001(\r\u0012;\n\u0015day_content_info_list\u0018\u0004 \u0003(\u000b2\u001c.FindHilichurlDayContentInfo\u0012\u001a\n\u0012content_close_time\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013is_end_quest_accept\u0018\u0005 \u0001(\b\u0012\u0018\n\u0010player_day_index\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FindHilichurlDayContentInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FindHilichurlDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FindHilichurlDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FindHilichurlDetailInfo_descriptor, new String[]{"DayIndex", "IsContentClosed", "MinOpenPlayerLevel", "DayContentInfoList", "ContentCloseTime", "IsEndQuestAccept", "PlayerDayIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FindHilichurlDetailInfoOuterClass$FindHilichurlDetailInfoOrBuilder.class */
    public interface FindHilichurlDetailInfoOrBuilder extends MessageOrBuilder {
        int getDayIndex();

        boolean getIsContentClosed();

        int getMinOpenPlayerLevel();

        List<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo> getDayContentInfoListList();

        FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo getDayContentInfoList(int i);

        int getDayContentInfoListCount();

        List<? extends FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder> getDayContentInfoListOrBuilderList();

        FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder getDayContentInfoListOrBuilder(int i);

        int getContentCloseTime();

        boolean getIsEndQuestAccept();

        int getPlayerDayIndex();
    }

    private FindHilichurlDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FindHilichurlDetailInfoOuterClass$FindHilichurlDetailInfo.class */
    public static final class FindHilichurlDetailInfo extends GeneratedMessageV3 implements FindHilichurlDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAY_INDEX_FIELD_NUMBER = 8;
        private int dayIndex_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 12;
        private boolean isContentClosed_;
        public static final int MIN_OPEN_PLAYER_LEVEL_FIELD_NUMBER = 2;
        private int minOpenPlayerLevel_;
        public static final int DAY_CONTENT_INFO_LIST_FIELD_NUMBER = 4;
        private List<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo> dayContentInfoList_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 7;
        private int contentCloseTime_;
        public static final int IS_END_QUEST_ACCEPT_FIELD_NUMBER = 5;
        private boolean isEndQuestAccept_;
        public static final int PLAYER_DAY_INDEX_FIELD_NUMBER = 14;
        private int playerDayIndex_;
        private byte memoizedIsInitialized;
        private static final FindHilichurlDetailInfo DEFAULT_INSTANCE = new FindHilichurlDetailInfo();
        private static final Parser<FindHilichurlDetailInfo> PARSER = new AbstractParser<FindHilichurlDetailInfo>() { // from class: emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.1
            @Override // com.google.protobuf.Parser
            public FindHilichurlDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FindHilichurlDetailInfo(input, extensionRegistry);
            }
        };

        private FindHilichurlDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FindHilichurlDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.dayContentInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FindHilichurlDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FindHilichurlDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 16:
                                    this.minOpenPlayerLevel_ = input.readUInt32();
                                    break;
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.dayContentInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.dayContentInfoList_.add((FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo) input.readMessage(FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.parser(), extensionRegistry));
                                    break;
                                case 40:
                                    this.isEndQuestAccept_ = input.readBool();
                                    break;
                                case 56:
                                    this.contentCloseTime_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.dayIndex_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.isContentClosed_ = input.readBool();
                                    break;
                                case 112:
                                    this.playerDayIndex_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.dayContentInfoList_ = Collections.unmodifiableList(this.dayContentInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FindHilichurlDetailInfoOuterClass.internal_static_FindHilichurlDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FindHilichurlDetailInfoOuterClass.internal_static_FindHilichurlDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FindHilichurlDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public int getMinOpenPlayerLevel() {
            return this.minOpenPlayerLevel_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public List<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo> getDayContentInfoListList() {
            return this.dayContentInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public List<? extends FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder> getDayContentInfoListOrBuilderList() {
            return this.dayContentInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public int getDayContentInfoListCount() {
            return this.dayContentInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo getDayContentInfoList(int index) {
            return this.dayContentInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder getDayContentInfoListOrBuilder(int index) {
            return this.dayContentInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public boolean getIsEndQuestAccept() {
            return this.isEndQuestAccept_;
        }

        @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
        public int getPlayerDayIndex() {
            return this.playerDayIndex_;
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
            if (this.minOpenPlayerLevel_ != 0) {
                output.writeUInt32(2, this.minOpenPlayerLevel_);
            }
            for (int i = 0; i < this.dayContentInfoList_.size(); i++) {
                output.writeMessage(4, this.dayContentInfoList_.get(i));
            }
            if (this.isEndQuestAccept_) {
                output.writeBool(5, this.isEndQuestAccept_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(7, this.contentCloseTime_);
            }
            if (this.dayIndex_ != 0) {
                output.writeUInt32(8, this.dayIndex_);
            }
            if (this.isContentClosed_) {
                output.writeBool(12, this.isContentClosed_);
            }
            if (this.playerDayIndex_ != 0) {
                output.writeUInt32(14, this.playerDayIndex_);
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
            if (this.minOpenPlayerLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.minOpenPlayerLevel_);
            }
            for (int i = 0; i < this.dayContentInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.dayContentInfoList_.get(i));
            }
            if (this.isEndQuestAccept_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isEndQuestAccept_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.contentCloseTime_);
            }
            if (this.dayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.dayIndex_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isContentClosed_);
            }
            if (this.playerDayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.playerDayIndex_);
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
            if (!(obj instanceof FindHilichurlDetailInfo)) {
                return equals(obj);
            }
            FindHilichurlDetailInfo other = (FindHilichurlDetailInfo) obj;
            return getDayIndex() == other.getDayIndex() && getIsContentClosed() == other.getIsContentClosed() && getMinOpenPlayerLevel() == other.getMinOpenPlayerLevel() && getDayContentInfoListList().equals(other.getDayContentInfoListList()) && getContentCloseTime() == other.getContentCloseTime() && getIsEndQuestAccept() == other.getIsEndQuestAccept() && getPlayerDayIndex() == other.getPlayerDayIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getDayIndex())) + 12)) + Internal.hashBoolean(getIsContentClosed()))) + 2)) + getMinOpenPlayerLevel();
            if (getDayContentInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getDayContentInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 7)) + getContentCloseTime())) + 5)) + Internal.hashBoolean(getIsEndQuestAccept()))) + 14)) + getPlayerDayIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FindHilichurlDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FindHilichurlDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FindHilichurlDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FindHilichurlDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FindHilichurlDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FindHilichurlDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FindHilichurlDetailInfo parseFrom(InputStream input) throws IOException {
            return (FindHilichurlDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FindHilichurlDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FindHilichurlDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FindHilichurlDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FindHilichurlDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FindHilichurlDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FindHilichurlDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FindHilichurlDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (FindHilichurlDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FindHilichurlDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FindHilichurlDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FindHilichurlDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FindHilichurlDetailInfoOuterClass$FindHilichurlDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FindHilichurlDetailInfoOrBuilder {
            private int bitField0_;
            private int dayIndex_;
            private boolean isContentClosed_;
            private int minOpenPlayerLevel_;
            private List<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo> dayContentInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder> dayContentInfoListBuilder_;
            private int contentCloseTime_;
            private boolean isEndQuestAccept_;
            private int playerDayIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FindHilichurlDetailInfoOuterClass.internal_static_FindHilichurlDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FindHilichurlDetailInfoOuterClass.internal_static_FindHilichurlDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FindHilichurlDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FindHilichurlDetailInfo.alwaysUseFieldBuilders) {
                    getDayContentInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dayIndex_ = 0;
                this.isContentClosed_ = false;
                this.minOpenPlayerLevel_ = 0;
                if (this.dayContentInfoListBuilder_ == null) {
                    this.dayContentInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dayContentInfoListBuilder_.clear();
                }
                this.contentCloseTime_ = 0;
                this.isEndQuestAccept_ = false;
                this.playerDayIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FindHilichurlDetailInfoOuterClass.internal_static_FindHilichurlDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FindHilichurlDetailInfo getDefaultInstanceForType() {
                return FindHilichurlDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FindHilichurlDetailInfo build() {
                FindHilichurlDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FindHilichurlDetailInfo buildPartial() {
                FindHilichurlDetailInfo result = new FindHilichurlDetailInfo(this);
                int i = this.bitField0_;
                result.dayIndex_ = this.dayIndex_;
                result.isContentClosed_ = this.isContentClosed_;
                result.minOpenPlayerLevel_ = this.minOpenPlayerLevel_;
                if (this.dayContentInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dayContentInfoList_ = Collections.unmodifiableList(this.dayContentInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.dayContentInfoList_ = this.dayContentInfoList_;
                } else {
                    result.dayContentInfoList_ = this.dayContentInfoListBuilder_.build();
                }
                result.contentCloseTime_ = this.contentCloseTime_;
                result.isEndQuestAccept_ = this.isEndQuestAccept_;
                result.playerDayIndex_ = this.playerDayIndex_;
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
                if (other instanceof FindHilichurlDetailInfo) {
                    return mergeFrom((FindHilichurlDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FindHilichurlDetailInfo other) {
                if (other == FindHilichurlDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getMinOpenPlayerLevel() != 0) {
                    setMinOpenPlayerLevel(other.getMinOpenPlayerLevel());
                }
                if (this.dayContentInfoListBuilder_ == null) {
                    if (!other.dayContentInfoList_.isEmpty()) {
                        if (this.dayContentInfoList_.isEmpty()) {
                            this.dayContentInfoList_ = other.dayContentInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDayContentInfoListIsMutable();
                            this.dayContentInfoList_.addAll(other.dayContentInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dayContentInfoList_.isEmpty()) {
                    if (this.dayContentInfoListBuilder_.isEmpty()) {
                        this.dayContentInfoListBuilder_.dispose();
                        this.dayContentInfoListBuilder_ = null;
                        this.dayContentInfoList_ = other.dayContentInfoList_;
                        this.bitField0_ &= -2;
                        this.dayContentInfoListBuilder_ = FindHilichurlDetailInfo.alwaysUseFieldBuilders ? getDayContentInfoListFieldBuilder() : null;
                    } else {
                        this.dayContentInfoListBuilder_.addAllMessages(other.dayContentInfoList_);
                    }
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getIsEndQuestAccept()) {
                    setIsEndQuestAccept(other.getIsEndQuestAccept());
                }
                if (other.getPlayerDayIndex() != 0) {
                    setPlayerDayIndex(other.getPlayerDayIndex());
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
                FindHilichurlDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FindHilichurlDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FindHilichurlDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
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

            private void ensureDayContentInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dayContentInfoList_ = new ArrayList(this.dayContentInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public List<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo> getDayContentInfoListList() {
                if (this.dayContentInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dayContentInfoList_);
                }
                return this.dayContentInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public int getDayContentInfoListCount() {
                if (this.dayContentInfoListBuilder_ == null) {
                    return this.dayContentInfoList_.size();
                }
                return this.dayContentInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo getDayContentInfoList(int index) {
                if (this.dayContentInfoListBuilder_ == null) {
                    return this.dayContentInfoList_.get(index);
                }
                return this.dayContentInfoListBuilder_.getMessage(index);
            }

            public Builder setDayContentInfoList(int index, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo value) {
                if (this.dayContentInfoListBuilder_ != null) {
                    this.dayContentInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDayContentInfoList(int index, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder builderForValue) {
                if (this.dayContentInfoListBuilder_ == null) {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dayContentInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDayContentInfoList(FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo value) {
                if (this.dayContentInfoListBuilder_ != null) {
                    this.dayContentInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDayContentInfoList(int index, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo value) {
                if (this.dayContentInfoListBuilder_ != null) {
                    this.dayContentInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDayContentInfoList(FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder builderForValue) {
                if (this.dayContentInfoListBuilder_ == null) {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dayContentInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDayContentInfoList(int index, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder builderForValue) {
                if (this.dayContentInfoListBuilder_ == null) {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dayContentInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDayContentInfoList(Iterable<? extends FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo> values) {
                if (this.dayContentInfoListBuilder_ == null) {
                    ensureDayContentInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dayContentInfoList_);
                    onChanged();
                } else {
                    this.dayContentInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDayContentInfoList() {
                if (this.dayContentInfoListBuilder_ == null) {
                    this.dayContentInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dayContentInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDayContentInfoList(int index) {
                if (this.dayContentInfoListBuilder_ == null) {
                    ensureDayContentInfoListIsMutable();
                    this.dayContentInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dayContentInfoListBuilder_.remove(index);
                }
                return this;
            }

            public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder getDayContentInfoListBuilder(int index) {
                return getDayContentInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder getDayContentInfoListOrBuilder(int index) {
                if (this.dayContentInfoListBuilder_ == null) {
                    return this.dayContentInfoList_.get(index);
                }
                return this.dayContentInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public List<? extends FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder> getDayContentInfoListOrBuilderList() {
                if (this.dayContentInfoListBuilder_ != null) {
                    return this.dayContentInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dayContentInfoList_);
            }

            public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder addDayContentInfoListBuilder() {
                return getDayContentInfoListFieldBuilder().addBuilder(FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.getDefaultInstance());
            }

            public FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder addDayContentInfoListBuilder(int index) {
                return getDayContentInfoListFieldBuilder().addBuilder(index, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.getDefaultInstance());
            }

            public List<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder> getDayContentInfoListBuilderList() {
                return getDayContentInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfo.Builder, FindHilichurlDayContentInfoOuterClass.FindHilichurlDayContentInfoOrBuilder> getDayContentInfoListFieldBuilder() {
                if (this.dayContentInfoListBuilder_ == null) {
                    this.dayContentInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dayContentInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dayContentInfoList_ = null;
                }
                return this.dayContentInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public boolean getIsEndQuestAccept() {
                return this.isEndQuestAccept_;
            }

            public Builder setIsEndQuestAccept(boolean value) {
                this.isEndQuestAccept_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEndQuestAccept() {
                this.isEndQuestAccept_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder
            public int getPlayerDayIndex() {
                return this.playerDayIndex_;
            }

            public Builder setPlayerDayIndex(int value) {
                this.playerDayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerDayIndex() {
                this.playerDayIndex_ = 0;
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

        public static FindHilichurlDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FindHilichurlDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FindHilichurlDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FindHilichurlDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FindHilichurlDayContentInfoOuterClass.getDescriptor();
    }
}
