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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketDeliverItemReqOuterClass.class */
public final class VintageMarketDeliverItemReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!VintageMarketDeliverItemReq.proto\u001a\u000fItemParam.proto\"T\n\u001bVintageMarketDeliverItemReq\u0012#\n\u000fdeliverItemList\u0018\u000f \u0003(\u000b2\n.ItemParam\u0012\u0010\n\btraderId\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageMarketDeliverItemReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageMarketDeliverItemReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketDeliverItemReq_descriptor, new String[]{"DeliverItemList", "TraderId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketDeliverItemReqOuterClass$VintageMarketDeliverItemReqOrBuilder.class */
    public interface VintageMarketDeliverItemReqOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getDeliverItemListList();

        ItemParamOuterClass.ItemParam getDeliverItemList(int i);

        int getDeliverItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getDeliverItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getDeliverItemListOrBuilder(int i);

        int getTraderId();
    }

    private VintageMarketDeliverItemReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketDeliverItemReqOuterClass$VintageMarketDeliverItemReq.class */
    public static final class VintageMarketDeliverItemReq extends GeneratedMessageV3 implements VintageMarketDeliverItemReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DELIVERITEMLIST_FIELD_NUMBER = 15;
        private List<ItemParamOuterClass.ItemParam> deliverItemList_;
        public static final int TRADERID_FIELD_NUMBER = 4;
        private int traderId_;
        private byte memoizedIsInitialized;
        private static final VintageMarketDeliverItemReq DEFAULT_INSTANCE = new VintageMarketDeliverItemReq();
        private static final Parser<VintageMarketDeliverItemReq> PARSER = new AbstractParser<VintageMarketDeliverItemReq>() { // from class: emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReq.1
            @Override // com.google.protobuf.Parser
            public VintageMarketDeliverItemReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageMarketDeliverItemReq(input, extensionRegistry);
            }
        };

        private VintageMarketDeliverItemReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintageMarketDeliverItemReq() {
            this.memoizedIsInitialized = -1;
            this.deliverItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageMarketDeliverItemReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintageMarketDeliverItemReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.traderId_ = input.readUInt32();
                                    break;
                                case 122:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.deliverItemList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.deliverItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.deliverItemList_ = Collections.unmodifiableList(this.deliverItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VintageMarketDeliverItemReqOuterClass.internal_static_VintageMarketDeliverItemReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageMarketDeliverItemReqOuterClass.internal_static_VintageMarketDeliverItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketDeliverItemReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
        public List<ItemParamOuterClass.ItemParam> getDeliverItemListList() {
            return this.deliverItemList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getDeliverItemListOrBuilderList() {
            return this.deliverItemList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
        public int getDeliverItemListCount() {
            return this.deliverItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
        public ItemParamOuterClass.ItemParam getDeliverItemList(int index) {
            return this.deliverItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getDeliverItemListOrBuilder(int index) {
            return this.deliverItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
        public int getTraderId() {
            return this.traderId_;
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
            if (this.traderId_ != 0) {
                output.writeUInt32(4, this.traderId_);
            }
            for (int i = 0; i < this.deliverItemList_.size(); i++) {
                output.writeMessage(15, this.deliverItemList_.get(i));
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
            if (this.traderId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.traderId_);
            }
            for (int i = 0; i < this.deliverItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.deliverItemList_.get(i));
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
            if (!(obj instanceof VintageMarketDeliverItemReq)) {
                return equals(obj);
            }
            VintageMarketDeliverItemReq other = (VintageMarketDeliverItemReq) obj;
            return getDeliverItemListList().equals(other.getDeliverItemListList()) && getTraderId() == other.getTraderId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDeliverItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getDeliverItemListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getTraderId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VintageMarketDeliverItemReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketDeliverItemReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketDeliverItemReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketDeliverItemReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketDeliverItemReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketDeliverItemReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketDeliverItemReq parseFrom(InputStream input) throws IOException {
            return (VintageMarketDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketDeliverItemReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketDeliverItemReq parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageMarketDeliverItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageMarketDeliverItemReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketDeliverItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketDeliverItemReq parseFrom(CodedInputStream input) throws IOException {
            return (VintageMarketDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketDeliverItemReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageMarketDeliverItemReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketDeliverItemReqOuterClass$VintageMarketDeliverItemReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageMarketDeliverItemReqOrBuilder {
            private int bitField0_;
            private List<ItemParamOuterClass.ItemParam> deliverItemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> deliverItemListBuilder_;
            private int traderId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageMarketDeliverItemReqOuterClass.internal_static_VintageMarketDeliverItemReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageMarketDeliverItemReqOuterClass.internal_static_VintageMarketDeliverItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketDeliverItemReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageMarketDeliverItemReq.alwaysUseFieldBuilders) {
                    getDeliverItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.deliverItemListBuilder_ == null) {
                    this.deliverItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.deliverItemListBuilder_.clear();
                }
                this.traderId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageMarketDeliverItemReqOuterClass.internal_static_VintageMarketDeliverItemReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageMarketDeliverItemReq getDefaultInstanceForType() {
                return VintageMarketDeliverItemReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketDeliverItemReq build() {
                VintageMarketDeliverItemReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketDeliverItemReq buildPartial() {
                VintageMarketDeliverItemReq result = new VintageMarketDeliverItemReq(this);
                int i = this.bitField0_;
                if (this.deliverItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.deliverItemList_ = Collections.unmodifiableList(this.deliverItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.deliverItemList_ = this.deliverItemList_;
                } else {
                    result.deliverItemList_ = this.deliverItemListBuilder_.build();
                }
                result.traderId_ = this.traderId_;
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
                if (other instanceof VintageMarketDeliverItemReq) {
                    return mergeFrom((VintageMarketDeliverItemReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageMarketDeliverItemReq other) {
                if (other == VintageMarketDeliverItemReq.getDefaultInstance()) {
                    return this;
                }
                if (this.deliverItemListBuilder_ == null) {
                    if (!other.deliverItemList_.isEmpty()) {
                        if (this.deliverItemList_.isEmpty()) {
                            this.deliverItemList_ = other.deliverItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDeliverItemListIsMutable();
                            this.deliverItemList_.addAll(other.deliverItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.deliverItemList_.isEmpty()) {
                    if (this.deliverItemListBuilder_.isEmpty()) {
                        this.deliverItemListBuilder_.dispose();
                        this.deliverItemListBuilder_ = null;
                        this.deliverItemList_ = other.deliverItemList_;
                        this.bitField0_ &= -2;
                        this.deliverItemListBuilder_ = VintageMarketDeliverItemReq.alwaysUseFieldBuilders ? getDeliverItemListFieldBuilder() : null;
                    } else {
                        this.deliverItemListBuilder_.addAllMessages(other.deliverItemList_);
                    }
                }
                if (other.getTraderId() != 0) {
                    setTraderId(other.getTraderId());
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
                VintageMarketDeliverItemReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageMarketDeliverItemReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageMarketDeliverItemReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDeliverItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.deliverItemList_ = new ArrayList(this.deliverItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
            public List<ItemParamOuterClass.ItemParam> getDeliverItemListList() {
                if (this.deliverItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.deliverItemList_);
                }
                return this.deliverItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
            public int getDeliverItemListCount() {
                if (this.deliverItemListBuilder_ == null) {
                    return this.deliverItemList_.size();
                }
                return this.deliverItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
            public ItemParamOuterClass.ItemParam getDeliverItemList(int index) {
                if (this.deliverItemListBuilder_ == null) {
                    return this.deliverItemList_.get(index);
                }
                return this.deliverItemListBuilder_.getMessage(index);
            }

            public Builder setDeliverItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.deliverItemListBuilder_ != null) {
                    this.deliverItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDeliverItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.deliverItemListBuilder_ == null) {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deliverItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDeliverItemList(ItemParamOuterClass.ItemParam value) {
                if (this.deliverItemListBuilder_ != null) {
                    this.deliverItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeliverItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.deliverItemListBuilder_ != null) {
                    this.deliverItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeliverItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.deliverItemListBuilder_ == null) {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.deliverItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDeliverItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.deliverItemListBuilder_ == null) {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deliverItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDeliverItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.deliverItemListBuilder_ == null) {
                    ensureDeliverItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.deliverItemList_);
                    onChanged();
                } else {
                    this.deliverItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDeliverItemList() {
                if (this.deliverItemListBuilder_ == null) {
                    this.deliverItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.deliverItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDeliverItemList(int index) {
                if (this.deliverItemListBuilder_ == null) {
                    ensureDeliverItemListIsMutable();
                    this.deliverItemList_.remove(index);
                    onChanged();
                } else {
                    this.deliverItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getDeliverItemListBuilder(int index) {
                return getDeliverItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getDeliverItemListOrBuilder(int index) {
                if (this.deliverItemListBuilder_ == null) {
                    return this.deliverItemList_.get(index);
                }
                return this.deliverItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getDeliverItemListOrBuilderList() {
                if (this.deliverItemListBuilder_ != null) {
                    return this.deliverItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.deliverItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addDeliverItemListBuilder() {
                return getDeliverItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addDeliverItemListBuilder(int index) {
                return getDeliverItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getDeliverItemListBuilderList() {
                return getDeliverItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getDeliverItemListFieldBuilder() {
                if (this.deliverItemListBuilder_ == null) {
                    this.deliverItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.deliverItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.deliverItemList_ = null;
                }
                return this.deliverItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketDeliverItemReqOuterClass.VintageMarketDeliverItemReqOrBuilder
            public int getTraderId() {
                return this.traderId_;
            }

            public Builder setTraderId(int value) {
                this.traderId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTraderId() {
                this.traderId_ = 0;
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

        public static VintageMarketDeliverItemReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageMarketDeliverItemReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageMarketDeliverItemReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageMarketDeliverItemReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
    }
}
