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
import emu.grasscutter.net.proto.ForgeQueueManipulateTypeOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateRspOuterClass.class */
public final class ForgeQueueManipulateRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dForgeQueueManipulateRsp.proto\u001a\u001eForgeQueueManipulateType.proto\u001a\u000fItemParam.proto\"Ö\u0001\n\u0017ForgeQueueManipulateRsp\u0012*\n\u0016extra_output_item_list\u0018\u0003 \u0003(\u000b2\n.ItemParam\u00122\n\u000fmanipulate_type\u0018\f \u0001(\u000e2\u0019.ForgeQueueManipulateType\u0012$\n\u0010return_item_list\u0018\u0004 \u0003(\u000b2\n.ItemParam\u0012$\n\u0010output_item_list\u0018\u000e \u0003(\u000b2\n.ItemParam\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ForgeQueueManipulateTypeOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ForgeQueueManipulateRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ForgeQueueManipulateRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ForgeQueueManipulateRsp_descriptor, new String[]{"ExtraOutputItemList", "ManipulateType", "ReturnItemList", "OutputItemList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateRspOuterClass$ForgeQueueManipulateRspOrBuilder.class */
    public interface ForgeQueueManipulateRspOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getExtraOutputItemListList();

        ItemParamOuterClass.ItemParam getExtraOutputItemList(int i);

        int getExtraOutputItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraOutputItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getExtraOutputItemListOrBuilder(int i);

        int getManipulateTypeValue();

        ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType getManipulateType();

        List<ItemParamOuterClass.ItemParam> getReturnItemListList();

        ItemParamOuterClass.ItemParam getReturnItemList(int i);

        int getReturnItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getReturnItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getReturnItemListOrBuilder(int i);

        List<ItemParamOuterClass.ItemParam> getOutputItemListList();

        ItemParamOuterClass.ItemParam getOutputItemList(int i);

        int getOutputItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getOutputItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getOutputItemListOrBuilder(int i);

        int getRetcode();
    }

    private ForgeQueueManipulateRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateRspOuterClass$ForgeQueueManipulateRsp.class */
    public static final class ForgeQueueManipulateRsp extends GeneratedMessageV3 implements ForgeQueueManipulateRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXTRA_OUTPUT_ITEM_LIST_FIELD_NUMBER = 3;
        private List<ItemParamOuterClass.ItemParam> extraOutputItemList_;
        public static final int MANIPULATE_TYPE_FIELD_NUMBER = 12;
        private int manipulateType_;
        public static final int RETURN_ITEM_LIST_FIELD_NUMBER = 4;
        private List<ItemParamOuterClass.ItemParam> returnItemList_;
        public static final int OUTPUT_ITEM_LIST_FIELD_NUMBER = 14;
        private List<ItemParamOuterClass.ItemParam> outputItemList_;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final ForgeQueueManipulateRsp DEFAULT_INSTANCE = new ForgeQueueManipulateRsp();
        private static final Parser<ForgeQueueManipulateRsp> PARSER = new AbstractParser<ForgeQueueManipulateRsp>() { // from class: emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRsp.1
            @Override // com.google.protobuf.Parser
            public ForgeQueueManipulateRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ForgeQueueManipulateRsp(input, extensionRegistry);
            }
        };

        private ForgeQueueManipulateRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ForgeQueueManipulateRsp() {
            this.memoizedIsInitialized = -1;
            this.extraOutputItemList_ = Collections.emptyList();
            this.manipulateType_ = 0;
            this.returnItemList_ = Collections.emptyList();
            this.outputItemList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ForgeQueueManipulateRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x0117 */
        private ForgeQueueManipulateRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.extraOutputItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.extraOutputItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.returnItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.returnItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.retcode_ = input.readInt32();
                                break;
                            case 96:
                                this.manipulateType_ = input.readEnum();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.outputItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.outputItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.extraOutputItemList_ = Collections.unmodifiableList(this.extraOutputItemList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.returnItemList_ = Collections.unmodifiableList(this.returnItemList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.outputItemList_ = Collections.unmodifiableList(this.outputItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ForgeQueueManipulateRspOuterClass.internal_static_ForgeQueueManipulateRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ForgeQueueManipulateRspOuterClass.internal_static_ForgeQueueManipulateRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueManipulateRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getExtraOutputItemListList() {
            return this.extraOutputItemList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraOutputItemListOrBuilderList() {
            return this.extraOutputItemList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public int getExtraOutputItemListCount() {
            return this.extraOutputItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ItemParamOuterClass.ItemParam getExtraOutputItemList(int index) {
            return this.extraOutputItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getExtraOutputItemListOrBuilder(int index) {
            return this.extraOutputItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public int getManipulateTypeValue() {
            return this.manipulateType_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType getManipulateType() {
            ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType result = ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.valueOf(this.manipulateType_);
            return result == null ? ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getReturnItemListList() {
            return this.returnItemList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getReturnItemListOrBuilderList() {
            return this.returnItemList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public int getReturnItemListCount() {
            return this.returnItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ItemParamOuterClass.ItemParam getReturnItemList(int index) {
            return this.returnItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getReturnItemListOrBuilder(int index) {
            return this.returnItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getOutputItemListList() {
            return this.outputItemList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getOutputItemListOrBuilderList() {
            return this.outputItemList_;
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public int getOutputItemListCount() {
            return this.outputItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ItemParamOuterClass.ItemParam getOutputItemList(int index) {
            return this.outputItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getOutputItemListOrBuilder(int index) {
            return this.outputItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
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
            for (int i = 0; i < this.extraOutputItemList_.size(); i++) {
                output.writeMessage(3, this.extraOutputItemList_.get(i));
            }
            for (int i2 = 0; i2 < this.returnItemList_.size(); i2++) {
                output.writeMessage(4, this.returnItemList_.get(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            if (this.manipulateType_ != ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT.getNumber()) {
                output.writeEnum(12, this.manipulateType_);
            }
            for (int i3 = 0; i3 < this.outputItemList_.size(); i3++) {
                output.writeMessage(14, this.outputItemList_.get(i3));
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
            for (int i = 0; i < this.extraOutputItemList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.extraOutputItemList_.get(i));
            }
            for (int i2 = 0; i2 < this.returnItemList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.returnItemList_.get(i2));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            if (this.manipulateType_ != ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.manipulateType_);
            }
            for (int i3 = 0; i3 < this.outputItemList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.outputItemList_.get(i3));
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
            if (!(obj instanceof ForgeQueueManipulateRsp)) {
                return equals(obj);
            }
            ForgeQueueManipulateRsp other = (ForgeQueueManipulateRsp) obj;
            return getExtraOutputItemListList().equals(other.getExtraOutputItemListList()) && this.manipulateType_ == other.manipulateType_ && getReturnItemListList().equals(other.getReturnItemListList()) && getOutputItemListList().equals(other.getOutputItemListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getExtraOutputItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getExtraOutputItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 12)) + this.manipulateType_;
            if (getReturnItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 4)) + getReturnItemListList().hashCode();
            }
            if (getOutputItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getOutputItemListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ForgeQueueManipulateRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueManipulateRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueManipulateRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueManipulateRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueManipulateRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ForgeQueueManipulateRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ForgeQueueManipulateRsp parseFrom(InputStream input) throws IOException {
            return (ForgeQueueManipulateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueManipulateRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueManipulateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueManipulateRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ForgeQueueManipulateRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ForgeQueueManipulateRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueManipulateRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ForgeQueueManipulateRsp parseFrom(CodedInputStream input) throws IOException {
            return (ForgeQueueManipulateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ForgeQueueManipulateRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ForgeQueueManipulateRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ForgeQueueManipulateRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateRspOuterClass$ForgeQueueManipulateRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ForgeQueueManipulateRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> extraOutputItemListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> returnItemListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> outputItemListBuilder_;
            private int retcode_;
            private List<ItemParamOuterClass.ItemParam> extraOutputItemList_ = Collections.emptyList();
            private int manipulateType_ = 0;
            private List<ItemParamOuterClass.ItemParam> returnItemList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> outputItemList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ForgeQueueManipulateRspOuterClass.internal_static_ForgeQueueManipulateRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ForgeQueueManipulateRspOuterClass.internal_static_ForgeQueueManipulateRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ForgeQueueManipulateRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ForgeQueueManipulateRsp.alwaysUseFieldBuilders) {
                    getExtraOutputItemListFieldBuilder();
                    getReturnItemListFieldBuilder();
                    getOutputItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.extraOutputItemListBuilder_ == null) {
                    this.extraOutputItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.extraOutputItemListBuilder_.clear();
                }
                this.manipulateType_ = 0;
                if (this.returnItemListBuilder_ == null) {
                    this.returnItemList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.returnItemListBuilder_.clear();
                }
                if (this.outputItemListBuilder_ == null) {
                    this.outputItemList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.outputItemListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ForgeQueueManipulateRspOuterClass.internal_static_ForgeQueueManipulateRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ForgeQueueManipulateRsp getDefaultInstanceForType() {
                return ForgeQueueManipulateRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueManipulateRsp build() {
                ForgeQueueManipulateRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ForgeQueueManipulateRsp buildPartial() {
                ForgeQueueManipulateRsp result = new ForgeQueueManipulateRsp(this);
                int i = this.bitField0_;
                if (this.extraOutputItemListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.extraOutputItemList_ = Collections.unmodifiableList(this.extraOutputItemList_);
                        this.bitField0_ &= -2;
                    }
                    result.extraOutputItemList_ = this.extraOutputItemList_;
                } else {
                    result.extraOutputItemList_ = this.extraOutputItemListBuilder_.build();
                }
                result.manipulateType_ = this.manipulateType_;
                if (this.returnItemListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.returnItemList_ = Collections.unmodifiableList(this.returnItemList_);
                        this.bitField0_ &= -3;
                    }
                    result.returnItemList_ = this.returnItemList_;
                } else {
                    result.returnItemList_ = this.returnItemListBuilder_.build();
                }
                if (this.outputItemListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.outputItemList_ = Collections.unmodifiableList(this.outputItemList_);
                        this.bitField0_ &= -5;
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
                if (other instanceof ForgeQueueManipulateRsp) {
                    return mergeFrom((ForgeQueueManipulateRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ForgeQueueManipulateRsp other) {
                if (other == ForgeQueueManipulateRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.extraOutputItemListBuilder_ == null) {
                    if (!other.extraOutputItemList_.isEmpty()) {
                        if (this.extraOutputItemList_.isEmpty()) {
                            this.extraOutputItemList_ = other.extraOutputItemList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureExtraOutputItemListIsMutable();
                            this.extraOutputItemList_.addAll(other.extraOutputItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.extraOutputItemList_.isEmpty()) {
                    if (this.extraOutputItemListBuilder_.isEmpty()) {
                        this.extraOutputItemListBuilder_.dispose();
                        this.extraOutputItemListBuilder_ = null;
                        this.extraOutputItemList_ = other.extraOutputItemList_;
                        this.bitField0_ &= -2;
                        this.extraOutputItemListBuilder_ = ForgeQueueManipulateRsp.alwaysUseFieldBuilders ? getExtraOutputItemListFieldBuilder() : null;
                    } else {
                        this.extraOutputItemListBuilder_.addAllMessages(other.extraOutputItemList_);
                    }
                }
                if (other.manipulateType_ != 0) {
                    setManipulateTypeValue(other.getManipulateTypeValue());
                }
                if (this.returnItemListBuilder_ == null) {
                    if (!other.returnItemList_.isEmpty()) {
                        if (this.returnItemList_.isEmpty()) {
                            this.returnItemList_ = other.returnItemList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.returnItemListBuilder_ = ForgeQueueManipulateRsp.alwaysUseFieldBuilders ? getReturnItemListFieldBuilder() : null;
                    } else {
                        this.returnItemListBuilder_.addAllMessages(other.returnItemList_);
                    }
                }
                if (this.outputItemListBuilder_ == null) {
                    if (!other.outputItemList_.isEmpty()) {
                        if (this.outputItemList_.isEmpty()) {
                            this.outputItemList_ = other.outputItemList_;
                            this.bitField0_ &= -5;
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
                        this.bitField0_ &= -5;
                        this.outputItemListBuilder_ = ForgeQueueManipulateRsp.alwaysUseFieldBuilders ? getOutputItemListFieldBuilder() : null;
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
                ForgeQueueManipulateRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ForgeQueueManipulateRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ForgeQueueManipulateRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureExtraOutputItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.extraOutputItemList_ = new ArrayList(this.extraOutputItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getExtraOutputItemListList() {
                if (this.extraOutputItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.extraOutputItemList_);
                }
                return this.extraOutputItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public int getExtraOutputItemListCount() {
                if (this.extraOutputItemListBuilder_ == null) {
                    return this.extraOutputItemList_.size();
                }
                return this.extraOutputItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public ItemParamOuterClass.ItemParam getExtraOutputItemList(int index) {
                if (this.extraOutputItemListBuilder_ == null) {
                    return this.extraOutputItemList_.get(index);
                }
                return this.extraOutputItemListBuilder_.getMessage(index);
            }

            public Builder setExtraOutputItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.extraOutputItemListBuilder_ != null) {
                    this.extraOutputItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtraOutputItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraOutputItemListBuilder_ == null) {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraOutputItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtraOutputItemList(ItemParamOuterClass.ItemParam value) {
                if (this.extraOutputItemListBuilder_ != null) {
                    this.extraOutputItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraOutputItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.extraOutputItemListBuilder_ != null) {
                    this.extraOutputItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraOutputItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraOutputItemListBuilder_ == null) {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extraOutputItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtraOutputItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.extraOutputItemListBuilder_ == null) {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraOutputItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtraOutputItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.extraOutputItemListBuilder_ == null) {
                    ensureExtraOutputItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.extraOutputItemList_);
                    onChanged();
                } else {
                    this.extraOutputItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtraOutputItemList() {
                if (this.extraOutputItemListBuilder_ == null) {
                    this.extraOutputItemList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.extraOutputItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtraOutputItemList(int index) {
                if (this.extraOutputItemListBuilder_ == null) {
                    ensureExtraOutputItemListIsMutable();
                    this.extraOutputItemList_.remove(index);
                    onChanged();
                } else {
                    this.extraOutputItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getExtraOutputItemListBuilder(int index) {
                return getExtraOutputItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getExtraOutputItemListOrBuilder(int index) {
                if (this.extraOutputItemListBuilder_ == null) {
                    return this.extraOutputItemList_.get(index);
                }
                return this.extraOutputItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getExtraOutputItemListOrBuilderList() {
                if (this.extraOutputItemListBuilder_ != null) {
                    return this.extraOutputItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extraOutputItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addExtraOutputItemListBuilder() {
                return getExtraOutputItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addExtraOutputItemListBuilder(int index) {
                return getExtraOutputItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getExtraOutputItemListBuilderList() {
                return getExtraOutputItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getExtraOutputItemListFieldBuilder() {
                if (this.extraOutputItemListBuilder_ == null) {
                    this.extraOutputItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.extraOutputItemList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.extraOutputItemList_ = null;
                }
                return this.extraOutputItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public int getManipulateTypeValue() {
                return this.manipulateType_;
            }

            public Builder setManipulateTypeValue(int value) {
                this.manipulateType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType getManipulateType() {
                ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType result = ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.valueOf(this.manipulateType_);
                return result == null ? ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.UNRECOGNIZED : result;
            }

            public Builder setManipulateType(ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.manipulateType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearManipulateType() {
                this.manipulateType_ = 0;
                onChanged();
                return this;
            }

            private void ensureReturnItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.returnItemList_ = new ArrayList(this.returnItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getReturnItemListList() {
                if (this.returnItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.returnItemList_);
                }
                return this.returnItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public int getReturnItemListCount() {
                if (this.returnItemListBuilder_ == null) {
                    return this.returnItemList_.size();
                }
                return this.returnItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getReturnItemListOrBuilder(int index) {
                if (this.returnItemListBuilder_ == null) {
                    return this.returnItemList_.get(index);
                }
                return this.returnItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
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
                    this.returnItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.returnItemList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.returnItemList_ = null;
                }
                return this.returnItemListBuilder_;
            }

            private void ensureOutputItemListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.outputItemList_ = new ArrayList(this.outputItemList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getOutputItemListList() {
                if (this.outputItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.outputItemList_);
                }
                return this.outputItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public int getOutputItemListCount() {
                if (this.outputItemListBuilder_ == null) {
                    return this.outputItemList_.size();
                }
                return this.outputItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
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
                    this.bitField0_ &= -5;
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

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getOutputItemListOrBuilder(int index) {
                if (this.outputItemListBuilder_ == null) {
                    return this.outputItemList_.get(index);
                }
                return this.outputItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
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
                    this.outputItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.outputItemList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.outputItemList_ = null;
                }
                return this.outputItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRspOrBuilder
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

        public static ForgeQueueManipulateRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ForgeQueueManipulateRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ForgeQueueManipulateRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ForgeQueueManipulateRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ForgeQueueManipulateTypeOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
