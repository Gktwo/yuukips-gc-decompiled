package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GadgetInteractRspOuterClass;
import emu.grasscutter.net.proto.InterOpTypeOuterClass;
import emu.grasscutter.net.proto.InteractTypeOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGadgetInteractRsp.class */
public class PacketGadgetInteractRsp extends BasePacket {
    public PacketGadgetInteractRsp(EntityBaseGadget gadget, InteractTypeOuterClass.InteractType interact) {
        this(gadget, interact, null);
    }

    public PacketGadgetInteractRsp(EntityBaseGadget gadget, InteractTypeOuterClass.InteractType interact, InterOpTypeOuterClass.InterOpType opType) {
        super(PacketOpcodes.GadgetInteractRsp);
        GadgetInteractRspOuterClass.GadgetInteractRsp.Builder proto = GadgetInteractRspOuterClass.GadgetInteractRsp.newBuilder().setGadgetEntityId(gadget.getId()).setInteractType(interact).setGadgetId(gadget.getGadgetId());
        if (opType != null) {
            proto.setOpType(opType);
        }
        setData(proto.build());
    }

    public PacketGadgetInteractRsp() {
        super(PacketOpcodes.GadgetInteractRsp);
        setData(GadgetInteractRspOuterClass.GadgetInteractRsp.newBuilder().setRetcode(1).build());
    }
}
