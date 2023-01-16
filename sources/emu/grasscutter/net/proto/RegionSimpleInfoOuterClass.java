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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionSimpleInfoOuterClass.class */
public final class RegionSimpleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016RegionSimpleInfo.proto\"S\n\u0010RegionSimpleInfo\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\r\n\u0005title\u0018\u0002 \u0001(\t\u0012\f\n\u0004type\u0018\u0003 \u0001(\t\u0012\u0014\n\fdispatch_url\u0018\u0004 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RegionSimpleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RegionSimpleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RegionSimpleInfo_descriptor, new String[]{"Name", "Title", "Type", "DispatchUrl"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionSimpleInfoOuterClass$RegionSimpleInfoOrBuilder.class */
    public interface RegionSimpleInfoOrBuilder extends MessageOrBuilder {
        String getName();

        ByteString getNameBytes();

        String getTitle();

        ByteString getTitleBytes();

        String getType();

        ByteString getTypeBytes();

        String getDispatchUrl();

        ByteString getDispatchUrlBytes();
    }

    private RegionSimpleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionSimpleInfoOuterClass$RegionSimpleInfo.class */
    public static final class RegionSimpleInfo extends GeneratedMessageV3 implements RegionSimpleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NAME_FIELD_NUMBER = 1;
        private volatile Object name_;
        public static final int TITLE_FIELD_NUMBER = 2;
        private volatile Object title_;
        public static final int TYPE_FIELD_NUMBER = 3;
        private volatile Object type_;
        public static final int DISPATCH_URL_FIELD_NUMBER = 4;
        private volatile Object dispatchUrl_;
        private byte memoizedIsInitialized;
        private static final RegionSimpleInfo DEFAULT_INSTANCE = new RegionSimpleInfo();
        private static final Parser<RegionSimpleInfo> PARSER = new AbstractParser<RegionSimpleInfo>() { // from class: emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfo.1
            @Override // com.google.protobuf.Parser
            public RegionSimpleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RegionSimpleInfo(input, extensionRegistry);
            }
        };

        private RegionSimpleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RegionSimpleInfo() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.title_ = "";
            this.type_ = "";
            this.dispatchUrl_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RegionSimpleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RegionSimpleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.name_ = input.readStringRequireUtf8();
                                    break;
                                case 18:
                                    this.title_ = input.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.type_ = input.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.dispatchUrl_ = input.readStringRequireUtf8();
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
            return RegionSimpleInfoOuterClass.internal_static_RegionSimpleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RegionSimpleInfoOuterClass.internal_static_RegionSimpleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RegionSimpleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.name_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public String getTitle() {
            Object ref = this.title_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.title_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public ByteString getTitleBytes() {
            Object ref = this.title_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.title_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public String getType() {
            Object ref = this.type_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.type_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public ByteString getTypeBytes() {
            Object ref = this.type_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.type_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public String getDispatchUrl() {
            Object ref = this.dispatchUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.dispatchUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
        public ByteString getDispatchUrlBytes() {
            Object ref = this.dispatchUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.dispatchUrl_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                GeneratedMessageV3.writeString(output, 1, this.name_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
                GeneratedMessageV3.writeString(output, 2, this.title_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.type_)) {
                GeneratedMessageV3.writeString(output, 3, this.type_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dispatchUrl_)) {
                GeneratedMessageV3.writeString(output, 4, this.dispatchUrl_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.title_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.type_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.type_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dispatchUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.dispatchUrl_);
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
            if (!(obj instanceof RegionSimpleInfo)) {
                return equals(obj);
            }
            RegionSimpleInfo other = (RegionSimpleInfo) obj;
            return getName().equals(other.getName()) && getTitle().equals(other.getTitle()) && getType().equals(other.getType()) && getDispatchUrl().equals(other.getDispatchUrl()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getName().hashCode())) + 2)) + getTitle().hashCode())) + 3)) + getType().hashCode())) + 4)) + getDispatchUrl().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RegionSimpleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegionSimpleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegionSimpleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegionSimpleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegionSimpleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RegionSimpleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RegionSimpleInfo parseFrom(InputStream input) throws IOException {
            return (RegionSimpleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RegionSimpleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionSimpleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegionSimpleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RegionSimpleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RegionSimpleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionSimpleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RegionSimpleInfo parseFrom(CodedInputStream input) throws IOException {
            return (RegionSimpleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RegionSimpleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionSimpleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RegionSimpleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RegionSimpleInfoOuterClass$RegionSimpleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RegionSimpleInfoOrBuilder {
            private Object name_ = "";
            private Object title_ = "";
            private Object type_ = "";
            private Object dispatchUrl_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return RegionSimpleInfoOuterClass.internal_static_RegionSimpleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RegionSimpleInfoOuterClass.internal_static_RegionSimpleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RegionSimpleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RegionSimpleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.name_ = "";
                this.title_ = "";
                this.type_ = "";
                this.dispatchUrl_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RegionSimpleInfoOuterClass.internal_static_RegionSimpleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RegionSimpleInfo getDefaultInstanceForType() {
                return RegionSimpleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RegionSimpleInfo build() {
                RegionSimpleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RegionSimpleInfo buildPartial() {
                RegionSimpleInfo result = new RegionSimpleInfo(this);
                result.name_ = this.name_;
                result.title_ = this.title_;
                result.type_ = this.type_;
                result.dispatchUrl_ = this.dispatchUrl_;
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
                if (other instanceof RegionSimpleInfo) {
                    return mergeFrom((RegionSimpleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RegionSimpleInfo other) {
                if (other == RegionSimpleInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getName().isEmpty()) {
                    this.name_ = other.name_;
                    onChanged();
                }
                if (!other.getTitle().isEmpty()) {
                    this.title_ = other.title_;
                    onChanged();
                }
                if (!other.getType().isEmpty()) {
                    this.type_ = other.type_;
                    onChanged();
                }
                if (!other.getDispatchUrl().isEmpty()) {
                    this.dispatchUrl_ = other.dispatchUrl_;
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
                RegionSimpleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RegionSimpleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RegionSimpleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = RegionSimpleInfo.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionSimpleInfo.checkByteStringIsUtf8(value);
                this.name_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public String getTitle() {
                Object ref = this.title_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.title_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
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
                this.title_ = RegionSimpleInfo.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionSimpleInfo.checkByteStringIsUtf8(value);
                this.title_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public String getType() {
                Object ref = this.type_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.type_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public ByteString getTypeBytes() {
                Object ref = this.type_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.type_ = b;
                return b;
            }

            public Builder setType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = RegionSimpleInfo.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionSimpleInfo.checkByteStringIsUtf8(value);
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public String getDispatchUrl() {
                Object ref = this.dispatchUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.dispatchUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.RegionSimpleInfoOuterClass.RegionSimpleInfoOrBuilder
            public ByteString getDispatchUrlBytes() {
                Object ref = this.dispatchUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dispatchUrl_ = b;
                return b;
            }

            public Builder setDispatchUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dispatchUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearDispatchUrl() {
                this.dispatchUrl_ = RegionSimpleInfo.getDefaultInstance().getDispatchUrl();
                onChanged();
                return this;
            }

            public Builder setDispatchUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RegionSimpleInfo.checkByteStringIsUtf8(value);
                this.dispatchUrl_ = value;
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

        public static RegionSimpleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RegionSimpleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RegionSimpleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RegionSimpleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
