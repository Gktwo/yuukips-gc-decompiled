package emu.grasscutter.server.packet.send;

import emu.grasscutter.config.Configuration;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.StoreTypeOuterClass;
import emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketStoreWeightLimitNotify.class */
public class PacketStoreWeightLimitNotify extends BasePacket {
    public PacketStoreWeightLimitNotify() {
        super(630);
        setData(StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotify.newBuilder().setStoreType(StoreTypeOuterClass.StoreType.STORE_TYPE_PACK).setWeightLimit(Configuration.INVENTORY_LIMITS.all).setWeaponCountLimit(Configuration.INVENTORY_LIMITS.weapons).setReliquaryCountLimit(Configuration.INVENTORY_LIMITS.relics).setMaterialCountLimit(Configuration.INVENTORY_LIMITS.materials).setFurnitureCountLimit(Configuration.INVENTORY_LIMITS.furniture).build());
    }
}
