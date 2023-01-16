package emu.grasscutter.server.event.game;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.event.Cancellable;
import emu.grasscutter.server.event.types.ServerEvent;
import javax.annotation.Nullable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/game/ReceiveCommandFeedbackEvent.class */
public final class ReceiveCommandFeedbackEvent extends ServerEvent implements Cancellable {
    @Nullable
    private final Player player;
    private String message;

    public ReceiveCommandFeedbackEvent(@Nullable Player player, String message) {
        super(ServerEvent.Type.GAME);
        this.player = player;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Nullable
    public Player getPlayer() {
        return this.player;
    }
}
