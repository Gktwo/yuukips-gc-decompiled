package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AddBackupAvatarTeamRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAddCustomTeamRsp.class */
public class PacketAddCustomTeamRsp extends BasePacket {
    public PacketAddCustomTeamRsp(RetcodeOuterClass.Retcode retcode) {
        super(PacketOpcodes.AddBackupAvatarTeamRsp);
        setData(AddBackupAvatarTeamRspOuterClass.AddBackupAvatarTeamRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }

    public PacketAddCustomTeamRsp() {
        this(RetcodeOuterClass.Retcode.RET_SUCC);
    }
}
