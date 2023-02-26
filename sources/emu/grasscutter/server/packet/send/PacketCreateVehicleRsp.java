package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityVehicle;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CreateVehicleRspOuterClass;
import emu.grasscutter.net.proto.VehicleInteractTypeOuterClass;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCreateVehicleRsp.class */
public class PacketCreateVehicleRsp extends BasePacket {
    public PacketCreateVehicleRsp(Player player, int vehicleId, int pointId, Position pos, Position rot) {
        super(818);
        CreateVehicleRspOuterClass.CreateVehicleRsp.Builder proto = CreateVehicleRspOuterClass.CreateVehicleRsp.newBuilder();
        player.getScene().getEntities().values().stream().filter(entity -> {
            return (entity instanceof EntityVehicle) && ((EntityVehicle) entity).getGadgetId() == vehicleId && ((EntityVehicle) entity).getOwner().equals(player);
        }).toList().stream().forEach(entity -> {
            ((EntityVehicle) entity).getVehicleMembers().stream().toList().stream().forEach(vehicleMember -> {
                player.getScene().broadcastPacket(new PacketVehicleInteractRsp((EntityVehicle) entity, vehicleMember, VehicleInteractTypeOuterClass.VehicleInteractType.VEHICLE_INTERACT_TYPE_OUT));
            });
            player.getScene().killEntity(entity, 0);
        });
        EntityVehicle vehicle = new EntityVehicle(player.getScene(), player, vehicleId, pointId, pos, rot);
        player.getScene().addEntity(vehicle);
        proto.setVehicleId(vehicleId);
        proto.setEntityId(vehicle.getId());
        setData(proto.build());
    }
}
