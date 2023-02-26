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
import emu.grasscutter.net.proto.WinterCampRecvItemDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemNotifyOuterClass.class */
public final class WinterCampRecvItemNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eWinterCampRecvItemNotify.proto\u001a\u001cWinterCampRecvItemData.proto\"I\n\u0018WinterCampRecvItemNotify\u0012-\n\frecvItemData\u0018\u0005 \u0001(\u000b2\u0017.WinterCampRecvItemDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WinterCampRecvItemDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampRecvItemNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampRecvItemNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampRecvItemNotify_descriptor, new String[]{"RecvItemData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemNotifyOuterClass$WinterCampRecvItemNotifyOrBuilder.class */
    public interface WinterCampRecvItemNotifyOrBuilder extends MessageOrBuilder {
        boolean hasRecvItemData();

        WinterCampRecvItemDataOuterClass.WinterCampRecvItemData getRecvItemData();

        WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder getRecvItemDataOrBuilder();
    }

    private WinterCampRecvItemNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemNotifyOuterClass$WinterCampRecvItemNotify.class */
    public static final class WinterCampRecvItemNotify extends GeneratedMessageV3 implements WinterCampRecvItemNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECVITEMDATA_FIELD_NUMBER = 5;
        private WinterCampRecvItemDataOuterClass.WinterCampRecvItemData recvItemData_;
        private byte memoizedIsInitialized;
        private static final WinterCampRecvItemNotify DEFAULT_INSTANCE = new WinterCampRecvItemNotify();
        private static final Parser<WinterCampRecvItemNotify> PARSER = new AbstractParser<WinterCampRecvItemNotify>() { // from class: emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotify.1
            @Override // com.google.protobuf.Parser
            public WinterCampRecvItemNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampRecvItemNotify(input, extensionRegistry);
            }
        };

        private WinterCampRecvItemNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampRecvItemNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampRecvItemNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampRecvItemNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder subBuilder = this.recvItemData_ != null ? this.recvItemData_.toBuilder() : null;
                                this.recvItemData_ = (WinterCampRecvItemDataOuterClass.WinterCampRecvItemData) input.readMessage(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.recvItemData_);
                                    this.recvItemData_ = subBuilder.buildPartial();
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
            return WinterCampRecvItemNotifyOuterClass.internal_static_WinterCampRecvItemNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampRecvItemNotifyOuterClass.internal_static_WinterCampRecvItemNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampRecvItemNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotifyOrBuilder
        public boolean hasRecvItemData() {
            return this.recvItemData_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotifyOrBuilder
        public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData getRecvItemData() {
            return this.recvItemData_ == null ? WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.getDefaultInstance() : this.recvItemData_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotifyOrBuilder
        public WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder getRecvItemDataOrBuilder() {
            return getRecvItemData();
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
            if (this.recvItemData_ != null) {
                output.writeMessage(5, getRecvItemData());
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
            if (this.recvItemData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getRecvItemData());
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
            if (!(obj instanceof WinterCampRecvItemNotify)) {
                return equals(obj);
            }
            WinterCampRecvItemNotify other = (WinterCampRecvItemNotify) obj;
            if (hasRecvItemData() != other.hasRecvItemData()) {
                return false;
            }
            return (!hasRecvItemData() || getRecvItemData().equals(other.getRecvItemData())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRecvItemData()) {
                hash = (53 * ((37 * hash) + 5)) + getRecvItemData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampRecvItemNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampRecvItemNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampRecvItemNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampRecvItemNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampRecvItemNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampRecvItemNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampRecvItemNotify parseFrom(InputStream input) throws IOException {
            return (WinterCampRecvItemNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampRecvItemNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampRecvItemNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampRecvItemNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampRecvItemNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampRecvItemNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampRecvItemNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampRecvItemNotify parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampRecvItemNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampRecvItemNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampRecvItemNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampRecvItemNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampRecvItemNotifyOuterClass$WinterCampRecvItemNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampRecvItemNotifyOrBuilder {
            private WinterCampRecvItemDataOuterClass.WinterCampRecvItemData recvItemData_;
            private SingleFieldBuilderV3<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder, WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> recvItemDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampRecvItemNotifyOuterClass.internal_static_WinterCampRecvItemNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampRecvItemNotifyOuterClass.internal_static_WinterCampRecvItemNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampRecvItemNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampRecvItemNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.recvItemDataBuilder_ == null) {
                    this.recvItemData_ = null;
                } else {
                    this.recvItemData_ = null;
                    this.recvItemDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampRecvItemNotifyOuterClass.internal_static_WinterCampRecvItemNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampRecvItemNotify getDefaultInstanceForType() {
                return WinterCampRecvItemNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampRecvItemNotify build() {
                WinterCampRecvItemNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampRecvItemNotify buildPartial() {
                WinterCampRecvItemNotify result = new WinterCampRecvItemNotify(this);
                if (this.recvItemDataBuilder_ == null) {
                    result.recvItemData_ = this.recvItemData_;
                } else {
                    result.recvItemData_ = this.recvItemDataBuilder_.build();
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
                if (other instanceof WinterCampRecvItemNotify) {
                    return mergeFrom((WinterCampRecvItemNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampRecvItemNotify other) {
                if (other == WinterCampRecvItemNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRecvItemData()) {
                    mergeRecvItemData(other.getRecvItemData());
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
                WinterCampRecvItemNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampRecvItemNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampRecvItemNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotifyOrBuilder
            public boolean hasRecvItemData() {
                return (this.recvItemDataBuilder_ == null && this.recvItemData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotifyOrBuilder
            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData getRecvItemData() {
                if (this.recvItemDataBuilder_ == null) {
                    return this.recvItemData_ == null ? WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.getDefaultInstance() : this.recvItemData_;
                }
                return this.recvItemDataBuilder_.getMessage();
            }

            public Builder setRecvItemData(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData value) {
                if (this.recvItemDataBuilder_ != null) {
                    this.recvItemDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.recvItemData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRecvItemData(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder builderForValue) {
                if (this.recvItemDataBuilder_ == null) {
                    this.recvItemData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.recvItemDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRecvItemData(WinterCampRecvItemDataOuterClass.WinterCampRecvItemData value) {
                if (this.recvItemDataBuilder_ == null) {
                    if (this.recvItemData_ != null) {
                        this.recvItemData_ = WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.newBuilder(this.recvItemData_).mergeFrom(value).buildPartial();
                    } else {
                        this.recvItemData_ = value;
                    }
                    onChanged();
                } else {
                    this.recvItemDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRecvItemData() {
                if (this.recvItemDataBuilder_ == null) {
                    this.recvItemData_ = null;
                    onChanged();
                } else {
                    this.recvItemData_ = null;
                    this.recvItemDataBuilder_ = null;
                }
                return this;
            }

            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder getRecvItemDataBuilder() {
                onChanged();
                return getRecvItemDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WinterCampRecvItemNotifyOuterClass.WinterCampRecvItemNotifyOrBuilder
            public WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder getRecvItemDataOrBuilder() {
                if (this.recvItemDataBuilder_ != null) {
                    return this.recvItemDataBuilder_.getMessageOrBuilder();
                }
                return this.recvItemData_ == null ? WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.getDefaultInstance() : this.recvItemData_;
            }

            private SingleFieldBuilderV3<WinterCampRecvItemDataOuterClass.WinterCampRecvItemData, WinterCampRecvItemDataOuterClass.WinterCampRecvItemData.Builder, WinterCampRecvItemDataOuterClass.WinterCampRecvItemDataOrBuilder> getRecvItemDataFieldBuilder() {
                if (this.recvItemDataBuilder_ == null) {
                    this.recvItemDataBuilder_ = new SingleFieldBuilderV3<>(getRecvItemData(), getParentForChildren(), isClean());
                    this.recvItemData_ = null;
                }
                return this.recvItemDataBuilder_;
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

        public static WinterCampRecvItemNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampRecvItemNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampRecvItemNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampRecvItemNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WinterCampRecvItemDataOuterClass.getDescriptor();
    }
}
