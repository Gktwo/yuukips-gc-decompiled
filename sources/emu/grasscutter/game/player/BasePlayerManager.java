package emu.grasscutter.game.player;

import lombok.NonNull;

/* loaded from: grasscutter.jar:emu/grasscutter/game/player/BasePlayerManager.class */
public abstract class BasePlayerManager {
    protected final transient Player player;

    public BasePlayerManager(@NonNull Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void save() {
        getPlayer().save();
    }
}
