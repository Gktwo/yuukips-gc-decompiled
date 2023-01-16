package emu.grasscutter.game.entity;

import emu.grasscutter.data.binout.ConfigGadget;
import emu.grasscutter.data.binout.ConfigGadgetCombatProperty;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityBaseGadget.class */
public abstract class EntityBaseGadget extends GameEntity {
    protected final Position position;
    protected final Position rotation;

    public abstract int getGadgetId();

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getPosition() {
        return this.position;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getRotation() {
        return this.rotation;
    }

    public EntityBaseGadget(Scene scene) {
        this(scene, null, null);
    }

    public EntityBaseGadget(Scene scene, Position position, Position rotation) {
        super(scene);
        this.position = position != null ? position.clone() : new Position();
        this.rotation = rotation != null ? rotation.clone() : new Position();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onDeath(int killerId) {
        onDeath(killerId);
        getScene().getPlayers().forEach(p -> {
            p.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_DESTROY_GADGET, getGadgetId());
        });
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void callLuaHPEvent() {
        getScene().getScriptManager().callEvent(new ScriptArgs(34, getConfigId(), getGadgetId()).setSourceEntityId(getId()).setParam3((int) getFightProperty(FightProperty.FIGHT_PROP_CUR_HP)).setEventSource(Integer.toString(getConfigId())));
    }

    /* access modifiers changed from: protected */
    public void fillFightProps(ConfigGadget configGadget) {
        if (configGadget != null && configGadget.getCombat() != null) {
            ConfigGadgetCombatProperty combatProperties = configGadget.getCombat().getProperty();
            float targetHp = combatProperties.getHP();
            setFightProperty(FightProperty.FIGHT_PROP_MAX_HP, targetHp);
            setFightProperty(FightProperty.FIGHT_PROP_BASE_HP, targetHp);
            if (combatProperties.isInvincible()) {
                targetHp = Float.POSITIVE_INFINITY;
            }
            setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, targetHp);
            float atk = combatProperties.getAttack();
            setFightProperty(FightProperty.FIGHT_PROP_BASE_ATTACK, atk);
            setFightProperty(FightProperty.FIGHT_PROP_CUR_ATTACK, atk);
            float def = combatProperties.getDefence();
            setFightProperty(FightProperty.FIGHT_PROP_BASE_DEFENSE, def);
            setFightProperty(FightProperty.FIGHT_PROP_CUR_DEFENSE, def);
            setLockHP(combatProperties.isLockHP());
        }
    }
}
