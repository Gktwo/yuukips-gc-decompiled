package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetDailyDungeonEntryInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetDailyDungeonEntryInfoRsp;

@Opcodes(PacketOpcodes.GetDailyDungeonEntryInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetDailyDungeonEntryInfoReq.class */
public class HandlerGetDailyDungeonEntryInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetDailyDungeonEntryInfoRsp(Integer.valueOf(GetDailyDungeonEntryInfoReqOuterClass.GetDailyDungeonEntryInfoReq.parseFrom(payload).getSceneId())));
    }
}
