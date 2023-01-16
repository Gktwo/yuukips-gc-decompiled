package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsReqOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketCalcWeaponUpgradeReturnItemsRsp;
import java.util.List;

@Opcodes(666)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerCalcWeaponUpgradeReturnItemsReq.class */
public class HandlerCalcWeaponUpgradeReturnItemsReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        CalcWeaponUpgradeReturnItemsReqOuterClass.CalcWeaponUpgradeReturnItemsReq req = CalcWeaponUpgradeReturnItemsReqOuterClass.CalcWeaponUpgradeReturnItemsReq.parseFrom(payload);
        List<ItemParamOuterClass.ItemParam> returnOres = session.getServer().getInventorySystem().calcWeaponUpgradeReturnItems(session.getPlayer(), req.getTargetWeaponGuid(), req.getFoodWeaponGuidListList(), req.getItemParamListList());
        if (returnOres != null) {
            session.send(new PacketCalcWeaponUpgradeReturnItemsRsp(req.getTargetWeaponGuid(), returnOres));
        } else {
            session.send(new PacketCalcWeaponUpgradeReturnItemsRsp());
        }
    }
}
