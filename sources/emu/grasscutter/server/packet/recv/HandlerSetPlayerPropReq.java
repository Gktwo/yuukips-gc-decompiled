package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.PropValueOuterClass;
import emu.grasscutter.net.proto.SetPlayerPropReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetPlayerPropRsp;

@Opcodes(199)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetPlayerPropReq.class */
public class HandlerSetPlayerPropReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetPlayerPropReqOuterClass.SetPlayerPropReq req = SetPlayerPropReqOuterClass.SetPlayerPropReq.parseFrom(payload);
        Player player = session.getPlayer();
        for (PropValueOuterClass.PropValue p : req.getPropListList()) {
            PlayerProperty prop = PlayerProperty.getPropById(p.getType());
            if (prop == PlayerProperty.PROP_IS_MP_MODE_AVAILABLE && !player.setProperty(prop, (int) p.getVal(), false)) {
                session.send(new PacketSetPlayerPropRsp(1));
                return;
            }
        }
        player.save();
        session.send(new PacketSetPlayerPropRsp(0));
    }
}
