package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DelBackupAvatarTeamRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketRemoveCustomTeamRsp.class */
public class PacketRemoveCustomTeamRsp extends BasePacket {
    public PacketRemoveCustomTeamRsp(RetcodeOuterClass.Retcode retcode, int id) {
        super(1666);
        setData(DelBackupAvatarTeamRspOuterClass.DelBackupAvatarTeamRsp.newBuilder().setRetcode(retcode.getNumber()).setBackupAvatarTeamId(id).build());
    }

    public PacketRemoveCustomTeamRsp(int id) {
        this(RetcodeOuterClass.Retcode.RET_SUCC, id);
    }
}
