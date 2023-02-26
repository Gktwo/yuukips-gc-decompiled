package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockPersonalLineRsp.class */
public class PacketUnlockPersonalLineRsp extends BasePacket {
    public PacketUnlockPersonalLineRsp(int id, int level, int chapterId) {
        super(403);
        UnlockPersonalLineRspOuterClass.UnlockPersonalLineRsp.Builder proto = UnlockPersonalLineRspOuterClass.UnlockPersonalLineRsp.newBuilder();
        proto.setPersonalLineId(id).setLevel(level).setChapterId(chapterId);
        setData(proto);
    }
}
