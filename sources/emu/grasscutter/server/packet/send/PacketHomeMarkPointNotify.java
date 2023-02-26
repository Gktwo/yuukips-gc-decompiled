package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.home.HomeSceneItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeMarkPointNotifyOuterClass;
import emu.grasscutter.net.proto.HomeMarkPointSceneDataOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeMarkPointNotify.class */
public class PacketHomeMarkPointNotify extends BasePacket {
    public PacketHomeMarkPointNotify(Player player) {
        super(PacketOpcodes.HomeMarkPointNotify);
        HomeMarkPointNotifyOuterClass.HomeMarkPointNotify.Builder proto = HomeMarkPointNotifyOuterClass.HomeMarkPointNotify.newBuilder();
        if (player.getRealmList() != null) {
            for (Integer moduleId : player.getRealmList()) {
                HomeSceneItem homeScene = player.getHome().getHomeSceneItem(2000 + moduleId.intValue());
                if (homeScene != null) {
                    HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.Builder markPointData = HomeMarkPointSceneDataOuterClass.HomeMarkPointSceneData.newBuilder().setModuleId(moduleId.intValue()).setSceneId(moduleId.intValue() + 2000).setTeapotSpiritPos(homeScene.getDjinnPos().toProto());
                    markPointData.addAllFurnitureList(homeScene.getBlockItems().values().stream().map((v0) -> {
                        return v0.getDeployFurnitureList();
                    }).flatMap((v0) -> {
                        return v0.stream();
                    }).filter(i -> {
                        return i.getFurnitureId() == 373501;
                    }).map(x -> {
                        return x.toMarkPointProto(3);
                    }).toList());
                    proto.addMarkPointDataList(markPointData);
                }
            }
            setData(proto);
        }
    }
}
