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
import emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass;
import emu.grasscutter.net.proto.HomeFurnitureDataOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSceneArrangementInfoOuterClass.class */
public final class HomeSceneArrangementInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eHomeSceneArrangementInfo.proto\u001a\u001eHomeBlockArrangementInfo.proto\u001a\u0017HomeFurnitureData.proto\u001a\fVector.proto\"\u0003\n\u0018HomeSceneArrangementInfo\u0012\u0015\n\rcomfort_value\u0018\u0006 \u0001(\r\u0012>\n\u001bblock_arrangement_info_list\u0018\u0001 \u0003(\u000b2\u0019.HomeBlockArrangementInfo\u0012\u0017\n\u000fis_set_born_pos\u0018\u0004 \u0001(\b\u0012\u001a\n\tdjinn_pos\u0018\u000e \u0001(\u000b2\u0007.Vector\u0012\u0019\n\bborn_rot\u0018\n \u0001(\u000b2\u0007.Vector\u0012\u000e\n\u0006bgm_id\u0018\u0005 \u0001(\r\u0012\u0019\n\bborn_pos\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012/\n\u0013Unk3300_GCHNAMHBPHG\u0018\u0002 \u0003(\u000b2\u0012.HomeFurnitureData\u0012&\n\nmain_house\u0018\u000f \u0001(\u000b2\u0012.HomeFurnitureData\u0012\u0010\n\bscene_id\u0018\b \u0001(\r\u0012/\n\u0013Unk3300_HPCHPODNBPH\u0018\t \u0003(\u000b2\u0012.HomeFurnitureData\u0012\u0013\n\u000btmp_version\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeBlockArrangementInfoOuterClass.getDescriptor(), HomeFurnitureDataOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeSceneArrangementInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeSceneArrangementInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeSceneArrangementInfo_descriptor, new String[]{"ComfortValue", "BlockArrangementInfoList", "IsSetBornPos", "DjinnPos", "BornRot", "BgmId", "BornPos", "Unk3300GCHNAMHBPHG", "MainHouse", "SceneId", "Unk3300HPCHPODNBPH", "TmpVersion"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSceneArrangementInfoOuterClass$HomeSceneArrangementInfoOrBuilder.class */
    public interface HomeSceneArrangementInfoOrBuilder extends MessageOrBuilder {
        int getComfortValue();

        List<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo> getBlockArrangementInfoListList();

        HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo getBlockArrangementInfoList(int i);

        int getBlockArrangementInfoListCount();

        List<? extends HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder> getBlockArrangementInfoListOrBuilderList();

        HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder getBlockArrangementInfoListOrBuilder(int i);

        boolean getIsSetBornPos();

        boolean hasDjinnPos();

        VectorOuterClass.Vector getDjinnPos();

        VectorOuterClass.VectorOrBuilder getDjinnPosOrBuilder();

        boolean hasBornRot();

        VectorOuterClass.Vector getBornRot();

        VectorOuterClass.VectorOrBuilder getBornRotOrBuilder();

        int getBgmId();

        boolean hasBornPos();

        VectorOuterClass.Vector getBornPos();

        VectorOuterClass.VectorOrBuilder getBornPosOrBuilder();

        List<HomeFurnitureDataOuterClass.HomeFurnitureData> getUnk3300GCHNAMHBPHGList();

        HomeFurnitureDataOuterClass.HomeFurnitureData getUnk3300GCHNAMHBPHG(int i);

        int getUnk3300GCHNAMHBPHGCount();

        List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300GCHNAMHBPHGOrBuilderList();

        HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getUnk3300GCHNAMHBPHGOrBuilder(int i);

        boolean hasMainHouse();

        HomeFurnitureDataOuterClass.HomeFurnitureData getMainHouse();

        HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getMainHouseOrBuilder();

        int getSceneId();

        List<HomeFurnitureDataOuterClass.HomeFurnitureData> getUnk3300HPCHPODNBPHList();

        HomeFurnitureDataOuterClass.HomeFurnitureData getUnk3300HPCHPODNBPH(int i);

        int getUnk3300HPCHPODNBPHCount();

        List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300HPCHPODNBPHOrBuilderList();

        HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getUnk3300HPCHPODNBPHOrBuilder(int i);

        int getTmpVersion();
    }

    private HomeSceneArrangementInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSceneArrangementInfoOuterClass$HomeSceneArrangementInfo.class */
    public static final class HomeSceneArrangementInfo extends GeneratedMessageV3 implements HomeSceneArrangementInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMFORT_VALUE_FIELD_NUMBER = 6;
        private int comfortValue_;
        public static final int BLOCK_ARRANGEMENT_INFO_LIST_FIELD_NUMBER = 1;
        private List<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo> blockArrangementInfoList_;
        public static final int IS_SET_BORN_POS_FIELD_NUMBER = 4;
        private boolean isSetBornPos_;
        public static final int DJINN_POS_FIELD_NUMBER = 14;
        private VectorOuterClass.Vector djinnPos_;
        public static final int BORN_ROT_FIELD_NUMBER = 10;
        private VectorOuterClass.Vector bornRot_;
        public static final int BGM_ID_FIELD_NUMBER = 5;
        private int bgmId_;
        public static final int BORN_POS_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector bornPos_;
        public static final int UNK3300_GCHNAMHBPHG_FIELD_NUMBER = 2;
        private List<HomeFurnitureDataOuterClass.HomeFurnitureData> unk3300GCHNAMHBPHG_;
        public static final int MAIN_HOUSE_FIELD_NUMBER = 15;
        private HomeFurnitureDataOuterClass.HomeFurnitureData mainHouse_;
        public static final int SCENE_ID_FIELD_NUMBER = 8;
        private int sceneId_;
        public static final int UNK3300_HPCHPODNBPH_FIELD_NUMBER = 9;
        private List<HomeFurnitureDataOuterClass.HomeFurnitureData> unk3300HPCHPODNBPH_;
        public static final int TMP_VERSION_FIELD_NUMBER = 3;
        private int tmpVersion_;
        private byte memoizedIsInitialized;
        private static final HomeSceneArrangementInfo DEFAULT_INSTANCE = new HomeSceneArrangementInfo();
        private static final Parser<HomeSceneArrangementInfo> PARSER = new AbstractParser<HomeSceneArrangementInfo>() { // from class: emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo.1
            @Override // com.google.protobuf.Parser
            public HomeSceneArrangementInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeSceneArrangementInfo(input, extensionRegistry);
            }
        };

        private HomeSceneArrangementInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeSceneArrangementInfo() {
            this.memoizedIsInitialized = -1;
            this.blockArrangementInfoList_ = Collections.emptyList();
            this.unk3300GCHNAMHBPHG_ = Collections.emptyList();
            this.unk3300HPCHPODNBPH_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeSceneArrangementInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:111:0x0260 */
        private HomeSceneArrangementInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.blockArrangementInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.blockArrangementInfoList_.add((HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo) input.readMessage(HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.parser(), extensionRegistry));
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300GCHNAMHBPHG_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300GCHNAMHBPHG_.add((HomeFurnitureDataOuterClass.HomeFurnitureData) input.readMessage(HomeFurnitureDataOuterClass.HomeFurnitureData.parser(), extensionRegistry));
                                break;
                            case 24:
                                this.tmpVersion_ = input.readUInt32();
                                break;
                            case 32:
                                this.isSetBornPos_ = input.readBool();
                                break;
                            case 40:
                                this.bgmId_ = input.readUInt32();
                                break;
                            case 48:
                                this.comfortValue_ = input.readUInt32();
                                break;
                            case 64:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.unk3300HPCHPODNBPH_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.unk3300HPCHPODNBPH_.add((HomeFurnitureDataOuterClass.HomeFurnitureData) input.readMessage(HomeFurnitureDataOuterClass.HomeFurnitureData.parser(), extensionRegistry));
                                break;
                            case 82:
                                VectorOuterClass.Vector.Builder subBuilder = this.bornRot_ != null ? this.bornRot_.toBuilder() : null;
                                this.bornRot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.bornRot_);
                                    this.bornRot_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 90:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.bornPos_ != null ? this.bornPos_.toBuilder() : null;
                                this.bornPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.bornPos_);
                                    this.bornPos_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 114:
                                VectorOuterClass.Vector.Builder subBuilder3 = this.djinnPos_ != null ? this.djinnPos_.toBuilder() : null;
                                this.djinnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.djinnPos_);
                                    this.djinnPos_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 122:
                                HomeFurnitureDataOuterClass.HomeFurnitureData.Builder subBuilder4 = this.mainHouse_ != null ? this.mainHouse_.toBuilder() : null;
                                this.mainHouse_ = (HomeFurnitureDataOuterClass.HomeFurnitureData) input.readMessage(HomeFurnitureDataOuterClass.HomeFurnitureData.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.mainHouse_);
                                    this.mainHouse_ = subBuilder4.buildPartial();
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
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.blockArrangementInfoList_ = Collections.unmodifiableList(this.blockArrangementInfoList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300GCHNAMHBPHG_ = Collections.unmodifiableList(this.unk3300GCHNAMHBPHG_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unk3300HPCHPODNBPH_ = Collections.unmodifiableList(this.unk3300HPCHPODNBPH_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeSceneArrangementInfoOuterClass.internal_static_HomeSceneArrangementInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeSceneArrangementInfoOuterClass.internal_static_HomeSceneArrangementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSceneArrangementInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getComfortValue() {
            return this.comfortValue_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public List<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo> getBlockArrangementInfoListList() {
            return this.blockArrangementInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public List<? extends HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder> getBlockArrangementInfoListOrBuilderList() {
            return this.blockArrangementInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getBlockArrangementInfoListCount() {
            return this.blockArrangementInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo getBlockArrangementInfoList(int index) {
            return this.blockArrangementInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder getBlockArrangementInfoListOrBuilder(int index) {
            return this.blockArrangementInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public boolean getIsSetBornPos() {
            return this.isSetBornPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public boolean hasDjinnPos() {
            return this.djinnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public VectorOuterClass.Vector getDjinnPos() {
            return this.djinnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getDjinnPosOrBuilder() {
            return getDjinnPos();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public boolean hasBornRot() {
            return this.bornRot_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public VectorOuterClass.Vector getBornRot() {
            return this.bornRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornRot_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getBornRotOrBuilder() {
            return getBornRot();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getBgmId() {
            return this.bgmId_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public boolean hasBornPos() {
            return this.bornPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public VectorOuterClass.Vector getBornPos() {
            return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getBornPosOrBuilder() {
            return getBornPos();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getUnk3300GCHNAMHBPHGList() {
            return this.unk3300GCHNAMHBPHG_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300GCHNAMHBPHGOrBuilderList() {
            return this.unk3300GCHNAMHBPHG_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getUnk3300GCHNAMHBPHGCount() {
            return this.unk3300GCHNAMHBPHG_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureData getUnk3300GCHNAMHBPHG(int index) {
            return this.unk3300GCHNAMHBPHG_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getUnk3300GCHNAMHBPHGOrBuilder(int index) {
            return this.unk3300GCHNAMHBPHG_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public boolean hasMainHouse() {
            return this.mainHouse_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureData getMainHouse() {
            return this.mainHouse_ == null ? HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance() : this.mainHouse_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getMainHouseOrBuilder() {
            return getMainHouse();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getUnk3300HPCHPODNBPHList() {
            return this.unk3300HPCHPODNBPH_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300HPCHPODNBPHOrBuilderList() {
            return this.unk3300HPCHPODNBPH_;
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getUnk3300HPCHPODNBPHCount() {
            return this.unk3300HPCHPODNBPH_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureData getUnk3300HPCHPODNBPH(int index) {
            return this.unk3300HPCHPODNBPH_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getUnk3300HPCHPODNBPHOrBuilder(int index) {
            return this.unk3300HPCHPODNBPH_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
        public int getTmpVersion() {
            return this.tmpVersion_;
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
            for (int i = 0; i < this.blockArrangementInfoList_.size(); i++) {
                output.writeMessage(1, this.blockArrangementInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.unk3300GCHNAMHBPHG_.size(); i2++) {
                output.writeMessage(2, this.unk3300GCHNAMHBPHG_.get(i2));
            }
            if (this.tmpVersion_ != 0) {
                output.writeUInt32(3, this.tmpVersion_);
            }
            if (this.isSetBornPos_) {
                output.writeBool(4, this.isSetBornPos_);
            }
            if (this.bgmId_ != 0) {
                output.writeUInt32(5, this.bgmId_);
            }
            if (this.comfortValue_ != 0) {
                output.writeUInt32(6, this.comfortValue_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(8, this.sceneId_);
            }
            for (int i3 = 0; i3 < this.unk3300HPCHPODNBPH_.size(); i3++) {
                output.writeMessage(9, this.unk3300HPCHPODNBPH_.get(i3));
            }
            if (this.bornRot_ != null) {
                output.writeMessage(10, getBornRot());
            }
            if (this.bornPos_ != null) {
                output.writeMessage(11, getBornPos());
            }
            if (this.djinnPos_ != null) {
                output.writeMessage(14, getDjinnPos());
            }
            if (this.mainHouse_ != null) {
                output.writeMessage(15, getMainHouse());
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
            for (int i = 0; i < this.blockArrangementInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.blockArrangementInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.unk3300GCHNAMHBPHG_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.unk3300GCHNAMHBPHG_.get(i2));
            }
            if (this.tmpVersion_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.tmpVersion_);
            }
            if (this.isSetBornPos_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isSetBornPos_);
            }
            if (this.bgmId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.bgmId_);
            }
            if (this.comfortValue_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.comfortValue_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.sceneId_);
            }
            for (int i3 = 0; i3 < this.unk3300HPCHPODNBPH_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.unk3300HPCHPODNBPH_.get(i3));
            }
            if (this.bornRot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getBornRot());
            }
            if (this.bornPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getBornPos());
            }
            if (this.djinnPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getDjinnPos());
            }
            if (this.mainHouse_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getMainHouse());
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
            if (!(obj instanceof HomeSceneArrangementInfo)) {
                return equals(obj);
            }
            HomeSceneArrangementInfo other = (HomeSceneArrangementInfo) obj;
            if (getComfortValue() != other.getComfortValue() || !getBlockArrangementInfoListList().equals(other.getBlockArrangementInfoListList()) || getIsSetBornPos() != other.getIsSetBornPos() || hasDjinnPos() != other.hasDjinnPos()) {
                return false;
            }
            if ((hasDjinnPos() && !getDjinnPos().equals(other.getDjinnPos())) || hasBornRot() != other.hasBornRot()) {
                return false;
            }
            if ((hasBornRot() && !getBornRot().equals(other.getBornRot())) || getBgmId() != other.getBgmId() || hasBornPos() != other.hasBornPos()) {
                return false;
            }
            if ((!hasBornPos() || getBornPos().equals(other.getBornPos())) && getUnk3300GCHNAMHBPHGList().equals(other.getUnk3300GCHNAMHBPHGList()) && hasMainHouse() == other.hasMainHouse()) {
                return (!hasMainHouse() || getMainHouse().equals(other.getMainHouse())) && getSceneId() == other.getSceneId() && getUnk3300HPCHPODNBPHList().equals(other.getUnk3300HPCHPODNBPHList()) && getTmpVersion() == other.getTmpVersion() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getComfortValue();
            if (getBlockArrangementInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getBlockArrangementInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + Internal.hashBoolean(getIsSetBornPos());
            if (hasDjinnPos()) {
                hash2 = (53 * ((37 * hash2) + 14)) + getDjinnPos().hashCode();
            }
            if (hasBornRot()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getBornRot().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 5)) + getBgmId();
            if (hasBornPos()) {
                hash3 = (53 * ((37 * hash3) + 11)) + getBornPos().hashCode();
            }
            if (getUnk3300GCHNAMHBPHGCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 2)) + getUnk3300GCHNAMHBPHGList().hashCode();
            }
            if (hasMainHouse()) {
                hash3 = (53 * ((37 * hash3) + 15)) + getMainHouse().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 8)) + getSceneId();
            if (getUnk3300HPCHPODNBPHCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 9)) + getUnk3300HPCHPODNBPHList().hashCode();
            }
            int hash5 = (29 * ((53 * ((37 * hash4) + 3)) + getTmpVersion())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static HomeSceneArrangementInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSceneArrangementInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSceneArrangementInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSceneArrangementInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSceneArrangementInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeSceneArrangementInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeSceneArrangementInfo parseFrom(InputStream input) throws IOException {
            return (HomeSceneArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSceneArrangementInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSceneArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSceneArrangementInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeSceneArrangementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeSceneArrangementInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSceneArrangementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeSceneArrangementInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeSceneArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeSceneArrangementInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeSceneArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeSceneArrangementInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeSceneArrangementInfoOuterClass$HomeSceneArrangementInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeSceneArrangementInfoOrBuilder {
            private int bitField0_;
            private int comfortValue_;
            private RepeatedFieldBuilderV3<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder> blockArrangementInfoListBuilder_;
            private boolean isSetBornPos_;
            private VectorOuterClass.Vector djinnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> djinnPosBuilder_;
            private VectorOuterClass.Vector bornRot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> bornRotBuilder_;
            private int bgmId_;
            private VectorOuterClass.Vector bornPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> bornPosBuilder_;
            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> unk3300GCHNAMHBPHGBuilder_;
            private HomeFurnitureDataOuterClass.HomeFurnitureData mainHouse_;
            private SingleFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> mainHouseBuilder_;
            private int sceneId_;
            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> unk3300HPCHPODNBPHBuilder_;
            private int tmpVersion_;
            private List<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo> blockArrangementInfoList_ = Collections.emptyList();
            private List<HomeFurnitureDataOuterClass.HomeFurnitureData> unk3300GCHNAMHBPHG_ = Collections.emptyList();
            private List<HomeFurnitureDataOuterClass.HomeFurnitureData> unk3300HPCHPODNBPH_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeSceneArrangementInfoOuterClass.internal_static_HomeSceneArrangementInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeSceneArrangementInfoOuterClass.internal_static_HomeSceneArrangementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeSceneArrangementInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeSceneArrangementInfo.alwaysUseFieldBuilders) {
                    getBlockArrangementInfoListFieldBuilder();
                    getUnk3300GCHNAMHBPHGFieldBuilder();
                    getUnk3300HPCHPODNBPHFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.comfortValue_ = 0;
                if (this.blockArrangementInfoListBuilder_ == null) {
                    this.blockArrangementInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.blockArrangementInfoListBuilder_.clear();
                }
                this.isSetBornPos_ = false;
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPos_ = null;
                } else {
                    this.djinnPos_ = null;
                    this.djinnPosBuilder_ = null;
                }
                if (this.bornRotBuilder_ == null) {
                    this.bornRot_ = null;
                } else {
                    this.bornRot_ = null;
                    this.bornRotBuilder_ = null;
                }
                this.bgmId_ = 0;
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = null;
                } else {
                    this.bornPos_ = null;
                    this.bornPosBuilder_ = null;
                }
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    this.unk3300GCHNAMHBPHG_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.clear();
                }
                if (this.mainHouseBuilder_ == null) {
                    this.mainHouse_ = null;
                } else {
                    this.mainHouse_ = null;
                    this.mainHouseBuilder_ = null;
                }
                this.sceneId_ = 0;
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    this.unk3300HPCHPODNBPH_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.clear();
                }
                this.tmpVersion_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeSceneArrangementInfoOuterClass.internal_static_HomeSceneArrangementInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeSceneArrangementInfo getDefaultInstanceForType() {
                return HomeSceneArrangementInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSceneArrangementInfo build() {
                HomeSceneArrangementInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeSceneArrangementInfo buildPartial() {
                HomeSceneArrangementInfo result = new HomeSceneArrangementInfo(this);
                int i = this.bitField0_;
                result.comfortValue_ = this.comfortValue_;
                if (this.blockArrangementInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.blockArrangementInfoList_ = Collections.unmodifiableList(this.blockArrangementInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.blockArrangementInfoList_ = this.blockArrangementInfoList_;
                } else {
                    result.blockArrangementInfoList_ = this.blockArrangementInfoListBuilder_.build();
                }
                result.isSetBornPos_ = this.isSetBornPos_;
                if (this.djinnPosBuilder_ == null) {
                    result.djinnPos_ = this.djinnPos_;
                } else {
                    result.djinnPos_ = this.djinnPosBuilder_.build();
                }
                if (this.bornRotBuilder_ == null) {
                    result.bornRot_ = this.bornRot_;
                } else {
                    result.bornRot_ = this.bornRotBuilder_.build();
                }
                result.bgmId_ = this.bgmId_;
                if (this.bornPosBuilder_ == null) {
                    result.bornPos_ = this.bornPos_;
                } else {
                    result.bornPos_ = this.bornPosBuilder_.build();
                }
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.unk3300GCHNAMHBPHG_ = Collections.unmodifiableList(this.unk3300GCHNAMHBPHG_);
                        this.bitField0_ &= -3;
                    }
                    result.unk3300GCHNAMHBPHG_ = this.unk3300GCHNAMHBPHG_;
                } else {
                    result.unk3300GCHNAMHBPHG_ = this.unk3300GCHNAMHBPHGBuilder_.build();
                }
                if (this.mainHouseBuilder_ == null) {
                    result.mainHouse_ = this.mainHouse_;
                } else {
                    result.mainHouse_ = this.mainHouseBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.unk3300HPCHPODNBPH_ = Collections.unmodifiableList(this.unk3300HPCHPODNBPH_);
                        this.bitField0_ &= -5;
                    }
                    result.unk3300HPCHPODNBPH_ = this.unk3300HPCHPODNBPH_;
                } else {
                    result.unk3300HPCHPODNBPH_ = this.unk3300HPCHPODNBPHBuilder_.build();
                }
                result.tmpVersion_ = this.tmpVersion_;
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
                if (other instanceof HomeSceneArrangementInfo) {
                    return mergeFrom((HomeSceneArrangementInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeSceneArrangementInfo other) {
                if (other == HomeSceneArrangementInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getComfortValue() != 0) {
                    setComfortValue(other.getComfortValue());
                }
                if (this.blockArrangementInfoListBuilder_ == null) {
                    if (!other.blockArrangementInfoList_.isEmpty()) {
                        if (this.blockArrangementInfoList_.isEmpty()) {
                            this.blockArrangementInfoList_ = other.blockArrangementInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBlockArrangementInfoListIsMutable();
                            this.blockArrangementInfoList_.addAll(other.blockArrangementInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.blockArrangementInfoList_.isEmpty()) {
                    if (this.blockArrangementInfoListBuilder_.isEmpty()) {
                        this.blockArrangementInfoListBuilder_.dispose();
                        this.blockArrangementInfoListBuilder_ = null;
                        this.blockArrangementInfoList_ = other.blockArrangementInfoList_;
                        this.bitField0_ &= -2;
                        this.blockArrangementInfoListBuilder_ = HomeSceneArrangementInfo.alwaysUseFieldBuilders ? getBlockArrangementInfoListFieldBuilder() : null;
                    } else {
                        this.blockArrangementInfoListBuilder_.addAllMessages(other.blockArrangementInfoList_);
                    }
                }
                if (other.getIsSetBornPos()) {
                    setIsSetBornPos(other.getIsSetBornPos());
                }
                if (other.hasDjinnPos()) {
                    mergeDjinnPos(other.getDjinnPos());
                }
                if (other.hasBornRot()) {
                    mergeBornRot(other.getBornRot());
                }
                if (other.getBgmId() != 0) {
                    setBgmId(other.getBgmId());
                }
                if (other.hasBornPos()) {
                    mergeBornPos(other.getBornPos());
                }
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    if (!other.unk3300GCHNAMHBPHG_.isEmpty()) {
                        if (this.unk3300GCHNAMHBPHG_.isEmpty()) {
                            this.unk3300GCHNAMHBPHG_ = other.unk3300GCHNAMHBPHG_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureUnk3300GCHNAMHBPHGIsMutable();
                            this.unk3300GCHNAMHBPHG_.addAll(other.unk3300GCHNAMHBPHG_);
                        }
                        onChanged();
                    }
                } else if (!other.unk3300GCHNAMHBPHG_.isEmpty()) {
                    if (this.unk3300GCHNAMHBPHGBuilder_.isEmpty()) {
                        this.unk3300GCHNAMHBPHGBuilder_.dispose();
                        this.unk3300GCHNAMHBPHGBuilder_ = null;
                        this.unk3300GCHNAMHBPHG_ = other.unk3300GCHNAMHBPHG_;
                        this.bitField0_ &= -3;
                        this.unk3300GCHNAMHBPHGBuilder_ = HomeSceneArrangementInfo.alwaysUseFieldBuilders ? getUnk3300GCHNAMHBPHGFieldBuilder() : null;
                    } else {
                        this.unk3300GCHNAMHBPHGBuilder_.addAllMessages(other.unk3300GCHNAMHBPHG_);
                    }
                }
                if (other.hasMainHouse()) {
                    mergeMainHouse(other.getMainHouse());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    if (!other.unk3300HPCHPODNBPH_.isEmpty()) {
                        if (this.unk3300HPCHPODNBPH_.isEmpty()) {
                            this.unk3300HPCHPODNBPH_ = other.unk3300HPCHPODNBPH_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureUnk3300HPCHPODNBPHIsMutable();
                            this.unk3300HPCHPODNBPH_.addAll(other.unk3300HPCHPODNBPH_);
                        }
                        onChanged();
                    }
                } else if (!other.unk3300HPCHPODNBPH_.isEmpty()) {
                    if (this.unk3300HPCHPODNBPHBuilder_.isEmpty()) {
                        this.unk3300HPCHPODNBPHBuilder_.dispose();
                        this.unk3300HPCHPODNBPHBuilder_ = null;
                        this.unk3300HPCHPODNBPH_ = other.unk3300HPCHPODNBPH_;
                        this.bitField0_ &= -5;
                        this.unk3300HPCHPODNBPHBuilder_ = HomeSceneArrangementInfo.alwaysUseFieldBuilders ? getUnk3300HPCHPODNBPHFieldBuilder() : null;
                    } else {
                        this.unk3300HPCHPODNBPHBuilder_.addAllMessages(other.unk3300HPCHPODNBPH_);
                    }
                }
                if (other.getTmpVersion() != 0) {
                    setTmpVersion(other.getTmpVersion());
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
                HomeSceneArrangementInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeSceneArrangementInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeSceneArrangementInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getComfortValue() {
                return this.comfortValue_;
            }

            public Builder setComfortValue(int value) {
                this.comfortValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearComfortValue() {
                this.comfortValue_ = 0;
                onChanged();
                return this;
            }

            private void ensureBlockArrangementInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.blockArrangementInfoList_ = new ArrayList(this.blockArrangementInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public List<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo> getBlockArrangementInfoListList() {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.blockArrangementInfoList_);
                }
                return this.blockArrangementInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getBlockArrangementInfoListCount() {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    return this.blockArrangementInfoList_.size();
                }
                return this.blockArrangementInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo getBlockArrangementInfoList(int index) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    return this.blockArrangementInfoList_.get(index);
                }
                return this.blockArrangementInfoListBuilder_.getMessage(index);
            }

            public Builder setBlockArrangementInfoList(int index, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo value) {
                if (this.blockArrangementInfoListBuilder_ != null) {
                    this.blockArrangementInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBlockArrangementInfoList(int index, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder builderForValue) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.blockArrangementInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBlockArrangementInfoList(HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo value) {
                if (this.blockArrangementInfoListBuilder_ != null) {
                    this.blockArrangementInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBlockArrangementInfoList(int index, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo value) {
                if (this.blockArrangementInfoListBuilder_ != null) {
                    this.blockArrangementInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBlockArrangementInfoList(HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder builderForValue) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.blockArrangementInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBlockArrangementInfoList(int index, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder builderForValue) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.blockArrangementInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBlockArrangementInfoList(Iterable<? extends HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo> values) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    ensureBlockArrangementInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.blockArrangementInfoList_);
                    onChanged();
                } else {
                    this.blockArrangementInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBlockArrangementInfoList() {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    this.blockArrangementInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.blockArrangementInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBlockArrangementInfoList(int index) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    ensureBlockArrangementInfoListIsMutable();
                    this.blockArrangementInfoList_.remove(index);
                    onChanged();
                } else {
                    this.blockArrangementInfoListBuilder_.remove(index);
                }
                return this;
            }

            public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder getBlockArrangementInfoListBuilder(int index) {
                return getBlockArrangementInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder getBlockArrangementInfoListOrBuilder(int index) {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    return this.blockArrangementInfoList_.get(index);
                }
                return this.blockArrangementInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public List<? extends HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder> getBlockArrangementInfoListOrBuilderList() {
                if (this.blockArrangementInfoListBuilder_ != null) {
                    return this.blockArrangementInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.blockArrangementInfoList_);
            }

            public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder addBlockArrangementInfoListBuilder() {
                return getBlockArrangementInfoListFieldBuilder().addBuilder(HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.getDefaultInstance());
            }

            public HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder addBlockArrangementInfoListBuilder(int index) {
                return getBlockArrangementInfoListFieldBuilder().addBuilder(index, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.getDefaultInstance());
            }

            public List<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder> getBlockArrangementInfoListBuilderList() {
                return getBlockArrangementInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.Builder, HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder> getBlockArrangementInfoListFieldBuilder() {
                if (this.blockArrangementInfoListBuilder_ == null) {
                    this.blockArrangementInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.blockArrangementInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.blockArrangementInfoList_ = null;
                }
                return this.blockArrangementInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public boolean getIsSetBornPos() {
                return this.isSetBornPos_;
            }

            public Builder setIsSetBornPos(boolean value) {
                this.isSetBornPos_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSetBornPos() {
                this.isSetBornPos_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public boolean hasDjinnPos() {
                return (this.djinnPosBuilder_ == null && this.djinnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public VectorOuterClass.Vector getDjinnPos() {
                if (this.djinnPosBuilder_ == null) {
                    return this.djinnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnPos_;
                }
                return this.djinnPosBuilder_.getMessage();
            }

            public Builder setDjinnPos(VectorOuterClass.Vector value) {
                if (this.djinnPosBuilder_ != null) {
                    this.djinnPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.djinnPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDjinnPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.djinnPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDjinnPos(VectorOuterClass.Vector value) {
                if (this.djinnPosBuilder_ == null) {
                    if (this.djinnPos_ != null) {
                        this.djinnPos_ = VectorOuterClass.Vector.newBuilder(this.djinnPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.djinnPos_ = value;
                    }
                    onChanged();
                } else {
                    this.djinnPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDjinnPos() {
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPos_ = null;
                    onChanged();
                } else {
                    this.djinnPos_ = null;
                    this.djinnPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDjinnPosBuilder() {
                onChanged();
                return getDjinnPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getDjinnPosOrBuilder() {
                if (this.djinnPosBuilder_ != null) {
                    return this.djinnPosBuilder_.getMessageOrBuilder();
                }
                return this.djinnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDjinnPosFieldBuilder() {
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPosBuilder_ = new SingleFieldBuilderV3<>(getDjinnPos(), getParentForChildren(), isClean());
                    this.djinnPos_ = null;
                }
                return this.djinnPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public boolean hasBornRot() {
                return (this.bornRotBuilder_ == null && this.bornRot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public VectorOuterClass.Vector getBornRot() {
                if (this.bornRotBuilder_ == null) {
                    return this.bornRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornRot_;
                }
                return this.bornRotBuilder_.getMessage();
            }

            public Builder setBornRot(VectorOuterClass.Vector value) {
                if (this.bornRotBuilder_ != null) {
                    this.bornRotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.bornRot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBornRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.bornRotBuilder_ == null) {
                    this.bornRot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bornRotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBornRot(VectorOuterClass.Vector value) {
                if (this.bornRotBuilder_ == null) {
                    if (this.bornRot_ != null) {
                        this.bornRot_ = VectorOuterClass.Vector.newBuilder(this.bornRot_).mergeFrom(value).buildPartial();
                    } else {
                        this.bornRot_ = value;
                    }
                    onChanged();
                } else {
                    this.bornRotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBornRot() {
                if (this.bornRotBuilder_ == null) {
                    this.bornRot_ = null;
                    onChanged();
                } else {
                    this.bornRot_ = null;
                    this.bornRotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getBornRotBuilder() {
                onChanged();
                return getBornRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getBornRotOrBuilder() {
                if (this.bornRotBuilder_ != null) {
                    return this.bornRotBuilder_.getMessageOrBuilder();
                }
                return this.bornRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornRot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getBornRotFieldBuilder() {
                if (this.bornRotBuilder_ == null) {
                    this.bornRotBuilder_ = new SingleFieldBuilderV3<>(getBornRot(), getParentForChildren(), isClean());
                    this.bornRot_ = null;
                }
                return this.bornRotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getBgmId() {
                return this.bgmId_;
            }

            public Builder setBgmId(int value) {
                this.bgmId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBgmId() {
                this.bgmId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public boolean hasBornPos() {
                return (this.bornPosBuilder_ == null && this.bornPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public VectorOuterClass.Vector getBornPos() {
                if (this.bornPosBuilder_ == null) {
                    return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
                }
                return this.bornPosBuilder_.getMessage();
            }

            public Builder setBornPos(VectorOuterClass.Vector value) {
                if (this.bornPosBuilder_ != null) {
                    this.bornPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.bornPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBornPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bornPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBornPos(VectorOuterClass.Vector value) {
                if (this.bornPosBuilder_ == null) {
                    if (this.bornPos_ != null) {
                        this.bornPos_ = VectorOuterClass.Vector.newBuilder(this.bornPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.bornPos_ = value;
                    }
                    onChanged();
                } else {
                    this.bornPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBornPos() {
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = null;
                    onChanged();
                } else {
                    this.bornPos_ = null;
                    this.bornPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getBornPosBuilder() {
                onChanged();
                return getBornPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getBornPosOrBuilder() {
                if (this.bornPosBuilder_ != null) {
                    return this.bornPosBuilder_.getMessageOrBuilder();
                }
                return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getBornPosFieldBuilder() {
                if (this.bornPosBuilder_ == null) {
                    this.bornPosBuilder_ = new SingleFieldBuilderV3<>(getBornPos(), getParentForChildren(), isClean());
                    this.bornPos_ = null;
                }
                return this.bornPosBuilder_;
            }

            private void ensureUnk3300GCHNAMHBPHGIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300GCHNAMHBPHG_ = new ArrayList(this.unk3300GCHNAMHBPHG_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getUnk3300GCHNAMHBPHGList() {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    return Collections.unmodifiableList(this.unk3300GCHNAMHBPHG_);
                }
                return this.unk3300GCHNAMHBPHGBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getUnk3300GCHNAMHBPHGCount() {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    return this.unk3300GCHNAMHBPHG_.size();
                }
                return this.unk3300GCHNAMHBPHGBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureData getUnk3300GCHNAMHBPHG(int index) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    return this.unk3300GCHNAMHBPHG_.get(index);
                }
                return this.unk3300GCHNAMHBPHGBuilder_.getMessage(index);
            }

            public Builder setUnk3300GCHNAMHBPHG(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.unk3300GCHNAMHBPHGBuilder_ != null) {
                    this.unk3300GCHNAMHBPHGBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300GCHNAMHBPHG(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300GCHNAMHBPHG(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.unk3300GCHNAMHBPHGBuilder_ != null) {
                    this.unk3300GCHNAMHBPHGBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300GCHNAMHBPHG(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.unk3300GCHNAMHBPHGBuilder_ != null) {
                    this.unk3300GCHNAMHBPHGBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300GCHNAMHBPHG(HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300GCHNAMHBPHG(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk3300GCHNAMHBPHG(Iterable<? extends HomeFurnitureDataOuterClass.HomeFurnitureData> values) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300GCHNAMHBPHG_);
                    onChanged();
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk3300GCHNAMHBPHG() {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    this.unk3300GCHNAMHBPHG_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk3300GCHNAMHBPHG(int index) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    ensureUnk3300GCHNAMHBPHGIsMutable();
                    this.unk3300GCHNAMHBPHG_.remove(index);
                    onChanged();
                } else {
                    this.unk3300GCHNAMHBPHGBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder getUnk3300GCHNAMHBPHGBuilder(int index) {
                return getUnk3300GCHNAMHBPHGFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getUnk3300GCHNAMHBPHGOrBuilder(int index) {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    return this.unk3300GCHNAMHBPHG_.get(index);
                }
                return this.unk3300GCHNAMHBPHGBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300GCHNAMHBPHGOrBuilderList() {
                if (this.unk3300GCHNAMHBPHGBuilder_ != null) {
                    return this.unk3300GCHNAMHBPHGBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk3300GCHNAMHBPHG_);
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addUnk3300GCHNAMHBPHGBuilder() {
                return getUnk3300GCHNAMHBPHGFieldBuilder().addBuilder(HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addUnk3300GCHNAMHBPHGBuilder(int index) {
                return getUnk3300GCHNAMHBPHGFieldBuilder().addBuilder(index, HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public List<HomeFurnitureDataOuterClass.HomeFurnitureData.Builder> getUnk3300GCHNAMHBPHGBuilderList() {
                return getUnk3300GCHNAMHBPHGFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300GCHNAMHBPHGFieldBuilder() {
                if (this.unk3300GCHNAMHBPHGBuilder_ == null) {
                    this.unk3300GCHNAMHBPHGBuilder_ = new RepeatedFieldBuilderV3<>(this.unk3300GCHNAMHBPHG_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.unk3300GCHNAMHBPHG_ = null;
                }
                return this.unk3300GCHNAMHBPHGBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public boolean hasMainHouse() {
                return (this.mainHouseBuilder_ == null && this.mainHouse_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureData getMainHouse() {
                if (this.mainHouseBuilder_ == null) {
                    return this.mainHouse_ == null ? HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance() : this.mainHouse_;
                }
                return this.mainHouseBuilder_.getMessage();
            }

            public Builder setMainHouse(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.mainHouseBuilder_ != null) {
                    this.mainHouseBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.mainHouse_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMainHouse(HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.mainHouseBuilder_ == null) {
                    this.mainHouse_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mainHouseBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMainHouse(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.mainHouseBuilder_ == null) {
                    if (this.mainHouse_ != null) {
                        this.mainHouse_ = HomeFurnitureDataOuterClass.HomeFurnitureData.newBuilder(this.mainHouse_).mergeFrom(value).buildPartial();
                    } else {
                        this.mainHouse_ = value;
                    }
                    onChanged();
                } else {
                    this.mainHouseBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMainHouse() {
                if (this.mainHouseBuilder_ == null) {
                    this.mainHouse_ = null;
                    onChanged();
                } else {
                    this.mainHouse_ = null;
                    this.mainHouseBuilder_ = null;
                }
                return this;
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder getMainHouseBuilder() {
                onChanged();
                return getMainHouseFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getMainHouseOrBuilder() {
                if (this.mainHouseBuilder_ != null) {
                    return this.mainHouseBuilder_.getMessageOrBuilder();
                }
                return this.mainHouse_ == null ? HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance() : this.mainHouse_;
            }

            private SingleFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getMainHouseFieldBuilder() {
                if (this.mainHouseBuilder_ == null) {
                    this.mainHouseBuilder_ = new SingleFieldBuilderV3<>(getMainHouse(), getParentForChildren(), isClean());
                    this.mainHouse_ = null;
                }
                return this.mainHouseBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300HPCHPODNBPHIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unk3300HPCHPODNBPH_ = new ArrayList(this.unk3300HPCHPODNBPH_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getUnk3300HPCHPODNBPHList() {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    return Collections.unmodifiableList(this.unk3300HPCHPODNBPH_);
                }
                return this.unk3300HPCHPODNBPHBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getUnk3300HPCHPODNBPHCount() {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    return this.unk3300HPCHPODNBPH_.size();
                }
                return this.unk3300HPCHPODNBPHBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureData getUnk3300HPCHPODNBPH(int index) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    return this.unk3300HPCHPODNBPH_.get(index);
                }
                return this.unk3300HPCHPODNBPHBuilder_.getMessage(index);
            }

            public Builder setUnk3300HPCHPODNBPH(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.unk3300HPCHPODNBPHBuilder_ != null) {
                    this.unk3300HPCHPODNBPHBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300HPCHPODNBPH(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300HPCHPODNBPH(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.unk3300HPCHPODNBPHBuilder_ != null) {
                    this.unk3300HPCHPODNBPHBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300HPCHPODNBPH(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.unk3300HPCHPODNBPHBuilder_ != null) {
                    this.unk3300HPCHPODNBPHBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300HPCHPODNBPH(HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300HPCHPODNBPH(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk3300HPCHPODNBPH(Iterable<? extends HomeFurnitureDataOuterClass.HomeFurnitureData> values) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300HPCHPODNBPH_);
                    onChanged();
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk3300HPCHPODNBPH() {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    this.unk3300HPCHPODNBPH_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk3300HPCHPODNBPH(int index) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    ensureUnk3300HPCHPODNBPHIsMutable();
                    this.unk3300HPCHPODNBPH_.remove(index);
                    onChanged();
                } else {
                    this.unk3300HPCHPODNBPHBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder getUnk3300HPCHPODNBPHBuilder(int index) {
                return getUnk3300HPCHPODNBPHFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getUnk3300HPCHPODNBPHOrBuilder(int index) {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    return this.unk3300HPCHPODNBPH_.get(index);
                }
                return this.unk3300HPCHPODNBPHBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300HPCHPODNBPHOrBuilderList() {
                if (this.unk3300HPCHPODNBPHBuilder_ != null) {
                    return this.unk3300HPCHPODNBPHBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk3300HPCHPODNBPH_);
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addUnk3300HPCHPODNBPHBuilder() {
                return getUnk3300HPCHPODNBPHFieldBuilder().addBuilder(HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addUnk3300HPCHPODNBPHBuilder(int index) {
                return getUnk3300HPCHPODNBPHFieldBuilder().addBuilder(index, HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public List<HomeFurnitureDataOuterClass.HomeFurnitureData.Builder> getUnk3300HPCHPODNBPHBuilderList() {
                return getUnk3300HPCHPODNBPHFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getUnk3300HPCHPODNBPHFieldBuilder() {
                if (this.unk3300HPCHPODNBPHBuilder_ == null) {
                    this.unk3300HPCHPODNBPHBuilder_ = new RepeatedFieldBuilderV3<>(this.unk3300HPCHPODNBPH_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.unk3300HPCHPODNBPH_ = null;
                }
                return this.unk3300HPCHPODNBPHBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfoOrBuilder
            public int getTmpVersion() {
                return this.tmpVersion_;
            }

            public Builder setTmpVersion(int value) {
                this.tmpVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearTmpVersion() {
                this.tmpVersion_ = 0;
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

        public static HomeSceneArrangementInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeSceneArrangementInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeSceneArrangementInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeSceneArrangementInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeBlockArrangementInfoOuterClass.getDescriptor();
        HomeFurnitureDataOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
