package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UpdatePlayerShowNameCardListRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUpdatePlayerShowNameCardListRsp.class */
public class PacketUpdatePlayerShowNameCardListRsp extends BasePacket {
    public PacketUpdatePlayerShowNameCardListRsp(List<Integer> cardIds) {
        super(PacketOpcodes.UpdatePlayerShowNameCardListRsp);
        setData(UpdatePlayerShowNameCardListRspOuterClass.UpdatePlayerShowNameCardListRsp.newBuilder().addAllShowNameCardIdList(cardIds).setRetcode(0).build());
    }
}
