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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaTransferItemOuterClass.class */
public final class GachaTransferItemOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GachaTransferItem.proto\u001a\u000fItemParam.proto\"K\n\u0011GachaTransferItem\u0012\u0018\n\u0004item\u0018\u0001 \u0001(\u000b2\n.ItemParam\u0012\u001c\n\u0014is_transfer_item_new\u0018\u000b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GachaTransferItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaTransferItem_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaTransferItem_descriptor, new String[]{"Item", "IsTransferItemNew"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaTransferItemOuterClass$GachaTransferItemOrBuilder.class */
    public interface GachaTransferItemOrBuilder extends MessageOrBuilder {
        boolean hasItem();

        ItemParamOuterClass.ItemParam getItem();

        ItemParamOuterClass.ItemParamOrBuilder getItemOrBuilder();

        boolean getIsTransferItemNew();
    }

    private GachaTransferItemOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaTransferItemOuterClass$GachaTransferItem.class */
    public static final class GachaTransferItem extends GeneratedMessageV3 implements GachaTransferItemOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEM_FIELD_NUMBER = 1;
        private ItemParamOuterClass.ItemParam item_;
        public static final int IS_TRANSFER_ITEM_NEW_FIELD_NUMBER = 11;
        private boolean isTransferItemNew_;
        private byte memoizedIsInitialized;
        private static final GachaTransferItem DEFAULT_INSTANCE = new GachaTransferItem();
        private static final Parser<GachaTransferItem> PARSER = new AbstractParser<GachaTransferItem>() { // from class: emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItem.1
            @Override // com.google.protobuf.Parser
            public GachaTransferItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaTransferItem(input, extensionRegistry);
            }
        };

        private GachaTransferItem(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GachaTransferItem() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaTransferItem();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GachaTransferItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    ItemParamOuterClass.ItemParam.Builder subBuilder = this.item_ != null ? this.item_.toBuilder() : null;
                                    this.item_ = (ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.item_);
                                        this.item_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 88:
                                    this.isTransferItemNew_ = input.readBool();
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
            return GachaTransferItemOuterClass.internal_static_GachaTransferItem_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaTransferItemOuterClass.internal_static_GachaTransferItem_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaTransferItem.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
        public boolean hasItem() {
            return this.item_ != null;
        }

        @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
        public ItemParamOuterClass.ItemParam getItem() {
            return this.item_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.item_;
        }

        @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemOrBuilder() {
            return getItem();
        }

        @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
        public boolean getIsTransferItemNew() {
            return this.isTransferItemNew_;
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
            if (this.item_ != null) {
                output.writeMessage(1, getItem());
            }
            if (this.isTransferItemNew_) {
                output.writeBool(11, this.isTransferItemNew_);
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
            if (this.item_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getItem());
            }
            if (this.isTransferItemNew_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isTransferItemNew_);
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
            if (!(obj instanceof GachaTransferItem)) {
                return equals(obj);
            }
            GachaTransferItem other = (GachaTransferItem) obj;
            if (hasItem() != other.hasItem()) {
                return false;
            }
            return (!hasItem() || getItem().equals(other.getItem())) && getIsTransferItemNew() == other.getIsTransferItemNew() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasItem()) {
                hash = (53 * ((37 * hash) + 1)) + getItem().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + Internal.hashBoolean(getIsTransferItemNew()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GachaTransferItem parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaTransferItem parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaTransferItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaTransferItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaTransferItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaTransferItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaTransferItem parseFrom(InputStream input) throws IOException {
            return (GachaTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaTransferItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaTransferItem parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaTransferItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaTransferItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaTransferItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaTransferItem parseFrom(CodedInputStream input) throws IOException {
            return (GachaTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaTransferItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaTransferItem prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaTransferItemOuterClass$GachaTransferItem$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaTransferItemOrBuilder {
            private ItemParamOuterClass.ItemParam item_;
            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemBuilder_;
            private boolean isTransferItemNew_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaTransferItemOuterClass.internal_static_GachaTransferItem_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaTransferItemOuterClass.internal_static_GachaTransferItem_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaTransferItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaTransferItem.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.itemBuilder_ == null) {
                    this.item_ = null;
                } else {
                    this.item_ = null;
                    this.itemBuilder_ = null;
                }
                this.isTransferItemNew_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaTransferItemOuterClass.internal_static_GachaTransferItem_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaTransferItem getDefaultInstanceForType() {
                return GachaTransferItem.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaTransferItem build() {
                GachaTransferItem result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaTransferItem buildPartial() {
                GachaTransferItem result = new GachaTransferItem(this);
                if (this.itemBuilder_ == null) {
                    result.item_ = this.item_;
                } else {
                    result.item_ = this.itemBuilder_.build();
                }
                result.isTransferItemNew_ = this.isTransferItemNew_;
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
                if (other instanceof GachaTransferItem) {
                    return mergeFrom((GachaTransferItem) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaTransferItem other) {
                if (other == GachaTransferItem.getDefaultInstance()) {
                    return this;
                }
                if (other.hasItem()) {
                    mergeItem(other.getItem());
                }
                if (other.getIsTransferItemNew()) {
                    setIsTransferItemNew(other.getIsTransferItemNew());
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
                GachaTransferItem parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaTransferItem.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaTransferItem) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
            public boolean hasItem() {
                return (this.itemBuilder_ == null && this.item_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
            public ItemParamOuterClass.ItemParam getItem() {
                if (this.itemBuilder_ == null) {
                    return this.item_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.item_;
                }
                return this.itemBuilder_.getMessage();
            }

            public Builder setItem(ItemParamOuterClass.ItemParam value) {
                if (this.itemBuilder_ != null) {
                    this.itemBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.item_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setItem(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemBuilder_ == null) {
                    this.item_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeItem(ItemParamOuterClass.ItemParam value) {
                if (this.itemBuilder_ == null) {
                    if (this.item_ != null) {
                        this.item_ = ItemParamOuterClass.ItemParam.newBuilder(this.item_).mergeFrom(value).buildPartial();
                    } else {
                        this.item_ = value;
                    }
                    onChanged();
                } else {
                    this.itemBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearItem() {
                if (this.itemBuilder_ == null) {
                    this.item_ = null;
                    onChanged();
                } else {
                    this.item_ = null;
                    this.itemBuilder_ = null;
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemBuilder() {
                onChanged();
                return getItemFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemOrBuilder() {
                if (this.itemBuilder_ != null) {
                    return this.itemBuilder_.getMessageOrBuilder();
                }
                return this.item_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.item_;
            }

            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemFieldBuilder() {
                if (this.itemBuilder_ == null) {
                    this.itemBuilder_ = new SingleFieldBuilderV3<>(getItem(), getParentForChildren(), isClean());
                    this.item_ = null;
                }
                return this.itemBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaTransferItemOuterClass.GachaTransferItemOrBuilder
            public boolean getIsTransferItemNew() {
                return this.isTransferItemNew_;
            }

            public Builder setIsTransferItemNew(boolean value) {
                this.isTransferItemNew_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTransferItemNew() {
                this.isTransferItemNew_ = false;
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

        public static GachaTransferItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaTransferItem> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaTransferItem> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaTransferItem getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
    }
}
