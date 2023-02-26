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
import emu.grasscutter.net.proto.AuditStateOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ContentAuditInfoOuterClass.class */
public final class ContentAuditInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016ContentAuditInfo.proto\u001a\u0010AuditState.proto\"~\n\u0010ContentAuditInfo\u0012\u000e\n\u0006isOpen\u0018\u0001 \u0001(\b\u0012\u000f\n\u0007content\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bsubmitCount\u0018\u0003 \u0001(\r\u0012\u001f\n\nauditState\u0018\u0004 \u0001(\u000e2\u000b.AuditState\u0012\u0013\n\u000bsubmitLimit\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AuditStateOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ContentAuditInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ContentAuditInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ContentAuditInfo_descriptor, new String[]{"IsOpen", "Content", "SubmitCount", "AuditState", "SubmitLimit"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ContentAuditInfoOuterClass$ContentAuditInfoOrBuilder.class */
    public interface ContentAuditInfoOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        String getContent();

        ByteString getContentBytes();

        int getSubmitCount();

        int getAuditStateValue();

        AuditStateOuterClass.AuditState getAuditState();

        int getSubmitLimit();
    }

    private ContentAuditInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ContentAuditInfoOuterClass$ContentAuditInfo.class */
    public static final class ContentAuditInfo extends GeneratedMessageV3 implements ContentAuditInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISOPEN_FIELD_NUMBER = 1;
        private boolean isOpen_;
        public static final int CONTENT_FIELD_NUMBER = 2;
        private volatile Object content_;
        public static final int SUBMITCOUNT_FIELD_NUMBER = 3;
        private int submitCount_;
        public static final int AUDITSTATE_FIELD_NUMBER = 4;
        private int auditState_;
        public static final int SUBMITLIMIT_FIELD_NUMBER = 5;
        private int submitLimit_;
        private byte memoizedIsInitialized;
        private static final ContentAuditInfo DEFAULT_INSTANCE = new ContentAuditInfo();
        private static final Parser<ContentAuditInfo> PARSER = new AbstractParser<ContentAuditInfo>() { // from class: emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfo.1
            @Override // com.google.protobuf.Parser
            public ContentAuditInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ContentAuditInfo(input, extensionRegistry);
            }
        };

        private ContentAuditInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ContentAuditInfo() {
            this.memoizedIsInitialized = -1;
            this.content_ = "";
            this.auditState_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ContentAuditInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ContentAuditInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isOpen_ = input.readBool();
                                break;
                            case 18:
                                this.content_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.submitCount_ = input.readUInt32();
                                break;
                            case 32:
                                this.auditState_ = input.readEnum();
                                break;
                            case 40:
                                this.submitLimit_ = input.readUInt32();
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
            return ContentAuditInfoOuterClass.internal_static_ContentAuditInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ContentAuditInfoOuterClass.internal_static_ContentAuditInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ContentAuditInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public String getContent() {
            Object ref = this.content_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.content_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public ByteString getContentBytes() {
            Object ref = this.content_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.content_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public int getSubmitCount() {
            return this.submitCount_;
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public int getAuditStateValue() {
            return this.auditState_;
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public AuditStateOuterClass.AuditState getAuditState() {
            AuditStateOuterClass.AuditState result = AuditStateOuterClass.AuditState.valueOf(this.auditState_);
            return result == null ? AuditStateOuterClass.AuditState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
        public int getSubmitLimit() {
            return this.submitLimit_;
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
            if (this.isOpen_) {
                output.writeBool(1, this.isOpen_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
                GeneratedMessageV3.writeString(output, 2, this.content_);
            }
            if (this.submitCount_ != 0) {
                output.writeUInt32(3, this.submitCount_);
            }
            if (this.auditState_ != AuditStateOuterClass.AuditState.AUDIT_STATE_NONE.getNumber()) {
                output.writeEnum(4, this.auditState_);
            }
            if (this.submitLimit_ != 0) {
                output.writeUInt32(5, this.submitLimit_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isOpen_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.content_);
            }
            if (this.submitCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.submitCount_);
            }
            if (this.auditState_ != AuditStateOuterClass.AuditState.AUDIT_STATE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.auditState_);
            }
            if (this.submitLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.submitLimit_);
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
            if (!(obj instanceof ContentAuditInfo)) {
                return equals(obj);
            }
            ContentAuditInfo other = (ContentAuditInfo) obj;
            return getIsOpen() == other.getIsOpen() && getContent().equals(other.getContent()) && getSubmitCount() == other.getSubmitCount() && this.auditState_ == other.auditState_ && getSubmitLimit() == other.getSubmitLimit() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsOpen()))) + 2)) + getContent().hashCode())) + 3)) + getSubmitCount())) + 4)) + this.auditState_)) + 5)) + getSubmitLimit())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ContentAuditInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ContentAuditInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ContentAuditInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ContentAuditInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ContentAuditInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ContentAuditInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ContentAuditInfo parseFrom(InputStream input) throws IOException {
            return (ContentAuditInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ContentAuditInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ContentAuditInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ContentAuditInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ContentAuditInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ContentAuditInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ContentAuditInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ContentAuditInfo parseFrom(CodedInputStream input) throws IOException {
            return (ContentAuditInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ContentAuditInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ContentAuditInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ContentAuditInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ContentAuditInfoOuterClass$ContentAuditInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ContentAuditInfoOrBuilder {
            private boolean isOpen_;
            private int submitCount_;
            private int submitLimit_;
            private Object content_ = "";
            private int auditState_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return ContentAuditInfoOuterClass.internal_static_ContentAuditInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ContentAuditInfoOuterClass.internal_static_ContentAuditInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ContentAuditInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ContentAuditInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.content_ = "";
                this.submitCount_ = 0;
                this.auditState_ = 0;
                this.submitLimit_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ContentAuditInfoOuterClass.internal_static_ContentAuditInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ContentAuditInfo getDefaultInstanceForType() {
                return ContentAuditInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ContentAuditInfo build() {
                ContentAuditInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ContentAuditInfo buildPartial() {
                ContentAuditInfo result = new ContentAuditInfo(this);
                result.isOpen_ = this.isOpen_;
                result.content_ = this.content_;
                result.submitCount_ = this.submitCount_;
                result.auditState_ = this.auditState_;
                result.submitLimit_ = this.submitLimit_;
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
                if (other instanceof ContentAuditInfo) {
                    return mergeFrom((ContentAuditInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ContentAuditInfo other) {
                if (other == ContentAuditInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (!other.getContent().isEmpty()) {
                    this.content_ = other.content_;
                    onChanged();
                }
                if (other.getSubmitCount() != 0) {
                    setSubmitCount(other.getSubmitCount());
                }
                if (other.auditState_ != 0) {
                    setAuditStateValue(other.getAuditStateValue());
                }
                if (other.getSubmitLimit() != 0) {
                    setSubmitLimit(other.getSubmitLimit());
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
                ContentAuditInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ContentAuditInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ContentAuditInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
            public String getContent() {
                Object ref = this.content_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.content_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
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
                this.content_ = ContentAuditInfo.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ContentAuditInfo.checkByteStringIsUtf8(value);
                this.content_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
            public int getSubmitCount() {
                return this.submitCount_;
            }

            public Builder setSubmitCount(int value) {
                this.submitCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearSubmitCount() {
                this.submitCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
            public int getAuditStateValue() {
                return this.auditState_;
            }

            public Builder setAuditStateValue(int value) {
                this.auditState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
            public AuditStateOuterClass.AuditState getAuditState() {
                AuditStateOuterClass.AuditState result = AuditStateOuterClass.AuditState.valueOf(this.auditState_);
                return result == null ? AuditStateOuterClass.AuditState.UNRECOGNIZED : result;
            }

            public Builder setAuditState(AuditStateOuterClass.AuditState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.auditState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAuditState() {
                this.auditState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder
            public int getSubmitLimit() {
                return this.submitLimit_;
            }

            public Builder setSubmitLimit(int value) {
                this.submitLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearSubmitLimit() {
                this.submitLimit_ = 0;
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

        public static ContentAuditInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ContentAuditInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ContentAuditInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ContentAuditInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AuditStateOuterClass.getDescriptor();
    }
}
