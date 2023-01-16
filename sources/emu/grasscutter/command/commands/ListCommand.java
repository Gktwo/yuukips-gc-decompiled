package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.List;
import java.util.Map;

@Command(label = "list", aliases = {"players"}, usage = {"[<UID>]"}, targetRequirement = Command.TargetRequirement.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/ListCommand.class */
public final class ListCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        Map<Integer, Player> playersMap = Grasscutter.getGameServer().getPlayers();
        boolean needUID = false;
        if (args.size() > 0) {
            needUID = args.get(0).equals("uid");
        }
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.list.success", Integer.valueOf(playersMap.size())));
        if (Grasscutter.getConfig().server.game.gameOptions.CMD_ListOnline && playersMap.size() != 0) {
            StringBuilder playerSet = new StringBuilder();
            playersMap.values().forEach(player -> {
                playerSet.append(player.getNickname());
                if (needUID) {
                    if (sender != null) {
                        playerSet.append(" <color=green>(").append(player.getUid()).append(")</color>");
                    } else {
                        playerSet.append(" (").append(player.getUid()).append(")");
                    }
                }
                playerSet.append(", ");
            });
            String players = playerSet.toString();
            CommandHandler.sendMessage(sender, players.substring(0, players.length() - 2));
        }
    }
}
