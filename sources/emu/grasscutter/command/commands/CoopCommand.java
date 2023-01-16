package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import java.util.List;

@Command(label = "coop", usage = {"[<host UID>]"}, permission = "server.coop", permissionTargeted = "server.coop.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/CoopCommand.class */
public final class CoopCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        Player host = sender;
        switch (args.size()) {
            case 0:
                if (sender == null) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                break;
            case 1:
                try {
                    host = Grasscutter.getGameServer().getPlayerByUid(Integer.parseInt(args.get(0)));
                    if (host == null) {
                        CommandHandler.sendTranslatedMessage(sender, "commands.execution.player_offline_error", new Object[0]);
                        return;
                    }
                } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                    CommandHandler.sendTranslatedMessage(sender, "commands.generic.invalid.uid", new Object[0]);
                    return;
                }
                break;
            default:
                sendUsageMessage(sender, new String[0]);
                return;
        }
        if (targetPlayer.isInMultiplayer()) {
            targetPlayer.getServer().getMultiplayerSystem().leaveCoop(targetPlayer);
        }
        host.getServer().getMultiplayerSystem().applyEnterMp(targetPlayer, host.getUid());
        targetPlayer.getServer().getMultiplayerSystem().applyEnterMpReply(host, targetPlayer.getUid(), true);
        CommandHandler.sendTranslatedMessage(sender, "commands.coop.success", targetPlayer.getNickname(), host.getNickname());
    }
}
