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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeReqOuterClass.class */
public final class WeaponUpgradeReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016WeaponUpgradeReq.proto\u001a\u000fItemParam.proto\"k\n\u0010WeaponUpgradeReq\u0012!\n\ritemParamList\u0018\u0001 \u0003(\u000b2\n.ItemParam\u0012\u0018\n\u0010targetWeaponGuid\u0018\u000b \u0001(\u0004\u0012\u001a\n\u0012foodWeaponGuidList\u0018\u0007 \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WeaponUpgradeReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WeaponUpgradeReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponUpgradeReq_descriptor, new String[]{"ItemParamList", "TargetWeaponGuid", "FoodWeaponGuidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeReqOuterClass$WeaponUpgradeReqOrBuilder.class */
    public interface WeaponUpgradeReqOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getItemParamListList();

        ItemParamOuterClass.ItemParam getItemParamList(int i);

        int getItemParamListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int i);

        long getTargetWeaponGuid();

        List<Long> getFoodWeaponGuidListList();

        int getFoodWeaponGuidListCount();

        long getFoodWeaponGuidList(int i);
    }

    private WeaponUpgradeReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeReqOuterClass$WeaponUpgradeReq.class */
    public static final class WeaponUpgradeReq extends GeneratedMessageV3 implements WeaponUpgradeReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEMPARAMLIST_FIELD_NUMBER = 1;
        private List<ItemParamOuterClass.ItemParam> itemParamList_;
        public static final int TARGETWEAPONGUID_FIELD_NUMBER = 11;
        private long targetWeaponGuid_;
        public static final int FOODWEAPONGUIDLIST_FIELD_NUMBER = 7;
        private Internal.LongList foodWeaponGuidList_;
        private int foodWeaponGuidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final WeaponUpgradeReq DEFAULT_INSTANCE = new WeaponUpgradeReq();
        private static final Parser<WeaponUpgradeReq> PARSER = new AbstractParser<WeaponUpgradeReq>() { // from class: emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReq.1
            @Override // com.google.protobuf.Parser
            public WeaponUpgradeReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WeaponUpgradeReq(input, extensionRegistry);
            }
        };

        private WeaponUpgradeReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.foodWeaponGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WeaponUpgradeReq() {
            this.foodWeaponGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.itemParamList_ = Collections.emptyList();
            this.foodWeaponGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WeaponUpgradeReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x010d */
        private WeaponUpgradeReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemParamList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.itemParamList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.foodWeaponGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.foodWeaponGuidList_.addLong(input.readUInt64());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.foodWeaponGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.foodWeaponGuidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.targetWeaponGuid_ = input.readUInt64();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.foodWeaponGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WeaponUpgradeReqOuterClass.internal_static_WeaponUpgradeReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WeaponUpgradeReqOuterClass.internal_static_WeaponUpgradeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponUpgradeReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public int getItemParamListCount() {
            return this.itemParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public ItemParamOuterClass.ItemParam getItemParamList(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public long getTargetWeaponGuid() {
            return this.targetWeaponGuid_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public List<Long> getFoodWeaponGuidListList() {
            return this.foodWeaponGuidList_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public int getFoodWeaponGuidListCount() {
            return this.foodWeaponGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
        public long getFoodWeaponGuidList(int index) {
            return this.foodWeaponGuidList_.getLong(index);
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
            getSerializedSize();
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                output.writeMessage(1, this.itemParamList_.get(i));
            }
            if (getFoodWeaponGuidListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.foodWeaponGuidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.foodWeaponGuidList_.size(); i2++) {
                output.writeUInt64NoTag(this.foodWeaponGuidList_.getLong(i2));
            }
            if (this.targetWeaponGuid_ != 0) {
                output.writeUInt64(11, this.targetWeaponGuid_);
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
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.itemParamList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.foodWeaponGuidList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.foodWeaponGuidList_.getLong(i2));
            }
            int size3 = size2 + dataSize;
            if (!getFoodWeaponGuidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.foodWeaponGuidListMemoizedSerializedSize = dataSize;
            if (this.targetWeaponGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(11, this.targetWeaponGuid_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WeaponUpgradeReq)) {
                return equals(obj);
            }
            WeaponUpgradeReq other = (WeaponUpgradeReq) obj;
            return getItemParamListList().equals(other.getItemParamListList()) && getTargetWeaponGuid() == other.getTargetWeaponGuid() && getFoodWeaponGuidListList().equals(other.getFoodWeaponGuidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getItemParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getItemParamListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 11)) + Internal.hashLong(getTargetWeaponGuid());
            if (getFoodWeaponGuidListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getFoodWeaponGuidListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static WeaponUpgradeReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponUpgradeReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponUpgradeReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponUpgradeReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponUpgradeReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponUpgradeReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponUpgradeReq parseFrom(InputStream input) throws IOException {
            return (WeaponUpgradeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponUpgradeReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponUpgradeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponUpgradeReq parseDelimitedFrom(InputStream input) throws IOException {
            return (WeaponUpgradeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WeaponUpgradeReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponUpgradeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponUpgradeReq parseFrom(CodedInputStream input) throws IOException {
            return (WeaponUpgradeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponUpgradeReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponUpgradeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WeaponUpgradeReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeReqOuterClass$WeaponUpgradeReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WeaponUpgradeReqOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemParamListBuilder_;
            private long targetWeaponGuid_;
            private List<ItemParamOuterClass.ItemParam> itemParamList_ = Collections.emptyList();
            private Internal.LongList foodWeaponGuidList_ = WeaponUpgradeReq.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WeaponUpgradeReqOuterClass.internal_static_WeaponUpgradeReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WeaponUpgradeReqOuterClass.internal_static_WeaponUpgradeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponUpgradeReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WeaponUpgradeReq.alwaysUseFieldBuilders) {
                    getItemParamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemParamListBuilder_.clear();
                }
                this.targetWeaponGuid_ = 0;
                this.foodWeaponGuidList_ = WeaponUpgradeReq.emptyLongList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WeaponUpgradeReqOuterClass.internal_static_WeaponUpgradeReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WeaponUpgradeReq getDefaultInstanceForType() {
                return WeaponUpgradeReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponUpgradeReq build() {
                WeaponUpgradeReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponUpgradeReq buildPartial() {
                WeaponUpgradeReq result = new WeaponUpgradeReq(this);
                int i = this.bitField0_;
                if (this.itemParamListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemParamList_ = this.itemParamList_;
                } else {
                    result.itemParamList_ = this.itemParamListBuilder_.build();
                }
                result.targetWeaponGuid_ = this.targetWeaponGuid_;
                if ((this.bitField0_ & 2) != 0) {
                    this.foodWeaponGuidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.foodWeaponGuidList_ = this.foodWeaponGuidList_;
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
                if (other instanceof WeaponUpgradeReq) {
                    return mergeFrom((WeaponUpgradeReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WeaponUpgradeReq other) {
                if (other == WeaponUpgradeReq.getDefaultInstance()) {
                    return this;
                }
                if (this.itemParamListBuilder_ == null) {
                    if (!other.itemParamList_.isEmpty()) {
                        if (this.itemParamList_.isEmpty()) {
                            this.itemParamList_ = other.itemParamList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemParamListIsMutable();
                            this.itemParamList_.addAll(other.itemParamList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemParamList_.isEmpty()) {
                    if (this.itemParamListBuilder_.isEmpty()) {
                        this.itemParamListBuilder_.dispose();
                        this.itemParamListBuilder_ = null;
                        this.itemParamList_ = other.itemParamList_;
                        this.bitField0_ &= -2;
                        this.itemParamListBuilder_ = WeaponUpgradeReq.alwaysUseFieldBuilders ? getItemParamListFieldBuilder() : null;
                    } else {
                        this.itemParamListBuilder_.addAllMessages(other.itemParamList_);
                    }
                }
                if (other.getTargetWeaponGuid() != 0) {
                    setTargetWeaponGuid(other.getTargetWeaponGuid());
                }
                if (!other.foodWeaponGuidList_.isEmpty()) {
                    if (this.foodWeaponGuidList_.isEmpty()) {
                        this.foodWeaponGuidList_ = other.foodWeaponGuidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureFoodWeaponGuidListIsMutable();
                        this.foodWeaponGuidList_.addAll(other.foodWeaponGuidList_);
                    }
                    onChanged();
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
                WeaponUpgradeReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = WeaponUpgradeReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WeaponUpgradeReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureItemParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemParamList_ = new ArrayList(this.itemParamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
                if (this.itemParamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemParamList_);
                }
                return this.itemParamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public int getItemParamListCount() {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.size();
                }
                return this.itemParamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public ItemParamOuterClass.ItemParam getItemParamList(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessage(index);
            }

            public Builder setItemParamList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemParamList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemParamList(ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemParamList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemParamList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemParamList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemParamList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemParamList_);
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemParamList() {
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemParamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemParamList(int index) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.remove(index);
                    onChanged();
                } else {
                    this.itemParamListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemParamListBuilder(int index) {
                return getItemParamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
                if (this.itemParamListBuilder_ != null) {
                    return this.itemParamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemParamList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemParamListBuilder() {
                return getItemParamListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemParamListBuilder(int index) {
                return getItemParamListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemParamListBuilderList() {
                return getItemParamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemParamListFieldBuilder() {
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemParamList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemParamList_ = null;
                }
                return this.itemParamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public long getTargetWeaponGuid() {
                return this.targetWeaponGuid_;
            }

            public Builder setTargetWeaponGuid(long value) {
                this.targetWeaponGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetWeaponGuid() {
                this.targetWeaponGuid_ = 0;
                onChanged();
                return this;
            }

            private void ensureFoodWeaponGuidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.foodWeaponGuidList_ = WeaponUpgradeReq.mutableCopy(this.foodWeaponGuidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public List<Long> getFoodWeaponGuidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.foodWeaponGuidList_) : this.foodWeaponGuidList_;
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public int getFoodWeaponGuidListCount() {
                return this.foodWeaponGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeReqOuterClass.WeaponUpgradeReqOrBuilder
            public long getFoodWeaponGuidList(int index) {
                return this.foodWeaponGuidList_.getLong(index);
            }

            public Builder setFoodWeaponGuidList(int index, long value) {
                ensureFoodWeaponGuidListIsMutable();
                this.foodWeaponGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addFoodWeaponGuidList(long value) {
                ensureFoodWeaponGuidListIsMutable();
                this.foodWeaponGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllFoodWeaponGuidList(Iterable<? extends Long> values) {
                ensureFoodWeaponGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.foodWeaponGuidList_);
                onChanged();
                return this;
            }

            public Builder clearFoodWeaponGuidList() {
                this.foodWeaponGuidList_ = WeaponUpgradeReq.emptyLongList();
                this.bitField0_ &= -3;
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

        public static WeaponUpgradeReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WeaponUpgradeReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WeaponUpgradeReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WeaponUpgradeReq getDefaultInstanceForType() {
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
