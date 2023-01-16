package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketChangeMpTeamAvatarRsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

@Command(label = "team", usage = {"add <avatarId,...>", "(remove|set) [index|first|last|index-index,...]"}, permission = "player.team", permissionTargeted = "player.team.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/TeamCommand.class */
public final class TeamCommand implements CommandHandler {
    private static final int BASE_AVATARID = 10000000;

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.isEmpty()) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        String str = args.get(0);
        char c = 65535;
        switch (str.hashCode()) {
            case -934610812:
                if (str.equals("remove")) {
                    c = 1;
                    break;
                }
                break;
            case 96417:
                if (str.equals(BeanUtil.PREFIX_ADDER)) {
                    c = 0;
                    break;
                }
                break;
            case 113762:
                if (str.equals("set")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (!addCommand(sender, targetPlayer, args)) {
                    return;
                }
                break;
            case 1:
                if (!removeCommand(sender, targetPlayer, args)) {
                    return;
                }
                break;
            case 2:
                if (!setCommand(sender, targetPlayer, args)) {
                    return;
                }
                break;
            default:
                CommandHandler.sendTranslatedMessage(sender, "commands.team.invalid_usage", new Object[0]);
                sendUsageMessage(sender, new String[0]);
                return;
        }
        targetPlayer.getTeamManager().updateTeamEntities(new PacketChangeMpTeamAvatarRsp(targetPlayer, targetPlayer.getTeamManager().getCurrentTeamInfo()));
    }

    private boolean addCommand(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 2) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.invalid_usage", new Object[0]);
            sendUsageMessage(sender, new String[0]);
            return false;
        }
        int index = -1;
        if (args.size() > 2) {
            try {
                index = Integer.parseInt(args.get(2)) - 1;
                if (index < 0) {
                    index = 0;
                }
            } catch (Exception e) {
                CommandHandler.sendTranslatedMessage(sender, "commands.team.invalid_index", new Object[0]);
                return false;
            }
        }
        String[] avatarIds = args.get(1).split(",");
        if (targetPlayer.getTeamManager().getCurrentTeamInfo().getAvatars().size() + avatarIds.length > Configuration.GAME_OPTIONS.avatarLimits.singlePlayerTeam) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.add_too_much", Integer.valueOf(Configuration.GAME_OPTIONS.avatarLimits.singlePlayerTeam));
            return false;
        }
        for (String avatarId : avatarIds) {
            try {
                if (!addAvatar(sender, targetPlayer, Integer.parseInt(avatarId), index)) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.team.failed_to_add_avatar", avatarId);
                }
                if (index > 0) {
                    index++;
                }
            } catch (Exception e2) {
            }
        }
        return true;
    }

    private boolean removeCommand(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 2) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.invalid_usage", new Object[0]);
            sendUsageMessage(sender, new String[0]);
            return false;
        }
        List<Integer> currentTeamAvatars = targetPlayer.getTeamManager().getCurrentTeamInfo().getAvatars();
        int avatarCount = currentTeamAvatars.size();
        String[] metaIndexList = args.get(1).split(",");
        HashSet<Integer> indexes = new HashSet<>();
        ArrayList<Integer> ignoreList = new ArrayList<>();
        for (String metaIndex : metaIndexList) {
            List<Integer> subIndexes = transformToIndexes(metaIndex, avatarCount);
            if (subIndexes == null) {
                CommandHandler.sendTranslatedMessage(sender, "commands.team.failed_to_parse_index", metaIndex);
            } else {
                for (Integer avatarIndex : subIndexes) {
                    try {
                        indexes.add(currentTeamAvatars.get(avatarIndex.intValue() - 1));
                    } catch (Exception e) {
                        ignoreList.add(avatarIndex);
                    }
                }
            }
        }
        if (indexes.size() >= avatarCount) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.remove_too_much", new Object[0]);
            return false;
        }
        if (!ignoreList.isEmpty()) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.ignore_index", ignoreList);
        }
        currentTeamAvatars.removeAll(indexes);
        return true;
    }

    private boolean setCommand(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 3) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.invalid_usage", new Object[0]);
            sendUsageMessage(sender, new String[0]);
            return false;
        }
        List<Integer> currentTeamAvatars = targetPlayer.getTeamManager().getCurrentTeamInfo().getAvatars();
        try {
            int index = Integer.parseInt(args.get(1)) - 1;
            if (index < 0) {
                index = 0;
            }
            if (index + 1 > currentTeamAvatars.size()) {
                CommandHandler.sendTranslatedMessage(sender, "commands.team.index_out_of_range", new Object[0]);
                return false;
            }
            try {
                int avatarId = Integer.parseInt(args.get(2));
                if (avatarId < BASE_AVATARID) {
                    avatarId += BASE_AVATARID;
                }
                if (currentTeamAvatars.contains(Integer.valueOf(avatarId))) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.team.avatar_already_in_team", Integer.valueOf(avatarId));
                    return false;
                } else if (!targetPlayer.getAvatars().hasAvatar(avatarId)) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.team.avatar_not_found", Integer.valueOf(avatarId));
                    return false;
                } else {
                    currentTeamAvatars.set(index, Integer.valueOf(avatarId));
                    return true;
                }
            } catch (Exception e) {
                CommandHandler.sendTranslatedMessage(sender, "commands.team.failed_parse_avatar_id", args.get(2));
                return false;
            }
        } catch (Exception e2) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.failed_to_parse_index", args.get(1));
            return false;
        }
    }

    private boolean addAvatar(Player sender, Player targetPlayer, int avatarId, int index) {
        if (avatarId < BASE_AVATARID) {
            avatarId += BASE_AVATARID;
        }
        List<Integer> currentTeamAvatars = targetPlayer.getTeamManager().getCurrentTeamInfo().getAvatars();
        if (currentTeamAvatars.contains(Integer.valueOf(avatarId))) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.avatar_already_in_team", Integer.valueOf(avatarId));
            return false;
        } else if (!targetPlayer.getAvatars().hasAvatar(avatarId)) {
            CommandHandler.sendTranslatedMessage(sender, "commands.team.avatar_not_found", Integer.valueOf(avatarId));
            return false;
        } else {
            try {
                if (index < 0) {
                    currentTeamAvatars.add(Integer.valueOf(avatarId));
                } else {
                    currentTeamAvatars.add(index, Integer.valueOf(avatarId));
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    private List<Integer> transformToIndexes(String metaIndexes, int listLength) {
        int min;
        int max;
        if (metaIndexes.equals("first")) {
            return List.of(1);
        }
        if (metaIndexes.equals("last")) {
            return List.of(Integer.valueOf(listLength));
        }
        if (metaIndexes.contains("-")) {
            String[] range = metaIndexes.split("-");
            if (range.length < 2) {
                return null;
            }
            try {
                String str = range[0];
                char c = 65535;
                switch (str.hashCode()) {
                    case 3314326:
                        if (str.equals("last")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 97440432:
                        if (str.equals("first")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        min = 1;
                        break;
                    case 1:
                        min = listLength;
                        break;
                    default:
                        min = Integer.parseInt(range[0]);
                        break;
                }
                String str2 = range[1];
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case 3314326:
                        if (str2.equals("last")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 97440432:
                        if (str2.equals("first")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        max = 1;
                        break;
                    case 1:
                        max = listLength;
                        break;
                    default:
                        max = Integer.parseInt(range[1]);
                        break;
                }
                if (min > max) {
                    int min2 = min ^ max;
                    max ^= min2;
                    min = min2 ^ max;
                }
                ArrayList<Integer> indexes = new ArrayList<>();
                for (int i = min; i <= max; i++) {
                    indexes.add(Integer.valueOf(i));
                }
                return indexes;
            } catch (Exception e) {
                return null;
            }
        } else {
            try {
                return List.of(Integer.valueOf(Integer.parseInt(metaIndexes)));
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
