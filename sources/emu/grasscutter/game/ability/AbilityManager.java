package emu.grasscutter.game.ability;

import com.google.protobuf.InvalidProtocolBufferException;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.AbilityModifier;
import emu.grasscutter.data.binout.AbilityModifierEntry;
import emu.grasscutter.data.excels.AvatarSkillData;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.entity.gadget.GadgetContent;
import emu.grasscutter.game.entity.gadget.GadgetGatherObject;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass;
import emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass;
import emu.grasscutter.net.proto.AbilityMixinCostStaminaOuterClass;
import emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass;
import emu.grasscutter.net.proto.ModifierActionOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/ability/AbilityManager.class */
public final class AbilityManager extends BasePlayerManager {
    HealAbilityManager healAbilityManager;
    private boolean abilityInvulnerable = false;

    public boolean isAbilityInvulnerable() {
        return this.abilityInvulnerable;
    }

    public AbilityManager(Player player) {
        super(player);
        this.healAbilityManager = new HealAbilityManager(player);
    }

    public void onAbilityInvoke(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws Exception {
        if (invoke != null) {
            this.healAbilityManager.healHandler(invoke);
            switch (invoke.getArgumentType()) {
                case ABILITY_INVOKE_ARGUMENT_META_OVERRIDE_PARAM:
                    handleOverrideParam(invoke);
                    return;
                case ABILITY_INVOKE_ARGUMENT_META_REINIT_OVERRIDEMAP:
                    handleReinitOverrideMap(invoke);
                    return;
                case ABILITY_INVOKE_ARGUMENT_META_MODIFIER_CHANGE:
                    handleModifierChange(invoke);
                    return;
                case ABILITY_INVOKE_ARGUMENT_MIXIN_COST_STAMINA:
                    handleMixinCostStamina(invoke);
                    return;
                case ABILITY_INVOKE_ARGUMENT_ACTION_GENERATE_ELEM_BALL:
                    handleGenerateElemBall(invoke);
                    return;
                case ABILITY_INVOKE_ARGUMENT_META_GLOBAL_FLOAT_VALUE:
                    handleGlobalFloatValue(invoke);
                    return;
                default:
                    return;
            }
        }
    }

    public void onSkillStart(Player player, int skillId, int casterId) {
        AvatarSkillData skillData;
        if (player.getUid() == this.player.getUid()) {
            try {
                if (player.getTeamManager().getCurrentAvatarEntity().getId() == casterId && (skillData = GameData.getAvatarSkillDataMap().get(skillId)) != null && skillData.getCostElemVal() > 0.0f) {
                    this.abilityInvulnerable = true;
                }
            } catch (Exception e) {
            }
        }
    }

    public void onSkillEnd(Player player) {
        if (player.getUid() == this.player.getUid() && this.abilityInvulnerable) {
            this.abilityInvulnerable = false;
        }
    }

    private void handleOverrideParam(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws Exception {
        GameEntity entity = this.player.getScene().getEntityById(invoke.getEntityId());
        if (entity != null) {
            AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry entry = AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.parseFrom(invoke.getAbilityData());
            entity.getMetaOverrideMap().put((Object2FloatMap<String>) entry.getKey().getStr(), entry.getFloatValue());
        }
    }

    private void handleReinitOverrideMap(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws Exception {
        GameEntity entity = this.player.getScene().getEntityById(invoke.getEntityId());
        if (entity != null) {
            for (AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry entry : AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMap.parseFrom(invoke.getAbilityData()).getOverrideMapList()) {
                entity.getMetaOverrideMap().put((Object2FloatMap<String>) entry.getKey().getStr(), entry.getFloatValue());
            }
        }
    }

    private void handleModifierChange(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws Exception {
        GameEntity target;
        AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChange data;
        GameEntity sourceEntity;
        String modifierString;
        if (this.player != null && this.player.getScene() != null && (target = this.player.getScene().getEntityById(invoke.getEntityId())) != null && (data = AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChange.parseFrom(invoke.getAbilityData())) != null) {
            if (target instanceof EntityGadget) {
                EntityGadget targetGadget = (EntityGadget) target;
                GadgetContent content = targetGadget.getContent();
                if (content instanceof GadgetGatherObject) {
                    GadgetGatherObject gatherObject = (GadgetGatherObject) content;
                    if (targetGadget.getGadgetId() != 0 && data.getAction() == ModifierActionOuterClass.ModifierAction.MODIFIER_ACTION_REMOVED) {
                        gatherObject.dropItems(getPlayer());
                        return;
                    }
                }
            }
            AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead head = invoke.getHead();
            if (head != null && (sourceEntity = this.player.getScene().getEntityById(data.getApplyEntityId())) != null) {
                if (data.getAction() == ModifierActionOuterClass.ModifierAction.MODIFIER_ACTION_ADDED && data.getParentAbilityName() != null) {
                    String modifierString2 = data.getParentAbilityName().getStr();
                    AbilityModifierEntry modifier = GameData.getAbilityModifiers().get(modifierString2);
                    if (modifier != null && modifier.getOnAdded().size() > 0) {
                        for (AbilityModifier.AbilityModifierAction action : modifier.getOnAdded()) {
                            invokeAction(action, target, sourceEntity);
                        }
                    }
                    target.getMetaModifiers().put(head.getInstancedModifierId(), (int) modifierString2);
                } else if (data.getAction() == ModifierActionOuterClass.ModifierAction.MODIFIER_ACTION_REMOVED && (modifierString = target.getMetaModifiers().get(head.getInstancedModifierId())) != null) {
                    AbilityModifierEntry modifier2 = GameData.getAbilityModifiers().get(modifierString);
                    if (modifier2 != null && modifier2.getOnRemoved().size() > 0) {
                        for (AbilityModifier.AbilityModifierAction action2 : modifier2.getOnRemoved()) {
                            invokeAction(action2, target, sourceEntity);
                        }
                    }
                    target.getMetaModifiers().remove(head.getInstancedModifierId());
                }
            }
        }
    }

    private void handleMixinCostStamina(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws InvalidProtocolBufferException {
        getPlayer().getStaminaManager().handleMixinCostStamina(AbilityMixinCostStaminaOuterClass.AbilityMixinCostStamina.parseFrom(invoke.getAbilityData()).getIsSwim());
    }

    private void handleGenerateElemBall(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws InvalidProtocolBufferException {
        this.player.getEnergyManager().handleGenerateElemBall(invoke);
    }

    private void handleGlobalFloatValue(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws InvalidProtocolBufferException {
        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry entry = AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.parseFrom(invoke.getAbilityData());
        if (entry.getKey().hasStr() && entry.getKey().getStr().equals("_ABILITY_UziExplode_Count") && entry.hasFloatValue() && entry.getFloatValue() == 2.0f) {
            this.player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_SKILL, RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_ALREADY_SACRIFICE_VALUE);
        }
    }

    private void invokeAction(AbilityModifier.AbilityModifierAction action, GameEntity target, GameEntity sourceEntity) {
        switch (action.type) {
            case HealHP:
            default:
                return;
            case LoseHP:
                if (action.amountByTargetCurrentHPRatio != null) {
                    float damageAmount = action.amount.get();
                    if (damageAmount > 0.0f) {
                        target.damage(damageAmount);
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
