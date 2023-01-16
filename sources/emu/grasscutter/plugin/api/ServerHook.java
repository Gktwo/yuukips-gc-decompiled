package emu.grasscutter.plugin.api;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.auth.AuthenticationSystem;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.CommandMap;
import emu.grasscutter.command.PermissionHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.http.HttpServer;
import emu.grasscutter.server.http.Router;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* loaded from: grasscutter.jar:emu/grasscutter/plugin/api/ServerHook.class */
public final class ServerHook {
    private static ServerHook instance;
    private final GameServer gameServer;
    private final HttpServer httpServer;

    public static ServerHook getInstance() {
        return instance;
    }

    public ServerHook(GameServer gameServer, HttpServer httpServer) {
        this.gameServer = gameServer;
        this.httpServer = httpServer;
        instance = this;
    }

    public GameServer getGameServer() {
        return this.gameServer;
    }

    public HttpServer getHttpServer() {
        return this.httpServer;
    }

    @Deprecated(forRemoval = true)
    public List<Player> getOnlinePlayers() {
        return new ArrayList(this.gameServer.getPlayers().values());
    }

    public Stream<Player> getOnlinePlayersStream() {
        return this.gameServer.getPlayers().values().stream();
    }

    public void registerCommand(CommandHandler handler) {
        Class<?> cls = handler.getClass();
        if (!cls.isAnnotationPresent(Command.class)) {
            throw new IllegalArgumentException("Command handler must be annotated with @Command.");
        }
        CommandMap.getInstance().registerCommand(((Command) cls.getAnnotation(Command.class)).label(), handler);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: emu.grasscutter.plugin.api.ServerHook */
    /* JADX WARN: Multi-variable type inference failed */
    public void addRouter(Router router) {
        addRouter((Class<? extends Router>) router.getClass());
    }

    public void addRouter(Class<? extends Router> router) {
        this.httpServer.addRouter(router, new Object[0]);
    }

    public void setAuthSystem(AuthenticationSystem authSystem) {
        Grasscutter.setAuthenticationSystem(authSystem);
    }

    public void setPermissionHandler(PermissionHandler permHandler) {
        Grasscutter.setPermissionHandler(permHandler);
    }
}
