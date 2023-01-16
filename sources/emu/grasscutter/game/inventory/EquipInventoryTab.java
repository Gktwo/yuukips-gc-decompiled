package emu.grasscutter.game.inventory;

import java.util.HashSet;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/EquipInventoryTab.class */
public class EquipInventoryTab implements InventoryTab {
    private final Set<GameItem> items = new HashSet();
    private final int maxCapacity;

    public EquipInventoryTab(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public GameItem getItemById(int id) {
        return null;
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public void onAddItem(GameItem item) {
        this.items.add(item);
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public void onRemoveItem(GameItem item) {
        this.items.remove(item);
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public int getSize() {
        return this.items.size();
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public int getMaxCapacity() {
        return this.maxCapacity;
    }
}
