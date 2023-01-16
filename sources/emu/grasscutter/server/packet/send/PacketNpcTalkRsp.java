package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.NpcTalkRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketNpcTalkRsp.class */
public class PacketNpcTalkRsp extends BasePacket {
    public PacketNpcTalkRsp(int npcEntityId, int curTalkId, int entityId) {
        super(530);
        setData(NpcTalkRspOuterClass.NpcTalkRsp.newBuilder().setNpcEntityId(npcEntityId).setCurTalkId(curTalkId).setEntityId(entityId).build());
    }
}
