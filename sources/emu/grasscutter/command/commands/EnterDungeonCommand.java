package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.List;

@Command(label = "enter_dungeon", aliases = {"enterdungeon", "dungeon", "dg"}, usage = {"<dungeonId>"}, permission = "player.enterdungeon", permissionTargeted = "player.enterdungeon.others", ratelimit = 20)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/EnterDungeonCommand.class */
public final class EnterDungeonCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        try {
            int dungeonId = Integer.parseInt(args.get(0));
            if (dungeonId == targetPlayer.getSceneId()) {
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.enter_dungeon.in_dungeon_error", new Object[0]));
                return;
            }
            if (!targetPlayer.getServer().getDungeonSystem().enterDungeon(targetPlayer.getSession().getPlayer(), 0, dungeonId)) {
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.enter_dungeon.not_found_error", new Object[0]));
            } else {
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.enter_dungeon.changed", Integer.valueOf(dungeonId)));
            }
        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
            sendUsageMessage(sender, new String[0]);
        }
    }
}
