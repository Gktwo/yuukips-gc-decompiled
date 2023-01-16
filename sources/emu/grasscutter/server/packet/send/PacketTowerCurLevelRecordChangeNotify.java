package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass;
import emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerCurLevelRecordChangeNotify.class */
public class PacketTowerCurLevelRecordChangeNotify extends BasePacket {
    public PacketTowerCurLevelRecordChangeNotify(int curFloorId, int curLevelIndex) {
        super(PacketOpcodes.TowerCurLevelRecordChangeNotify);
        setData(TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotify.newBuilder().setCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord.newBuilder().setCurFloorId(curFloorId).setCurLevelIndex(curLevelIndex).build()).build());
    }
}
