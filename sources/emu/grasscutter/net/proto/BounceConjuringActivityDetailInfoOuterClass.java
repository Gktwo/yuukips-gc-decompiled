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
import emu.grasscutter.net.proto.BounceConjuringChapterInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringActivityDetailInfoOuterClass.class */
public final class BounceConjuringActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'BounceConjuringActivityDetailInfo.proto\u001a BounceConjuringChapterInfo.proto\"\u0001\n!BounceConjuringActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\b \u0001(\b\u00126\n\u0011chapter_info_list\u0018\u000f \u0003(\u000b2\u001b.BounceConjuringChapterInfo\u0012\u001a\n\u0012content_close_time\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BounceConjuringChapterInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BounceConjuringActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_BounceConjuringActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f661xc70e9938 = new GeneratedMessageV3.FieldAccessorTable(internal_static_BounceConjuringActivityDetailInfo_descriptor, new String[]{"IsContentClosed", "ChapterInfoList", "ContentCloseTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringActivityDetailInfoOuterClass$BounceConjuringActivityDetailInfoOrBuilder.class */
    public interface BounceConjuringActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        List<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo> getChapterInfoListList();

        BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo getChapterInfoList(int i);

        int getChapterInfoListCount();

        List<? extends BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder> getChapterInfoListOrBuilderList();

        BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder getChapterInfoListOrBuilder(int i);

        int getContentCloseTime();
    }

    private BounceConjuringActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringActivityDetailInfoOuterClass$BounceConjuringActivityDetailInfo.class */
    public static final class BounceConjuringActivityDetailInfo extends GeneratedMessageV3 implements BounceConjuringActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 8;
        private boolean isContentClosed_;
        public static final int CHAPTER_INFO_LIST_FIELD_NUMBER = 15;
        private List<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo> chapterInfoList_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 2;
        private int contentCloseTime_;
        private byte memoizedIsInitialized;
        private static final BounceConjuringActivityDetailInfo DEFAULT_INSTANCE = new BounceConjuringActivityDetailInfo();
        private static final Parser<BounceConjuringActivityDetailInfo> PARSER = new AbstractParser<BounceConjuringActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public BounceConjuringActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BounceConjuringActivityDetailInfo(input, extensionRegistry);
            }
        };

        private BounceConjuringActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BounceConjuringActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.chapterInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BounceConjuringActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BounceConjuringActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 64:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.chapterInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.chapterInfoList_.add((BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo) input.readMessage(BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.parser(), extensionRegistry));
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
                    this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BounceConjuringActivityDetailInfoOuterClass.internal_static_BounceConjuringActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BounceConjuringActivityDetailInfoOuterClass.f661xc70e9938.ensureFieldAccessorsInitialized(BounceConjuringActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public List<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo> getChapterInfoListList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public List<? extends BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public int getChapterInfoListCount() {
            return this.chapterInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo getChapterInfoList(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
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
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(2, this.contentCloseTime_);
            }
            if (this.isContentClosed_) {
                output.writeBool(8, this.isContentClosed_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                output.writeMessage(15, this.chapterInfoList_.get(i));
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
            if (this.contentCloseTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.contentCloseTime_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isContentClosed_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.chapterInfoList_.get(i));
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
            if (!(obj instanceof BounceConjuringActivityDetailInfo)) {
                return equals(obj);
            }
            BounceConjuringActivityDetailInfo other = (BounceConjuringActivityDetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getChapterInfoListList().equals(other.getChapterInfoListList()) && getContentCloseTime() == other.getContentCloseTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsContentClosed());
            if (getChapterInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getChapterInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getContentCloseTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BounceConjuringActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (BounceConjuringActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BounceConjuringActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BounceConjuringActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BounceConjuringActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (BounceConjuringActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BounceConjuringActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BounceConjuringActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringActivityDetailInfoOuterClass$BounceConjuringActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BounceConjuringActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private List<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo> chapterInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder> chapterInfoListBuilder_;
            private int contentCloseTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BounceConjuringActivityDetailInfoOuterClass.internal_static_BounceConjuringActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BounceConjuringActivityDetailInfoOuterClass.f661xc70e9938.ensureFieldAccessorsInitialized(BounceConjuringActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BounceConjuringActivityDetailInfo.alwaysUseFieldBuilders) {
                    getChapterInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                this.contentCloseTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BounceConjuringActivityDetailInfoOuterClass.internal_static_BounceConjuringActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BounceConjuringActivityDetailInfo getDefaultInstanceForType() {
                return BounceConjuringActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BounceConjuringActivityDetailInfo build() {
                BounceConjuringActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BounceConjuringActivityDetailInfo buildPartial() {
                BounceConjuringActivityDetailInfo result = new BounceConjuringActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                if (this.chapterInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.chapterInfoList_ = this.chapterInfoList_;
                } else {
                    result.chapterInfoList_ = this.chapterInfoListBuilder_.build();
                }
                result.contentCloseTime_ = this.contentCloseTime_;
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
                if (other instanceof BounceConjuringActivityDetailInfo) {
                    return mergeFrom((BounceConjuringActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BounceConjuringActivityDetailInfo other) {
                if (other == BounceConjuringActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (this.chapterInfoListBuilder_ == null) {
                    if (!other.chapterInfoList_.isEmpty()) {
                        if (this.chapterInfoList_.isEmpty()) {
                            this.chapterInfoList_ = other.chapterInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChapterInfoListIsMutable();
                            this.chapterInfoList_.addAll(other.chapterInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.chapterInfoList_.isEmpty()) {
                    if (this.chapterInfoListBuilder_.isEmpty()) {
                        this.chapterInfoListBuilder_.dispose();
                        this.chapterInfoListBuilder_ = null;
                        this.chapterInfoList_ = other.chapterInfoList_;
                        this.bitField0_ &= -2;
                        this.chapterInfoListBuilder_ = BounceConjuringActivityDetailInfo.alwaysUseFieldBuilders ? getChapterInfoListFieldBuilder() : null;
                    } else {
                        this.chapterInfoListBuilder_.addAllMessages(other.chapterInfoList_);
                    }
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
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
                BounceConjuringActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BounceConjuringActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BounceConjuringActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
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

            private void ensureChapterInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chapterInfoList_ = new ArrayList(this.chapterInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
            public List<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo> getChapterInfoListList() {
                if (this.chapterInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chapterInfoList_);
                }
                return this.chapterInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
            public int getChapterInfoListCount() {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.size();
                }
                return this.chapterInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
            public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo getChapterInfoList(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessage(index);
            }

            public Builder setChapterInfoList(int index, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChapterInfoList(int index, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChapterInfoList(BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChapterInfoList(int index, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChapterInfoList(BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChapterInfoList(int index, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChapterInfoList(Iterable<? extends BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo> values) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chapterInfoList_);
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChapterInfoList() {
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChapterInfoList(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.remove(index);
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder getChapterInfoListBuilder(int index) {
                return getChapterInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
            public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
            public List<? extends BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
                if (this.chapterInfoListBuilder_ != null) {
                    return this.chapterInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.chapterInfoList_);
            }

            public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder addChapterInfoListBuilder() {
                return getChapterInfoListFieldBuilder().addBuilder(BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.getDefaultInstance());
            }

            public BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder addChapterInfoListBuilder(int index) {
                return getChapterInfoListFieldBuilder().addBuilder(index, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.getDefaultInstance());
            }

            public List<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder> getChapterInfoListBuilderList() {
                return getChapterInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfo.Builder, BounceConjuringChapterInfoOuterClass.BounceConjuringChapterInfoOrBuilder> getChapterInfoListFieldBuilder() {
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.chapterInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.chapterInfoList_ = null;
                }
                return this.chapterInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static BounceConjuringActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BounceConjuringActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BounceConjuringActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BounceConjuringActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BounceConjuringChapterInfoOuterClass.getDescriptor();
    }
}
