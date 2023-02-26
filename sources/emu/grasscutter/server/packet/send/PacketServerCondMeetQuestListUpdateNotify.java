package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ServerCondMeetQuestListUpdateNotifyOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketServerCondMeetQuestListUpdateNotify.class */
public class PacketServerCondMeetQuestListUpdateNotify extends BasePacket {
    public PacketServerCondMeetQuestListUpdateNotify(Player player) {
        super(PacketOpcodes.ServerCondMeetQuestListUpdateNotify);
        setData(ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotify.newBuilder());
    }

    public PacketServerCondMeetQuestListUpdateNotify(List<GameQuest> quests) {
        super(PacketOpcodes.ServerCondMeetQuestListUpdateNotify);
        ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotify.Builder proto = ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotify.newBuilder();
        for (GameQuest quest : quests) {
            proto.addAddQuestIdList(quest.getSubQuestId());
        }
        proto.build();
        setData(proto);
    }

    public PacketServerCondMeetQuestListUpdateNotify() {
        super(PacketOpcodes.ServerCondMeetQuestListUpdateNotify);
        ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotify.Builder proto = ServerCondMeetQuestListUpdateNotifyOuterClass.ServerCondMeetQuestListUpdateNotify.newBuilder();
        proto.build();
        setData(proto);
    }
}
