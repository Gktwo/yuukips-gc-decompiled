package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatReqOuterClass.class */
public final class PrivateChatReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014PrivateChatReq.proto\"O\n\u000ePrivateChatReq\u0012\u0012\n\ntarget_uid\u0018\u0005 \u0001(\r\u0012\u000e\n\u0004text\u0018\u0001 \u0001(\tH��\u0012\u000e\n\u0004icon\u0018\r \u0001(\rH��B\t\n\u0007contentB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PrivateChatReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PrivateChatReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PrivateChatReq_descriptor, new String[]{"TargetUid", "Text", "Icon", "Content"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatReqOuterClass$PrivateChatReqOrBuilder.class */
    public interface PrivateChatReqOrBuilder extends MessageOrBuilder {
        int getTargetUid();

        boolean hasText();

        String getText();

        ByteString getTextBytes();

        boolean hasIcon();

        int getIcon();

        PrivateChatReq.ContentCase getContentCase();
    }

    private PrivateChatReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatReqOuterClass$PrivateChatReq.class */
    public static final class PrivateChatReq extends GeneratedMessageV3 implements PrivateChatReqOrBuilder {
        private static final long serialVersionUID = 0;
        private int contentCase_;
        private Object content_;
        public static final int TARGET_UID_FIELD_NUMBER = 5;
        private int targetUid_;
        public static final int TEXT_FIELD_NUMBER = 1;
        public static final int ICON_FIELD_NUMBER = 13;
        private byte memoizedIsInitialized;
        private static final PrivateChatReq DEFAULT_INSTANCE = new PrivateChatReq();
        private static final Parser<PrivateChatReq> PARSER = new AbstractParser<PrivateChatReq>() { // from class: emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReq.1
            @Override // com.google.protobuf.Parser
            public PrivateChatReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PrivateChatReq(input, extensionRegistry);
            }
        };

        private PrivateChatReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.contentCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private PrivateChatReq() {
            this.contentCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PrivateChatReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PrivateChatReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    String s = input.readStringRequireUtf8();
                                    this.contentCase_ = 1;
                                    this.content_ = s;
                                    break;
                                case 40:
                                    this.targetUid_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.contentCase_ = 13;
                                    this.content_ = Integer.valueOf(input.readUInt32());
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
            return PrivateChatReqOuterClass.internal_static_PrivateChatReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PrivateChatReqOuterClass.internal_static_PrivateChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatReq.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatReqOuterClass$PrivateChatReq$ContentCase.class */
        public enum ContentCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            TEXT(1),
            ICON(13),
            CONTENT_NOT_SET(0);
            
            private final int value;

            ContentCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ContentCase valueOf(int value) {
                return forNumber(value);
            }

            public static ContentCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return CONTENT_NOT_SET;
                    case 1:
                        return TEXT;
                    case 13:
                        return ICON;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public ContentCase getContentCase() {
            return ContentCase.forNumber(this.contentCase_);
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public boolean hasText() {
            return this.contentCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public String getText() {
            Object ref = "";
            if (this.contentCase_ == 1) {
                ref = this.content_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.contentCase_ == 1) {
                this.content_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public ByteString getTextBytes() {
            Object ref = "";
            if (this.contentCase_ == 1) {
                ref = this.content_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.contentCase_ == 1) {
                this.content_ = b;
            }
            return b;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public boolean hasIcon() {
            return this.contentCase_ == 13;
        }

        @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
        public int getIcon() {
            if (this.contentCase_ == 13) {
                return ((Integer) this.content_).intValue();
            }
            return 0;
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
            if (this.contentCase_ == 1) {
                GeneratedMessageV3.writeString(output, 1, this.content_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(5, this.targetUid_);
            }
            if (this.contentCase_ == 13) {
                output.writeUInt32(13, ((Integer) this.content_).intValue());
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
            if (this.contentCase_ == 1) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.content_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.targetUid_);
            }
            if (this.contentCase_ == 13) {
                size2 += CodedOutputStream.computeUInt32Size(13, ((Integer) this.content_).intValue());
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
            if (!(obj instanceof PrivateChatReq)) {
                return equals(obj);
            }
            PrivateChatReq other = (PrivateChatReq) obj;
            if (getTargetUid() != other.getTargetUid() || !getContentCase().equals(other.getContentCase())) {
                return false;
            }
            switch (this.contentCase_) {
                case 1:
                    if (!getText().equals(other.getText())) {
                        return false;
                    }
                    break;
                case 13:
                    if (getIcon() != other.getIcon()) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getTargetUid();
            switch (this.contentCase_) {
                case 1:
                    hash = (53 * ((37 * hash) + 1)) + getText().hashCode();
                    break;
                case 13:
                    hash = (53 * ((37 * hash) + 13)) + getIcon();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PrivateChatReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PrivateChatReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PrivateChatReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PrivateChatReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PrivateChatReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PrivateChatReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PrivateChatReq parseFrom(InputStream input) throws IOException {
            return (PrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PrivateChatReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PrivateChatReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PrivateChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PrivateChatReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PrivateChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PrivateChatReq parseFrom(CodedInputStream input) throws IOException {
            return (PrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PrivateChatReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PrivateChatReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PrivateChatReqOuterClass$PrivateChatReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PrivateChatReqOrBuilder {
            private int contentCase_ = 0;
            private Object content_;
            private int targetUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PrivateChatReqOuterClass.internal_static_PrivateChatReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PrivateChatReqOuterClass.internal_static_PrivateChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PrivateChatReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetUid_ = 0;
                this.contentCase_ = 0;
                this.content_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PrivateChatReqOuterClass.internal_static_PrivateChatReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PrivateChatReq getDefaultInstanceForType() {
                return PrivateChatReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PrivateChatReq build() {
                PrivateChatReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PrivateChatReq buildPartial() {
                PrivateChatReq result = new PrivateChatReq(this);
                result.targetUid_ = this.targetUid_;
                if (this.contentCase_ == 1) {
                    result.content_ = this.content_;
                }
                if (this.contentCase_ == 13) {
                    result.content_ = this.content_;
                }
                result.contentCase_ = this.contentCase_;
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
                if (other instanceof PrivateChatReq) {
                    return mergeFrom((PrivateChatReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PrivateChatReq other) {
                if (other == PrivateChatReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
                }
                switch (other.getContentCase()) {
                    case TEXT:
                        this.contentCase_ = 1;
                        this.content_ = other.content_;
                        onChanged();
                        break;
                    case ICON:
                        setIcon(other.getIcon());
                        break;
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
                PrivateChatReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PrivateChatReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PrivateChatReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public ContentCase getContentCase() {
                return ContentCase.forNumber(this.contentCase_);
            }

            public Builder clearContent() {
                this.contentCase_ = 0;
                this.content_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public boolean hasText() {
                return this.contentCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public String getText() {
                Object ref = "";
                if (this.contentCase_ == 1) {
                    ref = this.content_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.contentCase_ == 1) {
                    this.content_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public ByteString getTextBytes() {
                Object ref = "";
                if (this.contentCase_ == 1) {
                    ref = this.content_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.contentCase_ == 1) {
                    this.content_ = b;
                }
                return b;
            }

            public Builder setText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.contentCase_ = 1;
                this.content_ = value;
                onChanged();
                return this;
            }

            public Builder clearText() {
                if (this.contentCase_ == 1) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder setTextBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                PrivateChatReq.checkByteStringIsUtf8(value);
                this.contentCase_ = 1;
                this.content_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public boolean hasIcon() {
                return this.contentCase_ == 13;
            }

            @Override // emu.grasscutter.net.proto.PrivateChatReqOuterClass.PrivateChatReqOrBuilder
            public int getIcon() {
                if (this.contentCase_ == 13) {
                    return ((Integer) this.content_).intValue();
                }
                return 0;
            }

            public Builder setIcon(int value) {
                this.contentCase_ = 13;
                this.content_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearIcon() {
                if (this.contentCase_ == 13) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
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

        public static PrivateChatReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PrivateChatReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PrivateChatReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PrivateChatReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
