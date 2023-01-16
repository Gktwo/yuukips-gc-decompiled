package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFurnitureCurModuleArrangeCountNotify.class */
public class PacketFurnitureCurModuleArrangeCountNotify extends BasePacket {
    public PacketFurnitureCurModuleArrangeCountNotify() {
        super(PacketOpcodes.FurnitureCurModuleArrangeCountNotify);
        setData(FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotify.newBuilder());
    }
}
