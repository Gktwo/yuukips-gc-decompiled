package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketMusicGameStartToPlayOthersBeatmapRsp;

@Opcodes(6302)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMusicGameStartToPlayOthersBeatmapReq.class */
public class HandlerMusicGameStartToPlayOthersBeatmapReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketMusicGameStartToPlayOthersBeatmapRsp(MusicGameStartToPlayOthersBeatmapReqOuterClass.MusicGameStartToPlayOthersBeatmapReq.parseFrom(payload).getUnknownEnum1()));
    }
}
