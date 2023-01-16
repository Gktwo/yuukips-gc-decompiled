package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.CodexQuestData;
import emu.grasscutter.game.quest.GameMainQuest;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CodexDataUpdateNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCodexDataUpdateNotify.class */
public class PacketCodexDataUpdateNotify extends BasePacket {
    public PacketCodexDataUpdateNotify(GameMainQuest quest) {
        super((int) PacketOpcodes.CodexDataUpdateNotify, true);
        CodexQuestData codexQuest = GameData.getCodexQuestDataIdMap().get(quest.getParentQuestId());
        if (codexQuest != null) {
            setData(CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotify.newBuilder().setTypeValue(1).setId(codexQuest.getId()).build());
        }
    }

    public PacketCodexDataUpdateNotify(int typeValue, int codexId) {
        super((int) PacketOpcodes.CodexDataUpdateNotify, true);
        setData(CodexDataUpdateNotifyOuterClass.CodexDataUpdateNotify.newBuilder().setTypeValue(typeValue).setId(codexId).build());
    }
}
