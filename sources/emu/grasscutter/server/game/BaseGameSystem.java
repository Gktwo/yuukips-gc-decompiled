package emu.grasscutter.server.game;

/* loaded from: grasscutter.jar:emu/grasscutter/server/game/BaseGameSystem.class */
public abstract class BaseGameSystem {
    protected final GameServer server;

    public BaseGameSystem(GameServer server) {
        this.server = server;
    }

    public GameServer getServer() {
        return this.server;
    }
}
