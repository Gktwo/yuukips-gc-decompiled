package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.CommandHelpers;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.GadgetData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.MonsterData;
import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityItem;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.EntityVehicle;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EntityType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.utils.Language;
import emu.grasscutter.utils.Position;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

@Command(label = "spawn", aliases = {"drop", "s"}, usage = {"<itemId> [x<amount>] [blk<blockId>] [grp<groupId>] [cfg<configId>] <x> <y> <z>", "<gadgetId> [x<amount>] [state<state>] [maxhp<maxhp>] [hp<hp>(0 for infinite)] [atk<atk>] [def<def>] [blk<blockId>] [grp<groupId>] [cfg<configId>] <x> <y> <z>", "<monsterId> [x<amount>] [lv<level>] [ai<aiId>] [maxhp<maxhp>] [hp<hp>(0 for infinite)] [atk<atk>] [def<def>] [blk<blockId>] [grp<groupId>] [cfg<configId>] <x> <y> <z>"}, permission = "server.spawn", permissionTargeted = "server.spawn.others", ratelimit = 60, count = 10)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SpawnCommand.class */
public final class SpawnCommand implements CommandHandler {
    private static final Map<Pattern, BiConsumer<SpawnParameters, Integer>> intCommandHandlers = Map.ofEntries(Map.entry(CommandHelpers.lvlRegex, (v0, v1) -> {
        v0.setLvl(v1);
    }), Map.entry(CommandHelpers.amountRegex, (v0, v1) -> {
        v0.setAmount(v1);
    }), Map.entry(CommandHelpers.stateRegex, (v0, v1) -> {
        v0.setState(v1);
    }), Map.entry(CommandHelpers.blockRegex, (v0, v1) -> {
        v0.setBlockId(v1);
    }), Map.entry(CommandHelpers.groupRegex, (v0, v1) -> {
        v0.setGroupId(v1);
    }), Map.entry(CommandHelpers.configRegex, (v0, v1) -> {
        v0.setConfigId(v1);
    }), Map.entry(CommandHelpers.maxHPRegex, (v0, v1) -> {
        v0.setMaxHP(v1);
    }), Map.entry(CommandHelpers.hpRegex, (v0, v1) -> {
        v0.setHp(v1);
    }), Map.entry(CommandHelpers.defRegex, (v0, v1) -> {
        v0.setDef(v1);
    }), Map.entry(CommandHelpers.atkRegex, (v0, v1) -> {
        v0.setAtk(v1);
    }), Map.entry(CommandHelpers.aiRegex, (v0, v1) -> {
        v0.setAi(v1);
    }));

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        SpawnParameters param = new SpawnParameters();
        CommandHelpers.parseIntParameters(args, param, intCommandHandlers);
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        switch (args.size()) {
            case 1:
                break;
            default:
                sendUsageMessage(sender, new String[0]);
                return;
            case 4:
                try {
                    param.pos = new Position(Float.parseFloat(args.get(1)), Float.parseFloat(args.get(2)), Float.parseFloat(args.get(3)));
                    break;
                } catch (NumberFormatException e) {
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.execution.argument_error", new Object[0]));
                    break;
                }
        }
        try {
            param.f494id = Integer.parseInt(args.get(0));
        } catch (NumberFormatException e2) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.entityId", new Object[0]));
        }
        MonsterData monsterData = GameData.getMonsterDataMap().get(param.f494id);
        GadgetData gadgetData = GameData.getGadgetDataMap().get(param.f494id);
        ItemData itemData = GameData.getItemDataMap().get(param.f494id);
        if (monsterData == null && gadgetData == null && itemData == null) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.generic.invalid.entityId", new Object[0]));
            return;
        }
        param.scene = targetPlayer.getScene();
        Map<Integer, GameEntity> Entityz = param.scene.getEntities();
        int total = Entityz.size();
        if (monsterData != null) {
            total = (int) Entityz.values().stream().filter(entity -> {
                return entity instanceof EntityMonster;
            }).count();
        }
        int etnow = total + param.amount;
        if (etnow > Configuration.GAME_OPTIONS.CMD_Spawn) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "dockergs.commands.limit", Integer.valueOf(Configuration.GAME_OPTIONS.CMD_Spawn), Integer.valueOf(etnow)));
            return;
        }
        double maxRadius = Math.sqrt((((double) param.amount) * 0.2d) / 3.141592653589793d);
        if (param.pos == null) {
            param.pos = targetPlayer.getPosition();
        }
        for (int i = 0; i < param.amount; i++) {
            Position pos = GetRandomPositionInCircle(param.pos, maxRadius).addY(3.0f);
            GameEntity entity = null;
            if (itemData != null) {
                entity = createItem(itemData, param, pos);
            }
            if (gadgetData != null) {
                pos.addY(-3.0f);
                entity = createGadget(gadgetData, param, pos, targetPlayer);
            }
            if (monsterData != null) {
                entity = createMonster(monsterData, param, pos);
            }
            applyCommonParameters(entity, param);
            param.scene.addEntity(entity);
        }
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.spawn.success", Integer.valueOf(param.amount), Integer.valueOf(param.f494id)));
    }

    private EntityItem createItem(ItemData itemData, SpawnParameters param, Position pos) {
        return new EntityItem(param.scene, null, itemData, pos, 1, true);
    }

    private EntityMonster createMonster(MonsterData monsterData, SpawnParameters param, Position pos) {
        EntityMonster entity = new EntityMonster(param.scene, monsterData, pos, param.lvl);
        if (param.f496ai != -1) {
            entity.setAiId(param.f496ai);
        }
        return entity;
    }

    private EntityBaseGadget createGadget(GadgetData gadgetData, SpawnParameters param, Position pos, Player targetPlayer) {
        EntityBaseGadget entity;
        if (gadgetData.getType() == EntityType.Vehicle) {
            entity = new EntityVehicle(param.scene, targetPlayer, param.f494id, 0, pos, targetPlayer.getRotation());
        } else {
            entity = new EntityGadget(param.scene, param.f494id, pos, targetPlayer.getRotation());
            if (param.state != -1) {
                ((EntityGadget) entity).setState(param.state);
            }
        }
        return entity;
    }

    private void applyCommonParameters(GameEntity entity, SpawnParameters param) {
        if (param.blockId != -1) {
            entity.setBlockId(param.blockId);
        }
        if (param.groupId != -1) {
            entity.setGroupId(param.groupId);
        }
        if (param.configId != -1) {
            entity.setConfigId(param.configId);
        }
        if (param.maxHP != -1) {
            entity.setFightProperty(FightProperty.FIGHT_PROP_MAX_HP, (float) param.maxHP);
            entity.setFightProperty(FightProperty.FIGHT_PROP_BASE_HP, (float) param.maxHP);
        }
        if (param.f495hp != -1) {
            entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, param.f495hp == 0 ? Float.MAX_VALUE : (float) param.f495hp);
        }
        if (param.atk != -1) {
            entity.setFightProperty(FightProperty.FIGHT_PROP_ATTACK, (float) param.atk);
            entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_ATTACK, (float) param.atk);
        }
        if (param.def != -1) {
            entity.setFightProperty(FightProperty.FIGHT_PROP_DEFENSE, (float) param.def);
            entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_DEFENSE, (float) param.def);
        }
    }

    private Position GetRandomPositionInCircle(Position origin, double radius) {
        Position target = origin.clone();
        double angle = Math.random() * 360.0d;
        double r = Math.sqrt(Math.random() * radius * radius);
        target.addX((float) (r * Math.cos(angle))).addZ((float) (r * Math.sin(angle)));
        return target;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SpawnCommand$SpawnParameters.class */
    public static class SpawnParameters {

        /* renamed from: id */
        public int f494id;
        public int lvl = 1;
        public int amount = 1;
        public int blockId = -1;
        public int groupId = -1;
        public int configId = -1;
        public int state = -1;

        /* renamed from: hp */
        public int f495hp = -1;
        public int maxHP = -1;
        public int atk = -1;
        public int def = -1;

        /* renamed from: ai */
        public int f496ai = -1;
        public Position pos = null;
        public Scene scene = null;

        private SpawnParameters() {
        }

        public void setId(int id) {
            this.f494id = id;
        }

        public void setLvl(int lvl) {
            this.lvl = lvl;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setBlockId(int blockId) {
            this.blockId = blockId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public void setConfigId(int configId) {
            this.configId = configId;
        }

        public void setState(int state) {
            this.state = state;
        }

        public void setHp(int hp) {
            this.f495hp = hp;
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
            this.f496ai = ai;
        }

        public void setPos(Position pos) {
            this.pos = pos;
        }
    }
}
