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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityReqOuterClass.class */
public final class QuestCreateEntityReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aQuestCreateEntityReq.proto\u001a\u0016CreateEntityInfo.proto\"s\n\u0014QuestCreateEntityReq\u0012\u0015\n\rparentQuestId\u0018\u0004 \u0001(\r\u0012\u0010\n\bisRewind\u0018\f \u0001(\b\u0012!\n\u0006entity\u0018\u000b \u0001(\u000b2\u0011.CreateEntityInfo\u0012\u000f\n\u0007questId\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CreateEntityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_QuestCreateEntityReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestCreateEntityReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestCreateEntityReq_descriptor, new String[]{"ParentQuestId", "IsRewind", "Entity", "QuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityReqOuterClass$QuestCreateEntityReqOrBuilder.class */
    public interface QuestCreateEntityReqOrBuilder extends MessageOrBuilder {
        int getParentQuestId();

        boolean getIsRewind();

        boolean hasEntity();

        CreateEntityInfoOuterClass.CreateEntityInfo getEntity();

        CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder getEntityOrBuilder();

        int getQuestId();
    }

    private QuestCreateEntityReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityReqOuterClass$QuestCreateEntityReq.class */
    public static final class QuestCreateEntityReq extends GeneratedMessageV3 implements QuestCreateEntityReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENTQUESTID_FIELD_NUMBER = 4;
        private int parentQuestId_;
        public static final int ISREWIND_FIELD_NUMBER = 12;
        private boolean isRewind_;
        public static final int ENTITY_FIELD_NUMBER = 11;
        private CreateEntityInfoOuterClass.CreateEntityInfo entity_;
        public static final int QUESTID_FIELD_NUMBER = 10;
        private int questId_;
        private byte memoizedIsInitialized;
        private static final QuestCreateEntityReq DEFAULT_INSTANCE = new QuestCreateEntityReq();
        private static final Parser<QuestCreateEntityReq> PARSER = new AbstractParser<QuestCreateEntityReq>() { // from class: emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReq.1
            @Override // com.google.protobuf.Parser
            public QuestCreateEntityReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestCreateEntityReq(input, extensionRegistry);
            }
        };

        private QuestCreateEntityReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestCreateEntityReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestCreateEntityReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestCreateEntityReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.parentQuestId_ = input.readUInt32();
                                break;
                            case 80:
                                this.questId_ = input.readUInt32();
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
                            case 96:
                                this.isRewind_ = input.readBool();
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
            return QuestCreateEntityReqOuterClass.internal_static_QuestCreateEntityReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestCreateEntityReqOuterClass.internal_static_QuestCreateEntityReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestCreateEntityReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
        public boolean getIsRewind() {
            return this.isRewind_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
        public boolean hasEntity() {
            return this.entity_ != null;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
        public CreateEntityInfoOuterClass.CreateEntityInfo getEntity() {
            return this.entity_ == null ? CreateEntityInfoOuterClass.CreateEntityInfo.getDefaultInstance() : this.entity_;
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
        public CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder getEntityOrBuilder() {
            return getEntity();
        }

        @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
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
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(4, this.parentQuestId_);
            }
            if (this.questId_ != 0) {
                output.writeUInt32(10, this.questId_);
            }
            if (this.entity_ != null) {
                output.writeMessage(11, getEntity());
            }
            if (this.isRewind_) {
                output.writeBool(12, this.isRewind_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.parentQuestId_);
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.questId_);
            }
            if (this.entity_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getEntity());
            }
            if (this.isRewind_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isRewind_);
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
            if (!(obj instanceof QuestCreateEntityReq)) {
                return equals(obj);
            }
            QuestCreateEntityReq other = (QuestCreateEntityReq) obj;
            if (getParentQuestId() == other.getParentQuestId() && getIsRewind() == other.getIsRewind() && hasEntity() == other.hasEntity()) {
                return (!hasEntity() || getEntity().equals(other.getEntity())) && getQuestId() == other.getQuestId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getParentQuestId())) + 12)) + Internal.hashBoolean(getIsRewind());
            if (hasEntity()) {
                hash = (53 * ((37 * hash) + 11)) + getEntity().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 10)) + getQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static QuestCreateEntityReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestCreateEntityReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestCreateEntityReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestCreateEntityReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestCreateEntityReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestCreateEntityReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestCreateEntityReq parseFrom(InputStream input) throws IOException {
            return (QuestCreateEntityReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestCreateEntityReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestCreateEntityReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestCreateEntityReq parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestCreateEntityReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestCreateEntityReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestCreateEntityReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestCreateEntityReq parseFrom(CodedInputStream input) throws IOException {
            return (QuestCreateEntityReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestCreateEntityReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestCreateEntityReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestCreateEntityReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestCreateEntityReqOuterClass$QuestCreateEntityReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestCreateEntityReqOrBuilder {
            private int parentQuestId_;
            private boolean isRewind_;
            private CreateEntityInfoOuterClass.CreateEntityInfo entity_;
            private SingleFieldBuilderV3<CreateEntityInfoOuterClass.CreateEntityInfo, CreateEntityInfoOuterClass.CreateEntityInfo.Builder, CreateEntityInfoOuterClass.CreateEntityInfoOrBuilder> entityBuilder_;
            private int questId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestCreateEntityReqOuterClass.internal_static_QuestCreateEntityReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestCreateEntityReqOuterClass.internal_static_QuestCreateEntityReq_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestCreateEntityReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestCreateEntityReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentQuestId_ = 0;
                this.isRewind_ = false;
                if (this.entityBuilder_ == null) {
                    this.entity_ = null;
                } else {
                    this.entity_ = null;
                    this.entityBuilder_ = null;
                }
                this.questId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestCreateEntityReqOuterClass.internal_static_QuestCreateEntityReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestCreateEntityReq getDefaultInstanceForType() {
                return QuestCreateEntityReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestCreateEntityReq build() {
                QuestCreateEntityReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestCreateEntityReq buildPartial() {
                QuestCreateEntityReq result = new QuestCreateEntityReq(this);
                result.parentQuestId_ = this.parentQuestId_;
                result.isRewind_ = this.isRewind_;
                if (this.entityBuilder_ == null) {
                    result.entity_ = this.entity_;
                } else {
                    result.entity_ = this.entityBuilder_.build();
                }
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
                if (other instanceof QuestCreateEntityReq) {
                    return mergeFrom((QuestCreateEntityReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestCreateEntityReq other) {
                if (other == QuestCreateEntityReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
                }
                if (other.getIsRewind()) {
                    setIsRewind(other.getIsRewind());
                }
                if (other.hasEntity()) {
                    mergeEntity(other.getEntity());
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
                QuestCreateEntityReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestCreateEntityReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestCreateEntityReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
            public boolean hasEntity() {
                return (this.entityBuilder_ == null && this.entity_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestCreateEntityReqOuterClass.QuestCreateEntityReqOrBuilder
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

        public static QuestCreateEntityReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestCreateEntityReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestCreateEntityReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestCreateEntityReq getDefaultInstanceForType() {
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
