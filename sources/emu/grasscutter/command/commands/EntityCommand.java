package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.CommandHelpers;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.utils.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

@Command(label = "entity", usage = {"<configId gadget> [state<state>] [maxhp<maxhp>] [hp<hp>(0 for infinite)] [atk<atk>] [def<def>]", "<configId monster> [ai<aiId>] [maxhp<maxhp>] [hp<hp>(0 for infinite)] [atk<atk>] [def<def>]"}, permission = "server.entity")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EntityCommand.class */
public final class EntityCommand implements CommandHandler {
    private static final Map<Pattern, BiConsumer<EntityParameters, Integer>> intCommandHandlers = Map.ofEntries(Map.entry(CommandHelpers.stateRegex, arg0, arg1 -> {
        arg0.setState(arg1.intValue());
    }), Map.entry(CommandHelpers.maxHPRegex, arg0, arg1 -> {
        arg0.setMaxHP(arg1.intValue());
    }), Map.entry(CommandHelpers.hpRegex, arg0, arg1 -> {
        arg0.setHp(arg1.intValue());
    }), Map.entry(CommandHelpers.defRegex, arg0, arg1 -> {
        arg0.setDef(arg1.intValue());
    }), Map.entry(CommandHelpers.atkRegex, arg0, arg1 -> {
        arg0.setAtk(arg1.intValue());
    }), Map.entry(CommandHelpers.aiRegex, arg0, arg1 -> {
        arg0.setAi(arg1.intValue());
    }));

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        EntityParameters param = new EntityParameters();
        CommandHelpers.parseIntParameters(args, param, intCommandHandlers);
        if (args.size() != 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        try {
            param.configId = Integer.parseInt(args.get(0));
        } catch (NumberFormatException e) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.cfgId", new Object[0]));
        }
        param.scene = targetPlayer.getScene();
        GameEntity entity = param.scene.getEntityByConfigId(param.configId);
        if (entity == null) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.entity.not_found_error", new Object[0]));
            return;
        }
        applyFightProps(entity, param);
        applyGadgetParams(entity, param);
        applyMonsterParams(entity, param);
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.status.success", new Object[0]));
    }

    private void applyGadgetParams(GameEntity entity, EntityParameters param) {
        if ((entity instanceof EntityGadget) && param.state != -1) {
            ((EntityGadget) entity).updateState(param.state);
        }
    }

    private void applyMonsterParams(GameEntity entity, EntityParameters param) {
        if ((entity instanceof EntityMonster) && param.f489ai != -1) {
            ((EntityMonster) entity).setAiId(param.f489ai);
        }
    }

    private void applyFightProps(GameEntity entity, EntityParameters param) {
        ArrayList<FightProperty> changedFields = new ArrayList<>();
        if (param.maxHP != -1) {
            setFightProperty(entity, FightProperty.FIGHT_PROP_MAX_HP, (float) param.maxHP, changedFields);
        }
        if (param.f488hp != -1) {
            setFightProperty(entity, FightProperty.FIGHT_PROP_CUR_HP, param.f488hp == 0 ? Float.MAX_VALUE : (float) param.f488hp, changedFields);
            callHPEvents(entity);
        }
        if (param.atk != -1) {
            setFightProperty(entity, FightProperty.FIGHT_PROP_ATTACK, (float) param.atk, changedFields);
            setFightProperty(entity, FightProperty.FIGHT_PROP_CUR_ATTACK, (float) param.atk, changedFields);
        }
        if (param.def != -1) {
            setFightProperty(entity, FightProperty.FIGHT_PROP_DEFENSE, (float) param.def, changedFields);
            setFightProperty(entity, FightProperty.FIGHT_PROP_CUR_DEFENSE, (float) param.def, changedFields);
        }
        if (!changedFields.isEmpty()) {
            entity.getScene().broadcastPacket(new PacketEntityFightPropUpdateNotify(entity, changedFields));
        }
    }

    private void callHPEvents(GameEntity entity) {
        entity.callLuaHPEvent();
    }

    private void setFightProperty(GameEntity entity, FightProperty property, float value, List<FightProperty> modifiedProps) {
        entity.setFightProperty(property, value);
        modifiedProps.add(property);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EntityCommand$EntityParameters.class */
    public static class EntityParameters {
        public int configId = -1;
        public int state = -1;

        /* renamed from: hp */
        public int f488hp = -1;
        public int maxHP = -1;
        public int atk = -1;
        public int def = -1;

        /* renamed from: ai */
        public int f489ai = -1;
        public Scene scene = null;

        private EntityParameters() {
        }

        public void setConfigId(int configId) {
            this.configId = configId;
        }

        public void setState(int state) {
            this.state = state;
        }

        public void setHp(int hp) {
            this.f488hp = hp;
        }

        public void setMaxHP(int maxHP) {
            this.maxHP = maxHP;
        }

        public void setAtk(int atk) {
            this.atk = atk;
        }

        public void setDef(int def) {
            this.def = def;
        }

        public void setAi(int ai) {
            this.f489ai = ai;
        }
    }
}
