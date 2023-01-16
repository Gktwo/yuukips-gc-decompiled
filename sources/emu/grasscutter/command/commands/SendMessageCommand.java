package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import java.util.List;

@Command(label = "sendMessage", aliases = {"say", "sendservmsg", "sendservermessage", "b", "broadcast"}, usage = {"<message>"}, permission = "server.sendmessage", permissionTargeted = "server.sendmessage.others", targetRequirement = Command.TargetRequirement.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SendMessageCommand.class */
public final class SendMessageCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() == 0) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        String message = String.join(" ", args);
        if (targetPlayer == null) {
            for (Player p : Grasscutter.getGameServer().getPlayers().values()) {
                CommandHandler.sendMessage(p, message);
            }
        } else {
            CommandHandler.sendMessage(targetPlayer, message);
        }
        CommandHandler.sendTranslatedMessage(sender, "commands.sendMessage.success", new Object[0]);
    }
}
