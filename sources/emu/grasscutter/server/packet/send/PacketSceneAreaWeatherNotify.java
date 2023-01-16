package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.SceneAreaWeatherNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneAreaWeatherNotify.class */
public class PacketSceneAreaWeatherNotify extends BasePacket {
    public PacketSceneAreaWeatherNotify(Player player) {
        super(250);
        setData(SceneAreaWeatherNotifyOuterClass.SceneAreaWeatherNotify.newBuilder().setWeatherAreaId(player.getWeatherId()).setClimateType(player.getClimate().getValue()).build());
    }
}
