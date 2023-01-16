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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarReqOuterClass.class */
public final class ItemRenameAvatarReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ItemRenameAvatarReq.proto\"=\n\u0013ItemRenameAvatarReq\u0012\u0011\n\trename_id\u0018\u000b \u0001(\r\u0012\u0013\n\u000bavatar_name\u0018\u0004 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ItemRenameAvatarReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ItemRenameAvatarReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ItemRenameAvatarReq_descriptor, new String[]{"RenameId", "AvatarName"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarReqOuterClass$ItemRenameAvatarReqOrBuilder.class */
    public interface ItemRenameAvatarReqOrBuilder extends MessageOrBuilder {
        int getRenameId();

        String getAvatarName();

        ByteString getAvatarNameBytes();
    }

    private ItemRenameAvatarReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarReqOuterClass$ItemRenameAvatarReq.class */
    public static final class ItemRenameAvatarReq extends GeneratedMessageV3 implements ItemRenameAvatarReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RENAME_ID_FIELD_NUMBER = 11;
        private int renameId_;
        public static final int AVATAR_NAME_FIELD_NUMBER = 4;
        private volatile Object avatarName_;
        private byte memoizedIsInitialized;
        private static final ItemRenameAvatarReq DEFAULT_INSTANCE = new ItemRenameAvatarReq();
        private static final Parser<ItemRenameAvatarReq> PARSER = new AbstractParser<ItemRenameAvatarReq>() { // from class: emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReq.1
            @Override // com.google.protobuf.Parser
            public ItemRenameAvatarReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemRenameAvatarReq(input, extensionRegistry);
            }
        };

        private ItemRenameAvatarReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ItemRenameAvatarReq() {
            this.memoizedIsInitialized = -1;
            this.avatarName_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ItemRenameAvatarReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemRenameAvatarReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    this.avatarName_ = input.readStringRequireUtf8();
                                    break;
                                case 88:
                                    this.renameId_ = input.readUInt32();
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
            return ItemRenameAvatarReqOuterClass.internal_static_ItemRenameAvatarReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemRenameAvatarReqOuterClass.internal_static_ItemRenameAvatarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemRenameAvatarReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReqOrBuilder
        public int getRenameId() {
            return this.renameId_;
        }

        @Override // emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReqOrBuilder
        public String getAvatarName() {
            Object ref = this.avatarName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.avatarName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReqOrBuilder
        public ByteString getAvatarNameBytes() {
            Object ref = this.avatarName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.avatarName_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.avatarName_)) {
                GeneratedMessageV3.writeString(output, 4, this.avatarName_);
            }
            if (this.renameId_ != 0) {
                output.writeUInt32(11, this.renameId_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.avatarName_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(4, this.avatarName_);
            }
            if (this.renameId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.renameId_);
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
            if (!(obj instanceof ItemRenameAvatarReq)) {
                return equals(obj);
            }
            ItemRenameAvatarReq other = (ItemRenameAvatarReq) obj;
            return getRenameId() == other.getRenameId() && getAvatarName().equals(other.getAvatarName()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getRenameId())) + 4)) + getAvatarName().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ItemRenameAvatarReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemRenameAvatarReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemRenameAvatarReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemRenameAvatarReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemRenameAvatarReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemRenameAvatarReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemRenameAvatarReq parseFrom(InputStream input) throws IOException {
            return (ItemRenameAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemRenameAvatarReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemRenameAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemRenameAvatarReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemRenameAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ItemRenameAvatarReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemRenameAvatarReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemRenameAvatarReq parseFrom(CodedInputStream input) throws IOException {
            return (ItemRenameAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemRenameAvatarReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemRenameAvatarReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ItemRenameAvatarReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarReqOuterClass$ItemRenameAvatarReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ItemRenameAvatarReqOrBuilder {
            private int renameId_;
            private Object avatarName_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemRenameAvatarReqOuterClass.internal_static_ItemRenameAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemRenameAvatarReqOuterClass.internal_static_ItemRenameAvatarReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemRenameAvatarReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemRenameAvatarReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.renameId_ = 0;
                this.avatarName_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ItemRenameAvatarReqOuterClass.internal_static_ItemRenameAvatarReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ItemRenameAvatarReq getDefaultInstanceForType() {
                return ItemRenameAvatarReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemRenameAvatarReq build() {
                ItemRenameAvatarReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemRenameAvatarReq buildPartial() {
                ItemRenameAvatarReq result = new ItemRenameAvatarReq(this);
                result.renameId_ = this.renameId_;
                result.avatarName_ = this.avatarName_;
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
                if (other instanceof ItemRenameAvatarReq) {
                    return mergeFrom((ItemRenameAvatarReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemRenameAvatarReq other) {
                if (other == ItemRenameAvatarReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getRenameId() != 0) {
                    setRenameId(other.getRenameId());
                }
                if (!other.getAvatarName().isEmpty()) {
                    this.avatarName_ = other.avatarName_;
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
                ItemRenameAvatarReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ItemRenameAvatarReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ItemRenameAvatarReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReqOrBuilder
            public int getRenameId() {
                return this.renameId_;
            }

            public Builder setRenameId(int value) {
                this.renameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRenameId() {
                this.renameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReqOrBuilder
            public String getAvatarName() {
                Object ref = this.avatarName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.avatarName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ItemRenameAvatarReqOuterClass.ItemRenameAvatarReqOrBuilder
            public ByteString getAvatarNameBytes() {
                Object ref = this.avatarName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.avatarName_ = b;
                return b;
            }

            public Builder setAvatarName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.avatarName_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarName() {
                this.avatarName_ = ItemRenameAvatarReq.getDefaultInstance().getAvatarName();
                onChanged();
                return this;
            }

            public Builder setAvatarNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ItemRenameAvatarReq.checkByteStringIsUtf8(value);
                this.avatarName_ = value;
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

        public static ItemRenameAvatarReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ItemRenameAvatarReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ItemRenameAvatarReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ItemRenameAvatarReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
