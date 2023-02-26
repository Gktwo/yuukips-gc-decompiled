package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.CommandHelpers;
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
import emu.grasscutter.utils.Position;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

@Command(label = "spawn", aliases = {"drop", "s"}, usage = {"<itemId> [x<amount>] [blk<blockId>] [grp<groupId>] [cfg<configId>] <x> <y> <z>", "<gadgetId> [x<amount>] [state<state>] [maxhp<maxhp>] [hp<hp>(0 for infinite)] [atk<atk>] [def<def>] [blk<blockId>] [grp<groupId>] [cfg<configId>] <x> <y> <z>", "<monsterId> [x<amount>] [lv<level>] [ai<aiId>] [maxhp<maxhp>] [hp<hp>(0 for infinite)] [atk<atk>] [def<def>] [blk<blockId>] [grp<groupId>] [cfg<configId>] <x> <y> <z>"}, permission = "server.spawn", permissionTargeted = "server.spawn.others", ratelimit = 120, count = 10)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SpawnCommand.class */
public final class SpawnCommand implements CommandHandler {
    private static final Map<Pattern, BiConsumer<SpawnParameters, Integer>> intCommandHandlers = Map.ofEntries(Map.entry(CommandHelpers.lvlRegex, arg0, arg1 -> {
        arg0.setLvl(arg1.intValue());
    }), Map.entry(CommandHelpers.amountRegex, arg0, arg1 -> {
        arg0.setAmount(arg1.intValue());
    }), Map.entry(CommandHelpers.stateRegex, arg0, arg1 -> {
        arg0.setState(arg1.intValue());
    }), Map.entry(CommandHelpers.blockRegex, arg0, arg1 -> {
        arg0.setBlockId(arg1.intValue());
    }), Map.entry(CommandHelpers.groupRegex, arg0, arg1 -> {
        arg0.setGroupId(arg1.intValue());
    }), Map.entry(CommandHelpers.configRegex, arg0, arg1 -> {
        arg0.setConfigId(arg1.intValue());
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

    /*  JADX ERROR: Dependency scan failed at insn: 0x023B: INVOKE_CUSTOM r-53
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x023B: INVOKE_CUSTOM r1, method: emu.grasscutter.command.commands.SpawnCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List<java.lang.String>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Null Data entity? ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Null Data entity? ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(emu.grasscutter.game.player.Player r9, emu.grasscutter.game.player.Player r10, java.util.List<java.lang.String> r11) {
        /*
        // Method dump skipped, instructions count: 622
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.commands.SpawnCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List):void");
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

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SpawnCommand$SpawnParameters.class */
    private static class SpawnParameters {

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
