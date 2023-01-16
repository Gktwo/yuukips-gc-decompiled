package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.UseItemRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUseItemRsp.class */
public class PacketUseItemRsp extends BasePacket {
    public PacketUseItemRsp(long targetGuid, GameItem useItem) {
        super(678);
        setData(UseItemRspOuterClass.UseItemRsp.newBuilder().setTargetGuid(targetGuid).setItemId(useItem.getItemId()).setGuid(useItem.getGuid()).build());
    }

    public PacketUseItemRsp() {
        super(678);
        setData(UseItemRspOuterClass.UseItemRsp.newBuilder().setRetcode(1).build());
    }
}
