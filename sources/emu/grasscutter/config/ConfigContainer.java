package emu.grasscutter.config;

import com.google.gson.JsonObject;
import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.utils.FileUtils;
import emu.grasscutter.utils.JsonUtils;
import emu.grasscutter.utils.Utils;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kcp.highway.Kcp;
import kotlin.time.DurationKt;

/* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer.class */
public class ConfigContainer {
    public Structure folderStructure = new Structure();
    public Database databaseInfo = new Database();
    public Language language = new Language();
    public Account account = new Account();
    public Server server = new Server();
    public int version = version_config();
    public static String dockergs_v = Utils.GetLast(GameConstants.VERSION);

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Account.class */
    public static class Account {
        public boolean autoCreate = true;
        public String[] defaultPermissions = {"-server.announce", "-server.windy", "-server.restart", "-server.stop", "-server.permission", "-server.account", "-server.broadcast", "-server.coop", "-server.kick", "-server.reload", "-server.resetshop", "-server.sendmail", "-player.tpall", "-player.*.others", "-server.*.others", "*"};
        public int maxPlayer = -1;
        public boolean EXPERIMENTAL_RealPassword = false;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$ConsoleAccount.class */
    public static class ConsoleAccount {
        public int avatarId = 10000002;
        public int nameCardId = 210081;
        public int adventureRank = 60;
        public int worldLevel = 8;
        public String nickName = "Ayaka";
        public String signature = "Hello, have fun playing :)";
        public String token = "melon";
        public boolean globalChatEnabled = true;
        public String globalChatFormat = "<color=#99CC99>{nickName}</color>: {message}";
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Database.class */
    public static class Database {
        public DataStore server = new DataStore();
        public DataStore game = new DataStore();

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Database$DataStore.class */
        public static class DataStore {
            public String connectionUri = "mongodb://localhost:27017";
            public String collection = "grasscutter";
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Dispatch.class */
    public static class Dispatch {
        public Region[] regions = new Region[0];
        public String defaultName = "YuukiPS";
        public Grasscutter.ServerDebugMode logRequests = Grasscutter.ServerDebugMode.NONE;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Encryption.class */
    public static class Encryption {
        public boolean useEncryption = true;
        public boolean useInRouting = true;
        public String keystore = "./keystore.p12";
        public String keystorePassword = "123456";
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Files.class */
    public static class Files {
        public String indexFile = "./index.html";
        public String errorFile = "./404.html";
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Game.class */
    public static class Game {
        public String bindAddress = "0.0.0.0";
        public int bindPort = 22102;
        public String accessAddress = "127.0.0.1";
        public int accessPort = 0;
        public int loadEntitiesForPlayerRange = 100;
        public boolean enableConsole = true;
        public int kcpInterval = 20;
        public GameOptions gameOptions = new GameOptions();
        public JoinOptions joinOptions = new JoinOptions();
        public ConsoleAccount serverAccount = new ConsoleAccount();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$GameOptions.class */
    public static class GameOptions {
        public InventoryLimits inventoryLimits = new InventoryLimits();
        public AvatarLimits avatarLimits = new AvatarLimits();
        public int CMD_Spawn = 500;
        public int sceneEntityLimit = 5000;
        public boolean staminaUsage = true;
        public boolean energyUsage = true;
        public boolean fishhookTeleport = true;
        public ResinOptions resinOptions = new ResinOptions();
        public Rates rates = new Rates();
        public boolean questing = true;
        public int CMD_Give_WP = 10;
        public int CMD_Give_ART = 10;
        public int CMD_Give = 10000000;
        public int CMD_DayLogin = 8;
        public boolean CMD_ListOnline = false;
        public boolean DropMo = true;
        public boolean DungeonMT = false;
        public boolean AbyssMT = false;
        public boolean RatelimitCMD = true;

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$GameOptions$AvatarLimits.class */
        public static class AvatarLimits {
            public int singlePlayerTeam = 5;
            public int multiplayerTeam = 5;
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$GameOptions$InventoryLimits.class */
        public static class InventoryLimits {
            public int weapons = 2500;
            public int relics = 2500;
            public int materials = 2500;
            public int furniture = 2500;
            public int all = 10000;
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$GameOptions$Rates.class */
        public static class Rates {
            public float adventureExp = 1.0f;
            public float mora = 1.0f;
            public float leyLines = 1.0f;
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$GameOptions$ResinOptions.class */
        public static class ResinOptions {
            public boolean resinUsage = true;
            public int cap = 160;
            public int rechargeTime = PacketOpcodes.QuestGlobalVarNotify;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$HTTP.class */
    public static class HTTP {
        public String bindAddress = "0.0.0.0";
        public int bindPort = PacketOpcodes.AddQuestContentProgressReq;
        public String accessAddress = "127.0.0.1";
        public int accessPort = 0;
        public String APICloud = "https://ps.yuuki.me/";
        public Encryption encryption = new Encryption();
        public Policies policies = new Policies();
        public Files files = new Files();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$JoinOptions.class */
    public static class JoinOptions {
        public int[] welcomeEmotes = {RetcodeOuterClass.Retcode.RET_LEGENDARY_KEY_NOT_ENOUGH_VALUE, RetcodeOuterClass.Retcode.RET_LEGENDARY_KEY_EXCEED_LIMIT_VALUE, RetcodeOuterClass.Retcode.RET_DAILY_TASK_NOT_ENOUGH_TO_REDEEM_VALUE, RetcodeOuterClass.Retcode.RET_PERSONAL_LINE_OPEN_STATE_OFF_VALUE, 14005, 14006, 14007, 14008};
        public String welcomeMessage = "Welcome to YuukiPS";
        public Mail welcomeMail = new Mail();

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$JoinOptions$Mail.class */
        public static class Mail {
            public String title = "Welcome to YuukiPS";
            public String content = "Hi";
            public String sender = "Yuuki";
            public Mail.MailItem[] items = {new Mail.MailItem(PacketOpcodes.LevelupCityReq, 1000), new Mail.MailItem(PacketOpcodes.WorldPlayerLocationNotify, 1000), new Mail.MailItem(202, 6000000), new Mail.MailItem(201, Kcp.IKCP_RTO_MAX), new Mail.MailItem(203, 10000), new Mail.MailItem(204, DurationKt.NANOS_IN_MILLIS), new Mail.MailItem(303, 1000)};
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Language.class */
    public static class Language {
        public Locale language = Locale.getDefault();
        public Locale fallback = Locale.US;
        public String document = "EN";
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Policies.class */
    public static class Policies {
        public CORS cors = new CORS();

        /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Policies$CORS.class */
        public static class CORS {
            public boolean enabled = true;
            public String[] allowedOrigins = {"*"};
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$ResVersionConfig.class */
    public static class ResVersionConfig {
        public int version = 0;
        public String md5 = "";
        public String releaseTotalSize = "";
        public String versionSuffix = "";
        public String branch = "";
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Resource.class */
    public static class Resource {
        public String version = "";
        public String resourceUrl = "";
        public String dataUrl = "";
        public String resourceUrlBak = "";
        public int clientDataVersion = 0;
        public int clientSilenceDataVersion = 0;
        public String clientDataMd5 = "";
        public String clientSilenceDataMd5 = "";
        public ResVersionConfig resVersionConfig = new ResVersionConfig();
        public String clientVersionSuffix = "";
        public String clientSilenceVersionSuffix = "";
        public String nextResourceUrl = "";
        public ResVersionConfig nextResVersionConfig = new ResVersionConfig();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Server.class */
    public static class Server {
        public boolean RatelimitLOGIN = true;
        public Grasscutter.ServerDebugMode debugLevel = Grasscutter.ServerDebugMode.NONE;
        public Set<Integer> DebugBlacklist = new HashSet<Integer>() { // from class: emu.grasscutter.config.ConfigContainer.Server.1
            {
                add(100);
                add(43);
                add(37);
                add(Integer.valueOf((int) PacketOpcodes.QueryPathReq));
            }
        };
        public Set<Integer> DebugWatchPayload = new HashSet<Integer>() { // from class: emu.grasscutter.config.ConfigContainer.Server.2
        };
        public Grasscutter.ServerRunMode runMode = Grasscutter.ServerRunMode.HYBRID;
        public boolean logCommands = true;
        public HTTP http = new HTTP();
        public Game game = new Game();
        public Dispatch dispatch = new Dispatch();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Structure.class */
    public static class Structure {
        public String resources = "./resources/";
        public String data = "./data/";
        public String packets = "./packets/";
        public String keys = "./keys/";
        public String scripts = "resources:Scripts/";
        public String plugins = "./plugins/";
        public String VERSION = "./ver";
    }

    private static int version_config() {
        return 16;
    }

    public static void updateConfig() {
        try {
            File vv = new File(Grasscutter.config.folderStructure.VERSION);
            if (vv.exists()) {
                dockergs_v = new String(FileUtils.read(vv));
            }
        } catch (Exception e) {
        }
        try {
            if (!((JsonObject) JsonUtils.loadToClass(Grasscutter.configFile.toPath(), JsonObject.class)).has("version")) {
                Grasscutter.getLogger().info("Updating legacy ..");
                Grasscutter.saveConfig(null);
            }
        } catch (Exception e2) {
        }
        if (Grasscutter.config.version != version_config()) {
            ConfigContainer updated = new ConfigContainer();
            Arrays.stream(ConfigContainer.class.getDeclaredFields()).forEach(field -> {
                try {
                    field.set(updated, field.get(Grasscutter.config));
                } catch (Exception exception) {
                    Grasscutter.getLogger().error("Failed to update a configuration field.", (Throwable) exception);
                }
            });
            updated.version = version_config();
            try {
                Grasscutter.saveConfig(updated);
                Grasscutter.loadConfig();
            } catch (Exception exception) {
                Grasscutter.getLogger().warn("Failed to inject the updated ", (Throwable) exception);
            }
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/config/ConfigContainer$Region.class */
    public static class Region {
        public String Name;
        public String Title;

        /* renamed from: Ip */
        public String f497Ip;
        public int Port;
        public String dispatchUrl;
        public Resource Resource;

        public Region() {
            this.Name = "os_usa";
            this.Title = "YuukiPS";
            this.f497Ip = "127.0.0.1";
            this.Port = 22102;
            this.dispatchUrl = "";
            this.Resource = null;
        }

        public Region(String name, String title, String address, int port, String dispatchUrl, Resource resource) {
            this.Name = "os_usa";
            this.Title = "YuukiPS";
            this.f497Ip = "127.0.0.1";
            this.Port = 22102;
            this.dispatchUrl = "";
            this.Resource = null;
            this.Name = name;
            this.Title = title;
            this.f497Ip = address;
            this.Port = port;
            this.Resource = resource;
            this.dispatchUrl = dispatchUrl;
        }
    }
}
