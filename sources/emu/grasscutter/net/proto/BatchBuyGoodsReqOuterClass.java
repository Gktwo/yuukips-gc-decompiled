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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BuyGoodsParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsReqOuterClass.class */
public final class BatchBuyGoodsReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016BatchBuyGoodsReq.proto\u001a\u0013BuyGoodsParam.proto\"M\n\u0010BatchBuyGoodsReq\u0012\u0011\n\tshop_type\u0018\u000f \u0001(\r\u0012&\n\u000ebuy_goods_list\u0018\f \u0003(\u000b2\u000e.BuyGoodsParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BuyGoodsParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BatchBuyGoodsReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BatchBuyGoodsReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BatchBuyGoodsReq_descriptor, new String[]{"ShopType", "BuyGoodsList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsReqOuterClass$BatchBuyGoodsReqOrBuilder.class */
    public interface BatchBuyGoodsReqOrBuilder extends MessageOrBuilder {
        int getShopType();

        List<BuyGoodsParamOuterClass.BuyGoodsParam> getBuyGoodsListList();

        BuyGoodsParamOuterClass.BuyGoodsParam getBuyGoodsList(int i);

        int getBuyGoodsListCount();

        List<? extends BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListOrBuilderList();

        BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder getBuyGoodsListOrBuilder(int i);
    }

    private BatchBuyGoodsReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsReqOuterClass$BatchBuyGoodsReq.class */
    public static final class BatchBuyGoodsReq extends GeneratedMessageV3 implements BatchBuyGoodsReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOP_TYPE_FIELD_NUMBER = 15;
        private int shopType_;
        public static final int BUY_GOODS_LIST_FIELD_NUMBER = 12;
        private List<BuyGoodsParamOuterClass.BuyGoodsParam> buyGoodsList_;
        private byte memoizedIsInitialized;
        private static final BatchBuyGoodsReq DEFAULT_INSTANCE = new BatchBuyGoodsReq();
        private static final Parser<BatchBuyGoodsReq> PARSER = new AbstractParser<BatchBuyGoodsReq>() { // from class: emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReq.1
            @Override // com.google.protobuf.Parser
            public BatchBuyGoodsReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BatchBuyGoodsReq(input, extensionRegistry);
            }
        };

        private BatchBuyGoodsReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BatchBuyGoodsReq() {
            this.memoizedIsInitialized = -1;
            this.buyGoodsList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BatchBuyGoodsReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BatchBuyGoodsReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.buyGoodsList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.buyGoodsList_.add((BuyGoodsParamOuterClass.BuyGoodsParam) input.readMessage(BuyGoodsParamOuterClass.BuyGoodsParam.parser(), extensionRegistry));
                                    break;
                                case 120:
                                    this.shopType_ = input.readUInt32();
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
                    this.buyGoodsList_ = Collections.unmodifiableList(this.buyGoodsList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BatchBuyGoodsReqOuterClass.internal_static_BatchBuyGoodsReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BatchBuyGoodsReqOuterClass.internal_static_BatchBuyGoodsReq_fieldAccessorTable.ensureFieldAccessorsInitialized(BatchBuyGoodsReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
        public int getShopType() {
            return this.shopType_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
        public List<BuyGoodsParamOuterClass.BuyGoodsParam> getBuyGoodsListList() {
            return this.buyGoodsList_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
        public List<? extends BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListOrBuilderList() {
            return this.buyGoodsList_;
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
        public int getBuyGoodsListCount() {
            return this.buyGoodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
        public BuyGoodsParamOuterClass.BuyGoodsParam getBuyGoodsList(int index) {
            return this.buyGoodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
        public BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder getBuyGoodsListOrBuilder(int index) {
            return this.buyGoodsList_.get(index);
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
            for (int i = 0; i < this.buyGoodsList_.size(); i++) {
                output.writeMessage(12, this.buyGoodsList_.get(i));
            }
            if (this.shopType_ != 0) {
                output.writeUInt32(15, this.shopType_);
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
            for (int i = 0; i < this.buyGoodsList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.buyGoodsList_.get(i));
            }
            if (this.shopType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.shopType_);
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
            if (!(obj instanceof BatchBuyGoodsReq)) {
                return equals(obj);
            }
            BatchBuyGoodsReq other = (BatchBuyGoodsReq) obj;
            return getShopType() == other.getShopType() && getBuyGoodsListList().equals(other.getBuyGoodsListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getShopType();
            if (getBuyGoodsListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getBuyGoodsListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BatchBuyGoodsReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BatchBuyGoodsReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BatchBuyGoodsReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BatchBuyGoodsReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BatchBuyGoodsReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BatchBuyGoodsReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BatchBuyGoodsReq parseFrom(InputStream input) throws IOException {
            return (BatchBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BatchBuyGoodsReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BatchBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BatchBuyGoodsReq parseDelimitedFrom(InputStream input) throws IOException {
            return (BatchBuyGoodsReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BatchBuyGoodsReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BatchBuyGoodsReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BatchBuyGoodsReq parseFrom(CodedInputStream input) throws IOException {
            return (BatchBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BatchBuyGoodsReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BatchBuyGoodsReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BatchBuyGoodsReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BatchBuyGoodsReqOuterClass$BatchBuyGoodsReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BatchBuyGoodsReqOrBuilder {
            private int bitField0_;
            private int shopType_;
            private List<BuyGoodsParamOuterClass.BuyGoodsParam> buyGoodsList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BuyGoodsParamOuterClass.BuyGoodsParam, BuyGoodsParamOuterClass.BuyGoodsParam.Builder, BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> buyGoodsListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BatchBuyGoodsReqOuterClass.internal_static_BatchBuyGoodsReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BatchBuyGoodsReqOuterClass.internal_static_BatchBuyGoodsReq_fieldAccessorTable.ensureFieldAccessorsInitialized(BatchBuyGoodsReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BatchBuyGoodsReq.alwaysUseFieldBuilders) {
                    getBuyGoodsListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.shopType_ = 0;
                if (this.buyGoodsListBuilder_ == null) {
                    this.buyGoodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.buyGoodsListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BatchBuyGoodsReqOuterClass.internal_static_BatchBuyGoodsReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BatchBuyGoodsReq getDefaultInstanceForType() {
                return BatchBuyGoodsReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BatchBuyGoodsReq build() {
                BatchBuyGoodsReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BatchBuyGoodsReq buildPartial() {
                BatchBuyGoodsReq result = new BatchBuyGoodsReq(this);
                int i = this.bitField0_;
                result.shopType_ = this.shopType_;
                if (this.buyGoodsListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.buyGoodsList_ = Collections.unmodifiableList(this.buyGoodsList_);
                        this.bitField0_ &= -2;
                    }
                    result.buyGoodsList_ = this.buyGoodsList_;
                } else {
                    result.buyGoodsList_ = this.buyGoodsListBuilder_.build();
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
                if (other instanceof BatchBuyGoodsReq) {
                    return mergeFrom((BatchBuyGoodsReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BatchBuyGoodsReq other) {
                if (other == BatchBuyGoodsReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getShopType() != 0) {
                    setShopType(other.getShopType());
                }
                if (this.buyGoodsListBuilder_ == null) {
                    if (!other.buyGoodsList_.isEmpty()) {
                        if (this.buyGoodsList_.isEmpty()) {
                            this.buyGoodsList_ = other.buyGoodsList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBuyGoodsListIsMutable();
                            this.buyGoodsList_.addAll(other.buyGoodsList_);
                        }
                        onChanged();
                    }
                } else if (!other.buyGoodsList_.isEmpty()) {
                    if (this.buyGoodsListBuilder_.isEmpty()) {
                        this.buyGoodsListBuilder_.dispose();
                        this.buyGoodsListBuilder_ = null;
                        this.buyGoodsList_ = other.buyGoodsList_;
                        this.bitField0_ &= -2;
                        this.buyGoodsListBuilder_ = BatchBuyGoodsReq.alwaysUseFieldBuilders ? getBuyGoodsListFieldBuilder() : null;
                    } else {
                        this.buyGoodsListBuilder_.addAllMessages(other.buyGoodsList_);
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
                BatchBuyGoodsReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = BatchBuyGoodsReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BatchBuyGoodsReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
            public int getShopType() {
                return this.shopType_;
            }

            public Builder setShopType(int value) {
                this.shopType_ = value;
                onChanged();
                return this;
            }

            public Builder clearShopType() {
                this.shopType_ = 0;
                onChanged();
                return this;
            }

            private void ensureBuyGoodsListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.buyGoodsList_ = new ArrayList(this.buyGoodsList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
            public List<BuyGoodsParamOuterClass.BuyGoodsParam> getBuyGoodsListList() {
                if (this.buyGoodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.buyGoodsList_);
                }
                return this.buyGoodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
            public int getBuyGoodsListCount() {
                if (this.buyGoodsListBuilder_ == null) {
                    return this.buyGoodsList_.size();
                }
                return this.buyGoodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
            public BuyGoodsParamOuterClass.BuyGoodsParam getBuyGoodsList(int index) {
                if (this.buyGoodsListBuilder_ == null) {
                    return this.buyGoodsList_.get(index);
                }
                return this.buyGoodsListBuilder_.getMessage(index);
            }

            public Builder setBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam value) {
                if (this.buyGoodsListBuilder_ != null) {
                    this.buyGoodsListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam.Builder builderForValue) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBuyGoodsList(BuyGoodsParamOuterClass.BuyGoodsParam value) {
                if (this.buyGoodsListBuilder_ != null) {
                    this.buyGoodsListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam value) {
                if (this.buyGoodsListBuilder_ != null) {
                    this.buyGoodsListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuyGoodsList(BuyGoodsParamOuterClass.BuyGoodsParam.Builder builderForValue) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBuyGoodsList(int index, BuyGoodsParamOuterClass.BuyGoodsParam.Builder builderForValue) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBuyGoodsList(Iterable<? extends BuyGoodsParamOuterClass.BuyGoodsParam> values) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.buyGoodsList_);
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBuyGoodsList() {
                if (this.buyGoodsListBuilder_ == null) {
                    this.buyGoodsList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBuyGoodsList(int index) {
                if (this.buyGoodsListBuilder_ == null) {
                    ensureBuyGoodsListIsMutable();
                    this.buyGoodsList_.remove(index);
                    onChanged();
                } else {
                    this.buyGoodsListBuilder_.remove(index);
                }
                return this;
            }

            public BuyGoodsParamOuterClass.BuyGoodsParam.Builder getBuyGoodsListBuilder(int index) {
                return getBuyGoodsListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
            public BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder getBuyGoodsListOrBuilder(int index) {
                if (this.buyGoodsListBuilder_ == null) {
                    return this.buyGoodsList_.get(index);
                }
                return this.buyGoodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BatchBuyGoodsReqOuterClass.BatchBuyGoodsReqOrBuilder
            public List<? extends BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListOrBuilderList() {
                if (this.buyGoodsListBuilder_ != null) {
                    return this.buyGoodsListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.buyGoodsList_);
            }

            public BuyGoodsParamOuterClass.BuyGoodsParam.Builder addBuyGoodsListBuilder() {
                return getBuyGoodsListFieldBuilder().addBuilder(BuyGoodsParamOuterClass.BuyGoodsParam.getDefaultInstance());
            }

            public BuyGoodsParamOuterClass.BuyGoodsParam.Builder addBuyGoodsListBuilder(int index) {
                return getBuyGoodsListFieldBuilder().addBuilder(index, BuyGoodsParamOuterClass.BuyGoodsParam.getDefaultInstance());
            }

            public List<BuyGoodsParamOuterClass.BuyGoodsParam.Builder> getBuyGoodsListBuilderList() {
                return getBuyGoodsListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BuyGoodsParamOuterClass.BuyGoodsParam, BuyGoodsParamOuterClass.BuyGoodsParam.Builder, BuyGoodsParamOuterClass.BuyGoodsParamOrBuilder> getBuyGoodsListFieldBuilder() {
                if (this.buyGoodsListBuilder_ == null) {
                    this.buyGoodsListBuilder_ = new RepeatedFieldBuilderV3<>(this.buyGoodsList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.buyGoodsList_ = null;
                }
                return this.buyGoodsListBuilder_;
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

        public static BatchBuyGoodsReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BatchBuyGoodsReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BatchBuyGoodsReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BatchBuyGoodsReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BuyGoodsParamOuterClass.getDescriptor();
    }
}
