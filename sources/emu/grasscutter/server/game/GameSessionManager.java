package emu.grasscutter.server.game;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.utils.Utils;
import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import kcp.highway.KcpListener;
import kcp.highway.Ukcp;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.DefaultEventLoop;

/* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameSessionManager.class */
public class GameSessionManager {
    private static final DefaultEventLoop logicThread = new DefaultEventLoop();
    private static final ConcurrentHashMap<Ukcp, GameSession> sessions = new ConcurrentHashMap<>();
    private static final KcpListener listener = new KcpListener() { // from class: emu.grasscutter.server.game.GameSessionManager.1
        @Override // kcp.highway.KcpListener
        public void onConnected(final Ukcp ukcp) {
            int times = 0;
            GameServer server = Grasscutter.getGameServer();
            while (server == null) {
                try {
                    Thread.sleep(1000);
                    times++;
                    if (times > 5) {
                        Grasscutter.getLogger().error("Service is not available!");
                        ukcp.close();
                        return;
                    }
                    server = Grasscutter.getGameServer();
                } catch (InterruptedException e) {
                    ukcp.close();
                    return;
                }
            }
            GameSession conversation = new GameSession(server);
            conversation.onConnected(new KcpTunnel() { // from class: emu.grasscutter.server.game.GameSessionManager.1.1
                @Override // emu.grasscutter.server.game.GameSessionManager.KcpTunnel
                public InetSocketAddress getAddress() {
                    return ukcp.user().getRemoteAddress();
                }

                @Override // emu.grasscutter.server.game.GameSessionManager.KcpTunnel
                public void writeData(byte[] bytes) {
                    ByteBuf buf = Unpooled.wrappedBuffer(bytes);
                    ukcp.write(buf);
                    buf.release();
                }

                @Override // emu.grasscutter.server.game.GameSessionManager.KcpTunnel
                public void close() {
                    ukcp.close();
                }

                @Override // emu.grasscutter.server.game.GameSessionManager.KcpTunnel
                public int getSrtt() {
                    return ukcp.srtt();
                }
            });
            GameSessionManager.sessions.put(ukcp, conversation);
        }

        @Override // kcp.highway.KcpListener
        public void handleReceive(ByteBuf buf, Ukcp kcp2) {
            byte[] byteData = Utils.byteBufToArray(buf);
            GameSessionManager.logicThread.execute(() -> {
                try {
                    GameSession conversation = GameSessionManager.sessions.get(kcp2);
                    if (conversation != null) {
                        conversation.handleReceive(byteData);
                    } else {
                        GameSessionManager.sessions.remove(kcp2);
                    }
                } catch (Exception e) {
                    Grasscutter.getLogger().error("handleReceive error:", (Throwable) e);
                }
            });
        }

        @Override // kcp.highway.KcpListener
        public void handleException(Throwable ex, Ukcp ukcp) {
            try {
                if (ukcp != null) {
                    ukcp.close();
                } else {
                    Grasscutter.getLogger().error("ukcp no found");
                }
            } catch (Exception e) {
                Grasscutter.getLogger().error("Erro close:", (Throwable) e);
                Grasscutter.getLogger().error("handleException error:", ex);
            }
        }

        @Override // kcp.highway.KcpListener
        public void handleClose(Ukcp ukcp) {
            try {
                GameSession conversation = GameSessionManager.sessions.get(ukcp);
                if (conversation != null) {
                    conversation.handleClose();
                }
                GameSessionManager.sessions.remove(ukcp);
            } catch (Exception e) {
                Grasscutter.getLogger().error("handleClose error:", (Throwable) e);
            }
        }
    };

    /* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameSessionManager$KcpChannel.class */
    interface KcpChannel {
        void onConnected(KcpTunnel kcpTunnel);

        void handleClose();

        void handleReceive(byte[] bArr);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameSessionManager$KcpTunnel.class */
    public interface KcpTunnel {
        InetSocketAddress getAddress();

        void writeData(byte[] bArr);

        void close();

        int getSrtt();
    }

    public static KcpListener getListener() {
        return listener;
    }
}
