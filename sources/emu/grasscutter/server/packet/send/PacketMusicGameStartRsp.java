package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameStartRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMusicGameStartRsp.class */
public class PacketMusicGameStartRsp extends BasePacket {
    public PacketMusicGameStartRsp(int musicBasicId, long musicShareId) {
        super(PacketOpcodes.MusicGameStartRsp);
        MusicGameStartRspOuterClass.MusicGameStartRsp.Builder proto = MusicGameStartRspOuterClass.MusicGameStartRsp.newBuilder();
        proto.setMusicBasicId(musicBasicId).setUgcGuid(musicShareId);
        setData(proto);
    }
}
