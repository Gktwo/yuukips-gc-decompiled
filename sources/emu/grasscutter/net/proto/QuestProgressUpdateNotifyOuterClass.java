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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestProgressUpdateNotifyOuterClass.class */
public final class QuestProgressUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fQuestProgressUpdateNotify.proto\"b\n\u0019QuestProgressUpdateNotify\u0012\u000f\n\u0007questId\u0018\t \u0001(\r\u0012\u0018\n\u0010failProgressList\u0018\u000b \u0003(\r\u0012\u001a\n\u0012finishProgressList\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestProgressUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestProgressUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestProgressUpdateNotify_descriptor, new String[]{"QuestId", "FailProgressList", "FinishProgressList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestProgressUpdateNotifyOuterClass$QuestProgressUpdateNotifyOrBuilder.class */
    public interface QuestProgressUpdateNotifyOrBuilder extends MessageOrBuilder {
        int getQuestId();

        List<Integer> getFailProgressListList();

        int getFailProgressListCount();

        int getFailProgressList(int i);

        List<Integer> getFinishProgressListList();

        int getFinishProgressListCount();

        int getFinishProgressList(int i);
    }

    private QuestProgressUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestProgressUpdateNotifyOuterClass$QuestProgressUpdateNotify.class */
    public static final class QuestProgressUpdateNotify extends GeneratedMessageV3 implements QuestProgressUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUESTID_FIELD_NUMBER = 9;
        private int questId_;
        public static final int FAILPROGRESSLIST_FIELD_NUMBER = 11;
        private Internal.IntList failProgressList_;
        private int failProgressListMemoizedSerializedSize;
        public static final int FINISHPROGRESSLIST_FIELD_NUMBER = 1;
        private Internal.IntList finishProgressList_;
        private int finishProgressListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final QuestProgressUpdateNotify DEFAULT_INSTANCE = new QuestProgressUpdateNotify();
        private static final Parser<QuestProgressUpdateNotify> PARSER = new AbstractParser<QuestProgressUpdateNotify>() { // from class: emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public QuestProgressUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestProgressUpdateNotify(input, extensionRegistry);
            }
        };

        private QuestProgressUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.failProgressListMemoizedSerializedSize = -1;
            this.finishProgressListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private QuestProgressUpdateNotify() {
            this.failProgressListMemoizedSerializedSize = -1;
            this.finishProgressListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.failProgressList_ = emptyIntList();
            this.finishProgressList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestProgressUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x014f */
        private QuestProgressUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.finishProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.finishProgressList_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishProgressList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.questId_ = input.readUInt32();
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.failProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.failProgressList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.failProgressList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.failProgressList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.finishProgressList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.failProgressList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestProgressUpdateNotifyOuterClass.internal_static_QuestProgressUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestProgressUpdateNotifyOuterClass.internal_static_QuestProgressUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestProgressUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public int getQuestId() {
            return this.questId_;
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public List<Integer> getFailProgressListList() {
            return this.failProgressList_;
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public int getFailProgressListCount() {
            return this.failProgressList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public int getFailProgressList(int index) {
            return this.failProgressList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public List<Integer> getFinishProgressListList() {
            return this.finishProgressList_;
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public int getFinishProgressListCount() {
            return this.finishProgressList_.size();
        }

        @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
        public int getFinishProgressList(int index) {
            return this.finishProgressList_.getInt(index);
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
            if (getFinishProgressListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.finishProgressListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishProgressList_.size(); i++) {
                output.writeUInt32NoTag(this.finishProgressList_.getInt(i));
            }
            if (this.questId_ != 0) {
                output.writeUInt32(9, this.questId_);
            }
            if (getFailProgressListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.failProgressListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.failProgressList_.size(); i2++) {
                output.writeUInt32NoTag(this.failProgressList_.getInt(i2));
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
            for (int i = 0; i < this.finishProgressList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishProgressList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getFinishProgressListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishProgressListMemoizedSerializedSize = dataSize;
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.questId_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.failProgressList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.failProgressList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getFailProgressListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.failProgressListMemoizedSerializedSize = dataSize2;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QuestProgressUpdateNotify)) {
                return equals(obj);
            }
            QuestProgressUpdateNotify other = (QuestProgressUpdateNotify) obj;
            return getQuestId() == other.getQuestId() && getFailProgressListList().equals(other.getFailProgressListList()) && getFinishProgressListList().equals(other.getFinishProgressListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getQuestId();
            if (getFailProgressListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getFailProgressListList().hashCode();
            }
            if (getFinishProgressListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getFinishProgressListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestProgressUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestProgressUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestProgressUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestProgressUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestProgressUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestProgressUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestProgressUpdateNotify parseFrom(InputStream input) throws IOException {
            return (QuestProgressUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestProgressUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestProgressUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestProgressUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestProgressUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestProgressUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestProgressUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestProgressUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (QuestProgressUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestProgressUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestProgressUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestProgressUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestProgressUpdateNotifyOuterClass$QuestProgressUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestProgressUpdateNotifyOrBuilder {
            private int bitField0_;
            private int questId_;
            private Internal.IntList failProgressList_ = QuestProgressUpdateNotify.emptyIntList();
            private Internal.IntList finishProgressList_ = QuestProgressUpdateNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestProgressUpdateNotifyOuterClass.internal_static_QuestProgressUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestProgressUpdateNotifyOuterClass.internal_static_QuestProgressUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestProgressUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestProgressUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.questId_ = 0;
                this.failProgressList_ = QuestProgressUpdateNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.finishProgressList_ = QuestProgressUpdateNotify.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestProgressUpdateNotifyOuterClass.internal_static_QuestProgressUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestProgressUpdateNotify getDefaultInstanceForType() {
                return QuestProgressUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestProgressUpdateNotify build() {
                QuestProgressUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestProgressUpdateNotify buildPartial() {
                QuestProgressUpdateNotify result = new QuestProgressUpdateNotify(this);
                int i = this.bitField0_;
                result.questId_ = this.questId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.failProgressList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.failProgressList_ = this.failProgressList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.finishProgressList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.finishProgressList_ = this.finishProgressList_;
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
                if (other instanceof QuestProgressUpdateNotify) {
                    return mergeFrom((QuestProgressUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestProgressUpdateNotify other) {
                if (other == QuestProgressUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
                }
                if (!other.failProgressList_.isEmpty()) {
                    if (this.failProgressList_.isEmpty()) {
                        this.failProgressList_ = other.failProgressList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFailProgressListIsMutable();
                        this.failProgressList_.addAll(other.failProgressList_);
                    }
                    onChanged();
                }
                if (!other.finishProgressList_.isEmpty()) {
                    if (this.finishProgressList_.isEmpty()) {
                        this.finishProgressList_ = other.finishProgressList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureFinishProgressListIsMutable();
                        this.finishProgressList_.addAll(other.finishProgressList_);
                    }
                    onChanged();
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
                QuestProgressUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestProgressUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestProgressUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
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

            private void ensureFailProgressListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.failProgressList_ = QuestProgressUpdateNotify.mutableCopy(this.failProgressList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
            public List<Integer> getFailProgressListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.failProgressList_) : this.failProgressList_;
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
            public int getFailProgressListCount() {
                return this.failProgressList_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
            public int getFailProgressList(int index) {
                return this.failProgressList_.getInt(index);
            }

            public Builder setFailProgressList(int index, int value) {
                ensureFailProgressListIsMutable();
                this.failProgressList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFailProgressList(int value) {
                ensureFailProgressListIsMutable();
                this.failProgressList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFailProgressList(Iterable<? extends Integer> values) {
                ensureFailProgressListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.failProgressList_);
                onChanged();
                return this;
            }

            public Builder clearFailProgressList() {
                this.failProgressList_ = QuestProgressUpdateNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureFinishProgressListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.finishProgressList_ = QuestProgressUpdateNotify.mutableCopy(this.finishProgressList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
            public List<Integer> getFinishProgressListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.finishProgressList_) : this.finishProgressList_;
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
            public int getFinishProgressListCount() {
                return this.finishProgressList_.size();
            }

            @Override // emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotifyOrBuilder
            public int getFinishProgressList(int index) {
                return this.finishProgressList_.getInt(index);
            }

            public Builder setFinishProgressList(int index, int value) {
                ensureFinishProgressListIsMutable();
                this.finishProgressList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishProgressList(int value) {
                ensureFinishProgressListIsMutable();
                this.finishProgressList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishProgressList(Iterable<? extends Integer> values) {
                ensureFinishProgressListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishProgressList_);
                onChanged();
                return this;
            }

            public Builder clearFinishProgressList() {
                this.finishProgressList_ = QuestProgressUpdateNotify.emptyIntList();
                this.bitField0_ &= -3;
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

        public static QuestProgressUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestProgressUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestProgressUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestProgressUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
