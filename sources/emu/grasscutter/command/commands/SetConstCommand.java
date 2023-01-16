package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.game.world.World;
import emu.grasscutter.server.packet.send.PacketSceneEntityAppearNotify;
import emu.grasscutter.utils.Position;
import java.util.List;
import org.jline.console.Printer;

@Command(label = "setConst", aliases = {"setconstellation"}, usage = {"<constellation level> [all]"}, permission = "player.setconstellation", permissionTargeted = "player.setconstellation.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/SetConstCommand.class */
public final class SetConstCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        try {
            int constLevel = Integer.parseInt(args.get(0));
            if (constLevel < -1 || constLevel > 6) {
                CommandHandler.sendTranslatedMessage(sender, "commands.setConst.range_error", new Object[0]);
            } else if (args.size() == 1) {
                EntityAvatar entity = targetPlayer.getTeamManager().getCurrentAvatarEntity();
                if (entity != null) {
                    Avatar avatar = entity.getAvatar();
                    setConstellation(targetPlayer, avatar, constLevel);
                    CommandHandler.sendTranslatedMessage(sender, "commands.setConst.success", avatar.getAvatarData().getName(), Integer.valueOf(constLevel));
                }
            } else {
                if (args.size() <= 1 || !args.get(1).equalsIgnoreCase(Printer.ALL)) {
                    sendUsageMessage(sender, new String[0]);
                } else {
                    setAllConstellation(targetPlayer, constLevel);
                    CommandHandler.sendTranslatedMessage(sender, "commands.setConst.successall", Integer.valueOf(constLevel));
                }
            }
        } catch (NumberFormatException e) {
            CommandHandler.sendTranslatedMessage(sender, "commands.setConst.level_error", new Object[0]);
        }
    }

    private void setConstellation(Player player, Avatar avatar, int constLevel) {
        int currentConstLevel = avatar.getCoreProudSkillLevel();
        avatar.forceConstellationLevel(constLevel);
        if (constLevel < currentConstLevel) {
            reloadScene(player);
        }
        avatar.recalcConstellations();
        avatar.recalcStats(true);
        avatar.save();
    }

    private void setAllConstellation(Player player, int constLevel) {
        player.getAvatars().forEach(avatar -> {
            avatar.forceConstellationLevel(constLevel);
            avatar.recalcConstellations();
            avatar.recalcStats(true);
            avatar.save();
        });
        reloadScene(player);
    }

    private void reloadScene(Player player) {
        World world = player.getWorld();
        Scene scene = player.getScene();
        Position pos = player.getPosition();
        world.transferPlayerToScene(player, 1, pos);
        world.transferPlayerToScene(player, scene.getId(), pos);
        scene.broadcastPacket(new PacketSceneEntityAppearNotify(player));
    }
}
