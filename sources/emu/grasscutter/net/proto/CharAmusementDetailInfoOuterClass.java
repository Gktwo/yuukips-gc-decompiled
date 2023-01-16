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
import emu.grasscutter.net.proto.CharAmusementStageDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementDetailInfoOuterClass.class */
public final class CharAmusementDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCharAmusementDetailInfo.proto\u001a\u001cCharAmusementStageData.proto\"K\n\u0017CharAmusementDetailInfo\u00120\n\u000fstage_data_list\u0018\f \u0003(\u000b2\u0017.CharAmusementStageDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CharAmusementStageDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CharAmusementDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CharAmusementDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CharAmusementDetailInfo_descriptor, new String[]{"StageDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementDetailInfoOuterClass$CharAmusementDetailInfoOrBuilder.class */
    public interface CharAmusementDetailInfoOrBuilder extends MessageOrBuilder {
        List<CharAmusementStageDataOuterClass.CharAmusementStageData> getStageDataListList();

        CharAmusementStageDataOuterClass.CharAmusementStageData getStageDataList(int i);

        int getStageDataListCount();

        List<? extends CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder> getStageDataListOrBuilderList();

        CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder getStageDataListOrBuilder(int i);
    }

    private CharAmusementDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementDetailInfoOuterClass$CharAmusementDetailInfo.class */
    public static final class CharAmusementDetailInfo extends GeneratedMessageV3 implements CharAmusementDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_DATA_LIST_FIELD_NUMBER = 12;
        private List<CharAmusementStageDataOuterClass.CharAmusementStageData> stageDataList_;
        private byte memoizedIsInitialized;
        private static final CharAmusementDetailInfo DEFAULT_INSTANCE = new CharAmusementDetailInfo();
        private static final Parser<CharAmusementDetailInfo> PARSER = new AbstractParser<CharAmusementDetailInfo>() { // from class: emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.1
            @Override // com.google.protobuf.Parser
            public CharAmusementDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CharAmusementDetailInfo(input, extensionRegistry);
            }
        };

        private CharAmusementDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CharAmusementDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.stageDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CharAmusementDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CharAmusementDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.stageDataList_.add((CharAmusementStageDataOuterClass.CharAmusementStageData) input.readMessage(CharAmusementStageDataOuterClass.CharAmusementStageData.parser(), extensionRegistry));
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
                    this.stageDataList_ = Collections.unmodifiableList(this.stageDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CharAmusementDetailInfoOuterClass.internal_static_CharAmusementDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CharAmusementDetailInfoOuterClass.internal_static_CharAmusementDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CharAmusementDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
        public List<CharAmusementStageDataOuterClass.CharAmusementStageData> getStageDataListList() {
            return this.stageDataList_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
        public List<? extends CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder> getStageDataListOrBuilderList() {
            return this.stageDataList_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
        public int getStageDataListCount() {
            return this.stageDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
        public CharAmusementStageDataOuterClass.CharAmusementStageData getStageDataList(int index) {
            return this.stageDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
        public CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder getStageDataListOrBuilder(int index) {
            return this.stageDataList_.get(index);
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
            for (int i = 0; i < this.stageDataList_.size(); i++) {
                output.writeMessage(12, this.stageDataList_.get(i));
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
            for (int i = 0; i < this.stageDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.stageDataList_.get(i));
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
            if (!(obj instanceof CharAmusementDetailInfo)) {
                return equals(obj);
            }
            CharAmusementDetailInfo other = (CharAmusementDetailInfo) obj;
            return getStageDataListList().equals(other.getStageDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getStageDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CharAmusementDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementDetailInfo parseFrom(InputStream input) throws IOException {
            return (CharAmusementDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CharAmusementDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CharAmusementDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CharAmusementDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CharAmusementDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CharAmusementDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (CharAmusementDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CharAmusementDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CharAmusementDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementDetailInfoOuterClass$CharAmusementDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CharAmusementDetailInfoOrBuilder {
            private int bitField0_;
            private List<CharAmusementStageDataOuterClass.CharAmusementStageData> stageDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CharAmusementStageDataOuterClass.CharAmusementStageData, CharAmusementStageDataOuterClass.CharAmusementStageData.Builder, CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder> stageDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CharAmusementDetailInfoOuterClass.internal_static_CharAmusementDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CharAmusementDetailInfoOuterClass.internal_static_CharAmusementDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CharAmusementDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CharAmusementDetailInfo.alwaysUseFieldBuilders) {
                    getStageDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.stageDataListBuilder_ == null) {
                    this.stageDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CharAmusementDetailInfoOuterClass.internal_static_CharAmusementDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CharAmusementDetailInfo getDefaultInstanceForType() {
                return CharAmusementDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CharAmusementDetailInfo build() {
                CharAmusementDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CharAmusementDetailInfo buildPartial() {
                CharAmusementDetailInfo result = new CharAmusementDetailInfo(this);
                int i = this.bitField0_;
                if (this.stageDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageDataList_ = Collections.unmodifiableList(this.stageDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageDataList_ = this.stageDataList_;
                } else {
                    result.stageDataList_ = this.stageDataListBuilder_.build();
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
                if (other instanceof CharAmusementDetailInfo) {
                    return mergeFrom((CharAmusementDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CharAmusementDetailInfo other) {
                if (other == CharAmusementDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.stageDataListBuilder_ == null) {
                    if (!other.stageDataList_.isEmpty()) {
                        if (this.stageDataList_.isEmpty()) {
                            this.stageDataList_ = other.stageDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageDataListIsMutable();
                            this.stageDataList_.addAll(other.stageDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageDataList_.isEmpty()) {
                    if (this.stageDataListBuilder_.isEmpty()) {
                        this.stageDataListBuilder_.dispose();
                        this.stageDataListBuilder_ = null;
                        this.stageDataList_ = other.stageDataList_;
                        this.bitField0_ &= -2;
                        this.stageDataListBuilder_ = CharAmusementDetailInfo.alwaysUseFieldBuilders ? getStageDataListFieldBuilder() : null;
                    } else {
                        this.stageDataListBuilder_.addAllMessages(other.stageDataList_);
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
                CharAmusementDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CharAmusementDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CharAmusementDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureStageDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageDataList_ = new ArrayList(this.stageDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
            public List<CharAmusementStageDataOuterClass.CharAmusementStageData> getStageDataListList() {
                if (this.stageDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageDataList_);
                }
                return this.stageDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
            public int getStageDataListCount() {
                if (this.stageDataListBuilder_ == null) {
                    return this.stageDataList_.size();
                }
                return this.stageDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
            public CharAmusementStageDataOuterClass.CharAmusementStageData getStageDataList(int index) {
                if (this.stageDataListBuilder_ == null) {
                    return this.stageDataList_.get(index);
                }
                return this.stageDataListBuilder_.getMessage(index);
            }

            public Builder setStageDataList(int index, CharAmusementStageDataOuterClass.CharAmusementStageData value) {
                if (this.stageDataListBuilder_ != null) {
                    this.stageDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageDataList(int index, CharAmusementStageDataOuterClass.CharAmusementStageData.Builder builderForValue) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageDataList(CharAmusementStageDataOuterClass.CharAmusementStageData value) {
                if (this.stageDataListBuilder_ != null) {
                    this.stageDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageDataList(int index, CharAmusementStageDataOuterClass.CharAmusementStageData value) {
                if (this.stageDataListBuilder_ != null) {
                    this.stageDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageDataList(CharAmusementStageDataOuterClass.CharAmusementStageData.Builder builderForValue) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageDataList(int index, CharAmusementStageDataOuterClass.CharAmusementStageData.Builder builderForValue) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageDataList(Iterable<? extends CharAmusementStageDataOuterClass.CharAmusementStageData> values) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageDataList_);
                    onChanged();
                } else {
                    this.stageDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageDataList() {
                if (this.stageDataListBuilder_ == null) {
                    this.stageDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageDataList(int index) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.remove(index);
                    onChanged();
                } else {
                    this.stageDataListBuilder_.remove(index);
                }
                return this;
            }

            public CharAmusementStageDataOuterClass.CharAmusementStageData.Builder getStageDataListBuilder(int index) {
                return getStageDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
            public CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder getStageDataListOrBuilder(int index) {
                if (this.stageDataListBuilder_ == null) {
                    return this.stageDataList_.get(index);
                }
                return this.stageDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder
            public List<? extends CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder> getStageDataListOrBuilderList() {
                if (this.stageDataListBuilder_ != null) {
                    return this.stageDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageDataList_);
            }

            public CharAmusementStageDataOuterClass.CharAmusementStageData.Builder addStageDataListBuilder() {
                return getStageDataListFieldBuilder().addBuilder(CharAmusementStageDataOuterClass.CharAmusementStageData.getDefaultInstance());
            }

            public CharAmusementStageDataOuterClass.CharAmusementStageData.Builder addStageDataListBuilder(int index) {
                return getStageDataListFieldBuilder().addBuilder(index, CharAmusementStageDataOuterClass.CharAmusementStageData.getDefaultInstance());
            }

            public List<CharAmusementStageDataOuterClass.CharAmusementStageData.Builder> getStageDataListBuilderList() {
                return getStageDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CharAmusementStageDataOuterClass.CharAmusementStageData, CharAmusementStageDataOuterClass.CharAmusementStageData.Builder, CharAmusementStageDataOuterClass.CharAmusementStageDataOrBuilder> getStageDataListFieldBuilder() {
                if (this.stageDataListBuilder_ == null) {
                    this.stageDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageDataList_ = null;
                }
                return this.stageDataListBuilder_;
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

        public static CharAmusementDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CharAmusementDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CharAmusementDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CharAmusementDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CharAmusementStageDataOuterClass.getDescriptor();
    }
}
