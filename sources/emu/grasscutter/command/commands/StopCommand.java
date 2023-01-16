package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.game.GameServer;
import java.util.List;

@Command(label = "stop", permission = "server.stop", targetRequirement = Command.TargetRequirement.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/StopCommand.class */
public final class StopCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        GameServer.doExit(0, "exit by command");
    }
}
