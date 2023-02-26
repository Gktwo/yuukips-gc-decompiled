package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityVehicle;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.VehicleInteractRspOuterClass;
import emu.grasscutter.net.proto.VehicleInteractTypeOuterClass;
import emu.grasscutter.net.proto.VehicleMemberOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketVehicleInteractRsp.class */
public class PacketVehicleInteractRsp extends BasePacket {
    public PacketVehicleInteractRsp(Player player, int entityId, VehicleInteractTypeOuterClass.VehicleInteractType interactType) {
        super(825);
        VehicleInteractRspOuterClass.VehicleInteractRsp.Builder proto = VehicleInteractRspOuterClass.VehicleInteractRsp.newBuilder();
        GameEntity vehicle = player.getScene().getEntityById(entityId);
        if (vehicle instanceof EntityVehicle) {
            proto.setEntityId(vehicle.getId());
            VehicleMemberOuterClass.VehicleMember vehicleMember = VehicleMemberOuterClass.VehicleMember.newBuilder().setUid(player.getUid()).setAvatarGuid(player.getTeamManager().getCurrentCharacterGuid()).build();
            proto.setInteractType(interactType);
            proto.setMember(vehicleMember);
            switch (interactType) {
                case VEHICLE_INTERACT_TYPE_IN:
                    ((EntityVehicle) vehicle).getVehicleMembers().add(vehicleMember);
                    player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_ENTER_VEHICLE, ((EntityVehicle) vehicle).getGadgetId());
                    break;
                case VEHICLE_INTERACT_TYPE_OUT:
                    ((EntityVehicle) vehicle).getVehicleMembers().remove(vehicleMember);
                    break;
            }
        }
        setData(proto.build());
    }

    public PacketVehicleInteractRsp(EntityVehicle vehicle, VehicleMemberOuterClass.VehicleMember vehicleMember, VehicleInteractTypeOuterClass.VehicleInteractType interactType) {
        super(825);
        VehicleInteractRspOuterClass.VehicleInteractRsp.Builder proto = VehicleInteractRspOuterClass.VehicleInteractRsp.newBuilder();
        if (vehicle != null) {
            proto.setEntityId(vehicle.getId());
            proto.setInteractType(interactType);
            proto.setMember(vehicleMember);
            switch (interactType) {
                case VEHICLE_INTERACT_TYPE_IN:
                    vehicle.getVehicleMembers().add(vehicleMember);
                    break;
                case VEHICLE_INTERACT_TYPE_OUT:
                    vehicle.getVehicleMembers().remove(vehicleMember);
                    break;
            }
        }
        setData(proto.build());
    }
}
