package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UnlockAvatarTalentReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.UnlockAvatarTalentReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUnlockAvatarTalentReq.class */
public class HandlerUnlockAvatarTalentReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReq req = UnlockAvatarTalentReqOuterClass.UnlockAvatarTalentReq.parseFrom(payload);
        Avatar avatar = session.getPlayer().getAvatars().getAvatarByGuid(req.getAvatarGuid());
        if (avatar != null) {
            avatar.unlockConstellation(req.getTalentId());
        }
    }
}
