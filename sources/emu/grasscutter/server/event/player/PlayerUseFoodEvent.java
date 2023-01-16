package emu.grasscutter.server.event.player;

import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.Cancellable;
import emu.grasscutter.server.event.types.PlayerEvent;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerUseFoodEvent.class */
public final class PlayerUseFoodEvent extends PlayerEvent implements Cancellable {
    private ItemData foodUsed;
    private final EntityAvatar selectedAvatar;

    public ItemData getFoodUsed() {
        return this.foodUsed;
    }

    public void setFoodUsed(ItemData foodUsed) {
        this.foodUsed = foodUsed;
    }

    public EntityAvatar getSelectedAvatar() {
        return this.selectedAvatar;
    }

    public PlayerUseFoodEvent(Player player, ItemData foodUsed, EntityAvatar selectedAvatar) {
        super(player);
        this.foodUsed = foodUsed;
        this.selectedAvatar = selectedAvatar;
    }
}
