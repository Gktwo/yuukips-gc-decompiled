package emu.grasscutter.server.event.player;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.types.PlayerEvent;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerQuitEvent.class */
public final class PlayerQuitEvent extends PlayerEvent {
    public PlayerQuitEvent(Player player) {
        super(player);
    }
}
