package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameSettleRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMusicGameSettleRsp.class */
public class PacketMusicGameSettleRsp extends BasePacket {
    public PacketMusicGameSettleRsp(int musicBasicId, long musicShareId, boolean isNewRecord) {
        super(PacketOpcodes.MusicGameSettleRsp);
        MusicGameSettleRspOuterClass.MusicGameSettleRsp.Builder proto = MusicGameSettleRspOuterClass.MusicGameSettleRsp.newBuilder();
        proto.setMusicBasicId(musicBasicId).setUgcGuid(musicShareId).setIsNewRecord(isNewRecord);
        setData(proto);
    }
}
