package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.gacha.GachaBanner;
import emu.grasscutter.game.gacha.PlayerGachaBannerInfo;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GachaWishReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGachaWishRsp;

@Opcodes(PacketOpcodes.GachaWishReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGachaWishReq.class */
public class HandlerGachaWishReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        GachaWishReqOuterClass.GachaWishReq req = GachaWishReqOuterClass.GachaWishReq.parseFrom(payload);
        GachaBanner banner = session.getServer().getGachaSystem().getGachaBanners().get(req.getGachaScheduleId());
        if (banner != null) {
            PlayerGachaBannerInfo gachaInfo = session.getPlayer().getGachaInfo().getBannerInfo(banner);
            gachaInfo.setFailedChosenItemPulls(0);
            gachaInfo.setWishItemId(req.getItemId());
            session.send(new PacketGachaWishRsp(req.getGachaType(), req.getGachaScheduleId(), req.getItemId(), 0, banner.getWishMaxProgress()));
        }
    }
}
