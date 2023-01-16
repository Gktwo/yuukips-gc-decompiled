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
import emu.grasscutter.net.proto.TanukiTravelLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityDetailInfoOuterClass.class */
public final class TanukiTravelActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$TanukiTravelActivityDetailInfo.proto\u001a\u001bTanukiTravelLevelData.proto\"\u0001\n\u001eTanukiTravelActivityDetailInfo\u0012=\n\u001dtanuki_travel_level_data_list\u0018\u0005 \u0003(\u000b2\u0016.TanukiTravelLevelData\u0012\u0019\n\u0011is_content_closed\u0018\f \u0001(\b\u0012\u001c\n\u0014finished_level_index\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TanukiTravelLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TanukiTravelActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TanukiTravelActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f886x403cbda3 = new GeneratedMessageV3.FieldAccessorTable(internal_static_TanukiTravelActivityDetailInfo_descriptor, new String[]{"TanukiTravelLevelDataList", "IsContentClosed", "FinishedLevelIndex"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityDetailInfoOuterClass$TanukiTravelActivityDetailInfoOrBuilder.class */
    public interface TanukiTravelActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> getTanukiTravelLevelDataListList();

        TanukiTravelLevelDataOuterClass.TanukiTravelLevelData getTanukiTravelLevelDataList(int i);

        int getTanukiTravelLevelDataListCount();

        List<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListOrBuilderList();

        TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder getTanukiTravelLevelDataListOrBuilder(int i);

        boolean getIsContentClosed();

        int getFinishedLevelIndex();
    }

    private TanukiTravelActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityDetailInfoOuterClass$TanukiTravelActivityDetailInfo.class */
    public static final class TanukiTravelActivityDetailInfo extends GeneratedMessageV3 implements TanukiTravelActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TANUKI_TRAVEL_LEVEL_DATA_LIST_FIELD_NUMBER = 5;
        private List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> tanukiTravelLevelDataList_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 12;
        private boolean isContentClosed_;
        public static final int FINISHED_LEVEL_INDEX_FIELD_NUMBER = 15;
        private int finishedLevelIndex_;
        private byte memoizedIsInitialized;
        private static final TanukiTravelActivityDetailInfo DEFAULT_INSTANCE = new TanukiTravelActivityDetailInfo();
        private static final Parser<TanukiTravelActivityDetailInfo> PARSER = new AbstractParser<TanukiTravelActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public TanukiTravelActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TanukiTravelActivityDetailInfo(input, extensionRegistry);
            }
        };

        private TanukiTravelActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TanukiTravelActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.tanukiTravelLevelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TanukiTravelActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TanukiTravelActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.tanukiTravelLevelDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.tanukiTravelLevelDataList_.add((TanukiTravelLevelDataOuterClass.TanukiTravelLevelData) input.readMessage(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.parser(), extensionRegistry));
                                break;
                            case 96:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 120:
                                this.finishedLevelIndex_ = input.readUInt32();
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
                    this.tanukiTravelLevelDataList_ = Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TanukiTravelActivityDetailInfoOuterClass.internal_static_TanukiTravelActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TanukiTravelActivityDetailInfoOuterClass.f886x403cbda3.ensureFieldAccessorsInitialized(TanukiTravelActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> getTanukiTravelLevelDataListList() {
            return this.tanukiTravelLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public List<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListOrBuilderList() {
            return this.tanukiTravelLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public int getTanukiTravelLevelDataListCount() {
            return this.tanukiTravelLevelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData getTanukiTravelLevelDataList(int index) {
            return this.tanukiTravelLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder getTanukiTravelLevelDataListOrBuilder(int index) {
            return this.tanukiTravelLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
        public int getFinishedLevelIndex() {
            return this.finishedLevelIndex_;
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
            for (int i = 0; i < this.tanukiTravelLevelDataList_.size(); i++) {
                output.writeMessage(5, this.tanukiTravelLevelDataList_.get(i));
            }
            if (this.isContentClosed_) {
                output.writeBool(12, this.isContentClosed_);
            }
            if (this.finishedLevelIndex_ != 0) {
                output.writeUInt32(15, this.finishedLevelIndex_);
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
            for (int i = 0; i < this.tanukiTravelLevelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.tanukiTravelLevelDataList_.get(i));
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isContentClosed_);
            }
            if (this.finishedLevelIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.finishedLevelIndex_);
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
            if (!(obj instanceof TanukiTravelActivityDetailInfo)) {
                return equals(obj);
            }
            TanukiTravelActivityDetailInfo other = (TanukiTravelActivityDetailInfo) obj;
            return getTanukiTravelLevelDataListList().equals(other.getTanukiTravelLevelDataListList()) && getIsContentClosed() == other.getIsContentClosed() && getFinishedLevelIndex() == other.getFinishedLevelIndex() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTanukiTravelLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getTanukiTravelLevelDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + Internal.hashBoolean(getIsContentClosed()))) + 15)) + getFinishedLevelIndex())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TanukiTravelActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (TanukiTravelActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TanukiTravelActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TanukiTravelActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (TanukiTravelActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TanukiTravelActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TanukiTravelActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TanukiTravelActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TanukiTravelActivityDetailInfoOuterClass$TanukiTravelActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TanukiTravelActivityDetailInfoOrBuilder {
            private int bitField0_;
            private List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> tanukiTravelLevelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder, TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> tanukiTravelLevelDataListBuilder_;
            private boolean isContentClosed_;
            private int finishedLevelIndex_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TanukiTravelActivityDetailInfoOuterClass.internal_static_TanukiTravelActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TanukiTravelActivityDetailInfoOuterClass.f886x403cbda3.ensureFieldAccessorsInitialized(TanukiTravelActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TanukiTravelActivityDetailInfo.alwaysUseFieldBuilders) {
                    getTanukiTravelLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    this.tanukiTravelLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.tanukiTravelLevelDataListBuilder_.clear();
                }
                this.isContentClosed_ = false;
                this.finishedLevelIndex_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TanukiTravelActivityDetailInfoOuterClass.internal_static_TanukiTravelActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TanukiTravelActivityDetailInfo getDefaultInstanceForType() {
                return TanukiTravelActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelActivityDetailInfo build() {
                TanukiTravelActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TanukiTravelActivityDetailInfo buildPartial() {
                TanukiTravelActivityDetailInfo result = new TanukiTravelActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.tanukiTravelLevelDataList_ = Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.tanukiTravelLevelDataList_ = this.tanukiTravelLevelDataList_;
                } else {
                    result.tanukiTravelLevelDataList_ = this.tanukiTravelLevelDataListBuilder_.build();
                }
                result.isContentClosed_ = this.isContentClosed_;
                result.finishedLevelIndex_ = this.finishedLevelIndex_;
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
                if (other instanceof TanukiTravelActivityDetailInfo) {
                    return mergeFrom((TanukiTravelActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TanukiTravelActivityDetailInfo other) {
                if (other == TanukiTravelActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    if (!other.tanukiTravelLevelDataList_.isEmpty()) {
                        if (this.tanukiTravelLevelDataList_.isEmpty()) {
                            this.tanukiTravelLevelDataList_ = other.tanukiTravelLevelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTanukiTravelLevelDataListIsMutable();
                            this.tanukiTravelLevelDataList_.addAll(other.tanukiTravelLevelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.tanukiTravelLevelDataList_.isEmpty()) {
                    if (this.tanukiTravelLevelDataListBuilder_.isEmpty()) {
                        this.tanukiTravelLevelDataListBuilder_.dispose();
                        this.tanukiTravelLevelDataListBuilder_ = null;
                        this.tanukiTravelLevelDataList_ = other.tanukiTravelLevelDataList_;
                        this.bitField0_ &= -2;
                        this.tanukiTravelLevelDataListBuilder_ = TanukiTravelActivityDetailInfo.alwaysUseFieldBuilders ? getTanukiTravelLevelDataListFieldBuilder() : null;
                    } else {
                        this.tanukiTravelLevelDataListBuilder_.addAllMessages(other.tanukiTravelLevelDataList_);
                    }
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getFinishedLevelIndex() != 0) {
                    setFinishedLevelIndex(other.getFinishedLevelIndex());
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
                TanukiTravelActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TanukiTravelActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TanukiTravelActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTanukiTravelLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.tanukiTravelLevelDataList_ = new ArrayList(this.tanukiTravelLevelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
            public List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> getTanukiTravelLevelDataListList() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
                }
                return this.tanukiTravelLevelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
            public int getTanukiTravelLevelDataListCount() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return this.tanukiTravelLevelDataList_.size();
                }
                return this.tanukiTravelLevelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData getTanukiTravelLevelDataList(int index) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return this.tanukiTravelLevelDataList_.get(index);
                }
                return this.tanukiTravelLevelDataListBuilder_.getMessage(index);
            }

            public Builder setTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData value) {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    this.tanukiTravelLevelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder builderForValue) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData value) {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData value) {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder builderForValue) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTanukiTravelLevelDataList(int index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder builderForValue) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTanukiTravelLevelDataList(Iterable<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelData> values) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tanukiTravelLevelDataList_);
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTanukiTravelLevelDataList() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    this.tanukiTravelLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTanukiTravelLevelDataList(int index) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    ensureTanukiTravelLevelDataListIsMutable();
                    this.tanukiTravelLevelDataList_.remove(index);
                    onChanged();
                } else {
                    this.tanukiTravelLevelDataListBuilder_.remove(index);
                }
                return this;
            }

            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder getTanukiTravelLevelDataListBuilder(int index) {
                return getTanukiTravelLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder getTanukiTravelLevelDataListOrBuilder(int index) {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    return this.tanukiTravelLevelDataList_.get(index);
                }
                return this.tanukiTravelLevelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
            public List<? extends TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListOrBuilderList() {
                if (this.tanukiTravelLevelDataListBuilder_ != null) {
                    return this.tanukiTravelLevelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.tanukiTravelLevelDataList_);
            }

            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder addTanukiTravelLevelDataListBuilder() {
                return getTanukiTravelLevelDataListFieldBuilder().addBuilder(TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.getDefaultInstance());
            }

            public TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder addTanukiTravelLevelDataListBuilder(int index) {
                return getTanukiTravelLevelDataListFieldBuilder().addBuilder(index, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.getDefaultInstance());
            }

            public List<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder> getTanukiTravelLevelDataListBuilderList() {
                return getTanukiTravelLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TanukiTravelLevelDataOuterClass.TanukiTravelLevelData, TanukiTravelLevelDataOuterClass.TanukiTravelLevelData.Builder, TanukiTravelLevelDataOuterClass.TanukiTravelLevelDataOrBuilder> getTanukiTravelLevelDataListFieldBuilder() {
                if (this.tanukiTravelLevelDataListBuilder_ == null) {
                    this.tanukiTravelLevelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.tanukiTravelLevelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.tanukiTravelLevelDataList_ = null;
                }
                return this.tanukiTravelLevelDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder
            public int getFinishedLevelIndex() {
                return this.finishedLevelIndex_;
            }

            public Builder setFinishedLevelIndex(int value) {
                this.finishedLevelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinishedLevelIndex() {
                this.finishedLevelIndex_ = 0;
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

        public static TanukiTravelActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TanukiTravelActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TanukiTravelActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TanukiTravelActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TanukiTravelLevelDataOuterClass.getDescriptor();
    }
}
