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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketStoreInfoOuterClass.class */
public final class VintageMarketStoreInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cVintageMarketStoreInfo.proto\"\u0001\n\u0016VintageMarketStoreInfo\u0012\u0010\n\bstore_id\u0018\r \u0001(\r\u0012\u001b\n\u0013Unk3300_HNBGHCCENIA\u0018\u0001 \u0003(\r\u0012\u0015\n\rstrategy_list\u0018\n \u0003(\r\u0012\u001b\n\u0013Unk3300_ODLLANKOEND\u0018\u0007 \u0003(\r\u0012\u0012\n\nslot_count\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_VintageMarketStoreInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageMarketStoreInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketStoreInfo_descriptor, new String[]{"StoreId", "Unk3300HNBGHCCENIA", "StrategyList", "Unk3300ODLLANKOEND", "SlotCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketStoreInfoOuterClass$VintageMarketStoreInfoOrBuilder.class */
    public interface VintageMarketStoreInfoOrBuilder extends MessageOrBuilder {
        int getStoreId();

        List<Integer> getUnk3300HNBGHCCENIAList();

        int getUnk3300HNBGHCCENIACount();

        int getUnk3300HNBGHCCENIA(int i);

        List<Integer> getStrategyListList();

        int getStrategyListCount();

        int getStrategyList(int i);

        List<Integer> getUnk3300ODLLANKOENDList();

        int getUnk3300ODLLANKOENDCount();

        int getUnk3300ODLLANKOEND(int i);

        int getSlotCount();
    }

    private VintageMarketStoreInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketStoreInfoOuterClass$VintageMarketStoreInfo.class */
    public static final class VintageMarketStoreInfo extends GeneratedMessageV3 implements VintageMarketStoreInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STORE_ID_FIELD_NUMBER = 13;
        private int storeId_;
        public static final int UNK3300_HNBGHCCENIA_FIELD_NUMBER = 1;
        private Internal.IntList unk3300HNBGHCCENIA_;
        private int unk3300HNBGHCCENIAMemoizedSerializedSize;
        public static final int STRATEGY_LIST_FIELD_NUMBER = 10;
        private Internal.IntList strategyList_;
        private int strategyListMemoizedSerializedSize;
        public static final int UNK3300_ODLLANKOEND_FIELD_NUMBER = 7;
        private Internal.IntList unk3300ODLLANKOEND_;
        private int unk3300ODLLANKOENDMemoizedSerializedSize;
        public static final int SLOT_COUNT_FIELD_NUMBER = 5;
        private int slotCount_;
        private byte memoizedIsInitialized;
        private static final VintageMarketStoreInfo DEFAULT_INSTANCE = new VintageMarketStoreInfo();
        private static final Parser<VintageMarketStoreInfo> PARSER = new AbstractParser<VintageMarketStoreInfo>() { // from class: emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfo.1
            @Override // com.google.protobuf.Parser
            public VintageMarketStoreInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageMarketStoreInfo(input, extensionRegistry);
            }
        };

        private VintageMarketStoreInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300HNBGHCCENIAMemoizedSerializedSize = -1;
            this.strategyListMemoizedSerializedSize = -1;
            this.unk3300ODLLANKOENDMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private VintageMarketStoreInfo() {
            this.unk3300HNBGHCCENIAMemoizedSerializedSize = -1;
            this.strategyListMemoizedSerializedSize = -1;
            this.unk3300ODLLANKOENDMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300HNBGHCCENIA_ = emptyIntList();
            this.strategyList_ = emptyIntList();
            this.unk3300ODLLANKOEND_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageMarketStoreInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x01d9 */
        private VintageMarketStoreInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk3300HNBGHCCENIA_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unk3300HNBGHCCENIA_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300HNBGHCCENIA_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300HNBGHCCENIA_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 40:
                                    this.slotCount_ = input.readUInt32();
                                    break;
                                case 56:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.unk3300ODLLANKOEND_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.unk3300ODLLANKOEND_.addInt(input.readUInt32());
                                    break;
                                case 58:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300ODLLANKOEND_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300ODLLANKOEND_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.strategyList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.strategyList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit3 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.strategyList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.strategyList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit3);
                                    break;
                                case 104:
                                    this.storeId_ = input.readUInt32();
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
                    this.unk3300HNBGHCCENIA_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unk3300ODLLANKOEND_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.strategyList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VintageMarketStoreInfoOuterClass.internal_static_VintageMarketStoreInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageMarketStoreInfoOuterClass.internal_static_VintageMarketStoreInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketStoreInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getStoreId() {
            return this.storeId_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public List<Integer> getUnk3300HNBGHCCENIAList() {
            return this.unk3300HNBGHCCENIA_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getUnk3300HNBGHCCENIACount() {
            return this.unk3300HNBGHCCENIA_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getUnk3300HNBGHCCENIA(int index) {
            return this.unk3300HNBGHCCENIA_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public List<Integer> getStrategyListList() {
            return this.strategyList_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getStrategyListCount() {
            return this.strategyList_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getStrategyList(int index) {
            return this.strategyList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public List<Integer> getUnk3300ODLLANKOENDList() {
            return this.unk3300ODLLANKOEND_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getUnk3300ODLLANKOENDCount() {
            return this.unk3300ODLLANKOEND_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getUnk3300ODLLANKOEND(int index) {
            return this.unk3300ODLLANKOEND_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
        public int getSlotCount() {
            return this.slotCount_;
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
            if (getUnk3300HNBGHCCENIAList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.unk3300HNBGHCCENIAMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300HNBGHCCENIA_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300HNBGHCCENIA_.getInt(i));
            }
            if (this.slotCount_ != 0) {
                output.writeUInt32(5, this.slotCount_);
            }
            if (getUnk3300ODLLANKOENDList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.unk3300ODLLANKOENDMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300ODLLANKOEND_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300ODLLANKOEND_.getInt(i2));
            }
            if (getStrategyListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.strategyListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.strategyList_.size(); i3++) {
                output.writeUInt32NoTag(this.strategyList_.getInt(i3));
            }
            if (this.storeId_ != 0) {
                output.writeUInt32(13, this.storeId_);
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
            for (int i = 0; i < this.unk3300HNBGHCCENIA_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300HNBGHCCENIA_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300HNBGHCCENIAList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300HNBGHCCENIAMemoizedSerializedSize = dataSize;
            if (this.slotCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.slotCount_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300ODLLANKOEND_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300ODLLANKOEND_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300ODLLANKOENDList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300ODLLANKOENDMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.strategyList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.strategyList_.getInt(i3));
            }
            int size4 = size3 + dataSize3;
            if (!getStrategyListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.strategyListMemoizedSerializedSize = dataSize3;
            if (this.storeId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(13, this.storeId_);
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
            if (!(obj instanceof VintageMarketStoreInfo)) {
                return equals(obj);
            }
            VintageMarketStoreInfo other = (VintageMarketStoreInfo) obj;
            return getStoreId() == other.getStoreId() && getUnk3300HNBGHCCENIAList().equals(other.getUnk3300HNBGHCCENIAList()) && getStrategyListList().equals(other.getStrategyListList()) && getUnk3300ODLLANKOENDList().equals(other.getUnk3300ODLLANKOENDList()) && getSlotCount() == other.getSlotCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getStoreId();
            if (getUnk3300HNBGHCCENIACount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getUnk3300HNBGHCCENIAList().hashCode();
            }
            if (getStrategyListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getStrategyListList().hashCode();
            }
            if (getUnk3300ODLLANKOENDCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getUnk3300ODLLANKOENDList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 5)) + getSlotCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VintageMarketStoreInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketStoreInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketStoreInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketStoreInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketStoreInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketStoreInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketStoreInfo parseFrom(InputStream input) throws IOException {
            return (VintageMarketStoreInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketStoreInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketStoreInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketStoreInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageMarketStoreInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageMarketStoreInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketStoreInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketStoreInfo parseFrom(CodedInputStream input) throws IOException {
            return (VintageMarketStoreInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketStoreInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketStoreInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageMarketStoreInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketStoreInfoOuterClass$VintageMarketStoreInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageMarketStoreInfoOrBuilder {
            private int bitField0_;
            private int storeId_;
            private Internal.IntList unk3300HNBGHCCENIA_ = VintageMarketStoreInfo.emptyIntList();
            private Internal.IntList strategyList_ = VintageMarketStoreInfo.emptyIntList();
            private Internal.IntList unk3300ODLLANKOEND_ = VintageMarketStoreInfo.emptyIntList();
            private int slotCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageMarketStoreInfoOuterClass.internal_static_VintageMarketStoreInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageMarketStoreInfoOuterClass.internal_static_VintageMarketStoreInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketStoreInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageMarketStoreInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.storeId_ = 0;
                this.unk3300HNBGHCCENIA_ = VintageMarketStoreInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.strategyList_ = VintageMarketStoreInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unk3300ODLLANKOEND_ = VintageMarketStoreInfo.emptyIntList();
                this.bitField0_ &= -5;
                this.slotCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageMarketStoreInfoOuterClass.internal_static_VintageMarketStoreInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageMarketStoreInfo getDefaultInstanceForType() {
                return VintageMarketStoreInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketStoreInfo build() {
                VintageMarketStoreInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketStoreInfo buildPartial() {
                VintageMarketStoreInfo result = new VintageMarketStoreInfo(this);
                int i = this.bitField0_;
                result.storeId_ = this.storeId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300HNBGHCCENIA_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300HNBGHCCENIA_ = this.unk3300HNBGHCCENIA_;
                if ((this.bitField0_ & 2) != 0) {
                    this.strategyList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.strategyList_ = this.strategyList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.unk3300ODLLANKOEND_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.unk3300ODLLANKOEND_ = this.unk3300ODLLANKOEND_;
                result.slotCount_ = this.slotCount_;
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
                if (other instanceof VintageMarketStoreInfo) {
                    return mergeFrom((VintageMarketStoreInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageMarketStoreInfo other) {
                if (other == VintageMarketStoreInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStoreId() != 0) {
                    setStoreId(other.getStoreId());
                }
                if (!other.unk3300HNBGHCCENIA_.isEmpty()) {
                    if (this.unk3300HNBGHCCENIA_.isEmpty()) {
                        this.unk3300HNBGHCCENIA_ = other.unk3300HNBGHCCENIA_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300HNBGHCCENIAIsMutable();
                        this.unk3300HNBGHCCENIA_.addAll(other.unk3300HNBGHCCENIA_);
                    }
                    onChanged();
                }
                if (!other.strategyList_.isEmpty()) {
                    if (this.strategyList_.isEmpty()) {
                        this.strategyList_ = other.strategyList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureStrategyListIsMutable();
                        this.strategyList_.addAll(other.strategyList_);
                    }
                    onChanged();
                }
                if (!other.unk3300ODLLANKOEND_.isEmpty()) {
                    if (this.unk3300ODLLANKOEND_.isEmpty()) {
                        this.unk3300ODLLANKOEND_ = other.unk3300ODLLANKOEND_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureUnk3300ODLLANKOENDIsMutable();
                        this.unk3300ODLLANKOEND_.addAll(other.unk3300ODLLANKOEND_);
                    }
                    onChanged();
                }
                if (other.getSlotCount() != 0) {
                    setSlotCount(other.getSlotCount());
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
                VintageMarketStoreInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageMarketStoreInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageMarketStoreInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getStoreId() {
                return this.storeId_;
            }

            public Builder setStoreId(int value) {
                this.storeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStoreId() {
                this.storeId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300HNBGHCCENIAIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300HNBGHCCENIA_ = VintageMarketStoreInfo.mutableCopy(this.unk3300HNBGHCCENIA_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public List<Integer> getUnk3300HNBGHCCENIAList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300HNBGHCCENIA_) : this.unk3300HNBGHCCENIA_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getUnk3300HNBGHCCENIACount() {
                return this.unk3300HNBGHCCENIA_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getUnk3300HNBGHCCENIA(int index) {
                return this.unk3300HNBGHCCENIA_.getInt(index);
            }

            public Builder setUnk3300HNBGHCCENIA(int index, int value) {
                ensureUnk3300HNBGHCCENIAIsMutable();
                this.unk3300HNBGHCCENIA_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300HNBGHCCENIA(int value) {
                ensureUnk3300HNBGHCCENIAIsMutable();
                this.unk3300HNBGHCCENIA_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300HNBGHCCENIA(Iterable<? extends Integer> values) {
                ensureUnk3300HNBGHCCENIAIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300HNBGHCCENIA_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300HNBGHCCENIA() {
                this.unk3300HNBGHCCENIA_ = VintageMarketStoreInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureStrategyListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.strategyList_ = VintageMarketStoreInfo.mutableCopy(this.strategyList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public List<Integer> getStrategyListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.strategyList_) : this.strategyList_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getStrategyListCount() {
                return this.strategyList_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getStrategyList(int index) {
                return this.strategyList_.getInt(index);
            }

            public Builder setStrategyList(int index, int value) {
                ensureStrategyListIsMutable();
                this.strategyList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addStrategyList(int value) {
                ensureStrategyListIsMutable();
                this.strategyList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllStrategyList(Iterable<? extends Integer> values) {
                ensureStrategyListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.strategyList_);
                onChanged();
                return this;
            }

            public Builder clearStrategyList() {
                this.strategyList_ = VintageMarketStoreInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureUnk3300ODLLANKOENDIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unk3300ODLLANKOEND_ = VintageMarketStoreInfo.mutableCopy(this.unk3300ODLLANKOEND_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public List<Integer> getUnk3300ODLLANKOENDList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unk3300ODLLANKOEND_) : this.unk3300ODLLANKOEND_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getUnk3300ODLLANKOENDCount() {
                return this.unk3300ODLLANKOEND_.size();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getUnk3300ODLLANKOEND(int index) {
                return this.unk3300ODLLANKOEND_.getInt(index);
            }

            public Builder setUnk3300ODLLANKOEND(int index, int value) {
                ensureUnk3300ODLLANKOENDIsMutable();
                this.unk3300ODLLANKOEND_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300ODLLANKOEND(int value) {
                ensureUnk3300ODLLANKOENDIsMutable();
                this.unk3300ODLLANKOEND_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300ODLLANKOEND(Iterable<? extends Integer> values) {
                ensureUnk3300ODLLANKOENDIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300ODLLANKOEND_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300ODLLANKOEND() {
                this.unk3300ODLLANKOEND_ = VintageMarketStoreInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketStoreInfoOuterClass.VintageMarketStoreInfoOrBuilder
            public int getSlotCount() {
                return this.slotCount_;
            }

            public Builder setSlotCount(int value) {
                this.slotCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearSlotCount() {
                this.slotCount_ = 0;
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

        public static VintageMarketStoreInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageMarketStoreInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageMarketStoreInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageMarketStoreInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
