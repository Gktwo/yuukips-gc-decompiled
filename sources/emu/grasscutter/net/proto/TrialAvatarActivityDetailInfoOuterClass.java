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
import emu.grasscutter.net.proto.TrialAvatarActivityRewardDetailInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityDetailInfoOuterClass.class */
public final class TrialAvatarActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#TrialAvatarActivityDetailInfo.proto\u001a)TrialAvatarActivityRewardDetailInfo.proto\"_\n\u001dTrialAvatarActivityDetailInfo\u0012>\n\u0010reward_info_list\u0018\u000b \u0003(\u000b2$.TrialAvatarActivityRewardDetailInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TrialAvatarActivityRewardDetailInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TrialAvatarActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TrialAvatarActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TrialAvatarActivityDetailInfo_descriptor, new String[]{"RewardInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityDetailInfoOuterClass$TrialAvatarActivityDetailInfoOrBuilder.class */
    public interface TrialAvatarActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo> getRewardInfoListList();

        TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo getRewardInfoList(int i);

        int getRewardInfoListCount();

        List<? extends TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder> getRewardInfoListOrBuilderList();

        TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder getRewardInfoListOrBuilder(int i);
    }

    private TrialAvatarActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityDetailInfoOuterClass$TrialAvatarActivityDetailInfo.class */
    public static final class TrialAvatarActivityDetailInfo extends GeneratedMessageV3 implements TrialAvatarActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REWARD_INFO_LIST_FIELD_NUMBER = 11;
        private List<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo> rewardInfoList_;
        private byte memoizedIsInitialized;
        private static final TrialAvatarActivityDetailInfo DEFAULT_INSTANCE = new TrialAvatarActivityDetailInfo();
        private static final Parser<TrialAvatarActivityDetailInfo> PARSER = new AbstractParser<TrialAvatarActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public TrialAvatarActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TrialAvatarActivityDetailInfo(input, extensionRegistry);
            }
        };

        private TrialAvatarActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TrialAvatarActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.rewardInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TrialAvatarActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrialAvatarActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 90:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.rewardInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.rewardInfoList_.add((TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo) input.readMessage(TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.parser(), extensionRegistry));
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
                    this.rewardInfoList_ = Collections.unmodifiableList(this.rewardInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TrialAvatarActivityDetailInfoOuterClass.internal_static_TrialAvatarActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TrialAvatarActivityDetailInfoOuterClass.internal_static_TrialAvatarActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TrialAvatarActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
        public List<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo> getRewardInfoListList() {
            return this.rewardInfoList_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
        public List<? extends TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder> getRewardInfoListOrBuilderList() {
            return this.rewardInfoList_;
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
        public int getRewardInfoListCount() {
            return this.rewardInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
        public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo getRewardInfoList(int index) {
            return this.rewardInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
        public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder getRewardInfoListOrBuilder(int index) {
            return this.rewardInfoList_.get(index);
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
            for (int i = 0; i < this.rewardInfoList_.size(); i++) {
                output.writeMessage(11, this.rewardInfoList_.get(i));
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
            for (int i = 0; i < this.rewardInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.rewardInfoList_.get(i));
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
            if (!(obj instanceof TrialAvatarActivityDetailInfo)) {
                return equals(obj);
            }
            TrialAvatarActivityDetailInfo other = (TrialAvatarActivityDetailInfo) obj;
            return getRewardInfoListList().equals(other.getRewardInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRewardInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getRewardInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TrialAvatarActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (TrialAvatarActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TrialAvatarActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TrialAvatarActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (TrialAvatarActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrialAvatarActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrialAvatarActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrialAvatarActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrialAvatarActivityDetailInfoOuterClass$TrialAvatarActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrialAvatarActivityDetailInfoOrBuilder {
            private int bitField0_;
            private List<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo> rewardInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder> rewardInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TrialAvatarActivityDetailInfoOuterClass.internal_static_TrialAvatarActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TrialAvatarActivityDetailInfoOuterClass.internal_static_TrialAvatarActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TrialAvatarActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrialAvatarActivityDetailInfo.alwaysUseFieldBuilders) {
                    getRewardInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.rewardInfoListBuilder_ == null) {
                    this.rewardInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.rewardInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TrialAvatarActivityDetailInfoOuterClass.internal_static_TrialAvatarActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrialAvatarActivityDetailInfo getDefaultInstanceForType() {
                return TrialAvatarActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarActivityDetailInfo build() {
                TrialAvatarActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrialAvatarActivityDetailInfo buildPartial() {
                TrialAvatarActivityDetailInfo result = new TrialAvatarActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.rewardInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.rewardInfoList_ = Collections.unmodifiableList(this.rewardInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.rewardInfoList_ = this.rewardInfoList_;
                } else {
                    result.rewardInfoList_ = this.rewardInfoListBuilder_.build();
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
                if (other instanceof TrialAvatarActivityDetailInfo) {
                    return mergeFrom((TrialAvatarActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TrialAvatarActivityDetailInfo other) {
                if (other == TrialAvatarActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.rewardInfoListBuilder_ == null) {
                    if (!other.rewardInfoList_.isEmpty()) {
                        if (this.rewardInfoList_.isEmpty()) {
                            this.rewardInfoList_ = other.rewardInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRewardInfoListIsMutable();
                            this.rewardInfoList_.addAll(other.rewardInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.rewardInfoList_.isEmpty()) {
                    if (this.rewardInfoListBuilder_.isEmpty()) {
                        this.rewardInfoListBuilder_.dispose();
                        this.rewardInfoListBuilder_ = null;
                        this.rewardInfoList_ = other.rewardInfoList_;
                        this.bitField0_ &= -2;
                        this.rewardInfoListBuilder_ = TrialAvatarActivityDetailInfo.alwaysUseFieldBuilders ? getRewardInfoListFieldBuilder() : null;
                    } else {
                        this.rewardInfoListBuilder_.addAllMessages(other.rewardInfoList_);
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
                TrialAvatarActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TrialAvatarActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TrialAvatarActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRewardInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.rewardInfoList_ = new ArrayList(this.rewardInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
            public List<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo> getRewardInfoListList() {
                if (this.rewardInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.rewardInfoList_);
                }
                return this.rewardInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
            public int getRewardInfoListCount() {
                if (this.rewardInfoListBuilder_ == null) {
                    return this.rewardInfoList_.size();
                }
                return this.rewardInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
            public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo getRewardInfoList(int index) {
                if (this.rewardInfoListBuilder_ == null) {
                    return this.rewardInfoList_.get(index);
                }
                return this.rewardInfoListBuilder_.getMessage(index);
            }

            public Builder setRewardInfoList(int index, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo value) {
                if (this.rewardInfoListBuilder_ != null) {
                    this.rewardInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRewardInfoList(int index, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder builderForValue) {
                if (this.rewardInfoListBuilder_ == null) {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRewardInfoList(TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo value) {
                if (this.rewardInfoListBuilder_ != null) {
                    this.rewardInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRewardInfoList(int index, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo value) {
                if (this.rewardInfoListBuilder_ != null) {
                    this.rewardInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRewardInfoList(TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder builderForValue) {
                if (this.rewardInfoListBuilder_ == null) {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.rewardInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRewardInfoList(int index, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder builderForValue) {
                if (this.rewardInfoListBuilder_ == null) {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRewardInfoList(Iterable<? extends TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo> values) {
                if (this.rewardInfoListBuilder_ == null) {
                    ensureRewardInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.rewardInfoList_);
                    onChanged();
                } else {
                    this.rewardInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRewardInfoList() {
                if (this.rewardInfoListBuilder_ == null) {
                    this.rewardInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.rewardInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRewardInfoList(int index) {
                if (this.rewardInfoListBuilder_ == null) {
                    ensureRewardInfoListIsMutable();
                    this.rewardInfoList_.remove(index);
                    onChanged();
                } else {
                    this.rewardInfoListBuilder_.remove(index);
                }
                return this;
            }

            public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder getRewardInfoListBuilder(int index) {
                return getRewardInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
            public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder getRewardInfoListOrBuilder(int index) {
                if (this.rewardInfoListBuilder_ == null) {
                    return this.rewardInfoList_.get(index);
                }
                return this.rewardInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder
            public List<? extends TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder> getRewardInfoListOrBuilderList() {
                if (this.rewardInfoListBuilder_ != null) {
                    return this.rewardInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.rewardInfoList_);
            }

            public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder addRewardInfoListBuilder() {
                return getRewardInfoListFieldBuilder().addBuilder(TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.getDefaultInstance());
            }

            public TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder addRewardInfoListBuilder(int index) {
                return getRewardInfoListFieldBuilder().addBuilder(index, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.getDefaultInstance());
            }

            public List<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder> getRewardInfoListBuilderList() {
                return getRewardInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfo.Builder, TrialAvatarActivityRewardDetailInfoOuterClass.TrialAvatarActivityRewardDetailInfoOrBuilder> getRewardInfoListFieldBuilder() {
                if (this.rewardInfoListBuilder_ == null) {
                    this.rewardInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.rewardInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.rewardInfoList_ = null;
                }
                return this.rewardInfoListBuilder_;
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

        public static TrialAvatarActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrialAvatarActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrialAvatarActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrialAvatarActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TrialAvatarActivityRewardDetailInfoOuterClass.getDescriptor();
    }
}
