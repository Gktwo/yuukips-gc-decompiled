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
import emu.grasscutter.net.proto.CompoundBoostTakeStatusTypeOuterClass;
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass.class */
public final class PlayerCompoundMaterialBoostRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$PlayerCompoundMaterialBoostRsp.proto\u001a!CompoundBoostTakeStatusType.proto\u001a\u0017CompoundQueueData.proto\u001a\u000fItemParam.proto\"¾\u0001\n\u001ePlayerCompoundMaterialBoostRsp\u00124\n\u0018compound_queue_data_list\u0018\n \u0003(\u000b2\u0012.CompoundQueueData\u00121\n\u000btake_status\u0018\u0004 \u0001(\u000e2\u001c.CompoundBoostTakeStatusType\u0012\"\n\u000etake_item_list\u0018\u0003 \u0003(\u000b2\n.ItemParam\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CompoundBoostTakeStatusTypeOuterClass.getDescriptor(), CompoundQueueDataOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerCompoundMaterialBoostRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_PlayerCompoundMaterialBoostRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f829xe20044fe = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCompoundMaterialBoostRsp_descriptor, new String[]{"CompoundQueueDataList", "TakeStatus", "TakeItemList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass$PlayerCompoundMaterialBoostRspOrBuilder.class */
    public interface PlayerCompoundMaterialBoostRspOrBuilder extends MessageOrBuilder {
        List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList();

        CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int i);

        int getCompoundQueueDataListCount();

        List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList();

        CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int i);

        int getTakeStatusValue();

        CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType getTakeStatus();

        List<ItemParamOuterClass.ItemParam> getTakeItemListList();

        ItemParamOuterClass.ItemParam getTakeItemList(int i);

        int getTakeItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTakeItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getTakeItemListOrBuilder(int i);

        int getRetcode();
    }

    private PlayerCompoundMaterialBoostRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass$PlayerCompoundMaterialBoostRsp.class */
    public static final class PlayerCompoundMaterialBoostRsp extends GeneratedMessageV3 implements PlayerCompoundMaterialBoostRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMPOUND_QUEUE_DATA_LIST_FIELD_NUMBER = 10;
        private List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueDataList_;
        public static final int TAKE_STATUS_FIELD_NUMBER = 4;
        private int takeStatus_;
        public static final int TAKE_ITEM_LIST_FIELD_NUMBER = 3;
        private List<ItemParamOuterClass.ItemParam> takeItemList_;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final PlayerCompoundMaterialBoostRsp DEFAULT_INSTANCE = new PlayerCompoundMaterialBoostRsp();
        private static final Parser<PlayerCompoundMaterialBoostRsp> PARSER = new AbstractParser<PlayerCompoundMaterialBoostRsp>() { // from class: emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRsp.1
            @Override // com.google.protobuf.Parser
            public PlayerCompoundMaterialBoostRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCompoundMaterialBoostRsp(input, extensionRegistry);
            }
        };

        private PlayerCompoundMaterialBoostRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCompoundMaterialBoostRsp() {
            this.memoizedIsInitialized = -1;
            this.compoundQueueDataList_ = Collections.emptyList();
            this.takeStatus_ = 0;
            this.takeItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCompoundMaterialBoostRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x00e2 */
        private PlayerCompoundMaterialBoostRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.takeItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.takeItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 32:
                                    this.takeStatus_ = input.readEnum();
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.compoundQueueDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.compoundQueueDataList_.add((CompoundQueueDataOuterClass.CompoundQueueData) input.readMessage(CompoundQueueDataOuterClass.CompoundQueueData.parser(), extensionRegistry));
                                    break;
                                case 104:
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
                            done = done;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.takeItemList_ = Collections.unmodifiableList(this.takeItemList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.compoundQueueDataList_ = Collections.unmodifiableList(this.compoundQueueDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerCompoundMaterialBoostRspOuterClass.internal_static_PlayerCompoundMaterialBoostRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCompoundMaterialBoostRspOuterClass.f829xe20044fe.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList() {
            return this.compoundQueueDataList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList() {
            return this.compoundQueueDataList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public int getCompoundQueueDataListCount() {
            return this.compoundQueueDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int index) {
            return this.compoundQueueDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int index) {
            return this.compoundQueueDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public int getTakeStatusValue() {
            return this.takeStatus_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType getTakeStatus() {
            CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType result = CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.valueOf(this.takeStatus_);
            return result == null ? CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getTakeItemListList() {
            return this.takeItemList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTakeItemListOrBuilderList() {
            return this.takeItemList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public int getTakeItemListCount() {
            return this.takeItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public ItemParamOuterClass.ItemParam getTakeItemList(int index) {
            return this.takeItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getTakeItemListOrBuilder(int index) {
            return this.takeItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
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
            for (int i = 0; i < this.takeItemList_.size(); i++) {
                output.writeMessage(3, this.takeItemList_.get(i));
            }
            if (this.takeStatus_ != CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE.getNumber()) {
                output.writeEnum(4, this.takeStatus_);
            }
            for (int i2 = 0; i2 < this.compoundQueueDataList_.size(); i2++) {
                output.writeMessage(10, this.compoundQueueDataList_.get(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
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
            for (int i = 0; i < this.takeItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.takeItemList_.get(i));
            }
            if (this.takeStatus_ != CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.takeStatus_);
            }
            for (int i2 = 0; i2 < this.compoundQueueDataList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.compoundQueueDataList_.get(i2));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.retcode_);
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
            if (!(obj instanceof PlayerCompoundMaterialBoostRsp)) {
                return equals(obj);
            }
            PlayerCompoundMaterialBoostRsp other = (PlayerCompoundMaterialBoostRsp) obj;
            return getCompoundQueueDataListList().equals(other.getCompoundQueueDataListList()) && this.takeStatus_ == other.takeStatus_ && getTakeItemListList().equals(other.getTakeItemListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCompoundQueueDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getCompoundQueueDataListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + this.takeStatus_;
            if (getTakeItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getTakeItemListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 13)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCompoundMaterialBoostRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostRspOuterClass$PlayerCompoundMaterialBoostRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCompoundMaterialBoostRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> compoundQueueDataListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> takeItemListBuilder_;
            private int retcode_;
            private List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueDataList_ = Collections.emptyList();
            private int takeStatus_ = 0;
            private List<ItemParamOuterClass.ItemParam> takeItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCompoundMaterialBoostRspOuterClass.internal_static_PlayerCompoundMaterialBoostRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCompoundMaterialBoostRspOuterClass.f829xe20044fe.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCompoundMaterialBoostRsp.alwaysUseFieldBuilders) {
                    getCompoundQueueDataListFieldBuilder();
                    getTakeItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.compoundQueueDataListBuilder_ == null) {
                    this.compoundQueueDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.compoundQueueDataListBuilder_.clear();
                }
                this.takeStatus_ = 0;
                if (this.takeItemListBuilder_ == null) {
                    this.takeItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.takeItemListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCompoundMaterialBoostRspOuterClass.internal_static_PlayerCompoundMaterialBoostRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCompoundMaterialBoostRsp getDefaultInstanceForType() {
                return PlayerCompoundMaterialBoostRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostRsp build() {
                PlayerCompoundMaterialBoostRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostRsp buildPartial() {
                PlayerCompoundMaterialBoostRsp result = new PlayerCompoundMaterialBoostRsp(this);
                int i = this.bitField0_;
                if (this.compoundQueueDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.compoundQueueDataList_ = Collections.unmodifiableList(this.compoundQueueDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.compoundQueueDataList_ = this.compoundQueueDataList_;
                } else {
                    result.compoundQueueDataList_ = this.compoundQueueDataListBuilder_.build();
                }
                result.takeStatus_ = this.takeStatus_;
                if (this.takeItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.takeItemList_ = Collections.unmodifiableList(this.takeItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.takeItemList_ = this.takeItemList_;
                } else {
                    result.takeItemList_ = this.takeItemListBuilder_.build();
                }
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
                if (other instanceof PlayerCompoundMaterialBoostRsp) {
                    return mergeFrom((PlayerCompoundMaterialBoostRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCompoundMaterialBoostRsp other) {
                if (other == PlayerCompoundMaterialBoostRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.compoundQueueDataListBuilder_ == null) {
                    if (!other.compoundQueueDataList_.isEmpty()) {
                        if (this.compoundQueueDataList_.isEmpty()) {
                            this.compoundQueueDataList_ = other.compoundQueueDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCompoundQueueDataListIsMutable();
                            this.compoundQueueDataList_.addAll(other.compoundQueueDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.compoundQueueDataList_.isEmpty()) {
                    if (this.compoundQueueDataListBuilder_.isEmpty()) {
                        this.compoundQueueDataListBuilder_.dispose();
                        this.compoundQueueDataListBuilder_ = null;
                        this.compoundQueueDataList_ = other.compoundQueueDataList_;
                        this.bitField0_ &= -2;
                        this.compoundQueueDataListBuilder_ = PlayerCompoundMaterialBoostRsp.alwaysUseFieldBuilders ? getCompoundQueueDataListFieldBuilder() : null;
                    } else {
                        this.compoundQueueDataListBuilder_.addAllMessages(other.compoundQueueDataList_);
                    }
                }
                if (other.takeStatus_ != 0) {
                    setTakeStatusValue(other.getTakeStatusValue());
                }
                if (this.takeItemListBuilder_ == null) {
                    if (!other.takeItemList_.isEmpty()) {
                        if (this.takeItemList_.isEmpty()) {
                            this.takeItemList_ = other.takeItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureTakeItemListIsMutable();
                            this.takeItemList_.addAll(other.takeItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.takeItemList_.isEmpty()) {
                    if (this.takeItemListBuilder_.isEmpty()) {
                        this.takeItemListBuilder_.dispose();
                        this.takeItemListBuilder_ = null;
                        this.takeItemList_ = other.takeItemList_;
                        this.bitField0_ &= -3;
                        this.takeItemListBuilder_ = PlayerCompoundMaterialBoostRsp.alwaysUseFieldBuilders ? getTakeItemListFieldBuilder() : null;
                    } else {
                        this.takeItemListBuilder_.addAllMessages(other.takeItemList_);
                    }
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
                PlayerCompoundMaterialBoostRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCompoundMaterialBoostRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCompoundMaterialBoostRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCompoundQueueDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.compoundQueueDataList_ = new ArrayList(this.compoundQueueDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.compoundQueueDataList_);
                }
                return this.compoundQueueDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public int getCompoundQueueDataListCount() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.size();
                }
                return this.compoundQueueDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.get(index);
                }
                return this.compoundQueueDataListBuilder_.getMessage(index);
            }

            public Builder setCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataListBuilder_ != null) {
                    this.compoundQueueDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCompoundQueueDataList(CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataListBuilder_ != null) {
                    this.compoundQueueDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData value) {
                if (this.compoundQueueDataListBuilder_ != null) {
                    this.compoundQueueDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCompoundQueueDataList(CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCompoundQueueDataList(int index, CompoundQueueDataOuterClass.CompoundQueueData.Builder builderForValue) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCompoundQueueDataList(Iterable<? extends CompoundQueueDataOuterClass.CompoundQueueData> values) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.compoundQueueDataList_);
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCompoundQueueDataList() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    this.compoundQueueDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCompoundQueueDataList(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    ensureCompoundQueueDataListIsMutable();
                    this.compoundQueueDataList_.remove(index);
                    onChanged();
                } else {
                    this.compoundQueueDataListBuilder_.remove(index);
                }
                return this;
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder getCompoundQueueDataListBuilder(int index) {
                return getCompoundQueueDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.get(index);
                }
                return this.compoundQueueDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList() {
                if (this.compoundQueueDataListBuilder_ != null) {
                    return this.compoundQueueDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.compoundQueueDataList_);
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder addCompoundQueueDataListBuilder() {
                return getCompoundQueueDataListFieldBuilder().addBuilder(CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance());
            }

            public CompoundQueueDataOuterClass.CompoundQueueData.Builder addCompoundQueueDataListBuilder(int index) {
                return getCompoundQueueDataListFieldBuilder().addBuilder(index, CompoundQueueDataOuterClass.CompoundQueueData.getDefaultInstance());
            }

            public List<CompoundQueueDataOuterClass.CompoundQueueData.Builder> getCompoundQueueDataListBuilderList() {
                return getCompoundQueueDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListFieldBuilder() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    this.compoundQueueDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.compoundQueueDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.compoundQueueDataList_ = null;
                }
                return this.compoundQueueDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public int getTakeStatusValue() {
                return this.takeStatus_;
            }

            public Builder setTakeStatusValue(int value) {
                this.takeStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType getTakeStatus() {
                CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType result = CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.valueOf(this.takeStatus_);
                return result == null ? CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.UNRECOGNIZED : result;
            }

            public Builder setTakeStatus(CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.takeStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearTakeStatus() {
                this.takeStatus_ = 0;
                onChanged();
                return this;
            }

            private void ensureTakeItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.takeItemList_ = new ArrayList(this.takeItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getTakeItemListList() {
                if (this.takeItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.takeItemList_);
                }
                return this.takeItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public int getTakeItemListCount() {
                if (this.takeItemListBuilder_ == null) {
                    return this.takeItemList_.size();
                }
                return this.takeItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public ItemParamOuterClass.ItemParam getTakeItemList(int index) {
                if (this.takeItemListBuilder_ == null) {
                    return this.takeItemList_.get(index);
                }
                return this.takeItemListBuilder_.getMessage(index);
            }

            public Builder setTakeItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.takeItemListBuilder_ != null) {
                    this.takeItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTakeItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.takeItemListBuilder_ == null) {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.takeItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTakeItemList(ItemParamOuterClass.ItemParam value) {
                if (this.takeItemListBuilder_ != null) {
                    this.takeItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTakeItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.takeItemListBuilder_ != null) {
                    this.takeItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTakeItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.takeItemListBuilder_ == null) {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.takeItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTakeItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.takeItemListBuilder_ == null) {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.takeItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTakeItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.takeItemListBuilder_ == null) {
                    ensureTakeItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takeItemList_);
                    onChanged();
                } else {
                    this.takeItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTakeItemList() {
                if (this.takeItemListBuilder_ == null) {
                    this.takeItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.takeItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTakeItemList(int index) {
                if (this.takeItemListBuilder_ == null) {
                    ensureTakeItemListIsMutable();
                    this.takeItemList_.remove(index);
                    onChanged();
                } else {
                    this.takeItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getTakeItemListBuilder(int index) {
                return getTakeItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getTakeItemListOrBuilder(int index) {
                if (this.takeItemListBuilder_ == null) {
                    return this.takeItemList_.get(index);
                }
                return this.takeItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTakeItemListOrBuilderList() {
                if (this.takeItemListBuilder_ != null) {
                    return this.takeItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.takeItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addTakeItemListBuilder() {
                return getTakeItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addTakeItemListBuilder(int index) {
                return getTakeItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getTakeItemListBuilderList() {
                return getTakeItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getTakeItemListFieldBuilder() {
                if (this.takeItemListBuilder_ == null) {
                    this.takeItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.takeItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.takeItemList_ = null;
                }
                return this.takeItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostRspOuterClass.PlayerCompoundMaterialBoostRspOrBuilder
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

        public static PlayerCompoundMaterialBoostRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCompoundMaterialBoostRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCompoundMaterialBoostRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCompoundMaterialBoostRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CompoundBoostTakeStatusTypeOuterClass.getDescriptor();
        CompoundQueueDataOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
