package emu.grasscutter.game;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Collation;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.PreLoad;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass;
import emu.grasscutter.utils.Crypto;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import org.bson.Document;
import org.eclipse.jetty.util.security.Constraint;

@Entity(value = "accounts", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/Account.class */
public class Account {
    @AbstractC1283Id

    /* renamed from: id */
    private String f557id;
    @Indexed(options = @IndexOptions(unique = true))
    @Collation(locale = "simple", caseLevel = true)
    private String username;
    private String password;
    private int reservedPlayerId;
    private String email;
    private String token;
    private String sessionKey;
    private List<String> permissions = new ArrayList();
    private Locale locale = Configuration.LANGUAGE;
    private String banReason;
    private int banEndTime;
    private int banStartTime;
    private boolean isBanned;
    private String kickReason;
    private int kickCodeReason;
    private boolean isKick;
    private String tokenAPI;

    public String getId() {
        return this.f557id;
    }

    public void setId(String id) {
        this.f557id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenAPI() {
        return this.tokenAPI;
    }

    public void setTokenAPI(String token) {
        this.tokenAPI = token;
    }

    public int getReservedPlayerUid() {
        return this.reservedPlayerId;
    }

    public void setReservedPlayerUid(int playerId) {
        this.reservedPlayerId = playerId;
    }

    public String getEmail() {
        if (this.email == null || this.email.isEmpty()) {
            return "";
        }
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public String generateSessionKey() {
        this.sessionKey = Utils.bytesToHex(Crypto.createSessionKey(32));
        save();
        return this.sessionKey;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setKick(boolean iskick, String reason, int code) {
        this.isKick = iskick;
        this.kickReason = reason;
        this.kickCodeReason = code;
        save();
    }

    public boolean isKick() {
        return this.isKick;
    }

    public void setKick(boolean set) {
        this.isKick = set;
    }

    public String getKickReason() {
        return this.kickReason;
    }

    public int getKickCodeReason() {
        return this.kickCodeReason;
    }

    public String getBanReason() {
        return this.banReason;
    }

    public void setBanReason(String banReason) {
        this.banReason = banReason;
    }

    public int getBanEndTime() {
        return this.banEndTime;
    }

    public void setBanEndTime(int banEndTime) {
        this.banEndTime = banEndTime;
    }

    public int getBanStartTime() {
        return this.banStartTime;
    }

    public void setBanStartTime(int banStartTime) {
        this.banStartTime = banStartTime;
    }

    public boolean isBanned() {
        if (this.banEndTime > 0 && ((long) this.banEndTime) < System.currentTimeMillis() / 1000) {
            this.isBanned = false;
            this.banEndTime = 0;
            this.banStartTime = 0;
            this.banReason = null;
            save();
        }
        return this.isBanned;
    }

    public void setBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public boolean addPermission(String permission) {
        if (this.permissions.contains(permission)) {
            return false;
        }
        this.permissions.add(permission);
        return true;
    }

    public static boolean permissionMatchesWildcard(String wildcard, String[] permissionParts) {
        String[] wildcardParts = wildcard.split("\\.");
        if (permissionParts.length < wildcardParts.length) {
            return false;
        }
        for (int i = 0; i < wildcardParts.length; i++) {
            String str = wildcardParts[i];
            char c = 65535;
            switch (str.hashCode()) {
                case 42:
                    if (str.equals("*")) {
                        c = 1;
                        break;
                    }
                    break;
                case GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.TAG_FIELD_NUMBER /* 1344 */:
                    if (str.equals(Constraint.ANY_AUTH)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return true;
                case 1:
                    if (i < permissionParts.length - 1) {
                        break;
                    } else {
                        return true;
                    }
                default:
                    if (wildcardParts[i].equals(permissionParts[i])) {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return wildcardParts.length == permissionParts.length;
    }

    public boolean hasPermission(String permission) {
        if (permission.isEmpty()) {
            return true;
        }
        if (this.permissions.contains("*") && this.permissions.size() == 1) {
            return true;
        }
        List<String> permissions = Stream.of((Object[]) new List[]{this.permissions, Arrays.asList(Configuration.ACCOUNT.defaultPermissions)}).flatMap((v0) -> {
            return v0.stream();
        }).distinct().toList();
        if (permissions.contains(permission)) {
            return true;
        }
        String[] permissionParts = permission.split("\\.");
        for (String p : permissions) {
            if (p.startsWith("-") && permissionMatchesWildcard(p.substring(1), permissionParts)) {
                return false;
            }
            if (permissionMatchesWildcard(p, permissionParts)) {
                return true;
            }
        }
        return permissions.contains("*");
    }

    public boolean removePermission(String permission) {
        return this.permissions.remove(permission);
    }

    public void clearPermission() {
        this.permissions.clear();
    }

    public String generateLoginToken() {
        this.token = Utils.bytesToHex(Crypto.createSessionKey(32));
        save();
        return this.token;
    }

    public void save() {
        DatabaseHelper.saveAccount(this);
    }

    @PreLoad
    public void onLoad(Document document) {
        if (!document.containsKey("permissions")) {
            addPermission("*");
        }
        if (!document.containsKey("locale")) {
            this.locale = Configuration.LANGUAGE;
        }
    }
}
