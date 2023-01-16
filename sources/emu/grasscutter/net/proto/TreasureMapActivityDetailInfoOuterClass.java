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
import emu.grasscutter.net.proto.TreasureMapBonusChallengeInfoOuterClass;
import emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapActivityDetailInfoOuterClass.class */
public final class TreasureMapActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#TreasureMapActivityDetailInfo.proto\u001a#TreasureMapBonusChallengeInfo.proto\u001a\u001bTreasureMapRegionInfo.proto\"Õ\u0002\n\u001dTreasureMapActivityDetailInfo\u0012\u001f\n\u0017is_mp_challenge_touched\u0018\u000f \u0001(\b\u0012\u0019\n\u0011total_mp_spot_num\u0018\f \u0001(\r\u0012\u001b\n\u0013active_region_index\u0018\u0003 \u0001(\r\u0012<\n\u0014bonus_challenge_list\u0018\r \u0003(\u000b2\u001e.TreasureMapBonusChallengeInfo\u0012\u001d\n\u0015min_open_player_level\u0018\b \u0001(\r\u0012\u0019\n\u0011preview_reward_id\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013treasure_close_time\u0018\u0001 \u0001(\r\u0012\u0014\n\fcurrency_num\u0018\u0004 \u0001(\r\u00120\n\u0010region_info_list\u0018\u000b \u0003(\u000b2\u0016.TreasureMapRegionInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TreasureMapBonusChallengeInfoOuterClass.getDescriptor(), TreasureMapRegionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TreasureMapActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureMapActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureMapActivityDetailInfo_descriptor, new String[]{"IsMpChallengeTouched", "TotalMpSpotNum", "ActiveRegionIndex", "BonusChallengeList", "MinOpenPlayerLevel", "PreviewRewardId", "TreasureCloseTime", "CurrencyNum", "RegionInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapActivityDetailInfoOuterClass$TreasureMapActivityDetailInfoOrBuilder.class */
    public interface TreasureMapActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsMpChallengeTouched();

        int getTotalMpSpotNum();

        int getActiveRegionIndex();

        List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> getBonusChallengeListList();

        TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo getBonusChallengeList(int i);

        int getBonusChallengeListCount();

        List<? extends TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> getBonusChallengeListOrBuilderList();

        TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder getBonusChallengeListOrBuilder(int i);

        int getMinOpenPlayerLevel();

        int getPreviewRewardId();

        int getTreasureCloseTime();

        int getCurrencyNum();

        List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> getRegionInfoListList();

        TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfoList(int i);

        int getRegionInfoListCount();

        List<? extends TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoListOrBuilderList();

        TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoListOrBuilder(int i);
    }

    private TreasureMapActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapActivityDetailInfoOuterClass$TreasureMapActivityDetailInfo.class */
    public static final class TreasureMapActivityDetailInfo extends GeneratedMessageV3 implements TreasureMapActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_MP_CHALLENGE_TOUCHED_FIELD_NUMBER = 15;
        private boolean isMpChallengeTouched_;
        public static final int TOTAL_MP_SPOT_NUM_FIELD_NUMBER = 12;
        private int totalMpSpotNum_;
        public static final int ACTIVE_REGION_INDEX_FIELD_NUMBER = 3;
        private int activeRegionIndex_;
        public static final int BONUS_CHALLENGE_LIST_FIELD_NUMBER = 13;
        private List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> bonusChallengeList_;
        public static final int MIN_OPEN_PLAYER_LEVEL_FIELD_NUMBER = 8;
        private int minOpenPlayerLevel_;
        public static final int PREVIEW_REWARD_ID_FIELD_NUMBER = 2;
        private int previewRewardId_;
        public static final int TREASURE_CLOSE_TIME_FIELD_NUMBER = 1;
        private int treasureCloseTime_;
        public static final int CURRENCY_NUM_FIELD_NUMBER = 4;
        private int currencyNum_;
        public static final int REGION_INFO_LIST_FIELD_NUMBER = 11;
        private List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> regionInfoList_;
        private byte memoizedIsInitialized;
        private static final TreasureMapActivityDetailInfo DEFAULT_INSTANCE = new TreasureMapActivityDetailInfo();
        private static final Parser<TreasureMapActivityDetailInfo> PARSER = new AbstractParser<TreasureMapActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public TreasureMapActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureMapActivityDetailInfo(input, extensionRegistry);
            }
        };

        private TreasureMapActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureMapActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.bonusChallengeList_ = Collections.emptyList();
            this.regionInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureMapActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x013d */
        private TreasureMapActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.treasureCloseTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.previewRewardId_ = input.readUInt32();
                                break;
                            case 24:
                                this.activeRegionIndex_ = input.readUInt32();
                                break;
                            case 32:
                                this.currencyNum_ = input.readUInt32();
                                break;
                            case 64:
                                this.minOpenPlayerLevel_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.regionInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.regionInfoList_.add((TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo) input.readMessage(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                this.totalMpSpotNum_ = input.readUInt32();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.bonusChallengeList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.bonusChallengeList_.add((TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo) input.readMessage(TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.parser(), extensionRegistry));
                                break;
                            case 120:
                                this.isMpChallengeTouched_ = input.readBool();
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
                    this.regionInfoList_ = Collections.unmodifiableList(this.regionInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.bonusChallengeList_ = Collections.unmodifiableList(this.bonusChallengeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TreasureMapActivityDetailInfoOuterClass.internal_static_TreasureMapActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureMapActivityDetailInfoOuterClass.internal_static_TreasureMapActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public boolean getIsMpChallengeTouched() {
            return this.isMpChallengeTouched_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getTotalMpSpotNum() {
            return this.totalMpSpotNum_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getActiveRegionIndex() {
            return this.activeRegionIndex_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> getBonusChallengeListList() {
            return this.bonusChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public List<? extends TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> getBonusChallengeListOrBuilderList() {
            return this.bonusChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getBonusChallengeListCount() {
            return this.bonusChallengeList_.size();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo getBonusChallengeList(int index) {
            return this.bonusChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder getBonusChallengeListOrBuilder(int index) {
            return this.bonusChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getMinOpenPlayerLevel() {
            return this.minOpenPlayerLevel_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getPreviewRewardId() {
            return this.previewRewardId_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getTreasureCloseTime() {
            return this.treasureCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getCurrencyNum() {
            return this.currencyNum_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> getRegionInfoListList() {
            return this.regionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public List<? extends TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoListOrBuilderList() {
            return this.regionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public int getRegionInfoListCount() {
            return this.regionInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfoList(int index) {
            return this.regionInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
        public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoListOrBuilder(int index) {
            return this.regionInfoList_.get(index);
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
            if (this.treasureCloseTime_ != 0) {
                output.writeUInt32(1, this.treasureCloseTime_);
            }
            if (this.previewRewardId_ != 0) {
                output.writeUInt32(2, this.previewRewardId_);
            }
            if (this.activeRegionIndex_ != 0) {
                output.writeUInt32(3, this.activeRegionIndex_);
            }
            if (this.currencyNum_ != 0) {
                output.writeUInt32(4, this.currencyNum_);
            }
            if (this.minOpenPlayerLevel_ != 0) {
                output.writeUInt32(8, this.minOpenPlayerLevel_);
            }
            for (int i = 0; i < this.regionInfoList_.size(); i++) {
                output.writeMessage(11, this.regionInfoList_.get(i));
            }
            if (this.totalMpSpotNum_ != 0) {
                output.writeUInt32(12, this.totalMpSpotNum_);
            }
            for (int i2 = 0; i2 < this.bonusChallengeList_.size(); i2++) {
                output.writeMessage(13, this.bonusChallengeList_.get(i2));
            }
            if (this.isMpChallengeTouched_) {
                output.writeBool(15, this.isMpChallengeTouched_);
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
            if (this.treasureCloseTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.treasureCloseTime_);
            }
            if (this.previewRewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.previewRewardId_);
            }
            if (this.activeRegionIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.activeRegionIndex_);
            }
            if (this.currencyNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.currencyNum_);
            }
            if (this.minOpenPlayerLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.minOpenPlayerLevel_);
            }
            for (int i = 0; i < this.regionInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.regionInfoList_.get(i));
            }
            if (this.totalMpSpotNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.totalMpSpotNum_);
            }
            for (int i2 = 0; i2 < this.bonusChallengeList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.bonusChallengeList_.get(i2));
            }
            if (this.isMpChallengeTouched_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isMpChallengeTouched_);
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
            if (!(obj instanceof TreasureMapActivityDetailInfo)) {
                return equals(obj);
            }
            TreasureMapActivityDetailInfo other = (TreasureMapActivityDetailInfo) obj;
            return getIsMpChallengeTouched() == other.getIsMpChallengeTouched() && getTotalMpSpotNum() == other.getTotalMpSpotNum() && getActiveRegionIndex() == other.getActiveRegionIndex() && getBonusChallengeListList().equals(other.getBonusChallengeListList()) && getMinOpenPlayerLevel() == other.getMinOpenPlayerLevel() && getPreviewRewardId() == other.getPreviewRewardId() && getTreasureCloseTime() == other.getTreasureCloseTime() && getCurrencyNum() == other.getCurrencyNum() && getRegionInfoListList().equals(other.getRegionInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + Internal.hashBoolean(getIsMpChallengeTouched()))) + 12)) + getTotalMpSpotNum())) + 3)) + getActiveRegionIndex();
            if (getBonusChallengeListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getBonusChallengeListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + getMinOpenPlayerLevel())) + 2)) + getPreviewRewardId())) + 1)) + getTreasureCloseTime())) + 4)) + getCurrencyNum();
            if (getRegionInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getRegionInfoListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static TreasureMapActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (TreasureMapActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureMapActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureMapActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (TreasureMapActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureMapActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapActivityDetailInfoOuterClass$TreasureMapActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureMapActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isMpChallengeTouched_;
            private int totalMpSpotNum_;
            private int activeRegionIndex_;
            private RepeatedFieldBuilderV3<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> bonusChallengeListBuilder_;
            private int minOpenPlayerLevel_;
            private int previewRewardId_;
            private int treasureCloseTime_;
            private int currencyNum_;
            private RepeatedFieldBuilderV3<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> regionInfoListBuilder_;
            private List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> bonusChallengeList_ = Collections.emptyList();
            private List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> regionInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureMapActivityDetailInfoOuterClass.internal_static_TreasureMapActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureMapActivityDetailInfoOuterClass.internal_static_TreasureMapActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureMapActivityDetailInfo.alwaysUseFieldBuilders) {
                    getBonusChallengeListFieldBuilder();
                    getRegionInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isMpChallengeTouched_ = false;
                this.totalMpSpotNum_ = 0;
                this.activeRegionIndex_ = 0;
                if (this.bonusChallengeListBuilder_ == null) {
                    this.bonusChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.bonusChallengeListBuilder_.clear();
                }
                this.minOpenPlayerLevel_ = 0;
                this.previewRewardId_ = 0;
                this.treasureCloseTime_ = 0;
                this.currencyNum_ = 0;
                if (this.regionInfoListBuilder_ == null) {
                    this.regionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.regionInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureMapActivityDetailInfoOuterClass.internal_static_TreasureMapActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureMapActivityDetailInfo getDefaultInstanceForType() {
                return TreasureMapActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapActivityDetailInfo build() {
                TreasureMapActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapActivityDetailInfo buildPartial() {
                TreasureMapActivityDetailInfo result = new TreasureMapActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isMpChallengeTouched_ = this.isMpChallengeTouched_;
                result.totalMpSpotNum_ = this.totalMpSpotNum_;
                result.activeRegionIndex_ = this.activeRegionIndex_;
                if (this.bonusChallengeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.bonusChallengeList_ = Collections.unmodifiableList(this.bonusChallengeList_);
                        this.bitField0_ &= -2;
                    }
                    result.bonusChallengeList_ = this.bonusChallengeList_;
                } else {
                    result.bonusChallengeList_ = this.bonusChallengeListBuilder_.build();
                }
                result.minOpenPlayerLevel_ = this.minOpenPlayerLevel_;
                result.previewRewardId_ = this.previewRewardId_;
                result.treasureCloseTime_ = this.treasureCloseTime_;
                result.currencyNum_ = this.currencyNum_;
                if (this.regionInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.regionInfoList_ = Collections.unmodifiableList(this.regionInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.regionInfoList_ = this.regionInfoList_;
                } else {
                    result.regionInfoList_ = this.regionInfoListBuilder_.build();
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
                if (other instanceof TreasureMapActivityDetailInfo) {
                    return mergeFrom((TreasureMapActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureMapActivityDetailInfo other) {
                if (other == TreasureMapActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsMpChallengeTouched()) {
                    setIsMpChallengeTouched(other.getIsMpChallengeTouched());
                }
                if (other.getTotalMpSpotNum() != 0) {
                    setTotalMpSpotNum(other.getTotalMpSpotNum());
                }
                if (other.getActiveRegionIndex() != 0) {
                    setActiveRegionIndex(other.getActiveRegionIndex());
                }
                if (this.bonusChallengeListBuilder_ == null) {
                    if (!other.bonusChallengeList_.isEmpty()) {
                        if (this.bonusChallengeList_.isEmpty()) {
                            this.bonusChallengeList_ = other.bonusChallengeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBonusChallengeListIsMutable();
                            this.bonusChallengeList_.addAll(other.bonusChallengeList_);
                        }
                        onChanged();
                    }
                } else if (!other.bonusChallengeList_.isEmpty()) {
                    if (this.bonusChallengeListBuilder_.isEmpty()) {
                        this.bonusChallengeListBuilder_.dispose();
                        this.bonusChallengeListBuilder_ = null;
                        this.bonusChallengeList_ = other.bonusChallengeList_;
                        this.bitField0_ &= -2;
                        this.bonusChallengeListBuilder_ = TreasureMapActivityDetailInfo.alwaysUseFieldBuilders ? getBonusChallengeListFieldBuilder() : null;
                    } else {
                        this.bonusChallengeListBuilder_.addAllMessages(other.bonusChallengeList_);
                    }
                }
                if (other.getMinOpenPlayerLevel() != 0) {
                    setMinOpenPlayerLevel(other.getMinOpenPlayerLevel());
                }
                if (other.getPreviewRewardId() != 0) {
                    setPreviewRewardId(other.getPreviewRewardId());
                }
                if (other.getTreasureCloseTime() != 0) {
                    setTreasureCloseTime(other.getTreasureCloseTime());
                }
                if (other.getCurrencyNum() != 0) {
                    setCurrencyNum(other.getCurrencyNum());
                }
                if (this.regionInfoListBuilder_ == null) {
                    if (!other.regionInfoList_.isEmpty()) {
                        if (this.regionInfoList_.isEmpty()) {
                            this.regionInfoList_ = other.regionInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureRegionInfoListIsMutable();
                            this.regionInfoList_.addAll(other.regionInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.regionInfoList_.isEmpty()) {
                    if (this.regionInfoListBuilder_.isEmpty()) {
                        this.regionInfoListBuilder_.dispose();
                        this.regionInfoListBuilder_ = null;
                        this.regionInfoList_ = other.regionInfoList_;
                        this.bitField0_ &= -3;
                        this.regionInfoListBuilder_ = TreasureMapActivityDetailInfo.alwaysUseFieldBuilders ? getRegionInfoListFieldBuilder() : null;
                    } else {
                        this.regionInfoListBuilder_.addAllMessages(other.regionInfoList_);
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
                TreasureMapActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureMapActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureMapActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public boolean getIsMpChallengeTouched() {
                return this.isMpChallengeTouched_;
            }

            public Builder setIsMpChallengeTouched(boolean value) {
                this.isMpChallengeTouched_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsMpChallengeTouched() {
                this.isMpChallengeTouched_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getTotalMpSpotNum() {
                return this.totalMpSpotNum_;
            }

            public Builder setTotalMpSpotNum(int value) {
                this.totalMpSpotNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalMpSpotNum() {
                this.totalMpSpotNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getActiveRegionIndex() {
                return this.activeRegionIndex_;
            }

            public Builder setActiveRegionIndex(int value) {
                this.activeRegionIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearActiveRegionIndex() {
                this.activeRegionIndex_ = 0;
                onChanged();
                return this;
            }

            private void ensureBonusChallengeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.bonusChallengeList_ = new ArrayList(this.bonusChallengeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> getBonusChallengeListList() {
                if (this.bonusChallengeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.bonusChallengeList_);
                }
                return this.bonusChallengeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getBonusChallengeListCount() {
                if (this.bonusChallengeListBuilder_ == null) {
                    return this.bonusChallengeList_.size();
                }
                return this.bonusChallengeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo getBonusChallengeList(int index) {
                if (this.bonusChallengeListBuilder_ == null) {
                    return this.bonusChallengeList_.get(index);
                }
                return this.bonusChallengeListBuilder_.getMessage(index);
            }

            public Builder setBonusChallengeList(int index, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo value) {
                if (this.bonusChallengeListBuilder_ != null) {
                    this.bonusChallengeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBonusChallengeList(int index, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder builderForValue) {
                if (this.bonusChallengeListBuilder_ == null) {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bonusChallengeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBonusChallengeList(TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo value) {
                if (this.bonusChallengeListBuilder_ != null) {
                    this.bonusChallengeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBonusChallengeList(int index, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo value) {
                if (this.bonusChallengeListBuilder_ != null) {
                    this.bonusChallengeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBonusChallengeList(TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder builderForValue) {
                if (this.bonusChallengeListBuilder_ == null) {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.bonusChallengeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBonusChallengeList(int index, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder builderForValue) {
                if (this.bonusChallengeListBuilder_ == null) {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bonusChallengeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBonusChallengeList(Iterable<? extends TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> values) {
                if (this.bonusChallengeListBuilder_ == null) {
                    ensureBonusChallengeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.bonusChallengeList_);
                    onChanged();
                } else {
                    this.bonusChallengeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBonusChallengeList() {
                if (this.bonusChallengeListBuilder_ == null) {
                    this.bonusChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.bonusChallengeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBonusChallengeList(int index) {
                if (this.bonusChallengeListBuilder_ == null) {
                    ensureBonusChallengeListIsMutable();
                    this.bonusChallengeList_.remove(index);
                    onChanged();
                } else {
                    this.bonusChallengeListBuilder_.remove(index);
                }
                return this;
            }

            public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder getBonusChallengeListBuilder(int index) {
                return getBonusChallengeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder getBonusChallengeListOrBuilder(int index) {
                if (this.bonusChallengeListBuilder_ == null) {
                    return this.bonusChallengeList_.get(index);
                }
                return this.bonusChallengeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public List<? extends TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> getBonusChallengeListOrBuilderList() {
                if (this.bonusChallengeListBuilder_ != null) {
                    return this.bonusChallengeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.bonusChallengeList_);
            }

            public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder addBonusChallengeListBuilder() {
                return getBonusChallengeListFieldBuilder().addBuilder(TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.getDefaultInstance());
            }

            public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder addBonusChallengeListBuilder(int index) {
                return getBonusChallengeListFieldBuilder().addBuilder(index, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.getDefaultInstance());
            }

            public List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder> getBonusChallengeListBuilderList() {
                return getBonusChallengeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> getBonusChallengeListFieldBuilder() {
                if (this.bonusChallengeListBuilder_ == null) {
                    this.bonusChallengeListBuilder_ = new RepeatedFieldBuilderV3<>(this.bonusChallengeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.bonusChallengeList_ = null;
                }
                return this.bonusChallengeListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getMinOpenPlayerLevel() {
                return this.minOpenPlayerLevel_;
            }

            public Builder setMinOpenPlayerLevel(int value) {
                this.minOpenPlayerLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinOpenPlayerLevel() {
                this.minOpenPlayerLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getPreviewRewardId() {
                return this.previewRewardId_;
            }

            public Builder setPreviewRewardId(int value) {
                this.previewRewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPreviewRewardId() {
                this.previewRewardId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getTreasureCloseTime() {
                return this.treasureCloseTime_;
            }

            public Builder setTreasureCloseTime(int value) {
                this.treasureCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTreasureCloseTime() {
                this.treasureCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getCurrencyNum() {
                return this.currencyNum_;
            }

            public Builder setCurrencyNum(int value) {
                this.currencyNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrencyNum() {
                this.currencyNum_ = 0;
                onChanged();
                return this;
            }

            private void ensureRegionInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.regionInfoList_ = new ArrayList(this.regionInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> getRegionInfoListList() {
                if (this.regionInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.regionInfoList_);
                }
                return this.regionInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public int getRegionInfoListCount() {
                if (this.regionInfoListBuilder_ == null) {
                    return this.regionInfoList_.size();
                }
                return this.regionInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfoList(int index) {
                if (this.regionInfoListBuilder_ == null) {
                    return this.regionInfoList_.get(index);
                }
                return this.regionInfoListBuilder_.getMessage(index);
            }

            public Builder setRegionInfoList(int index, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo value) {
                if (this.regionInfoListBuilder_ != null) {
                    this.regionInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRegionInfoList(int index, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder builderForValue) {
                if (this.regionInfoListBuilder_ == null) {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.regionInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRegionInfoList(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo value) {
                if (this.regionInfoListBuilder_ != null) {
                    this.regionInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRegionInfoList(int index, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo value) {
                if (this.regionInfoListBuilder_ != null) {
                    this.regionInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRegionInfoList(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder builderForValue) {
                if (this.regionInfoListBuilder_ == null) {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.regionInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRegionInfoList(int index, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder builderForValue) {
                if (this.regionInfoListBuilder_ == null) {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.regionInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRegionInfoList(Iterable<? extends TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> values) {
                if (this.regionInfoListBuilder_ == null) {
                    ensureRegionInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.regionInfoList_);
                    onChanged();
                } else {
                    this.regionInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRegionInfoList() {
                if (this.regionInfoListBuilder_ == null) {
                    this.regionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.regionInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRegionInfoList(int index) {
                if (this.regionInfoListBuilder_ == null) {
                    ensureRegionInfoListIsMutable();
                    this.regionInfoList_.remove(index);
                    onChanged();
                } else {
                    this.regionInfoListBuilder_.remove(index);
                }
                return this;
            }

            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder getRegionInfoListBuilder(int index) {
                return getRegionInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoListOrBuilder(int index) {
                if (this.regionInfoListBuilder_ == null) {
                    return this.regionInfoList_.get(index);
                }
                return this.regionInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder
            public List<? extends TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoListOrBuilderList() {
                if (this.regionInfoListBuilder_ != null) {
                    return this.regionInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.regionInfoList_);
            }

            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder addRegionInfoListBuilder() {
                return getRegionInfoListFieldBuilder().addBuilder(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.getDefaultInstance());
            }

            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder addRegionInfoListBuilder(int index) {
                return getRegionInfoListFieldBuilder().addBuilder(index, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.getDefaultInstance());
            }

            public List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder> getRegionInfoListBuilderList() {
                return getRegionInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoListFieldBuilder() {
                if (this.regionInfoListBuilder_ == null) {
                    this.regionInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.regionInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.regionInfoList_ = null;
                }
                return this.regionInfoListBuilder_;
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

        public static TreasureMapActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureMapActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureMapActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureMapActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TreasureMapBonusChallengeInfoOuterClass.getDescriptor();
        TreasureMapRegionInfoOuterClass.getDescriptor();
    }
}
