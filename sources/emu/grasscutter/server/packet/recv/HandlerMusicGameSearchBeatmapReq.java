package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.activity.musicgame.MusicGameBeatmap;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameSearchBeatmapReqOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketMusicGameSearchBeatmapRsp;

@Opcodes(PacketOpcodes.MusicGameSearchBeatmapReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMusicGameSearchBeatmapReq.class */
public class HandlerMusicGameSearchBeatmapReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReq req = MusicGameSearchBeatmapReqOuterClass.MusicGameSearchBeatmapReq.parseFrom(payload);
        MusicGameBeatmap musicGameBeatmap = MusicGameBeatmap.getByShareId(req.getMusicShareId());
        if (musicGameBeatmap == null) {
            session.send(new PacketMusicGameSearchBeatmapRsp((int) RetcodeOuterClass.Retcode.RET_UGC_BRIEF_NOT_FOUND_VALUE, req.getUnknownEnum1()));
        } else {
            session.send(new PacketMusicGameSearchBeatmapRsp(musicGameBeatmap.toBriefProto().build(), req.getUnknownEnum1()));
        }
    }
}
