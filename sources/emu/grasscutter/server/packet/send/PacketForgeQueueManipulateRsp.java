package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForgeQueueManipulateRspOuterClass;
import emu.grasscutter.net.proto.ForgeQueueManipulateTypeOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketForgeQueueManipulateRsp.class */
public class PacketForgeQueueManipulateRsp extends BasePacket {
    public PacketForgeQueueManipulateRsp(RetcodeOuterClass.Retcode retcode, ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType type, List<GameItem> output, List<GameItem> refund, List<GameItem> extra) {
        super(636);
        ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRsp.Builder builder = ForgeQueueManipulateRspOuterClass.ForgeQueueManipulateRsp.newBuilder().setRetcode(retcode.getNumber()).setManipulateType(type);
        for (GameItem item : output) {
            builder.addOutputItemList(ItemParamOuterClass.ItemParam.newBuilder().setItemId(item.getItemId()).setCount(item.getCount()).build());
        }
        for (GameItem item2 : refund) {
            builder.addReturnItemList(ItemParamOuterClass.ItemParam.newBuilder().setItemId(item2.getItemId()).setCount(item2.getCount()).build());
        }
        setData(builder.build());
    }
}
