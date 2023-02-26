package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ClientLoadingCostumeVerificationNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.ClientLoadingCostumeVerificationNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerClientLoadingCostumeVerificationNotify.class */
public class HandlerClientLoadingCostumeVerificationNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotify req = ClientLoadingCostumeVerificationNotifyOuterClass.ClientLoadingCostumeVerificationNotify.parseFrom(payload);
        Grasscutter.getLogger().debug("ClientLoadingCostumeVerificationNotify: {} {} {}", Integer.valueOf(req.getCostumeId()), Long.valueOf(req.getGuid()), Long.valueOf(req.getPrefabHash()));
    }
}
