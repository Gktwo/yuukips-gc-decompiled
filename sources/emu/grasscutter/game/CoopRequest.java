package emu.grasscutter.game;

import emu.grasscutter.game.player.Player;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:emu/grasscutter/game/CoopRequest.class */
public class CoopRequest {
    private final Player requester;
    private final long requestTime = System.currentTimeMillis();
    private final long expireTime = this.requestTime + AbstractComponentTracker.LINGERING_TIMEOUT;

    public CoopRequest(Player requester) {
        this.requester = requester;
    }

    public Player getRequester() {
        return this.requester;
    }

    public long getRequestTime() {
        return this.requestTime;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > getExpireTime();
    }
}
