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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResVersionConfigOuterClass.class */
public final class ResVersionConfigOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016ResVersionConfig.proto\"\u0001\n\u0010ResVersionConfig\u0012\u000f\n\u0007version\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007relogin\u0018\u0002 \u0001(\b\u0012\u000b\n\u0003md5\u0018\u0003 \u0001(\t\u0012\u0018\n\u0010releaseTotalSize\u0018\u0004 \u0001(\t\u0012\u0015\n\rversionSuffix\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006branch\u0018\u0006 \u0001(\t\u0012\u0019\n\u0011nextScriptVersion\u0018\u0007 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ResVersionConfig_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ResVersionConfig_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ResVersionConfig_descriptor, new String[]{"Version", "Relogin", "Md5", "ReleaseTotalSize", "VersionSuffix", "Branch", "NextScriptVersion"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResVersionConfigOuterClass$ResVersionConfigOrBuilder.class */
    public interface ResVersionConfigOrBuilder extends MessageOrBuilder {
        int getVersion();

        boolean getRelogin();

        String getMd5();

        ByteString getMd5Bytes();

        String getReleaseTotalSize();

        ByteString getReleaseTotalSizeBytes();

        String getVersionSuffix();

        ByteString getVersionSuffixBytes();

        String getBranch();

        ByteString getBranchBytes();

        String getNextScriptVersion();

        ByteString getNextScriptVersionBytes();
    }

    private ResVersionConfigOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResVersionConfigOuterClass$ResVersionConfig.class */
    public static final class ResVersionConfig extends GeneratedMessageV3 implements ResVersionConfigOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int version_;
        public static final int RELOGIN_FIELD_NUMBER = 2;
        private boolean relogin_;
        public static final int MD5_FIELD_NUMBER = 3;
        private volatile Object md5_;
        public static final int RELEASETOTALSIZE_FIELD_NUMBER = 4;
        private volatile Object releaseTotalSize_;
        public static final int VERSIONSUFFIX_FIELD_NUMBER = 5;
        private volatile Object versionSuffix_;
        public static final int BRANCH_FIELD_NUMBER = 6;
        private volatile Object branch_;
        public static final int NEXTSCRIPTVERSION_FIELD_NUMBER = 7;
        private volatile Object nextScriptVersion_;
        private byte memoizedIsInitialized;
        private static final ResVersionConfig DEFAULT_INSTANCE = new ResVersionConfig();
        private static final Parser<ResVersionConfig> PARSER = new AbstractParser<ResVersionConfig>() { // from class: emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfig.1
            @Override // com.google.protobuf.Parser
            public ResVersionConfig parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResVersionConfig(input, extensionRegistry);
            }
        };

        private ResVersionConfig(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ResVersionConfig() {
            this.memoizedIsInitialized = -1;
            this.md5_ = "";
            this.releaseTotalSize_ = "";
            this.versionSuffix_ = "";
            this.branch_ = "";
            this.nextScriptVersion_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ResVersionConfig();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ResVersionConfig(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.version_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.relogin_ = input.readBool();
                                    break;
                                case 26:
                                    this.md5_ = input.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.releaseTotalSize_ = input.readStringRequireUtf8();
                                    break;
                                case 42:
                                    this.versionSuffix_ = input.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.branch_ = input.readStringRequireUtf8();
                                    break;
                                case 58:
                                    this.nextScriptVersion_ = input.readStringRequireUtf8();
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
            return ResVersionConfigOuterClass.internal_static_ResVersionConfig_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ResVersionConfigOuterClass.internal_static_ResVersionConfig_fieldAccessorTable.ensureFieldAccessorsInitialized(ResVersionConfig.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public boolean getRelogin() {
            return this.relogin_;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public String getMd5() {
            Object ref = this.md5_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.md5_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public ByteString getMd5Bytes() {
            Object ref = this.md5_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.md5_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public String getReleaseTotalSize() {
            Object ref = this.releaseTotalSize_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.releaseTotalSize_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public ByteString getReleaseTotalSizeBytes() {
            Object ref = this.releaseTotalSize_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.releaseTotalSize_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public String getVersionSuffix() {
            Object ref = this.versionSuffix_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.versionSuffix_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public ByteString getVersionSuffixBytes() {
            Object ref = this.versionSuffix_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.versionSuffix_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public String getBranch() {
            Object ref = this.branch_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.branch_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public ByteString getBranchBytes() {
            Object ref = this.branch_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.branch_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public String getNextScriptVersion() {
            Object ref = this.nextScriptVersion_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.nextScriptVersion_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
        public ByteString getNextScriptVersionBytes() {
            Object ref = this.nextScriptVersion_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.nextScriptVersion_ = b;
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
            if (this.version_ != 0) {
                output.writeUInt32(1, this.version_);
            }
            if (this.relogin_) {
                output.writeBool(2, this.relogin_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.md5_)) {
                GeneratedMessageV3.writeString(output, 3, this.md5_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.releaseTotalSize_)) {
                GeneratedMessageV3.writeString(output, 4, this.releaseTotalSize_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.versionSuffix_)) {
                GeneratedMessageV3.writeString(output, 5, this.versionSuffix_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.branch_)) {
                GeneratedMessageV3.writeString(output, 6, this.branch_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nextScriptVersion_)) {
                GeneratedMessageV3.writeString(output, 7, this.nextScriptVersion_);
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
            if (this.version_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.version_);
            }
            if (this.relogin_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.relogin_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.md5_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.md5_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.releaseTotalSize_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.releaseTotalSize_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.versionSuffix_)) {
                size2 += GeneratedMessageV3.computeStringSize(5, this.versionSuffix_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.branch_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.branch_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.nextScriptVersion_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.nextScriptVersion_);
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
            if (!(obj instanceof ResVersionConfig)) {
                return equals(obj);
            }
            ResVersionConfig other = (ResVersionConfig) obj;
            return getVersion() == other.getVersion() && getRelogin() == other.getRelogin() && getMd5().equals(other.getMd5()) && getReleaseTotalSize().equals(other.getReleaseTotalSize()) && getVersionSuffix().equals(other.getVersionSuffix()) && getBranch().equals(other.getBranch()) && getNextScriptVersion().equals(other.getNextScriptVersion()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getVersion())) + 2)) + Internal.hashBoolean(getRelogin()))) + 3)) + getMd5().hashCode())) + 4)) + getReleaseTotalSize().hashCode())) + 5)) + getVersionSuffix().hashCode())) + 6)) + getBranch().hashCode())) + 7)) + getNextScriptVersion().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ResVersionConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResVersionConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResVersionConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResVersionConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResVersionConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResVersionConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResVersionConfig parseFrom(InputStream input) throws IOException {
            return (ResVersionConfig) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResVersionConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResVersionConfig) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResVersionConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (ResVersionConfig) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ResVersionConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResVersionConfig) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResVersionConfig parseFrom(CodedInputStream input) throws IOException {
            return (ResVersionConfig) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResVersionConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResVersionConfig) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ResVersionConfig prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResVersionConfigOuterClass$ResVersionConfig$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResVersionConfigOrBuilder {
            private int version_;
            private boolean relogin_;
            private Object md5_ = "";
            private Object releaseTotalSize_ = "";
            private Object versionSuffix_ = "";
            private Object branch_ = "";
            private Object nextScriptVersion_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return ResVersionConfigOuterClass.internal_static_ResVersionConfig_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ResVersionConfigOuterClass.internal_static_ResVersionConfig_fieldAccessorTable.ensureFieldAccessorsInitialized(ResVersionConfig.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResVersionConfig.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.version_ = 0;
                this.relogin_ = false;
                this.md5_ = "";
                this.releaseTotalSize_ = "";
                this.versionSuffix_ = "";
                this.branch_ = "";
                this.nextScriptVersion_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ResVersionConfigOuterClass.internal_static_ResVersionConfig_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ResVersionConfig getDefaultInstanceForType() {
                return ResVersionConfig.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResVersionConfig build() {
                ResVersionConfig result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResVersionConfig buildPartial() {
                ResVersionConfig result = new ResVersionConfig(this);
                result.version_ = this.version_;
                result.relogin_ = this.relogin_;
                result.md5_ = this.md5_;
                result.releaseTotalSize_ = this.releaseTotalSize_;
                result.versionSuffix_ = this.versionSuffix_;
                result.branch_ = this.branch_;
                result.nextScriptVersion_ = this.nextScriptVersion_;
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
                if (other instanceof ResVersionConfig) {
                    return mergeFrom((ResVersionConfig) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResVersionConfig other) {
                if (other == ResVersionConfig.getDefaultInstance()) {
                    return this;
                }
                if (other.getVersion() != 0) {
                    setVersion(other.getVersion());
                }
                if (other.getRelogin()) {
                    setRelogin(other.getRelogin());
                }
                if (!other.getMd5().isEmpty()) {
                    this.md5_ = other.md5_;
                    onChanged();
                }
                if (!other.getReleaseTotalSize().isEmpty()) {
                    this.releaseTotalSize_ = other.releaseTotalSize_;
                    onChanged();
                }
                if (!other.getVersionSuffix().isEmpty()) {
                    this.versionSuffix_ = other.versionSuffix_;
                    onChanged();
                }
                if (!other.getBranch().isEmpty()) {
                    this.branch_ = other.branch_;
                    onChanged();
                }
                if (!other.getNextScriptVersion().isEmpty()) {
                    this.nextScriptVersion_ = other.nextScriptVersion_;
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
                ResVersionConfig parsedMessage = null;
                try {
                    try {
                        parsedMessage = ResVersionConfig.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ResVersionConfig) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public int getVersion() {
                return this.version_;
            }

            public Builder setVersion(int value) {
                this.version_ = value;
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.version_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public boolean getRelogin() {
                return this.relogin_;
            }

            public Builder setRelogin(boolean value) {
                this.relogin_ = value;
                onChanged();
                return this;
            }

            public Builder clearRelogin() {
                this.relogin_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public String getMd5() {
                Object ref = this.md5_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.md5_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public ByteString getMd5Bytes() {
                Object ref = this.md5_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.md5_ = b;
                return b;
            }

            public Builder setMd5(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.md5_ = value;
                onChanged();
                return this;
            }

            public Builder clearMd5() {
                this.md5_ = ResVersionConfig.getDefaultInstance().getMd5();
                onChanged();
                return this;
            }

            public Builder setMd5Bytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ResVersionConfig.checkByteStringIsUtf8(value);
                this.md5_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public String getReleaseTotalSize() {
                Object ref = this.releaseTotalSize_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.releaseTotalSize_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public ByteString getReleaseTotalSizeBytes() {
                Object ref = this.releaseTotalSize_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.releaseTotalSize_ = b;
                return b;
            }

            public Builder setReleaseTotalSize(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.releaseTotalSize_ = value;
                onChanged();
                return this;
            }

            public Builder clearReleaseTotalSize() {
                this.releaseTotalSize_ = ResVersionConfig.getDefaultInstance().getReleaseTotalSize();
                onChanged();
                return this;
            }

            public Builder setReleaseTotalSizeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ResVersionConfig.checkByteStringIsUtf8(value);
                this.releaseTotalSize_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public String getVersionSuffix() {
                Object ref = this.versionSuffix_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.versionSuffix_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public ByteString getVersionSuffixBytes() {
                Object ref = this.versionSuffix_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.versionSuffix_ = b;
                return b;
            }

            public Builder setVersionSuffix(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.versionSuffix_ = value;
                onChanged();
                return this;
            }

            public Builder clearVersionSuffix() {
                this.versionSuffix_ = ResVersionConfig.getDefaultInstance().getVersionSuffix();
                onChanged();
                return this;
            }

            public Builder setVersionSuffixBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ResVersionConfig.checkByteStringIsUtf8(value);
                this.versionSuffix_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public String getBranch() {
                Object ref = this.branch_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.branch_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public ByteString getBranchBytes() {
                Object ref = this.branch_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.branch_ = b;
                return b;
            }

            public Builder setBranch(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.branch_ = value;
                onChanged();
                return this;
            }

            public Builder clearBranch() {
                this.branch_ = ResVersionConfig.getDefaultInstance().getBranch();
                onChanged();
                return this;
            }

            public Builder setBranchBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ResVersionConfig.checkByteStringIsUtf8(value);
                this.branch_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public String getNextScriptVersion() {
                Object ref = this.nextScriptVersion_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.nextScriptVersion_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ResVersionConfigOuterClass.ResVersionConfigOrBuilder
            public ByteString getNextScriptVersionBytes() {
                Object ref = this.nextScriptVersion_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.nextScriptVersion_ = b;
                return b;
            }

            public Builder setNextScriptVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nextScriptVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextScriptVersion() {
                this.nextScriptVersion_ = ResVersionConfig.getDefaultInstance().getNextScriptVersion();
                onChanged();
                return this;
            }

            public Builder setNextScriptVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ResVersionConfig.checkByteStringIsUtf8(value);
                this.nextScriptVersion_ = value;
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

        public static ResVersionConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ResVersionConfig> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ResVersionConfig> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResVersionConfig getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
