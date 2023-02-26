package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.home.HomeSceneItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeBasicInfoNotifyOuterClass;
import emu.grasscutter.net.proto.HomeBasicInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeBasicInfoNotify.class */
public class PacketHomeBasicInfoNotify extends BasePacket {
    public PacketHomeBasicInfoNotify(Player player, boolean editMode) {
        super(PacketOpcodes.HomeBasicInfoNotify);
        if (player.getCurrentRealmId() > 0) {
            HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotify.Builder proto = HomeBasicInfoNotifyOuterClass.HomeBasicInfoNotify.newBuilder();
            HomeSceneItem homeScene = player.getHome().getHomeSceneItem(2000 + player.getCurrentRealmId());
            if (homeScene != null) {
                proto.setBasicInfo(HomeBasicInfoOuterClass.HomeBasicInfo.newBuilder().setCurModuleId(player.getCurrentRealmId()).setCurRoomSceneId(homeScene.getRoomSceneId()).setIsInEditMode(editMode).setHomeOwnerUid(player.getUid()).setExp((long) player.getHome().getExp()).setLevel(player.getHome().getLevel()).setOwnerNickName(player.getNickname()).build());
                setData(proto);
            }
        }
    }
}
