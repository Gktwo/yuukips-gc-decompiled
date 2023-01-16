package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetWidgetSlotReqOuterClass;
import emu.grasscutter.net.proto.WidgetSlotOpOuterClass;
import emu.grasscutter.net.proto.WidgetSlotTagOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetWidgetSlotRsp;
import emu.grasscutter.server.packet.send.PacketWidgetSlotChangeNotify;

@Opcodes(PacketOpcodes.SetWidgetSlotReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetWidgetSlotReq.class */
public class HandlerSetWidgetSlotReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetWidgetSlotReqOuterClass.SetWidgetSlotReq req = SetWidgetSlotReqOuterClass.SetWidgetSlotReq.parseFrom(payload);
        WidgetSlotTagOuterClass.WidgetSlotTag attktag = WidgetSlotTagOuterClass.WidgetSlotTag.WIDGET_SLOT_TAG_QUICK_USE;
        if (req.getMaterialId() == 220074) {
            attktag = WidgetSlotTagOuterClass.WidgetSlotTag.WIDGET_SLOT_TAG_ATTACH_AVATAR;
        }
        Grasscutter.getLogger().info("SetWidgetSlotReq: {},{},{},{}", Integer.valueOf(req.getMaterialId()), req.getOp().name(), Integer.valueOf(req.getTagListList().size()), attktag);
        session.getPlayer().setWidgetId(req.getMaterialId());
        session.send(new PacketWidgetSlotChangeNotify(WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_DETACH));
        if (req.getOp() == WidgetSlotOpOuterClass.WidgetSlotOp.WIDGET_SLOT_OP_ATTACH) {
            session.send(new PacketWidgetSlotChangeNotify(req.getMaterialId(), attktag));
        }
        session.send(new PacketSetWidgetSlotRsp(req.getMaterialId()));
    }
}
