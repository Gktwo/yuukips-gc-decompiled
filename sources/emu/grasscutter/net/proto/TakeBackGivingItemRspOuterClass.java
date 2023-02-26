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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ContentAuditInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemRspOuterClass.class */
public final class TakeBackGivingItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bTakeBackGivingItemRsp.proto\u001a\u0016ContentAuditInfo.proto\"8\n\u0015TakeBackGivingItemRsp\u0012\u001f\n\u0004info\u0018\r \u0001(\u000b2\u0011.ContentAuditInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ContentAuditInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TakeBackGivingItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeBackGivingItemRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeBackGivingItemRsp_descriptor, new String[]{"Info"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemRspOuterClass$TakeBackGivingItemRspOrBuilder.class */
    public interface TakeBackGivingItemRspOrBuilder extends MessageOrBuilder {
        boolean hasInfo();

        ContentAuditInfoOuterClass.ContentAuditInfo getInfo();

        ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder getInfoOrBuilder();
    }

    private TakeBackGivingItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemRspOuterClass$TakeBackGivingItemRsp.class */
    public static final class TakeBackGivingItemRsp extends GeneratedMessageV3 implements TakeBackGivingItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INFO_FIELD_NUMBER = 13;
        private ContentAuditInfoOuterClass.ContentAuditInfo info_;
        private byte memoizedIsInitialized;
        private static final TakeBackGivingItemRsp DEFAULT_INSTANCE = new TakeBackGivingItemRsp();
        private static final Parser<TakeBackGivingItemRsp> PARSER = new AbstractParser<TakeBackGivingItemRsp>() { // from class: emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRsp.1
            @Override // com.google.protobuf.Parser
            public TakeBackGivingItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeBackGivingItemRsp(input, extensionRegistry);
            }
        };

        private TakeBackGivingItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeBackGivingItemRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeBackGivingItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeBackGivingItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 106:
                                ContentAuditInfoOuterClass.ContentAuditInfo.Builder subBuilder = this.info_ != null ? this.info_.toBuilder() : null;
                                this.info_ = (ContentAuditInfoOuterClass.ContentAuditInfo) input.readMessage(ContentAuditInfoOuterClass.ContentAuditInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.info_);
                                    this.info_ = subBuilder.buildPartial();
                                    break;
                                }
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
            return TakeBackGivingItemRspOuterClass.internal_static_TakeBackGivingItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeBackGivingItemRspOuterClass.internal_static_TakeBackGivingItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBackGivingItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRspOrBuilder
        public boolean hasInfo() {
            return this.info_ != null;
        }

        @Override // emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRspOrBuilder
        public ContentAuditInfoOuterClass.ContentAuditInfo getInfo() {
            return this.info_ == null ? ContentAuditInfoOuterClass.ContentAuditInfo.getDefaultInstance() : this.info_;
        }

        @Override // emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRspOrBuilder
        public ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder getInfoOrBuilder() {
            return getInfo();
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
            if (this.info_ != null) {
                output.writeMessage(13, getInfo());
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
            if (this.info_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(13, getInfo());
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
            if (!(obj instanceof TakeBackGivingItemRsp)) {
                return equals(obj);
            }
            TakeBackGivingItemRsp other = (TakeBackGivingItemRsp) obj;
            if (hasInfo() != other.hasInfo()) {
                return false;
            }
            return (!hasInfo() || getInfo().equals(other.getInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TakeBackGivingItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBackGivingItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBackGivingItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBackGivingItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBackGivingItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBackGivingItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBackGivingItemRsp parseFrom(InputStream input) throws IOException {
            return (TakeBackGivingItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBackGivingItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBackGivingItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBackGivingItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeBackGivingItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeBackGivingItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBackGivingItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBackGivingItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (TakeBackGivingItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBackGivingItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBackGivingItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeBackGivingItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBackGivingItemRspOuterClass$TakeBackGivingItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeBackGivingItemRspOrBuilder {
            private ContentAuditInfoOuterClass.ContentAuditInfo info_;
            private SingleFieldBuilderV3<ContentAuditInfoOuterClass.ContentAuditInfo, ContentAuditInfoOuterClass.ContentAuditInfo.Builder, ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder> infoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeBackGivingItemRspOuterClass.internal_static_TakeBackGivingItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeBackGivingItemRspOuterClass.internal_static_TakeBackGivingItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBackGivingItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeBackGivingItemRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.infoBuilder_ == null) {
                    this.info_ = null;
                } else {
                    this.info_ = null;
                    this.infoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeBackGivingItemRspOuterClass.internal_static_TakeBackGivingItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeBackGivingItemRsp getDefaultInstanceForType() {
                return TakeBackGivingItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBackGivingItemRsp build() {
                TakeBackGivingItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBackGivingItemRsp buildPartial() {
                TakeBackGivingItemRsp result = new TakeBackGivingItemRsp(this);
                if (this.infoBuilder_ == null) {
                    result.info_ = this.info_;
                } else {
                    result.info_ = this.infoBuilder_.build();
                }
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
                if (other instanceof TakeBackGivingItemRsp) {
                    return mergeFrom((TakeBackGivingItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeBackGivingItemRsp other) {
                if (other == TakeBackGivingItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasInfo()) {
                    mergeInfo(other.getInfo());
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
                TakeBackGivingItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeBackGivingItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeBackGivingItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRspOrBuilder
            public boolean hasInfo() {
                return (this.infoBuilder_ == null && this.info_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRspOrBuilder
            public ContentAuditInfoOuterClass.ContentAuditInfo getInfo() {
                if (this.infoBuilder_ == null) {
                    return this.info_ == null ? ContentAuditInfoOuterClass.ContentAuditInfo.getDefaultInstance() : this.info_;
                }
                return this.infoBuilder_.getMessage();
            }

            public Builder setInfo(ContentAuditInfoOuterClass.ContentAuditInfo value) {
                if (this.infoBuilder_ != null) {
                    this.infoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.info_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setInfo(ContentAuditInfoOuterClass.ContentAuditInfo.Builder builderForValue) {
                if (this.infoBuilder_ == null) {
                    this.info_ = builderForValue.build();
                    onChanged();
                } else {
                    this.infoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeInfo(ContentAuditInfoOuterClass.ContentAuditInfo value) {
                if (this.infoBuilder_ == null) {
                    if (this.info_ != null) {
                        this.info_ = ContentAuditInfoOuterClass.ContentAuditInfo.newBuilder(this.info_).mergeFrom(value).buildPartial();
                    } else {
                        this.info_ = value;
                    }
                    onChanged();
                } else {
                    this.infoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearInfo() {
                if (this.infoBuilder_ == null) {
                    this.info_ = null;
                    onChanged();
                } else {
                    this.info_ = null;
                    this.infoBuilder_ = null;
                }
                return this;
            }

            public ContentAuditInfoOuterClass.ContentAuditInfo.Builder getInfoBuilder() {
                onChanged();
                return getInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TakeBackGivingItemRspOuterClass.TakeBackGivingItemRspOrBuilder
            public ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder getInfoOrBuilder() {
                if (this.infoBuilder_ != null) {
                    return this.infoBuilder_.getMessageOrBuilder();
                }
                return this.info_ == null ? ContentAuditInfoOuterClass.ContentAuditInfo.getDefaultInstance() : this.info_;
            }

            private SingleFieldBuilderV3<ContentAuditInfoOuterClass.ContentAuditInfo, ContentAuditInfoOuterClass.ContentAuditInfo.Builder, ContentAuditInfoOuterClass.ContentAuditInfoOrBuilder> getInfoFieldBuilder() {
                if (this.infoBuilder_ == null) {
                    this.infoBuilder_ = new SingleFieldBuilderV3<>(getInfo(), getParentForChildren(), isClean());
                    this.info_ = null;
                }
                return this.infoBuilder_;
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

        public static TakeBackGivingItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeBackGivingItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeBackGivingItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeBackGivingItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ContentAuditInfoOuterClass.getDescriptor();
    }
}
