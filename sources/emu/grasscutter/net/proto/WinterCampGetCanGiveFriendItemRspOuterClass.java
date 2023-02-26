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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetCanGiveFriendItemRspOuterClass.class */
public final class WinterCampGetCanGiveFriendItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'WinterCampGetCanGiveFriendItemRsp.proto\u001a\u000fItemParam.proto\"R\n!WinterCampGetCanGiveFriendItemRsp\u0012\u000f\n\u0007retcode\u0018\u0002 \u0001(\u0005\u0012\u001c\n\bitemList\u0018\u0001 \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampGetCanGiveFriendItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_WinterCampGetCanGiveFriendItemRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f916x78f6c04e = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampGetCanGiveFriendItemRsp_descriptor, new String[]{"Retcode", "ItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetCanGiveFriendItemRspOuterClass$WinterCampGetCanGiveFriendItemRspOrBuilder.class */
    public interface WinterCampGetCanGiveFriendItemRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<ItemParamOuterClass.ItemParam> getItemListList();

        ItemParamOuterClass.ItemParam getItemList(int i);

        int getItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int i);
    }

    private WinterCampGetCanGiveFriendItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetCanGiveFriendItemRspOuterClass$WinterCampGetCanGiveFriendItemRsp.class */
    public static final class WinterCampGetCanGiveFriendItemRsp extends GeneratedMessageV3 implements WinterCampGetCanGiveFriendItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 2;
        private int retcode_;
        public static final int ITEMLIST_FIELD_NUMBER = 1;
        private List<ItemParamOuterClass.ItemParam> itemList_;
        private byte memoizedIsInitialized;
        private static final WinterCampGetCanGiveFriendItemRsp DEFAULT_INSTANCE = new WinterCampGetCanGiveFriendItemRsp();
        private static final Parser<WinterCampGetCanGiveFriendItemRsp> PARSER = new AbstractParser<WinterCampGetCanGiveFriendItemRsp>() { // from class: emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRsp.1
            @Override // com.google.protobuf.Parser
            public WinterCampGetCanGiveFriendItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampGetCanGiveFriendItemRsp(input, extensionRegistry);
            }
        };

        private WinterCampGetCanGiveFriendItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampGetCanGiveFriendItemRsp() {
            this.memoizedIsInitialized = -1;
            this.itemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampGetCanGiveFriendItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampGetCanGiveFriendItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.itemList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.itemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 16:
                                    this.retcode_ = input.readInt32();
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
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampGetCanGiveFriendItemRspOuterClass.internal_static_WinterCampGetCanGiveFriendItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampGetCanGiveFriendItemRspOuterClass.f916x78f6c04e.ensureFieldAccessorsInitialized(WinterCampGetCanGiveFriendItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
            return this.itemList_.get(index);
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
            for (int i = 0; i < this.itemList_.size(); i++) {
                output.writeMessage(1, this.itemList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(2, this.retcode_);
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
            for (int i = 0; i < this.itemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.itemList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(2, this.retcode_);
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
            if (!(obj instanceof WinterCampGetCanGiveFriendItemRsp)) {
                return equals(obj);
            }
            WinterCampGetCanGiveFriendItemRsp other = (WinterCampGetCanGiveFriendItemRsp) obj;
            return getRetcode() == other.getRetcode() && getItemListList().equals(other.getItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getRetcode();
            if (getItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getItemListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(InputStream input) throws IOException {
            return (WinterCampGetCanGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGetCanGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampGetCanGiveFriendItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGetCanGiveFriendItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampGetCanGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampGetCanGiveFriendItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampGetCanGiveFriendItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampGetCanGiveFriendItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampGetCanGiveFriendItemRspOuterClass$WinterCampGetCanGiveFriendItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampGetCanGiveFriendItemRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<ItemParamOuterClass.ItemParam> itemList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampGetCanGiveFriendItemRspOuterClass.internal_static_WinterCampGetCanGiveFriendItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampGetCanGiveFriendItemRspOuterClass.f916x78f6c04e.ensureFieldAccessorsInitialized(WinterCampGetCanGiveFriendItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampGetCanGiveFriendItemRsp.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampGetCanGiveFriendItemRspOuterClass.internal_static_WinterCampGetCanGiveFriendItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampGetCanGiveFriendItemRsp getDefaultInstanceForType() {
                return WinterCampGetCanGiveFriendItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampGetCanGiveFriendItemRsp build() {
                WinterCampGetCanGiveFriendItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampGetCanGiveFriendItemRsp buildPartial() {
                WinterCampGetCanGiveFriendItemRsp result = new WinterCampGetCanGiveFriendItemRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemList_ = this.itemList_;
                } else {
                    result.itemList_ = this.itemListBuilder_.build();
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
                if (other instanceof WinterCampGetCanGiveFriendItemRsp) {
                    return mergeFrom((WinterCampGetCanGiveFriendItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampGetCanGiveFriendItemRsp other) {
                if (other == WinterCampGetCanGiveFriendItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                        this.itemListBuilder_ = WinterCampGetCanGiveFriendItemRsp.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
                    } else {
                        this.itemListBuilder_.addAllMessages(other.itemList_);
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
                WinterCampGetCanGiveFriendItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampGetCanGiveFriendItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampGetCanGiveFriendItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
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

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampGetCanGiveFriendItemRspOuterClass.WinterCampGetCanGiveFriendItemRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static WinterCampGetCanGiveFriendItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampGetCanGiveFriendItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampGetCanGiveFriendItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampGetCanGiveFriendItemRsp getDefaultInstanceForType() {
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
