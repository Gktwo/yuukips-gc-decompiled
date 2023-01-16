package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.home.HomeSceneItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeComfortInfoNotifyOuterClass;
import emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeComfortInfoNotify.class */
public class PacketHomeComfortInfoNotify extends BasePacket {
    public PacketHomeComfortInfoNotify(Player player) {
        super(PacketOpcodes.HomeComfortInfoNotify);
        if (player.getRealmList() != null) {
            List<HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo> comfortInfoList = new ArrayList<>();
            for (Integer num : player.getRealmList()) {
                int moduleId = num.intValue();
                HomeSceneItem homeScene = player.getHome().getHomeSceneItem(PacketOpcodes.SetCoopChapterViewedRsp + moduleId);
                if (homeScene != null) {
                    List<Integer> blockComfortList = homeScene.getBlockItems().values().stream().map((v0) -> {
                        return v0.calComfort();
                    }).toList();
                    HomeSceneItem homeRoomScene = player.getHome().getHomeSceneItem(homeScene.getRoomSceneId());
                    if (homeRoomScene != null) {
                        comfortInfoList.add(HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.newBuilder().setModuleId(moduleId).setRoomSceneComfortValue(homeRoomScene.calComfort()).addAllWorldSceneBlockComfortValueList(blockComfortList).build());
                    }
                }
            }
            setData(HomeComfortInfoNotifyOuterClass.HomeComfortInfoNotify.newBuilder().addAllModuleInfoList(comfortInfoList).build());
        }
    }
}
