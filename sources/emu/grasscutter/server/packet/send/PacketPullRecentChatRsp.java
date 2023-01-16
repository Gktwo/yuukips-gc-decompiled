package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.net.proto.PullRecentChatRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPullRecentChatRsp.class */
public class PacketPullRecentChatRsp extends BasePacket {
    public PacketPullRecentChatRsp(List<ChatInfoOuterClass.ChatInfo> messages) {
        super(PacketOpcodes.PullRecentChatRsp);
        setData(PullRecentChatRspOuterClass.PullRecentChatRsp.newBuilder().addAllChatInfo(messages));
    }
}
