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
import emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsRspOuterClass.class */
public final class HomeLimitedShopBuyGoodsRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n HomeLimitedShopBuyGoodsRsp.proto\u001a\u001aHomeLimitedShopGoods.proto\"\u0001\n\u001aHomeLimitedShopBuyGoodsRsp\u0012(\n\tgoodsList\u0018\u0005 \u0003(\u000b2\u0015.HomeLimitedShopGoods\u0012$\n\u0005goods\u0018\b \u0001(\u000b2\u0015.HomeLimitedShopGoods\u0012\u0010\n\bbuyCount\u0018\u000b \u0001(\r\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopBuyGoodsRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopBuyGoodsRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopBuyGoodsRsp_descriptor, new String[]{"GoodsList", "Goods", "BuyCount", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsRspOuterClass$HomeLimitedShopBuyGoodsRspOrBuilder.class */
    public interface HomeLimitedShopBuyGoodsRspOrBuilder extends MessageOrBuilder {
        List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> getGoodsListList();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoodsList(int i);

        int getGoodsListCount();

        List<? extends HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsListOrBuilderList();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsListOrBuilder(int i);

        boolean hasGoods();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoods();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsOrBuilder();

        int getBuyCount();

        int getRetcode();
    }

    private HomeLimitedShopBuyGoodsRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsRspOuterClass$HomeLimitedShopBuyGoodsRsp.class */
    public static final class HomeLimitedShopBuyGoodsRsp extends GeneratedMessageV3 implements HomeLimitedShopBuyGoodsRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GOODSLIST_FIELD_NUMBER = 5;
        private List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> goodsList_;
        public static final int GOODS_FIELD_NUMBER = 8;
        private HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods goods_;
        public static final int BUYCOUNT_FIELD_NUMBER = 11;
        private int buyCount_;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopBuyGoodsRsp DEFAULT_INSTANCE = new HomeLimitedShopBuyGoodsRsp();
        private static final Parser<HomeLimitedShopBuyGoodsRsp> PARSER = new AbstractParser<HomeLimitedShopBuyGoodsRsp>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRsp.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopBuyGoodsRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopBuyGoodsRsp(input, extensionRegistry);
            }
        };

        private HomeLimitedShopBuyGoodsRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopBuyGoodsRsp() {
            this.memoizedIsInitialized = -1;
            this.goodsList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopBuyGoodsRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopBuyGoodsRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.retcode_ = input.readInt32();
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.goodsList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.goodsList_.add((HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods) input.readMessage(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.parser(), extensionRegistry));
                                break;
                            case 66:
                                HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder subBuilder = this.goods_ != null ? this.goods_.toBuilder() : null;
                                this.goods_ = (HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods) input.readMessage(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.goods_);
                                    this.goods_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 88:
                                this.buyCount_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeLimitedShopBuyGoodsRspOuterClass.internal_static_HomeLimitedShopBuyGoodsRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopBuyGoodsRspOuterClass.internal_static_HomeLimitedShopBuyGoodsRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopBuyGoodsRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> getGoodsListList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public List<? extends HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsListOrBuilderList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public int getGoodsListCount() {
            return this.goodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoodsList(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public boolean hasGoods() {
            return this.goods_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoods() {
            return this.goods_ == null ? HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance() : this.goods_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsOrBuilder() {
            return getGoods();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public int getBuyCount() {
            return this.buyCount_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(1, this.retcode_);
            }
            for (int i = 0; i < this.goodsList_.size(); i++) {
                output.writeMessage(5, this.goodsList_.get(i));
            }
            if (this.goods_ != null) {
                output.writeMessage(8, getGoods());
            }
            if (this.buyCount_ != 0) {
                output.writeUInt32(11, this.buyCount_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            for (int i = 0; i < this.goodsList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.goodsList_.get(i));
            }
            if (this.goods_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getGoods());
            }
            if (this.buyCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.buyCount_);
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
            if (!(obj instanceof HomeLimitedShopBuyGoodsRsp)) {
                return equals(obj);
            }
            HomeLimitedShopBuyGoodsRsp other = (HomeLimitedShopBuyGoodsRsp) obj;
            if (getGoodsListList().equals(other.getGoodsListList()) && hasGoods() == other.hasGoods()) {
                return (!hasGoods() || getGoods().equals(other.getGoods())) && getBuyCount() == other.getBuyCount() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGoodsListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getGoodsListList().hashCode();
            }
            if (hasGoods()) {
                hash = (53 * ((37 * hash) + 8)) + getGoods().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 11)) + getBuyCount())) + 1)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopBuyGoodsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopBuyGoodsRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopBuyGoodsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopBuyGoodsRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopBuyGoodsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopBuyGoodsRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopBuyGoodsRspOuterClass$HomeLimitedShopBuyGoodsRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopBuyGoodsRspOrBuilder {
            private int bitField0_;
            private List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> goodsList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> goodsListBuilder_;
            private HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods goods_;
            private SingleFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> goodsBuilder_;
            private int buyCount_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopBuyGoodsRspOuterClass.internal_static_HomeLimitedShopBuyGoodsRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopBuyGoodsRspOuterClass.internal_static_HomeLimitedShopBuyGoodsRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopBuyGoodsRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopBuyGoodsRsp.alwaysUseFieldBuilders) {
                    getGoodsListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.goodsListBuilder_ == null) {
                    this.goodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.goodsListBuilder_.clear();
                }
                if (this.goodsBuilder_ == null) {
                    this.goods_ = null;
                } else {
                    this.goods_ = null;
                    this.goodsBuilder_ = null;
                }
                this.buyCount_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopBuyGoodsRspOuterClass.internal_static_HomeLimitedShopBuyGoodsRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopBuyGoodsRsp getDefaultInstanceForType() {
                return HomeLimitedShopBuyGoodsRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopBuyGoodsRsp build() {
                HomeLimitedShopBuyGoodsRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopBuyGoodsRsp buildPartial() {
                HomeLimitedShopBuyGoodsRsp result = new HomeLimitedShopBuyGoodsRsp(this);
                int i = this.bitField0_;
                if (this.goodsListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                        this.bitField0_ &= -2;
                    }
                    result.goodsList_ = this.goodsList_;
                } else {
                    result.goodsList_ = this.goodsListBuilder_.build();
                }
                if (this.goodsBuilder_ == null) {
                    result.goods_ = this.goods_;
                } else {
                    result.goods_ = this.goodsBuilder_.build();
                }
                result.buyCount_ = this.buyCount_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof HomeLimitedShopBuyGoodsRsp) {
                    return mergeFrom((HomeLimitedShopBuyGoodsRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopBuyGoodsRsp other) {
                if (other == HomeLimitedShopBuyGoodsRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.goodsListBuilder_ == null) {
                    if (!other.goodsList_.isEmpty()) {
                        if (this.goodsList_.isEmpty()) {
                            this.goodsList_ = other.goodsList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureGoodsListIsMutable();
                            this.goodsList_.addAll(other.goodsList_);
                        }
                        onChanged();
                    }
                } else if (!other.goodsList_.isEmpty()) {
                    if (this.goodsListBuilder_.isEmpty()) {
                        this.goodsListBuilder_.dispose();
                        this.goodsListBuilder_ = null;
                        this.goodsList_ = other.goodsList_;
                        this.bitField0_ &= -2;
                        this.goodsListBuilder_ = HomeLimitedShopBuyGoodsRsp.alwaysUseFieldBuilders ? getGoodsListFieldBuilder() : null;
                    } else {
                        this.goodsListBuilder_.addAllMessages(other.goodsList_);
                    }
                }
                if (other.hasGoods()) {
                    mergeGoods(other.getGoods());
                }
                if (other.getBuyCount() != 0) {
                    setBuyCount(other.getBuyCount());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                HomeLimitedShopBuyGoodsRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopBuyGoodsRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopBuyGoodsRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureGoodsListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.goodsList_ = new ArrayList(this.goodsList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> getGoodsListList() {
                if (this.goodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.goodsList_);
                }
                return this.goodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public int getGoodsListCount() {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.size();
                }
                return this.goodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoodsList(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessage(index);
            }

            public Builder setGoodsList(int index, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsListBuilder_ != null) {
                    this.goodsListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGoodsListIsMutable();
                    this.goodsList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGoodsList(int index, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder builderForValue) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.goodsListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGoodsList(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsListBuilder_ != null) {
                    this.goodsListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGoodsList(int index, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsListBuilder_ != null) {
                    this.goodsListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGoodsList(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder builderForValue) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.goodsListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGoodsList(int index, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder builderForValue) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.goodsListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGoodsList(Iterable<? extends HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> values) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.goodsList_);
                    onChanged();
                } else {
                    this.goodsListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGoodsList() {
                if (this.goodsListBuilder_ == null) {
                    this.goodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.goodsListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGoodsList(int index) {
                if (this.goodsListBuilder_ == null) {
                    ensureGoodsListIsMutable();
                    this.goodsList_.remove(index);
                    onChanged();
                } else {
                    this.goodsListBuilder_.remove(index);
                }
                return this;
            }

            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder getGoodsListBuilder(int index) {
                return getGoodsListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public List<? extends HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsListOrBuilderList() {
                if (this.goodsListBuilder_ != null) {
                    return this.goodsListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.goodsList_);
            }

            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder addGoodsListBuilder() {
                return getGoodsListFieldBuilder().addBuilder(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance());
            }

            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder addGoodsListBuilder(int index) {
                return getGoodsListFieldBuilder().addBuilder(index, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance());
            }

            public List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder> getGoodsListBuilderList() {
                return getGoodsListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsListFieldBuilder() {
                if (this.goodsListBuilder_ == null) {
                    this.goodsListBuilder_ = new RepeatedFieldBuilderV3<>(this.goodsList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.goodsList_ = null;
                }
                return this.goodsListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public boolean hasGoods() {
                return (this.goodsBuilder_ == null && this.goods_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoods() {
                if (this.goodsBuilder_ == null) {
                    return this.goods_ == null ? HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance() : this.goods_;
                }
                return this.goodsBuilder_.getMessage();
            }

            public Builder setGoods(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsBuilder_ != null) {
                    this.goodsBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.goods_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setGoods(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder builderForValue) {
                if (this.goodsBuilder_ == null) {
                    this.goods_ = builderForValue.build();
                    onChanged();
                } else {
                    this.goodsBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeGoods(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods value) {
                if (this.goodsBuilder_ == null) {
                    if (this.goods_ != null) {
                        this.goods_ = HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.newBuilder(this.goods_).mergeFrom(value).buildPartial();
                    } else {
                        this.goods_ = value;
                    }
                    onChanged();
                } else {
                    this.goodsBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearGoods() {
                if (this.goodsBuilder_ == null) {
                    this.goods_ = null;
                    onChanged();
                } else {
                    this.goods_ = null;
                    this.goodsBuilder_ = null;
                }
                return this;
            }

            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder getGoodsBuilder() {
                onChanged();
                return getGoodsFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsOrBuilder() {
                if (this.goodsBuilder_ != null) {
                    return this.goodsBuilder_.getMessageOrBuilder();
                }
                return this.goods_ == null ? HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.getDefaultInstance() : this.goods_;
            }

            private SingleFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsFieldBuilder() {
                if (this.goodsBuilder_ == null) {
                    this.goodsBuilder_ = new SingleFieldBuilderV3<>(getGoods(), getParentForChildren(), isClean());
                    this.goods_ = null;
                }
                return this.goodsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
            public int getBuyCount() {
                return this.buyCount_;
            }

            public Builder setBuyCount(int value) {
                this.buyCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuyCount() {
                this.buyCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopBuyGoodsRspOuterClass.HomeLimitedShopBuyGoodsRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static HomeLimitedShopBuyGoodsRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopBuyGoodsRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopBuyGoodsRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopBuyGoodsRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeLimitedShopGoodsOuterClass.getDescriptor();
    }
}
