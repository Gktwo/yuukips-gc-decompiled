package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.dailytask.DailyTaskManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketDailyTaskProgressNotify;
import emu.grasscutter.server.packet.send.PacketWorldOwnerDailyTaskNotify;
import java.util.List;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

@Command(label = "daily", usage = {"(add|finish) dailyTaskId", "finishall", "reset"})
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/DailyCommand.class */
public final class DailyCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        String cmd = args.remove(0).toLowerCase();
        DailyTaskManager manager = targetPlayer.getDailyTaskManager();
        char c = 65535;
        switch (cmd.hashCode()) {
            case -1274442605:
                if (cmd.equals("finish")) {
                    c = 1;
                    break;
                }
                break;
            case 96417:
                if (cmd.equals(BeanUtil.PREFIX_ADDER)) {
                    c = 0;
                    break;
                }
                break;
            case 108404047:
                if (cmd.equals("reset")) {
                    c = 3;
                    break;
                }
                break;
            case 591347758:
                if (cmd.equals("finishall")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                if (args.size() < 1) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
                try {
                    Integer.parseInt(args.remove(0));
                    return;
                } catch (NumberFormatException e) {
                    sendUsageMessage(sender, new String[0]);
                    return;
                }
            case 2:
                manager.getDailyTasks().forEach((v0) -> {
                    v0.finish();
                });
                manager.getDailyTasks().forEach(dailyTask -> {
                    targetPlayer.sendPacket(new PacketDailyTaskProgressNotify(dailyTask.toProto()));
                });
                return;
            case 3:
                manager.getDailyTasks().forEach((v0) -> {
                    v0.finish();
                });
                manager.getDailyTasks().forEach(dailyTask -> {
                    targetPlayer.sendPacket(new PacketDailyTaskProgressNotify(dailyTask.toProto()));
                });
                targetPlayer.getDailyTaskManager().resetDailyTasks();
                if (targetPlayer.isOnline()) {
                    targetPlayer.sendPacket(new PacketWorldOwnerDailyTaskNotify(targetPlayer));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
