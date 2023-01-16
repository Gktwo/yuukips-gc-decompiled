package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.gadget.GadgetContent;
import emu.grasscutter.game.entity.gadget.GadgetWorktop;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.WorktopOptionNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorktopOptionNotify.class */
public class PacketWorktopOptionNotify extends BasePacket {
    public PacketWorktopOptionNotify(EntityGadget gadget) {
        super(819);
        WorktopOptionNotifyOuterClass.WorktopOptionNotify.Builder proto = WorktopOptionNotifyOuterClass.WorktopOptionNotify.newBuilder().setGadgetEntityId(gadget.getId());
        GadgetContent content = gadget.getContent();
        if (content instanceof GadgetWorktop) {
            proto.addAllOptionList(((GadgetWorktop) content).getWorktopOptions());
        }
        setData(proto);
    }
}
