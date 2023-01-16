package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.systems.AnnouncementSystem;
import emu.grasscutter.server.packet.send.PacketServerAnnounceNotify;
import emu.grasscutter.utils.Language;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Command(label = "announce", usage = {"<content>", "refresh", "(tpl|revoke) <templateId>"}, permission = "server.announce", aliases = {"a"}, targetRequirement = Command.TargetRequirement.NONE)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/AnnounceCommand.class */
public final class AnnounceCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        AnnouncementSystem manager = Grasscutter.getGameServer().getAnnouncementSystem();
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        String str = args.get(0);
        char c = 65535;
        switch (str.hashCode()) {
            case -934343034:
                if (str.equals("revoke")) {
                    c = 2;
                    break;
                }
                break;
            case 115056:
                if (str.equals("tpl")) {
                    c = 0;
                    break;
                }
                break;
            case 1085444827:
                if (str.equals("refresh")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (args.size() < 2) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                int templateId = Integer.parseInt(args.get(1));
                AnnouncementSystem.AnnounceConfigItem tpl = manager.getAnnounceConfigItemMap().get(Integer.valueOf(templateId));
                if (tpl == null) {
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.announce.not_found", Integer.valueOf(templateId)));
                    return;
                }
                manager.broadcast(Collections.singletonList(tpl));
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.announce.send_success", Integer.valueOf(tpl.getTemplateId())));
                return;
            case 1:
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.announce.refresh_success", Integer.valueOf(manager.refresh())));
                return;
            case 2:
                if (args.size() < 2) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                int templateId1 = Integer.parseInt(args.get(1));
                manager.revoke(templateId1);
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.announce.revoke_done", Integer.valueOf(templateId1)));
                return;
            default:
                int id = new Random().nextInt(10000, 99999);
                String text = String.join(" ", args);
                manager.getOnlinePlayers().forEach(i -> {
                    i.sendPacket(new PacketServerAnnounceNotify(text, id));
                });
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.announce.send_success", Integer.valueOf(id)));
                return;
        }
    }
}
