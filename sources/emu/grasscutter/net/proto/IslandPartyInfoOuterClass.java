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
import emu.grasscutter.net.proto.IslandPartyStageDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IslandPartyInfoOuterClass.class */
public final class IslandPartyInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015IslandPartyInfo.proto\u001a\u001aIslandPartyStageData.proto\"?\n\u000fIslandPartyInfo\u0012,\n\rstageDataList\u0018\u0005 \u0003(\u000b2\u0015.IslandPartyStageDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IslandPartyStageDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IslandPartyInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IslandPartyInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IslandPartyInfo_descriptor, new String[]{"StageDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IslandPartyInfoOuterClass$IslandPartyInfoOrBuilder.class */
    public interface IslandPartyInfoOrBuilder extends MessageOrBuilder {
        List<IslandPartyStageDataOuterClass.IslandPartyStageData> getStageDataListList();

        IslandPartyStageDataOuterClass.IslandPartyStageData getStageDataList(int i);

        int getStageDataListCount();

        List<? extends IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder> getStageDataListOrBuilderList();

        IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder getStageDataListOrBuilder(int i);
    }

    private IslandPartyInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IslandPartyInfoOuterClass$IslandPartyInfo.class */
    public static final class IslandPartyInfo extends GeneratedMessageV3 implements IslandPartyInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGEDATALIST_FIELD_NUMBER = 5;
        private List<IslandPartyStageDataOuterClass.IslandPartyStageData> stageDataList_;
        private byte memoizedIsInitialized;
        private static final IslandPartyInfo DEFAULT_INSTANCE = new IslandPartyInfo();
        private static final Parser<IslandPartyInfo> PARSER = new AbstractParser<IslandPartyInfo>() { // from class: emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfo.1
            @Override // com.google.protobuf.Parser
            public IslandPartyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IslandPartyInfo(input, extensionRegistry);
            }
        };

        private IslandPartyInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IslandPartyInfo() {
            this.memoizedIsInitialized = -1;
            this.stageDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IslandPartyInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IslandPartyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.stageDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.stageDataList_.add((IslandPartyStageDataOuterClass.IslandPartyStageData) input.readMessage(IslandPartyStageDataOuterClass.IslandPartyStageData.parser(), extensionRegistry));
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
            return IslandPartyInfoOuterClass.internal_static_IslandPartyInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IslandPartyInfoOuterClass.internal_static_IslandPartyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IslandPartyInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
        public List<IslandPartyStageDataOuterClass.IslandPartyStageData> getStageDataListList() {
            return this.stageDataList_;
        }

        @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
        public List<? extends IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder> getStageDataListOrBuilderList() {
            return this.stageDataList_;
        }

        @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
        public int getStageDataListCount() {
            return this.stageDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
        public IslandPartyStageDataOuterClass.IslandPartyStageData getStageDataList(int index) {
            return this.stageDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
        public IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder getStageDataListOrBuilder(int index) {
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
                output.writeMessage(5, this.stageDataList_.get(i));
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
                size2 += CodedOutputStream.computeMessageSize(5, this.stageDataList_.get(i));
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
            if (!(obj instanceof IslandPartyInfo)) {
                return equals(obj);
            }
            IslandPartyInfo other = (IslandPartyInfo) obj;
            return getStageDataListList().equals(other.getStageDataListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getStageDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IslandPartyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IslandPartyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IslandPartyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IslandPartyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IslandPartyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IslandPartyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IslandPartyInfo parseFrom(InputStream input) throws IOException {
            return (IslandPartyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IslandPartyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IslandPartyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IslandPartyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IslandPartyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IslandPartyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IslandPartyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IslandPartyInfo parseFrom(CodedInputStream input) throws IOException {
            return (IslandPartyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IslandPartyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IslandPartyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IslandPartyInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IslandPartyInfoOuterClass$IslandPartyInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IslandPartyInfoOrBuilder {
            private int bitField0_;
            private List<IslandPartyStageDataOuterClass.IslandPartyStageData> stageDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IslandPartyStageDataOuterClass.IslandPartyStageData, IslandPartyStageDataOuterClass.IslandPartyStageData.Builder, IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder> stageDataListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IslandPartyInfoOuterClass.internal_static_IslandPartyInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IslandPartyInfoOuterClass.internal_static_IslandPartyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IslandPartyInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IslandPartyInfo.alwaysUseFieldBuilders) {
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
                return IslandPartyInfoOuterClass.internal_static_IslandPartyInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IslandPartyInfo getDefaultInstanceForType() {
                return IslandPartyInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IslandPartyInfo build() {
                IslandPartyInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IslandPartyInfo buildPartial() {
                IslandPartyInfo result = new IslandPartyInfo(this);
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
                if (other instanceof IslandPartyInfo) {
                    return mergeFrom((IslandPartyInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IslandPartyInfo other) {
                if (other == IslandPartyInfo.getDefaultInstance()) {
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
                        this.stageDataListBuilder_ = IslandPartyInfo.alwaysUseFieldBuilders ? getStageDataListFieldBuilder() : null;
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
                IslandPartyInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IslandPartyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IslandPartyInfo) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
            public List<IslandPartyStageDataOuterClass.IslandPartyStageData> getStageDataListList() {
                if (this.stageDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageDataList_);
                }
                return this.stageDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
            public int getStageDataListCount() {
                if (this.stageDataListBuilder_ == null) {
                    return this.stageDataList_.size();
                }
                return this.stageDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
            public IslandPartyStageDataOuterClass.IslandPartyStageData getStageDataList(int index) {
                if (this.stageDataListBuilder_ == null) {
                    return this.stageDataList_.get(index);
                }
                return this.stageDataListBuilder_.getMessage(index);
            }

            public Builder setStageDataList(int index, IslandPartyStageDataOuterClass.IslandPartyStageData value) {
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

            public Builder setStageDataList(int index, IslandPartyStageDataOuterClass.IslandPartyStageData.Builder builderForValue) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageDataList(IslandPartyStageDataOuterClass.IslandPartyStageData value) {
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

            public Builder addStageDataList(int index, IslandPartyStageDataOuterClass.IslandPartyStageData value) {
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

            public Builder addStageDataList(IslandPartyStageDataOuterClass.IslandPartyStageData.Builder builderForValue) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageDataList(int index, IslandPartyStageDataOuterClass.IslandPartyStageData.Builder builderForValue) {
                if (this.stageDataListBuilder_ == null) {
                    ensureStageDataListIsMutable();
                    this.stageDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageDataList(Iterable<? extends IslandPartyStageDataOuterClass.IslandPartyStageData> values) {
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

            public IslandPartyStageDataOuterClass.IslandPartyStageData.Builder getStageDataListBuilder(int index) {
                return getStageDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
            public IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder getStageDataListOrBuilder(int index) {
                if (this.stageDataListBuilder_ == null) {
                    return this.stageDataList_.get(index);
                }
                return this.stageDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder
            public List<? extends IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder> getStageDataListOrBuilderList() {
                if (this.stageDataListBuilder_ != null) {
                    return this.stageDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageDataList_);
            }

            public IslandPartyStageDataOuterClass.IslandPartyStageData.Builder addStageDataListBuilder() {
                return getStageDataListFieldBuilder().addBuilder(IslandPartyStageDataOuterClass.IslandPartyStageData.getDefaultInstance());
            }

            public IslandPartyStageDataOuterClass.IslandPartyStageData.Builder addStageDataListBuilder(int index) {
                return getStageDataListFieldBuilder().addBuilder(index, IslandPartyStageDataOuterClass.IslandPartyStageData.getDefaultInstance());
            }

            public List<IslandPartyStageDataOuterClass.IslandPartyStageData.Builder> getStageDataListBuilderList() {
                return getStageDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IslandPartyStageDataOuterClass.IslandPartyStageData, IslandPartyStageDataOuterClass.IslandPartyStageData.Builder, IslandPartyStageDataOuterClass.IslandPartyStageDataOrBuilder> getStageDataListFieldBuilder() {
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

        public static IslandPartyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IslandPartyInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IslandPartyInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IslandPartyInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IslandPartyStageDataOuterClass.getDescriptor();
    }
}
