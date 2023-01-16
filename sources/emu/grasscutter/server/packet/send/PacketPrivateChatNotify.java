package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.net.proto.PrivateChatNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPrivateChatNotify.class */
public class PacketPrivateChatNotify extends BasePacket {
    private ChatInfoOuterClass.ChatInfo info;

    public PacketPrivateChatNotify(int senderId, int recvId, String message) {
        super(PacketOpcodes.PrivateChatNotify);
        ChatInfoOuterClass.ChatInfo info = ChatInfoOuterClass.ChatInfo.newBuilder().setTime((int) (System.currentTimeMillis() / 1000)).setUid(senderId).setToUid(recvId).setText(message).build();
        this.info = info;
        setData(PrivateChatNotifyOuterClass.PrivateChatNotify.newBuilder().setChatInfo(info).build());
    }

    public PacketPrivateChatNotify(int senderId, int recvId, int emote) {
        super(PacketOpcodes.PrivateChatNotify);
        ChatInfoOuterClass.ChatInfo info = ChatInfoOuterClass.ChatInfo.newBuilder().setTime((int) (System.currentTimeMillis() / 1000)).setUid(senderId).setToUid(recvId).setIcon(emote).build();
        this.info = info;
        setData(PrivateChatNotifyOuterClass.PrivateChatNotify.newBuilder().setChatInfo(info).build());
    }

    public ChatInfoOuterClass.ChatInfo getChatInfo() {
        return this.info;
    }
}
