package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMcoinExchangeHcoinRsp.class */
public class PacketMcoinExchangeHcoinRsp extends BasePacket {
    public PacketMcoinExchangeHcoinRsp(int retCode) {
        super(667);
        setData(McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRsp.newBuilder().setRetcode(retCode).build());
    }
}
