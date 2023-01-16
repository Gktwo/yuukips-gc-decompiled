package emu.grasscutter.server.event.player;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.types.PlayerEvent;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerTeamDeathEvent.class */
public final class PlayerTeamDeathEvent extends PlayerEvent {
    private final EntityAvatar selectedAvatar;

    public EntityAvatar getSelectedAvatar() {
        return this.selectedAvatar;
    }

    public PlayerTeamDeathEvent(Player player, EntityAvatar selectedAvatar) {
        super(player);
        this.selectedAvatar = selectedAvatar;
    }
}
