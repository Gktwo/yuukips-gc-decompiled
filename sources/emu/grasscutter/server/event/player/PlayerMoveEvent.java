package emu.grasscutter.server.event.player;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.types.PlayerEvent;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerMoveEvent.class */
public final class PlayerMoveEvent extends PlayerEvent {
    private final MoveType type;
    private final Position from;

    /* renamed from: to */
    private final Position f923to;

    /* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerMoveEvent$MoveType.class */
    public enum MoveType {
        PLAYER,
        SERVER
    }

    public PlayerMoveEvent(Player player, MoveType type, Position from, Position to) {
        super(player);
        this.type = type;
        this.from = from;
        this.f923to = to;
    }

    public MoveType getMoveType() {
        return this.type;
    }

    public Position getSource() {
        return this.from;
    }

    public Position getDestination() {
        return this.f923to;
    }
}
