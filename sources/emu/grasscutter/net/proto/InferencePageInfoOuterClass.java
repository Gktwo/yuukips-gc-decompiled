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
import emu.grasscutter.net.proto.InferenceWordInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferencePageInfoOuterClass.class */
public final class InferencePageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017InferencePageInfo.proto\u001a\u0017InferenceWordInfo.proto\"O\n\u0011InferencePageInfo\u0012\u000e\n\u0006pageId\u0018\u0006 \u0001(\r\u0012*\n\u000eunlockWordList\u0018\b \u0003(\u000b2\u0012.InferenceWordInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InferenceWordInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_InferencePageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_InferencePageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_InferencePageInfo_descriptor, new String[]{"PageId", "UnlockWordList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferencePageInfoOuterClass$InferencePageInfoOrBuilder.class */
    public interface InferencePageInfoOrBuilder extends MessageOrBuilder {
        int getPageId();

        List<InferenceWordInfoOuterClass.InferenceWordInfo> getUnlockWordListList();

        InferenceWordInfoOuterClass.InferenceWordInfo getUnlockWordList(int i);

        int getUnlockWordListCount();

        List<? extends InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder> getUnlockWordListOrBuilderList();

        InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder getUnlockWordListOrBuilder(int i);
    }

    private InferencePageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferencePageInfoOuterClass$InferencePageInfo.class */
    public static final class InferencePageInfo extends GeneratedMessageV3 implements InferencePageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PAGEID_FIELD_NUMBER = 6;
        private int pageId_;
        public static final int UNLOCKWORDLIST_FIELD_NUMBER = 8;
        private List<InferenceWordInfoOuterClass.InferenceWordInfo> unlockWordList_;
        private byte memoizedIsInitialized;
        private static final InferencePageInfo DEFAULT_INSTANCE = new InferencePageInfo();
        private static final Parser<InferencePageInfo> PARSER = new AbstractParser<InferencePageInfo>() { // from class: emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfo.1
            @Override // com.google.protobuf.Parser
            public InferencePageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InferencePageInfo(input, extensionRegistry);
            }
        };

        private InferencePageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InferencePageInfo() {
            this.memoizedIsInitialized = -1;
            this.unlockWordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InferencePageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InferencePageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.pageId_ = input.readUInt32();
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unlockWordList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.unlockWordList_.add((InferenceWordInfoOuterClass.InferenceWordInfo) input.readMessage(InferenceWordInfoOuterClass.InferenceWordInfo.parser(), extensionRegistry));
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
                    this.unlockWordList_ = Collections.unmodifiableList(this.unlockWordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InferencePageInfoOuterClass.internal_static_InferencePageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InferencePageInfoOuterClass.internal_static_InferencePageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InferencePageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
        public int getPageId() {
            return this.pageId_;
        }

        @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
        public List<InferenceWordInfoOuterClass.InferenceWordInfo> getUnlockWordListList() {
            return this.unlockWordList_;
        }

        @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
        public List<? extends InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder> getUnlockWordListOrBuilderList() {
            return this.unlockWordList_;
        }

        @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
        public int getUnlockWordListCount() {
            return this.unlockWordList_.size();
        }

        @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
        public InferenceWordInfoOuterClass.InferenceWordInfo getUnlockWordList(int index) {
            return this.unlockWordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
        public InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder getUnlockWordListOrBuilder(int index) {
            return this.unlockWordList_.get(index);
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
            if (this.pageId_ != 0) {
                output.writeUInt32(6, this.pageId_);
            }
            for (int i = 0; i < this.unlockWordList_.size(); i++) {
                output.writeMessage(8, this.unlockWordList_.get(i));
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
            if (this.pageId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.pageId_);
            }
            for (int i = 0; i < this.unlockWordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.unlockWordList_.get(i));
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
            if (!(obj instanceof InferencePageInfo)) {
                return equals(obj);
            }
            InferencePageInfo other = (InferencePageInfo) obj;
            return getPageId() == other.getPageId() && getUnlockWordListList().equals(other.getUnlockWordListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getPageId();
            if (getUnlockWordListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getUnlockWordListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static InferencePageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InferencePageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InferencePageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InferencePageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InferencePageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InferencePageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InferencePageInfo parseFrom(InputStream input) throws IOException {
            return (InferencePageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InferencePageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InferencePageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InferencePageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (InferencePageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InferencePageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InferencePageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InferencePageInfo parseFrom(CodedInputStream input) throws IOException {
            return (InferencePageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InferencePageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InferencePageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InferencePageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InferencePageInfoOuterClass$InferencePageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InferencePageInfoOrBuilder {
            private int bitField0_;
            private int pageId_;
            private List<InferenceWordInfoOuterClass.InferenceWordInfo> unlockWordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<InferenceWordInfoOuterClass.InferenceWordInfo, InferenceWordInfoOuterClass.InferenceWordInfo.Builder, InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder> unlockWordListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InferencePageInfoOuterClass.internal_static_InferencePageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InferencePageInfoOuterClass.internal_static_InferencePageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InferencePageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InferencePageInfo.alwaysUseFieldBuilders) {
                    getUnlockWordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.pageId_ = 0;
                if (this.unlockWordListBuilder_ == null) {
                    this.unlockWordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.unlockWordListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InferencePageInfoOuterClass.internal_static_InferencePageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InferencePageInfo getDefaultInstanceForType() {
                return InferencePageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InferencePageInfo build() {
                InferencePageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InferencePageInfo buildPartial() {
                InferencePageInfo result = new InferencePageInfo(this);
                int i = this.bitField0_;
                result.pageId_ = this.pageId_;
                if (this.unlockWordListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.unlockWordList_ = Collections.unmodifiableList(this.unlockWordList_);
                        this.bitField0_ &= -2;
                    }
                    result.unlockWordList_ = this.unlockWordList_;
                } else {
                    result.unlockWordList_ = this.unlockWordListBuilder_.build();
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
                if (other instanceof InferencePageInfo) {
                    return mergeFrom((InferencePageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InferencePageInfo other) {
                if (other == InferencePageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPageId() != 0) {
                    setPageId(other.getPageId());
                }
                if (this.unlockWordListBuilder_ == null) {
                    if (!other.unlockWordList_.isEmpty()) {
                        if (this.unlockWordList_.isEmpty()) {
                            this.unlockWordList_ = other.unlockWordList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUnlockWordListIsMutable();
                            this.unlockWordList_.addAll(other.unlockWordList_);
                        }
                        onChanged();
                    }
                } else if (!other.unlockWordList_.isEmpty()) {
                    if (this.unlockWordListBuilder_.isEmpty()) {
                        this.unlockWordListBuilder_.dispose();
                        this.unlockWordListBuilder_ = null;
                        this.unlockWordList_ = other.unlockWordList_;
                        this.bitField0_ &= -2;
                        this.unlockWordListBuilder_ = InferencePageInfo.alwaysUseFieldBuilders ? getUnlockWordListFieldBuilder() : null;
                    } else {
                        this.unlockWordListBuilder_.addAllMessages(other.unlockWordList_);
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
                InferencePageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = InferencePageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InferencePageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
            public int getPageId() {
                return this.pageId_;
            }

            public Builder setPageId(int value) {
                this.pageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPageId() {
                this.pageId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnlockWordListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockWordList_ = new ArrayList(this.unlockWordList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
            public List<InferenceWordInfoOuterClass.InferenceWordInfo> getUnlockWordListList() {
                if (this.unlockWordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.unlockWordList_);
                }
                return this.unlockWordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
            public int getUnlockWordListCount() {
                if (this.unlockWordListBuilder_ == null) {
                    return this.unlockWordList_.size();
                }
                return this.unlockWordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
            public InferenceWordInfoOuterClass.InferenceWordInfo getUnlockWordList(int index) {
                if (this.unlockWordListBuilder_ == null) {
                    return this.unlockWordList_.get(index);
                }
                return this.unlockWordListBuilder_.getMessage(index);
            }

            public Builder setUnlockWordList(int index, InferenceWordInfoOuterClass.InferenceWordInfo value) {
                if (this.unlockWordListBuilder_ != null) {
                    this.unlockWordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnlockWordList(int index, InferenceWordInfoOuterClass.InferenceWordInfo.Builder builderForValue) {
                if (this.unlockWordListBuilder_ == null) {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unlockWordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnlockWordList(InferenceWordInfoOuterClass.InferenceWordInfo value) {
                if (this.unlockWordListBuilder_ != null) {
                    this.unlockWordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnlockWordList(int index, InferenceWordInfoOuterClass.InferenceWordInfo value) {
                if (this.unlockWordListBuilder_ != null) {
                    this.unlockWordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnlockWordList(InferenceWordInfoOuterClass.InferenceWordInfo.Builder builderForValue) {
                if (this.unlockWordListBuilder_ == null) {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unlockWordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnlockWordList(int index, InferenceWordInfoOuterClass.InferenceWordInfo.Builder builderForValue) {
                if (this.unlockWordListBuilder_ == null) {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unlockWordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnlockWordList(Iterable<? extends InferenceWordInfoOuterClass.InferenceWordInfo> values) {
                if (this.unlockWordListBuilder_ == null) {
                    ensureUnlockWordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockWordList_);
                    onChanged();
                } else {
                    this.unlockWordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnlockWordList() {
                if (this.unlockWordListBuilder_ == null) {
                    this.unlockWordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.unlockWordListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnlockWordList(int index) {
                if (this.unlockWordListBuilder_ == null) {
                    ensureUnlockWordListIsMutable();
                    this.unlockWordList_.remove(index);
                    onChanged();
                } else {
                    this.unlockWordListBuilder_.remove(index);
                }
                return this;
            }

            public InferenceWordInfoOuterClass.InferenceWordInfo.Builder getUnlockWordListBuilder(int index) {
                return getUnlockWordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
            public InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder getUnlockWordListOrBuilder(int index) {
                if (this.unlockWordListBuilder_ == null) {
                    return this.unlockWordList_.get(index);
                }
                return this.unlockWordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InferencePageInfoOuterClass.InferencePageInfoOrBuilder
            public List<? extends InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder> getUnlockWordListOrBuilderList() {
                if (this.unlockWordListBuilder_ != null) {
                    return this.unlockWordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unlockWordList_);
            }

            public InferenceWordInfoOuterClass.InferenceWordInfo.Builder addUnlockWordListBuilder() {
                return getUnlockWordListFieldBuilder().addBuilder(InferenceWordInfoOuterClass.InferenceWordInfo.getDefaultInstance());
            }

            public InferenceWordInfoOuterClass.InferenceWordInfo.Builder addUnlockWordListBuilder(int index) {
                return getUnlockWordListFieldBuilder().addBuilder(index, InferenceWordInfoOuterClass.InferenceWordInfo.getDefaultInstance());
            }

            public List<InferenceWordInfoOuterClass.InferenceWordInfo.Builder> getUnlockWordListBuilderList() {
                return getUnlockWordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<InferenceWordInfoOuterClass.InferenceWordInfo, InferenceWordInfoOuterClass.InferenceWordInfo.Builder, InferenceWordInfoOuterClass.InferenceWordInfoOrBuilder> getUnlockWordListFieldBuilder() {
                if (this.unlockWordListBuilder_ == null) {
                    this.unlockWordListBuilder_ = new RepeatedFieldBuilderV3<>(this.unlockWordList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.unlockWordList_ = null;
                }
                return this.unlockWordListBuilder_;
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

        public static InferencePageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InferencePageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InferencePageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InferencePageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InferenceWordInfoOuterClass.getDescriptor();
    }
}
