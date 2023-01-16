package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.List;
import org.jline.console.Printer;

@Command(label = "resetConst", aliases = {"resetconstellation"}, usage = {"[all]"}, permission = "player.resetconstellation", permissionTargeted = "player.resetconstellation.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/ResetConstCommand.class */
public final class ResetConstCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() <= 0 || !args.get(0).equalsIgnoreCase(Printer.ALL)) {
            EntityAvatar entity = targetPlayer.getTeamManager().getCurrentAvatarEntity();
            if (entity != null) {
                Avatar avatar = entity.getAvatar();
                resetConstellation(avatar);
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.resetConst.success", avatar.getAvatarData().getName()));
                return;
            }
            return;
        }
        targetPlayer.getAvatars().forEach(this::resetConstellation);
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.resetConst.reset_all", new Object[0]));
    }

    private void resetConstellation(Avatar avatar) {
        avatar.forceConstellationLevel(-1);
    }
}
