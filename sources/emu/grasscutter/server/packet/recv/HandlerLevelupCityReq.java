package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.LevelupCityReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.LevelupCityReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerLevelupCityReq.class */
public class HandlerLevelupCityReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        LevelupCityReqOuterClass.LevelupCityReq req = LevelupCityReqOuterClass.LevelupCityReq.parseFrom(payload);
        Grasscutter.getLogger().debug("LevelupCityReq: {} {} {} ", Integer.valueOf(req.getSceneId()), Integer.valueOf(req.getAreaId()), Integer.valueOf(req.getItemNum()));
    }
}
