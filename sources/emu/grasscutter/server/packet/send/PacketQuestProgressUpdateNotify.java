package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestProgressUpdateNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestProgressUpdateNotify.class */
public class PacketQuestProgressUpdateNotify extends BasePacket {
    public PacketQuestProgressUpdateNotify(GameQuest quest) {
        super(PacketOpcodes.QuestProgressUpdateNotify);
        QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotify.Builder proto = QuestProgressUpdateNotifyOuterClass.QuestProgressUpdateNotify.newBuilder().setQuestId(quest.getSubQuestId());
        if (quest.getFinishProgressList() != null) {
            for (int i : quest.getFinishProgressList()) {
                proto.addFinishProgressList(i);
            }
        }
        if (quest.getFailProgressList() != null) {
            for (int i2 : quest.getFailProgressList()) {
                proto.addFailProgressList(i2);
            }
        }
        setData(proto);
    }
}
