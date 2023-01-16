package emu.grasscutter.command;

import emu.grasscutter.game.Account;
import emu.grasscutter.game.player.Player;

/* loaded from: grasscutter.jar:emu/grasscutter/command/DefaultPermissionHandler.class */
public class DefaultPermissionHandler implements PermissionHandler {
    @Override // emu.grasscutter.command.PermissionHandler
    public boolean EnablePermissionCommand() {
        return true;
    }

    @Override // emu.grasscutter.command.PermissionHandler
    public boolean checkPermission(Player player, Player targetPlayer, String permissionNode, String permissionNodeTargeted) {
        if (player == null) {
            return true;
        }
        Account account = player.getAccount();
        if (player != targetPlayer && !permissionNodeTargeted.isEmpty() && !account.hasPermission(permissionNodeTargeted)) {
            CommandHandler.sendTranslatedMessage(player, "commands.generic.permission_error", new Object[0]);
            return false;
        } else if (permissionNode.isEmpty() || account.hasPermission(permissionNode)) {
            return true;
        } else {
            CommandHandler.sendTranslatedMessage(player, "commands.generic.permission_error", new Object[0]);
            return false;
        }
    }
}
