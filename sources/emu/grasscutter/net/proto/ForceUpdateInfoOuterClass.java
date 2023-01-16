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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForceUpdateInfoOuterClass.class */
public final class ForceUpdateInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015ForceUpdateInfo.proto\"+\n\u000fForceUpdateInfo\u0012\u0018\n\u0010force_update_url\u0018\u0001 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ForceUpdateInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForceUpdateInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForceUpdateInfo_descriptor, new String[]{"ForceUpdateUrl"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForceUpdateInfoOuterClass$ForceUpdateInfoOrBuilder.class */
    public interface ForceUpdateInfoOrBuilder extends MessageOrBuilder {
        String getForceUpdateUrl();

        ByteString getForceUpdateUrlBytes();
    }

    private ForceUpdateInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForceUpdateInfoOuterClass$ForceUpdateInfo.class */
    public static final class ForceUpdateInfo extends GeneratedMessageV3 implements ForceUpdateInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FORCE_UPDATE_URL_FIELD_NUMBER = 1;
        private volatile Object forceUpdateUrl_;
        private byte memoizedIsInitialized;
        private static final ForceUpdateInfo DEFAULT_INSTANCE = new ForceUpdateInfo();
        private static final Parser<ForceUpdateInfo> PARSER = new AbstractParser<ForceUpdateInfo>() { // from class: emu.grasscutter.net.proto.ForceUpdateInfoOuterClass.ForceUpdateInfo.1
            @Override // com.google.protobuf.Parser
            public ForceUpdateInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForceUpdateInfo(input, extensionRegistry);
            }
        };

        private ForceUpdateInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForceUpdateInfo() {
            this.memoizedIsInitialized = -1;
            this.forceUpdateUrl_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForceUpdateInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ForceUpdateInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.forceUpdateUrl_ = input.readStringRequireUtf8();
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
            return ForceUpdateInfoOuterClass.internal_static_ForceUpdateInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForceUpdateInfoOuterClass.internal_static_ForceUpdateInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ForceUpdateInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder
        public String getForceUpdateUrl() {
            Object ref = this.forceUpdateUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.forceUpdateUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder
        public ByteString getForceUpdateUrlBytes() {
            Object ref = this.forceUpdateUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.forceUpdateUrl_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.forceUpdateUrl_)) {
                GeneratedMessageV3.writeString(output, 1, this.forceUpdateUrl_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.forceUpdateUrl_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.forceUpdateUrl_);
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
            if (!(obj instanceof ForceUpdateInfo)) {
                return equals(obj);
            }
            ForceUpdateInfo other = (ForceUpdateInfo) obj;
            return getForceUpdateUrl().equals(other.getForceUpdateUrl()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getForceUpdateUrl().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ForceUpdateInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForceUpdateInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForceUpdateInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForceUpdateInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForceUpdateInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForceUpdateInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForceUpdateInfo parseFrom(InputStream input) throws IOException {
            return (ForceUpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForceUpdateInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForceUpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForceUpdateInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ForceUpdateInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForceUpdateInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForceUpdateInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForceUpdateInfo parseFrom(CodedInputStream input) throws IOException {
            return (ForceUpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForceUpdateInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForceUpdateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForceUpdateInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForceUpdateInfoOuterClass$ForceUpdateInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForceUpdateInfoOrBuilder {
            private Object forceUpdateUrl_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return ForceUpdateInfoOuterClass.internal_static_ForceUpdateInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForceUpdateInfoOuterClass.internal_static_ForceUpdateInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ForceUpdateInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForceUpdateInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.forceUpdateUrl_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForceUpdateInfoOuterClass.internal_static_ForceUpdateInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForceUpdateInfo getDefaultInstanceForType() {
                return ForceUpdateInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForceUpdateInfo build() {
                ForceUpdateInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForceUpdateInfo buildPartial() {
                ForceUpdateInfo result = new ForceUpdateInfo(this);
                result.forceUpdateUrl_ = this.forceUpdateUrl_;
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
                if (other instanceof ForceUpdateInfo) {
                    return mergeFrom((ForceUpdateInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForceUpdateInfo other) {
                if (other == ForceUpdateInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getForceUpdateUrl().isEmpty()) {
                    this.forceUpdateUrl_ = other.forceUpdateUrl_;
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
                ForceUpdateInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForceUpdateInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForceUpdateInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder
            public String getForceUpdateUrl() {
                Object ref = this.forceUpdateUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.forceUpdateUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ForceUpdateInfoOuterClass.ForceUpdateInfoOrBuilder
            public ByteString getForceUpdateUrlBytes() {
                Object ref = this.forceUpdateUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.forceUpdateUrl_ = b;
                return b;
            }

            public Builder setForceUpdateUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.forceUpdateUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearForceUpdateUrl() {
                this.forceUpdateUrl_ = ForceUpdateInfo.getDefaultInstance().getForceUpdateUrl();
                onChanged();
                return this;
            }

            public Builder setForceUpdateUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ForceUpdateInfo.checkByteStringIsUtf8(value);
                this.forceUpdateUrl_ = value;
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

        public static ForceUpdateInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForceUpdateInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForceUpdateInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForceUpdateInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
