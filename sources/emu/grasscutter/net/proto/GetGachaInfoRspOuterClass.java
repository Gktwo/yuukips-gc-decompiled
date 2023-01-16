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
import emu.grasscutter.net.proto.GachaInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetGachaInfoRspOuterClass.class */
public final class GetGachaInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015GetGachaInfoRsp.proto\u001a\u000fGachaInfo.proto\"²\u0001\n\u000fGetGachaInfoRsp\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u0019\n\u0011daily_gacha_times\u0018\u0006 \u0001(\r\u0012#\n\u000fgacha_info_list\u0018\n \u0003(\u000b2\n.GachaInfo\u0012\u001b\n\u0013Unk3300_OHFMHIHJHPJ\u0018\u0004 \u0001(\b\u0012\u0014\n\fgacha_random\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_HBILIAEIHNK\u0018\u0003 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GachaInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetGachaInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetGachaInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetGachaInfoRsp_descriptor, new String[]{"Retcode", "DailyGachaTimes", "GachaInfoList", "Unk3300OHFMHIHJHPJ", "GachaRandom", "Unk3300HBILIAEIHNK"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetGachaInfoRspOuterClass$GetGachaInfoRspOrBuilder.class */
    public interface GetGachaInfoRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getDailyGachaTimes();

        List<GachaInfoOuterClass.GachaInfo> getGachaInfoListList();

        GachaInfoOuterClass.GachaInfo getGachaInfoList(int i);

        int getGachaInfoListCount();

        List<? extends GachaInfoOuterClass.GachaInfoOrBuilder> getGachaInfoListOrBuilderList();

        GachaInfoOuterClass.GachaInfoOrBuilder getGachaInfoListOrBuilder(int i);

        boolean getUnk3300OHFMHIHJHPJ();

        int getGachaRandom();

        boolean getUnk3300HBILIAEIHNK();
    }

    private GetGachaInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetGachaInfoRspOuterClass$GetGachaInfoRsp.class */
    public static final class GetGachaInfoRsp extends GeneratedMessageV3 implements GetGachaInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int DAILY_GACHA_TIMES_FIELD_NUMBER = 6;
        private int dailyGachaTimes_;
        public static final int GACHA_INFO_LIST_FIELD_NUMBER = 10;
        private List<GachaInfoOuterClass.GachaInfo> gachaInfoList_;
        public static final int UNK3300_OHFMHIHJHPJ_FIELD_NUMBER = 4;
        private boolean unk3300OHFMHIHJHPJ_;
        public static final int GACHA_RANDOM_FIELD_NUMBER = 9;
        private int gachaRandom_;
        public static final int UNK3300_HBILIAEIHNK_FIELD_NUMBER = 3;
        private boolean unk3300HBILIAEIHNK_;
        private byte memoizedIsInitialized;
        private static final GetGachaInfoRsp DEFAULT_INSTANCE = new GetGachaInfoRsp();
        private static final Parser<GetGachaInfoRsp> PARSER = new AbstractParser<GetGachaInfoRsp>() { // from class: emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetGachaInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetGachaInfoRsp(input, extensionRegistry);
            }
        };

        private GetGachaInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetGachaInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.gachaInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetGachaInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetGachaInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.unk3300HBILIAEIHNK_ = input.readBool();
                                break;
                            case 32:
                                this.unk3300OHFMHIHJHPJ_ = input.readBool();
                                break;
                            case 48:
                                this.dailyGachaTimes_ = input.readUInt32();
                                break;
                            case 72:
                                this.gachaRandom_ = input.readUInt32();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.gachaInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.gachaInfoList_.add((GachaInfoOuterClass.GachaInfo) input.readMessage(GachaInfoOuterClass.GachaInfo.parser(), extensionRegistry));
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.gachaInfoList_ = Collections.unmodifiableList(this.gachaInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetGachaInfoRspOuterClass.internal_static_GetGachaInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetGachaInfoRspOuterClass.internal_static_GetGachaInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGachaInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public int getDailyGachaTimes() {
            return this.dailyGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public List<GachaInfoOuterClass.GachaInfo> getGachaInfoListList() {
            return this.gachaInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public List<? extends GachaInfoOuterClass.GachaInfoOrBuilder> getGachaInfoListOrBuilderList() {
            return this.gachaInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public int getGachaInfoListCount() {
            return this.gachaInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public GachaInfoOuterClass.GachaInfo getGachaInfoList(int index) {
            return this.gachaInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public GachaInfoOuterClass.GachaInfoOrBuilder getGachaInfoListOrBuilder(int index) {
            return this.gachaInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public boolean getUnk3300OHFMHIHJHPJ() {
            return this.unk3300OHFMHIHJHPJ_;
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public int getGachaRandom() {
            return this.gachaRandom_;
        }

        @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
        public boolean getUnk3300HBILIAEIHNK() {
            return this.unk3300HBILIAEIHNK_;
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
            if (this.unk3300HBILIAEIHNK_) {
                output.writeBool(3, this.unk3300HBILIAEIHNK_);
            }
            if (this.unk3300OHFMHIHJHPJ_) {
                output.writeBool(4, this.unk3300OHFMHIHJHPJ_);
            }
            if (this.dailyGachaTimes_ != 0) {
                output.writeUInt32(6, this.dailyGachaTimes_);
            }
            if (this.gachaRandom_ != 0) {
                output.writeUInt32(9, this.gachaRandom_);
            }
            for (int i = 0; i < this.gachaInfoList_.size(); i++) {
                output.writeMessage(10, this.gachaInfoList_.get(i));
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
            if (this.unk3300HBILIAEIHNK_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.unk3300HBILIAEIHNK_);
            }
            if (this.unk3300OHFMHIHJHPJ_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.unk3300OHFMHIHJHPJ_);
            }
            if (this.dailyGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.dailyGachaTimes_);
            }
            if (this.gachaRandom_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.gachaRandom_);
            }
            for (int i = 0; i < this.gachaInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.gachaInfoList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof GetGachaInfoRsp)) {
                return equals(obj);
            }
            GetGachaInfoRsp other = (GetGachaInfoRsp) obj;
            return getRetcode() == other.getRetcode() && getDailyGachaTimes() == other.getDailyGachaTimes() && getGachaInfoListList().equals(other.getGachaInfoListList()) && getUnk3300OHFMHIHJHPJ() == other.getUnk3300OHFMHIHJHPJ() && getGachaRandom() == other.getGachaRandom() && getUnk3300HBILIAEIHNK() == other.getUnk3300HBILIAEIHNK() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getRetcode())) + 6)) + getDailyGachaTimes();
            if (getGachaInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getGachaInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + Internal.hashBoolean(getUnk3300OHFMHIHJHPJ()))) + 9)) + getGachaRandom())) + 3)) + Internal.hashBoolean(getUnk3300HBILIAEIHNK()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetGachaInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetGachaInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGachaInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetGachaInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGachaInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetGachaInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetGachaInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetGachaInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetGachaInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGachaInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetGachaInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetGachaInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetGachaInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGachaInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetGachaInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetGachaInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetGachaInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetGachaInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetGachaInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetGachaInfoRspOuterClass$GetGachaInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetGachaInfoRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int dailyGachaTimes_;
            private List<GachaInfoOuterClass.GachaInfo> gachaInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GachaInfoOuterClass.GachaInfo, GachaInfoOuterClass.GachaInfo.Builder, GachaInfoOuterClass.GachaInfoOrBuilder> gachaInfoListBuilder_;
            private boolean unk3300OHFMHIHJHPJ_;
            private int gachaRandom_;
            private boolean unk3300HBILIAEIHNK_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetGachaInfoRspOuterClass.internal_static_GetGachaInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetGachaInfoRspOuterClass.internal_static_GetGachaInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetGachaInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetGachaInfoRsp.alwaysUseFieldBuilders) {
                    getGachaInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.dailyGachaTimes_ = 0;
                if (this.gachaInfoListBuilder_ == null) {
                    this.gachaInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.gachaInfoListBuilder_.clear();
                }
                this.unk3300OHFMHIHJHPJ_ = false;
                this.gachaRandom_ = 0;
                this.unk3300HBILIAEIHNK_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetGachaInfoRspOuterClass.internal_static_GetGachaInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetGachaInfoRsp getDefaultInstanceForType() {
                return GetGachaInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetGachaInfoRsp build() {
                GetGachaInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetGachaInfoRsp buildPartial() {
                GetGachaInfoRsp result = new GetGachaInfoRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.dailyGachaTimes_ = this.dailyGachaTimes_;
                if (this.gachaInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.gachaInfoList_ = Collections.unmodifiableList(this.gachaInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.gachaInfoList_ = this.gachaInfoList_;
                } else {
                    result.gachaInfoList_ = this.gachaInfoListBuilder_.build();
                }
                result.unk3300OHFMHIHJHPJ_ = this.unk3300OHFMHIHJHPJ_;
                result.gachaRandom_ = this.gachaRandom_;
                result.unk3300HBILIAEIHNK_ = this.unk3300HBILIAEIHNK_;
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
                if (other instanceof GetGachaInfoRsp) {
                    return mergeFrom((GetGachaInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetGachaInfoRsp other) {
                if (other == GetGachaInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getDailyGachaTimes() != 0) {
                    setDailyGachaTimes(other.getDailyGachaTimes());
                }
                if (this.gachaInfoListBuilder_ == null) {
                    if (!other.gachaInfoList_.isEmpty()) {
                        if (this.gachaInfoList_.isEmpty()) {
                            this.gachaInfoList_ = other.gachaInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureGachaInfoListIsMutable();
                            this.gachaInfoList_.addAll(other.gachaInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.gachaInfoList_.isEmpty()) {
                    if (this.gachaInfoListBuilder_.isEmpty()) {
                        this.gachaInfoListBuilder_.dispose();
                        this.gachaInfoListBuilder_ = null;
                        this.gachaInfoList_ = other.gachaInfoList_;
                        this.bitField0_ &= -2;
                        this.gachaInfoListBuilder_ = GetGachaInfoRsp.alwaysUseFieldBuilders ? getGachaInfoListFieldBuilder() : null;
                    } else {
                        this.gachaInfoListBuilder_.addAllMessages(other.gachaInfoList_);
                    }
                }
                if (other.getUnk3300OHFMHIHJHPJ()) {
                    setUnk3300OHFMHIHJHPJ(other.getUnk3300OHFMHIHJHPJ());
                }
                if (other.getGachaRandom() != 0) {
                    setGachaRandom(other.getGachaRandom());
                }
                if (other.getUnk3300HBILIAEIHNK()) {
                    setUnk3300HBILIAEIHNK(other.getUnk3300HBILIAEIHNK());
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
                GetGachaInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetGachaInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetGachaInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public int getDailyGachaTimes() {
                return this.dailyGachaTimes_;
            }

            public Builder setDailyGachaTimes(int value) {
                this.dailyGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearDailyGachaTimes() {
                this.dailyGachaTimes_ = 0;
                onChanged();
                return this;
            }

            private void ensureGachaInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.gachaInfoList_ = new ArrayList(this.gachaInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public List<GachaInfoOuterClass.GachaInfo> getGachaInfoListList() {
                if (this.gachaInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.gachaInfoList_);
                }
                return this.gachaInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public int getGachaInfoListCount() {
                if (this.gachaInfoListBuilder_ == null) {
                    return this.gachaInfoList_.size();
                }
                return this.gachaInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public GachaInfoOuterClass.GachaInfo getGachaInfoList(int index) {
                if (this.gachaInfoListBuilder_ == null) {
                    return this.gachaInfoList_.get(index);
                }
                return this.gachaInfoListBuilder_.getMessage(index);
            }

            public Builder setGachaInfoList(int index, GachaInfoOuterClass.GachaInfo value) {
                if (this.gachaInfoListBuilder_ != null) {
                    this.gachaInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGachaInfoList(int index, GachaInfoOuterClass.GachaInfo.Builder builderForValue) {
                if (this.gachaInfoListBuilder_ == null) {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGachaInfoList(GachaInfoOuterClass.GachaInfo value) {
                if (this.gachaInfoListBuilder_ != null) {
                    this.gachaInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaInfoList(int index, GachaInfoOuterClass.GachaInfo value) {
                if (this.gachaInfoListBuilder_ != null) {
                    this.gachaInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaInfoList(GachaInfoOuterClass.GachaInfo.Builder builderForValue) {
                if (this.gachaInfoListBuilder_ == null) {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.gachaInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGachaInfoList(int index, GachaInfoOuterClass.GachaInfo.Builder builderForValue) {
                if (this.gachaInfoListBuilder_ == null) {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGachaInfoList(Iterable<? extends GachaInfoOuterClass.GachaInfo> values) {
                if (this.gachaInfoListBuilder_ == null) {
                    ensureGachaInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gachaInfoList_);
                    onChanged();
                } else {
                    this.gachaInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGachaInfoList() {
                if (this.gachaInfoListBuilder_ == null) {
                    this.gachaInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.gachaInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGachaInfoList(int index) {
                if (this.gachaInfoListBuilder_ == null) {
                    ensureGachaInfoListIsMutable();
                    this.gachaInfoList_.remove(index);
                    onChanged();
                } else {
                    this.gachaInfoListBuilder_.remove(index);
                }
                return this;
            }

            public GachaInfoOuterClass.GachaInfo.Builder getGachaInfoListBuilder(int index) {
                return getGachaInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public GachaInfoOuterClass.GachaInfoOrBuilder getGachaInfoListOrBuilder(int index) {
                if (this.gachaInfoListBuilder_ == null) {
                    return this.gachaInfoList_.get(index);
                }
                return this.gachaInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public List<? extends GachaInfoOuterClass.GachaInfoOrBuilder> getGachaInfoListOrBuilderList() {
                if (this.gachaInfoListBuilder_ != null) {
                    return this.gachaInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.gachaInfoList_);
            }

            public GachaInfoOuterClass.GachaInfo.Builder addGachaInfoListBuilder() {
                return getGachaInfoListFieldBuilder().addBuilder(GachaInfoOuterClass.GachaInfo.getDefaultInstance());
            }

            public GachaInfoOuterClass.GachaInfo.Builder addGachaInfoListBuilder(int index) {
                return getGachaInfoListFieldBuilder().addBuilder(index, GachaInfoOuterClass.GachaInfo.getDefaultInstance());
            }

            public List<GachaInfoOuterClass.GachaInfo.Builder> getGachaInfoListBuilderList() {
                return getGachaInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GachaInfoOuterClass.GachaInfo, GachaInfoOuterClass.GachaInfo.Builder, GachaInfoOuterClass.GachaInfoOrBuilder> getGachaInfoListFieldBuilder() {
                if (this.gachaInfoListBuilder_ == null) {
                    this.gachaInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.gachaInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.gachaInfoList_ = null;
                }
                return this.gachaInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public boolean getUnk3300OHFMHIHJHPJ() {
                return this.unk3300OHFMHIHJHPJ_;
            }

            public Builder setUnk3300OHFMHIHJHPJ(boolean value) {
                this.unk3300OHFMHIHJHPJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OHFMHIHJHPJ() {
                this.unk3300OHFMHIHJHPJ_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public int getGachaRandom() {
                return this.gachaRandom_;
            }

            public Builder setGachaRandom(int value) {
                this.gachaRandom_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaRandom() {
                this.gachaRandom_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetGachaInfoRspOuterClass.GetGachaInfoRspOrBuilder
            public boolean getUnk3300HBILIAEIHNK() {
                return this.unk3300HBILIAEIHNK_;
            }

            public Builder setUnk3300HBILIAEIHNK(boolean value) {
                this.unk3300HBILIAEIHNK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HBILIAEIHNK() {
                this.unk3300HBILIAEIHNK_ = false;
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

        public static GetGachaInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetGachaInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetGachaInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetGachaInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GachaInfoOuterClass.getDescriptor();
    }
}
