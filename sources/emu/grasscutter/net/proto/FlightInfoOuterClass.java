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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightInfoOuterClass.class */
public final class FlightInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010FlightInfo.proto\u001a\u0017FlightDailyRecord.proto\"n\n\nFlightInfo\u0012+\n\u000fdailyRecordList\u0018\u0005 \u0003(\u000b2\u0012.FlightDailyRecord\u0012\u001a\n\u0012minOpenPlayerLevel\u0018\u0002 \u0001(\r\u0012\u0017\n\u000fpreviewRewardId\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FlightDailyRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FlightInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FlightInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FlightInfo_descriptor, new String[]{"DailyRecordList", "MinOpenPlayerLevel", "PreviewRewardId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightInfoOuterClass$FlightInfoOrBuilder.class */
    public interface FlightInfoOrBuilder extends MessageOrBuilder {
        List<FlightDailyRecordOuterClass.FlightDailyRecord> getDailyRecordListList();

        FlightDailyRecordOuterClass.FlightDailyRecord getDailyRecordList(int i);

        int getDailyRecordListCount();

        List<? extends FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> getDailyRecordListOrBuilderList();

        FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder getDailyRecordListOrBuilder(int i);

        int getMinOpenPlayerLevel();

        int getPreviewRewardId();
    }

    private FlightInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightInfoOuterClass$FlightInfo.class */
    public static final class FlightInfo extends GeneratedMessageV3 implements FlightInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAILYRECORDLIST_FIELD_NUMBER = 5;
        private List<FlightDailyRecordOuterClass.FlightDailyRecord> dailyRecordList_;
        public static final int MINOPENPLAYERLEVEL_FIELD_NUMBER = 2;
        private int minOpenPlayerLevel_;
        public static final int PREVIEWREWARDID_FIELD_NUMBER = 7;
        private int previewRewardId_;
        private byte memoizedIsInitialized;
        private static final FlightInfo DEFAULT_INSTANCE = new FlightInfo();
        private static final Parser<FlightInfo> PARSER = new AbstractParser<FlightInfo>() { // from class: emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfo.1
            @Override // com.google.protobuf.Parser
            public FlightInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FlightInfo(input, extensionRegistry);
            }
        };

        private FlightInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FlightInfo() {
            this.memoizedIsInitialized = -1;
            this.dailyRecordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FlightInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FlightInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.minOpenPlayerLevel_ = input.readUInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dailyRecordList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.dailyRecordList_.add((FlightDailyRecordOuterClass.FlightDailyRecord) input.readMessage(FlightDailyRecordOuterClass.FlightDailyRecord.parser(), extensionRegistry));
                                break;
                            case 56:
                                this.previewRewardId_ = input.readUInt32();
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
            return FlightInfoOuterClass.internal_static_FlightInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FlightInfoOuterClass.internal_static_FlightInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FlightInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public List<FlightDailyRecordOuterClass.FlightDailyRecord> getDailyRecordListList() {
            return this.dailyRecordList_;
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public List<? extends FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> getDailyRecordListOrBuilderList() {
            return this.dailyRecordList_;
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public int getDailyRecordListCount() {
            return this.dailyRecordList_.size();
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public FlightDailyRecordOuterClass.FlightDailyRecord getDailyRecordList(int index) {
            return this.dailyRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder getDailyRecordListOrBuilder(int index) {
            return this.dailyRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public int getMinOpenPlayerLevel() {
            return this.minOpenPlayerLevel_;
        }

        @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
        public int getPreviewRewardId() {
            return this.previewRewardId_;
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
            for (int i = 0; i < this.dailyRecordList_.size(); i++) {
                output.writeMessage(5, this.dailyRecordList_.get(i));
            }
            if (this.previewRewardId_ != 0) {
                output.writeUInt32(7, this.previewRewardId_);
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
            for (int i = 0; i < this.dailyRecordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.dailyRecordList_.get(i));
            }
            if (this.previewRewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.previewRewardId_);
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
            if (!(obj instanceof FlightInfo)) {
                return equals(obj);
            }
            FlightInfo other = (FlightInfo) obj;
            return getDailyRecordListList().equals(other.getDailyRecordListList()) && getMinOpenPlayerLevel() == other.getMinOpenPlayerLevel() && getPreviewRewardId() == other.getPreviewRewardId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDailyRecordListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getDailyRecordListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getMinOpenPlayerLevel())) + 7)) + getPreviewRewardId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FlightInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FlightInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FlightInfo parseFrom(InputStream input) throws IOException {
            return (FlightInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FlightInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FlightInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FlightInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FlightInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FlightInfo parseFrom(CodedInputStream input) throws IOException {
            return (FlightInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FlightInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FlightInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FlightInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FlightInfoOuterClass$FlightInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FlightInfoOrBuilder {
            private int bitField0_;
            private List<FlightDailyRecordOuterClass.FlightDailyRecord> dailyRecordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FlightDailyRecordOuterClass.FlightDailyRecord, FlightDailyRecordOuterClass.FlightDailyRecord.Builder, FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder> dailyRecordListBuilder_;
            private int minOpenPlayerLevel_;
            private int previewRewardId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FlightInfoOuterClass.internal_static_FlightInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FlightInfoOuterClass.internal_static_FlightInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FlightInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FlightInfo.alwaysUseFieldBuilders) {
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
                this.minOpenPlayerLevel_ = 0;
                this.previewRewardId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FlightInfoOuterClass.internal_static_FlightInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FlightInfo getDefaultInstanceForType() {
                return FlightInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FlightInfo build() {
                FlightInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FlightInfo buildPartial() {
                FlightInfo result = new FlightInfo(this);
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
                result.minOpenPlayerLevel_ = this.minOpenPlayerLevel_;
                result.previewRewardId_ = this.previewRewardId_;
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
                if (other instanceof FlightInfo) {
                    return mergeFrom((FlightInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FlightInfo other) {
                if (other == FlightInfo.getDefaultInstance()) {
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
                        this.dailyRecordListBuilder_ = FlightInfo.alwaysUseFieldBuilders ? getDailyRecordListFieldBuilder() : null;
                    } else {
                        this.dailyRecordListBuilder_.addAllMessages(other.dailyRecordList_);
                    }
                }
                if (other.getMinOpenPlayerLevel() != 0) {
                    setMinOpenPlayerLevel(other.getMinOpenPlayerLevel());
                }
                if (other.getPreviewRewardId() != 0) {
                    setPreviewRewardId(other.getPreviewRewardId());
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
                FlightInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FlightInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FlightInfo) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
            public List<FlightDailyRecordOuterClass.FlightDailyRecord> getDailyRecordListList() {
                if (this.dailyRecordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dailyRecordList_);
                }
                return this.dailyRecordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
            public int getDailyRecordListCount() {
                if (this.dailyRecordListBuilder_ == null) {
                    return this.dailyRecordList_.size();
                }
                return this.dailyRecordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
            public FlightDailyRecordOuterClass.FlightDailyRecordOrBuilder getDailyRecordListOrBuilder(int index) {
                if (this.dailyRecordListBuilder_ == null) {
                    return this.dailyRecordList_.get(index);
                }
                return this.dailyRecordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.FlightInfoOuterClass.FlightInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static FlightInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FlightInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FlightInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FlightInfo getDefaultInstanceForType() {
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
