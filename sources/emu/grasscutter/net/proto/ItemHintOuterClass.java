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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemHintOuterClass.class */
public final class ItemHintOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eItemHint.proto\"H\n\bItemHint\u0012\u000e\n\u0006is_new\u0018\t \u0001(\b\u0012\f\n\u0004guid\u0018\n \u0001(\u0004\u0012\r\n\u0005count\u0018\u000f \u0001(\r\u0012\u000f\n\u0007item_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ItemHint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ItemHint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ItemHint_descriptor, new String[]{"IsNew", "Guid", "Count", "ItemId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemHintOuterClass$ItemHintOrBuilder.class */
    public interface ItemHintOrBuilder extends MessageOrBuilder {
        boolean getIsNew();

        long getGuid();

        int getCount();

        int getItemId();
    }

    private ItemHintOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemHintOuterClass$ItemHint.class */
    public static final class ItemHint extends GeneratedMessageV3 implements ItemHintOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_NEW_FIELD_NUMBER = 9;
        private boolean isNew_;
        public static final int GUID_FIELD_NUMBER = 10;
        private long guid_;
        public static final int COUNT_FIELD_NUMBER = 15;
        private int count_;
        public static final int ITEM_ID_FIELD_NUMBER = 3;
        private int itemId_;
        private byte memoizedIsInitialized;
        private static final ItemHint DEFAULT_INSTANCE = new ItemHint();
        private static final Parser<ItemHint> PARSER = new AbstractParser<ItemHint>() { // from class: emu.grasscutter.net.proto.ItemHintOuterClass.ItemHint.1
            @Override // com.google.protobuf.Parser
            public ItemHint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemHint(input, extensionRegistry);
            }
        };

        private ItemHint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ItemHint() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ItemHint();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemHint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.itemId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.isNew_ = input.readBool();
                                    break;
                                case 80:
                                    this.guid_ = input.readUInt64();
                                    break;
                                case 120:
                                    this.count_ = input.readUInt32();
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
            return ItemHintOuterClass.internal_static_ItemHint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemHintOuterClass.internal_static_ItemHint_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHint.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
        public boolean getIsNew() {
            return this.isNew_;
        }

        @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
        public int getItemId() {
            return this.itemId_;
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
            if (this.itemId_ != 0) {
                output.writeUInt32(3, this.itemId_);
            }
            if (this.isNew_) {
                output.writeBool(9, this.isNew_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(10, this.guid_);
            }
            if (this.count_ != 0) {
                output.writeUInt32(15, this.count_);
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
            if (this.itemId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.itemId_);
            }
            if (this.isNew_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isNew_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(10, this.guid_);
            }
            if (this.count_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.count_);
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
            if (!(obj instanceof ItemHint)) {
                return equals(obj);
            }
            ItemHint other = (ItemHint) obj;
            return getIsNew() == other.getIsNew() && getGuid() == other.getGuid() && getCount() == other.getCount() && getItemId() == other.getItemId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + Internal.hashBoolean(getIsNew()))) + 10)) + Internal.hashLong(getGuid()))) + 15)) + getCount())) + 3)) + getItemId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ItemHint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemHint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemHint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemHint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemHint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemHint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemHint parseFrom(InputStream input) throws IOException {
            return (ItemHint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemHint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemHint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemHint parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemHint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ItemHint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemHint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemHint parseFrom(CodedInputStream input) throws IOException {
            return (ItemHint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemHint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemHint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ItemHint prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemHintOuterClass$ItemHint$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ItemHintOrBuilder {
            private boolean isNew_;
            private long guid_;
            private int count_;
            private int itemId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemHintOuterClass.internal_static_ItemHint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemHintOuterClass.internal_static_ItemHint_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemHint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemHint.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isNew_ = false;
                this.guid_ = 0;
                this.count_ = 0;
                this.itemId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ItemHintOuterClass.internal_static_ItemHint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ItemHint getDefaultInstanceForType() {
                return ItemHint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemHint build() {
                ItemHint result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemHint buildPartial() {
                ItemHint result = new ItemHint(this);
                result.isNew_ = this.isNew_;
                result.guid_ = this.guid_;
                result.count_ = this.count_;
                result.itemId_ = this.itemId_;
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
                if (other instanceof ItemHint) {
                    return mergeFrom((ItemHint) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemHint other) {
                if (other == ItemHint.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsNew()) {
                    setIsNew(other.getIsNew());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
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
                ItemHint parsedMessage = null;
                try {
                    try {
                        parsedMessage = ItemHint.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ItemHint) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
            public boolean getIsNew() {
                return this.isNew_;
            }

            public Builder setIsNew(boolean value) {
                this.isNew_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNew() {
                this.isNew_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
            public int getCount() {
                return this.count_;
            }

            public Builder setCount(int value) {
                this.count_ = value;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemHintOuterClass.ItemHintOrBuilder
            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = 0;
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

        public static ItemHint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ItemHint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ItemHint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ItemHint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
