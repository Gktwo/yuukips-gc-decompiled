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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.WinterCampRaceStageInfoOuterClass;
import emu.grasscutter.net.proto.WinterCampStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampActivityDetailInfoOuterClass.class */
public final class WinterCampActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"WinterCampActivityDetailInfo.proto\u001a\u000fItemParam.proto\u001a\u001dWinterCampRaceStageInfo.proto\u001a\u0019WinterCampStageInfo.proto\"½\u0002\n\u001cWinterCampActivityDetailInfo\u0012*\n\fexplore_info\u0018\u0003 \u0001(\u000b2\u0014.WinterCampStageInfo\u0012\u001b\n\u0013Unk3300_KCGKNJFGCFC\u0018\u0004 \u0003(\r\u0012\u0019\n\u0011is_content_closed\u0018\f \u0001(\b\u0012\u001b\n\u0013Unk3300_CMNIBPMOECO\u0018\u0005 \u0003(\r\u0012\u001b\n\u0013Unk3300_FHNNJJDGLOO\u0018\u0006 \u0003(\r\u0012\"\n\u000eused_item_list\u0018\u000e \u0003(\u000b2\n.ItemParam\u0012)\n\u000bbattle_info\u0018\t \u0001(\u000b2\u0014.WinterCampStageInfo\u00120\n\u000erace_info_list\u0018\r \u0003(\u000b2\u0018.WinterCampRaceStageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor(), WinterCampRaceStageInfoOuterClass.getDescriptor(), WinterCampStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampActivityDetailInfo_descriptor, new String[]{"ExploreInfo", "Unk3300KCGKNJFGCFC", "IsContentClosed", "Unk3300CMNIBPMOECO", "Unk3300FHNNJJDGLOO", "UsedItemList", "BattleInfo", "RaceInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampActivityDetailInfoOuterClass$WinterCampActivityDetailInfoOrBuilder.class */
    public interface WinterCampActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean hasExploreInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfo getExploreInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getExploreInfoOrBuilder();

        List<Integer> getUnk3300KCGKNJFGCFCList();

        int getUnk3300KCGKNJFGCFCCount();

        int getUnk3300KCGKNJFGCFC(int i);

        boolean getIsContentClosed();

        List<Integer> getUnk3300CMNIBPMOECOList();

        int getUnk3300CMNIBPMOECOCount();

        int getUnk3300CMNIBPMOECO(int i);

        List<Integer> getUnk3300FHNNJJDGLOOList();

        int getUnk3300FHNNJJDGLOOCount();

        int getUnk3300FHNNJJDGLOO(int i);

        List<ItemParamOuterClass.ItemParam> getUsedItemListList();

        ItemParamOuterClass.ItemParam getUsedItemList(int i);

        int getUsedItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getUsedItemListOrBuilder(int i);

        boolean hasBattleInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfo getBattleInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getBattleInfoOrBuilder();

        List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> getRaceInfoListList();

        WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo getRaceInfoList(int i);

        int getRaceInfoListCount();

        List<? extends WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> getRaceInfoListOrBuilderList();

        WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder getRaceInfoListOrBuilder(int i);
    }

    private WinterCampActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampActivityDetailInfoOuterClass$WinterCampActivityDetailInfo.class */
    public static final class WinterCampActivityDetailInfo extends GeneratedMessageV3 implements WinterCampActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXPLORE_INFO_FIELD_NUMBER = 3;
        private WinterCampStageInfoOuterClass.WinterCampStageInfo exploreInfo_;
        public static final int UNK3300_KCGKNJFGCFC_FIELD_NUMBER = 4;
        private Internal.IntList unk3300KCGKNJFGCFC_;
        private int unk3300KCGKNJFGCFCMemoizedSerializedSize;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 12;
        private boolean isContentClosed_;
        public static final int UNK3300_CMNIBPMOECO_FIELD_NUMBER = 5;
        private Internal.IntList unk3300CMNIBPMOECO_;
        private int unk3300CMNIBPMOECOMemoizedSerializedSize;
        public static final int UNK3300_FHNNJJDGLOO_FIELD_NUMBER = 6;
        private Internal.IntList unk3300FHNNJJDGLOO_;
        private int unk3300FHNNJJDGLOOMemoizedSerializedSize;
        public static final int USED_ITEM_LIST_FIELD_NUMBER = 14;
        private List<ItemParamOuterClass.ItemParam> usedItemList_;
        public static final int BATTLE_INFO_FIELD_NUMBER = 9;
        private WinterCampStageInfoOuterClass.WinterCampStageInfo battleInfo_;
        public static final int RACE_INFO_LIST_FIELD_NUMBER = 13;
        private List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> raceInfoList_;
        private byte memoizedIsInitialized;
        private static final WinterCampActivityDetailInfo DEFAULT_INSTANCE = new WinterCampActivityDetailInfo();
        private static final Parser<WinterCampActivityDetailInfo> PARSER = new AbstractParser<WinterCampActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public WinterCampActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampActivityDetailInfo(input, extensionRegistry);
            }
        };

        private WinterCampActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300KCGKNJFGCFCMemoizedSerializedSize = -1;
            this.unk3300CMNIBPMOECOMemoizedSerializedSize = -1;
            this.unk3300FHNNJJDGLOOMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WinterCampActivityDetailInfo() {
            this.unk3300KCGKNJFGCFCMemoizedSerializedSize = -1;
            this.unk3300CMNIBPMOECOMemoizedSerializedSize = -1;
            this.unk3300FHNNJJDGLOOMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300KCGKNJFGCFC_ = emptyIntList();
            this.unk3300CMNIBPMOECO_ = emptyIntList();
            this.unk3300FHNNJJDGLOO_ = emptyIntList();
            this.usedItemList_ = Collections.emptyList();
            this.raceInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:139:0x02be */
        private WinterCampActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder subBuilder = this.exploreInfo_ != null ? this.exploreInfo_.toBuilder() : null;
                                this.exploreInfo_ = (WinterCampStageInfoOuterClass.WinterCampStageInfo) input.readMessage(WinterCampStageInfoOuterClass.WinterCampStageInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.exploreInfo_);
                                    this.exploreInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300KCGKNJFGCFC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300KCGKNJFGCFC_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300KCGKNJFGCFC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300KCGKNJFGCFC_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300CMNIBPMOECO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300CMNIBPMOECO_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300CMNIBPMOECO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300CMNIBPMOECO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.unk3300FHNNJJDGLOO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.unk3300FHNNJJDGLOO_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300FHNNJJDGLOO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300FHNNJJDGLOO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 74:
                                WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder subBuilder2 = this.battleInfo_ != null ? this.battleInfo_.toBuilder() : null;
                                this.battleInfo_ = (WinterCampStageInfoOuterClass.WinterCampStageInfo) input.readMessage(WinterCampStageInfoOuterClass.WinterCampStageInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.battleInfo_);
                                    this.battleInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 96:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.raceInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.raceInfoList_.add((WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo) input.readMessage(WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.parser(), extensionRegistry));
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.usedItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.usedItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.unk3300KCGKNJFGCFC_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300CMNIBPMOECO_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unk3300FHNNJJDGLOO_.makeImmutable();
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.raceInfoList_ = Collections.unmodifiableList(this.raceInfoList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.usedItemList_ = Collections.unmodifiableList(this.usedItemList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampActivityDetailInfoOuterClass.internal_static_WinterCampActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampActivityDetailInfoOuterClass.internal_static_WinterCampActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public boolean hasExploreInfo() {
            return this.exploreInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfo getExploreInfo() {
            return this.exploreInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.exploreInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getExploreInfoOrBuilder() {
            return getExploreInfo();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<Integer> getUnk3300KCGKNJFGCFCList() {
            return this.unk3300KCGKNJFGCFC_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUnk3300KCGKNJFGCFCCount() {
            return this.unk3300KCGKNJFGCFC_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUnk3300KCGKNJFGCFC(int index) {
            return this.unk3300KCGKNJFGCFC_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<Integer> getUnk3300CMNIBPMOECOList() {
            return this.unk3300CMNIBPMOECO_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUnk3300CMNIBPMOECOCount() {
            return this.unk3300CMNIBPMOECO_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUnk3300CMNIBPMOECO(int index) {
            return this.unk3300CMNIBPMOECO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<Integer> getUnk3300FHNNJJDGLOOList() {
            return this.unk3300FHNNJJDGLOO_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUnk3300FHNNJJDGLOOCount() {
            return this.unk3300FHNNJJDGLOO_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUnk3300FHNNJJDGLOO(int index) {
            return this.unk3300FHNNJJDGLOO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<ItemParamOuterClass.ItemParam> getUsedItemListList() {
            return this.usedItemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedItemListOrBuilderList() {
            return this.usedItemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getUsedItemListCount() {
            return this.usedItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public ItemParamOuterClass.ItemParam getUsedItemList(int index) {
            return this.usedItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getUsedItemListOrBuilder(int index) {
            return this.usedItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public boolean hasBattleInfo() {
            return this.battleInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfo getBattleInfo() {
            return this.battleInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.battleInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getBattleInfoOrBuilder() {
            return getBattleInfo();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> getRaceInfoListList() {
            return this.raceInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public List<? extends WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> getRaceInfoListOrBuilderList() {
            return this.raceInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public int getRaceInfoListCount() {
            return this.raceInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo getRaceInfoList(int index) {
            return this.raceInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
        public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder getRaceInfoListOrBuilder(int index) {
            return this.raceInfoList_.get(index);
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
            if (this.exploreInfo_ != null) {
                output.writeMessage(3, getExploreInfo());
            }
            if (getUnk3300KCGKNJFGCFCList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.unk3300KCGKNJFGCFCMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300KCGKNJFGCFC_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300KCGKNJFGCFC_.getInt(i));
            }
            if (getUnk3300CMNIBPMOECOList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.unk3300CMNIBPMOECOMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300CMNIBPMOECO_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300CMNIBPMOECO_.getInt(i2));
            }
            if (getUnk3300FHNNJJDGLOOList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.unk3300FHNNJJDGLOOMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unk3300FHNNJJDGLOO_.size(); i3++) {
                output.writeUInt32NoTag(this.unk3300FHNNJJDGLOO_.getInt(i3));
            }
            if (this.battleInfo_ != null) {
                output.writeMessage(9, getBattleInfo());
            }
            if (this.isContentClosed_) {
                output.writeBool(12, this.isContentClosed_);
            }
            for (int i4 = 0; i4 < this.raceInfoList_.size(); i4++) {
                output.writeMessage(13, this.raceInfoList_.get(i4));
            }
            for (int i5 = 0; i5 < this.usedItemList_.size(); i5++) {
                output.writeMessage(14, this.usedItemList_.get(i5));
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
            if (this.exploreInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getExploreInfo());
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300KCGKNJFGCFC_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300KCGKNJFGCFC_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300KCGKNJFGCFCList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300KCGKNJFGCFCMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300CMNIBPMOECO_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300CMNIBPMOECO_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300CMNIBPMOECOList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300CMNIBPMOECOMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.unk3300FHNNJJDGLOO_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300FHNNJJDGLOO_.getInt(i3));
            }
            int size5 = size4 + dataSize3;
            if (!getUnk3300FHNNJJDGLOOList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unk3300FHNNJJDGLOOMemoizedSerializedSize = dataSize3;
            if (this.battleInfo_ != null) {
                size5 += CodedOutputStream.computeMessageSize(9, getBattleInfo());
            }
            if (this.isContentClosed_) {
                size5 += CodedOutputStream.computeBoolSize(12, this.isContentClosed_);
            }
            for (int i4 = 0; i4 < this.raceInfoList_.size(); i4++) {
                size5 += CodedOutputStream.computeMessageSize(13, this.raceInfoList_.get(i4));
            }
            for (int i5 = 0; i5 < this.usedItemList_.size(); i5++) {
                size5 += CodedOutputStream.computeMessageSize(14, this.usedItemList_.get(i5));
            }
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WinterCampActivityDetailInfo)) {
                return equals(obj);
            }
            WinterCampActivityDetailInfo other = (WinterCampActivityDetailInfo) obj;
            if (hasExploreInfo() != other.hasExploreInfo()) {
                return false;
            }
            if ((!hasExploreInfo() || getExploreInfo().equals(other.getExploreInfo())) && getUnk3300KCGKNJFGCFCList().equals(other.getUnk3300KCGKNJFGCFCList()) && getIsContentClosed() == other.getIsContentClosed() && getUnk3300CMNIBPMOECOList().equals(other.getUnk3300CMNIBPMOECOList()) && getUnk3300FHNNJJDGLOOList().equals(other.getUnk3300FHNNJJDGLOOList()) && getUsedItemListList().equals(other.getUsedItemListList()) && hasBattleInfo() == other.hasBattleInfo()) {
                return (!hasBattleInfo() || getBattleInfo().equals(other.getBattleInfo())) && getRaceInfoListList().equals(other.getRaceInfoListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasExploreInfo()) {
                hash = (53 * ((37 * hash) + 3)) + getExploreInfo().hashCode();
            }
            if (getUnk3300KCGKNJFGCFCCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getUnk3300KCGKNJFGCFCList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 12)) + Internal.hashBoolean(getIsContentClosed());
            if (getUnk3300CMNIBPMOECOCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 5)) + getUnk3300CMNIBPMOECOList().hashCode();
            }
            if (getUnk3300FHNNJJDGLOOCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getUnk3300FHNNJJDGLOOList().hashCode();
            }
            if (getUsedItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getUsedItemListList().hashCode();
            }
            if (hasBattleInfo()) {
                hash2 = (53 * ((37 * hash2) + 9)) + getBattleInfo().hashCode();
            }
            if (getRaceInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getRaceInfoListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static WinterCampActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (WinterCampActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampActivityDetailInfoOuterClass$WinterCampActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampActivityDetailInfoOrBuilder {
            private int bitField0_;
            private WinterCampStageInfoOuterClass.WinterCampStageInfo exploreInfo_;
            private SingleFieldBuilderV3<WinterCampStageInfoOuterClass.WinterCampStageInfo, WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder, WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder> exploreInfoBuilder_;
            private boolean isContentClosed_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> usedItemListBuilder_;
            private WinterCampStageInfoOuterClass.WinterCampStageInfo battleInfo_;
            private SingleFieldBuilderV3<WinterCampStageInfoOuterClass.WinterCampStageInfo, WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder, WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder> battleInfoBuilder_;
            private RepeatedFieldBuilderV3<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> raceInfoListBuilder_;
            private Internal.IntList unk3300KCGKNJFGCFC_ = WinterCampActivityDetailInfo.emptyIntList();
            private Internal.IntList unk3300CMNIBPMOECO_ = WinterCampActivityDetailInfo.emptyIntList();
            private Internal.IntList unk3300FHNNJJDGLOO_ = WinterCampActivityDetailInfo.emptyIntList();
            private List<ItemParamOuterClass.ItemParam> usedItemList_ = Collections.emptyList();
            private List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> raceInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampActivityDetailInfoOuterClass.internal_static_WinterCampActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampActivityDetailInfoOuterClass.internal_static_WinterCampActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampActivityDetailInfo.alwaysUseFieldBuilders) {
                    getUsedItemListFieldBuilder();
                    getRaceInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.exploreInfoBuilder_ == null) {
                    this.exploreInfo_ = null;
                } else {
                    this.exploreInfo_ = null;
                    this.exploreInfoBuilder_ = null;
                }
                this.unk3300KCGKNJFGCFC_ = WinterCampActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.isContentClosed_ = false;
                this.unk3300CMNIBPMOECO_ = WinterCampActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unk3300FHNNJJDGLOO_ = WinterCampActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.usedItemListBuilder_ == null) {
                    this.usedItemList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.usedItemListBuilder_.clear();
                }
                if (this.battleInfoBuilder_ == null) {
                    this.battleInfo_ = null;
                } else {
                    this.battleInfo_ = null;
                    this.battleInfoBuilder_ = null;
                }
                if (this.raceInfoListBuilder_ == null) {
                    this.raceInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.raceInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampActivityDetailInfoOuterClass.internal_static_WinterCampActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampActivityDetailInfo getDefaultInstanceForType() {
                return WinterCampActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampActivityDetailInfo build() {
                WinterCampActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampActivityDetailInfo buildPartial() {
                WinterCampActivityDetailInfo result = new WinterCampActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.exploreInfoBuilder_ == null) {
                    result.exploreInfo_ = this.exploreInfo_;
                } else {
                    result.exploreInfo_ = this.exploreInfoBuilder_.build();
                }
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300KCGKNJFGCFC_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300KCGKNJFGCFC_ = this.unk3300KCGKNJFGCFC_;
                result.isContentClosed_ = this.isContentClosed_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300CMNIBPMOECO_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300CMNIBPMOECO_ = this.unk3300CMNIBPMOECO_;
                if ((this.bitField0_ & 4) != 0) {
                    this.unk3300FHNNJJDGLOO_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.unk3300FHNNJJDGLOO_ = this.unk3300FHNNJJDGLOO_;
                if (this.usedItemListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.usedItemList_ = Collections.unmodifiableList(this.usedItemList_);
                        this.bitField0_ &= -9;
                    }
                    result.usedItemList_ = this.usedItemList_;
                } else {
                    result.usedItemList_ = this.usedItemListBuilder_.build();
                }
                if (this.battleInfoBuilder_ == null) {
                    result.battleInfo_ = this.battleInfo_;
                } else {
                    result.battleInfo_ = this.battleInfoBuilder_.build();
                }
                if (this.raceInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.raceInfoList_ = Collections.unmodifiableList(this.raceInfoList_);
                        this.bitField0_ &= -17;
                    }
                    result.raceInfoList_ = this.raceInfoList_;
                } else {
                    result.raceInfoList_ = this.raceInfoListBuilder_.build();
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
                if (other instanceof WinterCampActivityDetailInfo) {
                    return mergeFrom((WinterCampActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampActivityDetailInfo other) {
                if (other == WinterCampActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasExploreInfo()) {
                    mergeExploreInfo(other.getExploreInfo());
                }
                if (!other.unk3300KCGKNJFGCFC_.isEmpty()) {
                    if (this.unk3300KCGKNJFGCFC_.isEmpty()) {
                        this.unk3300KCGKNJFGCFC_ = other.unk3300KCGKNJFGCFC_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300KCGKNJFGCFCIsMutable();
                        this.unk3300KCGKNJFGCFC_.addAll(other.unk3300KCGKNJFGCFC_);
                    }
                    onChanged();
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (!other.unk3300CMNIBPMOECO_.isEmpty()) {
                    if (this.unk3300CMNIBPMOECO_.isEmpty()) {
                        this.unk3300CMNIBPMOECO_ = other.unk3300CMNIBPMOECO_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300CMNIBPMOECOIsMutable();
                        this.unk3300CMNIBPMOECO_.addAll(other.unk3300CMNIBPMOECO_);
                    }
                    onChanged();
                }
                if (!other.unk3300FHNNJJDGLOO_.isEmpty()) {
                    if (this.unk3300FHNNJJDGLOO_.isEmpty()) {
                        this.unk3300FHNNJJDGLOO_ = other.unk3300FHNNJJDGLOO_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureUnk3300FHNNJJDGLOOIsMutable();
                        this.unk3300FHNNJJDGLOO_.addAll(other.unk3300FHNNJJDGLOO_);
                    }
                    onChanged();
                }
                if (this.usedItemListBuilder_ == null) {
                    if (!other.usedItemList_.isEmpty()) {
                        if (this.usedItemList_.isEmpty()) {
                            this.usedItemList_ = other.usedItemList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureUsedItemListIsMutable();
                            this.usedItemList_.addAll(other.usedItemList_);
                        }
                        onChanged();
                    }
                } else if (!other.usedItemList_.isEmpty()) {
                    if (this.usedItemListBuilder_.isEmpty()) {
                        this.usedItemListBuilder_.dispose();
                        this.usedItemListBuilder_ = null;
                        this.usedItemList_ = other.usedItemList_;
                        this.bitField0_ &= -9;
                        this.usedItemListBuilder_ = WinterCampActivityDetailInfo.alwaysUseFieldBuilders ? getUsedItemListFieldBuilder() : null;
                    } else {
                        this.usedItemListBuilder_.addAllMessages(other.usedItemList_);
                    }
                }
                if (other.hasBattleInfo()) {
                    mergeBattleInfo(other.getBattleInfo());
                }
                if (this.raceInfoListBuilder_ == null) {
                    if (!other.raceInfoList_.isEmpty()) {
                        if (this.raceInfoList_.isEmpty()) {
                            this.raceInfoList_ = other.raceInfoList_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureRaceInfoListIsMutable();
                            this.raceInfoList_.addAll(other.raceInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.raceInfoList_.isEmpty()) {
                    if (this.raceInfoListBuilder_.isEmpty()) {
                        this.raceInfoListBuilder_.dispose();
                        this.raceInfoListBuilder_ = null;
                        this.raceInfoList_ = other.raceInfoList_;
                        this.bitField0_ &= -17;
                        this.raceInfoListBuilder_ = WinterCampActivityDetailInfo.alwaysUseFieldBuilders ? getRaceInfoListFieldBuilder() : null;
                    } else {
                        this.raceInfoListBuilder_.addAllMessages(other.raceInfoList_);
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
                WinterCampActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public boolean hasExploreInfo() {
                return (this.exploreInfoBuilder_ == null && this.exploreInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public WinterCampStageInfoOuterClass.WinterCampStageInfo getExploreInfo() {
                if (this.exploreInfoBuilder_ == null) {
                    return this.exploreInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.exploreInfo_;
                }
                return this.exploreInfoBuilder_.getMessage();
            }

            public Builder setExploreInfo(WinterCampStageInfoOuterClass.WinterCampStageInfo value) {
                if (this.exploreInfoBuilder_ != null) {
                    this.exploreInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.exploreInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setExploreInfo(WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder builderForValue) {
                if (this.exploreInfoBuilder_ == null) {
                    this.exploreInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.exploreInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeExploreInfo(WinterCampStageInfoOuterClass.WinterCampStageInfo value) {
                if (this.exploreInfoBuilder_ == null) {
                    if (this.exploreInfo_ != null) {
                        this.exploreInfo_ = WinterCampStageInfoOuterClass.WinterCampStageInfo.newBuilder(this.exploreInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.exploreInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.exploreInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearExploreInfo() {
                if (this.exploreInfoBuilder_ == null) {
                    this.exploreInfo_ = null;
                    onChanged();
                } else {
                    this.exploreInfo_ = null;
                    this.exploreInfoBuilder_ = null;
                }
                return this;
            }

            public WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder getExploreInfoBuilder() {
                onChanged();
                return getExploreInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getExploreInfoOrBuilder() {
                if (this.exploreInfoBuilder_ != null) {
                    return this.exploreInfoBuilder_.getMessageOrBuilder();
                }
                return this.exploreInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.exploreInfo_;
            }

            private SingleFieldBuilderV3<WinterCampStageInfoOuterClass.WinterCampStageInfo, WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder, WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder> getExploreInfoFieldBuilder() {
                if (this.exploreInfoBuilder_ == null) {
                    this.exploreInfoBuilder_ = new SingleFieldBuilderV3<>(getExploreInfo(), getParentForChildren(), isClean());
                    this.exploreInfo_ = null;
                }
                return this.exploreInfoBuilder_;
            }

            private void ensureUnk3300KCGKNJFGCFCIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300KCGKNJFGCFC_ = WinterCampActivityDetailInfo.mutableCopy(this.unk3300KCGKNJFGCFC_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<Integer> getUnk3300KCGKNJFGCFCList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300KCGKNJFGCFC_) : this.unk3300KCGKNJFGCFC_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUnk3300KCGKNJFGCFCCount() {
                return this.unk3300KCGKNJFGCFC_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUnk3300KCGKNJFGCFC(int index) {
                return this.unk3300KCGKNJFGCFC_.getInt(index);
            }

            public Builder setUnk3300KCGKNJFGCFC(int index, int value) {
                ensureUnk3300KCGKNJFGCFCIsMutable();
                this.unk3300KCGKNJFGCFC_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300KCGKNJFGCFC(int value) {
                ensureUnk3300KCGKNJFGCFCIsMutable();
                this.unk3300KCGKNJFGCFC_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300KCGKNJFGCFC(Iterable<? extends Integer> values) {
                ensureUnk3300KCGKNJFGCFCIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300KCGKNJFGCFC_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300KCGKNJFGCFC() {
                this.unk3300KCGKNJFGCFC_ = WinterCampActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
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

            private void ensureUnk3300CMNIBPMOECOIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300CMNIBPMOECO_ = WinterCampActivityDetailInfo.mutableCopy(this.unk3300CMNIBPMOECO_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<Integer> getUnk3300CMNIBPMOECOList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300CMNIBPMOECO_) : this.unk3300CMNIBPMOECO_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUnk3300CMNIBPMOECOCount() {
                return this.unk3300CMNIBPMOECO_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUnk3300CMNIBPMOECO(int index) {
                return this.unk3300CMNIBPMOECO_.getInt(index);
            }

            public Builder setUnk3300CMNIBPMOECO(int index, int value) {
                ensureUnk3300CMNIBPMOECOIsMutable();
                this.unk3300CMNIBPMOECO_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300CMNIBPMOECO(int value) {
                ensureUnk3300CMNIBPMOECOIsMutable();
                this.unk3300CMNIBPMOECO_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300CMNIBPMOECO(Iterable<? extends Integer> values) {
                ensureUnk3300CMNIBPMOECOIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300CMNIBPMOECO_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300CMNIBPMOECO() {
                this.unk3300CMNIBPMOECO_ = WinterCampActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureUnk3300FHNNJJDGLOOIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unk3300FHNNJJDGLOO_ = WinterCampActivityDetailInfo.mutableCopy(this.unk3300FHNNJJDGLOO_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<Integer> getUnk3300FHNNJJDGLOOList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unk3300FHNNJJDGLOO_) : this.unk3300FHNNJJDGLOO_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUnk3300FHNNJJDGLOOCount() {
                return this.unk3300FHNNJJDGLOO_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUnk3300FHNNJJDGLOO(int index) {
                return this.unk3300FHNNJJDGLOO_.getInt(index);
            }

            public Builder setUnk3300FHNNJJDGLOO(int index, int value) {
                ensureUnk3300FHNNJJDGLOOIsMutable();
                this.unk3300FHNNJJDGLOO_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300FHNNJJDGLOO(int value) {
                ensureUnk3300FHNNJJDGLOOIsMutable();
                this.unk3300FHNNJJDGLOO_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300FHNNJJDGLOO(Iterable<? extends Integer> values) {
                ensureUnk3300FHNNJJDGLOOIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300FHNNJJDGLOO_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300FHNNJJDGLOO() {
                this.unk3300FHNNJJDGLOO_ = WinterCampActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureUsedItemListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.usedItemList_ = new ArrayList(this.usedItemList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<ItemParamOuterClass.ItemParam> getUsedItemListList() {
                if (this.usedItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.usedItemList_);
                }
                return this.usedItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getUsedItemListCount() {
                if (this.usedItemListBuilder_ == null) {
                    return this.usedItemList_.size();
                }
                return this.usedItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public ItemParamOuterClass.ItemParam getUsedItemList(int index) {
                if (this.usedItemListBuilder_ == null) {
                    return this.usedItemList_.get(index);
                }
                return this.usedItemListBuilder_.getMessage(index);
            }

            public Builder setUsedItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.usedItemListBuilder_ != null) {
                    this.usedItemListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUsedItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.usedItemListBuilder_ == null) {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.usedItemListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUsedItemList(ItemParamOuterClass.ItemParam value) {
                if (this.usedItemListBuilder_ != null) {
                    this.usedItemListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUsedItemList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.usedItemListBuilder_ != null) {
                    this.usedItemListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUsedItemList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.usedItemListBuilder_ == null) {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.usedItemListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUsedItemList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.usedItemListBuilder_ == null) {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.usedItemListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUsedItemList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.usedItemListBuilder_ == null) {
                    ensureUsedItemListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.usedItemList_);
                    onChanged();
                } else {
                    this.usedItemListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUsedItemList() {
                if (this.usedItemListBuilder_ == null) {
                    this.usedItemList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.usedItemListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUsedItemList(int index) {
                if (this.usedItemListBuilder_ == null) {
                    ensureUsedItemListIsMutable();
                    this.usedItemList_.remove(index);
                    onChanged();
                } else {
                    this.usedItemListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getUsedItemListBuilder(int index) {
                return getUsedItemListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getUsedItemListOrBuilder(int index) {
                if (this.usedItemListBuilder_ == null) {
                    return this.usedItemList_.get(index);
                }
                return this.usedItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedItemListOrBuilderList() {
                if (this.usedItemListBuilder_ != null) {
                    return this.usedItemListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.usedItemList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addUsedItemListBuilder() {
                return getUsedItemListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addUsedItemListBuilder(int index) {
                return getUsedItemListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getUsedItemListBuilderList() {
                return getUsedItemListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getUsedItemListFieldBuilder() {
                if (this.usedItemListBuilder_ == null) {
                    this.usedItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.usedItemList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.usedItemList_ = null;
                }
                return this.usedItemListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public boolean hasBattleInfo() {
                return (this.battleInfoBuilder_ == null && this.battleInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public WinterCampStageInfoOuterClass.WinterCampStageInfo getBattleInfo() {
                if (this.battleInfoBuilder_ == null) {
                    return this.battleInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.battleInfo_;
                }
                return this.battleInfoBuilder_.getMessage();
            }

            public Builder setBattleInfo(WinterCampStageInfoOuterClass.WinterCampStageInfo value) {
                if (this.battleInfoBuilder_ != null) {
                    this.battleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.battleInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBattleInfo(WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder builderForValue) {
                if (this.battleInfoBuilder_ == null) {
                    this.battleInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.battleInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBattleInfo(WinterCampStageInfoOuterClass.WinterCampStageInfo value) {
                if (this.battleInfoBuilder_ == null) {
                    if (this.battleInfo_ != null) {
                        this.battleInfo_ = WinterCampStageInfoOuterClass.WinterCampStageInfo.newBuilder(this.battleInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.battleInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.battleInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBattleInfo() {
                if (this.battleInfoBuilder_ == null) {
                    this.battleInfo_ = null;
                    onChanged();
                } else {
                    this.battleInfo_ = null;
                    this.battleInfoBuilder_ = null;
                }
                return this;
            }

            public WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder getBattleInfoBuilder() {
                onChanged();
                return getBattleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getBattleInfoOrBuilder() {
                if (this.battleInfoBuilder_ != null) {
                    return this.battleInfoBuilder_.getMessageOrBuilder();
                }
                return this.battleInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.battleInfo_;
            }

            private SingleFieldBuilderV3<WinterCampStageInfoOuterClass.WinterCampStageInfo, WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder, WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder> getBattleInfoFieldBuilder() {
                if (this.battleInfoBuilder_ == null) {
                    this.battleInfoBuilder_ = new SingleFieldBuilderV3<>(getBattleInfo(), getParentForChildren(), isClean());
                    this.battleInfo_ = null;
                }
                return this.battleInfoBuilder_;
            }

            private void ensureRaceInfoListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.raceInfoList_ = new ArrayList(this.raceInfoList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> getRaceInfoListList() {
                if (this.raceInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.raceInfoList_);
                }
                return this.raceInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public int getRaceInfoListCount() {
                if (this.raceInfoListBuilder_ == null) {
                    return this.raceInfoList_.size();
                }
                return this.raceInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo getRaceInfoList(int index) {
                if (this.raceInfoListBuilder_ == null) {
                    return this.raceInfoList_.get(index);
                }
                return this.raceInfoListBuilder_.getMessage(index);
            }

            public Builder setRaceInfoList(int index, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo value) {
                if (this.raceInfoListBuilder_ != null) {
                    this.raceInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRaceInfoList(int index, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder builderForValue) {
                if (this.raceInfoListBuilder_ == null) {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.raceInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRaceInfoList(WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo value) {
                if (this.raceInfoListBuilder_ != null) {
                    this.raceInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRaceInfoList(int index, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo value) {
                if (this.raceInfoListBuilder_ != null) {
                    this.raceInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRaceInfoList(WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder builderForValue) {
                if (this.raceInfoListBuilder_ == null) {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.raceInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRaceInfoList(int index, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder builderForValue) {
                if (this.raceInfoListBuilder_ == null) {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.raceInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRaceInfoList(Iterable<? extends WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> values) {
                if (this.raceInfoListBuilder_ == null) {
                    ensureRaceInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.raceInfoList_);
                    onChanged();
                } else {
                    this.raceInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRaceInfoList() {
                if (this.raceInfoListBuilder_ == null) {
                    this.raceInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.raceInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRaceInfoList(int index) {
                if (this.raceInfoListBuilder_ == null) {
                    ensureRaceInfoListIsMutable();
                    this.raceInfoList_.remove(index);
                    onChanged();
                } else {
                    this.raceInfoListBuilder_.remove(index);
                }
                return this;
            }

            public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder getRaceInfoListBuilder(int index) {
                return getRaceInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder getRaceInfoListOrBuilder(int index) {
                if (this.raceInfoListBuilder_ == null) {
                    return this.raceInfoList_.get(index);
                }
                return this.raceInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder
            public List<? extends WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> getRaceInfoListOrBuilderList() {
                if (this.raceInfoListBuilder_ != null) {
                    return this.raceInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.raceInfoList_);
            }

            public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder addRaceInfoListBuilder() {
                return getRaceInfoListFieldBuilder().addBuilder(WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.getDefaultInstance());
            }

            public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder addRaceInfoListBuilder(int index) {
                return getRaceInfoListFieldBuilder().addBuilder(index, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.getDefaultInstance());
            }

            public List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder> getRaceInfoListBuilderList() {
                return getRaceInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> getRaceInfoListFieldBuilder() {
                if (this.raceInfoListBuilder_ == null) {
                    this.raceInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.raceInfoList_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.raceInfoList_ = null;
                }
                return this.raceInfoListBuilder_;
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

        public static WinterCampActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
        WinterCampRaceStageInfoOuterClass.getDescriptor();
        WinterCampStageInfoOuterClass.getDescriptor();
    }
}
