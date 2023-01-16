package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeAllUnlockedBgmIdListNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockedHomeBgmNotify.class */
public class PacketUnlockedHomeBgmNotify extends BasePacket {
    public PacketUnlockedHomeBgmNotify(Player player) {
        super(PacketOpcodes.HomeAllUnlockedBgmIdListNotify);
        if (player.getRealmList() != null) {
            setData(HomeAllUnlockedBgmIdListNotifyOuterClass.HomeAllUnlockedBgmIdListNotify.newBuilder().addAllAllUnlockedBgmIdList(player.getHome().getUnlockedHomeBgmList()).build());
        }
    }
}
