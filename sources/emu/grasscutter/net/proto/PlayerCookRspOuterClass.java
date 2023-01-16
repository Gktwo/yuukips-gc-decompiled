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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookRspOuterClass.class */
public final class PlayerCookRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013PlayerCookRsp.proto\u001a\u0014CookRecipeData.proto\u001a\u000fItemParam.proto\"³\u0001\n\rPlayerCookRsp\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u0012$\n\u000brecipe_data\u0018\f \u0001(\u000b2\u000f.CookRecipeData\u0012\u001d\n\titem_list\u0018\u0005 \u0003(\u000b2\n.ItemParam\u0012\u0013\n\u000bqte_quality\u0018\u0001 \u0001(\r\u0012#\n\u000fextra_item_list\u0018\u0003 \u0003(\u000b2\n.ItemParam\u0012\u0012\n\ncook_count\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CookRecipeDataOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerCookRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PlayerCookRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCookRsp_descriptor, new String[]{"Retcode", "RecipeData", "ItemList", "QteQuality", "ExtraItemList", "CookCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookRspOuterClass$PlayerCookRspOrBuilder.class */
    public interface PlayerCookRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasRecipeData();

        CookRecipeDataOuterClass.CookRecipeData getRecipeData();

        CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataOrBuilder();

        List<ItemParamOuterClass.ItemParam> getItemListList();

        ItemParamOuterClass.ItemParam getItemList(int i);

        int getItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int i);

        int getQteQuality();

        List<ItemParamOuterClass.ItemParam> getExtraItemListList();

        ItemParamOuterClass.ItemParam getExtraItemList(int i);

        int getExtraItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getExtraItemListOrBuilder(int i);

        int getCookCount();
    }

    private PlayerCookRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookRspOuterClass$PlayerCookRsp.class */
    public static final class PlayerCookRsp extends GeneratedMessageV3 implements PlayerCookRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        public static final int RECIPE_DATA_FIELD_NUMBER = 12;
        private CookRecipeDataOuterClass.CookRecipeData recipeData_;
        public static final int ITEM_LIST_FIELD_NUMBER = 5;
        private List<ItemParamOuterClass.ItemParam> itemList_;
        public static final int QTE_QUALITY_FIELD_NUMBER = 1;
        private int qteQuality_;
        public static final int EXTRA_ITEM_LIST_FIELD_NUMBER = 3;
        private List<ItemParamOuterClass.ItemParam> extraItemList_;
        public static final int COOK_COUNT_FIELD_NUMBER = 11;
        private int cookCount_;
        private byte memoizedIsInitialized;
        private static final PlayerCookRsp DEFAULT_INSTANCE = new PlayerCookRsp();
        private static final Parser<PlayerCookRsp> PARSER = new AbstractParser<PlayerCookRsp>() { // from class: emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerCookRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCookRsp(input, extensionRegistry);
            }
        };

        private PlayerCookRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCookRsp() {
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
            this.extraItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCookRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0136 */
        private PlayerCookRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.qteQuality_ = input.readUInt32();
                                    break;
                                case 26:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.extraItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.extraItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 32:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.itemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.itemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 88:
                                    this.cookCount_ = input.readUInt32();
                                    break;
                                case 98:
                                    CookRecipeDataOuterClass.CookRecipeData.Builder subBuilder = this.recipeData_ != null ? this.recipeData_.toBuilder() : null;
                                    this.recipeData_ = (CookRecipeDataOuterClass.CookRecipeData) input.readMessage(CookRecipeDataOuterClass.CookRecipeData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.recipeData_);
                                        this.recipeData_ = subBuilder.buildPartial();
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
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.extraItemList_ = Collections.unmodifiableList(this.extraItemList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerCookRspOuterClass.internal_static_PlayerCookRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCookRspOuterClass.internal_static_PlayerCookRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerCookRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public boolean hasRecipeData() {
            return this.recipeData_ != null;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public CookRecipeDataOuterClass.CookRecipeData getRecipeData() {
            return this.recipeData_ == null ? CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance() : this.recipeData_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataOrBuilder() {
            return getRecipeData();
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public int getQteQuality() {
            return this.qteQuality_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getExtraItemListList() {
            return this.extraItemList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListOrBuilderList() {
            return this.extraItemList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public int getExtraItemListCount() {
            return this.extraItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public ItemParamOuterClass.ItemParam getExtraItemList(int index) {
            return this.extraItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getExtraItemListOrBuilder(int index) {
            return this.extraItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
        public int getCookCount() {
            return this.cookCount_;
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
            if (this.qteQuality_ != 0) {
                output.writeUInt32(1, this.qteQuality_);
            }
            for (int i = 0; i < this.extraItemList_.size(); i++) {
                output.writeMessage(3, this.extraItemList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(4, this.retcode_);
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                output.writeMessage(5, this.itemList_.get(i2));
            }
            if (this.cookCount_ != 0) {
                output.writeUInt32(11, this.cookCount_);
            }
            if (this.recipeData_ != null) {
                output.writeMessage(12, getRecipeData());
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
            if (this.qteQuality_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.qteQuality_);
            }
            for (int i = 0; i < this.extraItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.extraItemList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.itemList_.get(i2));
            }
            if (this.cookCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.cookCount_);
            }
            if (this.recipeData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getRecipeData());
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
            if (!(obj instanceof PlayerCookRsp)) {
                return equals(obj);
            }
            PlayerCookRsp other = (PlayerCookRsp) obj;
            if (getRetcode() == other.getRetcode() && hasRecipeData() == other.hasRecipeData()) {
                return (!hasRecipeData() || getRecipeData().equals(other.getRecipeData())) && getItemListList().equals(other.getItemListList()) && getQteQuality() == other.getQteQuality() && getExtraItemListList().equals(other.getExtraItemListList()) && getCookCount() == other.getCookCount() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getRetcode();
            if (hasRecipeData()) {
                hash = (53 * ((37 * hash) + 12)) + getRecipeData().hashCode();
            }
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 1)) + getQteQuality();
            if (getExtraItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getExtraItemListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 11)) + getCookCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerCookRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCookRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCookRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCookRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCookRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCookRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCookRsp parseFrom(InputStream input) throws IOException {
            return (PlayerCookRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCookRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCookRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCookRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCookRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCookRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCookRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCookRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCookRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCookRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCookRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCookRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCookRspOuterClass$PlayerCookRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCookRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private CookRecipeDataOuterClass.CookRecipeData recipeData_;
            private SingleFieldBuilderV3<CookRecipeDataOuterClass.CookRecipeData, CookRecipeDataOuterClass.CookRecipeData.Builder, CookRecipeDataOuterClass.CookRecipeDataOrBuilder> recipeDataBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemListBuilder_;
            private int qteQuality_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> extraItemListBuilder_;
            private int cookCount_;
            private List<ItemParamOuterClass.ItemParam> itemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> extraItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCookRspOuterClass.internal_static_PlayerCookRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCookRspOuterClass.internal_static_PlayerCookRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerCookRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCookRsp.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                    getExtraItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.recipeDataBuilder_ == null) {
                    this.recipeData_ = null;
                } else {
                    this.recipeData_ = null;
                    this.recipeDataBuilder_ = null;
                }
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                this.qteQuality_ = 0;
                if (this.extraItemListBuilder_ == null) {
                    this.extraItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.extraItemListBuilder_.clear();
                }
                this.cookCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCookRspOuterClass.internal_static_PlayerCookRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCookRsp getDefaultInstanceForType() {
                return PlayerCookRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCookRsp build() {
                PlayerCookRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCookRsp buildPartial() {
                PlayerCookRsp result = new PlayerCookRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.recipeDataBuilder_ == null) {
                    result.recipeData_ = this.recipeData_;
                } else {
                    result.recipeData_ = this.recipeDataBuilder_.build();
                }
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
                }
                result.qteQuality_ = this.qteQuality_;
                if (this.extraItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.extraItemList_ = Collections.unmodifiableList(this.extraItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.extraItemList_ = this.extraItemList_;
                } else {
                    result.extraItemList_ = this.extraItemListBuilder_.build();
                }
                result.cookCount_ = this.cookCount_;
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
                if (other instanceof PlayerCookRsp) {
                    return mergeFrom((PlayerCookRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCookRsp other) {
                if (other == PlayerCookRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.hasRecipeData()) {
                    mergeRecipeData(other.getRecipeData());
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
                        this.itemListBuilder_ = PlayerCookRsp.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
                    }
                }
                if (other.getQteQuality() != 0) {
                    setQteQuality(other.getQteQuality());
                }
                if (this.extraItemListBuilder_ == null) {
                    if (!other.extraItemList_.isEmpty()) {
                        if (this.extraItemList_.isEmpty()) {
                            this.extraItemList_ = other.extraItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureExtraItemListIsMutable();
                            this.extraItemList_.addAll(other.extraItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.extraItemList_.isEmpty()) {
                    if (this.extraItemListBuilder_.isEmpty()) {
                        this.extraItemListBuilder_.dispose();
                        this.extraItemListBuilder_ = null;
                        this.extraItemList_ = other.extraItemList_;
                        this.bitField0_ &= -3;
                        this.extraItemListBuilder_ = PlayerCookRsp.alwaysUseFieldBuilders ? getExtraItemListFieldBuilder() : null;
                    } else {
                        this.extraItemListBuilder_.addAllMessages(other.extraItemList_);
                    }
                }
                if (other.getCookCount() != 0) {
                    setCookCount(other.getCookCount());
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
                PlayerCookRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCookRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCookRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public boolean hasRecipeData() {
                return (this.recipeDataBuilder_ == null && this.recipeData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public CookRecipeDataOuterClass.CookRecipeData getRecipeData() {
                if (this.recipeDataBuilder_ == null) {
                    return this.recipeData_ == null ? CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance() : this.recipeData_;
                }
                return this.recipeDataBuilder_.getMessage();
            }

            public Builder setRecipeData(CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataBuilder_ != null) {
                    this.recipeDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.recipeData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRecipeData(CookRecipeDataOuterClass.CookRecipeData.Builder builderForValue) {
                if (this.recipeDataBuilder_ == null) {
                    this.recipeData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.recipeDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRecipeData(CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataBuilder_ == null) {
                    if (this.recipeData_ != null) {
                        this.recipeData_ = CookRecipeDataOuterClass.CookRecipeData.newBuilder(this.recipeData_).mergeFrom(value).buildPartial();
                    } else {
                        this.recipeData_ = value;
                    }
                    onChanged();
                } else {
                    this.recipeDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRecipeData() {
                if (this.recipeDataBuilder_ == null) {
                    this.recipeData_ = null;
                    onChanged();
                } else {
                    this.recipeData_ = null;
                    this.recipeDataBuilder_ = null;
                }
                return this;
            }

            public CookRecipeDataOuterClass.CookRecipeData.Builder getRecipeDataBuilder() {
                onChanged();
                return getRecipeDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataOrBuilder() {
                if (this.recipeDataBuilder_ != null) {
                    return this.recipeDataBuilder_.getMessageOrBuilder();
                }
                return this.recipeData_ == null ? CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance() : this.recipeData_;
            }

            private SingleFieldBuilderV3<CookRecipeDataOuterClass.CookRecipeData, CookRecipeDataOuterClass.CookRecipeData.Builder, CookRecipeDataOuterClass.CookRecipeDataOrBuilder> getRecipeDataFieldBuilder() {
                if (this.recipeDataBuilder_ == null) {
                    this.recipeDataBuilder_ = new SingleFieldBuilderV3<>(getRecipeData(), getParentForChildren(), isClean());
                    this.recipeData_ = null;
                }
                return this.recipeDataBuilder_;
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public ItemParamOuterClass.ItemParam getItemList(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessage(index);
            }

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam value) {
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

            public Builder setItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(ItemParamOuterClass.ItemParam value) {
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

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam value) {
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

            public Builder addItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemListBuilder_ == null) {
                    ensureItemListIsMutable();
                    this.itemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
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

            public ItemParamOuterClass.ItemParam.Builder getItemListBuilder(int index) {
                return getItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
                if (this.itemListBuilder_ != null) {
                    return this.itemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder() {
                return getItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemListBuilder(int index) {
                return getItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemListBuilderList() {
                return getItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemListFieldBuilder() {
                if (this.itemListBuilder_ == null) {
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemList_ = null;
                }
                return this.itemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public int getQteQuality() {
                return this.qteQuality_;
            }

            public Builder setQteQuality(int value) {
                this.qteQuality_ = value;
                onChanged();
                return this;
            }

            public Builder clearQteQuality() {
                this.qteQuality_ = 0;
                onChanged();
                return this;
            }

            private void ensureExtraItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.extraItemList_ = new ArrayList(this.extraItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getExtraItemListList() {
                if (this.extraItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.extraItemList_);
                }
                return this.extraItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public int getExtraItemListCount() {
                if (this.extraItemListBuilder_ == null) {
                    return this.extraItemList_.size();
                }
                return this.extraItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public ItemParamOuterClass.ItemParam getExtraItemList(int index) {
                if (this.extraItemListBuilder_ == null) {
                    return this.extraItemList_.get(index);
                }
                return this.extraItemListBuilder_.getMessage(index);
            }

            public Builder setExtraItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.extraItemListBuilder_ != null) {
                    this.extraItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtraItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtraItemList(ItemParamOuterClass.ItemParam value) {
                if (this.extraItemListBuilder_ != null) {
                    this.extraItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.extraItemListBuilder_ != null) {
                    this.extraItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extraItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtraItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtraItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.extraItemList_);
                    onChanged();
                } else {
                    this.extraItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtraItemList() {
                if (this.extraItemListBuilder_ == null) {
                    this.extraItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.extraItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtraItemList(int index) {
                if (this.extraItemListBuilder_ == null) {
                    ensureExtraItemListIsMutable();
                    this.extraItemList_.remove(index);
                    onChanged();
                } else {
                    this.extraItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getExtraItemListBuilder(int index) {
                return getExtraItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getExtraItemListOrBuilder(int index) {
                if (this.extraItemListBuilder_ == null) {
                    return this.extraItemList_.get(index);
                }
                return this.extraItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListOrBuilderList() {
                if (this.extraItemListBuilder_ != null) {
                    return this.extraItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extraItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addExtraItemListBuilder() {
                return getExtraItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addExtraItemListBuilder(int index) {
                return getExtraItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getExtraItemListBuilderList() {
                return getExtraItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getExtraItemListFieldBuilder() {
                if (this.extraItemListBuilder_ == null) {
                    this.extraItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.extraItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.extraItemList_ = null;
                }
                return this.extraItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerCookRspOuterClass.PlayerCookRspOrBuilder
            public int getCookCount() {
                return this.cookCount_;
            }

            public Builder setCookCount(int value) {
                this.cookCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCookCount() {
                this.cookCount_ = 0;
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

        public static PlayerCookRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCookRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCookRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCookRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CookRecipeDataOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
