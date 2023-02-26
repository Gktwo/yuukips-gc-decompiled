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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarOuterClass.class */
public final class QuestGlobalVarOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014QuestGlobalVar.proto\",\n\u000eQuestGlobalVar\u0012\r\n\u0005value\u0018\u000e \u0001(\u0005\u0012\u000b\n\u0003key\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestGlobalVar_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestGlobalVar_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestGlobalVar_descriptor, new String[]{"Value", "Key"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarOuterClass$QuestGlobalVarOrBuilder.class */
    public interface QuestGlobalVarOrBuilder extends MessageOrBuilder {
        int getValue();

        int getKey();
    }

    private QuestGlobalVarOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarOuterClass$QuestGlobalVar.class */
    public static final class QuestGlobalVar extends GeneratedMessageV3 implements QuestGlobalVarOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VALUE_FIELD_NUMBER = 14;
        private int value_;
        public static final int KEY_FIELD_NUMBER = 9;
        private int key_;
        private byte memoizedIsInitialized;
        private static final QuestGlobalVar DEFAULT_INSTANCE = new QuestGlobalVar();
        private static final Parser<QuestGlobalVar> PARSER = new AbstractParser<QuestGlobalVar>() { // from class: emu.grasscutter.net.proto.QuestGlobalVarOuterClass.QuestGlobalVar.1
            @Override // com.google.protobuf.Parser
            public QuestGlobalVar parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestGlobalVar(input, extensionRegistry);
            }
        };

        private QuestGlobalVar(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestGlobalVar() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestGlobalVar();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestGlobalVar(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 72:
                                this.key_ = input.readUInt32();
                                break;
                            case 112:
                                this.value_ = input.readInt32();
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
            return QuestGlobalVarOuterClass.internal_static_QuestGlobalVar_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestGlobalVarOuterClass.internal_static_QuestGlobalVar_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestGlobalVar.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder
        public int getValue() {
            return this.value_;
        }

        @Override // emu.grasscutter.net.proto.QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder
        public int getKey() {
            return this.key_;
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
            if (this.key_ != 0) {
                output.writeUInt32(9, this.key_);
            }
            if (this.value_ != 0) {
                output.writeInt32(14, this.value_);
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
            if (this.key_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.key_);
            }
            if (this.value_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.value_);
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
            if (!(obj instanceof QuestGlobalVar)) {
                return equals(obj);
            }
            QuestGlobalVar other = (QuestGlobalVar) obj;
            return getValue() == other.getValue() && getKey() == other.getKey() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getValue())) + 9)) + getKey())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QuestGlobalVar parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestGlobalVar parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestGlobalVar parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestGlobalVar parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestGlobalVar parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestGlobalVar parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestGlobalVar parseFrom(InputStream input) throws IOException {
            return (QuestGlobalVar) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestGlobalVar parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestGlobalVar) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestGlobalVar parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestGlobalVar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestGlobalVar parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestGlobalVar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestGlobalVar parseFrom(CodedInputStream input) throws IOException {
            return (QuestGlobalVar) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestGlobalVar parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestGlobalVar) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestGlobalVar prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestGlobalVarOuterClass$QuestGlobalVar$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestGlobalVarOrBuilder {
            private int value_;
            private int key_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestGlobalVarOuterClass.internal_static_QuestGlobalVar_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestGlobalVarOuterClass.internal_static_QuestGlobalVar_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestGlobalVar.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestGlobalVar.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.value_ = 0;
                this.key_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestGlobalVarOuterClass.internal_static_QuestGlobalVar_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestGlobalVar getDefaultInstanceForType() {
                return QuestGlobalVar.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestGlobalVar build() {
                QuestGlobalVar result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestGlobalVar buildPartial() {
                QuestGlobalVar result = new QuestGlobalVar(this);
                result.value_ = this.value_;
                result.key_ = this.key_;
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
                if (other instanceof QuestGlobalVar) {
                    return mergeFrom((QuestGlobalVar) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestGlobalVar other) {
                if (other == QuestGlobalVar.getDefaultInstance()) {
                    return this;
                }
                if (other.getValue() != 0) {
                    setValue(other.getValue());
                }
                if (other.getKey() != 0) {
                    setKey(other.getKey());
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
                QuestGlobalVar parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestGlobalVar.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestGlobalVar) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder
            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int value) {
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.value_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestGlobalVarOuterClass.QuestGlobalVarOrBuilder
            public int getKey() {
                return this.key_;
            }

            public Builder setKey(int value) {
                this.key_ = value;
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.key_ = 0;
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

        public static QuestGlobalVar getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestGlobalVar> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestGlobalVar> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestGlobalVar getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
