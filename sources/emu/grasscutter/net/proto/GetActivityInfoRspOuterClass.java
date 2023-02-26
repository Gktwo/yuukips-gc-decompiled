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
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.Uint32PairOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoRspOuterClass.class */
public final class GetActivityInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018GetActivityInfoRsp.proto\u001a\u0012ActivityInfo.proto\u001a\u0010Uint32Pair.proto\"¥\u0001\n\u0012GetActivityInfoRsp\u0012'\n\u0010activityInfoList\u0018\r \u0003(\u000b2\r.ActivityInfo\u00128\n#disableTransferPointInteractionList\u0018\u0003 \u0003(\u000b2\u000b.Uint32Pair\u0012\u001b\n\u0013activatedSaleIdList\u0018\u0007 \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityInfoOuterClass.getDescriptor(), Uint32PairOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetActivityInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetActivityInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetActivityInfoRsp_descriptor, new String[]{"ActivityInfoList", "DisableTransferPointInteractionList", "ActivatedSaleIdList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoRspOuterClass$GetActivityInfoRspOrBuilder.class */
    public interface GetActivityInfoRspOrBuilder extends MessageOrBuilder {
        List<ActivityInfoOuterClass.ActivityInfo> getActivityInfoListList();

        ActivityInfoOuterClass.ActivityInfo getActivityInfoList(int i);

        int getActivityInfoListCount();

        List<? extends ActivityInfoOuterClass.ActivityInfoOrBuilder> getActivityInfoListOrBuilderList();

        ActivityInfoOuterClass.ActivityInfoOrBuilder getActivityInfoListOrBuilder(int i);

        List<Uint32PairOuterClass.Uint32Pair> getDisableTransferPointInteractionListList();

        Uint32PairOuterClass.Uint32Pair getDisableTransferPointInteractionList(int i);

        int getDisableTransferPointInteractionListCount();

        List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getDisableTransferPointInteractionListOrBuilderList();

        Uint32PairOuterClass.Uint32PairOrBuilder getDisableTransferPointInteractionListOrBuilder(int i);

        List<Integer> getActivatedSaleIdListList();

        int getActivatedSaleIdListCount();

        int getActivatedSaleIdList(int i);

        int getRetcode();
    }

    private GetActivityInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoRspOuterClass$GetActivityInfoRsp.class */
    public static final class GetActivityInfoRsp extends GeneratedMessageV3 implements GetActivityInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITYINFOLIST_FIELD_NUMBER = 13;
        private List<ActivityInfoOuterClass.ActivityInfo> activityInfoList_;
        public static final int DISABLETRANSFERPOINTINTERACTIONLIST_FIELD_NUMBER = 3;
        private List<Uint32PairOuterClass.Uint32Pair> disableTransferPointInteractionList_;
        public static final int ACTIVATEDSALEIDLIST_FIELD_NUMBER = 7;
        private Internal.IntList activatedSaleIdList_;
        private int activatedSaleIdListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetActivityInfoRsp DEFAULT_INSTANCE = new GetActivityInfoRsp();
        private static final Parser<GetActivityInfoRsp> PARSER = new AbstractParser<GetActivityInfoRsp>() { // from class: emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetActivityInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetActivityInfoRsp(input, extensionRegistry);
            }
        };

        private GetActivityInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.activatedSaleIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetActivityInfoRsp() {
            this.activatedSaleIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.activityInfoList_ = Collections.emptyList();
            this.disableTransferPointInteractionList_ = Collections.emptyList();
            this.activatedSaleIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetActivityInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0142 */
        private GetActivityInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.disableTransferPointInteractionList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.disableTransferPointInteractionList_.add((Uint32PairOuterClass.Uint32Pair) input.readMessage(Uint32PairOuterClass.Uint32Pair.parser(), extensionRegistry));
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.activatedSaleIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.activatedSaleIdList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.activatedSaleIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.activatedSaleIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.activityInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.activityInfoList_.add((ActivityInfoOuterClass.ActivityInfo) input.readMessage(ActivityInfoOuterClass.ActivityInfo.parser(), extensionRegistry));
                                break;
                            case 112:
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.disableTransferPointInteractionList_ = Collections.unmodifiableList(this.disableTransferPointInteractionList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.activatedSaleIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.activityInfoList_ = Collections.unmodifiableList(this.activityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetActivityInfoRspOuterClass.internal_static_GetActivityInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetActivityInfoRspOuterClass.internal_static_GetActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetActivityInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public List<ActivityInfoOuterClass.ActivityInfo> getActivityInfoListList() {
            return this.activityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public List<? extends ActivityInfoOuterClass.ActivityInfoOrBuilder> getActivityInfoListOrBuilderList() {
            return this.activityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public int getActivityInfoListCount() {
            return this.activityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public ActivityInfoOuterClass.ActivityInfo getActivityInfoList(int index) {
            return this.activityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public ActivityInfoOuterClass.ActivityInfoOrBuilder getActivityInfoListOrBuilder(int index) {
            return this.activityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public List<Uint32PairOuterClass.Uint32Pair> getDisableTransferPointInteractionListList() {
            return this.disableTransferPointInteractionList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getDisableTransferPointInteractionListOrBuilderList() {
            return this.disableTransferPointInteractionList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public int getDisableTransferPointInteractionListCount() {
            return this.disableTransferPointInteractionList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public Uint32PairOuterClass.Uint32Pair getDisableTransferPointInteractionList(int index) {
            return this.disableTransferPointInteractionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public Uint32PairOuterClass.Uint32PairOrBuilder getDisableTransferPointInteractionListOrBuilder(int index) {
            return this.disableTransferPointInteractionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public List<Integer> getActivatedSaleIdListList() {
            return this.activatedSaleIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public int getActivatedSaleIdListCount() {
            return this.activatedSaleIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
        public int getActivatedSaleIdList(int index) {
            return this.activatedSaleIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
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
            getSerializedSize();
            for (int i = 0; i < this.disableTransferPointInteractionList_.size(); i++) {
                output.writeMessage(3, this.disableTransferPointInteractionList_.get(i));
            }
            if (getActivatedSaleIdListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.activatedSaleIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.activatedSaleIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.activatedSaleIdList_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.activityInfoList_.size(); i3++) {
                output.writeMessage(13, this.activityInfoList_.get(i3));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            for (int i = 0; i < this.disableTransferPointInteractionList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.disableTransferPointInteractionList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.activatedSaleIdList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.activatedSaleIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getActivatedSaleIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.activatedSaleIdListMemoizedSerializedSize = dataSize;
            for (int i3 = 0; i3 < this.activityInfoList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(13, this.activityInfoList_.get(i3));
            }
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof GetActivityInfoRsp)) {
                return equals(obj);
            }
            GetActivityInfoRsp other = (GetActivityInfoRsp) obj;
            return getActivityInfoListList().equals(other.getActivityInfoListList()) && getDisableTransferPointInteractionListList().equals(other.getDisableTransferPointInteractionListList()) && getActivatedSaleIdListList().equals(other.getActivatedSaleIdListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getActivityInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getActivityInfoListList().hashCode();
            }
            if (getDisableTransferPointInteractionListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getDisableTransferPointInteractionListList().hashCode();
            }
            if (getActivatedSaleIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getActivatedSaleIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetActivityInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetActivityInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetActivityInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetActivityInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetActivityInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetActivityInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetActivityInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoRspOuterClass$GetActivityInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetActivityInfoRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ActivityInfoOuterClass.ActivityInfo, ActivityInfoOuterClass.ActivityInfo.Builder, ActivityInfoOuterClass.ActivityInfoOrBuilder> activityInfoListBuilder_;
            private RepeatedFieldBuilderV3<Uint32PairOuterClass.Uint32Pair, Uint32PairOuterClass.Uint32Pair.Builder, Uint32PairOuterClass.Uint32PairOrBuilder> disableTransferPointInteractionListBuilder_;
            private int retcode_;
            private List<ActivityInfoOuterClass.ActivityInfo> activityInfoList_ = Collections.emptyList();
            private List<Uint32PairOuterClass.Uint32Pair> disableTransferPointInteractionList_ = Collections.emptyList();
            private Internal.IntList activatedSaleIdList_ = GetActivityInfoRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetActivityInfoRspOuterClass.internal_static_GetActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetActivityInfoRspOuterClass.internal_static_GetActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetActivityInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetActivityInfoRsp.alwaysUseFieldBuilders) {
                    getActivityInfoListFieldBuilder();
                    getDisableTransferPointInteractionListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.activityInfoListBuilder_ == null) {
                    this.activityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.activityInfoListBuilder_.clear();
                }
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    this.disableTransferPointInteractionList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.disableTransferPointInteractionListBuilder_.clear();
                }
                this.activatedSaleIdList_ = GetActivityInfoRsp.emptyIntList();
                this.bitField0_ &= -5;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetActivityInfoRspOuterClass.internal_static_GetActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetActivityInfoRsp getDefaultInstanceForType() {
                return GetActivityInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetActivityInfoRsp build() {
                GetActivityInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetActivityInfoRsp buildPartial() {
                GetActivityInfoRsp result = new GetActivityInfoRsp(this);
                int i = this.bitField0_;
                if (this.activityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.activityInfoList_ = Collections.unmodifiableList(this.activityInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.activityInfoList_ = this.activityInfoList_;
                } else {
                    result.activityInfoList_ = this.activityInfoListBuilder_.build();
                }
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.disableTransferPointInteractionList_ = Collections.unmodifiableList(this.disableTransferPointInteractionList_);
                        this.bitField0_ &= -3;
                    }
                    result.disableTransferPointInteractionList_ = this.disableTransferPointInteractionList_;
                } else {
                    result.disableTransferPointInteractionList_ = this.disableTransferPointInteractionListBuilder_.build();
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.activatedSaleIdList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.activatedSaleIdList_ = this.activatedSaleIdList_;
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
                if (other instanceof GetActivityInfoRsp) {
                    return mergeFrom((GetActivityInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetActivityInfoRsp other) {
                if (other == GetActivityInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.activityInfoListBuilder_ == null) {
                    if (!other.activityInfoList_.isEmpty()) {
                        if (this.activityInfoList_.isEmpty()) {
                            this.activityInfoList_ = other.activityInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureActivityInfoListIsMutable();
                            this.activityInfoList_.addAll(other.activityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.activityInfoList_.isEmpty()) {
                    if (this.activityInfoListBuilder_.isEmpty()) {
                        this.activityInfoListBuilder_.dispose();
                        this.activityInfoListBuilder_ = null;
                        this.activityInfoList_ = other.activityInfoList_;
                        this.bitField0_ &= -2;
                        this.activityInfoListBuilder_ = GetActivityInfoRsp.alwaysUseFieldBuilders ? getActivityInfoListFieldBuilder() : null;
                    } else {
                        this.activityInfoListBuilder_.addAllMessages(other.activityInfoList_);
                    }
                }
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    if (!other.disableTransferPointInteractionList_.isEmpty()) {
                        if (this.disableTransferPointInteractionList_.isEmpty()) {
                            this.disableTransferPointInteractionList_ = other.disableTransferPointInteractionList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDisableTransferPointInteractionListIsMutable();
                            this.disableTransferPointInteractionList_.addAll(other.disableTransferPointInteractionList_);
                        }
                        onChanged();
                    }
                } else if (!other.disableTransferPointInteractionList_.isEmpty()) {
                    if (this.disableTransferPointInteractionListBuilder_.isEmpty()) {
                        this.disableTransferPointInteractionListBuilder_.dispose();
                        this.disableTransferPointInteractionListBuilder_ = null;
                        this.disableTransferPointInteractionList_ = other.disableTransferPointInteractionList_;
                        this.bitField0_ &= -3;
                        this.disableTransferPointInteractionListBuilder_ = GetActivityInfoRsp.alwaysUseFieldBuilders ? getDisableTransferPointInteractionListFieldBuilder() : null;
                    } else {
                        this.disableTransferPointInteractionListBuilder_.addAllMessages(other.disableTransferPointInteractionList_);
                    }
                }
                if (!other.activatedSaleIdList_.isEmpty()) {
                    if (this.activatedSaleIdList_.isEmpty()) {
                        this.activatedSaleIdList_ = other.activatedSaleIdList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureActivatedSaleIdListIsMutable();
                        this.activatedSaleIdList_.addAll(other.activatedSaleIdList_);
                    }
                    onChanged();
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
                GetActivityInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetActivityInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetActivityInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureActivityInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.activityInfoList_ = new ArrayList(this.activityInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public List<ActivityInfoOuterClass.ActivityInfo> getActivityInfoListList() {
                if (this.activityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.activityInfoList_);
                }
                return this.activityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public int getActivityInfoListCount() {
                if (this.activityInfoListBuilder_ == null) {
                    return this.activityInfoList_.size();
                }
                return this.activityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public ActivityInfoOuterClass.ActivityInfo getActivityInfoList(int index) {
                if (this.activityInfoListBuilder_ == null) {
                    return this.activityInfoList_.get(index);
                }
                return this.activityInfoListBuilder_.getMessage(index);
            }

            public Builder setActivityInfoList(int index, ActivityInfoOuterClass.ActivityInfo value) {
                if (this.activityInfoListBuilder_ != null) {
                    this.activityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setActivityInfoList(int index, ActivityInfoOuterClass.ActivityInfo.Builder builderForValue) {
                if (this.activityInfoListBuilder_ == null) {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.activityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addActivityInfoList(ActivityInfoOuterClass.ActivityInfo value) {
                if (this.activityInfoListBuilder_ != null) {
                    this.activityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addActivityInfoList(int index, ActivityInfoOuterClass.ActivityInfo value) {
                if (this.activityInfoListBuilder_ != null) {
                    this.activityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addActivityInfoList(ActivityInfoOuterClass.ActivityInfo.Builder builderForValue) {
                if (this.activityInfoListBuilder_ == null) {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.activityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addActivityInfoList(int index, ActivityInfoOuterClass.ActivityInfo.Builder builderForValue) {
                if (this.activityInfoListBuilder_ == null) {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.activityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllActivityInfoList(Iterable<? extends ActivityInfoOuterClass.ActivityInfo> values) {
                if (this.activityInfoListBuilder_ == null) {
                    ensureActivityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activityInfoList_);
                    onChanged();
                } else {
                    this.activityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearActivityInfoList() {
                if (this.activityInfoListBuilder_ == null) {
                    this.activityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.activityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeActivityInfoList(int index) {
                if (this.activityInfoListBuilder_ == null) {
                    ensureActivityInfoListIsMutable();
                    this.activityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.activityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ActivityInfoOuterClass.ActivityInfo.Builder getActivityInfoListBuilder(int index) {
                return getActivityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public ActivityInfoOuterClass.ActivityInfoOrBuilder getActivityInfoListOrBuilder(int index) {
                if (this.activityInfoListBuilder_ == null) {
                    return this.activityInfoList_.get(index);
                }
                return this.activityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public List<? extends ActivityInfoOuterClass.ActivityInfoOrBuilder> getActivityInfoListOrBuilderList() {
                if (this.activityInfoListBuilder_ != null) {
                    return this.activityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.activityInfoList_);
            }

            public ActivityInfoOuterClass.ActivityInfo.Builder addActivityInfoListBuilder() {
                return getActivityInfoListFieldBuilder().addBuilder(ActivityInfoOuterClass.ActivityInfo.getDefaultInstance());
            }

            public ActivityInfoOuterClass.ActivityInfo.Builder addActivityInfoListBuilder(int index) {
                return getActivityInfoListFieldBuilder().addBuilder(index, ActivityInfoOuterClass.ActivityInfo.getDefaultInstance());
            }

            public List<ActivityInfoOuterClass.ActivityInfo.Builder> getActivityInfoListBuilderList() {
                return getActivityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ActivityInfoOuterClass.ActivityInfo, ActivityInfoOuterClass.ActivityInfo.Builder, ActivityInfoOuterClass.ActivityInfoOrBuilder> getActivityInfoListFieldBuilder() {
                if (this.activityInfoListBuilder_ == null) {
                    this.activityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.activityInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.activityInfoList_ = null;
                }
                return this.activityInfoListBuilder_;
            }

            private void ensureDisableTransferPointInteractionListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.disableTransferPointInteractionList_ = new ArrayList(this.disableTransferPointInteractionList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public List<Uint32PairOuterClass.Uint32Pair> getDisableTransferPointInteractionListList() {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.disableTransferPointInteractionList_);
                }
                return this.disableTransferPointInteractionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public int getDisableTransferPointInteractionListCount() {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    return this.disableTransferPointInteractionList_.size();
                }
                return this.disableTransferPointInteractionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public Uint32PairOuterClass.Uint32Pair getDisableTransferPointInteractionList(int index) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    return this.disableTransferPointInteractionList_.get(index);
                }
                return this.disableTransferPointInteractionListBuilder_.getMessage(index);
            }

            public Builder setDisableTransferPointInteractionList(int index, Uint32PairOuterClass.Uint32Pair value) {
                if (this.disableTransferPointInteractionListBuilder_ != null) {
                    this.disableTransferPointInteractionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDisableTransferPointInteractionList(int index, Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.disableTransferPointInteractionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDisableTransferPointInteractionList(Uint32PairOuterClass.Uint32Pair value) {
                if (this.disableTransferPointInteractionListBuilder_ != null) {
                    this.disableTransferPointInteractionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDisableTransferPointInteractionList(int index, Uint32PairOuterClass.Uint32Pair value) {
                if (this.disableTransferPointInteractionListBuilder_ != null) {
                    this.disableTransferPointInteractionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDisableTransferPointInteractionList(Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.disableTransferPointInteractionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDisableTransferPointInteractionList(int index, Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.disableTransferPointInteractionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDisableTransferPointInteractionList(Iterable<? extends Uint32PairOuterClass.Uint32Pair> values) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    ensureDisableTransferPointInteractionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.disableTransferPointInteractionList_);
                    onChanged();
                } else {
                    this.disableTransferPointInteractionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDisableTransferPointInteractionList() {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    this.disableTransferPointInteractionList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.disableTransferPointInteractionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDisableTransferPointInteractionList(int index) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    ensureDisableTransferPointInteractionListIsMutable();
                    this.disableTransferPointInteractionList_.remove(index);
                    onChanged();
                } else {
                    this.disableTransferPointInteractionListBuilder_.remove(index);
                }
                return this;
            }

            public Uint32PairOuterClass.Uint32Pair.Builder getDisableTransferPointInteractionListBuilder(int index) {
                return getDisableTransferPointInteractionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public Uint32PairOuterClass.Uint32PairOrBuilder getDisableTransferPointInteractionListOrBuilder(int index) {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    return this.disableTransferPointInteractionList_.get(index);
                }
                return this.disableTransferPointInteractionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getDisableTransferPointInteractionListOrBuilderList() {
                if (this.disableTransferPointInteractionListBuilder_ != null) {
                    return this.disableTransferPointInteractionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.disableTransferPointInteractionList_);
            }

            public Uint32PairOuterClass.Uint32Pair.Builder addDisableTransferPointInteractionListBuilder() {
                return getDisableTransferPointInteractionListFieldBuilder().addBuilder(Uint32PairOuterClass.Uint32Pair.getDefaultInstance());
            }

            public Uint32PairOuterClass.Uint32Pair.Builder addDisableTransferPointInteractionListBuilder(int index) {
                return getDisableTransferPointInteractionListFieldBuilder().addBuilder(index, Uint32PairOuterClass.Uint32Pair.getDefaultInstance());
            }

            public List<Uint32PairOuterClass.Uint32Pair.Builder> getDisableTransferPointInteractionListBuilderList() {
                return getDisableTransferPointInteractionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Uint32PairOuterClass.Uint32Pair, Uint32PairOuterClass.Uint32Pair.Builder, Uint32PairOuterClass.Uint32PairOrBuilder> getDisableTransferPointInteractionListFieldBuilder() {
                if (this.disableTransferPointInteractionListBuilder_ == null) {
                    this.disableTransferPointInteractionListBuilder_ = new RepeatedFieldBuilderV3<>(this.disableTransferPointInteractionList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.disableTransferPointInteractionList_ = null;
                }
                return this.disableTransferPointInteractionListBuilder_;
            }

            private void ensureActivatedSaleIdListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.activatedSaleIdList_ = GetActivityInfoRsp.mutableCopy(this.activatedSaleIdList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public List<Integer> getActivatedSaleIdListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.activatedSaleIdList_) : this.activatedSaleIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public int getActivatedSaleIdListCount() {
                return this.activatedSaleIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
            public int getActivatedSaleIdList(int index) {
                return this.activatedSaleIdList_.getInt(index);
            }

            public Builder setActivatedSaleIdList(int index, int value) {
                ensureActivatedSaleIdListIsMutable();
                this.activatedSaleIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addActivatedSaleIdList(int value) {
                ensureActivatedSaleIdListIsMutable();
                this.activatedSaleIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllActivatedSaleIdList(Iterable<? extends Integer> values) {
                ensureActivatedSaleIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activatedSaleIdList_);
                onChanged();
                return this;
            }

            public Builder clearActivatedSaleIdList() {
                this.activatedSaleIdList_ = GetActivityInfoRsp.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRspOrBuilder
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

        public static GetActivityInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetActivityInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetActivityInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetActivityInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityInfoOuterClass.getDescriptor();
        Uint32PairOuterClass.getDescriptor();
    }
}
