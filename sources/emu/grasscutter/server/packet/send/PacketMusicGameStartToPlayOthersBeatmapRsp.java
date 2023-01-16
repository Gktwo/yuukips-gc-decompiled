package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMusicGameStartToPlayOthersBeatmapRsp.class */
public class PacketMusicGameStartToPlayOthersBeatmapRsp extends BasePacket {
    public PacketMusicGameStartToPlayOthersBeatmapRsp(MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum unknownEnum1) {
        super(PacketOpcodes.MusicGameStartToPlayOthersBeatmapRsp);
        MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRsp.Builder proto = MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRsp.newBuilder();
        proto.setUnknownEnum1(unknownEnum1);
        setData(proto);
    }
}
