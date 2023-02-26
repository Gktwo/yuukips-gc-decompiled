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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.EquipOuterClass;
import emu.grasscutter.net.proto.FurnitureOuterClass;
import emu.grasscutter.net.proto.MaterialOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemOuterClass.class */
public final class ItemOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\nItem.proto\u001a\u000eMaterial.proto\u001a\u000bEquip.proto\u001a\u000fFurniture.proto\"\u0001\n\u0004Item\u0012\u000e\n\u0006itemId\u0018\u0001 \u0001(\r\u0012\f\n\u0004guid\u0018\u0002 \u0001(\u0004\u0012\u001d\n\bmaterial\u0018\u0005 \u0001(\u000b2\t.MaterialH��\u0012\u0017\n\u0005equip\u0018\u0006 \u0001(\u000b2\u0006.EquipH��\u0012\u001f\n\tfurniture\u0018\u0007 \u0001(\u000b2\n.FurnitureH��B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MaterialOuterClass.getDescriptor(), EquipOuterClass.getDescriptor(), FurnitureOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_Item_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Item_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Item_descriptor, new String[]{"ItemId", "Guid", "Material", "Equip", "Furniture", "Detail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemOuterClass$ItemOrBuilder.class */
    public interface ItemOrBuilder extends MessageOrBuilder {
        int getItemId();

        long getGuid();

        boolean hasMaterial();

        MaterialOuterClass.Material getMaterial();

        MaterialOuterClass.MaterialOrBuilder getMaterialOrBuilder();

        boolean hasEquip();

        EquipOuterClass.Equip getEquip();

        EquipOuterClass.EquipOrBuilder getEquipOrBuilder();

        boolean hasFurniture();

        FurnitureOuterClass.Furniture getFurniture();

        FurnitureOuterClass.FurnitureOrBuilder getFurnitureOrBuilder();

        Item.DetailCase getDetailCase();
    }

    private ItemOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemOuterClass$Item.class */
    public static final class Item extends GeneratedMessageV3 implements ItemOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int ITEMID_FIELD_NUMBER = 1;
        private int itemId_;
        public static final int GUID_FIELD_NUMBER = 2;
        private long guid_;
        public static final int MATERIAL_FIELD_NUMBER = 5;
        public static final int EQUIP_FIELD_NUMBER = 6;
        public static final int FURNITURE_FIELD_NUMBER = 7;
        private byte memoizedIsInitialized;
        private static final Item DEFAULT_INSTANCE = new Item();
        private static final Parser<Item> PARSER = new AbstractParser<Item>() { // from class: emu.grasscutter.net.proto.ItemOuterClass.Item.1
            @Override // com.google.protobuf.Parser
            public Item parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Item(input, extensionRegistry);
            }
        };

        private Item(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private Item() {
            this.detailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Item();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Item(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.itemId_ = input.readUInt32();
                                break;
                            case 16:
                                this.guid_ = input.readUInt64();
                                break;
                            case 42:
                                MaterialOuterClass.Material.Builder subBuilder = this.detailCase_ == 5 ? ((MaterialOuterClass.Material) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MaterialOuterClass.Material.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((MaterialOuterClass.Material) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 5;
                                break;
                            case 50:
                                EquipOuterClass.Equip.Builder subBuilder2 = this.detailCase_ == 6 ? ((EquipOuterClass.Equip) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EquipOuterClass.Equip.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((EquipOuterClass.Equip) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 6;
                                break;
                            case 58:
                                FurnitureOuterClass.Furniture.Builder subBuilder3 = this.detailCase_ == 7 ? ((FurnitureOuterClass.Furniture) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FurnitureOuterClass.Furniture.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((FurnitureOuterClass.Furniture) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 7;
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
            return ItemOuterClass.internal_static_Item_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ItemOuterClass.internal_static_Item_fieldAccessorTable.ensureFieldAccessorsInitialized(Item.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemOuterClass$Item$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MATERIAL(5),
            EQUIP(6),
            FURNITURE(7),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    default:
                        return null;
                    case 5:
                        return MATERIAL;
                    case 6:
                        return EQUIP;
                    case 7:
                        return FURNITURE;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public boolean hasMaterial() {
            return this.detailCase_ == 5;
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public MaterialOuterClass.Material getMaterial() {
            if (this.detailCase_ == 5) {
                return (MaterialOuterClass.Material) this.detail_;
            }
            return MaterialOuterClass.Material.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public MaterialOuterClass.MaterialOrBuilder getMaterialOrBuilder() {
            if (this.detailCase_ == 5) {
                return (MaterialOuterClass.Material) this.detail_;
            }
            return MaterialOuterClass.Material.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public boolean hasEquip() {
            return this.detailCase_ == 6;
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public EquipOuterClass.Equip getEquip() {
            if (this.detailCase_ == 6) {
                return (EquipOuterClass.Equip) this.detail_;
            }
            return EquipOuterClass.Equip.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public EquipOuterClass.EquipOrBuilder getEquipOrBuilder() {
            if (this.detailCase_ == 6) {
                return (EquipOuterClass.Equip) this.detail_;
            }
            return EquipOuterClass.Equip.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public boolean hasFurniture() {
            return this.detailCase_ == 7;
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public FurnitureOuterClass.Furniture getFurniture() {
            if (this.detailCase_ == 7) {
                return (FurnitureOuterClass.Furniture) this.detail_;
            }
            return FurnitureOuterClass.Furniture.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
        public FurnitureOuterClass.FurnitureOrBuilder getFurnitureOrBuilder() {
            if (this.detailCase_ == 7) {
                return (FurnitureOuterClass.Furniture) this.detail_;
            }
            return FurnitureOuterClass.Furniture.getDefaultInstance();
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
                output.writeUInt32(1, this.itemId_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(2, this.guid_);
            }
            if (this.detailCase_ == 5) {
                output.writeMessage(5, (MaterialOuterClass.Material) this.detail_);
            }
            if (this.detailCase_ == 6) {
                output.writeMessage(6, (EquipOuterClass.Equip) this.detail_);
            }
            if (this.detailCase_ == 7) {
                output.writeMessage(7, (FurnitureOuterClass.Furniture) this.detail_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.itemId_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(2, this.guid_);
            }
            if (this.detailCase_ == 5) {
                size2 += CodedOutputStream.computeMessageSize(5, (MaterialOuterClass.Material) this.detail_);
            }
            if (this.detailCase_ == 6) {
                size2 += CodedOutputStream.computeMessageSize(6, (EquipOuterClass.Equip) this.detail_);
            }
            if (this.detailCase_ == 7) {
                size2 += CodedOutputStream.computeMessageSize(7, (FurnitureOuterClass.Furniture) this.detail_);
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
            if (!(obj instanceof Item)) {
                return equals(obj);
            }
            Item other = (Item) obj;
            if (getItemId() != other.getItemId() || getGuid() != other.getGuid() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 5:
                    if (!getMaterial().equals(other.getMaterial())) {
                        return false;
                    }
                    break;
                case 6:
                    if (!getEquip().equals(other.getEquip())) {
                        return false;
                    }
                    break;
                case 7:
                    if (!getFurniture().equals(other.getFurniture())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getItemId())) + 2)) + Internal.hashLong(getGuid());
            switch (this.detailCase_) {
                case 5:
                    hash = (53 * ((37 * hash) + 5)) + getMaterial().hashCode();
                    break;
                case 6:
                    hash = (53 * ((37 * hash) + 6)) + getEquip().hashCode();
                    break;
                case 7:
                    hash = (53 * ((37 * hash) + 7)) + getFurniture().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static Item parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Item parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Item parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Item parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Item parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Item parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Item parseFrom(InputStream input) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Item parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Item parseDelimitedFrom(InputStream input) throws IOException {
            return (Item) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Item parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Item) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Item parseFrom(CodedInputStream input) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Item parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Item) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Item prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemOuterClass$Item$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ItemOrBuilder {
            private int detailCase_ = 0;
            private Object detail_;
            private int itemId_;
            private long guid_;
            private SingleFieldBuilderV3<MaterialOuterClass.Material, MaterialOuterClass.Material.Builder, MaterialOuterClass.MaterialOrBuilder> materialBuilder_;
            private SingleFieldBuilderV3<EquipOuterClass.Equip, EquipOuterClass.Equip.Builder, EquipOuterClass.EquipOrBuilder> equipBuilder_;
            private SingleFieldBuilderV3<FurnitureOuterClass.Furniture, FurnitureOuterClass.Furniture.Builder, FurnitureOuterClass.FurnitureOrBuilder> furnitureBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ItemOuterClass.internal_static_Item_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ItemOuterClass.internal_static_Item_fieldAccessorTable.ensureFieldAccessorsInitialized(Item.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Item.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemId_ = 0;
                this.guid_ = 0;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ItemOuterClass.internal_static_Item_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Item getDefaultInstanceForType() {
                return Item.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Item build() {
                Item result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Item buildPartial() {
                Item result = new Item(this);
                result.itemId_ = this.itemId_;
                result.guid_ = this.guid_;
                if (this.detailCase_ == 5) {
                    if (this.materialBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.materialBuilder_.build();
                    }
                }
                if (this.detailCase_ == 6) {
                    if (this.equipBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.equipBuilder_.build();
                    }
                }
                if (this.detailCase_ == 7) {
                    if (this.furnitureBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.furnitureBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
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
                if (other instanceof Item) {
                    return mergeFrom((Item) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Item other) {
                if (other == Item.getDefaultInstance()) {
                    return this;
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                switch (other.getDetailCase()) {
                    case MATERIAL:
                        mergeMaterial(other.getMaterial());
                        break;
                    case EQUIP:
                        mergeEquip(other.getEquip());
                        break;
                    case FURNITURE:
                        mergeFurniture(other.getFurniture());
                        break;
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
                Item parsedMessage = null;
                try {
                    try {
                        parsedMessage = Item.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Item) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
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

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
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

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public boolean hasMaterial() {
                return this.detailCase_ == 5;
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public MaterialOuterClass.Material getMaterial() {
                if (this.materialBuilder_ == null) {
                    if (this.detailCase_ == 5) {
                        return (MaterialOuterClass.Material) this.detail_;
                    }
                    return MaterialOuterClass.Material.getDefaultInstance();
                } else if (this.detailCase_ == 5) {
                    return this.materialBuilder_.getMessage();
                } else {
                    return MaterialOuterClass.Material.getDefaultInstance();
                }
            }

            public Builder setMaterial(MaterialOuterClass.Material value) {
                if (this.materialBuilder_ != null) {
                    this.materialBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 5;
                return this;
            }

            public Builder setMaterial(MaterialOuterClass.Material.Builder builderForValue) {
                if (this.materialBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.materialBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 5;
                return this;
            }

            public Builder mergeMaterial(MaterialOuterClass.Material value) {
                if (this.materialBuilder_ == null) {
                    if (this.detailCase_ != 5 || this.detail_ == MaterialOuterClass.Material.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MaterialOuterClass.Material.newBuilder((MaterialOuterClass.Material) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 5) {
                        this.materialBuilder_.mergeFrom(value);
                    }
                    this.materialBuilder_.setMessage(value);
                }
                this.detailCase_ = 5;
                return this;
            }

            public Builder clearMaterial() {
                if (this.materialBuilder_ != null) {
                    if (this.detailCase_ == 5) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.materialBuilder_.clear();
                } else if (this.detailCase_ == 5) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MaterialOuterClass.Material.Builder getMaterialBuilder() {
                return getMaterialFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public MaterialOuterClass.MaterialOrBuilder getMaterialOrBuilder() {
                if (this.detailCase_ == 5 && this.materialBuilder_ != null) {
                    return this.materialBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 5) {
                    return (MaterialOuterClass.Material) this.detail_;
                }
                return MaterialOuterClass.Material.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MaterialOuterClass.Material, MaterialOuterClass.Material.Builder, MaterialOuterClass.MaterialOrBuilder> getMaterialFieldBuilder() {
                if (this.materialBuilder_ == null) {
                    if (this.detailCase_ != 5) {
                        this.detail_ = MaterialOuterClass.Material.getDefaultInstance();
                    }
                    this.materialBuilder_ = new SingleFieldBuilderV3<>((MaterialOuterClass.Material) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 5;
                onChanged();
                return this.materialBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public boolean hasEquip() {
                return this.detailCase_ == 6;
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public EquipOuterClass.Equip getEquip() {
                if (this.equipBuilder_ == null) {
                    if (this.detailCase_ == 6) {
                        return (EquipOuterClass.Equip) this.detail_;
                    }
                    return EquipOuterClass.Equip.getDefaultInstance();
                } else if (this.detailCase_ == 6) {
                    return this.equipBuilder_.getMessage();
                } else {
                    return EquipOuterClass.Equip.getDefaultInstance();
                }
            }

            public Builder setEquip(EquipOuterClass.Equip value) {
                if (this.equipBuilder_ != null) {
                    this.equipBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 6;
                return this;
            }

            public Builder setEquip(EquipOuterClass.Equip.Builder builderForValue) {
                if (this.equipBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.equipBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 6;
                return this;
            }

            public Builder mergeEquip(EquipOuterClass.Equip value) {
                if (this.equipBuilder_ == null) {
                    if (this.detailCase_ != 6 || this.detail_ == EquipOuterClass.Equip.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EquipOuterClass.Equip.newBuilder((EquipOuterClass.Equip) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 6) {
                        this.equipBuilder_.mergeFrom(value);
                    }
                    this.equipBuilder_.setMessage(value);
                }
                this.detailCase_ = 6;
                return this;
            }

            public Builder clearEquip() {
                if (this.equipBuilder_ != null) {
                    if (this.detailCase_ == 6) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.equipBuilder_.clear();
                } else if (this.detailCase_ == 6) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EquipOuterClass.Equip.Builder getEquipBuilder() {
                return getEquipFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public EquipOuterClass.EquipOrBuilder getEquipOrBuilder() {
                if (this.detailCase_ == 6 && this.equipBuilder_ != null) {
                    return this.equipBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 6) {
                    return (EquipOuterClass.Equip) this.detail_;
                }
                return EquipOuterClass.Equip.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EquipOuterClass.Equip, EquipOuterClass.Equip.Builder, EquipOuterClass.EquipOrBuilder> getEquipFieldBuilder() {
                if (this.equipBuilder_ == null) {
                    if (this.detailCase_ != 6) {
                        this.detail_ = EquipOuterClass.Equip.getDefaultInstance();
                    }
                    this.equipBuilder_ = new SingleFieldBuilderV3<>((EquipOuterClass.Equip) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 6;
                onChanged();
                return this.equipBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public boolean hasFurniture() {
                return this.detailCase_ == 7;
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public FurnitureOuterClass.Furniture getFurniture() {
                if (this.furnitureBuilder_ == null) {
                    if (this.detailCase_ == 7) {
                        return (FurnitureOuterClass.Furniture) this.detail_;
                    }
                    return FurnitureOuterClass.Furniture.getDefaultInstance();
                } else if (this.detailCase_ == 7) {
                    return this.furnitureBuilder_.getMessage();
                } else {
                    return FurnitureOuterClass.Furniture.getDefaultInstance();
                }
            }

            public Builder setFurniture(FurnitureOuterClass.Furniture value) {
                if (this.furnitureBuilder_ != null) {
                    this.furnitureBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 7;
                return this;
            }

            public Builder setFurniture(FurnitureOuterClass.Furniture.Builder builderForValue) {
                if (this.furnitureBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.furnitureBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 7;
                return this;
            }

            public Builder mergeFurniture(FurnitureOuterClass.Furniture value) {
                if (this.furnitureBuilder_ == null) {
                    if (this.detailCase_ != 7 || this.detail_ == FurnitureOuterClass.Furniture.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FurnitureOuterClass.Furniture.newBuilder((FurnitureOuterClass.Furniture) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 7) {
                        this.furnitureBuilder_.mergeFrom(value);
                    }
                    this.furnitureBuilder_.setMessage(value);
                }
                this.detailCase_ = 7;
                return this;
            }

            public Builder clearFurniture() {
                if (this.furnitureBuilder_ != null) {
                    if (this.detailCase_ == 7) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.furnitureBuilder_.clear();
                } else if (this.detailCase_ == 7) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FurnitureOuterClass.Furniture.Builder getFurnitureBuilder() {
                return getFurnitureFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ItemOuterClass.ItemOrBuilder
            public FurnitureOuterClass.FurnitureOrBuilder getFurnitureOrBuilder() {
                if (this.detailCase_ == 7 && this.furnitureBuilder_ != null) {
                    return this.furnitureBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 7) {
                    return (FurnitureOuterClass.Furniture) this.detail_;
                }
                return FurnitureOuterClass.Furniture.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FurnitureOuterClass.Furniture, FurnitureOuterClass.Furniture.Builder, FurnitureOuterClass.FurnitureOrBuilder> getFurnitureFieldBuilder() {
                if (this.furnitureBuilder_ == null) {
                    if (this.detailCase_ != 7) {
                        this.detail_ = FurnitureOuterClass.Furniture.getDefaultInstance();
                    }
                    this.furnitureBuilder_ = new SingleFieldBuilderV3<>((FurnitureOuterClass.Furniture) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 7;
                onChanged();
                return this.furnitureBuilder_;
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

        public static Item getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Item> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Item> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Item getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MaterialOuterClass.getDescriptor();
        EquipOuterClass.getDescriptor();
        FurnitureOuterClass.getDescriptor();
    }
}
