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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapInfoOuterClass.class */
public final class TreasureMapInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015TreasureMapInfo.proto\u001a\u001bTreasureMapRegionInfo.proto\u001a#TreasureMapBonusChallengeInfo.proto\"³\u0002\n\u000fTreasureMapInfo\u0012\u001c\n\u0014isMpChallengeTouched\u0018\u0006 \u0001(\b\u0012\u0016\n\u000etotalMpSpotNum\u0018\u000e \u0001(\r\u0012.\n\u000eregionInfoList\u0018\u0007 \u0003(\u000b2\u0016.TreasureMapRegionInfo\u0012\u0013\n\u000bcurrencyNum\u0018\u0001 \u0001(\r\u0012\u001a\n\u0012minOpenPlayerLevel\u0018\u0003 \u0001(\r\u0012\u0019\n\u0011activeRegionIndex\u0018\u0002 \u0001(\r\u0012:\n\u0012bonusChallengeList\u0018\u000f \u0003(\u000b2\u001e.TreasureMapBonusChallengeInfo\u0012\u0017\n\u000fpreviewRewardId\u0018\f \u0001(\r\u0012\u0019\n\u0011treasureCloseTime\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TreasureMapRegionInfoOuterClass.getDescriptor(), TreasureMapBonusChallengeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TreasureMapInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureMapInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureMapInfo_descriptor, new String[]{"IsMpChallengeTouched", "TotalMpSpotNum", "RegionInfoList", "CurrencyNum", "MinOpenPlayerLevel", "ActiveRegionIndex", "BonusChallengeList", "PreviewRewardId", "TreasureCloseTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapInfoOuterClass$TreasureMapInfoOrBuilder.class */
    public interface TreasureMapInfoOrBuilder extends MessageOrBuilder {
        boolean getIsMpChallengeTouched();

        int getTotalMpSpotNum();

        List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> getRegionInfoListList();

        TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfoList(int i);

        int getRegionInfoListCount();

        List<? extends TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoListOrBuilderList();

        TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoListOrBuilder(int i);

        int getCurrencyNum();

        int getMinOpenPlayerLevel();

        int getActiveRegionIndex();

        List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> getBonusChallengeListList();

        TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo getBonusChallengeList(int i);

        int getBonusChallengeListCount();

        List<? extends TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> getBonusChallengeListOrBuilderList();

        TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder getBonusChallengeListOrBuilder(int i);

        int getPreviewRewardId();

        int getTreasureCloseTime();
    }

    private TreasureMapInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapInfoOuterClass$TreasureMapInfo.class */
    public static final class TreasureMapInfo extends GeneratedMessageV3 implements TreasureMapInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISMPCHALLENGETOUCHED_FIELD_NUMBER = 6;
        private boolean isMpChallengeTouched_;
        public static final int TOTALMPSPOTNUM_FIELD_NUMBER = 14;
        private int totalMpSpotNum_;
        public static final int REGIONINFOLIST_FIELD_NUMBER = 7;
        private List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> regionInfoList_;
        public static final int CURRENCYNUM_FIELD_NUMBER = 1;
        private int currencyNum_;
        public static final int MINOPENPLAYERLEVEL_FIELD_NUMBER = 3;
        private int minOpenPlayerLevel_;
        public static final int ACTIVEREGIONINDEX_FIELD_NUMBER = 2;
        private int activeRegionIndex_;
        public static final int BONUSCHALLENGELIST_FIELD_NUMBER = 15;
        private List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> bonusChallengeList_;
        public static final int PREVIEWREWARDID_FIELD_NUMBER = 12;
        private int previewRewardId_;
        public static final int TREASURECLOSETIME_FIELD_NUMBER = 5;
        private int treasureCloseTime_;
        private byte memoizedIsInitialized;
        private static final TreasureMapInfo DEFAULT_INSTANCE = new TreasureMapInfo();
        private static final Parser<TreasureMapInfo> PARSER = new AbstractParser<TreasureMapInfo>() { // from class: emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfo.1
            @Override // com.google.protobuf.Parser
            public TreasureMapInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureMapInfo(input, extensionRegistry);
            }
        };

        private TreasureMapInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureMapInfo() {
            this.memoizedIsInitialized = -1;
            this.regionInfoList_ = Collections.emptyList();
            this.bonusChallengeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureMapInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x013d */
        private TreasureMapInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.currencyNum_ = input.readUInt32();
                                break;
                            case 16:
                                this.activeRegionIndex_ = input.readUInt32();
                                break;
                            case 24:
                                this.minOpenPlayerLevel_ = input.readUInt32();
                                break;
                            case 40:
                                this.treasureCloseTime_ = input.readUInt32();
                                break;
                            case 48:
                                this.isMpChallengeTouched_ = input.readBool();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.regionInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.regionInfoList_.add((TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo) input.readMessage(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                this.previewRewardId_ = input.readUInt32();
                                break;
                            case 112:
                                this.totalMpSpotNum_ = input.readUInt32();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.bonusChallengeList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.bonusChallengeList_.add((TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo) input.readMessage(TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.parser(), extensionRegistry));
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
                    this.regionInfoList_ = Collections.unmodifiableList(this.regionInfoList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.bonusChallengeList_ = Collections.unmodifiableList(this.bonusChallengeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TreasureMapInfoOuterClass.internal_static_TreasureMapInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureMapInfoOuterClass.internal_static_TreasureMapInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public boolean getIsMpChallengeTouched() {
            return this.isMpChallengeTouched_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getTotalMpSpotNum() {
            return this.totalMpSpotNum_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> getRegionInfoListList() {
            return this.regionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public List<? extends TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoListOrBuilderList() {
            return this.regionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getRegionInfoListCount() {
            return this.regionInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfoList(int index) {
            return this.regionInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoListOrBuilder(int index) {
            return this.regionInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getCurrencyNum() {
            return this.currencyNum_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getMinOpenPlayerLevel() {
            return this.minOpenPlayerLevel_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getActiveRegionIndex() {
            return this.activeRegionIndex_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> getBonusChallengeListList() {
            return this.bonusChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public List<? extends TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> getBonusChallengeListOrBuilderList() {
            return this.bonusChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getBonusChallengeListCount() {
            return this.bonusChallengeList_.size();
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo getBonusChallengeList(int index) {
            return this.bonusChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder getBonusChallengeListOrBuilder(int index) {
            return this.bonusChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getPreviewRewardId() {
            return this.previewRewardId_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
        public int getTreasureCloseTime() {
            return this.treasureCloseTime_;
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
            if (this.currencyNum_ != 0) {
                output.writeUInt32(1, this.currencyNum_);
            }
            if (this.activeRegionIndex_ != 0) {
                output.writeUInt32(2, this.activeRegionIndex_);
            }
            if (this.minOpenPlayerLevel_ != 0) {
                output.writeUInt32(3, this.minOpenPlayerLevel_);
            }
            if (this.treasureCloseTime_ != 0) {
                output.writeUInt32(5, this.treasureCloseTime_);
            }
            if (this.isMpChallengeTouched_) {
                output.writeBool(6, this.isMpChallengeTouched_);
            }
            for (int i = 0; i < this.regionInfoList_.size(); i++) {
                output.writeMessage(7, this.regionInfoList_.get(i));
            }
            if (this.previewRewardId_ != 0) {
                output.writeUInt32(12, this.previewRewardId_);
            }
            if (this.totalMpSpotNum_ != 0) {
                output.writeUInt32(14, this.totalMpSpotNum_);
            }
            for (int i2 = 0; i2 < this.bonusChallengeList_.size(); i2++) {
                output.writeMessage(15, this.bonusChallengeList_.get(i2));
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
            if (this.currencyNum_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.currencyNum_);
            }
            if (this.activeRegionIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.activeRegionIndex_);
            }
            if (this.minOpenPlayerLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.minOpenPlayerLevel_);
            }
            if (this.treasureCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.treasureCloseTime_);
            }
            if (this.isMpChallengeTouched_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isMpChallengeTouched_);
            }
            for (int i = 0; i < this.regionInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.regionInfoList_.get(i));
            }
            if (this.previewRewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.previewRewardId_);
            }
            if (this.totalMpSpotNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.totalMpSpotNum_);
            }
            for (int i2 = 0; i2 < this.bonusChallengeList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.bonusChallengeList_.get(i2));
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
            if (!(obj instanceof TreasureMapInfo)) {
                return equals(obj);
            }
            TreasureMapInfo other = (TreasureMapInfo) obj;
            return getIsMpChallengeTouched() == other.getIsMpChallengeTouched() && getTotalMpSpotNum() == other.getTotalMpSpotNum() && getRegionInfoListList().equals(other.getRegionInfoListList()) && getCurrencyNum() == other.getCurrencyNum() && getMinOpenPlayerLevel() == other.getMinOpenPlayerLevel() && getActiveRegionIndex() == other.getActiveRegionIndex() && getBonusChallengeListList().equals(other.getBonusChallengeListList()) && getPreviewRewardId() == other.getPreviewRewardId() && getTreasureCloseTime() == other.getTreasureCloseTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashBoolean(getIsMpChallengeTouched()))) + 14)) + getTotalMpSpotNum();
            if (getRegionInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getRegionInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getCurrencyNum())) + 3)) + getMinOpenPlayerLevel())) + 2)) + getActiveRegionIndex();
            if (getBonusChallengeListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 15)) + getBonusChallengeListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 12)) + getPreviewRewardId())) + 5)) + getTreasureCloseTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static TreasureMapInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapInfo parseFrom(InputStream input) throws IOException {
            return (TreasureMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureMapInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureMapInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapInfo parseFrom(CodedInputStream input) throws IOException {
            return (TreasureMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureMapInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapInfoOuterClass$TreasureMapInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureMapInfoOrBuilder {
            private int bitField0_;
            private boolean isMpChallengeTouched_;
            private int totalMpSpotNum_;
            private RepeatedFieldBuilderV3<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> regionInfoListBuilder_;
            private int currencyNum_;
            private int minOpenPlayerLevel_;
            private int activeRegionIndex_;
            private RepeatedFieldBuilderV3<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo.Builder, TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder> bonusChallengeListBuilder_;
            private int previewRewardId_;
            private int treasureCloseTime_;
            private List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> regionInfoList_ = Collections.emptyList();
            private List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> bonusChallengeList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureMapInfoOuterClass.internal_static_TreasureMapInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureMapInfoOuterClass.internal_static_TreasureMapInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureMapInfo.alwaysUseFieldBuilders) {
                    getRegionInfoListFieldBuilder();
                    getBonusChallengeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isMpChallengeTouched_ = false;
                this.totalMpSpotNum_ = 0;
                if (this.regionInfoListBuilder_ == null) {
                    this.regionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.regionInfoListBuilder_.clear();
                }
                this.currencyNum_ = 0;
                this.minOpenPlayerLevel_ = 0;
                this.activeRegionIndex_ = 0;
                if (this.bonusChallengeListBuilder_ == null) {
                    this.bonusChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.bonusChallengeListBuilder_.clear();
                }
                this.previewRewardId_ = 0;
                this.treasureCloseTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureMapInfoOuterClass.internal_static_TreasureMapInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureMapInfo getDefaultInstanceForType() {
                return TreasureMapInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapInfo build() {
                TreasureMapInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapInfo buildPartial() {
                TreasureMapInfo result = new TreasureMapInfo(this);
                int i = this.bitField0_;
                result.isMpChallengeTouched_ = this.isMpChallengeTouched_;
                result.totalMpSpotNum_ = this.totalMpSpotNum_;
                if (this.regionInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.regionInfoList_ = Collections.unmodifiableList(this.regionInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.regionInfoList_ = this.regionInfoList_;
                } else {
                    result.regionInfoList_ = this.regionInfoListBuilder_.build();
                }
                result.currencyNum_ = this.currencyNum_;
                result.minOpenPlayerLevel_ = this.minOpenPlayerLevel_;
                result.activeRegionIndex_ = this.activeRegionIndex_;
                if (this.bonusChallengeListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.bonusChallengeList_ = Collections.unmodifiableList(this.bonusChallengeList_);
                        this.bitField0_ &= -3;
                    }
                    result.bonusChallengeList_ = this.bonusChallengeList_;
                } else {
                    result.bonusChallengeList_ = this.bonusChallengeListBuilder_.build();
                }
                result.previewRewardId_ = this.previewRewardId_;
                result.treasureCloseTime_ = this.treasureCloseTime_;
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
                if (other instanceof TreasureMapInfo) {
                    return mergeFrom((TreasureMapInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureMapInfo other) {
                if (other == TreasureMapInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsMpChallengeTouched()) {
                    setIsMpChallengeTouched(other.getIsMpChallengeTouched());
                }
                if (other.getTotalMpSpotNum() != 0) {
                    setTotalMpSpotNum(other.getTotalMpSpotNum());
                }
                if (this.regionInfoListBuilder_ == null) {
                    if (!other.regionInfoList_.isEmpty()) {
                        if (this.regionInfoList_.isEmpty()) {
                            this.regionInfoList_ = other.regionInfoList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.regionInfoListBuilder_ = TreasureMapInfo.alwaysUseFieldBuilders ? getRegionInfoListFieldBuilder() : null;
                    } else {
                        this.regionInfoListBuilder_.addAllMessages(other.regionInfoList_);
                    }
                }
                if (other.getCurrencyNum() != 0) {
                    setCurrencyNum(other.getCurrencyNum());
                }
                if (other.getMinOpenPlayerLevel() != 0) {
                    setMinOpenPlayerLevel(other.getMinOpenPlayerLevel());
                }
                if (other.getActiveRegionIndex() != 0) {
                    setActiveRegionIndex(other.getActiveRegionIndex());
                }
                if (this.bonusChallengeListBuilder_ == null) {
                    if (!other.bonusChallengeList_.isEmpty()) {
                        if (this.bonusChallengeList_.isEmpty()) {
                            this.bonusChallengeList_ = other.bonusChallengeList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.bonusChallengeListBuilder_ = TreasureMapInfo.alwaysUseFieldBuilders ? getBonusChallengeListFieldBuilder() : null;
                    } else {
                        this.bonusChallengeListBuilder_.addAllMessages(other.bonusChallengeList_);
                    }
                }
                if (other.getPreviewRewardId() != 0) {
                    setPreviewRewardId(other.getPreviewRewardId());
                }
                if (other.getTreasureCloseTime() != 0) {
                    setTreasureCloseTime(other.getTreasureCloseTime());
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
                TreasureMapInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureMapInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureMapInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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

            private void ensureRegionInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.regionInfoList_ = new ArrayList(this.regionInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
            public List<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo> getRegionInfoListList() {
                if (this.regionInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.regionInfoList_);
                }
                return this.regionInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
            public int getRegionInfoListCount() {
                if (this.regionInfoListBuilder_ == null) {
                    return this.regionInfoList_.size();
                }
                return this.regionInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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
                    this.bitField0_ &= -2;
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

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoListOrBuilder(int index) {
                if (this.regionInfoListBuilder_ == null) {
                    return this.regionInfoList_.get(index);
                }
                return this.regionInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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
                    this.regionInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.regionInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.regionInfoList_ = null;
                }
                return this.regionInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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
                if ((this.bitField0_ & 2) == 0) {
                    this.bonusChallengeList_ = new ArrayList(this.bonusChallengeList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
            public List<TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfo> getBonusChallengeListList() {
                if (this.bonusChallengeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.bonusChallengeList_);
                }
                return this.bonusChallengeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
            public int getBonusChallengeListCount() {
                if (this.bonusChallengeListBuilder_ == null) {
                    return this.bonusChallengeList_.size();
                }
                return this.bonusChallengeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
            public TreasureMapBonusChallengeInfoOuterClass.TreasureMapBonusChallengeInfoOrBuilder getBonusChallengeListOrBuilder(int index) {
                if (this.bonusChallengeListBuilder_ == null) {
                    return this.bonusChallengeList_.get(index);
                }
                return this.bonusChallengeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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
                    this.bonusChallengeListBuilder_ = new RepeatedFieldBuilderV3<>(this.bonusChallengeList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.bonusChallengeList_ = null;
                }
                return this.bonusChallengeListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TreasureMapInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureMapInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureMapInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureMapInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TreasureMapRegionInfoOuterClass.getDescriptor();
        TreasureMapBonusChallengeInfoOuterClass.getDescriptor();
    }
}
