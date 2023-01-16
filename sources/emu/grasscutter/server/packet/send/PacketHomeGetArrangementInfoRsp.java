package emu.grasscutter.server.packet.send;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.game.home.HomeSceneItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeGetArrangementInfoRspOuterClass;
import emu.grasscutter.net.proto.HomeSceneArrangementInfoOuterClass;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeGetArrangementInfoRsp.class */
public class PacketHomeGetArrangementInfoRsp extends BasePacket {
    public PacketHomeGetArrangementInfoRsp(Player player, List<Integer> sceneIdList) {
        super(PacketOpcodes.HomeGetArrangementInfoRsp);
        if (sceneIdList != null) {
            GameHome home = player.getHome();
            List<HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo> homeScenes = new ArrayList<>();
            for (Integer scene : sceneIdList) {
                HomeSceneItem homeScene = home.getHomeSceneItem(scene.intValue());
                if (homeScene == null) {
                    Grasscutter.getLogger().error("Error getHomeSceneItem {}", scene);
                } else {
                    HomeSceneArrangementInfoOuterClass.HomeSceneArrangementInfo toadd = homeScene.toProto();
                    if (toadd == null) {
                        Grasscutter.getLogger().error("Error toProto {}", scene);
                    } else {
                        homeScenes.add(toadd);
                    }
                }
            }
            home.save();
            HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRsp.Builder proto = HomeGetArrangementInfoRspOuterClass.HomeGetArrangementInfoRsp.newBuilder();
            proto.addAllSceneArrangementInfoList(homeScenes);
            setData(proto);
        }
    }
}
