package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.utils.Language;
import emu.grasscutter.utils.Position;
import java.util.List;

@Command(label = "teleport", aliases = {"tp"}, usage = {"<x> <y> <z> [sceneId]"}, permission = "player.teleport", permissionTargeted = "player.teleport.others", ratelimit = 20)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/TeleportCommand.class */
public final class TeleportCommand implements CommandHandler {
    private float parseRelative(String input, Float current) {
        if (!input.contains("~")) {
            current = Float.valueOf(Float.parseFloat(input));
        } else if (!input.equals("~")) {
            current = Float.valueOf(current.floatValue() + Float.parseFloat(input.replace("~", "")));
        }
        return current.floatValue();
    }

    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        Position pos = targetPlayer.getPosition();
        float x = pos.getX();
        float y = pos.getY();
        float z = pos.getZ();
        int sceneId = targetPlayer.getSceneId();
        switch (args.size()) {
            case 3:
                break;
            default:
                sendUsageMessage(sender, new String[0]);
                return;
            case 4:
                try {
                    sceneId = Integer.parseInt(args.get(3));
                    break;
                } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.execution.argument_error", new Object[0]));
                    break;
                }
        }
        try {
            x = parseRelative(args.get(0), Float.valueOf(x));
            y = parseRelative(args.get(1), Float.valueOf(y));
            z = parseRelative(args.get(2), Float.valueOf(z));
        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e2) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.teleport.invalid_position", new Object[0]));
        }
        if (!targetPlayer.getWorld().transferPlayerToScene(targetPlayer, sceneId, PlayerTeleportEvent.TeleportType.COMMAND, new Position(x, y, z))) {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.teleport.exists_error", new Object[0]));
        } else {
            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.teleport.success", targetPlayer.getNickname(), Float.valueOf(x), Float.valueOf(y), Float.valueOf(z), Integer.valueOf(sceneId)));
        }
    }
}
