package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ItemAddHintNotifyOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketItemAddHintNotify.class */
public class PacketItemAddHintNotify extends BasePacket {
    public PacketItemAddHintNotify(GameItem item, ActionReason reason) {
        super(620);
        setData(ItemAddHintNotifyOuterClass.ItemAddHintNotify.newBuilder().addItemList(item.toItemHintProto()).setReason(reason.getValue()).build());
    }

    public PacketItemAddHintNotify(Collection<GameItem> items, ActionReason reason) {
        super(620);
        ItemAddHintNotifyOuterClass.ItemAddHintNotify.Builder proto = ItemAddHintNotifyOuterClass.ItemAddHintNotify.newBuilder().setReason(reason.getValue());
        for (GameItem item : items) {
            proto.addItemList(item.toItemHintProto());
        }
        setData(proto);
    }
}
