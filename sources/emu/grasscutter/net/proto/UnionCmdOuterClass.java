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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdOuterClass.class */
public final class UnionCmdOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eUnionCmd.proto\"+\n\bUnionCmd\u0012\u0011\n\tmessageId\u0018\u0003 \u0001(\r\u0012\f\n\u0004body\u0018\u0005 \u0001(\fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UnionCmd_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UnionCmd_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UnionCmd_descriptor, new String[]{"MessageId", "Body"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdOuterClass$UnionCmdOrBuilder.class */
    public interface UnionCmdOrBuilder extends MessageOrBuilder {
        int getMessageId();

        ByteString getBody();
    }

    private UnionCmdOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdOuterClass$UnionCmd.class */
    public static final class UnionCmd extends GeneratedMessageV3 implements UnionCmdOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MESSAGEID_FIELD_NUMBER = 3;
        private int messageId_;
        public static final int BODY_FIELD_NUMBER = 5;
        private ByteString body_;
        private byte memoizedIsInitialized;
        private static final UnionCmd DEFAULT_INSTANCE = new UnionCmd();
        private static final Parser<UnionCmd> PARSER = new AbstractParser<UnionCmd>() { // from class: emu.grasscutter.net.proto.UnionCmdOuterClass.UnionCmd.1
            @Override // com.google.protobuf.Parser
            public UnionCmd parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UnionCmd(input, extensionRegistry);
            }
        };

        private UnionCmd(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UnionCmd() {
            this.memoizedIsInitialized = -1;
            this.body_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UnionCmd();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UnionCmd(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.messageId_ = input.readUInt32();
                                break;
                            case 42:
                                this.body_ = input.readBytes();
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
            return UnionCmdOuterClass.internal_static_UnionCmd_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UnionCmdOuterClass.internal_static_UnionCmd_fieldAccessorTable.ensureFieldAccessorsInitialized(UnionCmd.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UnionCmdOuterClass.UnionCmdOrBuilder
        public int getMessageId() {
            return this.messageId_;
        }

        @Override // emu.grasscutter.net.proto.UnionCmdOuterClass.UnionCmdOrBuilder
        public ByteString getBody() {
            return this.body_;
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
            if (this.messageId_ != 0) {
                output.writeUInt32(3, this.messageId_);
            }
            if (!this.body_.isEmpty()) {
                output.writeBytes(5, this.body_);
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
            if (this.messageId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.messageId_);
            }
            if (!this.body_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(5, this.body_);
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
            if (!(obj instanceof UnionCmd)) {
                return equals(obj);
            }
            UnionCmd other = (UnionCmd) obj;
            return getMessageId() == other.getMessageId() && getBody().equals(other.getBody()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getMessageId())) + 5)) + getBody().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static UnionCmd parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnionCmd parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnionCmd parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnionCmd parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnionCmd parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnionCmd parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnionCmd parseFrom(InputStream input) throws IOException {
            return (UnionCmd) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnionCmd parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnionCmd) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnionCmd parseDelimitedFrom(InputStream input) throws IOException {
            return (UnionCmd) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UnionCmd parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnionCmd) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnionCmd parseFrom(CodedInputStream input) throws IOException {
            return (UnionCmd) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnionCmd parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnionCmd) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnionCmd prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdOuterClass$UnionCmd$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UnionCmdOrBuilder {
            private int messageId_;
            private ByteString body_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return UnionCmdOuterClass.internal_static_UnionCmd_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UnionCmdOuterClass.internal_static_UnionCmd_fieldAccessorTable.ensureFieldAccessorsInitialized(UnionCmd.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UnionCmd.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.messageId_ = 0;
                this.body_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UnionCmdOuterClass.internal_static_UnionCmd_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UnionCmd getDefaultInstanceForType() {
                return UnionCmd.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnionCmd build() {
                UnionCmd result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnionCmd buildPartial() {
                UnionCmd result = new UnionCmd(this);
                result.messageId_ = this.messageId_;
                result.body_ = this.body_;
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
                if (other instanceof UnionCmd) {
                    return mergeFrom((UnionCmd) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UnionCmd other) {
                if (other == UnionCmd.getDefaultInstance()) {
                    return this;
                }
                if (other.getMessageId() != 0) {
                    setMessageId(other.getMessageId());
                }
                if (other.getBody() != ByteString.EMPTY) {
                    setBody(other.getBody());
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
                UnionCmd parsedMessage = null;
                try {
                    try {
                        parsedMessage = UnionCmd.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UnionCmd) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UnionCmdOuterClass.UnionCmdOrBuilder
            public int getMessageId() {
                return this.messageId_;
            }

            public Builder setMessageId(int value) {
                this.messageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMessageId() {
                this.messageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnionCmdOuterClass.UnionCmdOrBuilder
            public ByteString getBody() {
                return this.body_;
            }

            public Builder setBody(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.body_ = value;
                onChanged();
                return this;
            }

            public Builder clearBody() {
                this.body_ = UnionCmd.getDefaultInstance().getBody();
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

        public static UnionCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnionCmd> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UnionCmd> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnionCmd getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
