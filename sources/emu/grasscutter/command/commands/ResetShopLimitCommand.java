package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.List;

@Command(label = "resetShopLimit", aliases = {"resetshop"}, permission = "server.resetshop", permissionTargeted = "server.resetshop.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/ResetShopLimitCommand.class */
public final class ResetShopLimitCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        targetPlayer.getShopLimit().forEach(x -> {
            x.setNextRefreshTime(0);
        });
        targetPlayer.save();
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.resetShopLimit.success", new Object[0]));
    }
}
