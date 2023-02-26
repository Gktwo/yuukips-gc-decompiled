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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GachaTransferItemOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaItemOuterClass.class */
public final class GachaItemOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fGachaItem.proto\u001a\u000fItemParam.proto\u001a\u0017GachaTransferItem.proto\"¥\u0001\n\tGachaItem\u0012)\n\rtransferItems\u0018\n \u0003(\u000b2\u0012.GachaTransferItem\u0012\u0016\n\u000eisGachaItemNew\u0018\t \u0001(\b\u0012!\n\rtokenItemList\u0018\f \u0003(\u000b2\n.ItemParam\u0012\u001d\n\tgachaItem\u0018\u0004 \u0001(\u000b2\n.ItemParam\u0012\u0013\n\u000bisFlashCard\u0018\u000b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor(), GachaTransferItemOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GachaItem_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaItem_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaItem_descriptor, new String[]{"TransferItems", "IsGachaItemNew", "TokenItemList", "GachaItem", "IsFlashCard"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaItemOuterClass$GachaItemOrBuilder.class */
    public interface GachaItemOrBuilder extends MessageOrBuilder {
        List<GachaTransferItemOuterClass.GachaTransferItem> getTransferItemsList();

        GachaTransferItemOuterClass.GachaTransferItem getTransferItems(int i);

        int getTransferItemsCount();

        List<? extends GachaTransferItemOuterClass.GachaTransferItemOrBuilder> getTransferItemsOrBuilderList();

        GachaTransferItemOuterClass.GachaTransferItemOrBuilder getTransferItemsOrBuilder(int i);

        boolean getIsGachaItemNew();

        List<ItemParamOuterClass.ItemParam> getTokenItemListList();

        ItemParamOuterClass.ItemParam getTokenItemList(int i);

        int getTokenItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTokenItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getTokenItemListOrBuilder(int i);

        boolean hasGachaItem();

        ItemParamOuterClass.ItemParam getGachaItem();

        ItemParamOuterClass.ItemParamOrBuilder getGachaItemOrBuilder();

        boolean getIsFlashCard();
    }

    private GachaItemOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaItemOuterClass$GachaItem.class */
    public static final class GachaItem extends GeneratedMessageV3 implements GachaItemOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TRANSFERITEMS_FIELD_NUMBER = 10;
        private List<GachaTransferItemOuterClass.GachaTransferItem> transferItems_;
        public static final int ISGACHAITEMNEW_FIELD_NUMBER = 9;
        private boolean isGachaItemNew_;
        public static final int TOKENITEMLIST_FIELD_NUMBER = 12;
        private List<ItemParamOuterClass.ItemParam> tokenItemList_;
        public static final int GACHAITEM_FIELD_NUMBER = 4;
        private ItemParamOuterClass.ItemParam gachaItem_;
        public static final int ISFLASHCARD_FIELD_NUMBER = 11;
        private boolean isFlashCard_;
        private byte memoizedIsInitialized;
        private static final GachaItem DEFAULT_INSTANCE = new GachaItem();
        private static final Parser<GachaItem> PARSER = new AbstractParser<GachaItem>() { // from class: emu.grasscutter.net.proto.GachaItemOuterClass.GachaItem.1
            @Override // com.google.protobuf.Parser
            public GachaItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaItem(input, extensionRegistry);
            }
        };

        private GachaItem(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GachaItem() {
            this.memoizedIsInitialized = -1;
            this.transferItems_ = Collections.emptyList();
            this.tokenItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaItem();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x0123 */
        private GachaItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    ItemParamOuterClass.ItemParam.Builder subBuilder = this.gachaItem_ != null ? this.gachaItem_.toBuilder() : null;
                                    this.gachaItem_ = (ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.gachaItem_);
                                        this.gachaItem_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.isGachaItemNew_ = input.readBool();
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.transferItems_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.transferItems_.add((GachaTransferItemOuterClass.GachaTransferItem) input.readMessage(GachaTransferItemOuterClass.GachaTransferItem.parser(), extensionRegistry));
                                    break;
                                case 88:
                                    this.isFlashCard_ = input.readBool();
                                    break;
                                case 98:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.tokenItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.tokenItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.transferItems_ = Collections.unmodifiableList(this.transferItems_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.tokenItemList_ = Collections.unmodifiableList(this.tokenItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GachaItemOuterClass.internal_static_GachaItem_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaItemOuterClass.internal_static_GachaItem_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaItem.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public List<GachaTransferItemOuterClass.GachaTransferItem> getTransferItemsList() {
            return this.transferItems_;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public List<? extends GachaTransferItemOuterClass.GachaTransferItemOrBuilder> getTransferItemsOrBuilderList() {
            return this.transferItems_;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public int getTransferItemsCount() {
            return this.transferItems_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public GachaTransferItemOuterClass.GachaTransferItem getTransferItems(int index) {
            return this.transferItems_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public GachaTransferItemOuterClass.GachaTransferItemOrBuilder getTransferItemsOrBuilder(int index) {
            return this.transferItems_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public boolean getIsGachaItemNew() {
            return this.isGachaItemNew_;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public List<ItemParamOuterClass.ItemParam> getTokenItemListList() {
            return this.tokenItemList_;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTokenItemListOrBuilderList() {
            return this.tokenItemList_;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public int getTokenItemListCount() {
            return this.tokenItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public ItemParamOuterClass.ItemParam getTokenItemList(int index) {
            return this.tokenItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getTokenItemListOrBuilder(int index) {
            return this.tokenItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public boolean hasGachaItem() {
            return this.gachaItem_ != null;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public ItemParamOuterClass.ItemParam getGachaItem() {
            return this.gachaItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.gachaItem_;
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getGachaItemOrBuilder() {
            return getGachaItem();
        }

        @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
        public boolean getIsFlashCard() {
            return this.isFlashCard_;
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
            if (this.gachaItem_ != null) {
                output.writeMessage(4, getGachaItem());
            }
            if (this.isGachaItemNew_) {
                output.writeBool(9, this.isGachaItemNew_);
            }
            for (int i = 0; i < this.transferItems_.size(); i++) {
                output.writeMessage(10, this.transferItems_.get(i));
            }
            if (this.isFlashCard_) {
                output.writeBool(11, this.isFlashCard_);
            }
            for (int i2 = 0; i2 < this.tokenItemList_.size(); i2++) {
                output.writeMessage(12, this.tokenItemList_.get(i2));
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
            if (this.gachaItem_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(4, getGachaItem());
            }
            if (this.isGachaItemNew_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isGachaItemNew_);
            }
            for (int i = 0; i < this.transferItems_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.transferItems_.get(i));
            }
            if (this.isFlashCard_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isFlashCard_);
            }
            for (int i2 = 0; i2 < this.tokenItemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.tokenItemList_.get(i2));
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
            if (!(obj instanceof GachaItem)) {
                return equals(obj);
            }
            GachaItem other = (GachaItem) obj;
            if (getTransferItemsList().equals(other.getTransferItemsList()) && getIsGachaItemNew() == other.getIsGachaItemNew() && getTokenItemListList().equals(other.getTokenItemListList()) && hasGachaItem() == other.hasGachaItem()) {
                return (!hasGachaItem() || getGachaItem().equals(other.getGachaItem())) && getIsFlashCard() == other.getIsFlashCard() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTransferItemsCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getTransferItemsList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 9)) + Internal.hashBoolean(getIsGachaItemNew());
            if (getTokenItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 12)) + getTokenItemListList().hashCode();
            }
            if (hasGachaItem()) {
                hash2 = (53 * ((37 * hash2) + 4)) + getGachaItem().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 11)) + Internal.hashBoolean(getIsFlashCard()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GachaItem parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaItem parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaItem parseFrom(InputStream input) throws IOException {
            return (GachaItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaItem parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaItem) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaItem parseFrom(CodedInputStream input) throws IOException {
            return (GachaItem) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaItem) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaItem prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaItemOuterClass$GachaItem$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaItemOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<GachaTransferItemOuterClass.GachaTransferItem, GachaTransferItemOuterClass.GachaTransferItem.Builder, GachaTransferItemOuterClass.GachaTransferItemOrBuilder> transferItemsBuilder_;
            private boolean isGachaItemNew_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> tokenItemListBuilder_;
            private ItemParamOuterClass.ItemParam gachaItem_;
            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> gachaItemBuilder_;
            private boolean isFlashCard_;
            private List<GachaTransferItemOuterClass.GachaTransferItem> transferItems_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> tokenItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaItemOuterClass.internal_static_GachaItem_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaItemOuterClass.internal_static_GachaItem_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaItem.alwaysUseFieldBuilders) {
                    getTransferItemsFieldBuilder();
                    getTokenItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.transferItemsBuilder_ == null) {
                    this.transferItems_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.transferItemsBuilder_.clear();
                }
                this.isGachaItemNew_ = false;
                if (this.tokenItemListBuilder_ == null) {
                    this.tokenItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.tokenItemListBuilder_.clear();
                }
                if (this.gachaItemBuilder_ == null) {
                    this.gachaItem_ = null;
                } else {
                    this.gachaItem_ = null;
                    this.gachaItemBuilder_ = null;
                }
                this.isFlashCard_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaItemOuterClass.internal_static_GachaItem_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaItem getDefaultInstanceForType() {
                return GachaItem.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaItem build() {
                GachaItem result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaItem buildPartial() {
                GachaItem result = new GachaItem(this);
                int i = this.bitField0_;
                if (this.transferItemsBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.transferItems_ = Collections.unmodifiableList(this.transferItems_);
                        this.bitField0_ &= -2;
                    }
                    result.transferItems_ = this.transferItems_;
                } else {
                    result.transferItems_ = this.transferItemsBuilder_.build();
                }
                result.isGachaItemNew_ = this.isGachaItemNew_;
                if (this.tokenItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.tokenItemList_ = Collections.unmodifiableList(this.tokenItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.tokenItemList_ = this.tokenItemList_;
                } else {
                    result.tokenItemList_ = this.tokenItemListBuilder_.build();
                }
                if (this.gachaItemBuilder_ == null) {
                    result.gachaItem_ = this.gachaItem_;
                } else {
                    result.gachaItem_ = this.gachaItemBuilder_.build();
                }
                result.isFlashCard_ = this.isFlashCard_;
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
                if (other instanceof GachaItem) {
                    return mergeFrom((GachaItem) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaItem other) {
                if (other == GachaItem.getDefaultInstance()) {
                    return this;
                }
                if (this.transferItemsBuilder_ == null) {
                    if (!other.transferItems_.isEmpty()) {
                        if (this.transferItems_.isEmpty()) {
                            this.transferItems_ = other.transferItems_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTransferItemsIsMutable();
                            this.transferItems_.addAll(other.transferItems_);
                        }
                        onChanged();
                    }
                } else if (!other.transferItems_.isEmpty()) {
                    if (this.transferItemsBuilder_.isEmpty()) {
                        this.transferItemsBuilder_.dispose();
                        this.transferItemsBuilder_ = null;
                        this.transferItems_ = other.transferItems_;
                        this.bitField0_ &= -2;
                        this.transferItemsBuilder_ = GachaItem.alwaysUseFieldBuilders ? getTransferItemsFieldBuilder() : null;
                    } else {
                        this.transferItemsBuilder_.addAllMessages(other.transferItems_);
                    }
                }
                if (other.getIsGachaItemNew()) {
                    setIsGachaItemNew(other.getIsGachaItemNew());
                }
                if (this.tokenItemListBuilder_ == null) {
                    if (!other.tokenItemList_.isEmpty()) {
                        if (this.tokenItemList_.isEmpty()) {
                            this.tokenItemList_ = other.tokenItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureTokenItemListIsMutable();
                            this.tokenItemList_.addAll(other.tokenItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.tokenItemList_.isEmpty()) {
                    if (this.tokenItemListBuilder_.isEmpty()) {
                        this.tokenItemListBuilder_.dispose();
                        this.tokenItemListBuilder_ = null;
                        this.tokenItemList_ = other.tokenItemList_;
                        this.bitField0_ &= -3;
                        this.tokenItemListBuilder_ = GachaItem.alwaysUseFieldBuilders ? getTokenItemListFieldBuilder() : null;
                    } else {
                        this.tokenItemListBuilder_.addAllMessages(other.tokenItemList_);
                    }
                }
                if (other.hasGachaItem()) {
                    mergeGachaItem(other.getGachaItem());
                }
                if (other.getIsFlashCard()) {
                    setIsFlashCard(other.getIsFlashCard());
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
                GachaItem parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaItem.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaItem) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTransferItemsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.transferItems_ = new ArrayList(this.transferItems_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public List<GachaTransferItemOuterClass.GachaTransferItem> getTransferItemsList() {
                if (this.transferItemsBuilder_ == null) {
                    return Collections.unmodifiableList(this.transferItems_);
                }
                return this.transferItemsBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public int getTransferItemsCount() {
                if (this.transferItemsBuilder_ == null) {
                    return this.transferItems_.size();
                }
                return this.transferItemsBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public GachaTransferItemOuterClass.GachaTransferItem getTransferItems(int index) {
                if (this.transferItemsBuilder_ == null) {
                    return this.transferItems_.get(index);
                }
                return this.transferItemsBuilder_.getMessage(index);
            }

            public Builder setTransferItems(int index, GachaTransferItemOuterClass.GachaTransferItem value) {
                if (this.transferItemsBuilder_ != null) {
                    this.transferItemsBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTransferItems(int index, GachaTransferItemOuterClass.GachaTransferItem.Builder builderForValue) {
                if (this.transferItemsBuilder_ == null) {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.transferItemsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTransferItems(GachaTransferItemOuterClass.GachaTransferItem value) {
                if (this.transferItemsBuilder_ != null) {
                    this.transferItemsBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTransferItems(int index, GachaTransferItemOuterClass.GachaTransferItem value) {
                if (this.transferItemsBuilder_ != null) {
                    this.transferItemsBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTransferItems(GachaTransferItemOuterClass.GachaTransferItem.Builder builderForValue) {
                if (this.transferItemsBuilder_ == null) {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.transferItemsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTransferItems(int index, GachaTransferItemOuterClass.GachaTransferItem.Builder builderForValue) {
                if (this.transferItemsBuilder_ == null) {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.transferItemsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTransferItems(Iterable<? extends GachaTransferItemOuterClass.GachaTransferItem> values) {
                if (this.transferItemsBuilder_ == null) {
                    ensureTransferItemsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.transferItems_);
                    onChanged();
                } else {
                    this.transferItemsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTransferItems() {
                if (this.transferItemsBuilder_ == null) {
                    this.transferItems_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.transferItemsBuilder_.clear();
                }
                return this;
            }

            public Builder removeTransferItems(int index) {
                if (this.transferItemsBuilder_ == null) {
                    ensureTransferItemsIsMutable();
                    this.transferItems_.remove(index);
                    onChanged();
                } else {
                    this.transferItemsBuilder_.remove(index);
                }
                return this;
            }

            public GachaTransferItemOuterClass.GachaTransferItem.Builder getTransferItemsBuilder(int index) {
                return getTransferItemsFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public GachaTransferItemOuterClass.GachaTransferItemOrBuilder getTransferItemsOrBuilder(int index) {
                if (this.transferItemsBuilder_ == null) {
                    return this.transferItems_.get(index);
                }
                return this.transferItemsBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public List<? extends GachaTransferItemOuterClass.GachaTransferItemOrBuilder> getTransferItemsOrBuilderList() {
                if (this.transferItemsBuilder_ != null) {
                    return this.transferItemsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.transferItems_);
            }

            public GachaTransferItemOuterClass.GachaTransferItem.Builder addTransferItemsBuilder() {
                return getTransferItemsFieldBuilder().addBuilder(GachaTransferItemOuterClass.GachaTransferItem.getDefaultInstance());
            }

            public GachaTransferItemOuterClass.GachaTransferItem.Builder addTransferItemsBuilder(int index) {
                return getTransferItemsFieldBuilder().addBuilder(index, GachaTransferItemOuterClass.GachaTransferItem.getDefaultInstance());
            }

            public List<GachaTransferItemOuterClass.GachaTransferItem.Builder> getTransferItemsBuilderList() {
                return getTransferItemsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GachaTransferItemOuterClass.GachaTransferItem, GachaTransferItemOuterClass.GachaTransferItem.Builder, GachaTransferItemOuterClass.GachaTransferItemOrBuilder> getTransferItemsFieldBuilder() {
                if (this.transferItemsBuilder_ == null) {
                    this.transferItemsBuilder_ = new RepeatedFieldBuilderV3<>(this.transferItems_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.transferItems_ = null;
                }
                return this.transferItemsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public boolean getIsGachaItemNew() {
                return this.isGachaItemNew_;
            }

            public Builder setIsGachaItemNew(boolean value) {
                this.isGachaItemNew_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGachaItemNew() {
                this.isGachaItemNew_ = false;
                onChanged();
                return this;
            }

            private void ensureTokenItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.tokenItemList_ = new ArrayList(this.tokenItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public List<ItemParamOuterClass.ItemParam> getTokenItemListList() {
                if (this.tokenItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.tokenItemList_);
                }
                return this.tokenItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public int getTokenItemListCount() {
                if (this.tokenItemListBuilder_ == null) {
                    return this.tokenItemList_.size();
                }
                return this.tokenItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public ItemParamOuterClass.ItemParam getTokenItemList(int index) {
                if (this.tokenItemListBuilder_ == null) {
                    return this.tokenItemList_.get(index);
                }
                return this.tokenItemListBuilder_.getMessage(index);
            }

            public Builder setTokenItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.tokenItemListBuilder_ != null) {
                    this.tokenItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTokenItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.tokenItemListBuilder_ == null) {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tokenItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTokenItemList(ItemParamOuterClass.ItemParam value) {
                if (this.tokenItemListBuilder_ != null) {
                    this.tokenItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTokenItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.tokenItemListBuilder_ != null) {
                    this.tokenItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTokenItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.tokenItemListBuilder_ == null) {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.tokenItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTokenItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.tokenItemListBuilder_ == null) {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tokenItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTokenItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.tokenItemListBuilder_ == null) {
                    ensureTokenItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tokenItemList_);
                    onChanged();
                } else {
                    this.tokenItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTokenItemList() {
                if (this.tokenItemListBuilder_ == null) {
                    this.tokenItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.tokenItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTokenItemList(int index) {
                if (this.tokenItemListBuilder_ == null) {
                    ensureTokenItemListIsMutable();
                    this.tokenItemList_.remove(index);
                    onChanged();
                } else {
                    this.tokenItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getTokenItemListBuilder(int index) {
                return getTokenItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getTokenItemListOrBuilder(int index) {
                if (this.tokenItemListBuilder_ == null) {
                    return this.tokenItemList_.get(index);
                }
                return this.tokenItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTokenItemListOrBuilderList() {
                if (this.tokenItemListBuilder_ != null) {
                    return this.tokenItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.tokenItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addTokenItemListBuilder() {
                return getTokenItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addTokenItemListBuilder(int index) {
                return getTokenItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getTokenItemListBuilderList() {
                return getTokenItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getTokenItemListFieldBuilder() {
                if (this.tokenItemListBuilder_ == null) {
                    this.tokenItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.tokenItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.tokenItemList_ = null;
                }
                return this.tokenItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public boolean hasGachaItem() {
                return (this.gachaItemBuilder_ == null && this.gachaItem_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public ItemParamOuterClass.ItemParam getGachaItem() {
                if (this.gachaItemBuilder_ == null) {
                    return this.gachaItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.gachaItem_;
                }
                return this.gachaItemBuilder_.getMessage();
            }

            public Builder setGachaItem(ItemParamOuterClass.ItemParam value) {
                if (this.gachaItemBuilder_ != null) {
                    this.gachaItemBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.gachaItem_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setGachaItem(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.gachaItemBuilder_ == null) {
                    this.gachaItem_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gachaItemBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeGachaItem(ItemParamOuterClass.ItemParam value) {
                if (this.gachaItemBuilder_ == null) {
                    if (this.gachaItem_ != null) {
                        this.gachaItem_ = ItemParamOuterClass.ItemParam.newBuilder(this.gachaItem_).mergeFrom(value).buildPartial();
                    } else {
                        this.gachaItem_ = value;
                    }
                    onChanged();
                } else {
                    this.gachaItemBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearGachaItem() {
                if (this.gachaItemBuilder_ == null) {
                    this.gachaItem_ = null;
                    onChanged();
                } else {
                    this.gachaItem_ = null;
                    this.gachaItemBuilder_ = null;
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getGachaItemBuilder() {
                onChanged();
                return getGachaItemFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getGachaItemOrBuilder() {
                if (this.gachaItemBuilder_ != null) {
                    return this.gachaItemBuilder_.getMessageOrBuilder();
                }
                return this.gachaItem_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.gachaItem_;
            }

            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getGachaItemFieldBuilder() {
                if (this.gachaItemBuilder_ == null) {
                    this.gachaItemBuilder_ = new SingleFieldBuilderV3<>(getGachaItem(), getParentForChildren(), isClean());
                    this.gachaItem_ = null;
                }
                return this.gachaItemBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaItemOuterClass.GachaItemOrBuilder
            public boolean getIsFlashCard() {
                return this.isFlashCard_;
            }

            public Builder setIsFlashCard(boolean value) {
                this.isFlashCard_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFlashCard() {
                this.isFlashCard_ = false;
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

        public static GachaItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaItem> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaItem> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaItem getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
        GachaTransferItemOuterClass.getDescriptor();
    }
}
