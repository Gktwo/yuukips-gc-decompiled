package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.VehicleStaminaNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketVehicleStaminaNotify.class */
public class PacketVehicleStaminaNotify extends BasePacket {
    public PacketVehicleStaminaNotify(int vehicleId, float newStamina) {
        super(PacketOpcodes.VehicleStaminaNotify);
        VehicleStaminaNotifyOuterClass.VehicleStaminaNotify.Builder proto = VehicleStaminaNotifyOuterClass.VehicleStaminaNotify.newBuilder();
        proto.setEntityId(vehicleId);
        proto.setCurStamina(newStamina);
        setData(proto.build());
    }
}
