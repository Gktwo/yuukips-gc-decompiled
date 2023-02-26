package emu.grasscutter.command.commands;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.Inventory;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.player.Player;
import java.util.List;
import org.jline.console.Printer;
import org.jline.reader.LineReader;

@Command(label = LineReader.CLEAR, usage = {"[all|wp|art|mat]"}, permission = "player.clearinv", permissionTargeted = "player.clearinv.others", ratelimit = 60)
/* loaded from: grasscutter.jar:emu/grasscutter/command/commands/ClearCommand.class */
public final class ClearCommand implements CommandHandler {
    @Override // emu.grasscutter.command.CommandHandler
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        if (args.size() < 1) {
            sendUsageMessage(sender, new String[0]);
            return;
        }
        Inventory playerInventory = sender.getInventory();
        List<GameItem> toDelete = null;
        String str = args.get(0);
        char c = 65535;
        switch (str.hashCode()) {
            case 3801:
                if (str.equals("wp")) {
                    c = 0;
                    break;
                }
                break;
            case 96673:
                if (str.equals(Printer.ALL)) {
                    c = 3;
                    break;
                }
                break;
            case 96867:
                if (str.equals("art")) {
                    c = 1;
                    break;
                }
                break;
            case 107872:
                if (str.equals("mat")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                toDelete = playerInventory.getItems().values().stream().filter(item -> {
                    return item.getItemType() == ItemType.ITEM_WEAPON;
                }).filter(item -> {
                    return !item.isLocked() && !item.isEquipped();
                }).limit((long) 1000).toList();
                CommandHandler.sendTranslatedMessage(sender, "commands.clear.weapons", targetPlayer.getNickname());
                break;
            case 1:
                toDelete = playerInventory.getItems().values().stream().filter(item -> {
                    return item.getItemType() == ItemType.ITEM_RELIQUARY;
                }).filter(item -> {
                    return !item.isLocked() && !item.isEquipped();
                }).limit((long) 1000).toList();
                CommandHandler.sendTranslatedMessage(sender, "commands.clear.artifacts", targetPlayer.getNickname());
                break;
            case 2:
                toDelete = playerInventory.getItems().values().stream().filter(item -> {
                    return item.getItemType() == ItemType.ITEM_MATERIAL;
                }).filter(item -> {
                    return !item.isLocked() && !item.isEquipped();
                }).limit((long) 1000).toList();
                CommandHandler.sendTranslatedMessage(sender, "commands.clear.materials", targetPlayer.getNickname());
                break;
            case 3:
                toDelete = playerInventory.getItems().values().stream().filter(item -> {
                    return !item.isLocked() && !item.isEquipped();
                }).limit((long) 1000).toList();
                break;
        }
        if (toDelete != null) {
            CommandHandler.sendTranslatedMessage(sender, "dockergs.commands.clear.done", Integer.valueOf(toDelete.size()), 1000);
            playerInventory.removeItems(toDelete);
        }
    }
}
