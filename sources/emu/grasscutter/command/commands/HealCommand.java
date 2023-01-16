package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.server.packet.send.PacketAvatarFightPropUpdateNotify;
import emu.grasscutter.server.packet.send.PacketAvatarLifeStateChangeNotify;
import emu.grasscutter.utils.Language;
import java.util.List;

@Command(label = "heal", aliases = {"h"}, permission = "player.heal", permissionTargeted = "player.heal.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/HealCommand.class */
public final class HealCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        targetPlayer.getTeamManager().getActiveTeam().forEach(entity -> {
            boolean isAlive = entity.isAlive();
            entity.setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, entity.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP));
            entity.getWorld().broadcastPacket(new PacketAvatarFightPropUpdateNotify(entity.getAvatar(), FightProperty.FIGHT_PROP_CUR_HP));
            if (!isAlive) {
                entity.getWorld().broadcastPacket(new PacketAvatarLifeStateChangeNotify(entity.getAvatar()));
            }
        });
        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.heal.success", new Object[0]));
    }
}
