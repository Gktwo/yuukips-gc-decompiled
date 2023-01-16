package emu.grasscutter.game.friends;

import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.DealAddFriendResultTypeOuterClass;
import emu.grasscutter.server.packet.send.PacketAskAddFriendNotify;
import emu.grasscutter.server.packet.send.PacketAskAddFriendRsp;
import emu.grasscutter.server.packet.send.PacketDealAddFriendRsp;
import emu.grasscutter.server.packet.send.PacketDeleteFriendNotify;
import emu.grasscutter.server.packet.send.PacketDeleteFriendRsp;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/friends/FriendsList.class */
public class FriendsList extends BasePlayerManager {
    private boolean loaded = false;
    private final Int2ObjectMap<Friendship> friends = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<Friendship> pendingFriends = new Int2ObjectOpenHashMap();

    public FriendsList(Player player) {
        super(player);
    }

    public boolean hasLoaded() {
        return this.loaded;
    }

    public synchronized Int2ObjectMap<Friendship> getFriends() {
        return this.friends;
    }

    public synchronized Int2ObjectMap<Friendship> getPendingFriends() {
        return this.pendingFriends;
    }

    public synchronized boolean isFriendsWith(int uid) {
        return getFriends().containsKey(uid);
    }

    private synchronized Friendship getFriendshipById(int id) {
        Friendship friendship = getFriends().get(id);
        if (friendship == null) {
            friendship = getPendingFriendById(id);
        }
        return friendship;
    }

    private synchronized Friendship getFriendById(int id) {
        return getFriends().get(id);
    }

    private synchronized Friendship getPendingFriendById(int id) {
        return getPendingFriends().get(id);
    }

    public void addFriend(Friendship friendship) {
        getFriends().put(friendship.getFriendId(), (int) friendship);
    }

    public void addPendingFriend(Friendship friendship) {
        getPendingFriends().put(friendship.getFriendId(), (int) friendship);
    }

    public synchronized void handleFriendRequest(int targetUid, DealAddFriendResultTypeOuterClass.DealAddFriendResultType result) {
        Player target;
        Friendship theirFriendship;
        Friendship myFriendship = getPendingFriendById(targetUid);
        if (myFriendship != null && myFriendship.getAskerId() != getPlayer().getUid() && (target = getPlayer().getSession().getServer().getPlayerByUid(targetUid, true)) != null) {
            if (target.isOnline()) {
                theirFriendship = target.getFriendsList().getPendingFriendById(getPlayer().getUid());
            } else {
                theirFriendship = DatabaseHelper.getReverseFriendship(myFriendship);
            }
            if (theirFriendship == null) {
                getPendingFriends().remove(myFriendship.getOwnerId());
                myFriendship.delete();
                return;
            }
            if (result == DealAddFriendResultTypeOuterClass.DealAddFriendResultType.DEAL_ADD_FRIEND_RESULT_TYPE_ACCEPT) {
                myFriendship.setIsFriend(true);
                theirFriendship.setIsFriend(true);
                getPendingFriends().remove(myFriendship.getOwnerId());
                addFriend(myFriendship);
                if (target.isOnline()) {
                    target.getFriendsList().getPendingFriends().remove(getPlayer().getUid());
                    target.getFriendsList().addFriend(theirFriendship);
                }
                myFriendship.save();
                theirFriendship.save();
            } else {
                getPendingFriends().remove(myFriendship.getOwnerId());
                myFriendship.delete();
                if (target.isOnline()) {
                    theirFriendship = target.getFriendsList().getPendingFriendById(getPlayer().getUid());
                }
                theirFriendship.delete();
            }
            getPlayer().sendPacket(new PacketDealAddFriendRsp(targetUid, result));
        }
    }

    public synchronized void deleteFriend(int targetUid) {
        Friendship myFriendship = getFriendById(targetUid);
        if (myFriendship != null) {
            getFriends().remove(targetUid);
            myFriendship.delete();
            Player friend = myFriendship.getFriendProfile().getPlayer();
            if (friend != null) {
                Friendship theirFriendship = friend.getFriendsList().getFriendById(getPlayer().getUid());
                if (theirFriendship != null) {
                    friend.getFriendsList().getFriends().remove(theirFriendship.getFriendId());
                    theirFriendship.delete();
                    friend.sendPacket(new PacketDeleteFriendNotify(theirFriendship.getFriendId()));
                }
            } else {
                Friendship theirFriendship2 = DatabaseHelper.getReverseFriendship(myFriendship);
                if (theirFriendship2 != null) {
                    theirFriendship2.delete();
                }
            }
            getPlayer().sendPacket(new PacketDeleteFriendRsp(targetUid));
        }
    }

    public synchronized void sendFriendRequest(int targetUid) {
        Player target = getPlayer().getSession().getServer().getPlayerByUid(targetUid, true);
        if (target != null && target != getPlayer() && !getPendingFriends().containsKey(targetUid) && !getFriends().containsKey(targetUid)) {
            Friendship myFriendship = new Friendship(getPlayer(), target, getPlayer());
            Friendship theirFriendship = new Friendship(target, getPlayer(), getPlayer());
            addPendingFriend(myFriendship);
            if (target.isOnline() && target.getFriendsList().hasLoaded()) {
                target.getFriendsList().addPendingFriend(theirFriendship);
                target.sendPacket(new PacketAskAddFriendNotify(theirFriendship));
            }
            myFriendship.save();
            theirFriendship.save();
            getPlayer().sendPacket(new PacketAskAddFriendRsp(targetUid));
        }
    }

    public int getFullFriendCount() {
        return getPendingFriends().size() + getFriends().size();
    }

    public synchronized void loadFromDatabase() {
        if (!hasLoaded()) {
            DatabaseHelper.getFriends(this.player).forEach(this::loadFriendFromDatabase);
            this.loaded = true;
        }
    }

    private void loadFriendFromDatabase(Friendship friendship) {
        friendship.setOwner(getPlayer());
        Player friend = getPlayer().getSession().getServer().getPlayerByUid(friendship.getFriendProfile().getUid());
        if (friend != null) {
            friendship.setFriendProfile(friend);
            if (friend.getFriendsList().hasLoaded()) {
                Friendship theirFriendship = friend.getFriendsList().getFriendshipById(getPlayer().getUid());
                if (theirFriendship != null) {
                    theirFriendship.setFriendProfile(getPlayer());
                } else {
                    friendship.delete();
                    return;
                }
            }
        }
        if (friendship.isFriend()) {
            getFriends().put(friendship.getFriendId(), (int) friendship);
            return;
        }
        getPendingFriends().put(friendship.getFriendId(), (int) friendship);
        if (getPendingFriends().size() == 1) {
            getPlayer().getSession().send(new PacketAskAddFriendNotify(friendship));
        }
    }

    @Override // emu.grasscutter.game.player.BasePlayerManager
    public void save() {
        for (Friendship friend : DatabaseHelper.getReverseFriends(getPlayer())) {
            friend.setFriendProfile(getPlayer());
            friend.save();
        }
    }
}
