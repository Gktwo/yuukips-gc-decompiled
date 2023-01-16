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
import emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectDetailInfoOuterClass.class */
public final class CoinCollectDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bCoinCollectDetailInfo.proto\u001a\u001aCoinCollectLevelData.proto\"G\n\u0015CoinCollectDetailInfo\u0012.\n\u000flevel_data_list\u0018\u0002 \u0003(\u000b2\u0015.CoinCollectLevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CoinCollectLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CoinCollectDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CoinCollectDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CoinCollectDetailInfo_descriptor, new String[]{"LevelDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectDetailInfoOuterClass$CoinCollectDetailInfoOrBuilder.class */
    public interface CoinCollectDetailInfoOrBuilder extends MessageOrBuilder {
        List<CoinCollectLevelDataOuterClass.CoinCollectLevelData> getLevelDataListList();

        CoinCollectLevelDataOuterClass.CoinCollectLevelData getLevelDataList(int i);

        int getLevelDataListCount();

        List<? extends CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder> getLevelDataListOrBuilderList();

        CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder getLevelDataListOrBuilder(int i);
    }

    private CoinCollectDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectDetailInfoOuterClass$CoinCollectDetailInfo.class */
    public static final class CoinCollectDetailInfo extends GeneratedMessageV3 implements CoinCollectDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_DATA_LIST_FIELD_NUMBER = 2;
        private List<CoinCollectLevelDataOuterClass.CoinCollectLevelData> levelDataList_;
        private byte memoizedIsInitialized;
        private static final CoinCollectDetailInfo DEFAULT_INSTANCE = new CoinCollectDetailInfo();
        private static final Parser<CoinCollectDetailInfo> PARSER = new AbstractParser<CoinCollectDetailInfo>() { // from class: emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.1
            @Override // com.google.protobuf.Parser
            public CoinCollectDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CoinCollectDetailInfo(input, extensionRegistry);
            }
        };

        private CoinCollectDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CoinCollectDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.levelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CoinCollectDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CoinCollectDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.levelDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.levelDataList_.add((CoinCollectLevelDataOuterClass.CoinCollectLevelData) input.readMessage(CoinCollectLevelDataOuterClass.CoinCollectLevelData.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.levelDataList_ = Collections.unmodifiableList(this.levelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CoinCollectDetailInfoOuterClass.internal_static_CoinCollectDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CoinCollectDetailInfoOuterClass.internal_static_CoinCollectDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
        public List<CoinCollectLevelDataOuterClass.CoinCollectLevelData> getLevelDataListList() {
            return this.levelDataList_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
        public List<? extends CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder> getLevelDataListOrBuilderList() {
            return this.levelDataList_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
        public int getLevelDataListCount() {
            return this.levelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
        public CoinCollectLevelDataOuterClass.CoinCollectLevelData getLevelDataList(int index) {
            return this.levelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
        public CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder getLevelDataListOrBuilder(int index) {
            return this.levelDataList_.get(index);
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
            for (int i = 0; i < this.levelDataList_.size(); i++) {
                output.writeMessage(2, this.levelDataList_.get(i));
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
            for (int i = 0; i < this.levelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.levelDataList_.get(i));
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
            if (!(obj instanceof CoinCollectDetailInfo)) {
                return equals(obj);
            }
            CoinCollectDetailInfo other = (CoinCollectDetailInfo) obj;
            return getLevelDataListList().equals(other.getLevelDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getLevelDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CoinCollectDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectDetailInfo parseFrom(InputStream input) throws IOException {
            return (CoinCollectDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CoinCollectDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CoinCollectDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (CoinCollectDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CoinCollectDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectDetailInfoOuterClass$CoinCollectDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CoinCollectDetailInfoOrBuilder {
            private int bitField0_;
            private List<CoinCollectLevelDataOuterClass.CoinCollectLevelData> levelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CoinCollectLevelDataOuterClass.CoinCollectLevelData, CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder, CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder> levelDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CoinCollectDetailInfoOuterClass.internal_static_CoinCollectDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CoinCollectDetailInfoOuterClass.internal_static_CoinCollectDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CoinCollectDetailInfo.alwaysUseFieldBuilders) {
                    getLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.levelDataListBuilder_ == null) {
                    this.levelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.levelDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CoinCollectDetailInfoOuterClass.internal_static_CoinCollectDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CoinCollectDetailInfo getDefaultInstanceForType() {
                return CoinCollectDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectDetailInfo build() {
                CoinCollectDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectDetailInfo buildPartial() {
                CoinCollectDetailInfo result = new CoinCollectDetailInfo(this);
                int i = this.bitField0_;
                if (this.levelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.levelDataList_ = Collections.unmodifiableList(this.levelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.levelDataList_ = this.levelDataList_;
                } else {
                    result.levelDataList_ = this.levelDataListBuilder_.build();
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
                if (other instanceof CoinCollectDetailInfo) {
                    return mergeFrom((CoinCollectDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CoinCollectDetailInfo other) {
                if (other == CoinCollectDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.levelDataListBuilder_ == null) {
                    if (!other.levelDataList_.isEmpty()) {
                        if (this.levelDataList_.isEmpty()) {
                            this.levelDataList_ = other.levelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLevelDataListIsMutable();
                            this.levelDataList_.addAll(other.levelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.levelDataList_.isEmpty()) {
                    if (this.levelDataListBuilder_.isEmpty()) {
                        this.levelDataListBuilder_.dispose();
                        this.levelDataListBuilder_ = null;
                        this.levelDataList_ = other.levelDataList_;
                        this.bitField0_ &= -2;
                        this.levelDataListBuilder_ = CoinCollectDetailInfo.alwaysUseFieldBuilders ? getLevelDataListFieldBuilder() : null;
                    } else {
                        this.levelDataListBuilder_.addAllMessages(other.levelDataList_);
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
                CoinCollectDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CoinCollectDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CoinCollectDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.levelDataList_ = new ArrayList(this.levelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
            public List<CoinCollectLevelDataOuterClass.CoinCollectLevelData> getLevelDataListList() {
                if (this.levelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelDataList_);
                }
                return this.levelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
            public int getLevelDataListCount() {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.size();
                }
                return this.levelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
            public CoinCollectLevelDataOuterClass.CoinCollectLevelData getLevelDataList(int index) {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.get(index);
                }
                return this.levelDataListBuilder_.getMessage(index);
            }

            public Builder setLevelDataList(int index, CoinCollectLevelDataOuterClass.CoinCollectLevelData value) {
                if (this.levelDataListBuilder_ != null) {
                    this.levelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLevelDataList(int index, CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelDataList(CoinCollectLevelDataOuterClass.CoinCollectLevelData value) {
                if (this.levelDataListBuilder_ != null) {
                    this.levelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelDataList(int index, CoinCollectLevelDataOuterClass.CoinCollectLevelData value) {
                if (this.levelDataListBuilder_ != null) {
                    this.levelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelDataList(CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelDataList(int index, CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder builderForValue) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelDataList(Iterable<? extends CoinCollectLevelDataOuterClass.CoinCollectLevelData> values) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelDataList_);
                    onChanged();
                } else {
                    this.levelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLevelDataList() {
                if (this.levelDataListBuilder_ == null) {
                    this.levelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.levelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeLevelDataList(int index) {
                if (this.levelDataListBuilder_ == null) {
                    ensureLevelDataListIsMutable();
                    this.levelDataList_.remove(index);
                    onChanged();
                } else {
                    this.levelDataListBuilder_.remove(index);
                }
                return this;
            }

            public CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder getLevelDataListBuilder(int index) {
                return getLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
            public CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder getLevelDataListOrBuilder(int index) {
                if (this.levelDataListBuilder_ == null) {
                    return this.levelDataList_.get(index);
                }
                return this.levelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder
            public List<? extends CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder> getLevelDataListOrBuilderList() {
                if (this.levelDataListBuilder_ != null) {
                    return this.levelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelDataList_);
            }

            public CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder addLevelDataListBuilder() {
                return getLevelDataListFieldBuilder().addBuilder(CoinCollectLevelDataOuterClass.CoinCollectLevelData.getDefaultInstance());
            }

            public CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder addLevelDataListBuilder(int index) {
                return getLevelDataListFieldBuilder().addBuilder(index, CoinCollectLevelDataOuterClass.CoinCollectLevelData.getDefaultInstance());
            }

            public List<CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder> getLevelDataListBuilderList() {
                return getLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CoinCollectLevelDataOuterClass.CoinCollectLevelData, CoinCollectLevelDataOuterClass.CoinCollectLevelData.Builder, CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder> getLevelDataListFieldBuilder() {
                if (this.levelDataListBuilder_ == null) {
                    this.levelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.levelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.levelDataList_ = null;
                }
                return this.levelDataListBuilder_;
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

        public static CoinCollectDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CoinCollectDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CoinCollectDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CoinCollectDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CoinCollectLevelDataOuterClass.getDescriptor();
    }
}
