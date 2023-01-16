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
import emu.grasscutter.net.proto.InferencePageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestInferenceDataNotifyOuterClass.class */
public final class ParentQuestInferenceDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$ParentQuestInferenceDataNotify.proto\u001a\u0017InferencePageInfo.proto\"j\n\u001eParentQuestInferenceDataNotify\u0012\u0017\n\u000fparent_quest_id\u0018\b \u0001(\r\u0012/\n\u0013inference_page_list\u0018\u000e \u0003(\u000b2\u0012.InferencePageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InferencePageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ParentQuestInferenceDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_ParentQuestInferenceDataNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f822xabec9989 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ParentQuestInferenceDataNotify_descriptor, new String[]{"ParentQuestId", "InferencePageList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestInferenceDataNotifyOuterClass$ParentQuestInferenceDataNotifyOrBuilder.class */
    public interface ParentQuestInferenceDataNotifyOrBuilder extends MessageOrBuilder {
        int getParentQuestId();

        List<InferencePageInfoOuterClass.InferencePageInfo> getInferencePageListList();

        InferencePageInfoOuterClass.InferencePageInfo getInferencePageList(int i);

        int getInferencePageListCount();

        List<? extends InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListOrBuilderList();

        InferencePageInfoOuterClass.InferencePageInfoOrBuilder getInferencePageListOrBuilder(int i);
    }

    private ParentQuestInferenceDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestInferenceDataNotifyOuterClass$ParentQuestInferenceDataNotify.class */
    public static final class ParentQuestInferenceDataNotify extends GeneratedMessageV3 implements ParentQuestInferenceDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENT_QUEST_ID_FIELD_NUMBER = 8;
        private int parentQuestId_;
        public static final int INFERENCE_PAGE_LIST_FIELD_NUMBER = 14;
        private List<InferencePageInfoOuterClass.InferencePageInfo> inferencePageList_;
        private byte memoizedIsInitialized;
        private static final ParentQuestInferenceDataNotify DEFAULT_INSTANCE = new ParentQuestInferenceDataNotify();
        private static final Parser<ParentQuestInferenceDataNotify> PARSER = new AbstractParser<ParentQuestInferenceDataNotify>() { // from class: emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotify.1
            @Override // com.google.protobuf.Parser
            public ParentQuestInferenceDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ParentQuestInferenceDataNotify(input, extensionRegistry);
            }
        };

        private ParentQuestInferenceDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ParentQuestInferenceDataNotify() {
            this.memoizedIsInitialized = -1;
            this.inferencePageList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ParentQuestInferenceDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ParentQuestInferenceDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.parentQuestId_ = input.readUInt32();
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.inferencePageList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.inferencePageList_.add((InferencePageInfoOuterClass.InferencePageInfo) input.readMessage(InferencePageInfoOuterClass.InferencePageInfo.parser(), extensionRegistry));
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
                    this.inferencePageList_ = Collections.unmodifiableList(this.inferencePageList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ParentQuestInferenceDataNotifyOuterClass.internal_static_ParentQuestInferenceDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ParentQuestInferenceDataNotifyOuterClass.f822xabec9989.ensureFieldAccessorsInitialized(ParentQuestInferenceDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
        public List<InferencePageInfoOuterClass.InferencePageInfo> getInferencePageListList() {
            return this.inferencePageList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
        public List<? extends InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListOrBuilderList() {
            return this.inferencePageList_;
        }

        @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
        public int getInferencePageListCount() {
            return this.inferencePageList_.size();
        }

        @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
        public InferencePageInfoOuterClass.InferencePageInfo getInferencePageList(int index) {
            return this.inferencePageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
        public InferencePageInfoOuterClass.InferencePageInfoOrBuilder getInferencePageListOrBuilder(int index) {
            return this.inferencePageList_.get(index);
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
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(8, this.parentQuestId_);
            }
            for (int i = 0; i < this.inferencePageList_.size(); i++) {
                output.writeMessage(14, this.inferencePageList_.get(i));
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
            if (this.parentQuestId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.parentQuestId_);
            }
            for (int i = 0; i < this.inferencePageList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.inferencePageList_.get(i));
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
            if (!(obj instanceof ParentQuestInferenceDataNotify)) {
                return equals(obj);
            }
            ParentQuestInferenceDataNotify other = (ParentQuestInferenceDataNotify) obj;
            return getParentQuestId() == other.getParentQuestId() && getInferencePageListList().equals(other.getInferencePageListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getParentQuestId();
            if (getInferencePageListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getInferencePageListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ParentQuestInferenceDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuestInferenceDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuestInferenceDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuestInferenceDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuestInferenceDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ParentQuestInferenceDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ParentQuestInferenceDataNotify parseFrom(InputStream input) throws IOException {
            return (ParentQuestInferenceDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParentQuestInferenceDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuestInferenceDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParentQuestInferenceDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ParentQuestInferenceDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ParentQuestInferenceDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuestInferenceDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ParentQuestInferenceDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (ParentQuestInferenceDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ParentQuestInferenceDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ParentQuestInferenceDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ParentQuestInferenceDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ParentQuestInferenceDataNotifyOuterClass$ParentQuestInferenceDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ParentQuestInferenceDataNotifyOrBuilder {
            private int bitField0_;
            private int parentQuestId_;
            private List<InferencePageInfoOuterClass.InferencePageInfo> inferencePageList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<InferencePageInfoOuterClass.InferencePageInfo, InferencePageInfoOuterClass.InferencePageInfo.Builder, InferencePageInfoOuterClass.InferencePageInfoOrBuilder> inferencePageListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ParentQuestInferenceDataNotifyOuterClass.internal_static_ParentQuestInferenceDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ParentQuestInferenceDataNotifyOuterClass.f822xabec9989.ensureFieldAccessorsInitialized(ParentQuestInferenceDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ParentQuestInferenceDataNotify.alwaysUseFieldBuilders) {
                    getInferencePageListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentQuestId_ = 0;
                if (this.inferencePageListBuilder_ == null) {
                    this.inferencePageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.inferencePageListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ParentQuestInferenceDataNotifyOuterClass.internal_static_ParentQuestInferenceDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ParentQuestInferenceDataNotify getDefaultInstanceForType() {
                return ParentQuestInferenceDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParentQuestInferenceDataNotify build() {
                ParentQuestInferenceDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ParentQuestInferenceDataNotify buildPartial() {
                ParentQuestInferenceDataNotify result = new ParentQuestInferenceDataNotify(this);
                int i = this.bitField0_;
                result.parentQuestId_ = this.parentQuestId_;
                if (this.inferencePageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.inferencePageList_ = Collections.unmodifiableList(this.inferencePageList_);
                        this.bitField0_ &= -2;
                    }
                    result.inferencePageList_ = this.inferencePageList_;
                } else {
                    result.inferencePageList_ = this.inferencePageListBuilder_.build();
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
                if (other instanceof ParentQuestInferenceDataNotify) {
                    return mergeFrom((ParentQuestInferenceDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ParentQuestInferenceDataNotify other) {
                if (other == ParentQuestInferenceDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (this.inferencePageListBuilder_ == null) {
                    if (!other.inferencePageList_.isEmpty()) {
                        if (this.inferencePageList_.isEmpty()) {
                            this.inferencePageList_ = other.inferencePageList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInferencePageListIsMutable();
                            this.inferencePageList_.addAll(other.inferencePageList_);
                        }
                        onChanged();
                    }
                } else if (!other.inferencePageList_.isEmpty()) {
                    if (this.inferencePageListBuilder_.isEmpty()) {
                        this.inferencePageListBuilder_.dispose();
                        this.inferencePageListBuilder_ = null;
                        this.inferencePageList_ = other.inferencePageList_;
                        this.bitField0_ &= -2;
                        this.inferencePageListBuilder_ = ParentQuestInferenceDataNotify.alwaysUseFieldBuilders ? getInferencePageListFieldBuilder() : null;
                    } else {
                        this.inferencePageListBuilder_.addAllMessages(other.inferencePageList_);
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
                ParentQuestInferenceDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ParentQuestInferenceDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ParentQuestInferenceDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
            public int getParentQuestId() {
                return this.parentQuestId_;
            }

            public Builder setParentQuestId(int value) {
                this.parentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestId() {
                this.parentQuestId_ = 0;
                onChanged();
                return this;
            }

            private void ensureInferencePageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.inferencePageList_ = new ArrayList(this.inferencePageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
            public List<InferencePageInfoOuterClass.InferencePageInfo> getInferencePageListList() {
                if (this.inferencePageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.inferencePageList_);
                }
                return this.inferencePageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
            public int getInferencePageListCount() {
                if (this.inferencePageListBuilder_ == null) {
                    return this.inferencePageList_.size();
                }
                return this.inferencePageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
            public InferencePageInfoOuterClass.InferencePageInfo getInferencePageList(int index) {
                if (this.inferencePageListBuilder_ == null) {
                    return this.inferencePageList_.get(index);
                }
                return this.inferencePageListBuilder_.getMessage(index);
            }

            public Builder setInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo value) {
                if (this.inferencePageListBuilder_ != null) {
                    this.inferencePageListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo.Builder builderForValue) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInferencePageList(InferencePageInfoOuterClass.InferencePageInfo value) {
                if (this.inferencePageListBuilder_ != null) {
                    this.inferencePageListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo value) {
                if (this.inferencePageListBuilder_ != null) {
                    this.inferencePageListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInferencePageList(InferencePageInfoOuterClass.InferencePageInfo.Builder builderForValue) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInferencePageList(int index, InferencePageInfoOuterClass.InferencePageInfo.Builder builderForValue) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInferencePageList(Iterable<? extends InferencePageInfoOuterClass.InferencePageInfo> values) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.inferencePageList_);
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInferencePageList() {
                if (this.inferencePageListBuilder_ == null) {
                    this.inferencePageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInferencePageList(int index) {
                if (this.inferencePageListBuilder_ == null) {
                    ensureInferencePageListIsMutable();
                    this.inferencePageList_.remove(index);
                    onChanged();
                } else {
                    this.inferencePageListBuilder_.remove(index);
                }
                return this;
            }

            public InferencePageInfoOuterClass.InferencePageInfo.Builder getInferencePageListBuilder(int index) {
                return getInferencePageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
            public InferencePageInfoOuterClass.InferencePageInfoOrBuilder getInferencePageListOrBuilder(int index) {
                if (this.inferencePageListBuilder_ == null) {
                    return this.inferencePageList_.get(index);
                }
                return this.inferencePageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ParentQuestInferenceDataNotifyOuterClass.ParentQuestInferenceDataNotifyOrBuilder
            public List<? extends InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListOrBuilderList() {
                if (this.inferencePageListBuilder_ != null) {
                    return this.inferencePageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.inferencePageList_);
            }

            public InferencePageInfoOuterClass.InferencePageInfo.Builder addInferencePageListBuilder() {
                return getInferencePageListFieldBuilder().addBuilder(InferencePageInfoOuterClass.InferencePageInfo.getDefaultInstance());
            }

            public InferencePageInfoOuterClass.InferencePageInfo.Builder addInferencePageListBuilder(int index) {
                return getInferencePageListFieldBuilder().addBuilder(index, InferencePageInfoOuterClass.InferencePageInfo.getDefaultInstance());
            }

            public List<InferencePageInfoOuterClass.InferencePageInfo.Builder> getInferencePageListBuilderList() {
                return getInferencePageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<InferencePageInfoOuterClass.InferencePageInfo, InferencePageInfoOuterClass.InferencePageInfo.Builder, InferencePageInfoOuterClass.InferencePageInfoOrBuilder> getInferencePageListFieldBuilder() {
                if (this.inferencePageListBuilder_ == null) {
                    this.inferencePageListBuilder_ = new RepeatedFieldBuilderV3<>(this.inferencePageList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.inferencePageList_ = null;
                }
                return this.inferencePageListBuilder_;
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

        public static ParentQuestInferenceDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ParentQuestInferenceDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ParentQuestInferenceDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ParentQuestInferenceDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InferencePageInfoOuterClass.getDescriptor();
    }
}
