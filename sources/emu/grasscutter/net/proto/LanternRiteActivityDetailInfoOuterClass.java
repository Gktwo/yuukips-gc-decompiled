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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.LanternProjectionInfoOuterClass;
import emu.grasscutter.net.proto.LanternRiteFireworksInfoOuterClass;
import emu.grasscutter.net.proto.SalvageStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityDetailInfoOuterClass.class */
public final class LanternRiteActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#LanternRiteActivityDetailInfo.proto\u001a\u001bLanternProjectionInfo.proto\u001a\u001eLanternRiteFireworksInfo.proto\u001a\u0016SalvageStageInfo.proto\"\u0002\n\u001dLanternRiteActivityDetailInfo\u0012*\n\u000fstage_info_list\u0018\u0005 \u0003(\u000b2\u0011.SalvageStageInfo\u00121\n\u000efireworks_info\u0018\u000f \u0001(\u000b2\u0019.LanternRiteFireworksInfo\u0012\u001b\n\u0013Unk3300_PDFJNCDGKGH\u0018\u000b \u0001(\b\u0012/\n\u000fprojection_info\u0018\u0003 \u0001(\u000b2\u0016.LanternProjectionInfo\u0012\u001b\n\u0013Unk3300_DKBJLCIMBAL\u0018\b \u0001(\b\u0012\u0019\n\u0011is_content_closed\u0018\u000e \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LanternProjectionInfoOuterClass.getDescriptor(), LanternRiteFireworksInfoOuterClass.getDescriptor(), SalvageStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LanternRiteActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LanternRiteActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LanternRiteActivityDetailInfo_descriptor, new String[]{"StageInfoList", "FireworksInfo", "Unk3300PDFJNCDGKGH", "ProjectionInfo", "Unk3300DKBJLCIMBAL", "IsContentClosed"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityDetailInfoOuterClass$LanternRiteActivityDetailInfoOrBuilder.class */
    public interface LanternRiteActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<SalvageStageInfoOuterClass.SalvageStageInfo> getStageInfoListList();

        SalvageStageInfoOuterClass.SalvageStageInfo getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListOrBuilderList();

        SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder getStageInfoListOrBuilder(int i);

        boolean hasFireworksInfo();

        LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo getFireworksInfo();

        LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder getFireworksInfoOrBuilder();

        boolean getUnk3300PDFJNCDGKGH();

        boolean hasProjectionInfo();

        LanternProjectionInfoOuterClass.LanternProjectionInfo getProjectionInfo();

        LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder getProjectionInfoOrBuilder();

        boolean getUnk3300DKBJLCIMBAL();

        boolean getIsContentClosed();
    }

    private LanternRiteActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityDetailInfoOuterClass$LanternRiteActivityDetailInfo.class */
    public static final class LanternRiteActivityDetailInfo extends GeneratedMessageV3 implements LanternRiteActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_INFO_LIST_FIELD_NUMBER = 5;
        private List<SalvageStageInfoOuterClass.SalvageStageInfo> stageInfoList_;
        public static final int FIREWORKS_INFO_FIELD_NUMBER = 15;
        private LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo fireworksInfo_;
        public static final int UNK3300_PDFJNCDGKGH_FIELD_NUMBER = 11;
        private boolean unk3300PDFJNCDGKGH_;
        public static final int PROJECTION_INFO_FIELD_NUMBER = 3;
        private LanternProjectionInfoOuterClass.LanternProjectionInfo projectionInfo_;
        public static final int UNK3300_DKBJLCIMBAL_FIELD_NUMBER = 8;
        private boolean unk3300DKBJLCIMBAL_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 14;
        private boolean isContentClosed_;
        private byte memoizedIsInitialized;
        private static final LanternRiteActivityDetailInfo DEFAULT_INSTANCE = new LanternRiteActivityDetailInfo();
        private static final Parser<LanternRiteActivityDetailInfo> PARSER = new AbstractParser<LanternRiteActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public LanternRiteActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LanternRiteActivityDetailInfo(input, extensionRegistry);
            }
        };

        private LanternRiteActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LanternRiteActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.stageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LanternRiteActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LanternRiteActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder subBuilder = this.projectionInfo_ != null ? this.projectionInfo_.toBuilder() : null;
                                    this.projectionInfo_ = (LanternProjectionInfoOuterClass.LanternProjectionInfo) input.readMessage(LanternProjectionInfoOuterClass.LanternProjectionInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.projectionInfo_);
                                        this.projectionInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.stageInfoList_.add((SalvageStageInfoOuterClass.SalvageStageInfo) input.readMessage(SalvageStageInfoOuterClass.SalvageStageInfo.parser(), extensionRegistry));
                                    break;
                                case 64:
                                    this.unk3300DKBJLCIMBAL_ = input.readBool();
                                    break;
                                case 88:
                                    this.unk3300PDFJNCDGKGH_ = input.readBool();
                                    break;
                                case 112:
                                    this.isContentClosed_ = input.readBool();
                                    break;
                                case 122:
                                    LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder subBuilder2 = this.fireworksInfo_ != null ? this.fireworksInfo_.toBuilder() : null;
                                    this.fireworksInfo_ = (LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo) input.readMessage(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.fireworksInfo_);
                                        this.fireworksInfo_ = subBuilder2.buildPartial();
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LanternRiteActivityDetailInfoOuterClass.internal_static_LanternRiteActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LanternRiteActivityDetailInfoOuterClass.internal_static_LanternRiteActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternRiteActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public List<SalvageStageInfoOuterClass.SalvageStageInfo> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public List<? extends SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public SalvageStageInfoOuterClass.SalvageStageInfo getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public boolean hasFireworksInfo() {
            return this.fireworksInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo getFireworksInfo() {
            return this.fireworksInfo_ == null ? LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.getDefaultInstance() : this.fireworksInfo_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder getFireworksInfoOrBuilder() {
            return getFireworksInfo();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public boolean getUnk3300PDFJNCDGKGH() {
            return this.unk3300PDFJNCDGKGH_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public boolean hasProjectionInfo() {
            return this.projectionInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public LanternProjectionInfoOuterClass.LanternProjectionInfo getProjectionInfo() {
            return this.projectionInfo_ == null ? LanternProjectionInfoOuterClass.LanternProjectionInfo.getDefaultInstance() : this.projectionInfo_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder getProjectionInfoOrBuilder() {
            return getProjectionInfo();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public boolean getUnk3300DKBJLCIMBAL() {
            return this.unk3300DKBJLCIMBAL_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
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
            if (this.projectionInfo_ != null) {
                output.writeMessage(3, getProjectionInfo());
            }
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                output.writeMessage(5, this.stageInfoList_.get(i));
            }
            if (this.unk3300DKBJLCIMBAL_) {
                output.writeBool(8, this.unk3300DKBJLCIMBAL_);
            }
            if (this.unk3300PDFJNCDGKGH_) {
                output.writeBool(11, this.unk3300PDFJNCDGKGH_);
            }
            if (this.isContentClosed_) {
                output.writeBool(14, this.isContentClosed_);
            }
            if (this.fireworksInfo_ != null) {
                output.writeMessage(15, getFireworksInfo());
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
            if (this.projectionInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getProjectionInfo());
            }
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.stageInfoList_.get(i));
            }
            if (this.unk3300DKBJLCIMBAL_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.unk3300DKBJLCIMBAL_);
            }
            if (this.unk3300PDFJNCDGKGH_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.unk3300PDFJNCDGKGH_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isContentClosed_);
            }
            if (this.fireworksInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getFireworksInfo());
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
            if (!(obj instanceof LanternRiteActivityDetailInfo)) {
                return equals(obj);
            }
            LanternRiteActivityDetailInfo other = (LanternRiteActivityDetailInfo) obj;
            if (!getStageInfoListList().equals(other.getStageInfoListList()) || hasFireworksInfo() != other.hasFireworksInfo()) {
                return false;
            }
            if ((!hasFireworksInfo() || getFireworksInfo().equals(other.getFireworksInfo())) && getUnk3300PDFJNCDGKGH() == other.getUnk3300PDFJNCDGKGH() && hasProjectionInfo() == other.hasProjectionInfo()) {
                return (!hasProjectionInfo() || getProjectionInfo().equals(other.getProjectionInfo())) && getUnk3300DKBJLCIMBAL() == other.getUnk3300DKBJLCIMBAL() && getIsContentClosed() == other.getIsContentClosed() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getStageInfoListList().hashCode();
            }
            if (hasFireworksInfo()) {
                hash = (53 * ((37 * hash) + 15)) + getFireworksInfo().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 11)) + Internal.hashBoolean(getUnk3300PDFJNCDGKGH());
            if (hasProjectionInfo()) {
                hash2 = (53 * ((37 * hash2) + 3)) + getProjectionInfo().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 8)) + Internal.hashBoolean(getUnk3300DKBJLCIMBAL()))) + 14)) + Internal.hashBoolean(getIsContentClosed()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static LanternRiteActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (LanternRiteActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LanternRiteActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LanternRiteActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (LanternRiteActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LanternRiteActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityDetailInfoOuterClass$LanternRiteActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LanternRiteActivityDetailInfoOrBuilder {
            private int bitField0_;
            private List<SalvageStageInfoOuterClass.SalvageStageInfo> stageInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SalvageStageInfoOuterClass.SalvageStageInfo, SalvageStageInfoOuterClass.SalvageStageInfo.Builder, SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> stageInfoListBuilder_;
            private LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo fireworksInfo_;
            private SingleFieldBuilderV3<LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder> fireworksInfoBuilder_;
            private boolean unk3300PDFJNCDGKGH_;
            private LanternProjectionInfoOuterClass.LanternProjectionInfo projectionInfo_;
            private SingleFieldBuilderV3<LanternProjectionInfoOuterClass.LanternProjectionInfo, LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder, LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder> projectionInfoBuilder_;
            private boolean unk3300DKBJLCIMBAL_;
            private boolean isContentClosed_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LanternRiteActivityDetailInfoOuterClass.internal_static_LanternRiteActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LanternRiteActivityDetailInfoOuterClass.internal_static_LanternRiteActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternRiteActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LanternRiteActivityDetailInfo.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfo_ = null;
                } else {
                    this.fireworksInfo_ = null;
                    this.fireworksInfoBuilder_ = null;
                }
                this.unk3300PDFJNCDGKGH_ = false;
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfo_ = null;
                } else {
                    this.projectionInfo_ = null;
                    this.projectionInfoBuilder_ = null;
                }
                this.unk3300DKBJLCIMBAL_ = false;
                this.isContentClosed_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LanternRiteActivityDetailInfoOuterClass.internal_static_LanternRiteActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LanternRiteActivityDetailInfo getDefaultInstanceForType() {
                return LanternRiteActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteActivityDetailInfo build() {
                LanternRiteActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteActivityDetailInfo buildPartial() {
                LanternRiteActivityDetailInfo result = new LanternRiteActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.stageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageInfoList_ = this.stageInfoList_;
                } else {
                    result.stageInfoList_ = this.stageInfoListBuilder_.build();
                }
                if (this.fireworksInfoBuilder_ == null) {
                    result.fireworksInfo_ = this.fireworksInfo_;
                } else {
                    result.fireworksInfo_ = this.fireworksInfoBuilder_.build();
                }
                result.unk3300PDFJNCDGKGH_ = this.unk3300PDFJNCDGKGH_;
                if (this.projectionInfoBuilder_ == null) {
                    result.projectionInfo_ = this.projectionInfo_;
                } else {
                    result.projectionInfo_ = this.projectionInfoBuilder_.build();
                }
                result.unk3300DKBJLCIMBAL_ = this.unk3300DKBJLCIMBAL_;
                result.isContentClosed_ = this.isContentClosed_;
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
                if (other instanceof LanternRiteActivityDetailInfo) {
                    return mergeFrom((LanternRiteActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LanternRiteActivityDetailInfo other) {
                if (other == LanternRiteActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.stageInfoListBuilder_ == null) {
                    if (!other.stageInfoList_.isEmpty()) {
                        if (this.stageInfoList_.isEmpty()) {
                            this.stageInfoList_ = other.stageInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageInfoListIsMutable();
                            this.stageInfoList_.addAll(other.stageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageInfoList_.isEmpty()) {
                    if (this.stageInfoListBuilder_.isEmpty()) {
                        this.stageInfoListBuilder_.dispose();
                        this.stageInfoListBuilder_ = null;
                        this.stageInfoList_ = other.stageInfoList_;
                        this.bitField0_ &= -2;
                        this.stageInfoListBuilder_ = LanternRiteActivityDetailInfo.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
                    } else {
                        this.stageInfoListBuilder_.addAllMessages(other.stageInfoList_);
                    }
                }
                if (other.hasFireworksInfo()) {
                    mergeFireworksInfo(other.getFireworksInfo());
                }
                if (other.getUnk3300PDFJNCDGKGH()) {
                    setUnk3300PDFJNCDGKGH(other.getUnk3300PDFJNCDGKGH());
                }
                if (other.hasProjectionInfo()) {
                    mergeProjectionInfo(other.getProjectionInfo());
                }
                if (other.getUnk3300DKBJLCIMBAL()) {
                    setUnk3300DKBJLCIMBAL(other.getUnk3300DKBJLCIMBAL());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
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
                LanternRiteActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LanternRiteActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LanternRiteActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageInfoList_ = new ArrayList(this.stageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public List<SalvageStageInfoOuterClass.SalvageStageInfo> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public SalvageStageInfoOuterClass.SalvageStageInfo getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(SalvageStageInfoOuterClass.SalvageStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(SalvageStageInfoOuterClass.SalvageStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends SalvageStageInfoOuterClass.SalvageStageInfo> values) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageInfoList_);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageInfoList() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SalvageStageInfoOuterClass.SalvageStageInfo.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public List<? extends SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public SalvageStageInfoOuterClass.SalvageStageInfo.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(SalvageStageInfoOuterClass.SalvageStageInfo.getDefaultInstance());
            }

            public SalvageStageInfoOuterClass.SalvageStageInfo.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, SalvageStageInfoOuterClass.SalvageStageInfo.getDefaultInstance());
            }

            public List<SalvageStageInfoOuterClass.SalvageStageInfo.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SalvageStageInfoOuterClass.SalvageStageInfo, SalvageStageInfoOuterClass.SalvageStageInfo.Builder, SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageInfoList_ = null;
                }
                return this.stageInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public boolean hasFireworksInfo() {
                return (this.fireworksInfoBuilder_ == null && this.fireworksInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo getFireworksInfo() {
                if (this.fireworksInfoBuilder_ == null) {
                    return this.fireworksInfo_ == null ? LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.getDefaultInstance() : this.fireworksInfo_;
                }
                return this.fireworksInfoBuilder_.getMessage();
            }

            public Builder setFireworksInfo(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo value) {
                if (this.fireworksInfoBuilder_ != null) {
                    this.fireworksInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.fireworksInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFireworksInfo(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder builderForValue) {
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fireworksInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFireworksInfo(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo value) {
                if (this.fireworksInfoBuilder_ == null) {
                    if (this.fireworksInfo_ != null) {
                        this.fireworksInfo_ = LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.newBuilder(this.fireworksInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.fireworksInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.fireworksInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFireworksInfo() {
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfo_ = null;
                    onChanged();
                } else {
                    this.fireworksInfo_ = null;
                    this.fireworksInfoBuilder_ = null;
                }
                return this;
            }

            public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder getFireworksInfoBuilder() {
                onChanged();
                return getFireworksInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder getFireworksInfoOrBuilder() {
                if (this.fireworksInfoBuilder_ != null) {
                    return this.fireworksInfoBuilder_.getMessageOrBuilder();
                }
                return this.fireworksInfo_ == null ? LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.getDefaultInstance() : this.fireworksInfo_;
            }

            private SingleFieldBuilderV3<LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder> getFireworksInfoFieldBuilder() {
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfoBuilder_ = new SingleFieldBuilderV3<>(getFireworksInfo(), getParentForChildren(), isClean());
                    this.fireworksInfo_ = null;
                }
                return this.fireworksInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public boolean getUnk3300PDFJNCDGKGH() {
                return this.unk3300PDFJNCDGKGH_;
            }

            public Builder setUnk3300PDFJNCDGKGH(boolean value) {
                this.unk3300PDFJNCDGKGH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PDFJNCDGKGH() {
                this.unk3300PDFJNCDGKGH_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public boolean hasProjectionInfo() {
                return (this.projectionInfoBuilder_ == null && this.projectionInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public LanternProjectionInfoOuterClass.LanternProjectionInfo getProjectionInfo() {
                if (this.projectionInfoBuilder_ == null) {
                    return this.projectionInfo_ == null ? LanternProjectionInfoOuterClass.LanternProjectionInfo.getDefaultInstance() : this.projectionInfo_;
                }
                return this.projectionInfoBuilder_.getMessage();
            }

            public Builder setProjectionInfo(LanternProjectionInfoOuterClass.LanternProjectionInfo value) {
                if (this.projectionInfoBuilder_ != null) {
                    this.projectionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.projectionInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setProjectionInfo(LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder builderForValue) {
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.projectionInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeProjectionInfo(LanternProjectionInfoOuterClass.LanternProjectionInfo value) {
                if (this.projectionInfoBuilder_ == null) {
                    if (this.projectionInfo_ != null) {
                        this.projectionInfo_ = LanternProjectionInfoOuterClass.LanternProjectionInfo.newBuilder(this.projectionInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.projectionInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.projectionInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearProjectionInfo() {
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfo_ = null;
                    onChanged();
                } else {
                    this.projectionInfo_ = null;
                    this.projectionInfoBuilder_ = null;
                }
                return this;
            }

            public LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder getProjectionInfoBuilder() {
                onChanged();
                return getProjectionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder getProjectionInfoOrBuilder() {
                if (this.projectionInfoBuilder_ != null) {
                    return this.projectionInfoBuilder_.getMessageOrBuilder();
                }
                return this.projectionInfo_ == null ? LanternProjectionInfoOuterClass.LanternProjectionInfo.getDefaultInstance() : this.projectionInfo_;
            }

            private SingleFieldBuilderV3<LanternProjectionInfoOuterClass.LanternProjectionInfo, LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder, LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder> getProjectionInfoFieldBuilder() {
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfoBuilder_ = new SingleFieldBuilderV3<>(getProjectionInfo(), getParentForChildren(), isClean());
                    this.projectionInfo_ = null;
                }
                return this.projectionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public boolean getUnk3300DKBJLCIMBAL() {
                return this.unk3300DKBJLCIMBAL_;
            }

            public Builder setUnk3300DKBJLCIMBAL(boolean value) {
                this.unk3300DKBJLCIMBAL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DKBJLCIMBAL() {
                this.unk3300DKBJLCIMBAL_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
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

        public static LanternRiteActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LanternRiteActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LanternRiteActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanternRiteActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LanternProjectionInfoOuterClass.getDescriptor();
        LanternRiteFireworksInfoOuterClass.getDescriptor();
        SalvageStageInfoOuterClass.getDescriptor();
    }
}
