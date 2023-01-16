package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.utils.Language;
import java.util.List;

@Command(label = "teleportAll", aliases = {"tpall"}, permission = "player.tpall", permissionTargeted = "player.tpall.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/TeleportAllCommand.class */
public final class TeleportAllCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (!targetPlayer.getWorld().isMultiplayer()) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.teleportAll.error", new Object[0]));
            return;
        }
        for (Player player : targetPlayer.getWorld().getPlayers()) {
            if (!player.equals(targetPlayer)) {
                player.getWorld().transferPlayerToScene(player, targetPlayer.getSceneId(), PlayerTeleportEvent.TeleportType.COMMAND, targetPlayer.getPosition());
            }
        }
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.teleportAll.success", new Object[0]));
    }
}
