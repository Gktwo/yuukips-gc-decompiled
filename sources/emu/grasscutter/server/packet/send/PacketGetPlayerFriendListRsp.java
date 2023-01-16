package emu.grasscutter.server.packet.send;

import emu.grasscutter.config.ConfigContainer;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.friends.Friendship;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FriendBriefOuterClass;
import emu.grasscutter.net.proto.FriendOnlineStateOuterClass;
import emu.grasscutter.net.proto.GetPlayerFriendListRspOuterClass;
import emu.grasscutter.net.proto.PlatformTypeOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetPlayerFriendListRsp.class */
public class PacketGetPlayerFriendListRsp extends BasePacket {
    public PacketGetPlayerFriendListRsp(Player player) {
        super(PacketOpcodes.GetPlayerFriendListRsp);
        ConfigContainer.ConsoleAccount serverAccount = Configuration.GAME_INFO.serverAccount;
        GetPlayerFriendListRspOuterClass.GetPlayerFriendListRsp.Builder proto = GetPlayerFriendListRspOuterClass.GetPlayerFriendListRsp.newBuilder().addFriendList(FriendBriefOuterClass.FriendBrief.newBuilder().setUid(99).setNickname(serverAccount.nickName).setLevel(serverAccount.adventureRank).setProfilePicture(ProfilePictureOuterClass.ProfilePicture.newBuilder().setAvatarId(serverAccount.avatarId)).setWorldLevel(serverAccount.worldLevel).setSignature(serverAccount.signature).setLastActiveTime((int) (((float) System.currentTimeMillis()) / 1000.0f)).setNameCardId(serverAccount.nameCardId).setOnlineState(FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_ONLINE).setParam(1).setIsGameSource(true).setPlatformType(PlatformTypeOuterClass.PlatformType.PLATFORM_TYPE_PC).build());
        ObjectIterator<Friendship> it = player.getFriendsList().getFriends().values().iterator();
        while (it.hasNext()) {
            proto.addFriendList(it.next().toProto());
        }
        setData(proto);
    }
}
