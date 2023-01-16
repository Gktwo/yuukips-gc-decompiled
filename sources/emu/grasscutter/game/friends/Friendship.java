package emu.grasscutter.game.friends;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Transient;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.FriendBriefOuterClass;
import emu.grasscutter.net.proto.FriendOnlineStateOuterClass;
import emu.grasscutter.net.proto.PlatformTypeOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import org.bson.types.ObjectId;

@Entity(value = "friendships", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/friends/Friendship.class */
public class Friendship {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f572id;
    @Transient
    private Player owner;
    @Indexed
    private int ownerId;
    @Indexed
    private int friendId;
    private boolean isFriend;
    private int askerId;
    private PlayerProfile profile;

    @Deprecated(forRemoval = true)
    public Friendship() {
    }

    public Friendship(Player owner, Player friend, Player asker) {
        setOwner(owner);
        this.ownerId = owner.getUid();
        this.friendId = friend.getUid();
        this.profile = friend.getProfile();
        this.askerId = asker.getUid();
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public void setIsFriend(boolean b) {
        this.isFriend = b;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public int getFriendId() {
        return this.friendId;
    }

    public int getAskerId() {
        return this.askerId;
    }

    public void setAskerId(int askerId) {
        this.askerId = askerId;
    }

    public PlayerProfile getFriendProfile() {
        return this.profile;
    }

    public void setFriendProfile(Player character) {
        if (character != null && this.friendId == character.getUid()) {
            this.profile = character.getProfile();
        }
    }

    public boolean isOnline() {
        return getFriendProfile().getPlayer() != null;
    }

    public void save() {
        DatabaseHelper.saveFriendship(this);
    }

    public void delete() {
        DatabaseHelper.deleteFriendship(this);
    }

    public FriendBriefOuterClass.FriendBrief toProto() {
        FriendOnlineStateOuterClass.FriendOnlineState friendOnlineState;
        FriendBriefOuterClass.FriendBrief.Builder signature = FriendBriefOuterClass.FriendBrief.newBuilder().setUid(getFriendProfile().getUid()).setNickname(getFriendProfile().getName()).setLevel(getFriendProfile().getPlayerLevel()).setProfilePicture(ProfilePictureOuterClass.ProfilePicture.newBuilder().setAvatarId(getFriendProfile().getAvatarId())).setWorldLevel(getFriendProfile().getWorldLevel()).setSignature(getFriendProfile().getSignature());
        if (getFriendProfile().isOnline()) {
            friendOnlineState = FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_ONLINE;
        } else {
            friendOnlineState = FriendOnlineStateOuterClass.FriendOnlineState.FRIEND_ONLINE_STATE_DISCONNECT;
        }
        return signature.setOnlineState(friendOnlineState).setIsMpModeAvailable(true).setLastActiveTime(getFriendProfile().getLastActiveTime()).setNameCardId(getFriendProfile().getNameCard()).setParam(getFriendProfile().getDaysSinceLogin()).setIsGameSource(true).setPlatformType(PlatformTypeOuterClass.PlatformType.PLATFORM_TYPE_PC).build();
    }
}
