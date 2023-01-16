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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardTransferItemOuterClass.class */
public final class AddNoGachaAvatarCardTransferItemOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&AddNoGachaAvatarCardTransferItem.proto\"R\n AddNoGachaAvatarCardTransferItem\u0012\r\n\u0005count\u0018\u0005 \u0001(\r\u0012\u000e\n\u0006is_new\u0018\b \u0001(\b\u0012\u000f\n\u0007item_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AddNoGachaAvatarCardTransferItem_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_AddNoGachaAvatarCardTransferItem_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f619x5c6aa4b6 = new GeneratedMessageV3.FieldAccessorTable(internal_static_AddNoGachaAvatarCardTransferItem_descriptor, new String[]{"Count", "IsNew", "ItemId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardTransferItemOuterClass$AddNoGachaAvatarCardTransferItemOrBuilder.class */
    public interface AddNoGachaAvatarCardTransferItemOrBuilder extends MessageOrBuilder {
        int getCount();

        boolean getIsNew();

        int getItemId();
    }

    private AddNoGachaAvatarCardTransferItemOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardTransferItemOuterClass$AddNoGachaAvatarCardTransferItem.class */
    public static final class AddNoGachaAvatarCardTransferItem extends GeneratedMessageV3 implements AddNoGachaAvatarCardTransferItemOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COUNT_FIELD_NUMBER = 5;
        private int count_;
        public static final int IS_NEW_FIELD_NUMBER = 8;
        private boolean isNew_;
        public static final int ITEM_ID_FIELD_NUMBER = 11;
        private int itemId_;
        private byte memoizedIsInitialized;
        private static final AddNoGachaAvatarCardTransferItem DEFAULT_INSTANCE = new AddNoGachaAvatarCardTransferItem();
        private static final Parser<AddNoGachaAvatarCardTransferItem> PARSER = new AbstractParser<AddNoGachaAvatarCardTransferItem>() { // from class: emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.1
            @Override // com.google.protobuf.Parser
            public AddNoGachaAvatarCardTransferItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AddNoGachaAvatarCardTransferItem(input, extensionRegistry);
            }
        };

        private AddNoGachaAvatarCardTransferItem(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AddNoGachaAvatarCardTransferItem() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AddNoGachaAvatarCardTransferItem();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddNoGachaAvatarCardTransferItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.count_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.isNew_ = input.readBool();
                                    break;
                                case 88:
                                    this.itemId_ = input.readUInt32();
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
            return AddNoGachaAvatarCardTransferItemOuterClass.internal_static_AddNoGachaAvatarCardTransferItem_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AddNoGachaAvatarCardTransferItemOuterClass.f619x5c6aa4b6.ensureFieldAccessorsInitialized(AddNoGachaAvatarCardTransferItem.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder
        public boolean getIsNew() {
            return this.isNew_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder
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
            if (this.count_ != 0) {
                output.writeUInt32(5, this.count_);
            }
            if (this.isNew_) {
                output.writeBool(8, this.isNew_);
            }
            if (this.itemId_ != 0) {
                output.writeUInt32(11, this.itemId_);
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
            if (this.count_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.count_);
            }
            if (this.isNew_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isNew_);
            }
            if (this.itemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.itemId_);
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
            if (!(obj instanceof AddNoGachaAvatarCardTransferItem)) {
                return equals(obj);
            }
            AddNoGachaAvatarCardTransferItem other = (AddNoGachaAvatarCardTransferItem) obj;
            return getCount() == other.getCount() && getIsNew() == other.getIsNew() && getItemId() == other.getItemId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getCount())) + 8)) + Internal.hashBoolean(getIsNew()))) + 11)) + getItemId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(InputStream input) throws IOException {
            return (AddNoGachaAvatarCardTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddNoGachaAvatarCardTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AddNoGachaAvatarCardTransferItem parseDelimitedFrom(InputStream input) throws IOException {
            return (AddNoGachaAvatarCardTransferItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AddNoGachaAvatarCardTransferItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddNoGachaAvatarCardTransferItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(CodedInputStream input) throws IOException {
            return (AddNoGachaAvatarCardTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AddNoGachaAvatarCardTransferItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddNoGachaAvatarCardTransferItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AddNoGachaAvatarCardTransferItem prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardTransferItemOuterClass$AddNoGachaAvatarCardTransferItem$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AddNoGachaAvatarCardTransferItemOrBuilder {
            private int count_;
            private boolean isNew_;
            private int itemId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AddNoGachaAvatarCardTransferItemOuterClass.internal_static_AddNoGachaAvatarCardTransferItem_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AddNoGachaAvatarCardTransferItemOuterClass.f619x5c6aa4b6.ensureFieldAccessorsInitialized(AddNoGachaAvatarCardTransferItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AddNoGachaAvatarCardTransferItem.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.count_ = 0;
                this.isNew_ = false;
                this.itemId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AddNoGachaAvatarCardTransferItemOuterClass.internal_static_AddNoGachaAvatarCardTransferItem_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AddNoGachaAvatarCardTransferItem getDefaultInstanceForType() {
                return AddNoGachaAvatarCardTransferItem.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddNoGachaAvatarCardTransferItem build() {
                AddNoGachaAvatarCardTransferItem result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddNoGachaAvatarCardTransferItem buildPartial() {
                AddNoGachaAvatarCardTransferItem result = new AddNoGachaAvatarCardTransferItem(this);
                result.count_ = this.count_;
                result.isNew_ = this.isNew_;
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
                if (other instanceof AddNoGachaAvatarCardTransferItem) {
                    return mergeFrom((AddNoGachaAvatarCardTransferItem) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AddNoGachaAvatarCardTransferItem other) {
                if (other == AddNoGachaAvatarCardTransferItem.getDefaultInstance()) {
                    return this;
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
                }
                if (other.getIsNew()) {
                    setIsNew(other.getIsNew());
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
                AddNoGachaAvatarCardTransferItem parsedMessage = null;
                try {
                    try {
                        parsedMessage = AddNoGachaAvatarCardTransferItem.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AddNoGachaAvatarCardTransferItem) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder
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

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder
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

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder
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

        public static AddNoGachaAvatarCardTransferItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddNoGachaAvatarCardTransferItem> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AddNoGachaAvatarCardTransferItem> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AddNoGachaAvatarCardTransferItem getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
