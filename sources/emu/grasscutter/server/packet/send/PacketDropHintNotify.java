package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DropHintNotifyOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDropHintNotify.class */
public class PacketDropHintNotify extends BasePacket {
    public PacketDropHintNotify(int itemId, VectorOuterClass.Vector position) {
        super(642);
        setData(DropHintNotifyOuterClass.DropHintNotify.newBuilder().addItemIdList(itemId).setPosition(position).build());
    }

    public PacketDropHintNotify(Iterable<GameItem> items, VectorOuterClass.Vector position) {
        super(642);
        DropHintNotifyOuterClass.DropHintNotify.Builder proto = DropHintNotifyOuterClass.DropHintNotify.newBuilder();
        items.forEach(i -> {
            proto.addItemIdList(i.getItemId());
        });
        proto.setPosition(position);
        setData(proto.build());
    }
}
