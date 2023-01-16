package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameCreateBeatmapRspOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMusicGameCreateBeatmapRsp.class */
public class PacketMusicGameCreateBeatmapRsp extends BasePacket {
    public PacketMusicGameCreateBeatmapRsp(long musicShareId, MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum unknownEnum1) {
        super(PacketOpcodes.MusicGameCreateBeatmapRsp);
        MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRsp.Builder proto = MusicGameCreateBeatmapRspOuterClass.MusicGameCreateBeatmapRsp.newBuilder();
        proto.setMusicShareId(musicShareId).setUnknownEnum1(unknownEnum1);
        setData(proto);
    }
}
