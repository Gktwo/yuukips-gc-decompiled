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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestRspOuterClass.class */
public final class TakeCityReputationParentQuestRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&TakeCityReputationParentQuestRsp.proto\u001a\u000fItemParam.proto\"~\n TakeCityReputationParentQuestRsp\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005\u0012\u0019\n\u0011parent_quest_list\u0018\u0002 \u0003(\r\u0012\u000f\n\u0007city_id\u0018\u000e \u0001(\r\u0012\u001d\n\titem_list\u0018\u0007 \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TakeCityReputationParentQuestRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TakeCityReputationParentQuestRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f885x7531eb3b = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeCityReputationParentQuestRsp_descriptor, new String[]{"Retcode", "ParentQuestList", "CityId", "ItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestRspOuterClass$TakeCityReputationParentQuestRspOrBuilder.class */
    public interface TakeCityReputationParentQuestRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<Integer> getParentQuestListList();

        int getParentQuestListCount();

        int getParentQuestList(int i);

        int getCityId();

        List<ItemParamOuterClass.ItemParam> getItemListList();

        ItemParamOuterClass.ItemParam getItemList(int i);

        int getItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int i);
    }

    private TakeCityReputationParentQuestRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestRspOuterClass$TakeCityReputationParentQuestRsp.class */
    public static final class TakeCityReputationParentQuestRsp extends GeneratedMessageV3 implements TakeCityReputationParentQuestRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        public static final int PARENT_QUEST_LIST_FIELD_NUMBER = 2;
        private Internal.IntList parentQuestList_;
        private int parentQuestListMemoizedSerializedSize;
        public static final int CITY_ID_FIELD_NUMBER = 14;
        private int cityId_;
        public static final int ITEM_LIST_FIELD_NUMBER = 7;
        private List<ItemParamOuterClass.ItemParam> itemList_;
        private byte memoizedIsInitialized;
        private static final TakeCityReputationParentQuestRsp DEFAULT_INSTANCE = new TakeCityReputationParentQuestRsp();
        private static final Parser<TakeCityReputationParentQuestRsp> PARSER = new AbstractParser<TakeCityReputationParentQuestRsp>() { // from class: emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRsp.1
            @Override // com.google.protobuf.Parser
            public TakeCityReputationParentQuestRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeCityReputationParentQuestRsp(input, extensionRegistry);
            }
        };

        private TakeCityReputationParentQuestRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.parentQuestListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TakeCityReputationParentQuestRsp() {
            this.parentQuestListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.parentQuestList_ = emptyIntList();
            this.itemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeCityReputationParentQuestRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0120 */
        private TakeCityReputationParentQuestRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.parentQuestList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.parentQuestList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.parentQuestList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.parentQuestList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.retcode_ = input.readInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.itemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.itemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.cityId_ = input.readUInt32();
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
                    this.parentQuestList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.itemList_ = Collections.unmodifiableList(this.itemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeCityReputationParentQuestRspOuterClass.internal_static_TakeCityReputationParentQuestRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeCityReputationParentQuestRspOuterClass.f885x7531eb3b.ensureFieldAccessorsInitialized(TakeCityReputationParentQuestRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public List<Integer> getParentQuestListList() {
            return this.parentQuestList_;
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public int getParentQuestListCount() {
            return this.parentQuestList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public int getParentQuestList(int index) {
            return this.parentQuestList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public int getCityId() {
            return this.cityId_;
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemListList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemListOrBuilderList() {
            return this.itemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public int getItemListCount() {
            return this.itemList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemList(int index) {
            return this.itemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
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
            getSerializedSize();
            if (getParentQuestListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.parentQuestListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.parentQuestList_.size(); i++) {
                output.writeUInt32NoTag(this.parentQuestList_.getInt(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(3, this.retcode_);
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                output.writeMessage(7, this.itemList_.get(i2));
            }
            if (this.cityId_ != 0) {
                output.writeUInt32(14, this.cityId_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.parentQuestList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.parentQuestList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getParentQuestListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.parentQuestListMemoizedSerializedSize = dataSize;
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            for (int i2 = 0; i2 < this.itemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.itemList_.get(i2));
            }
            if (this.cityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.cityId_);
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
            if (!(obj instanceof TakeCityReputationParentQuestRsp)) {
                return equals(obj);
            }
            TakeCityReputationParentQuestRsp other = (TakeCityReputationParentQuestRsp) obj;
            return getRetcode() == other.getRetcode() && getParentQuestListList().equals(other.getParentQuestListList()) && getCityId() == other.getCityId() && getItemListList().equals(other.getItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getRetcode();
            if (getParentQuestListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getParentQuestListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 14)) + getCityId();
            if (getItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getItemListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static TakeCityReputationParentQuestRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(InputStream input) throws IOException {
            return (TakeCityReputationParentQuestRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCityReputationParentQuestRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeCityReputationParentQuestRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeCityReputationParentQuestRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeCityReputationParentQuestRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCityReputationParentQuestRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(CodedInputStream input) throws IOException {
            return (TakeCityReputationParentQuestRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeCityReputationParentQuestRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCityReputationParentQuestRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeCityReputationParentQuestRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestRspOuterClass$TakeCityReputationParentQuestRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeCityReputationParentQuestRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int cityId_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemListBuilder_;
            private Internal.IntList parentQuestList_ = TakeCityReputationParentQuestRsp.emptyIntList();
            private List<ItemParamOuterClass.ItemParam> itemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeCityReputationParentQuestRspOuterClass.internal_static_TakeCityReputationParentQuestRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeCityReputationParentQuestRspOuterClass.f885x7531eb3b.ensureFieldAccessorsInitialized(TakeCityReputationParentQuestRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeCityReputationParentQuestRsp.alwaysUseFieldBuilders) {
                    getItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.parentQuestList_ = TakeCityReputationParentQuestRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.cityId_ = 0;
                if (this.itemListBuilder_ == null) {
                    this.itemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.itemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeCityReputationParentQuestRspOuterClass.internal_static_TakeCityReputationParentQuestRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeCityReputationParentQuestRsp getDefaultInstanceForType() {
                return TakeCityReputationParentQuestRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeCityReputationParentQuestRsp build() {
                TakeCityReputationParentQuestRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeCityReputationParentQuestRsp buildPartial() {
                TakeCityReputationParentQuestRsp result = new TakeCityReputationParentQuestRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if ((this.bitField0_ & 1) != 0) {
                    this.parentQuestList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.parentQuestList_ = this.parentQuestList_;
                result.cityId_ = this.cityId_;
                if (this.itemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.itemList_ = Collections.unmodifiableList(this.itemList_);
                        this.bitField0_ &= -3;
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
                if (other instanceof TakeCityReputationParentQuestRsp) {
                    return mergeFrom((TakeCityReputationParentQuestRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeCityReputationParentQuestRsp other) {
                if (other == TakeCityReputationParentQuestRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.parentQuestList_.isEmpty()) {
                    if (this.parentQuestList_.isEmpty()) {
                        this.parentQuestList_ = other.parentQuestList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureParentQuestListIsMutable();
                        this.parentQuestList_.addAll(other.parentQuestList_);
                    }
                    onChanged();
                }
                if (other.getCityId() != 0) {
                    setCityId(other.getCityId());
                }
                if (this.itemListBuilder_ == null) {
                    if (!other.itemList_.isEmpty()) {
                        if (this.itemList_.isEmpty()) {
                            this.itemList_ = other.itemList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.itemListBuilder_ = TakeCityReputationParentQuestRsp.alwaysUseFieldBuilders ? getItemListFieldBuilder() : null;
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
                TakeCityReputationParentQuestRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeCityReputationParentQuestRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeCityReputationParentQuestRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
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

            private void ensureParentQuestListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.parentQuestList_ = TakeCityReputationParentQuestRsp.mutableCopy(this.parentQuestList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public List<Integer> getParentQuestListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.parentQuestList_) : this.parentQuestList_;
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public int getParentQuestListCount() {
                return this.parentQuestList_.size();
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public int getParentQuestList(int index) {
                return this.parentQuestList_.getInt(index);
            }

            public Builder setParentQuestList(int index, int value) {
                ensureParentQuestListIsMutable();
                this.parentQuestList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addParentQuestList(int value) {
                ensureParentQuestListIsMutable();
                this.parentQuestList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllParentQuestList(Iterable<? extends Integer> values) {
                ensureParentQuestListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.parentQuestList_);
                onChanged();
                return this;
            }

            public Builder clearParentQuestList() {
                this.parentQuestList_ = TakeCityReputationParentQuestRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public int getCityId() {
                return this.cityId_;
            }

            public Builder setCityId(int value) {
                this.cityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCityId() {
                this.cityId_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.itemList_ = new ArrayList(this.itemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemListList() {
                if (this.itemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemList_);
                }
                return this.itemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public int getItemListCount() {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.size();
                }
                return this.itemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemListOrBuilder(int index) {
                if (this.itemListBuilder_ == null) {
                    return this.itemList_.get(index);
                }
                return this.itemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestRspOuterClass.TakeCityReputationParentQuestRspOrBuilder
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
                    this.itemListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
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

        public static TakeCityReputationParentQuestRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeCityReputationParentQuestRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeCityReputationParentQuestRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeCityReputationParentQuestRsp getDefaultInstanceForType() {
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
