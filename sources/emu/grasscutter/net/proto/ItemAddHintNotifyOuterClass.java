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
import emu.grasscutter.net.proto.ItemHintOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemAddHintNotifyOuterClass.class */
public final class ItemAddHintNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ItemAddHintNotify.proto\u001a\u000eItemHint.proto\u001a\fVector.proto\"ø\u0001\n\u0011ItemAddHintNotify\u0012\u001b\n\u0013Unk3300_FLIKEBJINCL\u0018\u0005 \u0001(\b\u0012\u001b\n\u0013Unk3300_NIJLGEHNBNC\u0018\u0004 \u0001(\b\u0012\u001c\n\titem_list\u0018\u000b \u0003(\u000b2\t.ItemHint\u00121\n\u001eoverflow_transformed_item_list\u0018\u0001 \u0003(\u000b2\t.ItemHint\u0012\u001b\n\u0013Unk3300_KIOMJNHFMDE\u0018\u0006 \u0001(\b\u0012\u000e\n\u0006reason\u0018\u000e \u0001(\r\u0012\u0019\n\bposition\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bquest_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemHintOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ItemAddHintNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ItemAddHintNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ItemAddHintNotify_descriptor, new String[]{"Unk3300FLIKEBJINCL", "Unk3300NIJLGEHNBNC", "ItemList", "OverflowTransformedItemList", "Unk3300KIOMJNHFMDE", "Reason", "Position", "QuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemAddHintNotifyOuterClass$ItemAddHintNotifyOrBuilder.class */
    public interface ItemAddHintNotifyOrBuilder extends MessageOrBuilder {
        boolean getUnk3300FLIKEBJINCL();

        boolean getUnk3300NIJLGEHNBNC();

        List<ItemHintOuterClass.ItemHint> getItemListList();

        ItemHintOuterClass.ItemHint getItemList(int i);

        int getItemListCount();

        List<? extends ItemHintOuterClass.ItemHintOrBuilder> getItemListOrBuilderList();

        ItemHintOuterClass.ItemHintOrBuilder getItemListOrBuilder(int i);

        List<ItemHintOuterClass.ItemHint> getOverflowTransformedItemListList();

        ItemHintOuterClass.ItemHint getOverflowTransformedItemList(int i);

        int getOverflowTransformedItemListCount();

        List<? extends ItemHintOuterClass.ItemHintOrBuilder> getOverflowTransformedItemListOrBuilderList();

        ItemHintOuterClass.ItemHintOrBuilder getOverflowTransformedItemListOrBuilder(int i);

        boolean getUnk3300KIOMJNHFMDE();

        int getReason();

        boolean hasPosition();

        VectorOuterClass.Vector getPosition();

        VectorOuterClass.VectorOrBuilder getPositionOrBuilder();

        int getQuestId();
    }

    private ItemAddHintNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemAddHintNotifyOuterClass$ItemAddHintNotify.class */
    public static final class ItemAddHintNotify extends GeneratedMessageV3 implements ItemAddHintNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_FLIKEBJINCL_FIELD_NUMBER = 5;
        private boolean unk3300FLIKEBJINCL_;
        public static final int UNK3300_NIJLGEHNBNC_FIELD_NUMBER = 4;
        private boolean unk3300NIJLGEHNBNC_;
        public static final int ITEM_LIST_FIELD_NUMBER = 11;
        private List<ItemHintOuterClass.ItemHint> itemList_;
        public static final int OVERFLOW_TRANSFORMED_ITEM_LIST_FIELD_NUMBER = 1;
        private List<ItemHintOuterClass.ItemHint> overflowTransformedItemList_;
        public static final int UNK3300_KIOMJNHFMDE_FIELD_NUMBER = 6;
        private boolean unk3300KIOMJNHFMDE_;
        public static final int REASON_FIELD_NUMBER = 14;
        private int reason_;
        public static final int POSITION_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector position_;
        public static final int QUEST_ID_FIELD_NUMBER = 3;
        private int questId_;
        private byte memoizedIsInitialized;
        private static final ItemAddHintNotify DEFAULT_INSTANCE = new ItemAddHintNotify();
        private static final Parser<ItemAddHintNotify> PARSER = new AbstractParser<ItemAddHintNotify>() { // from class: emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotify.1
            @Override // com.google.protobuf.Parser
            public ItemAddHintNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ItemAddHintNotify(input, extensionRegistry);
            }
        };

        private ItemAddHintNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ItemAddHintNotify() {
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
            this.overflowTransformedItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ItemAddHintNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x015c */
        private ItemAddHintNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.overflowTransformedItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.overflowTransformedItemList_.add((ItemHintOuterClass.ItemHint) input.readMessage(ItemHintOuterClass.ItemHint.parser(), extensionRegistry));
                                break;
                            case 24:
                                this.questId_ = input.readUInt32();
                                break;
                            case 32:
                                this.unk3300NIJLGEHNBNC_ = input.readBool();
                                break;
                            case 40:
                                this.unk3300FLIKEBJINCL_ = input.readBool();
                                break;
                            case 48:
                                this.unk3300KIOMJNHFMDE_ = input.readBool();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.itemList_.add((ItemHintOuterClass.ItemHint) input.readMessage(ItemHintOuterClass.ItemHint.parser(), extensionRegistry));
                                break;
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder = this.position_ != null ? this.position_.toBuilder() : null;
                                this.position_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.position_);
                                    this.position_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.reason_ = input.readUInt32();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.overflowTransformedItemList_ = Collections.unmodifiableList(this.overflowTransformedItemList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ItemAddHintNotifyOuterClass.internal_static_ItemAddHintNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemAddHintNotifyOuterClass.internal_static_ItemAddHintNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemAddHintNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public boolean getUnk3300FLIKEBJINCL() {
            return this.unk3300FLIKEBJINCL_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public boolean getUnk3300NIJLGEHNBNC() {
            return this.unk3300NIJLGEHNBNC_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public List<ItemHintOuterClass.ItemHint> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public List<? extends ItemHintOuterClass.ItemHintOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public ItemHintOuterClass.ItemHint getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public ItemHintOuterClass.ItemHintOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public List<ItemHintOuterClass.ItemHint> getOverflowTransformedItemListList() {
            return this.overflowTransformedItemList_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public List<? extends ItemHintOuterClass.ItemHintOrBuilder> getOverflowTransformedItemListOrBuilderList() {
            return this.overflowTransformedItemList_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public int getOverflowTransformedItemListCount() {
            return this.overflowTransformedItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public ItemHintOuterClass.ItemHint getOverflowTransformedItemList(int index) {
            return this.overflowTransformedItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public ItemHintOuterClass.ItemHintOrBuilder getOverflowTransformedItemListOrBuilder(int index) {
            return this.overflowTransformedItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public boolean getUnk3300KIOMJNHFMDE() {
            return this.unk3300KIOMJNHFMDE_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public int getReason() {
            return this.reason_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public boolean hasPosition() {
            return this.position_ != null;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public VectorOuterClass.Vector getPosition() {
            return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
            return getPosition();
        }

        @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
        public int getQuestId() {
            return this.questId_;
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
            for (int i = 0; i < this.overflowTransformedItemList_.size(); i++) {
                output.writeMessage(1, this.overflowTransformedItemList_.get(i));
            }
            if (this.questId_ != 0) {
                output.writeUInt32(3, this.questId_);
            }
            if (this.unk3300NIJLGEHNBNC_) {
                output.writeBool(4, this.unk3300NIJLGEHNBNC_);
            }
            if (this.unk3300FLIKEBJINCL_) {
                output.writeBool(5, this.unk3300FLIKEBJINCL_);
            }
            if (this.unk3300KIOMJNHFMDE_) {
                output.writeBool(6, this.unk3300KIOMJNHFMDE_);
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                output.writeMessage(11, this.itemList_.get(i2));
            }
            if (this.position_ != null) {
                output.writeMessage(12, getPosition());
            }
            if (this.reason_ != 0) {
                output.writeUInt32(14, this.reason_);
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
            for (int i = 0; i < this.overflowTransformedItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.overflowTransformedItemList_.get(i));
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.questId_);
            }
            if (this.unk3300NIJLGEHNBNC_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.unk3300NIJLGEHNBNC_);
            }
            if (this.unk3300FLIKEBJINCL_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.unk3300FLIKEBJINCL_);
            }
            if (this.unk3300KIOMJNHFMDE_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.unk3300KIOMJNHFMDE_);
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.itemList_.get(i2));
            }
            if (this.position_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getPosition());
            }
            if (this.reason_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.reason_);
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
            if (!(obj instanceof ItemAddHintNotify)) {
                return equals(obj);
            }
            ItemAddHintNotify other = (ItemAddHintNotify) obj;
            if (getUnk3300FLIKEBJINCL() == other.getUnk3300FLIKEBJINCL() && getUnk3300NIJLGEHNBNC() == other.getUnk3300NIJLGEHNBNC() && getItemListList().equals(other.getItemListList()) && getOverflowTransformedItemListList().equals(other.getOverflowTransformedItemListList()) && getUnk3300KIOMJNHFMDE() == other.getUnk3300KIOMJNHFMDE() && getReason() == other.getReason() && hasPosition() == other.hasPosition()) {
                return (!hasPosition() || getPosition().equals(other.getPosition())) && getQuestId() == other.getQuestId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashBoolean(getUnk3300FLIKEBJINCL()))) + 4)) + Internal.hashBoolean(getUnk3300NIJLGEHNBNC());
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getItemListList().hashCode();
            }
            if (getOverflowTransformedItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getOverflowTransformedItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 6)) + Internal.hashBoolean(getUnk3300KIOMJNHFMDE()))) + 14)) + getReason();
            if (hasPosition()) {
                hash2 = (53 * ((37 * hash2) + 12)) + getPosition().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 3)) + getQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ItemAddHintNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemAddHintNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemAddHintNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemAddHintNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemAddHintNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ItemAddHintNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ItemAddHintNotify parseFrom(InputStream input) throws IOException {
            return (ItemAddHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemAddHintNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemAddHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemAddHintNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ItemAddHintNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ItemAddHintNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemAddHintNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ItemAddHintNotify parseFrom(CodedInputStream input) throws IOException {
            return (ItemAddHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ItemAddHintNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ItemAddHintNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ItemAddHintNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemAddHintNotifyOuterClass$ItemAddHintNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ItemAddHintNotifyOrBuilder {
            private int bitField0_;
            private boolean unk3300FLIKEBJINCL_;
            private boolean unk3300NIJLGEHNBNC_;
            private RepeatedFieldBuilderV3<ItemHintOuterClass.ItemHint, ItemHintOuterClass.ItemHint.Builder, ItemHintOuterClass.ItemHintOrBuilder> itemListBuilder_;
            private RepeatedFieldBuilderV3<ItemHintOuterClass.ItemHint, ItemHintOuterClass.ItemHint.Builder, ItemHintOuterClass.ItemHintOrBuilder> overflowTransformedItemListBuilder_;
            private boolean unk3300KIOMJNHFMDE_;
            private int reason_;
            private VectorOuterClass.Vector position_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> positionBuilder_;
            private int questId_;
            private List<ItemHintOuterClass.ItemHint> itemList_ = Collections.emptyList();
            private List<ItemHintOuterClass.ItemHint> overflowTransformedItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemAddHintNotifyOuterClass.internal_static_ItemAddHintNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemAddHintNotifyOuterClass.internal_static_ItemAddHintNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ItemAddHintNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ItemAddHintNotify.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                    getOverflowTransformedItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300FLIKEBJINCL_ = false;
                this.unk3300NIJLGEHNBNC_ = false;
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                if (this.overflowTransformedItemListBuilder_ == null) {
                    this.overflowTransformedItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.overflowTransformedItemListBuilder_.clear();
                }
                this.unk3300KIOMJNHFMDE_ = false;
                this.reason_ = 0;
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                this.questId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ItemAddHintNotifyOuterClass.internal_static_ItemAddHintNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ItemAddHintNotify getDefaultInstanceForType() {
                return ItemAddHintNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemAddHintNotify build() {
                ItemAddHintNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ItemAddHintNotify buildPartial() {
                ItemAddHintNotify result = new ItemAddHintNotify(this);
                int i = this.bitField0_;
                result.unk3300FLIKEBJINCL_ = this.unk3300FLIKEBJINCL_;
                result.unk3300NIJLGEHNBNC_ = this.unk3300NIJLGEHNBNC_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                if (this.overflowTransformedItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.overflowTransformedItemList_ = Collections.unmodifiableList(this.overflowTransformedItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.overflowTransformedItemList_ = this.overflowTransformedItemList_;
                } else {
                    result.overflowTransformedItemList_ = this.overflowTransformedItemListBuilder_.build();
                }
                result.unk3300KIOMJNHFMDE_ = this.unk3300KIOMJNHFMDE_;
                result.reason_ = this.reason_;
                if (this.positionBuilder_ == null) {
                    result.position_ = this.position_;
                } else {
                    result.position_ = this.positionBuilder_.build();
                }
                result.questId_ = this.questId_;
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
                if (other instanceof ItemAddHintNotify) {
                    return mergeFrom((ItemAddHintNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ItemAddHintNotify other) {
                if (other == ItemAddHintNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300FLIKEBJINCL()) {
                    setUnk3300FLIKEBJINCL(other.getUnk3300FLIKEBJINCL());
                }
                if (other.getUnk3300NIJLGEHNBNC()) {
                    setUnk3300NIJLGEHNBNC(other.getUnk3300NIJLGEHNBNC());
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemListIsMutable();
                            this.itemList_.addAll(other.itemList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemList_.isEmpty()) {
                    if (this.itemListBuilder_.isEmpty()) {
                        this.itemListBuilder_.dispose();
                        this.itemListBuilder_ = null;
                        this.itemList_ = other.itemList_;
                        this.bitField0_ &= -2;
                        this.itemListBuilder_ = ItemAddHintNotify.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (this.overflowTransformedItemListBuilder_ == null) {
                    if (!other.overflowTransformedItemList_.isEmpty()) {
                        if (this.overflowTransformedItemList_.isEmpty()) {
                            this.overflowTransformedItemList_ = other.overflowTransformedItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureOverflowTransformedItemListIsMutable();
                            this.overflowTransformedItemList_.addAll(other.overflowTransformedItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.overflowTransformedItemList_.isEmpty()) {
                    if (this.overflowTransformedItemListBuilder_.isEmpty()) {
                        this.overflowTransformedItemListBuilder_.dispose();
                        this.overflowTransformedItemListBuilder_ = null;
                        this.overflowTransformedItemList_ = other.overflowTransformedItemList_;
                        this.bitField0_ &= -3;
                        this.overflowTransformedItemListBuilder_ = ItemAddHintNotify.alwaysUseFieldBuilders ? getOverflowTransformedItemListFieldBuilder() : null;
                    } else {
                        this.overflowTransformedItemListBuilder_.addAllMessages(other.overflowTransformedItemList_);
                    }
                }
                if (other.getUnk3300KIOMJNHFMDE()) {
                    setUnk3300KIOMJNHFMDE(other.getUnk3300KIOMJNHFMDE());
                }
                if (other.getReason() != 0) {
                    setReason(other.getReason());
                }
                if (other.hasPosition()) {
                    mergePosition(other.getPosition());
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
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
                ItemAddHintNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ItemAddHintNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ItemAddHintNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public boolean getUnk3300FLIKEBJINCL() {
                return this.unk3300FLIKEBJINCL_;
            }

            public Builder setUnk3300FLIKEBJINCL(boolean value) {
                this.unk3300FLIKEBJINCL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FLIKEBJINCL() {
                this.unk3300FLIKEBJINCL_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public boolean getUnk3300NIJLGEHNBNC() {
                return this.unk3300NIJLGEHNBNC_;
            }

            public Builder setUnk3300NIJLGEHNBNC(boolean value) {
                this.unk3300NIJLGEHNBNC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NIJLGEHNBNC() {
                this.unk3300NIJLGEHNBNC_ = false;
                onChanged();
                return this;
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public List<ItemHintOuterClass.ItemHint> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public ItemHintOuterClass.ItemHint getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, ItemHintOuterClass.ItemHint value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemList(int index, ItemHintOuterClass.ItemHint.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(ItemHintOuterClass.ItemHint value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(int index, ItemHintOuterClass.ItemHint value) {
                if (this.itemListBuilder_ != null) {
                    this.itemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemList(ItemHintOuterClass.ItemHint.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, ItemHintOuterClass.ItemHint.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends ItemHintOuterClass.ItemHint> values) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemList_);
                    onChanged();
                } else {
                    this.itemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemList() {
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.remove(index);
                    onChanged();
                } else {
                    this.itemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemHintOuterClass.ItemHint.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public ItemHintOuterClass.ItemHintOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public List<? extends ItemHintOuterClass.ItemHintOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public ItemHintOuterClass.ItemHint.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(ItemHintOuterClass.ItemHint.getDefaultInstance());
            }

            public ItemHintOuterClass.ItemHint.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, ItemHintOuterClass.ItemHint.getDefaultInstance());
            }

            public List<ItemHintOuterClass.ItemHint.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemHintOuterClass.ItemHint, ItemHintOuterClass.ItemHint.Builder, ItemHintOuterClass.ItemHintOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }

            private void ensureOverflowTransformedItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.overflowTransformedItemList_ = new ArrayList(this.overflowTransformedItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public List<ItemHintOuterClass.ItemHint> getOverflowTransformedItemListList() {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.overflowTransformedItemList_);
                }
                return this.overflowTransformedItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public int getOverflowTransformedItemListCount() {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    return this.overflowTransformedItemList_.size();
                }
                return this.overflowTransformedItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public ItemHintOuterClass.ItemHint getOverflowTransformedItemList(int index) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    return this.overflowTransformedItemList_.get(index);
                }
                return this.overflowTransformedItemListBuilder_.getMessage(index);
            }

            public Builder setOverflowTransformedItemList(int index, ItemHintOuterClass.ItemHint value) {
                if (this.overflowTransformedItemListBuilder_ != null) {
                    this.overflowTransformedItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOverflowTransformedItemList(int index, ItemHintOuterClass.ItemHint.Builder builderForValue) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.overflowTransformedItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOverflowTransformedItemList(ItemHintOuterClass.ItemHint value) {
                if (this.overflowTransformedItemListBuilder_ != null) {
                    this.overflowTransformedItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOverflowTransformedItemList(int index, ItemHintOuterClass.ItemHint value) {
                if (this.overflowTransformedItemListBuilder_ != null) {
                    this.overflowTransformedItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOverflowTransformedItemList(ItemHintOuterClass.ItemHint.Builder builderForValue) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.overflowTransformedItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOverflowTransformedItemList(int index, ItemHintOuterClass.ItemHint.Builder builderForValue) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.overflowTransformedItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOverflowTransformedItemList(Iterable<? extends ItemHintOuterClass.ItemHint> values) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    ensureOverflowTransformedItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.overflowTransformedItemList_);
                    onChanged();
                } else {
                    this.overflowTransformedItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOverflowTransformedItemList() {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    this.overflowTransformedItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.overflowTransformedItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOverflowTransformedItemList(int index) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    ensureOverflowTransformedItemListIsMutable();
                    this.overflowTransformedItemList_.remove(index);
                    onChanged();
                } else {
                    this.overflowTransformedItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemHintOuterClass.ItemHint.Builder getOverflowTransformedItemListBuilder(int index) {
                return getOverflowTransformedItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public ItemHintOuterClass.ItemHintOrBuilder getOverflowTransformedItemListOrBuilder(int index) {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    return this.overflowTransformedItemList_.get(index);
                }
                return this.overflowTransformedItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public List<? extends ItemHintOuterClass.ItemHintOrBuilder> getOverflowTransformedItemListOrBuilderList() {
                if (this.overflowTransformedItemListBuilder_ != null) {
                    return this.overflowTransformedItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.overflowTransformedItemList_);
            }

            public ItemHintOuterClass.ItemHint.Builder addOverflowTransformedItemListBuilder() {
                return getOverflowTransformedItemListFieldBuilder().addBuilder(ItemHintOuterClass.ItemHint.getDefaultInstance());
            }

            public ItemHintOuterClass.ItemHint.Builder addOverflowTransformedItemListBuilder(int index) {
                return getOverflowTransformedItemListFieldBuilder().addBuilder(index, ItemHintOuterClass.ItemHint.getDefaultInstance());
            }

            public List<ItemHintOuterClass.ItemHint.Builder> getOverflowTransformedItemListBuilderList() {
                return getOverflowTransformedItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemHintOuterClass.ItemHint, ItemHintOuterClass.ItemHint.Builder, ItemHintOuterClass.ItemHintOrBuilder> getOverflowTransformedItemListFieldBuilder() {
                if (this.overflowTransformedItemListBuilder_ == null) {
                    this.overflowTransformedItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.overflowTransformedItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.overflowTransformedItemList_ = null;
                }
                return this.overflowTransformedItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public boolean getUnk3300KIOMJNHFMDE() {
                return this.unk3300KIOMJNHFMDE_;
            }

            public Builder setUnk3300KIOMJNHFMDE(boolean value) {
                this.unk3300KIOMJNHFMDE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KIOMJNHFMDE() {
                this.unk3300KIOMJNHFMDE_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public boolean hasPosition() {
                return (this.positionBuilder_ == null && this.position_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public VectorOuterClass.Vector getPosition() {
                if (this.positionBuilder_ == null) {
                    return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
                }
                return this.positionBuilder_.getMessage();
            }

            public Builder setPosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ != null) {
                    this.positionBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.position_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPosition(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.positionBuilder_ == null) {
                    this.position_ = builderForValue.build();
                    onChanged();
                } else {
                    this.positionBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePosition(VectorOuterClass.Vector value) {
                if (this.positionBuilder_ == null) {
                    if (this.position_ != null) {
                        this.position_ = VectorOuterClass.Vector.newBuilder(this.position_).mergeFrom(value).buildPartial();
                    } else {
                        this.position_ = value;
                    }
                    onChanged();
                } else {
                    this.positionBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPosition() {
                if (this.positionBuilder_ == null) {
                    this.position_ = null;
                    onChanged();
                } else {
                    this.position_ = null;
                    this.positionBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPositionBuilder() {
                onChanged();
                return getPositionFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getPositionOrBuilder() {
                if (this.positionBuilder_ != null) {
                    return this.positionBuilder_.getMessageOrBuilder();
                }
                return this.position_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.position_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPositionFieldBuilder() {
                if (this.positionBuilder_ == null) {
                    this.positionBuilder_ = new SingleFieldBuilderV3<>(getPosition(), getParentForChildren(), isClean());
                    this.position_ = null;
                }
                return this.positionBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass.ItemAddHintNotifyOrBuilder
            public int getQuestId() {
                return this.questId_;
            }

            public Builder setQuestId(int value) {
                this.questId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestId() {
                this.questId_ = 0;
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

        public static ItemAddHintNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ItemAddHintNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ItemAddHintNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ItemAddHintNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemHintOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
