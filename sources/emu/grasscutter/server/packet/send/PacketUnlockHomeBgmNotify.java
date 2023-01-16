package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeNewUnlockedBgmIdListNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockHomeBgmNotify.class */
public class PacketUnlockHomeBgmNotify extends BasePacket {
    public PacketUnlockHomeBgmNotify(int homeBgmId) {
        super(PacketOpcodes.HomeNewUnlockedBgmIdListNotify);
        setData(HomeNewUnlockedBgmIdListNotifyOuterClass.HomeNewUnlockedBgmIdListNotify.newBuilder().addNewUnlockedBgmIdList(homeBgmId).build());
    }
}
