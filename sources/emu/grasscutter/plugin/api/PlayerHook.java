package emu.grasscutter.plugin.api;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EnterReason;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.server.packet.send.PacketAvatarFightPropUpdateNotify;
import emu.grasscutter.server.packet.send.PacketAvatarLifeStateChangeNotify;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/plugin/api/PlayerHook.class */
public final class PlayerHook {
    private final Player player;

    public PlayerHook(Player player) {
        this.player = player;
    }

    public void kick() {
        this.player.getSession().setKick("Kick");
    }

    public void changeScenes(int sceneId) {
        this.player.getWorld().transferPlayerToScene(this.player, sceneId, this.player.getPosition());
    }

    public void updateFightProperty(FightProperty property) {
        broadcastPacketToWorld(new PacketAvatarFightPropUpdateNotify(getCurrentAvatar(), property));
    }

    public void broadcastPacketToWorld(BasePacket packet) {
        this.player.getWorld().broadcastPacket(packet);
    }

    public void setHealth(float health) {
        getCurrentAvatarEntity().setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, health);
        updateFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
    }

    public void reviveAvatar(Avatar avatar) {
        broadcastPacketToWorld(new PacketAvatarLifeStateChangeNotify(avatar));
    }

    public void teleport(Position position) {
        this.player.getPosition().set(position);
        this.player.sendPacket(new PacketPlayerEnterSceneNotify(this.player, EnterTypeOuterClass.EnterType.ENTER_TYPE_JUMP, EnterReason.TransPoint, this.player.getSceneId(), position));
    }

    public float getMaxHealth() {
        return getCurrentAvatarEntity().getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
    }

    public EntityAvatar getCurrentAvatarEntity() {
        return this.player.getTeamManager().getCurrentAvatarEntity();
    }

    public Avatar getCurrentAvatar() {
        return getCurrentAvatarEntity().getAvatar();
    }
}
