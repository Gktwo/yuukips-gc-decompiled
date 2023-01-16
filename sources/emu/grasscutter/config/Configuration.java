package emu.grasscutter.config;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.ConfigContainer;
import java.nio.file.Path;
import java.util.Locale;

/* loaded from: grasscutter.jar:emu/grasscutter/config/Configuration.class */
public final class Configuration extends ConfigContainer {

    /* renamed from: c */
    public static final ConfigContainer f498c = Grasscutter.config;
    public static final Locale LANGUAGE = Grasscutter.config.language.language;
    public static final Locale FALLBACK_LANGUAGE = Grasscutter.config.language.fallback;
    public static final String DOCUMENT_LANGUAGE = Grasscutter.config.language.document;
    private static final String PLUGINS_FOLDER = Grasscutter.config.folderStructure.plugins;
    public static final ConfigContainer.Server SERVER = Grasscutter.config.server;
    public static final ConfigContainer.Database DATABASE = Grasscutter.config.databaseInfo;
    public static final ConfigContainer.Account ACCOUNT = Grasscutter.config.account;
    public static final ConfigContainer.HTTP HTTP_INFO = Grasscutter.config.server.http;
    public static final ConfigContainer.Game GAME_INFO = Grasscutter.config.server.game;
    public static final ConfigContainer.Dispatch DISPATCH_INFO = Grasscutter.config.server.dispatch;
    public static final ConfigContainer.Encryption HTTP_ENCRYPTION = Grasscutter.config.server.http.encryption;
    public static final ConfigContainer.Policies HTTP_POLICIES = Grasscutter.config.server.http.policies;
    public static final ConfigContainer.Files HTTP_STATIC_FILES = Grasscutter.config.server.http.files;
    public static final ConfigContainer.GameOptions GAME_OPTIONS = Grasscutter.config.server.game.gameOptions;
    public static final ConfigContainer.GameOptions.InventoryLimits INVENTORY_LIMITS = Grasscutter.config.server.game.gameOptions.inventoryLimits;

    public static String PLUGIN(String path) {
        return Path.of(PLUGINS_FOLDER, new String[]{path}).toString();
    }

    /* renamed from: lr */
    public static <T> T m1215lr(T left, T right) {
        return left == null ? right : left;
    }

    /* renamed from: lr */
    public static String m1214lr(String left, String right) {
        return left.isEmpty() ? right : left;
    }

    /* renamed from: lr */
    public static int m1216lr(int left, int right) {
        return left == 0 ? right : left;
    }
}
