package emu.grasscutter.game.shop;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass;
import emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass;
import emu.grasscutter.net.proto.PlayerLoginReqOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import org.eclipse.jetty.websocket.api.StatusCode;

/* loaded from: grasscutter.jar:emu/grasscutter/game/shop/ShopType.class */
public enum ShopType {
    SHOP_TYPE_NONE(0),
    SHOP_TYPE_PAIMON(900),
    SHOP_TYPE_PACKAGE(902),
    SHOP_TYPE_MCOIN(903),
    SHOP_TYPE_RECOMMEND(1001),
    SHOP_TYPE_CITY(1002),
    SHOP_TYPE_BLACKSMITH(1003),
    SHOP_TYPE_GROCERY(StatusCode.UNDEFINED),
    SHOP_TYPE_FOOD(1005),
    SHOP_TYPE_SEA_LAMP(1006),
    SHOP_TYPE_VIRTUAL_SHOP(1007),
    SHOP_TYPE_LIYUE_GROCERY(StatusCode.POLICY_VIOLATION),
    SHOP_TYPE_LIYUE_SOUVENIR(StatusCode.MESSAGE_TOO_LARGE),
    SHOP_TYPE_LIYUE_RESTAURANT(StatusCode.REQUIRED_EXTENSION),
    SHOP_TYPE_NPC_Flora(StatusCode.SERVER_ERROR),
    SHOP_TYPE_NPC_Charles(StatusCode.SERVICE_RESTART),
    SHOP_TYPE_NPC_Shiliu(StatusCode.TRY_AGAIN_LATER),
    SHOP_TYPE_NPC_Schulz(StatusCode.INVALID_UPSTREAM_RESPONSE),
    SHOP_TYPE_NPC_Brook(StatusCode.FAILED_TLS_HANDSHAKE),
    SHOP_TYPE_NPC_Hopkins(1016),
    SHOP_TYPE_NPC_Draff(1017),
    SHOP_TYPE_NPC_Chloris(1018),
    SHOP_TYPE_NPC_Licai(PacketOpcodes.AvatarSkillDepotChangeNotify),
    SHOP_TYPE_NPC_Yueshu(1020),
    SHOP_TYPE_NPC_Gui(MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReq.MUSIC_BRIEF_INFO_FIELD_NUMBER),
    SHOP_TYPE_NPC_Gao(1022),
    SHOP_TYPE_NPC_Sun(1023),
    SHOP_TYPE_NPC_Qiming(1024),
    SHOP_TYPE_NPC_Zhangshun(PacketOpcodes.ProudSkillExtraLevelNotify),
    SHOP_TYPE_NPC_Chen(1026),
    SHOP_TYPE_NPC_ErNiang(PacketOpcodes.ProudSkillChangeNotify),
    SHOP_TYPE_NPC_Shitou(PlayerLoginReqOuterClass.PlayerLoginReq.UNK3300_OFFHPAFIFGD_FIELD_NUMBER),
    SHOP_TYPE_NPC_Jifang(1029),
    SHOP_TYPE_NPC_Zhu(PacketOpcodes.UnlockAvatarTalentRsp),
    SHOP_TYPE_NPC_Bai(1031),
    SHOP_TYPE_NPC_Kai(ActivityInfoOuterClass.ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER),
    SHOP_TYPE_NPC_Linglang(1033),
    SHOP_TYPE_NPC_VerrGoldet(1034),
    SHOP_TYPE_NPC_Zhou(1035),
    SHOP_TYPE_TASK_Ekaterina(1036),
    SHOP_TYPE_ACTIVITY_ASTER(ShopGoodsOuterClass.ShopGoods.UNK3300_OMKIFIMDGDN_FIELD_NUMBER),
    SHOP_TYPE_TASK_Tartaglia(GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.SUB_CHANNEL_ID_FIELD_NUMBER),
    SHOP_TYPE_NPC_Harris(PacketOpcodes.AvatarSkillUpgradeReq),
    SHOP_TYPE_ACTIVITY_DRAGON_SPINE(1040),
    SHOP_TYPE_ACTIVITY_TREASURE_MAP(1041),
    SHOP_TYPE_NPC_Yinian(PacketOpcodes.CanUseSkillNotify),
    SHOP_TYPE_ACTIVITY_SEA_LAMP(PacketOpcodes.BigTalentPointConvertRsp),
    SHOP_TYPE_ACTIVITY_FLEUR_FAIR(1044),
    SHOP_TYPE_NPC_Changshun(1045),
    SHOP_TYPE_NPC_Bolai(1046),
    SHOP_TYPE_NPC_Ashanpo(PacketOpcodes.AvatarSkillInfoNotify),
    SHOP_TYPE_HOME(PacketOpcodes.AvatarSkillUpgradeRsp),
    SHOP_TYPE_HOME_LIMIT(1049),
    SHOP_TYPE_NPC_MasterLu(1050),
    SHOP_TYPE_NPC_Goth(1051),
    SHOP_TYPE_COSTUME(1052),
    SHOP_TYPE_NPC_Obata(1053),
    SHOP_TYPE_NPC_Qiuyue(1054),
    SHOP_TYPE_NPC_Ryouko(1055),
    SHOP_TYPE_INAZUMA_GROCERY(1056),
    SHOP_TYPE_INAZUMA_SOUVENIR(PacketOpcodes.ProudSkillUpgradeRsp),
    SHOP_TYPE_INAZUMA_RESTAURANT(1058),
    SHOP_TYPE_NPC_Kuroda(1059),
    SHOP_TYPE_NPC_KiminamiAnna(1060),
    SHOP_TYPE_NPC_Tomoki(PacketOpcodes.AvatarSkillMaxChargeCountNotify),
    SHOP_TYPE_NPC_Karpillia(1062),
    SHOP_TYPE_BLACKSMITH_INAZUMA(1063),
    SHOP_TYPE_FISH(1064),
    SHOP_TYPE_FISH_LIYUE(1065),
    SHOP_TYPE_FISH_INAZUMA(1066),
    SHOP_TYPE_NPC_Kiyoko(1067),
    SHOP_TYPE_EXPIRED_WIDGET_MENGDE(1068),
    SHOP_TYPE_CAPTURE_ANIMAL_SHOP(1069),
    SHOP_TYPE_NPC_YamashiroKenta(1070),
    SHOP_TYPE_ACTIVITY_CHANNELLER_SLAB(15001),
    SHOP_TYPE_ACTIVITY_SUMMER_TIME(16001),
    SHOP_TYPE_ACTIVITY_BOUNCE_CONJURING(16002),
    SHOP_TYPE_ACTIVITY_BLITZ_RUSH(20001),
    SHOP_TYPE_ACTIVITY_CHESS(20002),
    SHOP_TYPE_ACTIVITY_WINTER_CAMP(20004),
    SHOP_TYPE_ACTIVITY_LANTERN_RITE(20005),
    SHOP_TYPE_ACTIVITY_ROGUELIKE_DUNGEON(22001),
    SHOP_TYPE_ACTIVITY_ROGUE_DIARY(27001),
    SHOP_TYPE_ACTIVITY_SUMMER_TIME_V2(28001),
    SHOP_TYPE_ACTIVITY_GRAVEN_INNOCENCE(30001);
    
    public final int shopTypeId;

    ShopType(int shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public static ShopType getById(int shopTypeId) {
        ShopType[] values = values();
        for (ShopType type : values) {
            if (type.shopTypeId == shopTypeId) {
                return type;
            }
        }
        return SHOP_TYPE_NONE;
    }
}
