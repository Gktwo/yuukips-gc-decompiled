package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.SceneTeamAvatarOuterClass;
import emu.grasscutter.net.proto.SceneTeamUpdateNotifyOuterClass;
import java.util.Iterator;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneTeamUpdateNotify.class */
public class PacketSceneTeamUpdateNotify extends BasePacket {
    public PacketSceneTeamUpdateNotify(Player player) {
        super(PacketOpcodes.SceneTeamUpdateNotify);
        SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotify.Builder proto = SceneTeamUpdateNotifyOuterClass.SceneTeamUpdateNotify.newBuilder().setIsInMp(player.getWorld().isMultiplayer());
        for (Player p : player.getWorld().getPlayers()) {
            Iterator<EntityAvatar> it = p.getTeamManager().getActiveTeam().iterator();
            while (it.hasNext()) {
                EntityAvatar entityAvatar = it.next();
                SceneTeamAvatarOuterClass.SceneTeamAvatar.Builder avatarProto = SceneTeamAvatarOuterClass.SceneTeamAvatar.newBuilder().setPlayerUid(p.getUid()).setAvatarGuid(entityAvatar.getAvatar().getGuid()).setSceneId(p.getSceneId()).setEntityId(entityAvatar.getId()).setSceneEntityInfo(entityAvatar.toProto()).setWeaponGuid(entityAvatar.getAvatar().getWeapon().getGuid()).setWeaponEntityId(entityAvatar.getWeaponEntityId()).setIsPlayerCurAvatar(p.getTeamManager().getCurrentAvatarEntity() == entityAvatar).setIsOnScene(p.getTeamManager().getCurrentAvatarEntity() == entityAvatar).setAvatarAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setWeaponAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setAbilityControlBlock(entityAvatar.getAbilityControlBlock());
                if (player.getWorld().isMultiplayer()) {
                    avatarProto.setAvatarInfo(entityAvatar.getAvatar().toProto());
                    avatarProto.setSceneAvatarInfo(entityAvatar.getSceneAvatarInfo());
                }
                proto.addSceneTeamAvatarList(avatarProto);
            }
        }
        setData(proto);
    }
}
