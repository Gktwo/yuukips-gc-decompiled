package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.GadgetAutoPickDropInfoNotifyOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGadgetAutoPickDropInfoNotify.class */
public class PacketGadgetAutoPickDropInfoNotify extends BasePacket {
    public PacketGadgetAutoPickDropInfoNotify(Collection<GameItem> items) {
        super(899);
        GadgetAutoPickDropInfoNotifyOuterClass.GadgetAutoPickDropInfoNotify.Builder proto = GadgetAutoPickDropInfoNotifyOuterClass.GadgetAutoPickDropInfoNotify.newBuilder();
        items.forEach(item -> {
            proto.addItemList(item.toProto());
        });
        setData(proto);
    }
}
