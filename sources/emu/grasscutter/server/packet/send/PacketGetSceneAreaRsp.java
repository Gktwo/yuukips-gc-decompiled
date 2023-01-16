package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CityInfoOuterClass;
import emu.grasscutter.net.proto.GetSceneAreaRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetSceneAreaRsp.class */
public class PacketGetSceneAreaRsp extends BasePacket {
    public PacketGetSceneAreaRsp(Player player, int sceneId) {
        super(PacketOpcodes.GetSceneAreaRsp);
        buildHeader(0);
        setData(GetSceneAreaRspOuterClass.GetSceneAreaRsp.newBuilder().setSceneId(sceneId).addAllAreaIdList(player.getUnlockedSceneAreas(sceneId)).addCityInfoList(CityInfoOuterClass.CityInfo.newBuilder().setCityId(1).setLevel(1).build()).addCityInfoList(CityInfoOuterClass.CityInfo.newBuilder().setCityId(2).setLevel(1).build()).addCityInfoList(CityInfoOuterClass.CityInfo.newBuilder().setCityId(3).setLevel(1).build()).build());
    }
}
