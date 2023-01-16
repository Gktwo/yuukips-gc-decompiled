package emu.grasscutter.command;

import emu.grasscutter.game.player.Player;

/* loaded from: grasscutter.jar:emu/grasscutter/command/PermissionHandler.class */
public interface PermissionHandler {
    boolean EnablePermissionCommand();

    boolean checkPermission(Player player, Player player2, String str, String str2);
}
