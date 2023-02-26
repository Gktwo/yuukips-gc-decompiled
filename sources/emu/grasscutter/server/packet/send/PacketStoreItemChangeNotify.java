package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.StoreItemChangeNotifyOuterClass;
import emu.grasscutter.net.proto.StoreTypeOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketStoreItemChangeNotify.class */
public class PacketStoreItemChangeNotify extends BasePacket {
    private PacketStoreItemChangeNotify() {
        super(687);
    }

    public PacketStoreItemChangeNotify(GameItem item) {
        this();
        setData(StoreItemChangeNotifyOuterClass.StoreItemChangeNotify.newBuilder().setStoreType(StoreTypeOuterClass.StoreType.STORE_TYPE_PACK).addItemList(item.toProto()));
    }

    public PacketStoreItemChangeNotify(Collection<GameItem> items) {
        this();
        StoreItemChangeNotifyOuterClass.StoreItemChangeNotify.Builder proto = StoreItemChangeNotifyOuterClass.StoreItemChangeNotify.newBuilder().setStoreType(StoreTypeOuterClass.StoreType.STORE_TYPE_PACK);
        items.forEach(item -> {
            proto.addItemList(item.toProto());
        });
        setData(proto);
    }
}
