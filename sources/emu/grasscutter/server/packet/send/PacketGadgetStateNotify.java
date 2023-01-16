package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GadgetStateNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGadgetStateNotify.class */
public class PacketGadgetStateNotify extends BasePacket {
    public PacketGadgetStateNotify(EntityGadget gadget, int newState) {
        super(PacketOpcodes.GadgetStateNotify);
        setData(GadgetStateNotifyOuterClass.GadgetStateNotify.newBuilder().setGadgetEntityId(gadget.getId()).setGadgetState(newState).setIsEnableInteract(true).build());
    }
}
