package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.net.proto.PullPrivateChatRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPullPrivateChatRsp.class */
public class PacketPullPrivateChatRsp extends BasePacket {
    public PacketPullPrivateChatRsp(List<ChatInfoOuterClass.ChatInfo> history) {
        super(PacketOpcodes.PullPrivateChatRsp);
        PullPrivateChatRspOuterClass.PullPrivateChatRsp.Builder builder = PullPrivateChatRspOuterClass.PullPrivateChatRsp.newBuilder();
        if (history == null) {
            builder.setRetcode(-1);
        } else {
            for (ChatInfoOuterClass.ChatInfo info : history) {
                builder.addChatInfo(info);
            }
        }
        setData(builder.build());
    }
}
