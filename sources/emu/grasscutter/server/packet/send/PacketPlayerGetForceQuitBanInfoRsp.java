package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerGetForceQuitBanInfoRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerGetForceQuitBanInfoRsp.class */
public class PacketPlayerGetForceQuitBanInfoRsp extends BasePacket {
    public PacketPlayerGetForceQuitBanInfoRsp(int retcode) {
        super(PacketOpcodes.PlayerGetForceQuitBanInfoRsp);
        setData(PlayerGetForceQuitBanInfoRspOuterClass.PlayerGetForceQuitBanInfoRsp.newBuilder().setRetcode(retcode).build());
    }
}
