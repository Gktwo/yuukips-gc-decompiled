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
import emu.grasscutter.net.proto.HomeLimitedShopGoodsOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopOuterClass.class */
public final class HomeLimitedShopOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015HomeLimitedShop.proto\u001a\u001aHomeLimitedShopGoods.proto\";\n\u000fHomeLimitedShop\u0012(\n\tgoodsList\u0018\t \u0003(\u000b2\u0015.HomeLimitedShopGoodsB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeLimitedShopGoodsOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShop_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShop_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShop_descriptor, new String[]{"GoodsList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopOuterClass$HomeLimitedShopOrBuilder.class */
    public interface HomeLimitedShopOrBuilder extends MessageOrBuilder {
        List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> getGoodsListList();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoodsList(int i);

        int getGoodsListCount();

        List<? extends HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsListOrBuilderList();

        HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsListOrBuilder(int i);
    }

    private HomeLimitedShopOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopOuterClass$HomeLimitedShop.class */
    public static final class HomeLimitedShop extends GeneratedMessageV3 implements HomeLimitedShopOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GOODSLIST_FIELD_NUMBER = 9;
        private List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> goodsList_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShop DEFAULT_INSTANCE = new HomeLimitedShop();
        private static final Parser<HomeLimitedShop> PARSER = new AbstractParser<HomeLimitedShop>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShop.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShop parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShop(input, extensionRegistry);
            }
        };

        private HomeLimitedShop(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShop() {
            this.memoizedIsInitialized = -1;
            this.goodsList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShop();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShop(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.goodsList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.goodsList_.add((HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods) input.readMessage(HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.goodsList_ = Collections.unmodifiableList(this.goodsList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeLimitedShopOuterClass.internal_static_HomeLimitedShop_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopOuterClass.internal_static_HomeLimitedShop_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShop.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
        public List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> getGoodsListList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
        public List<? extends HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> getGoodsListOrBuilderList() {
            return this.goodsList_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
        public int getGoodsListCount() {
            return this.goodsList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods getGoodsList(int index) {
            return this.goodsList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
        public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
            return this.goodsList_.get(index);
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
            for (int i = 0; i < this.goodsList_.size(); i++) {
                output.writeMessage(9, this.goodsList_.get(i));
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
            for (int i = 0; i < this.goodsList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.goodsList_.get(i));
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
            if (!(obj instanceof HomeLimitedShop)) {
                return equals(obj);
            }
            HomeLimitedShop other = (HomeLimitedShop) obj;
            return getGoodsListList().equals(other.getGoodsListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGoodsListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getGoodsListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeLimitedShop parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShop parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShop parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShop parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShop parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShop parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShop parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShop) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShop parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShop) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShop parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShop) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShop parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShop) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShop parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShop) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShop parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShop) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShop prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopOuterClass$HomeLimitedShop$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopOrBuilder {
            private int bitField0_;
            private List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> goodsList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods.Builder, HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder> goodsListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopOuterClass.internal_static_HomeLimitedShop_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopOuterClass.internal_static_HomeLimitedShop_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShop.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShop.alwaysUseFieldBuilders) {
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
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopOuterClass.internal_static_HomeLimitedShop_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShop getDefaultInstanceForType() {
                return HomeLimitedShop.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShop build() {
                HomeLimitedShop result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShop buildPartial() {
                HomeLimitedShop result = new HomeLimitedShop(this);
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
                if (other instanceof HomeLimitedShop) {
                    return mergeFrom((HomeLimitedShop) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShop other) {
                if (other == HomeLimitedShop.getDefaultInstance()) {
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
                        this.goodsListBuilder_ = HomeLimitedShop.alwaysUseFieldBuilders ? getGoodsListFieldBuilder() : null;
                    } else {
                        this.goodsListBuilder_.addAllMessages(other.goodsList_);
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
                HomeLimitedShop parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShop.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShop) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
            public List<HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoods> getGoodsListList() {
                if (this.goodsListBuilder_ == null) {
                    return Collections.unmodifiableList(this.goodsList_);
                }
                return this.goodsListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
            public int getGoodsListCount() {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.size();
                }
                return this.goodsListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
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

            @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
            public HomeLimitedShopGoodsOuterClass.HomeLimitedShopGoodsOrBuilder getGoodsListOrBuilder(int index) {
                if (this.goodsListBuilder_ == null) {
                    return this.goodsList_.get(index);
                }
                return this.goodsListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopOuterClass.HomeLimitedShopOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static HomeLimitedShop getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShop> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShop> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShop getDefaultInstanceForType() {
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
