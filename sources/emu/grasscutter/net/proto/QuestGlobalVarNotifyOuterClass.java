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
import emu.grasscutter.net.proto.QuestGlobalVarOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarNotifyOuterClass.class */
public final class QuestGlobalVarNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aQuestGlobalVarNotify.proto\u001a\u0014QuestGlobalVar.proto\"8\n\u0014QuestGlobalVarNotify\u0012 \n\u0007varList\u0018\f \u0003(\u000b2\u000f.QuestGlobalVarB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{QuestGlobalVarOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QuestGlobalVarNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestGlobalVarNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestGlobalVarNotify_descriptor, new String[]{"VarList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarNotifyOuterClass$QuestGlobalVarNotifyOrBuilder.class */
    public interface QuestGlobalVarNotifyOrBuilder extends MessageOrBuilder {
        List<QuestGlobalVarOuterClass.QuestGlobalVar> getVarListList();

        QuestGlobalVarOuterClass.QuestGlobalVar getVarList(int i);

        int getVarListCount();

        List<? extends QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder> getVarListOrBuilderList();

        QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder getVarListOrBuilder(int i);
    }

    private QuestGlobalVarNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarNotifyOuterClass$QuestGlobalVarNotify.class */
    public static final class QuestGlobalVarNotify extends GeneratedMessageV3 implements QuestGlobalVarNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VARLIST_FIELD_NUMBER = 12;
        private List<QuestGlobalVarOuterClass.QuestGlobalVar> varList_;
        private byte memoizedIsInitialized;
        private static final QuestGlobalVarNotify DEFAULT_INSTANCE = new QuestGlobalVarNotify();
        private static final Parser<QuestGlobalVarNotify> PARSER = new AbstractParser<QuestGlobalVarNotify>() { // from class: emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotify.1
            @Override // com.google.protobuf.Parser
            public QuestGlobalVarNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestGlobalVarNotify(input, extensionRegistry);
            }
        };

        private QuestGlobalVarNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestGlobalVarNotify() {
            this.memoizedIsInitialized = -1;
            this.varList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestGlobalVarNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestGlobalVarNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.varList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.varList_.add((QuestGlobalVarOuterClass.QuestGlobalVar) input.readMessage(QuestGlobalVarOuterClass.QuestGlobalVar.parser(), extensionRegistry));
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
                    this.varList_ = Collections.unmodifiableList(this.varList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestGlobalVarNotifyOuterClass.internal_static_QuestGlobalVarNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestGlobalVarNotifyOuterClass.internal_static_QuestGlobalVarNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestGlobalVarNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
        public List<QuestGlobalVarOuterClass.QuestGlobalVar> getVarListList() {
            return this.varList_;
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
        public List<? extends QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder> getVarListOrBuilderList() {
            return this.varList_;
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
        public int getVarListCount() {
            return this.varList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
        public QuestGlobalVarOuterClass.QuestGlobalVar getVarList(int index) {
            return this.varList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
        public QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder getVarListOrBuilder(int index) {
            return this.varList_.get(index);
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
            for (int i = 0; i < this.varList_.size(); i++) {
                output.writeMessage(12, this.varList_.get(i));
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
            for (int i = 0; i < this.varList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.varList_.get(i));
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
            if (!(obj instanceof QuestGlobalVarNotify)) {
                return equals(obj);
            }
            QuestGlobalVarNotify other = (QuestGlobalVarNotify) obj;
            return getVarListList().equals(other.getVarListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getVarListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getVarListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestGlobalVarNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestGlobalVarNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestGlobalVarNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestGlobalVarNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestGlobalVarNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestGlobalVarNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestGlobalVarNotify parseFrom(InputStream input) throws IOException {
            return (QuestGlobalVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestGlobalVarNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestGlobalVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestGlobalVarNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestGlobalVarNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestGlobalVarNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestGlobalVarNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestGlobalVarNotify parseFrom(CodedInputStream input) throws IOException {
            return (QuestGlobalVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestGlobalVarNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestGlobalVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestGlobalVarNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarNotifyOuterClass$QuestGlobalVarNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestGlobalVarNotifyOrBuilder {
            private int bitField0_;
            private List<QuestGlobalVarOuterClass.QuestGlobalVar> varList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<QuestGlobalVarOuterClass.QuestGlobalVar, QuestGlobalVarOuterClass.QuestGlobalVar.Builder, QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder> varListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestGlobalVarNotifyOuterClass.internal_static_QuestGlobalVarNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestGlobalVarNotifyOuterClass.internal_static_QuestGlobalVarNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestGlobalVarNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestGlobalVarNotify.alwaysUseFieldBuilders) {
                    getVarListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.varListBuilder_ == null) {
                    this.varList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.varListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestGlobalVarNotifyOuterClass.internal_static_QuestGlobalVarNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestGlobalVarNotify getDefaultInstanceForType() {
                return QuestGlobalVarNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestGlobalVarNotify build() {
                QuestGlobalVarNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestGlobalVarNotify buildPartial() {
                QuestGlobalVarNotify result = new QuestGlobalVarNotify(this);
                int i = this.bitField0_;
                if (this.varListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.varList_ = Collections.unmodifiableList(this.varList_);
                        this.bitField0_ &= -2;
                    }
                    result.varList_ = this.varList_;
                } else {
                    result.varList_ = this.varListBuilder_.build();
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
                if (other instanceof QuestGlobalVarNotify) {
                    return mergeFrom((QuestGlobalVarNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestGlobalVarNotify other) {
                if (other == QuestGlobalVarNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.varListBuilder_ == null) {
                    if (!other.varList_.isEmpty()) {
                        if (this.varList_.isEmpty()) {
                            this.varList_ = other.varList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureVarListIsMutable();
                            this.varList_.addAll(other.varList_);
                        }
                        onChanged();
                    }
                } else if (!other.varList_.isEmpty()) {
                    if (this.varListBuilder_.isEmpty()) {
                        this.varListBuilder_.dispose();
                        this.varListBuilder_ = null;
                        this.varList_ = other.varList_;
                        this.bitField0_ &= -2;
                        this.varListBuilder_ = QuestGlobalVarNotify.alwaysUseFieldBuilders ? getVarListFieldBuilder() : null;
                    } else {
                        this.varListBuilder_.addAllMessages(other.varList_);
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
                QuestGlobalVarNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestGlobalVarNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestGlobalVarNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureVarListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.varList_ = new ArrayList(this.varList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
            public List<QuestGlobalVarOuterClass.QuestGlobalVar> getVarListList() {
                if (this.varListBuilder_ == null) {
                    return Collections.unmodifiableList(this.varList_);
                }
                return this.varListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
            public int getVarListCount() {
                if (this.varListBuilder_ == null) {
                    return this.varList_.size();
                }
                return this.varListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
            public QuestGlobalVarOuterClass.QuestGlobalVar getVarList(int index) {
                if (this.varListBuilder_ == null) {
                    return this.varList_.get(index);
                }
                return this.varListBuilder_.getMessage(index);
            }

            public Builder setVarList(int index, QuestGlobalVarOuterClass.QuestGlobalVar value) {
                if (this.varListBuilder_ != null) {
                    this.varListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVarListIsMutable();
                    this.varList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setVarList(int index, QuestGlobalVarOuterClass.QuestGlobalVar.Builder builderForValue) {
                if (this.varListBuilder_ == null) {
                    ensureVarListIsMutable();
                    this.varList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.varListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addVarList(QuestGlobalVarOuterClass.QuestGlobalVar value) {
                if (this.varListBuilder_ != null) {
                    this.varListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVarListIsMutable();
                    this.varList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addVarList(int index, QuestGlobalVarOuterClass.QuestGlobalVar value) {
                if (this.varListBuilder_ != null) {
                    this.varListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVarListIsMutable();
                    this.varList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addVarList(QuestGlobalVarOuterClass.QuestGlobalVar.Builder builderForValue) {
                if (this.varListBuilder_ == null) {
                    ensureVarListIsMutable();
                    this.varList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.varListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addVarList(int index, QuestGlobalVarOuterClass.QuestGlobalVar.Builder builderForValue) {
                if (this.varListBuilder_ == null) {
                    ensureVarListIsMutable();
                    this.varList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.varListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllVarList(Iterable<? extends QuestGlobalVarOuterClass.QuestGlobalVar> values) {
                if (this.varListBuilder_ == null) {
                    ensureVarListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.varList_);
                    onChanged();
                } else {
                    this.varListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearVarList() {
                if (this.varListBuilder_ == null) {
                    this.varList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.varListBuilder_.clear();
                }
                return this;
            }

            public Builder removeVarList(int index) {
                if (this.varListBuilder_ == null) {
                    ensureVarListIsMutable();
                    this.varList_.remove(index);
                    onChanged();
                } else {
                    this.varListBuilder_.remove(index);
                }
                return this;
            }

            public QuestGlobalVarOuterClass.QuestGlobalVar.Builder getVarListBuilder(int index) {
                return getVarListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
            public QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder getVarListOrBuilder(int index) {
                if (this.varListBuilder_ == null) {
                    return this.varList_.get(index);
                }
                return this.varListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarNotifyOuterClass.QuestGlobalVarNotifyOrBuilder
            public List<? extends QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder> getVarListOrBuilderList() {
                if (this.varListBuilder_ != null) {
                    return this.varListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.varList_);
            }

            public QuestGlobalVarOuterClass.QuestGlobalVar.Builder addVarListBuilder() {
                return getVarListFieldBuilder().addBuilder(QuestGlobalVarOuterClass.QuestGlobalVar.getDefaultInstance());
            }

            public QuestGlobalVarOuterClass.QuestGlobalVar.Builder addVarListBuilder(int index) {
                return getVarListFieldBuilder().addBuilder(index, QuestGlobalVarOuterClass.QuestGlobalVar.getDefaultInstance());
            }

            public List<QuestGlobalVarOuterClass.QuestGlobalVar.Builder> getVarListBuilderList() {
                return getVarListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<QuestGlobalVarOuterClass.QuestGlobalVar, QuestGlobalVarOuterClass.QuestGlobalVar.Builder, QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder> getVarListFieldBuilder() {
                if (this.varListBuilder_ == null) {
                    this.varListBuilder_ = new RepeatedFieldBuilderV3<>(this.varList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.varList_ = null;
                }
                return this.varListBuilder_;
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

        public static QuestGlobalVarNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestGlobalVarNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestGlobalVarNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestGlobalVarNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        QuestGlobalVarOuterClass.getDescriptor();
    }
}
