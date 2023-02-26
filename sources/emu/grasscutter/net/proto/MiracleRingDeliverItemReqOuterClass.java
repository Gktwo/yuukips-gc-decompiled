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
import emu.grasscutter.net.proto.InterOpTypeOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MiracleRingDeliverItemReqOuterClass.class */
public final class MiracleRingDeliverItemReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fMiracleRingDeliverItemReq.proto\u001a\u0011InterOpType.proto\u001a\u000fItemParam.proto\"¢\u0001\n\u0019MiracleRingDeliverItemReq\u0012\u001a\n\u0012foodWeaponGuidList\u0018\u0003 \u0003(\u0004\u0012\u001c\n\u0006opType\u0018\u0002 \u0001(\u000e2\f.InterOpType\u0012\u0010\n\bgadgetId\u0018\u000e \u0001(\r\u0012!\n\ritemParamList\u0018\u0005 \u0003(\u000b2\n.ItemParam\u0012\u0016\n\u000egadgetEntityId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InterOpTypeOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MiracleRingDeliverItemReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MiracleRingDeliverItemReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MiracleRingDeliverItemReq_descriptor, new String[]{"FoodWeaponGuidList", "OpType", "GadgetId", "ItemParamList", "GadgetEntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MiracleRingDeliverItemReqOuterClass$MiracleRingDeliverItemReqOrBuilder.class */
    public interface MiracleRingDeliverItemReqOrBuilder extends MessageOrBuilder {
        List<Long> getFoodWeaponGuidListList();

        int getFoodWeaponGuidListCount();

        long getFoodWeaponGuidList(int i);

        int getOpTypeValue();

        InterOpTypeOuterClass.InterOpType getOpType();

        int getGadgetId();

        List<ItemParamOuterClass.ItemParam> getItemParamListList();

        ItemParamOuterClass.ItemParam getItemParamList(int i);

        int getItemParamListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int i);

        int getGadgetEntityId();
    }

    private MiracleRingDeliverItemReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MiracleRingDeliverItemReqOuterClass$MiracleRingDeliverItemReq.class */
    public static final class MiracleRingDeliverItemReq extends GeneratedMessageV3 implements MiracleRingDeliverItemReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FOODWEAPONGUIDLIST_FIELD_NUMBER = 3;
        private Internal.LongList foodWeaponGuidList_;
        private int foodWeaponGuidListMemoizedSerializedSize;
        public static final int OPTYPE_FIELD_NUMBER = 2;
        private int opType_;
        public static final int GADGETID_FIELD_NUMBER = 14;
        private int gadgetId_;
        public static final int ITEMPARAMLIST_FIELD_NUMBER = 5;
        private List<ItemParamOuterClass.ItemParam> itemParamList_;
        public static final int GADGETENTITYID_FIELD_NUMBER = 6;
        private int gadgetEntityId_;
        private byte memoizedIsInitialized;
        private static final MiracleRingDeliverItemReq DEFAULT_INSTANCE = new MiracleRingDeliverItemReq();
        private static final Parser<MiracleRingDeliverItemReq> PARSER = new AbstractParser<MiracleRingDeliverItemReq>() { // from class: emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReq.1
            @Override // com.google.protobuf.Parser
            public MiracleRingDeliverItemReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MiracleRingDeliverItemReq(input, extensionRegistry);
            }
        };

        private MiracleRingDeliverItemReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.foodWeaponGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MiracleRingDeliverItemReq() {
            this.foodWeaponGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.foodWeaponGuidList_ = emptyLongList();
            this.opType_ = 0;
            this.itemParamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MiracleRingDeliverItemReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0137 */
        private MiracleRingDeliverItemReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.opType_ = input.readEnum();
                                    break;
                                case 24:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.foodWeaponGuidList_ = newLongList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.foodWeaponGuidList_.addLong(input.readUInt64());
                                    break;
                                case 26:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.foodWeaponGuidList_ = newLongList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.foodWeaponGuidList_.addLong(input.readUInt64());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 42:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.itemParamList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.itemParamList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 48:
                                    this.gadgetEntityId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.gadgetId_ = input.readUInt32();
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.foodWeaponGuidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MiracleRingDeliverItemReqOuterClass.internal_static_MiracleRingDeliverItemReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MiracleRingDeliverItemReqOuterClass.internal_static_MiracleRingDeliverItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MiracleRingDeliverItemReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public List<Long> getFoodWeaponGuidListList() {
            return this.foodWeaponGuidList_;
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public int getFoodWeaponGuidListCount() {
            return this.foodWeaponGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public long getFoodWeaponGuidList(int index) {
            return this.foodWeaponGuidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public int getOpTypeValue() {
            return this.opType_;
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public InterOpTypeOuterClass.InterOpType getOpType() {
            InterOpTypeOuterClass.InterOpType result = InterOpTypeOuterClass.InterOpType.valueOf(this.opType_);
            return result == null ? InterOpTypeOuterClass.InterOpType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public int getItemParamListCount() {
            return this.itemParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public ItemParamOuterClass.ItemParam getItemParamList(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
        public int getGadgetEntityId() {
            return this.gadgetEntityId_;
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
            if (this.opType_ != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH.getNumber()) {
                output.writeEnum(2, this.opType_);
            }
            if (getFoodWeaponGuidListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.foodWeaponGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.foodWeaponGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.foodWeaponGuidList_.getLong(i));
            }
            for (int i2 = 0; i2 < this.itemParamList_.size(); i2++) {
                output.writeMessage(5, this.itemParamList_.get(i2));
            }
            if (this.gadgetEntityId_ != 0) {
                output.writeUInt32(6, this.gadgetEntityId_);
            }
            if (this.gadgetId_ != 0) {
                output.writeUInt32(14, this.gadgetId_);
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
            if (this.opType_ != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(2, this.opType_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.foodWeaponGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.foodWeaponGuidList_.getLong(i));
            }
            int size3 = size2 + dataSize;
            if (!getFoodWeaponGuidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.foodWeaponGuidListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.itemParamList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(5, this.itemParamList_.get(i2));
            }
            if (this.gadgetEntityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.gadgetEntityId_);
            }
            if (this.gadgetId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.gadgetId_);
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
            if (!(obj instanceof MiracleRingDeliverItemReq)) {
                return equals(obj);
            }
            MiracleRingDeliverItemReq other = (MiracleRingDeliverItemReq) obj;
            return getFoodWeaponGuidListList().equals(other.getFoodWeaponGuidListList()) && this.opType_ == other.opType_ && getGadgetId() == other.getGadgetId() && getItemParamListList().equals(other.getItemParamListList()) && getGadgetEntityId() == other.getGadgetEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFoodWeaponGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getFoodWeaponGuidListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 2)) + this.opType_)) + 14)) + getGadgetId();
            if (getItemParamListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getItemParamListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 6)) + getGadgetEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static MiracleRingDeliverItemReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MiracleRingDeliverItemReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MiracleRingDeliverItemReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MiracleRingDeliverItemReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MiracleRingDeliverItemReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MiracleRingDeliverItemReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MiracleRingDeliverItemReq parseFrom(InputStream input) throws IOException {
            return (MiracleRingDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MiracleRingDeliverItemReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MiracleRingDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MiracleRingDeliverItemReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MiracleRingDeliverItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MiracleRingDeliverItemReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MiracleRingDeliverItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MiracleRingDeliverItemReq parseFrom(CodedInputStream input) throws IOException {
            return (MiracleRingDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MiracleRingDeliverItemReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MiracleRingDeliverItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MiracleRingDeliverItemReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MiracleRingDeliverItemReqOuterClass$MiracleRingDeliverItemReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MiracleRingDeliverItemReqOrBuilder {
            private int bitField0_;
            private int gadgetId_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemParamListBuilder_;
            private int gadgetEntityId_;
            private Internal.LongList foodWeaponGuidList_ = MiracleRingDeliverItemReq.emptyLongList();
            private int opType_ = 0;
            private List<ItemParamOuterClass.ItemParam> itemParamList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return MiracleRingDeliverItemReqOuterClass.internal_static_MiracleRingDeliverItemReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MiracleRingDeliverItemReqOuterClass.internal_static_MiracleRingDeliverItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MiracleRingDeliverItemReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MiracleRingDeliverItemReq.alwaysUseFieldBuilders) {
                    getItemParamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.foodWeaponGuidList_ = MiracleRingDeliverItemReq.emptyLongList();
                this.bitField0_ &= -2;
                this.opType_ = 0;
                this.gadgetId_ = 0;
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.itemParamListBuilder_.clear();
                }
                this.gadgetEntityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MiracleRingDeliverItemReqOuterClass.internal_static_MiracleRingDeliverItemReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MiracleRingDeliverItemReq getDefaultInstanceForType() {
                return MiracleRingDeliverItemReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MiracleRingDeliverItemReq build() {
                MiracleRingDeliverItemReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MiracleRingDeliverItemReq buildPartial() {
                MiracleRingDeliverItemReq result = new MiracleRingDeliverItemReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.foodWeaponGuidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.foodWeaponGuidList_ = this.foodWeaponGuidList_;
                result.opType_ = this.opType_;
                result.gadgetId_ = this.gadgetId_;
                if (this.itemParamListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                        this.bitField0_ &= -3;
                    }
                    result.itemParamList_ = this.itemParamList_;
                } else {
                    result.itemParamList_ = this.itemParamListBuilder_.build();
                }
                result.gadgetEntityId_ = this.gadgetEntityId_;
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
                if (other instanceof MiracleRingDeliverItemReq) {
                    return mergeFrom((MiracleRingDeliverItemReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MiracleRingDeliverItemReq other) {
                if (other == MiracleRingDeliverItemReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.foodWeaponGuidList_.isEmpty()) {
                    if (this.foodWeaponGuidList_.isEmpty()) {
                        this.foodWeaponGuidList_ = other.foodWeaponGuidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFoodWeaponGuidListIsMutable();
                        this.foodWeaponGuidList_.addAll(other.foodWeaponGuidList_);
                    }
                    onChanged();
                }
                if (other.opType_ != 0) {
                    setOpTypeValue(other.getOpTypeValue());
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (this.itemParamListBuilder_ == null) {
                    if (!other.itemParamList_.isEmpty()) {
                        if (this.itemParamList_.isEmpty()) {
                            this.itemParamList_ = other.itemParamList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.itemParamListBuilder_ = MiracleRingDeliverItemReq.alwaysUseFieldBuilders ? getItemParamListFieldBuilder() : null;
                    } else {
                        this.itemParamListBuilder_.addAllMessages(other.itemParamList_);
                    }
                }
                if (other.getGadgetEntityId() != 0) {
                    setGadgetEntityId(other.getGadgetEntityId());
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
                MiracleRingDeliverItemReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MiracleRingDeliverItemReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MiracleRingDeliverItemReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFoodWeaponGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.foodWeaponGuidList_ = MiracleRingDeliverItemReq.mutableCopy(this.foodWeaponGuidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public List<Long> getFoodWeaponGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.foodWeaponGuidList_) : this.foodWeaponGuidList_;
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public int getFoodWeaponGuidListCount() {
                return this.foodWeaponGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
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
                this.foodWeaponGuidList_ = MiracleRingDeliverItemReq.emptyLongList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public int getOpTypeValue() {
                return this.opType_;
            }

            public Builder setOpTypeValue(int value) {
                this.opType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public InterOpTypeOuterClass.InterOpType getOpType() {
                InterOpTypeOuterClass.InterOpType result = InterOpTypeOuterClass.InterOpType.valueOf(this.opType_);
                return result == null ? InterOpTypeOuterClass.InterOpType.UNRECOGNIZED : result;
            }

            public Builder setOpType(InterOpTypeOuterClass.InterOpType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.opType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearOpType() {
                this.opType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemParamListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.itemParamList_ = new ArrayList(this.itemParamList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
                if (this.itemParamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemParamList_);
                }
                return this.itemParamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public int getItemParamListCount() {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.size();
                }
                return this.itemParamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
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
                    this.itemParamListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemParamList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.itemParamList_ = null;
                }
                return this.itemParamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MiracleRingDeliverItemReqOuterClass.MiracleRingDeliverItemReqOrBuilder
            public int getGadgetEntityId() {
                return this.gadgetEntityId_;
            }

            public Builder setGadgetEntityId(int value) {
                this.gadgetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetEntityId() {
                this.gadgetEntityId_ = 0;
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

        public static MiracleRingDeliverItemReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MiracleRingDeliverItemReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MiracleRingDeliverItemReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MiracleRingDeliverItemReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InterOpTypeOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
