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
import emu.grasscutter.net.proto.HomeSeekFurniturePlayerScoreOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureOneRecordOuterClass.class */
public final class HomeSeekFurnitureOneRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeSeekFurnitureOneRecord.proto\u001a\"HomeSeekFurniturePlayerScore.proto\"q\n\u001aHomeSeekFurnitureOneRecord\u0012\u0011\n\ttimestamp\u0018\f \u0001(\r\u0012@\n\u0019engaged_player_score_list\u0018\u0005 \u0003(\u000b2\u001d.HomeSeekFurniturePlayerScoreB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeSeekFurniturePlayerScoreOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeSeekFurnitureOneRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeSeekFurnitureOneRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeSeekFurnitureOneRecord_descriptor, new String[]{"Timestamp", "EngagedPlayerScoreList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureOneRecordOuterClass$HomeSeekFurnitureOneRecordOrBuilder.class */
    public interface HomeSeekFurnitureOneRecordOrBuilder extends MessageOrBuilder {
        int getTimestamp();

        List<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore> getEngagedPlayerScoreListList();

        HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore getEngagedPlayerScoreList(int i);

        int getEngagedPlayerScoreListCount();

        List<? extends HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder> getEngagedPlayerScoreListOrBuilderList();

        HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder getEngagedPlayerScoreListOrBuilder(int i);
    }

    private HomeSeekFurnitureOneRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureOneRecordOuterClass$HomeSeekFurnitureOneRecord.class */
    public static final class HomeSeekFurnitureOneRecord extends GeneratedMessageV3 implements HomeSeekFurnitureOneRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TIMESTAMP_FIELD_NUMBER = 12;
        private int timestamp_;
        public static final int ENGAGED_PLAYER_SCORE_LIST_FIELD_NUMBER = 5;
        private List<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore> engagedPlayerScoreList_;
        private byte memoizedIsInitialized;
        private static final HomeSeekFurnitureOneRecord DEFAULT_INSTANCE = new HomeSeekFurnitureOneRecord();
        private static final Parser<HomeSeekFurnitureOneRecord> PARSER = new AbstractParser<HomeSeekFurnitureOneRecord>() { // from class: emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecord.1
            @Override // com.google.protobuf.Parser
            public HomeSeekFurnitureOneRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeSeekFurnitureOneRecord(input, extensionRegistry);
            }
        };

        private HomeSeekFurnitureOneRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeSeekFurnitureOneRecord() {
            this.memoizedIsInitialized = -1;
            this.engagedPlayerScoreList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeSeekFurnitureOneRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeSeekFurnitureOneRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.engagedPlayerScoreList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.engagedPlayerScoreList_.add((HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore) input.readMessage(HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.parser(), extensionRegistry));
                                    break;
                                case 96:
                                    this.timestamp_ = input.readUInt32();
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
                    this.engagedPlayerScoreList_ = Collections.unmodifiableList(this.engagedPlayerScoreList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeSeekFurnitureOneRecordOuterClass.internal_static_HomeSeekFurnitureOneRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeSeekFurnitureOneRecordOuterClass.internal_static_HomeSeekFurnitureOneRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSeekFurnitureOneRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
        public int getTimestamp() {
            return this.timestamp_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
        public List<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore> getEngagedPlayerScoreListList() {
            return this.engagedPlayerScoreList_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
        public List<? extends HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder> getEngagedPlayerScoreListOrBuilderList() {
            return this.engagedPlayerScoreList_;
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
        public int getEngagedPlayerScoreListCount() {
            return this.engagedPlayerScoreList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
        public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore getEngagedPlayerScoreList(int index) {
            return this.engagedPlayerScoreList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
        public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder getEngagedPlayerScoreListOrBuilder(int index) {
            return this.engagedPlayerScoreList_.get(index);
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
            for (int i = 0; i < this.engagedPlayerScoreList_.size(); i++) {
                output.writeMessage(5, this.engagedPlayerScoreList_.get(i));
            }
            if (this.timestamp_ != 0) {
                output.writeUInt32(12, this.timestamp_);
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
            for (int i = 0; i < this.engagedPlayerScoreList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.engagedPlayerScoreList_.get(i));
            }
            if (this.timestamp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.timestamp_);
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
            if (!(obj instanceof HomeSeekFurnitureOneRecord)) {
                return equals(obj);
            }
            HomeSeekFurnitureOneRecord other = (HomeSeekFurnitureOneRecord) obj;
            return getTimestamp() == other.getTimestamp() && getEngagedPlayerScoreListList().equals(other.getEngagedPlayerScoreListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getTimestamp();
            if (getEngagedPlayerScoreListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getEngagedPlayerScoreListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeSeekFurnitureOneRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(InputStream input) throws IOException {
            return (HomeSeekFurnitureOneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureOneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurnitureOneRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeSeekFurnitureOneRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureOneRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureOneRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(CodedInputStream input) throws IOException {
            return (HomeSeekFurnitureOneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSeekFurnitureOneRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSeekFurnitureOneRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeSeekFurnitureOneRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSeekFurnitureOneRecordOuterClass$HomeSeekFurnitureOneRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeSeekFurnitureOneRecordOrBuilder {
            private int bitField0_;
            private int timestamp_;
            private List<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore> engagedPlayerScoreList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder> engagedPlayerScoreListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeSeekFurnitureOneRecordOuterClass.internal_static_HomeSeekFurnitureOneRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeSeekFurnitureOneRecordOuterClass.internal_static_HomeSeekFurnitureOneRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSeekFurnitureOneRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeSeekFurnitureOneRecord.alwaysUseFieldBuilders) {
                    getEngagedPlayerScoreListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.timestamp_ = 0;
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    this.engagedPlayerScoreList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.engagedPlayerScoreListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeSeekFurnitureOneRecordOuterClass.internal_static_HomeSeekFurnitureOneRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeSeekFurnitureOneRecord getDefaultInstanceForType() {
                return HomeSeekFurnitureOneRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurnitureOneRecord build() {
                HomeSeekFurnitureOneRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSeekFurnitureOneRecord buildPartial() {
                HomeSeekFurnitureOneRecord result = new HomeSeekFurnitureOneRecord(this);
                int i = this.bitField0_;
                result.timestamp_ = this.timestamp_;
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.engagedPlayerScoreList_ = Collections.unmodifiableList(this.engagedPlayerScoreList_);
                        this.bitField0_ &= -2;
                    }
                    result.engagedPlayerScoreList_ = this.engagedPlayerScoreList_;
                } else {
                    result.engagedPlayerScoreList_ = this.engagedPlayerScoreListBuilder_.build();
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
                if (other instanceof HomeSeekFurnitureOneRecord) {
                    return mergeFrom((HomeSeekFurnitureOneRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeSeekFurnitureOneRecord other) {
                if (other == HomeSeekFurnitureOneRecord.getDefaultInstance()) {
                    return this;
                }
                if (other.getTimestamp() != 0) {
                    setTimestamp(other.getTimestamp());
                }
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    if (!other.engagedPlayerScoreList_.isEmpty()) {
                        if (this.engagedPlayerScoreList_.isEmpty()) {
                            this.engagedPlayerScoreList_ = other.engagedPlayerScoreList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureEngagedPlayerScoreListIsMutable();
                            this.engagedPlayerScoreList_.addAll(other.engagedPlayerScoreList_);
                        }
                        onChanged();
                    }
                } else if (!other.engagedPlayerScoreList_.isEmpty()) {
                    if (this.engagedPlayerScoreListBuilder_.isEmpty()) {
                        this.engagedPlayerScoreListBuilder_.dispose();
                        this.engagedPlayerScoreListBuilder_ = null;
                        this.engagedPlayerScoreList_ = other.engagedPlayerScoreList_;
                        this.bitField0_ &= -2;
                        this.engagedPlayerScoreListBuilder_ = HomeSeekFurnitureOneRecord.alwaysUseFieldBuilders ? getEngagedPlayerScoreListFieldBuilder() : null;
                    } else {
                        this.engagedPlayerScoreListBuilder_.addAllMessages(other.engagedPlayerScoreList_);
                    }
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
                HomeSeekFurnitureOneRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeSeekFurnitureOneRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeSeekFurnitureOneRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
            public int getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(int value) {
                this.timestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            private void ensureEngagedPlayerScoreListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.engagedPlayerScoreList_ = new ArrayList(this.engagedPlayerScoreList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
            public List<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore> getEngagedPlayerScoreListList() {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    return Collections.unmodifiableList(this.engagedPlayerScoreList_);
                }
                return this.engagedPlayerScoreListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
            public int getEngagedPlayerScoreListCount() {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    return this.engagedPlayerScoreList_.size();
                }
                return this.engagedPlayerScoreListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
            public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore getEngagedPlayerScoreList(int index) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    return this.engagedPlayerScoreList_.get(index);
                }
                return this.engagedPlayerScoreListBuilder_.getMessage(index);
            }

            public Builder setEngagedPlayerScoreList(int index, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore value) {
                if (this.engagedPlayerScoreListBuilder_ != null) {
                    this.engagedPlayerScoreListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setEngagedPlayerScoreList(int index, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder builderForValue) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.engagedPlayerScoreListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEngagedPlayerScoreList(HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore value) {
                if (this.engagedPlayerScoreListBuilder_ != null) {
                    this.engagedPlayerScoreListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addEngagedPlayerScoreList(int index, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore value) {
                if (this.engagedPlayerScoreListBuilder_ != null) {
                    this.engagedPlayerScoreListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addEngagedPlayerScoreList(HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder builderForValue) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.engagedPlayerScoreListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEngagedPlayerScoreList(int index, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder builderForValue) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.engagedPlayerScoreListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEngagedPlayerScoreList(Iterable<? extends HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore> values) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    ensureEngagedPlayerScoreListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.engagedPlayerScoreList_);
                    onChanged();
                } else {
                    this.engagedPlayerScoreListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEngagedPlayerScoreList() {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    this.engagedPlayerScoreList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.engagedPlayerScoreListBuilder_.clear();
                }
                return this;
            }

            public Builder removeEngagedPlayerScoreList(int index) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    ensureEngagedPlayerScoreListIsMutable();
                    this.engagedPlayerScoreList_.remove(index);
                    onChanged();
                } else {
                    this.engagedPlayerScoreListBuilder_.remove(index);
                }
                return this;
            }

            public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder getEngagedPlayerScoreListBuilder(int index) {
                return getEngagedPlayerScoreListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
            public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder getEngagedPlayerScoreListOrBuilder(int index) {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    return this.engagedPlayerScoreList_.get(index);
                }
                return this.engagedPlayerScoreListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSeekFurnitureOneRecordOuterClass.HomeSeekFurnitureOneRecordOrBuilder
            public List<? extends HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder> getEngagedPlayerScoreListOrBuilderList() {
                if (this.engagedPlayerScoreListBuilder_ != null) {
                    return this.engagedPlayerScoreListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.engagedPlayerScoreList_);
            }

            public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder addEngagedPlayerScoreListBuilder() {
                return getEngagedPlayerScoreListFieldBuilder().addBuilder(HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.getDefaultInstance());
            }

            public HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder addEngagedPlayerScoreListBuilder(int index) {
                return getEngagedPlayerScoreListFieldBuilder().addBuilder(index, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.getDefaultInstance());
            }

            public List<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder> getEngagedPlayerScoreListBuilderList() {
                return getEngagedPlayerScoreListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScore.Builder, HomeSeekFurniturePlayerScoreOuterClass.HomeSeekFurniturePlayerScoreOrBuilder> getEngagedPlayerScoreListFieldBuilder() {
                if (this.engagedPlayerScoreListBuilder_ == null) {
                    this.engagedPlayerScoreListBuilder_ = new RepeatedFieldBuilderV3<>(this.engagedPlayerScoreList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.engagedPlayerScoreList_ = null;
                }
                return this.engagedPlayerScoreListBuilder_;
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

        public static HomeSeekFurnitureOneRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeSeekFurnitureOneRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeSeekFurnitureOneRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeSeekFurnitureOneRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeSeekFurniturePlayerScoreOuterClass.getDescriptor();
    }
}
