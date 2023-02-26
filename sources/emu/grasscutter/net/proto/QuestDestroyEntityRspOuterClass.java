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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestDestroyEntityRspOuterClass.class */
public final class QuestDestroyEntityRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bQuestDestroyEntityRsp.proto\"\\\n\u0015QuestDestroyEntityRsp\u0012\u0010\n\bentityId\u0018\t \u0001(\r\u0012\u000f\n\u0007sceneId\u0018\u000f \u0001(\r\u0012\u000f\n\u0007retcode\u0018\b \u0001(\u0005\u0012\u000f\n\u0007questId\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestDestroyEntityRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestDestroyEntityRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestDestroyEntityRsp_descriptor, new String[]{"EntityId", "SceneId", "Retcode", "QuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestDestroyEntityRspOuterClass$QuestDestroyEntityRspOrBuilder.class */
    public interface QuestDestroyEntityRspOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getSceneId();

        int getRetcode();

        int getQuestId();
    }

    private QuestDestroyEntityRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestDestroyEntityRspOuterClass$QuestDestroyEntityRsp.class */
    public static final class QuestDestroyEntityRsp extends GeneratedMessageV3 implements QuestDestroyEntityRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 9;
        private int entityId_;
        public static final int SCENEID_FIELD_NUMBER = 15;
        private int sceneId_;
        public static final int RETCODE_FIELD_NUMBER = 8;
        private int retcode_;
        public static final int QUESTID_FIELD_NUMBER = 13;
        private int questId_;
        private byte memoizedIsInitialized;
        private static final QuestDestroyEntityRsp DEFAULT_INSTANCE = new QuestDestroyEntityRsp();
        private static final Parser<QuestDestroyEntityRsp> PARSER = new AbstractParser<QuestDestroyEntityRsp>() { // from class: emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRsp.1
            @Override // com.google.protobuf.Parser
            public QuestDestroyEntityRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestDestroyEntityRsp(input, extensionRegistry);
            }
        };

        private QuestDestroyEntityRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestDestroyEntityRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestDestroyEntityRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestDestroyEntityRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 72:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.questId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.sceneId_ = input.readUInt32();
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
            return QuestDestroyEntityRspOuterClass.internal_static_QuestDestroyEntityRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestDestroyEntityRspOuterClass.internal_static_QuestDestroyEntityRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestDestroyEntityRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
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
                output.writeInt32(8, this.retcode_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(9, this.entityId_);
            }
            if (this.questId_ != 0) {
                output.writeUInt32(13, this.questId_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(15, this.sceneId_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(8, this.retcode_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.entityId_);
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.questId_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.sceneId_);
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
            if (!(obj instanceof QuestDestroyEntityRsp)) {
                return equals(obj);
            }
            QuestDestroyEntityRsp other = (QuestDestroyEntityRsp) obj;
            return getEntityId() == other.getEntityId() && getSceneId() == other.getSceneId() && getRetcode() == other.getRetcode() && getQuestId() == other.getQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getEntityId())) + 15)) + getSceneId())) + 8)) + getRetcode())) + 13)) + getQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QuestDestroyEntityRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestDestroyEntityRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestDestroyEntityRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestDestroyEntityRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestDestroyEntityRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestDestroyEntityRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestDestroyEntityRsp parseFrom(InputStream input) throws IOException {
            return (QuestDestroyEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestDestroyEntityRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestDestroyEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestDestroyEntityRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestDestroyEntityRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestDestroyEntityRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestDestroyEntityRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestDestroyEntityRsp parseFrom(CodedInputStream input) throws IOException {
            return (QuestDestroyEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestDestroyEntityRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestDestroyEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestDestroyEntityRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestDestroyEntityRspOuterClass$QuestDestroyEntityRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestDestroyEntityRspOrBuilder {
            private int entityId_;
            private int sceneId_;
            private int retcode_;
            private int questId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestDestroyEntityRspOuterClass.internal_static_QuestDestroyEntityRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestDestroyEntityRspOuterClass.internal_static_QuestDestroyEntityRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestDestroyEntityRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestDestroyEntityRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.sceneId_ = 0;
                this.retcode_ = 0;
                this.questId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestDestroyEntityRspOuterClass.internal_static_QuestDestroyEntityRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestDestroyEntityRsp getDefaultInstanceForType() {
                return QuestDestroyEntityRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestDestroyEntityRsp build() {
                QuestDestroyEntityRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestDestroyEntityRsp buildPartial() {
                QuestDestroyEntityRsp result = new QuestDestroyEntityRsp(this);
                result.entityId_ = this.entityId_;
                result.sceneId_ = this.sceneId_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof QuestDestroyEntityRsp) {
                    return mergeFrom((QuestDestroyEntityRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestDestroyEntityRsp other) {
                if (other == QuestDestroyEntityRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                QuestDestroyEntityRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestDestroyEntityRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestDestroyEntityRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestDestroyEntityRspOuterClass.QuestDestroyEntityRspOrBuilder
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

        public static QuestDestroyEntityRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestDestroyEntityRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestDestroyEntityRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestDestroyEntityRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
