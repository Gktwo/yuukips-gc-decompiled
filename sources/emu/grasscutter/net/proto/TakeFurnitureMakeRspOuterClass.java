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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeRspOuterClass.class */
public final class TakeFurnitureMakeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aTakeFurnitureMakeRsp.proto\u001a\u0017FurnitureMakeSlot.proto\u001a\u000fItemParam.proto\"®\u0001\n\u0014TakeFurnitureMakeRsp\u0012\"\n\u000ereturnItemList\u0018\u0007 \u0003(\u000b2\n.ItemParam\u0012-\n\u0011furnitureMakeSlot\u0018\u0006 \u0001(\u000b2\u0012.FurnitureMakeSlot\u0012\u000e\n\u0006makeId\u0018\u0004 \u0001(\r\u0012\"\n\u000eoutputItemList\u0018\u0001 \u0003(\u000b2\n.ItemParam\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FurnitureMakeSlotOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TakeFurnitureMakeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeFurnitureMakeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeFurnitureMakeRsp_descriptor, new String[]{"ReturnItemList", "FurnitureMakeSlot", "MakeId", "OutputItemList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeRspOuterClass$TakeFurnitureMakeRspOrBuilder.class */
    public interface TakeFurnitureMakeRspOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getReturnItemListList();

        ItemParamOuterClass.ItemParam getReturnItemList(int i);

        int getReturnItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getReturnItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getReturnItemListOrBuilder(int i);

        boolean hasFurnitureMakeSlot();

        FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot();

        FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder();

        int getMakeId();

        List<ItemParamOuterClass.ItemParam> getOutputItemListList();

        ItemParamOuterClass.ItemParam getOutputItemList(int i);

        int getOutputItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getOutputItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getOutputItemListOrBuilder(int i);

        int getRetcode();
    }

    private TakeFurnitureMakeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeRspOuterClass$TakeFurnitureMakeRsp.class */
    public static final class TakeFurnitureMakeRsp extends GeneratedMessageV3 implements TakeFurnitureMakeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETURNITEMLIST_FIELD_NUMBER = 7;
        private List<ItemParamOuterClass.ItemParam> returnItemList_;
        public static final int FURNITUREMAKESLOT_FIELD_NUMBER = 6;
        private FurnitureMakeSlotOuterClass.FurnitureMakeSlot furnitureMakeSlot_;
        public static final int MAKEID_FIELD_NUMBER = 4;
        private int makeId_;
        public static final int OUTPUTITEMLIST_FIELD_NUMBER = 1;
        private List<ItemParamOuterClass.ItemParam> outputItemList_;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TakeFurnitureMakeRsp DEFAULT_INSTANCE = new TakeFurnitureMakeRsp();
        private static final Parser<TakeFurnitureMakeRsp> PARSER = new AbstractParser<TakeFurnitureMakeRsp>() { // from class: emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRsp.1
            @Override // com.google.protobuf.Parser
            public TakeFurnitureMakeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeFurnitureMakeRsp(input, extensionRegistry);
            }
        };

        private TakeFurnitureMakeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeFurnitureMakeRsp() {
            this.memoizedIsInitialized = -1;
            this.returnItemList_ = Collections.emptyList();
            this.outputItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeFurnitureMakeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x0123 */
        private TakeFurnitureMakeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.outputItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.outputItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 32:
                                    this.makeId_ = input.readUInt32();
                                    break;
                                case 50:
                                    FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder subBuilder = this.furnitureMakeSlot_ != null ? this.furnitureMakeSlot_.toBuilder() : null;
                                    this.furnitureMakeSlot_ = (FurnitureMakeSlotOuterClass.FurnitureMakeSlot) input.readMessage(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.furnitureMakeSlot_);
                                        this.furnitureMakeSlot_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 58:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.returnItemList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.returnItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 80:
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
                    this.outputItemList_ = Collections.unmodifiableList(this.outputItemList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.returnItemList_ = Collections.unmodifiableList(this.returnItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeFurnitureMakeRspOuterClass.internal_static_TakeFurnitureMakeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeFurnitureMakeRspOuterClass.internal_static_TakeFurnitureMakeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeFurnitureMakeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getReturnItemListList() {
            return this.returnItemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getReturnItemListOrBuilderList() {
            return this.returnItemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public int getReturnItemListCount() {
            return this.returnItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public ItemParamOuterClass.ItemParam getReturnItemList(int index) {
            return this.returnItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getReturnItemListOrBuilder(int index) {
            return this.returnItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public boolean hasFurnitureMakeSlot() {
            return this.furnitureMakeSlot_ != null;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot() {
            return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder() {
            return getFurnitureMakeSlot();
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public int getMakeId() {
            return this.makeId_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getOutputItemListList() {
            return this.outputItemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getOutputItemListOrBuilderList() {
            return this.outputItemList_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public int getOutputItemListCount() {
            return this.outputItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public ItemParamOuterClass.ItemParam getOutputItemList(int index) {
            return this.outputItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getOutputItemListOrBuilder(int index) {
            return this.outputItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
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
            for (int i = 0; i < this.outputItemList_.size(); i++) {
                output.writeMessage(1, this.outputItemList_.get(i));
            }
            if (this.makeId_ != 0) {
                output.writeUInt32(4, this.makeId_);
            }
            if (this.furnitureMakeSlot_ != null) {
                output.writeMessage(6, getFurnitureMakeSlot());
            }
            for (int i2 = 0; i2 < this.returnItemList_.size(); i2++) {
                output.writeMessage(7, this.returnItemList_.get(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
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
            for (int i = 0; i < this.outputItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.outputItemList_.get(i));
            }
            if (this.makeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.makeId_);
            }
            if (this.furnitureMakeSlot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getFurnitureMakeSlot());
            }
            for (int i2 = 0; i2 < this.returnItemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.returnItemList_.get(i2));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
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
            if (!(obj instanceof TakeFurnitureMakeRsp)) {
                return equals(obj);
            }
            TakeFurnitureMakeRsp other = (TakeFurnitureMakeRsp) obj;
            if (getReturnItemListList().equals(other.getReturnItemListList()) && hasFurnitureMakeSlot() == other.hasFurnitureMakeSlot()) {
                return (!hasFurnitureMakeSlot() || getFurnitureMakeSlot().equals(other.getFurnitureMakeSlot())) && getMakeId() == other.getMakeId() && getOutputItemListList().equals(other.getOutputItemListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getReturnItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getReturnItemListList().hashCode();
            }
            if (hasFurnitureMakeSlot()) {
                hash = (53 * ((37 * hash) + 6)) + getFurnitureMakeSlot().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + getMakeId();
            if (getOutputItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getOutputItemListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 10)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static TakeFurnitureMakeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeFurnitureMakeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeFurnitureMakeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeFurnitureMakeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeFurnitureMakeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeFurnitureMakeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeFurnitureMakeRsp parseFrom(InputStream input) throws IOException {
            return (TakeFurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeFurnitureMakeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeFurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeFurnitureMakeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeFurnitureMakeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeFurnitureMakeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeFurnitureMakeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeFurnitureMakeRsp parseFrom(CodedInputStream input) throws IOException {
            return (TakeFurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeFurnitureMakeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeFurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeFurnitureMakeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeRspOuterClass$TakeFurnitureMakeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeFurnitureMakeRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> returnItemListBuilder_;
            private FurnitureMakeSlotOuterClass.FurnitureMakeSlot furnitureMakeSlot_;
            private SingleFieldBuilderV3<FurnitureMakeSlotOuterClass.FurnitureMakeSlot, FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder, FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder> furnitureMakeSlotBuilder_;
            private int makeId_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> outputItemListBuilder_;
            private int retcode_;
            private List<ItemParamOuterClass.ItemParam> returnItemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> outputItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeFurnitureMakeRspOuterClass.internal_static_TakeFurnitureMakeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeFurnitureMakeRspOuterClass.internal_static_TakeFurnitureMakeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeFurnitureMakeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeFurnitureMakeRsp.alwaysUseFieldBuilders) {
                    getReturnItemListFieldBuilder();
                    getOutputItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.returnItemListBuilder_ == null) {
                    this.returnItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.returnItemListBuilder_.clear();
                }
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = null;
                } else {
                    this.furnitureMakeSlot_ = null;
                    this.furnitureMakeSlotBuilder_ = null;
                }
                this.makeId_ = 0;
                if (this.outputItemListBuilder_ == null) {
                    this.outputItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.outputItemListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeFurnitureMakeRspOuterClass.internal_static_TakeFurnitureMakeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeFurnitureMakeRsp getDefaultInstanceForType() {
                return TakeFurnitureMakeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeFurnitureMakeRsp build() {
                TakeFurnitureMakeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeFurnitureMakeRsp buildPartial() {
                TakeFurnitureMakeRsp result = new TakeFurnitureMakeRsp(this);
                int i = this.bitField0_;
                if (this.returnItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.returnItemList_ = Collections.unmodifiableList(this.returnItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.returnItemList_ = this.returnItemList_;
                } else {
                    result.returnItemList_ = this.returnItemListBuilder_.build();
                }
                if (this.furnitureMakeSlotBuilder_ == null) {
                    result.furnitureMakeSlot_ = this.furnitureMakeSlot_;
                } else {
                    result.furnitureMakeSlot_ = this.furnitureMakeSlotBuilder_.build();
                }
                result.makeId_ = this.makeId_;
                if (this.outputItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.outputItemList_ = Collections.unmodifiableList(this.outputItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.outputItemList_ = this.outputItemList_;
                } else {
                    result.outputItemList_ = this.outputItemListBuilder_.build();
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
                if (other instanceof TakeFurnitureMakeRsp) {
                    return mergeFrom((TakeFurnitureMakeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeFurnitureMakeRsp other) {
                if (other == TakeFurnitureMakeRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.returnItemListBuilder_ == null) {
                    if (!other.returnItemList_.isEmpty()) {
                        if (this.returnItemList_.isEmpty()) {
                            this.returnItemList_ = other.returnItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureReturnItemListIsMutable();
                            this.returnItemList_.addAll(other.returnItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.returnItemList_.isEmpty()) {
                    if (this.returnItemListBuilder_.isEmpty()) {
                        this.returnItemListBuilder_.dispose();
                        this.returnItemListBuilder_ = null;
                        this.returnItemList_ = other.returnItemList_;
                        this.bitField0_ &= -2;
                        this.returnItemListBuilder_ = TakeFurnitureMakeRsp.alwaysUseFieldBuilders ? getReturnItemListFieldBuilder() : null;
                    } else {
                        this.returnItemListBuilder_.addAllMessages(other.returnItemList_);
                    }
                }
                if (other.hasFurnitureMakeSlot()) {
                    mergeFurnitureMakeSlot(other.getFurnitureMakeSlot());
                }
                if (other.getMakeId() != 0) {
                    setMakeId(other.getMakeId());
                }
                if (this.outputItemListBuilder_ == null) {
                    if (!other.outputItemList_.isEmpty()) {
                        if (this.outputItemList_.isEmpty()) {
                            this.outputItemList_ = other.outputItemList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureOutputItemListIsMutable();
                            this.outputItemList_.addAll(other.outputItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.outputItemList_.isEmpty()) {
                    if (this.outputItemListBuilder_.isEmpty()) {
                        this.outputItemListBuilder_.dispose();
                        this.outputItemListBuilder_ = null;
                        this.outputItemList_ = other.outputItemList_;
                        this.bitField0_ &= -3;
                        this.outputItemListBuilder_ = TakeFurnitureMakeRsp.alwaysUseFieldBuilders ? getOutputItemListFieldBuilder() : null;
                    } else {
                        this.outputItemListBuilder_.addAllMessages(other.outputItemList_);
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
                TakeFurnitureMakeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeFurnitureMakeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeFurnitureMakeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureReturnItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.returnItemList_ = new ArrayList(this.returnItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getReturnItemListList() {
                if (this.returnItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.returnItemList_);
                }
                return this.returnItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public int getReturnItemListCount() {
                if (this.returnItemListBuilder_ == null) {
                    return this.returnItemList_.size();
                }
                return this.returnItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public ItemParamOuterClass.ItemParam getReturnItemList(int index) {
                if (this.returnItemListBuilder_ == null) {
                    return this.returnItemList_.get(index);
                }
                return this.returnItemListBuilder_.getMessage(index);
            }

            public Builder setReturnItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.returnItemListBuilder_ != null) {
                    this.returnItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setReturnItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.returnItemListBuilder_ == null) {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.returnItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addReturnItemList(ItemParamOuterClass.ItemParam value) {
                if (this.returnItemListBuilder_ != null) {
                    this.returnItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addReturnItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.returnItemListBuilder_ != null) {
                    this.returnItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addReturnItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.returnItemListBuilder_ == null) {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.returnItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addReturnItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.returnItemListBuilder_ == null) {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.returnItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllReturnItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.returnItemListBuilder_ == null) {
                    ensureReturnItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.returnItemList_);
                    onChanged();
                } else {
                    this.returnItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearReturnItemList() {
                if (this.returnItemListBuilder_ == null) {
                    this.returnItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.returnItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeReturnItemList(int index) {
                if (this.returnItemListBuilder_ == null) {
                    ensureReturnItemListIsMutable();
                    this.returnItemList_.remove(index);
                    onChanged();
                } else {
                    this.returnItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getReturnItemListBuilder(int index) {
                return getReturnItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getReturnItemListOrBuilder(int index) {
                if (this.returnItemListBuilder_ == null) {
                    return this.returnItemList_.get(index);
                }
                return this.returnItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getReturnItemListOrBuilderList() {
                if (this.returnItemListBuilder_ != null) {
                    return this.returnItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.returnItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addReturnItemListBuilder() {
                return getReturnItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addReturnItemListBuilder(int index) {
                return getReturnItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getReturnItemListBuilderList() {
                return getReturnItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getReturnItemListFieldBuilder() {
                if (this.returnItemListBuilder_ == null) {
                    this.returnItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.returnItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.returnItemList_ = null;
                }
                return this.returnItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public boolean hasFurnitureMakeSlot() {
                return (this.furnitureMakeSlotBuilder_ == null && this.furnitureMakeSlot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
                }
                return this.furnitureMakeSlotBuilder_.getMessage();
            }

            public Builder setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot value) {
                if (this.furnitureMakeSlotBuilder_ != null) {
                    this.furnitureMakeSlotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.furnitureMakeSlot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder builderForValue) {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.furnitureMakeSlotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot value) {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    if (this.furnitureMakeSlot_ != null) {
                        this.furnitureMakeSlot_ = FurnitureMakeSlotOuterClass.FurnitureMakeSlot.newBuilder(this.furnitureMakeSlot_).mergeFrom(value).buildPartial();
                    } else {
                        this.furnitureMakeSlot_ = value;
                    }
                    onChanged();
                } else {
                    this.furnitureMakeSlotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFurnitureMakeSlot() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = null;
                    onChanged();
                } else {
                    this.furnitureMakeSlot_ = null;
                    this.furnitureMakeSlotBuilder_ = null;
                }
                return this;
            }

            public FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder getFurnitureMakeSlotBuilder() {
                onChanged();
                return getFurnitureMakeSlotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder() {
                if (this.furnitureMakeSlotBuilder_ != null) {
                    return this.furnitureMakeSlotBuilder_.getMessageOrBuilder();
                }
                return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
            }

            private SingleFieldBuilderV3<FurnitureMakeSlotOuterClass.FurnitureMakeSlot, FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder, FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder> getFurnitureMakeSlotFieldBuilder() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlotBuilder_ = new SingleFieldBuilderV3<>(getFurnitureMakeSlot(), getParentForChildren(), isClean());
                    this.furnitureMakeSlot_ = null;
                }
                return this.furnitureMakeSlotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public int getMakeId() {
                return this.makeId_;
            }

            public Builder setMakeId(int value) {
                this.makeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMakeId() {
                this.makeId_ = 0;
                onChanged();
                return this;
            }

            private void ensureOutputItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.outputItemList_ = new ArrayList(this.outputItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getOutputItemListList() {
                if (this.outputItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.outputItemList_);
                }
                return this.outputItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public int getOutputItemListCount() {
                if (this.outputItemListBuilder_ == null) {
                    return this.outputItemList_.size();
                }
                return this.outputItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public ItemParamOuterClass.ItemParam getOutputItemList(int index) {
                if (this.outputItemListBuilder_ == null) {
                    return this.outputItemList_.get(index);
                }
                return this.outputItemListBuilder_.getMessage(index);
            }

            public Builder setOutputItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.outputItemListBuilder_ != null) {
                    this.outputItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOutputItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.outputItemListBuilder_ == null) {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.outputItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOutputItemList(ItemParamOuterClass.ItemParam value) {
                if (this.outputItemListBuilder_ != null) {
                    this.outputItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOutputItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.outputItemListBuilder_ != null) {
                    this.outputItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOutputItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.outputItemListBuilder_ == null) {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.outputItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOutputItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.outputItemListBuilder_ == null) {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.outputItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOutputItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.outputItemListBuilder_ == null) {
                    ensureOutputItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.outputItemList_);
                    onChanged();
                } else {
                    this.outputItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOutputItemList() {
                if (this.outputItemListBuilder_ == null) {
                    this.outputItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.outputItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOutputItemList(int index) {
                if (this.outputItemListBuilder_ == null) {
                    ensureOutputItemListIsMutable();
                    this.outputItemList_.remove(index);
                    onChanged();
                } else {
                    this.outputItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getOutputItemListBuilder(int index) {
                return getOutputItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getOutputItemListOrBuilder(int index) {
                if (this.outputItemListBuilder_ == null) {
                    return this.outputItemList_.get(index);
                }
                return this.outputItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getOutputItemListOrBuilderList() {
                if (this.outputItemListBuilder_ != null) {
                    return this.outputItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.outputItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addOutputItemListBuilder() {
                return getOutputItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addOutputItemListBuilder(int index) {
                return getOutputItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getOutputItemListBuilderList() {
                return getOutputItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getOutputItemListFieldBuilder() {
                if (this.outputItemListBuilder_ == null) {
                    this.outputItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.outputItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.outputItemList_ = null;
                }
                return this.outputItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeRspOuterClass.TakeFurnitureMakeRspOrBuilder
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

        public static TakeFurnitureMakeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeFurnitureMakeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeFurnitureMakeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeFurnitureMakeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FurnitureMakeSlotOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
