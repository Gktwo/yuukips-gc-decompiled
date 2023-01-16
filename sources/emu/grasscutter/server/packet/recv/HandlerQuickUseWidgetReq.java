package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.Inventory;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QuickUseWidgetRspOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.QuickUseWidgetReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerQuickUseWidgetReq.class */
public class HandlerQuickUseWidgetReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        QuickUseWidgetRspOuterClass.QuickUseWidgetRsp.Builder proto = QuickUseWidgetRspOuterClass.QuickUseWidgetRsp.newBuilder();
        Player pl = session.getPlayer();
        synchronized (pl) {
            int materialId = pl.getWidgetId();
            Inventory inventory = session.getPlayer().getInventory();
            GameItem item = inventory.getInventoryTab(ItemType.ITEM_MATERIAL).getItemById(materialId);
            if (item == null) {
                Grasscutter.getLogger().warn("HandlerQuickUseWidgetReq: item null");
                return;
            }
            int remain = item.getCount();
            if (remain > 0) {
                if (remain - 1 <= 0) {
                    proto.setRetcode(1);
                } else {
                    proto.setRetcode(0);
                }
                proto.setMaterialId(materialId);
                inventory.removeItem(item, 1);
                BasePacket rsp = new BasePacket(PacketOpcodes.QuickUseWidgetRsp);
                rsp.setData(proto);
                session.send(rsp);
            }
        }
    }
}
