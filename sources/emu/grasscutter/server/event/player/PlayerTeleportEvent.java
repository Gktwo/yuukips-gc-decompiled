package emu.grasscutter.server.event.player;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.Cancellable;
import emu.grasscutter.server.event.types.PlayerEvent;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerTeleportEvent.class */
public final class PlayerTeleportEvent extends PlayerEvent implements Cancellable {
    private final TeleportType type;
    private final Position from;

    /* renamed from: to */
    private Position f924to;

    /* loaded from: grasscutter.jar:emu/grasscutter/server/event/player/PlayerTeleportEvent$TeleportType.class */
    public enum TeleportType {
        INTERNAL,
        WAYPOINT,
        MAP,
        DUNGEON,
        COMMAND,
        SCRIPT,
        CLIENT
    }

    public PlayerTeleportEvent(Player player, TeleportType type, Position from, Position to) {
        super(player);
        this.type = type;
        this.from = from;
        this.f924to = to;
    }

    public TeleportType getTeleportType() {
        return this.type;
    }

    public Position getSource() {
        return this.from;
    }

    public Position getDestination() {
        return this.f924to;
    }

    public void setDestination(Position to) {
        this.f924to = to;
    }
}
