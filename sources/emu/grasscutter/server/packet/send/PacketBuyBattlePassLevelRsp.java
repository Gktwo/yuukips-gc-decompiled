package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BuyBattlePassLevelRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBuyBattlePassLevelRsp.class */
public class PacketBuyBattlePassLevelRsp extends BasePacket {
    public PacketBuyBattlePassLevelRsp(int buyLevel) {
        super(PacketOpcodes.BuyBattlePassLevelRsp);
        setData(BuyBattlePassLevelRspOuterClass.BuyBattlePassLevelRsp.newBuilder().setBuyLevel(buyLevel).build());
    }
}
