package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FurnitureMakeRspOuterClass;
import emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFurnitureMakeRsp.class */
public class PacketFurnitureMakeRsp extends BasePacket {
    public PacketFurnitureMakeRsp(GameHome home) {
        super(PacketOpcodes.FurnitureMakeRsp);
        FurnitureMakeRspOuterClass.FurnitureMakeRsp.Builder proto = FurnitureMakeRspOuterClass.FurnitureMakeRsp.newBuilder();
        proto.setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.newBuilder().addAllFurnitureMakeDataList(home.getFurnitureMakeSlotItemList().stream().map((v0) -> {
            return v0.toProto();
        }).toList()).build());
        setData(proto);
    }
}
