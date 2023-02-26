package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.CommandHelpers;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameDepot;
import emu.grasscutter.data.excels.AvatarData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.ReliquaryAffixData;
import emu.grasscutter.data.excels.ReliquaryMainPropData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.inventory.MaterialType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.utils.SparseSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import net.bytebuddy.utility.JavaConstant;
import org.jline.console.Printer;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

@Command(label = "give", aliases = {"g", "item", "giveitem"}, usage = {"(<itemId>|<avatarId>|weapons|mats|avatars|basic|teapot|artifact) [lv<level>] [r<refinement>] [x<amount>] [c<constellation>] [sl<skilllevel>]", "<artifactId> [lv<level>] [x<amount>] [<mainPropId>] [<appendPropId>[,<times>]]..."}, permission = "player.give", permissionTargeted = "player.give.others", ratelimit = 120, count = 20)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/GiveCommand.class */
public final class GiveCommand implements CommandHandler {
    private static final Map<Pattern, BiConsumer<GiveItemParameters, Integer>> intCommandHandlers = Map.ofEntries(Map.entry(CommandHelpers.lvlRegex, arg0, arg1 -> {
        arg0.setLvl(arg1.intValue());
    }), Map.entry(CommandHelpers.refineRegex, arg0, arg1 -> {
        arg0.setRefinement(arg1.intValue());
    }), Map.entry(CommandHelpers.amountRegex, arg0, arg1 -> {
        arg0.setAmount(arg1.intValue());
    }), Map.entry(CommandHelpers.constellationRegex, arg0, arg1 -> {
        arg0.setConstellation(arg1.intValue());
    }), Map.entry(CommandHelpers.skillLevelRegex, arg0, arg1 -> {
        arg0.setSkillLevel(arg1.intValue());
    }));
    private static final SparseSet illegalWeaponIds = new SparseSet("10000-10008, 11411, 11506-11508, 12505, 12506, 12508, 12509,\n13503, 13506, 14411, 14503, 14505, 14508, 15504-15506\n");
    private static final SparseSet illegalRelicIds = new SparseSet("20001, 23300-23340, 23383-23385, 78310-78554, 99310-99554\n");
    private static final SparseSet illegalItemIds = new SparseSet("100086, 100087, 100100-101000, 101106-101110, 101306, 101500-104000,\n105001, 105004, 106000-107000, 107011, 108000, 109000-110000,\n115000-130000, 200200-200899, 220050, 220054\n");

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/GiveCommand$GiveAllType.class */
    public enum GiveAllType {
        NONE,
        BASIC,
        WEAPONS,
        MATS,
        AVATARS,
        HOUSE,
        ARTIFACT
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0017: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0017: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.command.commands.GiveCommand.IsRate(emu.grasscutter.game.player.Player, java.lang.String):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, -]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, -]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static boolean IsRate(emu.grasscutter.game.player.Player r8, java.lang.String r9) {
        /*
            emu.grasscutter.config.ConfigContainer r0 = emu.grasscutter.Grasscutter.getConfig()
            emu.grasscutter.config.ConfigContainer$Server r0 = r0.server
            emu.grasscutter.config.ConfigContainer$Game r0 = r0.game
            emu.grasscutter.config.ConfigContainer$GameOptions r0 = r0.gameOptions
            boolean r0 = r0.RatelimitCMD
            if (r0 == 0) goto L_0x004c
            r0 = r9
            r1 = r8
            int r1 = r1.getUid()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I)Ljava/lang/String;}, -]}
            r10 = r0
            emu.grasscutter.server.game.Ratelimit r0 = new emu.grasscutter.server.game.Ratelimit
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            r1 = r10
            r2 = 3600(0xe10, float:5.045E-42)
            r3 = 1
            r0.Set(r1, r2, r3)
            r0 = r11
            boolean r0 = r0.m1192Is()
            if (r0 == 0) goto L_0x004c
            r0 = r8
            java.lang.String r1 = "commands.generic.ratelimit"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r11
            long r5 = r5.GetMs()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            emu.grasscutter.command.CommandHandler.sendTranslatedMessage(r0, r1, r2)
            r0 = 1
            return r0
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.command.commands.GiveCommand.IsRate(emu.grasscutter.game.player.Player, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/GiveCommand$GiveItemParameters.class */
    public static class GiveItemParameters {

        /* renamed from: id */
        public int f491id;
        public List<Integer> appendPropIdList;
        public ItemData data;
        public AvatarData avatarData;
        public int lvl = 90;
        public int amount = 1;
        public int refinement = 5;
        public int constellation = 6;
        public int skillLevel = 1;
        public int mainPropId = -1;
        public GiveAllType giveAllType = GiveAllType.NONE;

        private GiveItemParameters() {
        }

        public void setLvl(int lvl) {
            this.lvl = lvl;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setRefinement(int refinement) {
            this.refinement = refinement;
        }

        public void setConstellation(int constellation) {
            this.constellation = constellation;
        }

        public void setSkillLevel(int skillLevel) {
            this.skillLevel = skillLevel;
        }
    }

    private GiveItemParameters parseArgs(Player sender, Player targetPlayer, List<String> args) throws IllegalArgumentException {
        GiveItemParameters param = new GiveItemParameters();
        CommandHelpers.parseIntParameters(args, param, intCommandHandlers);
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            throw new IllegalArgumentException();
        }
        String id = args.remove(0);
        boolean isRelic = false;
        char c = 65535;
        switch (id.hashCode()) {
            case -1228798510:
                if (id.equals("artifact")) {
                    c = '\n';
                    break;
                }
                break;
            case -877709243:
                if (id.equals("teapot")) {
                    c = '\t';
                    break;
                }
                break;
            case -635082182:
                if (id.equals("avatars")) {
                    c = '\r';
                    break;
                }
                break;
            case 3109:
                if (id.equals("af")) {
                    c = '\f';
                    break;
                }
                break;
            case PacketOpcodes.WorldPlayerInfoNotify /* 3125 */:
                if (id.equals("av")) {
                    c = 14;
                    break;
                }
                break;
            case 3495:
                if (id.equals("mt")) {
                    c = 5;
                    break;
                }
                break;
            case 3801:
                if (id.equals("wp")) {
                    c = 3;
                    break;
                }
                break;
            case 96673:
                if (id.equals(Printer.ALL)) {
                    c = 1;
                    break;
                }
                break;
            case 3052374:
                if (id.equals("char")) {
                    c = 15;
                    break;
                }
                break;
            case 3208415:
                if (id.equals("home")) {
                    c = '\b';
                    break;
                }
                break;
            case 3242771:
                if (id.equals("item")) {
                    c = 6;
                    break;
                }
                break;
            case 3344147:
                if (id.equals("mats")) {
                    c = 4;
                    break;
                }
                break;
            case 3649297:
                if (id.equals("wife")) {
                    c = 17;
                    break;
                }
                break;
            case 3649313:
                if (id.equals("wifu")) {
                    c = 19;
                    break;
                }
                break;
            case 93508654:
                if (id.equals("basic")) {
                    c = 0;
                    break;
                }
                break;
            case 99469088:
                if (id.equals("house")) {
                    c = 7;
                    break;
                }
                break;
            case 112892910:
                if (id.equals("waifu")) {
                    c = 18;
                    break;
                }
                break;
            case 561951969:
                if (id.equals("artifacts")) {
                    c = 11;
                    break;
                }
                break;
            case 1223328215:
                if (id.equals("weapons")) {
                    c = 2;
                    break;
                }
                break;
            case 1269934139:
                if (id.equals("husband")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                param.giveAllType = GiveAllType.BASIC;
                break;
            case 2:
            case 3:
                param.giveAllType = GiveAllType.WEAPONS;
                break;
            case 4:
            case 5:
            case 6:
                param.giveAllType = GiveAllType.MATS;
                break;
            case 7:
            case '\b':
            case '\t':
                param.giveAllType = GiveAllType.HOUSE;
                break;
            case '\n':
            case 11:
            case '\f':
                param.giveAllType = GiveAllType.ARTIFACT;
                break;
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                param.giveAllType = GiveAllType.AVATARS;
                break;
            default:
                try {
                    param.f491id = Integer.parseInt(id);
                    param.data = GameData.getItemDataMap().get(param.f491id);
                    if (param.f491id > 10000000 && param.f491id < 12000000) {
                        param.avatarData = GameData.getAvatarDataMap().get(param.f491id);
                    } else if (param.f491id > 1000 && param.f491id < 1100) {
                        param.avatarData = GameData.getAvatarDataMap().get((param.f491id - 1000) + 10000000);
                    }
                    isRelic = param.data != null && param.data.getItemType() == ItemType.ITEM_RELIQUARY;
                    if (!isRelic && !args.isEmpty() && param.amount == 1) {
                        try {
                            param.amount = Integer.parseInt(args.remove(0));
                            break;
                        } catch (NumberFormatException e) {
                            CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.amount", new Object[0]);
                            throw e;
                        }
                    }
                } catch (NumberFormatException e2) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.itemId", new Object[0]);
                    throw e2;
                }
                break;
        }
        if (param.amount < 1) {
            param.amount = 1;
        }
        if (param.refinement < 1) {
            param.refinement = 1;
        }
        if (param.refinement > 5) {
            param.refinement = 5;
        }
        if (isRelic) {
            if (param.lvl < 0) {
                param.lvl = 0;
            }
            if (param.lvl > 20) {
                param.lvl = 20;
            }
            param.lvl++;
            if (illegalRelicIds.contains(param.f491id)) {
                CommandHandler.sendTranslatedMessage(sender, "commands.give.illegal_relic", new Object[0]);
            }
        } else {
            if (param.lvl < 1) {
                param.lvl = 1;
            }
            if (param.lvl > 90) {
                param.lvl = 90;
            }
        }
        if (!args.isEmpty()) {
            if (isRelic) {
                try {
                    parseRelicArgs(param, args);
                } catch (IllegalArgumentException e3) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.execution.argument_error", new Object[0]);
                    CommandHandler.sendTranslatedMessage(sender, "commands.give.usage_relic", new Object[0]);
                    throw e3;
                }
            } else {
                sendUsageMessage(sender, new String[0]);
                throw new IllegalArgumentException();
            }
        }
        return param;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.isEmpty()) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        try {
            GiveItemParameters param = parseArgs(sender, targetPlayer, args);
            switch (param.giveAllType) {
                case BASIC:
                    giveBasic(targetPlayer, param);
                    return;
                case WEAPONS:
                    giveAllWeapons(targetPlayer, param);
                    return;
                case MATS:
                    giveAllMats(targetPlayer, param);
                    return;
                case HOUSE:
                    giveAllHouse(targetPlayer, param);
                    return;
                case ARTIFACT:
                    giveAllArt(targetPlayer, param);
                    return;
                case AVATARS:
                    giveAllAvatars(targetPlayer, param);
                    return;
            }
            if (param.avatarData != null) {
                targetPlayer.addAvatar(makeAvatar(param));
                CommandHandler.sendTranslatedMessage(sender, "commands.give.given_avatar", Integer.valueOf(param.f491id), Integer.valueOf(param.lvl), Integer.valueOf(targetPlayer.getUid()));
            } else if (param.data == null) {
                CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.itemId", new Object[0]);
            } else {
                switch (param.data.getItemType()) {
                    case ITEM_WEAPON:
                        if (param.amount > Configuration.GAME_OPTIONS.CMD_Give_WP) {
                            param.amount = Configuration.GAME_OPTIONS.CMD_Give_WP;
                        }
                        targetPlayer.getInventory().addItems(makeUnstackableItems(param), ActionReason.SubfieldDrop);
                        CommandHandler.sendTranslatedMessage(sender, "commands.give.given_with_level_and_refinement", Integer.valueOf(param.f491id), Integer.valueOf(param.lvl), Integer.valueOf(param.refinement), Integer.valueOf(param.amount), Integer.valueOf(targetPlayer.getUid()));
                        return;
                    case ITEM_RELIQUARY:
                        if (param.amount > Configuration.GAME_OPTIONS.CMD_Give_ART) {
                            param.amount = Configuration.GAME_OPTIONS.CMD_Give_ART;
                        }
                        targetPlayer.getInventory().addItems(makeArtifacts(param), ActionReason.SubfieldDrop);
                        CommandHandler.sendTranslatedMessage(sender, "commands.give.given_level", Integer.valueOf(param.f491id), Integer.valueOf(param.lvl), Integer.valueOf(param.amount), Integer.valueOf(targetPlayer.getUid()));
                        return;
                    default:
                        if (param.amount > Configuration.GAME_OPTIONS.CMD_Give) {
                            param.amount = Configuration.GAME_OPTIONS.CMD_Give;
                        }
                        targetPlayer.getInventory().addItem(new GameItem(param.data, param.amount), ActionReason.SubfieldDrop);
                        CommandHandler.sendTranslatedMessage(sender, "commands.give.given", Integer.valueOf(param.amount), Integer.valueOf(param.f491id), Integer.valueOf(targetPlayer.getUid()));
                        return;
                }
            }
        } catch (IllegalArgumentException e) {
        }
    }

    private static Avatar makeAvatar(GiveItemParameters param) {
        return makeAvatar(param.avatarData, param.lvl, Avatar.getMinPromoteLevel(param.lvl), param.constellation, param.skillLevel);
    }

    private static Avatar makeAvatar(AvatarData avatarData, int level, int promoteLevel, int constellation, int skillLevel) {
        Avatar avatar = new Avatar(avatarData);
        avatar.setLevel(level);
        avatar.setPromoteLevel(promoteLevel);
        avatar.getSkillDepot().getSkillsAndEnergySkill().forEach(id -> {
            avatar.setSkillLevel(id, skillLevel);
        });
        avatar.forceConstellationLevel(constellation);
        avatar.recalcStats(true);
        avatar.save();
        return avatar;
    }

    private static void giveAllAvatars(Player player, GiveItemParameters param) {
        if (!IsRate(player, "avatar")) {
            int promoteLevel = Avatar.getMinPromoteLevel(param.lvl);
            if (param.constellation < 0 || param.constellation > 6) {
                param.constellation = 6;
            }
            ObjectIterator<AvatarData> it = GameData.getAvatarDataMap().values().iterator();
            while (it.hasNext()) {
                AvatarData avatarData = it.next();
                int id = avatarData.getId();
                if (id >= 10000002 && id < 11000000) {
                    player.addAvatar(makeAvatar(avatarData, param.lvl, promoteLevel, param.constellation, param.skillLevel), false);
                }
            }
            CommandHandler.sendMessage(player, "Successfully got all avatar");
        }
    }

    private static List<GameItem> makeUnstackableItems(GiveItemParameters param) {
        int promoteLevel = GameItem.getMinPromoteLevel(param.lvl);
        int totalExp = 0;
        if (param.data.getItemType() == ItemType.ITEM_WEAPON) {
            int rankLevel = param.data.getRankLevel();
            for (int i = 1; i < param.lvl; i++) {
                totalExp += GameData.getWeaponExpRequired(rankLevel, i);
            }
        }
        List<GameItem> items = new ArrayList<>(param.amount);
        for (int i2 = 0; i2 < param.amount; i2++) {
            GameItem item = new GameItem(param.data);
            item.setLevel(param.lvl);
            if (item.getItemType() == ItemType.ITEM_WEAPON) {
                item.setPromoteLevel(promoteLevel);
                item.setTotalExp(totalExp);
                item.setRefinement(param.refinement - 1);
            }
            items.add(item);
        }
        return items;
    }

    private static List<GameItem> makeArtifacts(GiveItemParameters param) {
        param.lvl = Math.min(param.lvl, param.data.getMaxLevel());
        int rank = param.data.getRankLevel();
        int totalExp = 0;
        for (int i = 1; i < param.lvl; i++) {
            totalExp += GameData.getRelicExpRequired(rank, i);
        }
        List<GameItem> items = new ArrayList<>(param.amount);
        for (int i2 = 0; i2 < param.amount; i2++) {
            GameItem item = new GameItem(param.data);
            item.setLevel(param.lvl);
            item.setTotalExp(totalExp);
            int numAffixes = param.data.getAppendPropNum() + ((param.lvl - 1) / 4);
            if (param.mainPropId > 0) {
                item.setMainPropId(param.mainPropId);
            }
            if (param.appendPropIdList != null) {
                item.getAppendPropIdList().clear();
                item.getAppendPropIdList().addAll(param.appendPropIdList);
            }
            item.addAppendProps(numAffixes - item.getAppendPropIdList().size());
            items.add(item);
        }
        return items;
    }

    private static int getArtifactMainProp(ItemData itemData, FightProperty prop) throws IllegalArgumentException {
        if (prop != FightProperty.FIGHT_PROP_NONE) {
            for (ReliquaryMainPropData data : GameDepot.getRelicMainPropList(itemData.getMainPropDepotId())) {
                if (data.getWeight() > 0 && data.getFightProp() == prop) {
                    return data.getId();
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private static List<Integer> getArtifactAffixes(ItemData itemData, FightProperty prop) throws IllegalArgumentException {
        if (prop == FightProperty.FIGHT_PROP_NONE) {
            throw new IllegalArgumentException();
        }
        List<Integer> affixes = new ArrayList<>();
        for (ReliquaryAffixData data : GameDepot.getRelicAffixList(itemData.getAppendPropDepotId())) {
            if (data.getWeight() > 0 && data.getFightProp() == prop) {
                affixes.add(Integer.valueOf(data.getId()));
            }
        }
        return affixes;
    }

    private static int getAppendPropId(String substatText, ItemData itemData) throws IllegalArgumentException {
        try {
            return Integer.parseInt(substatText);
        } catch (NumberFormatException e) {
            String[] substatArgs = substatText.split(JavaConstant.Dynamic.DEFAULT_NAME);
            String substatType = substatArgs[0];
            int substatTier = 4;
            if (substatArgs.length > 1) {
                substatTier = Integer.parseInt(substatArgs[1]);
            }
            List<Integer> substats = getArtifactAffixes(itemData, FightProperty.getPropByShortName(substatType));
            if (!substats.isEmpty()) {
                return substats.get(Math.min(Math.max(0, substatTier - 1), substats.size() - 1)).intValue();
            }
            throw new IllegalArgumentException();
        }
    }

    private static void parseRelicArgs(GiveItemParameters param, List<String> args) throws IllegalArgumentException {
        String mainPropIdString = args.remove(0);
        try {
            param.mainPropId = Integer.parseInt(mainPropIdString);
        } catch (NumberFormatException e) {
            param.mainPropId = getArtifactMainProp(param.data, FightProperty.getPropByShortName(mainPropIdString));
        }
        param.appendPropIdList = new ArrayList();
        for (String prop : args) {
            String[] arr = prop.split(",");
            String prop2 = arr[0];
            int n = 1;
            if (arr.length > 1) {
                n = Math.min(Integer.parseInt(arr[1]), 200);
            }
            int appendPropId = getAppendPropId(prop2, param.data);
            for (int i = 0; i < n; i++) {
                param.appendPropIdList.add(Integer.valueOf(appendPropId));
            }
        }
    }

    private static void addItemsChunked(Player player, List<GameItem> items, int packetSize) {
        int lastIdx = items.size() - 1;
        int i = 0;
        while (i <= lastIdx) {
            player.getInventory().addItems(items.subList(i, Math.min(i + packetSize, lastIdx)));
            i += packetSize;
        }
    }

    private static void giveAllMats(Player player, GiveItemParameters param) {
        if (!IsRate(player, "mats")) {
            List<GameItem> itemList = new ArrayList<>();
            int tmpamut = param.amount;
            if (tmpamut == 1) {
                tmpamut = 100;
            }
            if (tmpamut > 1000) {
                tmpamut = 1000;
            }
            ObjectIterator<ItemData> it = GameData.getItemDataMap().values().iterator();
            while (it.hasNext()) {
                ItemData itemdata = it.next();
                int id = itemdata.getId();
                int tmp = tmpamut;
                if (id >= 100000 && !illegalItemIds.contains(id) && !itemdata.isEquip()) {
                    if (itemdata.getItemType() == ItemType.ITEM_MATERIAL && itemdata.getMaterialType() == MaterialType.MATERIAL_WIDGET) {
                        tmp = itemdata.getStackLimit();
                    }
                    if (itemdata.getMaterialType() == MaterialType.MATERIAL_FOOD || itemdata.getMaterialType() == MaterialType.MATERIAL_WIDGET || itemdata.getMaterialType() == MaterialType.MATERIAL_AVATAR_MATERIAL || itemdata.getMaterialType() == MaterialType.MATERIAL_TALENT || itemdata.getMaterialType() == MaterialType.MATERIAL_NAMECARD || itemdata.getMaterialType() == MaterialType.MATERIAL_COSTUME || itemdata.getMaterialType() == MaterialType.MATERIAL_FLYCLOAK || itemdata.getMaterialType() == MaterialType.MATERIAL_ELEM_CRYSTAL || itemdata.getMaterialType() == MaterialType.MATERIAL_NOTICE_ADD_HP) {
                        GameItem item = new GameItem(itemdata);
                        item.setCount(tmp);
                        itemList.add(item);
                    }
                }
            }
            addItemsChunked(player, itemList, 100);
            CommandHandler.sendMessage(player, "Successfully got all item mats");
        }
    }

    private static void giveAllArt(Player player, GiveItemParameters param) {
        if (!IsRate(player, "art")) {
            List<GameItem> itemList = new ArrayList<>();
            int tmplv = param.lvl;
            if (tmplv > 20) {
                tmplv = 21;
            }
            ObjectIterator<ItemData> it = GameData.getItemDataMap().values().iterator();
            while (it.hasNext()) {
                ItemData itemdata = it.next();
                if (itemdata.getItemType() == ItemType.ITEM_RELIQUARY) {
                    GameItem item = new GameItem(itemdata);
                    if (itemdata.getRankLevel() == 5) {
                        item.setLevel(tmplv);
                        itemList.add(item);
                    }
                }
            }
            addItemsChunked(player, itemList, 100);
            CommandHandler.sendMessage(player, "Successfully got all item art");
        }
    }

    private static void giveAllHouse(Player player, GiveItemParameters param) {
        if (!IsRate(player, "house")) {
            List<GameItem> itemList = new ArrayList<>();
            int tmpamut = param.amount;
            if (tmpamut == 1) {
                tmpamut = 100;
            }
            if (tmpamut > 1000) {
                tmpamut = 1000;
            }
            ObjectIterator<ItemData> it = GameData.getItemDataMap().values().iterator();
            while (it.hasNext()) {
                ItemData itemdata = it.next();
                if (itemdata.getItemType() == ItemType.ITEM_FURNITURE) {
                    GameItem item = new GameItem(itemdata);
                    item.setCount(tmpamut);
                    itemList.add(item);
                }
            }
            addItemsChunked(player, itemList, 100);
            CommandHandler.sendMessage(player, "Successfully got all item house");
        }
    }

    private static void giveAllWeapons(Player player, GiveItemParameters param) {
        if (!IsRate(player, "wp")) {
            int promoteLevel = GameItem.getMinPromoteLevel(param.lvl);
            int tmpamut = param.amount;
            if (tmpamut > 3) {
                tmpamut = 3;
            }
            int refinement = param.refinement - 1;
            List<GameItem> itemList = new ArrayList<>();
            ObjectIterator<ItemData> it = GameData.getItemDataMap().values().iterator();
            while (it.hasNext()) {
                ItemData itemdata = it.next();
                int id = itemdata.getId();
                if (id >= 11100 && id <= 16000 && !illegalWeaponIds.contains(id) && itemdata.isEquip() && itemdata.getItemType() == ItemType.ITEM_WEAPON) {
                    for (int i = 0; i < tmpamut; i++) {
                        GameItem item = new GameItem(itemdata);
                        item.setLevel(param.lvl);
                        item.setPromoteLevel(promoteLevel);
                        item.setRefinement(refinement);
                        itemList.add(item);
                    }
                }
            }
            addItemsChunked(player, itemList, 100);
            CommandHandler.sendMessage(player, "Successfully got all weapons");
        }
    }

    private static void giveBasic(Player player, GiveItemParameters param) {
        SetPropCommand.AllOpenState(player, 1);
        SetPropCommand.unlockMap(player, 1);
        player.getInventory().addItem(new GameItem(GameData.getItemDataMap().get(201), 10000), ActionReason.SubfieldDrop);
        player.getInventory().addItem(new GameItem(GameData.getItemDataMap().get(202), 10000), ActionReason.SubfieldDrop);
        player.getInventory().addItem(new GameItem(GameData.getItemDataMap().get(203), 10000), ActionReason.SubfieldDrop);
        player.getInventory().addItem(new GameItem(GameData.getItemDataMap().get((int) PacketOpcodes.UnmarkEntityInMinMapNotify), 1000), ActionReason.SubfieldDrop);
        player.getInventory().addItem(new GameItem(GameData.getItemDataMap().get((int) PacketOpcodes.SceneAvatarStaminaStepRsp), 1000), ActionReason.SubfieldDrop);
        CommandHandler.sendMessage(player, "Successfully unlock basic, now just need `/g weapons|mats|avatars|basic|teapot|artifact` to unlock all items by category");
    }
}
