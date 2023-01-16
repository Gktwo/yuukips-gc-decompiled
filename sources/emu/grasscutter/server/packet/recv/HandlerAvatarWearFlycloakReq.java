package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarWearFlycloakReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarWearFlycloakRsp;

@Opcodes(PacketOpcodes.AvatarWearFlycloakReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarWearFlycloakReq.class */
public class HandlerAvatarWearFlycloakReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarWearFlycloakReqOuterClass.AvatarWearFlycloakReq req = AvatarWearFlycloakReqOuterClass.AvatarWearFlycloakReq.parseFrom(payload);
        if (session.getPlayer().getAvatars().wearFlycloak(req.getAvatarGuid(), req.getFlycloakId())) {
            session.getPlayer().sendPacket(new PacketAvatarWearFlycloakRsp(req.getAvatarGuid(), req.getFlycloakId()));
        } else {
            session.getPlayer().sendPacket(new PacketAvatarWearFlycloakRsp());
        }
    }
}
