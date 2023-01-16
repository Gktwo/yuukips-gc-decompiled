package emu.grasscutter.server.event.types;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.Event;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/types/PlayerEvent.class */
public abstract class PlayerEvent extends Event {
    protected final Player player;

    public PlayerEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }
}
