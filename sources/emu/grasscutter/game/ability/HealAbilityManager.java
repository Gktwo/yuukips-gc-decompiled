package emu.grasscutter.game.ability;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/ability/HealAbilityManager.class */
public class HealAbilityManager {
    ArrayList<HealDataAvatar> healDataAvatarList = new ArrayList<>();
    private Player player;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/ability/HealAbilityManager$HealData.class */
    public class HealData {
        public boolean isString;
        public String abilityType;
        public String sRatio;
        public String sBase;
        public float fRatio;
        public float fBase;
        public boolean healAll;

        public HealData(String _abilityType, String _sRatio, String _sBase, boolean _healAll) {
            this.isString = true;
            this.abilityType = "";
            this.sRatio = "";
            this.sBase = "";
            this.fRatio = 0.0f;
            this.fBase = 0.0f;
            this.healAll = false;
            this.abilityType = _abilityType;
            this.isString = true;
            this.sRatio = _sRatio;
            this.sBase = _sBase;
            this.healAll = _healAll;
        }

        public HealData(String _abilityType, String _sRatio, float _fRatio, float _fBase, boolean _healAll) {
            this.isString = true;
            this.abilityType = "";
            this.sRatio = "";
            this.sBase = "";
            this.fRatio = 0.0f;
            this.fBase = 0.0f;
            this.healAll = false;
            this.abilityType = _abilityType;
            this.isString = false;
            this.sRatio = _sRatio;
            this.fRatio = _fRatio;
            this.fBase = _fBase;
            this.healAll = _healAll;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/ability/HealAbilityManager$HealDataAvatar.class */
    public class HealDataAvatar {
        public int avatarId;
        public String avatarName;
        public int fightPropertyType;
        public ArrayList<HealData> healDataList = new ArrayList<>();

        public HealDataAvatar(int _avatarId, String _avatarName, int _fightPropertyType) {
            this.avatarId = 0;
            this.avatarName = "";
            this.fightPropertyType = 0;
            this.avatarId = _avatarId;
            this.avatarName = _avatarName;
            this.fightPropertyType = _fightPropertyType;
        }

        public HealDataAvatar addHealData(String abilityType, String sRatio, String sBase, boolean healAll) {
            this.healDataList.add(new HealData(abilityType, sRatio, sBase, healAll));
            return this;
        }

        public HealDataAvatar addHealData(String abilityType, String sRatio, float fRatio, float fBase, boolean healAll) {
            this.healDataList.add(new HealData(abilityType, sRatio, fRatio, fBase, healAll));
            return this;
        }
    }

    public HealAbilityManager(Player player) {
        this.player = player;
        this.healDataAvatarList.add(new HealDataAvatar(10000054, "Kokomi", 0).addHealData("E", "ElementalArt_Heal_MaxHP_Base_Percentage", "ElementalArt_Heal_Base_Amount", false).addHealData("Q", "Avatar_Kokomi_ElementalBurst_Heal", 0.0172f, 212.0f, false));
        this.healDataAvatarList.add(new HealDataAvatar(10000003, "Qin", 1).addHealData("Q", "Heal", "BurstHealConst", true));
        this.healDataAvatarList.add(new HealDataAvatar(10000034, "Noel", 2).addHealData("E", "OnAttack_HealthRate", 0.452f, 282.0f, true));
        this.healDataAvatarList.add(new HealDataAvatar(10000032, "Bennett", 0).addHealData("Q", "HealMaxHpRatio", "HealConst", false));
        this.healDataAvatarList.add(new HealDataAvatar(10000039, "Diona", 0).addHealData("Q", "HealHPRatio", "HealHP_Const", false));
        this.healDataAvatarList.add(new HealDataAvatar(10000053, "Sayu", 1).addHealData("Q", "Constellation_6_Damage", "Heal_BaseAmount", true).addHealData("Q", "Heal_AttackRatio", "Constellation_6_Heal", true));
        this.healDataAvatarList.add(new HealDataAvatar(10000014, "Barbara", 0).addHealData("E", "HealHPOnAdded", "HealHPOnAdded_Const", true).addHealData("E", "HealHP_OnHittingOthers", "HealHP_Const_OnHittingOthers", true).addHealData("Q", "Avatar_Barbara_IdolHeal", 0.374f, 4660.0f, true));
        this.healDataAvatarList.add(new HealDataAvatar(10000065, "Shinobu", 0).addHealData("E", "ElementalArt_Heal_MaxHP_Percentage", 0.064f, 795.0f, false));
        this.healDataAvatarList.add(new HealDataAvatar(10000035, "Qiqi", 1).addHealData("E", "HealHP_OnHittingOthers", "HealHP_Const_OnHittingOthers", true).addHealData("E", "ElementalArt_HealHp_Ratio", "ElementalArt_HealHp_Const", true).addHealData("Q", "Avatar_Qiqi_ElementalBurst_ApplyModifier", 0.0191f, 1588.0f, false));
        this.healDataAvatarList.add(new HealDataAvatar(10000046, "Hutao", 0).addHealData("Q", "Avatar_Hutao_VermilionBite_BakeMesh", 0.1166f, 0.0f, false));
    }

    public Player getPlayer() {
        return this.player;
    }

    public void healHandler(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws Exception {
        if (invoke != null) {
            AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChange data = null;
            try {
                data = AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChange.parseFrom(invoke.getAbilityData());
            } catch (Exception e) {
            }
            if (data != null && this.player != null && this.player.getScene() != null && data.getApplyEntityId() != 0) {
                GameEntity sourceEntity = this.player.getScene().getEntityById(data.getApplyEntityId());
                String modifierString = "";
                if (data.getParentAbilityName() != null) {
                    modifierString = data.getParentAbilityName().getStr();
                }
                if (sourceEntity != null) {
                    checkAndHeal(sourceEntity, modifierString);
                }
            }
        }
    }

    public void checkAndHeal(GameEntity sourceEntity, String modifierString) {
        float healAmount = 0.0f;
        float ratio = 0.0f;
        float base = 0.0f;
        Map<String, Float> map = sourceEntity.getMetaOverrideMap();
        for (int i = 0; i < this.healDataAvatarList.size(); i++) {
            HealDataAvatar healDataAvatar = this.healDataAvatarList.get(i);
            if (modifierString.contains(healDataAvatar.avatarName)) {
                int fightPropertyType = healDataAvatar.fightPropertyType;
                ArrayList<HealData> healDataList = healDataAvatar.healDataList;
                for (int j = 0; j < healDataList.size(); j++) {
                    HealData healData = healDataList.get(j);
                    if (map.containsKey(healData.sRatio) || modifierString.equals(healData.sRatio)) {
                        if (healData.isString) {
                            ratio = map.get(healData.sRatio).floatValue();
                            base = map.get(healData.sBase).floatValue();
                        } else {
                            ratio = healData.fRatio;
                            base = healData.fBase;
                        }
                    }
                    List<EntityAvatar> activeTeam = this.player.getTeamManager().getActiveTeam();
                    List<EntityAvatar> needHealAvatars = new ArrayList<>();
                    EntityAvatar currentAvatar = activeTeam.get(this.player.getTeamManager().getCurrentCharacterIndex());
                    if (healData.healAll) {
                        needHealAvatars = activeTeam;
                    } else {
                        needHealAvatars.add(currentAvatar);
                    }
                    EntityAvatar healActionAvatar = null;
                    int k = 0;
                    while (true) {
                        if (k < activeTeam.size()) {
                            EntityAvatar avatar = activeTeam.get(k);
                            if (avatar.getAvatar().getAvatarId() == healDataAvatar.avatarId) {
                                healActionAvatar = avatar;
                            } else {
                                k++;
                            }
                        }
                    }
                    if (healActionAvatar != null) {
                        float maxHP = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
                        float curHP = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
                        float curAttack = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_ATTACK);
                        float curDefense = healActionAvatar.getFightProperty(FightProperty.FIGHT_PROP_CUR_DEFENSE);
                        if (healDataAvatar.avatarName.equals("Hutao") && ((double) curHP) <= ((double) maxHP) * 0.5d && ratio != 0.0f) {
                            ratio = 0.1555f;
                        }
                        switch (fightPropertyType) {
                            case 0:
                                healAmount = (ratio * maxHP) + base;
                                break;
                            case 1:
                                healAmount = (ratio * curAttack) + base;
                                break;
                            case 2:
                                healAmount = (ratio * curDefense) + base;
                                break;
                        }
                    }
                    if (healAmount != 0.0f) {
                        for (int k2 = 0; k2 < needHealAvatars.size(); k2++) {
                            needHealAvatars.get(k2).heal(healAmount);
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
        }
    }
}
