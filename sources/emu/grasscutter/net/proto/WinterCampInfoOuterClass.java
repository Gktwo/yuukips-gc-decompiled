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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampInfoOuterClass.class */
public final class WinterCampInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014WinterCampInfo.proto\u001a\u0019WinterCampStageInfo.proto\u001a\u001dWinterCampRaceStageInfo.proto\u001a\u000fItemParam.proto\"¤\u0002\n\u000eWinterCampInfo\u0012.\n\fraceInfoList\u0018\u0005 \u0003(\u000b2\u0018.WinterCampRaceStageInfo\u0012\u001b\n\u0013Unk3300_CMNIBPMOECO\u0018\u000e \u0003(\r\u0012 \n\fusedItemList\u0018\b \u0003(\u000b2\n.ItemParam\u0012\u001b\n\u0013Unk3300_FHNNJJDGLOO\u0018\u0007 \u0003(\r\u0012)\n\u000bexploreInfo\u0018\u0001 \u0001(\u000b2\u0014.WinterCampStageInfo\u0012\u001b\n\u0013Unk3300_KCGKNJFGCFC\u0018\u0003 \u0003(\r\u0012\u0014\n\fleftMonsters\u0018\u000b \u0001(\b\u0012(\n\nbattleInfo\u0018\n \u0001(\u000b2\u0014.WinterCampStageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WinterCampStageInfoOuterClass.getDescriptor(), WinterCampRaceStageInfoOuterClass.getDescriptor(), ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampInfo_descriptor, new String[]{"RaceInfoList", "Unk3300CMNIBPMOECO", "UsedItemList", "Unk3300FHNNJJDGLOO", "ExploreInfo", "Unk3300KCGKNJFGCFC", "LeftMonsters", "BattleInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampInfoOuterClass$WinterCampInfoOrBuilder.class */
    public interface WinterCampInfoOrBuilder extends MessageOrBuilder {
        List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> getRaceInfoListList();

        WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo getRaceInfoList(int i);

        int getRaceInfoListCount();

        List<? extends WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> getRaceInfoListOrBuilderList();

        WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder getRaceInfoListOrBuilder(int i);

        List<Integer> getUnk3300CMNIBPMOECOList();

        int getUnk3300CMNIBPMOECOCount();

        int getUnk3300CMNIBPMOECO(int i);

        List<ItemParamOuterClass.ItemParam> getUsedItemListList();

        ItemParamOuterClass.ItemParam getUsedItemList(int i);

        int getUsedItemListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedItemListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getUsedItemListOrBuilder(int i);

        List<Integer> getUnk3300FHNNJJDGLOOList();

        int getUnk3300FHNNJJDGLOOCount();

        int getUnk3300FHNNJJDGLOO(int i);

        boolean hasExploreInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfo getExploreInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getExploreInfoOrBuilder();

        List<Integer> getUnk3300KCGKNJFGCFCList();

        int getUnk3300KCGKNJFGCFCCount();

        int getUnk3300KCGKNJFGCFC(int i);

        boolean getLeftMonsters();

        boolean hasBattleInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfo getBattleInfo();

        WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getBattleInfoOrBuilder();
    }

    private WinterCampInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampInfoOuterClass$WinterCampInfo.class */
    public static final class WinterCampInfo extends GeneratedMessageV3 implements WinterCampInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RACEINFOLIST_FIELD_NUMBER = 5;
        private List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> raceInfoList_;
        public static final int UNK3300_CMNIBPMOECO_FIELD_NUMBER = 14;
        private Internal.IntList unk3300CMNIBPMOECO_;
        private int unk3300CMNIBPMOECOMemoizedSerializedSize;
        public static final int USEDITEMLIST_FIELD_NUMBER = 8;
        private List<ItemParamOuterClass.ItemParam> usedItemList_;
        public static final int UNK3300_FHNNJJDGLOO_FIELD_NUMBER = 7;
        private Internal.IntList unk3300FHNNJJDGLOO_;
        private int unk3300FHNNJJDGLOOMemoizedSerializedSize;
        public static final int EXPLOREINFO_FIELD_NUMBER = 1;
        private WinterCampStageInfoOuterClass.WinterCampStageInfo exploreInfo_;
        public static final int UNK3300_KCGKNJFGCFC_FIELD_NUMBER = 3;
        private Internal.IntList unk3300KCGKNJFGCFC_;
        private int unk3300KCGKNJFGCFCMemoizedSerializedSize;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 11;
        private boolean leftMonsters_;
        public static final int BATTLEINFO_FIELD_NUMBER = 10;
        private WinterCampStageInfoOuterClass.WinterCampStageInfo battleInfo_;
        private byte memoizedIsInitialized;
        private static final WinterCampInfo DEFAULT_INSTANCE = new WinterCampInfo();
        private static final Parser<WinterCampInfo> PARSER = new AbstractParser<WinterCampInfo>() { // from class: emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfo.1
            @Override // com.google.protobuf.Parser
            public WinterCampInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampInfo(input, extensionRegistry);
            }
        };

        private WinterCampInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300CMNIBPMOECOMemoizedSerializedSize = -1;
            this.unk3300FHNNJJDGLOOMemoizedSerializedSize = -1;
            this.unk3300KCGKNJFGCFCMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private WinterCampInfo() {
            this.unk3300CMNIBPMOECOMemoizedSerializedSize = -1;
            this.unk3300FHNNJJDGLOOMemoizedSerializedSize = -1;
            this.unk3300KCGKNJFGCFCMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.raceInfoList_ = Collections.emptyList();
            this.unk3300CMNIBPMOECO_ = emptyIntList();
            this.usedItemList_ = Collections.emptyList();
            this.unk3300FHNNJJDGLOO_ = emptyIntList();
            this.unk3300KCGKNJFGCFC_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:139:0x02c2 */
        private WinterCampInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder subBuilder = this.exploreInfo_ != null ? this.exploreInfo_.toBuilder() : null;
                                this.exploreInfo_ = (WinterCampStageInfoOuterClass.WinterCampStageInfo) input.readMessage(WinterCampStageInfoOuterClass.WinterCampStageInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.exploreInfo_);
                                    this.exploreInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 24:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.unk3300KCGKNJFGCFC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.unk3300KCGKNJFGCFC_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300KCGKNJFGCFC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300KCGKNJFGCFC_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.raceInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.raceInfoList_.add((WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo) input.readMessage(WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.parser(), extensionRegistry));
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unk3300FHNNJJDGLOO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unk3300FHNNJJDGLOO_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300FHNNJJDGLOO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300FHNNJJDGLOO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.usedItemList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.usedItemList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 82:
                                WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder subBuilder2 = this.battleInfo_ != null ? this.battleInfo_.toBuilder() : null;
                                this.battleInfo_ = (WinterCampStageInfoOuterClass.WinterCampStageInfo) input.readMessage(WinterCampStageInfoOuterClass.WinterCampStageInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.battleInfo_);
                                    this.battleInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 88:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300CMNIBPMOECO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300CMNIBPMOECO_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300CMNIBPMOECO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300CMNIBPMOECO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
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
                if ((mutable_bitField0_ & 16) != 0) {
                    this.unk3300KCGKNJFGCFC_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.raceInfoList_ = Collections.unmodifiableList(this.raceInfoList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unk3300FHNNJJDGLOO_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.usedItemList_ = Collections.unmodifiableList(this.usedItemList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300CMNIBPMOECO_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampInfoOuterClass.internal_static_WinterCampInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampInfoOuterClass.internal_static_WinterCampInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> getRaceInfoListList() {
            return this.raceInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<? extends WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> getRaceInfoListOrBuilderList() {
            return this.raceInfoList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getRaceInfoListCount() {
            return this.raceInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo getRaceInfoList(int index) {
            return this.raceInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder getRaceInfoListOrBuilder(int index) {
            return this.raceInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<Integer> getUnk3300CMNIBPMOECOList() {
            return this.unk3300CMNIBPMOECO_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUnk3300CMNIBPMOECOCount() {
            return this.unk3300CMNIBPMOECO_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUnk3300CMNIBPMOECO(int index) {
            return this.unk3300CMNIBPMOECO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<ItemParamOuterClass.ItemParam> getUsedItemListList() {
            return this.usedItemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUsedItemListOrBuilderList() {
            return this.usedItemList_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUsedItemListCount() {
            return this.usedItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public ItemParamOuterClass.ItemParam getUsedItemList(int index) {
            return this.usedItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getUsedItemListOrBuilder(int index) {
            return this.usedItemList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<Integer> getUnk3300FHNNJJDGLOOList() {
            return this.unk3300FHNNJJDGLOO_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUnk3300FHNNJJDGLOOCount() {
            return this.unk3300FHNNJJDGLOO_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUnk3300FHNNJJDGLOO(int index) {
            return this.unk3300FHNNJJDGLOO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public boolean hasExploreInfo() {
            return this.exploreInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfo getExploreInfo() {
            return this.exploreInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.exploreInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getExploreInfoOrBuilder() {
            return getExploreInfo();
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public List<Integer> getUnk3300KCGKNJFGCFCList() {
            return this.unk3300KCGKNJFGCFC_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUnk3300KCGKNJFGCFCCount() {
            return this.unk3300KCGKNJFGCFC_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public int getUnk3300KCGKNJFGCFC(int index) {
            return this.unk3300KCGKNJFGCFC_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public boolean hasBattleInfo() {
            return this.battleInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfo getBattleInfo() {
            return this.battleInfo_ == null ? WinterCampStageInfoOuterClass.WinterCampStageInfo.getDefaultInstance() : this.battleInfo_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
        public WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder getBattleInfoOrBuilder() {
            return getBattleInfo();
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
                output.writeMessage(1, getExploreInfo());
            }
            if (getUnk3300KCGKNJFGCFCList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.unk3300KCGKNJFGCFCMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300KCGKNJFGCFC_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300KCGKNJFGCFC_.getInt(i));
            }
            for (int i2 = 0; i2 < this.raceInfoList_.size(); i2++) {
                output.writeMessage(5, this.raceInfoList_.get(i2));
            }
            if (getUnk3300FHNNJJDGLOOList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.unk3300FHNNJJDGLOOMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unk3300FHNNJJDGLOO_.size(); i3++) {
                output.writeUInt32NoTag(this.unk3300FHNNJJDGLOO_.getInt(i3));
            }
            for (int i4 = 0; i4 < this.usedItemList_.size(); i4++) {
                output.writeMessage(8, this.usedItemList_.get(i4));
            }
            if (this.battleInfo_ != null) {
                output.writeMessage(10, getBattleInfo());
            }
            if (this.leftMonsters_) {
                output.writeBool(11, this.leftMonsters_);
            }
            if (getUnk3300CMNIBPMOECOList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.unk3300CMNIBPMOECOMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.unk3300CMNIBPMOECO_.size(); i5++) {
                output.writeUInt32NoTag(this.unk3300CMNIBPMOECO_.getInt(i5));
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
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getExploreInfo());
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
            for (int i2 = 0; i2 < this.raceInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(5, this.raceInfoList_.get(i2));
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.unk3300FHNNJJDGLOO_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300FHNNJJDGLOO_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300FHNNJJDGLOOList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300FHNNJJDGLOOMemoizedSerializedSize = dataSize2;
            for (int i4 = 0; i4 < this.usedItemList_.size(); i4++) {
                size4 += CodedOutputStream.computeMessageSize(8, this.usedItemList_.get(i4));
            }
            if (this.battleInfo_ != null) {
                size4 += CodedOutputStream.computeMessageSize(10, getBattleInfo());
            }
            if (this.leftMonsters_) {
                size4 += CodedOutputStream.computeBoolSize(11, this.leftMonsters_);
            }
            int dataSize3 = 0;
            for (int i5 = 0; i5 < this.unk3300CMNIBPMOECO_.size(); i5++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300CMNIBPMOECO_.getInt(i5));
            }
            int size5 = size4 + dataSize3;
            if (!getUnk3300CMNIBPMOECOList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unk3300CMNIBPMOECOMemoizedSerializedSize = dataSize3;
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WinterCampInfo)) {
                return equals(obj);
            }
            WinterCampInfo other = (WinterCampInfo) obj;
            if (!getRaceInfoListList().equals(other.getRaceInfoListList()) || !getUnk3300CMNIBPMOECOList().equals(other.getUnk3300CMNIBPMOECOList()) || !getUsedItemListList().equals(other.getUsedItemListList()) || !getUnk3300FHNNJJDGLOOList().equals(other.getUnk3300FHNNJJDGLOOList()) || hasExploreInfo() != other.hasExploreInfo()) {
                return false;
            }
            if ((!hasExploreInfo() || getExploreInfo().equals(other.getExploreInfo())) && getUnk3300KCGKNJFGCFCList().equals(other.getUnk3300KCGKNJFGCFCList()) && getLeftMonsters() == other.getLeftMonsters() && hasBattleInfo() == other.hasBattleInfo()) {
                return (!hasBattleInfo() || getBattleInfo().equals(other.getBattleInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRaceInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getRaceInfoListList().hashCode();
            }
            if (getUnk3300CMNIBPMOECOCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getUnk3300CMNIBPMOECOList().hashCode();
            }
            if (getUsedItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getUsedItemListList().hashCode();
            }
            if (getUnk3300FHNNJJDGLOOCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getUnk3300FHNNJJDGLOOList().hashCode();
            }
            if (hasExploreInfo()) {
                hash = (53 * ((37 * hash) + 1)) + getExploreInfo().hashCode();
            }
            if (getUnk3300KCGKNJFGCFCCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getUnk3300KCGKNJFGCFCList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 11)) + Internal.hashBoolean(getLeftMonsters());
            if (hasBattleInfo()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getBattleInfo().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static WinterCampInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampInfo parseFrom(InputStream input) throws IOException {
            return (WinterCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampInfo parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampInfoOuterClass$WinterCampInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo.Builder, WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder> raceInfoListBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> usedItemListBuilder_;
            private WinterCampStageInfoOuterClass.WinterCampStageInfo exploreInfo_;
            private SingleFieldBuilderV3<WinterCampStageInfoOuterClass.WinterCampStageInfo, WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder, WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder> exploreInfoBuilder_;
            private boolean leftMonsters_;
            private WinterCampStageInfoOuterClass.WinterCampStageInfo battleInfo_;
            private SingleFieldBuilderV3<WinterCampStageInfoOuterClass.WinterCampStageInfo, WinterCampStageInfoOuterClass.WinterCampStageInfo.Builder, WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder> battleInfoBuilder_;
            private List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> raceInfoList_ = Collections.emptyList();
            private Internal.IntList unk3300CMNIBPMOECO_ = WinterCampInfo.emptyIntList();
            private List<ItemParamOuterClass.ItemParam> usedItemList_ = Collections.emptyList();
            private Internal.IntList unk3300FHNNJJDGLOO_ = WinterCampInfo.emptyIntList();
            private Internal.IntList unk3300KCGKNJFGCFC_ = WinterCampInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampInfoOuterClass.internal_static_WinterCampInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampInfoOuterClass.internal_static_WinterCampInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampInfo.alwaysUseFieldBuilders) {
                    getRaceInfoListFieldBuilder();
                    getUsedItemListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.raceInfoListBuilder_ == null) {
                    this.raceInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.raceInfoListBuilder_.clear();
                }
                this.unk3300CMNIBPMOECO_ = WinterCampInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.usedItemListBuilder_ == null) {
                    this.usedItemList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.usedItemListBuilder_.clear();
                }
                this.unk3300FHNNJJDGLOO_ = WinterCampInfo.emptyIntList();
                this.bitField0_ &= -9;
                if (this.exploreInfoBuilder_ == null) {
                    this.exploreInfo_ = null;
                } else {
                    this.exploreInfo_ = null;
                    this.exploreInfoBuilder_ = null;
                }
                this.unk3300KCGKNJFGCFC_ = WinterCampInfo.emptyIntList();
                this.bitField0_ &= -17;
                this.leftMonsters_ = false;
                if (this.battleInfoBuilder_ == null) {
                    this.battleInfo_ = null;
                } else {
                    this.battleInfo_ = null;
                    this.battleInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampInfoOuterClass.internal_static_WinterCampInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampInfo getDefaultInstanceForType() {
                return WinterCampInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampInfo build() {
                WinterCampInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampInfo buildPartial() {
                WinterCampInfo result = new WinterCampInfo(this);
                int i = this.bitField0_;
                if (this.raceInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.raceInfoList_ = Collections.unmodifiableList(this.raceInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.raceInfoList_ = this.raceInfoList_;
                } else {
                    result.raceInfoList_ = this.raceInfoListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300CMNIBPMOECO_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300CMNIBPMOECO_ = this.unk3300CMNIBPMOECO_;
                if (this.usedItemListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.usedItemList_ = Collections.unmodifiableList(this.usedItemList_);
                        this.bitField0_ &= -5;
                    }
                    result.usedItemList_ = this.usedItemList_;
                } else {
                    result.usedItemList_ = this.usedItemListBuilder_.build();
                }
                if ((this.bitField0_ & 8) != 0) {
                    this.unk3300FHNNJJDGLOO_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.unk3300FHNNJJDGLOO_ = this.unk3300FHNNJJDGLOO_;
                if (this.exploreInfoBuilder_ == null) {
                    result.exploreInfo_ = this.exploreInfo_;
                } else {
                    result.exploreInfo_ = this.exploreInfoBuilder_.build();
                }
                if ((this.bitField0_ & 16) != 0) {
                    this.unk3300KCGKNJFGCFC_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.unk3300KCGKNJFGCFC_ = this.unk3300KCGKNJFGCFC_;
                result.leftMonsters_ = this.leftMonsters_;
                if (this.battleInfoBuilder_ == null) {
                    result.battleInfo_ = this.battleInfo_;
                } else {
                    result.battleInfo_ = this.battleInfoBuilder_.build();
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
                if (other instanceof WinterCampInfo) {
                    return mergeFrom((WinterCampInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampInfo other) {
                if (other == WinterCampInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.raceInfoListBuilder_ == null) {
                    if (!other.raceInfoList_.isEmpty()) {
                        if (this.raceInfoList_.isEmpty()) {
                            this.raceInfoList_ = other.raceInfoList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.raceInfoListBuilder_ = WinterCampInfo.alwaysUseFieldBuilders ? getRaceInfoListFieldBuilder() : null;
                    } else {
                        this.raceInfoListBuilder_.addAllMessages(other.raceInfoList_);
                    }
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
                if (this.usedItemListBuilder_ == null) {
                    if (!other.usedItemList_.isEmpty()) {
                        if (this.usedItemList_.isEmpty()) {
                            this.usedItemList_ = other.usedItemList_;
                            this.bitField0_ &= -5;
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
                        this.bitField0_ &= -5;
                        this.usedItemListBuilder_ = WinterCampInfo.alwaysUseFieldBuilders ? getUsedItemListFieldBuilder() : null;
                    } else {
                        this.usedItemListBuilder_.addAllMessages(other.usedItemList_);
                    }
                }
                if (!other.unk3300FHNNJJDGLOO_.isEmpty()) {
                    if (this.unk3300FHNNJJDGLOO_.isEmpty()) {
                        this.unk3300FHNNJJDGLOO_ = other.unk3300FHNNJJDGLOO_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureUnk3300FHNNJJDGLOOIsMutable();
                        this.unk3300FHNNJJDGLOO_.addAll(other.unk3300FHNNJJDGLOO_);
                    }
                    onChanged();
                }
                if (other.hasExploreInfo()) {
                    mergeExploreInfo(other.getExploreInfo());
                }
                if (!other.unk3300KCGKNJFGCFC_.isEmpty()) {
                    if (this.unk3300KCGKNJFGCFC_.isEmpty()) {
                        this.unk3300KCGKNJFGCFC_ = other.unk3300KCGKNJFGCFC_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUnk3300KCGKNJFGCFCIsMutable();
                        this.unk3300KCGKNJFGCFC_.addAll(other.unk3300KCGKNJFGCFC_);
                    }
                    onChanged();
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.hasBattleInfo()) {
                    mergeBattleInfo(other.getBattleInfo());
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
                WinterCampInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRaceInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.raceInfoList_ = new ArrayList(this.raceInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public List<WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfo> getRaceInfoListList() {
                if (this.raceInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.raceInfoList_);
                }
                return this.raceInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public int getRaceInfoListCount() {
                if (this.raceInfoListBuilder_ == null) {
                    return this.raceInfoList_.size();
                }
                return this.raceInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                    this.bitField0_ &= -2;
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

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public WinterCampRaceStageInfoOuterClass.WinterCampRaceStageInfoOrBuilder getRaceInfoListOrBuilder(int index) {
                if (this.raceInfoListBuilder_ == null) {
                    return this.raceInfoList_.get(index);
                }
                return this.raceInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                    this.raceInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.raceInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.raceInfoList_ = null;
                }
                return this.raceInfoListBuilder_;
            }

            private void ensureUnk3300CMNIBPMOECOIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300CMNIBPMOECO_ = WinterCampInfo.mutableCopy(this.unk3300CMNIBPMOECO_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public List<Integer> getUnk3300CMNIBPMOECOList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300CMNIBPMOECO_) : this.unk3300CMNIBPMOECO_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public int getUnk3300CMNIBPMOECOCount() {
                return this.unk3300CMNIBPMOECO_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                this.unk3300CMNIBPMOECO_ = WinterCampInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureUsedItemListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.usedItemList_ = new ArrayList(this.usedItemList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public List<ItemParamOuterClass.ItemParam> getUsedItemListList() {
                if (this.usedItemListBuilder_ == null) {
                    return Collections.unmodifiableList(this.usedItemList_);
                }
                return this.usedItemListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public int getUsedItemListCount() {
                if (this.usedItemListBuilder_ == null) {
                    return this.usedItemList_.size();
                }
                return this.usedItemListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                    this.bitField0_ &= -5;
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

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getUsedItemListOrBuilder(int index) {
                if (this.usedItemListBuilder_ == null) {
                    return this.usedItemList_.get(index);
                }
                return this.usedItemListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                    this.usedItemListBuilder_ = new RepeatedFieldBuilderV3<>(this.usedItemList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.usedItemList_ = null;
                }
                return this.usedItemListBuilder_;
            }

            private void ensureUnk3300FHNNJJDGLOOIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unk3300FHNNJJDGLOO_ = WinterCampInfo.mutableCopy(this.unk3300FHNNJJDGLOO_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public List<Integer> getUnk3300FHNNJJDGLOOList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.unk3300FHNNJJDGLOO_) : this.unk3300FHNNJJDGLOO_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public int getUnk3300FHNNJJDGLOOCount() {
                return this.unk3300FHNNJJDGLOO_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                this.unk3300FHNNJJDGLOO_ = WinterCampInfo.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public boolean hasExploreInfo() {
                return (this.exploreInfoBuilder_ == null && this.exploreInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                if ((this.bitField0_ & 16) == 0) {
                    this.unk3300KCGKNJFGCFC_ = WinterCampInfo.mutableCopy(this.unk3300KCGKNJFGCFC_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public List<Integer> getUnk3300KCGKNJFGCFCList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.unk3300KCGKNJFGCFC_) : this.unk3300KCGKNJFGCFC_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public int getUnk3300KCGKNJFGCFCCount() {
                return this.unk3300KCGKNJFGCFC_.size();
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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
                this.unk3300KCGKNJFGCFC_ = WinterCampInfo.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
            public boolean hasBattleInfo() {
                return (this.battleInfoBuilder_ == null && this.battleInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.WinterCampInfoOuterClass.WinterCampInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static WinterCampInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WinterCampStageInfoOuterClass.getDescriptor();
        WinterCampRaceStageInfoOuterClass.getDescriptor();
        ItemParamOuterClass.getDescriptor();
    }
}
