package emu.grasscutter.game.inventory;

import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/MaterialInventoryTab.class */
public class MaterialInventoryTab implements InventoryTab {
    private final Int2ObjectMap<GameItem> items = new Int2ObjectOpenHashMap();
    private final int maxCapacity;

    public MaterialInventoryTab(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public GameItem getItemById(int id) {
        return this.items.get(id);
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public void onAddItem(GameItem item) {
        this.items.put(item.getItemId(), (int) item);
    }

    @Override // emu.grasscutter.game.inventory.InventoryTab
    public void onRemoveItem(GameItem item) {
        this.items.remove(item.getItemId());
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
