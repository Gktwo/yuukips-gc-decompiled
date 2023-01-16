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
import emu.grasscutter.net.proto.HomeAnimalDataOuterClass;
import emu.grasscutter.net.proto.HomeBlockDotPatternOuterClass;
import emu.grasscutter.net.proto.HomeBlockFieldDataOuterClass;
import emu.grasscutter.net.proto.HomeFurnitureCustomSuiteDataOuterClass;
import emu.grasscutter.net.proto.HomeFurnitureDataOuterClass;
import emu.grasscutter.net.proto.HomeFurnitureGroupDataOuterClass;
import emu.grasscutter.net.proto.HomeFurnitureSuiteDataOuterClass;
import emu.grasscutter.net.proto.HomeNpcDataOuterClass;
import emu.grasscutter.net.proto.WeekendDjinnInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockArrangementInfoOuterClass.class */
public final class HomeBlockArrangementInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eHomeBlockArrangementInfo.proto\u001a\u0014HomeAnimalData.proto\u001a\u0019HomeBlockDotPattern.proto\u001a\u0018HomeBlockFieldData.proto\u001a\"HomeFurnitureCustomSuiteData.proto\u001a\u0017HomeFurnitureData.proto\u001a\u001cHomeFurnitureGroupData.proto\u001a\u001cHomeFurnitureSuiteData.proto\u001a\u0011HomeNpcData.proto\u001a\u0016WeekendDjinnInfo.proto\"Ô\u0004\n\u0018HomeBlockArrangementInfo\u00120\n\u0014deploy_furniure_list\u0018\n \u0003(\u000b2\u0012.HomeFurnitureData\u0012+\n\u0012deploy_animal_list\u0018\u0007 \u0003(\u000b2\u000f.HomeAnimalData\u00125\n\u0014furniture_suite_list\u0018\u0003 \u0003(\u000b2\u0017.HomeFurnitureSuiteData\u00122\n\u0017weekend_djinn_info_list\u0018\u0005 \u0003(\u000b2\u0011.WeekendDjinnInfo\u0012\u0010\n\bblock_id\u0018\u000e \u0001(\r\u0012.\n\u0010dot_pattern_list\u0018\u0006 \u0003(\u000b2\u0014.HomeBlockDotPattern\u0012\u0013\n\u000bis_unlocked\u0018\u000f \u0001(\b\u0012%\n\u000fdeploy_npc_list\u0018\u0001 \u0003(\u000b2\f.HomeNpcData\u00125\n\u0014furniture_group_list\u0018\b \u0003(\u000b2\u0017.HomeFurnitureGroupData\u0012'\n\nfield_list\u0018\r \u0003(\u000b2\u0013.HomeBlockFieldData\u0012\u0015\n\rcomfort_value\u0018\t \u0001(\r\u00125\n\u0019persistent_furniture_list\u0018\f \u0003(\u000b2\u0012.HomeFurnitureData\u0012B\n\u001bfurniture_custom_suite_list\u0018\u0004 \u0003(\u000b2\u001d.HomeFurnitureCustomSuiteDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HomeAnimalDataOuterClass.getDescriptor(), HomeBlockDotPatternOuterClass.getDescriptor(), HomeBlockFieldDataOuterClass.getDescriptor(), HomeFurnitureCustomSuiteDataOuterClass.getDescriptor(), HomeFurnitureDataOuterClass.getDescriptor(), HomeFurnitureGroupDataOuterClass.getDescriptor(), HomeFurnitureSuiteDataOuterClass.getDescriptor(), HomeNpcDataOuterClass.getDescriptor(), WeekendDjinnInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeBlockArrangementInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeBlockArrangementInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeBlockArrangementInfo_descriptor, new String[]{"DeployFurniureList", "DeployAnimalList", "FurnitureSuiteList", "WeekendDjinnInfoList", "BlockId", "DotPatternList", "IsUnlocked", "DeployNpcList", "FurnitureGroupList", "FieldList", "ComfortValue", "PersistentFurnitureList", "FurnitureCustomSuiteList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockArrangementInfoOuterClass$HomeBlockArrangementInfoOrBuilder.class */
    public interface HomeBlockArrangementInfoOrBuilder extends MessageOrBuilder {
        List<HomeFurnitureDataOuterClass.HomeFurnitureData> getDeployFurniureListList();

        HomeFurnitureDataOuterClass.HomeFurnitureData getDeployFurniureList(int i);

        int getDeployFurniureListCount();

        List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getDeployFurniureListOrBuilderList();

        HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getDeployFurniureListOrBuilder(int i);

        List<HomeAnimalDataOuterClass.HomeAnimalData> getDeployAnimalListList();

        HomeAnimalDataOuterClass.HomeAnimalData getDeployAnimalList(int i);

        int getDeployAnimalListCount();

        List<? extends HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder> getDeployAnimalListOrBuilderList();

        HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder getDeployAnimalListOrBuilder(int i);

        List<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData> getFurnitureSuiteListList();

        HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData getFurnitureSuiteList(int i);

        int getFurnitureSuiteListCount();

        List<? extends HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder> getFurnitureSuiteListOrBuilderList();

        HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder getFurnitureSuiteListOrBuilder(int i);

        List<WeekendDjinnInfoOuterClass.WeekendDjinnInfo> getWeekendDjinnInfoListList();

        WeekendDjinnInfoOuterClass.WeekendDjinnInfo getWeekendDjinnInfoList(int i);

        int getWeekendDjinnInfoListCount();

        List<? extends WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder> getWeekendDjinnInfoListOrBuilderList();

        WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder getWeekendDjinnInfoListOrBuilder(int i);

        int getBlockId();

        List<HomeBlockDotPatternOuterClass.HomeBlockDotPattern> getDotPatternListList();

        HomeBlockDotPatternOuterClass.HomeBlockDotPattern getDotPatternList(int i);

        int getDotPatternListCount();

        List<? extends HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder> getDotPatternListOrBuilderList();

        HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder getDotPatternListOrBuilder(int i);

        boolean getIsUnlocked();

        List<HomeNpcDataOuterClass.HomeNpcData> getDeployNpcListList();

        HomeNpcDataOuterClass.HomeNpcData getDeployNpcList(int i);

        int getDeployNpcListCount();

        List<? extends HomeNpcDataOuterClass.HomeNpcDataOrBuilder> getDeployNpcListOrBuilderList();

        HomeNpcDataOuterClass.HomeNpcDataOrBuilder getDeployNpcListOrBuilder(int i);

        List<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData> getFurnitureGroupListList();

        HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData getFurnitureGroupList(int i);

        int getFurnitureGroupListCount();

        List<? extends HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder> getFurnitureGroupListOrBuilderList();

        HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder getFurnitureGroupListOrBuilder(int i);

        List<HomeBlockFieldDataOuterClass.HomeBlockFieldData> getFieldListList();

        HomeBlockFieldDataOuterClass.HomeBlockFieldData getFieldList(int i);

        int getFieldListCount();

        List<? extends HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder> getFieldListOrBuilderList();

        HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder getFieldListOrBuilder(int i);

        int getComfortValue();

        List<HomeFurnitureDataOuterClass.HomeFurnitureData> getPersistentFurnitureListList();

        HomeFurnitureDataOuterClass.HomeFurnitureData getPersistentFurnitureList(int i);

        int getPersistentFurnitureListCount();

        List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getPersistentFurnitureListOrBuilderList();

        HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getPersistentFurnitureListOrBuilder(int i);

        List<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData> getFurnitureCustomSuiteListList();

        HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData getFurnitureCustomSuiteList(int i);

        int getFurnitureCustomSuiteListCount();

        List<? extends HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder> getFurnitureCustomSuiteListOrBuilderList();

        HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder getFurnitureCustomSuiteListOrBuilder(int i);
    }

    private HomeBlockArrangementInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockArrangementInfoOuterClass$HomeBlockArrangementInfo.class */
    public static final class HomeBlockArrangementInfo extends GeneratedMessageV3 implements HomeBlockArrangementInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DEPLOY_FURNIURE_LIST_FIELD_NUMBER = 10;
        private List<HomeFurnitureDataOuterClass.HomeFurnitureData> deployFurniureList_;
        public static final int DEPLOY_ANIMAL_LIST_FIELD_NUMBER = 7;
        private List<HomeAnimalDataOuterClass.HomeAnimalData> deployAnimalList_;
        public static final int FURNITURE_SUITE_LIST_FIELD_NUMBER = 3;
        private List<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData> furnitureSuiteList_;
        public static final int WEEKEND_DJINN_INFO_LIST_FIELD_NUMBER = 5;
        private List<WeekendDjinnInfoOuterClass.WeekendDjinnInfo> weekendDjinnInfoList_;
        public static final int BLOCK_ID_FIELD_NUMBER = 14;
        private int blockId_;
        public static final int DOT_PATTERN_LIST_FIELD_NUMBER = 6;
        private List<HomeBlockDotPatternOuterClass.HomeBlockDotPattern> dotPatternList_;
        public static final int IS_UNLOCKED_FIELD_NUMBER = 15;
        private boolean isUnlocked_;
        public static final int DEPLOY_NPC_LIST_FIELD_NUMBER = 1;
        private List<HomeNpcDataOuterClass.HomeNpcData> deployNpcList_;
        public static final int FURNITURE_GROUP_LIST_FIELD_NUMBER = 8;
        private List<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData> furnitureGroupList_;
        public static final int FIELD_LIST_FIELD_NUMBER = 13;
        private List<HomeBlockFieldDataOuterClass.HomeBlockFieldData> fieldList_;
        public static final int COMFORT_VALUE_FIELD_NUMBER = 9;
        private int comfortValue_;
        public static final int PERSISTENT_FURNITURE_LIST_FIELD_NUMBER = 12;
        private List<HomeFurnitureDataOuterClass.HomeFurnitureData> persistentFurnitureList_;
        public static final int FURNITURE_CUSTOM_SUITE_LIST_FIELD_NUMBER = 4;
        private List<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData> furnitureCustomSuiteList_;
        private byte memoizedIsInitialized;
        private static final HomeBlockArrangementInfo DEFAULT_INSTANCE = new HomeBlockArrangementInfo();
        private static final Parser<HomeBlockArrangementInfo> PARSER = new AbstractParser<HomeBlockArrangementInfo>() { // from class: emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfo.1
            @Override // com.google.protobuf.Parser
            public HomeBlockArrangementInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeBlockArrangementInfo(input, extensionRegistry);
            }
        };

        private HomeBlockArrangementInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeBlockArrangementInfo() {
            this.memoizedIsInitialized = -1;
            this.deployFurniureList_ = Collections.emptyList();
            this.deployAnimalList_ = Collections.emptyList();
            this.furnitureSuiteList_ = Collections.emptyList();
            this.weekendDjinnInfoList_ = Collections.emptyList();
            this.dotPatternList_ = Collections.emptyList();
            this.deployNpcList_ = Collections.emptyList();
            this.furnitureGroupList_ = Collections.emptyList();
            this.fieldList_ = Collections.emptyList();
            this.persistentFurnitureList_ = Collections.emptyList();
            this.furnitureCustomSuiteList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeBlockArrangementInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:152:0x02ad */
        private HomeBlockArrangementInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.deployNpcList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.deployNpcList_.add((HomeNpcDataOuterClass.HomeNpcData) input.readMessage(HomeNpcDataOuterClass.HomeNpcData.parser(), extensionRegistry));
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.furnitureSuiteList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.furnitureSuiteList_.add((HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData) input.readMessage(HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.parser(), extensionRegistry));
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 512) == 0) {
                                    this.furnitureCustomSuiteList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 512) == 1 ? 1 : 0;
                                }
                                this.furnitureCustomSuiteList_.add((HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData) input.readMessage(HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.parser(), extensionRegistry));
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.weekendDjinnInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.weekendDjinnInfoList_.add((WeekendDjinnInfoOuterClass.WeekendDjinnInfo) input.readMessage(WeekendDjinnInfoOuterClass.WeekendDjinnInfo.parser(), extensionRegistry));
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.dotPatternList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.dotPatternList_.add((HomeBlockDotPatternOuterClass.HomeBlockDotPattern) input.readMessage(HomeBlockDotPatternOuterClass.HomeBlockDotPattern.parser(), extensionRegistry));
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.deployAnimalList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.deployAnimalList_.add((HomeAnimalDataOuterClass.HomeAnimalData) input.readMessage(HomeAnimalDataOuterClass.HomeAnimalData.parser(), extensionRegistry));
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.furnitureGroupList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.furnitureGroupList_.add((HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData) input.readMessage(HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.parser(), extensionRegistry));
                                break;
                            case 72:
                                this.comfortValue_ = input.readUInt32();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.deployFurniureList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.deployFurniureList_.add((HomeFurnitureDataOuterClass.HomeFurnitureData) input.readMessage(HomeFurnitureDataOuterClass.HomeFurnitureData.parser(), extensionRegistry));
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 256) == 0) {
                                    this.persistentFurnitureList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                }
                                this.persistentFurnitureList_.add((HomeFurnitureDataOuterClass.HomeFurnitureData) input.readMessage(HomeFurnitureDataOuterClass.HomeFurnitureData.parser(), extensionRegistry));
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 128) == 0) {
                                    this.fieldList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                }
                                this.fieldList_.add((HomeBlockFieldDataOuterClass.HomeBlockFieldData) input.readMessage(HomeBlockFieldDataOuterClass.HomeBlockFieldData.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.blockId_ = input.readUInt32();
                                break;
                            case 120:
                                this.isUnlocked_ = input.readBool();
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
                if ((mutable_bitField0_ & 32) != 0) {
                    this.deployNpcList_ = Collections.unmodifiableList(this.deployNpcList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.furnitureSuiteList_ = Collections.unmodifiableList(this.furnitureSuiteList_);
                }
                if ((mutable_bitField0_ & 512) != 0) {
                    this.furnitureCustomSuiteList_ = Collections.unmodifiableList(this.furnitureCustomSuiteList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.weekendDjinnInfoList_ = Collections.unmodifiableList(this.weekendDjinnInfoList_);
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.dotPatternList_ = Collections.unmodifiableList(this.dotPatternList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.deployAnimalList_ = Collections.unmodifiableList(this.deployAnimalList_);
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.furnitureGroupList_ = Collections.unmodifiableList(this.furnitureGroupList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.deployFurniureList_ = Collections.unmodifiableList(this.deployFurniureList_);
                }
                if ((mutable_bitField0_ & 256) != 0) {
                    this.persistentFurnitureList_ = Collections.unmodifiableList(this.persistentFurnitureList_);
                }
                if ((mutable_bitField0_ & 128) != 0) {
                    this.fieldList_ = Collections.unmodifiableList(this.fieldList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeBlockArrangementInfoOuterClass.internal_static_HomeBlockArrangementInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeBlockArrangementInfoOuterClass.internal_static_HomeBlockArrangementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBlockArrangementInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getDeployFurniureListList() {
            return this.deployFurniureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getDeployFurniureListOrBuilderList() {
            return this.deployFurniureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getDeployFurniureListCount() {
            return this.deployFurniureList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureData getDeployFurniureList(int index) {
            return this.deployFurniureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getDeployFurniureListOrBuilder(int index) {
            return this.deployFurniureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeAnimalDataOuterClass.HomeAnimalData> getDeployAnimalListList() {
            return this.deployAnimalList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder> getDeployAnimalListOrBuilderList() {
            return this.deployAnimalList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getDeployAnimalListCount() {
            return this.deployAnimalList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeAnimalDataOuterClass.HomeAnimalData getDeployAnimalList(int index) {
            return this.deployAnimalList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder getDeployAnimalListOrBuilder(int index) {
            return this.deployAnimalList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData> getFurnitureSuiteListList() {
            return this.furnitureSuiteList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder> getFurnitureSuiteListOrBuilderList() {
            return this.furnitureSuiteList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getFurnitureSuiteListCount() {
            return this.furnitureSuiteList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData getFurnitureSuiteList(int index) {
            return this.furnitureSuiteList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder getFurnitureSuiteListOrBuilder(int index) {
            return this.furnitureSuiteList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<WeekendDjinnInfoOuterClass.WeekendDjinnInfo> getWeekendDjinnInfoListList() {
            return this.weekendDjinnInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder> getWeekendDjinnInfoListOrBuilderList() {
            return this.weekendDjinnInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getWeekendDjinnInfoListCount() {
            return this.weekendDjinnInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public WeekendDjinnInfoOuterClass.WeekendDjinnInfo getWeekendDjinnInfoList(int index) {
            return this.weekendDjinnInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder getWeekendDjinnInfoListOrBuilder(int index) {
            return this.weekendDjinnInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getBlockId() {
            return this.blockId_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeBlockDotPatternOuterClass.HomeBlockDotPattern> getDotPatternListList() {
            return this.dotPatternList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder> getDotPatternListOrBuilderList() {
            return this.dotPatternList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getDotPatternListCount() {
            return this.dotPatternList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeBlockDotPatternOuterClass.HomeBlockDotPattern getDotPatternList(int index) {
            return this.dotPatternList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder getDotPatternListOrBuilder(int index) {
            return this.dotPatternList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public boolean getIsUnlocked() {
            return this.isUnlocked_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeNpcDataOuterClass.HomeNpcData> getDeployNpcListList() {
            return this.deployNpcList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeNpcDataOuterClass.HomeNpcDataOrBuilder> getDeployNpcListOrBuilderList() {
            return this.deployNpcList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getDeployNpcListCount() {
            return this.deployNpcList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeNpcDataOuterClass.HomeNpcData getDeployNpcList(int index) {
            return this.deployNpcList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeNpcDataOuterClass.HomeNpcDataOrBuilder getDeployNpcListOrBuilder(int index) {
            return this.deployNpcList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData> getFurnitureGroupListList() {
            return this.furnitureGroupList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder> getFurnitureGroupListOrBuilderList() {
            return this.furnitureGroupList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getFurnitureGroupListCount() {
            return this.furnitureGroupList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData getFurnitureGroupList(int index) {
            return this.furnitureGroupList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder getFurnitureGroupListOrBuilder(int index) {
            return this.furnitureGroupList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeBlockFieldDataOuterClass.HomeBlockFieldData> getFieldListList() {
            return this.fieldList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder> getFieldListOrBuilderList() {
            return this.fieldList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getFieldListCount() {
            return this.fieldList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeBlockFieldDataOuterClass.HomeBlockFieldData getFieldList(int index) {
            return this.fieldList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder getFieldListOrBuilder(int index) {
            return this.fieldList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getComfortValue() {
            return this.comfortValue_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getPersistentFurnitureListList() {
            return this.persistentFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getPersistentFurnitureListOrBuilderList() {
            return this.persistentFurnitureList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getPersistentFurnitureListCount() {
            return this.persistentFurnitureList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureData getPersistentFurnitureList(int index) {
            return this.persistentFurnitureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getPersistentFurnitureListOrBuilder(int index) {
            return this.persistentFurnitureList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData> getFurnitureCustomSuiteListList() {
            return this.furnitureCustomSuiteList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public List<? extends HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder> getFurnitureCustomSuiteListOrBuilderList() {
            return this.furnitureCustomSuiteList_;
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public int getFurnitureCustomSuiteListCount() {
            return this.furnitureCustomSuiteList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData getFurnitureCustomSuiteList(int index) {
            return this.furnitureCustomSuiteList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
        public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder getFurnitureCustomSuiteListOrBuilder(int index) {
            return this.furnitureCustomSuiteList_.get(index);
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
            for (int i = 0; i < this.deployNpcList_.size(); i++) {
                output.writeMessage(1, this.deployNpcList_.get(i));
            }
            for (int i2 = 0; i2 < this.furnitureSuiteList_.size(); i2++) {
                output.writeMessage(3, this.furnitureSuiteList_.get(i2));
            }
            for (int i3 = 0; i3 < this.furnitureCustomSuiteList_.size(); i3++) {
                output.writeMessage(4, this.furnitureCustomSuiteList_.get(i3));
            }
            for (int i4 = 0; i4 < this.weekendDjinnInfoList_.size(); i4++) {
                output.writeMessage(5, this.weekendDjinnInfoList_.get(i4));
            }
            for (int i5 = 0; i5 < this.dotPatternList_.size(); i5++) {
                output.writeMessage(6, this.dotPatternList_.get(i5));
            }
            for (int i6 = 0; i6 < this.deployAnimalList_.size(); i6++) {
                output.writeMessage(7, this.deployAnimalList_.get(i6));
            }
            for (int i7 = 0; i7 < this.furnitureGroupList_.size(); i7++) {
                output.writeMessage(8, this.furnitureGroupList_.get(i7));
            }
            if (this.comfortValue_ != 0) {
                output.writeUInt32(9, this.comfortValue_);
            }
            for (int i8 = 0; i8 < this.deployFurniureList_.size(); i8++) {
                output.writeMessage(10, this.deployFurniureList_.get(i8));
            }
            for (int i9 = 0; i9 < this.persistentFurnitureList_.size(); i9++) {
                output.writeMessage(12, this.persistentFurnitureList_.get(i9));
            }
            for (int i10 = 0; i10 < this.fieldList_.size(); i10++) {
                output.writeMessage(13, this.fieldList_.get(i10));
            }
            if (this.blockId_ != 0) {
                output.writeUInt32(14, this.blockId_);
            }
            if (this.isUnlocked_) {
                output.writeBool(15, this.isUnlocked_);
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
            for (int i = 0; i < this.deployNpcList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.deployNpcList_.get(i));
            }
            for (int i2 = 0; i2 < this.furnitureSuiteList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.furnitureSuiteList_.get(i2));
            }
            for (int i3 = 0; i3 < this.furnitureCustomSuiteList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.furnitureCustomSuiteList_.get(i3));
            }
            for (int i4 = 0; i4 < this.weekendDjinnInfoList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.weekendDjinnInfoList_.get(i4));
            }
            for (int i5 = 0; i5 < this.dotPatternList_.size(); i5++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.dotPatternList_.get(i5));
            }
            for (int i6 = 0; i6 < this.deployAnimalList_.size(); i6++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.deployAnimalList_.get(i6));
            }
            for (int i7 = 0; i7 < this.furnitureGroupList_.size(); i7++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.furnitureGroupList_.get(i7));
            }
            if (this.comfortValue_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.comfortValue_);
            }
            for (int i8 = 0; i8 < this.deployFurniureList_.size(); i8++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.deployFurniureList_.get(i8));
            }
            for (int i9 = 0; i9 < this.persistentFurnitureList_.size(); i9++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.persistentFurnitureList_.get(i9));
            }
            for (int i10 = 0; i10 < this.fieldList_.size(); i10++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.fieldList_.get(i10));
            }
            if (this.blockId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.blockId_);
            }
            if (this.isUnlocked_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isUnlocked_);
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
            if (!(obj instanceof HomeBlockArrangementInfo)) {
                return equals(obj);
            }
            HomeBlockArrangementInfo other = (HomeBlockArrangementInfo) obj;
            return getDeployFurniureListList().equals(other.getDeployFurniureListList()) && getDeployAnimalListList().equals(other.getDeployAnimalListList()) && getFurnitureSuiteListList().equals(other.getFurnitureSuiteListList()) && getWeekendDjinnInfoListList().equals(other.getWeekendDjinnInfoListList()) && getBlockId() == other.getBlockId() && getDotPatternListList().equals(other.getDotPatternListList()) && getIsUnlocked() == other.getIsUnlocked() && getDeployNpcListList().equals(other.getDeployNpcListList()) && getFurnitureGroupListList().equals(other.getFurnitureGroupListList()) && getFieldListList().equals(other.getFieldListList()) && getComfortValue() == other.getComfortValue() && getPersistentFurnitureListList().equals(other.getPersistentFurnitureListList()) && getFurnitureCustomSuiteListList().equals(other.getFurnitureCustomSuiteListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDeployFurniureListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getDeployFurniureListList().hashCode();
            }
            if (getDeployAnimalListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getDeployAnimalListList().hashCode();
            }
            if (getFurnitureSuiteListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getFurnitureSuiteListList().hashCode();
            }
            if (getWeekendDjinnInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getWeekendDjinnInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 14)) + getBlockId();
            if (getDotPatternListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getDotPatternListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 15)) + Internal.hashBoolean(getIsUnlocked());
            if (getDeployNpcListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 1)) + getDeployNpcListList().hashCode();
            }
            if (getFurnitureGroupListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 8)) + getFurnitureGroupListList().hashCode();
            }
            if (getFieldListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 13)) + getFieldListList().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 9)) + getComfortValue();
            if (getPersistentFurnitureListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 12)) + getPersistentFurnitureListList().hashCode();
            }
            if (getFurnitureCustomSuiteListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 4)) + getFurnitureCustomSuiteListList().hashCode();
            }
            int hash5 = (29 * hash4) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static HomeBlockArrangementInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockArrangementInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockArrangementInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockArrangementInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockArrangementInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeBlockArrangementInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeBlockArrangementInfo parseFrom(InputStream input) throws IOException {
            return (HomeBlockArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBlockArrangementInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBlockArrangementInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeBlockArrangementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeBlockArrangementInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockArrangementInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeBlockArrangementInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeBlockArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeBlockArrangementInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeBlockArrangementInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeBlockArrangementInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeBlockArrangementInfoOuterClass$HomeBlockArrangementInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeBlockArrangementInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> deployFurniureListBuilder_;
            private RepeatedFieldBuilderV3<HomeAnimalDataOuterClass.HomeAnimalData, HomeAnimalDataOuterClass.HomeAnimalData.Builder, HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder> deployAnimalListBuilder_;
            private RepeatedFieldBuilderV3<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder> furnitureSuiteListBuilder_;
            private RepeatedFieldBuilderV3<WeekendDjinnInfoOuterClass.WeekendDjinnInfo, WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder, WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder> weekendDjinnInfoListBuilder_;
            private int blockId_;
            private RepeatedFieldBuilderV3<HomeBlockDotPatternOuterClass.HomeBlockDotPattern, HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder, HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder> dotPatternListBuilder_;
            private boolean isUnlocked_;
            private RepeatedFieldBuilderV3<HomeNpcDataOuterClass.HomeNpcData, HomeNpcDataOuterClass.HomeNpcData.Builder, HomeNpcDataOuterClass.HomeNpcDataOrBuilder> deployNpcListBuilder_;
            private RepeatedFieldBuilderV3<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder> furnitureGroupListBuilder_;
            private RepeatedFieldBuilderV3<HomeBlockFieldDataOuterClass.HomeBlockFieldData, HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder, HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder> fieldListBuilder_;
            private int comfortValue_;
            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> persistentFurnitureListBuilder_;
            private RepeatedFieldBuilderV3<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder> furnitureCustomSuiteListBuilder_;
            private List<HomeFurnitureDataOuterClass.HomeFurnitureData> deployFurniureList_ = Collections.emptyList();
            private List<HomeAnimalDataOuterClass.HomeAnimalData> deployAnimalList_ = Collections.emptyList();
            private List<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData> furnitureSuiteList_ = Collections.emptyList();
            private List<WeekendDjinnInfoOuterClass.WeekendDjinnInfo> weekendDjinnInfoList_ = Collections.emptyList();
            private List<HomeBlockDotPatternOuterClass.HomeBlockDotPattern> dotPatternList_ = Collections.emptyList();
            private List<HomeNpcDataOuterClass.HomeNpcData> deployNpcList_ = Collections.emptyList();
            private List<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData> furnitureGroupList_ = Collections.emptyList();
            private List<HomeBlockFieldDataOuterClass.HomeBlockFieldData> fieldList_ = Collections.emptyList();
            private List<HomeFurnitureDataOuterClass.HomeFurnitureData> persistentFurnitureList_ = Collections.emptyList();
            private List<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData> furnitureCustomSuiteList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeBlockArrangementInfoOuterClass.internal_static_HomeBlockArrangementInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeBlockArrangementInfoOuterClass.internal_static_HomeBlockArrangementInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeBlockArrangementInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeBlockArrangementInfo.alwaysUseFieldBuilders) {
                    getDeployFurniureListFieldBuilder();
                    getDeployAnimalListFieldBuilder();
                    getFurnitureSuiteListFieldBuilder();
                    getWeekendDjinnInfoListFieldBuilder();
                    getDotPatternListFieldBuilder();
                    getDeployNpcListFieldBuilder();
                    getFurnitureGroupListFieldBuilder();
                    getFieldListFieldBuilder();
                    getPersistentFurnitureListFieldBuilder();
                    getFurnitureCustomSuiteListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.deployFurniureListBuilder_ == null) {
                    this.deployFurniureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.deployFurniureListBuilder_.clear();
                }
                if (this.deployAnimalListBuilder_ == null) {
                    this.deployAnimalList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.deployAnimalListBuilder_.clear();
                }
                if (this.furnitureSuiteListBuilder_ == null) {
                    this.furnitureSuiteList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.furnitureSuiteListBuilder_.clear();
                }
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    this.weekendDjinnInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.weekendDjinnInfoListBuilder_.clear();
                }
                this.blockId_ = 0;
                if (this.dotPatternListBuilder_ == null) {
                    this.dotPatternList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.dotPatternListBuilder_.clear();
                }
                this.isUnlocked_ = false;
                if (this.deployNpcListBuilder_ == null) {
                    this.deployNpcList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.deployNpcListBuilder_.clear();
                }
                if (this.furnitureGroupListBuilder_ == null) {
                    this.furnitureGroupList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.furnitureGroupListBuilder_.clear();
                }
                if (this.fieldListBuilder_ == null) {
                    this.fieldList_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                } else {
                    this.fieldListBuilder_.clear();
                }
                this.comfortValue_ = 0;
                if (this.persistentFurnitureListBuilder_ == null) {
                    this.persistentFurnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                } else {
                    this.persistentFurnitureListBuilder_.clear();
                }
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    this.furnitureCustomSuiteList_ = Collections.emptyList();
                    this.bitField0_ &= -513;
                } else {
                    this.furnitureCustomSuiteListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeBlockArrangementInfoOuterClass.internal_static_HomeBlockArrangementInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeBlockArrangementInfo getDefaultInstanceForType() {
                return HomeBlockArrangementInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBlockArrangementInfo build() {
                HomeBlockArrangementInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeBlockArrangementInfo buildPartial() {
                HomeBlockArrangementInfo result = new HomeBlockArrangementInfo(this);
                int i = this.bitField0_;
                if (this.deployFurniureListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.deployFurniureList_ = Collections.unmodifiableList(this.deployFurniureList_);
                        this.bitField0_ &= -2;
                    }
                    result.deployFurniureList_ = this.deployFurniureList_;
                } else {
                    result.deployFurniureList_ = this.deployFurniureListBuilder_.build();
                }
                if (this.deployAnimalListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.deployAnimalList_ = Collections.unmodifiableList(this.deployAnimalList_);
                        this.bitField0_ &= -3;
                    }
                    result.deployAnimalList_ = this.deployAnimalList_;
                } else {
                    result.deployAnimalList_ = this.deployAnimalListBuilder_.build();
                }
                if (this.furnitureSuiteListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.furnitureSuiteList_ = Collections.unmodifiableList(this.furnitureSuiteList_);
                        this.bitField0_ &= -5;
                    }
                    result.furnitureSuiteList_ = this.furnitureSuiteList_;
                } else {
                    result.furnitureSuiteList_ = this.furnitureSuiteListBuilder_.build();
                }
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.weekendDjinnInfoList_ = Collections.unmodifiableList(this.weekendDjinnInfoList_);
                        this.bitField0_ &= -9;
                    }
                    result.weekendDjinnInfoList_ = this.weekendDjinnInfoList_;
                } else {
                    result.weekendDjinnInfoList_ = this.weekendDjinnInfoListBuilder_.build();
                }
                result.blockId_ = this.blockId_;
                if (this.dotPatternListBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.dotPatternList_ = Collections.unmodifiableList(this.dotPatternList_);
                        this.bitField0_ &= -17;
                    }
                    result.dotPatternList_ = this.dotPatternList_;
                } else {
                    result.dotPatternList_ = this.dotPatternListBuilder_.build();
                }
                result.isUnlocked_ = this.isUnlocked_;
                if (this.deployNpcListBuilder_ == null) {
                    if ((this.bitField0_ & 32) != 0) {
                        this.deployNpcList_ = Collections.unmodifiableList(this.deployNpcList_);
                        this.bitField0_ &= -33;
                    }
                    result.deployNpcList_ = this.deployNpcList_;
                } else {
                    result.deployNpcList_ = this.deployNpcListBuilder_.build();
                }
                if (this.furnitureGroupListBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 0) {
                        this.furnitureGroupList_ = Collections.unmodifiableList(this.furnitureGroupList_);
                        this.bitField0_ &= -65;
                    }
                    result.furnitureGroupList_ = this.furnitureGroupList_;
                } else {
                    result.furnitureGroupList_ = this.furnitureGroupListBuilder_.build();
                }
                if (this.fieldListBuilder_ == null) {
                    if ((this.bitField0_ & 128) != 0) {
                        this.fieldList_ = Collections.unmodifiableList(this.fieldList_);
                        this.bitField0_ &= -129;
                    }
                    result.fieldList_ = this.fieldList_;
                } else {
                    result.fieldList_ = this.fieldListBuilder_.build();
                }
                result.comfortValue_ = this.comfortValue_;
                if (this.persistentFurnitureListBuilder_ == null) {
                    if ((this.bitField0_ & 256) != 0) {
                        this.persistentFurnitureList_ = Collections.unmodifiableList(this.persistentFurnitureList_);
                        this.bitField0_ &= -257;
                    }
                    result.persistentFurnitureList_ = this.persistentFurnitureList_;
                } else {
                    result.persistentFurnitureList_ = this.persistentFurnitureListBuilder_.build();
                }
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    if ((this.bitField0_ & 512) != 0) {
                        this.furnitureCustomSuiteList_ = Collections.unmodifiableList(this.furnitureCustomSuiteList_);
                        this.bitField0_ &= -513;
                    }
                    result.furnitureCustomSuiteList_ = this.furnitureCustomSuiteList_;
                } else {
                    result.furnitureCustomSuiteList_ = this.furnitureCustomSuiteListBuilder_.build();
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
                if (other instanceof HomeBlockArrangementInfo) {
                    return mergeFrom((HomeBlockArrangementInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeBlockArrangementInfo other) {
                if (other == HomeBlockArrangementInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.deployFurniureListBuilder_ == null) {
                    if (!other.deployFurniureList_.isEmpty()) {
                        if (this.deployFurniureList_.isEmpty()) {
                            this.deployFurniureList_ = other.deployFurniureList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDeployFurniureListIsMutable();
                            this.deployFurniureList_.addAll(other.deployFurniureList_);
                        }
                        onChanged();
                    }
                } else if (!other.deployFurniureList_.isEmpty()) {
                    if (this.deployFurniureListBuilder_.isEmpty()) {
                        this.deployFurniureListBuilder_.dispose();
                        this.deployFurniureListBuilder_ = null;
                        this.deployFurniureList_ = other.deployFurniureList_;
                        this.bitField0_ &= -2;
                        this.deployFurniureListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getDeployFurniureListFieldBuilder() : null;
                    } else {
                        this.deployFurniureListBuilder_.addAllMessages(other.deployFurniureList_);
                    }
                }
                if (this.deployAnimalListBuilder_ == null) {
                    if (!other.deployAnimalList_.isEmpty()) {
                        if (this.deployAnimalList_.isEmpty()) {
                            this.deployAnimalList_ = other.deployAnimalList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDeployAnimalListIsMutable();
                            this.deployAnimalList_.addAll(other.deployAnimalList_);
                        }
                        onChanged();
                    }
                } else if (!other.deployAnimalList_.isEmpty()) {
                    if (this.deployAnimalListBuilder_.isEmpty()) {
                        this.deployAnimalListBuilder_.dispose();
                        this.deployAnimalListBuilder_ = null;
                        this.deployAnimalList_ = other.deployAnimalList_;
                        this.bitField0_ &= -3;
                        this.deployAnimalListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getDeployAnimalListFieldBuilder() : null;
                    } else {
                        this.deployAnimalListBuilder_.addAllMessages(other.deployAnimalList_);
                    }
                }
                if (this.furnitureSuiteListBuilder_ == null) {
                    if (!other.furnitureSuiteList_.isEmpty()) {
                        if (this.furnitureSuiteList_.isEmpty()) {
                            this.furnitureSuiteList_ = other.furnitureSuiteList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureFurnitureSuiteListIsMutable();
                            this.furnitureSuiteList_.addAll(other.furnitureSuiteList_);
                        }
                        onChanged();
                    }
                } else if (!other.furnitureSuiteList_.isEmpty()) {
                    if (this.furnitureSuiteListBuilder_.isEmpty()) {
                        this.furnitureSuiteListBuilder_.dispose();
                        this.furnitureSuiteListBuilder_ = null;
                        this.furnitureSuiteList_ = other.furnitureSuiteList_;
                        this.bitField0_ &= -5;
                        this.furnitureSuiteListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getFurnitureSuiteListFieldBuilder() : null;
                    } else {
                        this.furnitureSuiteListBuilder_.addAllMessages(other.furnitureSuiteList_);
                    }
                }
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    if (!other.weekendDjinnInfoList_.isEmpty()) {
                        if (this.weekendDjinnInfoList_.isEmpty()) {
                            this.weekendDjinnInfoList_ = other.weekendDjinnInfoList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureWeekendDjinnInfoListIsMutable();
                            this.weekendDjinnInfoList_.addAll(other.weekendDjinnInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.weekendDjinnInfoList_.isEmpty()) {
                    if (this.weekendDjinnInfoListBuilder_.isEmpty()) {
                        this.weekendDjinnInfoListBuilder_.dispose();
                        this.weekendDjinnInfoListBuilder_ = null;
                        this.weekendDjinnInfoList_ = other.weekendDjinnInfoList_;
                        this.bitField0_ &= -9;
                        this.weekendDjinnInfoListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getWeekendDjinnInfoListFieldBuilder() : null;
                    } else {
                        this.weekendDjinnInfoListBuilder_.addAllMessages(other.weekendDjinnInfoList_);
                    }
                }
                if (other.getBlockId() != 0) {
                    setBlockId(other.getBlockId());
                }
                if (this.dotPatternListBuilder_ == null) {
                    if (!other.dotPatternList_.isEmpty()) {
                        if (this.dotPatternList_.isEmpty()) {
                            this.dotPatternList_ = other.dotPatternList_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureDotPatternListIsMutable();
                            this.dotPatternList_.addAll(other.dotPatternList_);
                        }
                        onChanged();
                    }
                } else if (!other.dotPatternList_.isEmpty()) {
                    if (this.dotPatternListBuilder_.isEmpty()) {
                        this.dotPatternListBuilder_.dispose();
                        this.dotPatternListBuilder_ = null;
                        this.dotPatternList_ = other.dotPatternList_;
                        this.bitField0_ &= -17;
                        this.dotPatternListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getDotPatternListFieldBuilder() : null;
                    } else {
                        this.dotPatternListBuilder_.addAllMessages(other.dotPatternList_);
                    }
                }
                if (other.getIsUnlocked()) {
                    setIsUnlocked(other.getIsUnlocked());
                }
                if (this.deployNpcListBuilder_ == null) {
                    if (!other.deployNpcList_.isEmpty()) {
                        if (this.deployNpcList_.isEmpty()) {
                            this.deployNpcList_ = other.deployNpcList_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureDeployNpcListIsMutable();
                            this.deployNpcList_.addAll(other.deployNpcList_);
                        }
                        onChanged();
                    }
                } else if (!other.deployNpcList_.isEmpty()) {
                    if (this.deployNpcListBuilder_.isEmpty()) {
                        this.deployNpcListBuilder_.dispose();
                        this.deployNpcListBuilder_ = null;
                        this.deployNpcList_ = other.deployNpcList_;
                        this.bitField0_ &= -33;
                        this.deployNpcListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getDeployNpcListFieldBuilder() : null;
                    } else {
                        this.deployNpcListBuilder_.addAllMessages(other.deployNpcList_);
                    }
                }
                if (this.furnitureGroupListBuilder_ == null) {
                    if (!other.furnitureGroupList_.isEmpty()) {
                        if (this.furnitureGroupList_.isEmpty()) {
                            this.furnitureGroupList_ = other.furnitureGroupList_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureFurnitureGroupListIsMutable();
                            this.furnitureGroupList_.addAll(other.furnitureGroupList_);
                        }
                        onChanged();
                    }
                } else if (!other.furnitureGroupList_.isEmpty()) {
                    if (this.furnitureGroupListBuilder_.isEmpty()) {
                        this.furnitureGroupListBuilder_.dispose();
                        this.furnitureGroupListBuilder_ = null;
                        this.furnitureGroupList_ = other.furnitureGroupList_;
                        this.bitField0_ &= -65;
                        this.furnitureGroupListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getFurnitureGroupListFieldBuilder() : null;
                    } else {
                        this.furnitureGroupListBuilder_.addAllMessages(other.furnitureGroupList_);
                    }
                }
                if (this.fieldListBuilder_ == null) {
                    if (!other.fieldList_.isEmpty()) {
                        if (this.fieldList_.isEmpty()) {
                            this.fieldList_ = other.fieldList_;
                            this.bitField0_ &= -129;
                        } else {
                            ensureFieldListIsMutable();
                            this.fieldList_.addAll(other.fieldList_);
                        }
                        onChanged();
                    }
                } else if (!other.fieldList_.isEmpty()) {
                    if (this.fieldListBuilder_.isEmpty()) {
                        this.fieldListBuilder_.dispose();
                        this.fieldListBuilder_ = null;
                        this.fieldList_ = other.fieldList_;
                        this.bitField0_ &= -129;
                        this.fieldListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getFieldListFieldBuilder() : null;
                    } else {
                        this.fieldListBuilder_.addAllMessages(other.fieldList_);
                    }
                }
                if (other.getComfortValue() != 0) {
                    setComfortValue(other.getComfortValue());
                }
                if (this.persistentFurnitureListBuilder_ == null) {
                    if (!other.persistentFurnitureList_.isEmpty()) {
                        if (this.persistentFurnitureList_.isEmpty()) {
                            this.persistentFurnitureList_ = other.persistentFurnitureList_;
                            this.bitField0_ &= -257;
                        } else {
                            ensurePersistentFurnitureListIsMutable();
                            this.persistentFurnitureList_.addAll(other.persistentFurnitureList_);
                        }
                        onChanged();
                    }
                } else if (!other.persistentFurnitureList_.isEmpty()) {
                    if (this.persistentFurnitureListBuilder_.isEmpty()) {
                        this.persistentFurnitureListBuilder_.dispose();
                        this.persistentFurnitureListBuilder_ = null;
                        this.persistentFurnitureList_ = other.persistentFurnitureList_;
                        this.bitField0_ &= -257;
                        this.persistentFurnitureListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getPersistentFurnitureListFieldBuilder() : null;
                    } else {
                        this.persistentFurnitureListBuilder_.addAllMessages(other.persistentFurnitureList_);
                    }
                }
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    if (!other.furnitureCustomSuiteList_.isEmpty()) {
                        if (this.furnitureCustomSuiteList_.isEmpty()) {
                            this.furnitureCustomSuiteList_ = other.furnitureCustomSuiteList_;
                            this.bitField0_ &= -513;
                        } else {
                            ensureFurnitureCustomSuiteListIsMutable();
                            this.furnitureCustomSuiteList_.addAll(other.furnitureCustomSuiteList_);
                        }
                        onChanged();
                    }
                } else if (!other.furnitureCustomSuiteList_.isEmpty()) {
                    if (this.furnitureCustomSuiteListBuilder_.isEmpty()) {
                        this.furnitureCustomSuiteListBuilder_.dispose();
                        this.furnitureCustomSuiteListBuilder_ = null;
                        this.furnitureCustomSuiteList_ = other.furnitureCustomSuiteList_;
                        this.bitField0_ &= -513;
                        this.furnitureCustomSuiteListBuilder_ = HomeBlockArrangementInfo.alwaysUseFieldBuilders ? getFurnitureCustomSuiteListFieldBuilder() : null;
                    } else {
                        this.furnitureCustomSuiteListBuilder_.addAllMessages(other.furnitureCustomSuiteList_);
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
                HomeBlockArrangementInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeBlockArrangementInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeBlockArrangementInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDeployFurniureListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.deployFurniureList_ = new ArrayList(this.deployFurniureList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getDeployFurniureListList() {
                if (this.deployFurniureListBuilder_ == null) {
                    return Collections.unmodifiableList(this.deployFurniureList_);
                }
                return this.deployFurniureListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getDeployFurniureListCount() {
                if (this.deployFurniureListBuilder_ == null) {
                    return this.deployFurniureList_.size();
                }
                return this.deployFurniureListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureData getDeployFurniureList(int index) {
                if (this.deployFurniureListBuilder_ == null) {
                    return this.deployFurniureList_.get(index);
                }
                return this.deployFurniureListBuilder_.getMessage(index);
            }

            public Builder setDeployFurniureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.deployFurniureListBuilder_ != null) {
                    this.deployFurniureListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDeployFurniureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.deployFurniureListBuilder_ == null) {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deployFurniureListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDeployFurniureList(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.deployFurniureListBuilder_ != null) {
                    this.deployFurniureListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeployFurniureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.deployFurniureListBuilder_ != null) {
                    this.deployFurniureListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeployFurniureList(HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.deployFurniureListBuilder_ == null) {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.deployFurniureListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDeployFurniureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.deployFurniureListBuilder_ == null) {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deployFurniureListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDeployFurniureList(Iterable<? extends HomeFurnitureDataOuterClass.HomeFurnitureData> values) {
                if (this.deployFurniureListBuilder_ == null) {
                    ensureDeployFurniureListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.deployFurniureList_);
                    onChanged();
                } else {
                    this.deployFurniureListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDeployFurniureList() {
                if (this.deployFurniureListBuilder_ == null) {
                    this.deployFurniureList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.deployFurniureListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDeployFurniureList(int index) {
                if (this.deployFurniureListBuilder_ == null) {
                    ensureDeployFurniureListIsMutable();
                    this.deployFurniureList_.remove(index);
                    onChanged();
                } else {
                    this.deployFurniureListBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder getDeployFurniureListBuilder(int index) {
                return getDeployFurniureListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getDeployFurniureListOrBuilder(int index) {
                if (this.deployFurniureListBuilder_ == null) {
                    return this.deployFurniureList_.get(index);
                }
                return this.deployFurniureListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getDeployFurniureListOrBuilderList() {
                if (this.deployFurniureListBuilder_ != null) {
                    return this.deployFurniureListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.deployFurniureList_);
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addDeployFurniureListBuilder() {
                return getDeployFurniureListFieldBuilder().addBuilder(HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addDeployFurniureListBuilder(int index) {
                return getDeployFurniureListFieldBuilder().addBuilder(index, HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public List<HomeFurnitureDataOuterClass.HomeFurnitureData.Builder> getDeployFurniureListBuilderList() {
                return getDeployFurniureListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getDeployFurniureListFieldBuilder() {
                if (this.deployFurniureListBuilder_ == null) {
                    this.deployFurniureListBuilder_ = new RepeatedFieldBuilderV3<>(this.deployFurniureList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.deployFurniureList_ = null;
                }
                return this.deployFurniureListBuilder_;
            }

            private void ensureDeployAnimalListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.deployAnimalList_ = new ArrayList(this.deployAnimalList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeAnimalDataOuterClass.HomeAnimalData> getDeployAnimalListList() {
                if (this.deployAnimalListBuilder_ == null) {
                    return Collections.unmodifiableList(this.deployAnimalList_);
                }
                return this.deployAnimalListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getDeployAnimalListCount() {
                if (this.deployAnimalListBuilder_ == null) {
                    return this.deployAnimalList_.size();
                }
                return this.deployAnimalListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeAnimalDataOuterClass.HomeAnimalData getDeployAnimalList(int index) {
                if (this.deployAnimalListBuilder_ == null) {
                    return this.deployAnimalList_.get(index);
                }
                return this.deployAnimalListBuilder_.getMessage(index);
            }

            public Builder setDeployAnimalList(int index, HomeAnimalDataOuterClass.HomeAnimalData value) {
                if (this.deployAnimalListBuilder_ != null) {
                    this.deployAnimalListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDeployAnimalList(int index, HomeAnimalDataOuterClass.HomeAnimalData.Builder builderForValue) {
                if (this.deployAnimalListBuilder_ == null) {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deployAnimalListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDeployAnimalList(HomeAnimalDataOuterClass.HomeAnimalData value) {
                if (this.deployAnimalListBuilder_ != null) {
                    this.deployAnimalListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeployAnimalList(int index, HomeAnimalDataOuterClass.HomeAnimalData value) {
                if (this.deployAnimalListBuilder_ != null) {
                    this.deployAnimalListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeployAnimalList(HomeAnimalDataOuterClass.HomeAnimalData.Builder builderForValue) {
                if (this.deployAnimalListBuilder_ == null) {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.deployAnimalListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDeployAnimalList(int index, HomeAnimalDataOuterClass.HomeAnimalData.Builder builderForValue) {
                if (this.deployAnimalListBuilder_ == null) {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deployAnimalListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDeployAnimalList(Iterable<? extends HomeAnimalDataOuterClass.HomeAnimalData> values) {
                if (this.deployAnimalListBuilder_ == null) {
                    ensureDeployAnimalListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.deployAnimalList_);
                    onChanged();
                } else {
                    this.deployAnimalListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDeployAnimalList() {
                if (this.deployAnimalListBuilder_ == null) {
                    this.deployAnimalList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.deployAnimalListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDeployAnimalList(int index) {
                if (this.deployAnimalListBuilder_ == null) {
                    ensureDeployAnimalListIsMutable();
                    this.deployAnimalList_.remove(index);
                    onChanged();
                } else {
                    this.deployAnimalListBuilder_.remove(index);
                }
                return this;
            }

            public HomeAnimalDataOuterClass.HomeAnimalData.Builder getDeployAnimalListBuilder(int index) {
                return getDeployAnimalListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder getDeployAnimalListOrBuilder(int index) {
                if (this.deployAnimalListBuilder_ == null) {
                    return this.deployAnimalList_.get(index);
                }
                return this.deployAnimalListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder> getDeployAnimalListOrBuilderList() {
                if (this.deployAnimalListBuilder_ != null) {
                    return this.deployAnimalListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.deployAnimalList_);
            }

            public HomeAnimalDataOuterClass.HomeAnimalData.Builder addDeployAnimalListBuilder() {
                return getDeployAnimalListFieldBuilder().addBuilder(HomeAnimalDataOuterClass.HomeAnimalData.getDefaultInstance());
            }

            public HomeAnimalDataOuterClass.HomeAnimalData.Builder addDeployAnimalListBuilder(int index) {
                return getDeployAnimalListFieldBuilder().addBuilder(index, HomeAnimalDataOuterClass.HomeAnimalData.getDefaultInstance());
            }

            public List<HomeAnimalDataOuterClass.HomeAnimalData.Builder> getDeployAnimalListBuilderList() {
                return getDeployAnimalListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeAnimalDataOuterClass.HomeAnimalData, HomeAnimalDataOuterClass.HomeAnimalData.Builder, HomeAnimalDataOuterClass.HomeAnimalDataOrBuilder> getDeployAnimalListFieldBuilder() {
                if (this.deployAnimalListBuilder_ == null) {
                    this.deployAnimalListBuilder_ = new RepeatedFieldBuilderV3<>(this.deployAnimalList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.deployAnimalList_ = null;
                }
                return this.deployAnimalListBuilder_;
            }

            private void ensureFurnitureSuiteListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.furnitureSuiteList_ = new ArrayList(this.furnitureSuiteList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData> getFurnitureSuiteListList() {
                if (this.furnitureSuiteListBuilder_ == null) {
                    return Collections.unmodifiableList(this.furnitureSuiteList_);
                }
                return this.furnitureSuiteListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getFurnitureSuiteListCount() {
                if (this.furnitureSuiteListBuilder_ == null) {
                    return this.furnitureSuiteList_.size();
                }
                return this.furnitureSuiteListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData getFurnitureSuiteList(int index) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    return this.furnitureSuiteList_.get(index);
                }
                return this.furnitureSuiteListBuilder_.getMessage(index);
            }

            public Builder setFurnitureSuiteList(int index, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData value) {
                if (this.furnitureSuiteListBuilder_ != null) {
                    this.furnitureSuiteListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureSuiteList(int index, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder builderForValue) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureSuiteListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureSuiteList(HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData value) {
                if (this.furnitureSuiteListBuilder_ != null) {
                    this.furnitureSuiteListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureSuiteList(int index, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData value) {
                if (this.furnitureSuiteListBuilder_ != null) {
                    this.furnitureSuiteListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureSuiteList(HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder builderForValue) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureSuiteListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureSuiteList(int index, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder builderForValue) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureSuiteListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFurnitureSuiteList(Iterable<? extends HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData> values) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    ensureFurnitureSuiteListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureSuiteList_);
                    onChanged();
                } else {
                    this.furnitureSuiteListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFurnitureSuiteList() {
                if (this.furnitureSuiteListBuilder_ == null) {
                    this.furnitureSuiteList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.furnitureSuiteListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFurnitureSuiteList(int index) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    ensureFurnitureSuiteListIsMutable();
                    this.furnitureSuiteList_.remove(index);
                    onChanged();
                } else {
                    this.furnitureSuiteListBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder getFurnitureSuiteListBuilder(int index) {
                return getFurnitureSuiteListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder getFurnitureSuiteListOrBuilder(int index) {
                if (this.furnitureSuiteListBuilder_ == null) {
                    return this.furnitureSuiteList_.get(index);
                }
                return this.furnitureSuiteListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder> getFurnitureSuiteListOrBuilderList() {
                if (this.furnitureSuiteListBuilder_ != null) {
                    return this.furnitureSuiteListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.furnitureSuiteList_);
            }

            public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder addFurnitureSuiteListBuilder() {
                return getFurnitureSuiteListFieldBuilder().addBuilder(HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.getDefaultInstance());
            }

            public HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder addFurnitureSuiteListBuilder(int index) {
                return getFurnitureSuiteListFieldBuilder().addBuilder(index, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.getDefaultInstance());
            }

            public List<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder> getFurnitureSuiteListBuilderList() {
                return getFurnitureSuiteListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteData.Builder, HomeFurnitureSuiteDataOuterClass.HomeFurnitureSuiteDataOrBuilder> getFurnitureSuiteListFieldBuilder() {
                if (this.furnitureSuiteListBuilder_ == null) {
                    this.furnitureSuiteListBuilder_ = new RepeatedFieldBuilderV3<>(this.furnitureSuiteList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.furnitureSuiteList_ = null;
                }
                return this.furnitureSuiteListBuilder_;
            }

            private void ensureWeekendDjinnInfoListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.weekendDjinnInfoList_ = new ArrayList(this.weekendDjinnInfoList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<WeekendDjinnInfoOuterClass.WeekendDjinnInfo> getWeekendDjinnInfoListList() {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.weekendDjinnInfoList_);
                }
                return this.weekendDjinnInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getWeekendDjinnInfoListCount() {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    return this.weekendDjinnInfoList_.size();
                }
                return this.weekendDjinnInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public WeekendDjinnInfoOuterClass.WeekendDjinnInfo getWeekendDjinnInfoList(int index) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    return this.weekendDjinnInfoList_.get(index);
                }
                return this.weekendDjinnInfoListBuilder_.getMessage(index);
            }

            public Builder setWeekendDjinnInfoList(int index, WeekendDjinnInfoOuterClass.WeekendDjinnInfo value) {
                if (this.weekendDjinnInfoListBuilder_ != null) {
                    this.weekendDjinnInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setWeekendDjinnInfoList(int index, WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder builderForValue) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.weekendDjinnInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addWeekendDjinnInfoList(WeekendDjinnInfoOuterClass.WeekendDjinnInfo value) {
                if (this.weekendDjinnInfoListBuilder_ != null) {
                    this.weekendDjinnInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addWeekendDjinnInfoList(int index, WeekendDjinnInfoOuterClass.WeekendDjinnInfo value) {
                if (this.weekendDjinnInfoListBuilder_ != null) {
                    this.weekendDjinnInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addWeekendDjinnInfoList(WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder builderForValue) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.weekendDjinnInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addWeekendDjinnInfoList(int index, WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder builderForValue) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.weekendDjinnInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllWeekendDjinnInfoList(Iterable<? extends WeekendDjinnInfoOuterClass.WeekendDjinnInfo> values) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    ensureWeekendDjinnInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.weekendDjinnInfoList_);
                    onChanged();
                } else {
                    this.weekendDjinnInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearWeekendDjinnInfoList() {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    this.weekendDjinnInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.weekendDjinnInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeWeekendDjinnInfoList(int index) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    ensureWeekendDjinnInfoListIsMutable();
                    this.weekendDjinnInfoList_.remove(index);
                    onChanged();
                } else {
                    this.weekendDjinnInfoListBuilder_.remove(index);
                }
                return this;
            }

            public WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder getWeekendDjinnInfoListBuilder(int index) {
                return getWeekendDjinnInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder getWeekendDjinnInfoListOrBuilder(int index) {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    return this.weekendDjinnInfoList_.get(index);
                }
                return this.weekendDjinnInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder> getWeekendDjinnInfoListOrBuilderList() {
                if (this.weekendDjinnInfoListBuilder_ != null) {
                    return this.weekendDjinnInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.weekendDjinnInfoList_);
            }

            public WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder addWeekendDjinnInfoListBuilder() {
                return getWeekendDjinnInfoListFieldBuilder().addBuilder(WeekendDjinnInfoOuterClass.WeekendDjinnInfo.getDefaultInstance());
            }

            public WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder addWeekendDjinnInfoListBuilder(int index) {
                return getWeekendDjinnInfoListFieldBuilder().addBuilder(index, WeekendDjinnInfoOuterClass.WeekendDjinnInfo.getDefaultInstance());
            }

            public List<WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder> getWeekendDjinnInfoListBuilderList() {
                return getWeekendDjinnInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WeekendDjinnInfoOuterClass.WeekendDjinnInfo, WeekendDjinnInfoOuterClass.WeekendDjinnInfo.Builder, WeekendDjinnInfoOuterClass.WeekendDjinnInfoOrBuilder> getWeekendDjinnInfoListFieldBuilder() {
                if (this.weekendDjinnInfoListBuilder_ == null) {
                    this.weekendDjinnInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.weekendDjinnInfoList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.weekendDjinnInfoList_ = null;
                }
                return this.weekendDjinnInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getBlockId() {
                return this.blockId_;
            }

            public Builder setBlockId(int value) {
                this.blockId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBlockId() {
                this.blockId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDotPatternListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.dotPatternList_ = new ArrayList(this.dotPatternList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeBlockDotPatternOuterClass.HomeBlockDotPattern> getDotPatternListList() {
                if (this.dotPatternListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dotPatternList_);
                }
                return this.dotPatternListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getDotPatternListCount() {
                if (this.dotPatternListBuilder_ == null) {
                    return this.dotPatternList_.size();
                }
                return this.dotPatternListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeBlockDotPatternOuterClass.HomeBlockDotPattern getDotPatternList(int index) {
                if (this.dotPatternListBuilder_ == null) {
                    return this.dotPatternList_.get(index);
                }
                return this.dotPatternListBuilder_.getMessage(index);
            }

            public Builder setDotPatternList(int index, HomeBlockDotPatternOuterClass.HomeBlockDotPattern value) {
                if (this.dotPatternListBuilder_ != null) {
                    this.dotPatternListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDotPatternList(int index, HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder builderForValue) {
                if (this.dotPatternListBuilder_ == null) {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dotPatternListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDotPatternList(HomeBlockDotPatternOuterClass.HomeBlockDotPattern value) {
                if (this.dotPatternListBuilder_ != null) {
                    this.dotPatternListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDotPatternList(int index, HomeBlockDotPatternOuterClass.HomeBlockDotPattern value) {
                if (this.dotPatternListBuilder_ != null) {
                    this.dotPatternListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDotPatternList(HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder builderForValue) {
                if (this.dotPatternListBuilder_ == null) {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dotPatternListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDotPatternList(int index, HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder builderForValue) {
                if (this.dotPatternListBuilder_ == null) {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dotPatternListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDotPatternList(Iterable<? extends HomeBlockDotPatternOuterClass.HomeBlockDotPattern> values) {
                if (this.dotPatternListBuilder_ == null) {
                    ensureDotPatternListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dotPatternList_);
                    onChanged();
                } else {
                    this.dotPatternListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDotPatternList() {
                if (this.dotPatternListBuilder_ == null) {
                    this.dotPatternList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.dotPatternListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDotPatternList(int index) {
                if (this.dotPatternListBuilder_ == null) {
                    ensureDotPatternListIsMutable();
                    this.dotPatternList_.remove(index);
                    onChanged();
                } else {
                    this.dotPatternListBuilder_.remove(index);
                }
                return this;
            }

            public HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder getDotPatternListBuilder(int index) {
                return getDotPatternListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder getDotPatternListOrBuilder(int index) {
                if (this.dotPatternListBuilder_ == null) {
                    return this.dotPatternList_.get(index);
                }
                return this.dotPatternListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder> getDotPatternListOrBuilderList() {
                if (this.dotPatternListBuilder_ != null) {
                    return this.dotPatternListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dotPatternList_);
            }

            public HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder addDotPatternListBuilder() {
                return getDotPatternListFieldBuilder().addBuilder(HomeBlockDotPatternOuterClass.HomeBlockDotPattern.getDefaultInstance());
            }

            public HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder addDotPatternListBuilder(int index) {
                return getDotPatternListFieldBuilder().addBuilder(index, HomeBlockDotPatternOuterClass.HomeBlockDotPattern.getDefaultInstance());
            }

            public List<HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder> getDotPatternListBuilderList() {
                return getDotPatternListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeBlockDotPatternOuterClass.HomeBlockDotPattern, HomeBlockDotPatternOuterClass.HomeBlockDotPattern.Builder, HomeBlockDotPatternOuterClass.HomeBlockDotPatternOrBuilder> getDotPatternListFieldBuilder() {
                if (this.dotPatternListBuilder_ == null) {
                    this.dotPatternListBuilder_ = new RepeatedFieldBuilderV3<>(this.dotPatternList_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.dotPatternList_ = null;
                }
                return this.dotPatternListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public boolean getIsUnlocked() {
                return this.isUnlocked_;
            }

            public Builder setIsUnlocked(boolean value) {
                this.isUnlocked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUnlocked() {
                this.isUnlocked_ = false;
                onChanged();
                return this;
            }

            private void ensureDeployNpcListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.deployNpcList_ = new ArrayList(this.deployNpcList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeNpcDataOuterClass.HomeNpcData> getDeployNpcListList() {
                if (this.deployNpcListBuilder_ == null) {
                    return Collections.unmodifiableList(this.deployNpcList_);
                }
                return this.deployNpcListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getDeployNpcListCount() {
                if (this.deployNpcListBuilder_ == null) {
                    return this.deployNpcList_.size();
                }
                return this.deployNpcListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeNpcDataOuterClass.HomeNpcData getDeployNpcList(int index) {
                if (this.deployNpcListBuilder_ == null) {
                    return this.deployNpcList_.get(index);
                }
                return this.deployNpcListBuilder_.getMessage(index);
            }

            public Builder setDeployNpcList(int index, HomeNpcDataOuterClass.HomeNpcData value) {
                if (this.deployNpcListBuilder_ != null) {
                    this.deployNpcListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDeployNpcList(int index, HomeNpcDataOuterClass.HomeNpcData.Builder builderForValue) {
                if (this.deployNpcListBuilder_ == null) {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deployNpcListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDeployNpcList(HomeNpcDataOuterClass.HomeNpcData value) {
                if (this.deployNpcListBuilder_ != null) {
                    this.deployNpcListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeployNpcList(int index, HomeNpcDataOuterClass.HomeNpcData value) {
                if (this.deployNpcListBuilder_ != null) {
                    this.deployNpcListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDeployNpcList(HomeNpcDataOuterClass.HomeNpcData.Builder builderForValue) {
                if (this.deployNpcListBuilder_ == null) {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.deployNpcListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDeployNpcList(int index, HomeNpcDataOuterClass.HomeNpcData.Builder builderForValue) {
                if (this.deployNpcListBuilder_ == null) {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.deployNpcListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDeployNpcList(Iterable<? extends HomeNpcDataOuterClass.HomeNpcData> values) {
                if (this.deployNpcListBuilder_ == null) {
                    ensureDeployNpcListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.deployNpcList_);
                    onChanged();
                } else {
                    this.deployNpcListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDeployNpcList() {
                if (this.deployNpcListBuilder_ == null) {
                    this.deployNpcList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.deployNpcListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDeployNpcList(int index) {
                if (this.deployNpcListBuilder_ == null) {
                    ensureDeployNpcListIsMutable();
                    this.deployNpcList_.remove(index);
                    onChanged();
                } else {
                    this.deployNpcListBuilder_.remove(index);
                }
                return this;
            }

            public HomeNpcDataOuterClass.HomeNpcData.Builder getDeployNpcListBuilder(int index) {
                return getDeployNpcListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeNpcDataOuterClass.HomeNpcDataOrBuilder getDeployNpcListOrBuilder(int index) {
                if (this.deployNpcListBuilder_ == null) {
                    return this.deployNpcList_.get(index);
                }
                return this.deployNpcListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeNpcDataOuterClass.HomeNpcDataOrBuilder> getDeployNpcListOrBuilderList() {
                if (this.deployNpcListBuilder_ != null) {
                    return this.deployNpcListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.deployNpcList_);
            }

            public HomeNpcDataOuterClass.HomeNpcData.Builder addDeployNpcListBuilder() {
                return getDeployNpcListFieldBuilder().addBuilder(HomeNpcDataOuterClass.HomeNpcData.getDefaultInstance());
            }

            public HomeNpcDataOuterClass.HomeNpcData.Builder addDeployNpcListBuilder(int index) {
                return getDeployNpcListFieldBuilder().addBuilder(index, HomeNpcDataOuterClass.HomeNpcData.getDefaultInstance());
            }

            public List<HomeNpcDataOuterClass.HomeNpcData.Builder> getDeployNpcListBuilderList() {
                return getDeployNpcListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeNpcDataOuterClass.HomeNpcData, HomeNpcDataOuterClass.HomeNpcData.Builder, HomeNpcDataOuterClass.HomeNpcDataOrBuilder> getDeployNpcListFieldBuilder() {
                if (this.deployNpcListBuilder_ == null) {
                    this.deployNpcListBuilder_ = new RepeatedFieldBuilderV3<>(this.deployNpcList_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                    this.deployNpcList_ = null;
                }
                return this.deployNpcListBuilder_;
            }

            private void ensureFurnitureGroupListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.furnitureGroupList_ = new ArrayList(this.furnitureGroupList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData> getFurnitureGroupListList() {
                if (this.furnitureGroupListBuilder_ == null) {
                    return Collections.unmodifiableList(this.furnitureGroupList_);
                }
                return this.furnitureGroupListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getFurnitureGroupListCount() {
                if (this.furnitureGroupListBuilder_ == null) {
                    return this.furnitureGroupList_.size();
                }
                return this.furnitureGroupListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData getFurnitureGroupList(int index) {
                if (this.furnitureGroupListBuilder_ == null) {
                    return this.furnitureGroupList_.get(index);
                }
                return this.furnitureGroupListBuilder_.getMessage(index);
            }

            public Builder setFurnitureGroupList(int index, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData value) {
                if (this.furnitureGroupListBuilder_ != null) {
                    this.furnitureGroupListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureGroupList(int index, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder builderForValue) {
                if (this.furnitureGroupListBuilder_ == null) {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureGroupListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureGroupList(HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData value) {
                if (this.furnitureGroupListBuilder_ != null) {
                    this.furnitureGroupListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureGroupList(int index, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData value) {
                if (this.furnitureGroupListBuilder_ != null) {
                    this.furnitureGroupListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureGroupList(HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder builderForValue) {
                if (this.furnitureGroupListBuilder_ == null) {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureGroupListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureGroupList(int index, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder builderForValue) {
                if (this.furnitureGroupListBuilder_ == null) {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureGroupListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFurnitureGroupList(Iterable<? extends HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData> values) {
                if (this.furnitureGroupListBuilder_ == null) {
                    ensureFurnitureGroupListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureGroupList_);
                    onChanged();
                } else {
                    this.furnitureGroupListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFurnitureGroupList() {
                if (this.furnitureGroupListBuilder_ == null) {
                    this.furnitureGroupList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.furnitureGroupListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFurnitureGroupList(int index) {
                if (this.furnitureGroupListBuilder_ == null) {
                    ensureFurnitureGroupListIsMutable();
                    this.furnitureGroupList_.remove(index);
                    onChanged();
                } else {
                    this.furnitureGroupListBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder getFurnitureGroupListBuilder(int index) {
                return getFurnitureGroupListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder getFurnitureGroupListOrBuilder(int index) {
                if (this.furnitureGroupListBuilder_ == null) {
                    return this.furnitureGroupList_.get(index);
                }
                return this.furnitureGroupListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder> getFurnitureGroupListOrBuilderList() {
                if (this.furnitureGroupListBuilder_ != null) {
                    return this.furnitureGroupListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.furnitureGroupList_);
            }

            public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder addFurnitureGroupListBuilder() {
                return getFurnitureGroupListFieldBuilder().addBuilder(HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.getDefaultInstance());
            }

            public HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder addFurnitureGroupListBuilder(int index) {
                return getFurnitureGroupListFieldBuilder().addBuilder(index, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.getDefaultInstance());
            }

            public List<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder> getFurnitureGroupListBuilderList() {
                return getFurnitureGroupListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupData.Builder, HomeFurnitureGroupDataOuterClass.HomeFurnitureGroupDataOrBuilder> getFurnitureGroupListFieldBuilder() {
                if (this.furnitureGroupListBuilder_ == null) {
                    this.furnitureGroupListBuilder_ = new RepeatedFieldBuilderV3<>(this.furnitureGroupList_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                    this.furnitureGroupList_ = null;
                }
                return this.furnitureGroupListBuilder_;
            }

            private void ensureFieldListIsMutable() {
                if ((this.bitField0_ & 128) == 0) {
                    this.fieldList_ = new ArrayList(this.fieldList_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeBlockFieldDataOuterClass.HomeBlockFieldData> getFieldListList() {
                if (this.fieldListBuilder_ == null) {
                    return Collections.unmodifiableList(this.fieldList_);
                }
                return this.fieldListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getFieldListCount() {
                if (this.fieldListBuilder_ == null) {
                    return this.fieldList_.size();
                }
                return this.fieldListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeBlockFieldDataOuterClass.HomeBlockFieldData getFieldList(int index) {
                if (this.fieldListBuilder_ == null) {
                    return this.fieldList_.get(index);
                }
                return this.fieldListBuilder_.getMessage(index);
            }

            public Builder setFieldList(int index, HomeBlockFieldDataOuterClass.HomeBlockFieldData value) {
                if (this.fieldListBuilder_ != null) {
                    this.fieldListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFieldListIsMutable();
                    this.fieldList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFieldList(int index, HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder builderForValue) {
                if (this.fieldListBuilder_ == null) {
                    ensureFieldListIsMutable();
                    this.fieldList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fieldListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFieldList(HomeBlockFieldDataOuterClass.HomeBlockFieldData value) {
                if (this.fieldListBuilder_ != null) {
                    this.fieldListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFieldListIsMutable();
                    this.fieldList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFieldList(int index, HomeBlockFieldDataOuterClass.HomeBlockFieldData value) {
                if (this.fieldListBuilder_ != null) {
                    this.fieldListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFieldListIsMutable();
                    this.fieldList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFieldList(HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder builderForValue) {
                if (this.fieldListBuilder_ == null) {
                    ensureFieldListIsMutable();
                    this.fieldList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fieldListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFieldList(int index, HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder builderForValue) {
                if (this.fieldListBuilder_ == null) {
                    ensureFieldListIsMutable();
                    this.fieldList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fieldListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFieldList(Iterable<? extends HomeBlockFieldDataOuterClass.HomeBlockFieldData> values) {
                if (this.fieldListBuilder_ == null) {
                    ensureFieldListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fieldList_);
                    onChanged();
                } else {
                    this.fieldListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFieldList() {
                if (this.fieldListBuilder_ == null) {
                    this.fieldList_ = Collections.emptyList();
                    this.bitField0_ &= -129;
                    onChanged();
                } else {
                    this.fieldListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFieldList(int index) {
                if (this.fieldListBuilder_ == null) {
                    ensureFieldListIsMutable();
                    this.fieldList_.remove(index);
                    onChanged();
                } else {
                    this.fieldListBuilder_.remove(index);
                }
                return this;
            }

            public HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder getFieldListBuilder(int index) {
                return getFieldListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder getFieldListOrBuilder(int index) {
                if (this.fieldListBuilder_ == null) {
                    return this.fieldList_.get(index);
                }
                return this.fieldListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder> getFieldListOrBuilderList() {
                if (this.fieldListBuilder_ != null) {
                    return this.fieldListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fieldList_);
            }

            public HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder addFieldListBuilder() {
                return getFieldListFieldBuilder().addBuilder(HomeBlockFieldDataOuterClass.HomeBlockFieldData.getDefaultInstance());
            }

            public HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder addFieldListBuilder(int index) {
                return getFieldListFieldBuilder().addBuilder(index, HomeBlockFieldDataOuterClass.HomeBlockFieldData.getDefaultInstance());
            }

            public List<HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder> getFieldListBuilderList() {
                return getFieldListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeBlockFieldDataOuterClass.HomeBlockFieldData, HomeBlockFieldDataOuterClass.HomeBlockFieldData.Builder, HomeBlockFieldDataOuterClass.HomeBlockFieldDataOrBuilder> getFieldListFieldBuilder() {
                if (this.fieldListBuilder_ == null) {
                    this.fieldListBuilder_ = new RepeatedFieldBuilderV3<>(this.fieldList_, (this.bitField0_ & 128) != 0, getParentForChildren(), isClean());
                    this.fieldList_ = null;
                }
                return this.fieldListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
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

            private void ensurePersistentFurnitureListIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.persistentFurnitureList_ = new ArrayList(this.persistentFurnitureList_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeFurnitureDataOuterClass.HomeFurnitureData> getPersistentFurnitureListList() {
                if (this.persistentFurnitureListBuilder_ == null) {
                    return Collections.unmodifiableList(this.persistentFurnitureList_);
                }
                return this.persistentFurnitureListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getPersistentFurnitureListCount() {
                if (this.persistentFurnitureListBuilder_ == null) {
                    return this.persistentFurnitureList_.size();
                }
                return this.persistentFurnitureListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureData getPersistentFurnitureList(int index) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    return this.persistentFurnitureList_.get(index);
                }
                return this.persistentFurnitureListBuilder_.getMessage(index);
            }

            public Builder setPersistentFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.persistentFurnitureListBuilder_ != null) {
                    this.persistentFurnitureListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPersistentFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.persistentFurnitureListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPersistentFurnitureList(HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.persistentFurnitureListBuilder_ != null) {
                    this.persistentFurnitureListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPersistentFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData value) {
                if (this.persistentFurnitureListBuilder_ != null) {
                    this.persistentFurnitureListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPersistentFurnitureList(HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.persistentFurnitureListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPersistentFurnitureList(int index, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder builderForValue) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.persistentFurnitureListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPersistentFurnitureList(Iterable<? extends HomeFurnitureDataOuterClass.HomeFurnitureData> values) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    ensurePersistentFurnitureListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.persistentFurnitureList_);
                    onChanged();
                } else {
                    this.persistentFurnitureListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPersistentFurnitureList() {
                if (this.persistentFurnitureListBuilder_ == null) {
                    this.persistentFurnitureList_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                    onChanged();
                } else {
                    this.persistentFurnitureListBuilder_.clear();
                }
                return this;
            }

            public Builder removePersistentFurnitureList(int index) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    ensurePersistentFurnitureListIsMutable();
                    this.persistentFurnitureList_.remove(index);
                    onChanged();
                } else {
                    this.persistentFurnitureListBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder getPersistentFurnitureListBuilder(int index) {
                return getPersistentFurnitureListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder getPersistentFurnitureListOrBuilder(int index) {
                if (this.persistentFurnitureListBuilder_ == null) {
                    return this.persistentFurnitureList_.get(index);
                }
                return this.persistentFurnitureListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getPersistentFurnitureListOrBuilderList() {
                if (this.persistentFurnitureListBuilder_ != null) {
                    return this.persistentFurnitureListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.persistentFurnitureList_);
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addPersistentFurnitureListBuilder() {
                return getPersistentFurnitureListFieldBuilder().addBuilder(HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public HomeFurnitureDataOuterClass.HomeFurnitureData.Builder addPersistentFurnitureListBuilder(int index) {
                return getPersistentFurnitureListFieldBuilder().addBuilder(index, HomeFurnitureDataOuterClass.HomeFurnitureData.getDefaultInstance());
            }

            public List<HomeFurnitureDataOuterClass.HomeFurnitureData.Builder> getPersistentFurnitureListBuilderList() {
                return getPersistentFurnitureListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureDataOuterClass.HomeFurnitureData, HomeFurnitureDataOuterClass.HomeFurnitureData.Builder, HomeFurnitureDataOuterClass.HomeFurnitureDataOrBuilder> getPersistentFurnitureListFieldBuilder() {
                if (this.persistentFurnitureListBuilder_ == null) {
                    this.persistentFurnitureListBuilder_ = new RepeatedFieldBuilderV3<>(this.persistentFurnitureList_, (this.bitField0_ & 256) != 0, getParentForChildren(), isClean());
                    this.persistentFurnitureList_ = null;
                }
                return this.persistentFurnitureListBuilder_;
            }

            private void ensureFurnitureCustomSuiteListIsMutable() {
                if ((this.bitField0_ & 512) == 0) {
                    this.furnitureCustomSuiteList_ = new ArrayList(this.furnitureCustomSuiteList_);
                    this.bitField0_ |= 512;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData> getFurnitureCustomSuiteListList() {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    return Collections.unmodifiableList(this.furnitureCustomSuiteList_);
                }
                return this.furnitureCustomSuiteListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public int getFurnitureCustomSuiteListCount() {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    return this.furnitureCustomSuiteList_.size();
                }
                return this.furnitureCustomSuiteListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData getFurnitureCustomSuiteList(int index) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    return this.furnitureCustomSuiteList_.get(index);
                }
                return this.furnitureCustomSuiteListBuilder_.getMessage(index);
            }

            public Builder setFurnitureCustomSuiteList(int index, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData value) {
                if (this.furnitureCustomSuiteListBuilder_ != null) {
                    this.furnitureCustomSuiteListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureCustomSuiteList(int index, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder builderForValue) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureCustomSuiteListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureCustomSuiteList(HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData value) {
                if (this.furnitureCustomSuiteListBuilder_ != null) {
                    this.furnitureCustomSuiteListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureCustomSuiteList(int index, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData value) {
                if (this.furnitureCustomSuiteListBuilder_ != null) {
                    this.furnitureCustomSuiteListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureCustomSuiteList(HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder builderForValue) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureCustomSuiteListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureCustomSuiteList(int index, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder builderForValue) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureCustomSuiteListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFurnitureCustomSuiteList(Iterable<? extends HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData> values) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    ensureFurnitureCustomSuiteListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureCustomSuiteList_);
                    onChanged();
                } else {
                    this.furnitureCustomSuiteListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFurnitureCustomSuiteList() {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    this.furnitureCustomSuiteList_ = Collections.emptyList();
                    this.bitField0_ &= -513;
                    onChanged();
                } else {
                    this.furnitureCustomSuiteListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFurnitureCustomSuiteList(int index) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    ensureFurnitureCustomSuiteListIsMutable();
                    this.furnitureCustomSuiteList_.remove(index);
                    onChanged();
                } else {
                    this.furnitureCustomSuiteListBuilder_.remove(index);
                }
                return this;
            }

            public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder getFurnitureCustomSuiteListBuilder(int index) {
                return getFurnitureCustomSuiteListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder getFurnitureCustomSuiteListOrBuilder(int index) {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    return this.furnitureCustomSuiteList_.get(index);
                }
                return this.furnitureCustomSuiteListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HomeBlockArrangementInfoOuterClass.HomeBlockArrangementInfoOrBuilder
            public List<? extends HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder> getFurnitureCustomSuiteListOrBuilderList() {
                if (this.furnitureCustomSuiteListBuilder_ != null) {
                    return this.furnitureCustomSuiteListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.furnitureCustomSuiteList_);
            }

            public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder addFurnitureCustomSuiteListBuilder() {
                return getFurnitureCustomSuiteListFieldBuilder().addBuilder(HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.getDefaultInstance());
            }

            public HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder addFurnitureCustomSuiteListBuilder(int index) {
                return getFurnitureCustomSuiteListFieldBuilder().addBuilder(index, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.getDefaultInstance());
            }

            public List<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder> getFurnitureCustomSuiteListBuilderList() {
                return getFurnitureCustomSuiteListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteData.Builder, HomeFurnitureCustomSuiteDataOuterClass.HomeFurnitureCustomSuiteDataOrBuilder> getFurnitureCustomSuiteListFieldBuilder() {
                if (this.furnitureCustomSuiteListBuilder_ == null) {
                    this.furnitureCustomSuiteListBuilder_ = new RepeatedFieldBuilderV3<>(this.furnitureCustomSuiteList_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                    this.furnitureCustomSuiteList_ = null;
                }
                return this.furnitureCustomSuiteListBuilder_;
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

        public static HomeBlockArrangementInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeBlockArrangementInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeBlockArrangementInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeBlockArrangementInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HomeAnimalDataOuterClass.getDescriptor();
        HomeBlockDotPatternOuterClass.getDescriptor();
        HomeBlockFieldDataOuterClass.getDescriptor();
        HomeFurnitureCustomSuiteDataOuterClass.getDescriptor();
        HomeFurnitureDataOuterClass.getDescriptor();
        HomeFurnitureGroupDataOuterClass.getDescriptor();
        HomeFurnitureSuiteDataOuterClass.getDescriptor();
        HomeNpcDataOuterClass.getDescriptor();
        WeekendDjinnInfoOuterClass.getDescriptor();
    }
}
