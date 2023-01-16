package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Command(label = "setStats", aliases = {"stats", "stat"}, usage = {"[set] <stat> <value>", "(lock|freeze) <stat> [<value>]", "(unlock|unfreeze) <stat>"}, permission = "player.setstats", permissionTargeted = "player.setstats.others", count = 3)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetStatsCommand.class */
public final class SetStatsCommand implements CommandHandler {
    private Map<String, Stat> stats = new HashMap();

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetStatsCommand$Stat.class */
    private static class Stat {
        String name;
        FightProperty prop;

        public Stat(FightProperty prop) {
            this.name = prop.toString();
            this.prop = prop;
        }

        public Stat(String name, FightProperty prop) {
            this.name = name;
            this.prop = prop;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetStatsCommand$Action.class */
    private enum Action {
        ACTION_SET("commands.generic.set_to", "commands.generic.set_for_to"),
        ACTION_LOCK("commands.setStats.locked_to", "commands.setStats.locked_for_to"),
        ACTION_UNLOCK("commands.setStats.unlocked", "commands.setStats.unlocked_for");
        
        public final String messageKeySelf;
        public final String messageKeyOther;

        Action(String messageKeySelf, String messageKeyOther) {
            this.messageKeySelf = messageKeySelf;
            this.messageKeyOther = messageKeyOther;
        }
    }

    public SetStatsCommand() {
        for (String key : FightProperty.getShortNames()) {
            this.stats.put(key, new Stat(FightProperty.getPropByShortName(key)));
        }
        FightProperty[] values = FightProperty.values();
        for (FightProperty prop : values) {
            String name = prop.toString().substring(10);
            this.stats.put(name.toLowerCase(), new Stat(name.substring(1), prop));
        }
        this.stats.put("mhp", this.stats.get("maxhp"));
        this.stats.put("hp", this.stats.get("_cur_hp"));
        this.stats.put("atk", this.stats.get("_cur_attack"));
        this.stats.put("def", this.stats.get("_cur_defense"));
        this.stats.put("atkb", this.stats.get("_base_attack"));
        this.stats.put("eanemo", this.stats.get("anemo%"));
        this.stats.put("ecryo", this.stats.get("cryo%"));
        this.stats.put("edendro", this.stats.get("dendro%"));
        this.stats.put("edend", this.stats.get("dendro%"));
        this.stats.put("eelectro", this.stats.get("electro%"));
        this.stats.put("eelec", this.stats.get("electro%"));
        this.stats.put("ethunder", this.stats.get("electro%"));
        this.stats.put("egeo", this.stats.get("geo%"));
        this.stats.put("ehydro", this.stats.get("hydro%"));
        this.stats.put("epyro", this.stats.get("pyro%"));
        this.stats.put("ephys", this.stats.get("phys%"));
    }

    public static float parsePercent(String input) throws NumberFormatException {
        if (input.endsWith("%")) {
            return Float.parseFloat(input.substring(0, input.length() - 1)) / 100.0f;
        }
        return Float.parseFloat(input);
    }

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        Action action;
        String valueStr;
        String statStr = null;
        float value = 0.0f;
        if (args.size() < 2) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        String arg0 = args.remove(0).toLowerCase();
        char c = 65535;
        switch (arg0.hashCode()) {
            case -1266402665:
                if (arg0.equals("freeze")) {
                    c = 3;
                    break;
                }
                break;
            case -840442044:
                if (arg0.equals("unlock")) {
                    c = 4;
                    break;
                }
                break;
            case -379899280:
                if (arg0.equals("unfreeze")) {
                    c = 5;
                    break;
                }
                break;
            case 113762:
                if (arg0.equals("set")) {
                    c = 1;
                    break;
                }
                break;
            case 3327275:
                if (arg0.equals("lock")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 1:
                action = Action.ACTION_SET;
                break;
            case 2:
            case 3:
                action = Action.ACTION_LOCK;
                break;
            case 4:
            case 5:
                action = Action.ACTION_UNLOCK;
                break;
            default:
                statStr = arg0;
                action = Action.ACTION_SET;
                break;
        }
        if (statStr == null) {
            statStr = args.remove(0).toLowerCase();
        }
        if (!this.stats.containsKey(statStr)) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        Stat stat = this.stats.get(statStr);
        EntityAvatar entity = targetPlayer.getTeamManager().getCurrentAvatarEntity();
        Avatar avatar = entity.getAvatar();
        try {
            switch (action) {
                case ACTION_LOCK:
                    if (args.isEmpty()) {
                        value = avatar.getFightProperty(stat.prop);
                        break;
                    }
                case ACTION_SET:
                    value = parsePercent(args.remove(0));
                    break;
            }
            if (!args.isEmpty()) {
                sendUsageMessage(sender, new String[0]);
                return;
            }
            switch (action) {
                case ACTION_LOCK:
                    avatar.getFightPropOverrides().put(stat.prop.getId(), value);
                    avatar.recalcStats();
                    break;
                case ACTION_SET:
                    entity.setFightProperty(stat.prop, value);
                    entity.getWorld().broadcastPacket(new PacketEntityFightPropUpdateNotify(entity, stat.prop));
                    break;
                case ACTION_UNLOCK:
                    avatar.getFightPropOverrides().remove(stat.prop.getId());
                    avatar.recalcStats();
                    break;
            }
            if (FightProperty.isPercentage(stat.prop)) {
                valueStr = String.format("%.1f%%", Float.valueOf(value * 100.0f));
            } else {
                valueStr = String.format("%.0f", Float.valueOf(value));
            }
            if (targetPlayer == sender) {
                CommandHandler.sendTranslatedMessage(sender, action.messageKeySelf, stat.name, valueStr);
                return;
            }
            CommandHandler.sendTranslatedMessage(sender, action.messageKeyOther, stat.name, targetPlayer.getAccount().getId(), valueStr);
        } catch (IndexOutOfBoundsException e) {
            sendUsageMessage(sender, new String[0]);
        } catch (NumberFormatException e2) {
            CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.statValue", new Object[0]);
        }
    }
}
