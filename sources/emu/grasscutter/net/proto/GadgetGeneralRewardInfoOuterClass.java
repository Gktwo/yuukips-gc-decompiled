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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetGeneralRewardInfoOuterClass.class */
public final class GadgetGeneralRewardInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dGadgetGeneralRewardInfo.proto\u001a\u000fItemParam.proto\"\u0001\n\u0017GadgetGeneralRewardInfo\u0012\r\n\u0005resin\u0018\u0001 \u0001(\r\u0012\u0011\n\tdead_time\u0018\u0002 \u0001(\r\u0012\u0017\n\u000fremain_uid_list\u0018\u0003 \u0003(\r\u0012\u0018\n\u0010qualify_uid_list\u0018\u0004 \u0003(\r\u0012\u001e\n\nitem_param\u0018\u0005 \u0001(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GadgetGeneralRewardInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GadgetGeneralRewardInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GadgetGeneralRewardInfo_descriptor, new String[]{"Resin", "DeadTime", "RemainUidList", "QualifyUidList", "ItemParam"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetGeneralRewardInfoOuterClass$GadgetGeneralRewardInfoOrBuilder.class */
    public interface GadgetGeneralRewardInfoOrBuilder extends MessageOrBuilder {
        int getResin();

        int getDeadTime();

        List<Integer> getRemainUidListList();

        int getRemainUidListCount();

        int getRemainUidList(int i);

        List<Integer> getQualifyUidListList();

        int getQualifyUidListCount();

        int getQualifyUidList(int i);

        boolean hasItemParam();

        ItemParamOuterClass.ItemParam getItemParam();

        ItemParamOuterClass.ItemParamOrBuilder getItemParamOrBuilder();
    }

    private GadgetGeneralRewardInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetGeneralRewardInfoOuterClass$GadgetGeneralRewardInfo.class */
    public static final class GadgetGeneralRewardInfo extends GeneratedMessageV3 implements GadgetGeneralRewardInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RESIN_FIELD_NUMBER = 1;
        private int resin_;
        public static final int DEAD_TIME_FIELD_NUMBER = 2;
        private int deadTime_;
        public static final int REMAIN_UID_LIST_FIELD_NUMBER = 3;
        private Internal.IntList remainUidList_;
        private int remainUidListMemoizedSerializedSize;
        public static final int QUALIFY_UID_LIST_FIELD_NUMBER = 4;
        private Internal.IntList qualifyUidList_;
        private int qualifyUidListMemoizedSerializedSize;
        public static final int ITEM_PARAM_FIELD_NUMBER = 5;
        private ItemParamOuterClass.ItemParam itemParam_;
        private byte memoizedIsInitialized;
        private static final GadgetGeneralRewardInfo DEFAULT_INSTANCE = new GadgetGeneralRewardInfo();
        private static final Parser<GadgetGeneralRewardInfo> PARSER = new AbstractParser<GadgetGeneralRewardInfo>() { // from class: emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.1
            @Override // com.google.protobuf.Parser
            public GadgetGeneralRewardInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GadgetGeneralRewardInfo(input, extensionRegistry);
            }
        };

        private GadgetGeneralRewardInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.remainUidListMemoizedSerializedSize = -1;
            this.qualifyUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GadgetGeneralRewardInfo() {
            this.remainUidListMemoizedSerializedSize = -1;
            this.qualifyUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.remainUidList_ = emptyIntList();
            this.qualifyUidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GadgetGeneralRewardInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x01a7 */
        private GadgetGeneralRewardInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.resin_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.deadTime_ = input.readUInt32();
                                    break;
                                case 24:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.remainUidList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.remainUidList_.addInt(input.readUInt32());
                                    break;
                                case 26:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.remainUidList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.remainUidList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 32:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.qualifyUidList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.qualifyUidList_.addInt(input.readUInt32());
                                    break;
                                case 34:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.qualifyUidList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.qualifyUidList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 42:
                                    ItemParamOuterClass.ItemParam.Builder subBuilder = this.itemParam_ != null ? this.itemParam_.toBuilder() : null;
                                    this.itemParam_ = (ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.itemParam_);
                                        this.itemParam_ = subBuilder.buildPartial();
                                        break;
                                    }
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.remainUidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.qualifyUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GadgetGeneralRewardInfoOuterClass.internal_static_GadgetGeneralRewardInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GadgetGeneralRewardInfoOuterClass.internal_static_GadgetGeneralRewardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetGeneralRewardInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public int getResin() {
            return this.resin_;
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public int getDeadTime() {
            return this.deadTime_;
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public List<Integer> getRemainUidListList() {
            return this.remainUidList_;
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public int getRemainUidListCount() {
            return this.remainUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public int getRemainUidList(int index) {
            return this.remainUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public List<Integer> getQualifyUidListList() {
            return this.qualifyUidList_;
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public int getQualifyUidListCount() {
            return this.qualifyUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public int getQualifyUidList(int index) {
            return this.qualifyUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public boolean hasItemParam() {
            return this.itemParam_ != null;
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public ItemParamOuterClass.ItemParam getItemParam() {
            return this.itemParam_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.itemParam_;
        }

        @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemParamOrBuilder() {
            return getItemParam();
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
            if (this.resin_ != 0) {
                output.writeUInt32(1, this.resin_);
            }
            if (this.deadTime_ != 0) {
                output.writeUInt32(2, this.deadTime_);
            }
            if (getRemainUidListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.remainUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.remainUidList_.size(); i++) {
                output.writeUInt32NoTag(this.remainUidList_.getInt(i));
            }
            if (getQualifyUidListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.qualifyUidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.qualifyUidList_.size(); i2++) {
                output.writeUInt32NoTag(this.qualifyUidList_.getInt(i2));
            }
            if (this.itemParam_ != null) {
                output.writeMessage(5, getItemParam());
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
            if (this.resin_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.resin_);
            }
            if (this.deadTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.deadTime_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.remainUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.remainUidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getRemainUidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.remainUidListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.qualifyUidList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.qualifyUidList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getQualifyUidListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.qualifyUidListMemoizedSerializedSize = dataSize2;
            if (this.itemParam_ != null) {
                size4 += CodedOutputStream.computeMessageSize(5, getItemParam());
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GadgetGeneralRewardInfo)) {
                return equals(obj);
            }
            GadgetGeneralRewardInfo other = (GadgetGeneralRewardInfo) obj;
            if (getResin() == other.getResin() && getDeadTime() == other.getDeadTime() && getRemainUidListList().equals(other.getRemainUidListList()) && getQualifyUidListList().equals(other.getQualifyUidListList()) && hasItemParam() == other.hasItemParam()) {
                return (!hasItemParam() || getItemParam().equals(other.getItemParam())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getResin())) + 2)) + getDeadTime();
            if (getRemainUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getRemainUidListList().hashCode();
            }
            if (getQualifyUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getQualifyUidListList().hashCode();
            }
            if (hasItemParam()) {
                hash = (53 * ((37 * hash) + 5)) + getItemParam().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GadgetGeneralRewardInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetGeneralRewardInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetGeneralRewardInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetGeneralRewardInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetGeneralRewardInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetGeneralRewardInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetGeneralRewardInfo parseFrom(InputStream input) throws IOException {
            return (GadgetGeneralRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetGeneralRewardInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetGeneralRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetGeneralRewardInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GadgetGeneralRewardInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GadgetGeneralRewardInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetGeneralRewardInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetGeneralRewardInfo parseFrom(CodedInputStream input) throws IOException {
            return (GadgetGeneralRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetGeneralRewardInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetGeneralRewardInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GadgetGeneralRewardInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetGeneralRewardInfoOuterClass$GadgetGeneralRewardInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GadgetGeneralRewardInfoOrBuilder {
            private int bitField0_;
            private int resin_;
            private int deadTime_;
            private Internal.IntList remainUidList_ = GadgetGeneralRewardInfo.emptyIntList();
            private Internal.IntList qualifyUidList_ = GadgetGeneralRewardInfo.emptyIntList();
            private ItemParamOuterClass.ItemParam itemParam_;
            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemParamBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GadgetGeneralRewardInfoOuterClass.internal_static_GadgetGeneralRewardInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GadgetGeneralRewardInfoOuterClass.internal_static_GadgetGeneralRewardInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetGeneralRewardInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GadgetGeneralRewardInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.resin_ = 0;
                this.deadTime_ = 0;
                this.remainUidList_ = GadgetGeneralRewardInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.qualifyUidList_ = GadgetGeneralRewardInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.itemParamBuilder_ == null) {
                    this.itemParam_ = null;
                } else {
                    this.itemParam_ = null;
                    this.itemParamBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GadgetGeneralRewardInfoOuterClass.internal_static_GadgetGeneralRewardInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GadgetGeneralRewardInfo getDefaultInstanceForType() {
                return GadgetGeneralRewardInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetGeneralRewardInfo build() {
                GadgetGeneralRewardInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetGeneralRewardInfo buildPartial() {
                GadgetGeneralRewardInfo result = new GadgetGeneralRewardInfo(this);
                int i = this.bitField0_;
                result.resin_ = this.resin_;
                result.deadTime_ = this.deadTime_;
                if ((this.bitField0_ & 1) != 0) {
                    this.remainUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.remainUidList_ = this.remainUidList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.qualifyUidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.qualifyUidList_ = this.qualifyUidList_;
                if (this.itemParamBuilder_ == null) {
                    result.itemParam_ = this.itemParam_;
                } else {
                    result.itemParam_ = this.itemParamBuilder_.build();
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
                if (other instanceof GadgetGeneralRewardInfo) {
                    return mergeFrom((GadgetGeneralRewardInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GadgetGeneralRewardInfo other) {
                if (other == GadgetGeneralRewardInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getResin() != 0) {
                    setResin(other.getResin());
                }
                if (other.getDeadTime() != 0) {
                    setDeadTime(other.getDeadTime());
                }
                if (!other.remainUidList_.isEmpty()) {
                    if (this.remainUidList_.isEmpty()) {
                        this.remainUidList_ = other.remainUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRemainUidListIsMutable();
                        this.remainUidList_.addAll(other.remainUidList_);
                    }
                    onChanged();
                }
                if (!other.qualifyUidList_.isEmpty()) {
                    if (this.qualifyUidList_.isEmpty()) {
                        this.qualifyUidList_ = other.qualifyUidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureQualifyUidListIsMutable();
                        this.qualifyUidList_.addAll(other.qualifyUidList_);
                    }
                    onChanged();
                }
                if (other.hasItemParam()) {
                    mergeItemParam(other.getItemParam());
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
                GadgetGeneralRewardInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GadgetGeneralRewardInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GadgetGeneralRewardInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public int getResin() {
                return this.resin_;
            }

            public Builder setResin(int value) {
                this.resin_ = value;
                onChanged();
                return this;
            }

            public Builder clearResin() {
                this.resin_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public int getDeadTime() {
                return this.deadTime_;
            }

            public Builder setDeadTime(int value) {
                this.deadTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeadTime() {
                this.deadTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureRemainUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.remainUidList_ = GadgetGeneralRewardInfo.mutableCopy(this.remainUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public List<Integer> getRemainUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.remainUidList_) : this.remainUidList_;
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public int getRemainUidListCount() {
                return this.remainUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public int getRemainUidList(int index) {
                return this.remainUidList_.getInt(index);
            }

            public Builder setRemainUidList(int index, int value) {
                ensureRemainUidListIsMutable();
                this.remainUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRemainUidList(int value) {
                ensureRemainUidListIsMutable();
                this.remainUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRemainUidList(Iterable<? extends Integer> values) {
                ensureRemainUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.remainUidList_);
                onChanged();
                return this;
            }

            public Builder clearRemainUidList() {
                this.remainUidList_ = GadgetGeneralRewardInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureQualifyUidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.qualifyUidList_ = GadgetGeneralRewardInfo.mutableCopy(this.qualifyUidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public List<Integer> getQualifyUidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.qualifyUidList_) : this.qualifyUidList_;
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public int getQualifyUidListCount() {
                return this.qualifyUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public int getQualifyUidList(int index) {
                return this.qualifyUidList_.getInt(index);
            }

            public Builder setQualifyUidList(int index, int value) {
                ensureQualifyUidListIsMutable();
                this.qualifyUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addQualifyUidList(int value) {
                ensureQualifyUidListIsMutable();
                this.qualifyUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllQualifyUidList(Iterable<? extends Integer> values) {
                ensureQualifyUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.qualifyUidList_);
                onChanged();
                return this;
            }

            public Builder clearQualifyUidList() {
                this.qualifyUidList_ = GadgetGeneralRewardInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public boolean hasItemParam() {
                return (this.itemParamBuilder_ == null && this.itemParam_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public ItemParamOuterClass.ItemParam getItemParam() {
                if (this.itemParamBuilder_ == null) {
                    return this.itemParam_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.itemParam_;
                }
                return this.itemParamBuilder_.getMessage();
            }

            public Builder setItemParam(ItemParamOuterClass.ItemParam value) {
                if (this.itemParamBuilder_ != null) {
                    this.itemParamBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.itemParam_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setItemParam(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamBuilder_ == null) {
                    this.itemParam_ = builderForValue.build();
                    onChanged();
                } else {
                    this.itemParamBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeItemParam(ItemParamOuterClass.ItemParam value) {
                if (this.itemParamBuilder_ == null) {
                    if (this.itemParam_ != null) {
                        this.itemParam_ = ItemParamOuterClass.ItemParam.newBuilder(this.itemParam_).mergeFrom(value).buildPartial();
                    } else {
                        this.itemParam_ = value;
                    }
                    onChanged();
                } else {
                    this.itemParamBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearItemParam() {
                if (this.itemParamBuilder_ == null) {
                    this.itemParam_ = null;
                    onChanged();
                } else {
                    this.itemParam_ = null;
                    this.itemParamBuilder_ = null;
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemParamBuilder() {
                onChanged();
                return getItemParamFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemParamOrBuilder() {
                if (this.itemParamBuilder_ != null) {
                    return this.itemParamBuilder_.getMessageOrBuilder();
                }
                return this.itemParam_ == null ? ItemParamOuterClass.ItemParam.getDefaultInstance() : this.itemParam_;
            }

            private SingleFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemParamFieldBuilder() {
                if (this.itemParamBuilder_ == null) {
                    this.itemParamBuilder_ = new SingleFieldBuilderV3<>(getItemParam(), getParentForChildren(), isClean());
                    this.itemParam_ = null;
                }
                return this.itemParamBuilder_;
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

        public static GadgetGeneralRewardInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GadgetGeneralRewardInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GadgetGeneralRewardInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GadgetGeneralRewardInfo getDefaultInstanceForType() {
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
