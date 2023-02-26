package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.StoreItemDelNotifyOuterClass;
import emu.grasscutter.net.proto.StoreTypeOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketStoreItemDelNotify.class */
public class PacketStoreItemDelNotify extends BasePacket {
    private PacketStoreItemDelNotify() {
        super(698);
    }

    public PacketStoreItemDelNotify(GameItem item) {
        this();
        setData(StoreItemDelNotifyOuterClass.StoreItemDelNotify.newBuilder().setStoreType(StoreTypeOuterClass.StoreType.STORE_TYPE_PACK).addGuidList(item.getGuid()));
    }

    public PacketStoreItemDelNotify(Collection<GameItem> items) {
        this();
        StoreItemDelNotifyOuterClass.StoreItemDelNotify.Builder proto = StoreItemDelNotifyOuterClass.StoreItemDelNotify.newBuilder().setStoreType(StoreTypeOuterClass.StoreType.STORE_TYPE_PACK);
        items.stream().forEach(item -> {
            proto.addGuidList(item.getGuid());
        });
        setData(proto);
    }
}
