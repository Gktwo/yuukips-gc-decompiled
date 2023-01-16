package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.game.quest.enums.ParentQuestState;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FinishedParentQuestNotifyOuterClass;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFinishedParentQuestNotify.class */
public class PacketFinishedParentQuestNotify extends BasePacket {
    public PacketFinishedParentQuestNotify(Player player) {
        super((int) PacketOpcodes.FinishedParentQuestNotify, true);
        FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotify.Builder proto = FinishedParentQuestNotifyOuterClass.FinishedParentQuestNotify.newBuilder();
        ObjectIterator<GameMainQuest> it = player.getQuestManager().getMainQuests().values().iterator();
        while (it.hasNext()) {
            GameMainQuest mainQuest = it.next();
            if (mainQuest.getState() != ParentQuestState.PARENT_QUEST_STATE_CANCELED) {
                proto.addParentQuestList(mainQuest.toProto(false));
            }
        }
        setData(proto);
    }
}
