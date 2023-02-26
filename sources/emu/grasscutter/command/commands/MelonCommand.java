package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketWindSeedClientNotify;
import java.util.List;

@Command(label = "melon", usage = {"[ufps.luac/luac file in lua folder]"}, aliases = {"moe"}, permission = "player.melon", permissionTargeted = "player.melon.others")
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/MelonCommand.class */
public class MelonCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        try {
            sender.sendPacket(new PacketWindSeedClientNotify(args.get(0)));
            CommandHandler.sendMessage(sender, "Melon!");
        } catch (Exception e) {
            sendUsageMessage(sender, new String[0]);
        }
    }
}
