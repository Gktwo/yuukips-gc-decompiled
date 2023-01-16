package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuestListNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQuestListNotify.class */
public class PacketQuestListNotify extends BasePacket {
    public PacketQuestListNotify(Player player) {
        super((int) PacketOpcodes.QuestListNotify, true);
        QuestListNotifyOuterClass.QuestListNotify.Builder proto = QuestListNotifyOuterClass.QuestListNotify.newBuilder();
        player.getQuestManager().forEachQuest(quest -> {
            if (quest.getState() != QuestState.QUEST_STATE_UNSTARTED) {
                proto.addQuestList(quest.toProto());
            }
        });
        setData(proto);
    }
}
