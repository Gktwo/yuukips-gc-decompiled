package emu.grasscutter.game.managers;

import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.server.packet.send.PacketResinChangeNotify;
import emu.grasscutter.utils.Utils;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/ResinManager.class */
public class ResinManager extends BasePlayerManager {
    public ResinManager(Player player) {
        super(player);
    }

    public synchronized boolean useResin(int amount) {
        if (!Configuration.GAME_OPTIONS.resinOptions.resinUsage) {
            return true;
        }
        int currentResin = this.player.getProperty(PlayerProperty.PROP_PLAYER_RESIN);
        if (currentResin < amount) {
            return false;
        }
        int newResin = currentResin - amount;
        this.player.setProperty(PlayerProperty.PROP_PLAYER_RESIN, newResin);
        if (this.player.getNextResinRefresh() == 0 && newResin < Configuration.GAME_OPTIONS.resinOptions.cap) {
            this.player.setNextResinRefresh(Utils.getCurrentSeconds() + Configuration.GAME_OPTIONS.resinOptions.rechargeTime);
        }
        this.player.sendPacket(new PacketResinChangeNotify(this.player));
        this.player.getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_COST_MATERIAL, 106, amount);
        return true;
    }

    public synchronized boolean useCondensedResin(int amount) {
        if (!Configuration.GAME_OPTIONS.resinOptions.resinUsage) {
            return true;
        }
        return this.player.getInventory().payItem(220007, amount);
    }

    public synchronized void addResin(int amount) {
        if (Configuration.GAME_OPTIONS.resinOptions.resinUsage) {
            int newResin = this.player.getProperty(PlayerProperty.PROP_PLAYER_RESIN) + amount;
            this.player.setProperty(PlayerProperty.PROP_PLAYER_RESIN, newResin);
            if (newResin >= Configuration.GAME_OPTIONS.resinOptions.cap) {
                this.player.setNextResinRefresh(0);
            }
            this.player.sendPacket(new PacketResinChangeNotify(this.player));
        }
    }

    public synchronized void rechargeResin() {
        if (Configuration.GAME_OPTIONS.resinOptions.resinUsage) {
            int currentResin = this.player.getProperty(PlayerProperty.PROP_PLAYER_RESIN);
            int currentTime = Utils.getCurrentSeconds();
            if (this.player.getNextResinRefresh() > 0 && currentTime >= this.player.getNextResinRefresh()) {
                int newResin = Math.min(Configuration.GAME_OPTIONS.resinOptions.cap, currentResin + 1 + ((currentTime - this.player.getNextResinRefresh()) / Configuration.GAME_OPTIONS.resinOptions.rechargeTime));
                int resinChange = newResin - currentResin;
                this.player.setProperty(PlayerProperty.PROP_PLAYER_RESIN, newResin);
                if (newResin >= Configuration.GAME_OPTIONS.resinOptions.cap) {
                    this.player.setNextResinRefresh(0);
                } else {
                    this.player.setNextResinRefresh(this.player.getNextResinRefresh() + (resinChange * Configuration.GAME_OPTIONS.resinOptions.rechargeTime));
                }
                this.player.sendPacket(new PacketResinChangeNotify(this.player));
            }
        }
    }

    public synchronized void onPlayerLogin() {
        if (!Configuration.GAME_OPTIONS.resinOptions.resinUsage) {
            this.player.setProperty(PlayerProperty.PROP_PLAYER_RESIN, Configuration.GAME_OPTIONS.resinOptions.cap);
            this.player.setNextResinRefresh(0);
        }
        int currentResin = this.player.getProperty(PlayerProperty.PROP_PLAYER_RESIN);
        int currentTime = Utils.getCurrentSeconds();
        if (currentResin < Configuration.GAME_OPTIONS.resinOptions.cap && this.player.getNextResinRefresh() == 0) {
            this.player.setNextResinRefresh(currentTime + Configuration.GAME_OPTIONS.resinOptions.rechargeTime);
        }
        this.player.sendPacket(new PacketResinChangeNotify(this.player));
    }
}
