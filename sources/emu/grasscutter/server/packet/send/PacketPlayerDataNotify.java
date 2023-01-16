package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerDataNotifyOuterClass;
import emu.grasscutter.net.proto.PropValueOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerDataNotify.class */
public class PacketPlayerDataNotify extends BasePacket {
    public PacketPlayerDataNotify(Player player) {
        super(147, 2);
        PlayerDataNotifyOuterClass.PlayerDataNotify.Builder p = PlayerDataNotifyOuterClass.PlayerDataNotify.newBuilder().setNickName(player.getNickname()).setServerTime(System.currentTimeMillis()).setIsFirstLoginToday(true).setRegionId(player.getRegionId());
        player.getProperties().forEach(key, value -> {
            p.putPropMap(key.intValue(), PropValueOuterClass.PropValue.newBuilder().setType(key.intValue()).setIval((long) value.intValue()).setVal((long) value.intValue()).build());
        });
        setData(p.build());
    }
}
