package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.WorldAreaData;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarChangeElementTypeReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarChangeElementTypeRsp;

@Opcodes(PacketOpcodes.AvatarChangeElementTypeReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarChangeElementTypeReq.class */
public class HandlerAvatarChangeElementTypeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        WorldAreaData area = GameData.getWorldAreaDataMap().get(AvatarChangeElementTypeReqOuterClass.AvatarChangeElementTypeReq.parseFrom(payload).getAreaId());
        if (area == null || area.getElementType() == null || area.getElementType().getDepotIndex() <= 0) {
            session.send(new PacketAvatarChangeElementTypeRsp(1));
        } else if (!session.getPlayer().getTeamManager().getCurrentAvatarEntity().getAvatar().changeElement(area.getElementType())) {
            session.send(new PacketAvatarChangeElementTypeRsp(1));
        } else {
            session.send(new PacketAvatarChangeElementTypeRsp());
        }
    }
}
