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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineRspOuterClass.class */
public final class CombineRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010CombineRsp.proto\u001a\u000fItemParam.proto\"\u0002\n\nCombineRsp\u0012\u0014\n\fcombineCount\u0018\n \u0001(\r\u0012\"\n\u000eresultItemList\u0018\r \u0003(\u000b2\n.ItemParam\u0012\u0012\n\navatarGuid\u0018\u0007 \u0001(\u0004\u0012&\n\u0012totalExtraItemList\u0018\u0001 \u0003(\u000b2\n.ItemParam\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005\u0012'\n\u0013totalRandomItemList\u0018\u0003 \u0003(\u000b2\n.ItemParam\u0012\u0011\n\tcombineId\u0018\u0005 \u0001(\r\u0012 \n\fcostItemList\u0018\u0002 \u0003(\u000b2\n.ItemParam\u0012'\n\u0013totalReturnItemList\u0018\u0004 \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CombineRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CombineRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CombineRsp_descriptor, new String[]{"CombineCount", "ResultItemList", "AvatarGuid", "TotalExtraItemList", "Retcode", "TotalRandomItemList", "CombineId", "CostItemList", "TotalReturnItemList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineRspOuterClass$CombineRspOrBuilder.class */
    public interface CombineRspOrBuilder extends MessageOrBuilder {
        int getCombineCount();

        List<ItemParamOuterClass.ItemParam> getResultItemListList();

        ItemParamOuterClass.ItemParam getResultItemList(int i);

        int getResultItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getResultItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getResultItemListOrBuilder(int i);

        long getAvatarGuid();

        List<ItemParamOuterClass.ItemParam> getTotalExtraItemListList();

        ItemParamOuterClass.ItemParam getTotalExtraItemList(int i);

        int getTotalExtraItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalExtraItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getTotalExtraItemListOrBuilder(int i);

        int getRetcode();

        List<ItemParamOuterClass.ItemParam> getTotalRandomItemListList();

        ItemParamOuterClass.ItemParam getTotalRandomItemList(int i);

        int getTotalRandomItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalRandomItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getTotalRandomItemListOrBuilder(int i);

        int getCombineId();

        List<ItemParamOuterClass.ItemParam> getCostItemListList();

        ItemParamOuterClass.ItemParam getCostItemList(int i);

        int getCostItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int i);

        List<ItemParamOuterClass.ItemParam> getTotalReturnItemListList();

        ItemParamOuterClass.ItemParam getTotalReturnItemList(int i);

        int getTotalReturnItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalReturnItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getTotalReturnItemListOrBuilder(int i);
    }

    private CombineRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineRspOuterClass$CombineRsp.class */
    public static final class CombineRsp extends GeneratedMessageV3 implements CombineRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMBINECOUNT_FIELD_NUMBER = 10;
        private int combineCount_;
        public static final int RESULTITEMLIST_FIELD_NUMBER = 13;
        private List<ItemParamOuterClass.ItemParam> resultItemList_;
        public static final int AVATARGUID_FIELD_NUMBER = 7;
        private long avatarGuid_;
        public static final int TOTALEXTRAITEMLIST_FIELD_NUMBER = 1;
        private List<ItemParamOuterClass.ItemParam> totalExtraItemList_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        public static final int TOTALRANDOMITEMLIST_FIELD_NUMBER = 3;
        private List<ItemParamOuterClass.ItemParam> totalRandomItemList_;
        public static final int COMBINEID_FIELD_NUMBER = 5;
        private int combineId_;
        public static final int COSTITEMLIST_FIELD_NUMBER = 2;
        private List<ItemParamOuterClass.ItemParam> costItemList_;
        public static final int TOTALRETURNITEMLIST_FIELD_NUMBER = 4;
        private List<ItemParamOuterClass.ItemParam> totalReturnItemList_;
        private byte memoizedIsInitialized;
        private static final CombineRsp DEFAULT_INSTANCE = new CombineRsp();
        private static final Parser<CombineRsp> PARSER = new AbstractParser<CombineRsp>() { // from class: emu.grasscutter.net.proto.CombineRspOuterClass.CombineRsp.1
            @Override // com.google.protobuf.Parser
            public CombineRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CombineRsp(input, extensionRegistry);
            }
        };

        private CombineRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CombineRsp() {
            this.memoizedIsInitialized = -1;
            this.resultItemList_ = Collections.emptyList();
            this.totalExtraItemList_ = Collections.emptyList();
            this.totalRandomItemList_ = Collections.emptyList();
            this.costItemList_ = Collections.emptyList();
            this.totalReturnItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CombineRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x01a7 */
        private CombineRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.totalExtraItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.totalExtraItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.costItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.costItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.totalRandomItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.totalRandomItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.totalReturnItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.totalReturnItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 40:
                                this.combineId_ = input.readUInt32();
                                break;
                            case 56:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 80:
                                this.combineCount_ = input.readUInt32();
                                break;
                            case 96:
                                this.retcode_ = input.readInt32();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.resultItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.resultItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.totalExtraItemList_ = Collections.unmodifiableList(this.totalExtraItemList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.costItemList_ = Collections.unmodifiableList(this.costItemList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.totalRandomItemList_ = Collections.unmodifiableList(this.totalRandomItemList_);
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.totalReturnItemList_ = Collections.unmodifiableList(this.totalReturnItemList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.resultItemList_ = Collections.unmodifiableList(this.resultItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CombineRspOuterClass.internal_static_CombineRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CombineRspOuterClass.internal_static_CombineRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getCombineCount() {
            return this.combineCount_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getResultItemListList() {
            return this.resultItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getResultItemListOrBuilderList() {
            return this.resultItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getResultItemListCount() {
            return this.resultItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParam getResultItemList(int index) {
            return this.resultItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getResultItemListOrBuilder(int index) {
            return this.resultItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getTotalExtraItemListList() {
            return this.totalExtraItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalExtraItemListOrBuilderList() {
            return this.totalExtraItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getTotalExtraItemListCount() {
            return this.totalExtraItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParam getTotalExtraItemList(int index) {
            return this.totalExtraItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getTotalExtraItemListOrBuilder(int index) {
            return this.totalExtraItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getTotalRandomItemListList() {
            return this.totalRandomItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalRandomItemListOrBuilderList() {
            return this.totalRandomItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getTotalRandomItemListCount() {
            return this.totalRandomItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParam getTotalRandomItemList(int index) {
            return this.totalRandomItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getTotalRandomItemListOrBuilder(int index) {
            return this.totalRandomItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getCombineId() {
            return this.combineId_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getCostItemListList() {
            return this.costItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList() {
            return this.costItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getCostItemListCount() {
            return this.costItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParam getCostItemList(int index) {
            return this.costItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int index) {
            return this.costItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getTotalReturnItemListList() {
            return this.totalReturnItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalReturnItemListOrBuilderList() {
            return this.totalReturnItemList_;
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public int getTotalReturnItemListCount() {
            return this.totalReturnItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParam getTotalReturnItemList(int index) {
            return this.totalReturnItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getTotalReturnItemListOrBuilder(int index) {
            return this.totalReturnItemList_.get(index);
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
            for (int i = 0; i < this.totalExtraItemList_.size(); i++) {
                output.writeMessage(1, this.totalExtraItemList_.get(i));
            }
            for (int i2 = 0; i2 < this.costItemList_.size(); i2++) {
                output.writeMessage(2, this.costItemList_.get(i2));
            }
            for (int i3 = 0; i3 < this.totalRandomItemList_.size(); i3++) {
                output.writeMessage(3, this.totalRandomItemList_.get(i3));
            }
            for (int i4 = 0; i4 < this.totalReturnItemList_.size(); i4++) {
                output.writeMessage(4, this.totalReturnItemList_.get(i4));
            }
            if (this.combineId_ != 0) {
                output.writeUInt32(5, this.combineId_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(7, this.avatarGuid_);
            }
            if (this.combineCount_ != 0) {
                output.writeUInt32(10, this.combineCount_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
            }
            for (int i5 = 0; i5 < this.resultItemList_.size(); i5++) {
                output.writeMessage(13, this.resultItemList_.get(i5));
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
            for (int i = 0; i < this.totalExtraItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.totalExtraItemList_.get(i));
            }
            for (int i2 = 0; i2 < this.costItemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.costItemList_.get(i2));
            }
            for (int i3 = 0; i3 < this.totalRandomItemList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.totalRandomItemList_.get(i3));
            }
            for (int i4 = 0; i4 < this.totalReturnItemList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.totalReturnItemList_.get(i4));
            }
            if (this.combineId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.combineId_);
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(7, this.avatarGuid_);
            }
            if (this.combineCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.combineCount_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
            }
            for (int i5 = 0; i5 < this.resultItemList_.size(); i5++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.resultItemList_.get(i5));
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
            if (!(obj instanceof CombineRsp)) {
                return equals(obj);
            }
            CombineRsp other = (CombineRsp) obj;
            return getCombineCount() == other.getCombineCount() && getResultItemListList().equals(other.getResultItemListList()) && getAvatarGuid() == other.getAvatarGuid() && getTotalExtraItemListList().equals(other.getTotalExtraItemListList()) && getRetcode() == other.getRetcode() && getTotalRandomItemListList().equals(other.getTotalRandomItemListList()) && getCombineId() == other.getCombineId() && getCostItemListList().equals(other.getCostItemListList()) && getTotalReturnItemListList().equals(other.getTotalReturnItemListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getCombineCount();
            if (getResultItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getResultItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 7)) + Internal.hashLong(getAvatarGuid());
            if (getTotalExtraItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getTotalExtraItemListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 12)) + getRetcode();
            if (getTotalRandomItemListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 3)) + getTotalRandomItemListList().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 5)) + getCombineId();
            if (getCostItemListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 2)) + getCostItemListList().hashCode();
            }
            if (getTotalReturnItemListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 4)) + getTotalReturnItemListList().hashCode();
            }
            int hash5 = (29 * hash4) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static CombineRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombineRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombineRsp parseFrom(InputStream input) throws IOException {
            return (CombineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (CombineRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CombineRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombineRsp parseFrom(CodedInputStream input) throws IOException {
            return (CombineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombineRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CombineRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombineRspOuterClass$CombineRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CombineRspOrBuilder {
            private int bitField0_;
            private int combineCount_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> resultItemListBuilder_;
            private long avatarGuid_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> totalExtraItemListBuilder_;
            private int retcode_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> totalRandomItemListBuilder_;
            private int combineId_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> costItemListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> totalReturnItemListBuilder_;
            private List<ItemParamOuterClass.ItemParam> resultItemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> totalExtraItemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> totalRandomItemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> costItemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> totalReturnItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return CombineRspOuterClass.internal_static_CombineRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CombineRspOuterClass.internal_static_CombineRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(CombineRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CombineRsp.alwaysUseFieldBuilders) {
                    getResultItemListFieldBuilder();
                    getTotalExtraItemListFieldBuilder();
                    getTotalRandomItemListFieldBuilder();
                    getCostItemListFieldBuilder();
                    getTotalReturnItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.combineCount_ = 0;
                if (this.resultItemListBuilder_ == null) {
                    this.resultItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.resultItemListBuilder_.clear();
                }
                this.avatarGuid_ = 0;
                if (this.totalExtraItemListBuilder_ == null) {
                    this.totalExtraItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.totalExtraItemListBuilder_.clear();
                }
                this.retcode_ = 0;
                if (this.totalRandomItemListBuilder_ == null) {
                    this.totalRandomItemList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.totalRandomItemListBuilder_.clear();
                }
                this.combineId_ = 0;
                if (this.costItemListBuilder_ == null) {
                    this.costItemList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.costItemListBuilder_.clear();
                }
                if (this.totalReturnItemListBuilder_ == null) {
                    this.totalReturnItemList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.totalReturnItemListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CombineRspOuterClass.internal_static_CombineRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CombineRsp getDefaultInstanceForType() {
                return CombineRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineRsp build() {
                CombineRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombineRsp buildPartial() {
                CombineRsp result = new CombineRsp(this);
                int i = this.bitField0_;
                result.combineCount_ = this.combineCount_;
                if (this.resultItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.resultItemList_ = Collections.unmodifiableList(this.resultItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.resultItemList_ = this.resultItemList_;
                } else {
                    result.resultItemList_ = this.resultItemListBuilder_.build();
                }
                result.avatarGuid_ = this.avatarGuid_;
                if (this.totalExtraItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.totalExtraItemList_ = Collections.unmodifiableList(this.totalExtraItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.totalExtraItemList_ = this.totalExtraItemList_;
                } else {
                    result.totalExtraItemList_ = this.totalExtraItemListBuilder_.build();
                }
                result.retcode_ = this.retcode_;
                if (this.totalRandomItemListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.totalRandomItemList_ = Collections.unmodifiableList(this.totalRandomItemList_);
                        this.bitField0_ &= -5;
                    }
                    result.totalRandomItemList_ = this.totalRandomItemList_;
                } else {
                    result.totalRandomItemList_ = this.totalRandomItemListBuilder_.build();
                }
                result.combineId_ = this.combineId_;
                if (this.costItemListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.costItemList_ = Collections.unmodifiableList(this.costItemList_);
                        this.bitField0_ &= -9;
                    }
                    result.costItemList_ = this.costItemList_;
                } else {
                    result.costItemList_ = this.costItemListBuilder_.build();
                }
                if (this.totalReturnItemListBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.totalReturnItemList_ = Collections.unmodifiableList(this.totalReturnItemList_);
                        this.bitField0_ &= -17;
                    }
                    result.totalReturnItemList_ = this.totalReturnItemList_;
                } else {
                    result.totalReturnItemList_ = this.totalReturnItemListBuilder_.build();
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
                if (other instanceof CombineRsp) {
                    return mergeFrom((CombineRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CombineRsp other) {
                if (other == CombineRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getCombineCount() != 0) {
                    setCombineCount(other.getCombineCount());
                }
                if (this.resultItemListBuilder_ == null) {
                    if (!other.resultItemList_.isEmpty()) {
                        if (this.resultItemList_.isEmpty()) {
                            this.resultItemList_ = other.resultItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureResultItemListIsMutable();
                            this.resultItemList_.addAll(other.resultItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.resultItemList_.isEmpty()) {
                    if (this.resultItemListBuilder_.isEmpty()) {
                        this.resultItemListBuilder_.dispose();
                        this.resultItemListBuilder_ = null;
                        this.resultItemList_ = other.resultItemList_;
                        this.bitField0_ &= -2;
                        this.resultItemListBuilder_ = CombineRsp.alwaysUseFieldBuilders ? getResultItemListFieldBuilder() : null;
                    } else {
                        this.resultItemListBuilder_.addAllMessages(other.resultItemList_);
                    }
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (this.totalExtraItemListBuilder_ == null) {
                    if (!other.totalExtraItemList_.isEmpty()) {
                        if (this.totalExtraItemList_.isEmpty()) {
                            this.totalExtraItemList_ = other.totalExtraItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureTotalExtraItemListIsMutable();
                            this.totalExtraItemList_.addAll(other.totalExtraItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.totalExtraItemList_.isEmpty()) {
                    if (this.totalExtraItemListBuilder_.isEmpty()) {
                        this.totalExtraItemListBuilder_.dispose();
                        this.totalExtraItemListBuilder_ = null;
                        this.totalExtraItemList_ = other.totalExtraItemList_;
                        this.bitField0_ &= -3;
                        this.totalExtraItemListBuilder_ = CombineRsp.alwaysUseFieldBuilders ? getTotalExtraItemListFieldBuilder() : null;
                    } else {
                        this.totalExtraItemListBuilder_.addAllMessages(other.totalExtraItemList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.totalRandomItemListBuilder_ == null) {
                    if (!other.totalRandomItemList_.isEmpty()) {
                        if (this.totalRandomItemList_.isEmpty()) {
                            this.totalRandomItemList_ = other.totalRandomItemList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureTotalRandomItemListIsMutable();
                            this.totalRandomItemList_.addAll(other.totalRandomItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.totalRandomItemList_.isEmpty()) {
                    if (this.totalRandomItemListBuilder_.isEmpty()) {
                        this.totalRandomItemListBuilder_.dispose();
                        this.totalRandomItemListBuilder_ = null;
                        this.totalRandomItemList_ = other.totalRandomItemList_;
                        this.bitField0_ &= -5;
                        this.totalRandomItemListBuilder_ = CombineRsp.alwaysUseFieldBuilders ? getTotalRandomItemListFieldBuilder() : null;
                    } else {
                        this.totalRandomItemListBuilder_.addAllMessages(other.totalRandomItemList_);
                    }
                }
                if (other.getCombineId() != 0) {
                    setCombineId(other.getCombineId());
                }
                if (this.costItemListBuilder_ == null) {
                    if (!other.costItemList_.isEmpty()) {
                        if (this.costItemList_.isEmpty()) {
                            this.costItemList_ = other.costItemList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureCostItemListIsMutable();
                            this.costItemList_.addAll(other.costItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.costItemList_.isEmpty()) {
                    if (this.costItemListBuilder_.isEmpty()) {
                        this.costItemListBuilder_.dispose();
                        this.costItemListBuilder_ = null;
                        this.costItemList_ = other.costItemList_;
                        this.bitField0_ &= -9;
                        this.costItemListBuilder_ = CombineRsp.alwaysUseFieldBuilders ? getCostItemListFieldBuilder() : null;
                    } else {
                        this.costItemListBuilder_.addAllMessages(other.costItemList_);
                    }
                }
                if (this.totalReturnItemListBuilder_ == null) {
                    if (!other.totalReturnItemList_.isEmpty()) {
                        if (this.totalReturnItemList_.isEmpty()) {
                            this.totalReturnItemList_ = other.totalReturnItemList_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureTotalReturnItemListIsMutable();
                            this.totalReturnItemList_.addAll(other.totalReturnItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.totalReturnItemList_.isEmpty()) {
                    if (this.totalReturnItemListBuilder_.isEmpty()) {
                        this.totalReturnItemListBuilder_.dispose();
                        this.totalReturnItemListBuilder_ = null;
                        this.totalReturnItemList_ = other.totalReturnItemList_;
                        this.bitField0_ &= -17;
                        this.totalReturnItemListBuilder_ = CombineRsp.alwaysUseFieldBuilders ? getTotalReturnItemListFieldBuilder() : null;
                    } else {
                        this.totalReturnItemListBuilder_.addAllMessages(other.totalReturnItemList_);
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
                CombineRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = CombineRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CombineRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getCombineCount() {
                return this.combineCount_;
            }

            public Builder setCombineCount(int value) {
                this.combineCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombineCount() {
                this.combineCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureResultItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.resultItemList_ = new ArrayList(this.resultItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getResultItemListList() {
                if (this.resultItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.resultItemList_);
                }
                return this.resultItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getResultItemListCount() {
                if (this.resultItemListBuilder_ == null) {
                    return this.resultItemList_.size();
                }
                return this.resultItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParam getResultItemList(int index) {
                if (this.resultItemListBuilder_ == null) {
                    return this.resultItemList_.get(index);
                }
                return this.resultItemListBuilder_.getMessage(index);
            }

            public Builder setResultItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.resultItemListBuilder_ != null) {
                    this.resultItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setResultItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.resultItemListBuilder_ == null) {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addResultItemList(ItemParamOuterClass.ItemParam value) {
                if (this.resultItemListBuilder_ != null) {
                    this.resultItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addResultItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.resultItemListBuilder_ != null) {
                    this.resultItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addResultItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.resultItemListBuilder_ == null) {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.resultItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addResultItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.resultItemListBuilder_ == null) {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.resultItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllResultItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.resultItemListBuilder_ == null) {
                    ensureResultItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.resultItemList_);
                    onChanged();
                } else {
                    this.resultItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearResultItemList() {
                if (this.resultItemListBuilder_ == null) {
                    this.resultItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.resultItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeResultItemList(int index) {
                if (this.resultItemListBuilder_ == null) {
                    ensureResultItemListIsMutable();
                    this.resultItemList_.remove(index);
                    onChanged();
                } else {
                    this.resultItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getResultItemListBuilder(int index) {
                return getResultItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getResultItemListOrBuilder(int index) {
                if (this.resultItemListBuilder_ == null) {
                    return this.resultItemList_.get(index);
                }
                return this.resultItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getResultItemListOrBuilderList() {
                if (this.resultItemListBuilder_ != null) {
                    return this.resultItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.resultItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addResultItemListBuilder() {
                return getResultItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addResultItemListBuilder(int index) {
                return getResultItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getResultItemListBuilderList() {
                return getResultItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getResultItemListFieldBuilder() {
                if (this.resultItemListBuilder_ == null) {
                    this.resultItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.resultItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.resultItemList_ = null;
                }
                return this.resultItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            private void ensureTotalExtraItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.totalExtraItemList_ = new ArrayList(this.totalExtraItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getTotalExtraItemListList() {
                if (this.totalExtraItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.totalExtraItemList_);
                }
                return this.totalExtraItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getTotalExtraItemListCount() {
                if (this.totalExtraItemListBuilder_ == null) {
                    return this.totalExtraItemList_.size();
                }
                return this.totalExtraItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParam getTotalExtraItemList(int index) {
                if (this.totalExtraItemListBuilder_ == null) {
                    return this.totalExtraItemList_.get(index);
                }
                return this.totalExtraItemListBuilder_.getMessage(index);
            }

            public Builder setTotalExtraItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.totalExtraItemListBuilder_ != null) {
                    this.totalExtraItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTotalExtraItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalExtraItemListBuilder_ == null) {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.totalExtraItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTotalExtraItemList(ItemParamOuterClass.ItemParam value) {
                if (this.totalExtraItemListBuilder_ != null) {
                    this.totalExtraItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTotalExtraItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.totalExtraItemListBuilder_ != null) {
                    this.totalExtraItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTotalExtraItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalExtraItemListBuilder_ == null) {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.totalExtraItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTotalExtraItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalExtraItemListBuilder_ == null) {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.totalExtraItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTotalExtraItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.totalExtraItemListBuilder_ == null) {
                    ensureTotalExtraItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.totalExtraItemList_);
                    onChanged();
                } else {
                    this.totalExtraItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTotalExtraItemList() {
                if (this.totalExtraItemListBuilder_ == null) {
                    this.totalExtraItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.totalExtraItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTotalExtraItemList(int index) {
                if (this.totalExtraItemListBuilder_ == null) {
                    ensureTotalExtraItemListIsMutable();
                    this.totalExtraItemList_.remove(index);
                    onChanged();
                } else {
                    this.totalExtraItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getTotalExtraItemListBuilder(int index) {
                return getTotalExtraItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getTotalExtraItemListOrBuilder(int index) {
                if (this.totalExtraItemListBuilder_ == null) {
                    return this.totalExtraItemList_.get(index);
                }
                return this.totalExtraItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalExtraItemListOrBuilderList() {
                if (this.totalExtraItemListBuilder_ != null) {
                    return this.totalExtraItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.totalExtraItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addTotalExtraItemListBuilder() {
                return getTotalExtraItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addTotalExtraItemListBuilder(int index) {
                return getTotalExtraItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getTotalExtraItemListBuilderList() {
                return getTotalExtraItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getTotalExtraItemListFieldBuilder() {
                if (this.totalExtraItemListBuilder_ == null) {
                    this.totalExtraItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.totalExtraItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.totalExtraItemList_ = null;
                }
                return this.totalExtraItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
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

            private void ensureTotalRandomItemListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.totalRandomItemList_ = new ArrayList(this.totalRandomItemList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getTotalRandomItemListList() {
                if (this.totalRandomItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.totalRandomItemList_);
                }
                return this.totalRandomItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getTotalRandomItemListCount() {
                if (this.totalRandomItemListBuilder_ == null) {
                    return this.totalRandomItemList_.size();
                }
                return this.totalRandomItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParam getTotalRandomItemList(int index) {
                if (this.totalRandomItemListBuilder_ == null) {
                    return this.totalRandomItemList_.get(index);
                }
                return this.totalRandomItemListBuilder_.getMessage(index);
            }

            public Builder setTotalRandomItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.totalRandomItemListBuilder_ != null) {
                    this.totalRandomItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTotalRandomItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalRandomItemListBuilder_ == null) {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.totalRandomItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTotalRandomItemList(ItemParamOuterClass.ItemParam value) {
                if (this.totalRandomItemListBuilder_ != null) {
                    this.totalRandomItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTotalRandomItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.totalRandomItemListBuilder_ != null) {
                    this.totalRandomItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTotalRandomItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalRandomItemListBuilder_ == null) {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.totalRandomItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTotalRandomItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalRandomItemListBuilder_ == null) {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.totalRandomItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTotalRandomItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.totalRandomItemListBuilder_ == null) {
                    ensureTotalRandomItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.totalRandomItemList_);
                    onChanged();
                } else {
                    this.totalRandomItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTotalRandomItemList() {
                if (this.totalRandomItemListBuilder_ == null) {
                    this.totalRandomItemList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.totalRandomItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTotalRandomItemList(int index) {
                if (this.totalRandomItemListBuilder_ == null) {
                    ensureTotalRandomItemListIsMutable();
                    this.totalRandomItemList_.remove(index);
                    onChanged();
                } else {
                    this.totalRandomItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getTotalRandomItemListBuilder(int index) {
                return getTotalRandomItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getTotalRandomItemListOrBuilder(int index) {
                if (this.totalRandomItemListBuilder_ == null) {
                    return this.totalRandomItemList_.get(index);
                }
                return this.totalRandomItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalRandomItemListOrBuilderList() {
                if (this.totalRandomItemListBuilder_ != null) {
                    return this.totalRandomItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.totalRandomItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addTotalRandomItemListBuilder() {
                return getTotalRandomItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addTotalRandomItemListBuilder(int index) {
                return getTotalRandomItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getTotalRandomItemListBuilderList() {
                return getTotalRandomItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getTotalRandomItemListFieldBuilder() {
                if (this.totalRandomItemListBuilder_ == null) {
                    this.totalRandomItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.totalRandomItemList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.totalRandomItemList_ = null;
                }
                return this.totalRandomItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getCombineId() {
                return this.combineId_;
            }

            public Builder setCombineId(int value) {
                this.combineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombineId() {
                this.combineId_ = 0;
                onChanged();
                return this;
            }

            private void ensureCostItemListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.costItemList_ = new ArrayList(this.costItemList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getCostItemListList() {
                if (this.costItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.costItemList_);
                }
                return this.costItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getCostItemListCount() {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.size();
                }
                return this.costItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParam getCostItemList(int index) {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.get(index);
                }
                return this.costItemListBuilder_.getMessage(index);
            }

            public Builder setCostItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.costItemListBuilder_ != null) {
                    this.costItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCostItemListIsMutable();
                    this.costItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCostItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.costItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCostItemList(ItemParamOuterClass.ItemParam value) {
                if (this.costItemListBuilder_ != null) {
                    this.costItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCostItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.costItemListBuilder_ != null) {
                    this.costItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCostItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.costItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCostItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.costItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCostItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.costItemList_);
                    onChanged();
                } else {
                    this.costItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCostItemList() {
                if (this.costItemListBuilder_ == null) {
                    this.costItemList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.costItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCostItemList(int index) {
                if (this.costItemListBuilder_ == null) {
                    ensureCostItemListIsMutable();
                    this.costItemList_.remove(index);
                    onChanged();
                } else {
                    this.costItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getCostItemListBuilder(int index) {
                return getCostItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getCostItemListOrBuilder(int index) {
                if (this.costItemListBuilder_ == null) {
                    return this.costItemList_.get(index);
                }
                return this.costItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getCostItemListOrBuilderList() {
                if (this.costItemListBuilder_ != null) {
                    return this.costItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.costItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addCostItemListBuilder() {
                return getCostItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addCostItemListBuilder(int index) {
                return getCostItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getCostItemListBuilderList() {
                return getCostItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getCostItemListFieldBuilder() {
                if (this.costItemListBuilder_ == null) {
                    this.costItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.costItemList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.costItemList_ = null;
                }
                return this.costItemListBuilder_;
            }

            private void ensureTotalReturnItemListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.totalReturnItemList_ = new ArrayList(this.totalReturnItemList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getTotalReturnItemListList() {
                if (this.totalReturnItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.totalReturnItemList_);
                }
                return this.totalReturnItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public int getTotalReturnItemListCount() {
                if (this.totalReturnItemListBuilder_ == null) {
                    return this.totalReturnItemList_.size();
                }
                return this.totalReturnItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParam getTotalReturnItemList(int index) {
                if (this.totalReturnItemListBuilder_ == null) {
                    return this.totalReturnItemList_.get(index);
                }
                return this.totalReturnItemListBuilder_.getMessage(index);
            }

            public Builder setTotalReturnItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.totalReturnItemListBuilder_ != null) {
                    this.totalReturnItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTotalReturnItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalReturnItemListBuilder_ == null) {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.totalReturnItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTotalReturnItemList(ItemParamOuterClass.ItemParam value) {
                if (this.totalReturnItemListBuilder_ != null) {
                    this.totalReturnItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTotalReturnItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.totalReturnItemListBuilder_ != null) {
                    this.totalReturnItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTotalReturnItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalReturnItemListBuilder_ == null) {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.totalReturnItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTotalReturnItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.totalReturnItemListBuilder_ == null) {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.totalReturnItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTotalReturnItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.totalReturnItemListBuilder_ == null) {
                    ensureTotalReturnItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.totalReturnItemList_);
                    onChanged();
                } else {
                    this.totalReturnItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTotalReturnItemList() {
                if (this.totalReturnItemListBuilder_ == null) {
                    this.totalReturnItemList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.totalReturnItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTotalReturnItemList(int index) {
                if (this.totalReturnItemListBuilder_ == null) {
                    ensureTotalReturnItemListIsMutable();
                    this.totalReturnItemList_.remove(index);
                    onChanged();
                } else {
                    this.totalReturnItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getTotalReturnItemListBuilder(int index) {
                return getTotalReturnItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getTotalReturnItemListOrBuilder(int index) {
                if (this.totalReturnItemListBuilder_ == null) {
                    return this.totalReturnItemList_.get(index);
                }
                return this.totalReturnItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombineRspOuterClass.CombineRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getTotalReturnItemListOrBuilderList() {
                if (this.totalReturnItemListBuilder_ != null) {
                    return this.totalReturnItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.totalReturnItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addTotalReturnItemListBuilder() {
                return getTotalReturnItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addTotalReturnItemListBuilder(int index) {
                return getTotalReturnItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getTotalReturnItemListBuilderList() {
                return getTotalReturnItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getTotalReturnItemListFieldBuilder() {
                if (this.totalReturnItemListBuilder_ == null) {
                    this.totalReturnItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.totalReturnItemList_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.totalReturnItemList_ = null;
                }
                return this.totalReturnItemListBuilder_;
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

        public static CombineRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CombineRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CombineRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CombineRsp getDefaultInstanceForType() {
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
