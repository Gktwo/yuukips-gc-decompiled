package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestDelNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDelQuestNotify.class */
public class PacketDelQuestNotify extends BasePacket {
    public PacketDelQuestNotify(int questId) {
        super(PacketOpcodes.QuestDelNotify);
        setData(QuestDelNotifyOuterClass.QuestDelNotify.newBuilder().setQuestId(questId).build());
    }
}
