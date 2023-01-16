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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarNotifyOuterClass.class */
public final class QuestUpdateQuestVarNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fQuestUpdateQuestVarNotify.proto\"e\n\u0019QuestUpdateQuestVarNotify\u0012\u001c\n\u0014parent_quest_var_seq\u0018\t \u0001(\r\u0012\u0011\n\tquest_var\u0018\u0003 \u0003(\u0005\u0012\u0017\n\u000fparent_quest_id\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestUpdateQuestVarNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestUpdateQuestVarNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestUpdateQuestVarNotify_descriptor, new String[]{"ParentQuestVarSeq", "QuestVar", "ParentQuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarNotifyOuterClass$QuestUpdateQuestVarNotifyOrBuilder.class */
    public interface QuestUpdateQuestVarNotifyOrBuilder extends MessageOrBuilder {
        int getParentQuestVarSeq();

        List<Integer> getQuestVarList();

        int getQuestVarCount();

        int getQuestVar(int i);

        int getParentQuestId();
    }

    private QuestUpdateQuestVarNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarNotifyOuterClass$QuestUpdateQuestVarNotify.class */
    public static final class QuestUpdateQuestVarNotify extends GeneratedMessageV3 implements QuestUpdateQuestVarNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENT_QUEST_VAR_SEQ_FIELD_NUMBER = 9;
        private int parentQuestVarSeq_;
        public static final int QUEST_VAR_FIELD_NUMBER = 3;
        private Internal.IntList questVar_;
        private int questVarMemoizedSerializedSize;
        public static final int PARENT_QUEST_ID_FIELD_NUMBER = 7;
        private int parentQuestId_;
        private byte memoizedIsInitialized;
        private static final QuestUpdateQuestVarNotify DEFAULT_INSTANCE = new QuestUpdateQuestVarNotify();
        private static final Parser<QuestUpdateQuestVarNotify> PARSER = new AbstractParser<QuestUpdateQuestVarNotify>() { // from class: emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotify.1
            @Override // com.google.protobuf.Parser
            public QuestUpdateQuestVarNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestUpdateQuestVarNotify(input, extensionRegistry);
            }
        };

        private QuestUpdateQuestVarNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.questVarMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private QuestUpdateQuestVarNotify() {
            this.questVarMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.questVar_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestUpdateQuestVarNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestUpdateQuestVarNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.questVar_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.questVar_.addInt(input.readInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.questVar_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.questVar_.addInt(input.readInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 56:
                                this.parentQuestId_ = input.readUInt32();
                                break;
                            case 72:
                                this.parentQuestVarSeq_ = input.readUInt32();
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
                    this.questVar_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestUpdateQuestVarNotifyOuterClass.internal_static_QuestUpdateQuestVarNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestUpdateQuestVarNotifyOuterClass.internal_static_QuestUpdateQuestVarNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestVarNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
        public int getParentQuestVarSeq() {
            return this.parentQuestVarSeq_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
        public List<Integer> getQuestVarList() {
            return this.questVar_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
        public int getQuestVarCount() {
            return this.questVar_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
        public int getQuestVar(int index) {
            return this.questVar_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
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
            getSerializedSize();
            if (getQuestVarList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.questVarMemoizedSerializedSize);
            }
            for (int i = 0; i < this.questVar_.size(); i++) {
                output.writeInt32NoTag(this.questVar_.getInt(i));
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(7, this.parentQuestId_);
            }
            if (this.parentQuestVarSeq_ != 0) {
                output.writeUInt32(9, this.parentQuestVarSeq_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.questVar_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.questVar_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getQuestVarList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.questVarMemoizedSerializedSize = dataSize;
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.parentQuestId_);
            }
            if (this.parentQuestVarSeq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.parentQuestVarSeq_);
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
            if (!(obj instanceof QuestUpdateQuestVarNotify)) {
                return equals(obj);
            }
            QuestUpdateQuestVarNotify other = (QuestUpdateQuestVarNotify) obj;
            return getParentQuestVarSeq() == other.getParentQuestVarSeq() && getQuestVarList().equals(other.getQuestVarList()) && getParentQuestId() == other.getParentQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getParentQuestVarSeq();
            if (getQuestVarCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getQuestVarList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getParentQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestUpdateQuestVarNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarNotify parseFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestVarNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestVarNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestVarNotify parseFrom(CodedInputStream input) throws IOException {
            return (QuestUpdateQuestVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestUpdateQuestVarNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarNotifyOuterClass$QuestUpdateQuestVarNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestUpdateQuestVarNotifyOrBuilder {
            private int bitField0_;
            private int parentQuestVarSeq_;
            private Internal.IntList questVar_ = QuestUpdateQuestVarNotify.emptyIntList();
            private int parentQuestId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestUpdateQuestVarNotifyOuterClass.internal_static_QuestUpdateQuestVarNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestUpdateQuestVarNotifyOuterClass.internal_static_QuestUpdateQuestVarNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestVarNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestUpdateQuestVarNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentQuestVarSeq_ = 0;
                this.questVar_ = QuestUpdateQuestVarNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.parentQuestId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestUpdateQuestVarNotifyOuterClass.internal_static_QuestUpdateQuestVarNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestUpdateQuestVarNotify getDefaultInstanceForType() {
                return QuestUpdateQuestVarNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestVarNotify build() {
                QuestUpdateQuestVarNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestVarNotify buildPartial() {
                QuestUpdateQuestVarNotify result = new QuestUpdateQuestVarNotify(this);
                int i = this.bitField0_;
                result.parentQuestVarSeq_ = this.parentQuestVarSeq_;
                if ((this.bitField0_ & 1) != 0) {
                    this.questVar_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.questVar_ = this.questVar_;
                result.parentQuestId_ = this.parentQuestId_;
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
                if (other instanceof QuestUpdateQuestVarNotify) {
                    return mergeFrom((QuestUpdateQuestVarNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestUpdateQuestVarNotify other) {
                if (other == QuestUpdateQuestVarNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getParentQuestVarSeq() != 0) {
                    setParentQuestVarSeq(other.getParentQuestVarSeq());
                }
                if (!other.questVar_.isEmpty()) {
                    if (this.questVar_.isEmpty()) {
                        this.questVar_ = other.questVar_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureQuestVarIsMutable();
                        this.questVar_.addAll(other.questVar_);
                    }
                    onChanged();
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
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
                QuestUpdateQuestVarNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestUpdateQuestVarNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestUpdateQuestVarNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
            public int getParentQuestVarSeq() {
                return this.parentQuestVarSeq_;
            }

            public Builder setParentQuestVarSeq(int value) {
                this.parentQuestVarSeq_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestVarSeq() {
                this.parentQuestVarSeq_ = 0;
                onChanged();
                return this;
            }

            private void ensureQuestVarIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.questVar_ = QuestUpdateQuestVarNotify.mutableCopy(this.questVar_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
            public List<Integer> getQuestVarList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.questVar_) : this.questVar_;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
            public int getQuestVarCount() {
                return this.questVar_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
            public int getQuestVar(int index) {
                return this.questVar_.getInt(index);
            }

            public Builder setQuestVar(int index, int value) {
                ensureQuestVarIsMutable();
                this.questVar_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addQuestVar(int value) {
                ensureQuestVarIsMutable();
                this.questVar_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllQuestVar(Iterable<? extends Integer> values) {
                ensureQuestVarIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.questVar_);
                onChanged();
                return this;
            }

            public Builder clearQuestVar() {
                this.questVar_ = QuestUpdateQuestVarNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarNotifyOuterClass.QuestUpdateQuestVarNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static QuestUpdateQuestVarNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestUpdateQuestVarNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestUpdateQuestVarNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestUpdateQuestVarNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
