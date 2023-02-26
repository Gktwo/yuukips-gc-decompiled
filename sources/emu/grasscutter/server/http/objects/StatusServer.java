package emu.grasscutter.server.http.objects;

import dev.morphia.annotations.Entity;
import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.ConfigContainer;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.Utils;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/server/http/objects/StatusServer.class */
public class StatusServer {
    private Map<Integer, Player> playersMap = Grasscutter.getGameServer().getPlayers();
    private ArrayList<User> UserList = new ArrayList<>();

    public ArrayList<User> getUser() {
        return this.UserList;
    }

    public void addUser(Player player) {
        this.UserList.add(new User(player));
    }

    public Output getOutput() {
        return new Output();
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/server/http/objects/StatusServer$Output.class */
    public class Output {
        public int retcode = 0;
        public Status status;

        public Output() {
            this.status = new Status();
        }
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/server/http/objects/StatusServer$Status.class */
    public class Status {
        public Grasscutter.ServerRunMode runMode = Grasscutter.getRunMode();
        private boolean gameonly;

        /* renamed from: mb */
        private int f927mb;
        private MemoryMXBean memoryBean;
        private ThreadMXBean threadBean;
        public long MemoryMax;
        public long MemoryCurrently;
        public long MemoryInit;
        public long MemoryCommitted;
        public int Thread;
        public long ThreadTotalStarted;
        public int ThreadDaemon;
        public int TotalPlayer;
        public int playerCount;
        public int maxPlayer;
        public String DockerGS;
        public String Version;

        public Status() {
            this.gameonly = this.runMode == Grasscutter.ServerRunMode.GAME_ONLY || this.runMode == Grasscutter.ServerRunMode.HYBRID;
            this.f927mb = 1048576;
            this.memoryBean = ManagementFactory.getMemoryMXBean();
            this.threadBean = ManagementFactory.getThreadMXBean();
            this.MemoryMax = this.memoryBean.getHeapMemoryUsage().getMax() / ((long) this.f927mb);
            this.MemoryCurrently = this.memoryBean.getHeapMemoryUsage().getUsed() / ((long) this.f927mb);
            this.MemoryInit = this.memoryBean.getHeapMemoryUsage().getInit() / ((long) this.f927mb);
            this.MemoryCommitted = this.memoryBean.getHeapMemoryUsage().getCommitted() / ((long) this.f927mb);
            this.Thread = this.threadBean.getThreadCount();
            this.ThreadTotalStarted = this.threadBean.getTotalStartedThreadCount();
            this.ThreadDaemon = this.threadBean.getDaemonThreadCount();
            this.TotalPlayer = this.gameonly ? 0 : 0;
            this.playerCount = this.gameonly ? StatusServer.this.playersMap.size() : 0;
            this.maxPlayer = this.gameonly ? Configuration.ACCOUNT.maxPlayer : 0;
            this.DockerGS = ConfigContainer.dockergs_v;
            this.Version = Utils.GetLast(GameConstants.VERSION);
        }
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/server/http/objects/StatusServer$User.class */
    public static class User {
        public String nickname;
        public int uid;
        public long lastping;
        public int time;
        public Position pos;
        public int scene;
        public int player_in_scene;

        public User(Player player) {
            Scene t = player.getScene();
            this.nickname = player.getNickname();
            this.uid = player.getUid();
            this.lastping = ((new Date().getTime() - player.getLastPingTime()) / 1000) % 60;
            this.time = player.getClientTime();
            this.pos = player.getPosition();
            this.scene = player.getSceneId();
            this.player_in_scene = t.getPlayerCount();
        }
    }
}
