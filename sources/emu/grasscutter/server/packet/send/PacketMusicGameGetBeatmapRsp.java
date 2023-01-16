package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicBeatmapOuterClass;
import emu.grasscutter.net.proto.MusicGameGetBeatmapReqOuterClass;
import emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass;
import emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMusicGameGetBeatmapRsp.class */
public class PacketMusicGameGetBeatmapRsp extends BasePacket {
    public PacketMusicGameGetBeatmapRsp(UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo briefInfo, MusicBeatmapOuterClass.MusicBeatmap musicRecord, MusicGameGetBeatmapReqOuterClass.MusicGameGetBeatmapReq req) {
        super(PacketOpcodes.MusicGameGetBeatmapRsp);
        MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRsp.Builder proto = MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRsp.newBuilder();
        proto.setMusicShareId(briefInfo.getUgcGuid()).setMusicRecord(musicRecord).setUnknownEnum1(req.getUnknownEnum1()).setReqType(req.getReqType());
        setData(proto);
    }
}
