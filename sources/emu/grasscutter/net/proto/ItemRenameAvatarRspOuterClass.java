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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarRspOuterClass.class */
public final class ItemRenameAvatarRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ItemRenameAvatarRsp.proto\"H\n\u0013ItemRenameAvatarRsp\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005\u0012\u0010\n\brenameId\u0018\b \u0001(\r\u0012\u000e\n\u0006cdTime\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ItemRenameAvatarRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ItemRenameAvatarRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ItemRenameAvatarRsp_descriptor, new String[]{"Retcode", "RenameId", "CdTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarRspOuterClass$ItemRenameAvatarRspOrBuilder.class */
    public interface ItemRenameAvatarRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getRenameId();

        int getCdTime();
    }

    private ItemRenameAvatarRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarRspOuterClass$ItemRenameAvatarRsp.class */
    public static final class ItemRenameAvatarRsp extends GeneratedMessageV3 implements ItemRenameAvatarRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        public static final int RENAMEID_FIELD_NUMBER = 8;
        private int renameId_;
        public static final int CDTIME_FIELD_NUMBER = 7;
        private int cdTime_;
        private byte memoizedIsInitialized;
        private static final ItemRenameAvatarRsp DEFAULT_INSTANCE = new ItemRenameAvatarRsp();
        private static final Parser<ItemRenameAvatarRsp> PARSER = new AbstractParser<ItemRenameAvatarRsp>() { // from class: emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRsp.1
            @Override // com.google.protobuf.Parser
            public ItemRenameAvatarRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemRenameAvatarRsp(input, extensionRegistry);
            }
        };

        private ItemRenameAvatarRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ItemRenameAvatarRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ItemRenameAvatarRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ItemRenameAvatarRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.cdTime_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.renameId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.retcode_ = input.readInt32();
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
            return ItemRenameAvatarRspOuterClass.internal_static_ItemRenameAvatarRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemRenameAvatarRspOuterClass.internal_static_ItemRenameAvatarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemRenameAvatarRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRspOrBuilder
        public int getRenameId() {
            return this.renameId_;
        }

        @Override // emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRspOrBuilder
        public int getCdTime() {
            return this.cdTime_;
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
            if (this.cdTime_ != 0) {
                output.writeUInt32(7, this.cdTime_);
            }
            if (this.renameId_ != 0) {
                output.writeUInt32(8, this.renameId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            if (this.cdTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(7, this.cdTime_);
            }
            if (this.renameId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.renameId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof ItemRenameAvatarRsp)) {
                return equals(obj);
            }
            ItemRenameAvatarRsp other = (ItemRenameAvatarRsp) obj;
            return getRetcode() == other.getRetcode() && getRenameId() == other.getRenameId() && getCdTime() == other.getCdTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getRetcode())) + 8)) + getRenameId())) + 7)) + getCdTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ItemRenameAvatarRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemRenameAvatarRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemRenameAvatarRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemRenameAvatarRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemRenameAvatarRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemRenameAvatarRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemRenameAvatarRsp parseFrom(InputStream input) throws IOException {
            return (ItemRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemRenameAvatarRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemRenameAvatarRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemRenameAvatarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ItemRenameAvatarRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemRenameAvatarRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemRenameAvatarRsp parseFrom(CodedInputStream input) throws IOException {
            return (ItemRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemRenameAvatarRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemRenameAvatarRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ItemRenameAvatarRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemRenameAvatarRspOuterClass$ItemRenameAvatarRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ItemRenameAvatarRspOrBuilder {
            private int retcode_;
            private int renameId_;
            private int cdTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemRenameAvatarRspOuterClass.internal_static_ItemRenameAvatarRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemRenameAvatarRspOuterClass.internal_static_ItemRenameAvatarRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemRenameAvatarRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemRenameAvatarRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.renameId_ = 0;
                this.cdTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ItemRenameAvatarRspOuterClass.internal_static_ItemRenameAvatarRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ItemRenameAvatarRsp getDefaultInstanceForType() {
                return ItemRenameAvatarRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemRenameAvatarRsp build() {
                ItemRenameAvatarRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemRenameAvatarRsp buildPartial() {
                ItemRenameAvatarRsp result = new ItemRenameAvatarRsp(this);
                result.retcode_ = this.retcode_;
                result.renameId_ = this.renameId_;
                result.cdTime_ = this.cdTime_;
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
                if (other instanceof ItemRenameAvatarRsp) {
                    return mergeFrom((ItemRenameAvatarRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemRenameAvatarRsp other) {
                if (other == ItemRenameAvatarRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getRenameId() != 0) {
                    setRenameId(other.getRenameId());
                }
                if (other.getCdTime() != 0) {
                    setCdTime(other.getCdTime());
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
                ItemRenameAvatarRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ItemRenameAvatarRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ItemRenameAvatarRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ItemRenameAvatarRspOuterClass.ItemRenameAvatarRspOrBuilder
            public int getCdTime() {
                return this.cdTime_;
            }

            public Builder setCdTime(int value) {
                this.cdTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCdTime() {
                this.cdTime_ = 0;
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

        public static ItemRenameAvatarRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ItemRenameAvatarRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ItemRenameAvatarRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ItemRenameAvatarRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
