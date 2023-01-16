package emu.grasscutter.server.packet.recv;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.game.combine.CombineResult;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.CombineReqOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketCombineRsp;
import java.util.List;
import java.util.stream.Collectors;

@Opcodes(675)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerCombineReq.class */
public class HandlerCombineReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        CombineReqOuterClass.CombineReq req = CombineReqOuterClass.CombineReq.parseFrom(payload);
        CombineResult result = session.getServer().getCombineSystem().combineItem(session.getPlayer(), req.getCombineId(), req.getCombineCount());
        if (result != null) {
            session.send(new PacketCombineRsp(req, toItemParamList(result.getMaterial()), toItemParamList(result.getResult()), toItemParamList(result.getExtra()), toItemParamList(result.getBack()), toItemParamList(result.getBack())));
        }
    }

    private List<ItemParamOuterClass.ItemParam> toItemParamList(List<ItemParamData> list) {
        return (List) list.stream().map(item -> {
            return ItemParamOuterClass.ItemParam.newBuilder().setItemId(item.getId()).setCount(item.getCount()).build();
        }).collect(Collectors.toList());
    }
}
