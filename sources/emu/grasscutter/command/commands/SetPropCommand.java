package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.OpenStateData;
import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.PlayerProgressManager;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.tower.TowerLevelRecord;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.packet.send.PacketHomeBasicInfoNotify;
import emu.grasscutter.server.packet.send.PacketOpenStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketSceneAreaUnlockNotify;
import emu.grasscutter.server.packet.send.PacketScenePointUnlockNotify;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Command(label = "setProp", aliases = {"prop"}, usage = {"<prop> <value>"}, permission = "player.setprop", permissionTargeted = "player.setprop.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetPropCommand.class */
public final class SetPropCommand implements CommandHandler {
    Map<String, Prop> props = new HashMap();
    private static final int total_scene = 9;
    private static final List<Integer> scene_point_rand = IntStream.range(0, 1000).boxed().toList();
    private static final List<Integer> scene_areas_rand = IntStream.range(0, 500).boxed().toList();
    private static final List<Integer> sceneAreas = List.of((Object[]) new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 22, 23, 24, 25, 29, 100, 101, 102, 103, 200, Integer.valueOf((int) PacketOpcodes.ExecuteGadgetLuaReq), 300, 400, 401, 402, 403});

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetPropCommand$PseudoProp.class */
    enum PseudoProp {
        NONE,
        WORLD_LEVEL,
        TOWER_LEVEL,
        BP_LEVEL,
        GOD_MODE,
        UNLIMITED_STAMINA,
        UNLIMITED_ENERGY,
        SWITCH_ELEMENT,
        ALL_OPENSTATE,
        SET_OPENSTATE,
        UNSET_OPENSTATE,
        UNLOCK_MAP,
        UNLOCK_HOUSE
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x026B: INVOKE_CUSTOM r-19
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
    /*  JADX ERROR: Failed to decode insn: 0x026B: INVOKE_CUSTOM r2, method: emu.grasscutter.command.commands.SetPropCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List<java.lang.String>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Unexpected value: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Unexpected value: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(emu.grasscutter.game.player.Player r8, emu.grasscutter.game.player.Player r9, java.util.List<java.lang.String> r10) {
        /*
        // Method dump skipped, instructions count: 1206
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.commands.SetPropCommand.execute(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, java.util.List):void");
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetPropCommand$Prop.class */
    static class Prop {
        String name;
        PlayerProperty prop;
        PseudoProp pseudoProp;

        public Prop(PlayerProperty prop) {
            this(prop.toString(), prop, PseudoProp.NONE);
        }

        public Prop(String name) {
            this(name, PlayerProperty.PROP_NONE, PseudoProp.NONE);
        }

        public Prop(String name, PseudoProp pseudoProp) {
            this(name, PlayerProperty.PROP_NONE, pseudoProp);
        }

        public Prop(String name, PlayerProperty prop) {
            this(name, prop, PseudoProp.NONE);
        }

        public Prop(String name, PlayerProperty prop, PseudoProp pseudoProp) {
            this.name = name;
            this.prop = prop;
            this.pseudoProp = pseudoProp;
        }
    }

    public SetPropCommand() {
        PlayerProperty[] values = PlayerProperty.values();
        for (PlayerProperty prop : values) {
            String name = prop.toString().substring(5);
            this.props.put(name.toLowerCase(), new Prop(name, prop));
        }
        Prop worldlevel = new Prop("World Level", PlayerProperty.PROP_PLAYER_WORLD_LEVEL, PseudoProp.WORLD_LEVEL);
        this.props.put("worldlevel", worldlevel);
        this.props.put("wl", worldlevel);
        Prop abyss = new Prop("Tower Level", PseudoProp.TOWER_LEVEL);
        this.props.put("abyss", abyss);
        this.props.put("abyssfloor", abyss);
        this.props.put("ut", abyss);
        this.props.put("tower", abyss);
        this.props.put("towerlevel", abyss);
        this.props.put("unlocktower", abyss);
        Prop bplevel = new Prop("BP Level", PseudoProp.BP_LEVEL);
        this.props.put("bplevel", bplevel);
        this.props.put("bp", bplevel);
        this.props.put("battlepass", bplevel);
        Prop godmode = new Prop("GodMode", PseudoProp.GOD_MODE);
        this.props.put("godmode", godmode);
        this.props.put("god", godmode);
        Prop nostamina = new Prop("UnlimitedStamina", PseudoProp.UNLIMITED_STAMINA);
        this.props.put("unlimitedstamina", nostamina);
        this.props.put("us", nostamina);
        this.props.put("nostamina", nostamina);
        this.props.put("nostam", nostamina);
        this.props.put("ns", nostamina);
        Prop unlimitedenergy = new Prop("UnlimitedEnergy", PseudoProp.UNLIMITED_ENERGY);
        this.props.put("unlimitedenergy", unlimitedenergy);
        this.props.put("ue", unlimitedenergy);
        Prop switchelement = new Prop("switchelement", PseudoProp.SWITCH_ELEMENT);
        this.props.put("switchelement", switchelement);
        this.props.put("se", switchelement);
        Prop allopenstate = new Prop("openstate", PseudoProp.ALL_OPENSTATE);
        this.props.put("OpenState", allopenstate);
        this.props.put("osall", allopenstate);
        this.props.put("barrier", allopenstate);
        this.props.put("pb", allopenstate);
        Prop setopenstate = new Prop("SetOpenstate", PseudoProp.SET_OPENSTATE);
        this.props.put("setopenstate", setopenstate);
        this.props.put("so", setopenstate);
        Prop unsetopenstate = new Prop("UnsetOpenstate", PseudoProp.UNSET_OPENSTATE);
        this.props.put("unsetopenstate", unsetopenstate);
        this.props.put("uo", unsetopenstate);
        Prop unlockmap = new Prop("UnlockMap", PseudoProp.UNLOCK_MAP);
        this.props.put("unlockmap", unlockmap);
        this.props.put("um", unlockmap);
        this.props.put("point", unlockmap);
        this.props.put("waypoint", unlockmap);
        this.props.put("teleport ", unlockmap);
        Prop home = new Prop("UnlockHome", PseudoProp.UNLOCK_HOUSE);
        this.props.put("unlockhome", home);
        this.props.put("uh", home);
        this.props.put("teapot", home);
        this.props.put("house", home);
    }

    private boolean setTowerLevel(Player sender, Player targetPlayer, int topFloor) {
        List<Integer> floorIds = targetPlayer.getServer().getTowerSystem().getAllFloors();
        if (topFloor < 0 || topFloor > floorIds.size()) {
            CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.value_between", "Tower Level", 0, Integer.valueOf(floorIds.size()));
            return false;
        }
        Map<Integer, TowerLevelRecord> recordMap = targetPlayer.getTowerManager().getRecordMap();
        for (Integer num : floorIds.subList(0, topFloor)) {
            int floor = num.intValue();
            if (!recordMap.containsKey(Integer.valueOf(floor))) {
                recordMap.put(Integer.valueOf(floor), new TowerLevelRecord(floor));
            }
        }
        for (Integer num2 : floorIds.subList(topFloor, floorIds.size())) {
            int floor2 = num2.intValue();
            if (recordMap.containsKey(Integer.valueOf(floor2))) {
                recordMap.remove(Integer.valueOf(floor2));
            }
        }
        if (topFloor <= 8) {
            return true;
        }
        recordMap.get(floorIds.get(7)).setLevelStars(0, 6);
        return true;
    }

    private boolean setBool(Player sender, Player targetPlayer, PseudoProp pseudoProp, int value) {
        boolean enabled;
        boolean enabled2;
        switch (pseudoProp) {
            case GOD_MODE:
                enabled = targetPlayer.inGodmode();
                break;
            case UNLIMITED_STAMINA:
                enabled = targetPlayer.getUnlimitedStamina();
                break;
            case UNLIMITED_ENERGY:
                if (targetPlayer.getEnergyManager().getEnergyUsage()) {
                    enabled = false;
                    break;
                } else {
                    enabled = true;
                    break;
                }
            default:
                enabled = false;
                break;
        }
        switch (value) {
            case -1:
                if (enabled) {
                    enabled2 = false;
                    break;
                } else {
                    enabled2 = true;
                    break;
                }
            case 0:
                enabled2 = false;
                break;
            default:
                enabled2 = true;
                break;
        }
        switch (pseudoProp) {
            case GOD_MODE:
                targetPlayer.setGodmode(enabled2);
                return true;
            case UNLIMITED_STAMINA:
                targetPlayer.setUnlimitedStamina(enabled2);
                return true;
            case UNLIMITED_ENERGY:
                targetPlayer.getEnergyManager().setEnergyUsage(!enabled2);
                return true;
            default:
                return false;
        }
    }

    private static boolean setOpenState(Player targetPlayer, int state, int value) {
        targetPlayer.sendPacket(new PacketOpenStateChangeNotify(state, value));
        return true;
    }

    public static boolean AllOpenState(Player targetPlayer, int onoff) {
        Map<Integer, Integer> changed = new HashMap<>();
        for (OpenStateData state : GameData.getOpenStateList()) {
            int id = state.getId();
            if (!PlayerProgressManager.DEFAULT_OPEN_STATES.contains(Integer.valueOf(id)) && (targetPlayer.getOpenStates().get(Integer.valueOf(id)) == null || targetPlayer.getOpenStates().get(Integer.valueOf(id)).intValue() != onoff)) {
                targetPlayer.getOpenStates().put(Integer.valueOf(id), Integer.valueOf(onoff));
                changed.put(Integer.valueOf(id), Integer.valueOf(onoff));
            }
        }
        targetPlayer.sendPacket(new PacketOpenStateChangeNotify(changed));
        return true;
    }

    public static boolean unlockMap(Player targetPlayer, int type) {
        if (type == 1 || type == 3) {
            if (type == 1) {
                GameData.getScenePointsPerScene().forEach(sceneId, scenePoints -> {
                    targetPlayer.getUnlockedScenePoints(sceneId.intValue()).addAll(scenePoints);
                    targetPlayer.getUnlockedSceneAreas(sceneId.intValue()).addAll(scene_areas_rand);
                });
            } else if (type == 3) {
                for (int i = 1; i < 9; i++) {
                    targetPlayer.getUnlockedScenePoints(i).addAll(scene_point_rand);
                    targetPlayer.getUnlockedSceneAreas(i).addAll(scene_areas_rand);
                }
            }
            int playerScene = targetPlayer.getSceneId();
            targetPlayer.sendPacket(new PacketScenePointUnlockNotify(playerScene, targetPlayer.getUnlockedScenePoints(playerScene)));
            targetPlayer.sendPacket(new PacketSceneAreaUnlockNotify(playerScene, targetPlayer.getUnlockedSceneAreas(playerScene)));
            CommandHandler.sendMessage(targetPlayer, "Map is already open");
            return true;
        } else if (type == 0) {
            targetPlayer.getUnlockedScenePoints().clear();
            targetPlayer.getUnlockedSceneAreas().clear();
            CommandHandler.sendMessage(targetPlayer, "Remove all Points MAP, you will be logged out automatically in 3 seconds");
            targetPlayer.getSession().LogoutWait(true, 3, "Map close");
            return true;
        } else if (type != 4) {
            return true;
        } else {
            CommandHandler.sendMessage(targetPlayer, "Unlock Music");
            targetPlayer.sendPacket(new PacketScenePointUnlockNotify(3, (int) PacketOpcodes.MeetNpcRsp));
            return true;
        }
    }

    public static boolean unlockHouse(Player targetPlayer) {
        GameHome home = targetPlayer.getHome();
        home.setLevel(10);
        home.save();
        targetPlayer.sendPacket(new PacketHomeBasicInfoNotify(targetPlayer, true));
        return true;
    }
}
