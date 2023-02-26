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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestVarOpOuterClass.class */
public final class QuestVarOpOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010QuestVarOp.proto\"9\n\nQuestVarOp\u0012\r\n\u0005index\u0018\u000e \u0001(\r\u0012\r\n\u0005value\u0018\u0006 \u0001(\u0005\u0012\r\n\u0005isAdd\u0018\u0005 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_QuestVarOp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_QuestVarOp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_QuestVarOp_descriptor, new String[]{"Index", "Value", "IsAdd"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestVarOpOuterClass$QuestVarOpOrBuilder.class */
    public interface QuestVarOpOrBuilder extends MessageOrBuilder {
        int getIndex();

        int getValue();

        boolean getIsAdd();
    }

    private QuestVarOpOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestVarOpOuterClass$QuestVarOp.class */
    public static final class QuestVarOp extends GeneratedMessageV3 implements QuestVarOpOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INDEX_FIELD_NUMBER = 14;
        private int index_;
        public static final int VALUE_FIELD_NUMBER = 6;
        private int value_;
        public static final int ISADD_FIELD_NUMBER = 5;
        private boolean isAdd_;
        private byte memoizedIsInitialized;
        private static final QuestVarOp DEFAULT_INSTANCE = new QuestVarOp();
        private static final Parser<QuestVarOp> PARSER = new AbstractParser<QuestVarOp>() { // from class: emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOp.1
            @Override // com.google.protobuf.Parser
            public QuestVarOp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new QuestVarOp(input, extensionRegistry);
            }
        };

        private QuestVarOp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private QuestVarOp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new QuestVarOp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private QuestVarOp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.isAdd_ = input.readBool();
                                    break;
                                case 48:
                                    this.value_ = input.readInt32();
                                    break;
                                case 112:
                                    this.index_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return QuestVarOpOuterClass.internal_static_QuestVarOp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return QuestVarOpOuterClass.internal_static_QuestVarOp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestVarOp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOpOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOpOrBuilder
        public int getValue() {
            return this.value_;
        }

        @Override // emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOpOrBuilder
        public boolean getIsAdd() {
            return this.isAdd_;
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
            if (this.isAdd_) {
                output.writeBool(5, this.isAdd_);
            }
            if (this.value_ != 0) {
                output.writeInt32(6, this.value_);
            }
            if (this.index_ != 0) {
                output.writeUInt32(14, this.index_);
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
            if (this.isAdd_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(5, this.isAdd_);
            }
            if (this.value_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.value_);
            }
            if (this.index_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.index_);
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
            if (!(obj instanceof QuestVarOp)) {
                return equals(obj);
            }
            QuestVarOp other = (QuestVarOp) obj;
            return getIndex() == other.getIndex() && getValue() == other.getValue() && getIsAdd() == other.getIsAdd() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getIndex())) + 6)) + getValue())) + 5)) + Internal.hashBoolean(getIsAdd()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static QuestVarOp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestVarOp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestVarOp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestVarOp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestVarOp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static QuestVarOp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static QuestVarOp parseFrom(InputStream input) throws IOException {
            return (QuestVarOp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestVarOp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestVarOp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestVarOp parseDelimitedFrom(InputStream input) throws IOException {
            return (QuestVarOp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static QuestVarOp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestVarOp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static QuestVarOp parseFrom(CodedInputStream input) throws IOException {
            return (QuestVarOp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static QuestVarOp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuestVarOp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(QuestVarOp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/QuestVarOpOuterClass$QuestVarOp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuestVarOpOrBuilder {
            private int index_;
            private int value_;
            private boolean isAdd_;

            public static final Descriptors.Descriptor getDescriptor() {
                return QuestVarOpOuterClass.internal_static_QuestVarOp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return QuestVarOpOuterClass.internal_static_QuestVarOp_fieldAccessorTable.ensureFieldAccessorsInitialized(QuestVarOp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (QuestVarOp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.index_ = 0;
                this.value_ = 0;
                this.isAdd_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return QuestVarOpOuterClass.internal_static_QuestVarOp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public QuestVarOp getDefaultInstanceForType() {
                return QuestVarOp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestVarOp build() {
                QuestVarOp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public QuestVarOp buildPartial() {
                QuestVarOp result = new QuestVarOp(this);
                result.index_ = this.index_;
                result.value_ = this.value_;
                result.isAdd_ = this.isAdd_;
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
                if (other instanceof QuestVarOp) {
                    return mergeFrom((QuestVarOp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(QuestVarOp other) {
                if (other == QuestVarOp.getDefaultInstance()) {
                    return this;
                }
                if (other.getIndex() != 0) {
                    setIndex(other.getIndex());
                }
                if (other.getValue() != 0) {
                    setValue(other.getValue());
                }
                if (other.getIsAdd()) {
                    setIsAdd(other.getIsAdd());
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
                QuestVarOp parsedMessage = null;
                try {
                    try {
                        parsedMessage = QuestVarOp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (QuestVarOp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOpOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int value) {
                this.index_ = value;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOpOrBuilder
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

            @Override // emu.grasscutter.net.proto.QuestVarOpOuterClass.QuestVarOpOrBuilder
            public boolean getIsAdd() {
                return this.isAdd_;
            }

            public Builder setIsAdd(boolean value) {
                this.isAdd_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAdd() {
                this.isAdd_ = false;
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

        public static QuestVarOp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuestVarOp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<QuestVarOp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuestVarOp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
