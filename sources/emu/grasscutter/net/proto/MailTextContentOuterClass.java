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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailTextContentOuterClass.class */
public final class MailTextContentOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015MailTextContent.proto\"A\n\u000fMailTextContent\u0012\r\n\u0005title\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007content\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006sender\u0018\u0003 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MailTextContent_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MailTextContent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MailTextContent_descriptor, new String[]{"Title", "Content", "Sender"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailTextContentOuterClass$MailTextContentOrBuilder.class */
    public interface MailTextContentOrBuilder extends MessageOrBuilder {
        String getTitle();

        ByteString getTitleBytes();

        String getContent();

        ByteString getContentBytes();

        String getSender();

        ByteString getSenderBytes();
    }

    private MailTextContentOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailTextContentOuterClass$MailTextContent.class */
    public static final class MailTextContent extends GeneratedMessageV3 implements MailTextContentOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TITLE_FIELD_NUMBER = 1;
        private volatile Object title_;
        public static final int CONTENT_FIELD_NUMBER = 2;
        private volatile Object content_;
        public static final int SENDER_FIELD_NUMBER = 3;
        private volatile Object sender_;
        private byte memoizedIsInitialized;
        private static final MailTextContent DEFAULT_INSTANCE = new MailTextContent();
        private static final Parser<MailTextContent> PARSER = new AbstractParser<MailTextContent>() { // from class: emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContent.1
            @Override // com.google.protobuf.Parser
            public MailTextContent parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailTextContent(input, extensionRegistry);
            }
        };

        private MailTextContent(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MailTextContent() {
            this.memoizedIsInitialized = -1;
            this.title_ = "";
            this.content_ = "";
            this.sender_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MailTextContent();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MailTextContent(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.title_ = input.readStringRequireUtf8();
                                break;
                            case 18:
                                this.content_ = input.readStringRequireUtf8();
                                break;
                            case 26:
                                this.sender_ = input.readStringRequireUtf8();
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
            return MailTextContentOuterClass.internal_static_MailTextContent_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailTextContentOuterClass.internal_static_MailTextContent_fieldAccessorTable.ensureFieldAccessorsInitialized(MailTextContent.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
        public String getTitle() {
            Object ref = this.title_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.title_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
        public ByteString getTitleBytes() {
            Object ref = this.title_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.title_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
        public String getContent() {
            Object ref = this.content_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.content_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
        public ByteString getContentBytes() {
            Object ref = this.content_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.content_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
        public String getSender() {
            Object ref = this.sender_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.sender_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
        public ByteString getSenderBytes() {
            Object ref = this.sender_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.sender_ = b;
            return b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
                GeneratedMessageV3.writeString(output, 1, this.title_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
                GeneratedMessageV3.writeString(output, 2, this.content_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sender_)) {
                GeneratedMessageV3.writeString(output, 3, this.sender_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.title_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.content_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sender_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.sender_);
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
            if (!(obj instanceof MailTextContent)) {
                return equals(obj);
            }
            MailTextContent other = (MailTextContent) obj;
            return getTitle().equals(other.getTitle()) && getContent().equals(other.getContent()) && getSender().equals(other.getSender()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getTitle().hashCode())) + 2)) + getContent().hashCode())) + 3)) + getSender().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MailTextContent parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailTextContent parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailTextContent parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailTextContent parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailTextContent parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailTextContent parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailTextContent parseFrom(InputStream input) throws IOException {
            return (MailTextContent) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailTextContent parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailTextContent) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailTextContent parseDelimitedFrom(InputStream input) throws IOException {
            return (MailTextContent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MailTextContent parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailTextContent) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailTextContent parseFrom(CodedInputStream input) throws IOException {
            return (MailTextContent) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailTextContent parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailTextContent) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MailTextContent prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailTextContentOuterClass$MailTextContent$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MailTextContentOrBuilder {
            private Object title_ = "";
            private Object content_ = "";
            private Object sender_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return MailTextContentOuterClass.internal_static_MailTextContent_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailTextContentOuterClass.internal_static_MailTextContent_fieldAccessorTable.ensureFieldAccessorsInitialized(MailTextContent.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailTextContent.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.title_ = "";
                this.content_ = "";
                this.sender_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MailTextContentOuterClass.internal_static_MailTextContent_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MailTextContent getDefaultInstanceForType() {
                return MailTextContent.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailTextContent build() {
                MailTextContent result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailTextContent buildPartial() {
                MailTextContent result = new MailTextContent(this);
                result.title_ = this.title_;
                result.content_ = this.content_;
                result.sender_ = this.sender_;
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
                if (other instanceof MailTextContent) {
                    return mergeFrom((MailTextContent) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailTextContent other) {
                if (other == MailTextContent.getDefaultInstance()) {
                    return this;
                }
                if (!other.getTitle().isEmpty()) {
                    this.title_ = other.title_;
                    onChanged();
                }
                if (!other.getContent().isEmpty()) {
                    this.content_ = other.content_;
                    onChanged();
                }
                if (!other.getSender().isEmpty()) {
                    this.sender_ = other.sender_;
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
                MailTextContent parsedMessage = null;
                try {
                    try {
                        parsedMessage = MailTextContent.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MailTextContent) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
            public String getTitle() {
                Object ref = this.title_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.title_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
            public ByteString getTitleBytes() {
                Object ref = this.title_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.title_ = b;
                return b;
            }

            public Builder setTitle(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.title_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = MailTextContent.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                MailTextContent.checkByteStringIsUtf8(value);
                this.title_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
            public String getContent() {
                Object ref = this.content_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.content_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
            public ByteString getContentBytes() {
                Object ref = this.content_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.content_ = b;
                return b;
            }

            public Builder setContent(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.content_ = value;
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = MailTextContent.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                MailTextContent.checkByteStringIsUtf8(value);
                this.content_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
            public String getSender() {
                Object ref = this.sender_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.sender_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.MailTextContentOuterClass.MailTextContentOrBuilder
            public ByteString getSenderBytes() {
                Object ref = this.sender_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sender_ = b;
                return b;
            }

            public Builder setSender(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.sender_ = value;
                onChanged();
                return this;
            }

            public Builder clearSender() {
                this.sender_ = MailTextContent.getDefaultInstance().getSender();
                onChanged();
                return this;
            }

            public Builder setSenderBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                MailTextContent.checkByteStringIsUtf8(value);
                this.sender_ = value;
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

        public static MailTextContent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MailTextContent> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MailTextContent> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MailTextContent getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
