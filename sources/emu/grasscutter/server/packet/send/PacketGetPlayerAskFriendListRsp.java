package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.friends.Friendship;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetPlayerAskFriendListRspOuterClass;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetPlayerAskFriendListRsp.class */
public class PacketGetPlayerAskFriendListRsp extends BasePacket {
    public PacketGetPlayerAskFriendListRsp(Player player) {
        super(PacketOpcodes.GetPlayerAskFriendListRsp);
        GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRsp.Builder proto = GetPlayerAskFriendListRspOuterClass.GetPlayerAskFriendListRsp.newBuilder();
        ObjectIterator<Friendship> it = player.getFriendsList().getPendingFriends().values().iterator();
        while (it.hasNext()) {
            Friendship friendship = it.next();
            if (friendship.getAskerId() != player.getUid()) {
                proto.addAskFriendList(friendship.toProto());
            }
        }
        setData(proto);
    }
}
