package emu.grasscutter.command.commands;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.Account;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.utils.Language;
import java.util.List;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

@Command(label = "permission", usage = {"add <permission>", "remove <permission>", LineReader.CLEAR, "list"}, permission = "server.permission", targetRequirement = Command.TargetRequirement.PLAYER)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/PermissionCommand.class */
public final class PermissionCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.isEmpty() || args.size() > 2) {
            sendUsageMessage(sender, new String[0]);
        } else if (!Grasscutter.getPermissionHandler().EnablePermissionCommand()) {
            CommandHandler.sendTranslatedMessage(sender, "commands.generic.permission_error", new Object[0]);
        } else {
            String action = args.get(0);
            String permission = "";
            if (args.size() > 1) {
                permission = args.get(1);
            }
            Account account = targetPlayer.getAccount();
            if (account == null) {
                CommandHandler.sendMessage(sender, Language.translate(sender, "commands.permission.account_error", new Object[0]));
                return;
            }
            char c = 65535;
            switch (action.hashCode()) {
                case -934610812:
                    if (action.equals("remove")) {
                        c = 2;
                        break;
                    }
                    break;
                case 96417:
                    if (action.equals(BeanUtil.PREFIX_ADDER)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3322014:
                    if (action.equals("list")) {
                        c = 4;
                        break;
                    }
                    break;
                case 94746189:
                    if (action.equals(LineReader.CLEAR)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 1:
                    if (!permission.isEmpty()) {
                        if (!account.addPermission(permission)) {
                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.permission.has_error", new Object[0]));
                            break;
                        } else {
                            CommandHandler.sendMessage(sender, Language.translate(sender, "commands.permission.add", new Object[0]));
                            break;
                        }
                    } else {
                        sendUsageMessage(sender, new String[0]);
                        break;
                    }
                case 2:
                    if (!account.removePermission(permission)) {
                        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.permission.not_have_error", new Object[0]));
                        break;
                    } else {
                        CommandHandler.sendMessage(sender, Language.translate(sender, "commands.permission.remove", new Object[0]));
                        break;
                    }
                case 3:
                    account.clearPermission();
                    CommandHandler.sendMessage(sender, Language.translate(sender, "commands.permission.remove", new Object[0]));
                    break;
                case 4:
                    CommandHandler.sendMessage(sender, String.join("\n", account.getPermissions()));
                    break;
                default:
                    sendUsageMessage(sender, new String[0]);
                    break;
            }
            account.save();
        }
    }
}
