package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AddNoGachaAvatarCardTransferItemOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardNotifyOuterClass.class */
public final class AddNoGachaAvatarCardNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n AddNoGachaAvatarCardNotify.proto\u001a&AddNoGachaAvatarCardTransferItem.proto\"â\u0001\n\u001aAddNoGachaAvatarCardNotify\u0012\u000e\n\u0006reason\u0018\t \u0001(\r\u0012\u001d\n\u0015initial_promote_level\u0018\u0007 \u0001(\r\u0012\u000f\n\u0007item_id\u0018\u0002 \u0001(\r\u0012\u0011\n\tavatar_id\u0018\u0004 \u0001(\r\u0012\u001b\n\u0013is_transfer_to_item\u0018\u000e \u0001(\b\u0012\u0015\n\rinitial_level\u0018\b \u0001(\r\u0012=\n\u0012transfer_item_list\u0018\u0006 \u0003(\u000b2!.AddNoGachaAvatarCardTransferItemB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AddNoGachaAvatarCardTransferItemOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AddNoGachaAvatarCardNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AddNoGachaAvatarCardNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AddNoGachaAvatarCardNotify_descriptor, new String[]{"Reason", "InitialPromoteLevel", "ItemId", "AvatarId", "IsTransferToItem", "InitialLevel", "TransferItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardNotifyOuterClass$AddNoGachaAvatarCardNotifyOrBuilder.class */
    public interface AddNoGachaAvatarCardNotifyOrBuilder extends MessageOrBuilder {
        int getReason();

        int getInitialPromoteLevel();

        int getItemId();

        int getAvatarId();

        boolean getIsTransferToItem();

        int getInitialLevel();

        List<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem> getTransferItemListList();

        AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem getTransferItemList(int i);

        int getTransferItemListCount();

        List<? extends AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder> getTransferItemListOrBuilderList();

        AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder getTransferItemListOrBuilder(int i);
    }

    private AddNoGachaAvatarCardNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardNotifyOuterClass$AddNoGachaAvatarCardNotify.class */
    public static final class AddNoGachaAvatarCardNotify extends GeneratedMessageV3 implements AddNoGachaAvatarCardNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REASON_FIELD_NUMBER = 9;
        private int reason_;
        public static final int INITIAL_PROMOTE_LEVEL_FIELD_NUMBER = 7;
        private int initialPromoteLevel_;
        public static final int ITEM_ID_FIELD_NUMBER = 2;
        private int itemId_;
        public static final int AVATAR_ID_FIELD_NUMBER = 4;
        private int avatarId_;
        public static final int IS_TRANSFER_TO_ITEM_FIELD_NUMBER = 14;
        private boolean isTransferToItem_;
        public static final int INITIAL_LEVEL_FIELD_NUMBER = 8;
        private int initialLevel_;
        public static final int TRANSFER_ITEM_LIST_FIELD_NUMBER = 6;
        private List<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem> transferItemList_;
        private byte memoizedIsInitialized;
        private static final AddNoGachaAvatarCardNotify DEFAULT_INSTANCE = new AddNoGachaAvatarCardNotify();
        private static final Parser<AddNoGachaAvatarCardNotify> PARSER = new AbstractParser<AddNoGachaAvatarCardNotify>() { // from class: emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotify.1
            @Override // com.google.protobuf.Parser
            public AddNoGachaAvatarCardNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AddNoGachaAvatarCardNotify(input, extensionRegistry);
            }
        };

        private AddNoGachaAvatarCardNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AddNoGachaAvatarCardNotify() {
            this.memoizedIsInitialized = -1;
            this.transferItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AddNoGachaAvatarCardNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddNoGachaAvatarCardNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 16:
                                    this.itemId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.avatarId_ = input.readUInt32();
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.transferItemList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.transferItemList_.add((AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem) input.readMessage(AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.parser(), extensionRegistry));
                                    break;
                                case 56:
                                    this.initialPromoteLevel_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.initialLevel_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.reason_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.isTransferToItem_ = input.readBool();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.transferItemList_ = Collections.unmodifiableList(this.transferItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AddNoGachaAvatarCardNotifyOuterClass.internal_static_AddNoGachaAvatarCardNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AddNoGachaAvatarCardNotifyOuterClass.internal_static_AddNoGachaAvatarCardNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AddNoGachaAvatarCardNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public int getReason() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public int getInitialPromoteLevel() {
            return this.initialPromoteLevel_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public boolean getIsTransferToItem() {
            return this.isTransferToItem_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public int getInitialLevel() {
            return this.initialLevel_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public List<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem> getTransferItemListList() {
            return this.transferItemList_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public List<? extends AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder> getTransferItemListOrBuilderList() {
            return this.transferItemList_;
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public int getTransferItemListCount() {
            return this.transferItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem getTransferItemList(int index) {
            return this.transferItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
        public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder getTransferItemListOrBuilder(int index) {
            return this.transferItemList_.get(index);
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
                output.writeUInt32(2, this.itemId_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(4, this.avatarId_);
            }
            for (int i = 0; i < this.transferItemList_.size(); i++) {
                output.writeMessage(6, this.transferItemList_.get(i));
            }
            if (this.initialPromoteLevel_ != 0) {
                output.writeUInt32(7, this.initialPromoteLevel_);
            }
            if (this.initialLevel_ != 0) {
                output.writeUInt32(8, this.initialLevel_);
            }
            if (this.reason_ != 0) {
                output.writeUInt32(9, this.reason_);
            }
            if (this.isTransferToItem_) {
                output.writeBool(14, this.isTransferToItem_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.itemId_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.avatarId_);
            }
            for (int i = 0; i < this.transferItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.transferItemList_.get(i));
            }
            if (this.initialPromoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.initialPromoteLevel_);
            }
            if (this.initialLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.initialLevel_);
            }
            if (this.reason_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.reason_);
            }
            if (this.isTransferToItem_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isTransferToItem_);
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
            if (!(obj instanceof AddNoGachaAvatarCardNotify)) {
                return equals(obj);
            }
            AddNoGachaAvatarCardNotify other = (AddNoGachaAvatarCardNotify) obj;
            return getReason() == other.getReason() && getInitialPromoteLevel() == other.getInitialPromoteLevel() && getItemId() == other.getItemId() && getAvatarId() == other.getAvatarId() && getIsTransferToItem() == other.getIsTransferToItem() && getInitialLevel() == other.getInitialLevel() && getTransferItemListList().equals(other.getTransferItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getReason())) + 7)) + getInitialPromoteLevel())) + 2)) + getItemId())) + 4)) + getAvatarId())) + 14)) + Internal.hashBoolean(getIsTransferToItem()))) + 8)) + getInitialLevel();
            if (getTransferItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getTransferItemListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AddNoGachaAvatarCardNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(InputStream input) throws IOException {
            return (AddNoGachaAvatarCardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddNoGachaAvatarCardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AddNoGachaAvatarCardNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AddNoGachaAvatarCardNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AddNoGachaAvatarCardNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddNoGachaAvatarCardNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(CodedInputStream input) throws IOException {
            return (AddNoGachaAvatarCardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AddNoGachaAvatarCardNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AddNoGachaAvatarCardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AddNoGachaAvatarCardNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AddNoGachaAvatarCardNotifyOuterClass$AddNoGachaAvatarCardNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AddNoGachaAvatarCardNotifyOrBuilder {
            private int bitField0_;
            private int reason_;
            private int initialPromoteLevel_;
            private int itemId_;
            private int avatarId_;
            private boolean isTransferToItem_;
            private int initialLevel_;
            private List<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem> transferItemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder> transferItemListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AddNoGachaAvatarCardNotifyOuterClass.internal_static_AddNoGachaAvatarCardNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AddNoGachaAvatarCardNotifyOuterClass.internal_static_AddNoGachaAvatarCardNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AddNoGachaAvatarCardNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AddNoGachaAvatarCardNotify.alwaysUseFieldBuilders) {
                    getTransferItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.reason_ = 0;
                this.initialPromoteLevel_ = 0;
                this.itemId_ = 0;
                this.avatarId_ = 0;
                this.isTransferToItem_ = false;
                this.initialLevel_ = 0;
                if (this.transferItemListBuilder_ == null) {
                    this.transferItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.transferItemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AddNoGachaAvatarCardNotifyOuterClass.internal_static_AddNoGachaAvatarCardNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AddNoGachaAvatarCardNotify getDefaultInstanceForType() {
                return AddNoGachaAvatarCardNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddNoGachaAvatarCardNotify build() {
                AddNoGachaAvatarCardNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AddNoGachaAvatarCardNotify buildPartial() {
                AddNoGachaAvatarCardNotify result = new AddNoGachaAvatarCardNotify(this);
                int i = this.bitField0_;
                result.reason_ = this.reason_;
                result.initialPromoteLevel_ = this.initialPromoteLevel_;
                result.itemId_ = this.itemId_;
                result.avatarId_ = this.avatarId_;
                result.isTransferToItem_ = this.isTransferToItem_;
                result.initialLevel_ = this.initialLevel_;
                if (this.transferItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.transferItemList_ = Collections.unmodifiableList(this.transferItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.transferItemList_ = this.transferItemList_;
                } else {
                    result.transferItemList_ = this.transferItemListBuilder_.build();
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
                if (other instanceof AddNoGachaAvatarCardNotify) {
                    return mergeFrom((AddNoGachaAvatarCardNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AddNoGachaAvatarCardNotify other) {
                if (other == AddNoGachaAvatarCardNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getReason() != 0) {
                    setReason(other.getReason());
                }
                if (other.getInitialPromoteLevel() != 0) {
                    setInitialPromoteLevel(other.getInitialPromoteLevel());
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getIsTransferToItem()) {
                    setIsTransferToItem(other.getIsTransferToItem());
                }
                if (other.getInitialLevel() != 0) {
                    setInitialLevel(other.getInitialLevel());
                }
                if (this.transferItemListBuilder_ == null) {
                    if (!other.transferItemList_.isEmpty()) {
                        if (this.transferItemList_.isEmpty()) {
                            this.transferItemList_ = other.transferItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTransferItemListIsMutable();
                            this.transferItemList_.addAll(other.transferItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.transferItemList_.isEmpty()) {
                    if (this.transferItemListBuilder_.isEmpty()) {
                        this.transferItemListBuilder_.dispose();
                        this.transferItemListBuilder_ = null;
                        this.transferItemList_ = other.transferItemList_;
                        this.bitField0_ &= -2;
                        this.transferItemListBuilder_ = AddNoGachaAvatarCardNotify.alwaysUseFieldBuilders ? getTransferItemListFieldBuilder() : null;
                    } else {
                        this.transferItemListBuilder_.addAllMessages(other.transferItemList_);
                    }
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
                AddNoGachaAvatarCardNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AddNoGachaAvatarCardNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AddNoGachaAvatarCardNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public int getReason() {
                return this.reason_;
            }

            public Builder setReason(int value) {
                this.reason_ = value;
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public int getInitialPromoteLevel() {
                return this.initialPromoteLevel_;
            }

            public Builder setInitialPromoteLevel(int value) {
                this.initialPromoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearInitialPromoteLevel() {
                this.initialPromoteLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public boolean getIsTransferToItem() {
                return this.isTransferToItem_;
            }

            public Builder setIsTransferToItem(boolean value) {
                this.isTransferToItem_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTransferToItem() {
                this.isTransferToItem_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public int getInitialLevel() {
                return this.initialLevel_;
            }

            public Builder setInitialLevel(int value) {
                this.initialLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearInitialLevel() {
                this.initialLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureTransferItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.transferItemList_ = new ArrayList(this.transferItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public List<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem> getTransferItemListList() {
                if (this.transferItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.transferItemList_);
                }
                return this.transferItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public int getTransferItemListCount() {
                if (this.transferItemListBuilder_ == null) {
                    return this.transferItemList_.size();
                }
                return this.transferItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem getTransferItemList(int index) {
                if (this.transferItemListBuilder_ == null) {
                    return this.transferItemList_.get(index);
                }
                return this.transferItemListBuilder_.getMessage(index);
            }

            public Builder setTransferItemList(int index, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem value) {
                if (this.transferItemListBuilder_ != null) {
                    this.transferItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTransferItemList(int index, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder builderForValue) {
                if (this.transferItemListBuilder_ == null) {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.transferItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTransferItemList(AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem value) {
                if (this.transferItemListBuilder_ != null) {
                    this.transferItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTransferItemList(int index, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem value) {
                if (this.transferItemListBuilder_ != null) {
                    this.transferItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTransferItemList(AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder builderForValue) {
                if (this.transferItemListBuilder_ == null) {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.transferItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTransferItemList(int index, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder builderForValue) {
                if (this.transferItemListBuilder_ == null) {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.transferItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTransferItemList(Iterable<? extends AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem> values) {
                if (this.transferItemListBuilder_ == null) {
                    ensureTransferItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.transferItemList_);
                    onChanged();
                } else {
                    this.transferItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTransferItemList() {
                if (this.transferItemListBuilder_ == null) {
                    this.transferItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.transferItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTransferItemList(int index) {
                if (this.transferItemListBuilder_ == null) {
                    ensureTransferItemListIsMutable();
                    this.transferItemList_.remove(index);
                    onChanged();
                } else {
                    this.transferItemListBuilder_.remove(index);
                }
                return this;
            }

            public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder getTransferItemListBuilder(int index) {
                return getTransferItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder getTransferItemListOrBuilder(int index) {
                if (this.transferItemListBuilder_ == null) {
                    return this.transferItemList_.get(index);
                }
                return this.transferItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotifyOrBuilder
            public List<? extends AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder> getTransferItemListOrBuilderList() {
                if (this.transferItemListBuilder_ != null) {
                    return this.transferItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.transferItemList_);
            }

            public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder addTransferItemListBuilder() {
                return getTransferItemListFieldBuilder().addBuilder(AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.getDefaultInstance());
            }

            public AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder addTransferItemListBuilder(int index) {
                return getTransferItemListFieldBuilder().addBuilder(index, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.getDefaultInstance());
            }

            public List<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder> getTransferItemListBuilderList() {
                return getTransferItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItem.Builder, AddNoGachaAvatarCardTransferItemOuterClass.AddNoGachaAvatarCardTransferItemOrBuilder> getTransferItemListFieldBuilder() {
                if (this.transferItemListBuilder_ == null) {
                    this.transferItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.transferItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.transferItemList_ = null;
                }
                return this.transferItemListBuilder_;
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

        public static AddNoGachaAvatarCardNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AddNoGachaAvatarCardNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AddNoGachaAvatarCardNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AddNoGachaAvatarCardNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AddNoGachaAvatarCardTransferItemOuterClass.getDescriptor();
    }
}
