package emu.grasscutter.game.inventory;

/* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/InventoryTab.class */
public interface InventoryTab {
    GameItem getItemById(int i);

    void onAddItem(GameItem gameItem);

    void onRemoveItem(GameItem gameItem);

    int getSize();

    int getMaxCapacity();
}
