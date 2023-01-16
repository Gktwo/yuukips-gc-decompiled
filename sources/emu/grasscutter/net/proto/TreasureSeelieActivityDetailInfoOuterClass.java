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
import emu.grasscutter.net.proto.TreasureSeelieRegionDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieActivityDetailInfoOuterClass.class */
public final class TreasureSeelieActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&TreasureSeelieActivityDetailInfo.proto\u001a\u001eTreasureSeelieRegionData.proto\"\u0001\n TreasureSeelieActivityDetailInfo\u0012\u001b\n\u0013treasure_close_time\u0018\r \u0001(\r\u0012\u0019\n\u0011is_content_closed\u0018\u000f \u0001(\b\u00123\n\u0010region_data_list\u0018\u0006 \u0003(\u000b2\u0019.TreasureSeelieRegionDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TreasureSeelieRegionDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TreasureSeelieActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TreasureSeelieActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f896x9550ae8b = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureSeelieActivityDetailInfo_descriptor, new String[]{"TreasureCloseTime", "IsContentClosed", "RegionDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieActivityDetailInfoOuterClass$TreasureSeelieActivityDetailInfoOrBuilder.class */
    public interface TreasureSeelieActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getTreasureCloseTime();

        boolean getIsContentClosed();

        List<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData> getRegionDataListList();

        TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData getRegionDataList(int i);

        int getRegionDataListCount();

        List<? extends TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder> getRegionDataListOrBuilderList();

        TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder getRegionDataListOrBuilder(int i);
    }

    private TreasureSeelieActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieActivityDetailInfoOuterClass$TreasureSeelieActivityDetailInfo.class */
    public static final class TreasureSeelieActivityDetailInfo extends GeneratedMessageV3 implements TreasureSeelieActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TREASURE_CLOSE_TIME_FIELD_NUMBER = 13;
        private int treasureCloseTime_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 15;
        private boolean isContentClosed_;
        public static final int REGION_DATA_LIST_FIELD_NUMBER = 6;
        private List<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData> regionDataList_;
        private byte memoizedIsInitialized;
        private static final TreasureSeelieActivityDetailInfo DEFAULT_INSTANCE = new TreasureSeelieActivityDetailInfo();
        private static final Parser<TreasureSeelieActivityDetailInfo> PARSER = new AbstractParser<TreasureSeelieActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public TreasureSeelieActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureSeelieActivityDetailInfo(input, extensionRegistry);
            }
        };

        private TreasureSeelieActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureSeelieActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.regionDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureSeelieActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureSeelieActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.regionDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.regionDataList_.add((TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData) input.readMessage(TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.parser(), extensionRegistry));
                                break;
                            case 104:
                                this.treasureCloseTime_ = input.readUInt32();
                                break;
                            case 120:
                                this.isContentClosed_ = input.readBool();
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
                    this.regionDataList_ = Collections.unmodifiableList(this.regionDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TreasureSeelieActivityDetailInfoOuterClass.internal_static_TreasureSeelieActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureSeelieActivityDetailInfoOuterClass.f896x9550ae8b.ensureFieldAccessorsInitialized(TreasureSeelieActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public int getTreasureCloseTime() {
            return this.treasureCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public List<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData> getRegionDataListList() {
            return this.regionDataList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public List<? extends TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder> getRegionDataListOrBuilderList() {
            return this.regionDataList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public int getRegionDataListCount() {
            return this.regionDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData getRegionDataList(int index) {
            return this.regionDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
        public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder getRegionDataListOrBuilder(int index) {
            return this.regionDataList_.get(index);
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
            for (int i = 0; i < this.regionDataList_.size(); i++) {
                output.writeMessage(6, this.regionDataList_.get(i));
            }
            if (this.treasureCloseTime_ != 0) {
                output.writeUInt32(13, this.treasureCloseTime_);
            }
            if (this.isContentClosed_) {
                output.writeBool(15, this.isContentClosed_);
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
            for (int i = 0; i < this.regionDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.regionDataList_.get(i));
            }
            if (this.treasureCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.treasureCloseTime_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isContentClosed_);
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
            if (!(obj instanceof TreasureSeelieActivityDetailInfo)) {
                return equals(obj);
            }
            TreasureSeelieActivityDetailInfo other = (TreasureSeelieActivityDetailInfo) obj;
            return getTreasureCloseTime() == other.getTreasureCloseTime() && getIsContentClosed() == other.getIsContentClosed() && getRegionDataListList().equals(other.getRegionDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getTreasureCloseTime())) + 15)) + Internal.hashBoolean(getIsContentClosed());
            if (getRegionDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getRegionDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (TreasureSeelieActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureSeelieActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureSeelieActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureSeelieActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (TreasureSeelieActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureSeelieActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureSeelieActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieActivityDetailInfoOuterClass$TreasureSeelieActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureSeelieActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int treasureCloseTime_;
            private boolean isContentClosed_;
            private List<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData> regionDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder> regionDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureSeelieActivityDetailInfoOuterClass.internal_static_TreasureSeelieActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureSeelieActivityDetailInfoOuterClass.f896x9550ae8b.ensureFieldAccessorsInitialized(TreasureSeelieActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureSeelieActivityDetailInfo.alwaysUseFieldBuilders) {
                    getRegionDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.treasureCloseTime_ = 0;
                this.isContentClosed_ = false;
                if (this.regionDataListBuilder_ == null) {
                    this.regionDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.regionDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureSeelieActivityDetailInfoOuterClass.internal_static_TreasureSeelieActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureSeelieActivityDetailInfo getDefaultInstanceForType() {
                return TreasureSeelieActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureSeelieActivityDetailInfo build() {
                TreasureSeelieActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureSeelieActivityDetailInfo buildPartial() {
                TreasureSeelieActivityDetailInfo result = new TreasureSeelieActivityDetailInfo(this);
                int i = this.bitField0_;
                result.treasureCloseTime_ = this.treasureCloseTime_;
                result.isContentClosed_ = this.isContentClosed_;
                if (this.regionDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.regionDataList_ = Collections.unmodifiableList(this.regionDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.regionDataList_ = this.regionDataList_;
                } else {
                    result.regionDataList_ = this.regionDataListBuilder_.build();
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
                if (other instanceof TreasureSeelieActivityDetailInfo) {
                    return mergeFrom((TreasureSeelieActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureSeelieActivityDetailInfo other) {
                if (other == TreasureSeelieActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTreasureCloseTime() != 0) {
                    setTreasureCloseTime(other.getTreasureCloseTime());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (this.regionDataListBuilder_ == null) {
                    if (!other.regionDataList_.isEmpty()) {
                        if (this.regionDataList_.isEmpty()) {
                            this.regionDataList_ = other.regionDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRegionDataListIsMutable();
                            this.regionDataList_.addAll(other.regionDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.regionDataList_.isEmpty()) {
                    if (this.regionDataListBuilder_.isEmpty()) {
                        this.regionDataListBuilder_.dispose();
                        this.regionDataListBuilder_ = null;
                        this.regionDataList_ = other.regionDataList_;
                        this.bitField0_ &= -2;
                        this.regionDataListBuilder_ = TreasureSeelieActivityDetailInfo.alwaysUseFieldBuilders ? getRegionDataListFieldBuilder() : null;
                    } else {
                        this.regionDataListBuilder_.addAllMessages(other.regionDataList_);
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
                TreasureSeelieActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureSeelieActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureSeelieActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
            public int getTreasureCloseTime() {
                return this.treasureCloseTime_;
            }

            public Builder setTreasureCloseTime(int value) {
                this.treasureCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTreasureCloseTime() {
                this.treasureCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
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

            private void ensureRegionDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.regionDataList_ = new ArrayList(this.regionDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
            public List<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData> getRegionDataListList() {
                if (this.regionDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.regionDataList_);
                }
                return this.regionDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
            public int getRegionDataListCount() {
                if (this.regionDataListBuilder_ == null) {
                    return this.regionDataList_.size();
                }
                return this.regionDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
            public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData getRegionDataList(int index) {
                if (this.regionDataListBuilder_ == null) {
                    return this.regionDataList_.get(index);
                }
                return this.regionDataListBuilder_.getMessage(index);
            }

            public Builder setRegionDataList(int index, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData value) {
                if (this.regionDataListBuilder_ != null) {
                    this.regionDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRegionDataList(int index, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder builderForValue) {
                if (this.regionDataListBuilder_ == null) {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.regionDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRegionDataList(TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData value) {
                if (this.regionDataListBuilder_ != null) {
                    this.regionDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRegionDataList(int index, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData value) {
                if (this.regionDataListBuilder_ != null) {
                    this.regionDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRegionDataList(TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder builderForValue) {
                if (this.regionDataListBuilder_ == null) {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.regionDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRegionDataList(int index, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder builderForValue) {
                if (this.regionDataListBuilder_ == null) {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.regionDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRegionDataList(Iterable<? extends TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData> values) {
                if (this.regionDataListBuilder_ == null) {
                    ensureRegionDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.regionDataList_);
                    onChanged();
                } else {
                    this.regionDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRegionDataList() {
                if (this.regionDataListBuilder_ == null) {
                    this.regionDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.regionDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRegionDataList(int index) {
                if (this.regionDataListBuilder_ == null) {
                    ensureRegionDataListIsMutable();
                    this.regionDataList_.remove(index);
                    onChanged();
                } else {
                    this.regionDataListBuilder_.remove(index);
                }
                return this;
            }

            public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder getRegionDataListBuilder(int index) {
                return getRegionDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
            public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder getRegionDataListOrBuilder(int index) {
                if (this.regionDataListBuilder_ == null) {
                    return this.regionDataList_.get(index);
                }
                return this.regionDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder
            public List<? extends TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder> getRegionDataListOrBuilderList() {
                if (this.regionDataListBuilder_ != null) {
                    return this.regionDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.regionDataList_);
            }

            public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder addRegionDataListBuilder() {
                return getRegionDataListFieldBuilder().addBuilder(TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.getDefaultInstance());
            }

            public TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder addRegionDataListBuilder(int index) {
                return getRegionDataListFieldBuilder().addBuilder(index, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.getDefaultInstance());
            }

            public List<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder> getRegionDataListBuilderList() {
                return getRegionDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionData.Builder, TreasureSeelieRegionDataOuterClass.TreasureSeelieRegionDataOrBuilder> getRegionDataListFieldBuilder() {
                if (this.regionDataListBuilder_ == null) {
                    this.regionDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.regionDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.regionDataList_ = null;
                }
                return this.regionDataListBuilder_;
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

        public static TreasureSeelieActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureSeelieActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureSeelieActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureSeelieActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TreasureSeelieRegionDataOuterClass.getDescriptor();
    }
}
