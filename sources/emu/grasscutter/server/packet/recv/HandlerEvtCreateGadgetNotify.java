package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.entity.EntityClientGadget;
import emu.grasscutter.game.entity.EntitySolarIsotomaClientGadget;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(400)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtCreateGadgetNotify.class */
public class HandlerEvtCreateGadgetNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        EntityClientGadget gadget;
        EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotify notify = EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotify.parseFrom(payload);
        if (session.getPlayer().getScene().getEntityById(notify.getEntityId()) == null) {
            switch (notify.getConfigId()) {
                case EntitySolarIsotomaClientGadget.GADGET_ID:
                    gadget = new EntitySolarIsotomaClientGadget(session.getPlayer().getScene(), session.getPlayer(), notify);
                    break;
                default:
                    gadget = new EntityClientGadget(session.getPlayer().getScene(), session.getPlayer(), notify);
                    break;
            }
            session.getPlayer().getScene().onPlayerCreateGadget(gadget);
        }
    }
}
