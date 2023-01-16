package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameSearchBeatmapRspOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMusicGameSearchBeatmapRsp.class */
public class PacketMusicGameSearchBeatmapRsp extends BasePacket {
    public PacketMusicGameSearchBeatmapRsp(int ret, MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum unknownEnum1) {
        super(PacketOpcodes.MusicGameSearchBeatmapRsp);
        MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRsp.Builder proto = MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRsp.newBuilder();
        proto.setRetcode(ret).setUnknownEnum1(unknownEnum1);
        setData(proto);
    }

    public PacketMusicGameSearchBeatmapRsp(UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo briefInfo, MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum unknownEnum1) {
        super(PacketOpcodes.MusicGameSearchBeatmapRsp);
        MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRsp.Builder proto = MusicGameSearchBeatmapRspOuterClass.MusicGameSearchBeatmapRsp.newBuilder();
        proto.setUnknownEnum1(unknownEnum1);
        setData(proto);
    }
}
