package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass;
import emu.grasscutter.net.proto.WidgetSlotOpOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetWidgetSlotRsp;
import emu.grasscutter.server.packet.send.PacketWidgetSlotChangeNotify;

@Opcodes(PacketOpcodes.SetWidgetSlotReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetWidgetSlotReq.class */
public class HandlerSetWidgetSlotReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetWidgetSlotReqOuterClass.SetWidgetSlotReq req = SetWidgetSlotReqOuterClass.SetWidgetSlotReq.parseFrom(payload);
        session.getPlayer().setWidgetId(req.getMaterialId());
        session.send(new PacketWidgetSlotChangeNotify(WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_DETACH));
        if (req.getOp() == WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH) {
            session.send(new PacketWidgetSlotChangeNotify(req.getMaterialId()));
        }
        session.send(new PacketSetWidgetSlotRsp(req.getMaterialId()));
    }
}
