package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.WorldChestOpenNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldChestOpenNotify.class */
public class PacketWorldChestOpenNotify extends BasePacket {
    public PacketWorldChestOpenNotify(int groupId, int sceneId, int configId) {
        super(PacketOpcodes.WorldChestOpenNotify);
        setData(WorldChestOpenNotifyOuterClass.WorldChestOpenNotify.newBuilder().setGroupId(groupId).setSceneId(sceneId).setConfigId(configId).build());
    }
}
