package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.PersonalLineData;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UnlockPersonalLineReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketUnlockPersonalLineRsp;

@Opcodes(PacketOpcodes.UnlockPersonalLineReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUnlockPersonalLineReq.class */
public class HandlerUnlockPersonalLineReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PersonalLineData data = GameData.getPersonalLineDataMap().get(UnlockPersonalLineReqOuterClass.UnlockPersonalLineReq.parseFrom(payload).getPersonalLineId());
        if (data != null) {
            session.getPlayer().getQuestManager().addQuest(data.getStartQuestId());
            session.getPlayer().useLegendaryKey(1);
            session.send(new PacketUnlockPersonalLineRsp(data.getId(), 1, data.getChapterId()));
        }
    }
}
