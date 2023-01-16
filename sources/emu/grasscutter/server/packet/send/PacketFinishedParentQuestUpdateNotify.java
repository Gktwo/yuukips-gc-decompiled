package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.FinishedParentQuestUpdateNotifyOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFinishedParentQuestUpdateNotify.class */
public class PacketFinishedParentQuestUpdateNotify extends BasePacket {
    public PacketFinishedParentQuestUpdateNotify(GameMainQuest quest) {
        super(500);
        setData(FinishedParentQuestUpdateNotifyOuterClass.FinishedParentQuestUpdateNotify.newBuilder().addParentQuestList(quest.toProto(true)).build());
    }

    public PacketFinishedParentQuestUpdateNotify(List<GameMainQuest> quests) {
        super(500);
        FinishedParentQuestUpdateNotifyOuterClass.FinishedParentQuestUpdateNotify.Builder proto = FinishedParentQuestUpdateNotifyOuterClass.FinishedParentQuestUpdateNotify.newBuilder();
        for (GameMainQuest mainQuest : quests) {
            proto.addParentQuestList(mainQuest.toProto(true));
        }
        proto.build();
        setData(proto);
    }
}
