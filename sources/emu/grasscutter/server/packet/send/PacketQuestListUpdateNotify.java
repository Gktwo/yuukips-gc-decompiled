package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestListUpdateNotifyOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestListUpdateNotify.class */
public class PacketQuestListUpdateNotify extends BasePacket {
    public PacketQuestListUpdateNotify(GameQuest quest) {
        super(PacketOpcodes.QuestListUpdateNotify);
        setData(QuestListUpdateNotifyOuterClass.QuestListUpdateNotify.newBuilder().addQuestList(quest.toProto()).build());
    }

    public PacketQuestListUpdateNotify(List<GameQuest> quests) {
        super(PacketOpcodes.QuestListUpdateNotify);
        QuestListUpdateNotifyOuterClass.QuestListUpdateNotify.Builder proto = QuestListUpdateNotifyOuterClass.QuestListUpdateNotify.newBuilder();
        for (GameQuest quest : quests) {
            proto.addQuestList(quest.toProto());
        }
        proto.build();
        setData(proto);
    }
}
