package emu.grasscutter.game.shop;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass;
import emu.grasscutter.net.proto.VintageMarketInfoOuterClass;
import org.eclipse.jetty.websocket.api.StatusCode;

/* loaded from: grasscutter.jar:emu/grasscutter/game/shop/ShopType.class */
public enum ShopType {
    SHOP_TYPE_NONE(0),
    SHOP_TYPE_PAIMON(900),
    SHOP_TYPE_PACKAGE(902),
    SHOP_TYPE_MCOIN(903),
    SHOP_TYPE_RECOMMEND(1001),
    SHOP_TYPE_CITY(1002),
    SHOP_TYPE_BLACKSMITH(StatusCode.BAD_DATA),
    SHOP_TYPE_GROCERY(1004),
    SHOP_TYPE_FOOD(1005),
    SHOP_TYPE_SEA_LAMP(1006),
    SHOP_TYPE_VIRTUAL_SHOP(StatusCode.BAD_PAYLOAD),
    SHOP_TYPE_LIYUE_GROCERY(StatusCode.POLICY_VIOLATION),
    SHOP_TYPE_LIYUE_SOUVENIR(1009),
    SHOP_TYPE_LIYUE_RESTAURANT(StatusCode.REQUIRED_EXTENSION),
    SHOP_TYPE_NPC_Flora(StatusCode.SERVER_ERROR),
    SHOP_TYPE_NPC_Charles(StatusCode.SERVICE_RESTART),
    SHOP_TYPE_NPC_Shiliu(1013),
    SHOP_TYPE_NPC_Schulz(1014),
    SHOP_TYPE_NPC_Brook(1015),
    SHOP_TYPE_NPC_Hopkins(PacketOpcodes.AvatarSkillChangeNotify),
    SHOP_TYPE_NPC_Draff(1017),
    SHOP_TYPE_NPC_Chloris(1018),
    SHOP_TYPE_NPC_Licai(1019),
    SHOP_TYPE_NPC_Yueshu(PacketOpcodes.BigTalentPointConvertReq),
    SHOP_TYPE_NPC_Gui(1021),
    SHOP_TYPE_NPC_Gao(1022),
    SHOP_TYPE_NPC_Sun(1023),
    SHOP_TYPE_NPC_Qiming(1024),
    SHOP_TYPE_NPC_Zhangshun(1025),
    SHOP_TYPE_NPC_Chen(1026),
    SHOP_TYPE_NPC_ErNiang(1027),
    SHOP_TYPE_NPC_Shitou(1028),
    SHOP_TYPE_NPC_Jifang(PacketOpcodes.AvatarSkillUpgradeReq),
    SHOP_TYPE_NPC_Zhu(1030),
    SHOP_TYPE_NPC_Bai(1031),
    SHOP_TYPE_NPC_Kai(1032),
    SHOP_TYPE_NPC_Linglang(1033),
    SHOP_TYPE_NPC_VerrGoldet(1034),
    SHOP_TYPE_NPC_Zhou(VintageMarketInfoOuterClass.VintageMarketInfo.UNK3300_ALHLENELIEO_FIELD_NUMBER),
    SHOP_TYPE_TASK_Ekaterina(1036),
    SHOP_TYPE_ACTIVITY_ASTER(1037),
    SHOP_TYPE_TASK_Tartaglia(1038),
    SHOP_TYPE_NPC_Harris(1039),
    SHOP_TYPE_ACTIVITY_DRAGON_SPINE(1040),
    SHOP_TYPE_ACTIVITY_TREASURE_MAP(1041),
    SHOP_TYPE_NPC_Yinian(1042),
    SHOP_TYPE_ACTIVITY_SEA_LAMP(1043),
    SHOP_TYPE_ACTIVITY_FLEUR_FAIR(1044),
    SHOP_TYPE_NPC_Changshun(DungeonSettleNotifyOuterClass.DungeonSettleNotify.CHANNELLER_SLAB_LOOP_DUNGEON_RESULT_INFO_FIELD_NUMBER),
    SHOP_TYPE_NPC_Bolai(1046),
    SHOP_TYPE_NPC_Ashanpo(1047),
    SHOP_TYPE_HOME(1048),
    SHOP_TYPE_HOME_LIMIT(1049),
    SHOP_TYPE_NPC_MasterLu(1050),
    SHOP_TYPE_NPC_Goth(1051),
    SHOP_TYPE_COSTUME(ActivityInfoOuterClass.ActivityInfo.WISHGIFTNUMMAP_FIELD_NUMBER),
    SHOP_TYPE_NPC_Obata(1053),
    SHOP_TYPE_NPC_Qiuyue(1054),
    SHOP_TYPE_NPC_Ryouko(PacketOpcodes.UnlockAvatarTalentRsp),
    SHOP_TYPE_INAZUMA_GROCERY(1056),
    SHOP_TYPE_INAZUMA_SOUVENIR(1057),
    SHOP_TYPE_INAZUMA_RESTAURANT(1058),
    SHOP_TYPE_NPC_Kuroda(1059),
    SHOP_TYPE_NPC_KiminamiAnna(1060),
    SHOP_TYPE_NPC_Tomoki(1061),
    SHOP_TYPE_NPC_Karpillia(1062),
    SHOP_TYPE_BLACKSMITH_INAZUMA(1063),
    SHOP_TYPE_FISH(1064),
    SHOP_TYPE_FISH_LIYUE(1065),
    SHOP_TYPE_FISH_INAZUMA(1066),
    SHOP_TYPE_NPC_Kiyoko(1067),
    SHOP_TYPE_EXPIRED_WIDGET_MENGDE(1068),
    SHOP_TYPE_CAPTURE_ANIMAL_SHOP(PacketOpcodes.CanUseSkillNotify),
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
