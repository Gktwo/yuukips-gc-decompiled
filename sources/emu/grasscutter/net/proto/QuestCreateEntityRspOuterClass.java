package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.CreateEntityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityRspOuterClass.class */
public final class QuestCreateEntityRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aQuestCreateEntityRsp.proto\u001a\u0016CreateEntityInfo.proto\"\u0001\n\u0014QuestCreateEntityRsp\u0012!\n\u0006entity\u0018\u000b \u0001(\u000b2\u0011.CreateEntityInfo\u0012\u0011\n\tentity_id\u0018\u0003 \u0001(\r\u0012\u0011\n\tis_rewind\u0018\t \u0001(\b\u0012\u0017\n\u000fparent_quest_id\u0018\u0002 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005\u0012\u0010\n\bquest_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CreateEntityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QuestCreateEntityRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestCreateEntityRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestCreateEntityRsp_descriptor, new String[]{"Entity", "EntityId", "IsRewind", "ParentQuestId", "Retcode", "QuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityRspOuterClass$QuestCreateEntityRspOrBuilder.class */
    public interface QuestCreateEntityRspOrBuilder extends MessageOrBuilder {
        boolean hasEntity();

        CreateEntityInfoOuterClass.CreateEntityInfo getEntity();

        CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder getEntityOrBuilder();

        int getEntityId();

        boolean getIsRewind();

        int getParentQuestId();

        int getRetcode();

        int getQuestId();
    }

    private QuestCreateEntityRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityRspOuterClass$QuestCreateEntityRsp.class */
    public static final class QuestCreateEntityRsp extends GeneratedMessageV3 implements QuestCreateEntityRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_FIELD_NUMBER = 11;
        private CreateEntityInfoOuterClass.CreateEntityInfo entity_;
        public static final int ENTITY_ID_FIELD_NUMBER = 3;
        private int entityId_;
        public static final int IS_REWIND_FIELD_NUMBER = 9;
        private boolean isRewind_;
        public static final int PARENT_QUEST_ID_FIELD_NUMBER = 2;
        private int parentQuestId_;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        public static final int QUEST_ID_FIELD_NUMBER = 1;
        private int questId_;
        private byte memoizedIsInitialized;
        private static final QuestCreateEntityRsp DEFAULT_INSTANCE = new QuestCreateEntityRsp();
        private static final Parser<QuestCreateEntityRsp> PARSER = new AbstractParser<QuestCreateEntityRsp>() { // from class: emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRsp.1
            @Override // com.google.protobuf.Parser
            public QuestCreateEntityRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestCreateEntityRsp(input, extensionRegistry);
            }
        };

        private QuestCreateEntityRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestCreateEntityRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestCreateEntityRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestCreateEntityRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.questId_ = input.readUInt32();
                                break;
                            case 16:
                                this.parentQuestId_ = input.readUInt32();
                                break;
                            case 24:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 56:
                                this.retcode_ = input.readInt32();
                                break;
                            case 72:
                                this.isRewind_ = input.readBool();
                                break;
                            case 90:
                                CreateEntityInfoOuterClass.CreateEntityInfo.Builder subBuilder = this.entity_ != null ? this.entity_.toBuilder() : null;
                                this.entity_ = (CreateEntityInfoOuterClass.CreateEntityInfo) input.readMessage(CreateEntityInfoOuterClass.CreateEntityInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.entity_);
                                    this.entity_ = subBuilder.buildPartial();
                                    break;
                                }
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
            return QuestCreateEntityRspOuterClass.internal_static_QuestCreateEntityRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestCreateEntityRspOuterClass.internal_static_QuestCreateEntityRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestCreateEntityRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public boolean hasEntity() {
            return this.entity_ != null;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public CreateEntityInfoOuterClass.CreateEntityInfo getEntity() {
            return this.entity_ == null ? CreateEntityInfoOuterClass.CreateEntityInfo.getDefaultInstance() : this.entity_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder getEntityOrBuilder() {
            return getEntity();
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public boolean getIsRewind() {
            return this.isRewind_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
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
            if (this.questId_ != 0) {
                output.writeUInt32(1, this.questId_);
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(2, this.parentQuestId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(3, this.entityId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
            }
            if (this.isRewind_) {
                output.writeBool(9, this.isRewind_);
            }
            if (this.entity_ != null) {
                output.writeMessage(11, getEntity());
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
            if (this.questId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.questId_);
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.parentQuestId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.entityId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.isRewind_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isRewind_);
            }
            if (this.entity_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getEntity());
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
            if (!(obj instanceof QuestCreateEntityRsp)) {
                return equals(obj);
            }
            QuestCreateEntityRsp other = (QuestCreateEntityRsp) obj;
            if (hasEntity() != other.hasEntity()) {
                return false;
            }
            return (!hasEntity() || getEntity().equals(other.getEntity())) && getEntityId() == other.getEntityId() && getIsRewind() == other.getIsRewind() && getParentQuestId() == other.getParentQuestId() && getRetcode() == other.getRetcode() && getQuestId() == other.getQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasEntity()) {
                hash = (53 * ((37 * hash) + 11)) + getEntity().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getEntityId())) + 9)) + Internal.hashBoolean(getIsRewind()))) + 2)) + getParentQuestId())) + 7)) + getRetcode())) + 1)) + getQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestCreateEntityRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestCreateEntityRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestCreateEntityRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestCreateEntityRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestCreateEntityRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestCreateEntityRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestCreateEntityRsp parseFrom(InputStream input) throws IOException {
            return (QuestCreateEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestCreateEntityRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestCreateEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestCreateEntityRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestCreateEntityRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestCreateEntityRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestCreateEntityRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestCreateEntityRsp parseFrom(CodedInputStream input) throws IOException {
            return (QuestCreateEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestCreateEntityRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestCreateEntityRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestCreateEntityRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityRspOuterClass$QuestCreateEntityRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestCreateEntityRspOrBuilder {
            private CreateEntityInfoOuterClass.CreateEntityInfo entity_;
            private SingleFieldBuilderV3<CreateEntityInfoOuterClass.CreateEntityInfo, CreateEntityInfoOuterClass.CreateEntityInfo.Builder, CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder> entityBuilder_;
            private int entityId_;
            private boolean isRewind_;
            private int parentQuestId_;
            private int retcode_;
            private int questId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestCreateEntityRspOuterClass.internal_static_QuestCreateEntityRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestCreateEntityRspOuterClass.internal_static_QuestCreateEntityRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestCreateEntityRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestCreateEntityRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.entityBuilder_ == null) {
                    this.entity_ = null;
                } else {
                    this.entity_ = null;
                    this.entityBuilder_ = null;
                }
                this.entityId_ = 0;
                this.isRewind_ = false;
                this.parentQuestId_ = 0;
                this.retcode_ = 0;
                this.questId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestCreateEntityRspOuterClass.internal_static_QuestCreateEntityRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestCreateEntityRsp getDefaultInstanceForType() {
                return QuestCreateEntityRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestCreateEntityRsp build() {
                QuestCreateEntityRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestCreateEntityRsp buildPartial() {
                QuestCreateEntityRsp result = new QuestCreateEntityRsp(this);
                if (this.entityBuilder_ == null) {
                    result.entity_ = this.entity_;
                } else {
                    result.entity_ = this.entityBuilder_.build();
                }
                result.entityId_ = this.entityId_;
                result.isRewind_ = this.isRewind_;
                result.parentQuestId_ = this.parentQuestId_;
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
                if (other instanceof QuestCreateEntityRsp) {
                    return mergeFrom((QuestCreateEntityRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestCreateEntityRsp other) {
                if (other == QuestCreateEntityRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasEntity()) {
                    mergeEntity(other.getEntity());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getIsRewind()) {
                    setIsRewind(other.getIsRewind());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
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
                QuestCreateEntityRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestCreateEntityRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestCreateEntityRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
            public boolean hasEntity() {
                return (this.entityBuilder_ == null && this.entity_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
            public CreateEntityInfoOuterClass.CreateEntityInfo getEntity() {
                if (this.entityBuilder_ == null) {
                    return this.entity_ == null ? CreateEntityInfoOuterClass.CreateEntityInfo.getDefaultInstance() : this.entity_;
                }
                return this.entityBuilder_.getMessage();
            }

            public Builder setEntity(CreateEntityInfoOuterClass.CreateEntityInfo value) {
                if (this.entityBuilder_ != null) {
                    this.entityBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.entity_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setEntity(CreateEntityInfoOuterClass.CreateEntityInfo.Builder builderForValue) {
                if (this.entityBuilder_ == null) {
                    this.entity_ = builderForValue.build();
                    onChanged();
                } else {
                    this.entityBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeEntity(CreateEntityInfoOuterClass.CreateEntityInfo value) {
                if (this.entityBuilder_ == null) {
                    if (this.entity_ != null) {
                        this.entity_ = CreateEntityInfoOuterClass.CreateEntityInfo.newBuilder(this.entity_).mergeFrom(value).buildPartial();
                    } else {
                        this.entity_ = value;
                    }
                    onChanged();
                } else {
                    this.entityBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearEntity() {
                if (this.entityBuilder_ == null) {
                    this.entity_ = null;
                    onChanged();
                } else {
                    this.entity_ = null;
                    this.entityBuilder_ = null;
                }
                return this;
            }

            public CreateEntityInfoOuterClass.CreateEntityInfo.Builder getEntityBuilder() {
                onChanged();
                return getEntityFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
            public CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder getEntityOrBuilder() {
                if (this.entityBuilder_ != null) {
                    return this.entityBuilder_.getMessageOrBuilder();
                }
                return this.entity_ == null ? CreateEntityInfoOuterClass.CreateEntityInfo.getDefaultInstance() : this.entity_;
            }

            private SingleFieldBuilderV3<CreateEntityInfoOuterClass.CreateEntityInfo, CreateEntityInfoOuterClass.CreateEntityInfo.Builder, CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder> getEntityFieldBuilder() {
                if (this.entityBuilder_ == null) {
                    this.entityBuilder_ = new SingleFieldBuilderV3<>(getEntity(), getParentForChildren(), isClean());
                    this.entity_ = null;
                }
                return this.entityBuilder_;
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
            public boolean getIsRewind() {
                return this.isRewind_;
            }

            public Builder setIsRewind(boolean value) {
                this.isRewind_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsRewind() {
                this.isRewind_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityRspOuterClass.QuestCreateEntityRspOrBuilder
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

        public static QuestCreateEntityRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestCreateEntityRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestCreateEntityRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestCreateEntityRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CreateEntityInfoOuterClass.getDescriptor();
    }
}
