package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarRspOuterClass.class */
public final class QuestUpdateQuestVarRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cQuestUpdateQuestVarRsp.proto\"l\n\u0016QuestUpdateQuestVarRsp\u0012\u000f\n\u0007retcode\u0018\u0002 \u0001(\u0005\u0012\u0019\n\u0011parentQuestVarSeq\u0018\u000f \u0001(\r\u0012\u0015\n\rparentQuestId\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007questId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestUpdateQuestVarRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestUpdateQuestVarRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestUpdateQuestVarRsp_descriptor, new String[]{"Retcode", "ParentQuestVarSeq", "ParentQuestId", "QuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarRspOuterClass$QuestUpdateQuestVarRspOrBuilder.class */
    public interface QuestUpdateQuestVarRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getParentQuestVarSeq();

        int getParentQuestId();

        int getQuestId();
    }

    private QuestUpdateQuestVarRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarRspOuterClass$QuestUpdateQuestVarRsp.class */
    public static final class QuestUpdateQuestVarRsp extends GeneratedMessageV3 implements QuestUpdateQuestVarRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 2;
        private int retcode_;
        public static final int PARENTQUESTVARSEQ_FIELD_NUMBER = 15;
        private int parentQuestVarSeq_;
        public static final int PARENTQUESTID_FIELD_NUMBER = 4;
        private int parentQuestId_;
        public static final int QUESTID_FIELD_NUMBER = 9;
        private int questId_;
        private byte memoizedIsInitialized;
        private static final QuestUpdateQuestVarRsp DEFAULT_INSTANCE = new QuestUpdateQuestVarRsp();
        private static final Parser<QuestUpdateQuestVarRsp> PARSER = new AbstractParser<QuestUpdateQuestVarRsp>() { // from class: emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRsp.1
            @Override // com.google.protobuf.Parser
            public QuestUpdateQuestVarRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestUpdateQuestVarRsp(input, extensionRegistry);
            }
        };

        private QuestUpdateQuestVarRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestUpdateQuestVarRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestUpdateQuestVarRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestUpdateQuestVarRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                case 16:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 32:
                                    this.parentQuestId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.questId_ = input.readUInt32();
                                    break;
                                case 120:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestUpdateQuestVarRspOuterClass.internal_static_QuestUpdateQuestVarRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestUpdateQuestVarRspOuterClass.internal_static_QuestUpdateQuestVarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestVarRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
        public int getParentQuestVarSeq() {
            return this.parentQuestVarSeq_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
        public int getQuestId() {
            return this.questId_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(2, this.retcode_);
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(4, this.parentQuestId_);
            }
            if (this.questId_ != 0) {
                output.writeUInt32(9, this.questId_);
            }
            if (this.parentQuestVarSeq_ != 0) {
                output.writeUInt32(15, this.parentQuestVarSeq_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(2, this.retcode_);
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.parentQuestId_);
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.questId_);
            }
            if (this.parentQuestVarSeq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.parentQuestVarSeq_);
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
            if (!(obj instanceof QuestUpdateQuestVarRsp)) {
                return equals(obj);
            }
            QuestUpdateQuestVarRsp other = (QuestUpdateQuestVarRsp) obj;
            return getRetcode() == other.getRetcode() && getParentQuestVarSeq() == other.getParentQuestVarSeq() && getParentQuestId() == other.getParentQuestId() && getQuestId() == other.getQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getRetcode())) + 15)) + getParentQuestVarSeq())) + 4)) + getParentQuestId())) + 9)) + getQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QuestUpdateQuestVarRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestUpdateQuestVarRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestUpdateQuestVarRsp parseFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestVarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestVarRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestUpdateQuestVarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestUpdateQuestVarRsp parseFrom(CodedInputStream input) throws IOException {
            return (QuestUpdateQuestVarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestUpdateQuestVarRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestUpdateQuestVarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestUpdateQuestVarRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestUpdateQuestVarRspOuterClass$QuestUpdateQuestVarRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestUpdateQuestVarRspOrBuilder {
            private int retcode_;
            private int parentQuestVarSeq_;
            private int parentQuestId_;
            private int questId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestUpdateQuestVarRspOuterClass.internal_static_QuestUpdateQuestVarRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestUpdateQuestVarRspOuterClass.internal_static_QuestUpdateQuestVarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestUpdateQuestVarRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestUpdateQuestVarRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.parentQuestVarSeq_ = 0;
                this.parentQuestId_ = 0;
                this.questId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestUpdateQuestVarRspOuterClass.internal_static_QuestUpdateQuestVarRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestUpdateQuestVarRsp getDefaultInstanceForType() {
                return QuestUpdateQuestVarRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestVarRsp build() {
                QuestUpdateQuestVarRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestUpdateQuestVarRsp buildPartial() {
                QuestUpdateQuestVarRsp result = new QuestUpdateQuestVarRsp(this);
                result.retcode_ = this.retcode_;
                result.parentQuestVarSeq_ = this.parentQuestVarSeq_;
                result.parentQuestId_ = this.parentQuestId_;
                result.questId_ = this.questId_;
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
                if (other instanceof QuestUpdateQuestVarRsp) {
                    return mergeFrom((QuestUpdateQuestVarRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestUpdateQuestVarRsp other) {
                if (other == QuestUpdateQuestVarRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getParentQuestVarSeq() != 0) {
                    setParentQuestVarSeq(other.getParentQuestVarSeq());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
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
                QuestUpdateQuestVarRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestUpdateQuestVarRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestUpdateQuestVarRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestUpdateQuestVarRspOuterClass.QuestUpdateQuestVarRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static QuestUpdateQuestVarRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestUpdateQuestVarRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestUpdateQuestVarRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestUpdateQuestVarRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
