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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass.class */
public final class PlayerCompoundMaterialBoostReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$PlayerCompoundMaterialBoostReq.proto\u001a!CompoundBoostTakeStatusType.proto\u001a\u0017CompoundQueueData.proto\u001a\u000fItemParam.proto\"¸\u0001\n\u001ePlayerCompoundMaterialBoostReq\u00121\n\u0015compoundQueueDataList\u0018\u0006 \u0003(\u000b2\u0012.CompoundQueueData\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005\u0012\u001f\n\u000bikceidbkdla\u0018\u000e \u0003(\u000b2\n.ItemParam\u00121\n\u000bobkcgkalonf\u0018\b \u0001(\u000e2\u001c.CompoundBoostTakeStatusTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CompoundBoostTakeStatusTypeOuterClass.getDescriptor(), CompoundQueueDataOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PlayerCompoundMaterialBoostReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_PlayerCompoundMaterialBoostReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f806x1944ae4f = new GeneratedMessageV3.FieldAccessorTable(internal_static_PlayerCompoundMaterialBoostReq_descriptor, new String[]{"CompoundQueueDataList", "Retcode", "Ikceidbkdla", "Obkcgkalonf"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass$PlayerCompoundMaterialBoostReqOrBuilder.class */
    public interface PlayerCompoundMaterialBoostReqOrBuilder extends MessageOrBuilder {
        List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList();

        CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int i);

        int getCompoundQueueDataListCount();

        List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList();

        CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int i);

        int getRetcode();

        List<ItemParamOuterClass.ItemParam> getIkceidbkdlaList();

        ItemParamOuterClass.ItemParam getIkceidbkdla(int i);

        int getIkceidbkdlaCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getIkceidbkdlaOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getIkceidbkdlaOrBuilder(int i);

        int getObkcgkalonfValue();

        CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType getObkcgkalonf();
    }

    private PlayerCompoundMaterialBoostReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass$PlayerCompoundMaterialBoostReq.class */
    public static final class PlayerCompoundMaterialBoostReq extends GeneratedMessageV3 implements PlayerCompoundMaterialBoostReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMPOUNDQUEUEDATALIST_FIELD_NUMBER = 6;
        private List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueDataList_;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        public static final int IKCEIDBKDLA_FIELD_NUMBER = 14;
        private List<ItemParamOuterClass.ItemParam> ikceidbkdla_;
        public static final int OBKCGKALONF_FIELD_NUMBER = 8;
        private int obkcgkalonf_;
        private byte memoizedIsInitialized;
        private static final PlayerCompoundMaterialBoostReq DEFAULT_INSTANCE = new PlayerCompoundMaterialBoostReq();
        private static final Parser<PlayerCompoundMaterialBoostReq> PARSER = new AbstractParser<PlayerCompoundMaterialBoostReq>() { // from class: emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReq.1
            @Override // com.google.protobuf.Parser
            public PlayerCompoundMaterialBoostReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PlayerCompoundMaterialBoostReq(input, extensionRegistry);
            }
        };

        private PlayerCompoundMaterialBoostReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PlayerCompoundMaterialBoostReq() {
            this.memoizedIsInitialized = -1;
            this.compoundQueueDataList_ = Collections.emptyList();
            this.ikceidbkdla_ = Collections.emptyList();
            this.obkcgkalonf_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PlayerCompoundMaterialBoostReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x00e2 */
        private PlayerCompoundMaterialBoostReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.compoundQueueDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.compoundQueueDataList_.add((CompoundQueueDataOuterClass.CompoundQueueData) input.readMessage(CompoundQueueDataOuterClass.CompoundQueueData.parser(), extensionRegistry));
                                    break;
                                case 64:
                                    this.obkcgkalonf_ = input.readEnum();
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.ikceidbkdla_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.ikceidbkdla_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                    break;
                                case 120:
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.compoundQueueDataList_ = Collections.unmodifiableList(this.compoundQueueDataList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.ikceidbkdla_ = Collections.unmodifiableList(this.ikceidbkdla_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PlayerCompoundMaterialBoostReqOuterClass.internal_static_PlayerCompoundMaterialBoostReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PlayerCompoundMaterialBoostReqOuterClass.f806x1944ae4f.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList() {
            return this.compoundQueueDataList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public List<? extends CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> getCompoundQueueDataListOrBuilderList() {
            return this.compoundQueueDataList_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getCompoundQueueDataListCount() {
            return this.compoundQueueDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueData getCompoundQueueDataList(int index) {
            return this.compoundQueueDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int index) {
            return this.compoundQueueDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public List<ItemParamOuterClass.ItemParam> getIkceidbkdlaList() {
            return this.ikceidbkdla_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getIkceidbkdlaOrBuilderList() {
            return this.ikceidbkdla_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getIkceidbkdlaCount() {
            return this.ikceidbkdla_.size();
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public ItemParamOuterClass.ItemParam getIkceidbkdla(int index) {
            return this.ikceidbkdla_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getIkceidbkdlaOrBuilder(int index) {
            return this.ikceidbkdla_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public int getObkcgkalonfValue() {
            return this.obkcgkalonf_;
        }

        @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
        public CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType getObkcgkalonf() {
            CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType result = CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.valueOf(this.obkcgkalonf_);
            return result == null ? CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.UNRECOGNIZED : result;
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
            for (int i = 0; i < this.compoundQueueDataList_.size(); i++) {
                output.writeMessage(6, this.compoundQueueDataList_.get(i));
            }
            if (this.obkcgkalonf_ != CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE.getNumber()) {
                output.writeEnum(8, this.obkcgkalonf_);
            }
            for (int i2 = 0; i2 < this.ikceidbkdla_.size(); i2++) {
                output.writeMessage(14, this.ikceidbkdla_.get(i2));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            for (int i = 0; i < this.compoundQueueDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.compoundQueueDataList_.get(i));
            }
            if (this.obkcgkalonf_ != CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(8, this.obkcgkalonf_);
            }
            for (int i2 = 0; i2 < this.ikceidbkdla_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.ikceidbkdla_.get(i2));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof PlayerCompoundMaterialBoostReq)) {
                return equals(obj);
            }
            PlayerCompoundMaterialBoostReq other = (PlayerCompoundMaterialBoostReq) obj;
            return getCompoundQueueDataListList().equals(other.getCompoundQueueDataListList()) && getRetcode() == other.getRetcode() && getIkceidbkdlaList().equals(other.getIkceidbkdlaList()) && this.obkcgkalonf_ == other.obkcgkalonf_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCompoundQueueDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getCompoundQueueDataListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 15)) + getRetcode();
            if (getIkceidbkdlaCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getIkceidbkdlaList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 8)) + this.obkcgkalonf_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(CodedInputStream input) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PlayerCompoundMaterialBoostReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PlayerCompoundMaterialBoostReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerCompoundMaterialBoostReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerCompoundMaterialBoostReqOuterClass$PlayerCompoundMaterialBoostReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlayerCompoundMaterialBoostReqOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<CompoundQueueDataOuterClass.CompoundQueueData, CompoundQueueDataOuterClass.CompoundQueueData.Builder, CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder> compoundQueueDataListBuilder_;
            private int retcode_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> ikceidbkdlaBuilder_;
            private List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueDataList_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> ikceidbkdla_ = Collections.emptyList();
            private int obkcgkalonf_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return PlayerCompoundMaterialBoostReqOuterClass.internal_static_PlayerCompoundMaterialBoostReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PlayerCompoundMaterialBoostReqOuterClass.f806x1944ae4f.ensureFieldAccessorsInitialized(PlayerCompoundMaterialBoostReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PlayerCompoundMaterialBoostReq.alwaysUseFieldBuilders) {
                    getCompoundQueueDataListFieldBuilder();
                    getIkceidbkdlaFieldBuilder();
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
                this.retcode_ = 0;
                if (this.ikceidbkdlaBuilder_ == null) {
                    this.ikceidbkdla_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.ikceidbkdlaBuilder_.clear();
                }
                this.obkcgkalonf_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PlayerCompoundMaterialBoostReqOuterClass.internal_static_PlayerCompoundMaterialBoostReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PlayerCompoundMaterialBoostReq getDefaultInstanceForType() {
                return PlayerCompoundMaterialBoostReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostReq build() {
                PlayerCompoundMaterialBoostReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PlayerCompoundMaterialBoostReq buildPartial() {
                PlayerCompoundMaterialBoostReq result = new PlayerCompoundMaterialBoostReq(this);
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
                result.retcode_ = this.retcode_;
                if (this.ikceidbkdlaBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.ikceidbkdla_ = Collections.unmodifiableList(this.ikceidbkdla_);
                        this.bitField0_ &= -3;
                    }
                    result.ikceidbkdla_ = this.ikceidbkdla_;
                } else {
                    result.ikceidbkdla_ = this.ikceidbkdlaBuilder_.build();
                }
                result.obkcgkalonf_ = this.obkcgkalonf_;
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
                if (other instanceof PlayerCompoundMaterialBoostReq) {
                    return mergeFrom((PlayerCompoundMaterialBoostReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PlayerCompoundMaterialBoostReq other) {
                if (other == PlayerCompoundMaterialBoostReq.getDefaultInstance()) {
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
                        this.compoundQueueDataListBuilder_ = PlayerCompoundMaterialBoostReq.alwaysUseFieldBuilders ? getCompoundQueueDataListFieldBuilder() : null;
                    } else {
                        this.compoundQueueDataListBuilder_.addAllMessages(other.compoundQueueDataList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.ikceidbkdlaBuilder_ == null) {
                    if (!other.ikceidbkdla_.isEmpty()) {
                        if (this.ikceidbkdla_.isEmpty()) {
                            this.ikceidbkdla_ = other.ikceidbkdla_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureIkceidbkdlaIsMutable();
                            this.ikceidbkdla_.addAll(other.ikceidbkdla_);
                        }
                        onChanged();
                    }
                } else if (!other.ikceidbkdla_.isEmpty()) {
                    if (this.ikceidbkdlaBuilder_.isEmpty()) {
                        this.ikceidbkdlaBuilder_.dispose();
                        this.ikceidbkdlaBuilder_ = null;
                        this.ikceidbkdla_ = other.ikceidbkdla_;
                        this.bitField0_ &= -3;
                        this.ikceidbkdlaBuilder_ = PlayerCompoundMaterialBoostReq.alwaysUseFieldBuilders ? getIkceidbkdlaFieldBuilder() : null;
                    } else {
                        this.ikceidbkdlaBuilder_.addAllMessages(other.ikceidbkdla_);
                    }
                }
                if (other.obkcgkalonf_ != 0) {
                    setObkcgkalonfValue(other.getObkcgkalonfValue());
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
                PlayerCompoundMaterialBoostReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PlayerCompoundMaterialBoostReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PlayerCompoundMaterialBoostReq) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueDataListList() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.compoundQueueDataList_);
                }
                return this.compoundQueueDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public int getCompoundQueueDataListCount() {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.size();
                }
                return this.compoundQueueDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public CompoundQueueDataOuterClass.CompoundQueueDataOrBuilder getCompoundQueueDataListOrBuilder(int index) {
                if (this.compoundQueueDataListBuilder_ == null) {
                    return this.compoundQueueDataList_.get(index);
                }
                return this.compoundQueueDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
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

            private void ensureIkceidbkdlaIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.ikceidbkdla_ = new ArrayList(this.ikceidbkdla_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public List<ItemParamOuterClass.ItemParam> getIkceidbkdlaList() {
                if (this.ikceidbkdlaBuilder_ == null) {
                    return Collections.unmodifiableList(this.ikceidbkdla_);
                }
                return this.ikceidbkdlaBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public int getIkceidbkdlaCount() {
                if (this.ikceidbkdlaBuilder_ == null) {
                    return this.ikceidbkdla_.size();
                }
                return this.ikceidbkdlaBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public ItemParamOuterClass.ItemParam getIkceidbkdla(int index) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    return this.ikceidbkdla_.get(index);
                }
                return this.ikceidbkdlaBuilder_.getMessage(index);
            }

            public Builder setIkceidbkdla(int index, ItemParamOuterClass.ItemParam value) {
                if (this.ikceidbkdlaBuilder_ != null) {
                    this.ikceidbkdlaBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setIkceidbkdla(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.ikceidbkdlaBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addIkceidbkdla(ItemParamOuterClass.ItemParam value) {
                if (this.ikceidbkdlaBuilder_ != null) {
                    this.ikceidbkdlaBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addIkceidbkdla(int index, ItemParamOuterClass.ItemParam value) {
                if (this.ikceidbkdlaBuilder_ != null) {
                    this.ikceidbkdlaBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addIkceidbkdla(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.ikceidbkdlaBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addIkceidbkdla(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.ikceidbkdlaBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllIkceidbkdla(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    ensureIkceidbkdlaIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.ikceidbkdla_);
                    onChanged();
                } else {
                    this.ikceidbkdlaBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearIkceidbkdla() {
                if (this.ikceidbkdlaBuilder_ == null) {
                    this.ikceidbkdla_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.ikceidbkdlaBuilder_.clear();
                }
                return this;
            }

            public Builder removeIkceidbkdla(int index) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    ensureIkceidbkdlaIsMutable();
                    this.ikceidbkdla_.remove(index);
                    onChanged();
                } else {
                    this.ikceidbkdlaBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getIkceidbkdlaBuilder(int index) {
                return getIkceidbkdlaFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getIkceidbkdlaOrBuilder(int index) {
                if (this.ikceidbkdlaBuilder_ == null) {
                    return this.ikceidbkdla_.get(index);
                }
                return this.ikceidbkdlaBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getIkceidbkdlaOrBuilderList() {
                if (this.ikceidbkdlaBuilder_ != null) {
                    return this.ikceidbkdlaBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.ikceidbkdla_);
            }

            public ItemParamOuterClass.ItemParam.Builder addIkceidbkdlaBuilder() {
                return getIkceidbkdlaFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addIkceidbkdlaBuilder(int index) {
                return getIkceidbkdlaFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getIkceidbkdlaBuilderList() {
                return getIkceidbkdlaFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getIkceidbkdlaFieldBuilder() {
                if (this.ikceidbkdlaBuilder_ == null) {
                    this.ikceidbkdlaBuilder_ = new RepeatedFieldBuilderV3<>(this.ikceidbkdla_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.ikceidbkdla_ = null;
                }
                return this.ikceidbkdlaBuilder_;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public int getObkcgkalonfValue() {
                return this.obkcgkalonf_;
            }

            public Builder setObkcgkalonfValue(int value) {
                this.obkcgkalonf_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PlayerCompoundMaterialBoostReqOuterClass.PlayerCompoundMaterialBoostReqOrBuilder
            public CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType getObkcgkalonf() {
                CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType result = CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.valueOf(this.obkcgkalonf_);
                return result == null ? CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.UNRECOGNIZED : result;
            }

            public Builder setObkcgkalonf(CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.obkcgkalonf_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearObkcgkalonf() {
                this.obkcgkalonf_ = 0;
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

        public static PlayerCompoundMaterialBoostReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PlayerCompoundMaterialBoostReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PlayerCompoundMaterialBoostReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerCompoundMaterialBoostReq getDefaultInstanceForType() {
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
