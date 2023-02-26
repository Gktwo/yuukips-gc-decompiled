package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.entity.EntityVehicle;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.LocationInfoOuterClass;
import emu.grasscutter.net.proto.WidgetDoBagReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketWidgetCoolDownNotify;
import emu.grasscutter.server.packet.send.PacketWidgetDoBagRsp;
import emu.grasscutter.server.packet.send.PacketWidgetGadgetDataNotify;
import emu.grasscutter.utils.Position;

@Opcodes(PacketOpcodes.WidgetDoBagReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerWidgetDoBagReq.class */
public class HandlerWidgetDoBagReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        WidgetDoBagReqOuterClass.WidgetDoBagReq req = WidgetDoBagReqOuterClass.WidgetDoBagReq.parseFrom(payload);
        LocationInfoOuterClass.LocationInfo locationInfo = req.getWidgetCreatorInfo().getLocationInfo();
        Position pos = new Position(locationInfo.getPos());
        Position rot = new Position(locationInfo.getRot());
        switch (req.getMaterialId()) {
            case 220026:
                spawnVehicle(session, 70500025, pos, rot);
                session.send(new PacketWidgetCoolDownNotify(15, System.currentTimeMillis() + 5000, true));
                session.send(new PacketWidgetCoolDownNotify(15, System.currentTimeMillis() + 5000, true));
                break;
            case 220047:
                spawnVehicle(session, 70800058, pos, rot);
                break;
        }
        session.send(new PacketWidgetDoBagRsp());
    }

    private void spawnVehicle(GameSession session, int gadgetId, Position pos, Position rot) throws Exception {
        Player player = session.getPlayer();
        Scene scene = player.getScene();
        EntityVehicle entity = new EntityVehicle(scene, player, gadgetId, 0, pos, rot);
        scene.addEntity(entity);
        session.send(new PacketWidgetGadgetDataNotify(gadgetId, entity.getId()));
    }
}
