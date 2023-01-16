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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass.class */
public final class VintageMarketTraderInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dVintageMarketTraderInfo.proto\u001a\u000fItemParam.proto\"U\n\u0017VintageMarketTraderInfo\u0012\u0011\n\ttrader_id\u0018\u0004 \u0001(\r\u0012'\n\u0013available_item_list\u0018\u000f \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageMarketTraderInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageMarketTraderInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketTraderInfo_descriptor, new String[]{"TraderId", "AvailableItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass$VintageMarketTraderInfoOrBuilder.class */
    public interface VintageMarketTraderInfoOrBuilder extends MessageOrBuilder {
        int getTraderId();

        List<ItemParamOuterClass.ItemParam> getAvailableItemListList();

        ItemParamOuterClass.ItemParam getAvailableItemList(int i);

        int getAvailableItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getAvailableItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getAvailableItemListOrBuilder(int i);
    }

    private VintageMarketTraderInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass$VintageMarketTraderInfo.class */
    public static final class VintageMarketTraderInfo extends GeneratedMessageV3 implements VintageMarketTraderInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TRADER_ID_FIELD_NUMBER = 4;
        private int traderId_;
        public static final int AVAILABLE_ITEM_LIST_FIELD_NUMBER = 15;
        private List<ItemParamOuterClass.ItemParam> availableItemList_;
        private byte memoizedIsInitialized;
        private static final VintageMarketTraderInfo DEFAULT_INSTANCE = new VintageMarketTraderInfo();
        private static final Parser<VintageMarketTraderInfo> PARSER = new AbstractParser<VintageMarketTraderInfo>() { // from class: emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfo.1
            @Override // com.google.protobuf.Parser
            public VintageMarketTraderInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageMarketTraderInfo(input, extensionRegistry);
            }
        };

        private VintageMarketTraderInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintageMarketTraderInfo() {
            this.memoizedIsInitialized = -1;
            this.availableItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageMarketTraderInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintageMarketTraderInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.availableItemList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.availableItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.availableItemList_ = Collections.unmodifiableList(this.availableItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketTraderInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public int getTraderId() {
            return this.traderId_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public List<ItemParamOuterClass.ItemParam> getAvailableItemListList() {
            return this.availableItemList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getAvailableItemListOrBuilderList() {
            return this.availableItemList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public int getAvailableItemListCount() {
            return this.availableItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public ItemParamOuterClass.ItemParam getAvailableItemList(int index) {
            return this.availableItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getAvailableItemListOrBuilder(int index) {
            return this.availableItemList_.get(index);
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
            for (int i = 0; i < this.availableItemList_.size(); i++) {
                output.writeMessage(15, this.availableItemList_.get(i));
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
            for (int i = 0; i < this.availableItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.availableItemList_.get(i));
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
            if (!(obj instanceof VintageMarketTraderInfo)) {
                return equals(obj);
            }
            VintageMarketTraderInfo other = (VintageMarketTraderInfo) obj;
            return getTraderId() == other.getTraderId() && getAvailableItemListList().equals(other.getAvailableItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getTraderId();
            if (getAvailableItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getAvailableItemListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VintageMarketTraderInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketTraderInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketTraderInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketTraderInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(InputStream input) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketTraderInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageMarketTraderInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(CodedInputStream input) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketTraderInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageMarketTraderInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass$VintageMarketTraderInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageMarketTraderInfoOrBuilder {
            private int bitField0_;
            private int traderId_;
            private List<ItemParamOuterClass.ItemParam> availableItemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> availableItemListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketTraderInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageMarketTraderInfo.alwaysUseFieldBuilders) {
                    getAvailableItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.traderId_ = 0;
                if (this.availableItemListBuilder_ == null) {
                    this.availableItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.availableItemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageMarketTraderInfo getDefaultInstanceForType() {
                return VintageMarketTraderInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketTraderInfo build() {
                VintageMarketTraderInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketTraderInfo buildPartial() {
                VintageMarketTraderInfo result = new VintageMarketTraderInfo(this);
                int i = this.bitField0_;
                result.traderId_ = this.traderId_;
                if (this.availableItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.availableItemList_ = Collections.unmodifiableList(this.availableItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.availableItemList_ = this.availableItemList_;
                } else {
                    result.availableItemList_ = this.availableItemListBuilder_.build();
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
                if (other instanceof VintageMarketTraderInfo) {
                    return mergeFrom((VintageMarketTraderInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageMarketTraderInfo other) {
                if (other == VintageMarketTraderInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTraderId() != 0) {
                    setTraderId(other.getTraderId());
                }
                if (this.availableItemListBuilder_ == null) {
                    if (!other.availableItemList_.isEmpty()) {
                        if (this.availableItemList_.isEmpty()) {
                            this.availableItemList_ = other.availableItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvailableItemListIsMutable();
                            this.availableItemList_.addAll(other.availableItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.availableItemList_.isEmpty()) {
                    if (this.availableItemListBuilder_.isEmpty()) {
                        this.availableItemListBuilder_.dispose();
                        this.availableItemListBuilder_ = null;
                        this.availableItemList_ = other.availableItemList_;
                        this.bitField0_ &= -2;
                        this.availableItemListBuilder_ = VintageMarketTraderInfo.alwaysUseFieldBuilders ? getAvailableItemListFieldBuilder() : null;
                    } else {
                        this.availableItemListBuilder_.addAllMessages(other.availableItemList_);
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
                VintageMarketTraderInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageMarketTraderInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageMarketTraderInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
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

            private void ensureAvailableItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.availableItemList_ = new ArrayList(this.availableItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public List<ItemParamOuterClass.ItemParam> getAvailableItemListList() {
                if (this.availableItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.availableItemList_);
                }
                return this.availableItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public int getAvailableItemListCount() {
                if (this.availableItemListBuilder_ == null) {
                    return this.availableItemList_.size();
                }
                return this.availableItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public ItemParamOuterClass.ItemParam getAvailableItemList(int index) {
                if (this.availableItemListBuilder_ == null) {
                    return this.availableItemList_.get(index);
                }
                return this.availableItemListBuilder_.getMessage(index);
            }

            public Builder setAvailableItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.availableItemListBuilder_ != null) {
                    this.availableItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvailableItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.availableItemListBuilder_ == null) {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.availableItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvailableItemList(ItemParamOuterClass.ItemParam value) {
                if (this.availableItemListBuilder_ != null) {
                    this.availableItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvailableItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.availableItemListBuilder_ != null) {
                    this.availableItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvailableItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.availableItemListBuilder_ == null) {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.availableItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvailableItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.availableItemListBuilder_ == null) {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.availableItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvailableItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.availableItemListBuilder_ == null) {
                    ensureAvailableItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.availableItemList_);
                    onChanged();
                } else {
                    this.availableItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvailableItemList() {
                if (this.availableItemListBuilder_ == null) {
                    this.availableItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.availableItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvailableItemList(int index) {
                if (this.availableItemListBuilder_ == null) {
                    ensureAvailableItemListIsMutable();
                    this.availableItemList_.remove(index);
                    onChanged();
                } else {
                    this.availableItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getAvailableItemListBuilder(int index) {
                return getAvailableItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getAvailableItemListOrBuilder(int index) {
                if (this.availableItemListBuilder_ == null) {
                    return this.availableItemList_.get(index);
                }
                return this.availableItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getAvailableItemListOrBuilderList() {
                if (this.availableItemListBuilder_ != null) {
                    return this.availableItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.availableItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addAvailableItemListBuilder() {
                return getAvailableItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addAvailableItemListBuilder(int index) {
                return getAvailableItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getAvailableItemListBuilderList() {
                return getAvailableItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getAvailableItemListFieldBuilder() {
                if (this.availableItemListBuilder_ == null) {
                    this.availableItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.availableItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.availableItemList_ = null;
                }
                return this.availableItemListBuilder_;
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

        public static VintageMarketTraderInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageMarketTraderInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageMarketTraderInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageMarketTraderInfo getDefaultInstanceForType() {
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
