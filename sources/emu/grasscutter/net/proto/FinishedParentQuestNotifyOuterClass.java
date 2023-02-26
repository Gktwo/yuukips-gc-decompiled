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
import emu.grasscutter.net.proto.ParentQuestOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FinishedParentQuestNotifyOuterClass.class */
public final class FinishedParentQuestNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fFinishedParentQuestNotify.proto\u001a\u0011ParentQuest.proto\"B\n\u0019FinishedParentQuestNotify\u0012%\n\u000fparentQuestList\u0018\u0003 \u0003(\u000b2\f.ParentQuestB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ParentQuestOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FinishedParentQuestNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FinishedParentQuestNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FinishedParentQuestNotify_descriptor, new String[]{"ParentQuestList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FinishedParentQuestNotifyOuterClass$FinishedParentQuestNotifyOrBuilder.class */
    public interface FinishedParentQuestNotifyOrBuilder extends MessageOrBuilder {
        List<ParentQuestOuterClass.ParentQuest> getParentQuestListList();

        ParentQuestOuterClass.ParentQuest getParentQuestList(int i);

        int getParentQuestListCount();

        List<? extends ParentQuestOuterClass.ParentQuestOrBuilder> getParentQuestListOrBuilderList();

        ParentQuestOuterClass.ParentQuestOrBuilder getParentQuestListOrBuilder(int i);
    }

    private FinishedParentQuestNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FinishedParentQuestNotifyOuterClass$FinishedParentQuestNotify.class */
    public static final class FinishedParentQuestNotify extends GeneratedMessageV3 implements FinishedParentQuestNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENTQUESTLIST_FIELD_NUMBER = 3;
        private List<ParentQuestOuterClass.ParentQuest> parentQuestList_;
        private byte memoizedIsInitialized;
        private static final FinishedParentQuestNotify DEFAULT_INSTANCE = new FinishedParentQuestNotify();
        private static final Parser<FinishedParentQuestNotify> PARSER = new AbstractParser<FinishedParentQuestNotify>() { // from class: emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotify.1
            @Override // com.google.protobuf.Parser
            public FinishedParentQuestNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FinishedParentQuestNotify(input, extensionRegistry);
            }
        };

        private FinishedParentQuestNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FinishedParentQuestNotify() {
            this.memoizedIsInitialized = -1;
            this.parentQuestList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FinishedParentQuestNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FinishedParentQuestNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.parentQuestList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.parentQuestList_.add((ParentQuestOuterClass.ParentQuest) input.readMessage(ParentQuestOuterClass.ParentQuest.parser(), extensionRegistry));
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
                    this.parentQuestList_ = Collections.unmodifiableList(this.parentQuestList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FinishedParentQuestNotifyOuterClass.internal_static_FinishedParentQuestNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FinishedParentQuestNotifyOuterClass.internal_static_FinishedParentQuestNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FinishedParentQuestNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
        public List<ParentQuestOuterClass.ParentQuest> getParentQuestListList() {
            return this.parentQuestList_;
        }

        @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
        public List<? extends ParentQuestOuterClass.ParentQuestOrBuilder> getParentQuestListOrBuilderList() {
            return this.parentQuestList_;
        }

        @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
        public int getParentQuestListCount() {
            return this.parentQuestList_.size();
        }

        @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
        public ParentQuestOuterClass.ParentQuest getParentQuestList(int index) {
            return this.parentQuestList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
        public ParentQuestOuterClass.ParentQuestOrBuilder getParentQuestListOrBuilder(int index) {
            return this.parentQuestList_.get(index);
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
            for (int i = 0; i < this.parentQuestList_.size(); i++) {
                output.writeMessage(3, this.parentQuestList_.get(i));
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
            for (int i = 0; i < this.parentQuestList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.parentQuestList_.get(i));
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
            if (!(obj instanceof FinishedParentQuestNotify)) {
                return equals(obj);
            }
            FinishedParentQuestNotify other = (FinishedParentQuestNotify) obj;
            return getParentQuestListList().equals(other.getParentQuestListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getParentQuestListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getParentQuestListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FinishedParentQuestNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FinishedParentQuestNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishedParentQuestNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FinishedParentQuestNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishedParentQuestNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FinishedParentQuestNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FinishedParentQuestNotify parseFrom(InputStream input) throws IOException {
            return (FinishedParentQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FinishedParentQuestNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishedParentQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FinishedParentQuestNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (FinishedParentQuestNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FinishedParentQuestNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishedParentQuestNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FinishedParentQuestNotify parseFrom(CodedInputStream input) throws IOException {
            return (FinishedParentQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FinishedParentQuestNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FinishedParentQuestNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FinishedParentQuestNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FinishedParentQuestNotifyOuterClass$FinishedParentQuestNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FinishedParentQuestNotifyOrBuilder {
            private int bitField0_;
            private List<ParentQuestOuterClass.ParentQuest> parentQuestList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ParentQuestOuterClass.ParentQuest, ParentQuestOuterClass.ParentQuest.Builder, ParentQuestOuterClass.ParentQuestOrBuilder> parentQuestListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FinishedParentQuestNotifyOuterClass.internal_static_FinishedParentQuestNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FinishedParentQuestNotifyOuterClass.internal_static_FinishedParentQuestNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FinishedParentQuestNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FinishedParentQuestNotify.alwaysUseFieldBuilders) {
                    getParentQuestListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.parentQuestListBuilder_ == null) {
                    this.parentQuestList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.parentQuestListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FinishedParentQuestNotifyOuterClass.internal_static_FinishedParentQuestNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FinishedParentQuestNotify getDefaultInstanceForType() {
                return FinishedParentQuestNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FinishedParentQuestNotify build() {
                FinishedParentQuestNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FinishedParentQuestNotify buildPartial() {
                FinishedParentQuestNotify result = new FinishedParentQuestNotify(this);
                int i = this.bitField0_;
                if (this.parentQuestListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.parentQuestList_ = Collections.unmodifiableList(this.parentQuestList_);
                        this.bitField0_ &= -2;
                    }
                    result.parentQuestList_ = this.parentQuestList_;
                } else {
                    result.parentQuestList_ = this.parentQuestListBuilder_.build();
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
                if (other instanceof FinishedParentQuestNotify) {
                    return mergeFrom((FinishedParentQuestNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FinishedParentQuestNotify other) {
                if (other == FinishedParentQuestNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.parentQuestListBuilder_ == null) {
                    if (!other.parentQuestList_.isEmpty()) {
                        if (this.parentQuestList_.isEmpty()) {
                            this.parentQuestList_ = other.parentQuestList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureParentQuestListIsMutable();
                            this.parentQuestList_.addAll(other.parentQuestList_);
                        }
                        onChanged();
                    }
                } else if (!other.parentQuestList_.isEmpty()) {
                    if (this.parentQuestListBuilder_.isEmpty()) {
                        this.parentQuestListBuilder_.dispose();
                        this.parentQuestListBuilder_ = null;
                        this.parentQuestList_ = other.parentQuestList_;
                        this.bitField0_ &= -2;
                        this.parentQuestListBuilder_ = FinishedParentQuestNotify.alwaysUseFieldBuilders ? getParentQuestListFieldBuilder() : null;
                    } else {
                        this.parentQuestListBuilder_.addAllMessages(other.parentQuestList_);
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
                FinishedParentQuestNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = FinishedParentQuestNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FinishedParentQuestNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureParentQuestListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.parentQuestList_ = new ArrayList(this.parentQuestList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
            public List<ParentQuestOuterClass.ParentQuest> getParentQuestListList() {
                if (this.parentQuestListBuilder_ == null) {
                    return Collections.unmodifiableList(this.parentQuestList_);
                }
                return this.parentQuestListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
            public int getParentQuestListCount() {
                if (this.parentQuestListBuilder_ == null) {
                    return this.parentQuestList_.size();
                }
                return this.parentQuestListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
            public ParentQuestOuterClass.ParentQuest getParentQuestList(int index) {
                if (this.parentQuestListBuilder_ == null) {
                    return this.parentQuestList_.get(index);
                }
                return this.parentQuestListBuilder_.getMessage(index);
            }

            public Builder setParentQuestList(int index, ParentQuestOuterClass.ParentQuest value) {
                if (this.parentQuestListBuilder_ != null) {
                    this.parentQuestListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setParentQuestList(int index, ParentQuestOuterClass.ParentQuest.Builder builderForValue) {
                if (this.parentQuestListBuilder_ == null) {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.parentQuestListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addParentQuestList(ParentQuestOuterClass.ParentQuest value) {
                if (this.parentQuestListBuilder_ != null) {
                    this.parentQuestListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addParentQuestList(int index, ParentQuestOuterClass.ParentQuest value) {
                if (this.parentQuestListBuilder_ != null) {
                    this.parentQuestListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addParentQuestList(ParentQuestOuterClass.ParentQuest.Builder builderForValue) {
                if (this.parentQuestListBuilder_ == null) {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.parentQuestListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addParentQuestList(int index, ParentQuestOuterClass.ParentQuest.Builder builderForValue) {
                if (this.parentQuestListBuilder_ == null) {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.parentQuestListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllParentQuestList(Iterable<? extends ParentQuestOuterClass.ParentQuest> values) {
                if (this.parentQuestListBuilder_ == null) {
                    ensureParentQuestListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.parentQuestList_);
                    onChanged();
                } else {
                    this.parentQuestListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearParentQuestList() {
                if (this.parentQuestListBuilder_ == null) {
                    this.parentQuestList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.parentQuestListBuilder_.clear();
                }
                return this;
            }

            public Builder removeParentQuestList(int index) {
                if (this.parentQuestListBuilder_ == null) {
                    ensureParentQuestListIsMutable();
                    this.parentQuestList_.remove(index);
                    onChanged();
                } else {
                    this.parentQuestListBuilder_.remove(index);
                }
                return this;
            }

            public ParentQuestOuterClass.ParentQuest.Builder getParentQuestListBuilder(int index) {
                return getParentQuestListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
            public ParentQuestOuterClass.ParentQuestOrBuilder getParentQuestListOrBuilder(int index) {
                if (this.parentQuestListBuilder_ == null) {
                    return this.parentQuestList_.get(index);
                }
                return this.parentQuestListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotifyOrBuilder
            public List<? extends ParentQuestOuterClass.ParentQuestOrBuilder> getParentQuestListOrBuilderList() {
                if (this.parentQuestListBuilder_ != null) {
                    return this.parentQuestListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.parentQuestList_);
            }

            public ParentQuestOuterClass.ParentQuest.Builder addParentQuestListBuilder() {
                return getParentQuestListFieldBuilder().addBuilder(ParentQuestOuterClass.ParentQuest.getDefaultInstance());
            }

            public ParentQuestOuterClass.ParentQuest.Builder addParentQuestListBuilder(int index) {
                return getParentQuestListFieldBuilder().addBuilder(index, ParentQuestOuterClass.ParentQuest.getDefaultInstance());
            }

            public List<ParentQuestOuterClass.ParentQuest.Builder> getParentQuestListBuilderList() {
                return getParentQuestListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ParentQuestOuterClass.ParentQuest, ParentQuestOuterClass.ParentQuest.Builder, ParentQuestOuterClass.ParentQuestOrBuilder> getParentQuestListFieldBuilder() {
                if (this.parentQuestListBuilder_ == null) {
                    this.parentQuestListBuilder_ = new RepeatedFieldBuilderV3<>(this.parentQuestList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.parentQuestList_ = null;
                }
                return this.parentQuestListBuilder_;
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

        public static FinishedParentQuestNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FinishedParentQuestNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FinishedParentQuestNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FinishedParentQuestNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ParentQuestOuterClass.getDescriptor();
    }
}
