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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass;
import emu.grasscutter.net.proto.BlossomChestInfoOuterClass;
import emu.grasscutter.net.proto.BossChestInfoOuterClass;
import emu.grasscutter.net.proto.ClientGadgetInfoOuterClass;
import emu.grasscutter.net.proto.CoinCollectOperatorInfoOuterClass;
import emu.grasscutter.net.proto.CustomGadgetTreeInfoOuterClass;
import emu.grasscutter.net.proto.DeshretObeliskGadgetInfoOuterClass;
import emu.grasscutter.net.proto.EchoShellInfoOuterClass;
import emu.grasscutter.net.proto.FishPoolInfoOuterClass;
import emu.grasscutter.net.proto.FoundationInfoOuterClass;
import emu.grasscutter.net.proto.GadgetBornTypeOuterClass;
import emu.grasscutter.net.proto.GadgetGeneralRewardInfoOuterClass;
import emu.grasscutter.net.proto.GadgetPlayInfoOuterClass;
import emu.grasscutter.net.proto.GatherGadgetInfoOuterClass;
import emu.grasscutter.net.proto.ItemOuterClass;
import emu.grasscutter.net.proto.MpPlayRewardInfoOuterClass;
import emu.grasscutter.net.proto.NightCrowGadgetInfoOuterClass;
import emu.grasscutter.net.proto.OfferingInfoOuterClass;
import emu.grasscutter.net.proto.PlatformInfoOuterClass;
import emu.grasscutter.net.proto.RoguelikeGadgetInfoOuterClass;
import emu.grasscutter.net.proto.ScreenInfoOuterClass;
import emu.grasscutter.net.proto.StatueGadgetInfoOuterClass;
import emu.grasscutter.net.proto.VehicleInfoOuterClass;
import emu.grasscutter.net.proto.WeatherInfoOuterClass;
import emu.grasscutter.net.proto.WorktopInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import javassist.compiler.TokenId;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGadgetInfoOuterClass.class */
public final class SceneGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015SceneGadgetInfo.proto\u001a\u0017AbilityGadgetInfo.proto\u001a\u0016BlossomChestInfo.proto\u001a\u0013BossChestInfo.proto\u001a\u0016ClientGadgetInfo.proto\u001a\u001dCoinCollectOperatorInfo.proto\u001a\u001aCustomGadgetTreeInfo.proto\u001a\u001eDeshretObeliskGadgetInfo.proto\u001a\u0013EchoShellInfo.proto\u001a\u0012FishPoolInfo.proto\u001a\u0014FoundationInfo.proto\u001a\u0014GadgetBornType.proto\u001a\u001dGadgetGeneralRewardInfo.proto\u001a\u0014GadgetPlayInfo.proto\u001a\u0016GatherGadgetInfo.proto\u001a\nItem.proto\u001a\u0016MpPlayRewardInfo.proto\u001a\u0019NightCrowGadgetInfo.proto\u001a\u0012OfferingInfo.proto\u001a\u0012PlatformInfo.proto\u001a\u0019RoguelikeGadgetInfo.proto\u001a\u0010ScreenInfo.proto\u001a\u0016StatueGadgetInfo.proto\u001a\u0011VehicleInfo.proto\u001a\u0011WeatherInfo.proto\u001a\u0011WorktopInfo.proto\"½\u000b\n\u000fSceneGadgetInfo\u0012\u0011\n\tgadget_id\u0018\u0001 \u0001(\r\u0012\u0010\n\bgroup_id\u0018\u0002 \u0001(\r\u0012\u0011\n\tconfig_id\u0018\u0003 \u0001(\r\u0012\u0017\n\u000fowner_entity_id\u0018\u0004 \u0001(\r\u0012\"\n\tborn_type\u0018\u0005 \u0001(\u000e2\u000f.GadgetBornType\u0012\u0014\n\fgadget_state\u0018\u0006 \u0001(\r\u0012\u0013\n\u000bgadget_type\u0018\u0007 \u0001(\r\u0012\u0018\n\u0010is_show_cutscene\u0018\b \u0001(\b\u0012\u0019\n\u0011authority_peer_id\u0018\t \u0001(\r\u0012\u001a\n\u0012is_enable_interact\u0018\n \u0001(\b\u0012\u0013\n\u000binteract_id\u0018\u000b \u0001(\r\u0012\u0011\n\tmark_flag\u0018\u0015 \u0001(\r\u0012\u001c\n\u0014prop_owner_entity_id\u0018\u0016 \u0001(\r\u0012\u001f\n\bplatform\u0018\u0017 \u0001(\u000b2\r.PlatformInfo\u0012\u0019\n\u0011interact_uid_list\u0018\u0018 \u0003(\r\u0012\u0010\n\bdraft_id\u0018\u0019 \u0001(\r\u0012\u0019\n\u0011gadget_talk_state\u0018\u001a \u0001(\r\u0012\"\n\tplay_info\u0018d \u0001(\u000b2\u000f.GadgetPlayInfo\u0012\u001c\n\u000btrifle_item\u0018\f \u0001(\u000b2\u0005.ItemH��\u0012*\n\rgather_gadget\u0018\r \u0001(\u000b2\u0011.GatherGadgetInfoH��\u0012\u001f\n\u0007worktop\u0018\u000e \u0001(\u000b2\f.WorktopInfoH��\u0012*\n\rclient_gadget\u0018\u000f \u0001(\u000b2\u0011.ClientGadgetInfoH��\u0012\u001f\n\u0007weather\u0018\u0011 \u0001(\u000b2\f.WeatherInfoH��\u0012,\n\u000eability_gadget\u0018\u0012 \u0001(\u000b2\u0012.AbilityGadgetInfoH��\u0012*\n\rstatue_gadget\u0018\u0013 \u0001(\u000b2\u0011.StatueGadgetInfoH��\u0012$\n\nboss_chest\u0018\u0014 \u0001(\u000b2\u000e.BossChestInfoH��\u0012*\n\rblossom_chest\u0018) \u0001(\u000b2\u0011.BlossomChestInfoH��\u0012+\n\u000emp_play_reward\u0018* \u0001(\u000b2\u0011.MpPlayRewardInfoH��\u00122\n\u000egeneral_reward\u0018+ \u0001(\u000b2\u0018.GadgetGeneralRewardInfoH��\u0012&\n\roffering_info\u0018, \u0001(\u000b2\r.OfferingInfoH��\u0012*\n\u000ffoundation_info\u0018- \u0001(\u000b2\u000f.FoundationInfoH��\u0012$\n\fvehicle_info\u0018. \u0001(\u000b2\f.VehicleInfoH��\u0012$\n\nshell_info\u0018/ \u0001(\u000b2\u000e.EchoShellInfoH��\u0012\"\n\u000bscreen_info\u00180 \u0001(\u000b2\u000b.ScreenInfoH��\u0012'\n\u000efish_pool_info\u0018; \u0001(\u000b2\r.FishPoolInfoH��\u00128\n\u0017custom_gadget_tree_info\u0018< \u0001(\u000b2\u0015.CustomGadgetTreeInfoH��\u00125\n\u0015roguelike_gadget_info\u0018= \u0001(\u000b2\u0014.RoguelikeGadgetInfoH��\u00126\n\u0016night_crow_gadget_info\u0018> \u0001(\u000b2\u0014.NightCrowGadgetInfoH��\u0012@\n\u001bdeshret_obelisk_gadget_info\u0018? \u0001(\u000b2\u0019.DeshretObeliskGadgetInfoH��\u0012>\n\u001acoin_collect_operator_info\u0018@ \u0001(\u000b2\u0018.CoinCollectOperatorInfoH��B\t\n\u0007contentB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityGadgetInfoOuterClass.getDescriptor(), BlossomChestInfoOuterClass.getDescriptor(), BossChestInfoOuterClass.getDescriptor(), ClientGadgetInfoOuterClass.getDescriptor(), CoinCollectOperatorInfoOuterClass.getDescriptor(), CustomGadgetTreeInfoOuterClass.getDescriptor(), DeshretObeliskGadgetInfoOuterClass.getDescriptor(), EchoShellInfoOuterClass.getDescriptor(), FishPoolInfoOuterClass.getDescriptor(), FoundationInfoOuterClass.getDescriptor(), GadgetBornTypeOuterClass.getDescriptor(), GadgetGeneralRewardInfoOuterClass.getDescriptor(), GadgetPlayInfoOuterClass.getDescriptor(), GatherGadgetInfoOuterClass.getDescriptor(), ItemOuterClass.getDescriptor(), MpPlayRewardInfoOuterClass.getDescriptor(), NightCrowGadgetInfoOuterClass.getDescriptor(), OfferingInfoOuterClass.getDescriptor(), PlatformInfoOuterClass.getDescriptor(), RoguelikeGadgetInfoOuterClass.getDescriptor(), ScreenInfoOuterClass.getDescriptor(), StatueGadgetInfoOuterClass.getDescriptor(), VehicleInfoOuterClass.getDescriptor(), WeatherInfoOuterClass.getDescriptor(), WorktopInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneGadgetInfo_descriptor, new String[]{"GadgetId", "GroupId", "ConfigId", "OwnerEntityId", "BornType", "GadgetState", "GadgetType", "IsShowCutscene", "AuthorityPeerId", "IsEnableInteract", "InteractId", "MarkFlag", "PropOwnerEntityId", "Platform", "InteractUidList", "DraftId", "GadgetTalkState", "PlayInfo", "TrifleItem", "GatherGadget", "Worktop", "ClientGadget", "Weather", "AbilityGadget", "StatueGadget", "BossChest", "BlossomChest", "MpPlayReward", "GeneralReward", "OfferingInfo", "FoundationInfo", "VehicleInfo", "ShellInfo", "ScreenInfo", "FishPoolInfo", "CustomGadgetTreeInfo", "RoguelikeGadgetInfo", "NightCrowGadgetInfo", "DeshretObeliskGadgetInfo", "CoinCollectOperatorInfo", "Content"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGadgetInfoOuterClass$SceneGadgetInfoOrBuilder.class */
    public interface SceneGadgetInfoOrBuilder extends MessageOrBuilder {
        int getGadgetId();

        int getGroupId();

        int getConfigId();

        int getOwnerEntityId();

        int getBornTypeValue();

        GadgetBornTypeOuterClass.GadgetBornType getBornType();

        int getGadgetState();

        int getGadgetType();

        boolean getIsShowCutscene();

        int getAuthorityPeerId();

        boolean getIsEnableInteract();

        int getInteractId();

        int getMarkFlag();

        int getPropOwnerEntityId();

        boolean hasPlatform();

        PlatformInfoOuterClass.PlatformInfo getPlatform();

        PlatformInfoOuterClass.PlatformInfoOrBuilder getPlatformOrBuilder();

        List<Integer> getInteractUidListList();

        int getInteractUidListCount();

        int getInteractUidList(int i);

        int getDraftId();

        int getGadgetTalkState();

        boolean hasPlayInfo();

        GadgetPlayInfoOuterClass.GadgetPlayInfo getPlayInfo();

        GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder getPlayInfoOrBuilder();

        boolean hasTrifleItem();

        ItemOuterClass.Item getTrifleItem();

        ItemOuterClass.ItemOrBuilder getTrifleItemOrBuilder();

        boolean hasGatherGadget();

        GatherGadgetInfoOuterClass.GatherGadgetInfo getGatherGadget();

        GatherGadgetInfoOuterClass.GatherGadgetInfoOrBuilder getGatherGadgetOrBuilder();

        boolean hasWorktop();

        WorktopInfoOuterClass.WorktopInfo getWorktop();

        WorktopInfoOuterClass.WorktopInfoOrBuilder getWorktopOrBuilder();

        boolean hasClientGadget();

        ClientGadgetInfoOuterClass.ClientGadgetInfo getClientGadget();

        ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder getClientGadgetOrBuilder();

        boolean hasWeather();

        WeatherInfoOuterClass.WeatherInfo getWeather();

        WeatherInfoOuterClass.WeatherInfoOrBuilder getWeatherOrBuilder();

        boolean hasAbilityGadget();

        AbilityGadgetInfoOuterClass.AbilityGadgetInfo getAbilityGadget();

        AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder getAbilityGadgetOrBuilder();

        boolean hasStatueGadget();

        StatueGadgetInfoOuterClass.StatueGadgetInfo getStatueGadget();

        StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder getStatueGadgetOrBuilder();

        boolean hasBossChest();

        BossChestInfoOuterClass.BossChestInfo getBossChest();

        BossChestInfoOuterClass.BossChestInfoOrBuilder getBossChestOrBuilder();

        boolean hasBlossomChest();

        BlossomChestInfoOuterClass.BlossomChestInfo getBlossomChest();

        BlossomChestInfoOuterClass.BlossomChestInfoOrBuilder getBlossomChestOrBuilder();

        boolean hasMpPlayReward();

        MpPlayRewardInfoOuterClass.MpPlayRewardInfo getMpPlayReward();

        MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder getMpPlayRewardOrBuilder();

        boolean hasGeneralReward();

        GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo getGeneralReward();

        GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder getGeneralRewardOrBuilder();

        boolean hasOfferingInfo();

        OfferingInfoOuterClass.OfferingInfo getOfferingInfo();

        OfferingInfoOuterClass.OfferingInfoOrBuilder getOfferingInfoOrBuilder();

        boolean hasFoundationInfo();

        FoundationInfoOuterClass.FoundationInfo getFoundationInfo();

        FoundationInfoOuterClass.FoundationInfoOrBuilder getFoundationInfoOrBuilder();

        boolean hasVehicleInfo();

        VehicleInfoOuterClass.VehicleInfo getVehicleInfo();

        VehicleInfoOuterClass.VehicleInfoOrBuilder getVehicleInfoOrBuilder();

        boolean hasShellInfo();

        EchoShellInfoOuterClass.EchoShellInfo getShellInfo();

        EchoShellInfoOuterClass.EchoShellInfoOrBuilder getShellInfoOrBuilder();

        boolean hasScreenInfo();

        ScreenInfoOuterClass.ScreenInfo getScreenInfo();

        ScreenInfoOuterClass.ScreenInfoOrBuilder getScreenInfoOrBuilder();

        boolean hasFishPoolInfo();

        FishPoolInfoOuterClass.FishPoolInfo getFishPoolInfo();

        FishPoolInfoOuterClass.FishPoolInfoOrBuilder getFishPoolInfoOrBuilder();

        boolean hasCustomGadgetTreeInfo();

        CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo getCustomGadgetTreeInfo();

        CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder getCustomGadgetTreeInfoOrBuilder();

        boolean hasRoguelikeGadgetInfo();

        RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo getRoguelikeGadgetInfo();

        RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder getRoguelikeGadgetInfoOrBuilder();

        boolean hasNightCrowGadgetInfo();

        NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo getNightCrowGadgetInfo();

        NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder getNightCrowGadgetInfoOrBuilder();

        boolean hasDeshretObeliskGadgetInfo();

        DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo getDeshretObeliskGadgetInfo();

        DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfoOrBuilder getDeshretObeliskGadgetInfoOrBuilder();

        boolean hasCoinCollectOperatorInfo();

        CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo getCoinCollectOperatorInfo();

        CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfoOrBuilder getCoinCollectOperatorInfoOrBuilder();

        SceneGadgetInfo.ContentCase getContentCase();
    }

    private SceneGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGadgetInfoOuterClass$SceneGadgetInfo.class */
    public static final class SceneGadgetInfo extends GeneratedMessageV3 implements SceneGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int contentCase_;
        private Object content_;
        public static final int GADGET_ID_FIELD_NUMBER = 1;
        private int gadgetId_;
        public static final int GROUP_ID_FIELD_NUMBER = 2;
        private int groupId_;
        public static final int CONFIG_ID_FIELD_NUMBER = 3;
        private int configId_;
        public static final int OWNER_ENTITY_ID_FIELD_NUMBER = 4;
        private int ownerEntityId_;
        public static final int BORN_TYPE_FIELD_NUMBER = 5;
        private int bornType_;
        public static final int GADGET_STATE_FIELD_NUMBER = 6;
        private int gadgetState_;
        public static final int GADGET_TYPE_FIELD_NUMBER = 7;
        private int gadgetType_;
        public static final int IS_SHOW_CUTSCENE_FIELD_NUMBER = 8;
        private boolean isShowCutscene_;
        public static final int AUTHORITY_PEER_ID_FIELD_NUMBER = 9;
        private int authorityPeerId_;
        public static final int IS_ENABLE_INTERACT_FIELD_NUMBER = 10;
        private boolean isEnableInteract_;
        public static final int INTERACT_ID_FIELD_NUMBER = 11;
        private int interactId_;
        public static final int MARK_FLAG_FIELD_NUMBER = 21;
        private int markFlag_;
        public static final int PROP_OWNER_ENTITY_ID_FIELD_NUMBER = 22;
        private int propOwnerEntityId_;
        public static final int PLATFORM_FIELD_NUMBER = 23;
        private PlatformInfoOuterClass.PlatformInfo platform_;
        public static final int INTERACT_UID_LIST_FIELD_NUMBER = 24;
        private Internal.IntList interactUidList_;
        private int interactUidListMemoizedSerializedSize;
        public static final int DRAFT_ID_FIELD_NUMBER = 25;
        private int draftId_;
        public static final int GADGET_TALK_STATE_FIELD_NUMBER = 26;
        private int gadgetTalkState_;
        public static final int PLAY_INFO_FIELD_NUMBER = 100;
        private GadgetPlayInfoOuterClass.GadgetPlayInfo playInfo_;
        public static final int TRIFLE_ITEM_FIELD_NUMBER = 12;
        public static final int GATHER_GADGET_FIELD_NUMBER = 13;
        public static final int WORKTOP_FIELD_NUMBER = 14;
        public static final int CLIENT_GADGET_FIELD_NUMBER = 15;
        public static final int WEATHER_FIELD_NUMBER = 17;
        public static final int ABILITY_GADGET_FIELD_NUMBER = 18;
        public static final int STATUE_GADGET_FIELD_NUMBER = 19;
        public static final int BOSS_CHEST_FIELD_NUMBER = 20;
        public static final int BLOSSOM_CHEST_FIELD_NUMBER = 41;
        public static final int MP_PLAY_REWARD_FIELD_NUMBER = 42;
        public static final int GENERAL_REWARD_FIELD_NUMBER = 43;
        public static final int OFFERING_INFO_FIELD_NUMBER = 44;
        public static final int FOUNDATION_INFO_FIELD_NUMBER = 45;
        public static final int VEHICLE_INFO_FIELD_NUMBER = 46;
        public static final int SHELL_INFO_FIELD_NUMBER = 47;
        public static final int SCREEN_INFO_FIELD_NUMBER = 48;
        public static final int FISH_POOL_INFO_FIELD_NUMBER = 59;
        public static final int CUSTOM_GADGET_TREE_INFO_FIELD_NUMBER = 60;
        public static final int ROGUELIKE_GADGET_INFO_FIELD_NUMBER = 61;
        public static final int NIGHT_CROW_GADGET_INFO_FIELD_NUMBER = 62;
        public static final int DESHRET_OBELISK_GADGET_INFO_FIELD_NUMBER = 63;
        public static final int COIN_COLLECT_OPERATOR_INFO_FIELD_NUMBER = 64;
        private byte memoizedIsInitialized;
        private static final SceneGadgetInfo DEFAULT_INSTANCE = new SceneGadgetInfo();
        private static final Parser<SceneGadgetInfo> PARSER = new AbstractParser<SceneGadgetInfo>() { // from class: emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public SceneGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneGadgetInfo(input, extensionRegistry);
            }
        };

        private SceneGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.contentCase_ = 0;
            this.interactUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SceneGadgetInfo() {
            this.contentCase_ = 0;
            this.interactUidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.bornType_ = 0;
            this.interactUidList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.gadgetId_ = input.readUInt32();
                                break;
                            case 16:
                                this.groupId_ = input.readUInt32();
                                break;
                            case 24:
                                this.configId_ = input.readUInt32();
                                break;
                            case 32:
                                this.ownerEntityId_ = input.readUInt32();
                                break;
                            case 40:
                                this.bornType_ = input.readEnum();
                                break;
                            case 48:
                                this.gadgetState_ = input.readUInt32();
                                break;
                            case 56:
                                this.gadgetType_ = input.readUInt32();
                                break;
                            case 64:
                                this.isShowCutscene_ = input.readBool();
                                break;
                            case 72:
                                this.authorityPeerId_ = input.readUInt32();
                                break;
                            case 80:
                                this.isEnableInteract_ = input.readBool();
                                break;
                            case 88:
                                this.interactId_ = input.readUInt32();
                                break;
                            case 98:
                                ItemOuterClass.Item.Builder subBuilder = this.contentCase_ == 12 ? ((ItemOuterClass.Item) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(ItemOuterClass.Item.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((ItemOuterClass.Item) this.content_);
                                    this.content_ = subBuilder.buildPartial();
                                }
                                this.contentCase_ = 12;
                                break;
                            case 106:
                                GatherGadgetInfoOuterClass.GatherGadgetInfo.Builder subBuilder2 = this.contentCase_ == 13 ? ((GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(GatherGadgetInfoOuterClass.GatherGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_);
                                    this.content_ = subBuilder2.buildPartial();
                                }
                                this.contentCase_ = 13;
                                break;
                            case 114:
                                WorktopInfoOuterClass.WorktopInfo.Builder subBuilder3 = this.contentCase_ == 14 ? ((WorktopInfoOuterClass.WorktopInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(WorktopInfoOuterClass.WorktopInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((WorktopInfoOuterClass.WorktopInfo) this.content_);
                                    this.content_ = subBuilder3.buildPartial();
                                }
                                this.contentCase_ = 14;
                                break;
                            case 122:
                                ClientGadgetInfoOuterClass.ClientGadgetInfo.Builder subBuilder4 = this.contentCase_ == 15 ? ((ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(ClientGadgetInfoOuterClass.ClientGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_);
                                    this.content_ = subBuilder4.buildPartial();
                                }
                                this.contentCase_ = 15;
                                break;
                            case 138:
                                WeatherInfoOuterClass.WeatherInfo.Builder subBuilder5 = this.contentCase_ == 17 ? ((WeatherInfoOuterClass.WeatherInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(WeatherInfoOuterClass.WeatherInfo.parser(), extensionRegistry);
                                if (subBuilder5 != null) {
                                    subBuilder5.mergeFrom((WeatherInfoOuterClass.WeatherInfo) this.content_);
                                    this.content_ = subBuilder5.buildPartial();
                                }
                                this.contentCase_ = 17;
                                break;
                            case 146:
                                AbilityGadgetInfoOuterClass.AbilityGadgetInfo.Builder subBuilder6 = this.contentCase_ == 18 ? ((AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(AbilityGadgetInfoOuterClass.AbilityGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder6 != null) {
                                    subBuilder6.mergeFrom((AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_);
                                    this.content_ = subBuilder6.buildPartial();
                                }
                                this.contentCase_ = 18;
                                break;
                            case 154:
                                StatueGadgetInfoOuterClass.StatueGadgetInfo.Builder subBuilder7 = this.contentCase_ == 19 ? ((StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(StatueGadgetInfoOuterClass.StatueGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder7 != null) {
                                    subBuilder7.mergeFrom((StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_);
                                    this.content_ = subBuilder7.buildPartial();
                                }
                                this.contentCase_ = 19;
                                break;
                            case 162:
                                BossChestInfoOuterClass.BossChestInfo.Builder subBuilder8 = this.contentCase_ == 20 ? ((BossChestInfoOuterClass.BossChestInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(BossChestInfoOuterClass.BossChestInfo.parser(), extensionRegistry);
                                if (subBuilder8 != null) {
                                    subBuilder8.mergeFrom((BossChestInfoOuterClass.BossChestInfo) this.content_);
                                    this.content_ = subBuilder8.buildPartial();
                                }
                                this.contentCase_ = 20;
                                break;
                            case 168:
                                this.markFlag_ = input.readUInt32();
                                break;
                            case 176:
                                this.propOwnerEntityId_ = input.readUInt32();
                                break;
                            case 186:
                                PlatformInfoOuterClass.PlatformInfo.Builder subBuilder9 = this.platform_ != null ? this.platform_.toBuilder() : null;
                                this.platform_ = (PlatformInfoOuterClass.PlatformInfo) input.readMessage(PlatformInfoOuterClass.PlatformInfo.parser(), extensionRegistry);
                                if (subBuilder9 == null) {
                                    break;
                                } else {
                                    subBuilder9.mergeFrom(this.platform_);
                                    this.platform_ = subBuilder9.buildPartial();
                                    break;
                                }
                            case 192:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.interactUidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.interactUidList_.addInt(input.readUInt32());
                                break;
                            case 194:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.interactUidList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.interactUidList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 200:
                                this.draftId_ = input.readUInt32();
                                break;
                            case PacketOpcodes.PlatformStartRouteNotify:
                                this.gadgetTalkState_ = input.readUInt32();
                                break;
                            case 330:
                                BlossomChestInfoOuterClass.BlossomChestInfo.Builder subBuilder10 = this.contentCase_ == 41 ? ((BlossomChestInfoOuterClass.BlossomChestInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(BlossomChestInfoOuterClass.BlossomChestInfo.parser(), extensionRegistry);
                                if (subBuilder10 != null) {
                                    subBuilder10.mergeFrom((BlossomChestInfoOuterClass.BlossomChestInfo) this.content_);
                                    this.content_ = subBuilder10.buildPartial();
                                }
                                this.contentCase_ = 41;
                                break;
                            case TokenId.SYNCHRONIZED /* 338 */:
                                MpPlayRewardInfoOuterClass.MpPlayRewardInfo.Builder subBuilder11 = this.contentCase_ == 42 ? ((MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(MpPlayRewardInfoOuterClass.MpPlayRewardInfo.parser(), extensionRegistry);
                                if (subBuilder11 != null) {
                                    subBuilder11.mergeFrom((MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_);
                                    this.content_ = subBuilder11.buildPartial();
                                }
                                this.contentCase_ = 42;
                                break;
                            case 346:
                                GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.Builder subBuilder12 = this.contentCase_ == 43 ? ((GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.parser(), extensionRegistry);
                                if (subBuilder12 != null) {
                                    subBuilder12.mergeFrom((GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_);
                                    this.content_ = subBuilder12.buildPartial();
                                }
                                this.contentCase_ = 43;
                                break;
                            case 354:
                                OfferingInfoOuterClass.OfferingInfo.Builder subBuilder13 = this.contentCase_ == 44 ? ((OfferingInfoOuterClass.OfferingInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(OfferingInfoOuterClass.OfferingInfo.parser(), extensionRegistry);
                                if (subBuilder13 != null) {
                                    subBuilder13.mergeFrom((OfferingInfoOuterClass.OfferingInfo) this.content_);
                                    this.content_ = subBuilder13.buildPartial();
                                }
                                this.contentCase_ = 44;
                                break;
                            case TokenId.PLUSPLUS /* 362 */:
                                FoundationInfoOuterClass.FoundationInfo.Builder subBuilder14 = this.contentCase_ == 45 ? ((FoundationInfoOuterClass.FoundationInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(FoundationInfoOuterClass.FoundationInfo.parser(), extensionRegistry);
                                if (subBuilder14 != null) {
                                    subBuilder14.mergeFrom((FoundationInfoOuterClass.FoundationInfo) this.content_);
                                    this.content_ = subBuilder14.buildPartial();
                                }
                                this.contentCase_ = 45;
                                break;
                            case 370:
                                VehicleInfoOuterClass.VehicleInfo.Builder subBuilder15 = this.contentCase_ == 46 ? ((VehicleInfoOuterClass.VehicleInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(VehicleInfoOuterClass.VehicleInfo.parser(), extensionRegistry);
                                if (subBuilder15 != null) {
                                    subBuilder15.mergeFrom((VehicleInfoOuterClass.VehicleInfo) this.content_);
                                    this.content_ = subBuilder15.buildPartial();
                                }
                                this.contentCase_ = 46;
                                break;
                            case 378:
                                EchoShellInfoOuterClass.EchoShellInfo.Builder subBuilder16 = this.contentCase_ == 47 ? ((EchoShellInfoOuterClass.EchoShellInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(EchoShellInfoOuterClass.EchoShellInfo.parser(), extensionRegistry);
                                if (subBuilder16 != null) {
                                    subBuilder16.mergeFrom((EchoShellInfoOuterClass.EchoShellInfo) this.content_);
                                    this.content_ = subBuilder16.buildPartial();
                                }
                                this.contentCase_ = 47;
                                break;
                            case 386:
                                ScreenInfoOuterClass.ScreenInfo.Builder subBuilder17 = this.contentCase_ == 48 ? ((ScreenInfoOuterClass.ScreenInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(ScreenInfoOuterClass.ScreenInfo.parser(), extensionRegistry);
                                if (subBuilder17 != null) {
                                    subBuilder17.mergeFrom((ScreenInfoOuterClass.ScreenInfo) this.content_);
                                    this.content_ = subBuilder17.buildPartial();
                                }
                                this.contentCase_ = 48;
                                break;
                            case 474:
                                FishPoolInfoOuterClass.FishPoolInfo.Builder subBuilder18 = this.contentCase_ == 59 ? ((FishPoolInfoOuterClass.FishPoolInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(FishPoolInfoOuterClass.FishPoolInfo.parser(), extensionRegistry);
                                if (subBuilder18 != null) {
                                    subBuilder18.mergeFrom((FishPoolInfoOuterClass.FishPoolInfo) this.content_);
                                    this.content_ = subBuilder18.buildPartial();
                                }
                                this.contentCase_ = 59;
                                break;
                            case PacketOpcodes.QuestUpdateQuestTimeVarNotify:
                                CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.Builder subBuilder19 = this.contentCase_ == 60 ? ((CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.parser(), extensionRegistry);
                                if (subBuilder19 != null) {
                                    subBuilder19.mergeFrom((CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_);
                                    this.content_ = subBuilder19.buildPartial();
                                }
                                this.contentCase_ = 60;
                                break;
                            case PacketOpcodes.QuestProgressUpdateNotify:
                                RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.Builder subBuilder20 = this.contentCase_ == 61 ? ((RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder20 != null) {
                                    subBuilder20.mergeFrom((RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_);
                                    this.content_ = subBuilder20.buildPartial();
                                }
                                this.contentCase_ = 61;
                                break;
                            case PacketOpcodes.InterpretInferenceWordRsp:
                                NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.Builder subBuilder21 = this.contentCase_ == 62 ? ((NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder21 != null) {
                                    subBuilder21.mergeFrom((NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_);
                                    this.content_ = subBuilder21.buildPartial();
                                }
                                this.contentCase_ = 62;
                                break;
                            case RET_PLAYER_IS_ENTER_SCENE_VALUE:
                                DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.Builder subBuilder22 = this.contentCase_ == 63 ? ((DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.parser(), extensionRegistry);
                                if (subBuilder22 != null) {
                                    subBuilder22.mergeFrom((DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_);
                                    this.content_ = subBuilder22.buildPartial();
                                }
                                this.contentCase_ = 63;
                                break;
                            case 514:
                                CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.Builder subBuilder23 = this.contentCase_ == 64 ? ((CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_).toBuilder() : null;
                                this.content_ = input.readMessage(CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.parser(), extensionRegistry);
                                if (subBuilder23 != null) {
                                    subBuilder23.mergeFrom((CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_);
                                    this.content_ = subBuilder23.buildPartial();
                                }
                                this.contentCase_ = 64;
                                break;
                            case RET_GADGET_NOT_INTERACTIVE_VALUE:
                                GadgetPlayInfoOuterClass.GadgetPlayInfo.Builder subBuilder24 = this.playInfo_ != null ? this.playInfo_.toBuilder() : null;
                                this.playInfo_ = (GadgetPlayInfoOuterClass.GadgetPlayInfo) input.readMessage(GadgetPlayInfoOuterClass.GadgetPlayInfo.parser(), extensionRegistry);
                                if (subBuilder24 == null) {
                                    break;
                                } else {
                                    subBuilder24.mergeFrom(this.playInfo_);
                                    this.playInfo_ = subBuilder24.buildPartial();
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.interactUidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneGadgetInfoOuterClass.internal_static_SceneGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneGadgetInfoOuterClass.internal_static_SceneGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneGadgetInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGadgetInfoOuterClass$SceneGadgetInfo$ContentCase.class */
        public enum ContentCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            TRIFLE_ITEM(12),
            GATHER_GADGET(13),
            WORKTOP(14),
            CLIENT_GADGET(15),
            WEATHER(17),
            ABILITY_GADGET(18),
            STATUE_GADGET(19),
            BOSS_CHEST(20),
            BLOSSOM_CHEST(41),
            MP_PLAY_REWARD(42),
            GENERAL_REWARD(43),
            OFFERING_INFO(44),
            FOUNDATION_INFO(45),
            VEHICLE_INFO(46),
            SHELL_INFO(47),
            SCREEN_INFO(48),
            FISH_POOL_INFO(59),
            CUSTOM_GADGET_TREE_INFO(60),
            ROGUELIKE_GADGET_INFO(61),
            NIGHT_CROW_GADGET_INFO(62),
            DESHRET_OBELISK_GADGET_INFO(63),
            COIN_COLLECT_OPERATOR_INFO(64),
            CONTENT_NOT_SET(0);
            
            private final int value;

            ContentCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ContentCase valueOf(int value) {
                return forNumber(value);
            }

            public static ContentCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return CONTENT_NOT_SET;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 16:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    default:
                        return null;
                    case 12:
                        return TRIFLE_ITEM;
                    case 13:
                        return GATHER_GADGET;
                    case 14:
                        return WORKTOP;
                    case 15:
                        return CLIENT_GADGET;
                    case 17:
                        return WEATHER;
                    case 18:
                        return ABILITY_GADGET;
                    case 19:
                        return STATUE_GADGET;
                    case 20:
                        return BOSS_CHEST;
                    case 41:
                        return BLOSSOM_CHEST;
                    case 42:
                        return MP_PLAY_REWARD;
                    case 43:
                        return GENERAL_REWARD;
                    case 44:
                        return OFFERING_INFO;
                    case 45:
                        return FOUNDATION_INFO;
                    case 46:
                        return VEHICLE_INFO;
                    case 47:
                        return SHELL_INFO;
                    case 48:
                        return SCREEN_INFO;
                    case 59:
                        return FISH_POOL_INFO;
                    case 60:
                        return CUSTOM_GADGET_TREE_INFO;
                    case 61:
                        return ROGUELIKE_GADGET_INFO;
                    case 62:
                        return NIGHT_CROW_GADGET_INFO;
                    case 63:
                        return DESHRET_OBELISK_GADGET_INFO;
                    case 64:
                        return COIN_COLLECT_OPERATOR_INFO;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ContentCase getContentCase() {
            return ContentCase.forNumber(this.contentCase_);
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getOwnerEntityId() {
            return this.ownerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getBornTypeValue() {
            return this.bornType_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GadgetBornTypeOuterClass.GadgetBornType getBornType() {
            GadgetBornTypeOuterClass.GadgetBornType result = GadgetBornTypeOuterClass.GadgetBornType.valueOf(this.bornType_);
            return result == null ? GadgetBornTypeOuterClass.GadgetBornType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getGadgetState() {
            return this.gadgetState_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getGadgetType() {
            return this.gadgetType_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean getIsShowCutscene() {
            return this.isShowCutscene_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getAuthorityPeerId() {
            return this.authorityPeerId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean getIsEnableInteract() {
            return this.isEnableInteract_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getInteractId() {
            return this.interactId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getMarkFlag() {
            return this.markFlag_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getPropOwnerEntityId() {
            return this.propOwnerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasPlatform() {
            return this.platform_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public PlatformInfoOuterClass.PlatformInfo getPlatform() {
            return this.platform_ == null ? PlatformInfoOuterClass.PlatformInfo.getDefaultInstance() : this.platform_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public PlatformInfoOuterClass.PlatformInfoOrBuilder getPlatformOrBuilder() {
            return getPlatform();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public List<Integer> getInteractUidListList() {
            return this.interactUidList_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getInteractUidListCount() {
            return this.interactUidList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getInteractUidList(int index) {
            return this.interactUidList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getDraftId() {
            return this.draftId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public int getGadgetTalkState() {
            return this.gadgetTalkState_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasPlayInfo() {
            return this.playInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GadgetPlayInfoOuterClass.GadgetPlayInfo getPlayInfo() {
            return this.playInfo_ == null ? GadgetPlayInfoOuterClass.GadgetPlayInfo.getDefaultInstance() : this.playInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder getPlayInfoOrBuilder() {
            return getPlayInfo();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasTrifleItem() {
            return this.contentCase_ == 12;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ItemOuterClass.Item getTrifleItem() {
            if (this.contentCase_ == 12) {
                return (ItemOuterClass.Item) this.content_;
            }
            return ItemOuterClass.Item.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ItemOuterClass.ItemOrBuilder getTrifleItemOrBuilder() {
            if (this.contentCase_ == 12) {
                return (ItemOuterClass.Item) this.content_;
            }
            return ItemOuterClass.Item.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasGatherGadget() {
            return this.contentCase_ == 13;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GatherGadgetInfoOuterClass.GatherGadgetInfo getGatherGadget() {
            if (this.contentCase_ == 13) {
                return (GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_;
            }
            return GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GatherGadgetInfoOuterClass.GatherGadgetInfoOrBuilder getGatherGadgetOrBuilder() {
            if (this.contentCase_ == 13) {
                return (GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_;
            }
            return GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasWorktop() {
            return this.contentCase_ == 14;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public WorktopInfoOuterClass.WorktopInfo getWorktop() {
            if (this.contentCase_ == 14) {
                return (WorktopInfoOuterClass.WorktopInfo) this.content_;
            }
            return WorktopInfoOuterClass.WorktopInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public WorktopInfoOuterClass.WorktopInfoOrBuilder getWorktopOrBuilder() {
            if (this.contentCase_ == 14) {
                return (WorktopInfoOuterClass.WorktopInfo) this.content_;
            }
            return WorktopInfoOuterClass.WorktopInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasClientGadget() {
            return this.contentCase_ == 15;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ClientGadgetInfoOuterClass.ClientGadgetInfo getClientGadget() {
            if (this.contentCase_ == 15) {
                return (ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_;
            }
            return ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder getClientGadgetOrBuilder() {
            if (this.contentCase_ == 15) {
                return (ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_;
            }
            return ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasWeather() {
            return this.contentCase_ == 17;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public WeatherInfoOuterClass.WeatherInfo getWeather() {
            if (this.contentCase_ == 17) {
                return (WeatherInfoOuterClass.WeatherInfo) this.content_;
            }
            return WeatherInfoOuterClass.WeatherInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public WeatherInfoOuterClass.WeatherInfoOrBuilder getWeatherOrBuilder() {
            if (this.contentCase_ == 17) {
                return (WeatherInfoOuterClass.WeatherInfo) this.content_;
            }
            return WeatherInfoOuterClass.WeatherInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasAbilityGadget() {
            return this.contentCase_ == 18;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public AbilityGadgetInfoOuterClass.AbilityGadgetInfo getAbilityGadget() {
            if (this.contentCase_ == 18) {
                return (AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_;
            }
            return AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder getAbilityGadgetOrBuilder() {
            if (this.contentCase_ == 18) {
                return (AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_;
            }
            return AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasStatueGadget() {
            return this.contentCase_ == 19;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public StatueGadgetInfoOuterClass.StatueGadgetInfo getStatueGadget() {
            if (this.contentCase_ == 19) {
                return (StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_;
            }
            return StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder getStatueGadgetOrBuilder() {
            if (this.contentCase_ == 19) {
                return (StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_;
            }
            return StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasBossChest() {
            return this.contentCase_ == 20;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public BossChestInfoOuterClass.BossChestInfo getBossChest() {
            if (this.contentCase_ == 20) {
                return (BossChestInfoOuterClass.BossChestInfo) this.content_;
            }
            return BossChestInfoOuterClass.BossChestInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public BossChestInfoOuterClass.BossChestInfoOrBuilder getBossChestOrBuilder() {
            if (this.contentCase_ == 20) {
                return (BossChestInfoOuterClass.BossChestInfo) this.content_;
            }
            return BossChestInfoOuterClass.BossChestInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasBlossomChest() {
            return this.contentCase_ == 41;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public BlossomChestInfoOuterClass.BlossomChestInfo getBlossomChest() {
            if (this.contentCase_ == 41) {
                return (BlossomChestInfoOuterClass.BlossomChestInfo) this.content_;
            }
            return BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public BlossomChestInfoOuterClass.BlossomChestInfoOrBuilder getBlossomChestOrBuilder() {
            if (this.contentCase_ == 41) {
                return (BlossomChestInfoOuterClass.BlossomChestInfo) this.content_;
            }
            return BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasMpPlayReward() {
            return this.contentCase_ == 42;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public MpPlayRewardInfoOuterClass.MpPlayRewardInfo getMpPlayReward() {
            if (this.contentCase_ == 42) {
                return (MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_;
            }
            return MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder getMpPlayRewardOrBuilder() {
            if (this.contentCase_ == 42) {
                return (MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_;
            }
            return MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasGeneralReward() {
            return this.contentCase_ == 43;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo getGeneralReward() {
            if (this.contentCase_ == 43) {
                return (GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_;
            }
            return GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder getGeneralRewardOrBuilder() {
            if (this.contentCase_ == 43) {
                return (GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_;
            }
            return GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasOfferingInfo() {
            return this.contentCase_ == 44;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public OfferingInfoOuterClass.OfferingInfo getOfferingInfo() {
            if (this.contentCase_ == 44) {
                return (OfferingInfoOuterClass.OfferingInfo) this.content_;
            }
            return OfferingInfoOuterClass.OfferingInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public OfferingInfoOuterClass.OfferingInfoOrBuilder getOfferingInfoOrBuilder() {
            if (this.contentCase_ == 44) {
                return (OfferingInfoOuterClass.OfferingInfo) this.content_;
            }
            return OfferingInfoOuterClass.OfferingInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasFoundationInfo() {
            return this.contentCase_ == 45;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public FoundationInfoOuterClass.FoundationInfo getFoundationInfo() {
            if (this.contentCase_ == 45) {
                return (FoundationInfoOuterClass.FoundationInfo) this.content_;
            }
            return FoundationInfoOuterClass.FoundationInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public FoundationInfoOuterClass.FoundationInfoOrBuilder getFoundationInfoOrBuilder() {
            if (this.contentCase_ == 45) {
                return (FoundationInfoOuterClass.FoundationInfo) this.content_;
            }
            return FoundationInfoOuterClass.FoundationInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasVehicleInfo() {
            return this.contentCase_ == 46;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public VehicleInfoOuterClass.VehicleInfo getVehicleInfo() {
            if (this.contentCase_ == 46) {
                return (VehicleInfoOuterClass.VehicleInfo) this.content_;
            }
            return VehicleInfoOuterClass.VehicleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public VehicleInfoOuterClass.VehicleInfoOrBuilder getVehicleInfoOrBuilder() {
            if (this.contentCase_ == 46) {
                return (VehicleInfoOuterClass.VehicleInfo) this.content_;
            }
            return VehicleInfoOuterClass.VehicleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasShellInfo() {
            return this.contentCase_ == 47;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public EchoShellInfoOuterClass.EchoShellInfo getShellInfo() {
            if (this.contentCase_ == 47) {
                return (EchoShellInfoOuterClass.EchoShellInfo) this.content_;
            }
            return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public EchoShellInfoOuterClass.EchoShellInfoOrBuilder getShellInfoOrBuilder() {
            if (this.contentCase_ == 47) {
                return (EchoShellInfoOuterClass.EchoShellInfo) this.content_;
            }
            return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasScreenInfo() {
            return this.contentCase_ == 48;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ScreenInfoOuterClass.ScreenInfo getScreenInfo() {
            if (this.contentCase_ == 48) {
                return (ScreenInfoOuterClass.ScreenInfo) this.content_;
            }
            return ScreenInfoOuterClass.ScreenInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public ScreenInfoOuterClass.ScreenInfoOrBuilder getScreenInfoOrBuilder() {
            if (this.contentCase_ == 48) {
                return (ScreenInfoOuterClass.ScreenInfo) this.content_;
            }
            return ScreenInfoOuterClass.ScreenInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasFishPoolInfo() {
            return this.contentCase_ == 59;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public FishPoolInfoOuterClass.FishPoolInfo getFishPoolInfo() {
            if (this.contentCase_ == 59) {
                return (FishPoolInfoOuterClass.FishPoolInfo) this.content_;
            }
            return FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public FishPoolInfoOuterClass.FishPoolInfoOrBuilder getFishPoolInfoOrBuilder() {
            if (this.contentCase_ == 59) {
                return (FishPoolInfoOuterClass.FishPoolInfo) this.content_;
            }
            return FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasCustomGadgetTreeInfo() {
            return this.contentCase_ == 60;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo getCustomGadgetTreeInfo() {
            if (this.contentCase_ == 60) {
                return (CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_;
            }
            return CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder getCustomGadgetTreeInfoOrBuilder() {
            if (this.contentCase_ == 60) {
                return (CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_;
            }
            return CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasRoguelikeGadgetInfo() {
            return this.contentCase_ == 61;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo getRoguelikeGadgetInfo() {
            if (this.contentCase_ == 61) {
                return (RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_;
            }
            return RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder getRoguelikeGadgetInfoOrBuilder() {
            if (this.contentCase_ == 61) {
                return (RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_;
            }
            return RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasNightCrowGadgetInfo() {
            return this.contentCase_ == 62;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo getNightCrowGadgetInfo() {
            if (this.contentCase_ == 62) {
                return (NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_;
            }
            return NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder getNightCrowGadgetInfoOrBuilder() {
            if (this.contentCase_ == 62) {
                return (NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_;
            }
            return NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasDeshretObeliskGadgetInfo() {
            return this.contentCase_ == 63;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo getDeshretObeliskGadgetInfo() {
            if (this.contentCase_ == 63) {
                return (DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_;
            }
            return DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfoOrBuilder getDeshretObeliskGadgetInfoOrBuilder() {
            if (this.contentCase_ == 63) {
                return (DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_;
            }
            return DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public boolean hasCoinCollectOperatorInfo() {
            return this.contentCase_ == 64;
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo getCoinCollectOperatorInfo() {
            if (this.contentCase_ == 64) {
                return (CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_;
            }
            return CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
        public CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfoOrBuilder getCoinCollectOperatorInfoOrBuilder() {
            if (this.contentCase_ == 64) {
                return (CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_;
            }
            return CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance();
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
            if (this.gadgetId_ != 0) {
                output.writeUInt32(1, this.gadgetId_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(2, this.groupId_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(3, this.configId_);
            }
            if (this.ownerEntityId_ != 0) {
                output.writeUInt32(4, this.ownerEntityId_);
            }
            if (this.bornType_ != GadgetBornTypeOuterClass.GadgetBornType.GADGET_BORN_TYPE_NONE.getNumber()) {
                output.writeEnum(5, this.bornType_);
            }
            if (this.gadgetState_ != 0) {
                output.writeUInt32(6, this.gadgetState_);
            }
            if (this.gadgetType_ != 0) {
                output.writeUInt32(7, this.gadgetType_);
            }
            if (this.isShowCutscene_) {
                output.writeBool(8, this.isShowCutscene_);
            }
            if (this.authorityPeerId_ != 0) {
                output.writeUInt32(9, this.authorityPeerId_);
            }
            if (this.isEnableInteract_) {
                output.writeBool(10, this.isEnableInteract_);
            }
            if (this.interactId_ != 0) {
                output.writeUInt32(11, this.interactId_);
            }
            if (this.contentCase_ == 12) {
                output.writeMessage(12, (ItemOuterClass.Item) this.content_);
            }
            if (this.contentCase_ == 13) {
                output.writeMessage(13, (GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 14) {
                output.writeMessage(14, (WorktopInfoOuterClass.WorktopInfo) this.content_);
            }
            if (this.contentCase_ == 15) {
                output.writeMessage(15, (ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 17) {
                output.writeMessage(17, (WeatherInfoOuterClass.WeatherInfo) this.content_);
            }
            if (this.contentCase_ == 18) {
                output.writeMessage(18, (AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 19) {
                output.writeMessage(19, (StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 20) {
                output.writeMessage(20, (BossChestInfoOuterClass.BossChestInfo) this.content_);
            }
            if (this.markFlag_ != 0) {
                output.writeUInt32(21, this.markFlag_);
            }
            if (this.propOwnerEntityId_ != 0) {
                output.writeUInt32(22, this.propOwnerEntityId_);
            }
            if (this.platform_ != null) {
                output.writeMessage(23, getPlatform());
            }
            if (getInteractUidListList().size() > 0) {
                output.writeUInt32NoTag(194);
                output.writeUInt32NoTag(this.interactUidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.interactUidList_.size(); i++) {
                output.writeUInt32NoTag(this.interactUidList_.getInt(i));
            }
            if (this.draftId_ != 0) {
                output.writeUInt32(25, this.draftId_);
            }
            if (this.gadgetTalkState_ != 0) {
                output.writeUInt32(26, this.gadgetTalkState_);
            }
            if (this.contentCase_ == 41) {
                output.writeMessage(41, (BlossomChestInfoOuterClass.BlossomChestInfo) this.content_);
            }
            if (this.contentCase_ == 42) {
                output.writeMessage(42, (MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_);
            }
            if (this.contentCase_ == 43) {
                output.writeMessage(43, (GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_);
            }
            if (this.contentCase_ == 44) {
                output.writeMessage(44, (OfferingInfoOuterClass.OfferingInfo) this.content_);
            }
            if (this.contentCase_ == 45) {
                output.writeMessage(45, (FoundationInfoOuterClass.FoundationInfo) this.content_);
            }
            if (this.contentCase_ == 46) {
                output.writeMessage(46, (VehicleInfoOuterClass.VehicleInfo) this.content_);
            }
            if (this.contentCase_ == 47) {
                output.writeMessage(47, (EchoShellInfoOuterClass.EchoShellInfo) this.content_);
            }
            if (this.contentCase_ == 48) {
                output.writeMessage(48, (ScreenInfoOuterClass.ScreenInfo) this.content_);
            }
            if (this.contentCase_ == 59) {
                output.writeMessage(59, (FishPoolInfoOuterClass.FishPoolInfo) this.content_);
            }
            if (this.contentCase_ == 60) {
                output.writeMessage(60, (CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_);
            }
            if (this.contentCase_ == 61) {
                output.writeMessage(61, (RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 62) {
                output.writeMessage(62, (NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 63) {
                output.writeMessage(63, (DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 64) {
                output.writeMessage(64, (CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_);
            }
            if (this.playInfo_ != null) {
                output.writeMessage(100, getPlayInfo());
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
            if (this.gadgetId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.gadgetId_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.groupId_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.configId_);
            }
            if (this.ownerEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.ownerEntityId_);
            }
            if (this.bornType_ != GadgetBornTypeOuterClass.GadgetBornType.GADGET_BORN_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.bornType_);
            }
            if (this.gadgetState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.gadgetState_);
            }
            if (this.gadgetType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.gadgetType_);
            }
            if (this.isShowCutscene_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isShowCutscene_);
            }
            if (this.authorityPeerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.authorityPeerId_);
            }
            if (this.isEnableInteract_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isEnableInteract_);
            }
            if (this.interactId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.interactId_);
            }
            if (this.contentCase_ == 12) {
                size2 += CodedOutputStream.computeMessageSize(12, (ItemOuterClass.Item) this.content_);
            }
            if (this.contentCase_ == 13) {
                size2 += CodedOutputStream.computeMessageSize(13, (GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 14) {
                size2 += CodedOutputStream.computeMessageSize(14, (WorktopInfoOuterClass.WorktopInfo) this.content_);
            }
            if (this.contentCase_ == 15) {
                size2 += CodedOutputStream.computeMessageSize(15, (ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 17) {
                size2 += CodedOutputStream.computeMessageSize(17, (WeatherInfoOuterClass.WeatherInfo) this.content_);
            }
            if (this.contentCase_ == 18) {
                size2 += CodedOutputStream.computeMessageSize(18, (AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 19) {
                size2 += CodedOutputStream.computeMessageSize(19, (StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 20) {
                size2 += CodedOutputStream.computeMessageSize(20, (BossChestInfoOuterClass.BossChestInfo) this.content_);
            }
            if (this.markFlag_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(21, this.markFlag_);
            }
            if (this.propOwnerEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(22, this.propOwnerEntityId_);
            }
            if (this.platform_ != null) {
                size2 += CodedOutputStream.computeMessageSize(23, getPlatform());
            }
            int dataSize = 0;
            for (int i = 0; i < this.interactUidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.interactUidList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getInteractUidListList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.interactUidListMemoizedSerializedSize = dataSize;
            if (this.draftId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(25, this.draftId_);
            }
            if (this.gadgetTalkState_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(26, this.gadgetTalkState_);
            }
            if (this.contentCase_ == 41) {
                size3 += CodedOutputStream.computeMessageSize(41, (BlossomChestInfoOuterClass.BlossomChestInfo) this.content_);
            }
            if (this.contentCase_ == 42) {
                size3 += CodedOutputStream.computeMessageSize(42, (MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_);
            }
            if (this.contentCase_ == 43) {
                size3 += CodedOutputStream.computeMessageSize(43, (GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_);
            }
            if (this.contentCase_ == 44) {
                size3 += CodedOutputStream.computeMessageSize(44, (OfferingInfoOuterClass.OfferingInfo) this.content_);
            }
            if (this.contentCase_ == 45) {
                size3 += CodedOutputStream.computeMessageSize(45, (FoundationInfoOuterClass.FoundationInfo) this.content_);
            }
            if (this.contentCase_ == 46) {
                size3 += CodedOutputStream.computeMessageSize(46, (VehicleInfoOuterClass.VehicleInfo) this.content_);
            }
            if (this.contentCase_ == 47) {
                size3 += CodedOutputStream.computeMessageSize(47, (EchoShellInfoOuterClass.EchoShellInfo) this.content_);
            }
            if (this.contentCase_ == 48) {
                size3 += CodedOutputStream.computeMessageSize(48, (ScreenInfoOuterClass.ScreenInfo) this.content_);
            }
            if (this.contentCase_ == 59) {
                size3 += CodedOutputStream.computeMessageSize(59, (FishPoolInfoOuterClass.FishPoolInfo) this.content_);
            }
            if (this.contentCase_ == 60) {
                size3 += CodedOutputStream.computeMessageSize(60, (CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_);
            }
            if (this.contentCase_ == 61) {
                size3 += CodedOutputStream.computeMessageSize(61, (RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 62) {
                size3 += CodedOutputStream.computeMessageSize(62, (NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 63) {
                size3 += CodedOutputStream.computeMessageSize(63, (DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_);
            }
            if (this.contentCase_ == 64) {
                size3 += CodedOutputStream.computeMessageSize(64, (CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_);
            }
            if (this.playInfo_ != null) {
                size3 += CodedOutputStream.computeMessageSize(100, getPlayInfo());
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
            if (!(obj instanceof SceneGadgetInfo)) {
                return equals(obj);
            }
            SceneGadgetInfo other = (SceneGadgetInfo) obj;
            if (getGadgetId() != other.getGadgetId() || getGroupId() != other.getGroupId() || getConfigId() != other.getConfigId() || getOwnerEntityId() != other.getOwnerEntityId() || this.bornType_ != other.bornType_ || getGadgetState() != other.getGadgetState() || getGadgetType() != other.getGadgetType() || getIsShowCutscene() != other.getIsShowCutscene() || getAuthorityPeerId() != other.getAuthorityPeerId() || getIsEnableInteract() != other.getIsEnableInteract() || getInteractId() != other.getInteractId() || getMarkFlag() != other.getMarkFlag() || getPropOwnerEntityId() != other.getPropOwnerEntityId() || hasPlatform() != other.hasPlatform()) {
                return false;
            }
            if ((hasPlatform() && !getPlatform().equals(other.getPlatform())) || !getInteractUidListList().equals(other.getInteractUidListList()) || getDraftId() != other.getDraftId() || getGadgetTalkState() != other.getGadgetTalkState() || hasPlayInfo() != other.hasPlayInfo()) {
                return false;
            }
            if ((hasPlayInfo() && !getPlayInfo().equals(other.getPlayInfo())) || !getContentCase().equals(other.getContentCase())) {
                return false;
            }
            switch (this.contentCase_) {
                case 12:
                    if (!getTrifleItem().equals(other.getTrifleItem())) {
                        return false;
                    }
                    break;
                case 13:
                    if (!getGatherGadget().equals(other.getGatherGadget())) {
                        return false;
                    }
                    break;
                case 14:
                    if (!getWorktop().equals(other.getWorktop())) {
                        return false;
                    }
                    break;
                case 15:
                    if (!getClientGadget().equals(other.getClientGadget())) {
                        return false;
                    }
                    break;
                case 17:
                    if (!getWeather().equals(other.getWeather())) {
                        return false;
                    }
                    break;
                case 18:
                    if (!getAbilityGadget().equals(other.getAbilityGadget())) {
                        return false;
                    }
                    break;
                case 19:
                    if (!getStatueGadget().equals(other.getStatueGadget())) {
                        return false;
                    }
                    break;
                case 20:
                    if (!getBossChest().equals(other.getBossChest())) {
                        return false;
                    }
                    break;
                case 41:
                    if (!getBlossomChest().equals(other.getBlossomChest())) {
                        return false;
                    }
                    break;
                case 42:
                    if (!getMpPlayReward().equals(other.getMpPlayReward())) {
                        return false;
                    }
                    break;
                case 43:
                    if (!getGeneralReward().equals(other.getGeneralReward())) {
                        return false;
                    }
                    break;
                case 44:
                    if (!getOfferingInfo().equals(other.getOfferingInfo())) {
                        return false;
                    }
                    break;
                case 45:
                    if (!getFoundationInfo().equals(other.getFoundationInfo())) {
                        return false;
                    }
                    break;
                case 46:
                    if (!getVehicleInfo().equals(other.getVehicleInfo())) {
                        return false;
                    }
                    break;
                case 47:
                    if (!getShellInfo().equals(other.getShellInfo())) {
                        return false;
                    }
                    break;
                case 48:
                    if (!getScreenInfo().equals(other.getScreenInfo())) {
                        return false;
                    }
                    break;
                case 59:
                    if (!getFishPoolInfo().equals(other.getFishPoolInfo())) {
                        return false;
                    }
                    break;
                case 60:
                    if (!getCustomGadgetTreeInfo().equals(other.getCustomGadgetTreeInfo())) {
                        return false;
                    }
                    break;
                case 61:
                    if (!getRoguelikeGadgetInfo().equals(other.getRoguelikeGadgetInfo())) {
                        return false;
                    }
                    break;
                case 62:
                    if (!getNightCrowGadgetInfo().equals(other.getNightCrowGadgetInfo())) {
                        return false;
                    }
                    break;
                case 63:
                    if (!getDeshretObeliskGadgetInfo().equals(other.getDeshretObeliskGadgetInfo())) {
                        return false;
                    }
                    break;
                case 64:
                    if (!getCoinCollectOperatorInfo().equals(other.getCoinCollectOperatorInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getGadgetId())) + 2)) + getGroupId())) + 3)) + getConfigId())) + 4)) + getOwnerEntityId())) + 5)) + this.bornType_)) + 6)) + getGadgetState())) + 7)) + getGadgetType())) + 8)) + Internal.hashBoolean(getIsShowCutscene()))) + 9)) + getAuthorityPeerId())) + 10)) + Internal.hashBoolean(getIsEnableInteract()))) + 11)) + getInteractId())) + 21)) + getMarkFlag())) + 22)) + getPropOwnerEntityId();
            if (hasPlatform()) {
                hash = (53 * ((37 * hash) + 23)) + getPlatform().hashCode();
            }
            if (getInteractUidListCount() > 0) {
                hash = (53 * ((37 * hash) + 24)) + getInteractUidListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 25)) + getDraftId())) + 26)) + getGadgetTalkState();
            if (hasPlayInfo()) {
                hash2 = (53 * ((37 * hash2) + 100)) + getPlayInfo().hashCode();
            }
            switch (this.contentCase_) {
                case 12:
                    hash2 = (53 * ((37 * hash2) + 12)) + getTrifleItem().hashCode();
                    break;
                case 13:
                    hash2 = (53 * ((37 * hash2) + 13)) + getGatherGadget().hashCode();
                    break;
                case 14:
                    hash2 = (53 * ((37 * hash2) + 14)) + getWorktop().hashCode();
                    break;
                case 15:
                    hash2 = (53 * ((37 * hash2) + 15)) + getClientGadget().hashCode();
                    break;
                case 17:
                    hash2 = (53 * ((37 * hash2) + 17)) + getWeather().hashCode();
                    break;
                case 18:
                    hash2 = (53 * ((37 * hash2) + 18)) + getAbilityGadget().hashCode();
                    break;
                case 19:
                    hash2 = (53 * ((37 * hash2) + 19)) + getStatueGadget().hashCode();
                    break;
                case 20:
                    hash2 = (53 * ((37 * hash2) + 20)) + getBossChest().hashCode();
                    break;
                case 41:
                    hash2 = (53 * ((37 * hash2) + 41)) + getBlossomChest().hashCode();
                    break;
                case 42:
                    hash2 = (53 * ((37 * hash2) + 42)) + getMpPlayReward().hashCode();
                    break;
                case 43:
                    hash2 = (53 * ((37 * hash2) + 43)) + getGeneralReward().hashCode();
                    break;
                case 44:
                    hash2 = (53 * ((37 * hash2) + 44)) + getOfferingInfo().hashCode();
                    break;
                case 45:
                    hash2 = (53 * ((37 * hash2) + 45)) + getFoundationInfo().hashCode();
                    break;
                case 46:
                    hash2 = (53 * ((37 * hash2) + 46)) + getVehicleInfo().hashCode();
                    break;
                case 47:
                    hash2 = (53 * ((37 * hash2) + 47)) + getShellInfo().hashCode();
                    break;
                case 48:
                    hash2 = (53 * ((37 * hash2) + 48)) + getScreenInfo().hashCode();
                    break;
                case 59:
                    hash2 = (53 * ((37 * hash2) + 59)) + getFishPoolInfo().hashCode();
                    break;
                case 60:
                    hash2 = (53 * ((37 * hash2) + 60)) + getCustomGadgetTreeInfo().hashCode();
                    break;
                case 61:
                    hash2 = (53 * ((37 * hash2) + 61)) + getRoguelikeGadgetInfo().hashCode();
                    break;
                case 62:
                    hash2 = (53 * ((37 * hash2) + 62)) + getNightCrowGadgetInfo().hashCode();
                    break;
                case 63:
                    hash2 = (53 * ((37 * hash2) + 63)) + getDeshretObeliskGadgetInfo().hashCode();
                    break;
                case 64:
                    hash2 = (53 * ((37 * hash2) + 64)) + getCoinCollectOperatorInfo().hashCode();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static SceneGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGadgetInfo parseFrom(InputStream input) throws IOException {
            return (SceneGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGadgetInfoOuterClass$SceneGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneGadgetInfoOrBuilder {
            private Object content_;
            private int bitField0_;
            private int gadgetId_;
            private int groupId_;
            private int configId_;
            private int ownerEntityId_;
            private int gadgetState_;
            private int gadgetType_;
            private boolean isShowCutscene_;
            private int authorityPeerId_;
            private boolean isEnableInteract_;
            private int interactId_;
            private int markFlag_;
            private int propOwnerEntityId_;
            private PlatformInfoOuterClass.PlatformInfo platform_;
            private SingleFieldBuilderV3<PlatformInfoOuterClass.PlatformInfo, PlatformInfoOuterClass.PlatformInfo.Builder, PlatformInfoOuterClass.PlatformInfoOrBuilder> platformBuilder_;
            private int draftId_;
            private int gadgetTalkState_;
            private GadgetPlayInfoOuterClass.GadgetPlayInfo playInfo_;
            private SingleFieldBuilderV3<GadgetPlayInfoOuterClass.GadgetPlayInfo, GadgetPlayInfoOuterClass.GadgetPlayInfo.Builder, GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder> playInfoBuilder_;
            private SingleFieldBuilderV3<ItemOuterClass.Item, ItemOuterClass.Item.Builder, ItemOuterClass.ItemOrBuilder> trifleItemBuilder_;
            private SingleFieldBuilderV3<GatherGadgetInfoOuterClass.GatherGadgetInfo, GatherGadgetInfoOuterClass.GatherGadgetInfo.Builder, GatherGadgetInfoOuterClass.GatherGadgetInfoOrBuilder> gatherGadgetBuilder_;
            private SingleFieldBuilderV3<WorktopInfoOuterClass.WorktopInfo, WorktopInfoOuterClass.WorktopInfo.Builder, WorktopInfoOuterClass.WorktopInfoOrBuilder> worktopBuilder_;
            private SingleFieldBuilderV3<ClientGadgetInfoOuterClass.ClientGadgetInfo, ClientGadgetInfoOuterClass.ClientGadgetInfo.Builder, ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder> clientGadgetBuilder_;
            private SingleFieldBuilderV3<WeatherInfoOuterClass.WeatherInfo, WeatherInfoOuterClass.WeatherInfo.Builder, WeatherInfoOuterClass.WeatherInfoOrBuilder> weatherBuilder_;
            private SingleFieldBuilderV3<AbilityGadgetInfoOuterClass.AbilityGadgetInfo, AbilityGadgetInfoOuterClass.AbilityGadgetInfo.Builder, AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder> abilityGadgetBuilder_;
            private SingleFieldBuilderV3<StatueGadgetInfoOuterClass.StatueGadgetInfo, StatueGadgetInfoOuterClass.StatueGadgetInfo.Builder, StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder> statueGadgetBuilder_;
            private SingleFieldBuilderV3<BossChestInfoOuterClass.BossChestInfo, BossChestInfoOuterClass.BossChestInfo.Builder, BossChestInfoOuterClass.BossChestInfoOrBuilder> bossChestBuilder_;
            private SingleFieldBuilderV3<BlossomChestInfoOuterClass.BlossomChestInfo, BlossomChestInfoOuterClass.BlossomChestInfo.Builder, BlossomChestInfoOuterClass.BlossomChestInfoOrBuilder> blossomChestBuilder_;
            private SingleFieldBuilderV3<MpPlayRewardInfoOuterClass.MpPlayRewardInfo, MpPlayRewardInfoOuterClass.MpPlayRewardInfo.Builder, MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder> mpPlayRewardBuilder_;
            private SingleFieldBuilderV3<GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo, GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.Builder, GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder> generalRewardBuilder_;
            private SingleFieldBuilderV3<OfferingInfoOuterClass.OfferingInfo, OfferingInfoOuterClass.OfferingInfo.Builder, OfferingInfoOuterClass.OfferingInfoOrBuilder> offeringInfoBuilder_;
            private SingleFieldBuilderV3<FoundationInfoOuterClass.FoundationInfo, FoundationInfoOuterClass.FoundationInfo.Builder, FoundationInfoOuterClass.FoundationInfoOrBuilder> foundationInfoBuilder_;
            private SingleFieldBuilderV3<VehicleInfoOuterClass.VehicleInfo, VehicleInfoOuterClass.VehicleInfo.Builder, VehicleInfoOuterClass.VehicleInfoOrBuilder> vehicleInfoBuilder_;
            private SingleFieldBuilderV3<EchoShellInfoOuterClass.EchoShellInfo, EchoShellInfoOuterClass.EchoShellInfo.Builder, EchoShellInfoOuterClass.EchoShellInfoOrBuilder> shellInfoBuilder_;
            private SingleFieldBuilderV3<ScreenInfoOuterClass.ScreenInfo, ScreenInfoOuterClass.ScreenInfo.Builder, ScreenInfoOuterClass.ScreenInfoOrBuilder> screenInfoBuilder_;
            private SingleFieldBuilderV3<FishPoolInfoOuterClass.FishPoolInfo, FishPoolInfoOuterClass.FishPoolInfo.Builder, FishPoolInfoOuterClass.FishPoolInfoOrBuilder> fishPoolInfoBuilder_;
            private SingleFieldBuilderV3<CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo, CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.Builder, CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder> customGadgetTreeInfoBuilder_;
            private SingleFieldBuilderV3<RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo, RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.Builder, RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder> roguelikeGadgetInfoBuilder_;
            private SingleFieldBuilderV3<NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo, NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.Builder, NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder> nightCrowGadgetInfoBuilder_;
            private SingleFieldBuilderV3<DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo, DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.Builder, DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfoOrBuilder> deshretObeliskGadgetInfoBuilder_;
            private SingleFieldBuilderV3<CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo, CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.Builder, CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfoOrBuilder> coinCollectOperatorInfoBuilder_;
            private int contentCase_ = 0;
            private int bornType_ = 0;
            private Internal.IntList interactUidList_ = SceneGadgetInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneGadgetInfoOuterClass.internal_static_SceneGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneGadgetInfoOuterClass.internal_static_SceneGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gadgetId_ = 0;
                this.groupId_ = 0;
                this.configId_ = 0;
                this.ownerEntityId_ = 0;
                this.bornType_ = 0;
                this.gadgetState_ = 0;
                this.gadgetType_ = 0;
                this.isShowCutscene_ = false;
                this.authorityPeerId_ = 0;
                this.isEnableInteract_ = false;
                this.interactId_ = 0;
                this.markFlag_ = 0;
                this.propOwnerEntityId_ = 0;
                if (this.platformBuilder_ == null) {
                    this.platform_ = null;
                } else {
                    this.platform_ = null;
                    this.platformBuilder_ = null;
                }
                this.interactUidList_ = SceneGadgetInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.draftId_ = 0;
                this.gadgetTalkState_ = 0;
                if (this.playInfoBuilder_ == null) {
                    this.playInfo_ = null;
                } else {
                    this.playInfo_ = null;
                    this.playInfoBuilder_ = null;
                }
                this.contentCase_ = 0;
                this.content_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneGadgetInfoOuterClass.internal_static_SceneGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneGadgetInfo getDefaultInstanceForType() {
                return SceneGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneGadgetInfo build() {
                SceneGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneGadgetInfo buildPartial() {
                SceneGadgetInfo result = new SceneGadgetInfo(this);
                int i = this.bitField0_;
                result.gadgetId_ = this.gadgetId_;
                result.groupId_ = this.groupId_;
                result.configId_ = this.configId_;
                result.ownerEntityId_ = this.ownerEntityId_;
                result.bornType_ = this.bornType_;
                result.gadgetState_ = this.gadgetState_;
                result.gadgetType_ = this.gadgetType_;
                result.isShowCutscene_ = this.isShowCutscene_;
                result.authorityPeerId_ = this.authorityPeerId_;
                result.isEnableInteract_ = this.isEnableInteract_;
                result.interactId_ = this.interactId_;
                result.markFlag_ = this.markFlag_;
                result.propOwnerEntityId_ = this.propOwnerEntityId_;
                if (this.platformBuilder_ == null) {
                    result.platform_ = this.platform_;
                } else {
                    result.platform_ = this.platformBuilder_.build();
                }
                if ((this.bitField0_ & 1) != 0) {
                    this.interactUidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.interactUidList_ = this.interactUidList_;
                result.draftId_ = this.draftId_;
                result.gadgetTalkState_ = this.gadgetTalkState_;
                if (this.playInfoBuilder_ == null) {
                    result.playInfo_ = this.playInfo_;
                } else {
                    result.playInfo_ = this.playInfoBuilder_.build();
                }
                if (this.contentCase_ == 12) {
                    if (this.trifleItemBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.trifleItemBuilder_.build();
                    }
                }
                if (this.contentCase_ == 13) {
                    if (this.gatherGadgetBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.gatherGadgetBuilder_.build();
                    }
                }
                if (this.contentCase_ == 14) {
                    if (this.worktopBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.worktopBuilder_.build();
                    }
                }
                if (this.contentCase_ == 15) {
                    if (this.clientGadgetBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.clientGadgetBuilder_.build();
                    }
                }
                if (this.contentCase_ == 17) {
                    if (this.weatherBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.weatherBuilder_.build();
                    }
                }
                if (this.contentCase_ == 18) {
                    if (this.abilityGadgetBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.abilityGadgetBuilder_.build();
                    }
                }
                if (this.contentCase_ == 19) {
                    if (this.statueGadgetBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.statueGadgetBuilder_.build();
                    }
                }
                if (this.contentCase_ == 20) {
                    if (this.bossChestBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.bossChestBuilder_.build();
                    }
                }
                if (this.contentCase_ == 41) {
                    if (this.blossomChestBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.blossomChestBuilder_.build();
                    }
                }
                if (this.contentCase_ == 42) {
                    if (this.mpPlayRewardBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.mpPlayRewardBuilder_.build();
                    }
                }
                if (this.contentCase_ == 43) {
                    if (this.generalRewardBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.generalRewardBuilder_.build();
                    }
                }
                if (this.contentCase_ == 44) {
                    if (this.offeringInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.offeringInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 45) {
                    if (this.foundationInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.foundationInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 46) {
                    if (this.vehicleInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.vehicleInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 47) {
                    if (this.shellInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.shellInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 48) {
                    if (this.screenInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.screenInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 59) {
                    if (this.fishPoolInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.fishPoolInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 60) {
                    if (this.customGadgetTreeInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.customGadgetTreeInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 61) {
                    if (this.roguelikeGadgetInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.roguelikeGadgetInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 62) {
                    if (this.nightCrowGadgetInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.nightCrowGadgetInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 63) {
                    if (this.deshretObeliskGadgetInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.deshretObeliskGadgetInfoBuilder_.build();
                    }
                }
                if (this.contentCase_ == 64) {
                    if (this.coinCollectOperatorInfoBuilder_ == null) {
                        result.content_ = this.content_;
                    } else {
                        result.content_ = this.coinCollectOperatorInfoBuilder_.build();
                    }
                }
                result.contentCase_ = this.contentCase_;
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
                if (other instanceof SceneGadgetInfo) {
                    return mergeFrom((SceneGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneGadgetInfo other) {
                if (other == SceneGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (other.getOwnerEntityId() != 0) {
                    setOwnerEntityId(other.getOwnerEntityId());
                }
                if (other.bornType_ != 0) {
                    setBornTypeValue(other.getBornTypeValue());
                }
                if (other.getGadgetState() != 0) {
                    setGadgetState(other.getGadgetState());
                }
                if (other.getGadgetType() != 0) {
                    setGadgetType(other.getGadgetType());
                }
                if (other.getIsShowCutscene()) {
                    setIsShowCutscene(other.getIsShowCutscene());
                }
                if (other.getAuthorityPeerId() != 0) {
                    setAuthorityPeerId(other.getAuthorityPeerId());
                }
                if (other.getIsEnableInteract()) {
                    setIsEnableInteract(other.getIsEnableInteract());
                }
                if (other.getInteractId() != 0) {
                    setInteractId(other.getInteractId());
                }
                if (other.getMarkFlag() != 0) {
                    setMarkFlag(other.getMarkFlag());
                }
                if (other.getPropOwnerEntityId() != 0) {
                    setPropOwnerEntityId(other.getPropOwnerEntityId());
                }
                if (other.hasPlatform()) {
                    mergePlatform(other.getPlatform());
                }
                if (!other.interactUidList_.isEmpty()) {
                    if (this.interactUidList_.isEmpty()) {
                        this.interactUidList_ = other.interactUidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureInteractUidListIsMutable();
                        this.interactUidList_.addAll(other.interactUidList_);
                    }
                    onChanged();
                }
                if (other.getDraftId() != 0) {
                    setDraftId(other.getDraftId());
                }
                if (other.getGadgetTalkState() != 0) {
                    setGadgetTalkState(other.getGadgetTalkState());
                }
                if (other.hasPlayInfo()) {
                    mergePlayInfo(other.getPlayInfo());
                }
                switch (other.getContentCase()) {
                    case TRIFLE_ITEM:
                        mergeTrifleItem(other.getTrifleItem());
                        break;
                    case GATHER_GADGET:
                        mergeGatherGadget(other.getGatherGadget());
                        break;
                    case WORKTOP:
                        mergeWorktop(other.getWorktop());
                        break;
                    case CLIENT_GADGET:
                        mergeClientGadget(other.getClientGadget());
                        break;
                    case WEATHER:
                        mergeWeather(other.getWeather());
                        break;
                    case ABILITY_GADGET:
                        mergeAbilityGadget(other.getAbilityGadget());
                        break;
                    case STATUE_GADGET:
                        mergeStatueGadget(other.getStatueGadget());
                        break;
                    case BOSS_CHEST:
                        mergeBossChest(other.getBossChest());
                        break;
                    case BLOSSOM_CHEST:
                        mergeBlossomChest(other.getBlossomChest());
                        break;
                    case MP_PLAY_REWARD:
                        mergeMpPlayReward(other.getMpPlayReward());
                        break;
                    case GENERAL_REWARD:
                        mergeGeneralReward(other.getGeneralReward());
                        break;
                    case OFFERING_INFO:
                        mergeOfferingInfo(other.getOfferingInfo());
                        break;
                    case FOUNDATION_INFO:
                        mergeFoundationInfo(other.getFoundationInfo());
                        break;
                    case VEHICLE_INFO:
                        mergeVehicleInfo(other.getVehicleInfo());
                        break;
                    case SHELL_INFO:
                        mergeShellInfo(other.getShellInfo());
                        break;
                    case SCREEN_INFO:
                        mergeScreenInfo(other.getScreenInfo());
                        break;
                    case FISH_POOL_INFO:
                        mergeFishPoolInfo(other.getFishPoolInfo());
                        break;
                    case CUSTOM_GADGET_TREE_INFO:
                        mergeCustomGadgetTreeInfo(other.getCustomGadgetTreeInfo());
                        break;
                    case ROGUELIKE_GADGET_INFO:
                        mergeRoguelikeGadgetInfo(other.getRoguelikeGadgetInfo());
                        break;
                    case NIGHT_CROW_GADGET_INFO:
                        mergeNightCrowGadgetInfo(other.getNightCrowGadgetInfo());
                        break;
                    case DESHRET_OBELISK_GADGET_INFO:
                        mergeDeshretObeliskGadgetInfo(other.getDeshretObeliskGadgetInfo());
                        break;
                    case COIN_COLLECT_OPERATOR_INFO:
                        mergeCoinCollectOperatorInfo(other.getCoinCollectOperatorInfo());
                        break;
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
                SceneGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ContentCase getContentCase() {
                return ContentCase.forNumber(this.contentCase_);
            }

            public Builder clearContent() {
                this.contentCase_ = 0;
                this.content_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            public Builder setGroupId(int value) {
                this.groupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getOwnerEntityId() {
                return this.ownerEntityId_;
            }

            public Builder setOwnerEntityId(int value) {
                this.ownerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerEntityId() {
                this.ownerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getBornTypeValue() {
                return this.bornType_;
            }

            public Builder setBornTypeValue(int value) {
                this.bornType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GadgetBornTypeOuterClass.GadgetBornType getBornType() {
                GadgetBornTypeOuterClass.GadgetBornType result = GadgetBornTypeOuterClass.GadgetBornType.valueOf(this.bornType_);
                return result == null ? GadgetBornTypeOuterClass.GadgetBornType.UNRECOGNIZED : result;
            }

            public Builder setBornType(GadgetBornTypeOuterClass.GadgetBornType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bornType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearBornType() {
                this.bornType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getGadgetState() {
                return this.gadgetState_;
            }

            public Builder setGadgetState(int value) {
                this.gadgetState_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetState() {
                this.gadgetState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getGadgetType() {
                return this.gadgetType_;
            }

            public Builder setGadgetType(int value) {
                this.gadgetType_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetType() {
                this.gadgetType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean getIsShowCutscene() {
                return this.isShowCutscene_;
            }

            public Builder setIsShowCutscene(boolean value) {
                this.isShowCutscene_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsShowCutscene() {
                this.isShowCutscene_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getAuthorityPeerId() {
                return this.authorityPeerId_;
            }

            public Builder setAuthorityPeerId(int value) {
                this.authorityPeerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAuthorityPeerId() {
                this.authorityPeerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean getIsEnableInteract() {
                return this.isEnableInteract_;
            }

            public Builder setIsEnableInteract(boolean value) {
                this.isEnableInteract_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEnableInteract() {
                this.isEnableInteract_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getInteractId() {
                return this.interactId_;
            }

            public Builder setInteractId(int value) {
                this.interactId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInteractId() {
                this.interactId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getMarkFlag() {
                return this.markFlag_;
            }

            public Builder setMarkFlag(int value) {
                this.markFlag_ = value;
                onChanged();
                return this;
            }

            public Builder clearMarkFlag() {
                this.markFlag_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getPropOwnerEntityId() {
                return this.propOwnerEntityId_;
            }

            public Builder setPropOwnerEntityId(int value) {
                this.propOwnerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropOwnerEntityId() {
                this.propOwnerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasPlatform() {
                return (this.platformBuilder_ == null && this.platform_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public PlatformInfoOuterClass.PlatformInfo getPlatform() {
                if (this.platformBuilder_ == null) {
                    return this.platform_ == null ? PlatformInfoOuterClass.PlatformInfo.getDefaultInstance() : this.platform_;
                }
                return this.platformBuilder_.getMessage();
            }

            public Builder setPlatform(PlatformInfoOuterClass.PlatformInfo value) {
                if (this.platformBuilder_ != null) {
                    this.platformBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.platform_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPlatform(PlatformInfoOuterClass.PlatformInfo.Builder builderForValue) {
                if (this.platformBuilder_ == null) {
                    this.platform_ = builderForValue.build();
                    onChanged();
                } else {
                    this.platformBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePlatform(PlatformInfoOuterClass.PlatformInfo value) {
                if (this.platformBuilder_ == null) {
                    if (this.platform_ != null) {
                        this.platform_ = PlatformInfoOuterClass.PlatformInfo.newBuilder(this.platform_).mergeFrom(value).buildPartial();
                    } else {
                        this.platform_ = value;
                    }
                    onChanged();
                } else {
                    this.platformBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPlatform() {
                if (this.platformBuilder_ == null) {
                    this.platform_ = null;
                    onChanged();
                } else {
                    this.platform_ = null;
                    this.platformBuilder_ = null;
                }
                return this;
            }

            public PlatformInfoOuterClass.PlatformInfo.Builder getPlatformBuilder() {
                onChanged();
                return getPlatformFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public PlatformInfoOuterClass.PlatformInfoOrBuilder getPlatformOrBuilder() {
                if (this.platformBuilder_ != null) {
                    return this.platformBuilder_.getMessageOrBuilder();
                }
                return this.platform_ == null ? PlatformInfoOuterClass.PlatformInfo.getDefaultInstance() : this.platform_;
            }

            private SingleFieldBuilderV3<PlatformInfoOuterClass.PlatformInfo, PlatformInfoOuterClass.PlatformInfo.Builder, PlatformInfoOuterClass.PlatformInfoOrBuilder> getPlatformFieldBuilder() {
                if (this.platformBuilder_ == null) {
                    this.platformBuilder_ = new SingleFieldBuilderV3<>(getPlatform(), getParentForChildren(), isClean());
                    this.platform_ = null;
                }
                return this.platformBuilder_;
            }

            private void ensureInteractUidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.interactUidList_ = SceneGadgetInfo.mutableCopy(this.interactUidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public List<Integer> getInteractUidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.interactUidList_) : this.interactUidList_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getInteractUidListCount() {
                return this.interactUidList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getInteractUidList(int index) {
                return this.interactUidList_.getInt(index);
            }

            public Builder setInteractUidList(int index, int value) {
                ensureInteractUidListIsMutable();
                this.interactUidList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addInteractUidList(int value) {
                ensureInteractUidListIsMutable();
                this.interactUidList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllInteractUidList(Iterable<? extends Integer> values) {
                ensureInteractUidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.interactUidList_);
                onChanged();
                return this;
            }

            public Builder clearInteractUidList() {
                this.interactUidList_ = SceneGadgetInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getDraftId() {
                return this.draftId_;
            }

            public Builder setDraftId(int value) {
                this.draftId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDraftId() {
                this.draftId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public int getGadgetTalkState() {
                return this.gadgetTalkState_;
            }

            public Builder setGadgetTalkState(int value) {
                this.gadgetTalkState_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetTalkState() {
                this.gadgetTalkState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasPlayInfo() {
                return (this.playInfoBuilder_ == null && this.playInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GadgetPlayInfoOuterClass.GadgetPlayInfo getPlayInfo() {
                if (this.playInfoBuilder_ == null) {
                    return this.playInfo_ == null ? GadgetPlayInfoOuterClass.GadgetPlayInfo.getDefaultInstance() : this.playInfo_;
                }
                return this.playInfoBuilder_.getMessage();
            }

            public Builder setPlayInfo(GadgetPlayInfoOuterClass.GadgetPlayInfo value) {
                if (this.playInfoBuilder_ != null) {
                    this.playInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.playInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPlayInfo(GadgetPlayInfoOuterClass.GadgetPlayInfo.Builder builderForValue) {
                if (this.playInfoBuilder_ == null) {
                    this.playInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.playInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePlayInfo(GadgetPlayInfoOuterClass.GadgetPlayInfo value) {
                if (this.playInfoBuilder_ == null) {
                    if (this.playInfo_ != null) {
                        this.playInfo_ = GadgetPlayInfoOuterClass.GadgetPlayInfo.newBuilder(this.playInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.playInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.playInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPlayInfo() {
                if (this.playInfoBuilder_ == null) {
                    this.playInfo_ = null;
                    onChanged();
                } else {
                    this.playInfo_ = null;
                    this.playInfoBuilder_ = null;
                }
                return this;
            }

            public GadgetPlayInfoOuterClass.GadgetPlayInfo.Builder getPlayInfoBuilder() {
                onChanged();
                return getPlayInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder getPlayInfoOrBuilder() {
                if (this.playInfoBuilder_ != null) {
                    return this.playInfoBuilder_.getMessageOrBuilder();
                }
                return this.playInfo_ == null ? GadgetPlayInfoOuterClass.GadgetPlayInfo.getDefaultInstance() : this.playInfo_;
            }

            private SingleFieldBuilderV3<GadgetPlayInfoOuterClass.GadgetPlayInfo, GadgetPlayInfoOuterClass.GadgetPlayInfo.Builder, GadgetPlayInfoOuterClass.GadgetPlayInfoOrBuilder> getPlayInfoFieldBuilder() {
                if (this.playInfoBuilder_ == null) {
                    this.playInfoBuilder_ = new SingleFieldBuilderV3<>(getPlayInfo(), getParentForChildren(), isClean());
                    this.playInfo_ = null;
                }
                return this.playInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasTrifleItem() {
                return this.contentCase_ == 12;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ItemOuterClass.Item getTrifleItem() {
                if (this.trifleItemBuilder_ == null) {
                    if (this.contentCase_ == 12) {
                        return (ItemOuterClass.Item) this.content_;
                    }
                    return ItemOuterClass.Item.getDefaultInstance();
                } else if (this.contentCase_ == 12) {
                    return this.trifleItemBuilder_.getMessage();
                } else {
                    return ItemOuterClass.Item.getDefaultInstance();
                }
            }

            public Builder setTrifleItem(ItemOuterClass.Item value) {
                if (this.trifleItemBuilder_ != null) {
                    this.trifleItemBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 12;
                return this;
            }

            public Builder setTrifleItem(ItemOuterClass.Item.Builder builderForValue) {
                if (this.trifleItemBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.trifleItemBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 12;
                return this;
            }

            public Builder mergeTrifleItem(ItemOuterClass.Item value) {
                if (this.trifleItemBuilder_ == null) {
                    if (this.contentCase_ != 12 || this.content_ == ItemOuterClass.Item.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = ItemOuterClass.Item.newBuilder((ItemOuterClass.Item) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 12) {
                        this.trifleItemBuilder_.mergeFrom(value);
                    }
                    this.trifleItemBuilder_.setMessage(value);
                }
                this.contentCase_ = 12;
                return this;
            }

            public Builder clearTrifleItem() {
                if (this.trifleItemBuilder_ != null) {
                    if (this.contentCase_ == 12) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.trifleItemBuilder_.clear();
                } else if (this.contentCase_ == 12) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public ItemOuterClass.Item.Builder getTrifleItemBuilder() {
                return getTrifleItemFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ItemOuterClass.ItemOrBuilder getTrifleItemOrBuilder() {
                if (this.contentCase_ == 12 && this.trifleItemBuilder_ != null) {
                    return this.trifleItemBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 12) {
                    return (ItemOuterClass.Item) this.content_;
                }
                return ItemOuterClass.Item.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ItemOuterClass.Item, ItemOuterClass.Item.Builder, ItemOuterClass.ItemOrBuilder> getTrifleItemFieldBuilder() {
                if (this.trifleItemBuilder_ == null) {
                    if (this.contentCase_ != 12) {
                        this.content_ = ItemOuterClass.Item.getDefaultInstance();
                    }
                    this.trifleItemBuilder_ = new SingleFieldBuilderV3<>((ItemOuterClass.Item) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 12;
                onChanged();
                return this.trifleItemBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasGatherGadget() {
                return this.contentCase_ == 13;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GatherGadgetInfoOuterClass.GatherGadgetInfo getGatherGadget() {
                if (this.gatherGadgetBuilder_ == null) {
                    if (this.contentCase_ == 13) {
                        return (GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_;
                    }
                    return GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 13) {
                    return this.gatherGadgetBuilder_.getMessage();
                } else {
                    return GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setGatherGadget(GatherGadgetInfoOuterClass.GatherGadgetInfo value) {
                if (this.gatherGadgetBuilder_ != null) {
                    this.gatherGadgetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 13;
                return this;
            }

            public Builder setGatherGadget(GatherGadgetInfoOuterClass.GatherGadgetInfo.Builder builderForValue) {
                if (this.gatherGadgetBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gatherGadgetBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 13;
                return this;
            }

            public Builder mergeGatherGadget(GatherGadgetInfoOuterClass.GatherGadgetInfo value) {
                if (this.gatherGadgetBuilder_ == null) {
                    if (this.contentCase_ != 13 || this.content_ == GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = GatherGadgetInfoOuterClass.GatherGadgetInfo.newBuilder((GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 13) {
                        this.gatherGadgetBuilder_.mergeFrom(value);
                    }
                    this.gatherGadgetBuilder_.setMessage(value);
                }
                this.contentCase_ = 13;
                return this;
            }

            public Builder clearGatherGadget() {
                if (this.gatherGadgetBuilder_ != null) {
                    if (this.contentCase_ == 13) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.gatherGadgetBuilder_.clear();
                } else if (this.contentCase_ == 13) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public GatherGadgetInfoOuterClass.GatherGadgetInfo.Builder getGatherGadgetBuilder() {
                return getGatherGadgetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GatherGadgetInfoOuterClass.GatherGadgetInfoOrBuilder getGatherGadgetOrBuilder() {
                if (this.contentCase_ == 13 && this.gatherGadgetBuilder_ != null) {
                    return this.gatherGadgetBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 13) {
                    return (GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_;
                }
                return GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GatherGadgetInfoOuterClass.GatherGadgetInfo, GatherGadgetInfoOuterClass.GatherGadgetInfo.Builder, GatherGadgetInfoOuterClass.GatherGadgetInfoOrBuilder> getGatherGadgetFieldBuilder() {
                if (this.gatherGadgetBuilder_ == null) {
                    if (this.contentCase_ != 13) {
                        this.content_ = GatherGadgetInfoOuterClass.GatherGadgetInfo.getDefaultInstance();
                    }
                    this.gatherGadgetBuilder_ = new SingleFieldBuilderV3<>((GatherGadgetInfoOuterClass.GatherGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 13;
                onChanged();
                return this.gatherGadgetBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasWorktop() {
                return this.contentCase_ == 14;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public WorktopInfoOuterClass.WorktopInfo getWorktop() {
                if (this.worktopBuilder_ == null) {
                    if (this.contentCase_ == 14) {
                        return (WorktopInfoOuterClass.WorktopInfo) this.content_;
                    }
                    return WorktopInfoOuterClass.WorktopInfo.getDefaultInstance();
                } else if (this.contentCase_ == 14) {
                    return this.worktopBuilder_.getMessage();
                } else {
                    return WorktopInfoOuterClass.WorktopInfo.getDefaultInstance();
                }
            }

            public Builder setWorktop(WorktopInfoOuterClass.WorktopInfo value) {
                if (this.worktopBuilder_ != null) {
                    this.worktopBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 14;
                return this;
            }

            public Builder setWorktop(WorktopInfoOuterClass.WorktopInfo.Builder builderForValue) {
                if (this.worktopBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.worktopBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 14;
                return this;
            }

            public Builder mergeWorktop(WorktopInfoOuterClass.WorktopInfo value) {
                if (this.worktopBuilder_ == null) {
                    if (this.contentCase_ != 14 || this.content_ == WorktopInfoOuterClass.WorktopInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = WorktopInfoOuterClass.WorktopInfo.newBuilder((WorktopInfoOuterClass.WorktopInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 14) {
                        this.worktopBuilder_.mergeFrom(value);
                    }
                    this.worktopBuilder_.setMessage(value);
                }
                this.contentCase_ = 14;
                return this;
            }

            public Builder clearWorktop() {
                if (this.worktopBuilder_ != null) {
                    if (this.contentCase_ == 14) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.worktopBuilder_.clear();
                } else if (this.contentCase_ == 14) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public WorktopInfoOuterClass.WorktopInfo.Builder getWorktopBuilder() {
                return getWorktopFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public WorktopInfoOuterClass.WorktopInfoOrBuilder getWorktopOrBuilder() {
                if (this.contentCase_ == 14 && this.worktopBuilder_ != null) {
                    return this.worktopBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 14) {
                    return (WorktopInfoOuterClass.WorktopInfo) this.content_;
                }
                return WorktopInfoOuterClass.WorktopInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WorktopInfoOuterClass.WorktopInfo, WorktopInfoOuterClass.WorktopInfo.Builder, WorktopInfoOuterClass.WorktopInfoOrBuilder> getWorktopFieldBuilder() {
                if (this.worktopBuilder_ == null) {
                    if (this.contentCase_ != 14) {
                        this.content_ = WorktopInfoOuterClass.WorktopInfo.getDefaultInstance();
                    }
                    this.worktopBuilder_ = new SingleFieldBuilderV3<>((WorktopInfoOuterClass.WorktopInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 14;
                onChanged();
                return this.worktopBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasClientGadget() {
                return this.contentCase_ == 15;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ClientGadgetInfoOuterClass.ClientGadgetInfo getClientGadget() {
                if (this.clientGadgetBuilder_ == null) {
                    if (this.contentCase_ == 15) {
                        return (ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_;
                    }
                    return ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 15) {
                    return this.clientGadgetBuilder_.getMessage();
                } else {
                    return ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setClientGadget(ClientGadgetInfoOuterClass.ClientGadgetInfo value) {
                if (this.clientGadgetBuilder_ != null) {
                    this.clientGadgetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 15;
                return this;
            }

            public Builder setClientGadget(ClientGadgetInfoOuterClass.ClientGadgetInfo.Builder builderForValue) {
                if (this.clientGadgetBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.clientGadgetBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 15;
                return this;
            }

            public Builder mergeClientGadget(ClientGadgetInfoOuterClass.ClientGadgetInfo value) {
                if (this.clientGadgetBuilder_ == null) {
                    if (this.contentCase_ != 15 || this.content_ == ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = ClientGadgetInfoOuterClass.ClientGadgetInfo.newBuilder((ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 15) {
                        this.clientGadgetBuilder_.mergeFrom(value);
                    }
                    this.clientGadgetBuilder_.setMessage(value);
                }
                this.contentCase_ = 15;
                return this;
            }

            public Builder clearClientGadget() {
                if (this.clientGadgetBuilder_ != null) {
                    if (this.contentCase_ == 15) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.clientGadgetBuilder_.clear();
                } else if (this.contentCase_ == 15) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public ClientGadgetInfoOuterClass.ClientGadgetInfo.Builder getClientGadgetBuilder() {
                return getClientGadgetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder getClientGadgetOrBuilder() {
                if (this.contentCase_ == 15 && this.clientGadgetBuilder_ != null) {
                    return this.clientGadgetBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 15) {
                    return (ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_;
                }
                return ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ClientGadgetInfoOuterClass.ClientGadgetInfo, ClientGadgetInfoOuterClass.ClientGadgetInfo.Builder, ClientGadgetInfoOuterClass.ClientGadgetInfoOrBuilder> getClientGadgetFieldBuilder() {
                if (this.clientGadgetBuilder_ == null) {
                    if (this.contentCase_ != 15) {
                        this.content_ = ClientGadgetInfoOuterClass.ClientGadgetInfo.getDefaultInstance();
                    }
                    this.clientGadgetBuilder_ = new SingleFieldBuilderV3<>((ClientGadgetInfoOuterClass.ClientGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 15;
                onChanged();
                return this.clientGadgetBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasWeather() {
                return this.contentCase_ == 17;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public WeatherInfoOuterClass.WeatherInfo getWeather() {
                if (this.weatherBuilder_ == null) {
                    if (this.contentCase_ == 17) {
                        return (WeatherInfoOuterClass.WeatherInfo) this.content_;
                    }
                    return WeatherInfoOuterClass.WeatherInfo.getDefaultInstance();
                } else if (this.contentCase_ == 17) {
                    return this.weatherBuilder_.getMessage();
                } else {
                    return WeatherInfoOuterClass.WeatherInfo.getDefaultInstance();
                }
            }

            public Builder setWeather(WeatherInfoOuterClass.WeatherInfo value) {
                if (this.weatherBuilder_ != null) {
                    this.weatherBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 17;
                return this;
            }

            public Builder setWeather(WeatherInfoOuterClass.WeatherInfo.Builder builderForValue) {
                if (this.weatherBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.weatherBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 17;
                return this;
            }

            public Builder mergeWeather(WeatherInfoOuterClass.WeatherInfo value) {
                if (this.weatherBuilder_ == null) {
                    if (this.contentCase_ != 17 || this.content_ == WeatherInfoOuterClass.WeatherInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = WeatherInfoOuterClass.WeatherInfo.newBuilder((WeatherInfoOuterClass.WeatherInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 17) {
                        this.weatherBuilder_.mergeFrom(value);
                    }
                    this.weatherBuilder_.setMessage(value);
                }
                this.contentCase_ = 17;
                return this;
            }

            public Builder clearWeather() {
                if (this.weatherBuilder_ != null) {
                    if (this.contentCase_ == 17) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.weatherBuilder_.clear();
                } else if (this.contentCase_ == 17) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public WeatherInfoOuterClass.WeatherInfo.Builder getWeatherBuilder() {
                return getWeatherFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public WeatherInfoOuterClass.WeatherInfoOrBuilder getWeatherOrBuilder() {
                if (this.contentCase_ == 17 && this.weatherBuilder_ != null) {
                    return this.weatherBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 17) {
                    return (WeatherInfoOuterClass.WeatherInfo) this.content_;
                }
                return WeatherInfoOuterClass.WeatherInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WeatherInfoOuterClass.WeatherInfo, WeatherInfoOuterClass.WeatherInfo.Builder, WeatherInfoOuterClass.WeatherInfoOrBuilder> getWeatherFieldBuilder() {
                if (this.weatherBuilder_ == null) {
                    if (this.contentCase_ != 17) {
                        this.content_ = WeatherInfoOuterClass.WeatherInfo.getDefaultInstance();
                    }
                    this.weatherBuilder_ = new SingleFieldBuilderV3<>((WeatherInfoOuterClass.WeatherInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 17;
                onChanged();
                return this.weatherBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasAbilityGadget() {
                return this.contentCase_ == 18;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public AbilityGadgetInfoOuterClass.AbilityGadgetInfo getAbilityGadget() {
                if (this.abilityGadgetBuilder_ == null) {
                    if (this.contentCase_ == 18) {
                        return (AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_;
                    }
                    return AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 18) {
                    return this.abilityGadgetBuilder_.getMessage();
                } else {
                    return AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setAbilityGadget(AbilityGadgetInfoOuterClass.AbilityGadgetInfo value) {
                if (this.abilityGadgetBuilder_ != null) {
                    this.abilityGadgetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 18;
                return this;
            }

            public Builder setAbilityGadget(AbilityGadgetInfoOuterClass.AbilityGadgetInfo.Builder builderForValue) {
                if (this.abilityGadgetBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityGadgetBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 18;
                return this;
            }

            public Builder mergeAbilityGadget(AbilityGadgetInfoOuterClass.AbilityGadgetInfo value) {
                if (this.abilityGadgetBuilder_ == null) {
                    if (this.contentCase_ != 18 || this.content_ == AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = AbilityGadgetInfoOuterClass.AbilityGadgetInfo.newBuilder((AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 18) {
                        this.abilityGadgetBuilder_.mergeFrom(value);
                    }
                    this.abilityGadgetBuilder_.setMessage(value);
                }
                this.contentCase_ = 18;
                return this;
            }

            public Builder clearAbilityGadget() {
                if (this.abilityGadgetBuilder_ != null) {
                    if (this.contentCase_ == 18) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.abilityGadgetBuilder_.clear();
                } else if (this.contentCase_ == 18) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public AbilityGadgetInfoOuterClass.AbilityGadgetInfo.Builder getAbilityGadgetBuilder() {
                return getAbilityGadgetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder getAbilityGadgetOrBuilder() {
                if (this.contentCase_ == 18 && this.abilityGadgetBuilder_ != null) {
                    return this.abilityGadgetBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 18) {
                    return (AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_;
                }
                return AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AbilityGadgetInfoOuterClass.AbilityGadgetInfo, AbilityGadgetInfoOuterClass.AbilityGadgetInfo.Builder, AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder> getAbilityGadgetFieldBuilder() {
                if (this.abilityGadgetBuilder_ == null) {
                    if (this.contentCase_ != 18) {
                        this.content_ = AbilityGadgetInfoOuterClass.AbilityGadgetInfo.getDefaultInstance();
                    }
                    this.abilityGadgetBuilder_ = new SingleFieldBuilderV3<>((AbilityGadgetInfoOuterClass.AbilityGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 18;
                onChanged();
                return this.abilityGadgetBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasStatueGadget() {
                return this.contentCase_ == 19;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public StatueGadgetInfoOuterClass.StatueGadgetInfo getStatueGadget() {
                if (this.statueGadgetBuilder_ == null) {
                    if (this.contentCase_ == 19) {
                        return (StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_;
                    }
                    return StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 19) {
                    return this.statueGadgetBuilder_.getMessage();
                } else {
                    return StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setStatueGadget(StatueGadgetInfoOuterClass.StatueGadgetInfo value) {
                if (this.statueGadgetBuilder_ != null) {
                    this.statueGadgetBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 19;
                return this;
            }

            public Builder setStatueGadget(StatueGadgetInfoOuterClass.StatueGadgetInfo.Builder builderForValue) {
                if (this.statueGadgetBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.statueGadgetBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 19;
                return this;
            }

            public Builder mergeStatueGadget(StatueGadgetInfoOuterClass.StatueGadgetInfo value) {
                if (this.statueGadgetBuilder_ == null) {
                    if (this.contentCase_ != 19 || this.content_ == StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = StatueGadgetInfoOuterClass.StatueGadgetInfo.newBuilder((StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 19) {
                        this.statueGadgetBuilder_.mergeFrom(value);
                    }
                    this.statueGadgetBuilder_.setMessage(value);
                }
                this.contentCase_ = 19;
                return this;
            }

            public Builder clearStatueGadget() {
                if (this.statueGadgetBuilder_ != null) {
                    if (this.contentCase_ == 19) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.statueGadgetBuilder_.clear();
                } else if (this.contentCase_ == 19) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public StatueGadgetInfoOuterClass.StatueGadgetInfo.Builder getStatueGadgetBuilder() {
                return getStatueGadgetFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder getStatueGadgetOrBuilder() {
                if (this.contentCase_ == 19 && this.statueGadgetBuilder_ != null) {
                    return this.statueGadgetBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 19) {
                    return (StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_;
                }
                return StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<StatueGadgetInfoOuterClass.StatueGadgetInfo, StatueGadgetInfoOuterClass.StatueGadgetInfo.Builder, StatueGadgetInfoOuterClass.StatueGadgetInfoOrBuilder> getStatueGadgetFieldBuilder() {
                if (this.statueGadgetBuilder_ == null) {
                    if (this.contentCase_ != 19) {
                        this.content_ = StatueGadgetInfoOuterClass.StatueGadgetInfo.getDefaultInstance();
                    }
                    this.statueGadgetBuilder_ = new SingleFieldBuilderV3<>((StatueGadgetInfoOuterClass.StatueGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 19;
                onChanged();
                return this.statueGadgetBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasBossChest() {
                return this.contentCase_ == 20;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public BossChestInfoOuterClass.BossChestInfo getBossChest() {
                if (this.bossChestBuilder_ == null) {
                    if (this.contentCase_ == 20) {
                        return (BossChestInfoOuterClass.BossChestInfo) this.content_;
                    }
                    return BossChestInfoOuterClass.BossChestInfo.getDefaultInstance();
                } else if (this.contentCase_ == 20) {
                    return this.bossChestBuilder_.getMessage();
                } else {
                    return BossChestInfoOuterClass.BossChestInfo.getDefaultInstance();
                }
            }

            public Builder setBossChest(BossChestInfoOuterClass.BossChestInfo value) {
                if (this.bossChestBuilder_ != null) {
                    this.bossChestBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 20;
                return this;
            }

            public Builder setBossChest(BossChestInfoOuterClass.BossChestInfo.Builder builderForValue) {
                if (this.bossChestBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bossChestBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 20;
                return this;
            }

            public Builder mergeBossChest(BossChestInfoOuterClass.BossChestInfo value) {
                if (this.bossChestBuilder_ == null) {
                    if (this.contentCase_ != 20 || this.content_ == BossChestInfoOuterClass.BossChestInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = BossChestInfoOuterClass.BossChestInfo.newBuilder((BossChestInfoOuterClass.BossChestInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 20) {
                        this.bossChestBuilder_.mergeFrom(value);
                    }
                    this.bossChestBuilder_.setMessage(value);
                }
                this.contentCase_ = 20;
                return this;
            }

            public Builder clearBossChest() {
                if (this.bossChestBuilder_ != null) {
                    if (this.contentCase_ == 20) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.bossChestBuilder_.clear();
                } else if (this.contentCase_ == 20) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public BossChestInfoOuterClass.BossChestInfo.Builder getBossChestBuilder() {
                return getBossChestFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public BossChestInfoOuterClass.BossChestInfoOrBuilder getBossChestOrBuilder() {
                if (this.contentCase_ == 20 && this.bossChestBuilder_ != null) {
                    return this.bossChestBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 20) {
                    return (BossChestInfoOuterClass.BossChestInfo) this.content_;
                }
                return BossChestInfoOuterClass.BossChestInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BossChestInfoOuterClass.BossChestInfo, BossChestInfoOuterClass.BossChestInfo.Builder, BossChestInfoOuterClass.BossChestInfoOrBuilder> getBossChestFieldBuilder() {
                if (this.bossChestBuilder_ == null) {
                    if (this.contentCase_ != 20) {
                        this.content_ = BossChestInfoOuterClass.BossChestInfo.getDefaultInstance();
                    }
                    this.bossChestBuilder_ = new SingleFieldBuilderV3<>((BossChestInfoOuterClass.BossChestInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 20;
                onChanged();
                return this.bossChestBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasBlossomChest() {
                return this.contentCase_ == 41;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public BlossomChestInfoOuterClass.BlossomChestInfo getBlossomChest() {
                if (this.blossomChestBuilder_ == null) {
                    if (this.contentCase_ == 41) {
                        return (BlossomChestInfoOuterClass.BlossomChestInfo) this.content_;
                    }
                    return BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance();
                } else if (this.contentCase_ == 41) {
                    return this.blossomChestBuilder_.getMessage();
                } else {
                    return BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance();
                }
            }

            public Builder setBlossomChest(BlossomChestInfoOuterClass.BlossomChestInfo value) {
                if (this.blossomChestBuilder_ != null) {
                    this.blossomChestBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 41;
                return this;
            }

            public Builder setBlossomChest(BlossomChestInfoOuterClass.BlossomChestInfo.Builder builderForValue) {
                if (this.blossomChestBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.blossomChestBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 41;
                return this;
            }

            public Builder mergeBlossomChest(BlossomChestInfoOuterClass.BlossomChestInfo value) {
                if (this.blossomChestBuilder_ == null) {
                    if (this.contentCase_ != 41 || this.content_ == BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = BlossomChestInfoOuterClass.BlossomChestInfo.newBuilder((BlossomChestInfoOuterClass.BlossomChestInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 41) {
                        this.blossomChestBuilder_.mergeFrom(value);
                    }
                    this.blossomChestBuilder_.setMessage(value);
                }
                this.contentCase_ = 41;
                return this;
            }

            public Builder clearBlossomChest() {
                if (this.blossomChestBuilder_ != null) {
                    if (this.contentCase_ == 41) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.blossomChestBuilder_.clear();
                } else if (this.contentCase_ == 41) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public BlossomChestInfoOuterClass.BlossomChestInfo.Builder getBlossomChestBuilder() {
                return getBlossomChestFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public BlossomChestInfoOuterClass.BlossomChestInfoOrBuilder getBlossomChestOrBuilder() {
                if (this.contentCase_ == 41 && this.blossomChestBuilder_ != null) {
                    return this.blossomChestBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 41) {
                    return (BlossomChestInfoOuterClass.BlossomChestInfo) this.content_;
                }
                return BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BlossomChestInfoOuterClass.BlossomChestInfo, BlossomChestInfoOuterClass.BlossomChestInfo.Builder, BlossomChestInfoOuterClass.BlossomChestInfoOrBuilder> getBlossomChestFieldBuilder() {
                if (this.blossomChestBuilder_ == null) {
                    if (this.contentCase_ != 41) {
                        this.content_ = BlossomChestInfoOuterClass.BlossomChestInfo.getDefaultInstance();
                    }
                    this.blossomChestBuilder_ = new SingleFieldBuilderV3<>((BlossomChestInfoOuterClass.BlossomChestInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 41;
                onChanged();
                return this.blossomChestBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasMpPlayReward() {
                return this.contentCase_ == 42;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public MpPlayRewardInfoOuterClass.MpPlayRewardInfo getMpPlayReward() {
                if (this.mpPlayRewardBuilder_ == null) {
                    if (this.contentCase_ == 42) {
                        return (MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_;
                    }
                    return MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance();
                } else if (this.contentCase_ == 42) {
                    return this.mpPlayRewardBuilder_.getMessage();
                } else {
                    return MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance();
                }
            }

            public Builder setMpPlayReward(MpPlayRewardInfoOuterClass.MpPlayRewardInfo value) {
                if (this.mpPlayRewardBuilder_ != null) {
                    this.mpPlayRewardBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 42;
                return this;
            }

            public Builder setMpPlayReward(MpPlayRewardInfoOuterClass.MpPlayRewardInfo.Builder builderForValue) {
                if (this.mpPlayRewardBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mpPlayRewardBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 42;
                return this;
            }

            public Builder mergeMpPlayReward(MpPlayRewardInfoOuterClass.MpPlayRewardInfo value) {
                if (this.mpPlayRewardBuilder_ == null) {
                    if (this.contentCase_ != 42 || this.content_ == MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = MpPlayRewardInfoOuterClass.MpPlayRewardInfo.newBuilder((MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 42) {
                        this.mpPlayRewardBuilder_.mergeFrom(value);
                    }
                    this.mpPlayRewardBuilder_.setMessage(value);
                }
                this.contentCase_ = 42;
                return this;
            }

            public Builder clearMpPlayReward() {
                if (this.mpPlayRewardBuilder_ != null) {
                    if (this.contentCase_ == 42) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.mpPlayRewardBuilder_.clear();
                } else if (this.contentCase_ == 42) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public MpPlayRewardInfoOuterClass.MpPlayRewardInfo.Builder getMpPlayRewardBuilder() {
                return getMpPlayRewardFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder getMpPlayRewardOrBuilder() {
                if (this.contentCase_ == 42 && this.mpPlayRewardBuilder_ != null) {
                    return this.mpPlayRewardBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 42) {
                    return (MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_;
                }
                return MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MpPlayRewardInfoOuterClass.MpPlayRewardInfo, MpPlayRewardInfoOuterClass.MpPlayRewardInfo.Builder, MpPlayRewardInfoOuterClass.MpPlayRewardInfoOrBuilder> getMpPlayRewardFieldBuilder() {
                if (this.mpPlayRewardBuilder_ == null) {
                    if (this.contentCase_ != 42) {
                        this.content_ = MpPlayRewardInfoOuterClass.MpPlayRewardInfo.getDefaultInstance();
                    }
                    this.mpPlayRewardBuilder_ = new SingleFieldBuilderV3<>((MpPlayRewardInfoOuterClass.MpPlayRewardInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 42;
                onChanged();
                return this.mpPlayRewardBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasGeneralReward() {
                return this.contentCase_ == 43;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo getGeneralReward() {
                if (this.generalRewardBuilder_ == null) {
                    if (this.contentCase_ == 43) {
                        return (GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_;
                    }
                    return GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance();
                } else if (this.contentCase_ == 43) {
                    return this.generalRewardBuilder_.getMessage();
                } else {
                    return GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance();
                }
            }

            public Builder setGeneralReward(GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo value) {
                if (this.generalRewardBuilder_ != null) {
                    this.generalRewardBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 43;
                return this;
            }

            public Builder setGeneralReward(GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.Builder builderForValue) {
                if (this.generalRewardBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.generalRewardBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 43;
                return this;
            }

            public Builder mergeGeneralReward(GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo value) {
                if (this.generalRewardBuilder_ == null) {
                    if (this.contentCase_ != 43 || this.content_ == GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.newBuilder((GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 43) {
                        this.generalRewardBuilder_.mergeFrom(value);
                    }
                    this.generalRewardBuilder_.setMessage(value);
                }
                this.contentCase_ = 43;
                return this;
            }

            public Builder clearGeneralReward() {
                if (this.generalRewardBuilder_ != null) {
                    if (this.contentCase_ == 43) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.generalRewardBuilder_.clear();
                } else if (this.contentCase_ == 43) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.Builder getGeneralRewardBuilder() {
                return getGeneralRewardFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder getGeneralRewardOrBuilder() {
                if (this.contentCase_ == 43 && this.generalRewardBuilder_ != null) {
                    return this.generalRewardBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 43) {
                    return (GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_;
                }
                return GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo, GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.Builder, GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfoOrBuilder> getGeneralRewardFieldBuilder() {
                if (this.generalRewardBuilder_ == null) {
                    if (this.contentCase_ != 43) {
                        this.content_ = GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo.getDefaultInstance();
                    }
                    this.generalRewardBuilder_ = new SingleFieldBuilderV3<>((GadgetGeneralRewardInfoOuterClass.GadgetGeneralRewardInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 43;
                onChanged();
                return this.generalRewardBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasOfferingInfo() {
                return this.contentCase_ == 44;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public OfferingInfoOuterClass.OfferingInfo getOfferingInfo() {
                if (this.offeringInfoBuilder_ == null) {
                    if (this.contentCase_ == 44) {
                        return (OfferingInfoOuterClass.OfferingInfo) this.content_;
                    }
                    return OfferingInfoOuterClass.OfferingInfo.getDefaultInstance();
                } else if (this.contentCase_ == 44) {
                    return this.offeringInfoBuilder_.getMessage();
                } else {
                    return OfferingInfoOuterClass.OfferingInfo.getDefaultInstance();
                }
            }

            public Builder setOfferingInfo(OfferingInfoOuterClass.OfferingInfo value) {
                if (this.offeringInfoBuilder_ != null) {
                    this.offeringInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 44;
                return this;
            }

            public Builder setOfferingInfo(OfferingInfoOuterClass.OfferingInfo.Builder builderForValue) {
                if (this.offeringInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.offeringInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 44;
                return this;
            }

            public Builder mergeOfferingInfo(OfferingInfoOuterClass.OfferingInfo value) {
                if (this.offeringInfoBuilder_ == null) {
                    if (this.contentCase_ != 44 || this.content_ == OfferingInfoOuterClass.OfferingInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = OfferingInfoOuterClass.OfferingInfo.newBuilder((OfferingInfoOuterClass.OfferingInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 44) {
                        this.offeringInfoBuilder_.mergeFrom(value);
                    }
                    this.offeringInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 44;
                return this;
            }

            public Builder clearOfferingInfo() {
                if (this.offeringInfoBuilder_ != null) {
                    if (this.contentCase_ == 44) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.offeringInfoBuilder_.clear();
                } else if (this.contentCase_ == 44) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public OfferingInfoOuterClass.OfferingInfo.Builder getOfferingInfoBuilder() {
                return getOfferingInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public OfferingInfoOuterClass.OfferingInfoOrBuilder getOfferingInfoOrBuilder() {
                if (this.contentCase_ == 44 && this.offeringInfoBuilder_ != null) {
                    return this.offeringInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 44) {
                    return (OfferingInfoOuterClass.OfferingInfo) this.content_;
                }
                return OfferingInfoOuterClass.OfferingInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<OfferingInfoOuterClass.OfferingInfo, OfferingInfoOuterClass.OfferingInfo.Builder, OfferingInfoOuterClass.OfferingInfoOrBuilder> getOfferingInfoFieldBuilder() {
                if (this.offeringInfoBuilder_ == null) {
                    if (this.contentCase_ != 44) {
                        this.content_ = OfferingInfoOuterClass.OfferingInfo.getDefaultInstance();
                    }
                    this.offeringInfoBuilder_ = new SingleFieldBuilderV3<>((OfferingInfoOuterClass.OfferingInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 44;
                onChanged();
                return this.offeringInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasFoundationInfo() {
                return this.contentCase_ == 45;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public FoundationInfoOuterClass.FoundationInfo getFoundationInfo() {
                if (this.foundationInfoBuilder_ == null) {
                    if (this.contentCase_ == 45) {
                        return (FoundationInfoOuterClass.FoundationInfo) this.content_;
                    }
                    return FoundationInfoOuterClass.FoundationInfo.getDefaultInstance();
                } else if (this.contentCase_ == 45) {
                    return this.foundationInfoBuilder_.getMessage();
                } else {
                    return FoundationInfoOuterClass.FoundationInfo.getDefaultInstance();
                }
            }

            public Builder setFoundationInfo(FoundationInfoOuterClass.FoundationInfo value) {
                if (this.foundationInfoBuilder_ != null) {
                    this.foundationInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 45;
                return this;
            }

            public Builder setFoundationInfo(FoundationInfoOuterClass.FoundationInfo.Builder builderForValue) {
                if (this.foundationInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.foundationInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 45;
                return this;
            }

            public Builder mergeFoundationInfo(FoundationInfoOuterClass.FoundationInfo value) {
                if (this.foundationInfoBuilder_ == null) {
                    if (this.contentCase_ != 45 || this.content_ == FoundationInfoOuterClass.FoundationInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = FoundationInfoOuterClass.FoundationInfo.newBuilder((FoundationInfoOuterClass.FoundationInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 45) {
                        this.foundationInfoBuilder_.mergeFrom(value);
                    }
                    this.foundationInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 45;
                return this;
            }

            public Builder clearFoundationInfo() {
                if (this.foundationInfoBuilder_ != null) {
                    if (this.contentCase_ == 45) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.foundationInfoBuilder_.clear();
                } else if (this.contentCase_ == 45) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public FoundationInfoOuterClass.FoundationInfo.Builder getFoundationInfoBuilder() {
                return getFoundationInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public FoundationInfoOuterClass.FoundationInfoOrBuilder getFoundationInfoOrBuilder() {
                if (this.contentCase_ == 45 && this.foundationInfoBuilder_ != null) {
                    return this.foundationInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 45) {
                    return (FoundationInfoOuterClass.FoundationInfo) this.content_;
                }
                return FoundationInfoOuterClass.FoundationInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FoundationInfoOuterClass.FoundationInfo, FoundationInfoOuterClass.FoundationInfo.Builder, FoundationInfoOuterClass.FoundationInfoOrBuilder> getFoundationInfoFieldBuilder() {
                if (this.foundationInfoBuilder_ == null) {
                    if (this.contentCase_ != 45) {
                        this.content_ = FoundationInfoOuterClass.FoundationInfo.getDefaultInstance();
                    }
                    this.foundationInfoBuilder_ = new SingleFieldBuilderV3<>((FoundationInfoOuterClass.FoundationInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 45;
                onChanged();
                return this.foundationInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasVehicleInfo() {
                return this.contentCase_ == 46;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public VehicleInfoOuterClass.VehicleInfo getVehicleInfo() {
                if (this.vehicleInfoBuilder_ == null) {
                    if (this.contentCase_ == 46) {
                        return (VehicleInfoOuterClass.VehicleInfo) this.content_;
                    }
                    return VehicleInfoOuterClass.VehicleInfo.getDefaultInstance();
                } else if (this.contentCase_ == 46) {
                    return this.vehicleInfoBuilder_.getMessage();
                } else {
                    return VehicleInfoOuterClass.VehicleInfo.getDefaultInstance();
                }
            }

            public Builder setVehicleInfo(VehicleInfoOuterClass.VehicleInfo value) {
                if (this.vehicleInfoBuilder_ != null) {
                    this.vehicleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 46;
                return this;
            }

            public Builder setVehicleInfo(VehicleInfoOuterClass.VehicleInfo.Builder builderForValue) {
                if (this.vehicleInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.vehicleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 46;
                return this;
            }

            public Builder mergeVehicleInfo(VehicleInfoOuterClass.VehicleInfo value) {
                if (this.vehicleInfoBuilder_ == null) {
                    if (this.contentCase_ != 46 || this.content_ == VehicleInfoOuterClass.VehicleInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = VehicleInfoOuterClass.VehicleInfo.newBuilder((VehicleInfoOuterClass.VehicleInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 46) {
                        this.vehicleInfoBuilder_.mergeFrom(value);
                    }
                    this.vehicleInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 46;
                return this;
            }

            public Builder clearVehicleInfo() {
                if (this.vehicleInfoBuilder_ != null) {
                    if (this.contentCase_ == 46) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.vehicleInfoBuilder_.clear();
                } else if (this.contentCase_ == 46) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public VehicleInfoOuterClass.VehicleInfo.Builder getVehicleInfoBuilder() {
                return getVehicleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public VehicleInfoOuterClass.VehicleInfoOrBuilder getVehicleInfoOrBuilder() {
                if (this.contentCase_ == 46 && this.vehicleInfoBuilder_ != null) {
                    return this.vehicleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 46) {
                    return (VehicleInfoOuterClass.VehicleInfo) this.content_;
                }
                return VehicleInfoOuterClass.VehicleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<VehicleInfoOuterClass.VehicleInfo, VehicleInfoOuterClass.VehicleInfo.Builder, VehicleInfoOuterClass.VehicleInfoOrBuilder> getVehicleInfoFieldBuilder() {
                if (this.vehicleInfoBuilder_ == null) {
                    if (this.contentCase_ != 46) {
                        this.content_ = VehicleInfoOuterClass.VehicleInfo.getDefaultInstance();
                    }
                    this.vehicleInfoBuilder_ = new SingleFieldBuilderV3<>((VehicleInfoOuterClass.VehicleInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 46;
                onChanged();
                return this.vehicleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasShellInfo() {
                return this.contentCase_ == 47;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public EchoShellInfoOuterClass.EchoShellInfo getShellInfo() {
                if (this.shellInfoBuilder_ == null) {
                    if (this.contentCase_ == 47) {
                        return (EchoShellInfoOuterClass.EchoShellInfo) this.content_;
                    }
                    return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
                } else if (this.contentCase_ == 47) {
                    return this.shellInfoBuilder_.getMessage();
                } else {
                    return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
                }
            }

            public Builder setShellInfo(EchoShellInfoOuterClass.EchoShellInfo value) {
                if (this.shellInfoBuilder_ != null) {
                    this.shellInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 47;
                return this;
            }

            public Builder setShellInfo(EchoShellInfoOuterClass.EchoShellInfo.Builder builderForValue) {
                if (this.shellInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.shellInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 47;
                return this;
            }

            public Builder mergeShellInfo(EchoShellInfoOuterClass.EchoShellInfo value) {
                if (this.shellInfoBuilder_ == null) {
                    if (this.contentCase_ != 47 || this.content_ == EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = EchoShellInfoOuterClass.EchoShellInfo.newBuilder((EchoShellInfoOuterClass.EchoShellInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 47) {
                        this.shellInfoBuilder_.mergeFrom(value);
                    }
                    this.shellInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 47;
                return this;
            }

            public Builder clearShellInfo() {
                if (this.shellInfoBuilder_ != null) {
                    if (this.contentCase_ == 47) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.shellInfoBuilder_.clear();
                } else if (this.contentCase_ == 47) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public EchoShellInfoOuterClass.EchoShellInfo.Builder getShellInfoBuilder() {
                return getShellInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public EchoShellInfoOuterClass.EchoShellInfoOrBuilder getShellInfoOrBuilder() {
                if (this.contentCase_ == 47 && this.shellInfoBuilder_ != null) {
                    return this.shellInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 47) {
                    return (EchoShellInfoOuterClass.EchoShellInfo) this.content_;
                }
                return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EchoShellInfoOuterClass.EchoShellInfo, EchoShellInfoOuterClass.EchoShellInfo.Builder, EchoShellInfoOuterClass.EchoShellInfoOrBuilder> getShellInfoFieldBuilder() {
                if (this.shellInfoBuilder_ == null) {
                    if (this.contentCase_ != 47) {
                        this.content_ = EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
                    }
                    this.shellInfoBuilder_ = new SingleFieldBuilderV3<>((EchoShellInfoOuterClass.EchoShellInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 47;
                onChanged();
                return this.shellInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasScreenInfo() {
                return this.contentCase_ == 48;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ScreenInfoOuterClass.ScreenInfo getScreenInfo() {
                if (this.screenInfoBuilder_ == null) {
                    if (this.contentCase_ == 48) {
                        return (ScreenInfoOuterClass.ScreenInfo) this.content_;
                    }
                    return ScreenInfoOuterClass.ScreenInfo.getDefaultInstance();
                } else if (this.contentCase_ == 48) {
                    return this.screenInfoBuilder_.getMessage();
                } else {
                    return ScreenInfoOuterClass.ScreenInfo.getDefaultInstance();
                }
            }

            public Builder setScreenInfo(ScreenInfoOuterClass.ScreenInfo value) {
                if (this.screenInfoBuilder_ != null) {
                    this.screenInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 48;
                return this;
            }

            public Builder setScreenInfo(ScreenInfoOuterClass.ScreenInfo.Builder builderForValue) {
                if (this.screenInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.screenInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 48;
                return this;
            }

            public Builder mergeScreenInfo(ScreenInfoOuterClass.ScreenInfo value) {
                if (this.screenInfoBuilder_ == null) {
                    if (this.contentCase_ != 48 || this.content_ == ScreenInfoOuterClass.ScreenInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = ScreenInfoOuterClass.ScreenInfo.newBuilder((ScreenInfoOuterClass.ScreenInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 48) {
                        this.screenInfoBuilder_.mergeFrom(value);
                    }
                    this.screenInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 48;
                return this;
            }

            public Builder clearScreenInfo() {
                if (this.screenInfoBuilder_ != null) {
                    if (this.contentCase_ == 48) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.screenInfoBuilder_.clear();
                } else if (this.contentCase_ == 48) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public ScreenInfoOuterClass.ScreenInfo.Builder getScreenInfoBuilder() {
                return getScreenInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public ScreenInfoOuterClass.ScreenInfoOrBuilder getScreenInfoOrBuilder() {
                if (this.contentCase_ == 48 && this.screenInfoBuilder_ != null) {
                    return this.screenInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 48) {
                    return (ScreenInfoOuterClass.ScreenInfo) this.content_;
                }
                return ScreenInfoOuterClass.ScreenInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ScreenInfoOuterClass.ScreenInfo, ScreenInfoOuterClass.ScreenInfo.Builder, ScreenInfoOuterClass.ScreenInfoOrBuilder> getScreenInfoFieldBuilder() {
                if (this.screenInfoBuilder_ == null) {
                    if (this.contentCase_ != 48) {
                        this.content_ = ScreenInfoOuterClass.ScreenInfo.getDefaultInstance();
                    }
                    this.screenInfoBuilder_ = new SingleFieldBuilderV3<>((ScreenInfoOuterClass.ScreenInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 48;
                onChanged();
                return this.screenInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasFishPoolInfo() {
                return this.contentCase_ == 59;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public FishPoolInfoOuterClass.FishPoolInfo getFishPoolInfo() {
                if (this.fishPoolInfoBuilder_ == null) {
                    if (this.contentCase_ == 59) {
                        return (FishPoolInfoOuterClass.FishPoolInfo) this.content_;
                    }
                    return FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance();
                } else if (this.contentCase_ == 59) {
                    return this.fishPoolInfoBuilder_.getMessage();
                } else {
                    return FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance();
                }
            }

            public Builder setFishPoolInfo(FishPoolInfoOuterClass.FishPoolInfo value) {
                if (this.fishPoolInfoBuilder_ != null) {
                    this.fishPoolInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 59;
                return this;
            }

            public Builder setFishPoolInfo(FishPoolInfoOuterClass.FishPoolInfo.Builder builderForValue) {
                if (this.fishPoolInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fishPoolInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 59;
                return this;
            }

            public Builder mergeFishPoolInfo(FishPoolInfoOuterClass.FishPoolInfo value) {
                if (this.fishPoolInfoBuilder_ == null) {
                    if (this.contentCase_ != 59 || this.content_ == FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = FishPoolInfoOuterClass.FishPoolInfo.newBuilder((FishPoolInfoOuterClass.FishPoolInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 59) {
                        this.fishPoolInfoBuilder_.mergeFrom(value);
                    }
                    this.fishPoolInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 59;
                return this;
            }

            public Builder clearFishPoolInfo() {
                if (this.fishPoolInfoBuilder_ != null) {
                    if (this.contentCase_ == 59) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.fishPoolInfoBuilder_.clear();
                } else if (this.contentCase_ == 59) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public FishPoolInfoOuterClass.FishPoolInfo.Builder getFishPoolInfoBuilder() {
                return getFishPoolInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public FishPoolInfoOuterClass.FishPoolInfoOrBuilder getFishPoolInfoOrBuilder() {
                if (this.contentCase_ == 59 && this.fishPoolInfoBuilder_ != null) {
                    return this.fishPoolInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 59) {
                    return (FishPoolInfoOuterClass.FishPoolInfo) this.content_;
                }
                return FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FishPoolInfoOuterClass.FishPoolInfo, FishPoolInfoOuterClass.FishPoolInfo.Builder, FishPoolInfoOuterClass.FishPoolInfoOrBuilder> getFishPoolInfoFieldBuilder() {
                if (this.fishPoolInfoBuilder_ == null) {
                    if (this.contentCase_ != 59) {
                        this.content_ = FishPoolInfoOuterClass.FishPoolInfo.getDefaultInstance();
                    }
                    this.fishPoolInfoBuilder_ = new SingleFieldBuilderV3<>((FishPoolInfoOuterClass.FishPoolInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 59;
                onChanged();
                return this.fishPoolInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasCustomGadgetTreeInfo() {
                return this.contentCase_ == 60;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo getCustomGadgetTreeInfo() {
                if (this.customGadgetTreeInfoBuilder_ == null) {
                    if (this.contentCase_ == 60) {
                        return (CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_;
                    }
                    return CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance();
                } else if (this.contentCase_ == 60) {
                    return this.customGadgetTreeInfoBuilder_.getMessage();
                } else {
                    return CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance();
                }
            }

            public Builder setCustomGadgetTreeInfo(CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo value) {
                if (this.customGadgetTreeInfoBuilder_ != null) {
                    this.customGadgetTreeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 60;
                return this;
            }

            public Builder setCustomGadgetTreeInfo(CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.Builder builderForValue) {
                if (this.customGadgetTreeInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.customGadgetTreeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 60;
                return this;
            }

            public Builder mergeCustomGadgetTreeInfo(CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo value) {
                if (this.customGadgetTreeInfoBuilder_ == null) {
                    if (this.contentCase_ != 60 || this.content_ == CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.newBuilder((CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 60) {
                        this.customGadgetTreeInfoBuilder_.mergeFrom(value);
                    }
                    this.customGadgetTreeInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 60;
                return this;
            }

            public Builder clearCustomGadgetTreeInfo() {
                if (this.customGadgetTreeInfoBuilder_ != null) {
                    if (this.contentCase_ == 60) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.customGadgetTreeInfoBuilder_.clear();
                } else if (this.contentCase_ == 60) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.Builder getCustomGadgetTreeInfoBuilder() {
                return getCustomGadgetTreeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder getCustomGadgetTreeInfoOrBuilder() {
                if (this.contentCase_ == 60 && this.customGadgetTreeInfoBuilder_ != null) {
                    return this.customGadgetTreeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 60) {
                    return (CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_;
                }
                return CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo, CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.Builder, CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfoOrBuilder> getCustomGadgetTreeInfoFieldBuilder() {
                if (this.customGadgetTreeInfoBuilder_ == null) {
                    if (this.contentCase_ != 60) {
                        this.content_ = CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo.getDefaultInstance();
                    }
                    this.customGadgetTreeInfoBuilder_ = new SingleFieldBuilderV3<>((CustomGadgetTreeInfoOuterClass.CustomGadgetTreeInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 60;
                onChanged();
                return this.customGadgetTreeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasRoguelikeGadgetInfo() {
                return this.contentCase_ == 61;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo getRoguelikeGadgetInfo() {
                if (this.roguelikeGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ == 61) {
                        return (RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_;
                    }
                    return RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 61) {
                    return this.roguelikeGadgetInfoBuilder_.getMessage();
                } else {
                    return RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setRoguelikeGadgetInfo(RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo value) {
                if (this.roguelikeGadgetInfoBuilder_ != null) {
                    this.roguelikeGadgetInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 61;
                return this;
            }

            public Builder setRoguelikeGadgetInfo(RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.Builder builderForValue) {
                if (this.roguelikeGadgetInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.roguelikeGadgetInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 61;
                return this;
            }

            public Builder mergeRoguelikeGadgetInfo(RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo value) {
                if (this.roguelikeGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ != 61 || this.content_ == RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.newBuilder((RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 61) {
                        this.roguelikeGadgetInfoBuilder_.mergeFrom(value);
                    }
                    this.roguelikeGadgetInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 61;
                return this;
            }

            public Builder clearRoguelikeGadgetInfo() {
                if (this.roguelikeGadgetInfoBuilder_ != null) {
                    if (this.contentCase_ == 61) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.roguelikeGadgetInfoBuilder_.clear();
                } else if (this.contentCase_ == 61) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.Builder getRoguelikeGadgetInfoBuilder() {
                return getRoguelikeGadgetInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder getRoguelikeGadgetInfoOrBuilder() {
                if (this.contentCase_ == 61 && this.roguelikeGadgetInfoBuilder_ != null) {
                    return this.roguelikeGadgetInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 61) {
                    return (RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_;
                }
                return RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo, RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.Builder, RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfoOrBuilder> getRoguelikeGadgetInfoFieldBuilder() {
                if (this.roguelikeGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ != 61) {
                        this.content_ = RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo.getDefaultInstance();
                    }
                    this.roguelikeGadgetInfoBuilder_ = new SingleFieldBuilderV3<>((RoguelikeGadgetInfoOuterClass.RoguelikeGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 61;
                onChanged();
                return this.roguelikeGadgetInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasNightCrowGadgetInfo() {
                return this.contentCase_ == 62;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo getNightCrowGadgetInfo() {
                if (this.nightCrowGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ == 62) {
                        return (NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_;
                    }
                    return NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 62) {
                    return this.nightCrowGadgetInfoBuilder_.getMessage();
                } else {
                    return NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setNightCrowGadgetInfo(NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo value) {
                if (this.nightCrowGadgetInfoBuilder_ != null) {
                    this.nightCrowGadgetInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 62;
                return this;
            }

            public Builder setNightCrowGadgetInfo(NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.Builder builderForValue) {
                if (this.nightCrowGadgetInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.nightCrowGadgetInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 62;
                return this;
            }

            public Builder mergeNightCrowGadgetInfo(NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo value) {
                if (this.nightCrowGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ != 62 || this.content_ == NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.newBuilder((NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 62) {
                        this.nightCrowGadgetInfoBuilder_.mergeFrom(value);
                    }
                    this.nightCrowGadgetInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 62;
                return this;
            }

            public Builder clearNightCrowGadgetInfo() {
                if (this.nightCrowGadgetInfoBuilder_ != null) {
                    if (this.contentCase_ == 62) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.nightCrowGadgetInfoBuilder_.clear();
                } else if (this.contentCase_ == 62) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.Builder getNightCrowGadgetInfoBuilder() {
                return getNightCrowGadgetInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder getNightCrowGadgetInfoOrBuilder() {
                if (this.contentCase_ == 62 && this.nightCrowGadgetInfoBuilder_ != null) {
                    return this.nightCrowGadgetInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 62) {
                    return (NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_;
                }
                return NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo, NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.Builder, NightCrowGadgetInfoOuterClass.NightCrowGadgetInfoOrBuilder> getNightCrowGadgetInfoFieldBuilder() {
                if (this.nightCrowGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ != 62) {
                        this.content_ = NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo.getDefaultInstance();
                    }
                    this.nightCrowGadgetInfoBuilder_ = new SingleFieldBuilderV3<>((NightCrowGadgetInfoOuterClass.NightCrowGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 62;
                onChanged();
                return this.nightCrowGadgetInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasDeshretObeliskGadgetInfo() {
                return this.contentCase_ == 63;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo getDeshretObeliskGadgetInfo() {
                if (this.deshretObeliskGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ == 63) {
                        return (DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_;
                    }
                    return DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance();
                } else if (this.contentCase_ == 63) {
                    return this.deshretObeliskGadgetInfoBuilder_.getMessage();
                } else {
                    return DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance();
                }
            }

            public Builder setDeshretObeliskGadgetInfo(DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo value) {
                if (this.deshretObeliskGadgetInfoBuilder_ != null) {
                    this.deshretObeliskGadgetInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 63;
                return this;
            }

            public Builder setDeshretObeliskGadgetInfo(DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.Builder builderForValue) {
                if (this.deshretObeliskGadgetInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.deshretObeliskGadgetInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 63;
                return this;
            }

            public Builder mergeDeshretObeliskGadgetInfo(DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo value) {
                if (this.deshretObeliskGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ != 63 || this.content_ == DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.newBuilder((DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 63) {
                        this.deshretObeliskGadgetInfoBuilder_.mergeFrom(value);
                    }
                    this.deshretObeliskGadgetInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 63;
                return this;
            }

            public Builder clearDeshretObeliskGadgetInfo() {
                if (this.deshretObeliskGadgetInfoBuilder_ != null) {
                    if (this.contentCase_ == 63) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.deshretObeliskGadgetInfoBuilder_.clear();
                } else if (this.contentCase_ == 63) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.Builder getDeshretObeliskGadgetInfoBuilder() {
                return getDeshretObeliskGadgetInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfoOrBuilder getDeshretObeliskGadgetInfoOrBuilder() {
                if (this.contentCase_ == 63 && this.deshretObeliskGadgetInfoBuilder_ != null) {
                    return this.deshretObeliskGadgetInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 63) {
                    return (DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_;
                }
                return DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo, DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.Builder, DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfoOrBuilder> getDeshretObeliskGadgetInfoFieldBuilder() {
                if (this.deshretObeliskGadgetInfoBuilder_ == null) {
                    if (this.contentCase_ != 63) {
                        this.content_ = DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo.getDefaultInstance();
                    }
                    this.deshretObeliskGadgetInfoBuilder_ = new SingleFieldBuilderV3<>((DeshretObeliskGadgetInfoOuterClass.DeshretObeliskGadgetInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 63;
                onChanged();
                return this.deshretObeliskGadgetInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public boolean hasCoinCollectOperatorInfo() {
                return this.contentCase_ == 64;
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo getCoinCollectOperatorInfo() {
                if (this.coinCollectOperatorInfoBuilder_ == null) {
                    if (this.contentCase_ == 64) {
                        return (CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_;
                    }
                    return CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance();
                } else if (this.contentCase_ == 64) {
                    return this.coinCollectOperatorInfoBuilder_.getMessage();
                } else {
                    return CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance();
                }
            }

            public Builder setCoinCollectOperatorInfo(CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo value) {
                if (this.coinCollectOperatorInfoBuilder_ != null) {
                    this.coinCollectOperatorInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.content_ = value;
                    onChanged();
                }
                this.contentCase_ = 64;
                return this;
            }

            public Builder setCoinCollectOperatorInfo(CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.Builder builderForValue) {
                if (this.coinCollectOperatorInfoBuilder_ == null) {
                    this.content_ = builderForValue.build();
                    onChanged();
                } else {
                    this.coinCollectOperatorInfoBuilder_.setMessage(builderForValue.build());
                }
                this.contentCase_ = 64;
                return this;
            }

            public Builder mergeCoinCollectOperatorInfo(CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo value) {
                if (this.coinCollectOperatorInfoBuilder_ == null) {
                    if (this.contentCase_ != 64 || this.content_ == CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance()) {
                        this.content_ = value;
                    } else {
                        this.content_ = CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.newBuilder((CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.contentCase_ == 64) {
                        this.coinCollectOperatorInfoBuilder_.mergeFrom(value);
                    }
                    this.coinCollectOperatorInfoBuilder_.setMessage(value);
                }
                this.contentCase_ = 64;
                return this;
            }

            public Builder clearCoinCollectOperatorInfo() {
                if (this.coinCollectOperatorInfoBuilder_ != null) {
                    if (this.contentCase_ == 64) {
                        this.contentCase_ = 0;
                        this.content_ = null;
                    }
                    this.coinCollectOperatorInfoBuilder_.clear();
                } else if (this.contentCase_ == 64) {
                    this.contentCase_ = 0;
                    this.content_ = null;
                    onChanged();
                }
                return this;
            }

            public CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.Builder getCoinCollectOperatorInfoBuilder() {
                return getCoinCollectOperatorInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneGadgetInfoOuterClass.SceneGadgetInfoOrBuilder
            public CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfoOrBuilder getCoinCollectOperatorInfoOrBuilder() {
                if (this.contentCase_ == 64 && this.coinCollectOperatorInfoBuilder_ != null) {
                    return this.coinCollectOperatorInfoBuilder_.getMessageOrBuilder();
                }
                if (this.contentCase_ == 64) {
                    return (CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_;
                }
                return CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo, CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.Builder, CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfoOrBuilder> getCoinCollectOperatorInfoFieldBuilder() {
                if (this.coinCollectOperatorInfoBuilder_ == null) {
                    if (this.contentCase_ != 64) {
                        this.content_ = CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo.getDefaultInstance();
                    }
                    this.coinCollectOperatorInfoBuilder_ = new SingleFieldBuilderV3<>((CoinCollectOperatorInfoOuterClass.CoinCollectOperatorInfo) this.content_, getParentForChildren(), isClean());
                    this.content_ = null;
                }
                this.contentCase_ = 64;
                onChanged();
                return this.coinCollectOperatorInfoBuilder_;
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

        public static SceneGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityGadgetInfoOuterClass.getDescriptor();
        BlossomChestInfoOuterClass.getDescriptor();
        BossChestInfoOuterClass.getDescriptor();
        ClientGadgetInfoOuterClass.getDescriptor();
        CoinCollectOperatorInfoOuterClass.getDescriptor();
        CustomGadgetTreeInfoOuterClass.getDescriptor();
        DeshretObeliskGadgetInfoOuterClass.getDescriptor();
        EchoShellInfoOuterClass.getDescriptor();
        FishPoolInfoOuterClass.getDescriptor();
        FoundationInfoOuterClass.getDescriptor();
        GadgetBornTypeOuterClass.getDescriptor();
        GadgetGeneralRewardInfoOuterClass.getDescriptor();
        GadgetPlayInfoOuterClass.getDescriptor();
        GatherGadgetInfoOuterClass.getDescriptor();
        ItemOuterClass.getDescriptor();
        MpPlayRewardInfoOuterClass.getDescriptor();
        NightCrowGadgetInfoOuterClass.getDescriptor();
        OfferingInfoOuterClass.getDescriptor();
        PlatformInfoOuterClass.getDescriptor();
        RoguelikeGadgetInfoOuterClass.getDescriptor();
        ScreenInfoOuterClass.getDescriptor();
        StatueGadgetInfoOuterClass.getDescriptor();
        VehicleInfoOuterClass.getDescriptor();
        WeatherInfoOuterClass.getDescriptor();
        WorktopInfoOuterClass.getDescriptor();
    }
}
