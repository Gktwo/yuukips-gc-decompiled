package emu.grasscutter.game.player;

import lombok.NonNull;

/* loaded from: grasscutter.jar:emu/grasscutter/game/player/BasePlayerDataManager.class */
public abstract class BasePlayerDataManager {
    protected transient Player player;

    public BasePlayerDataManager() {
    }

    public BasePlayerDataManager(@NonNull Player player) {
        if (player == null) {
            throw new NullPointerException("player is marked non-null but is null");
        }
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        if (this.player == null) {
            this.player = player;
        }
    }
}
