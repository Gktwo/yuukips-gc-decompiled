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
import emu.grasscutter.net.proto.QuestVarOpOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarReqOuterClass.class */
public final class QuestUpdateQuestVarReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cQuestUpdateQuestVarReq.proto\u001a\u0010QuestVarOp.proto\"\u0001\n\u0016QuestUpdateQuestVarReq\u0012\u001c\n\u0014parent_quest_var_seq\u0018\u0007 \u0001(\r\u0012&\n\u0011quest_var_op_list\u0018\u000b \u0003(\u000b2\u000b.QuestVarOp\u0012\u0010\n\bquest_id\u0018\u0005 \u0001(\r\u0012\u0017\n\u000fparent_quest_id\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{QuestVarOpOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QuestUpdateQuestVarReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestUpdateQuestVarReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestUpdateQuestVarReq_descriptor, new String[]{"ParentQuestVarSeq", "QuestVarOpList", "QuestId", "ParentQuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarReqOuterClass$QuestUpdateQuestVarReqOrBuilder.class */
    public interface QuestUpdateQuestVarReqOrBuilder extends MessageOrBuilder {
        int getParentQuestVarSeq();

        List<QuestVarOpOuterClass.QuestVarOp> getQuestVarOpListList();

        QuestVarOpOuterClass.QuestVarOp getQuestVarOpList(int i);

        int getQuestVarOpListCount();

        List<? extends QuestVarOpOuterClass.QuestVarOpOrBuilder> getQuestVarOpListOrBuilderList();

        QuestVarOpOuterClass.QuestVarOpOrBuilder getQuestVarOpListOrBuilder(int i);

        int getQuestId();

        int getParentQuestId();
    }

    private QuestUpdateQuestVarReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarReqOuterClass$QuestUpdateQuestVarReq.class */
    public static final class QuestUpdateQuestVarReq extends GeneratedMessageV3 implements QuestUpdateQuestVarReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENT_QUEST_VAR_SEQ_FIELD_NUMBER = 7;
        private int parentQuestVarSeq_;
        public static final int QUEST_VAR_OP_LIST_FIELD_NUMBER = 11;
        private List<QuestVarOpOuterClass.QuestVarOp> questVarOpList_;
        public static final int QUEST_ID_FIELD_NUMBER = 5;
        private int questId_;
        public static final int PARENT_QUEST_ID_FIELD_NUMBER = 2;
        private int parentQuestId_;
        private byte memoizedIsInitialized;
        private static final QuestUpdateQuestVarReq DEFAULT_INSTANCE = new QuestUpdateQuestVarReq();
        private static final Parser<QuestUpdateQuestVarReq> PARSER = new AbstractParser<QuestUpdateQuestVarReq>() { // from class: emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReq.1
            @Override // com.google.protobuf.Parser
            public QuestUpdateQuestVarReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestUpdateQuestVarReq(input, extensionRegistry);
            }
        };

        private QuestUpdateQuestVarReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestUpdateQuestVarReq() {
            this.memoizedIsInitialized = -1;
            this.questVarOpList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestUpdateQuestVarReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestUpdateQuestVarReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.parentQuestId_ = input.readUInt32();
                                break;
                            case 40:
                                this.questId_ = input.readUInt32();
                                break;
                            case 56:
                                this.parentQuestVarSeq_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.questVarOpList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.questVarOpList_.add((QuestVarOpOuterClass.QuestVarOp) input.readMessage(QuestVarOpOuterClass.QuestVarOp.parser(), extensionRegistry));
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
                    this.questVarOpList_ = Collections.unmodifiableList(this.questVarOpList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestUpdateQuestVarReqOuterClass.internal_static_QuestUpdateQuestVarReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestUpdateQuestVarReqOuterClass.internal_static_QuestUpdateQuestVarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestVarReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public int getParentQuestVarSeq() {
            return this.parentQuestVarSeq_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public List<QuestVarOpOuterClass.QuestVarOp> getQuestVarOpListList() {
            return this.questVarOpList_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public List<? extends QuestVarOpOuterClass.QuestVarOpOrBuilder> getQuestVarOpListOrBuilderList() {
            return this.questVarOpList_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public int getQuestVarOpListCount() {
            return this.questVarOpList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public QuestVarOpOuterClass.QuestVarOp getQuestVarOpList(int index) {
            return this.questVarOpList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public QuestVarOpOuterClass.QuestVarOpOrBuilder getQuestVarOpListOrBuilder(int index) {
            return this.questVarOpList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
        public int getQuestId() {
            return this.questId_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
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
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(2, this.parentQuestId_);
            }
            if (this.questId_ != 0) {
                output.writeUInt32(5, this.questId_);
            }
            if (this.parentQuestVarSeq_ != 0) {
                output.writeUInt32(7, this.parentQuestVarSeq_);
            }
            for (int i = 0; i < this.questVarOpList_.size(); i++) {
                output.writeMessage(11, this.questVarOpList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.parentQuestId_);
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.questId_);
            }
            if (this.parentQuestVarSeq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.parentQuestVarSeq_);
            }
            for (int i = 0; i < this.questVarOpList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.questVarOpList_.get(i));
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
            if (!(obj instanceof QuestUpdateQuestVarReq)) {
                return equals(obj);
            }
            QuestUpdateQuestVarReq other = (QuestUpdateQuestVarReq) obj;
            return getParentQuestVarSeq() == other.getParentQuestVarSeq() && getQuestVarOpListList().equals(other.getQuestVarOpListList()) && getQuestId() == other.getQuestId() && getParentQuestId() == other.getParentQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getParentQuestVarSeq();
            if (getQuestVarOpListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getQuestVarOpListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getQuestId())) + 2)) + getParentQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestUpdateQuestVarReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarReq parseFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestVarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestVarReq parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestVarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestVarReq parseFrom(CodedInputStream input) throws IOException {
            return (QuestUpdateQuestVarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestUpdateQuestVarReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarReqOuterClass$QuestUpdateQuestVarReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestUpdateQuestVarReqOrBuilder {
            private int bitField0_;
            private int parentQuestVarSeq_;
            private List<QuestVarOpOuterClass.QuestVarOp> questVarOpList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<QuestVarOpOuterClass.QuestVarOp, QuestVarOpOuterClass.QuestVarOp.Builder, QuestVarOpOuterClass.QuestVarOpOrBuilder> questVarOpListBuilder_;
            private int questId_;
            private int parentQuestId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestUpdateQuestVarReqOuterClass.internal_static_QuestUpdateQuestVarReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestUpdateQuestVarReqOuterClass.internal_static_QuestUpdateQuestVarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestVarReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestUpdateQuestVarReq.alwaysUseFieldBuilders) {
                    getQuestVarOpListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentQuestVarSeq_ = 0;
                if (this.questVarOpListBuilder_ == null) {
                    this.questVarOpList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.questVarOpListBuilder_.clear();
                }
                this.questId_ = 0;
                this.parentQuestId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestUpdateQuestVarReqOuterClass.internal_static_QuestUpdateQuestVarReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestUpdateQuestVarReq getDefaultInstanceForType() {
                return QuestUpdateQuestVarReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestVarReq build() {
                QuestUpdateQuestVarReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestVarReq buildPartial() {
                QuestUpdateQuestVarReq result = new QuestUpdateQuestVarReq(this);
                int i = this.bitField0_;
                result.parentQuestVarSeq_ = this.parentQuestVarSeq_;
                if (this.questVarOpListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.questVarOpList_ = Collections.unmodifiableList(this.questVarOpList_);
                        this.bitField0_ &= -2;
                    }
                    result.questVarOpList_ = this.questVarOpList_;
                } else {
                    result.questVarOpList_ = this.questVarOpListBuilder_.build();
                }
                result.questId_ = this.questId_;
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
                if (other instanceof QuestUpdateQuestVarReq) {
                    return mergeFrom((QuestUpdateQuestVarReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestUpdateQuestVarReq other) {
                if (other == QuestUpdateQuestVarReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getParentQuestVarSeq() != 0) {
                    setParentQuestVarSeq(other.getParentQuestVarSeq());
                }
                if (this.questVarOpListBuilder_ == null) {
                    if (!other.questVarOpList_.isEmpty()) {
                        if (this.questVarOpList_.isEmpty()) {
                            this.questVarOpList_ = other.questVarOpList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureQuestVarOpListIsMutable();
                            this.questVarOpList_.addAll(other.questVarOpList_);
                        }
                        onChanged();
                    }
                } else if (!other.questVarOpList_.isEmpty()) {
                    if (this.questVarOpListBuilder_.isEmpty()) {
                        this.questVarOpListBuilder_.dispose();
                        this.questVarOpListBuilder_ = null;
                        this.questVarOpList_ = other.questVarOpList_;
                        this.bitField0_ &= -2;
                        this.questVarOpListBuilder_ = QuestUpdateQuestVarReq.alwaysUseFieldBuilders ? getQuestVarOpListFieldBuilder() : null;
                    } else {
                        this.questVarOpListBuilder_.addAllMessages(other.questVarOpList_);
                    }
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
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
                QuestUpdateQuestVarReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestUpdateQuestVarReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestUpdateQuestVarReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
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

            private void ensureQuestVarOpListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.questVarOpList_ = new ArrayList(this.questVarOpList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
            public List<QuestVarOpOuterClass.QuestVarOp> getQuestVarOpListList() {
                if (this.questVarOpListBuilder_ == null) {
                    return Collections.unmodifiableList(this.questVarOpList_);
                }
                return this.questVarOpListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
            public int getQuestVarOpListCount() {
                if (this.questVarOpListBuilder_ == null) {
                    return this.questVarOpList_.size();
                }
                return this.questVarOpListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
            public QuestVarOpOuterClass.QuestVarOp getQuestVarOpList(int index) {
                if (this.questVarOpListBuilder_ == null) {
                    return this.questVarOpList_.get(index);
                }
                return this.questVarOpListBuilder_.getMessage(index);
            }

            public Builder setQuestVarOpList(int index, QuestVarOpOuterClass.QuestVarOp value) {
                if (this.questVarOpListBuilder_ != null) {
                    this.questVarOpListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setQuestVarOpList(int index, QuestVarOpOuterClass.QuestVarOp.Builder builderForValue) {
                if (this.questVarOpListBuilder_ == null) {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.questVarOpListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addQuestVarOpList(QuestVarOpOuterClass.QuestVarOp value) {
                if (this.questVarOpListBuilder_ != null) {
                    this.questVarOpListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addQuestVarOpList(int index, QuestVarOpOuterClass.QuestVarOp value) {
                if (this.questVarOpListBuilder_ != null) {
                    this.questVarOpListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addQuestVarOpList(QuestVarOpOuterClass.QuestVarOp.Builder builderForValue) {
                if (this.questVarOpListBuilder_ == null) {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.questVarOpListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addQuestVarOpList(int index, QuestVarOpOuterClass.QuestVarOp.Builder builderForValue) {
                if (this.questVarOpListBuilder_ == null) {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.questVarOpListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllQuestVarOpList(Iterable<? extends QuestVarOpOuterClass.QuestVarOp> values) {
                if (this.questVarOpListBuilder_ == null) {
                    ensureQuestVarOpListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.questVarOpList_);
                    onChanged();
                } else {
                    this.questVarOpListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearQuestVarOpList() {
                if (this.questVarOpListBuilder_ == null) {
                    this.questVarOpList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.questVarOpListBuilder_.clear();
                }
                return this;
            }

            public Builder removeQuestVarOpList(int index) {
                if (this.questVarOpListBuilder_ == null) {
                    ensureQuestVarOpListIsMutable();
                    this.questVarOpList_.remove(index);
                    onChanged();
                } else {
                    this.questVarOpListBuilder_.remove(index);
                }
                return this;
            }

            public QuestVarOpOuterClass.QuestVarOp.Builder getQuestVarOpListBuilder(int index) {
                return getQuestVarOpListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
            public QuestVarOpOuterClass.QuestVarOpOrBuilder getQuestVarOpListOrBuilder(int index) {
                if (this.questVarOpListBuilder_ == null) {
                    return this.questVarOpList_.get(index);
                }
                return this.questVarOpListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
            public List<? extends QuestVarOpOuterClass.QuestVarOpOrBuilder> getQuestVarOpListOrBuilderList() {
                if (this.questVarOpListBuilder_ != null) {
                    return this.questVarOpListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.questVarOpList_);
            }

            public QuestVarOpOuterClass.QuestVarOp.Builder addQuestVarOpListBuilder() {
                return getQuestVarOpListFieldBuilder().addBuilder(QuestVarOpOuterClass.QuestVarOp.getDefaultInstance());
            }

            public QuestVarOpOuterClass.QuestVarOp.Builder addQuestVarOpListBuilder(int index) {
                return getQuestVarOpListFieldBuilder().addBuilder(index, QuestVarOpOuterClass.QuestVarOp.getDefaultInstance());
            }

            public List<QuestVarOpOuterClass.QuestVarOp.Builder> getQuestVarOpListBuilderList() {
                return getQuestVarOpListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<QuestVarOpOuterClass.QuestVarOp, QuestVarOpOuterClass.QuestVarOp.Builder, QuestVarOpOuterClass.QuestVarOpOrBuilder> getQuestVarOpListFieldBuilder() {
                if (this.questVarOpListBuilder_ == null) {
                    this.questVarOpListBuilder_ = new RepeatedFieldBuilderV3<>(this.questVarOpList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.questVarOpList_ = null;
                }
                return this.questVarOpListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
            public int getQuestId() {
                return this.questId_;
            }

            public Builder setQuestId(int value) {
                this.questId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestId() {
                this.questId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarReqOuterClass.QuestUpdateQuestVarReqOrBuilder
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

        public static QuestUpdateQuestVarReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestUpdateQuestVarReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestUpdateQuestVarReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestUpdateQuestVarReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        QuestVarOpOuterClass.getDescriptor();
    }
}
