package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityControlBlockOuterClass;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AvatarEnterSceneInfoOuterClass;
import emu.grasscutter.net.proto.MPLevelEntityInfoOuterClass;
import emu.grasscutter.net.proto.PlayerEnterSceneInfoNotifyOuterClass;
import emu.grasscutter.net.proto.TeamEnterSceneInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerEnterSceneInfoNotify.class */
public class PacketPlayerEnterSceneInfoNotify extends BasePacket {
    public PacketPlayerEnterSceneInfoNotify(Player player) {
        super(PacketOpcodes.PlayerEnterSceneInfoNotify);
        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo empty = AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder().build();
        PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotify.Builder proto = PlayerEnterSceneInfoNotifyOuterClass.PlayerEnterSceneInfoNotify.newBuilder().setCurAvatarEntityId(player.getTeamManager().getCurrentAvatarEntity().getId()).setEnterSceneToken(player.getEnterSceneToken());
        proto.setTeamEnterInfo(TeamEnterSceneInfoOuterClass.TeamEnterSceneInfo.newBuilder().setTeamEntityId(player.getTeamManager().getEntityId()).setTeamAbilityInfo(empty).setAbilityControlBlock(AbilityControlBlockOuterClass.AbilityControlBlock.newBuilder().build()));
        proto.setMpLevelEntityInfo(MPLevelEntityInfoOuterClass.MPLevelEntityInfo.newBuilder().setEntityId(player.getWorld().getLevelEntityId()).setAuthorityPeerId(player.getWorld().getHostPeerId()).setAbilityInfo(empty));
        for (EntityAvatar avatarEntity : player.getTeamManager().getActiveTeam()) {
            GameItem weapon = avatarEntity.getAvatar().getWeapon();
            proto.addAvatarEnterInfo(AvatarEnterSceneInfoOuterClass.AvatarEnterSceneInfo.newBuilder().setAvatarGuid(avatarEntity.getAvatar().getGuid()).setAvatarEntityId(avatarEntity.getId()).setWeaponGuid(weapon != null ? weapon.getGuid() : 0).setWeaponEntityId(avatarEntity.getWeaponEntityId()).setAvatarAbilityInfo(empty).setWeaponAbilityInfo(empty).build());
        }
        setData(proto.build());
    }
}
