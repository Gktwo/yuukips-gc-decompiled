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
import emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoNotifyOuterClass.class */
public final class HomeLimitedShopInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fHomeLimitedShopInfoNotify.proto\u001a\u0019HomeLimitedShopInfo.proto\"D\n\u0019HomeLimitedShopInfoNotify\u0012'\n\tshop_info\u0018\u0007 \u0001(\u000b2\u0014.HomeLimitedShopInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopInfoNotify_descriptor, new String[]{"ShopInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoNotifyOuterClass$HomeLimitedShopInfoNotifyOrBuilder.class */
    public interface HomeLimitedShopInfoNotifyOrBuilder extends MessageOrBuilder {
        boolean hasShopInfo();

        HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getShopInfo();

        HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getShopInfoOrBuilder();
    }

    private HomeLimitedShopInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoNotifyOuterClass$HomeLimitedShopInfoNotify.class */
    public static final class HomeLimitedShopInfoNotify extends GeneratedMessageV3 implements HomeLimitedShopInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOP_INFO_FIELD_NUMBER = 7;
        private HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo shopInfo_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopInfoNotify DEFAULT_INSTANCE = new HomeLimitedShopInfoNotify();
        private static final Parser<HomeLimitedShopInfoNotify> PARSER = new AbstractParser<HomeLimitedShopInfoNotify>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotify.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopInfoNotify(input, extensionRegistry);
            }
        };

        private HomeLimitedShopInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopInfoNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
                                HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder subBuilder = this.shopInfo_ != null ? this.shopInfo_.toBuilder() : null;
                                this.shopInfo_ = (HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo) input.readMessage(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.shopInfo_);
                                    this.shopInfo_ = subBuilder.buildPartial();
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
            return HomeLimitedShopInfoNotifyOuterClass.internal_static_HomeLimitedShopInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopInfoNotifyOuterClass.internal_static_HomeLimitedShopInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotifyOrBuilder
        public boolean hasShopInfo() {
            return this.shopInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotifyOrBuilder
        public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getShopInfo() {
            return this.shopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.shopInfo_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotifyOrBuilder
        public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getShopInfoOrBuilder() {
            return getShopInfo();
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
            if (this.shopInfo_ != null) {
                output.writeMessage(7, getShopInfo());
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
            if (this.shopInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(7, getShopInfo());
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
            if (!(obj instanceof HomeLimitedShopInfoNotify)) {
                return equals(obj);
            }
            HomeLimitedShopInfoNotify other = (HomeLimitedShopInfoNotify) obj;
            if (hasShopInfo() != other.hasShopInfo()) {
                return false;
            }
            return (!hasShopInfo() || getShopInfo().equals(other.getShopInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasShopInfo()) {
                hash = (53 * ((37 * hash) + 7)) + getShopInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeLimitedShopInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfoNotify parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoNotifyOuterClass$HomeLimitedShopInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopInfoNotifyOrBuilder {
            private HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo shopInfo_;
            private SingleFieldBuilderV3<HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder> shopInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopInfoNotifyOuterClass.internal_static_HomeLimitedShopInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopInfoNotifyOuterClass.internal_static_HomeLimitedShopInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopInfoNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfo_ = null;
                } else {
                    this.shopInfo_ = null;
                    this.shopInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopInfoNotifyOuterClass.internal_static_HomeLimitedShopInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopInfoNotify getDefaultInstanceForType() {
                return HomeLimitedShopInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopInfoNotify build() {
                HomeLimitedShopInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopInfoNotify buildPartial() {
                HomeLimitedShopInfoNotify result = new HomeLimitedShopInfoNotify(this);
                if (this.shopInfoBuilder_ == null) {
                    result.shopInfo_ = this.shopInfo_;
                } else {
                    result.shopInfo_ = this.shopInfoBuilder_.build();
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
                if (other instanceof HomeLimitedShopInfoNotify) {
                    return mergeFrom((HomeLimitedShopInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopInfoNotify other) {
                if (other == HomeLimitedShopInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasShopInfo()) {
                    mergeShopInfo(other.getShopInfo());
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
                HomeLimitedShopInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotifyOrBuilder
            public boolean hasShopInfo() {
                return (this.shopInfoBuilder_ == null && this.shopInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotifyOrBuilder
            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo getShopInfo() {
                if (this.shopInfoBuilder_ == null) {
                    return this.shopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.shopInfo_;
                }
                return this.shopInfoBuilder_.getMessage();
            }

            public Builder setShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo value) {
                if (this.shopInfoBuilder_ != null) {
                    this.shopInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.shopInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder builderForValue) {
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.shopInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeShopInfo(HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo value) {
                if (this.shopInfoBuilder_ == null) {
                    if (this.shopInfo_ != null) {
                        this.shopInfo_ = HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.newBuilder(this.shopInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.shopInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.shopInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearShopInfo() {
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfo_ = null;
                    onChanged();
                } else {
                    this.shopInfo_ = null;
                    this.shopInfoBuilder_ = null;
                }
                return this;
            }

            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder getShopInfoBuilder() {
                onChanged();
                return getShopInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoNotifyOuterClass.HomeLimitedShopInfoNotifyOrBuilder
            public HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder getShopInfoOrBuilder() {
                if (this.shopInfoBuilder_ != null) {
                    return this.shopInfoBuilder_.getMessageOrBuilder();
                }
                return this.shopInfo_ == null ? HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.getDefaultInstance() : this.shopInfo_;
            }

            private SingleFieldBuilderV3<HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.Builder, HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder> getShopInfoFieldBuilder() {
                if (this.shopInfoBuilder_ == null) {
                    this.shopInfoBuilder_ = new SingleFieldBuilderV3<>(getShopInfo(), getParentForChildren(), isClean());
                    this.shopInfo_ = null;
                }
                return this.shopInfoBuilder_;
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

        public static HomeLimitedShopInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeLimitedShopInfoOuterClass.getDescriptor();
    }
}
