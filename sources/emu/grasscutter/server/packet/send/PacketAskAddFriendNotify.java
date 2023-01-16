package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.friends.Friendship;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AskAddFriendNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAskAddFriendNotify.class */
public class PacketAskAddFriendNotify extends BasePacket {
    public PacketAskAddFriendNotify(Friendship friendship) {
        super(PacketOpcodes.AskAddFriendNotify);
        setData(AskAddFriendNotifyOuterClass.AskAddFriendNotify.newBuilder().setTargetUid(friendship.getFriendId()).setTargetFriendBrief(friendship.toProto()).build());
    }
}
