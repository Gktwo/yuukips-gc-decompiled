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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelEndNotifyOuterClass.class */
public final class TowerLevelEndNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019TowerLevelEndNotify.proto\u001a\u000fItemParam.proto\"»\u0002\n\u0013TowerLevelEndNotify\u0012\u0016\n\u000econtinue_state\u0018\u0002 \u0001(\r\u0012\u001f\n\u0017finished_star_cond_list\u0018\u0006 \u0003(\r\u0012\u0015\n\rnext_floor_id\u0018\u0004 \u0001(\r\u0012\u0012\n\nis_success\u0018\u000f \u0001(\b\u0012$\n\u0010reward_item_list\u0018\n \u0003(\u000b2\n.ItemParam\"\u0001\n\u0011ContinueStateType\u0012(\n$CONTINUE_STATE_TYPE_CAN_NOT_CONTINUE\u0010��\u0012,\n(CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_LEVEL\u0010\u0001\u0012,\n(CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_FLOOR\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerLevelEndNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerLevelEndNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerLevelEndNotify_descriptor, new String[]{"ContinueState", "FinishedStarCondList", "NextFloorId", "IsSuccess", "RewardItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelEndNotifyOuterClass$TowerLevelEndNotifyOrBuilder.class */
    public interface TowerLevelEndNotifyOrBuilder extends MessageOrBuilder {
        int getContinueState();

        List<Integer> getFinishedStarCondListList();

        int getFinishedStarCondListCount();

        int getFinishedStarCondList(int i);

        int getNextFloorId();

        boolean getIsSuccess();

        List<ItemParamOuterClass.ItemParam> getRewardItemListList();

        ItemParamOuterClass.ItemParam getRewardItemList(int i);

        int getRewardItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getRewardItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getRewardItemListOrBuilder(int i);
    }

    private TowerLevelEndNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelEndNotifyOuterClass$TowerLevelEndNotify.class */
    public static final class TowerLevelEndNotify extends GeneratedMessageV3 implements TowerLevelEndNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CONTINUE_STATE_FIELD_NUMBER = 2;
        private int continueState_;
        public static final int FINISHED_STAR_COND_LIST_FIELD_NUMBER = 6;
        private Internal.IntList finishedStarCondList_;
        private int finishedStarCondListMemoizedSerializedSize;
        public static final int NEXT_FLOOR_ID_FIELD_NUMBER = 4;
        private int nextFloorId_;
        public static final int IS_SUCCESS_FIELD_NUMBER = 15;
        private boolean isSuccess_;
        public static final int REWARD_ITEM_LIST_FIELD_NUMBER = 10;
        private List<ItemParamOuterClass.ItemParam> rewardItemList_;
        private byte memoizedIsInitialized;
        private static final TowerLevelEndNotify DEFAULT_INSTANCE = new TowerLevelEndNotify();
        private static final Parser<TowerLevelEndNotify> PARSER = new AbstractParser<TowerLevelEndNotify>() { // from class: emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.1
            @Override // com.google.protobuf.Parser
            public TowerLevelEndNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerLevelEndNotify(input, extensionRegistry);
            }
        };

        private TowerLevelEndNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishedStarCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TowerLevelEndNotify() {
            this.finishedStarCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.finishedStarCondList_ = emptyIntList();
            this.rewardItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerLevelEndNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0133 */
        private TowerLevelEndNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.continueState_ = input.readUInt32();
                                break;
                            case 32:
                                this.nextFloorId_ = input.readUInt32();
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishedStarCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.finishedStarCondList_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishedStarCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishedStarCondList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.rewardItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.rewardItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 120:
                                this.isSuccess_ = input.readBool();
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
                    this.finishedStarCondList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.rewardItemList_ = Collections.unmodifiableList(this.rewardItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerLevelEndNotifyOuterClass.internal_static_TowerLevelEndNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerLevelEndNotifyOuterClass.internal_static_TowerLevelEndNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelEndNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelEndNotifyOuterClass$TowerLevelEndNotify$ContinueStateType.class */
        public enum ContinueStateType implements ProtocolMessageEnum {
            CONTINUE_STATE_TYPE_CAN_NOT_CONTINUE(0),
            CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_LEVEL(1),
            CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_FLOOR(2),
            UNRECOGNIZED(-1);
            
            public static final int CONTINUE_STATE_TYPE_CAN_NOT_CONTINUE_VALUE = 0;
            public static final int CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_LEVEL_VALUE = 1;
            public static final int CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_FLOOR_VALUE = 2;
            private static final Internal.EnumLiteMap<ContinueStateType> internalValueMap = new Internal.EnumLiteMap<ContinueStateType>() { // from class: emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotify.ContinueStateType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ContinueStateType findValueByNumber(int number) {
                    return ContinueStateType.forNumber(number);
                }
            };
            private static final ContinueStateType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ContinueStateType valueOf(int value) {
                return forNumber(value);
            }

            public static ContinueStateType forNumber(int value) {
                switch (value) {
                    case 0:
                        return CONTINUE_STATE_TYPE_CAN_NOT_CONTINUE;
                    case 1:
                        return CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_LEVEL;
                    case 2:
                        return CONTINUE_STATE_TYPE_CAN_ENTER_NEXT_FLOOR;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<ContinueStateType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return TowerLevelEndNotify.getDescriptor().getEnumTypes().get(0);
            }

            public static ContinueStateType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            ContinueStateType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public int getContinueState() {
            return this.continueState_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public List<Integer> getFinishedStarCondListList() {
            return this.finishedStarCondList_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public int getFinishedStarCondListCount() {
            return this.finishedStarCondList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public int getFinishedStarCondList(int index) {
            return this.finishedStarCondList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public int getNextFloorId() {
            return this.nextFloorId_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public List<ItemParamOuterClass.ItemParam> getRewardItemListList() {
            return this.rewardItemList_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getRewardItemListOrBuilderList() {
            return this.rewardItemList_;
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public int getRewardItemListCount() {
            return this.rewardItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public ItemParamOuterClass.ItemParam getRewardItemList(int index) {
            return this.rewardItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getRewardItemListOrBuilder(int index) {
            return this.rewardItemList_.get(index);
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
            if (this.continueState_ != 0) {
                output.writeUInt32(2, this.continueState_);
            }
            if (this.nextFloorId_ != 0) {
                output.writeUInt32(4, this.nextFloorId_);
            }
            if (getFinishedStarCondListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.finishedStarCondListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishedStarCondList_.size(); i++) {
                output.writeUInt32NoTag(this.finishedStarCondList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.rewardItemList_.size(); i2++) {
                output.writeMessage(10, this.rewardItemList_.get(i2));
            }
            if (this.isSuccess_) {
                output.writeBool(15, this.isSuccess_);
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
            if (this.continueState_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.continueState_);
            }
            if (this.nextFloorId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.nextFloorId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.finishedStarCondList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishedStarCondList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFinishedStarCondListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishedStarCondListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.rewardItemList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(10, this.rewardItemList_.get(i2));
            }
            if (this.isSuccess_) {
                size3 += CodedOutputStream.computeBoolSize(15, this.isSuccess_);
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
            if (!(obj instanceof TowerLevelEndNotify)) {
                return equals(obj);
            }
            TowerLevelEndNotify other = (TowerLevelEndNotify) obj;
            return getContinueState() == other.getContinueState() && getFinishedStarCondListList().equals(other.getFinishedStarCondListList()) && getNextFloorId() == other.getNextFloorId() && getIsSuccess() == other.getIsSuccess() && getRewardItemListList().equals(other.getRewardItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getContinueState();
            if (getFinishedStarCondListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getFinishedStarCondListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 4)) + getNextFloorId())) + 15)) + Internal.hashBoolean(getIsSuccess());
            if (getRewardItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getRewardItemListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static TowerLevelEndNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelEndNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelEndNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelEndNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelEndNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerLevelEndNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerLevelEndNotify parseFrom(InputStream input) throws IOException {
            return (TowerLevelEndNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelEndNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelEndNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelEndNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerLevelEndNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerLevelEndNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelEndNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerLevelEndNotify parseFrom(CodedInputStream input) throws IOException {
            return (TowerLevelEndNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerLevelEndNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerLevelEndNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerLevelEndNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerLevelEndNotifyOuterClass$TowerLevelEndNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerLevelEndNotifyOrBuilder {
            private int bitField0_;
            private int continueState_;
            private int nextFloorId_;
            private boolean isSuccess_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> rewardItemListBuilder_;
            private Internal.IntList finishedStarCondList_ = TowerLevelEndNotify.emptyIntList();
            private List<ItemParamOuterClass.ItemParam> rewardItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerLevelEndNotifyOuterClass.internal_static_TowerLevelEndNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerLevelEndNotifyOuterClass.internal_static_TowerLevelEndNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerLevelEndNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerLevelEndNotify.alwaysUseFieldBuilders) {
                    getRewardItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.continueState_ = 0;
                this.finishedStarCondList_ = TowerLevelEndNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.nextFloorId_ = 0;
                this.isSuccess_ = false;
                if (this.rewardItemListBuilder_ == null) {
                    this.rewardItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.rewardItemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerLevelEndNotifyOuterClass.internal_static_TowerLevelEndNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerLevelEndNotify getDefaultInstanceForType() {
                return TowerLevelEndNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelEndNotify build() {
                TowerLevelEndNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerLevelEndNotify buildPartial() {
                TowerLevelEndNotify result = new TowerLevelEndNotify(this);
                int i = this.bitField0_;
                result.continueState_ = this.continueState_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishedStarCondList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishedStarCondList_ = this.finishedStarCondList_;
                result.nextFloorId_ = this.nextFloorId_;
                result.isSuccess_ = this.isSuccess_;
                if (this.rewardItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.rewardItemList_ = Collections.unmodifiableList(this.rewardItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.rewardItemList_ = this.rewardItemList_;
                } else {
                    result.rewardItemList_ = this.rewardItemListBuilder_.build();
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
                if (other instanceof TowerLevelEndNotify) {
                    return mergeFrom((TowerLevelEndNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerLevelEndNotify other) {
                if (other == TowerLevelEndNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getContinueState() != 0) {
                    setContinueState(other.getContinueState());
                }
                if (!other.finishedStarCondList_.isEmpty()) {
                    if (this.finishedStarCondList_.isEmpty()) {
                        this.finishedStarCondList_ = other.finishedStarCondList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishedStarCondListIsMutable();
                        this.finishedStarCondList_.addAll(other.finishedStarCondList_);
                    }
                    onChanged();
                }
                if (other.getNextFloorId() != 0) {
                    setNextFloorId(other.getNextFloorId());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
                }
                if (this.rewardItemListBuilder_ == null) {
                    if (!other.rewardItemList_.isEmpty()) {
                        if (this.rewardItemList_.isEmpty()) {
                            this.rewardItemList_ = other.rewardItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureRewardItemListIsMutable();
                            this.rewardItemList_.addAll(other.rewardItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.rewardItemList_.isEmpty()) {
                    if (this.rewardItemListBuilder_.isEmpty()) {
                        this.rewardItemListBuilder_.dispose();
                        this.rewardItemListBuilder_ = null;
                        this.rewardItemList_ = other.rewardItemList_;
                        this.bitField0_ &= -3;
                        this.rewardItemListBuilder_ = TowerLevelEndNotify.alwaysUseFieldBuilders ? getRewardItemListFieldBuilder() : null;
                    } else {
                        this.rewardItemListBuilder_.addAllMessages(other.rewardItemList_);
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
                TowerLevelEndNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerLevelEndNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerLevelEndNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public int getContinueState() {
                return this.continueState_;
            }

            public Builder setContinueState(int value) {
                this.continueState_ = value;
                onChanged();
                return this;
            }

            public Builder clearContinueState() {
                this.continueState_ = 0;
                onChanged();
                return this;
            }

            private void ensureFinishedStarCondListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishedStarCondList_ = TowerLevelEndNotify.mutableCopy(this.finishedStarCondList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public List<Integer> getFinishedStarCondListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishedStarCondList_) : this.finishedStarCondList_;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public int getFinishedStarCondListCount() {
                return this.finishedStarCondList_.size();
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public int getFinishedStarCondList(int index) {
                return this.finishedStarCondList_.getInt(index);
            }

            public Builder setFinishedStarCondList(int index, int value) {
                ensureFinishedStarCondListIsMutable();
                this.finishedStarCondList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishedStarCondList(int value) {
                ensureFinishedStarCondListIsMutable();
                this.finishedStarCondList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishedStarCondList(Iterable<? extends Integer> values) {
                ensureFinishedStarCondListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishedStarCondList_);
                onChanged();
                return this;
            }

            public Builder clearFinishedStarCondList() {
                this.finishedStarCondList_ = TowerLevelEndNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public int getNextFloorId() {
                return this.nextFloorId_;
            }

            public Builder setNextFloorId(int value) {
                this.nextFloorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextFloorId() {
                this.nextFloorId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            public Builder setIsSuccess(boolean value) {
                this.isSuccess_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            private void ensureRewardItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.rewardItemList_ = new ArrayList(this.rewardItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public List<ItemParamOuterClass.ItemParam> getRewardItemListList() {
                if (this.rewardItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.rewardItemList_);
                }
                return this.rewardItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public int getRewardItemListCount() {
                if (this.rewardItemListBuilder_ == null) {
                    return this.rewardItemList_.size();
                }
                return this.rewardItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public ItemParamOuterClass.ItemParam getRewardItemList(int index) {
                if (this.rewardItemListBuilder_ == null) {
                    return this.rewardItemList_.get(index);
                }
                return this.rewardItemListBuilder_.getMessage(index);
            }

            public Builder setRewardItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.rewardItemListBuilder_ != null) {
                    this.rewardItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRewardItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.rewardItemListBuilder_ == null) {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRewardItemList(ItemParamOuterClass.ItemParam value) {
                if (this.rewardItemListBuilder_ != null) {
                    this.rewardItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRewardItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.rewardItemListBuilder_ != null) {
                    this.rewardItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRewardItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.rewardItemListBuilder_ == null) {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.rewardItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRewardItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.rewardItemListBuilder_ == null) {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.rewardItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRewardItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.rewardItemListBuilder_ == null) {
                    ensureRewardItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.rewardItemList_);
                    onChanged();
                } else {
                    this.rewardItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRewardItemList() {
                if (this.rewardItemListBuilder_ == null) {
                    this.rewardItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.rewardItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRewardItemList(int index) {
                if (this.rewardItemListBuilder_ == null) {
                    ensureRewardItemListIsMutable();
                    this.rewardItemList_.remove(index);
                    onChanged();
                } else {
                    this.rewardItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getRewardItemListBuilder(int index) {
                return getRewardItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getRewardItemListOrBuilder(int index) {
                if (this.rewardItemListBuilder_ == null) {
                    return this.rewardItemList_.get(index);
                }
                return this.rewardItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerLevelEndNotifyOuterClass.TowerLevelEndNotifyOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getRewardItemListOrBuilderList() {
                if (this.rewardItemListBuilder_ != null) {
                    return this.rewardItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.rewardItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addRewardItemListBuilder() {
                return getRewardItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addRewardItemListBuilder(int index) {
                return getRewardItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getRewardItemListBuilderList() {
                return getRewardItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getRewardItemListFieldBuilder() {
                if (this.rewardItemListBuilder_ == null) {
                    this.rewardItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.rewardItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.rewardItemList_ = null;
                }
                return this.rewardItemListBuilder_;
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

        public static TowerLevelEndNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerLevelEndNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerLevelEndNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerLevelEndNotify getDefaultInstanceForType() {
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
