package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.game.expedition.ExpeditionRewardDataList;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarExpeditionGetRewardReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAvatarExpeditionGetRewardRsp;
import emu.grasscutter.server.packet.send.PacketItemAddHintNotify;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Opcodes(PacketOpcodes.AvatarExpeditionGetRewardReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerAvatarExpeditionGetRewardReq.class */
public class HandlerAvatarExpeditionGetRewardReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        AvatarExpeditionGetRewardReqOuterClass.AvatarExpeditionGetRewardReq req = AvatarExpeditionGetRewardReqOuterClass.AvatarExpeditionGetRewardReq.parseFrom(payload);
        Player player = session.getPlayer();
        ExpeditionInfo expInfo = player.getExpeditionInfo(req.getAvatarGuid());
        List<GameItem> items = new ArrayList<>();
        List<ExpeditionRewardDataList> expeditionRewardDataLists = session.getServer().getExpeditionSystem().getExpeditionRewardDataList().get(expInfo.getExpId());
        if (expeditionRewardDataLists != null) {
            Stream<R> map = expeditionRewardDataLists.stream().filter(r -> {
                return r.getHourTime() == expInfo.getHourTime();
            }).map((v0) -> {
                return v0.getRewards();
            });
            Objects.requireNonNull(items);
            map.forEach((v1) -> {
                r1.addAll(v1);
            });
        }
        player.getInventory().addItems(items);
        player.sendPacket(new PacketItemAddHintNotify(items, ActionReason.ExpeditionReward));
        player.removeExpeditionInfo(req.getAvatarGuid());
        player.save();
        session.send(new PacketAvatarExpeditionGetRewardRsp(player.getExpeditionInfo(), items));
    }
}
