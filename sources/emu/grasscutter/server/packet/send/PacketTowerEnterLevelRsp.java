package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerEnterLevelRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerEnterLevelRsp.class */
public class PacketTowerEnterLevelRsp extends BasePacket {
    public PacketTowerEnterLevelRsp(int floorId, int levelIndex) {
        super(PacketOpcodes.TowerEnterLevelRsp);
        setData(TowerEnterLevelRspOuterClass.TowerEnterLevelRsp.newBuilder().setFloorId(floorId).setLevelIndex(levelIndex).addTowerBuffIdList(4).addTowerBuffIdList(28).addTowerBuffIdList(18).build());
    }
}
