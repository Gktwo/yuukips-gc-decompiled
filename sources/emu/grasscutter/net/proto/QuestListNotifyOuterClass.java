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
import emu.grasscutter.net.proto.QuestOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestListNotifyOuterClass.class */
public final class QuestListNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015QuestListNotify.proto\u001a\u000bQuest.proto\"-\n\u000fQuestListNotify\u0012\u001a\n\nquest_list\u0018\r \u0003(\u000b2\u0006.QuestB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{QuestOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QuestListNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestListNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestListNotify_descriptor, new String[]{"QuestList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestListNotifyOuterClass$QuestListNotifyOrBuilder.class */
    public interface QuestListNotifyOrBuilder extends MessageOrBuilder {
        List<QuestOuterClass.Quest> getQuestListList();

        QuestOuterClass.Quest getQuestList(int i);

        int getQuestListCount();

        List<? extends QuestOuterClass.QuestOrBuilder> getQuestListOrBuilderList();

        QuestOuterClass.QuestOrBuilder getQuestListOrBuilder(int i);
    }

    private QuestListNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestListNotifyOuterClass$QuestListNotify.class */
    public static final class QuestListNotify extends GeneratedMessageV3 implements QuestListNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUEST_LIST_FIELD_NUMBER = 13;
        private List<QuestOuterClass.Quest> questList_;
        private byte memoizedIsInitialized;
        private static final QuestListNotify DEFAULT_INSTANCE = new QuestListNotify();
        private static final Parser<QuestListNotify> PARSER = new AbstractParser<QuestListNotify>() { // from class: emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotify.1
            @Override // com.google.protobuf.Parser
            public QuestListNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestListNotify(input, extensionRegistry);
            }
        };

        private QuestListNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestListNotify() {
            this.memoizedIsInitialized = -1;
            this.questList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestListNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestListNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.questList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.questList_.add((QuestOuterClass.Quest) input.readMessage(QuestOuterClass.Quest.parser(), extensionRegistry));
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
                    this.questList_ = Collections.unmodifiableList(this.questList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestListNotifyOuterClass.internal_static_QuestListNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestListNotifyOuterClass.internal_static_QuestListNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestListNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
        public List<QuestOuterClass.Quest> getQuestListList() {
            return this.questList_;
        }

        @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
        public List<? extends QuestOuterClass.QuestOrBuilder> getQuestListOrBuilderList() {
            return this.questList_;
        }

        @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
        public int getQuestListCount() {
            return this.questList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
        public QuestOuterClass.Quest getQuestList(int index) {
            return this.questList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
        public QuestOuterClass.QuestOrBuilder getQuestListOrBuilder(int index) {
            return this.questList_.get(index);
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
            for (int i = 0; i < this.questList_.size(); i++) {
                output.writeMessage(13, this.questList_.get(i));
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
            for (int i = 0; i < this.questList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.questList_.get(i));
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
            if (!(obj instanceof QuestListNotify)) {
                return equals(obj);
            }
            QuestListNotify other = (QuestListNotify) obj;
            return getQuestListList().equals(other.getQuestListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getQuestListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getQuestListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestListNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestListNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestListNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestListNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestListNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestListNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestListNotify parseFrom(InputStream input) throws IOException {
            return (QuestListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestListNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestListNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestListNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestListNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestListNotify parseFrom(CodedInputStream input) throws IOException {
            return (QuestListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestListNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestListNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestListNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestListNotifyOuterClass$QuestListNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestListNotifyOrBuilder {
            private int bitField0_;
            private List<QuestOuterClass.Quest> questList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<QuestOuterClass.Quest, QuestOuterClass.Quest.Builder, QuestOuterClass.QuestOrBuilder> questListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestListNotifyOuterClass.internal_static_QuestListNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestListNotifyOuterClass.internal_static_QuestListNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestListNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestListNotify.alwaysUseFieldBuilders) {
                    getQuestListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.questListBuilder_ == null) {
                    this.questList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.questListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestListNotifyOuterClass.internal_static_QuestListNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestListNotify getDefaultInstanceForType() {
                return QuestListNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestListNotify build() {
                QuestListNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestListNotify buildPartial() {
                QuestListNotify result = new QuestListNotify(this);
                int i = this.bitField0_;
                if (this.questListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.questList_ = Collections.unmodifiableList(this.questList_);
                        this.bitField0_ &= -2;
                    }
                    result.questList_ = this.questList_;
                } else {
                    result.questList_ = this.questListBuilder_.build();
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
                if (other instanceof QuestListNotify) {
                    return mergeFrom((QuestListNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestListNotify other) {
                if (other == QuestListNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.questListBuilder_ == null) {
                    if (!other.questList_.isEmpty()) {
                        if (this.questList_.isEmpty()) {
                            this.questList_ = other.questList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureQuestListIsMutable();
                            this.questList_.addAll(other.questList_);
                        }
                        onChanged();
                    }
                } else if (!other.questList_.isEmpty()) {
                    if (this.questListBuilder_.isEmpty()) {
                        this.questListBuilder_.dispose();
                        this.questListBuilder_ = null;
                        this.questList_ = other.questList_;
                        this.bitField0_ &= -2;
                        this.questListBuilder_ = QuestListNotify.alwaysUseFieldBuilders ? getQuestListFieldBuilder() : null;
                    } else {
                        this.questListBuilder_.addAllMessages(other.questList_);
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
                QuestListNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestListNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestListNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureQuestListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.questList_ = new ArrayList(this.questList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
            public List<QuestOuterClass.Quest> getQuestListList() {
                if (this.questListBuilder_ == null) {
                    return Collections.unmodifiableList(this.questList_);
                }
                return this.questListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
            public int getQuestListCount() {
                if (this.questListBuilder_ == null) {
                    return this.questList_.size();
                }
                return this.questListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
            public QuestOuterClass.Quest getQuestList(int index) {
                if (this.questListBuilder_ == null) {
                    return this.questList_.get(index);
                }
                return this.questListBuilder_.getMessage(index);
            }

            public Builder setQuestList(int index, QuestOuterClass.Quest value) {
                if (this.questListBuilder_ != null) {
                    this.questListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureQuestListIsMutable();
                    this.questList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setQuestList(int index, QuestOuterClass.Quest.Builder builderForValue) {
                if (this.questListBuilder_ == null) {
                    ensureQuestListIsMutable();
                    this.questList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.questListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addQuestList(QuestOuterClass.Quest value) {
                if (this.questListBuilder_ != null) {
                    this.questListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureQuestListIsMutable();
                    this.questList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addQuestList(int index, QuestOuterClass.Quest value) {
                if (this.questListBuilder_ != null) {
                    this.questListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureQuestListIsMutable();
                    this.questList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addQuestList(QuestOuterClass.Quest.Builder builderForValue) {
                if (this.questListBuilder_ == null) {
                    ensureQuestListIsMutable();
                    this.questList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.questListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addQuestList(int index, QuestOuterClass.Quest.Builder builderForValue) {
                if (this.questListBuilder_ == null) {
                    ensureQuestListIsMutable();
                    this.questList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.questListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllQuestList(Iterable<? extends QuestOuterClass.Quest> values) {
                if (this.questListBuilder_ == null) {
                    ensureQuestListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.questList_);
                    onChanged();
                } else {
                    this.questListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearQuestList() {
                if (this.questListBuilder_ == null) {
                    this.questList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.questListBuilder_.clear();
                }
                return this;
            }

            public Builder removeQuestList(int index) {
                if (this.questListBuilder_ == null) {
                    ensureQuestListIsMutable();
                    this.questList_.remove(index);
                    onChanged();
                } else {
                    this.questListBuilder_.remove(index);
                }
                return this;
            }

            public QuestOuterClass.Quest.Builder getQuestListBuilder(int index) {
                return getQuestListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
            public QuestOuterClass.QuestOrBuilder getQuestListOrBuilder(int index) {
                if (this.questListBuilder_ == null) {
                    return this.questList_.get(index);
                }
                return this.questListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QuestListNotifyOuterClass.QuestListNotifyOrBuilder
            public List<? extends QuestOuterClass.QuestOrBuilder> getQuestListOrBuilderList() {
                if (this.questListBuilder_ != null) {
                    return this.questListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.questList_);
            }

            public QuestOuterClass.Quest.Builder addQuestListBuilder() {
                return getQuestListFieldBuilder().addBuilder(QuestOuterClass.Quest.getDefaultInstance());
            }

            public QuestOuterClass.Quest.Builder addQuestListBuilder(int index) {
                return getQuestListFieldBuilder().addBuilder(index, QuestOuterClass.Quest.getDefaultInstance());
            }

            public List<QuestOuterClass.Quest.Builder> getQuestListBuilderList() {
                return getQuestListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<QuestOuterClass.Quest, QuestOuterClass.Quest.Builder, QuestOuterClass.QuestOrBuilder> getQuestListFieldBuilder() {
                if (this.questListBuilder_ == null) {
                    this.questListBuilder_ = new RepeatedFieldBuilderV3<>(this.questList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.questList_ = null;
                }
                return this.questListBuilder_;
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

        public static QuestListNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestListNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestListNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestListNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        QuestOuterClass.getDescriptor();
    }
}
