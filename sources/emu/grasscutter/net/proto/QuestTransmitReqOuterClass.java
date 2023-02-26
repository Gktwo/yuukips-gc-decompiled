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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestTransmitReqOuterClass.class */
public final class QuestTransmitReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016QuestTransmitReq.proto\"4\n\u0010QuestTransmitReq\u0012\u000f\n\u0007questId\u0018\n \u0001(\r\u0012\u000f\n\u0007pointId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestTransmitReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestTransmitReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestTransmitReq_descriptor, new String[]{"QuestId", "PointId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestTransmitReqOuterClass$QuestTransmitReqOrBuilder.class */
    public interface QuestTransmitReqOrBuilder extends MessageOrBuilder {
        int getQuestId();

        int getPointId();
    }

    private QuestTransmitReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestTransmitReqOuterClass$QuestTransmitReq.class */
    public static final class QuestTransmitReq extends GeneratedMessageV3 implements QuestTransmitReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUESTID_FIELD_NUMBER = 10;
        private int questId_;
        public static final int POINTID_FIELD_NUMBER = 3;
        private int pointId_;
        private byte memoizedIsInitialized;
        private static final QuestTransmitReq DEFAULT_INSTANCE = new QuestTransmitReq();
        private static final Parser<QuestTransmitReq> PARSER = new AbstractParser<QuestTransmitReq>() { // from class: emu.grasscutter.net.proto.QuestTransmitReqOuterClass.QuestTransmitReq.1
            @Override // com.google.protobuf.Parser
            public QuestTransmitReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestTransmitReq(input, extensionRegistry);
            }
        };

        private QuestTransmitReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestTransmitReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestTransmitReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestTransmitReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 24:
                                this.pointId_ = input.readUInt32();
                                break;
                            case 80:
                                this.questId_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestTransmitReqOuterClass.internal_static_QuestTransmitReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestTransmitReqOuterClass.internal_static_QuestTransmitReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestTransmitReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestTransmitReqOuterClass.QuestTransmitReqOrBuilder
        public int getQuestId() {
            return this.questId_;
        }

        @Override // emu.grasscutter.net.proto.QuestTransmitReqOuterClass.QuestTransmitReqOrBuilder
        public int getPointId() {
            return this.pointId_;
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
            if (this.pointId_ != 0) {
                output.writeUInt32(3, this.pointId_);
            }
            if (this.questId_ != 0) {
                output.writeUInt32(10, this.questId_);
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
            if (this.pointId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.pointId_);
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.questId_);
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
            if (!(obj instanceof QuestTransmitReq)) {
                return equals(obj);
            }
            QuestTransmitReq other = (QuestTransmitReq) obj;
            return getQuestId() == other.getQuestId() && getPointId() == other.getPointId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getQuestId())) + 3)) + getPointId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QuestTransmitReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestTransmitReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestTransmitReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestTransmitReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestTransmitReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestTransmitReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestTransmitReq parseFrom(InputStream input) throws IOException {
            return (QuestTransmitReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestTransmitReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestTransmitReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestTransmitReq parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestTransmitReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestTransmitReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestTransmitReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestTransmitReq parseFrom(CodedInputStream input) throws IOException {
            return (QuestTransmitReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestTransmitReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestTransmitReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestTransmitReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestTransmitReqOuterClass$QuestTransmitReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestTransmitReqOrBuilder {
            private int questId_;
            private int pointId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestTransmitReqOuterClass.internal_static_QuestTransmitReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestTransmitReqOuterClass.internal_static_QuestTransmitReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestTransmitReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestTransmitReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.questId_ = 0;
                this.pointId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestTransmitReqOuterClass.internal_static_QuestTransmitReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestTransmitReq getDefaultInstanceForType() {
                return QuestTransmitReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestTransmitReq build() {
                QuestTransmitReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestTransmitReq buildPartial() {
                QuestTransmitReq result = new QuestTransmitReq(this);
                result.questId_ = this.questId_;
                result.pointId_ = this.pointId_;
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
                if (other instanceof QuestTransmitReq) {
                    return mergeFrom((QuestTransmitReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestTransmitReq other) {
                if (other == QuestTransmitReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
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
                QuestTransmitReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestTransmitReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestTransmitReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestTransmitReqOuterClass.QuestTransmitReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestTransmitReqOuterClass.QuestTransmitReqOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
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

        public static QuestTransmitReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestTransmitReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestTransmitReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestTransmitReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
