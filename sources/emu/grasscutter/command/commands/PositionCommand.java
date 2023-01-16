package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Position;
import java.util.List;

@Command(label = "position", aliases = {"pos"})
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/PositionCommand.class */
public final class PositionCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        Position pos = targetPlayer.getPosition();
        Position rot = targetPlayer.getRotation();
        CommandHandler.sendTranslatedMessage(sender, "commands.position.success", Float.valueOf(pos.getX()), Float.valueOf(pos.getY()), Float.valueOf(pos.getZ()), Float.valueOf(rot.getX()), Float.valueOf(rot.getY()), Float.valueOf(rot.getZ()), Integer.valueOf(targetPlayer.getSceneId()));
    }
}
