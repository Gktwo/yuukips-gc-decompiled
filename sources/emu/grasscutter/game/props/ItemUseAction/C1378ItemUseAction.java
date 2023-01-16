package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.data.common.ItemUseData;
import emu.grasscutter.game.props.ItemUseOp;

/* renamed from: emu.grasscutter.game.props.ItemUseAction.ItemUseAction */
/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAction.class */
public class C1378ItemUseAction {
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_NONE;
    }

    public static C1378ItemUseAction fromItemUseData(ItemUseData data) {
        String[] useParam = data.getUseParam();
        switch (data.getUseOp()) {
            case ITEM_USE_NONE:
                return null;
            case ITEM_USE_ADD_EXP:
                return new ItemUseAddExp(useParam);
            case ITEM_USE_ADD_RELIQUARY_EXP:
                return new ItemUseAddReliquaryExp(useParam);
            case ITEM_USE_ADD_WEAPON_EXP:
                return new ItemUseAddWeaponExp(useParam);
            case ITEM_USE_ADD_ALL_ENERGY:
                return new ItemUseAddAllEnergy(useParam);
            case ITEM_USE_ADD_ELEM_ENERGY:
                return new ItemUseAddElemEnergy(useParam);
            case ITEM_USE_ADD_ITEM:
                return new ItemUseAddItem(useParam);
            case ITEM_USE_GAIN_AVATAR:
                return new ItemUseGainAvatar(useParam);
            case ITEM_USE_GAIN_COSTUME:
                return new ItemUseGainCostume(useParam);
            case ITEM_USE_GAIN_FLYCLOAK:
                return new ItemUseGainFlycloak(useParam);
            case ITEM_USE_GAIN_NAME_CARD:
                return new ItemUseGainNameCard(useParam);
            case ITEM_USE_CHEST_SELECT_ITEM:
                return new ItemUseChestSelectItem(useParam);
            case ITEM_USE_ADD_SELECT_ITEM:
                return new ItemUseAddSelectItem(useParam);
            case ITEM_USE_GRANT_SELECT_REWARD:
                return new ItemUseGrantSelectReward(useParam);
            case ITEM_USE_COMBINE_ITEM:
                return new ItemUseCombineItem(useParam);
            case ITEM_USE_OPEN_RANDOM_CHEST:
                return new ItemUseOpenRandomChest(useParam);
            case ITEM_USE_RELIVE_AVATAR:
                return new ItemUseReliveAvatar(useParam);
            case ITEM_USE_ADD_CUR_HP:
                return new ItemUseAddCurHp(useParam);
            case ITEM_USE_ADD_CUR_STAMINA:
                return new ItemUseAddCurStamina(useParam);
            case ITEM_USE_ADD_SERVER_BUFF:
                return new ItemUseAddServerBuff(useParam);
            case ITEM_USE_MAKE_GADGET:
                return new ItemUseMakeGadget(useParam);
            case ITEM_USE_UNLOCK_COMBINE:
                return new ItemUseUnlockCombine(useParam);
            case ITEM_USE_UNLOCK_CODEX:
                return new ItemUseUnlockCodex(useParam);
            case ITEM_USE_UNLOCK_COOK_RECIPE:
                return new ItemUseUnlockCookRecipe(useParam);
            case ITEM_USE_UNLOCK_FORGE:
                return new ItemUseUnlockForge(useParam);
            case ITEM_USE_UNLOCK_FURNITURE_FORMULA:
                return new ItemUseUnlockFurnitureFormula(useParam);
            case ITEM_USE_UNLOCK_FURNITURE_SUITE:
                return new ItemUseUnlockFurnitureSuite(useParam);
            case ITEM_USE_UNLOCK_HOME_MODULE:
                return new ItemUseUnlockHomeModule(useParam);
            case ITEM_USE_UNLOCK_HOME_BGM:
                return new ItemUseUnlockHomeBgm(useParam);
            case ITEM_USE_ACCEPT_QUEST:
                return new ItemUseAcceptQuest(useParam);
            case ITEM_USE_GAIN_CARD_PRODUCT:
                return new ItemUseGainCardProduct(useParam);
            case ITEM_USE_UNLOCK_PAID_BATTLE_PASS_NORMAL:
                return new ItemUseUnlockPaidBattlePassNormal(useParam);
            case ITEM_USE_DEL_SERVER_BUFF:
                return null;
            case ITEM_USE_ADD_BIG_TALENT_POINT:
                return null;
            case ITEM_USE_GAIN_RESIN_CARD_PRODUCT:
                return null;
            case ITEM_USE_TRIGGER_ABILITY:
                return null;
            case ITEM_USE_ADD_TREASURE_MAP_BONUS_REGION_FRAGMENT:
                return null;
            case ITEM_USE_ADD_PERSIST_STAMINA:
                return null;
            case ITEM_USE_ADD_TEMPORARY_STAMINA:
                return null;
            case ITEM_USE_ADD_DUNGEON_COND_TIME:
                return null;
            case ITEM_USE_ADD_CHANNELLER_SLAB_BUFF:
                return null;
            case ITEM_USE_ADD_REGIONAL_PLAY_VAR:
                return null;
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    public boolean useItem(UseItemParams params) {
        return false;
    }

    public boolean postUseItem(UseItemParams params) {
        return false;
    }
}
